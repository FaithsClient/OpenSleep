package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class TimerUtilF {
   public long c98480 = System.currentTimeMillis();
   private long c43373;

   public TimerUtilF() {
      this.c61208();
   }

   public void c99119() {
      this.c98480 = System.currentTimeMillis();
   }

   public long c75337() {
      return System.currentTimeMillis() - this.c43373;
   }

   public void c61208() {
      this.c43373 = System.currentTimeMillis();
   }

   public boolean c35522(long var1, boolean var3) {
      Module[] var4 = Value.c27574();
      if (System.currentTimeMillis() - this.c98480 > var1) {
         if (var3) {
            this.c99119();
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean c93833(double var1, boolean var3) {
      Module[] var4 = Value.c27574();
      if ((double)(System.currentTimeMillis() - this.c98480) > var1) {
         if (var3) {
            this.c99119();
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean c75125(long var1) {
      Module[] var3 = Value.c27574();
      return System.currentTimeMillis() - this.c98480 > var1;
   }

   public long c60529() {
      return System.currentTimeMillis() - this.c98480;
   }

   public void c74512(long var1) {
      this.c98480 = var1;
   }

   public boolean c59715(float var1) {
      Module[] var2 = Value.c27574();
      return (float)(this.c60529() - this.c98480) >= var1;
   }

   public boolean c29988(Double var1) {
      Module[] var2 = Value.c27574();
      return (double)((float)(this.c60529() - this.c98480)) >= var1.doubleValue();
   }

   private long c45620() {
      return System.nanoTime() / 1000000L;
   }

   public boolean c87813(double var1) {
      Module[] var3 = Value.c27574();
      return (double)(this.c45620() - this.c98480) >= var1;
   }

   private static JSONException c38960(JSONException var0) {
      return var0;
   }
}
