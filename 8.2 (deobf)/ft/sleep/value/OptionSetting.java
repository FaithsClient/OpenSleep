package ft.sleep.value;

import ft.sleep.api.value.Option;
import ft.sleep.api.value.Value;
import native0.Loader;
import oh.yalan.NativeClass;

@NativeClass
public class OptionSetting extends SettingRender {
   public int champion$;
   public int bulletin$;
   public int keyboard$;

   public OptionSetting(Option featured, float savings, float trouble, int irish, int mailman, ModuleRender southern) {
      super((Value)featured, (float)savings, (float)trouble, (int)irish, (int)mailman, (ModuleRender)southern);
   }

   public native void __/* $FF was: */(int var1, int var2);

   public native void __/* $FF was: */(int var1, int var2, int var3);

   public native void __/* $FF was: */(int var1, int var2, int var3);

   static {
      Loader.registerNativesForClass(13, OptionSetting.class);
   }
}
