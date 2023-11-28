package rip.sleep.util;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Kernel;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class BlurUtil extends ConvoyUtil {
   protected float c496;
   protected Kernel c74634;

   public BlurUtil() {
      this(2.0F);
   }

   public BlurUtil(float var1) {
      this.c55025(var1);
   }

   public void c55025(float var1) {
      this.c496 = var1;
      this.c74634 = c30507(var1);
   }

   public float c40700() {
      return this.c496;
   }

   public BufferedImage filter(BufferedImage var1, BufferedImage var2) {
      Value.c27574();
      int var4 = var1.getWidth();
      int var5 = var1.getHeight();
      if (var2 == null) {
         var2 = this.createCompatibleDestImage(var1, (ColorModel)null);
      }

      int[] var6 = new int[var4 * var5];
      int[] var7 = new int[var4 * var5];
      var1.getRGB(0, 0, var4, var5, var6, 0, var4);
      if (this.c496 > 0.0F) {
         c97244(this.c74634, var6, var7, var4, var5, this.c42946, this.c42946 && this.c28994, false, c56293);
         c97244(this.c74634, var7, var6, var5, var4, this.c42946, false, this.c42946 && this.c28994, c56293);
      }

      var2.setRGB(0, 0, var4, var5, var6, 0, var4);
      return var2;
   }

   public static void c97244(Kernel var0, int[] var1, int[] var2, int var3, int var4, boolean var5, boolean var6, boolean var7, int var8) {
      float[] var10 = var0.getKernelData((float[])null);
      Value.c27574();
      int var11 = var0.getWidth();
      int var12 = var11 / 2;
      int var13 = 0;
      if (var13 < var4) {
         int var15 = var13 * var3;
         int var16 = 0;
         if (var16 < var3) {
            float var17 = 0.0F;
            float var18 = 0.0F;
            float var19 = 0.0F;
            float var20 = 0.0F;
            int var22 = -var12;
            if (var22 <= var12) {
               float var23 = var10[var12 + var22];
               if (var23 != 0.0F) {
                  int var24;
                  label50: {
                     var24 = var16 + var22;
                     if (var24 < 0) {
                        if (var8 == c56293) {
                           var24 = 0;
                        }

                        if (var8 != c40665) {
                           break label50;
                        }

                        var24 = (var16 + var3) % var3;
                     }

                     if (var24 >= var3) {
                        if (var8 == c56293) {
                           var24 = var3 - 1;
                        }

                        if (var8 == c40665) {
                           var24 = (var16 + var3) % var3;
                        }
                     }
                  }

                  int var25 = var1[var15 + var24];
                  int var26 = var25 >> 24 & 255;
                  int var27 = var25 >> 16 & 255;
                  int var28 = var25 >> 8 & 255;
                  int var29 = var25 & 255;
                  float var30 = (float)var26 * 0.003921569F;
                  var27 = (int)((float)var27 * var30);
                  var28 = (int)((float)var28 * var30);
                  var29 = (int)((float)var29 * var30);
                  var20 += var23 * (float)var26;
                  var17 += var23 * (float)var27;
                  var18 += var23 * (float)var28;
                  var19 += var23 * (float)var29;
               }

               ++var22;
            }

            if (var7 && var20 != 0.0F && var20 != 255.0F) {
               float var34 = 255.0F / var20;
               var17 *= var34;
               var18 *= var34;
               var19 *= var34;
            }

            var22 = var5 ? c57974((int)((double)var20 + 0.5D)) : 255;
            int var36 = c57974((int)((double)var17 + 0.5D));
            int var37 = c57974((int)((double)var18 + 0.5D));
            int var38 = c57974((int)((double)var19 + 0.5D));
            var2[var13] = var22 << 24 | var36 << 16 | var37 << 8 | var38;
            int var14 = var13 + var4;
            ++var16;
         }

         ++var13;
      }

   }

   public static int c57974(int var0) {
      Module[] var1 = Value.c27574();
      if (var0 < 0) {
         return 0;
      } else {
         return var0 > 255 ? 255 : var0;
      }
   }

   public static Kernel c30507(float var0) {
      int var2 = (int)Math.ceil((double)var0);
      Value.c27574();
      int var3 = var2 * 2 + 1;
      float[] var4 = new float[var3];
      float var5 = var0 / 3.0F;
      float var6 = 2.0F * var5 * var5;
      float var7 = 6.2831855F * var5;
      float var8 = (float)Math.sqrt((double)var7);
      float var9 = var0 * var0;
      float var10 = 0.0F;
      int var11 = 0;
      int var12 = -var2;
      if (var12 <= var2) {
         float var13 = (float)(var12 * var12);
         if (var13 > var9) {
            var4[var11] = 0.0F;
         }

         var4[var11] = (float)Math.exp((double)(-var13 / var6)) / var8;
         var10 += var4[var11];
         ++var11;
         ++var12;
      }

      var12 = 0;
      if (var12 < var3) {
         var4[var12] /= var10;
         ++var12;
      }

      return new Kernel(var3, 1, var4);
   }

   public String toString() {
      return "Blur/Gaussian Blur...";
   }

   private static JSONException c13549(JSONException var0) {
      return var0;
   }
}
