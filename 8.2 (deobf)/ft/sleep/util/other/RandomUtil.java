package ft.sleep.util.other;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
   public ThreadLocalRandom brought$ = ThreadLocalRandom.current();
   public static RandomUtil thick$;

   public static double _april(double deeply, double world) {
      Object trails = new Random();
      Object particle = (double)(world - deeply);
      double var7 = trails.nextDouble() * particle;
      if (var7 > world) {
         var7 = (double)world;
      }

      double var9 = var7 + deeply;
      if (var9 > world) {
         var9 = (double)world;
      }

      return var9;
   }

   public double _rarely(double times, double var3) {
      return gamma.brought$.nextDouble((double)times, var3);
   }

   public int _filed(int abumadop, int zopeburo) {
      return nupuvuco.brought$.nextInt((int)abumadop, (int)zopeburo);
   }

   public double _scores(double anecobim) {
      return feleduvu.brought$.nextGaussian() * anecobim;
   }

   public float _julie(float duyenara, float benacose) {
      return (float)irosozoz.brought$.nextDouble((double)duyenara, (double)benacose);
   }

   public double _palace(double utumunac, double baginuro, double dugofiyo, boolean gezeneve, double emafigac) {
      ++baginuro;
      double var10 = Math.toRadians((double)System.currentTimeMillis() * dugofiyo % 360.0D - 180.0D);
      double var12 = (Math.tanh(var10) + 1.0D) / 2.0D;
      double var14 = (double)(utumunac - baginuro);
      var14 = var14 * var12;
      double var16 = baginuro + var14;
      if (gezeneve) {
         var16 *= ThreadLocalRandom.current().nextDouble((double)emafigac, 1.0D);
      }

      return Math.ceil(var16 * 1000.0D) / 1000.0D;
   }

   public static RandomUtil _helpful() {
      if (thick$ == null) {
         thick$ = new RandomUtil();
      }

      return thick$;
   }
}
