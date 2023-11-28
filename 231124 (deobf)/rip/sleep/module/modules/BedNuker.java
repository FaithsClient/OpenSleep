package rip.sleep.module.modules;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.RotateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.struct.RotationStruct;
import rip.sleep.struct.VectorStructB;
import rip.sleep.util.RotationUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class BedNuker extends Module {
   private static BlockPos c39853;
   private RotationStruct c78393;
   public final BooleanValue c73773 = new BooleanValue("Home", true);
   public final BooleanValue c63645 = new BooleanValue("Mouse", true);
   public final BooleanValue c38834 = new BooleanValue("Hypixel", true);
   private VectorStructB c38144;
   private NumberValue<Number> c53762 = new NumberValue<Number>("Range", 4.0D, 1.0D, 6.0D, 1.0D);

   public BedNuker() {
      super("Bed Nuker", new String[]{"BedNuker"}, ModuleType.c31770, ModuleType.c21190.c55384);
   }

   public void c71897() {
      mc.gameSettings.keyBindAttack.pressed = Mouse.isButtonDown(0);
   }

   public void c83205() {
      c39853 = null;
      this.c78393 = new RotationStruct(mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
   }

   @EventTarget
   public void c94747(RotateEvent var1) {
      double var2 = mc.thePlayer.getDistance(var1.c19049(), var1.c10534(), var1.c26301());
      if (var2 > 40.0D) {
         this.c38144 = new VectorStructB(var1.c19049(), var1.c10534(), var1.c26301());
      }

   }

   @EventTarget
   public void c86165(EndTickEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c38144 == null || mc.thePlayer.getDistanceSq(this.c38144.c71335(), this.c38144.c20755(), this.c38144.c96564()) >= 1225.0D || !this.c73773.c1473().booleanValue()) {
         if (!c23171(KillAura.class).c24622() || KillAura.c19685 == null) {
            c39853 = null;
            boolean var3 = false;
            float var4 = this.c78393.c14509();
            float var5 = this.c78393.c86023();
            double var6 = mc.thePlayer.posX - this.c53762.c53968().doubleValue();
            if (var6 <= mc.thePlayer.posX + this.c53762.c53968().doubleValue()) {
               double var8 = mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight() - this.c53762.c53968().doubleValue();
               if (var8 <= mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight() + this.c53762.c53968().doubleValue()) {
                  double var10 = mc.thePlayer.posZ - this.c53762.c53968().doubleValue();
                  if (var10 <= mc.thePlayer.posZ + this.c53762.c53968().doubleValue()) {
                     BlockPos var12 = new BlockPos(var6, var8, var10);
                     if (mc.theWorld.getBlockState(var12).getBlock() instanceof BlockBed && !var3) {
                        c39853 = var12;
                        if (this.c38834.c1473().booleanValue() && this.c87059(c39853)) {
                           BlockPos var13 = var12.add(0, 1, 0);
                           mc.objectMouseOver = new MovingObjectPosition(new Vec3((double)var13.getX() + 0.5D, (double)(var13.getY() + 1), (double)var13.getZ() + 0.5D), EnumFacing.UP, var13);
                           if (!this.c63645.c1473().booleanValue() || Mouse.isButtonDown(0)) {
                              mc.gameSettings.keyBindAttack.pressed = true;
                              float[] var14 = RotationUtilA.c16718((double)var13.getX() + 0.5D, (double)(var13.getY() + 1), (double)var13.getZ() + 0.5D);
                              var4 = var14[0];
                              var5 = var14[1];
                           }
                        }

                        mc.objectMouseOver = new MovingObjectPosition(new Vec3((double)var12.getX() + 0.5D, (double)var12.getY() + 0.5D, (double)var12.getZ() + 0.5D), EnumFacing.UP, c39853);
                        if (!this.c63645.c1473().booleanValue() || Mouse.isButtonDown(0)) {
                           mc.gameSettings.keyBindAttack.pressed = true;
                           float[] var19 = RotationUtilA.c16718((double)var12.getX() + 0.5D, (double)var12.getY() + 0.5D, (double)var12.getZ() + 0.5D);
                           var4 = var19[0];
                           var5 = var19[1];
                        }

                        var3 = true;
                     }

                     ++var10;
                  }

                  ++var8;
               }

               ++var6;
            }

            mc.gameSettings.keyBindAttack.pressed = Mouse.isButtonDown(0);
            this.c78393.c87872(var4, var5);
         }
      }
   }

   public boolean c87059(BlockPos var1) {
      Value.c27574();
      BlockPos var3 = var1.add(0, 1, 0);
      Block var4 = mc.theWorld.getBlockState(var3).getBlock();
      return !(var4 instanceof BlockAir) && !(var4 instanceof BlockLiquid);
   }

   public static boolean c68025() {
      return c39853 != null;
   }

   @EventTarget
   public void c42000(MotionUpdateEvent var1) {
      Sleep var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      if (ModuleManager.c25475(KillAura.class).c24622() && KillAura.c79073() != null) {
         c39853 = null;
      }

      if (c39853 != null) {
         var1.c6297(this.c78393.c14509());
         var1.c78602(this.c78393.c86023());
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
