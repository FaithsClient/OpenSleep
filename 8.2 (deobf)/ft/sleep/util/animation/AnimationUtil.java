//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.animation;

import net.minecraft.client.Minecraft;

public class AnimationUtil {
   public static double marriott$;

   public static float _button(float capunofo, float acecusob, float olugulev, float gecovozo) {
      Object zitubovi = (float)((acecusob - capunofo) * olugulev);
      if (zitubovi > Float.intBitsToFloat(0)) {
         zitubovi = Math.max((float)gecovozo, zitubovi);
         zitubovi = Math.min((float)(acecusob - capunofo), zitubovi);
      } else if (zitubovi < Float.intBitsToFloat(0)) {
         zitubovi = Math.min((float)(-gecovozo), zitubovi);
         zitubovi = Math.max((float)(acecusob - capunofo), zitubovi);
      }

      return capunofo + zitubovi;
   }

   public static float _tomato(float surely, float lighting, double reads) {
      Object mayor = (double)Math.abs((float)(lighting - surely));
      float var6 = (float)Math.abs((double)(lighting - (lighting - Math.abs((float)(lighting - surely)))) / (100.0D - reads * 10.0D));
      float var7 = (float)surely;
      if (mayor != Double.longBitsToDouble(0L) && mayor < (double)var6) {
         var6 = (float)mayor;
      }

      if (mayor > Double.longBitsToDouble(0L)) {
         if (surely < lighting) {
            var7 = surely + var6 * RenderUtil2.helen$;
         } else if (surely > lighting) {
            var7 = surely - var6 * RenderUtil2.helen$;
         }
      } else {
         var7 = (float)lighting;
      }

      if ((double)Math.abs(lighting - var7) < 0.05D && var7 != lighting) {
         var7 = (float)lighting;
      }

      return var7;
   }

   public static float _sizes(float zafogase, float igufayip, long babicula, int adurazar) {
      Object mononaci = (float)(igufayip - zafogase);
      if (babicula < ((long)-444768826 ^ -444768825L)) {
         babicula = (long)-1498927867 ^ -1498927868L;
      }

      if (mononaci > (float)adurazar) {
         double var6 = (double)((long)adurazar * babicula / ((long)420945504 ^ 420945520L)) < 0.25D ? 0.5D : (double)((long)adurazar * babicula / ((long)-137220693 ^ -137220677L));
         igufayip = (float)((double)igufayip - var6);
         if (igufayip < zafogase) {
            igufayip = zafogase;
         }
      } else if (mononaci < (float)(-adurazar)) {
         double var9 = (double)((long)adurazar * babicula / ((long)546878342 ^ 546878358L)) < 0.25D ? 0.5D : (double)((long)adurazar * babicula / ((long)-704102787 ^ -704102803L));
         igufayip = (float)((double)igufayip + var9);
         if (igufayip > zafogase) {
            igufayip = zafogase;
         }
      } else {
         igufayip = zafogase;
      }

      return (float)igufayip;
   }

   public static float _tropical(float twelve, float climbing, long plots, double anybody) {
      float var6 = (float)(climbing - twelve);
      if (plots < ((long)-481456703 ^ -481456704L)) {
         plots = (long)-1227954227 ^ -1227954228L;
      }

      if (plots > ((long)-1873582831 ^ -1873582343L)) {
         plots = (long)-859068318 ^ -859068302L;
      }

      if ((double)var6 > anybody) {
         double var7 = Math.max(anybody * (double)plots / 16.0D, 0.5D);
         climbing = (float)((double)climbing - var7);
         if (climbing < twelve) {
            climbing = twelve;
         }
      } else if ((double)var6 < -anybody) {
         double var10 = Math.max(anybody * (double)plots / 16.0D, 0.5D);
         climbing = (float)((double)climbing + var10);
         if (climbing > twelve) {
            climbing = twelve;
         }
      } else {
         climbing = twelve;
      }

      return (float)climbing;
   }

   public static float _pretty(float speak, float jersey, float lyrics) {
      Object angola = (float)(marriott$ * (double)(lyrics / 1000.0F));
      if (speak < jersey) {
         if (speak + angola < jersey) {
            speak = speak + angola;
         } else {
            speak = jersey;
         }
      } else if (speak - angola > jersey) {
         speak = speak - angola;
      } else {
         speak = jersey;
      }

      return (float)speak;
   }

   public static float _meeting(float usesaluy, float gafofitu, float afaruyoy) {
      Object olovotay = (gafofitu - usesaluy) / Math.max((float)Minecraft.getDebugFPS(), 5.0F) * 15.0F;
      if (olovotay > Float.intBitsToFloat(0)) {
         olovotay = Math.max((float)afaruyoy, olovotay);
         olovotay = Math.min((float)(gafofitu - usesaluy), olovotay);
      } else if (olovotay < Float.intBitsToFloat(0)) {
         olovotay = Math.min((float)(-afaruyoy), olovotay);
         olovotay = Math.max((float)(gafofitu - usesaluy), olovotay);
      }

      return usesaluy + olovotay;
   }

   public static double _chrysler(double kingston, double alpha, double var4) {
      double var6 = (alpha - kingston) / (double)Math.max(Minecraft.getDebugFPS(), 5) * var4;
      if (var6 > Double.longBitsToDouble(0L)) {
         var6 = Math.max(var4, var6);
         var6 = Math.min((double)(alpha - kingston), var6);
      } else if (var6 < Double.longBitsToDouble(0L)) {
         var6 = Math.min(-var4, var6);
         var6 = Math.max((double)(alpha - kingston), var6);
      }

      return kingston + var6;
   }
}
