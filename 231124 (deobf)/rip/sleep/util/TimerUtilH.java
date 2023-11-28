package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class TimerUtilH {
   public long c45043 = System.currentTimeMillis();

   public void c12425() {
      this.c45043 = System.currentTimeMillis();
   }

   public boolean c46820(long var1, boolean var3) {
      Module[] var4 = Value.c27574();
      if (System.currentTimeMillis() - this.c45043 > var1) {
         if (var3) {
            this.c12425();
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean c10241(long var1) {
      Module[] var3 = Value.c27574();
      return System.currentTimeMillis() - this.c45043 > var1;
   }

   public long c65047() {
      return System.currentTimeMillis() - this.c45043;
   }

   public void c45804(long var1) {
      this.c45043 = var1;
   }

   private static JSONException c32102(JSONException var0) {
      return var0;
   }
}
