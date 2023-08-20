package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

@InjectionPoint.AtCode("INVOKE_ASSIGN")
public class AfterInvoke extends BeforeInvoke {
   public AfterInvoke(InjectionPointData data) {
      super(data);
   }

   protected boolean addInsn(InsnList insns, Collection nodes, AbstractInsnNode insn) {
      MethodInsnNode methodNode = (MethodInsnNode)insn;
      if (Type.getReturnType(methodNode.desc) == Type.VOID_TYPE) {
         return false;
      } else {
         insn = InjectionPoint.nextNode(insns, insn);
         if (insn instanceof VarInsnNode && insn.getOpcode() >= 54) {
            insn = InjectionPoint.nextNode(insns, insn);
         }

         nodes.add(insn);
         return true;
      }
   }
}
