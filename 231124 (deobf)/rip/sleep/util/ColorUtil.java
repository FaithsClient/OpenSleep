package rip.sleep.util;

import java.awt.Color;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public enum ColorUtil {
   c93650(-16711423),
   c2612(-12028161),
   c86505(-12621684),
   c91060(-9830551),
   c31120(-9320847),
   c27970(-65794),
   c29217(-7820064),
   c39179(-12621684),
   c5837(-9868951),
   c93061(-14342875),
   c8002(-65536),
   c26826(-8388608),
   c60644(-29696),
   c77576(-2263808),
   c36804(-256),
   c64551(-2702025),
   c31191(-18751),
   c48050(-2252579);

   public int c79340;
   private static Pattern c37686 = Pattern.compile("(?i)锟斤拷[0-9A-FK-OR]");

   private ColorUtil(int var3) {
      this.c79340 = var3;
   }

   public static int c40434(Color var0) {
      return c64483(var0.getRed(), var0.getGreen(), var0.getBlue(), var0.getAlpha());
   }

   public static int c41390(int var0) {
      return c64483(var0, var0, var0, 255);
   }

   public static int c21891(int var0, int var1) {
      return c64483(var0, var0, var0, var1);
   }

   public static int c74045(int var0, int var1, int var2) {
      return c64483(var0, var1, var2, 255);
   }

   public static int c64483(int var0, int var1, int var2, int var3) {
      byte var4 = 0;
      int var5 = var4 | var3 << 24;
      var5 = var5 | var0 << 16;
      var5 = var5 | var1 << 8;
      var5 = var5 | var2;
      return var5;
   }

   public static int c45230(int[] var0, double var1) {
      Value.c27574();
      int var4 = var0.length;
      if (var1 == 1.0D) {
         return var0[0];
      } else if (var1 == 0.0D) {
         return var0[var4 - 1];
      } else {
         double var5 = Math.max(0.0D, (1.0D - var1) * (double)(var4 - 1));
         int var7 = (int)var5;
         return c47870(var0[var7], var0[var7 + 1], var5 - (double)var7);
      }
   }

   public static int c47870(int var0, int var1, double var2) {
      Module[] var4 = Value.c27574();
      if (var2 > 1.0D) {
         var2 = 1.0D - var2 % 1.0D;
      }

      return c25711(var0, var1, var2);
   }

   public static int c8408(int var0, int var1) {
      return c47870(var0, var1, 0.0D);
   }

   public static Color c3182(Color var0, int var1, int var2) {
      float[] var3 = new float[3];
      Color.RGBtoHSB(var0.getRed(), var0.getGreen(), var0.getBlue(), var3);
      float var4 = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0F + (float)var1 / (float)var2 * 2.0F) % 2.0F - 1.0F);
      var4 = 0.5F + 0.5F * var4;
      var3[2] = var4 % 2.0F;
      return new Color(Color.HSBtoRGB(var3[0], var3[1], var3[2]));
   }

   public static int c25711(int var0, int var1, double var2) {
      double var4 = 1.0D - var2;
      int var6 = (int)((double)(var0 >> 16 & 255) * var4 + (double)(var1 >> 16 & 255) * var2);
      int var7 = (int)((double)(var0 >> 8 & 255) * var4 + (double)(var1 >> 8 & 255) * var2);
      int var8 = (int)((double)(var0 & 255) * var4 + (double)(var1 & 255) * var2);
      int var9 = (int)((double)(var0 >> 24 & 255) * var4 + (double)(var1 >> 24 & 255) * var2);
      return (var9 & 255) << 24 | (var6 & 255) << 16 | (var7 & 255) << 8 | var8 & 255;
   }

   public static String c45525(String var0) {
      return c37686.matcher(var0).replaceAll("");
   }

   public static Color c84057(Color var0, Color var1, float var2) {
      int var3 = var0.getRed() + (int)((float)(var1.getRed() - var0.getRed()) * var2);
      int var4 = var0.getGreen() + (int)((float)(var1.getGreen() - var0.getGreen()) * var2);
      int var5 = var0.getBlue() + (int)((float)(var1.getBlue() - var0.getBlue()) * var2);
      int var6 = var0.getAlpha() + (int)((float)(var1.getAlpha() - var0.getAlpha()) * var2);
      return new Color(var3, var4, var5, var6);
   }

   public static int c92882(int var0, float var1) {
      Color var2 = new Color(var0);
      float var3 = (float)var2.getRed() / 255.0F;
      float var4 = (float)var2.getGreen() / 255.0F;
      float var5 = (float)var2.getBlue() / 255.0F;
      return (new Color(var3, var4, var5, var1)).getRGB();
   }

   public static void c29334(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   private static JSONException c58771(JSONException var0) {
      return var0;
   }
}
