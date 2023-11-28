package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import java.nio.FloatBuffer;
import java.util.List;

import rip.sleep.injection.in.IEntity;
import rip.sleep.injection.in.IEntityRenderer;
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
import net.minecraft.util.Vec3;
import net.minecraftforge.client.ForgeHooksClient;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import rip.sleep.module.modules.MWAddons;
import rip.sleep.module.modules.Reach;
import rip.sleep.Sleep;
import rip.sleep.module.modules.GhostHead;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.modules.AntiDisplayFucker;
import rip.sleep.module.modules.Camera;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.modules.ViewClip;

@Mixin({EntityRenderer.class})
public abstract class MixinEntityRenderer implements IEntityRenderer {
   @Shadow
   private float field_78535_ad;
   @Shadow
   private float field_78539_ae;
   @Shadow
   public static int field_147708_e;
   @Shadow
   public ItemRenderer field_78516_c;
   @Shadow
   private static Logger field_147710_q;
   @Shadow
   private final float field_78490_B = 4.0F;
   @Shadow
   private final float field_78491_C = 4.0F;
   @Shadow
   private int field_78529_t;
   @Shadow
   private final FloatBuffer field_78521_m = GLAllocation.createDirectFloatBuffer(16);
   @Shadow
   private boolean field_78500_U;
   @Shadow
   private int field_175079_V = 0;
   @Shadow
   private boolean field_175078_W = false;
   @Shadow
   private double field_78503_V = 1.0D;
   @Shadow
   private double field_78502_W;
   @Shadow
   private double field_78509_X;
   @Shadow
   private Minecraft field_78531_r;
   @Shadow
   private Entity field_78528_u;
   @Shadow
   private int field_147713_ae;
   @Shadow
   private boolean field_175083_ad;
   @Shadow
   private ShaderGroup field_147707_d;
   @Shadow
   private IResourceManager field_147711_ac;
   @Shadow
   private float field_175080_Q;
   @Shadow
   private float field_175082_R;
   @Shadow
   private float field_175081_S;
   @Shadow
   private float field_78530_s;
   @Shadow
   private float field_78506_S;
   @Shadow
   private float field_82831_U;
   @Shadow
   private float field_78507_R;
   @Shadow
   private float field_82832_V;

   @Shadow
   protected abstract void func_175069_a(ResourceLocation var1);

   @Shadow
   protected abstract void func_175072_h();

   @Shadow
   protected abstract void func_180436_i();

   @Shadow
   protected abstract FloatBuffer func_78469_a(float var1, float var2, float var3, float var4);

   @Shadow
   protected abstract void func_78479_a(float var1, int var2);

   @Shadow
   protected abstract float func_78481_a(float var1, boolean var2);

   @Shadow
   protected abstract void func_78475_f(float var1);

   @Shadow
   protected abstract float func_180438_a(EntityLivingBase var1, float var2);

   private void removeEntities(List<Entity> var1) {
      Sleep.c33759();
      if (ModuleManager.c25475(GhostHead.class).c24622()) {
         var1.removeIf(GhostHead::c52608);
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
   private void getMouseOver(float var1, CallbackInfo var2, Entity var3, double var4, double var6, Vec3 var8, boolean var9, int var10, Vec3 var11, Vec3 var12, Vec3 var13, float var14, List<Entity> var15, double var16, int var18) {
      this.removeEntities(var15);
   }

   @Redirect(
      method = {"getMouseOver"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/util/Vec3;distanceTo(Lnet/minecraft/util/Vec3;)D",
   ordinal = 2
)
   )
   private double distanceTo(Vec3 var1, Vec3 var2) {
      return ModuleManager.c59260("Reach").c24622() && var1.distanceTo(var2) <= Reach.c98619() ? 2.9D : var1.distanceTo(var2);
   }

   @Inject(
      at = {@At("HEAD")},
      method = {"hurtCameraEffect"},
      cancellable = true
   )
   private void hurtCameraEffect(float var1, CallbackInfo var2) {
      if (Camera.c96195.c1473().booleanValue()) {
         var2.cancel();
      }
   }

   @Overwrite
   private void func_78468_a(int var1, float var2) {
      if (var1 != -1) {
         GlStateManager.disableFog();
      } else {
         boolean var3 = false;
         Entity var4 = this.field_78531_r.getRenderViewEntity();
         boolean var5 = false;
         if (var4 instanceof EntityPlayer) {
            var5 = ((EntityPlayer)var4).capabilities.isCreativeMode;
         }

         GL11.glFog(2918, this.func_78469_a(this.field_175080_Q, this.field_175082_R, this.field_175081_S, 1.0F));
         GL11.glNormal3f(0.0F, -1.0F, 0.0F);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         Block var6 = ActiveRenderInfo.getBlockAtEntityViewpoint(this.field_78531_r.theWorld, var4, var2);
         float var7 = -1.0F;
         var7 = ForgeHooksClient.getFogDensity((EntityRenderer)this, var4, var6, var2, 0.1F);
         if (var7 >= 0.0F) {
            GlStateManager.setFogDensity(var7);
         } else if (var4 instanceof EntityLivingBase && ModuleManager.c25475(AntiDisplayFucker.class).c24622()) {
            float var15 = this.field_78530_s;
            GlStateManager.setFog(9729);
            if (var1 == -1) {
               GlStateManager.setFogStart(0.0F);
               GlStateManager.setFogEnd(var15);
            } else {
               GlStateManager.setFogStart(var15 * 0.75F);
               GlStateManager.setFogEnd(var15);
            }
         } else if (var4 instanceof EntityLivingBase && ((EntityLivingBase)var4).isPotionActive(Potion.blindness)) {
            float var14 = 5.0F;
            int var16 = ((EntityLivingBase)var4).getActivePotionEffect(Potion.blindness).getDuration();
            if (var16 < 20) {
               var14 = 5.0F + (this.field_78530_s - 5.0F) * (1.0F - (float)var16 / 20.0F);
            }

            GlStateManager.setFog(9729);
            if (var1 == -1) {
               GlStateManager.setFogStart(0.0F);
               GlStateManager.setFogEnd(var14 * 0.8F);
            } else {
               GlStateManager.setFogStart(var14 * 0.25F);
               GlStateManager.setFogEnd(var14);
            }
         } else if (this.field_78500_U) {
            GlStateManager.setFog(2048);
            GlStateManager.setFogDensity(0.1F);
         } else if (var6.getMaterial() == Material.water) {
            GlStateManager.setFog(2048);
            float var8 = 0.02F;
            if (var4 instanceof EntityLivingBase && ((EntityLivingBase)var4).isPotionActive(Potion.waterBreathing)) {
               GlStateManager.setFogDensity(0.01F);
            } else {
               float var9 = 0.1F - (float)EnchantmentHelper.getRespiration(var4) * 0.03F;
               GlStateManager.setFogDensity(var9 < 0.0F ? var8 : (0.0F > var9 ? var9 : 0.0F));
            }
         } else if (var6.getMaterial() == Material.lava) {
            GlStateManager.setFog(2048);
            GlStateManager.setFogDensity(2.0F);
         } else {
            float var13 = this.field_78530_s;
            var3 = true;
            GlStateManager.disableFog();
            GlStateManager.setFog(9729);
            if (var1 == -1) {
               GlStateManager.setFogStart(0.0F);
               GlStateManager.setFogEnd(var13);
            } else {
               GlStateManager.setFogStart(var13 * 0.0F);
               GlStateManager.setFogEnd(var13);
            }

            if (this.field_78531_r.theWorld.provider.doesXZShowFog((int)var4.posX, (int)var4.posZ)) {
               GlStateManager.setFogStart(var13 * 0.05F);
               GlStateManager.setFogEnd(var13);
            }

            ForgeHooksClient.onFogRender((EntityRenderer)this, var4, var6, var2, var1, var7);
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
   private void renderWorldPass(int var1, float var2, long var3, CallbackInfo var5) {
      Render3DEvent var6 = new Render3DEvent(var2);
      EventBus.getInstance().call(var6);
   }

   public void runorientCamera(float var1) {
      this.func_78467_g(var1);
   }

   public void runSetupCameraTransform(float var1, int var2) {
      this.func_78479_a(var1, var2);
   }

   @Overwrite
   private void func_78467_g(float var1) {
      Entity var2 = this.field_78531_r.getRenderViewEntity();
      float var3 = var2.getEyeHeight();
      double var4 = var2.prevPosX + (var2.posX - var2.prevPosX) * (double)var1;
      double var6 = var2.prevPosY + (var2.posY - var2.prevPosY) * (double)var1 + (double)var3;
      double var8 = var2.prevPosZ + (var2.posZ - var2.prevPosZ) * (double)var1;
      MWAddons var10 = (MWAddons) ModuleManager.c25475(MWAddons.class);
      if (var2 instanceof EntityLivingBase && ((EntityLivingBase)var2).isPlayerSleeping()) {
         var3 = (float)((double)var3 + 1.0D);
         GlStateManager.translate(0.0F, 0.3F, 0.0F);
         if (!this.field_78531_r.gameSettings.debugCamEnable) {
            BlockPos var31 = new BlockPos(var2);
            IBlockState var12 = this.field_78531_r.theWorld.getBlockState(var31);
            Block var33 = var12.getBlock();
            if (var33 == Blocks.bed) {
               int var34 = ((EnumFacing)var12.getValue(BlockBed.field_176387_N)).getHorizontalIndex();
               GlStateManager.rotate((float)(var34 * 90), 0.0F, 1.0F, 0.0F);
            }

            GlStateManager.rotate(var2.prevRotationYaw + (var2.rotationYaw - var2.prevRotationYaw) * var1 + 180.0F, 0.0F, -1.0F, 0.0F);
            GlStateManager.rotate(var2.prevRotationPitch + (var2.rotationPitch - var2.prevRotationPitch) * var1, -1.0F, 0.0F, 0.0F);
         }
      } else if (this.field_78531_r.gameSettings.thirdPersonView > 0) {
         this.getClass();
         this.getClass();
         this.getClass();
         double var11 = (double)(4.0F + (4.0F - 4.0F) * var1);
         if (this.field_78531_r.gameSettings.debugCamEnable) {
            GlStateManager.translate(0.0F, 0.0F, -ViewClip.c51775.c53968().floatValue());
         } else {
            float var13 = var2.rotationYaw;
            float var14 = var2.rotationPitch;
            if (this.field_78531_r.gameSettings.thirdPersonView == 2) {
               var14 += 180.0F;
            }

            double var15 = (double)(-MathHelper.sin(var13 / 180.0F * 3.1415927F) * MathHelper.cos(var14 / 180.0F * 3.1415927F)) * var11;
            double var17 = (double)(MathHelper.cos(var13 / 180.0F * 3.1415927F) * MathHelper.cos(var14 / 180.0F * 3.1415927F)) * var11;
            double var19 = (double)(-MathHelper.sin(var14 / 180.0F * 3.1415927F)) * var11;

            for(int var21 = 0; var21 < 8; ++var21) {
               float var22 = (float)((var21 & 1) * 2 - 1);
               float var23 = (float)((var21 >> 1 & 1) * 2 - 1);
               float var24 = (float)((var21 >> 2 & 1) * 2 - 1);
               var22 = var22 * 0.1F;
               var23 = var23 * 0.1F;
               var24 = var24 * 0.1F;
               MovingObjectPosition var25 = this.field_78531_r.theWorld.rayTraceBlocks(new Vec3(var4 + (double)var22, var6 + (double)var23, var8 + (double)var24), new Vec3(var4 - var15 + (double)var22 + (double)var24, var6 - var19 + (double)var23, var8 - var17 + (double)var24));
               double var26 = var25.hitVec.distanceTo(new Vec3(var4, var6, var8));
               if (var26 < var11 && !ModuleManager.c25475(ViewClip.class).c24622()) {
                  var11 = var26;
               }
            }

            if (this.field_78531_r.gameSettings.thirdPersonView == 2) {
               GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            }

            GlStateManager.rotate(var2.rotationPitch - var14, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(var2.rotationYaw - var13, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.0F, 0.0F, -ViewClip.c51775.c53968().floatValue());
            GlStateManager.rotate(var13 - var2.rotationYaw, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(var14 - var2.rotationPitch, 1.0F, 0.0F, 0.0F);
         }
      } else {
         GlStateManager.translate(0.0F, 0.0F, -0.1F);
      }

      if (!this.field_78531_r.gameSettings.debugCamEnable) {
         if (var10.c24622() && MWAddons.c34018.c72319("McLook").c1473().booleanValue() && Mouse.isButtonDown(2)) {
            GlStateManager.rotate(((IEntity)var2).getCameraPitch(), 1.0F, 0.0F, 0.0F);
         } else {
            GlStateManager.rotate(var2.prevRotationPitch + (var2.rotationPitch - var2.prevRotationPitch) * var1, 1.0F, 0.0F, 0.0F);
         }

         if (var2 instanceof EntityAnimal) {
            EntityAnimal var32 = (EntityAnimal)var2;
            GlStateManager.rotate(var32.field_70758_at + (var32.field_70759_as - var32.field_70758_at) * var1 + 180.0F, 0.0F, 1.0F, 0.0F);
         } else if (var10.c24622() && MWAddons.c34018.c72319("McLook").c1473().booleanValue() && Mouse.isButtonDown(2)) {
            GlStateManager.rotate(((IEntity)var2).getCameraYaw() + 180.0F, 0.0F, 1.0F, 0.0F);
         } else {
            GlStateManager.rotate(var2.prevRotationYaw + (var2.rotationYaw - var2.prevRotationYaw) * var1 + 180.0F, 0.0F, 1.0F, 0.0F);
         }
      }

      GlStateManager.translate(0.0F, -var3, 0.0F);
      var4 = var2.prevPosX + (var2.posX - var2.prevPosX) * (double)var1;
      var6 = var2.prevPosY + (var2.posY - var2.prevPosY) * (double)var1 + (double)var3;
      var8 = var2.prevPosZ + (var2.posZ - var2.prevPosZ) * (double)var1;
      this.field_78500_U = this.field_78531_r.renderGlobal.hasCloudFog(var4, var6, var8, var1);
   }
}
