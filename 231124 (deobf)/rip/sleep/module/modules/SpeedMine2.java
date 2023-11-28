package rip.sleep.module.modules;

import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public class SpeedMine2 extends Module {
   public NumberValue<Number> c45204 = new NumberValue<Number>("Ticks", 2.0D, 0.0D, 9.0D, 1.0D);
   public NumberValue<Number> c44480 = new NumberValue<Number>("Break Delay", 0.0D, 0.0D, 5.0D, 1.0D);
   public NumberValue<Number> c50114 = new NumberValue<Number>("Block Break", 0.3D, 0.1D, 0.9D, 0.05D);

   public SpeedMine2() {
      super("Speed Mine2", new String[]{"SpeedMine2"}, ModuleType.c13050, ModuleType.c21190.c28329);
   }

   @EventTarget
   public void c40328(EndTickEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer.ticksExisted % this.c45204.c53968().intValue() == 0) {
         mc.playerController.blockHitDelay = mc.playerController.blockHitDelay > this.c44480.c53968().intValue() ? this.c44480.c53968().intValue() : mc.playerController.blockHitDelay;
         if (mc.playerController.curBlockDamageMP > 1.0F - this.c50114.c53968().floatValue()) {
            mc.playerController.curBlockDamageMP = 1.0F;
         }
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
