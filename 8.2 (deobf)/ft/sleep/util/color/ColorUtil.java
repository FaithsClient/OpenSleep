package ft.sleep.util.color;

import java.awt.Color;
import java.util.regex.Pattern;
import org.lwjgl.opengl.GL11;

public class ColorUtil {
   public static String vendor$ = "§7";
   public static Pattern handles$ = Pattern.compile("(?i)ยง[0-9A-FK-OR]");

   public static Color _exposed(float based, float animated, float campbell) {
      Object meets = (float)(System.currentTimeMillis() % (long)((int)(based * 1000.0F))) / (based * 1000.0F);
      return new Color(Color.HSBtoRGB(meets, (float)animated, (float)campbell));
   }

   public static Color _zoning(float epacofiv, float sulefuyo, float amapusig, long abivafaz) {
      float var5 = (float)((System.currentTimeMillis() + abivafaz) % (long)((int)(epacofiv * 1000.0F))) / (epacofiv * 1000.0F);
      return new Color(Color.HSBtoRGB(var5, (float)sulefuyo, (float)amapusig));
   }

   public static Color _prisoner(Color scanners, int brave, int flickr) {
      Object things = new float[3];
      Color.RGBtoHSB(((Color)scanners).getRed(), ((Color)scanners).getGreen(), ((Color)scanners).getBlue(), things);
      Object candle = Math.abs(((float)(System.currentTimeMillis() % ((long)-1086631130 ^ -1086630666L)) / 1000.0F + (float)brave / (float)flickr * 2.0F) % 2.0F - 1.0F);
      candle = 0.5F + 0.5F * candle;
      things[2] = candle % 2.0F;
      return new Color(Color.HSBtoRGB(things[0], things[1], things[2]));
   }

   public static Color _enjoying(double reported, double hottest) {
      long var4 = Math.round(hottest / 5.0D);
      if (reported >= (double)(var4 * ((long)-912634512 ^ -912634507L))) {
         return new Color(15, 255, 15);
      } else if (reported >= (double)(var4 * ((long)1446849440 ^ 1446849444L))) {
         return new Color(166, 255, 0);
      } else if (reported >= (double)(var4 * ((long)-769660024 ^ -769660021L))) {
         return new Color(255, 191, 0);
      } else {
         return reported >= (double)(var4 * ((long)1880310753 ^ 1880310755L)) ? new Color(255, 89, 0) : new Color(255, 0, 0);
      }
   }

   public static Color _assure(Color issue, int office, int kevin) {
      Object spray = Math.max(((Color)issue).getRed() - office, 0);
      Object wedding = Math.max(((Color)issue).getGreen() - office, 0);
      Object museum = Math.max(((Color)issue).getBlue() - office, 0);
      return new Color(spray, wedding, museum, (int)kevin);
   }

   public static Color _thirty(Color mocomotu, int zomomica, int utasemas) {
      Object repoburo = Math.min(((Color)mocomotu).getRed() + zomomica, 255);
      Object inagodad = Math.min(((Color)mocomotu).getGreen() + zomomica, 255);
      Object agofarec = Math.min(((Color)mocomotu).getBlue() + zomomica, 255);
      return new Color(repoburo, inagodad, agofarec, (int)utasemas);
   }

   public static void _candles(int britney) {
      Object wealth = (float)(britney >> 16 & 255) / 255.0F;
      Object examines = (float)(britney >> 8 & 255) / 255.0F;
      Object guidance = (float)(britney & 255) / 255.0F;
      Object margin = (float)(britney >> 24 & 255) / 255.0F;
      GL11.glColor4f(wealth, examines, guidance, margin);
   }

   public static Color _senior(Color rogers, int barbados) {
      return new Color(((Color)rogers).getRed(), ((Color)rogers).getGreen(), ((Color)rogers).getBlue(), (int)barbados);
   }

   public static int _broken(int sumesase, int zepoligi, int lonadene, int egutifem) {
      Object lorafoni = 0;
      lorafoni = lorafoni | egutifem << 24;
      lorafoni = lorafoni | sumesase << 16;
      lorafoni = lorafoni | zepoligi << 8;
      return lorafoni | lonadene;
   }

   public static int _contract(int izaralus) {
      return _broken((int)izaralus, (int)izaralus, (int)izaralus, 255);
   }

   public static Color _answers(long appears, float trivia, float visual) {
      Object succeed = ((float)appears + (1.0F + trivia) * 2.0E8F) / 1.0E1F % 1.0F;
      Object reply = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(succeed, 0.7F, 1.0F)), 16);
      Color var7 = new Color((int)reply);
      return new Color((float)var7.getRed() / 255.0F * visual, (float)var7.getGreen() / 255.0F * visual, (float)var7.getBlue() / 255.0F * visual, (float)var7.getAlpha() / 255.0F);
   }

   public static Color _blair(Color bumodiba, Color irunucic, double sozavace) {
      Object adalonef = (float)sozavace;
      Object mabetefu = 1.0F - adalonef;
      Object veyatadu = new float[3];
      Object ivobanay = new float[3];
      ((Color)bumodiba).getColorComponents(veyatadu);
      ((Color)irunucic).getColorComponents(ivobanay);
      Object tevibovu = veyatadu[0] * adalonef + ivobanay[0] * mabetefu;
      Object muluyapi = veyatadu[1] * adalonef + ivobanay[1] * mabetefu;
      Object doyuvaza = veyatadu[2] * adalonef + ivobanay[2] * mabetefu;
      if (tevibovu < Float.intBitsToFloat(0)) {
         tevibovu = Float.intBitsToFloat(0);
      } else if (tevibovu > 255.0F) {
         tevibovu = 255.0F;
      }

      if (muluyapi < Float.intBitsToFloat(0)) {
         muluyapi = Float.intBitsToFloat(0);
      } else if (muluyapi > 255.0F) {
         muluyapi = 255.0F;
      }

      if (doyuvaza < Float.intBitsToFloat(0)) {
         doyuvaza = Float.intBitsToFloat(0);
      } else if (doyuvaza > 255.0F) {
         doyuvaza = 255.0F;
      }

      Object enebesol = null;
      enebesol = new Color(tevibovu, muluyapi, doyuvaza);
      return enebesol;
   }

   public static Color _crafts(float[] collect, Color[] blogs, float lists) {
      if (collect == null) {
         throw new IllegalArgumentException("Fractions can't be null");
      } else if (blogs == null) {
         throw new IllegalArgumentException("Colours can't be null");
      } else if (((Object[])collect).length == ((Object[])blogs).length) {
         Object shapes = _pattern((float[])collect, (float)lists);
         Object ability = new float[]{(float)((Object[])collect)[shapes[0]], (float)((Object[])collect)[shapes[1]]};
         Object change = new Color[]{(Color)((Object[])blogs)[shapes[0]], (Color)((Object[])blogs)[shapes[1]]};
         Object clinic = ability[1] - ability[0];
         Object timber = lists - ability[0];
         Object portal = timber / clinic;
         return _blair(change[0], change[1], (double)(1.0F - portal));
      } else {
         throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
      }
   }

   public static int[] _pattern(float[] tracking, float lambda) {
      Object benefit = new int[2];

      int tasks;
      for(tasks = 0; tasks < ((Object[])tracking).length && ((Object[])tracking)[tasks] <= lambda; ++tasks) {
         ;
      }

      if (tasks >= ((Object[])tracking).length) {
         tasks = ((Object[])tracking).length - 1;
      }

      benefit[0] = tasks - 1;
      benefit[1] = tasks;
      return benefit;
   }

   public static int _maiden(Color emufegat, Color pitutabi, float godezusu) {
      godezusu = Math.min(1.0F, Math.max(Float.intBitsToFloat(0), (float)godezusu));
      return _impaired((Color)emufegat, (Color)pitutabi, (float)godezusu).getRGB();
   }

   public static int _benjamin(int efivupec, int pofeyore, float ulinuyov) {
      ulinuyov = Math.min(1.0F, Math.max(Float.intBitsToFloat(0), (float)ulinuyov));
      Object fetegube = new Color((int)efivupec);
      Object zileyusi = new Color((int)pofeyore);
      return _impaired(fetegube, zileyusi, (float)ulinuyov).getRGB();
   }

   public static Double _darkness(double correct, double baseball, double var4) {
      return correct + (baseball - correct) * var4;
   }

   public static float _depth(float inesuvoz, float zudasase, double elavunul) {
      return _darkness((double)inesuvoz, (double)zudasase, (double)((float)elavunul)).floatValue();
   }

   public static int _honolulu(int efifelat, int ibazedad, double ipipufud) {
      return _darkness((double)efifelat, (double)ibazedad, (double)((float)ipipufud)).intValue();
   }

   public static Color _impaired(Color slight, Color remote, float firms) {
      firms = Math.min(1.0F, Math.max(Float.intBitsToFloat(0), (float)firms));
      return new Color(_honolulu(((Color)slight).getRed(), ((Color)remote).getRed(), (double)firms), _honolulu(((Color)slight).getGreen(), ((Color)remote).getGreen(), (double)firms), _honolulu(((Color)slight).getBlue(), ((Color)remote).getBlue(), (double)firms), _honolulu(((Color)slight).getAlpha(), ((Color)remote).getAlpha(), (double)firms));
   }

   public static Color _medieval(Color strategy, Color adapter, float bought) {
      bought = Math.min(1.0F, Math.max(Float.intBitsToFloat(0), (float)bought));
      Object forget = Color.RGBtoHSB(((Color)strategy).getRed(), ((Color)strategy).getGreen(), ((Color)strategy).getBlue(), (float[])null);
      Object permit = Color.RGBtoHSB(((Color)adapter).getRed(), ((Color)adapter).getGreen(), ((Color)adapter).getBlue(), (float[])null);
      Object addition = Color.getHSBColor(_depth(forget[0], permit[0], (double)bought), _depth(forget[1], permit[1], (double)bought), _depth(forget[2], permit[2], (double)bought));
      return new Color(addition.getRed(), addition.getGreen(), addition.getBlue(), _honolulu(((Color)strategy).getAlpha(), ((Color)adapter).getAlpha(), (double)bought));
   }

   public static Color _islamic(int examined, int phrases, Color bracket, Color endless, boolean mainly) {
      Object chamber = (int)((System.currentTimeMillis() / (long)examined + (long)phrases) % ((long)-1326407827 ^ -1326408187L));
      chamber = (chamber >= 180 ? 360 - chamber : chamber) * 2;
      return mainly ? _medieval((Color)bracket, (Color)endless, (float)chamber / 360.0F) : _impaired((Color)bracket, (Color)endless, (float)chamber / 360.0F);
   }

   public static String _attacked(String iduvopuz) {
      return handles$.matcher((CharSequence)iduvopuz).replaceAll("");
   }

   public static int _handheld(int lurisaze, float ubosucup) {
      Object tonofugo = new Color((int)lurisaze);
      return _resulted(tonofugo, (float)ubosucup).getRGB();
   }

   public static Color _resulted(Color onutorud, float misinapu) {
      misinapu = Math.min(1.0F, Math.max(Float.intBitsToFloat(0), (float)misinapu));
      return new Color(((Color)onutorud).getRed(), ((Color)onutorud).getGreen(), ((Color)onutorud).getBlue(), (int)((float)((Color)onutorud).getAlpha() * misinapu));
   }
}
