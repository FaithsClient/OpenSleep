package rip.sleep.module.modules;

import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.values.NumberValue;

public class ViewClip extends Module {
   public static NumberValue<Number> c51775 = new NumberValue<Number>("3rdPersonDistance", 4.0D, 1.0D, 10.0D, 0.01D);

   public ViewClip() {
      super("View Clip", new String[]{"ViewClip"}, ModuleType.c12482, ModuleType.c21190.c94221);
   }
}
