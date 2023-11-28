package rip.sleep.unmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.interfaces.IControl;
import rip.sleep.module.Module;
import rip.sleep.util.Control;
import rip.sleep.value.Value;

public class c2671 {
   private static final HashMap<Integer, ArrayList<c60393>> c32960 = new HashMap();
   private static final List<Control> c77308 = new ArrayList();

   public static void c56115(boolean var0) {
      boolean var2 = Keyboard.getEventKeyState();
      Value.c27574();
      int var3 = Keyboard.getEventKey();
      c93206(var3, var2);
      if (var3 != 0) {
         if (var3 == 1) {
            c77308.clear();
         }

         if (c24853(var3)) {
            ArrayList var4 = new ArrayList();
            var4.addAll((Collection)c32960.get(Integer.valueOf(var3)));
            Iterator var5 = var4.iterator();
            if (var5.hasNext()) {
               c60393 var6 = (c60393)var5.next();
               if (c78282(var6.c86975())) {
                  if (var2) {
                     var6.c17835();
                  }

                  var6.c95105();
               }
            }

         }
      }
   }

   private static void c93206(int var0, boolean var1) {
      Value.c27574();
      Control[] var3 = Control.values();
      int var4 = var3.length;
      int var5 = 0;
      if (var5 < var4) {
         Control var6 = var3[var5];
         if (!var6.equals(Control.None)) {
            int[] var7 = var6.c38738();
            int var8 = var7.length;
            int var9 = 0;
            if (var9 < var8) {
               int var10 = var7[var9];
               if (var10 == var0) {
                  boolean var11 = c77308.contains(var6);
                  if (var1) {
                     if (var11) {
                        return;
                     }

                     c77308.add(var6);
                  }

                  if (var11) {
                     c77308.remove(var6);
                  }

                  return;
               }

               ++var9;
            }
         }

         ++var5;
      }

   }

   public static boolean c17363(c60393 var0) {
      Value.c27574();
      int var2 = var0.c86140();
      boolean var3 = c24853(var2);
      return var3 && ((ArrayList)c32960.get(Integer.valueOf(var2))).contains(var0);
   }

   public static void c8494(c60393 var0) {
      Value.c27574();
      int var2 = var0.c86140();
      boolean var3 = c24853(var2);
      if (var3) {
         if (((ArrayList)c32960.get(Integer.valueOf(var2))).contains(var0)) {
            return;
         }

         ((ArrayList)c32960.get(Integer.valueOf(var2))).add(var0);
      }

      ArrayList var4 = new ArrayList();
      var4.add(var0);
      c32960.put(Integer.valueOf(var2), var4);
   }

   public static void c46052(IControl var0, c60393 var1, c60393 var2) {
      Value.c27574();
      int var4 = var1.c86140();
      int var5 = var2.c86140();
      boolean var6 = c24853(var4);
      Iterator var7 = ((ArrayList)c32960.get(Integer.valueOf(var4))).iterator();
      if (var7.hasNext()) {
         c60393 var8 = (c60393)var7.next();
         if (var8.c20943().equals(var0)) {
            var8.c94611(var2);
         }
      }

   }

   public static void c20795(IControl var0, c60393 var1) {
      int var3 = var1.c86140();
      Value.c27574();
      boolean var4 = c24853(var3);
      ArrayList var5 = (ArrayList)c32960.get(Integer.valueOf(var3));
      int var6 = -1;
      int var7 = 0;
      Iterator var8 = var5.iterator();
      if (var8.hasNext()) {
         c60393 var9 = (c60393)var8.next();
         if (var9.c20943().equals(var0)) {
            var6 = var7;
         }

         ++var7;
      }

      if (var6 >= 0) {
         var5.remove(var6);
      }

   }

   public static boolean c24853(int var0) {
      return c32960.containsKey(Integer.valueOf(var0));
   }

   static boolean c78282(Control var0) {
      Module[] var1 = Value.c27574();
      return var0 == null || var0 == Control.None || c77308.contains(var0);
   }

   private static JSONException c43758(JSONException var0) {
      return var0;
   }
}
