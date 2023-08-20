package ft.sleep.util.other;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Kernel;

public class GaussianFilter extends ConvolveFilter {
   public float farming$;
   public Kernel cellular$;

   public GaussianFilter() {
      this(2.0F);
   }

   public GaussianFilter(float ulotelor) {
      vububaci._force((float)ulotelor);
   }

   public void _force(float bleeding) {
      handles.farming$ = (float)bleeding;
      handles.cellular$ = _bought((float)bleeding);
   }

   public float _fujitsu() {
      return targets.farming$;
   }

   public BufferedImage filter(BufferedImage ivusayey, BufferedImage acetutir) {
      Object ugogepag = ((BufferedImage)ivusayey).getWidth();
      Object tegagiya = ((BufferedImage)ivusayey).getHeight();
      if (acetutir == null) {
         acetutir = mozameba.createCompatibleDestImage((BufferedImage)ivusayey, (ColorModel)null);
      }

      Object mitolede = new int[ugogepag * tegagiya];
      Object dagolice = new int[ugogepag * tegagiya];
      ((BufferedImage)ivusayey).getRGB(0, 0, ugogepag, tegagiya, mitolede, 0, ugogepag);
      if (mozameba.farming$ > Float.intBitsToFloat(0)) {
         _controls(mozameba.cellular$, mitolede, dagolice, ugogepag, tegagiya, mozameba., mozameba. && mozameba., false, );
         _controls(mozameba.cellular$, dagolice, mitolede, tegagiya, ugogepag, mozameba., false, mozameba. && mozameba., );
      }

      ((BufferedImage)acetutir).setRGB(0, 0, ugogepag, tegagiya, mitolede, 0, ugogepag);
      return (BufferedImage)acetutir;
   }

   public static void _controls(Kernel houston, int[] oliver, int[] money, int driving, int switches, boolean literary, boolean wired, boolean engine, int although) {
      Object longer = ((Kernel)houston).getKernelData((float[])null);
      Object glenn = ((Kernel)houston).getWidth();
      Object contest = glenn / 2;

      for(Object retired = 0; retired < switches; ++retired) {
         Object colorado = retired;
         Object generous = retired * driving;

         for(Object under = 0; under < driving; ++under) {
            Object midnight = Float.intBitsToFloat(0);
            Object miller = Float.intBitsToFloat(0);
            Object arctic = Float.intBitsToFloat(0);
            Object bidding = Float.intBitsToFloat(0);
            Object present = contest;

            for(Object request = -contest; request <= contest; ++request) {
               Object attempts = longer[present + request];
               if (attempts != Float.intBitsToFloat(0)) {
                  Object timing = under + request;
                  if (timing < 0) {
                     if (although == ) {
                        timing = 0;
                     } else if (although == ) {
                        timing = (under + driving) % driving;
                     }
                  } else if (timing >= driving) {
                     if (although == ) {
                        timing = driving - 1;
                     } else if (although == ) {
                        timing = (under + driving) % driving;
                     }
                  }

                  Object guard = (int)((Object[])oliver)[generous + timing];
                  Object became = guard >> 24 & 255;
                  Object cargo = guard >> 16 & 255;
                  Object coins = guard >> 8 & 255;
                  Object beach = guard & 255;
                  if (wired) {
                     Object theories = (float)became * 0.003921569F;
                     cargo = (int)((float)cargo * theories);
                     coins = (int)((float)coins * theories);
                     beach = (int)((float)beach * theories);
                  }

                  bidding += attempts * (float)became;
                  midnight += attempts * (float)cargo;
                  miller += attempts * (float)coins;
                  arctic += attempts * (float)beach;
               }
            }

            if (engine && bidding != Float.intBitsToFloat(0) && bidding != 255.0F) {
               Object var30 = 255.0F / bidding;
               midnight *= var30;
               miller *= var30;
               arctic *= var30;
            }

            Object var31 = literary ? _burning((int)((double)bidding + 0.5D)) : 255;
            Object var32 = _burning((int)((double)midnight + 0.5D));
            Object var33 = _burning((int)((double)miller + 0.5D));
            Object var34 = _burning((int)((double)arctic + 0.5D));
            ((Object[])money)[colorado] = var31 << 24 | var32 << 16 | var33 << 8 | var34;
            colorado += switches;
         }
      }

   }

   public static int _burning(int tipafuyo) {
      // $FF: Couldn't be decompiled
   }

   public static Kernel _bought(float ignored) {
      Object zoning = (int)Math.ceil((double)ignored);
      Object pending = zoning * 2 + 1;
      Object seminars = new float[pending];
      Object outlets = ignored / 3.0F;
      Object database = 2.0F * outlets * outlets;
      Object theorem = 6.2831855F * outlets;
      Object beans = (float)Math.sqrt((double)theorem);
      Object mailed = (float)(ignored * ignored);
      Object plains = Float.intBitsToFloat(0);
      Object weddings = 0;

      for(Object mouth = -zoning; mouth <= zoning; ++mouth) {
         Object strain = (float)(mouth * mouth);
         if (strain > mailed) {
            seminars[weddings] = Float.intBitsToFloat(0);
         } else {
            seminars[weddings] = (float)Math.exp((double)(-strain / database)) / beans;
         }

         plains += seminars[weddings];
         ++weddings;
      }

      for(Object var13 = 0; var13 < pending; ++var13) {
         seminars[var13] /= plains;
      }

      return new Kernel(pending, 1, seminars);
   }

   public String toString() {
      return "Blur/Gaussian Blur...";
   }
}
