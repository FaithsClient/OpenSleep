package org.spongepowered.asm.mixin.injection.modify;

import java.util.Collection;
import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.SignaturePrinter;

public class ModifyVariableInjector extends Injector {
   private final LocalVariableDiscriminator discriminator;

   public ModifyVariableInjector(InjectionInfo info, LocalVariableDiscriminator discriminator) {
      super(info);
      this.discriminator = discriminator;
   }

   protected boolean findTargetNodes(MethodNode into, InjectionPoint injectionPoint, InsnList insns, Collection nodes) {
      if (injectionPoint instanceof ModifyVariableInjector.ContextualInjectionPoint) {
         org.spongepowered.asm.mixin.injection.struct.Target target = this.info.getContext().getTargetMethod(into);
         return ((ModifyVariableInjector.ContextualInjectionPoint)injectionPoint).find(target, nodes);
      } else {
         return injectionPoint.find(into.desc, insns, nodes);
      }
   }

   protected void sanityCheck(org.spongepowered.asm.mixin.injection.struct.Target target, List injectionPoints) {
      super.sanityCheck(target, injectionPoints);
      if (target.isStatic != this.isStatic) {
         throw new InvalidInjectionException(this.info, "'static' of variable modifier method does not match target in " + this);
      } else {
         int ordinal = this.discriminator.getOrdinal();
         if (ordinal < -1) {
            throw new InvalidInjectionException(this.info, "Invalid ordinal " + ordinal + " specified in " + this);
         } else if (this.discriminator.getIndex() == 0 && !this.isStatic) {
            throw new InvalidInjectionException(this.info, "Invalid index 0 specified in non-static variable modifier " + this);
         }
      }
   }

   protected void inject(org.spongepowered.asm.mixin.injection.struct.Target target, InjectionNodes.InjectionNode node) {
      if (node.isReplaced()) {
         throw new InvalidInjectionException(this.info, "Variable modifier target for " + this + " was removed by another injector");
      } else {
         ModifyVariableInjector.Context context = new ModifyVariableInjector.Context(this.returnType, this.discriminator.isArgsOnly(), target, node.getCurrentTarget());
         if (this.discriminator.printLVT()) {
            this.printLocals(context);
         }

         String handlerDesc = Bytecode.getDescriptor(new Type[]{this.returnType}, this.returnType);
         if (!handlerDesc.equals(this.methodNode.desc)) {
            throw new InvalidInjectionException(this.info, "Variable modifier " + this + " has an invalid signature, expected " + handlerDesc + " but found " + this.methodNode.desc);
         } else {
            try {
               int local = this.discriminator.findLocal(context);
               if (local > -1) {
                  this.inject(context, local);
               }
            } catch (InvalidImplicitDiscriminatorException var6) {
               if (this.discriminator.printLVT()) {
                  this.info.addCallbackInvocation(this.methodNode);
                  return;
               }

               throw new InvalidInjectionException(this.info, "Implicit variable modifier injection failed in " + this, var6);
            }

            target.insns.insertBefore(context.node, context.insns);
            target.addToStack(this.isStatic ? 1 : 2);
         }
      }
   }

   private void printLocals(ModifyVariableInjector.Context context) {
      SignaturePrinter handlerSig = new SignaturePrinter(this.methodNode.name, this.returnType, this.methodArgs, new String[]{"var"});
      handlerSig.setModifiers(this.methodNode);
      (new PrettyPrinter()).kvWidth(20).kv("ft.sleep.module.modules.Target Class", this.classNode.name.replace('/', '.')).kv("ft.sleep.module.modules.Target Method", context.target.method.name).kv("Callback Name", this.methodNode.name).kv("Capture Type", SignaturePrinter.getTypeName(this.returnType, false)).kv("Instruction", "%s %s", context.node.getClass().getSimpleName(), Bytecode.getOpcodeName(context.node.getOpcode())).hr().kv("Match mode", this.discriminator.isImplicit(context) ? "IMPLICIT (match single)" : "EXPLICIT (match by criteria)").kv("Match ordinal", this.discriminator.getOrdinal() < 0 ? "any" : this.discriminator.getOrdinal()).kv("Match index", this.discriminator.getIndex() < context.baseArgIndex ? "any" : this.discriminator.getIndex()).kv("Match name(s)", this.discriminator.hasNames() ? this.discriminator.getNames() : "any").kv("Args only", Boolean.valueOf(this.discriminator.isArgsOnly())).hr().add((PrettyPrinter.IPrettyPrintable)context).print(System.err);
   }

   private void inject(ModifyVariableInjector.Context context, int local) {
      if (!this.isStatic) {
         context.insns.add(new VarInsnNode(25, 0));
      }

      context.insns.add(new VarInsnNode(this.returnType.getOpcode(21), local));
      this.invokeHandler(context.insns);
      context.insns.add(new VarInsnNode(this.returnType.getOpcode(54), local));
   }

   static class Context extends LocalVariableDiscriminator.Context {
      final InsnList insns = new InsnList();

      public Context(Type returnType, boolean argsOnly, org.spongepowered.asm.mixin.injection.struct.Target target, AbstractInsnNode node) {
         super(returnType, argsOnly, target, node);
      }
   }

   abstract static class ContextualInjectionPoint extends InjectionPoint {
      protected final IMixinContext context;

      ContextualInjectionPoint(IMixinContext context) {
         this.context = context;
      }

      public boolean find(String desc, InsnList insns, Collection nodes) {
         throw new InvalidInjectionException(this.context, this.getAtCode() + " injection point must be used in conjunction with @ModifyVariable");
      }

      abstract boolean find(org.spongepowered.asm.mixin.injection.struct.Target var1, Collection var2);
   }
}
