package org.spongepowered.asm.mixin.injection.modify;

import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

@InjectionPoint.AtCode("STORE")
public class AfterStoreLocal extends BeforeLoadLocal {
   public AfterStoreLocal(InjectionPointData data) {
      super(data, 54, true);
   }
}
