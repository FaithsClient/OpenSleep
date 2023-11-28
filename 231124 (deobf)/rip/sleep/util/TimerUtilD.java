package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public final class TimerUtilD {
   private long c95673 = 0L;
   private long c88650 = 0L;

   public boolean c74172(double var1, boolean var3) {
      Module[] var4 = Value.c27574();
      if ((double)(System.currentTimeMillis() - this.c95673) > var1) {
         if (var3) {
            this.c13251();
         }

         return true;
      } else {
         return false;
      }
   }

   public void c13251() {
      this.c95673 = this.c32178();
   }

   public long c32178() {
      return System.nanoTime() / 1000000L;
   }

   public boolean c47779(double var1, boolean var3) {
      Module[] var4 = Value.c27574();
      if ((double)(System.currentTimeMillis() - this.c88650) > var1) {
         if (var3) {
            this.c24512();
         }

         return true;
      } else {
         return false;
      }
   }

   public long c77746() {
      return System.currentTimeMillis();
   }

   public final long c60515() {
      return this.c77746() - this.c88650;
   }

   public final void c24512() {
      this.c88650 = this.c77746();
   }

   private static JSONException c17617(JSONException var0) {
      return var0;
   }
}
