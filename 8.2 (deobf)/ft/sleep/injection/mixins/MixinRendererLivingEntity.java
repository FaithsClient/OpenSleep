//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.rendering.EventRenderLivingEntity;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.injection.interfaces.IRendererLivingEntity;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.client.event.RenderLivingEvent.Pre;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({RendererLivingEntity.class})
public abstract class MixinRendererLivingEntity extends MixinRender implements IRendererLivingEntity {
   @Shadow
   protected boolean renderOutlines = false;
   @Shadow
   protected ModelBase mainModel;
   @Shadow
   private static Logger logger;

   @Shadow
   protected abstract float interpolateRotation(float var1, float var2, float var3);

   @Shadow
   protected abstract float getSwingProgress(EntityLivingBase var1, float var2);

   @Shadow
   protected abstract void renderLivingAt(EntityLivingBase var1, double var2, double var4, double var6);

   @Shadow
   protected abstract void rotateCorpse(EntityLivingBase var1, float var2, float var3, float var4);

   @Shadow
   protected abstract float handleRotationFloat(EntityLivingBase var1, float var2);

   @Shadow
   protected abstract void preRenderCallback(EntityLivingBase var1, float var2);

   @Shadow
   protected abstract boolean setScoreTeamColor(EntityLivingBase var1);

   @Shadow
   protected abstract void unsetScoreTeamColor();

   @Shadow
   protected abstract void renderLayers(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

   @Shadow
   protected abstract boolean setDoRenderBrightness(EntityLivingBase var1, float var2);

   @Shadow
   protected abstract void unsetBrightness();

   @Overwrite
   protected void renderModel(EntityLivingBase entitylivingbaseIn, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
      boolean flag = !entitylivingbaseIn.isInvisible();
      boolean flag1 = !flag && !entitylivingbaseIn.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer);
      if (flag || flag1) {
         if (!this.bindEntityTexture(entitylivingbaseIn)) {
            return;
         }

         �?.�?();
          teams = ().�?(.class);
         if (flag1 || teams.(entitylivingbaseIn)) {
            GlStateManager.pushMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, ..getValue().floatValue());
            GlStateManager.depthMask(false);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.alphaFunc(516, 0.003921569F);
         }

         this.mainModel.render(entitylivingbaseIn, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
         if (flag1 || teams.(entitylivingbaseIn)) {
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc(516, 0.1F);
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
         }
      }

   }

   @Overwrite
   public void doRender(EntityLivingBase entity, double x, double y, double z, float entityYaw, float partialTicks) {
      if (!MinecraftForge.EVENT_BUS.post(new Pre(entity, (RendererLivingEntity)this, x, y, z))) {
         GlStateManager.pushMatrix();
         GlStateManager.disableCull();
         this.mainModel.swingProgress = this.getSwingProgress(entity, partialTicks);
         boolean shouldSit;
         this.mainModel.isRiding = shouldSit = entity.isRiding() && entity.ridingEntity != null && entity.ridingEntity.shouldRiderSit();
         this.mainModel.isChild = entity.isChild();
          aura = ().�?(.class);
          i = ().�?(.class);

         try {
            float f = this.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
            float f1 = this.interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
            if (entity instanceof EntityPlayerSP) {
               f = this.interpolateRotation(((EntityPlayerSP)entity).prevRenderYawOffset, ((EntityPlayerSP)entity).renderYawOffset, partialTicks);
               f1 = this.interpolateRotation(((EntityPlayerSP)entity).prevRotationYawHead, ((EntityPlayerSP)entity).rotationYawHead, partialTicks);
            }

            float f8 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
            if (!Objects.equals(..getValue(), "Astolfo2")) {
               if (aura.�?()) {
                  if (!Objects.equals(..getValue(), "None") && .�? != null && Objects.equals(..getValue(), "Smart") && .�?(.�?, 100.0F) && .�? != null && entity == Minecraft.getMinecraft().thePlayer && i.�?() && .�?.getValue().booleanValue()) {
                     f = �?.�?(entity, partialTicks)[0];
                     f1 = �?.�?(entity, partialTicks)[1];
                     f8 = �?.�?(entity, partialTicks)[2];
                  }

                  if (!Objects.equals(..getValue(), "None") && .�? != null && (Objects.equals(..getValue(), "Custom") || Objects.equals(..getValue(), "Zenith")) && entity == Minecraft.getMinecraft().thePlayer && i.�?() && .�?.getValue().booleanValue()) {
                     f = �?.�?(entity, partialTicks)[0];
                     f1 = �?.�?(entity, partialTicks)[1];
                     f8 = �?.�?(entity, partialTicks)[2];
                  }
               }

               �?.�?();
                bowAimBot = ().�?(.class);
               if ((.�?(.class).�?() || bowAimBot.�?() && bowAimBot.�?(Minecraft.getMinecraft().thePlayer)) && entity == Minecraft.getMinecraft().thePlayer && i.�?() && .�?.getValue().booleanValue()) {
                  f = �?.�?(entity, partialTicks)[0];
                  f1 = �?.�?(entity, partialTicks)[1];
                  f8 = �?.�?(entity, partialTicks)[2];
               }
            }

            float f2 = f1 - f;
            if (shouldSit && entity.ridingEntity instanceof EntityLivingBase) {
               EntityLivingBase entitylivingbase = (EntityLivingBase)entity.ridingEntity;
               f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
               �?.�?();
                bowAimBot = ().�?(.class);
               if (!Objects.equals(..getValue(), "Astolfo2")) {
                  if ((.�?(.class).�?() || bowAimBot.�?() && bowAimBot.�?(Minecraft.getMinecraft().thePlayer)) && entity == Minecraft.getMinecraft().thePlayer && i.�?() && .�?.getValue().booleanValue()) {
                     f = this.interpolateRotation(EventPreUpdate.yaw2, EventPreUpdate.yaw, partialTicks);
                  }

                  if (aura.�?() && !Objects.equals(..getValue(), "None") && .�? != null && Objects.equals(..getValue(), "Smart") && .�?(.�?, 100.0F) && .�? != null && entity == Minecraft.getMinecraft().thePlayer && i.�?() && .�?.getValue().booleanValue()) {
                     f = this.interpolateRotation(EventPreUpdate.yaw2, EventPreUpdate.yaw, partialTicks);
                  }

                  if (!Objects.equals(..getValue(), "None") && .�? != null && (Objects.equals(..getValue(), "Custom") || Objects.equals(..getValue(), "Zenith")) && entity == Minecraft.getMinecraft().thePlayer && i.�?() && .�?.getValue().booleanValue()) {
                     f = this.interpolateRotation(EventPreUpdate.yaw2, EventPreUpdate.yaw, partialTicks);
                  }
               }

               float var10000 = f1 - f;
               float f3;
               if ((f3 = MathHelper.wrapAngleTo180_float(f1 - f)) < -85.0F) {
                  f3 = -85.0F;
               }

               if (f3 >= 85.0F) {
                  f3 = 85.0F;
               }

               f = f1 - f3;
               if (f3 * f3 > 2500.0F) {
                  f += f3 * 0.2F;
               }

               f2 = f1 - f;
            }

            this.renderLivingAt(entity, x, y, z);
            float f7 = this.handleRotationFloat(entity, partialTicks);
            float f4 = 0.0625F;
            float f5 = entity.prevLimbSwingAmount + (entity.limbSwingAmount - entity.prevLimbSwingAmount) * partialTicks;
            float f6 = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks);
            boolean flag = this.setDoRenderBrightness(entity, partialTicks);
            if (entity instanceof EntityPlayer) {
               EventRenderLivingEntity pre = new EventRenderLivingEntity(entity, true, f6, f5, f7, f2, f8, f, f4);
               EventBus.getInstance().call(pre);
               if (pre.isCancelled()) {
                  return;
               }
            }

            this.rotateCorpse(entity, f7, f, partialTicks);
            GlStateManager.enableRescaleNormal();
            GlStateManager.scale(-1.0F, -1.0F, 1.0F);
            this.preRenderCallback(entity, partialTicks);
            GlStateManager.translate(0.0F, -1.5078125F, 0.0F);
            if (entity.isChild()) {
               f6 *= 3.0F;
            }

            if (f5 > 1.0F) {
               f5 = 1.0F;
            }

            GlStateManager.enableAlpha();
            this.mainModel.setLivingAnimations(entity, f6, f5, partialTicks);
            this.mainModel.setRotationAngles(f6, f5, f7, f2, f8, 0.0625F, entity);
            if (this.renderOutlines) {
               boolean flag1 = this.setScoreTeamColor(entity);
               this.renderModel(entity, f6, f5, f7, f2, f8, 0.0625F);
               if (flag1) {
                  this.unsetScoreTeamColor();
               }
            } else {
               this.renderModel(entity, f6, f5, f7, f2, f8, 0.0625F);
               if (flag) {
                  this.unsetBrightness();
               }

               GlStateManager.depthMask(true);
               if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).isSpectator()) {
                  this.renderLayers(entity, f6, f5, partialTicks, f7, f2, f8, 0.0625F);
               }
            }

            GlStateManager.disableRescaleNormal();
         } catch (Exception var24) {
            logger.error("Couldn't render entity", var24);
         }

         GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
         GlStateManager.enableTexture2D();
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GlStateManager.enableCull();
         GlStateManager.popMatrix();
         if (!this.renderOutlines) {
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
         }

         EventRenderLivingEntity post = new EventRenderLivingEntity(entity, false);
         EventBus.getInstance().call(post);
         MinecraftForge.EVENT_BUS.post(new Post(entity, (RendererLivingEntity)this, x, y, z));
      }
   }

   @Inject(
      method = {"canRenderName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void canRenderName(EntityLivingBase entity, CallbackInfoReturnable callbackInfoReturnable) {
      if (.�?(.class).�?() && entity instanceof EntityPlayer) {
         callbackInfoReturnable.setReturnValue(Boolean.valueOf(entity == Minecraft.getMinecraft().thePlayer));
      } else if (!.�?(.class).�?()) {
         callbackInfoReturnable.setReturnValue(Boolean.valueOf(true));
      }

      if (.�?(.class).�?() && entity instanceof EntityPlayer) {
         callbackInfoReturnable.setReturnValue(Boolean.valueOf(.�?.getValue().booleanValue() ? false : entity == Minecraft.getMinecraft().thePlayer));
      } else if (!.�?(.class).�?()) {
         callbackInfoReturnable.setReturnValue(Boolean.valueOf(true));
      }

   }
}
