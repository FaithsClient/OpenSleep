package rip.sleep.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class MathUtilB {
   public static Random c50210 = new Random();
   public static final float c58978 = c70409(0.017453292519943295D);

   public static double c90431(double var0, int var2) {
      return Double.parseDouble(String.format("%." + var2 + "f", var0));
   }

   public static double c98725(double var0, int var2) {
      var2 = (int)MathHelper.clamp_double((double)var2, 0.0D, 2.147483647E9D);
      return Double.parseDouble(String.format("%." + var2 + "f", var0));
   }

   public static boolean c81955(String param0, byte param1) {
      // $FF: Couldn't be decompiled
   }

   public static double c12627(double var0) {
      return var0 * var0;
   }

   public static double c68129(double var0, double var2) {
      return ThreadLocalRandom.current().nextDouble(var0, var2);
   }

   public static double c49552(double var0, double var2) {
      return MathHelper.clamp_double(var0 + c50210.nextDouble() * var2, var0, var2);
   }

   public static double c6195(double var0, double var2) {
      SecureRandom var4 = new SecureRandom();
      return var4.nextDouble() * (var2 - var0) + var0;
   }

   public static double c3447() {
      Value.c27574();
      double var1 = 0.2873D;
      if (ChatUtilA.mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
         int var3 = ChatUtilA.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         var1 *= 1.0D + 0.2D * (double)(var3 + 1);
      }

      return var1;
   }

   public static double c95603(double var0) {
      Value.c27574();
      double var3 = 0.0D;
      if (var3 < var0) {
         int[] var5 = new int[]{-2, -1, 0, 1, 2};
         int var7 = var5.length;
         int var8 = 0;
         if (var8 < var7) {
            int var9 = var5[var8];
            if (ChatUtilA.mc.theWorld.getCollidingBoundingBoxes(ChatUtilA.mc.thePlayer, ChatUtilA.mc.thePlayer.getEntityBoundingBox().offset(ChatUtilA.mc.thePlayer.motionX * (double)var9, var3, ChatUtilA.mc.thePlayer.motionZ * (double)var9)).size() > 0) {
               return var3 - 0.01D;
            }

            ++var8;
         }

         var3 = var3 + 0.01D;
      }

      return var0;
   }

   public static boolean c23165(double var0, double var2, double var4, double var6, double var8, double var10) {
      Module[] var12 = Value.c27574();
      return var0 > var8 && var0 < var4 && var2 > var10 && var2 < var6;
   }

   public static int c26096(int var0, int var1) {
      Module[] var2 = Value.c27574();
      return var1 < var0 ? 0 : var0 + c50210.nextInt(var1 - var0 + 1);
   }

   public static double c95323(double var0, double var2) {
      Random var5 = new Random();
      double var6 = var2 - var0;
      Value.c27574();
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

   public static int c73986(int var0, int var1, double var2) {
      Value.c27574();
      int var5 = var0;
      if (var0 < var1) {
         int var6 = (int)((double)(var1 - var0) / var2);
         if (var6 < 1) {
            var6 = 1;
         }

         var5 = var0 + var6;
      }

      if (var5 > var1) {
         int var7 = (int)((double)(var5 - var1) / var2);
         if (var7 < 1) {
            var7 = 1;
         }

         var5 -= var7;
      }

      return var5;
   }

   public static Random c64177() {
      return c50210;
   }

   public static int c11508(int var0, int var1) {
      Module[] var2 = Value.c27574();
      return var0 > var1 ? var0 : (new Random()).nextInt(var1) + var0;
   }

   public static boolean c73426(String var0) {
      String var10000 = var0;

      try {
         Float.parseFloat(var10000);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      }
   }

   public static double c39098(double var0, double var2) {
      double var4 = 1.0D / var2;
      return (double)Math.round(var0 * var4) / var4;
   }

   public static double c11525(double var0) {
      return (double)Math.round(var0 * 2.0D) / 2.0D;
   }

   public static Random c54594() {
      return c50210;
   }

   public static int c8650(int var0, int var1) {
      Module[] var2 = Value.c27574();
      if (var0 > var1) {
         return var0;
      } else {
         Random var3 = new Random();
         return var3.nextInt(var1) + var0;
      }
   }

   public static double c57059(double var0, double var2) {
      Module[] var4 = Value.c27574();
      if (var0 >= var2) {
         double var10000 = var0 - var2;
      }

      double var5 = var2 - var0;
      return var5;
   }

   public static double c26640(double var0, double var2) {
      Module[] var4 = Value.c27574();
      if (var0 > var2) {
         return var0;
      } else {
         Random var5 = new Random();
         return var5.nextDouble() * (var2 - var0) + var0;
      }
   }

   public static float c70409(double var0) {
      return (float)((double)Math.round(var0 * 1.0E8D) / 1.0E8D);
   }

   public static double[] c93655(double var0) {
      return c5709(Minecraft.getMinecraft().thePlayer.rotationYaw * c58978, var0);
   }

   public static double[] c5709(float var0, double var1) {
      return new double[]{(double)(-MathHelper.sin(var0)) * var1, (double)MathHelper.cos(var0) * var1};
   }

   public static float c38918(float var0, float var1) {
      SecureRandom var2 = new SecureRandom();
      return var2.nextFloat() * (var1 - var0) + var0;
   }

   public static float c79455(float var0, float var1) {
      double var2 = 3.141592653D;
      double var4 = 1.0D / Math.sqrt(2.0D * var2 * (double)(var1 * var1));
      return (float)(var4 * Math.exp((double)(-(var0 * var0)) / (2.0D * (double)(var1 * var1))));
   }

   private static NumberFormatException c54553(NumberFormatException var0) {
      return var0;
   }

   public static class c23598 {
      public static final byte c15792 = 0;
      public static final byte c62490 = 1;
      public static final byte c26137 = 2;
      public static final byte c77394 = 3;
      public static final byte c16745 = 4;
      public static final byte c43283 = 5;

      public static byte c31940(Class var0) {
         Module[] var1 = Value.c27574();
         if (var0 == Short.class) {
            return 0;
         } else if (var0 == Byte.class) {
            return 1;
         } else if (var0 == Integer.class) {
            return 2;
         } else if (var0 == Float.class) {
            return 3;
         } else if (var0 == Double.class) {
            return 4;
         } else {
            return (byte)(var0 == Long.class ? 5 : -1);
         }
      }

      private static JSONException c76443(JSONException var0) {
         return var0;
      }
   }
}
