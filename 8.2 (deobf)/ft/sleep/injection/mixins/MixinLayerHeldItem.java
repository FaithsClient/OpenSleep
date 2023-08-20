package ft.sleep.injection.mixins;

import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LayerHeldItem.class})
public class MixinLayerHeldItem {
   @Inject(
      method = {"doRenderLayer"},
      at = {@At("HEAD")}
   )
   public void renderss(EntityLivingBase p_doRenderLayer_1_, float p_doRenderLayer_2_, float p_doRenderLayer_3_, float p_doRenderLayer_4_, float p_doRenderLayer_5_, float p_doRenderLayer_6_, float p_doRenderLayer_7_, float p_doRenderLayer_8_, CallbackInfo ci) {
      .();
       teams = ().(.class);
      if (teams.(p_doRenderLayer_1_)) {
         ci.cancel();
      }

   }
}
