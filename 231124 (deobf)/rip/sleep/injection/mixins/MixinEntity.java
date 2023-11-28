package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import java.util.Random;
import rip.sleep.injection.in.IEntity;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rip.sleep.module.modules.MWAddons;
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.modules.FluidMove;
import rip.sleep.event.events.StrafeEvent;

@Mixin({Entity.class})
public abstract class MixinEntity implements IEntity {
   @Shadow
   public double field_70165_t;
   @Shadow
   public double field_70163_u;
   @Shadow
   public double field_70161_v;
   @Shadow
   public double field_70159_w;
   @Shadow
   public double field_70181_x;
   @Shadow
   public double field_70179_y;
   @Shadow
   protected Random field_70146_Z;
   @Shadow
   protected boolean field_71087_bX;
   @Shadow
   public float field_70177_z;
   @Shadow
   public float field_70125_A;
   @Shadow
   public boolean field_70122_E;
   @Shadow
   private int field_70150_b;
   @Shadow
   private int field_70151_c;
   @Shadow
   private AxisAlignedBB field_70121_D;
   @Shadow
   public boolean field_70145_X;
   @Shadow
   public float field_70138_W;
   @Shadow
   public boolean field_70134_J;
   @Shadow
   public boolean field_70123_F;
   @Shadow
   public boolean field_70124_G;
   @Shadow
   public boolean field_70132_H;
   @Shadow
   public float field_70140_Q;
   @Shadow
   public float field_82151_R;
   @Shadow
   public int field_70174_ab;
   @Shadow
   public Entity field_70154_o;
   @Shadow
   public World field_70170_p;
   public float cameraRotationPitch;
   public float cameraRotationYaw;
   public float prevCameraRotationPitch;
   public float prevCameraRotationYaw;
   @Shadow
   public float field_70126_B;
   @Shadow
   public float field_70127_C;

   public int getNextStepDistance() {
      return this.field_70150_b;
   }

   @Shadow
   protected abstract void func_70081_e(int var1);

   @Shadow
   public abstract boolean func_70026_G();

   @Shadow
   public abstract void func_85029_a(CrashReportCategory var1);

   @Shadow
   protected abstract void func_145775_I();

   @Shadow
   protected abstract void func_180429_a(BlockPos var1, Block var2);

   @Shadow
   public abstract AxisAlignedBB func_174813_aQ();

   @Shadow
   public abstract Vec3 func_174806_f(float var1, float var2);

   public void setNextStepDistance(int var1) {
      this.field_70150_b = var1;
   }

   public int getFire() {
      return this.field_70151_c;
   }

   public void setFire(int var1) {
      this.field_70151_c = var1;
   }

   public AxisAlignedBB getBoundingBox() {
      return this.field_70121_D;
   }

   @Inject(
      method = {"isInWater"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isInWater(CallbackInfoReturnable<Boolean> var1) {
      Sleep.getInstance();
      Sleep.c33759();
      FluidMove var2 = (FluidMove) ModuleManager.c25475(FluidMove.class);
      if (var2.c24622() && FluidMove.c73261.c1473().booleanValue() && var2.c44638()) {
         var1.setReturnValue(Boolean.valueOf(false));
      }

   }

   @Inject(
      method = {"isInLava"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isInLava(CallbackInfoReturnable<Boolean> var1) {
      Sleep.getInstance();
      Sleep.c33759();
      FluidMove var2 = (FluidMove) ModuleManager.c25475(FluidMove.class);
      if (var2.c24622() && FluidMove.c4346.c1473().booleanValue() && var2.c44638()) {
         var1.setReturnValue(Boolean.valueOf(false));
      }

   }

   @Inject(
      method = {"moveFlying"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void handleRotations(float var1, float var2, float var3, CallbackInfo var4) {
      float var5 = this.field_70177_z;
      StrafeEvent var6 = new StrafeEvent(var1, var2, var3, this.field_70177_z);
      if ((Entity)this instanceof EntityPlayerSP) {
         EventBus.getInstance().call(var6);
         var1 = var6.c3185();
         var2 = var6.c60583();
         var3 = var6.c69436();
         var5 = var6.c74012();
      }

      if (var6.c58917()) {
         var4.cancel();
      }

   }

   @Overwrite
   public void func_70082_c(float var1, float var2) {
      float var3 = this.field_70125_A;
      float var4 = this.field_70177_z;
      MWAddons var5 = (MWAddons) ModuleManager.c25475(MWAddons.class);
      if (!var5.c24622() || !MWAddons.c34018.c72319("McLook").c1473().booleanValue() || !Mouse.isButtonDown(2)) {
         this.field_70177_z = (float)((double)this.field_70177_z + (double)var1 * 0.15D);
         this.field_70125_A = (float)((double)this.field_70125_A - (double)var2 * 0.15D);
         this.field_70125_A = MathHelper.clamp_float(this.field_70125_A, -90.0F, 90.0F);
         this.field_70127_C += this.field_70125_A - var3;
         this.field_70126_B += this.field_70177_z - var4;
         this.cameraRotationYaw = this.field_70177_z;
         this.cameraRotationPitch = this.field_70125_A;
      }

      this.cameraRotationPitch = (float)((double)this.cameraRotationPitch - (double)var2 * 0.15D);
      this.cameraRotationPitch = MathHelper.clamp_float(this.cameraRotationPitch, -90.0F, 90.0F);
      this.cameraRotationYaw = (float)((double)this.cameraRotationYaw + (double)var1 * 0.15D);
   }

   public float getCameraYaw() {
      return this.cameraRotationYaw;
   }

   @Shadow
   private void func_174829_m() {
   }

   @Shadow
   public abstract boolean func_70093_af();

   @Shadow
   public abstract boolean func_70115_ae();

   @Shadow
   public abstract void func_174826_a(AxisAlignedBB var1);

   @Shadow
   public abstract boolean func_70090_H();

   @Shadow
   protected abstract boolean func_70041_e_();

   @Shadow
   public void func_85030_a(String var1, float var2, float var3) {
   }

   @Shadow
   protected abstract String func_145776_H();

   @Shadow
   protected void func_180433_a(double var1, boolean var3, Block var4, BlockPos var5) {
   }

   public float getCameraPitch() {
      return this.cameraRotationPitch;
   }
}
