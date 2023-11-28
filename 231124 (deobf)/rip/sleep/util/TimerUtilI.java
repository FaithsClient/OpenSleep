package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class TimerUtilI {
   private long c80032 = 0L;
   private int c75490;
   private double c64963;
   private double c41959;
   private boolean c45071;
   private double c11606;

   public void c8775() {
      this.c80032 = System.currentTimeMillis();
   }

   public void c21027() {
      Value.c27574();
      double var2 = c69928((double)this.c75490 / this.c64963, this.c80032);
      if (this.c45071) {
         var2 = 100.0D - var2;
      }

      this.c11606 = c31412(var2, (double)this.c75490);
      this.c41959 = var2;
   }

   public static double c69928(double var0, long var2) {
      double var5 = (double)(System.currentTimeMillis() - var2);
      Value.c27574();
      double var7 = var5 / var0 * 100.0D;
      return var7 <= 100.0D ? var7 : 100.0D;
   }

   public boolean c72231() {
      Module[] var1 = Value.c27574();
      return this.c45071 ? this.c84837() == 0.0D : this.c84837() == 100.0D || this.c80032 == 0L;
   }

   public static double c31412(double var0, double var2) {
      return var2 / 100.0D * var0;
   }

   public double c25926() {
      return this.c11606;
   }

   public double c48086() {
      return this.c64963;
   }

   public int c75531() {
      return this.c75490;
   }

   public void c8498(double var1) {
      this.c64963 = var1;
   }

   public void c49238(int var1) {
      this.c75490 = var1;
   }

   public double c84837() {
      return this.c41959;
   }

   public void c37901(boolean var1) {
      this.c45071 = var1;
   }

   public boolean c38170() {
      return this.c45071;
   }

   private static JSONException c29076(JSONException var0) {
      return var0;
   }
}
