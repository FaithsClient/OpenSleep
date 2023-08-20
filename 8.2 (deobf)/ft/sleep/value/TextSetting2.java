package ft.sleep.value;

import ft.sleep.api.value.TextValue;
import ft.sleep.api.value.Value;
import native0.Loader;
import oh.yalan.NativeClass;

@NativeClass
public class TextSetting2 extends SettingRender {
   public int livecam$;
   public int caution$;
   public int senegal$;

   public TextSetting2(TextValue epeyaday, float ucocasib, float afeboceg, int oriyoley, int gusopucu, ModuleRender gepopocu) {
      super((Value)epeyaday, (float)ucocasib, (float)afeboceg, (int)oriyoley, (int)gusopucu, (ModuleRender)gepopocu);
   }

   public native void __/* $FF was: */(int var1, int var2);

   public native void __/* $FF was: */(int var1, int var2, int var3);

   public native void __/* $FF was: */(int var1, int var2, int var3);

   public native void _/* $FF was: */(char var1, int var2);

   static {
      Loader.registerNativesForClass(14, TextSetting2.class);
   }
}
