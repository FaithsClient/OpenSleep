package rip.sleep.util;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Kernel;
import java.util.Hashtable;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class ConvoyUtil extends BufferUtil {
   public static int c90478 = 0;
   public static int c56293 = 1;
   public static int c40665 = 2;
   protected Kernel c38846;
   protected boolean c42946;
   protected boolean c28994;
   private int c88671;

   public ConvoyUtil() {
      this(new float[9]);
   }

   public ConvoyUtil(float[] var1) {
      this(new Kernel(3, 3, var1));
   }

   public ConvoyUtil(int var1, int var2, float[] var3) {
      this(new Kernel(var2, var1, var3));
   }

   public ConvoyUtil(Kernel var1) {
      this.c38846 = null;
      this.c42946 = true;
      this.c28994 = true;
      this.c88671 = c56293;
      this.c38846 = var1;
   }

   public void c76289(Kernel var1) {
      this.c38846 = var1;
   }

   public Kernel c22564() {
      return this.c38846;
   }

   public void c52826(int var1) {
      this.c88671 = var1;
   }

   public int c63672() {
      return this.c88671;
   }

   public void c88212(boolean var1) {
      this.c42946 = var1;
   }

   public boolean c44363() {
      return this.c42946;
   }

   public void c90367(boolean var1) {
      this.c28994 = var1;
   }

   public boolean c21331() {
      return this.c28994;
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
      this.c56747(var1, 0, 0, var4, var5, var6);
      if (this.c28994) {
         MathUtilH.c37759(var6, 0, var6.length);
      }

      c45744(this.c38846, var6, var7, var4, var5, this.c42946, this.c88671);
      if (this.c28994) {
         MathUtilH.c83886(var7, 0, var7.length);
      }

      this.c76621(var2, 0, 0, var4, var5, var7);
      return var2;
   }

   public BufferedImage createCompatibleDestImage(BufferedImage var1, ColorModel var2) {
      Module[] var3 = Value.c27574();
      if (var2 == null) {
         var2 = var1.getColorModel();
      }

      return new BufferedImage(var2, var2.createCompatibleWritableRaster(var1.getWidth(), var1.getHeight()), var2.isAlphaPremultiplied(), (Hashtable)null);
   }

   public Rectangle2D getBounds2D(BufferedImage var1) {
      return new Rectangle(0, 0, var1.getWidth(), var1.getHeight());
   }

   public Point2D getPoint2D(Point2D var1, Point2D var2) {
      Module[] var3 = Value.c27574();
      if (var2 == null) {
         var2 = new Double();
      }

      ((Point2D)var2).setLocation(var1.getX(), var1.getY());
      return (Point2D)var2;
   }

   public RenderingHints getRenderingHints() {
      return null;
   }

   public static void c56971(Kernel var0, int[] var1, int[] var2, int var3, int var4, int var5) {
      c45744(var0, var1, var2, var3, var4, true, var5);
   }

   public static void c45744(Kernel var0, int[] var1, int[] var2, int var3, int var4, boolean var5, int var6) {
      Module[] var7 = Value.c27574();
      if (var0.getHeight() == 1) {
         c76349(var0, var1, var2, var3, var4, var5, var6);
      }

      if (var0.getWidth() == 1) {
         c20725(var0, var1, var2, var3, var4, var5, var6);
      }

      c37352(var0, var1, var2, var3, var4, var5, var6);
   }

   public static void c37352(Kernel var0, int[] var1, int[] var2, int var3, int var4, boolean var5, int var6) {
      int var8 = 0;
      float[] var9 = var0.getKernelData((float[])null);
      Value.c27574();
      int var10 = var0.getHeight();
      int var11 = var0.getWidth();
      int var12 = var10 / 2;
      int var13 = var11 / 2;
      int var14 = 0;
      if (var14 < var4) {
         int var15 = 0;
         if (var15 < var3) {
            float var16 = 0.0F;
            float var17 = 0.0F;
            float var18 = 0.0F;
            float var19 = 0.0F;
            int var20 = -var12;
            if (var20 <= var12) {
               int var21 = var14 + var20;
               if (0 <= var21 && var21 < var4) {
                  int var10000 = var21 * var3;
               }

               if (var6 == c56293) {
                  int var37 = var14 * var3;
               }

               if (var6 == c40665) {
                  int var22 = (var21 + var4) % var4 * var3;
                  int var23 = var11 * (var20 + var12) + var13;
                  int var24 = -var13;
                  if (var24 <= var13) {
                     float var25 = var9[var23 + var24];
                     if (var25 != 0.0F) {
                        label73: {
                           int var26 = var15 + var24;
                           if (0 > var26 || var26 >= var3) {
                              if (var6 == c56293) {
                                 ;
                              }

                              if (var6 != c40665) {
                                 break label73;
                              }

                              var26 = (var15 + var3) % var3;
                           }

                           int var27 = var1[var22 + var26];
                           var19 += var25 * (float)(var27 >> 24 & 255);
                           var16 += var25 * (float)(var27 >> 16 & 255);
                           var17 += var25 * (float)(var27 >> 8 & 255);
                           var18 += var25 * (float)(var27 & 255);
                        }
                     }

                     ++var24;
                  }
               }

               ++var20;
            }

            var20 = var5 ? BlurUtil.c57974((int)((double)var19 + 0.5D)) : 255;
            int var33 = BlurUtil.c57974((int)((double)var16 + 0.5D));
            int var34 = BlurUtil.c57974((int)((double)var17 + 0.5D));
            int var35 = BlurUtil.c57974((int)((double)var18 + 0.5D));
            var2[var8++] = var20 << 24 | var33 << 16 | var34 << 8 | var35;
            ++var15;
         }

         ++var14;
      }

   }

   public static void c76349(Kernel var0, int[] var1, int[] var2, int var3, int var4, boolean var5, int var6) {
      Value.c27574();
      int var8 = 0;
      float[] var9 = var0.getKernelData((float[])null);
      int var10 = var0.getWidth();
      int var11 = var10 / 2;
      int var12 = 0;
      if (var12 < var4) {
         int var13 = var12 * var3;
         int var14 = 0;
         if (var14 < var3) {
            float var15 = 0.0F;
            float var16 = 0.0F;
            float var17 = 0.0F;
            float var18 = 0.0F;
            int var20 = -var11;
            if (var20 <= var11) {
               float var21 = var9[var11 + var20];
               if (var21 != 0.0F) {
                  int var22;
                  label42: {
                     var22 = var14 + var20;
                     if (var22 < 0) {
                        if (var6 == c56293) {
                           var22 = 0;
                        }

                        if (var6 != c40665) {
                           break label42;
                        }

                        var22 = (var14 + var3) % var3;
                     }

                     if (var22 >= var3) {
                        if (var6 == c56293) {
                           var22 = var3 - 1;
                        }

                        if (var6 == c40665) {
                           var22 = (var14 + var3) % var3;
                        }
                     }
                  }

                  int var23 = var1[var13 + var22];
                  var18 += var21 * (float)(var23 >> 24 & 255);
                  var15 += var21 * (float)(var23 >> 16 & 255);
                  var16 += var21 * (float)(var23 >> 8 & 255);
                  var17 += var21 * (float)(var23 & 255);
               }

               ++var20;
            }

            var20 = var5 ? BlurUtil.c57974((int)((double)var18 + 0.5D)) : 255;
            int var29 = BlurUtil.c57974((int)((double)var15 + 0.5D));
            int var30 = BlurUtil.c57974((int)((double)var16 + 0.5D));
            int var31 = BlurUtil.c57974((int)((double)var17 + 0.5D));
            var2[var8++] = var20 << 24 | var29 << 16 | var30 << 8 | var31;
            ++var14;
         }

         ++var12;
      }

   }

   public static void c20725(Kernel var0, int[] var1, int[] var2, int var3, int var4, boolean var5, int var6) {
      Value.c27574();
      int var8 = 0;
      float[] var9 = var0.getKernelData((float[])null);
      int var10 = var0.getHeight();
      int var11 = var10 / 2;
      int var12 = 0;
      if (var12 < var4) {
         int var13 = 0;
         if (var13 < var3) {
            float var14 = 0.0F;
            float var15 = 0.0F;
            float var16 = 0.0F;
            float var17 = 0.0F;
            int var18 = -var11;
            if (var18 <= var11) {
               int var19 = var12 + var18;
               if (var19 < 0) {
                  if (var6 == c56293) {
                     boolean var20 = false;
                  }

                  if (var6 == c40665) {
                     int var29 = (var12 + var4) % var4 * var3;
                  }

                  int var10000 = var19 * var3;
               }

               if (var19 >= var4) {
                  if (var6 == c56293) {
                     int var30 = (var4 - 1) * var3;
                  }

                  if (var6 == c40665) {
                     int var31 = (var12 + var4) % var4 * var3;
                  }

                  int var35 = var19 * var3;
               }

               int var32 = var19 * var3;
               float var21 = var9[var18 + var11];
               if (var21 != 0.0F) {
                  int var22 = var1[var32 + var13];
                  var17 += var21 * (float)(var22 >> 24 & 255);
                  var14 += var21 * (float)(var22 >> 16 & 255);
                  var15 += var21 * (float)(var22 >> 8 & 255);
                  var16 += var21 * (float)(var22 & 255);
               }

               ++var18;
            }

            var18 = var5 ? BlurUtil.c57974((int)((double)var17 + 0.5D)) : 255;
            int var28 = BlurUtil.c57974((int)((double)var14 + 0.5D));
            int var33 = BlurUtil.c57974((int)((double)var15 + 0.5D));
            int var34 = BlurUtil.c57974((int)((double)var16 + 0.5D));
            var2[var8++] = var18 << 24 | var28 << 16 | var33 << 8 | var34;
            ++var13;
         }

         ++var12;
      }

   }

   public String toString() {
      return "Blur/Convolve...";
   }

   private static JSONException c92957(JSONException var0) {
      return var0;
   }
}
