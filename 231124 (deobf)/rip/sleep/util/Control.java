package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.value.Value;

public enum Control {
   None((int[])null),
   Shift(new int[]{42, 54}),
   Control(new int[]{29, 157}),
   Alt(new int[]{56, 184});

   private final int[] c87807;

   private Control(int[] var3) {
      this.c87807 = var3;
   }

   public int[] c38738() {
      return this.c87807;
   }

   public static rip.sleep.util.Control c68931(String var0) {
      Value.c27574();
      rip.sleep.util.Control[] var2 = values();
      int var3 = var2.length;
      int var4 = 0;
      if (var4 < var3) {
         rip.sleep.util.Control var5 = var2[var4];
         if (var5.name().toLowerCase().startsWith(var0.toLowerCase())) {
            return var5;
         }

         ++var4;
      }

      return None;
   }

   private static JSONException c32173(JSONException var0) {
      return var0;
   }
}
