package rip.sleep.injection.mixins;

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
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.modules.Camera;

@Mixin({ModelBiped.class})
public abstract class MixinModelBiped<T extends MixinRendererLivingEntity> {
   @Shadow
   public ModelRenderer field_178723_h;
   @Shadow
   public int field_78120_m;
   @Shadow
   public ModelRenderer field_78116_c;
   @Shadow
   public ModelRenderer field_78115_e;

   @Shadow
   public abstract void func_78087_a(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

   @Inject(
      method = {"setRotationAngles"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/model/ModelBiped;swingProgress:F"
)}
   )
   private void revertSwordAnimation(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7, CallbackInfo var8) {
      Sleep var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      Camera var9 = (Camera) ModuleManager.c25475(Camera.class);
      if (this.field_78120_m == 3) {
         this.field_178723_h.rotateAngleY = 0.0F;
      }

      if (var7 instanceof EntityPlayer && var7.equals(Minecraft.getMinecraft().thePlayer) && var9.c24622() && Objects.equals(Camera.c94474.c54460(), "Astolfo2") && var9.c8703() != null) {
         this.field_78116_c.rotateAngleX = (float)Math.toRadians((double)var9.c8703().floatValue());
      }

   }
}
