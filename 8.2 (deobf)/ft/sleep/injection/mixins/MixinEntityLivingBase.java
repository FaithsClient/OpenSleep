//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.misc.EventJump;
import ft.sleep.api.events.rendering.EventLivingUpdate;
import ft.sleep.injection.interfaces.IEntityLivingBase;
import java.util.Objects;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityLivingBase.class})
public abstract class MixinEntityLivingBase extends Entity implements IEntityLivingBase {
   public float rotationPitchHead;
   public float prevRotationPitchHead;
   @Shadow
   private int jumpTicks;
   @Shadow
   protected int newPosRotationIncrements;
   @Shadow
   protected double newPosX;
   @Shadow
   protected double newPosY;
   @Shadow
   protected double newPosZ;
   @Shadow
   protected double newRotationYaw;
   @Shadow
   protected double newRotationPitch;
   @Shadow
   public boolean isJumping;
   @Shadow
   public float moveStrafing;
   @Shadow
   public float moveForward;
   @Shadow
   protected float randomYawVelocity;
   @Shadow
   public float renderYawOffset;

   public MixinEntityLivingBase() {
      super((World)null);
   }

   @Shadow
   protected abstract float getJumpUpwardsMotion();

   @Shadow
   public abstract boolean isServerWorld();

   @Shadow
   protected abstract boolean isMovementBlocked();

   @Shadow
   protected abstract void updateAITick();

   @Shadow
   protected abstract void handleJumpLava();

   @Shadow
   protected abstract void updateEntityActionState();

   @Shadow
   protected abstract void collideWithNearbyEntities();

   @Shadow
   public abstract PotionEffect getActivePotionEffect(Potion var1);

   @Shadow
   public abstract boolean isPotionActive(Potion var1);

   @Shadow
   public abstract void moveEntityWithHeading(float var1, float var2);

   public int runGetArmSwingAnimationEnd() {
      return this.getArmSwingAnimationEnd();
   }

   public int getJumpTicks() {
      return this.jumpTicks;
   }

   @Inject(
      method = {"onEntityUpdate"},
      at = {@At("HEAD")}
   )
   public void onEntityUpdate(CallbackInfo callbackInfo) {
      EventBus.getInstance().call(new EventLivingUpdate((EntityLivingBase)this));
      this.prevRotationPitchHead = this.rotationPitchHead;
   }

   public float getprevRotationPitchHead() {
      return this.prevRotationPitchHead;
   }

   public float getrotationPitchHead() {
      return this.rotationPitchHead;
   }

   public float setrotationPitchHead(float a) {
      return this.rotationPitchHead = a;
   }

   @Overwrite
   private int getArmSwingAnimationEnd() {
      int speed;
      if (this.isPotionActive(Potion.digSpeed)) {
         speed = 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier());
      } else {
         speed = this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6;
      }

      if ((EntityLivingBase)this instanceof EntityPlayerSP) {
          var10001 = ().�?(.class);
         speed += ..getValue().intValue();
      }

      return speed;
   }

   @Overwrite
   protected float updateDistance(float p_1101461, float p_1101462) {
      float rotationYaw = this.rotationYaw;
      �?.�?();
       silentView = ().�?(.class);
      if ((EntityLivingBase)this instanceof EntityPlayerSP && silentView.�?() && Objects.equals(..getValue(), "Astolfo2") && silentView.�?() != null) {
         rotationYaw = silentView.�?().floatValue();
      }

      float f = MathHelper.wrapAngleTo180_float(p_1101461 - this.renderYawOffset);
      this.renderYawOffset += f * 0.3F;
      float f2 = MathHelper.wrapAngleTo180_float(rotationYaw - this.renderYawOffset);
      boolean flag = f2 < -90.0F || f2 >= 90.0F;
      if (f2 < -60.0F) {
         f2 = -60.0F;
      }

      if (f2 >= 60.0F) {
         f2 = 60.0F;
      }

      this.renderYawOffset = rotationYaw - f2;
      if (f2 * f2 > 2500.0F) {
         this.renderYawOffset += f2 * 0.2F;
      }

      if (flag) {
         p_1101462 *= -1.0F;
      }

      return p_1101462;
   }

   @Overwrite
   public void jump() {
      double ymot = !.�?.getSetting("NoJumpP").getValue().booleanValue() && this.isPotionActive(Potion.jump) ? (double)(this.getJumpUpwardsMotion() + (float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F) : (double)this.getJumpUpwardsMotion();
      EventJump ej = new EventJump(ymot, true);
      EventBus.getInstance().call(ej);
      if (!ej.isCancelled()) {
         this.motionY = ej.getMotionY();
         if (!.�?.getSetting("NoJumpP2").getValue().booleanValue() && this.isPotionActive(Potion.jump)) {
            this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
         }

         if (this.isSprinting()) {
            float f = this.rotationYaw * 0.017453292F;
            this.motionX -= (double)(MathHelper.sin(f) * 0.2F);
            this.motionZ += (double)(MathHelper.cos(f) * 0.2F);
         }

         this.isAirBorne = true;
      }
   }

   @Overwrite
   public void onLivingUpdate() {
      if (this.jumpTicks > 0) {
         --this.jumpTicks;
      }

      if (this.newPosRotationIncrements > 0) {
         double d0 = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
         double d1 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
         double d2 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
         double d3 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
         this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.newPosRotationIncrements);
         this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
         --this.newPosRotationIncrements;
         this.setPosition(d0, d1, d2);
         this.setRotation(this.rotationYaw, this.rotationPitch);
      } else if (!this.isServerWorld()) {
         this.motionX *= 0.98D;
         this.motionY *= 0.98D;
         this.motionZ *= 0.98D;
      }

      if (Math.abs(this.motionX) < 0.005D) {
         this.motionX = 0.0D;
      }

      if (Math.abs(this.motionY) < 0.005D) {
         this.motionY = 0.0D;
      }

      if (Math.abs(this.motionZ) < 0.005D) {
         this.motionZ = 0.0D;
      }

      this.worldObj.theProfiler.startSection("ai");
      if (this.isMovementBlocked()) {
         this.isJumping = false;
         this.moveStrafing = 0.0F;
         this.moveForward = 0.0F;
         this.randomYawVelocity = 0.0F;
      } else if (this.isServerWorld()) {
         this.worldObj.theProfiler.startSection("newAi");
         this.updateEntityActionState();
         this.worldObj.theProfiler.endSection();
      }

      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("jump");
      if (this.isJumping) {
         if (this.isInWater()) {
            this.updateAITick();
         } else if (this.isInLava()) {
            this.handleJumpLava();
         } else if (this.onGround && this.jumpTicks == 0) {
            this.jump();
            if (.�?(.class).�?()) {
               this.jumpTicks = .�?.getValue().intValue();
            } else {
               this.jumpTicks = 10;
            }
         }
      } else {
         this.jumpTicks = 0;
      }

      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("travel");
      this.moveStrafing *= 0.98F;
      this.moveForward *= 0.98F;
      this.randomYawVelocity *= 0.9F;
      this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("push");
      if (!this.worldObj.isRemote) {
         this.collideWithNearbyEntities();
      }

      this.worldObj.theProfiler.endSection();
   }

   public void setJumpTicks(int a) {
      this.jumpTicks = a;
   }
}
