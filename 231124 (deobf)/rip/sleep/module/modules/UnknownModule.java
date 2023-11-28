package rip.sleep.module.modules;

import antiLeak.Loader;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.module.Module;
import rip.sleep.util.TimerUtilB;
import rip.sleep.value.values.NumberValue;
import rip.sleep.module.ModuleType;

public class UnknownModule extends Module {
   private final NumberValue<Number> c7416;
   public TimerUtilB c6508;
   private static final String[] c97896;

   public UnknownModule() {
      String[] var1 = c97896;
      super(var1[2], new String[]{var1[0]}, ModuleType.c13050, ModuleType.c21190.c28329);
      this.c7416 = new NumberValue<Number>(var1[1], 1.0D, 0.0D, 1.0D, 0.05D);
      this.c6508 = new TimerUtilB();
   }

   public void c83205() {
      super.c83205();
      this.c6508.c69505();
   }

   @EventTarget
   public native void c84219(EndTickEvent var1);

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   static {
      Loader.registerNativesForClass(2, UnknownModule.class);
      c36481();
   }

   // $FF: synthetic method
   private static native void c36481();
}
