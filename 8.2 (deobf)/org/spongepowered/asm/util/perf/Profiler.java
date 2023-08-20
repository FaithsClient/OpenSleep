package org.spongepowered.asm.util.perf;

import com.google.common.base.Joiner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.spongepowered.asm.util.PrettyPrinter;

public final class Profiler {
   public static final int ROOT = 1;
   public static final int FINE = 2;
   private final Map sections = new TreeMap();
   private final List phases = new ArrayList();
   private final Deque stack = new LinkedList();
   private boolean active;

   public Profiler() {
      this.phases.add("Initial");
   }

   public void setActive(boolean active) {
      if (!this.active && active || !active) {
         this.reset();
      }

      this.active = active;
   }

   public void reset() {
      for(Profiler.Section section : this.sections.values()) {
         section.invalidate();
      }

      this.sections.clear();
      this.phases.clear();
      this.phases.add("Initial");
      this.stack.clear();
   }

   public Profiler.Section get(String name) {
      Profiler.Section section = (Profiler.Section)this.sections.get(name);
      if (section == null) {
         section = (Profiler.Section)(this.active ? new Profiler.LiveSection(name, this.phases.size() - 1) : new Profiler.Section(name));
         this.sections.put(name, section);
      }

      return section;
   }

   private Profiler.Section getSubSection(String name, String baseName, Profiler.Section root) {
      Profiler.Section section = (Profiler.Section)this.sections.get(name);
      if (section == null) {
         section = new Profiler.SubSection(name, this.phases.size() - 1, baseName, root);
         this.sections.put(name, section);
      }

      return section;
   }

   boolean isHead(Profiler.Section section) {
      return this.stack.peek() == section;
   }

   public Profiler.Section begin(String... path) {
      return this.begin(0, path);
   }

   public Profiler.Section begin(int flags, String... path) {
      return this.begin(flags, Joiner.on('.').join(path));
   }

   public Profiler.Section begin(String name) {
      return this.begin(0, name);
   }

   public Profiler.Section begin(int flags, String name) {
      boolean root = (flags & 1) != 0;
      boolean fine = (flags & 2) != 0;
      String path = name;
      Profiler.Section head = (Profiler.Section)this.stack.peek();
      if (head != null) {
         path = head.getName() + (root ? " -> " : ".") + name;
         if (head.isRoot() && !root) {
            int pos = head.getName().lastIndexOf(" -> ");
            name = (pos > -1 ? head.getName().substring(pos + 4) : head.getName()) + "." + name;
            root = true;
         }
      }

      Profiler.Section section = this.get(root ? name : path);
      if (root && head != null && this.active) {
         section = this.getSubSection(path, head.getName(), section);
      }

      section.setFine(fine).setRoot(root);
      this.stack.push(section);
      return section.start();
   }

   void end(Profiler.Section section) {
      try {
         Profiler.Section head = (Profiler.Section)this.stack.pop();

         for(Profiler.Section next = head; next != section; next = (Profiler.Section)this.stack.pop()) {
            if (next == null && this.active) {
               if (head == null) {
                  throw new IllegalStateException("Attempted to pop " + section + " but the stack is empty");
               }

               throw new IllegalStateException("Attempted to pop " + section + " which was not in the stack, head was " + head);
            }
         }
      } catch (NoSuchElementException var4) {
         if (this.active) {
            throw new IllegalStateException("Attempted to pop " + section + " but the stack is empty");
         }
      }

   }

   public void mark(String phase) {
      long currentPhaseTime = 0L;

      for(Profiler.Section section : this.sections.values()) {
         currentPhaseTime += section.getTime();
      }

      if (currentPhaseTime == 0L) {
         int size = this.phases.size();
         this.phases.set(size - 1, phase);
      } else {
         this.phases.add(phase);

         for(Profiler.Section section : this.sections.values()) {
            section.mark();
         }

      }
   }

   public Collection getSections() {
      return Collections.unmodifiableCollection(this.sections.values());
   }

   public PrettyPrinter printer(boolean includeFine, boolean group) {
      PrettyPrinter printer = new PrettyPrinter();
      int colCount = this.phases.size() + 4;
      int[] columns = new int[]{0, 1, 2, colCount - 2, colCount - 1};
      Object[] headers = new Object[colCount * 2];
      int col = 0;

      for(int pos = 0; col < colCount; pos = col * 2) {
         headers[pos + 1] = PrettyPrinter.Alignment.RIGHT;
         if (col == columns[0]) {
            headers[pos] = (group ? "" : "  ") + "Section";
            headers[pos + 1] = PrettyPrinter.Alignment.LEFT;
         } else if (col == columns[1]) {
            headers[pos] = "    TOTAL";
         } else if (col == columns[3]) {
            headers[pos] = "    Count";
         } else if (col == columns[4]) {
            headers[pos] = "Avg. ";
         } else if (col - columns[2] < this.phases.size()) {
            headers[pos] = this.phases.get(col - columns[2]);
         } else {
            headers[pos] = "";
         }

         ++col;
      }

      printer.table(headers).th().hr().add();

      for(Profiler.Section section : this.sections.values()) {
         if ((!section.isFine() || includeFine) && (!group || section.getDelegate() == section)) {
            this.printSectionRow(printer, colCount, columns, section, group);
            if (group) {
               for(Profiler.Section subSection : this.sections.values()) {
                  Profiler.Section delegate = subSection.getDelegate();
                  if ((!subSection.isFine() || includeFine) && delegate == section && delegate != subSection) {
                     this.printSectionRow(printer, colCount, columns, subSection, group);
                  }
               }
            }
         }
      }

      return printer.add();
   }

   private void printSectionRow(PrettyPrinter printer, int colCount, int[] columns, Profiler.Section section, boolean group) {
      boolean isDelegate = section.getDelegate() != section;
      Object[] values = new Object[colCount];
      int col = 1;
      if (group) {
         values[0] = isDelegate ? "  > " + section.getBaseName() : section.getName();
      } else {
         values[0] = (isDelegate ? "+ " : "  ") + section.getName();
      }

      long[] times = section.getTimes();

      for(long time : times) {
         if (col == columns[1]) {
            values[col++] = section.getTotalTime() + " ms";
         }

         if (col >= columns[2] && col < values.length) {
            values[col++] = time + " ms";
         }
      }

      values[columns[3]] = section.getTotalCount();
      values[columns[4]] = (new DecimalFormat("   ###0.000 ms")).format(section.getTotalAverageTime());

      for(int i = 0; i < values.length; ++i) {
         if (values[i] == null) {
            values[i] = "-";
         }
      }

      printer.tr(values);
   }

   class LiveSection extends Profiler.Section {
      private int cursor = 0;
      private long[] times = new long[0];
      private long start = 0L;
      private long time;
      private long markedTime;
      private int count;
      private int markedCount;

      LiveSection(String name, int cursor) {
         super(name);
         this.cursor = cursor;
      }

      Profiler.Section start() {
         this.start = System.currentTimeMillis();
         return this;
      }

      protected Profiler.Section stop() {
         if (this.start > 0L) {
            this.time += System.currentTimeMillis() - this.start;
         }

         this.start = 0L;
         ++this.count;
         return this;
      }

      public Profiler.Section end() {
         this.stop();
         if (!this.invalidated) {
            Profiler.this.end(this);
         }

         return this;
      }

      void mark() {
         if (this.cursor >= this.times.length) {
            this.times = Arrays.copyOf(this.times, this.cursor + 4);
         }

         this.times[this.cursor] = this.time;
         this.markedTime += this.time;
         this.markedCount += this.count;
         this.time = 0L;
         this.count = 0;
         ++this.cursor;
      }

      public long getTime() {
         return this.time;
      }

      public long getTotalTime() {
         return this.time + this.markedTime;
      }

      public double getSeconds() {
         return (double)this.time * 0.001D;
      }

      public double getTotalSeconds() {
         return (double)(this.time + this.markedTime) * 0.001D;
      }

      public long[] getTimes() {
         long[] times = new long[this.cursor + 1];
         System.arraycopy(this.times, 0, times, 0, Math.min(this.times.length, this.cursor));
         times[this.cursor] = this.time;
         return times;
      }

      public int getCount() {
         return this.count;
      }

      public int getTotalCount() {
         return this.count + this.markedCount;
      }

      public double getAverageTime() {
         return this.count > 0 ? (double)this.time / (double)this.count : 0.0D;
      }

      public double getTotalAverageTime() {
         return this.count > 0 ? (double)(this.time + this.markedTime) / (double)(this.count + this.markedCount) : 0.0D;
      }
   }

   public class Section {
      static final String SEPARATOR_ROOT = " -> ";
      static final String SEPARATOR_CHILD = ".";
      private final String name;
      private boolean root;
      private boolean fine;
      protected boolean invalidated;
      private String info;

      Section(String name) {
         this.name = name;
         this.info = name;
      }

      Profiler.Section getDelegate() {
         return this;
      }

      Profiler.Section invalidate() {
         this.invalidated = true;
         return this;
      }

      Profiler.Section setRoot(boolean root) {
         this.root = root;
         return this;
      }

      public boolean isRoot() {
         return this.root;
      }

      Profiler.Section setFine(boolean fine) {
         this.fine = fine;
         return this;
      }

      public boolean isFine() {
         return this.fine;
      }

      public String getName() {
         return this.name;
      }

      public String getBaseName() {
         return this.name;
      }

      public void setInfo(String info) {
         this.info = info;
      }

      public String getInfo() {
         return this.info;
      }

      Profiler.Section start() {
         return this;
      }

      protected Profiler.Section stop() {
         return this;
      }

      public Profiler.Section end() {
         if (!this.invalidated) {
            Profiler.this.end(this);
         }

         return this;
      }

      public Profiler.Section next(String name) {
         this.end();
         return Profiler.this.begin(name);
      }

      void mark() {
      }

      public long getTime() {
         return 0L;
      }

      public long getTotalTime() {
         return 0L;
      }

      public double getSeconds() {
         return 0.0D;
      }

      public double getTotalSeconds() {
         return 0.0D;
      }

      public long[] getTimes() {
         return new long[1];
      }

      public int getCount() {
         return 0;
      }

      public int getTotalCount() {
         return 0;
      }

      public double getAverageTime() {
         return 0.0D;
      }

      public double getTotalAverageTime() {
         return 0.0D;
      }

      public final String toString() {
         return this.name;
      }
   }

   class SubSection extends Profiler.LiveSection {
      private final String baseName;
      private final Profiler.Section root;

      SubSection(String name, int cursor, String baseName, Profiler.Section root) {
         super(name, cursor);
         this.baseName = baseName;
         this.root = root;
      }

      Profiler.Section invalidate() {
         this.root.invalidate();
         return super.invalidate();
      }

      public String getBaseName() {
         return this.baseName;
      }

      public void setInfo(String info) {
         this.root.setInfo(info);
         super.setInfo(info);
      }

      Profiler.Section getDelegate() {
         return this.root;
      }

      Profiler.Section start() {
         this.root.start();
         return super.start();
      }

      public Profiler.Section end() {
         this.root.stop();
         return super.end();
      }

      public Profiler.Section next(String name) {
         super.stop();
         return this.root.next(name);
      }
   }
}
