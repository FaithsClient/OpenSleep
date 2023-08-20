package org.spongepowered.asm.mixin.injection.points;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;

@InjectionPoint.AtCode("NEW")
public class BeforeNew extends InjectionPoint {
   private final String target;
   private final String desc;
   private final int ordinal;

   public BeforeNew(InjectionPointData data) {
      super(data);
      this.ordinal = data.getOrdinal();
      String target = Strings.emptyToNull(data.get("class", data.get("target", "")).replace('.', '/'));
      MemberInfo member = MemberInfo.parseAndValidate(target, data.getContext());
      this.target = member.toCtorType();
      this.desc = member.toCtorDesc();
   }

   public boolean hasDescriptor() {
      return this.desc != null;
   }

   public boolean find(String desc, InsnList insns, Collection nodes) {
      boolean found = false;
      int ordinal = 0;
      Collection newNodes = new ArrayList();
      Collection candidates = this.desc != null ? newNodes : nodes;
      ListIterator iter = insns.iterator();

      while(iter.hasNext()) {
         AbstractInsnNode insn = (AbstractInsnNode)iter.next();
         if (insn instanceof TypeInsnNode && insn.getOpcode() == 187 && this.matchesOwner((TypeInsnNode)insn)) {
            if (this.ordinal == -1 || this.ordinal == ordinal) {
               candidates.add(insn);
               found = this.desc == null;
            }

            ++ordinal;
         }
      }

      if (this.desc != null) {
         for(TypeInsnNode newNode : newNodes) {
            if (this.findCtor(insns, newNode)) {
               nodes.add(newNode);
               found = true;
            }
         }
      }

      return found;
   }

   protected boolean findCtor(InsnList insns, TypeInsnNode newNode) {
      int indexOf = insns.indexOf(newNode);
      Iterator iter = insns.iterator(indexOf);

      while(iter.hasNext()) {
         AbstractInsnNode insn = (AbstractInsnNode)iter.next();
         if (insn instanceof MethodInsnNode && insn.getOpcode() == 183) {
            MethodInsnNode methodNode = (MethodInsnNode)insn;
            if ("<init>".equals(methodNode.name) && methodNode.owner.equals(newNode.desc) && methodNode.desc.equals(this.desc)) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean matchesOwner(TypeInsnNode insn) {
      return this.target == null || this.target.equals(insn.desc);
   }
}
