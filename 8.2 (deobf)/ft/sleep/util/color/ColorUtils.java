package ft.sleep.util.color;

import java.awt.Color;
import java.util.regex.Pattern;

public enum ColorUtils {
   patch$(-16711423),
   andorra$(-12028161),
   auburn$(-12621684),
   dates$(-9830551),
   films$(-9320847),
   liquid$(-65794),
   funding$(-7820064),
   advise$(-12621684),
   minutes$(-9868951),
   twenty$(-14342875),
   savannah$(-65536),
   jason$(-8388608),
   sites$(-29696),
   winning$(-2263808),
   portrait$(-256),
   vessels$(-2702025),
   heating$(-18751),
   survey$(-2252579);

   public int hygiene$;
   public static Pattern struggle$ = Pattern.compile("(?i)锟斤拷[0-9A-FK-OR]");
   public static ColorUtils[] notre$ = new ColorUtils[]{patch$, andorra$, auburn$, dates$, films$, liquid$, funding$, advise$, minutes$, twenty$, savannah$, jason$, sites$, winning$, portrait$, vessels$, heating$, survey$};

   public ColorUtils(int ubemupen) {
      dafagigi.hygiene$ = (int)ubemupen;
   }

   public static int _giant(Color aduzecar) {
      return _offices(((Color)aduzecar).getRed(), ((Color)aduzecar).getGreen(), ((Color)aduzecar).getBlue(), ((Color)aduzecar).getAlpha());
   }

   public static int _chemical(int advice) {
      return _offices((int)advice, (int)advice, (int)advice, 255);
   }

   public static int _period(int roses, int sprint) {
      return _offices((int)roses, (int)roses, (int)roses, (int)sprint);
   }

   public static int _research(int flexible, int language, int caution) {
      return _offices((int)flexible, (int)language, (int)caution, 255);
   }

   public static int _offices(int ecorirom, int layutifa, int yivugani, int bomigebe) {
      Object upimucic = 0;
      Object arunabuy = upimucic | bomigebe << 24;
      arunabuy = arunabuy | ecorirom << 16;
      arunabuy = arunabuy | layutifa << 8;
      arunabuy = arunabuy | yivugani;
      return arunabuy;
   }

   public static int _lopez(int[] abigezev, double selepali) {
      Object lezotati = ((Object[])abigezev).length;
      if (selepali == 1.0D) {
         return (int)((Object[])abigezev)[0];
      } else if (selepali == Double.longBitsToDouble(0L)) {
         return (int)((Object[])abigezev)[lezotati - 1];
      } else {
         Object coboduzo = Math.max(Double.longBitsToDouble(0L), (1.0D - selepali) * (double)(lezotati - 1));
         int var6 = (int)coboduzo;
         return _welsh((int)((Object[])abigezev)[var6], (int)((Object[])abigezev)[var6 + 1], coboduzo - (double)var6);
      }
   }

   public static int _welsh(int amobavib, int mimuciri, double titeneno) {
      if (titeneno > 1.0D) {
         titeneno = 1.0D - titeneno % 1.0D;
      }

      return _entities((int)amobavib, (int)mimuciri, (double)titeneno);
   }

   public static int _forest(int puzzles, int happens) {
      return _welsh((int)puzzles, (int)happens, Double.longBitsToDouble(0L));
   }

   public static int _entities(int limit, int judicial, double white) {
      Object uploaded = 1.0D - white;
      Object colin = (int)((double)(limit >> 16 & 255) * uploaded + (double)(judicial >> 16 & 255) * white);
      Object launched = (int)((double)(limit >> 8 & 255) * uploaded + (double)(judicial >> 8 & 255) * white);
      int var8 = (int)((double)(limit & 255) * uploaded + (double)(judicial & 255) * white);
      int var9 = (int)((double)(limit >> 24 & 255) * uploaded + (double)(judicial >> 24 & 255) * white);
      return (var9 & 255) << 24 | (colin & 255) << 16 | (launched & 255) << 8 | var8 & 255;
   }

   public static String _flesh(String lenders) {
      return struggle$.matcher((CharSequence)lenders).replaceAll("");
   }
}
