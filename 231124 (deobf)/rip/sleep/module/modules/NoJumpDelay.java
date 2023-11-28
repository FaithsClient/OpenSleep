package rip.sleep.module.modules;

import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;
import rip.sleep.module.ModuleType;

public class NoJumpDelay extends Module {
   public static final NumberValue<Number> c62200 = new NumberValue<Number>("Min Delay", 0.0D, 0.0D, 10.0D, 1.0D);
   private BooleanValue c4956 = new BooleanValue("Set Suffix", true);

   public NoJumpDelay() {
      super("No Jump Delay", new String[]{"NoJumpDelay", "NoJumpDelay"}, ModuleType.c62580, ModuleType.c21190.c37885);
   }

   @EventTarget
   void c73835(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c4956.c1473().booleanValue()) {
         this.c2159("" + c62200.c53968().intValue());
      }

      this.c2159("");
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
