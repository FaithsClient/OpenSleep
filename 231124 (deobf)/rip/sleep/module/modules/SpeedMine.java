package rip.sleep.module.modules;

import antiLeak.Loader;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.struct.RotationStruct;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public class SpeedMine extends Module {
   private RotationStruct c3086;
   private int c63384;
   private int c33081;
   private int c37422;
   private boolean c87909;
   public NumberValue<Number> c8950;
   public NumberValue<Number> c21798;
   private static final String[] c30123;

   public SpeedMine() {
      String[] var1 = c30123;
      super(var1[1], new String[]{var1[3]}, ModuleType.c31770, ModuleType.c21190.c55384);
      this.c8950 = new NumberValue<Number>(var1[2], Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(50), Integer.valueOf(1));
      this.c21798 = new NumberValue<Number>(var1[0], Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(50), Integer.valueOf(1));
   }

   public void c83205() {
      this.c3086 = new RotationStruct(mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
   }

   public void c71897() {
      this.c87909 = false;
      mc.gameSettings.keyBindAttack.pressed = Mouse.isButtonDown(0);
   }

   private native void c9460();

   @EventTarget
   public void c97185(EndTickEvent var1) {
      this.c87909 = false;
      this.c9460();
   }

   @EventTarget
   public void c29421(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c87909) {
         var1.c6297(this.c3086.c14509());
         var1.c78602(this.c3086.c86023());
      }

   }

   public void c10082(BlockPos var1, EnumFacing var2) {
      mc.thePlayer.swingItem();
      mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, var1, var2));
      mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, var1, var2));
   }

   public boolean c78990(float var1, float var2, float var3) {
      return this.c64144(new BlockPos((double)var1, (double)var2, (double)var3)) != null;
   }

   public EnumFacing c64144(BlockPos var1) {
      Value.c27574();
      EnumFacing[] var3 = new EnumFacing[]{EnumFacing.UP, EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST, EnumFacing.DOWN};
      int var5 = var3.length;
      int var6 = 0;
      if (var6 < var5) {
         EnumFacing var7 = var3[var6];
         EntitySnowball var8 = new EntitySnowball(mc.theWorld);
         var8.posX = (double)var1.getX() + 0.5D;
         var8.posY = (double)var1.getY() + 0.5D;
         var8.posZ = (double)var1.getZ() + 0.5D;
         var8.posX += (double)var7.getDirectionVec().getX() * 0.5D;
         var8.posY += (double)var7.getDirectionVec().getY() * 0.5D;
         var8.posZ += (double)var7.getDirectionVec().getZ() * 0.5D;
         if (mc.thePlayer.canEntityBeSeen(var8)) {
            return var7;
         }

         ++var6;
      }

      return null;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   static {
      Loader.registerNativesForClass(5, SpeedMine.class);
      c56563();
   }

   // $FF: synthetic method
   private static native void c56563();
}
