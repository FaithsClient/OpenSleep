package ft.sleep.injection.mixins;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ModelPlayer.class})
public class MixinModelPlayer extends ModelBiped {
   @Inject(
      method = {"setRotationAngles"},
      at = {@At("RETURN")}
   )
   private void revertSwordAnimation(float p_setRotationAngles_1_, float p_setRotationAngles_2_, float p_setRotationAngles_3_, float p_setRotationAngles_4_, float p_setRotationAngles_5_, float p_setRotationAngles_6_, Entity p_setRotationAngles_7_, CallbackInfo callbackInfo) {
      if (p_setRotationAngles_7_ instanceof EntityPlayer) {
         .((EntityPlayer)p_setRotationAngles_7_, (ModelPlayer)this);
      }

   }
}
