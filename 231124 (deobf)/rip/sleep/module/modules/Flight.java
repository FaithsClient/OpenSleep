package rip.sleep.module.modules;

import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtilD;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public class Flight extends Module {
   private final NumberValue<Number> c67309 = new NumberValue<Number>("Motion Speed", 15.0D, 0.0D, 20.0D, 0.5D);

   public Flight() {
      super("Flight", new String[0], ModuleType.c62580, ModuleType.c21190.c88511);
   }

   public void c83205() {
      super.c83205();
   }

   public void c71897() {
      super.c71897();
      PlayerUtilD.c38080(0.0D);
      mc.thePlayer.motionY = 0.0D;
   }

   @EventTarget
   void c73835(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.gameSettings.keyBindJump.isKeyDown()) {
         mc.thePlayer.motionY = 2.0D;
      }

      if (mc.gameSettings.keyBindSneak.isKeyDown()) {
         mc.thePlayer.motionY = -2.0D;
      }

      mc.thePlayer.motionY = 0.0D;
      PlayerUtilD.c38080(PlayerUtilD.c34428() * this.c67309.c53968().doubleValue());
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
