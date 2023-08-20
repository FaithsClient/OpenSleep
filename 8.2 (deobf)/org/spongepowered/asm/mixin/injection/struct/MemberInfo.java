package org.spongepowered.asm.mixin.injection.struct;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.asm.util.SignaturePrinter;

public final class MemberInfo {
   public final String owner;
   public final String name;
   public final String desc;
   public final boolean matchAll;
   private final boolean forceField;
   private final String unparsed;

   public MemberInfo(String name, boolean matchAll) {
      this(name, (String)null, (String)null, matchAll);
   }

   public MemberInfo(String name, String owner, boolean matchAll) {
      this(name, owner, (String)null, matchAll);
   }

   public MemberInfo(String name, String owner, String desc) {
      this(name, owner, desc, false);
   }

   public MemberInfo(String name, String owner, String desc, boolean matchAll) {
      this(name, owner, desc, matchAll, (String)null);
   }

   public MemberInfo(String name, String owner, String desc, boolean matchAll, String unparsed) {
      if (owner != null && owner.contains(".")) {
         throw new IllegalArgumentException("Attempt to instance a MemberInfo with an invalid owner format");
      } else {
         this.owner = owner;
         this.name = name;
         this.desc = desc;
         this.matchAll = matchAll;
         this.forceField = false;
         this.unparsed = unparsed;
      }
   }

   public MemberInfo(AbstractInsnNode insn) {
      this.matchAll = false;
      this.forceField = false;
      this.unparsed = null;
      if (insn instanceof MethodInsnNode) {
         MethodInsnNode methodNode = (MethodInsnNode)insn;
         this.owner = methodNode.owner;
         this.name = methodNode.name;
         this.desc = methodNode.desc;
      } else {
         if (!(insn instanceof FieldInsnNode)) {
            throw new IllegalArgumentException("insn must be an instance of MethodInsnNode or FieldInsnNode");
         }

         FieldInsnNode fieldNode = (FieldInsnNode)insn;
         this.owner = fieldNode.owner;
         this.name = fieldNode.name;
         this.desc = fieldNode.desc;
      }

   }

   public MemberInfo(IMapping mapping) {
      this.owner = mapping.getOwner();
      this.name = mapping.getSimpleName();
      this.desc = mapping.getDesc();
      this.matchAll = false;
      this.forceField = mapping.getType() == IMapping.Type.FIELD;
      this.unparsed = null;
   }

   private MemberInfo(MemberInfo remapped, MappingMethod method, boolean setOwner) {
      this.owner = setOwner ? method.getOwner() : remapped.owner;
      this.name = method.getSimpleName();
      this.desc = method.getDesc();
      this.matchAll = remapped.matchAll;
      this.forceField = false;
      this.unparsed = null;
   }

   private MemberInfo(MemberInfo original, String owner) {
      this.owner = owner;
      this.name = original.name;
      this.desc = original.desc;
      this.matchAll = original.matchAll;
      this.forceField = original.forceField;
      this.unparsed = null;
   }

   public String toString() {
      String owner = this.owner != null ? "L" + this.owner + ";" : "";
      String name = this.name != null ? this.name : "";
      String qualifier = this.matchAll ? "*" : "";
      String desc = this.desc != null ? this.desc : "";
      String separator = desc.startsWith("(") ? "" : (this.desc != null ? ":" : "");
      return owner + name + qualifier + separator + desc;
   }

   /** @deprecated */
   @Deprecated
   public String toSrg() {
      if (!this.isFullyQualified()) {
         throw new MixinException("Cannot convert unqualified reference to SRG mapping");
      } else {
         return this.desc.startsWith("(") ? this.owner + "/" + this.name + " " + this.desc : this.owner + "/" + this.name;
      }
   }

   public String toDescriptor() {
      return this.desc == null ? "" : (new SignaturePrinter(this)).setFullyQualified(true).toDescriptor();
   }

   public String toCtorType() {
      if (this.unparsed == null) {
         return null;
      } else {
         String returnType = this.getReturnType();
         if (returnType != null) {
            return returnType;
         } else if (this.owner != null) {
            return this.owner;
         } else if (this.name != null && this.desc == null) {
            return this.name;
         } else {
            return this.desc != null ? this.desc : this.unparsed;
         }
      }
   }

   public String toCtorDesc() {
      return this.desc != null && this.desc.startsWith("(") && this.desc.indexOf(41) > -1 ? this.desc.substring(0, this.desc.indexOf(41) + 1) + "V" : null;
   }

   public String getReturnType() {
      if (this.desc != null && this.desc.indexOf(41) != -1 && this.desc.indexOf(40) == 0) {
         String returnType = this.desc.substring(this.desc.indexOf(41) + 1);
         return returnType.startsWith("L") && returnType.endsWith(";") ? returnType.substring(1, returnType.length() - 1) : returnType;
      } else {
         return null;
      }
   }

   public IMapping asMapping() {
      return (IMapping)(this.isField() ? this.asFieldMapping() : this.asMethodMapping());
   }

   public MappingMethod asMethodMapping() {
      if (!this.isFullyQualified()) {
         throw new MixinException("Cannot convert unqualified reference " + this + " to MethodMapping");
      } else if (this.isField()) {
         throw new MixinException("Cannot convert a non-method reference " + this + " to MethodMapping");
      } else {
         return new MappingMethod(this.owner, this.name, this.desc);
      }
   }

   public MappingField asFieldMapping() {
      if (!this.isField()) {
         throw new MixinException("Cannot convert non-field reference " + this + " to FieldMapping");
      } else {
         return new MappingField(this.owner, this.name, this.desc);
      }
   }

   public boolean isFullyQualified() {
      return this.owner != null && this.name != null && this.desc != null;
   }

   public boolean isField() {
      return this.forceField || this.desc != null && !this.desc.startsWith("(");
   }

   public boolean isConstructor() {
      return "<init>".equals(this.name);
   }

   public boolean isClassInitialiser() {
      return "<clinit>".equals(this.name);
   }

   public boolean isInitialiser() {
      return this.isConstructor() || this.isClassInitialiser();
   }

   public MemberInfo validate() throws InvalidMemberDescriptorException {
      if (this.owner != null) {
         if (!this.owner.matches("(?i)^[\\w\\p{Sc}/]+$")) {
            throw new InvalidMemberDescriptorException("Invalid owner: " + this.owner);
         }

         if (this.unparsed != null && this.unparsed.lastIndexOf(46) > 0 && this.owner.startsWith("L")) {
            throw new InvalidMemberDescriptorException("Malformed owner: " + this.owner + " If you are seeing this message unexpectedly and the owner appears to be correct, replace the owner descriptor with formal type L" + this.owner + "; to suppress this error");
         }
      }

      if (this.name != null && !this.name.matches("(?i)^<?[\\w\\p{Sc}]+>?$")) {
         throw new InvalidMemberDescriptorException("Invalid name: " + this.name);
      } else {
         if (this.desc != null) {
            if (!this.desc.matches("^(\\([\\w\\p{Sc}\\[/;]*\\))?\\[*[\\w\\p{Sc}/;]+$")) {
               throw new InvalidMemberDescriptorException("Invalid descriptor: " + this.desc);
            }

            if (this.isField()) {
               if (!this.desc.equals(Type.getType(this.desc).getDescriptor())) {
                  throw new InvalidMemberDescriptorException("Invalid field type in descriptor: " + this.desc);
               }
            } else {
               try {
                  Type.getArgumentTypes(this.desc);
               } catch (Exception var4) {
                  throw new InvalidMemberDescriptorException("Invalid descriptor: " + this.desc);
               }

               String retString = this.desc.substring(this.desc.indexOf(41) + 1);

               try {
                  Type retType = Type.getType(retString);
                  if (!retString.equals(retType.getDescriptor())) {
                     throw new InvalidMemberDescriptorException("Invalid return type \"" + retString + "\" in descriptor: " + this.desc);
                  }
               } catch (Exception var3) {
                  throw new InvalidMemberDescriptorException("Invalid return type \"" + retString + "\" in descriptor: " + this.desc);
               }
            }
         }

         return this;
      }
   }

   public boolean matches(String owner, String name, String desc) {
      return this.matches(owner, name, desc, 0);
   }

   public boolean matches(String owner, String name, String desc, int ordinal) {
      if (this.desc != null && desc != null && !this.desc.equals(desc)) {
         return false;
      } else if (this.name != null && name != null && !this.name.equals(name)) {
         return false;
      } else if (this.owner != null && owner != null && !this.owner.equals(owner)) {
         return false;
      } else {
         return ordinal == 0 || this.matchAll;
      }
   }

   public boolean matches(String name, String desc) {
      return this.matches(name, desc, 0);
   }

   public boolean matches(String name, String desc, int ordinal) {
      return (this.name == null || this.name.equals(name)) && (this.desc == null || desc != null && desc.equals(this.desc)) && (ordinal == 0 || this.matchAll);
   }

   public boolean equals(Object obj) {
      if (obj != null && obj.getClass() == MemberInfo.class) {
         MemberInfo other = (MemberInfo)obj;
         return this.matchAll == other.matchAll && this.forceField == other.forceField && Objects.equal(this.owner, other.owner) && Objects.equal(this.name, other.name) && Objects.equal(this.desc, other.desc);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.matchAll, this.owner, this.name, this.desc});
   }

   public MemberInfo move(String newOwner) {
      return (newOwner != null || this.owner != null) && (newOwner == null || !newOwner.equals(this.owner)) ? new MemberInfo(this, newOwner) : this;
   }

   public MemberInfo transform(String newDesc) {
      return (newDesc != null || this.desc != null) && (newDesc == null || !newDesc.equals(this.desc)) ? new MemberInfo(this.name, this.owner, newDesc, this.matchAll) : this;
   }

   public MemberInfo remapUsing(MappingMethod srgMethod, boolean setOwner) {
      return new MemberInfo(this, srgMethod, setOwner);
   }

   public static MemberInfo parseAndValidate(String string) throws InvalidMemberDescriptorException {
      return parse(string, (IReferenceMapper)null, (String)null).validate();
   }

   public static MemberInfo parseAndValidate(String string, IMixinContext context) throws InvalidMemberDescriptorException {
      return parse(string, context.getReferenceMapper(), context.getClassRef()).validate();
   }

   public static MemberInfo parse(String string) {
      return parse(string, (IReferenceMapper)null, (String)null);
   }

   public static MemberInfo parse(String string, IMixinContext context) {
      return parse(string, context.getReferenceMapper(), context.getClassRef());
   }

   private static MemberInfo parse(String input, IReferenceMapper refMapper, String mixinClass) {
      String desc = null;
      String owner = null;
      String name = Strings.nullToEmpty(input).replaceAll("\\s", "");
      if (refMapper != null) {
         name = refMapper.remap(mixinClass, name);
      }

      int lastDotPos = name.lastIndexOf(46);
      int semiColonPos = name.indexOf(59);
      if (lastDotPos > -1) {
         owner = name.substring(0, lastDotPos).replace('.', '/');
         name = name.substring(lastDotPos + 1);
      } else if (semiColonPos > -1 && name.startsWith("L")) {
         owner = name.substring(1, semiColonPos).replace('.', '/');
         name = name.substring(semiColonPos + 1);
      }

      int parenPos = name.indexOf(40);
      int colonPos = name.indexOf(58);
      if (parenPos > -1) {
         desc = name.substring(parenPos);
         name = name.substring(0, parenPos);
      } else if (colonPos > -1) {
         desc = name.substring(colonPos + 1);
         name = name.substring(0, colonPos);
      }

      if ((name.indexOf(47) > -1 || name.indexOf(46) > -1) && owner == null) {
         owner = name;
         name = "";
      }

      boolean matchAll = name.endsWith("*");
      if (matchAll) {
         name = name.substring(0, name.length() - 1);
      }

      if (name.isEmpty()) {
         name = null;
      }

      return new MemberInfo(name, owner, desc, matchAll, input);
   }

   public static MemberInfo fromMapping(IMapping mapping) {
      return new MemberInfo(mapping);
   }
}
