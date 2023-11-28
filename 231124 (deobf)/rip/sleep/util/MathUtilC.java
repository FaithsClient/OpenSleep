package rip.sleep.util;

import net.minecraft.client.Minecraft;
import org.json.JSONException;
import rip.sleep.value.Value;

public class MathUtilC {
   public static double c18971;

   public static float c23426(float var0, float var1, float var2, float var3) {
      Value.c27574();
      float var5 = (var1 - var0) * var2;
      if (var5 > 0.0F) {
         var5 = Math.max(var3, var5);
         var5 = Math.min(var1 - var0, var5);
      }

      if (var5 < 0.0F) {
         var5 = Math.min(-var3, var5);
         var5 = Math.max(var1 - var0, var5);
      }

      return var0 + var5;
   }

   public static float c62487(float var0, float var1, double var2) {
      Value.c27574();
      double var5 = (double)Math.abs(var1 - var0);
      float var7 = (float)Math.abs((double)(var1 - (var1 - Math.abs(var1 - var0))) / (100.0D - var2 * 10.0D));
      float var8 = var0;
      if (var5 != 0.0D && var5 < (double)var7) {
         var7 = (float)var5;
      }

      label28: {
         if (var5 > 0.0D) {
            if (var0 < var1) {
               var8 = var0 + var7 * RenderUtilF.c75973;
            }

            if (var0 <= var1) {
               break label28;
            }

            float var10000 = var8 - var7 * RenderUtilF.c75973;
         }

         var8 = var1;
      }

      if ((double)Math.abs(var1 - var8) < 0.05D && var8 != var1) {
         var8 = var1;
      }

      return var8;
   }

   public static float c74056(float var0, float var1, long var2, int var4) {
      Value.c27574();
      float var6 = var1 - var0;
      if (var2 < 1L) {
         var2 = 1L;
      }

      if (var6 > (float)var4) {
         double var7 = (double)((long)var4 * var2 / 16L) < 0.25D ? 0.5D : (double)((long)var4 * var2 / 16L);
         var1 = (float)((double)var1 - var7);
         if (var1 >= var0) {
            return var1;
         }

         var1 = var0;
      }

      if (var6 < (float)(-var4)) {
         double var10 = (double)((long)var4 * var2 / 16L) < 0.25D ? 0.5D : (double)((long)var4 * var2 / 16L);
         var1 = (float)((double)var1 + var10);
         if (var1 <= var0) {
            return var1;
         }
      }

      var1 = var0;
      return var1;
   }

   public static float c44790(float var0, float var1, long var2, double var4) {
      Value.c27574();
      float var7 = var1 - var0;
      if (var2 < 1L) {
         var2 = 1L;
      }

      if (var2 > 1000L) {
         var2 = 16L;
      }

      if ((double)var7 > var4) {
         double var8 = Math.max(var4 * (double)var2 / 16.0D, 0.5D);
         var1 = (float)((double)var1 - var8);
         if (var1 < var0) {
            var1 = var0;
         }
      }

      if ((double)var7 < -var4) {
         double var11 = Math.max(var4 * (double)var2 / 16.0D, 0.5D);
         var1 = (float)((double)var1 + var11);
         if (var1 > var0) {
            ;
         }
      }

      return var0;
   }

   public static float c21701(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = (float)(c18971 * (double)(var2 / 1000.0F));
      if (var0 < var1) {
         if (var0 + var4 < var1) {
            float var10000 = var0 + var4;
         }

         var0 = var1;
      }

      if (var0 - var4 > var1) {
         float var5 = var0 - var4;
      }

      return var1;
   }

   public static float c74992(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = (var1 - var0) / Math.max((float)Minecraft.getDebugFPS(), 5.0F) * 15.0F;
      if (var4 > 0.0F) {
         var4 = Math.max(var2, var4);
         var4 = Math.min(var1 - var0, var4);
      }

      if (var4 < 0.0F) {
         var4 = Math.min(-var2, var4);
         var4 = Math.max(var1 - var0, var4);
      }

      return var0 + var4;
   }

   public static double c4865(double var0, double var2, double var4) {
      Value.c27574();
      double var7 = (var2 - var0) / (double)Math.max(Minecraft.getDebugFPS(), 5) * var4;
      if (var7 > 0.0D) {
         var7 = Math.max(var4, var7);
         var7 = Math.min(var2 - var0, var7);
      }

      if (var7 < 0.0D) {
         var7 = Math.min(-var4, var7);
         var7 = Math.max(var2 - var0, var7);
      }

      return var0 + var7;
   }

   private static JSONException c8360(JSONException var0) {
      return var0;
   }
}
