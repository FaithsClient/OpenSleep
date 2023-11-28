package rip.sleep.util;

import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class MathUtilH {
   public static final float c22242 = 3.1415927F;
   public static final float c2554 = 1.5707964F;
   public static final float c87186 = 0.7853982F;
   public static final float c30958 = 6.2831855F;
   private static final float c26054 = -0.5F;
   private static final float c76096 = 1.5F;
   private static final float c85397 = -1.5F;
   private static final float c35768 = 0.5F;
   private static final float c54641 = 1.0F;
   private static final float c40710 = -2.5F;
   private static final float c76750 = 2.0F;
   private static final float c115 = -0.5F;
   private static final float c56746 = -0.5F;
   private static final float c83582 = 0.0F;
   private static final float c30065 = 0.5F;
   private static final float c65708 = 0.0F;
   private static final float c42043 = 0.0F;
   private static final float c70906 = 1.0F;
   private static final float c34941 = 0.0F;
   private static final float c63858 = 0.0F;

   public static float c62772(float var0, float var1) {
      return var0 / ((1.0F / var1 - 2.0F) * (1.0F - var0) + 1.0F);
   }

   public static float c93538(float var0, float var1) {
      Value.c27574();
      float var3 = (1.0F / var1 - 2.0F) * (1.0F - 2.0F * var0);
      return (double)var0 < 0.5D ? var0 / (var3 + 1.0F) : (var3 - var0) / (var3 - 1.0F);
   }

   public static float c52224(float var0, float var1) {
      Module[] var2 = Value.c27574();
      return var1 < var0 ? 0.0F : 1.0F;
   }

   public static float c63124(float var0, float var1, float var2) {
      Module[] var3 = Value.c27574();
      return var2 >= var0 && var2 < var1 ? 1.0F : 0.0F;
   }

   public static float c78065(float var0, float var1, float var2, float var3, float var4) {
      Module[] var5 = Value.c27574();
      if (var4 >= var0 && var4 < var3) {
         if (var4 >= var1) {
            if (var4 < var2) {
               return 1.0F;
            } else {
               var4 = (var4 - var2) / (var3 - var2);
               return 1.0F - var4 * var4 * (3.0F - 2.0F * var4);
            }
         } else {
            var4 = (var4 - var0) / (var1 - var0);
            return var4 * var4 * (3.0F - 2.0F * var4);
         }
      } else {
         return 0.0F;
      }
   }

   public static float c42512(float var0, float var1, float var2) {
      Module[] var3 = Value.c27574();
      if (var2 < var0) {
         return 0.0F;
      } else if (var2 >= var1) {
         return 1.0F;
      } else {
         var2 = (var2 - var0) / (var1 - var0);
         return var2 * var2 * (3.0F - 2.0F * var2);
      }
   }

   public static float c14576(float var0) {
      var0 = 1.0F - var0;
      return (float)Math.sqrt((double)(1.0F - var0 * var0));
   }

   public static float c10305(float var0) {
      return 1.0F - (float)Math.sqrt((double)(1.0F - var0 * var0));
   }

   public static float c84479(float var0, float var1, float var2) {
      Module[] var3 = Value.c27574();
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   public static int c42982(int var0, int var1, int var2) {
      Module[] var3 = Value.c27574();
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   public static double c16201(double var0, double var2) {
      int var5 = (int)(var0 / var2);
      Value.c27574();
      var0 = var0 - (double)var5 * var2;
      return var0 < 0.0D ? var0 + var2 : var0;
   }

   public static float c66583(float var0, float var1) {
      Value.c27574();
      int var3 = (int)(var0 / var1);
      var0 = var0 - (float)var3 * var1;
      return var0 < 0.0F ? var0 + var1 : var0;
   }

   public static int c41722(int var0, int var1) {
      Value.c27574();
      int var3 = var0 / var1;
      var0 = var0 - var3 * var1;
      return var0 < 0 ? var0 + var1 : var0;
   }

   public static float c82646(float var0) {
      Value.c27574();
      float var2 = c66583(var0, 1.0F);
      return 2.0F * ((double)var2 < 0.5D ? var2 : 1.0F - var2);
   }

   public static float c14805(float var0, float var1, float var2) {
      return var1 + var0 * (var2 - var1);
   }

   public static int c49206(float var0, int var1, int var2) {
      return (int)((float)var1 + var0 * (float)(var2 - var1));
   }

   public static int c2940(float var0, int var1, int var2) {
      int var3 = var1 >> 24 & 255;
      int var4 = var1 >> 16 & 255;
      int var5 = var1 >> 8 & 255;
      int var6 = var1 & 255;
      int var7 = var2 >> 24 & 255;
      int var8 = var2 >> 16 & 255;
      int var9 = var2 >> 8 & 255;
      int var10 = var2 & 255;
      var3 = c49206(var0, var3, var7);
      var4 = c49206(var0, var4, var8);
      var5 = c49206(var0, var5, var9);
      var6 = c49206(var0, var6, var10);
      return var3 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   public static int c20798(float var0, float var1, int var2, int var3, int var4, int var5) {
      int var8 = var2 >> 24 & 255;
      int var9 = var2 >> 16 & 255;
      int var10 = var2 >> 8 & 255;
      int var11 = var2 & 255;
      int var12 = var3 >> 24 & 255;
      int var13 = var3 >> 16 & 255;
      int var14 = var3 >> 8 & 255;
      int var15 = var3 & 255;
      int var16 = var4 >> 24 & 255;
      int var17 = var4 >> 16 & 255;
      int var18 = var4 >> 8 & 255;
      int var19 = var4 & 255;
      int var20 = var5 >> 24 & 255;
      int var21 = var5 >> 16 & 255;
      int var22 = var5 >> 8 & 255;
      int var23 = var5 & 255;
      float var24 = 1.0F - var0;
      float var25 = 1.0F - var1;
      float var6 = var24 * (float)var8 + var0 * (float)var12;
      float var7 = var24 * (float)var16 + var0 * (float)var20;
      int var26 = (int)(var25 * var6 + var1 * var7);
      var6 = var24 * (float)var9 + var0 * (float)var13;
      var7 = var24 * (float)var17 + var0 * (float)var21;
      int var27 = (int)(var25 * var6 + var1 * var7);
      var6 = var24 * (float)var10 + var0 * (float)var14;
      var7 = var24 * (float)var18 + var0 * (float)var22;
      int var28 = (int)(var25 * var6 + var1 * var7);
      var6 = var24 * (float)var11 + var0 * (float)var15;
      var7 = var24 * (float)var19 + var0 * (float)var23;
      int var29 = (int)(var25 * var6 + var1 * var7);
      return var26 << 24 | var27 << 16 | var28 << 8 | var29;
   }

   public static int c82337(int var0) {
      int var1 = var0 >> 16 & 255;
      int var2 = var0 >> 8 & 255;
      int var3 = var0 & 255;
      return (int)((float)var1 * 0.299F + (float)var2 * 0.587F + (float)var3 * 0.114F);
   }

   public static float c28546(float var0, int var1, float[] var2) {
      Value.c27574();
      int var5 = var1 - 3;
      if (var5 < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         var0 = c84479(var0, 0.0F, 1.0F) * (float)var5;
         int var4 = (int)var0;
         if (var4 > var1 - 4) {
            var4 = var1 - 4;
         }

         var0 = var0 - (float)var4;
         float var6 = var2[var4];
         float var7 = var2[var4 + 1];
         float var8 = var2[var4 + 2];
         float var9 = var2[var4 + 3];
         float var13 = -0.5F * var6 + 1.5F * var7 + -1.5F * var8 + 0.5F * var9;
         float var12 = 1.0F * var6 + -2.5F * var7 + 2.0F * var8 + -0.5F * var9;
         float var11 = -0.5F * var6 + 0.0F * var7 + 0.5F * var8 + 0.0F * var9;
         float var10 = 0.0F * var6 + 1.0F * var7 + 0.0F * var8 + 0.0F * var9;
         return ((var13 * var0 + var12) * var0 + var11) * var0 + var10;
      }
   }

   public static float c82958(float var0, int var1, int[] var2, int[] var3) {
      Value.c27574();
      int var6 = var1 - 3;
      if (var6 < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         int var5 = 0;
         if (var5 < var6) {
            if ((float)var2[var5 + 1] > var0) {
               ;
            }

            ++var5;
         }

         if (var5 > var1 - 3) {
            var5 = var1 - 3;
         }

         float var15 = (var0 - (float)var2[var5]) / (float)(var2[var5 + 1] - var2[var5]);
         --var5;
         if (var5 < 0) {
            var5 = 0;
            var15 = 0.0F;
         }

         float var7 = (float)var3[var5];
         float var8 = (float)var3[var5 + 1];
         float var9 = (float)var3[var5 + 2];
         float var10 = (float)var3[var5 + 3];
         float var14 = -0.5F * var7 + 1.5F * var8 + -1.5F * var9 + 0.5F * var10;
         float var13 = 1.0F * var7 + -2.5F * var8 + 2.0F * var9 + -0.5F * var10;
         float var12 = -0.5F * var7 + 0.0F * var8 + 0.5F * var9 + 0.0F * var10;
         float var11 = 0.0F * var7 + 1.0F * var8 + 0.0F * var9 + 0.0F * var10;
         return ((var14 * var15 + var13) * var15 + var12) * var15 + var11;
      }
   }

   public static int c26175(float var0, int var1, int[] var2) {
      Value.c27574();
      int var5 = var1 - 3;
      if (var5 < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         var0 = c84479(var0, 0.0F, 1.0F) * (float)var5;
         int var4 = (int)var0;
         if (var4 > var1 - 4) {
            var4 = var1 - 4;
         }

         var0 = var0 - (float)var4;
         int var14 = 0;
         int var15 = 0;
         if (var15 < 4) {
            int var16 = var15 * 8;
            float var6 = (float)(var2[var4] >> var16 & 255);
            float var7 = (float)(var2[var4 + 1] >> var16 & 255);
            float var8 = (float)(var2[var4 + 2] >> var16 & 255);
            float var9 = (float)(var2[var4 + 3] >> var16 & 255);
            float var13 = -0.5F * var6 + 1.5F * var7 + -1.5F * var8 + 0.5F * var9;
            float var12 = 1.0F * var6 + -2.5F * var7 + 2.0F * var8 + -0.5F * var9;
            float var11 = -0.5F * var6 + 0.0F * var7 + 0.5F * var8 + 0.0F * var9;
            float var10 = 0.0F * var6 + 1.0F * var7 + 0.0F * var8 + 0.0F * var9;
            int var17 = (int)(((var13 * var0 + var12) * var0 + var11) * var0 + var10);
            if (var17 < 0) {
               var17 = 0;
            }

            if (var17 > 255) {
               var17 = 255;
            }

            var14 |= var17 << var16;
            ++var15;
         }

         return var14;
      }
   }

   public static int c85466(int var0, int var1, int[] var2, int[] var3) {
      Value.c27574();
      int var6 = var1 - 3;
      if (var6 < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         int var5 = 0;
         if (var5 < var6) {
            if (var2[var5 + 1] > var0) {
               ;
            }

            ++var5;
         }

         if (var5 > var1 - 3) {
            var5 = var1 - 3;
         }

         float var15 = (float)(var0 - var2[var5]) / (float)(var2[var5 + 1] - var2[var5]);
         --var5;
         if (var5 < 0) {
            var5 = 0;
            var15 = 0.0F;
         }

         int var16 = 0;
         int var17 = 0;
         if (var17 < 4) {
            int var18 = var17 * 8;
            float var7 = (float)(var3[var5] >> var18 & 255);
            float var8 = (float)(var3[var5 + 1] >> var18 & 255);
            float var9 = (float)(var3[var5 + 2] >> var18 & 255);
            float var10 = (float)(var3[var5 + 3] >> var18 & 255);
            float var14 = -0.5F * var7 + 1.5F * var8 + -1.5F * var9 + 0.5F * var10;
            float var13 = 1.0F * var7 + -2.5F * var8 + 2.0F * var9 + -0.5F * var10;
            float var12 = -0.5F * var7 + 0.0F * var8 + 0.5F * var9 + 0.0F * var10;
            float var11 = 0.0F * var7 + 1.0F * var8 + 0.0F * var9 + 0.0F * var10;
            int var19 = (int)(((var14 * var15 + var13) * var15 + var12) * var15 + var11);
            if (var19 < 0) {
               var19 = 0;
            }

            if (var19 > 255) {
               var19 = 255;
            }

            var16 |= var19 << var18;
            ++var17;
         }

         return var16;
      }
   }

   public static void c92465(int[] var0, int[] var1, int var2, int var3, int var4, float[] var5) {
      // $FF: Couldn't be decompiled
   }

   public static void c37759(int[] var0, int var1, int var2) {
      Value.c27574();
      var2 = var2 + var1;
      if (var1 < var2) {
         int var5 = var0[var1];
         int var6 = var5 >> 24 & 255;
         int var7 = var5 >> 16 & 255;
         int var8 = var5 >> 8 & 255;
         int var9 = var5 & 255;
         float var10 = (float)var6 * 0.003921569F;
         var7 = (int)((float)var7 * var10);
         var8 = (int)((float)var8 * var10);
         var9 = (int)((float)var9 * var10);
         var0[var1] = var6 << 24 | var7 << 16 | var8 << 8 | var9;
         int var4 = var1 + 1;
      }

   }

   public static void c83886(int[] var0, int var1, int var2) {
      Value.c27574();
      var2 = var2 + var1;
      if (var1 < var2) {
         int var5 = var0[var1];
         int var6 = var5 >> 24 & 255;
         int var7 = var5 >> 16 & 255;
         int var8 = var5 >> 8 & 255;
         int var9 = var5 & 255;
         if (var6 != 255) {
            float var10 = 255.0F / (float)var6;
            var7 = (int)((float)var7 * var10);
            var8 = (int)((float)var8 * var10);
            var9 = (int)((float)var9 * var10);
            if (var7 > 255) {
               var7 = 255;
            }

            if (var8 > 255) {
               var8 = 255;
            }

            if (var9 > 255) {
               var9 = 255;
            }

            var0[var1] = var6 << 24 | var7 << 16 | var8 << 8 | var9;
         }

         int var4 = var1 + 1;
      }

   }

   private static IllegalArgumentException c60887(IllegalArgumentException var0) {
      return var0;
   }
}
