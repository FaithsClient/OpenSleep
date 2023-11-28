package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import java.util.Objects;
import rip.sleep.injection.in.IEntityLivingBase;
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
import rip.sleep.event.events.JumpEvent;
import rip.sleep.event.events.EntityUpdateEvent;
import rip.sleep.module.modules.MWAddons;
import rip.sleep.Sleep;
import rip.sleep.module.modules.NoJumpDelay;
import rip.sleep.module.modules.Scaffold;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.modules.Camera;

@Mixin({EntityLivingBase.class})
public abstract class MixinEntityLivingBase extends Entity implements IEntityLivingBase {
   public float rotationPitchHead;
   public float prevRotationPitchHead;
   @Shadow
   private int field_70773_bE;
   @Shadow
   protected int field_70716_bi;
   @Shadow
   protected double field_70709_bj;
   @Shadow
   protected double field_70710_bk;
   @Shadow
   protected double field_110152_bk;
   @Shadow
   protected double field_70712_bm;
   @Shadow
   protected double field_70705_bn;
   @Shadow
   public boolean field_70703_bu;
   @Shadow
   public float field_70702_br;
   @Shadow
   public float field_70701_bs;
   @Shadow
   public float field_70759_as;
   @Shadow
   protected float field_70704_bt;
   @Shadow
   public float field_70761_aq;

   public MixinEntityLivingBase() {
      super((World)null);
   }

   @Shadow
   protected abstract float func_175134_bD();

   @Shadow
   public abstract boolean func_70613_aW();

   @Shadow
   protected abstract boolean func_70610_aX();

   @Shadow
   protected abstract void func_70629_bd();

   @Shadow
   protected abstract void func_180466_bG();

   @Shadow
   protected abstract void func_70626_be();

   @Shadow
   protected abstract void func_85033_bc();

   @Shadow
   public abstract PotionEffect func_70660_b(Potion var1);

   @Shadow
   public abstract boolean func_70644_a(Potion var1);

   @Shadow
   public abstract void func_70612_e(float var1, float var2);

   public int runGetArmSwingAnimationEnd() {
      return this.func_82166_i();
   }

   public int getJumpTicks() {
      return this.field_70773_bE;
   }

   @Inject(
      method = {"onEntityUpdate"},
      at = {@At("HEAD")}
   )
   public void onEntityUpdate(CallbackInfo var1) {
      EventBus.getInstance().call(new EntityUpdateEvent((EntityLivingBase)this));
      this.prevRotationPitchHead = this.rotationPitchHead;
   }

   public float getprevRotationPitchHead() {
      return this.prevRotationPitchHead;
   }

   public float getrotationPitchHead() {
      return this.rotationPitchHead;
   }

   public float setrotationPitchHead(float var1) {
      return this.rotationPitchHead = var1;
   }

   @Overwrite
   private int func_82166_i() {
      int var1;
      if (this.func_70644_a(Potion.digSpeed)) {
         var1 = 6 - (1 + this.func_70660_b(Potion.digSpeed).getAmplifier());
      } else {
         var1 = this.func_70644_a(Potion.digSlowdown) ? 6 + (1 + this.func_70660_b(Potion.digSlowdown).getAmplifier()) * 2 : 6;
      }

      if ((EntityLivingBase)this instanceof EntityPlayerSP) {
         Camera var10001 = (Camera) ModuleManager.c25475(Camera.class);
         var1 += Camera.c88109.c53968().intValue();
      }

      return var1;
   }

   @Overwrite
   protected float func_110146_f(float var1, float var2) {
      float var3 = this.rotationYaw;
      Sleep var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      Camera var4 = (Camera) ModuleManager.c25475(Camera.class);
      if ((EntityLivingBase)this instanceof EntityPlayerSP && var4.c24622() && Objects.equals(Camera.c94474.c54460(), "Astolfo2") && var4.c45000() != null) {
         var3 = var4.c45000().floatValue();
         this.field_70759_as = var4.c45000().floatValue();
      }

      float var5 = MathHelper.wrapAngleTo180_float(var1 - this.field_70761_aq);
      this.field_70761_aq += var5 * 0.24F;
      float var6 = MathHelper.wrapAngleTo180_float(var3 - this.field_70761_aq);
      if (var6 >= -90.0F && var6 < 90.0F) {
         boolean var10 = false;
      } else {
         boolean var9 = true;
      }

      if (var6 < -78.0F) {
         var6 = -78.0F;
      }

      if (var6 >= 78.0F) {
         var6 = 78.0F;
      }

      this.field_70761_aq = var3 - var6;
      if (var6 * var6 > 2500.0F) {
         this.field_70761_aq += var6 * 0.16F;
      }

      var2 = var2 * -1.2F;
      return var2;
   }

   @Overwrite
   public void func_70664_aZ() {
      double var1 = !MWAddons.c34018.c72319("NoJumpP").c1473().booleanValue() && this.func_70644_a(Potion.jump) ? (double)(this.func_175134_bD() + (float)(this.func_70660_b(Potion.jump).getAmplifier() + 1) * 0.1F) : (double)this.func_175134_bD();
      JumpEvent var3 = new JumpEvent(var1, true);
      EventBus.getInstance().call(var3);
      if (!var3.c58917()) {
         this.motionY = var3.c44349();
         if (!MWAddons.c34018.c72319("NoJumpP2").c1473().booleanValue() && this.func_70644_a(Potion.jump)) {
            this.motionY += (double)((float)(this.func_70660_b(Potion.jump).getAmplifier() + 1) * 0.1F);
         }

         if (this.isSprinting()) {
            float var4 = this.rotationYaw * 0.017453292F;
            this.motionX -= (double)(MathHelper.sin(var4) * 0.2F);
            this.motionZ += (double)(MathHelper.cos(var4) * 0.2F);
         }

         this.isAirBorne = true;
      }
   }

   @Overwrite
   public void func_70636_d() {
      if (this.field_70773_bE > 0) {
         --this.field_70773_bE;
      }

      if (this.field_70716_bi > 0) {
         double var1 = this.posX + (this.field_70709_bj - this.posX) / (double)this.field_70716_bi;
         double var3 = this.posY + (this.field_70710_bk - this.posY) / (double)this.field_70716_bi;
         double var5 = this.posZ + (this.field_110152_bk - this.posZ) / (double)this.field_70716_bi;
         double var7 = MathHelper.wrapAngleTo180_double(this.field_70712_bm - (double)this.rotationYaw);
         this.rotationYaw = (float)((double)this.rotationYaw + var7 / (double)this.field_70716_bi);
         this.rotationPitch = (float)((double)this.rotationPitch + (this.field_70705_bn - (double)this.rotationPitch) / (double)this.field_70716_bi);
         --this.field_70716_bi;
         this.setPosition(var1, var3, var5);
         this.setRotation(this.rotationYaw, this.rotationPitch);
      } else if (!this.func_70613_aW()) {
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
      if (this.func_70610_aX()) {
         this.field_70703_bu = false;
         this.field_70702_br = 0.0F;
         this.field_70701_bs = 0.0F;
         this.field_70704_bt = 0.0F;
      } else if (this.func_70613_aW()) {
         this.worldObj.theProfiler.startSection("newAi");
         this.func_70626_be();
         this.worldObj.theProfiler.endSection();
      }

      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("jump");
      if (this.field_70703_bu) {
         if (this.isInWater()) {
            this.func_70629_bd();
         } else if (this.isInLava()) {
            this.func_180466_bG();
         } else if (this.onGround && this.field_70773_bE == 0) {
            this.func_70664_aZ();
            if (ModuleManager.c25475(NoJumpDelay.class).c24622() && !ModuleManager.c25475(Scaffold.class).c24622()) {
               this.field_70773_bE = NoJumpDelay.c62200.c53968().intValue();
            } else {
               this.field_70773_bE = 10;
            }
         }
      } else {
         this.field_70773_bE = 0;
      }

      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("travel");
      this.field_70702_br *= 0.98F;
      this.field_70701_bs *= 0.98F;
      this.field_70704_bt *= 0.9F;
      this.func_70612_e(this.field_70702_br, this.field_70701_bs);
      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("push");
      if (!this.worldObj.isRemote) {
         this.func_85033_bc();
      }

      this.worldObj.theProfiler.endSection();
   }

   public void setJumpTicks(int var1) {
      this.field_70773_bE = var1;
   }
}
