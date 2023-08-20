package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;

public class AnnotationNode extends AnnotationVisitor {
   public String desc;
   public List values;

   public AnnotationNode(String desc) {
      this(327680, desc);
      if (this.getClass() != AnnotationNode.class) {
         throw new IllegalStateException();
      }
   }

   public AnnotationNode(int api, String desc) {
      super(api);
      this.desc = desc;
   }

   AnnotationNode(List values) {
      super(327680);
      this.values = values;
   }

   public void visit(String name, Object value) {
      if (this.values == null) {
         this.values = new ArrayList(this.desc != null ? 2 : 1);
      }

      if (this.desc != null) {
         this.values.add(name);
      }

      if (value instanceof byte[]) {
         byte[] v = (byte[])value;
         ArrayList l = new ArrayList(v.length);

         for(byte b : v) {
            l.add(Byte.valueOf(b));
         }

         this.values.add(l);
      } else if (value instanceof boolean[]) {
         boolean[] v = (boolean[])value;
         ArrayList l = new ArrayList(v.length);

         for(boolean b : v) {
            l.add(Boolean.valueOf(b));
         }

         this.values.add(l);
      } else if (value instanceof short[]) {
         short[] v = (short[])value;
         ArrayList l = new ArrayList(v.length);

         for(short s : v) {
            l.add(Short.valueOf(s));
         }

         this.values.add(l);
      } else if (value instanceof char[]) {
         char[] v = (char[])value;
         ArrayList l = new ArrayList(v.length);

         for(char c : v) {
            l.add(Character.valueOf(c));
         }

         this.values.add(l);
      } else if (value instanceof int[]) {
         int[] v = (int[])value;
         ArrayList l = new ArrayList(v.length);

         for(int i : v) {
            l.add(Integer.valueOf(i));
         }

         this.values.add(l);
      } else if (value instanceof long[]) {
         long[] v = (long[])value;
         ArrayList l = new ArrayList(v.length);

         for(long lng : v) {
            l.add(Long.valueOf(lng));
         }

         this.values.add(l);
      } else if (value instanceof float[]) {
         float[] v = (float[])value;
         ArrayList l = new ArrayList(v.length);

         for(float f : v) {
            l.add(Float.valueOf(f));
         }

         this.values.add(l);
      } else if (value instanceof double[]) {
         double[] v = (double[])value;
         ArrayList l = new ArrayList(v.length);

         for(double d : v) {
            l.add(Double.valueOf(d));
         }

         this.values.add(l);
      } else {
         this.values.add(value);
      }

   }

   public void visitEnum(String name, String desc, String value) {
      if (this.values == null) {
         this.values = new ArrayList(this.desc != null ? 2 : 1);
      }

      if (this.desc != null) {
         this.values.add(name);
      }

      this.values.add(new String[]{desc, value});
   }

   public AnnotationVisitor visitAnnotation(String name, String desc) {
      if (this.values == null) {
         this.values = new ArrayList(this.desc != null ? 2 : 1);
      }

      if (this.desc != null) {
         this.values.add(name);
      }

      AnnotationNode annotation = new AnnotationNode(desc);
      this.values.add(annotation);
      return annotation;
   }

   public AnnotationVisitor visitArray(String name) {
      if (this.values == null) {
         this.values = new ArrayList(this.desc != null ? 2 : 1);
      }

      if (this.desc != null) {
         this.values.add(name);
      }

      List array = new ArrayList();
      this.values.add(array);
      return new AnnotationNode(array);
   }

   public void visitEnd() {
   }

   public void check(int api) {
   }

   public void accept(AnnotationVisitor av) {
      if (av != null) {
         if (this.values != null) {
            for(int i = 0; i < this.values.size(); i += 2) {
               String name = (String)this.values.get(i);
               Object value = this.values.get(i + 1);
               accept(av, name, value);
            }
         }

         av.visitEnd();
      }

   }

   static void accept(AnnotationVisitor av, String name, Object value) {
      if (av != null) {
         if (value instanceof String[]) {
            String[] typeconst = (String[])value;
            av.visitEnum(name, typeconst[0], typeconst[1]);
         } else if (value instanceof AnnotationNode) {
            AnnotationNode an = (AnnotationNode)value;
            an.accept(av.visitAnnotation(name, an.desc));
         } else if (value instanceof List) {
            AnnotationVisitor v = av.visitArray(name);
            if (v != null) {
               List array = (List)value;

               for(int j = 0; j < array.size(); ++j) {
                  accept(v, (String)null, array.get(j));
               }

               v.visitEnd();
            }
         } else {
            av.visit(name, value);
         }
      }

   }
}
