package org.spongepowered.asm.mixin.injection.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.util.Bytecode;

public abstract class Injector {
   protected static final Logger logger = LogManager.getLogger("mixin");
   protected InjectionInfo info;
   protected final ClassNode classNode;
   protected final MethodNode methodNode;
   protected final Type[] methodArgs;
   protected final Type returnType;
   protected final boolean isStatic;

   public Injector(InjectionInfo info) {
      this(info.getClassNode(), info.getMethod());
      this.info = info;
   }

   private Injector(ClassNode classNode, MethodNode methodNode) {
      this.classNode = classNode;
      this.methodNode = methodNode;
      this.methodArgs = Type.getArgumentTypes(this.methodNode.desc);
      this.returnType = Type.getReturnType(this.methodNode.desc);
      this.isStatic = Bytecode.methodIsStatic(this.methodNode);
   }

   public String toString() {
      return String.format("%s::%s", this.classNode.name, this.methodNode.name);
   }

   public final List find(InjectorTarget injectorTarget, List injectionPoints) {
      this.sanityCheck(injectorTarget.getTarget(), injectionPoints);
      List myNodes = new ArrayList();

      for(Injector.TargetNode node : this.findTargetNodes(injectorTarget, injectionPoints)) {
         this.addTargetNode(injectorTarget.getTarget(), myNodes, node.insn, node.nominators);
      }

      return myNodes;
   }

   protected void addTargetNode(org.spongepowered.asm.mixin.injection.struct.Target target, List myNodes, AbstractInsnNode node, Set nominators) {
      myNodes.add(target.addInjectionNode(node));
   }

   public final void inject(org.spongepowered.asm.mixin.injection.struct.Target target, List nodes) {
      for(InjectionNodes.InjectionNode node : nodes) {
         if (node.isRemoved()) {
            if (this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
               logger.warn("ft.sleep.module.modules.Target node for {} was removed by a previous injector in {}", new Object[]{this.info, target});
            }
         } else {
            this.inject(target, node);
         }
      }

      for(InjectionNodes.InjectionNode node : nodes) {
         this.postInject(target, node);
      }

   }

   private Collection findTargetNodes(InjectorTarget injectorTarget, List injectionPoints) {
      IMixinContext mixin = this.info.getContext();
      MethodNode method = injectorTarget.getMethod();
      Map targetNodes = new TreeMap();
      Collection nodes = new ArrayList(32);

      for(InjectionPoint injectionPoint : injectionPoints) {
         nodes.clear();
         if (injectorTarget.isMerged() && !mixin.getClassName().equals(injectorTarget.getMergedBy()) && !injectionPoint.checkPriority(injectorTarget.getMergedPriority(), mixin.getPriority())) {
            throw new InvalidInjectionException(this.info, String.format("%s on %s with priority %d cannot inject into %s merged by %s with priority %d", injectionPoint, this, mixin.getPriority(), injectorTarget, injectorTarget.getMergedBy(), injectorTarget.getMergedPriority()));
         }

         if (this.findTargetNodes(method, injectionPoint, injectorTarget.getSlice(injectionPoint), nodes)) {
            for(AbstractInsnNode insn : nodes) {
               Integer key = method.instructions.indexOf(insn);
               Injector.TargetNode targetNode = (Injector.TargetNode)targetNodes.get(key);
               if (targetNode == null) {
                  targetNode = new Injector.TargetNode(insn);
                  targetNodes.put(key, targetNode);
               }

               targetNode.nominators.add(injectionPoint);
            }
         }
      }

      return targetNodes.values();
   }

   protected boolean findTargetNodes(MethodNode into, InjectionPoint injectionPoint, InsnList insns, Collection nodes) {
      return injectionPoint.find(into.desc, insns, nodes);
   }

   protected void sanityCheck(org.spongepowered.asm.mixin.injection.struct.Target target, List injectionPoints) {
      if (target.classNode != this.classNode) {
         throw new InvalidInjectionException(this.info, "ft.sleep.module.modules.Target class does not match injector class in " + this);
      }
   }

   protected abstract void inject(org.spongepowered.asm.mixin.injection.struct.Target var1, InjectionNodes.InjectionNode var2);

   protected void postInject(org.spongepowered.asm.mixin.injection.struct.Target target, InjectionNodes.InjectionNode node) {
   }

   protected AbstractInsnNode invokeHandler(InsnList insns) {
      return this.invokeHandler(insns, this.methodNode);
   }

   protected AbstractInsnNode invokeHandler(InsnList insns, MethodNode handler) {
      boolean isPrivate = (handler.access & 2) != 0;
      int invokeOpcode = this.isStatic ? 184 : (isPrivate ? 183 : 182);
      MethodInsnNode insn = new MethodInsnNode(invokeOpcode, this.classNode.name, handler.name, handler.desc, false);
      insns.add(insn);
      this.info.addCallbackInvocation(handler);
      return insn;
   }

   protected void throwException(InsnList insns, String exceptionType, String message) {
      insns.add(new TypeInsnNode(187, exceptionType));
      insns.add(new InsnNode(89));
      insns.add(new LdcInsnNode(message));
      insns.add(new MethodInsnNode(183, exceptionType, "<init>", "(Ljava/lang/String;)V", false));
      insns.add(new InsnNode(191));
   }

   public static boolean canCoerce(Type from, Type to) {
      return from.getSort() == 10 && to.getSort() == 10 ? canCoerce(ClassInfo.forType(from), ClassInfo.forType(to)) : canCoerce(from.getDescriptor(), to.getDescriptor());
   }

   public static boolean canCoerce(String from, String to) {
      return from.length() <= 1 && to.length() <= 1 ? canCoerce(from.charAt(0), to.charAt(0)) : false;
   }

   public static boolean canCoerce(char from, char to) {
      return to == 'I' && "IBSCZ".indexOf(from) > -1;
   }

   private static boolean canCoerce(ClassInfo from, ClassInfo to) {
      return from != null && to != null && (to == from || to.hasSuperClass(from));
   }

   public static final class TargetNode {
      final AbstractInsnNode insn;
      final Set nominators = new HashSet();

      TargetNode(AbstractInsnNode insn) {
         this.insn = insn;
      }

      public AbstractInsnNode getNode() {
         return this.insn;
      }

      public Set getNominators() {
         return Collections.unmodifiableSet(this.nominators);
      }

      public boolean equals(Object obj) {
         if (obj != null && obj.getClass() == Injector.TargetNode.class) {
            return ((Injector.TargetNode)obj).insn == this.insn;
         } else {
            return false;
         }
      }

      public int hashCode() {
         return this.insn.hashCode();
      }
   }
}
