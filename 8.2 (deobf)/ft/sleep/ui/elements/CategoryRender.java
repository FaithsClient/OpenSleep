package ft.sleep.ui.elements;

import java.util.ArrayList;
import java.util.function.Consumer;

import ft.sleep.Client;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.util.animation.Animation;
import ft.sleep.util.animation.Direction;
import ft.sleep.util.data.Position2;
import native0.Loader;
import oh.yalan.NativeClass;

@NativeClass
public class CategoryRender {
   public ModuleType shaft$;
   public int starring$;
   public int puerto$;
   public int refused$;
   public int dollars$;
   public int nickel$;
   public int seeking$;
   public ArrayList assist$;
   public boolean luxury$;
   public float faced$ = Float.MAX_VALUE;
   public float forums$;
   public float cleanup$;
   public Animation favorite$ = new SmoothStepAnimation(0, Double.longBitsToDouble(0L), Direction.posted$);

   public CategoryRender(ModuleType saves, int kathy) {
      plastics.starring$ = (int)kathy;
      plastics.shaft$ = (ModuleType)saves;
      Object watched = new Position2(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object relief = 0;
      plastics.assist$ = new ArrayList();
      Client.();

      for(Object margaret : ModuleManager._trick()) {
         if (margaret._bennett().equals(saves)) {
            Object greece = Float.intBitsToFloat(0);
            Object invite = watched.function$ + (float)(relief % 2 == 0 ? 0 : 170);
            Object hardwood = watched.weather$ + (float)(relief % 2 == 0 ? plastics.nickel$ : plastics.seeking$);
            Object myanmar = new Position2(invite, hardwood, greece, 20.0F);
            Object spears = new ModuleRender(margaret, myanmar.function$, myanmar.weather$, myanmar.predict$);
            myanmar.guess$ = (float)spears.powered$;
            if (relief % 2 == 0) {
               plastics.nickel$ = (int)((float)plastics.nickel$ + myanmar.guess$ + 10.0F);
            } else {
               plastics.seeking$ = (int)((float)plastics.seeking$ + myanmar.guess$ + 10.0F);
            }

            plastics.assist$.add(spears);
            ++relief;
         }
      }

   }

   public native void __/* $FF was: */(int var1, int var2);

   public native String ___/* $FF was: */();

   public native boolean ____/* $FF was: */();

   public native void ___/* $FF was: */(boolean var1);

   public native void _/* $FF was: */(int var1, int var2, int var3);

   public native float ___/* $FF was: */();

   public native void __/* $FF was: */(int var1, int var2, int var3);

   public native void __/* $FF was: */(int var1, int var2, int var3);

   public native void _/* $FF was: */(char var1, int var2);

   public native boolean _/* $FF was: */(int var1, int var2);

   public static native void _/* $FF was: */(char var0, int var1, ModuleRender var2);

   public static native void _/* $FF was: */(int var0, int var1, int var2, ModuleRender var3);

   public static native void _/* $FF was: */(int var0, int var1, int var2, ModuleRender var3);

   public static native void _/* $FF was: */(int var0, int var1, ModuleRender var2);

   static {
      Loader.registerNativesForClass(5, CategoryRender.class);
   }

   public static Consumer _donation(int reflect, int tissue) {
      return CategoryRender::;
   }

   public static Consumer _caring(char lafivibo, int renosopo) {
      return CategoryRender::;
   }

   public static Consumer _mixture(int during, int rhythm, int yahoo) {
      return CategoryRender::;
   }

   public static Consumer _artist(int tetadose, int epacitep, int dayaluya) {
      return CategoryRender::;
   }
}
