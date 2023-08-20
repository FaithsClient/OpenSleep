package org.spongepowered.asm.mixin.injection.invoke;

import java.util.Arrays;
import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.util.Bytecode;

public class ModifyArgInjector extends InvokeInjector {
   private final int index;
   private final boolean singleArgMode;

   public ModifyArgInjector(InjectionInfo info, int index) {
      super(info, "@ModifyArg");
      this.index = index;
      this.singleArgMode = this.methodArgs.length == 1;
   }

   protected void sanityCheck(org.spongepowered.asm.mixin.injection.struct.Target target, List injectionPoints) {
      super.sanityCheck(target, injectionPoints);
      if (this.singleArgMode && !this.methodArgs[0].equals(this.returnType)) {
         throw new InvalidInjectionException(this.info, "@ModifyArg return type on " + this + " must match the parameter type. ARG=" + this.methodArgs[0] + " RETURN=" + this.returnType);
      }
   }

   protected void checkTarget(org.spongepowered.asm.mixin.injection.struct.Target target) {
      if (!this.isStatic && target.isStatic) {
         throw new InvalidInjectionException(this.info, "non-static callback method " + this + " targets a static method which is not supported");
      }
   }

   protected void inject(org.spongepowered.asm.mixin.injection.struct.Target target, InjectionNodes.InjectionNode node) {
      this.checkTargetForNode(target, node);
      super.inject(target, node);
   }

   protected void injectAtInvoke(org.spongepowered.asm.mixin.injection.struct.Target target, InjectionNodes.InjectionNode node) {
      MethodInsnNode methodNode = (MethodInsnNode)node.getCurrentTarget();
      Type[] args = Type.getArgumentTypes(methodNode.desc);
      int argIndex = this.findArgIndex(target, args);
      InsnList insns = new InsnList();
      int extraLocals = 0;
      if (this.singleArgMode) {
         extraLocals = this.injectSingleArgHandler(target, args, argIndex, insns);
      } else {
         extraLocals = this.injectMultiArgHandler(target, args, argIndex, insns);
      }

      target.insns.insertBefore(methodNode, insns);
      target.addToLocals(extraLocals);
      target.addToStack(2 - (extraLocals - 1));
   }

   private int injectSingleArgHandler(org.spongepowered.asm.mixin.injection.struct.Target target, Type[] args, int argIndex, InsnList insns) {
      int[] argMap = this.storeArgs(target, args, insns, argIndex);
      this.invokeHandlerWithArgs(args, insns, argMap, argIndex, argIndex + 1);
      this.pushArgs(args, insns, argMap, argIndex + 1, args.length);
      return argMap[argMap.length - 1] - target.getMaxLocals() + args[args.length - 1].getSize();
   }

   private int injectMultiArgHandler(org.spongepowered.asm.mixin.injection.struct.Target target, Type[] args, int argIndex, InsnList insns) {
      if (!Arrays.equals(args, this.methodArgs)) {
         throw new InvalidInjectionException(this.info, "@ModifyArg method " + this + " targets a method with an invalid signature " + Bytecode.getDescriptor(args) + ", expected " + Bytecode.getDescriptor(this.methodArgs));
      } else {
         int[] argMap = this.storeArgs(target, args, insns, 0);
         this.pushArgs(args, insns, argMap, 0, argIndex);
         this.invokeHandlerWithArgs(args, insns, argMap, 0, args.length);
         this.pushArgs(args, insns, argMap, argIndex + 1, args.length);
         return argMap[argMap.length - 1] - target.getMaxLocals() + args[args.length - 1].getSize();
      }
   }

   protected int findArgIndex(org.spongepowered.asm.mixin.injection.struct.Target target, Type[] args) {
      if (this.index > -1) {
         if (this.index < args.length && args[this.index].equals(this.returnType)) {
            return this.index;
         } else {
            throw new InvalidInjectionException(this.info, "Specified index " + this.index + " for @ModifyArg is invalid for args " + Bytecode.getDescriptor(args) + ", expected " + this.returnType + " on " + this);
         }
      } else {
         int argIndex = -1;

         for(int arg = 0; arg < args.length; ++arg) {
            if (args[arg].equals(this.returnType)) {
               if (argIndex != -1) {
                  throw new InvalidInjectionException(this.info, "Found duplicate args with index [" + argIndex + ", " + arg + "] matching type " + this.returnType + " for @ModifyArg target " + target + " in " + this + ". Please specify index of desired arg.");
               }

               argIndex = arg;
            }
         }

         if (argIndex == -1) {
            throw new InvalidInjectionException(this.info, "Could not find arg matching type " + this.returnType + " for @ModifyArg target " + target + " in " + this);
         } else {
            return argIndex;
         }
      }
   }
}
