package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class TimerUtilB {
   public long c90255 = 0L;
   public long c46161;

   public boolean c65833(long var1) {
      Module[] var3 = Value.c27574();
      return System.currentTimeMillis() - this.c90255 > var1;
   }

   public long c81815() {
      return System.nanoTime() / 1000000L;
   }

   public void c69505() {
      this.c90255 = System.currentTimeMillis();
   }

   public long c13178() {
      return this.c90255;
   }

   public void c96716(int var1) {
      this.c90255 = System.currentTimeMillis() + (long)var1;
   }

   public boolean c59305(long var1) {
      Module[] var3 = Value.c27574();
      return this.c81815() - this.c90255 >= var1;
   }

   public boolean c98583(long var1, boolean var3) {
      Module[] var4 = Value.c27574();
      if (System.currentTimeMillis() - this.c90255 > var1) {
         if (var3) {
            this.c69505();
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean c65553(float var1) {
      Module[] var2 = Value.c27574();
      return (float)(System.currentTimeMillis() - this.c90255) > var1;
   }

   public boolean c13761(Double var1) {
      Module[] var2 = Value.c27574();
      return (double)(System.currentTimeMillis() - this.c90255) > var1.doubleValue();
   }

   public boolean c60452(long var1) {
      Module[] var3 = Value.c27574();
      return System.currentTimeMillis() - this.c90255 >= var1;
   }

   public long c92312() {
      return System.nanoTime() / 1000000L;
   }

   public boolean c93066(float var1) {
      Module[] var2 = Value.c27574();
      return (float)this.c92312() >= var1;
   }

   public boolean c38247(double var1) {
      Module[] var3 = Value.c27574();
      return (double)(System.currentTimeMillis() - this.c90255) >= var1;
   }

   public long c35011() {
      return System.currentTimeMillis() - this.c90255;
   }

   public boolean c66772(float var1) {
      Module[] var2 = Value.c27574();
      return (float)(this.c92312() - this.c46161) >= var1;
   }

   public boolean c96926(float var1, boolean var2) {
      Module[] var3 = Value.c27574();
      if ((float)(System.currentTimeMillis() - this.c90255) >= var1) {
         if (var2) {
            this.c69505();
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean c6010(double var1) {
      Module[] var3 = Value.c27574();
      return (double)(this.c81815() - this.c90255) >= var1;
   }

   private static JSONException c43952(JSONException var0) {
      return var0;
   }
}
