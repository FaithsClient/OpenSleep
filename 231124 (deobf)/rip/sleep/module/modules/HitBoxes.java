package rip.sleep.module.modules;

import antiLeak.Loader;
import net.minecraft.util.AxisAlignedBB;
import org.json.JSONException;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.EventTarget;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;

public class HitBoxes extends Module {
   public static int c98685;
   private boolean c35260;
   private boolean c8769;
   private static final String[] c22050;

   public HitBoxes() {
      String[] var1 = c22050;
      super(var1[1], new String[]{var1[4]}, ModuleType.c62580, ModuleType.c21190.c88511);
   }

   public void c83205() {
      this.c8769 = true;
   }

   @EventTarget
   private void c73835(MotionUpdateEvent var1) {
      this.c32929(var1);
   }

   public native void c32929(MotionUpdateEvent var1);

   private boolean c31833() {
      Module[] var1 = Value.c27574();
      if (mc.thePlayer.posY < 0.0D) {
         return false;
      } else {
         int var2 = 0;
         if (var2 < (int) mc.thePlayer.posY + 2) {
            AxisAlignedBB var3 = mc.thePlayer.getEntityBoundingBox().offset(0.0D, (double)(-var2), 0.0D);
            if (!mc.theWorld.getCollidingBoundingBoxes(mc.thePlayer, var3).isEmpty()) {
               return true;
            }

            var2 = var2 + 2;
         }

         return false;
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   static {
      Loader.registerNativesForClass(1, HitBoxes.class);
      c16927();
   }

   // $FF: synthetic method
   private static native void c16927();
}
