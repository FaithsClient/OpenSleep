//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.color;

import java.awt.Color;
import net.minecraft.util.MathHelper;

public class ColorUtils2 {
   public static int _declared() {
      return -16777216 | (int)(Math.random() * 1.6777215E7D);
   }

   public static int _bicycle(int zasemore, double polerumu) {
      Object yinotedu = new Color((int)zasemore);
      Object uyuniler = 0.003921569F * (float)yinotedu.getRed();
      Object emicoder = 0.003921569F * (float)yinotedu.getGreen();
      float var6 = 0.003921569F * (float)yinotedu.getBlue();
      return (new Color(uyuniler, emicoder, var6, (float)polerumu)).getRGB();
   }

   public static int _ethnic(Color events, double batch) {
      return (new Color((float)((Color)events).getRed(), (float)((Color)events).getGreen(), (float)((Color)events).getBlue(), (float)batch)).getRGB();
   }

   public static int _episode(Color fiction) {
      return _workers(((Color)fiction).getRed(), ((Color)fiction).getGreen(), ((Color)fiction).getBlue(), ((Color)fiction).getAlpha());
   }

   public static int _focuses(int ideteloy) {
      return _workers((int)ideteloy, (int)ideteloy, (int)ideteloy, 255);
   }

   public static int _wallet(int isutudaf, int latufigo) {
      return _workers((int)isutudaf, (int)isutudaf, (int)isutudaf, (int)latufigo);
   }

   public static int _workers(int danish, int decent, int borough, int cleaner) {
      Object other = MathHelper.clamp_int((int)cleaner, 0, 255) << 24;
      other = other | MathHelper.clamp_int((int)danish, 0, 255) << 16;
      other = other | MathHelper.clamp_int((int)decent, 0, 255) << 8;
      other = other | MathHelper.clamp_int((int)borough, 0, 255);
      return other;
   }

   public static Color _anthony(long poguyuya, float aserilep) {
      Object yerubeya = (float)(System.nanoTime() + poguyuya) / 1.0E1F % 1.0F;
      Object zefaloyi = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(yerubeya, 1.0F, 1.0F)), 16);
      Color var6 = new Color((int)zefaloyi);
      return new Color((float)var6.getRed() / 255.0F * aserilep, (float)var6.getGreen() / 255.0F * aserilep, (float)var6.getBlue() / 255.0F * aserilep, (float)var6.getAlpha() / 255.0F);
   }

   public static float[] _soonest(int ucutofap) {
      Object iteladit = (float)(ucutofap >> 24 & 255) / 255.0F;
      Object fitarocu = (float)(ucutofap >> 16 & 255) / 255.0F;
      Object ivemapon = (float)(ucutofap >> 8 & 255) / 255.0F;
      Object eferelom = (float)(ucutofap & 255) / 255.0F;
      return new float[]{fitarocu, ivemapon, eferelom, iteladit};
   }

   public static int _lobby(String uletizat) {
      return ((String)uletizat).equalsIgnoreCase("rainbow") ? _anthony((long)-2047905611 ^ -2047905611L, 1.0F).getRGB() : Integer.parseInt((String)uletizat, 16);
   }

   public static String _corners(int osefavop) {
      return _strand(new Color((int)osefavop));
   }

   public static String _strand(Color family) {
      return Integer.toHexString(((Color)family).getRGB()).substring(2);
   }

   public static Color _infrared(Color ageneyib, Color eciravas, double esicunir) {
      Object lonabode = (float)esicunir;
      Object ofemiyiz = 1.0F - lonabode;
      Object batodayu = new float[3];
      Object enuriyom = new float[3];
      ((Color)ageneyib).getColorComponents(batodayu);
      ((Color)eciravas).getColorComponents(enuriyom);
      Color var8 = new Color(batodayu[0] * lonabode + enuriyom[0] * ofemiyiz, batodayu[1] * lonabode + enuriyom[1] * ofemiyiz, batodayu[2] * lonabode + enuriyom[2] * ofemiyiz);
      return var8;
   }

   public static Color _imperial(Color denied, Color timothy) {
      return _infrared((Color)denied, (Color)timothy, 0.5D);
   }

   public static Color _kenya(Color oborotet, double opizifir) {
      Object cocecefo = (int)Math.round((double)((Color)oborotet).getRed() * (1.0D - opizifir));
      Object nolatize = (int)Math.round((double)((Color)oborotet).getGreen() * (1.0D - opizifir));
      Object vovigori = (int)Math.round((double)((Color)oborotet).getBlue() * (1.0D - opizifir));
      if (cocecefo < 0) {
         cocecefo = 0;
      } else if (cocecefo > 255) {
         cocecefo = 255;
      }

      if (nolatize < 0) {
         nolatize = 0;
      } else if (nolatize > 255) {
         nolatize = 255;
      }

      if (vovigori < 0) {
         vovigori = 0;
      } else if (vovigori > 255) {
         vovigori = 255;
      }

      int var6 = ((Color)oborotet).getAlpha();
      return new Color(cocecefo, nolatize, vovigori, var6);
   }

   public static Color _pushed(Color rocket, double polls) {
      Object bikes = (int)Math.round((double)((Color)rocket).getRed() * (1.0D + polls));
      Object daily = (int)Math.round((double)((Color)rocket).getGreen() * (1.0D + polls));
      Object funny = (int)Math.round((double)((Color)rocket).getBlue() * (1.0D + polls));
      if (bikes < 0) {
         bikes = 0;
      } else if (bikes > 255) {
         bikes = 255;
      }

      if (daily < 0) {
         daily = 0;
      } else if (daily > 255) {
         daily = 255;
      }

      if (funny < 0) {
         funny = 0;
      } else if (funny > 255) {
         funny = 255;
      }

      int var6 = ((Color)rocket).getAlpha();
      return new Color(bikes, daily, funny, var6);
   }

   public static String _larry(Color holidays) {
      Object birthday = ((Color)holidays).getRed();
      Object fioricet = ((Color)holidays).getGreen();
      Object deleted = ((Color)holidays).getBlue();
      Object hungry = Integer.toString(birthday, 16);
      Object landing = Integer.toString(fioricet, 16);
      Object country = Integer.toString(deleted, 16);
      return (hungry.length() == 2 ? hungry : "0" + hungry) + (landing.length() == 2 ? landing : "0" + landing) + (country.length() == 2 ? country : "0" + country);
   }

   public static double _madonna(double fleece, double zdnet, double answers, double repeat, double escape, double var10) {
      double var12 = (double)(repeat - fleece);
      double var14 = (double)(escape - zdnet);
      double var16 = var10 - answers;
      return Math.sqrt(var12 * var12 + var14 * var14 + var16 * var16);
   }

   public static double _minority(double[] ogumirif, double[] lapotami) {
      return _madonna((double)((Object[])ogumirif)[0], (double)((Object[])ogumirif)[1], (double)((Object[])ogumirif)[2], (double)((Object[])lapotami)[0], (double)((Object[])lapotami)[1], (double)((Object[])lapotami)[2]);
   }

   public static double _cliff(Color league, Color range) {
      Object virtual = new float[3];
      Object chances = new float[3];
      ((Color)league).getColorComponents(virtual);
      ((Color)range).getColorComponents(chances);
      return _madonna((double)virtual[0], (double)virtual[1], (double)virtual[2], (double)chances[0], (double)chances[1], (double)chances[2]);
   }

   public static boolean _hebrew(double eparemer, double yecizoco, double otisesol) {
      double var6 = _madonna((double)eparemer, (double)yecizoco, (double)otisesol, 1.0D, 1.0D, 1.0D);
      double var8 = _madonna((double)eparemer, (double)yecizoco, (double)otisesol, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
      return var8 < var6;
   }

   public static boolean _children(Color tucagana) {
      Object buzetifi = (float)((Color)tucagana).getRed() / 255.0F;
      Object imipetiz = (float)((Color)tucagana).getGreen() / 255.0F;
      Object ibogecuy = (float)((Color)tucagana).getBlue() / 255.0F;
      return _hebrew((double)buzetifi, (double)imipetiz, (double)ibogecuy);
   }

   public static int _despite(int otalifev, int vinepiga, int ubeyuyor) {
      return _workers((int)otalifev, (int)vinepiga, (int)ubeyuyor, 255);
   }

   public static Color _reward(Color fossil, int raleigh, int arrives) {
      Object telling = new float[3];
      Color.RGBtoHSB(((Color)fossil).getRed(), ((Color)fossil).getGreen(), ((Color)fossil).getBlue(), telling);
      Object kelly = Math.abs(((float)(System.currentTimeMillis() % ((long)-1918850372 ^ -1918849684L)) / 1000.0F + (float)raleigh / (float)arrives * 2.0F) % 2.0F - 1.0F);
      kelly = 0.5F + 0.5F * kelly;
      telling[2] = kelly % 2.0F;
      return new Color(Color.HSBtoRGB(telling[0], telling[1], telling[2]));
   }
}
