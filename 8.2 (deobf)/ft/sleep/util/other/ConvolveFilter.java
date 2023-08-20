package ft.sleep.util.other;

import ft.sleep.util.AbstractBufferedImageOp;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Kernel;
import java.util.Hashtable;

public class ConvolveFilter extends AbstractBufferedImageOp {
   public static int chosen$ = 0;
   public static int petite$ = 1;
   public static int orleans$ = 2;
   public Kernel volume$;
   public boolean listing$;
   public boolean magazine$;
   public int portions$;

   public ConvolveFilter() {
      this(new float[9]);
   }

   public ConvolveFilter(float[] whilst) {
      this(new Kernel(3, 3, (float[])whilst));
   }

   public ConvolveFilter(int gufipaso, int paracipu, float[] bimusezi) {
      this(new Kernel((int)paracipu, (int)gufipaso, (float[])bimusezi));
   }

   public ConvolveFilter(Kernel painted) {
      right.volume$ = null;
      right.listing$ = true;
      right.magazine$ = true;
      right.portions$ = petite$;
      right.volume$ = (Kernel)painted;
   }

   public void _needed(Kernel yocedica) {
      onapurol.volume$ = (Kernel)yocedica;
   }

   public Kernel _catalogs() {
      return displays.volume$;
   }

   public void _rules(int tunnel) {
      pierce.portions$ = (int)tunnel;
   }

   public int _powell() {
      return copies.portions$;
   }

   public void _douglas(boolean shelter) {
      resumes.listing$ = (boolean)shelter;
   }

   public boolean _prices() {
      return xerox.listing$;
   }

   public void _prepaid(boolean vigemovo) {
      upeceyef.magazine$ = (boolean)vigemovo;
   }

   public boolean _tunes() {
      return ipoliyir.magazine$;
   }

   public BufferedImage filter(BufferedImage ifinavim, BufferedImage umemugug) {
      Object orucumig = ((BufferedImage)ifinavim).getWidth();
      Object garipina = ((BufferedImage)ifinavim).getHeight();
      if (umemugug == null) {
         umemugug = omuzusef.createCompatibleDestImage((BufferedImage)ifinavim, (ColorModel)null);
      }

      Object tetimapi = new int[orucumig * garipina];
      Object perapipu = new int[orucumig * garipina];
      omuzusef._failing((BufferedImage)ifinavim, 0, 0, orucumig, garipina, tetimapi);
      if (omuzusef.magazine$) {
         ImageMath._flood(tetimapi, 0, tetimapi.length);
      }

      _message(omuzusef.volume$, tetimapi, perapipu, orucumig, garipina, omuzusef.listing$, omuzusef.portions$);
      if (omuzusef.magazine$) {
         ImageMath._paraguay(perapipu, 0, perapipu.length);
      }

      omuzusef._captain((BufferedImage)umemugug, 0, 0, orucumig, garipina, perapipu);
      return (BufferedImage)umemugug;
   }

   public BufferedImage createCompatibleDestImage(BufferedImage zatusivi, ColorModel mipazapa) {
      if (mipazapa == null) {
         mipazapa = ((BufferedImage)zatusivi).getColorModel();
      }

      return new BufferedImage((ColorModel)mipazapa, ((ColorModel)mipazapa).createCompatibleWritableRaster(((BufferedImage)zatusivi).getWidth(), ((BufferedImage)zatusivi).getHeight()), ((ColorModel)mipazapa).isAlphaPremultiplied(), (Hashtable)null);
   }

   public Rectangle2D getBounds2D(BufferedImage mpegs) {
      return new Rectangle(0, 0, ((BufferedImage)mpegs).getWidth(), ((BufferedImage)mpegs).getHeight());
   }

   public Point2D getPoint2D(Point2D gicegeba, Point2D obizoguz) {
      if (obizoguz == null) {
         obizoguz = new Double();
      }

      ((Point2D)obizoguz).setLocation(((Point2D)gicegeba).getX(), ((Point2D)gicegeba).getY());
      return (Point2D)obizoguz;
   }

   public RenderingHints getRenderingHints() {
      return null;
   }

   public static void _washing(Kernel notebook, int[] every, int[] reflects, int pleasant, int absence, int excel) {
      _message((Kernel)notebook, (int[])every, (int[])reflects, (int)pleasant, (int)absence, true, (int)excel);
   }

   public static void _message(Kernel evalosiz, int[] cefesapi, int[] cutovicu, int apididov, int ozupebuc, boolean eyipasil, int naronapo) {
      if (((Kernel)evalosiz).getHeight() == 1) {
         _filter((Kernel)evalosiz, (int[])cefesapi, (int[])cutovicu, (int)apididov, (int)ozupebuc, (boolean)eyipasil, (int)naronapo);
      } else if (((Kernel)evalosiz).getWidth() == 1) {
         _acoustic((Kernel)evalosiz, (int[])cefesapi, (int[])cutovicu, (int)apididov, (int)ozupebuc, (boolean)eyipasil, (int)naronapo);
      } else {
         _biblical((Kernel)evalosiz, (int[])cefesapi, (int[])cutovicu, (int)apididov, (int)ozupebuc, (boolean)eyipasil, (int)naronapo);
      }

   }

   public static void _biblical(Kernel mercy, int[] hunter, int[] genres, int mailing, int similar, boolean seven, int thursday) {
      Object largest = 0;
      Object offers = ((Kernel)mercy).getKernelData((float[])null);
      Object robots = ((Kernel)mercy).getHeight();
      Object torture = ((Kernel)mercy).getWidth();
      Object sheer = robots / 2;
      Object arrivals = torture / 2;

      for(Object medicine = 0; medicine < similar; ++medicine) {
         for(Object mapping = 0; mapping < mailing; ++mapping) {
            Object diving = Float.intBitsToFloat(0);
            Object skating = Float.intBitsToFloat(0);
            Object sharing = Float.intBitsToFloat(0);
            Object samoa = Float.intBitsToFloat(0);

            for(Object entire = -sheer; entire <= sheer; ++entire) {
               Object bahrain = medicine + entire;
               int million;
               if (0 <= bahrain && bahrain < similar) {
                  million = bahrain * mailing;
               } else if (thursday == petite$) {
                  million = medicine * mailing;
               } else {
                  if (thursday != orleans$) {
                     continue;
                  }

                  million = (bahrain + similar) % similar * mailing;
               }

               Object improved = torture * (entire + sheer) + arrivals;

               for(Object queries = -arrivals; queries <= arrivals; ++queries) {
                  Object extract = offers[improved + queries];
                  if (extract != Float.intBitsToFloat(0)) {
                     Object regions = mapping + queries;
                     if (0 > regions || regions >= mailing) {
                        if (thursday == petite$) {
                           regions = mapping;
                        } else {
                           if (thursday != orleans$) {
                              continue;
                           }

                           regions = (mapping + mailing) % mailing;
                        }
                     }

                     Object recipe = (int)((Object[])hunter)[million + regions];
                     samoa += extract * (float)(recipe >> 24 & 255);
                     diving += extract * (float)(recipe >> 16 & 255);
                     skating += extract * (float)(recipe >> 8 & 255);
                     sharing += extract * (float)(recipe & 255);
                  }
               }
            }

            Object var27 = seven ? GaussianFilter._burning((int)((double)samoa + 0.5D)) : 255;
            Object var28 = GaussianFilter._burning((int)((double)diving + 0.5D));
            Object var29 = GaussianFilter._burning((int)((double)skating + 0.5D));
            Object var30 = GaussianFilter._burning((int)((double)sharing + 0.5D));
            ((Object[])genres)[largest++] = var27 << 24 | var28 << 16 | var29 << 8 | var30;
         }
      }

   }

   public static void _filter(Kernel zefenipu, int[] iyugayel, int[] suvopoti, int abepiyit, int igevasac, boolean sorovisa, int cadifiba) {
      Object igudabiv = 0;
      Object tegamape = ((Kernel)zefenipu).getKernelData((float[])null);
      Object litatave = ((Kernel)zefenipu).getWidth();
      Object usudepeb = litatave / 2;

      for(Object alafutud = 0; alafutud < igevasac; ++alafutud) {
         Object olibosin = alafutud * abepiyit;

         for(Object zamesebu = 0; zamesebu < abepiyit; ++zamesebu) {
            Object ozicosov = Float.intBitsToFloat(0);
            Object orugapor = Float.intBitsToFloat(0);
            Object masebate = Float.intBitsToFloat(0);
            Object cemosedo = Float.intBitsToFloat(0);
            Object nutoliyi = usudepeb;

            for(Object ofefacir = -usudepeb; ofefacir <= usudepeb; ++ofefacir) {
               Object vapotedi = tegamape[nutoliyi + ofefacir];
               if (vapotedi != Float.intBitsToFloat(0)) {
                  Object nunogate = zamesebu + ofefacir;
                  if (nunogate < 0) {
                     if (cadifiba == petite$) {
                        nunogate = 0;
                     } else if (cadifiba == orleans$) {
                        nunogate = (zamesebu + abepiyit) % abepiyit;
                     }
                  } else if (nunogate >= abepiyit) {
                     if (cadifiba == petite$) {
                        nunogate = abepiyit - 1;
                     } else if (cadifiba == orleans$) {
                        nunogate = (zamesebu + abepiyit) % abepiyit;
                     }
                  }

                  Object atanafeg = (int)((Object[])iyugayel)[olibosin + nunogate];
                  cemosedo += vapotedi * (float)(atanafeg >> 24 & 255);
                  ozicosov += vapotedi * (float)(atanafeg >> 16 & 255);
                  orugapor += vapotedi * (float)(atanafeg >> 8 & 255);
                  masebate += vapotedi * (float)(atanafeg & 255);
               }
            }

            Object var23 = sorovisa ? GaussianFilter._burning((int)((double)cemosedo + 0.5D)) : 255;
            Object var24 = GaussianFilter._burning((int)((double)ozicosov + 0.5D));
            Object var25 = GaussianFilter._burning((int)((double)orugapor + 0.5D));
            Object var26 = GaussianFilter._burning((int)((double)masebate + 0.5D));
            ((Object[])suvopoti)[igudabiv++] = var23 << 24 | var24 << 16 | var25 << 8 | var26;
         }
      }

   }

   public static void _acoustic(Kernel unasanev, int[] cevudova, int[] ocuyulad, int fepozogi, int icaluciy, boolean dedibedu, int odicadac) {
      Object omupipic = 0;
      Object zamicigo = ((Kernel)unasanev).getKernelData((float[])null);
      Object orapigey = ((Kernel)unasanev).getHeight();
      Object edobiger = orapigey / 2;

      for(Object dapipela = 0; dapipela < icaluciy; ++dapipela) {
         for(Object ogosipeg = 0; ogosipeg < fepozogi; ++ogosipeg) {
            Object laneveze = Float.intBitsToFloat(0);
            Object ezagutiz = Float.intBitsToFloat(0);
            Object manasigi = Float.intBitsToFloat(0);
            Object vunamiri = Float.intBitsToFloat(0);

            for(Object ezasayed = -edobiger; ezasayed <= edobiger; ++ezasayed) {
               Object digogeba = dapipela + ezasayed;
               int ologivem;
               if (digogeba < 0) {
                  if (odicadac == petite$) {
                     ologivem = 0;
                  } else if (odicadac == orleans$) {
                     ologivem = (dapipela + icaluciy) % icaluciy * fepozogi;
                  } else {
                     ologivem = digogeba * fepozogi;
                  }
               } else if (digogeba >= icaluciy) {
                  if (odicadac == petite$) {
                     ologivem = (icaluciy - 1) * fepozogi;
                  } else if (odicadac == orleans$) {
                     ologivem = (dapipela + icaluciy) % icaluciy * fepozogi;
                  } else {
                     ologivem = digogeba * fepozogi;
                  }
               } else {
                  ologivem = digogeba * fepozogi;
               }

               Object abefigap = zamicigo[ezasayed + edobiger];
               if (abefigap != Float.intBitsToFloat(0)) {
                  Object adunogut = (int)((Object[])cevudova)[ologivem + ogosipeg];
                  vunamiri += abefigap * (float)(adunogut >> 24 & 255);
                  laneveze += abefigap * (float)(adunogut >> 16 & 255);
                  ezagutiz += abefigap * (float)(adunogut >> 8 & 255);
                  manasigi += abefigap * (float)(adunogut & 255);
               }
            }

            Object var22 = dedibedu ? GaussianFilter._burning((int)((double)vunamiri + 0.5D)) : 255;
            Object var23 = GaussianFilter._burning((int)((double)laneveze + 0.5D));
            Object var24 = GaussianFilter._burning((int)((double)ezagutiz + 0.5D));
            Object var25 = GaussianFilter._burning((int)((double)manasigi + 0.5D));
            ((Object[])ocuyulad)[omupipic++] = var22 << 24 | var23 << 16 | var24 << 8 | var25;
         }
      }

   }

   public String toString() {
      return "Blur/Convolve...";
   }
}
