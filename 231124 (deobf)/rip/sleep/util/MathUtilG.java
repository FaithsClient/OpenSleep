package rip.sleep.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class MathUtilG {
   private final ThreadLocalRandom c91402 = ThreadLocalRandom.current();
   private static MathUtilG c10381;

   public static double c32169(double var0, double var2) {
      Random var5 = new Random();
      Value.c27574();
      double var6 = var2 - var0;
      double var8 = var5.nextDouble() * var6;
      if (var8 > var2) {
         var8 = var2;
      }

      double var10 = var8 + var0;
      if (var10 > var2) {
         var10 = var2;
      }

      return var10;
   }

   public double c42564(double var1, double var3) {
      return this.c91402.nextDouble(var1, var3);
   }

   public int c94885(int var1, int var2) {
      return this.c91402.nextInt(var1, var2);
   }

   public double c15294(double var1) {
      return this.c91402.nextGaussian() * var1;
   }

   public float c45271(float var1, float var2) {
      return (float)this.c91402.nextDouble((double)var1, (double)var2);
   }

   public double c74619(double var1, double var3, double var5, boolean var7, double var8) {
      ++var3;
      double var10 = Math.toRadians((double)System.currentTimeMillis() * var5 % 360.0D - 180.0D);
      double var12 = (Math.tanh(var10) + 1.0D) / 2.0D;
      double var14 = var1 - var3;
      var14 = var14 * var12;
      double var16 = var3 + var14;
      var16 = var16 * ThreadLocalRandom.current().nextDouble(var8, 1.0D);
      return Math.ceil(var16 * 1000.0D) / 1000.0D;
   }

   public static MathUtilG c25892() {
      Module[] var0 = Value.c27574();
      if (c10381 == null) {
         c10381 = new MathUtilG();
      }

      return c10381;
   }

   private static JSONException c43106(JSONException var0) {
      return var0;
   }
}
