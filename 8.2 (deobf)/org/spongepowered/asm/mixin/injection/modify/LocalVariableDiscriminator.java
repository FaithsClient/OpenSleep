package org.spongepowered.asm.mixin.injection.modify;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.Locals;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.SignaturePrinter;

public class LocalVariableDiscriminator {
   private final boolean argsOnly;
   private final int ordinal;
   private final int index;
   private final Set names;
   private final boolean print;

   public LocalVariableDiscriminator(boolean argsOnly, int ordinal, int index, Set names, boolean print) {
      this.argsOnly = argsOnly;
      this.ordinal = ordinal;
      this.index = index;
      this.names = Collections.unmodifiableSet(names);
      this.print = print;
   }

   public boolean isArgsOnly() {
      return this.argsOnly;
   }

   public int getOrdinal() {
      return this.ordinal;
   }

   public int getIndex() {
      return this.index;
   }

   public Set getNames() {
      return this.names;
   }

   public boolean hasNames() {
      return !this.names.isEmpty();
   }

   public boolean printLVT() {
      return this.print;
   }

   protected boolean isImplicit(LocalVariableDiscriminator.Context context) {
      return this.ordinal < 0 && this.index < context.baseArgIndex && this.names.isEmpty();
   }

   public int findLocal(Type returnType, boolean argsOnly, org.spongepowered.asm.mixin.injection.struct.Target target, AbstractInsnNode node) {
      try {
         return this.findLocal(new LocalVariableDiscriminator.Context(returnType, argsOnly, target, node));
      } catch (InvalidImplicitDiscriminatorException var6) {
         return -2;
      }
   }

   public int findLocal(LocalVariableDiscriminator.Context context) {
      return this.isImplicit(context) ? this.findImplicitLocal(context) : this.findExplicitLocal(context);
   }

   private int findImplicitLocal(LocalVariableDiscriminator.Context context) {
      int found = 0;
      int count = 0;

      for(int index = context.baseArgIndex; index < context.locals.length; ++index) {
         LocalVariableDiscriminator.Context.Local local = context.locals[index];
         if (local != null && local.type.equals(context.returnType)) {
            ++count;
            found = index;
         }
      }

      if (count == 1) {
         return found;
      } else {
         throw new InvalidImplicitDiscriminatorException("Found " + count + " candidate variables but exactly 1 is required.");
      }
   }

   private int findExplicitLocal(LocalVariableDiscriminator.Context context) {
      for(int index = context.baseArgIndex; index < context.locals.length; ++index) {
         LocalVariableDiscriminator.Context.Local local = context.locals[index];
         if (local != null && local.type.equals(context.returnType)) {
            if (this.ordinal > -1) {
               if (this.ordinal == local.ord) {
                  return index;
               }
            } else if (this.index >= context.baseArgIndex) {
               if (this.index == index) {
                  return index;
               }
            } else if (this.names.contains(local.name)) {
               return index;
            }
         }
      }

      return -1;
   }

   public static LocalVariableDiscriminator parse(AnnotationNode annotation) {
      boolean argsOnly = ((Boolean)Annotations.getValue(annotation, "argsOnly", Boolean.FALSE)).booleanValue();
      int ordinal = ((Integer)Annotations.getValue(annotation, "ordinal", Integer.valueOf(-1))).intValue();
      int index = ((Integer)Annotations.getValue(annotation, "index", Integer.valueOf(-1))).intValue();
      boolean print = ((Boolean)Annotations.getValue(annotation, "print", Boolean.FALSE)).booleanValue();
      Set names = new HashSet();
      List namesList = (List)Annotations.getValue(annotation, "name", (List)null);
      if (namesList != null) {
         names.addAll(namesList);
      }

      return new LocalVariableDiscriminator(argsOnly, ordinal, index, names, print);
   }

   public static class Context implements PrettyPrinter.IPrettyPrintable {
      final org.spongepowered.asm.mixin.injection.struct.Target target;
      final Type returnType;
      final AbstractInsnNode node;
      final int baseArgIndex;
      final LocalVariableDiscriminator.Context.Local[] locals;
      private final boolean isStatic;

      public Context(Type returnType, boolean argsOnly, org.spongepowered.asm.mixin.injection.struct.Target target, AbstractInsnNode node) {
         this.isStatic = Bytecode.methodIsStatic(target.method);
         this.returnType = returnType;
         this.target = target;
         this.node = node;
         this.baseArgIndex = this.isStatic ? 0 : 1;
         this.locals = this.initLocals(target, argsOnly, node);
         this.initOrdinals();
      }

      private LocalVariableDiscriminator.Context.Local[] initLocals(org.spongepowered.asm.mixin.injection.struct.Target target, boolean argsOnly, AbstractInsnNode node) {
         if (!argsOnly) {
            LocalVariableNode[] locals = Locals.getLocalsAt(target.classNode, target.method, node);
            if (locals != null) {
               LocalVariableDiscriminator.Context.Local[] lvt = new LocalVariableDiscriminator.Context.Local[locals.length];

               for(int l = 0; l < locals.length; ++l) {
                  if (locals[l] != null) {
                     lvt[l] = new LocalVariableDiscriminator.Context.Local(locals[l].name, Type.getType(locals[l].desc));
                  }
               }

               return lvt;
            }
         }

         LocalVariableDiscriminator.Context.Local[] lvt = new LocalVariableDiscriminator.Context.Local[this.baseArgIndex + target.arguments.length];
         if (!this.isStatic) {
            lvt[0] = new LocalVariableDiscriminator.Context.Local("this", Type.getType(target.classNode.name));
         }

         for(int local = this.baseArgIndex; local < lvt.length; ++local) {
            Type arg = target.arguments[local - this.baseArgIndex];
            lvt[local] = new LocalVariableDiscriminator.Context.Local("arg" + local, arg);
         }

         return lvt;
      }

      private void initOrdinals() {
         Map ordinalMap = new HashMap();

         for(int l = 0; l < this.locals.length; ++l) {
            Integer ordinal = Integer.valueOf(0);
            if (this.locals[l] != null) {
               ordinal = (Integer)ordinalMap.get(this.locals[l].type);
               Integer var5;
               ordinalMap.put(this.locals[l].type, var5 = ordinal == null ? 0 : ordinal.intValue() + 1);
               this.locals[l].ord = var5.intValue();
            }
         }

      }

      public void print(PrettyPrinter printer) {
         printer.add("%5s  %7s  %30s  %-50s  %s", "INDEX", "ORDINAL", "TYPE", "NAME", "CANDIDATE");

         for(int l = this.baseArgIndex; l < this.locals.length; ++l) {
            LocalVariableDiscriminator.Context.Local local = this.locals[l];
            if (local != null) {
               Type localType = local.type;
               String localName = local.name;
               int ordinal = local.ord;
               String candidate = this.returnType.equals(localType) ? "YES" : "-";
               printer.add("[%3d]    [%3d]  %30s  %-50s  %s", l, ordinal, SignaturePrinter.getTypeName(localType, false), localName, candidate);
            } else if (l > 0) {
               LocalVariableDiscriminator.Context.Local prevLocal = this.locals[l - 1];
               boolean isTop = prevLocal != null && prevLocal.type != null && prevLocal.type.getSize() > 1;
               printer.add("[%3d]           %30s", l, isTop ? "<top>" : "-");
            }
         }

      }

      public class Local {
         int ord = 0;
         String name;
         Type type;

         public Local(String name, Type type) {
            this.name = name;
            this.type = type;
         }

         public String toString() {
            return String.format("Local[ordinal=%d, name=%s, type=%s]", this.ord, this.name, this.type);
         }
      }
   }
}
