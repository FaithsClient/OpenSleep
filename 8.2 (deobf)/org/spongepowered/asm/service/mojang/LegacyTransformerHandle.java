package org.spongepowered.asm.service.mojang;

import javax.annotation.Resource;
import net.minecraft.launchwrapper.IClassTransformer;
import org.spongepowered.asm.service.ILegacyClassTransformer;

class LegacyTransformerHandle implements ILegacyClassTransformer {
   private final IClassTransformer transformer;

   LegacyTransformerHandle(IClassTransformer transformer) {
      this.transformer = transformer;
   }

   public String getName() {
      return this.transformer.getClass().getName();
   }

   public boolean isDelegationExcluded() {
      return this.transformer.getClass().getAnnotation(Resource.class) != null;
   }

   public byte[] transformClassBytes(String name, String transformedName, byte[] basicClass) {
      return this.transformer.transform(name, transformedName, basicClass);
   }
}
