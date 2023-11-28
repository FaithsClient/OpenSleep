package rip.sleep.injection.mixins;

import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.Sleep;
import rip.sleep.module.modules.Teams;
import rip.sleep.management.ModuleManager;

@Mixin({LayerArmorBase.class})
public abstract class MixinLayerArmorBase {
   @Shadow
   private float field_177187_e;

   @Inject(
      method = {"renderLayer"},
      at = {@At("HEAD")}
   )
   private void renderLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, CallbackInfo var10) {
      Sleep.c33759();
      Teams var11 = (Teams) ModuleManager.c25475(Teams.class);
      if (var11.c1732(var1)) {
         this.field_177187_e = 0.1F;
      } else {
         this.field_177187_e = 1.0F;
      }

   }
}
