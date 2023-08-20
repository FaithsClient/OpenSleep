//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.math;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;

public class MathUtil {
   public static Random assets$ = new Random();
   public static float mailman$ = _police(0.017453292519943295D);

   public static double _walks(double tuzulude, int var2) {
      return Double.parseDouble(String.format("%." + var2 + "f", Double.valueOf((double)tuzulude)));
   }

   public static double _teach(double idoziliz, int var2) {
      var2 = (int)MathHelper.clamp_double((double)var2, Double.longBitsToDouble(0L), 2.147483647E9D);
      return Double.parseDouble(String.format("%." + var2 + "f", Double.valueOf((double)idoziliz)));
   }

   public static boolean _racks(String yitunase, byte ugepigus) {
      // $FF: Couldn't be decompiled
   }

   public static double _serbia(double tuniguco) {
      return (double)(tuniguco * tuniguco);
   }

   public static double _realty(double yatodulu, double var2) {
      return ThreadLocalRandom.current().nextDouble((double)yatodulu, var2);
   }

   public static double _circles(double povezuda, double var2) {
      return MathHelper.clamp_double(povezuda + assets$.nextDouble() * var2, (double)povezuda, var2);
   }

   public static double _binding(double sharon, double chance) {
      SecureRandom var4 = new SecureRandom();
      return var4.nextDouble() * (chance - sharon) + sharon;
   }

   public static double _glossary() {
      Object wooden = 0.2873D;
      if (Helper.sprint$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         int var2 = Helper.sprint$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         wooden *= 1.0D + 0.2D * (double)(var2 + 1);
      }

      return wooden;
   }

   public static double _england(double wrapping) {
      for(Object feature = Double.longBitsToDouble(0L); feature < wrapping; feature += 0.01D) {
         Object moscow = new int[]{-2, -1, 0, 1, 2};

         for(int var8 : moscow) {
            if (Helper.sprint$.theWorld.getCollidingBoundingBoxes(Helper.sprint$.thePlayer, Helper.sprint$.thePlayer.getEntityBoundingBox().offset(Helper.sprint$.thePlayer.motionX * (double)var8, feature, Helper.sprint$.thePlayer.motionZ * (double)var8)).size() > 0) {
               return feature - 0.01D;
            }
         }
      }

      return (double)wrapping;
   }

   public static boolean _alice(double evilosem, double abiyecov, double ecidecuc, double var6, double var8, double var10) {
      return evilosem > var8 && evilosem < ecidecuc && abiyecov > var10 && abiyecov < var6;
   }

   public static int _samuel(int lesbian, int recorded) {
      return recorded < lesbian ? 0 : lesbian + assets$.nextInt(recorded - lesbian + 1);
   }

   public static double _austin(double uguzinib, double odudadal) {
      Object enidedeg = new Random();
      Object oliyevud = (double)(odudadal - uguzinib);
      double var7 = enidedeg.nextDouble() * oliyevud;
      if (var7 > odudadal) {
         var7 = (double)odudadal;
      }

      double var9 = var7 + uguzinib;
      if (var9 > odudadal) {
         var9 = (double)odudadal;
      }

      return var9;
   }

   public static int _military(int cycles, int princess, double stake) {
      Object forth = (int)cycles;
      if (cycles < princess) {
         int var5 = (int)((double)(princess - cycles) / stake);
         if (var5 < 1) {
            var5 = 1;
         }

         forth = cycles + var5;
      } else if (cycles > princess) {
         int var6 = (int)((double)(cycles - princess) / stake);
         if (var6 < 1) {
            var6 = 1;
         }

         forth = cycles - var6;
      }

      return forth;
   }

   public static Random _fetish() {
      return assets$;
   }

   public static int _reply(int compaq, int region) {
      // $FF: Couldn't be decompiled
   }

   public static boolean _catering(String otulerim) {
      Float.parseFloat((String)otulerim);
      return true;
   }

   public static double _currency(double router, double regime) {
      double var4 = 1.0D / regime;
      return (double)Math.round(router * var4) / var4;
   }

   public static double _charms(double ugudenir) {
      return (double)Math.round(ugudenir * 2.0D) / 2.0D;
   }

   public static Random _spell() {
      return assets$;
   }

   public static int _wells(int laughing, int outlet) {
      if (laughing > outlet) {
         return (int)laughing;
      } else {
         Object toshiba = new Random();
         return toshiba.nextInt((int)outlet) + laughing;
      }
   }

   public static double _closes(double conflict, double anxiety) {
      double var4;
      if (conflict >= anxiety) {
         var4 = (double)(conflict - anxiety);
      } else {
         var4 = (double)(anxiety - conflict);
      }

      return var4;
   }

   public static double _roller(double patients, double nested) {
      if (patients > nested) {
         return (double)patients;
      } else {
         Random var4 = new Random();
         return var4.nextDouble() * (nested - patients) + patients;
      }
   }

   public static float _police(double chaos) {
      return (float)((double)Math.round(chaos * 1.0E8D) / 1.0E8D);
   }

   public static double[] _wrapping(double zezibudu) {
      return _gives(Minecraft.getMinecraft().thePlayer.rotationYaw * mailman$, (double)zezibudu);
   }

   public static double[] _gives(float stuffed, double amounts) {
      return new double[]{(double)(-MathHelper.sin((float)stuffed)) * amounts, (double)MathHelper.cos((float)stuffed) * amounts};
   }

   public static float _solomon(float erepeyin, float ezenibid) {
      Object utupafuf = new SecureRandom();
      return utupafuf.nextFloat() * (ezenibid - erepeyin) + erepeyin;
   }
}
