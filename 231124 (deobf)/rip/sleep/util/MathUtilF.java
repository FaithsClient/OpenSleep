package rip.sleep.util;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public final class MathUtilF {
   public static final float c97445 = 57.29578F;
   private static Random c74336 = new Random();
   private static final float[] c50442 = new float[4096];
   public static boolean c64514 = false;
   private static final float[] c31606 = new float[65536];

   public static int c4503(int var0, int var1) {
      return (int)(Math.random() * (double)(var0 - var1)) + var1;
   }

   public static double c96060(double var0, int var2) {
      return var0;
   }

   public static float c25789(float var0, float var1) {
      SecureRandom var2 = new SecureRandom();
      return var2.nextFloat() * (var1 - var0) + var0;
   }

   public static long c99759(int var0, int var1) {
      return (long)c37413(var0, var1 + 1);
   }

   public static int c37413(int var0, int var1) {
      Module[] var2 = Value.c27574();
      return var1 - var0 <= 0 ? var0 : var0 + c74336.nextInt(var1 - var0);
   }

   public static double c63324(double var0, double var2) {
      double var4 = 1.0D / var2;
      return (double)Math.round(var0 * var4) / var4;
   }

   public static boolean c24609(Double var0) {
      Module[] var1 = Value.c27574();
      return var0.doubleValue() == Math.floor(var0.doubleValue()) && !Double.isInfinite(var0.doubleValue());
   }

   public static float c83425(float var0, float var1, float var2) {
      Module[] var3 = Value.c27574();
      return var0 < var1 ? var1 : Math.min(var0, var2);
   }

   public static int c86103(int var0, int var1) {
      Module[] var2 = Value.c27574();
      return var0 > var1 ? var0 : (new Random()).nextInt(var1) + var0;
   }

   public static int c48527(int var0, int var1, int var2) {
      Module[] var3 = Value.c27574();
      return var0 < var1 ? var1 : Math.min(var0, var2);
   }

   public static double c23162(double var0, double var2) {
      Module[] var4 = Value.c27574();
      if (var2 == 0.0D) {
         return var0;
      } else if (var2 == 1.0D) {
         return (double)Math.round(var0);
      } else {
         double var5 = var2 / 2.0D;
         double var7 = Math.floor(var0 / var2) * var2;
         return var0 >= var7 + var5 ? (new BigDecimal(Math.ceil(var0 / var2) * var2)).doubleValue() : (new BigDecimal(var7)).doubleValue();
      }
   }

   public static float c491(float var0, float var1) {
      double var2 = 3.141592653D;
      double var4 = 1.0D / Math.sqrt(2.0D * var2 * (double)(var1 * var1));
      return (float)(var4 * Math.exp((double)(-(var0 * var0)) / (2.0D * (double)(var1 * var1))));
   }

   public static Double c94137(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static float c78391(float var0, float var1, double var2) {
      return c94137((double)var0, (double)var1, (double)((float)var2)).floatValue();
   }

   public static int c3745(int var0, int var1) {
      return (int)(Math.random() * (double)(var1 - var0) + (double)var0);
   }

   public static float c123(double var0) {
      return c64514 ? c50442[(int)(var0 * 651.8986206054688D) & 4095] : c31606[(int)(var0 * 10430.3779296875D) & '\uffff'];
   }

   public static float c83639(double var0) {
      return c64514 ? c50442[(int)((var0 + 1.5707963705062866D) * 651.8986206054688D) & 4095] : c31606[(int)(var0 * 10430.3779296875D + 16384.0D) & '\uffff'];
   }

   static {
      for(int var0 = 0; var0 < 65536; ++var0) {
         c31606[var0] = (float)Math.sin((double)var0 * 3.141592653589793D * 2.0D / 65536.0D);
      }

      for(int var1 = 0; var1 < 4096; ++var1) {
         c50442[var1] = (float)Math.sin((double)(((float)var1 + 0.5F) / 4096.0F * 6.2831855F));
      }

      for(int var2 = 0; var2 < 360; var2 += 90) {
         c50442[(int)((float)var2 * 11.377778F) & 4095] = (float)Math.sin((double)((float)var2 * 0.017453292F));
      }

   }

   private static JSONException c35421(JSONException var0) {
      return var0;
   }
}
