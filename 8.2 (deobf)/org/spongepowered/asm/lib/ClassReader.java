package org.spongepowered.asm.lib;

import java.io.IOException;
import java.io.InputStream;

public class ClassReader {
   static final boolean SIGNATURES = true;
   static final boolean ANNOTATIONS = true;
   static final boolean FRAMES = true;
   static final boolean WRITER = true;
   static final boolean RESIZE = true;
   public static final int SKIP_CODE = 1;
   public static final int SKIP_DEBUG = 2;
   public static final int SKIP_FRAMES = 4;
   public static final int EXPAND_FRAMES = 8;
   static final int EXPAND_ASM_INSNS = 256;
   public final byte[] b;
   private final int[] items;
   private final String[] strings;
   private final int maxStringLength;
   public final int header;

   public ClassReader(byte[] b) {
      this(b, 0, b.length);
   }

   public ClassReader(byte[] b, int off, int len) {
      this.b = b;
      if (this.readShort(off + 6) > 52) {
         throw new IllegalArgumentException();
      } else {
         this.items = new int[this.readUnsignedShort(off + 8)];
         int n = this.items.length;
         this.strings = new String[n];
         int max = 0;
         int index = off + 10;

         for(int i = 1; i < n; ++i) {
            this.items[i] = index + 1;
            int size;
            switch(b[index]) {
            case 1:
               size = 3 + this.readUnsignedShort(index + 1);
               if (size > max) {
                  max = size;
               }
               break;
            case 2:
            case 7:
            case 8:
            case 13:
            case 14:
            case 16:
            case 17:
            default:
               size = 3;
               break;
            case 3:
            case 4:
            case 9:
            case 10:
            case 11:
            case 12:
            case 18:
               size = 5;
               break;
            case 5:
            case 6:
               size = 9;
               ++i;
               break;
            case 15:
               size = 4;
            }

            index += size;
         }

         this.maxStringLength = max;
         this.header = index;
      }
   }

   public int getAccess() {
      return this.readUnsignedShort(this.header);
   }

   public String getClassName() {
      return this.readClass(this.header + 2, new char[this.maxStringLength]);
   }

   public String getSuperName() {
      return this.readClass(this.header + 4, new char[this.maxStringLength]);
   }

   public String[] getInterfaces() {
      int index = this.header + 6;
      int n = this.readUnsignedShort(index);
      String[] interfaces = new String[n];
      if (n > 0) {
         char[] buf = new char[this.maxStringLength];

         for(int i = 0; i < n; ++i) {
            index += 2;
            interfaces[i] = this.readClass(index, buf);
         }
      }

      return interfaces;
   }

   void copyPool(ClassWriter classWriter) {
      char[] buf = new char[this.maxStringLength];
      int ll = this.items.length;
      Item[] items2 = new Item[ll];

      for(int i = 1; i < ll; ++i) {
         int index = this.items[i];
         int tag = this.b[index - 1];
         Item item = new Item(i);
         switch(tag) {
         case 1:
            String s = this.strings[i];
            if (s == null) {
               index = this.items[i];
               s = this.strings[i] = this.readUTF(index + 2, this.readUnsignedShort(index), buf);
            }

            item.set(tag, s, (String)null, (String)null);
            break;
         case 2:
         case 7:
         case 8:
         case 13:
         case 14:
         case 16:
         case 17:
         default:
            item.set(tag, this.readUTF8(index, buf), (String)null, (String)null);
            break;
         case 3:
            item.set(this.readInt(index));
            break;
         case 4:
            item.set(Float.intBitsToFloat(this.readInt(index)));
            break;
         case 5:
            item.set(this.readLong(index));
            ++i;
            break;
         case 6:
            item.set(Double.longBitsToDouble(this.readLong(index)));
            ++i;
            break;
         case 9:
         case 10:
         case 11:
            int nameType = this.items[this.readUnsignedShort(index + 2)];
            item.set(tag, this.readClass(index, buf), this.readUTF8(nameType, buf), this.readUTF8(nameType + 2, buf));
            break;
         case 12:
            item.set(tag, this.readUTF8(index, buf), this.readUTF8(index + 2, buf), (String)null);
            break;
         case 15:
            int fieldOrMethodRef = this.items[this.readUnsignedShort(index + 1)];
            int nameType = this.items[this.readUnsignedShort(fieldOrMethodRef + 2)];
            item.set(20 + this.readByte(index), this.readClass(fieldOrMethodRef, buf), this.readUTF8(nameType, buf), this.readUTF8(nameType + 2, buf));
            break;
         case 18:
            if (classWriter.bootstrapMethods == null) {
               this.copyBootstrapMethods(classWriter, items2, buf);
            }

            int nameType = this.items[this.readUnsignedShort(index + 2)];
            item.set(this.readUTF8(nameType, buf), this.readUTF8(nameType + 2, buf), this.readUnsignedShort(index));
         }

         int index2 = item.hashCode % items2.length;
         item.next = items2[index2];
         items2[index2] = item;
      }

      int off = this.items[1] - 1;
      classWriter.pool.putByteArray(this.b, off, this.header - off);
      classWriter.items = items2;
      classWriter.threshold = (int)(0.75D * (double)ll);
      classWriter.index = ll;
   }

   private void copyBootstrapMethods(ClassWriter classWriter, Item[] items, char[] c) {
      int u = this.getAttributes();
      boolean found = false;

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         String attrName = this.readUTF8(u + 2, c);
         if ("BootstrapMethods".equals(attrName)) {
            found = true;
            break;
         }

         u += 6 + this.readInt(u + 4);
      }

      if (found) {
         int boostrapMethodCount = this.readUnsignedShort(u + 8);
         int j = 0;

         for(int v = u + 10; j < boostrapMethodCount; ++j) {
            int position = v - u - 10;
            int hashCode = this.readConst(this.readUnsignedShort(v), c).hashCode();

            for(int k = this.readUnsignedShort(v + 2); k > 0; --k) {
               hashCode ^= this.readConst(this.readUnsignedShort(v + 4), c).hashCode();
               v += 2;
            }

            v += 4;
            Item item = new Item(j);
            item.set(position, hashCode & Integer.MAX_VALUE);
            int index = item.hashCode % items.length;
            item.next = items[index];
            items[index] = item;
         }

         j = this.readInt(u + 4);
         ByteVector bootstrapMethods = new ByteVector(j + 62);
         bootstrapMethods.putByteArray(this.b, u + 10, j - 2);
         classWriter.bootstrapMethodsCount = boostrapMethodCount;
         classWriter.bootstrapMethods = bootstrapMethods;
      }
   }

   public ClassReader(InputStream is) throws IOException {
      this(readClass(is, false));
   }

   public ClassReader(String name) throws IOException {
      this(readClass(ClassLoader.getSystemResourceAsStream(name.replace('.', '/') + ".class"), true));
   }

   private static byte[] readClass(InputStream is, boolean close) throws IOException {
      if (is == null) {
         throw new IOException("Class not found");
      } else {
         try {
            byte[] b = new byte[is.available()];
            int len = 0;

            while(true) {
               int n = is.read(b, len, b.length - len);
               if (n == -1) {
                  if (len < b.length) {
                     byte[] c = new byte[len];
                     System.arraycopy(b, 0, c, 0, len);
                     b = c;
                  }

                  byte[] var11 = b;
                  return var11;
               }

               len += n;
               if (len == b.length) {
                  int last = is.read();
                  if (last < 0) {
                     byte[] var12 = b;
                     return var12;
                  }

                  byte[] c = new byte[b.length + 1000];
                  System.arraycopy(b, 0, c, 0, len);
                  c[len++] = (byte)last;
                  b = c;
               }
            }
         } finally {
            if (close) {
               is.close();
            }

         }
      }
   }

   public void accept(ClassVisitor classVisitor, int flags) {
      this.accept(classVisitor, new Attribute[0], flags);
   }

   public void accept(ClassVisitor classVisitor, Attribute[] attrs, int flags) {
      int u = this.header;
      char[] c = new char[this.maxStringLength];
      Context context = new Context();
      context.attrs = attrs;
      context.flags = flags;
      context.buffer = c;
      int access = this.readUnsignedShort(u);
      String name = this.readClass(u + 2, c);
      String superClass = this.readClass(u + 4, c);
      String[] interfaces = new String[this.readUnsignedShort(u + 6)];
      u = u + 8;

      for(int i = 0; i < interfaces.length; ++i) {
         interfaces[i] = this.readClass(u, c);
         u += 2;
      }

      String signature = null;
      String sourceFile = null;
      String sourceDebug = null;
      String enclosingOwner = null;
      String enclosingName = null;
      String enclosingDesc = null;
      int anns = 0;
      int ianns = 0;
      int tanns = 0;
      int itanns = 0;
      int innerClasses = 0;
      Attribute attributes = null;
      u = this.getAttributes();

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         String attrName = this.readUTF8(u + 2, c);
         if ("SourceFile".equals(attrName)) {
            sourceFile = this.readUTF8(u + 8, c);
         } else if ("InnerClasses".equals(attrName)) {
            innerClasses = u + 8;
         } else if ("EnclosingMethod".equals(attrName)) {
            enclosingOwner = this.readClass(u + 8, c);
            int item = this.readUnsignedShort(u + 10);
            if (item != 0) {
               enclosingName = this.readUTF8(this.items[item], c);
               enclosingDesc = this.readUTF8(this.items[item] + 2, c);
            }
         } else if ("Signature".equals(attrName)) {
            signature = this.readUTF8(u + 8, c);
         } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
            anns = u + 8;
         } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
            tanns = u + 8;
         } else if ("Deprecated".equals(attrName)) {
            access |= 131072;
         } else if ("Synthetic".equals(attrName)) {
            access |= 266240;
         } else if ("SourceDebugExtension".equals(attrName)) {
            int len = this.readInt(u + 4);
            sourceDebug = this.readUTF(u + 8, len, new char[len]);
         } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
            ianns = u + 8;
         } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
            itanns = u + 8;
         } else if (!"BootstrapMethods".equals(attrName)) {
            Attribute attr = this.readAttribute(attrs, attrName, u + 8, this.readInt(u + 4), c, -1, (Label[])null);
            if (attr != null) {
               attr.next = attributes;
               attributes = attr;
            }
         } else {
            int[] bootstrapMethods = new int[this.readUnsignedShort(u + 8)];
            int j = 0;

            for(int v = u + 10; j < bootstrapMethods.length; ++j) {
               bootstrapMethods[j] = v;
               v += 2 + this.readUnsignedShort(v + 2) << 1;
            }

            context.bootstrapMethods = bootstrapMethods;
         }

         u += 6 + this.readInt(u + 4);
      }

      classVisitor.visit(this.readInt(this.items[1] - 7), access, name, signature, superClass, interfaces);
      if ((flags & 2) == 0 && (sourceFile != null || sourceDebug != null)) {
         classVisitor.visitSource(sourceFile, sourceDebug);
      }

      if (enclosingOwner != null) {
         classVisitor.visitOuterClass(enclosingOwner, enclosingName, enclosingDesc);
      }

      if (anns != 0) {
         int i = this.readUnsignedShort(anns);

         for(int v = anns + 2; i > 0; --i) {
            v = this.readAnnotationValues(v + 2, c, true, classVisitor.visitAnnotation(this.readUTF8(v, c), true));
         }
      }

      if (ianns != 0) {
         int i = this.readUnsignedShort(ianns);

         for(int v = ianns + 2; i > 0; --i) {
            v = this.readAnnotationValues(v + 2, c, true, classVisitor.visitAnnotation(this.readUTF8(v, c), false));
         }
      }

      if (tanns != 0) {
         int i = this.readUnsignedShort(tanns);

         for(int v = tanns + 2; i > 0; --i) {
            v = this.readAnnotationTarget(context, v);
            v = this.readAnnotationValues(v + 2, c, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), true));
         }
      }

      if (itanns != 0) {
         int i = this.readUnsignedShort(itanns);

         for(int v = itanns + 2; i > 0; --i) {
            v = this.readAnnotationTarget(context, v);
            v = this.readAnnotationValues(v + 2, c, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), false));
         }
      }

      while(attributes != null) {
         Attribute attr = attributes.next;
         attributes.next = null;
         classVisitor.visitAttribute(attributes);
         attributes = attr;
      }

      if (innerClasses != 0) {
         int v = innerClasses + 2;

         for(int i = this.readUnsignedShort(innerClasses); i > 0; --i) {
            classVisitor.visitInnerClass(this.readClass(v, c), this.readClass(v + 2, c), this.readUTF8(v + 4, c), this.readUnsignedShort(v + 6));
            v += 8;
         }
      }

      u = this.header + 10 + 2 * interfaces.length;

      for(int i = this.readUnsignedShort(u - 2); i > 0; --i) {
         u = this.readField(classVisitor, context, u);
      }

      u = u + 2;

      for(int i = this.readUnsignedShort(u - 2); i > 0; --i) {
         u = this.readMethod(classVisitor, context, u);
      }

      classVisitor.visitEnd();
   }

   private int readField(ClassVisitor classVisitor, Context context, int u) {
      char[] c = context.buffer;
      int access = this.readUnsignedShort(u);
      String name = this.readUTF8(u + 2, c);
      String desc = this.readUTF8(u + 4, c);
      u = u + 6;
      String signature = null;
      int anns = 0;
      int ianns = 0;
      int tanns = 0;
      int itanns = 0;
      Object value = null;
      Attribute attributes = null;

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         String attrName = this.readUTF8(u + 2, c);
         if ("ConstantValue".equals(attrName)) {
            int item = this.readUnsignedShort(u + 8);
            value = item == 0 ? null : this.readConst(item, c);
         } else if ("Signature".equals(attrName)) {
            signature = this.readUTF8(u + 8, c);
         } else if ("Deprecated".equals(attrName)) {
            access |= 131072;
         } else if ("Synthetic".equals(attrName)) {
            access |= 266240;
         } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
            anns = u + 8;
         } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
            tanns = u + 8;
         } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
            ianns = u + 8;
         } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
            itanns = u + 8;
         } else {
            Attribute attr = this.readAttribute(context.attrs, attrName, u + 8, this.readInt(u + 4), c, -1, (Label[])null);
            if (attr != null) {
               attr.next = attributes;
               attributes = attr;
            }
         }

         u += 6 + this.readInt(u + 4);
      }

      u = u + 2;
      FieldVisitor fv = classVisitor.visitField(access, name, desc, signature, value);
      if (fv == null) {
         return u;
      } else {
         if (anns != 0) {
            int i = this.readUnsignedShort(anns);

            for(int v = anns + 2; i > 0; --i) {
               v = this.readAnnotationValues(v + 2, c, true, fv.visitAnnotation(this.readUTF8(v, c), true));
            }
         }

         if (ianns != 0) {
            int i = this.readUnsignedShort(ianns);

            for(int v = ianns + 2; i > 0; --i) {
               v = this.readAnnotationValues(v + 2, c, true, fv.visitAnnotation(this.readUTF8(v, c), false));
            }
         }

         if (tanns != 0) {
            int i = this.readUnsignedShort(tanns);

            for(int v = tanns + 2; i > 0; --i) {
               v = this.readAnnotationTarget(context, v);
               v = this.readAnnotationValues(v + 2, c, true, fv.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), true));
            }
         }

         if (itanns != 0) {
            int i = this.readUnsignedShort(itanns);

            for(int v = itanns + 2; i > 0; --i) {
               v = this.readAnnotationTarget(context, v);
               v = this.readAnnotationValues(v + 2, c, true, fv.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), false));
            }
         }

         while(attributes != null) {
            Attribute attr = attributes.next;
            attributes.next = null;
            fv.visitAttribute(attributes);
            attributes = attr;
         }

         fv.visitEnd();
         return u;
      }
   }

   private int readMethod(ClassVisitor classVisitor, Context context, int u) {
      char[] c = context.buffer;
      context.access = this.readUnsignedShort(u);
      context.name = this.readUTF8(u + 2, c);
      context.desc = this.readUTF8(u + 4, c);
      u = u + 6;
      int code = 0;
      int exception = 0;
      String[] exceptions = null;
      String signature = null;
      int methodParameters = 0;
      int anns = 0;
      int ianns = 0;
      int tanns = 0;
      int itanns = 0;
      int dann = 0;
      int mpanns = 0;
      int impanns = 0;
      int firstAttribute = u;
      Attribute attributes = null;

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         String attrName = this.readUTF8(u + 2, c);
         if ("Code".equals(attrName)) {
            if ((context.flags & 1) == 0) {
               code = u + 8;
            }
         } else if ("Exceptions".equals(attrName)) {
            exceptions = new String[this.readUnsignedShort(u + 8)];
            exception = u + 10;

            for(int j = 0; j < exceptions.length; ++j) {
               exceptions[j] = this.readClass(exception, c);
               exception += 2;
            }
         } else if ("Signature".equals(attrName)) {
            signature = this.readUTF8(u + 8, c);
         } else if ("Deprecated".equals(attrName)) {
            context.access |= 131072;
         } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
            anns = u + 8;
         } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
            tanns = u + 8;
         } else if ("AnnotationDefault".equals(attrName)) {
            dann = u + 8;
         } else if ("Synthetic".equals(attrName)) {
            context.access |= 266240;
         } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
            ianns = u + 8;
         } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
            itanns = u + 8;
         } else if ("RuntimeVisibleParameterAnnotations".equals(attrName)) {
            mpanns = u + 8;
         } else if ("RuntimeInvisibleParameterAnnotations".equals(attrName)) {
            impanns = u + 8;
         } else if ("MethodParameters".equals(attrName)) {
            methodParameters = u + 8;
         } else {
            Attribute attr = this.readAttribute(context.attrs, attrName, u + 8, this.readInt(u + 4), c, -1, (Label[])null);
            if (attr != null) {
               attr.next = attributes;
               attributes = attr;
            }
         }

         u += 6 + this.readInt(u + 4);
      }

      u = u + 2;
      MethodVisitor mv = classVisitor.visitMethod(context.access, context.name, context.desc, signature, exceptions);
      if (mv == null) {
         return u;
      } else {
         if (mv instanceof MethodWriter) {
            MethodWriter mw = (MethodWriter)mv;
            if (mw.cw.cr == this && signature == mw.signature) {
               boolean sameExceptions = false;
               if (exceptions == null) {
                  sameExceptions = mw.exceptionCount == 0;
               } else if (exceptions.length == mw.exceptionCount) {
                  sameExceptions = true;

                  for(int j = exceptions.length - 1; j >= 0; --j) {
                     exception -= 2;
                     if (mw.exceptions[j] != this.readUnsignedShort(exception)) {
                        sameExceptions = false;
                        break;
                     }
                  }
               }

               if (sameExceptions) {
                  mw.classReaderOffset = firstAttribute;
                  mw.classReaderLength = u - firstAttribute;
                  return u;
               }
            }
         }

         if (methodParameters != 0) {
            int i = this.b[methodParameters] & 255;

            for(int v = methodParameters + 1; i > 0; v += 4) {
               mv.visitParameter(this.readUTF8(v, c), this.readUnsignedShort(v + 2));
               --i;
            }
         }

         if (dann != 0) {
            AnnotationVisitor dv = mv.visitAnnotationDefault();
            this.readAnnotationValue(dann, c, (String)null, dv);
            if (dv != null) {
               dv.visitEnd();
            }
         }

         if (anns != 0) {
            int i = this.readUnsignedShort(anns);

            for(int v = anns + 2; i > 0; --i) {
               v = this.readAnnotationValues(v + 2, c, true, mv.visitAnnotation(this.readUTF8(v, c), true));
            }
         }

         if (ianns != 0) {
            int i = this.readUnsignedShort(ianns);

            for(int v = ianns + 2; i > 0; --i) {
               v = this.readAnnotationValues(v + 2, c, true, mv.visitAnnotation(this.readUTF8(v, c), false));
            }
         }

         if (tanns != 0) {
            int i = this.readUnsignedShort(tanns);

            for(int v = tanns + 2; i > 0; --i) {
               v = this.readAnnotationTarget(context, v);
               v = this.readAnnotationValues(v + 2, c, true, mv.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), true));
            }
         }

         if (itanns != 0) {
            int i = this.readUnsignedShort(itanns);

            for(int v = itanns + 2; i > 0; --i) {
               v = this.readAnnotationTarget(context, v);
               v = this.readAnnotationValues(v + 2, c, true, mv.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), false));
            }
         }

         if (mpanns != 0) {
            this.readParameterAnnotations(mv, context, mpanns, true);
         }

         if (impanns != 0) {
            this.readParameterAnnotations(mv, context, impanns, false);
         }

         while(attributes != null) {
            Attribute attr = attributes.next;
            attributes.next = null;
            mv.visitAttribute(attributes);
            attributes = attr;
         }

         if (code != 0) {
            mv.visitCode();
            this.readCode(mv, context, code);
         }

         mv.visitEnd();
         return u;
      }
   }

   private void readCode(MethodVisitor mv, Context context, int u) {
      byte[] b = this.b;
      char[] c = context.buffer;
      int maxStack = this.readUnsignedShort(u);
      int maxLocals = this.readUnsignedShort(u + 2);
      int codeLength = this.readInt(u + 4);
      u = u + 8;
      int codeStart = u;
      int codeEnd = u + codeLength;
      Label[] labels = context.labels = new Label[codeLength + 2];
      this.readLabel(codeLength + 1, labels);

      while(u < codeEnd) {
         int offset = u - codeStart;
         int opcode = b[u] & 255;
         switch(ClassWriter.TYPE[opcode]) {
         case 0:
         case 4:
            ++u;
            break;
         case 1:
         case 3:
         case 11:
            u += 2;
            break;
         case 2:
         case 5:
         case 6:
         case 12:
         case 13:
            u += 3;
            break;
         case 7:
         case 8:
            u += 5;
            break;
         case 9:
            this.readLabel(offset + this.readShort(u + 1), labels);
            u += 3;
            break;
         case 10:
            this.readLabel(offset + this.readInt(u + 1), labels);
            u += 5;
            break;
         case 14:
            u = u + 4 - (offset & 3);
            this.readLabel(offset + this.readInt(u), labels);

            for(int i = this.readInt(u + 8) - this.readInt(u + 4) + 1; i > 0; --i) {
               this.readLabel(offset + this.readInt(u + 12), labels);
               u += 4;
            }

            u = u + 12;
            break;
         case 15:
            u = u + 4 - (offset & 3);
            this.readLabel(offset + this.readInt(u), labels);

            for(int i = this.readInt(u + 4); i > 0; --i) {
               this.readLabel(offset + this.readInt(u + 12), labels);
               u += 8;
            }

            u = u + 8;
            break;
         case 16:
         default:
            u += 4;
            break;
         case 17:
            opcode = b[u + 1] & 255;
            if (opcode == 132) {
               u += 6;
            } else {
               u += 4;
            }
            break;
         case 18:
            this.readLabel(offset + this.readUnsignedShort(u + 1), labels);
            u += 3;
         }
      }

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         Label start = this.readLabel(this.readUnsignedShort(u + 2), labels);
         Label end = this.readLabel(this.readUnsignedShort(u + 4), labels);
         Label handler = this.readLabel(this.readUnsignedShort(u + 6), labels);
         String type = this.readUTF8(this.items[this.readUnsignedShort(u + 8)], c);
         mv.visitTryCatchBlock(start, end, handler, type);
         u += 8;
      }

      u = u + 2;
      int[] tanns = null;
      int[] itanns = null;
      int tann = 0;
      int itann = 0;
      int ntoff = -1;
      int nitoff = -1;
      int varTable = 0;
      int varTypeTable = 0;
      boolean zip = true;
      boolean unzip = (context.flags & 8) != 0;
      int stackMap = 0;
      int stackMapSize = 0;
      int frameCount = 0;
      Context frame = null;
      Attribute attributes = null;

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         String attrName = this.readUTF8(u + 2, c);
         if ("LocalVariableTable".equals(attrName)) {
            if ((context.flags & 2) == 0) {
               varTable = u + 8;
               int j = this.readUnsignedShort(u + 8);

               for(int v = u; j > 0; --j) {
                  int label = this.readUnsignedShort(v + 10);
                  if (labels[label] == null) {
                     Label var116 = this.readLabel(label, labels);
                     var116.status |= 1;
                  }

                  label = label + this.readUnsignedShort(v + 12);
                  if (labels[label] == null) {
                     Label var117 = this.readLabel(label, labels);
                     var117.status |= 1;
                  }

                  v += 10;
               }
            }
         } else if ("LocalVariableTypeTable".equals(attrName)) {
            varTypeTable = u + 8;
         } else if ("LineNumberTable".equals(attrName)) {
            if ((context.flags & 2) == 0) {
               int j = this.readUnsignedShort(u + 8);

               for(int v = u; j > 0; --j) {
                  int label = this.readUnsignedShort(v + 10);
                  if (labels[label] == null) {
                     Label var10000 = this.readLabel(label, labels);
                     var10000.status |= 1;
                  }

                  Label l;
                  for(l = labels[label]; l.line > 0; l = l.next) {
                     if (l.next == null) {
                        l.next = new Label();
                     }
                  }

                  l.line = this.readUnsignedShort(v + 12);
                  v += 4;
               }
            }
         } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
            tanns = this.readTypeAnnotations(mv, context, u + 8, true);
            ntoff = tanns.length != 0 && this.readByte(tanns[0]) >= 67 ? this.readUnsignedShort(tanns[0] + 1) : -1;
         } else if (!"RuntimeInvisibleTypeAnnotations".equals(attrName)) {
            if ("StackMapTable".equals(attrName)) {
               if ((context.flags & 4) == 0) {
                  stackMap = u + 10;
                  stackMapSize = this.readInt(u + 4);
                  frameCount = this.readUnsignedShort(u + 8);
               }
            } else if ("StackMap".equals(attrName)) {
               if ((context.flags & 4) == 0) {
                  zip = false;
                  stackMap = u + 10;
                  stackMapSize = this.readInt(u + 4);
                  frameCount = this.readUnsignedShort(u + 8);
               }
            } else {
               for(int j = 0; j < context.attrs.length; ++j) {
                  if (context.attrs[j].type.equals(attrName)) {
                     Attribute attr = context.attrs[j].read(this, u + 8, this.readInt(u + 4), c, codeStart - 8, labels);
                     if (attr != null) {
                        attr.next = attributes;
                        attributes = attr;
                     }
                  }
               }
            }
         } else {
            itanns = this.readTypeAnnotations(mv, context, u + 8, false);
            nitoff = itanns.length != 0 && this.readByte(itanns[0]) >= 67 ? this.readUnsignedShort(itanns[0] + 1) : -1;
         }

         u += 6 + this.readInt(u + 4);
      }

      u = u + 2;
      if (stackMap != 0) {
         frame = context;
         context.offset = -1;
         context.mode = 0;
         context.localCount = 0;
         context.localDiff = 0;
         context.stackCount = 0;
         context.local = new Object[maxLocals];
         context.stack = new Object[maxStack];
         if (unzip) {
            this.getImplicitFrame(context);
         }

         for(int i = stackMap; i < stackMap + stackMapSize - 2; ++i) {
            if (b[i] == 8) {
               int v = this.readUnsignedShort(i + 1);
               if (v >= 0 && v < codeLength && (b[codeStart + v] & 255) == 187) {
                  this.readLabel(v, labels);
               }
            }
         }
      }

      if ((context.flags & 256) != 0) {
         mv.visitFrame(-1, maxLocals, (Object[])null, 0, (Object[])null);
      }

      int opcodeDelta = (context.flags & 256) == 0 ? -33 : 0;
      u = codeStart;

      while(u < codeEnd) {
         int offset = u - codeStart;
         Label l = labels[offset];
         if (l != null) {
            Label next = l.next;
            l.next = null;
            mv.visitLabel(l);
            if ((context.flags & 2) == 0 && l.line > 0) {
               mv.visitLineNumber(l.line, l);

               while(next != null) {
                  mv.visitLineNumber(next.line, l);
                  next = next.next;
               }
            }
         }

         while(frame != null && (frame.offset == offset || frame.offset == -1)) {
            if (frame.offset != -1) {
               if (zip && !unzip) {
                  mv.visitFrame(frame.mode, frame.localDiff, frame.local, frame.stackCount, frame.stack);
               } else {
                  mv.visitFrame(-1, frame.localCount, frame.local, frame.stackCount, frame.stack);
               }
            }

            if (frameCount > 0) {
               stackMap = this.readFrame(stackMap, zip, unzip, frame);
               --frameCount;
            } else {
               frame = null;
            }
         }

         int opcode = b[u] & 255;
         switch(ClassWriter.TYPE[opcode]) {
         case 0:
            mv.visitInsn(opcode);
            ++u;
            break;
         case 1:
            mv.visitIntInsn(opcode, b[u + 1]);
            u += 2;
            break;
         case 2:
            mv.visitIntInsn(opcode, this.readShort(u + 1));
            u += 3;
            break;
         case 3:
            mv.visitVarInsn(opcode, b[u + 1] & 255);
            u += 2;
            break;
         case 4:
            if (opcode > 54) {
               opcode = opcode - 59;
               mv.visitVarInsn(54 + (opcode >> 2), opcode & 3);
            } else {
               opcode = opcode - 26;
               mv.visitVarInsn(21 + (opcode >> 2), opcode & 3);
            }

            ++u;
            break;
         case 5:
            mv.visitTypeInsn(opcode, this.readClass(u + 1, c));
            u += 3;
            break;
         case 6:
         case 7:
            int cpIndex = this.items[this.readUnsignedShort(u + 1)];
            boolean itf = b[cpIndex - 1] == 11;
            String iowner = this.readClass(cpIndex, c);
            cpIndex = this.items[this.readUnsignedShort(cpIndex + 2)];
            String iname = this.readUTF8(cpIndex, c);
            String idesc = this.readUTF8(cpIndex + 2, c);
            if (opcode < 182) {
               mv.visitFieldInsn(opcode, iowner, iname, idesc);
            } else {
               mv.visitMethodInsn(opcode, iowner, iname, idesc, itf);
            }

            if (opcode == 185) {
               u += 5;
            } else {
               u += 3;
            }
            break;
         case 8:
            int cpIndex = this.items[this.readUnsignedShort(u + 1)];
            int bsmIndex = context.bootstrapMethods[this.readUnsignedShort(cpIndex)];
            Handle bsm = (Handle)this.readConst(this.readUnsignedShort(bsmIndex), c);
            int bsmArgCount = this.readUnsignedShort(bsmIndex + 2);
            Object[] bsmArgs = new Object[bsmArgCount];
            bsmIndex = bsmIndex + 4;

            for(int i = 0; i < bsmArgCount; ++i) {
               bsmArgs[i] = this.readConst(this.readUnsignedShort(bsmIndex), c);
               bsmIndex += 2;
            }

            cpIndex = this.items[this.readUnsignedShort(cpIndex + 2)];
            String iname = this.readUTF8(cpIndex, c);
            String idesc = this.readUTF8(cpIndex + 2, c);
            mv.visitInvokeDynamicInsn(iname, idesc, bsm, bsmArgs);
            u += 5;
            break;
         case 9:
            mv.visitJumpInsn(opcode, labels[offset + this.readShort(u + 1)]);
            u += 3;
            break;
         case 10:
            mv.visitJumpInsn(opcode + opcodeDelta, labels[offset + this.readInt(u + 1)]);
            u += 5;
            break;
         case 11:
            mv.visitLdcInsn(this.readConst(b[u + 1] & 255, c));
            u += 2;
            break;
         case 12:
            mv.visitLdcInsn(this.readConst(this.readUnsignedShort(u + 1), c));
            u += 3;
            break;
         case 13:
            mv.visitIincInsn(b[u + 1] & 255, b[u + 2]);
            u += 3;
            break;
         case 14:
            u = u + 4 - (offset & 3);
            int label = offset + this.readInt(u);
            int min = this.readInt(u + 4);
            int max = this.readInt(u + 8);
            Label[] table = new Label[max - min + 1];
            u = u + 12;

            for(int i = 0; i < table.length; ++i) {
               table[i] = labels[offset + this.readInt(u)];
               u += 4;
            }

            mv.visitTableSwitchInsn(min, max, labels[label], table);
            break;
         case 15:
            u = u + 4 - (offset & 3);
            int label = offset + this.readInt(u);
            int len = this.readInt(u + 4);
            int[] keys = new int[len];
            Label[] values = new Label[len];
            u = u + 8;

            for(int i = 0; i < len; ++i) {
               keys[i] = this.readInt(u);
               values[i] = labels[offset + this.readInt(u + 4)];
               u += 8;
            }

            mv.visitLookupSwitchInsn(labels[label], keys, values);
            break;
         case 16:
         default:
            mv.visitMultiANewArrayInsn(this.readClass(u + 1, c), b[u + 3] & 255);
            u += 4;
            break;
         case 17:
            opcode = b[u + 1] & 255;
            if (opcode == 132) {
               mv.visitIincInsn(this.readUnsignedShort(u + 2), this.readShort(u + 4));
               u += 6;
            } else {
               mv.visitVarInsn(opcode, this.readUnsignedShort(u + 2));
               u += 4;
            }
            break;
         case 18:
            opcode = opcode < 218 ? opcode - 49 : opcode - 20;
            Label target = labels[offset + this.readUnsignedShort(u + 1)];
            if (opcode != 167 && opcode != 168) {
               opcode = opcode <= 166 ? (opcode + 1 ^ 1) - 1 : opcode ^ 1;
               Label endif = new Label();
               mv.visitJumpInsn(opcode, endif);
               mv.visitJumpInsn(200, target);
               mv.visitLabel(endif);
               if (stackMap != 0 && (frame == null || frame.offset != offset + 3)) {
                  mv.visitFrame(256, 0, (Object[])null, 0, (Object[])null);
               }
            } else {
               mv.visitJumpInsn(opcode + 33, target);
            }

            u += 3;
         }

         while(tanns != null && tann < tanns.length && ntoff <= offset) {
            if (ntoff == offset) {
               int v = this.readAnnotationTarget(context, tanns[tann]);
               this.readAnnotationValues(v + 2, c, true, mv.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), true));
            }

            ++tann;
            ntoff = tann < tanns.length && this.readByte(tanns[tann]) >= 67 ? this.readUnsignedShort(tanns[tann] + 1) : -1;
         }

         while(itanns != null && itann < itanns.length && nitoff <= offset) {
            if (nitoff == offset) {
               int v = this.readAnnotationTarget(context, itanns[itann]);
               this.readAnnotationValues(v + 2, c, true, mv.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(v, c), false));
            }

            ++itann;
            nitoff = itann < itanns.length && this.readByte(itanns[itann]) >= 67 ? this.readUnsignedShort(itanns[itann] + 1) : -1;
         }
      }

      if (labels[codeLength] != null) {
         mv.visitLabel(labels[codeLength]);
      }

      if ((context.flags & 2) == 0 && varTable != 0) {
         int[] typeTable = null;
         if (varTypeTable != 0) {
            u = varTypeTable + 2;
            typeTable = new int[this.readUnsignedShort(varTypeTable) * 3];

            for(int i = typeTable.length; i > 0; u += 10) {
               --i;
               typeTable[i] = u + 6;
               --i;
               typeTable[i] = this.readUnsignedShort(u + 8);
               --i;
               typeTable[i] = this.readUnsignedShort(u);
            }
         }

         u = varTable + 2;

         for(int i = this.readUnsignedShort(varTable); i > 0; --i) {
            int start = this.readUnsignedShort(u);
            int length = this.readUnsignedShort(u + 2);
            int index = this.readUnsignedShort(u + 8);
            String vsignature = null;
            if (typeTable != null) {
               for(int j = 0; j < typeTable.length; j += 3) {
                  if (typeTable[j] == start && typeTable[j + 1] == index) {
                     vsignature = this.readUTF8(typeTable[j + 2], c);
                     break;
                  }
               }
            }

            mv.visitLocalVariable(this.readUTF8(u + 4, c), this.readUTF8(u + 6, c), vsignature, labels[start], labels[start + length], index);
            u += 10;
         }
      }

      if (tanns != null) {
         for(int i = 0; i < tanns.length; ++i) {
            if (this.readByte(tanns[i]) >> 1 == 32) {
               int v = this.readAnnotationTarget(context, tanns[i]);
               this.readAnnotationValues(v + 2, c, true, mv.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(v, c), true));
            }
         }
      }

      if (itanns != null) {
         for(int i = 0; i < itanns.length; ++i) {
            if (this.readByte(itanns[i]) >> 1 == 32) {
               int v = this.readAnnotationTarget(context, itanns[i]);
               this.readAnnotationValues(v + 2, c, true, mv.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(v, c), false));
            }
         }
      }

      while(attributes != null) {
         Attribute attr = attributes.next;
         attributes.next = null;
         mv.visitAttribute(attributes);
         attributes = attr;
      }

      mv.visitMaxs(maxStack, maxLocals);
   }

   private int[] readTypeAnnotations(MethodVisitor mv, Context context, int u, boolean visible) {
      char[] c = context.buffer;
      int[] offsets = new int[this.readUnsignedShort(u)];
      u = u + 2;

      for(int i = 0; i < offsets.length; ++i) {
         offsets[i] = u;
         int target = this.readInt(u);
         switch(target >>> 24) {
         case 0:
         case 1:
         case 22:
            u += 2;
            break;
         case 19:
         case 20:
         case 21:
            ++u;
            break;
         case 64:
         case 65:
            for(int j = this.readUnsignedShort(u + 1); j > 0; --j) {
               int start = this.readUnsignedShort(u + 3);
               int length = this.readUnsignedShort(u + 5);
               this.readLabel(start, context.labels);
               this.readLabel(start + length, context.labels);
               u += 6;
            }

            u += 3;
            break;
         case 71:
         case 72:
         case 73:
         case 74:
         case 75:
            u += 4;
            break;
         default:
            u += 3;
         }

         int pathLength = this.readByte(u);
         if (target >>> 24 == 66) {
            TypePath path = pathLength == 0 ? null : new TypePath(this.b, u);
            u = u + 1 + 2 * pathLength;
            u = this.readAnnotationValues(u + 2, c, true, mv.visitTryCatchAnnotation(target, path, this.readUTF8(u, c), visible));
         } else {
            u = this.readAnnotationValues(u + 3 + 2 * pathLength, c, true, (AnnotationVisitor)null);
         }
      }

      return offsets;
   }

   private int readAnnotationTarget(Context context, int u) {
      int var9;
      target = this.readInt(u);
      label29:
      switch(var9 >>> 24) {
      case 0:
      case 1:
      case 22:
         var9 = var9 & -65536;
         u += 2;
         break;
      case 19:
      case 20:
      case 21:
         var9 = var9 & -16777216;
         ++u;
         break;
      case 64:
      case 65:
         var9 = var9 & -16777216;
         int n = this.readUnsignedShort(u + 1);
         context.start = new Label[n];
         context.end = new Label[n];
         context.index = new int[n];
         u += 3;
         int i = 0;

         while(true) {
            if (i >= n) {
               break label29;
            }

            int start = this.readUnsignedShort(u);
            int length = this.readUnsignedShort(u + 2);
            context.start[i] = this.readLabel(start, context.labels);
            context.end[i] = this.readLabel(start + length, context.labels);
            context.index[i] = this.readUnsignedShort(u + 4);
            u += 6;
            ++i;
         }
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
         var9 = var9 & -16776961;
         u += 4;
         break;
      default:
         var9 = var9 & (var9 >>> 24 < 67 ? -256 : -16777216);
         u += 3;
      }

      int pathLength = this.readByte(u);
      context.typeRef = var9;
      context.typePath = pathLength == 0 ? null : new TypePath(this.b, u);
      return u + 1 + 2 * pathLength;
   }

   private void readParameterAnnotations(MethodVisitor mv, Context context, int v, boolean visible) {
      int n = this.b[v++] & 255;
      int synthetics = Type.getArgumentTypes(context.desc).length - n;

      int i;
      for(i = 0; i < synthetics; ++i) {
         AnnotationVisitor av = mv.visitParameterAnnotation(i, "Ljava/lang/Synthetic;", false);
         if (av != null) {
            av.visitEnd();
         }
      }

      for(char[] c = context.buffer; i < n + synthetics; ++i) {
         int j = this.readUnsignedShort(v);

         for(v += 2; j > 0; --j) {
            AnnotationVisitor av = mv.visitParameterAnnotation(i, this.readUTF8(v, c), visible);
            v = this.readAnnotationValues(v + 2, c, true, av);
         }
      }

   }

   private int readAnnotationValues(int v, char[] buf, boolean named, AnnotationVisitor av) {
      int i = this.readUnsignedShort(v);
      v = v + 2;
      if (named) {
         while(i > 0) {
            v = this.readAnnotationValue(v + 2, buf, this.readUTF8(v, buf), av);
            --i;
         }
      } else {
         while(i > 0) {
            v = this.readAnnotationValue(v, buf, (String)null, av);
            --i;
         }
      }

      if (av != null) {
         av.visitEnd();
      }

      return v;
   }

   private int readAnnotationValue(int param1, char[] param2, String param3, AnnotationVisitor param4) {
      // $FF: Couldn't be decompiled
   }

   private void getImplicitFrame(Context frame) {
      String desc = frame.desc;
      Object[] locals = frame.local;
      int local = 0;
      if ((frame.access & 8) == 0) {
         if ("<init>".equals(frame.name)) {
            locals[local++] = Opcodes.UNINITIALIZED_THIS;
         } else {
            locals[local++] = this.readClass(this.header + 2, frame.buffer);
         }
      }

      int i = 1;

      while(true) {
         int j = i;
         switch(desc.charAt(i++)) {
         case 'B':
         case 'C':
         case 'I':
         case 'S':
         case 'Z':
            locals[local++] = Opcodes.INTEGER;
            break;
         case 'D':
            locals[local++] = Opcodes.DOUBLE;
            break;
         case 'E':
         case 'G':
         case 'H':
         case 'K':
         case 'M':
         case 'N':
         case 'O':
         case 'P':
         case 'Q':
         case 'R':
         case 'T':
         case 'U':
         case 'V':
         case 'W':
         case 'X':
         case 'Y':
         default:
            frame.localCount = local;
            return;
         case 'F':
            locals[local++] = Opcodes.FLOAT;
            break;
         case 'J':
            locals[local++] = Opcodes.LONG;
            break;
         case 'L':
            while(desc.charAt(i) != ';') {
               ++i;
            }

            locals[local++] = desc.substring(j + 1, i++);
            break;
         case '[':
            while(desc.charAt(i) == '[') {
               ++i;
            }

            if (desc.charAt(i) == 'L') {
               ++i;

               while(desc.charAt(i) != ';') {
                  ++i;
               }
            }

            int var9 = local++;
            ++i;
            locals[var9] = desc.substring(j, i);
         }
      }
   }

   private int readFrame(int stackMap, boolean zip, boolean unzip, Context frame) {
      char[] c = frame.buffer;
      Label[] labels = frame.labels;
      int tag;
      if (zip) {
         tag = this.b[stackMap++] & 255;
      } else {
         tag = 255;
         frame.offset = -1;
      }

      frame.localDiff = 0;
      int delta;
      if (tag < 64) {
         delta = tag;
         frame.mode = 3;
         frame.stackCount = 0;
      } else if (tag < 128) {
         delta = tag - 64;
         stackMap = this.readFrameType(frame.stack, 0, stackMap, c, labels);
         frame.mode = 4;
         frame.stackCount = 1;
      } else {
         delta = this.readUnsignedShort(stackMap);
         stackMap += 2;
         if (tag == 247) {
            stackMap = this.readFrameType(frame.stack, 0, stackMap, c, labels);
            frame.mode = 4;
            frame.stackCount = 1;
         } else if (tag >= 248 && tag < 251) {
            frame.mode = 2;
            frame.localDiff = 251 - tag;
            frame.localCount -= frame.localDiff;
            frame.stackCount = 0;
         } else if (tag == 251) {
            frame.mode = 3;
            frame.stackCount = 0;
         } else if (tag < 255) {
            int local = unzip ? frame.localCount : 0;

            for(int i = tag - 251; i > 0; --i) {
               stackMap = this.readFrameType(frame.local, local++, stackMap, c, labels);
            }

            frame.mode = 1;
            frame.localDiff = tag - 251;
            frame.localCount += frame.localDiff;
            frame.stackCount = 0;
         } else {
            frame.mode = 0;
            int n = this.readUnsignedShort(stackMap);
            stackMap = stackMap + 2;
            frame.localDiff = n;
            frame.localCount = n;

            for(int local = 0; n > 0; --n) {
               stackMap = this.readFrameType(frame.local, local++, stackMap, c, labels);
            }

            n = this.readUnsignedShort(stackMap);
            stackMap = stackMap + 2;
            frame.stackCount = n;

            for(int stack = 0; n > 0; --n) {
               stackMap = this.readFrameType(frame.stack, stack++, stackMap, c, labels);
            }
         }
      }

      frame.offset += delta + 1;
      this.readLabel(frame.offset, labels);
      return stackMap;
   }

   private int readFrameType(Object[] frame, int index, int v, char[] buf, Label[] labels) {
      int type = this.b[v++] & 255;
      switch(type) {
      case 0:
         frame[index] = Opcodes.TOP;
         break;
      case 1:
         frame[index] = Opcodes.INTEGER;
         break;
      case 2:
         frame[index] = Opcodes.FLOAT;
         break;
      case 3:
         frame[index] = Opcodes.DOUBLE;
         break;
      case 4:
         frame[index] = Opcodes.LONG;
         break;
      case 5:
         frame[index] = Opcodes.NULL;
         break;
      case 6:
         frame[index] = Opcodes.UNINITIALIZED_THIS;
         break;
      case 7:
         frame[index] = this.readClass(v, buf);
         v += 2;
         break;
      default:
         frame[index] = this.readLabel(this.readUnsignedShort(v), labels);
         v += 2;
      }

      return v;
   }

   protected Label readLabel(int offset, Label[] labels) {
      if (labels[offset] == null) {
         labels[offset] = new Label();
      }

      return labels[offset];
   }

   private int getAttributes() {
      int u = this.header + 8 + this.readUnsignedShort(this.header + 6) * 2;

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         for(int j = this.readUnsignedShort(u + 8); j > 0; --j) {
            u += 6 + this.readInt(u + 12);
         }

         u += 8;
      }

      u = u + 2;

      for(int i = this.readUnsignedShort(u); i > 0; --i) {
         for(int j = this.readUnsignedShort(u + 8); j > 0; --j) {
            u += 6 + this.readInt(u + 12);
         }

         u += 8;
      }

      return u + 2;
   }

   private Attribute readAttribute(Attribute[] attrs, String type, int off, int len, char[] buf, int codeOff, Label[] labels) {
      for(int i = 0; i < attrs.length; ++i) {
         if (attrs[i].type.equals(type)) {
            return attrs[i].read(this, off, len, buf, codeOff, labels);
         }
      }

      return (new Attribute(type)).read(this, off, len, (char[])null, -1, (Label[])null);
   }

   public int getItemCount() {
      return this.items.length;
   }

   public int getItem(int item) {
      return this.items[item];
   }

   public int getMaxStringLength() {
      return this.maxStringLength;
   }

   public int readByte(int index) {
      return this.b[index] & 255;
   }

   public int readUnsignedShort(int index) {
      byte[] b = this.b;
      return (b[index] & 255) << 8 | b[index + 1] & 255;
   }

   public short readShort(int index) {
      byte[] b = this.b;
      return (short)((b[index] & 255) << 8 | b[index + 1] & 255);
   }

   public int readInt(int index) {
      byte[] b = this.b;
      return (b[index] & 255) << 24 | (b[index + 1] & 255) << 16 | (b[index + 2] & 255) << 8 | b[index + 3] & 255;
   }

   public long readLong(int index) {
      long l1 = (long)this.readInt(index);
      long l0 = (long)this.readInt(index + 4) & 4294967295L;
      return l1 << 32 | l0;
   }

   public String readUTF8(int index, char[] buf) {
      int item = this.readUnsignedShort(index);
      if (index != 0 && item != 0) {
         String s = this.strings[item];
         if (s != null) {
            return s;
         } else {
            index = this.items[item];
            return this.strings[item] = this.readUTF(index + 2, this.readUnsignedShort(index), buf);
         }
      } else {
         return null;
      }
   }

   private String readUTF(int index, int utfLen, char[] buf) {
      int endIndex = index + utfLen;
      byte[] b = this.b;
      int strLen = 0;
      int st = 0;
      char cc = 0;

      while(index < endIndex) {
         int c = b[index++];
         switch(st) {
         case 0:
            c = c & 255;
            if (c < 128) {
               buf[strLen++] = (char)c;
            } else {
               if (c < 224 && c > 191) {
                  cc = (char)(c & 31);
                  st = 1;
                  continue;
               }

               cc = (char)(c & 15);
               st = 2;
            }
            break;
         case 1:
            buf[strLen++] = (char)(cc << 6 | c & 63);
            st = 0;
            break;
         case 2:
            cc = (char)(cc << 6 | c & 63);
            st = 1;
         }
      }

      return new String(buf, 0, strLen);
   }

   public String readClass(int index, char[] buf) {
      return this.readUTF8(this.items[this.readUnsignedShort(index)], buf);
   }

   public Object readConst(int item, char[] buf) {
      int index = this.items[item];
      switch(this.b[index - 1]) {
      case 3:
         return this.readInt(index);
      case 4:
         return Float.intBitsToFloat(this.readInt(index));
      case 5:
         return this.readLong(index);
      case 6:
         return Double.longBitsToDouble(this.readLong(index));
      case 7:
         return Type.getObjectType(this.readUTF8(index, buf));
      case 8:
         return this.readUTF8(index, buf);
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      default:
         int tag = this.readByte(index);
         int[] items = this.items;
         int cpIndex = items[this.readUnsignedShort(index + 1)];
         boolean itf = this.b[cpIndex - 1] == 11;
         String owner = this.readClass(cpIndex, buf);
         cpIndex = items[this.readUnsignedShort(cpIndex + 2)];
         String name = this.readUTF8(cpIndex, buf);
         String desc = this.readUTF8(cpIndex + 2, buf);
         return new Handle(tag, owner, name, desc, itf);
      case 16:
         return Type.getMethodType(this.readUTF8(index, buf));
      }
   }
}
