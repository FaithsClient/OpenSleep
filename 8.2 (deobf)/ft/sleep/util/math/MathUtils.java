package ft.sleep.util.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Random;

public class MathUtils {
   public static Random marble$ = new Random();

   public static int _skins(int vitadiru, int mofedavo) {
      return (int)(Math.random() * (double)(vitadiru - mofedavo)) + mofedavo;
   }

   public static double _compare(double custody, int secured) {
      if (secured < 0) {
         return (double)custody;
      } else {
         BigDecimal var3 = new BigDecimal((double)custody);
         var3 = var3.setScale((int)secured, RoundingMode.HALF_UP);
         return var3.doubleValue();
      }
   }

   public static float _minus(float paronesu, float layunula) {
      Object oraceric = new SecureRandom();
      return oraceric.nextFloat() * (layunula - paronesu) + paronesu;
   }

   public static long _trailer(int camps, int pearl) {
      return (long)_outdoor((int)camps, pearl + 1);
   }

   public static int _outdoor(int broken, int graduate) {
      // $FF: Couldn't be decompiled
   }

   public static double _logged(double macro, double drainage) {
      double var4 = 1.0D / drainage;
      return (double)Math.round(macro * var4) / var4;
   }

   public static boolean _status(Double elopeyip) {
      return ((Double)elopeyip).doubleValue() == Math.floor(((Double)elopeyip).doubleValue()) && !Double.isInfinite(((Double)elopeyip).doubleValue());
   }

   public static float _fatty(float feels, float columbus, float trial) {
      // $FF: Couldn't be decompiled
   }

   public static int _judicial(int omizemer, int izogayag) {
      // $FF: Couldn't be decompiled
   }

   public static int _hostels(int brokers, int bright, int cents) {
      // $FF: Couldn't be decompiled
   }

   public static double _detroit(double tocegavi, double palizetu) {
      if (palizetu == Double.longBitsToDouble(0L)) {
         return (double)tocegavi;
      } else if (palizetu == 1.0D) {
         return (double)Math.round((double)tocegavi);
      } else {
         double var4 = palizetu / 2.0D;
         double var6 = Math.floor((double)(tocegavi / palizetu)) * palizetu;
         return tocegavi >= var6 + var4 ? (new BigDecimal(Math.ceil((double)(tocegavi / palizetu)) * palizetu)).doubleValue() : (new BigDecimal(var6)).doubleValue();
      }
   }

   public static float _daddy(float thousand, float cheap) {
      Object knights = 3.141592653D;
      double var4 = 1.0D / Math.sqrt(2.0D * knights * (double)(cheap * cheap));
      return (float)(var4 * Math.exp((double)(-(thousand * thousand)) / (2.0D * (double)(cheap * cheap))));
   }

   public static Double _prozac(double ebesaloz, double mefiyovi, double var4) {
      return ebesaloz + (mefiyovi - ebesaloz) * var4;
   }

   public static float _saints(float signed, float chicago, double clocks) {
      return _prozac((double)signed, (double)chicago, (double)((float)clocks)).floatValue();
   }

   public static int _ultram(int answered, int turns) {
      return (int)(Math.random() * (double)(turns - answered) + (double)answered);
   }
}
