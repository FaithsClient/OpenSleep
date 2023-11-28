package rip.sleep.util;

import com.ibm.icu.text.NumberFormat;
import java.awt.Color;
import java.util.regex.Pattern;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;

public class RenderUtilG {
   public static final String c60838 = "§7";
   private static final Pattern c1135 = Pattern.compile("(?i)ยง[0-9A-FK-OR]");

   public static Color c6303(float var0, float var1, float var2) {
      float var3 = (float)(System.currentTimeMillis() % (long)((int)(var0 * 1000.0F))) / (var0 * 1000.0F);
      return new Color(Color.HSBtoRGB(var3, var1, var2));
   }

   public static Color c44738(float var0, float var1, float var2, long var3) {
      float var5 = (float)((System.currentTimeMillis() + var3) % (long)((int)(var0 * 1000.0F))) / (var0 * 1000.0F);
      return new Color(Color.HSBtoRGB(var5, var1, var2));
   }

   public static Color c89751(Color var0, int var1, int var2) {
      float[] var3 = new float[3];
      Color.RGBtoHSB(var0.getRed(), var0.getGreen(), var0.getBlue(), var3);
      float var4 = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0F + (float)var1 / (float)var2 * 2.0F) % 2.0F - 1.0F);
      var4 = 0.5F + 0.5F * var4;
      var3[2] = var4 % 2.0F;
      return new Color(Color.HSBtoRGB(var3[0], var3[1], var3[2]));
   }

   public static Color c2975(double var0, double var2) {
      Value.c27574();
      long var5 = Math.round(var2 / 5.0D);
      if (var0 >= (double)(var5 * 5L)) {
         return new Color(15, 255, 15);
      } else if (var0 >= (double)(var5 * 4L)) {
         return new Color(166, 255, 0);
      } else if (var0 >= (double)(var5 * 3L)) {
         return new Color(255, 191, 0);
      } else {
         return var0 >= (double)(var5 * 2L) ? new Color(255, 89, 0) : new Color(255, 0, 0);
      }
   }

   public static Color c59145(Color var0, int var1, int var2) {
      int var3 = Math.max(var0.getRed() - var1, 0);
      int var4 = Math.max(var0.getGreen() - var1, 0);
      int var5 = Math.max(var0.getBlue() - var1, 0);
      return new Color(var3, var4, var5, var2);
   }

   public static Color c35201(Color var0, int var1, int var2) {
      int var3 = Math.min(var0.getRed() + var1, 255);
      int var4 = Math.min(var0.getGreen() + var1, 255);
      int var5 = Math.min(var0.getBlue() + var1, 255);
      return new Color(var3, var4, var5, var2);
   }

   public static void c45410(int var0) {
      float var1 = (float)(var0 >> 16 & 255) / 255.0F;
      float var2 = (float)(var0 >> 8 & 255) / 255.0F;
      float var3 = (float)(var0 & 255) / 255.0F;
      float var4 = (float)(var0 >> 24 & 255) / 255.0F;
      GL11.glColor4f(var1, var2, var3, var4);
   }

   public static Color c31794(Color var0, int var1) {
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), var1);
   }

   public static int c77486(int var0, int var1, int var2, int var3) {
      int var4 = 0;
      var4 = var4 | var3 << 24;
      var4 = var4 | var0 << 16;
      var4 = var4 | var1 << 8;
      return var4 | var2;
   }

   public static int c87305(int var0) {
      return c77486(var0, var0, var0, 255);
   }

   public static Color c69591(long var0, float var2, float var3) {
      float var4 = ((float)var0 + (1.0F + var2) * 2.0E8F) / 1.0E1F % 1.0F;
      long var5 = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(var4, 0.7F, 1.0F)), 16);
      Color var7 = new Color((int)var5);
      return new Color((float)var7.getRed() / 255.0F * var3, (float)var7.getGreen() / 255.0F * var3, (float)var7.getBlue() / 255.0F * var3, (float)var7.getAlpha() / 255.0F);
   }

   public static Color c16558(Color var0, Color var1, double var2) {
      Value.c27574();
      float var5 = (float)var2;
      float var6 = 1.0F - var5;
      float[] var7 = new float[3];
      float[] var8 = new float[3];
      var0.getColorComponents(var7);
      var1.getColorComponents(var8);
      float var9 = var7[0] * var5 + var8[0] * var6;
      float var10 = var7[1] * var5 + var8[1] * var6;
      float var11 = var7[2] * var5 + var8[2] * var6;
      if (var9 < 0.0F) {
         var9 = 0.0F;
      }

      if (var9 > 255.0F) {
         var9 = 255.0F;
      }

      if (var10 < 0.0F) {
         var10 = 0.0F;
      }

      if (var10 > 255.0F) {
         var10 = 255.0F;
      }

      if (var11 < 0.0F) {
         var11 = 0.0F;
      }

      if (var11 > 255.0F) {
         var11 = 255.0F;
      }

      Color var12 = null;
      Color var10000 = new Color;
      Color var10001 = var10000;
      float var10002 = var9;
      float var10003 = var10;
      float var10004 = var11;

      try {
         var10001.<init>(var10002, var10003, var10004);
         var12 = var10000;
      } catch (IllegalArgumentException var15) {
         NumberFormat var14 = NumberFormat.getNumberInstance();
         var15.printStackTrace();
      }

      return var12;
   }

   public static Color c12770(float[] var0, Color[] var1, float var2) {
      Module[] var3 = Value.c27574();
      throw new IllegalArgumentException("Fractions can't be null");
   }

   public static int[] c5686(float[] var0, float var1) {
      int[] var4 = new int[2];
      Value.c27574();
      int var3 = 0;
      if (var3 < var0.length && var0[var3] <= var1) {
         ++var3;
      }

      if (var3 >= var0.length) {
         var3 = var0.length - 1;
      }

      var4[0] = var3 - 1;
      var4[1] = var3;
      return var4;
   }

   public static int c53664(Color var0, Color var1, float var2) {
      var2 = Math.min(1.0F, Math.max(0.0F, var2));
      return c88833(var0, var1, var2).getRGB();
   }

   public static int c86982(int var0, int var1, float var2) {
      var2 = Math.min(1.0F, Math.max(0.0F, var2));
      Color var3 = new Color(var0);
      Color var4 = new Color(var1);
      return c88833(var3, var4, var2).getRGB();
   }

   public static Double c22726(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static float c86548(float var0, float var1, double var2) {
      return c22726((double)var0, (double)var1, (double)((float)var2)).floatValue();
   }

   public static int c99041(int var0, int var1, double var2) {
      return c22726((double)var0, (double)var1, (double)((float)var2)).intValue();
   }

   public static Color c88833(Color var0, Color var1, float var2) {
      var2 = Math.min(1.0F, Math.max(0.0F, var2));
      return new Color(c99041(var0.getRed(), var1.getRed(), (double)var2), c99041(var0.getGreen(), var1.getGreen(), (double)var2), c99041(var0.getBlue(), var1.getBlue(), (double)var2), c99041(var0.getAlpha(), var1.getAlpha(), (double)var2));
   }

   public static Color c69732(Color var0, Color var1, float var2) {
      var2 = Math.min(1.0F, Math.max(0.0F, var2));
      float[] var3 = Color.RGBtoHSB(var0.getRed(), var0.getGreen(), var0.getBlue(), (float[])null);
      float[] var4 = Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), (float[])null);
      Color var5 = Color.getHSBColor(c86548(var3[0], var4[0], (double)var2), c86548(var3[1], var4[1], (double)var2), c86548(var3[2], var4[2], (double)var2));
      return new Color(var5.getRed(), var5.getGreen(), var5.getBlue(), c99041(var0.getAlpha(), var1.getAlpha(), (double)var2));
   }

   public static Color c61874(int var0, int var1, Color var2, Color var3, boolean var4) {
      Value.c27574();
      int var6 = (int)((System.currentTimeMillis() / (long)var0 + (long)var1) % 360L);
      var6 = (var6 >= 180 ? 360 - var6 : var6) * 2;
      return c69732(var2, var3, (float)var6 / 360.0F);
   }

   public static String c70907(String var0) {
      return c1135.matcher(var0).replaceAll("");
   }

   public static int c91337(int var0, float var1) {
      Color var2 = new Color(var0);
      return c23588(var2, var1).getRGB();
   }

   public static Color c23588(Color var0, float var1) {
      var1 = Math.min(1.0F, Math.max(0.0F, var1));
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), (int)((float)var0.getAlpha() * var1));
   }

   public static Color c46327(int var0) {
      return c23173(var0, 1.0F);
   }

   public static Color c23173(int var0, float var1) {
      var1 = Math.min(1.0F, Math.max(0.0F, var1));
      return new Color(var0, var0, var0, (int)(255.0F * var1));
   }

   public static int c72816(int var0) {
      double var2 = 1.2D;
      Value.c27574();
      double var4 = Math.ceil((double)(System.currentTimeMillis() + (long)((double)var0 * var2)) / 30.0D);
      double var7;
      float var6 = (double)((float)((var7 = var4 % 360.0D) / 360.0D)) < 0.5D ? -((float)(var7 / 360.0D)) : (float)(var7 / 360.0D);
      return Color.getHSBColor(var6, 0.35F, 1.0F).getRGB();
   }

   public static int c54521(ModuleType var0) {
      Value.c27574();
      int var2 = -1;
      if (var0 == ModuleType.c13050) {
         var2 = (new Color(219, 120, 163)).getRGB();
      }

      if (var0 == ModuleType.c62580) {
         var2 = (new Color(91, 153, 204)).getRGB();
      }

      if (var0 == ModuleType.c31770) {
         var2 = (new Color(224, 197, 242)).getRGB();
      }

      if (var0 == ModuleType.c12482) {
         var2 = (new Color(255, 187, 145)).getRGB();
      }

      return var2;
   }

   private static IllegalArgumentException c88340(IllegalArgumentException var0) {
      return var0;
   }
}
