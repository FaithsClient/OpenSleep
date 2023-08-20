//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.injection.interfaces.IEntity;
import ft.sleep.injection.interfaces.IEntityRenderer;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin({EntityRenderer.class})
public abstract class MixinEntityRenderer implements IEntityRenderer {
   @Shadow
   private float fogColor2;
   @Shadow
   private float fogColor1;
   @Shadow
   public static int shaderCount;
   @Shadow
   public ItemRenderer itemRenderer;
   @Shadow
   private static Logger logger;
   @Shadow
   private final float thirdPersonDistance = 4.0F;
   @Shadow
   private final float thirdPersonDistanceTemp = 4.0F;
   @Shadow
   private int rendererUpdateCount;
   @Shadow
   private final FloatBuffer fogColorBuffer = GLAllocation.createDirectFloatBuffer(16);
   @Shadow
   private boolean cloudFog;
   @Shadow
   private int debugViewDirection = 0;
   @Shadow
   private boolean debugView = false;
   @Shadow
   private double cameraZoom = 1.0D;
   @Shadow
   private double cameraYaw;
   @Shadow
   private double cameraPitch;
   @Shadow
   private Minecraft mc;
   @Shadow
   private Entity pointedEntity;
   @Shadow
   private int shaderIndex;
   @Shadow
   private boolean useShader;
   @Shadow
   private ShaderGroup theShaderGroup;
   @Shadow
   private IResourceManager resourceManager;
   @Shadow
   private float fogColorRed;
   @Shadow
   private float fogColorGreen;
   @Shadow
   private float fogColorBlue;
   @Shadow
   private float farPlaneDistance;
   @Shadow
   private float fovModifierHandPrev;
   @Shadow
   private float bossColorModifier;
   @Shadow
   private float fovModifierHand;
   @Shadow
   private float bossColorModifierPrev;

   @Shadow
   protected abstract void loadShader(ResourceLocation var1);

   @Shadow
   protected abstract void disableLightmap();

   @Shadow
   protected abstract void enableLightmap();

   @Shadow
   protected abstract FloatBuffer setFogColorBuffer(float var1, float var2, float var3, float var4);

   @Shadow
   protected abstract void setupCameraTransform(float var1, int var2);

   @Shadow
   protected abstract float getFOVModifier(float var1, boolean var2);

   @Shadow
   protected abstract void setupViewBobbing(float var1);

   @Shadow
   protected abstract float getNightVisionBrightness(EntityLivingBase var1, float var2);

   private void removeEntities(List list) {
      �?.�?();
      if (.�?(.class).�?()) {
         list.removeIf(::);
      }

   }

   @Inject(
      method = {"getMouseOver"},
      at = {@At(
   value = "INVOKE",
   target = "Ljava/util/List;size()I",
   ordinal = 0
)},
      locals = LocalCapture.CAPTURE_FAILSOFT
   )
   private void getMouseOver(float partialTicks, CallbackInfo ci, Entity entity, double d0, double d1, net.minecraft.util.Vec3 vec3, boolean flag, int i, net.minecraft.util.Vec3 vec31, net.minecraft.util.Vec3 vec32, net.minecraft.util.Vec3 vec33, float f, List list, double d2, int j) {
      this.removeEntities(list);
   }

   @Redirect(
      method = {"getMouseOver"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/util/ft.sleep.util.angle.Vec3;distanceTo(Lnet/minecraft/util/ft.sleep.util.angle.Vec3;)D",
   ordinal = 2
)
   )
   private double distanceTo(net.minecraft.util.Vec3 instance, net.minecraft.util.Vec3 vec) {
      return .�?("ft.sleep.module.modules.Reach").�?() && instance.distanceTo(vec) <= .() ? 2.9D : instance.distanceTo(vec);
   }

   @Inject(
      at = {@At("HEAD")},
      method = {"hurtCameraEffect"},
      cancellable = true
   )
   private void hurtCameraEffect(float partialTicks, CallbackInfo info) {
      if (.�?.getValue().booleanValue()) {
         info.cancel();
      }
   }

   @Overwrite
   private void setupFog(int startCoords, float partialTicks) {
      if (startCoords != -1) {
         GlStateManager.disableFog();
      } else {
         boolean fogStandard = false;
         Entity entity = this.mc.getRenderViewEntity();
         boolean flag = false;
         if (entity instanceof EntityPlayer) {
            flag = ((EntityPlayer)entity).capabilities.isCreativeMode;
         }

         GL11.glFog(2918, this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0F));
         GL11.glNormal3f(0.0F, -1.0F, 0.0F);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, partialTicks);
         float f = -1.0F;
         f = ForgeHooksClient.getFogDensity((EntityRenderer)this, entity, block, partialTicks, 0.1F);
         if (f >= 0.0F) {
            GlStateManager.setFogDensity(f);
         } else if (entity instanceof EntityLivingBase && .�?(.class).�?() && .�?.getValue().booleanValue()) {
            float f2 = this.farPlaneDistance;
            GlStateManager.setFog(9729);
            if (startCoords == -1) {
               GlStateManager.setFogStart(0.0F);
               GlStateManager.setFogEnd(f2);
            } else {
               GlStateManager.setFogStart(f2 * 0.75F);
               GlStateManager.setFogEnd(f2);
            }
         } else if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(Potion.blindness)) {
            float f4 = 5.0F;
            int i = ((EntityLivingBase)entity).getActivePotionEffect(Potion.blindness).getDuration();
            if (i < 20) {
               f4 = 5.0F + (this.farPlaneDistance - 5.0F) * (1.0F - (float)i / 20.0F);
            }

            GlStateManager.setFog(9729);
            if (startCoords == -1) {
               GlStateManager.setFogStart(0.0F);
               GlStateManager.setFogEnd(f4 * 0.8F);
            } else {
               GlStateManager.setFogStart(f4 * 0.25F);
               GlStateManager.setFogEnd(f4);
            }
         } else if (this.cloudFog) {
            GlStateManager.setFog(2048);
            GlStateManager.setFogDensity(0.1F);
         } else if (block.getMaterial() == Material.water) {
            GlStateManager.setFog(2048);
            float f1 = 0.02F;
            if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(Potion.waterBreathing)) {
               GlStateManager.setFogDensity(0.01F);
            } else {
               float f2 = 0.1F - (float)EnchantmentHelper.getRespiration(entity) * 0.03F;
               GlStateManager.setFogDensity(f2 < 0.0F ? f1 : (0.0F > f2 ? f2 : 0.0F));
            }
         } else if (block.getMaterial() == Material.lava) {
            GlStateManager.setFog(2048);
            GlStateManager.setFogDensity(2.0F);
         } else {
            float f3 = this.farPlaneDistance;
            fogStandard = true;
            GlStateManager.disableFog();
            GlStateManager.setFog(9729);
            if (startCoords == -1) {
               GlStateManager.setFogStart(0.0F);
               GlStateManager.setFogEnd(f3);
            } else {
               GlStateManager.setFogStart(f3 * 0.0F);
               GlStateManager.setFogEnd(f3);
            }

            if (this.mc.theWorld.provider.doesXZShowFog((int)entity.posX, (int)entity.posZ)) {
               GlStateManager.setFogStart(f3 * 0.05F);
               GlStateManager.setFogEnd(f3);
            }

            ForgeHooksClient.onFogRender((EntityRenderer)this, entity, block, partialTicks, startCoords, f);
         }

         GlStateManager.enableColorMaterial();
         GlStateManager.enableFog();
         GlStateManager.colorMaterial(1028, 4608);
      }
   }

   @Inject(
      method = {"renderWorldPass"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/renderer/EntityRenderer;renderHand:Z",
   shift = At.Shift.BEFORE
)}
   )
   private void renderWorldPass(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
      EventRender3D eventRender = new EventRender3D(partialTicks);
      EventBus.getInstance().call(eventRender);
   }

   public void runorientCamera(float partialTicks) {
      this.orientCamera(partialTicks);
   }

   public void runSetupCameraTransform(float partialTicks, int pass) {
      this.setupCameraTransform(partialTicks, pass);
   }

   @Overwrite
   private void orientCamera(float partialTicks) {
      Entity entity = this.mc.getRenderViewEntity();
      float f = entity.getEyeHeight();
      double d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
      double d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)f;
      double d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
       module = ().�?(.class);
      if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping()) {
         f = (float)((double)f + 1.0D);
         GlStateManager.translate(0.0F, 0.3F, 0.0F);
         if (!this.mc.gameSettings.debugCamEnable) {
            BlockPos blockpos = new BlockPos(entity);
            IBlockState iblockstate = this.mc.theWorld.getBlockState(blockpos);
            Block block = iblockstate.getBlock();
            if (block == Blocks.bed) {
               int j = ((EnumFacing)iblockstate.getValue(BlockBed.FACING)).getHorizontalIndex();
               GlStateManager.rotate((float)(j * 90), 0.0F, 1.0F, 0.0F);
            }

            GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0F, 0.0F, -1.0F, 0.0F);
            GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, -1.0F, 0.0F, 0.0F);
         }
      } else if (this.mc.gameSettings.thirdPersonView > 0) {
         this.getClass();
         this.getClass();
         this.getClass();
         double d3 = (double)(4.0F + (4.0F - 4.0F) * partialTicks);
         if (this.mc.gameSettings.debugCamEnable) {
            GlStateManager.translate(0.0F, 0.0F, -..getValue().floatValue());
         } else {
            float f1 = entity.rotationYaw;
            float f2 = entity.rotationPitch;
            if (this.mc.gameSettings.thirdPersonView == 2) {
               f2 += 180.0F;
            }

            double d4 = (double)(-MathHelper.sin(f1 / 180.0F * 3.1415927F) * MathHelper.cos(f2 / 180.0F * 3.1415927F)) * d3;
            double d5 = (double)(MathHelper.cos(f1 / 180.0F * 3.1415927F) * MathHelper.cos(f2 / 180.0F * 3.1415927F)) * d3;
            double d6 = (double)(-MathHelper.sin(f2 / 180.0F * 3.1415927F)) * d3;

            for(int i = 0; i < 8; ++i) {
               float f3 = (float)((i & 1) * 2 - 1);
               float f4 = (float)((i >> 1 & 1) * 2 - 1);
               float f5 = (float)((i >> 2 & 1) * 2 - 1);
               f3 = f3 * 0.1F;
               f4 = f4 * 0.1F;
               f5 = f5 * 0.1F;
               MovingObjectPosition movingobjectposition = this.mc.theWorld.rayTraceBlocks(new net.minecraft.util.Vec3(d0 + (double)f3, d1 + (double)f4, d2 + (double)f5), new net.minecraft.util.Vec3(d0 - d4 + (double)f3 + (double)f5, d1 - d6 + (double)f4, d2 - d5 + (double)f5));
               if (movingobjectposition != null) {
                  double d7 = movingobjectposition.hitVec.distanceTo(new net.minecraft.util.Vec3(d0, d1, d2));
                  if (d7 < d3 && !.�?(.class).�?()) {
                     d3 = d7;
                  }
               }
            }

            if (this.mc.gameSettings.thirdPersonView == 2) {
               GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            }

            GlStateManager.rotate(entity.rotationPitch - f2, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(entity.rotationYaw - f1, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.0F, 0.0F, -..getValue().floatValue());
            GlStateManager.rotate(f1 - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(f2 - entity.rotationPitch, 1.0F, 0.0F, 0.0F);
         }
      } else {
         GlStateManager.translate(0.0F, 0.0F, -0.1F);
      }

      if (!this.mc.gameSettings.debugCamEnable) {
         if (module.�?() && .�?.getSetting("McLook").getValue().booleanValue() && module.()) {
            GlStateManager.rotate(((IEntity)entity).getCameraPitch(), 1.0F, 0.0F, 0.0F);
         } else {
            GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 1.0F, 0.0F, 0.0F);
         }

         if (entity instanceof EntityAnimal) {
            EntityAnimal entityanimal = (EntityAnimal)entity;
            GlStateManager.rotate(entityanimal.prevRotationYawHead + (entityanimal.rotationYawHead - entityanimal.prevRotationYawHead) * partialTicks + 180.0F, 0.0F, 1.0F, 0.0F);
         } else if (module.�?() && .�?.getSetting("McLook").getValue().booleanValue() && module.()) {
            GlStateManager.rotate(((IEntity)entity).getCameraYaw() + 180.0F, 0.0F, 1.0F, 0.0F);
         } else {
            GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0F, 0.0F, 1.0F, 0.0F);
         }
      }

      GlStateManager.translate(0.0F, -f, 0.0F);
      d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
      d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)f;
      d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
      this.cloudFog = this.mc.renderGlobal.hasCloudFog(d0, d1, d2, partialTicks);
   }
}
