package org.spongepowered.tools.obfuscation.mirror;

import com.google.common.base.Strings;
import javax.lang.model.element.ExecutableElement;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mirror.mapping.ResolvableMappingMethod;

public class MethodHandle extends MemberHandle {
   private final ExecutableElement element;
   private final TypeHandle ownerHandle;

   public MethodHandle(TypeHandle owner, ExecutableElement element) {
      this(owner, element, TypeUtils.getName(element), TypeUtils.getDescriptor(element));
   }

   public MethodHandle(TypeHandle owner, String name, String desc) {
      this(owner, (ExecutableElement)null, name, desc);
   }

   private MethodHandle(TypeHandle owner, ExecutableElement element, String name, String desc) {
      super(owner != null ? owner.getName() : null, name, desc);
      this.element = element;
      this.ownerHandle = owner;
   }

   public boolean isImaginary() {
      return this.element == null;
   }

   public ExecutableElement getElement() {
      return this.element;
   }

   public Visibility getVisibility() {
      return TypeUtils.getVisibility(this.element);
   }

   public MappingMethod asMapping(boolean includeOwner) {
      if (includeOwner) {
         return (MappingMethod)(this.ownerHandle != null ? new ResolvableMappingMethod(this.ownerHandle, this.getName(), this.getDesc()) : new MappingMethod(this.getOwner(), this.getName(), this.getDesc()));
      } else {
         return new MappingMethod((String)null, this.getName(), this.getDesc());
      }
   }

   public String toString() {
      String owner = this.getOwner() != null ? "L" + this.getOwner() + ";" : "";
      String name = Strings.nullToEmpty(this.getName());
      String desc = Strings.nullToEmpty(this.getDesc());
      return String.format("%s%s%s", owner, name, desc);
   }
}
