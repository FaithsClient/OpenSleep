package org.spongepowered.asm.mixin.injection.invoke;

import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;

public abstract class InvokeInjector extends Injector {
   protected final String annotationType;

   public InvokeInjector(InjectionInfo info, String annotationType) {
      super(info);
      this.annotationType = annotationType;
   }

   protected void sanityCheck(org.spongepowered.asm.mixin.injection.struct.Target target, List injectionPoints) {
      super.sanityCheck(target, injectionPoints);
      this.checkTarget(target);
   }

   protected void checkTarget(org.spongepowered.asm.mixin.injection.struct.Target target) {
      this.checkTargetModifiers(target, true);
   }

   protected final void checkTargetModifiers(org.spongepowered.asm.mixin.injection.struct.Target target, boolean exactMatch) {
      if (exactMatch && target.isStatic != this.isStatic) {
         throw new InvalidInjectionException(this.info, "'static' modifier of handler method does not match target in " + this);
      } else if (!exactMatch && !this.isStatic && target.isStatic) {
         throw new InvalidInjectionException(this.info, "non-static callback method " + this + " targets a static method which is not supported");
      }
   }

   protected void checkTargetForNode(org.spongepowered.asm.mixin.injection.struct.Target target, InjectionNodes.InjectionNode node) {
      if (target.isCtor) {
         MethodInsnNode superCall = target.findSuperInitNode();
         int superCallIndex = target.indexOf(superCall);
         int targetIndex = target.indexOf(node.getCurrentTarget());
         if (targetIndex <= superCallIndex) {
            if (!this.isStatic) {
               throw new InvalidInjectionException(this.info, "Pre-super " + this.annotationType + " invocation must be static in " + this);
            }

            return;
         }
      }

      this.checkTargetModifiers(target, true);
   }

   protected void inject(org.spongepowered.asm.mixin.injection.struct.Target target, InjectionNodes.InjectionNode node) {
      if (!(node.getCurrentTarget() instanceof MethodInsnNode)) {
         throw new InvalidInjectionException(this.info, this.annotationType + " annotation on is targetting a non-method insn in " + target + " in " + this);
      } else {
         this.injectAtInvoke(target, node);
      }
   }

   protected abstract void injectAtInvoke(org.spongepowered.asm.mixin.injection.struct.Target var1, InjectionNodes.InjectionNode var2);

   protected AbstractInsnNode invokeHandlerWithArgs(Type[] args, InsnList insns, int[] argMap) {
      return this.invokeHandlerWithArgs(args, insns, argMap, 0, args.length);
   }

   protected AbstractInsnNode invokeHandlerWithArgs(Type[] args, InsnList insns, int[] argMap, int startArg, int endArg) {
      if (!this.isStatic) {
         insns.add(new VarInsnNode(25, 0));
      }

      this.pushArgs(args, insns, argMap, startArg, endArg);
      return this.invokeHandler(insns);
   }

   protected int[] storeArgs(org.spongepowered.asm.mixin.injection.struct.Target target, Type[] args, InsnList insns, int start) {
      int[] argMap = target.generateArgMap(args, start);
      this.storeArgs(args, insns, argMap, start, args.length);
      return argMap;
   }

   protected void storeArgs(Type[] args, InsnList insns, int[] argMap, int start, int end) {
      for(int arg = end - 1; arg >= start; --arg) {
         insns.add(new VarInsnNode(args[arg].getOpcode(54), argMap[arg]));
      }

   }

   protected void pushArgs(Type[] args, InsnList insns, int[] argMap, int start, int end) {
      for(int arg = start; arg < end; ++arg) {
         insns.add(new VarInsnNode(args[arg].getOpcode(21), argMap[arg]));
      }

   }
}
