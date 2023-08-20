package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;

public class MethodNode extends MethodVisitor {
   public int access;
   public String name;
   public String desc;
   public String signature;
   public List exceptions;
   public List parameters;
   public List visibleAnnotations;
   public List invisibleAnnotations;
   public List visibleTypeAnnotations;
   public List invisibleTypeAnnotations;
   public List attrs;
   public Object annotationDefault;
   public List[] visibleParameterAnnotations;
   public List[] invisibleParameterAnnotations;
   public InsnList instructions;
   public List tryCatchBlocks;
   public int maxStack;
   public int maxLocals;
   public List localVariables;
   public List visibleLocalVariableAnnotations;
   public List invisibleLocalVariableAnnotations;
   private boolean visited;

   public MethodNode() {
      this(327680);
      if (this.getClass() != MethodNode.class) {
         throw new IllegalStateException();
      }
   }

   public MethodNode(int api) {
      super(api);
      this.instructions = new InsnList();
   }

   public MethodNode(int access, String name, String desc, String signature, String[] exceptions) {
      this(327680, access, name, desc, signature, exceptions);
      if (this.getClass() != MethodNode.class) {
         throw new IllegalStateException();
      }
   }

   public MethodNode(int api, int access, String name, String desc, String signature, String[] exceptions) {
      super(api);
      this.access = access;
      this.name = name;
      this.desc = desc;
      this.signature = signature;
      this.exceptions = new ArrayList(exceptions == null ? 0 : exceptions.length);
      boolean isAbstract = (access & 1024) != 0;
      if (!isAbstract) {
         this.localVariables = new ArrayList(5);
      }

      this.tryCatchBlocks = new ArrayList();
      if (exceptions != null) {
         this.exceptions.addAll(Arrays.asList(exceptions));
      }

      this.instructions = new InsnList();
   }

   public void visitParameter(String name, int access) {
      if (this.parameters == null) {
         this.parameters = new ArrayList(5);
      }

      this.parameters.add(new ParameterNode(name, access));
   }

   public AnnotationVisitor visitAnnotationDefault() {
      return new AnnotationNode(new ArrayList(0) {
         public boolean add(Object o) {
            MethodNode.this.annotationDefault = o;
            return super.add(o);
         }
      });
   }

   public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
      AnnotationNode an = new AnnotationNode(desc);
      if (visible) {
         if (this.visibleAnnotations == null) {
            this.visibleAnnotations = new ArrayList(1);
         }

         this.visibleAnnotations.add(an);
      } else {
         if (this.invisibleAnnotations == null) {
            this.invisibleAnnotations = new ArrayList(1);
         }

         this.invisibleAnnotations.add(an);
      }

      return an;
   }

   public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
      TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc);
      if (visible) {
         if (this.visibleTypeAnnotations == null) {
            this.visibleTypeAnnotations = new ArrayList(1);
         }

         this.visibleTypeAnnotations.add(an);
      } else {
         if (this.invisibleTypeAnnotations == null) {
            this.invisibleTypeAnnotations = new ArrayList(1);
         }

         this.invisibleTypeAnnotations.add(an);
      }

      return an;
   }

   public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
      AnnotationNode an = new AnnotationNode(desc);
      if (visible) {
         if (this.visibleParameterAnnotations == null) {
            int params = Type.getArgumentTypes(this.desc).length;
            this.visibleParameterAnnotations = new List[params];
         }

         if (this.visibleParameterAnnotations[parameter] == null) {
            this.visibleParameterAnnotations[parameter] = new ArrayList(1);
         }

         this.visibleParameterAnnotations[parameter].add(an);
      } else {
         if (this.invisibleParameterAnnotations == null) {
            int params = Type.getArgumentTypes(this.desc).length;
            this.invisibleParameterAnnotations = new List[params];
         }

         if (this.invisibleParameterAnnotations[parameter] == null) {
            this.invisibleParameterAnnotations[parameter] = new ArrayList(1);
         }

         this.invisibleParameterAnnotations[parameter].add(an);
      }

      return an;
   }

   public void visitAttribute(Attribute attr) {
      if (this.attrs == null) {
         this.attrs = new ArrayList(1);
      }

      this.attrs.add(attr);
   }

   public void visitCode() {
   }

   public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
      this.instructions.add(new FrameNode(type, nLocal, local == null ? null : this.getLabelNodes(local), nStack, stack == null ? null : this.getLabelNodes(stack)));
   }

   public void visitInsn(int opcode) {
      this.instructions.add(new InsnNode(opcode));
   }

   public void visitIntInsn(int opcode, int operand) {
      this.instructions.add(new IntInsnNode(opcode, operand));
   }

   public void visitVarInsn(int opcode, int var) {
      this.instructions.add(new VarInsnNode(opcode, var));
   }

   public void visitTypeInsn(int opcode, String type) {
      this.instructions.add(new TypeInsnNode(opcode, type));
   }

   public void visitFieldInsn(int opcode, String owner, String name, String desc) {
      this.instructions.add(new FieldInsnNode(opcode, owner, name, desc));
   }

   /** @deprecated */
   @Deprecated
   public void visitMethodInsn(int opcode, String owner, String name, String desc) {
      if (this.api >= 327680) {
         super.visitMethodInsn(opcode, owner, name, desc);
      } else {
         this.instructions.add(new MethodInsnNode(opcode, owner, name, desc));
      }
   }

   public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
      if (this.api < 327680) {
         super.visitMethodInsn(opcode, owner, name, desc, itf);
      } else {
         this.instructions.add(new MethodInsnNode(opcode, owner, name, desc, itf));
      }
   }

   public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
      this.instructions.add(new InvokeDynamicInsnNode(name, desc, bsm, bsmArgs));
   }

   public void visitJumpInsn(int opcode, Label label) {
      this.instructions.add(new JumpInsnNode(opcode, this.getLabelNode(label)));
   }

   public void visitLabel(Label label) {
      this.instructions.add(this.getLabelNode(label));
   }

   public void visitLdcInsn(Object cst) {
      this.instructions.add(new LdcInsnNode(cst));
   }

   public void visitIincInsn(int var, int increment) {
      this.instructions.add(new IincInsnNode(var, increment));
   }

   public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
      this.instructions.add(new TableSwitchInsnNode(min, max, this.getLabelNode(dflt), this.getLabelNodes(labels)));
   }

   public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
      this.instructions.add(new LookupSwitchInsnNode(this.getLabelNode(dflt), keys, this.getLabelNodes(labels)));
   }

   public void visitMultiANewArrayInsn(String desc, int dims) {
      this.instructions.add(new MultiANewArrayInsnNode(desc, dims));
   }

   public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
      AbstractInsnNode insn;
      for(insn = this.instructions.getLast(); insn.getOpcode() == -1; insn = insn.getPrevious()) {
         ;
      }

      TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc);
      if (visible) {
         if (insn.visibleTypeAnnotations == null) {
            insn.visibleTypeAnnotations = new ArrayList(1);
         }

         insn.visibleTypeAnnotations.add(an);
      } else {
         if (insn.invisibleTypeAnnotations == null) {
            insn.invisibleTypeAnnotations = new ArrayList(1);
         }

         insn.invisibleTypeAnnotations.add(an);
      }

      return an;
   }

   public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
      this.tryCatchBlocks.add(new TryCatchBlockNode(this.getLabelNode(start), this.getLabelNode(end), this.getLabelNode(handler), type));
   }

   public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
      TryCatchBlockNode tcb = (TryCatchBlockNode)this.tryCatchBlocks.get((typeRef & 16776960) >> 8);
      TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc);
      if (visible) {
         if (tcb.visibleTypeAnnotations == null) {
            tcb.visibleTypeAnnotations = new ArrayList(1);
         }

         tcb.visibleTypeAnnotations.add(an);
      } else {
         if (tcb.invisibleTypeAnnotations == null) {
            tcb.invisibleTypeAnnotations = new ArrayList(1);
         }

         tcb.invisibleTypeAnnotations.add(an);
      }

      return an;
   }

   public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
      this.localVariables.add(new LocalVariableNode(name, desc, signature, this.getLabelNode(start), this.getLabelNode(end), index));
   }

   public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
      LocalVariableAnnotationNode an = new LocalVariableAnnotationNode(typeRef, typePath, this.getLabelNodes(start), this.getLabelNodes(end), index, desc);
      if (visible) {
         if (this.visibleLocalVariableAnnotations == null) {
            this.visibleLocalVariableAnnotations = new ArrayList(1);
         }

         this.visibleLocalVariableAnnotations.add(an);
      } else {
         if (this.invisibleLocalVariableAnnotations == null) {
            this.invisibleLocalVariableAnnotations = new ArrayList(1);
         }

         this.invisibleLocalVariableAnnotations.add(an);
      }

      return an;
   }

   public void visitLineNumber(int line, Label start) {
      this.instructions.add(new LineNumberNode(line, this.getLabelNode(start)));
   }

   public void visitMaxs(int maxStack, int maxLocals) {
      this.maxStack = maxStack;
      this.maxLocals = maxLocals;
   }

   public void visitEnd() {
   }

   protected LabelNode getLabelNode(Label l) {
      if (!(l.info instanceof LabelNode)) {
         l.info = new LabelNode();
      }

      return (LabelNode)l.info;
   }

   private LabelNode[] getLabelNodes(Label[] l) {
      LabelNode[] nodes = new LabelNode[l.length];

      for(int i = 0; i < l.length; ++i) {
         nodes[i] = this.getLabelNode(l[i]);
      }

      return nodes;
   }

   private Object[] getLabelNodes(Object[] objs) {
      Object[] nodes = new Object[objs.length];

      for(int i = 0; i < objs.length; ++i) {
         Object o = objs[i];
         if (o instanceof Label) {
            o = this.getLabelNode((Label)o);
         }

         nodes[i] = o;
      }

      return nodes;
   }

   public void check(int api) {
      if (api == 262144) {
         if (this.visibleTypeAnnotations != null && this.visibleTypeAnnotations.size() > 0) {
            throw new RuntimeException();
         }

         if (this.invisibleTypeAnnotations != null && this.invisibleTypeAnnotations.size() > 0) {
            throw new RuntimeException();
         }

         int n = this.tryCatchBlocks == null ? 0 : this.tryCatchBlocks.size();

         for(int i = 0; i < n; ++i) {
            TryCatchBlockNode tcb = (TryCatchBlockNode)this.tryCatchBlocks.get(i);
            if (tcb.visibleTypeAnnotations != null && tcb.visibleTypeAnnotations.size() > 0) {
               throw new RuntimeException();
            }

            if (tcb.invisibleTypeAnnotations != null && tcb.invisibleTypeAnnotations.size() > 0) {
               throw new RuntimeException();
            }
         }

         for(int i = 0; i < this.instructions.size(); ++i) {
            AbstractInsnNode insn = this.instructions.get(i);
            if (insn.visibleTypeAnnotations != null && insn.visibleTypeAnnotations.size() > 0) {
               throw new RuntimeException();
            }

            if (insn.invisibleTypeAnnotations != null && insn.invisibleTypeAnnotations.size() > 0) {
               throw new RuntimeException();
            }

            if (insn instanceof MethodInsnNode) {
               boolean itf = ((MethodInsnNode)insn).itf;
               if (itf != (insn.opcode == 185)) {
                  throw new RuntimeException();
               }
            }
         }

         if (this.visibleLocalVariableAnnotations != null && this.visibleLocalVariableAnnotations.size() > 0) {
            throw new RuntimeException();
         }

         if (this.invisibleLocalVariableAnnotations != null && this.invisibleLocalVariableAnnotations.size() > 0) {
            throw new RuntimeException();
         }
      }

   }

   public void accept(ClassVisitor cv) {
      String[] exceptions = new String[this.exceptions.size()];
      this.exceptions.toArray(exceptions);
      MethodVisitor mv = cv.visitMethod(this.access, this.name, this.desc, this.signature, exceptions);
      if (mv != null) {
         this.accept(mv);
      }

   }

   public void accept(MethodVisitor mv) {
      int n = this.parameters == null ? 0 : this.parameters.size();

      for(int i = 0; i < n; ++i) {
         ParameterNode parameter = (ParameterNode)this.parameters.get(i);
         mv.visitParameter(parameter.name, parameter.access);
      }

      if (this.annotationDefault != null) {
         AnnotationVisitor av = mv.visitAnnotationDefault();
         AnnotationNode.accept(av, (String)null, this.annotationDefault);
         if (av != null) {
            av.visitEnd();
         }
      }

      n = this.visibleAnnotations == null ? 0 : this.visibleAnnotations.size();

      for(int var18 = 0; var18 < n; ++var18) {
         AnnotationNode an = (AnnotationNode)this.visibleAnnotations.get(var18);
         an.accept(mv.visitAnnotation(an.desc, true));
      }

      n = this.invisibleAnnotations == null ? 0 : this.invisibleAnnotations.size();

      for(int var19 = 0; var19 < n; ++var19) {
         AnnotationNode an = (AnnotationNode)this.invisibleAnnotations.get(var19);
         an.accept(mv.visitAnnotation(an.desc, false));
      }

      n = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();

      for(int var20 = 0; var20 < n; ++var20) {
         TypeAnnotationNode an = (TypeAnnotationNode)this.visibleTypeAnnotations.get(var20);
         an.accept(mv.visitTypeAnnotation(an.typeRef, an.typePath, an.desc, true));
      }

      n = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();

      for(int var21 = 0; var21 < n; ++var21) {
         TypeAnnotationNode an = (TypeAnnotationNode)this.invisibleTypeAnnotations.get(var21);
         an.accept(mv.visitTypeAnnotation(an.typeRef, an.typePath, an.desc, false));
      }

      n = this.visibleParameterAnnotations == null ? 0 : this.visibleParameterAnnotations.length;

      for(int var22 = 0; var22 < n; ++var22) {
         List l = this.visibleParameterAnnotations[var22];
         if (l != null) {
            for(int j = 0; j < l.size(); ++j) {
               AnnotationNode an = (AnnotationNode)l.get(j);
               an.accept(mv.visitParameterAnnotation(var22, an.desc, true));
            }
         }
      }

      n = this.invisibleParameterAnnotations == null ? 0 : this.invisibleParameterAnnotations.length;

      for(int var23 = 0; var23 < n; ++var23) {
         List l = this.invisibleParameterAnnotations[var23];
         if (l != null) {
            for(int j = 0; j < l.size(); ++j) {
               AnnotationNode an = (AnnotationNode)l.get(j);
               an.accept(mv.visitParameterAnnotation(var23, an.desc, false));
            }
         }
      }

      if (this.visited) {
         this.instructions.resetLabels();
      }

      n = this.attrs == null ? 0 : this.attrs.size();

      for(int var24 = 0; var24 < n; ++var24) {
         mv.visitAttribute((Attribute)this.attrs.get(var24));
      }

      if (this.instructions.size() > 0) {
         mv.visitCode();
         n = this.tryCatchBlocks == null ? 0 : this.tryCatchBlocks.size();

         for(int var25 = 0; var25 < n; ++var25) {
            ((TryCatchBlockNode)this.tryCatchBlocks.get(var25)).updateIndex(var25);
            ((TryCatchBlockNode)this.tryCatchBlocks.get(var25)).accept(mv);
         }

         this.instructions.accept(mv);
         n = this.localVariables == null ? 0 : this.localVariables.size();

         for(int var26 = 0; var26 < n; ++var26) {
            ((LocalVariableNode)this.localVariables.get(var26)).accept(mv);
         }

         n = this.visibleLocalVariableAnnotations == null ? 0 : this.visibleLocalVariableAnnotations.size();

         for(int var27 = 0; var27 < n; ++var27) {
            ((LocalVariableAnnotationNode)this.visibleLocalVariableAnnotations.get(var27)).accept(mv, true);
         }

         n = this.invisibleLocalVariableAnnotations == null ? 0 : this.invisibleLocalVariableAnnotations.size();

         for(int var28 = 0; var28 < n; ++var28) {
            ((LocalVariableAnnotationNode)this.invisibleLocalVariableAnnotations.get(var28)).accept(mv, false);
         }

         mv.visitMaxs(this.maxStack, this.maxLocals);
         this.visited = true;
      }

      mv.visitEnd();
   }
}
