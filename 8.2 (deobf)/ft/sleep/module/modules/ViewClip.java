package ft.sleep.module.modules;

import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;

public class ViewClip extends Module {
   public static Numbers prayers$ = new Numbers("3rdPersonDistance", 4.0D, 1.0D, 10.0D, 0.01D);

   public ViewClip() {
      super("ft.sleep.module.modules.ViewClip", new String[]{"ft.sleep.module.modules.ViewClip"}, ModuleType.ignored$);
   }
}
