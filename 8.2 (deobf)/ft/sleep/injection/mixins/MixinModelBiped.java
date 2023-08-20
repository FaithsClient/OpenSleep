//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ModelBiped.class})
public abstract class MixinModelBiped {
   @Shadow
   public ModelRenderer bipedRightArm;
   @Shadow
   public int heldItemRight;
   @Shadow
   public ModelRenderer bipedHead;
   @Shadow
   public ModelRenderer bipedBody;

   @Shadow
   public abstract void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

   @Inject(
      method = {"setRotationAngles"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/model/ModelBiped;swingProgress:F"
)}
   )
   private void revertSwordAnimation(float p_setRotationAngles1, float p_setRotationAngles2, float p_setRotationAngles3, float p_setRotationAngles4, float p_setRotationAngles5, float p_setRotationAngles6, Entity p_setRotationAngles7, CallbackInfo callbackInfo) {
      �?.�?();
       silentView = ().�?(.class);
      if (this.heldItemRight == 3) {
         this.bipedRightArm.rotateAngleY = 0.0F;
      }

      if (p_setRotationAngles7 instanceof EntityPlayer && p_setRotationAngles7.equals(Minecraft.getMinecraft().thePlayer) && silentView.�?() && Objects.equals(..getValue(), "Astolfo2") && silentView.�?() != null) {
         this.bipedHead.rotateAngleX = (float)Math.toRadians((double)silentView.�?().floatValue());
      }

   }
}
