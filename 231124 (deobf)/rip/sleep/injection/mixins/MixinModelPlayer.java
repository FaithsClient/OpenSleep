package rip.sleep.injection.mixins;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.module.modules.Skeletal;

@Mixin({ModelPlayer.class})
public class MixinModelPlayer extends ModelBiped {
   @Inject(
      method = {"setRotationAngles"},
      at = {@At("RETURN")}
   )
   private void revertSwordAnimation(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7, CallbackInfo var8) {
      if (var7 instanceof EntityPlayer) {
         Skeletal.c42040((EntityPlayer)var7, (ModelPlayer)this);
      }

   }
}
