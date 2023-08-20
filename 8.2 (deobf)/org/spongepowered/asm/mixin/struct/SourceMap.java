package org.spongepowered.asm.mixin.struct;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.util.Bytecode;

public class SourceMap {
   private static final String DEFAULT_STRATUM = "Mixin";
   private static final String NEWLINE = "\n";
   private final String sourceFile;
   private final Map strata = new LinkedHashMap();
   private int nextLineOffset = 1;
   private String defaultStratum = "Mixin";

   public SourceMap(String sourceFile) {
      this.sourceFile = sourceFile;
   }

   public String getSourceFile() {
      return this.sourceFile;
   }

   public String getPseudoGeneratedSourceFile() {
      return this.sourceFile.replace(".java", "$mixin.java");
   }

   public SourceMap.File addFile(ClassNode classNode) {
      return this.addFile(this.defaultStratum, classNode);
   }

   public SourceMap.File addFile(String stratumName, ClassNode classNode) {
      return this.addFile(stratumName, classNode.sourceFile, classNode.name + ".java", Bytecode.getMaxLineNumber(classNode, 500, 50));
   }

   public SourceMap.File addFile(String sourceFileName, String sourceFilePath, int size) {
      return this.addFile(this.defaultStratum, sourceFileName, sourceFilePath, size);
   }

   public SourceMap.File addFile(String stratumName, String sourceFileName, String sourceFilePath, int size) {
      SourceMap.Stratum stratum = (SourceMap.Stratum)this.strata.get(stratumName);
      if (stratum == null) {
         stratum = new SourceMap.Stratum(stratumName);
         this.strata.put(stratumName, stratum);
      }

      SourceMap.File file = stratum.addFile(this.nextLineOffset, size, sourceFileName, sourceFilePath);
      this.nextLineOffset += size;
      return file;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      this.appendTo(sb);
      return sb.toString();
   }

   private void appendTo(StringBuilder sb) {
      sb.append("SMAP").append("\n");
      sb.append(this.getSourceFile()).append("\n");
      sb.append(this.defaultStratum).append("\n");

      for(SourceMap.Stratum stratum : this.strata.values()) {
         stratum.appendTo(sb);
      }

      sb.append("*E").append("\n");
   }

   public static class File {
      public final int id;
      public final int lineOffset;
      public final int size;
      public final String sourceFileName;
      public final String sourceFilePath;

      public File(int id, int lineOffset, int size, String sourceFileName) {
         this(id, lineOffset, size, sourceFileName, (String)null);
      }

      public File(int id, int lineOffset, int size, String sourceFileName, String sourceFilePath) {
         this.id = id;
         this.lineOffset = lineOffset;
         this.size = size;
         this.sourceFileName = sourceFileName;
         this.sourceFilePath = sourceFilePath;
      }

      public void applyOffset(ClassNode classNode) {
         for(MethodNode method : classNode.methods) {
            this.applyOffset(method);
         }

      }

      public void applyOffset(MethodNode method) {
         Iterator iter = method.instructions.iterator();

         while(iter.hasNext()) {
            AbstractInsnNode node = (AbstractInsnNode)iter.next();
            if (node instanceof LineNumberNode) {
               ((LineNumberNode)node).line += this.lineOffset - 1;
            }
         }

      }

      void appendFile(StringBuilder sb) {
         if (this.sourceFilePath != null) {
            sb.append("+ ").append(this.id).append(" ").append(this.sourceFileName).append("\n");
            sb.append(this.sourceFilePath).append("\n");
         } else {
            sb.append(this.id).append(" ").append(this.sourceFileName).append("\n");
         }

      }

      public void appendLines(StringBuilder sb) {
         sb.append("1#").append(this.id).append(",").append(this.size).append(":").append(this.lineOffset).append("\n");
      }
   }

   static class Stratum {
      private static final String STRATUM_MARK = "*S";
      private static final String FILE_MARK = "*F";
      private static final String LINES_MARK = "*L";
      public final String name;
      private final Map files = new LinkedHashMap();

      public Stratum(String name) {
         this.name = name;
      }

      public SourceMap.File addFile(int lineOffset, int size, String sourceFileName, String sourceFilePath) {
         SourceMap.File file = (SourceMap.File)this.files.get(sourceFilePath);
         if (file == null) {
            file = new SourceMap.File(this.files.size() + 1, lineOffset, size, sourceFileName, sourceFilePath);
            this.files.put(sourceFilePath, file);
         }

         return file;
      }

      void appendTo(StringBuilder sb) {
         sb.append("*S").append(" ").append(this.name).append("\n");
         sb.append("*F").append("\n");

         for(SourceMap.File file : this.files.values()) {
            file.appendFile(sb);
         }

         sb.append("*L").append("\n");

         for(SourceMap.File file : this.files.values()) {
            file.appendLines(sb);
         }

      }
   }
}
