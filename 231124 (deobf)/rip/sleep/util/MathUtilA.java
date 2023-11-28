package rip.sleep.util;

import java.awt.Color;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import rip.sleep.value.Value;

public class MathUtilA {
   public static int c28174(Color var0) {
      return c66748(var0.getRed(), var0.getGreen(), var0.getBlue(), var0.getAlpha());
   }

   public static int c83116(int var0) {
      return c66748(var0, var0, var0, 255);
   }

   public static int c57743(int var0, int var1) {
      return c66748(var0, var0, var0, var1);
   }

   public static int c70953(int var0, int var1, int var2) {
      return c66748(var0, var1, var2, 255);
   }

   public static int c66748(int var0, int var1, int var2, int var3) {
      int var4 = MathHelper.clamp_int(var3, 0, 255) << 24;
      var4 = var4 | MathHelper.clamp_int(var0, 0, 255) << 16;
      var4 = var4 | MathHelper.clamp_int(var1, 0, 255) << 8;
      var4 = var4 | MathHelper.clamp_int(var2, 0, 255);
      return var4;
   }

   public static int c61922(float var0, float var1) {
      Value.c27574();
      float var3 = var0 / var1;
      if (var3 >= 0.75F) {
         return (new Color(0, 230, 0, 120)).getRGB();
      } else {
         return (double)var3 < 0.75D && (double)var3 >= 0.35D ? (new Color(255, 255, 120, 120)).getRGB() : (new Color(255, 20, 20, 120)).getRGB();
      }
   }

   public static int c26037(float var0, float var1) {
      Value.c27574();
      float var3 = var0 / var1;
      if (var3 >= 0.75F) {
         return (new Color(0, 230, 0, 250)).getRGB();
      } else {
         return (double)var3 < 0.75D && (double)var3 >= 0.35D ? (new Color(255, 255, 120, 250)).getRGB() : (new Color(255, 20, 20, 250)).getRGB();
      }
   }

   private static JSONException c616(JSONException var0) {
      return var0;
   }
}
