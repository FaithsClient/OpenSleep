package rip.sleep.injection.mixins;

import rip.sleep.injection.in.IRendererLivingEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rip.sleep.module.modules.CustomTags;
import rip.sleep.Sleep;
import rip.sleep.module.modules.Teams;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.modules.NameTags;

@Mixin({RendererLivingEntity.class})
public abstract class MixinRendererLivingEntity<T extends EntityLivingBase> extends MixinRender implements IRendererLivingEntity {
   @Shadow
   protected boolean field_177098_i = false;
   @Shadow
   protected ModelBase field_77045_g;
   @Shadow
   private static Logger field_147923_a;

   @Shadow
   protected abstract float func_77034_a(float var1, float var2, float var3);

   @Shadow
   protected abstract float func_77040_d(T var1, float var2);

   @Shadow
   protected abstract void func_77039_a(T var1, double var2, double var4, double var6);

   @Shadow
   protected abstract void func_77043_a(T var1, float var2, float var3, float var4);

   @Shadow
   protected abstract float func_77044_a(T var1, float var2);

   @Shadow
   protected abstract void func_77041_b(T var1, float var2);

   @Shadow
   protected abstract boolean func_177088_c(EntityLivingBase var1);

   @Shadow
   protected abstract void func_180565_e();

   @Shadow
   protected abstract void func_177093_a(T var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

   @Shadow
   protected abstract boolean func_177090_c(T var1, float var2);

   @Shadow
   protected abstract void func_177091_f();

   @Overwrite
   protected void func_77036_a(T var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      boolean var8 = !var1.isInvisible();
      boolean var9 = !var1.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer);
      if (this.func_180548_c(var1)) {
         Sleep.c33759();
         Teams var10 = (Teams) ModuleManager.c25475(Teams.class);
         if (var10.c1732(var1)) {
            GlStateManager.pushMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, Teams.c64397.c53968().floatValue());
            GlStateManager.depthMask(false);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.alphaFunc(516, 0.003921569F);
         }

         this.field_77045_g.render(var1, var2, var3, var4, var5, var6, var7);
         if (var10.c1732(var1)) {
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc(516, 0.1F);
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
         }

      }
   }

   @Overwrite
   public void func_76986_a(T param1, double param2, double param4, double param6, float param8, float param9) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"canRenderName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private <T extends EntityLivingBase> void canRenderName(T var1, CallbackInfoReturnable<Boolean> var2) {
      if (ModuleManager.c25475(NameTags.class).c24622() && var1 instanceof EntityPlayer) {
         var2.setReturnValue(Boolean.valueOf(var1 == Minecraft.getMinecraft().thePlayer));
      } else if (!ModuleManager.c25475(CustomTags.class).c24622()) {
         var2.setReturnValue(Boolean.valueOf(true));
      }

      if (ModuleManager.c25475(CustomTags.class).c24622() && var1 instanceof EntityPlayer) {
         var2.setReturnValue(Boolean.valueOf(CustomTags.c92322.c1473().booleanValue() ? false : var1 == Minecraft.getMinecraft().thePlayer));
      } else if (!ModuleManager.c25475(NameTags.class).c24622()) {
         var2.setReturnValue(Boolean.valueOf(true));
      }

   }
}
