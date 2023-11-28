package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public final class TimerUtilE {
   public long c18563 = 0L;

   public int c28452(int var1) {
      return 1000 / var1;
   }

   public long c25509() {
      return System.nanoTime() / 1000000L;
   }

   public long c3776() {
      return System.currentTimeMillis() - this.c18563;
   }

   public boolean c28075(long var1) {
      Module[] var3 = Value.c27574();
      return this.c25509() - this.c18563 >= var1;
   }

   public long c4658() {
      return System.currentTimeMillis() - this.c18563;
   }

   public void c49494() {
      this.c18563 = this.c25509();
   }

   public void c20611() {
      this.c18563 = System.currentTimeMillis();
   }

   public void c68332(long var1) {
      this.c18563 = var1;
   }

   private static JSONException c3244(JSONException var0) {
      return var0;
   }
}
