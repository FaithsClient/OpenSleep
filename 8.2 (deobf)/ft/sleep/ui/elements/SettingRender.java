package ft.sleep.ui.elements;

import ft.sleep.api.value.Value;
import ft.sleep.util.data.Position2;
import native0.Loader;
import net.minecraft.client.gui.Gui;
import oh.yalan.NativeClass;

@NativeClass
public abstract class SettingRender extends Gui {
   public Value neutral$;
   public float poverty$;
   public float included$;
   public int sympathy$;
   public int counter$;
   public Position2 brothers$;
   public ModuleRender strange$;

   public SettingRender(Value asuzefus, float sufarota, float dodotama, int orosabob, int onededum, ModuleRender uvadatun) {
      pavivero.poverty$ = (float)sufarota;
      pavivero.included$ = (float)dodotama;
      pavivero.sympathy$ = (int)orosabob;
      pavivero.counter$ = (int)onededum;
      pavivero.neutral$ = (Value)asuzefus;
      pavivero.brothers$ = new Position2(pavivero.(), pavivero.(), (float)pavivero.getWidth(), (float)pavivero.getHeight());
      pavivero.strange$ = (ModuleRender)uvadatun;
   }

   public abstract void __/* $FF was: */(int var1, int var2);

   public abstract void __/* $FF was: */(int var1, int var2, int var3);

   public native void _/* $FF was: */(char var1, int var2);

   public abstract void __/* $FF was: */(int var1, int var2, int var3);

   public native float ___/* $FF was: */();

   public native float ___/* $FF was: */();

   public native int getHeight();

   public native int getWidth();

   public native void setX(int var1);

   public native void setY(int var1);

   public native int ___/* $FF was: */();

   static {
      Loader.registerNativesForClass(8, SettingRender.class);
   }
}
