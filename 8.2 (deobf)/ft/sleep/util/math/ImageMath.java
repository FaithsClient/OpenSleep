package ft.sleep.util.math;

public class ImageMath {
   public static float connect$ = 3.1415927F;
   public static float banks$ = 1.5707964F;
   public static float occurred$ = 0.7853982F;
   public static float brother$ = 6.2831855F;
   public static float bright$ = -0.5F;
   public static float wright$ = 1.5F;
   public static float plate$ = -1.5F;
   public static float heights$ = 0.5F;
   public static float forbes$ = 1.0F;
   public static float choosing$ = -2.5F;
   public static float point$ = 2.0F;
   public static float layout$ = -0.5F;
   public static float obvious$ = -0.5F;
   public static float suddenly$ = Float.intBitsToFloat(0);
   public static float explicit$ = 0.5F;
   public static float seventh$ = Float.intBitsToFloat(0);
   public static float coupons$ = Float.intBitsToFloat(0);
   public static float doctor$ = 1.0F;
   public static float diego$ = Float.intBitsToFloat(0);
   public static float autos$ = Float.intBitsToFloat(0);

   public static float _maximum(float google, float combo) {
      return google / ((1.0F / combo - 2.0F) * (1.0F - google) + 1.0F);
   }

   public static float _today(float goyapami, float uyizugug) {
      Object depuzono = (1.0F / uyizugug - 2.0F) * (1.0F - 2.0F * goyapami);
      return (double)goyapami < 0.5D ? goyapami / (depuzono + 1.0F) : (depuzono - goyapami) / (depuzono - 1.0F);
   }

   public static float _standard(float shaved, float baking) {
      return baking < shaved ? Float.intBitsToFloat(0) : 1.0F;
   }

   public static float _skilled(float labeled, float advisor, float queue) {
      return queue >= labeled && queue < advisor ? 1.0F : Float.intBitsToFloat(0);
   }

   public static float _antibody(float jewish, float start, float sporting, float provided, float obesity) {
      if (obesity >= jewish && obesity < provided) {
         if (obesity >= start) {
            if (obesity < sporting) {
               return 1.0F;
            } else {
               obesity = (obesity - sporting) / (provided - sporting);
               return 1.0F - obesity * obesity * (3.0F - 2.0F * obesity);
            }
         } else {
            obesity = (obesity - jewish) / (start - jewish);
            return obesity * obesity * (3.0F - 2.0F * obesity);
         }
      } else {
         return Float.intBitsToFloat(0);
      }
   }

   public static float _votes(float ulerutuf, float anazonef, float nenetuce) {
      if (nenetuce < ulerutuf) {
         return Float.intBitsToFloat(0);
      } else if (nenetuce >= anazonef) {
         return 1.0F;
      } else {
         nenetuce = (nenetuce - ulerutuf) / (anazonef - ulerutuf);
         return nenetuce * nenetuce * (3.0F - 2.0F * nenetuce);
      }
   }

   public static float _beside(float beside) {
      beside = 1.0F - beside;
      return (float)Math.sqrt((double)(1.0F - beside * beside));
   }

   public static float _indiana(float ebegusis) {
      return 1.0F - (float)Math.sqrt((double)(1.0F - ebegusis * ebegusis));
   }

   public static float _rebate(float odozufur, float miyuleci, float sacuvuci) {
      return (float)(odozufur < miyuleci ? miyuleci : (odozufur > sacuvuci ? sacuvuci : odozufur));
   }

   public static int _duncan(int packets, int titles, int means) {
      return (int)(packets < titles ? titles : (packets > means ? means : packets));
   }

   public static double _eminem(double delight, double francis) {
      // $FF: Couldn't be decompiled
   }

   public static float _stronger(float ufezemud, float gofugefu) {
      // $FF: Couldn't be decompiled
   }

   public static int _writes(int finance, int sense) {
      // $FF: Couldn't be decompiled
   }

   public static float _buddy(float isazuviy) {
      Object lorutodo = _stronger((float)isazuviy, 1.0F);
      return 2.0F * ((double)lorutodo < 0.5D ? lorutodo : 1.0F - lorutodo);
   }

   public static float _alone(float sixth, float pursue, float egypt) {
      return (float)(pursue + sixth * (egypt - pursue));
   }

   public static int _document(float utipetir, int oropacur, int dovotiyo) {
      return (int)((float)oropacur + utipetir * (float)(dovotiyo - oropacur));
   }

   public static int _listen(float vucobune, int pidizave, int ituvucac) {
      Object utulopup = pidizave >> 24 & 255;
      Object azezunaf = pidizave >> 16 & 255;
      Object gugaranu = pidizave >> 8 & 255;
      Object ubobaror = pidizave & 255;
      Object ilalacem = ituvucac >> 24 & 255;
      Object mazonabi = ituvucac >> 16 & 255;
      Object agiloviz = ituvucac >> 8 & 255;
      Object oguzadus = ituvucac & 255;
      utulopup = _document((float)vucobune, utulopup, ilalacem);
      azezunaf = _document((float)vucobune, azezunaf, mazonabi);
      gugaranu = _document((float)vucobune, gugaranu, agiloviz);
      ubobaror = _document((float)vucobune, ubobaror, oguzadus);
      return utulopup << 24 | azezunaf << 16 | gugaranu << 8 | ubobaror;
   }

   public static int _habitat(float sherman, float sciences, int entitled, int suited, int stands, int firewall) {
      Object eagle = entitled >> 24 & 255;
      Object match = entitled >> 16 & 255;
      Object father = entitled >> 8 & 255;
      Object specials = entitled & 255;
      Object tribune = suited >> 24 & 255;
      Object locked = suited >> 16 & 255;
      Object duration = suited >> 8 & 255;
      Object shopping = suited & 255;
      Object moldova = stands >> 24 & 255;
      Object parker = stands >> 16 & 255;
      Object sunday = stands >> 8 & 255;
      Object oldest = stands & 255;
      Object travels = firewall >> 24 & 255;
      Object words = firewall >> 16 & 255;
      Object widely = firewall >> 8 & 255;
      Object preserve = firewall & 255;
      Object junior = 1.0F - sherman;
      Object sphere = 1.0F - sciences;
      Object logitech = junior * (float)eagle + sherman * (float)tribune;
      Object arrive = junior * (float)moldova + sherman * (float)travels;
      Object belief = (int)(sphere * logitech + sciences * arrive);
      logitech = junior * (float)match + sherman * (float)locked;
      arrive = junior * (float)parker + sherman * (float)words;
      Object party = (int)(sphere * logitech + sciences * arrive);
      logitech = junior * (float)father + sherman * (float)duration;
      arrive = junior * (float)sunday + sherman * (float)widely;
      Object banking = (int)(sphere * logitech + sciences * arrive);
      logitech = junior * (float)specials + sherman * (float)shopping;
      arrive = junior * (float)oldest + sherman * (float)preserve;
      Object somalia = (int)(sphere * logitech + sciences * arrive);
      return belief << 24 | party << 16 | banking << 8 | somalia;
   }

   public static int _evening(int proxy) {
      Object greatest = proxy >> 16 & 255;
      Object sections = proxy >> 8 & 255;
      Object concept = proxy & 255;
      return (int)((float)greatest * 0.299F + (float)sections * 0.587F + (float)concept * 0.114F);
   }

   public static float _karma(float tubuluco, int uyegonon, float[] pirinuza) {
      Object nazenolu = uyegonon - 3;
      if (nazenolu < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         tubuluco = _rebate((float)tubuluco, Float.intBitsToFloat(0), 1.0F) * (float)nazenolu;
         Object beyoguta = (int)tubuluco;
         if (beyoguta > uyegonon - 4) {
            beyoguta = uyegonon - 4;
         }

         tubuluco = tubuluco - (float)beyoguta;
         Object vadapidu = (float)((Object[])pirinuza)[beyoguta];
         Object eyofebin = (float)((Object[])pirinuza)[beyoguta + 1];
         Object otozavag = (float)((Object[])pirinuza)[beyoguta + 2];
         Object emacufut = (float)((Object[])pirinuza)[beyoguta + 3];
         Object mapesuvo = -0.5F * vadapidu + 1.5F * eyofebin + -1.5F * otozavag + 0.5F * emacufut;
         Object memupuye = 1.0F * vadapidu + -2.5F * eyofebin + 2.0F * otozavag + -0.5F * emacufut;
         Object tamidapa = -0.5F * vadapidu + Float.intBitsToFloat(0) * eyofebin + 0.5F * otozavag + Float.intBitsToFloat(0) * emacufut;
         Object iyayipav = Float.intBitsToFloat(0) * vadapidu + 1.0F * eyofebin + Float.intBitsToFloat(0) * otozavag + Float.intBitsToFloat(0) * emacufut;
         return ((mapesuvo * tubuluco + memupuye) * tubuluco + tamidapa) * tubuluco + iyayipav;
      }
   }

   public static float _thursday(float haven, int biology, int[] trials, int[] diseases) {
      Object buddy = biology - 3;
      if (buddy < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         int awards;
         for(awards = 0; awards < buddy && (float)((Object[])trials)[awards + 1] <= haven; ++awards) {
            ;
         }

         if (awards > biology - 3) {
            awards = biology - 3;
         }

         Object servers = (haven - (float)((Object[])trials)[awards]) / (float)(((Object[])trials)[awards + 1] - ((Object[])trials)[awards]);
         --awards;
         if (awards < 0) {
            awards = 0;
            servers = Float.intBitsToFloat(0);
         }

         Object organic = (float)((Object[])diseases)[awards];
         Object victims = (float)((Object[])diseases)[awards + 1];
         Object guests = (float)((Object[])diseases)[awards + 2];
         Object sessions = (float)((Object[])diseases)[awards + 3];
         Object chips = -0.5F * organic + 1.5F * victims + -1.5F * guests + 0.5F * sessions;
         Object sudden = 1.0F * organic + -2.5F * victims + 2.0F * guests + -0.5F * sessions;
         Object screen = -0.5F * organic + Float.intBitsToFloat(0) * victims + 0.5F * guests + Float.intBitsToFloat(0) * sessions;
         Object autos = Float.intBitsToFloat(0) * organic + 1.0F * victims + Float.intBitsToFloat(0) * guests + Float.intBitsToFloat(0) * sessions;
         return ((chips * servers + sudden) * servers + screen) * servers + autos;
      }
   }

   public static int _exotic(float pakistan, int trans, int[] larger) {
      Object excess = trans - 3;
      if (excess < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         pakistan = _rebate((float)pakistan, Float.intBitsToFloat(0), 1.0F) * (float)excess;
         Object academic = (int)pakistan;
         if (academic > trans - 4) {
            academic = trans - 4;
         }

         pakistan = pakistan - (float)academic;
         Object lookup = 0;

         for(Object stocks = 0; stocks < 4; ++stocks) {
            Object legends = stocks * 8;
            Object contrast = (float)(((Object[])larger)[academic] >> legends & 255);
            Object syracuse = (float)(((Object[])larger)[academic + 1] >> legends & 255);
            Object adult = (float)(((Object[])larger)[academic + 2] >> legends & 255);
            Object active = (float)(((Object[])larger)[academic + 3] >> legends & 255);
            Object courier = -0.5F * contrast + 1.5F * syracuse + -1.5F * adult + 0.5F * active;
            Object charging = 1.0F * contrast + -2.5F * syracuse + 2.0F * adult + -0.5F * active;
            Object crawford = -0.5F * contrast + Float.intBitsToFloat(0) * syracuse + 0.5F * adult + Float.intBitsToFloat(0) * active;
            Object naughty = Float.intBitsToFloat(0) * contrast + 1.0F * syracuse + Float.intBitsToFloat(0) * adult + Float.intBitsToFloat(0) * active;
            Object positive = (int)(((courier * pakistan + charging) * pakistan + crawford) * pakistan + naughty);
            if (positive < 0) {
               positive = 0;
            } else if (positive > 255) {
               positive = 255;
            }

            lookup |= positive << legends;
         }

         return lookup;
      }
   }

   public static int _alaska(int tozilaga, int igumobar, int[] vugutunu, int[] igubusit) {
      Object loluyusi = igumobar - 3;
      if (loluyusi < 1) {
         throw new IllegalArgumentException("Too few knots in spline");
      } else {
         int ocipemic;
         for(ocipemic = 0; ocipemic < loluyusi && ((Object[])vugutunu)[ocipemic + 1] <= tozilaga; ++ocipemic) {
            ;
         }

         if (ocipemic > igumobar - 3) {
            ocipemic = igumobar - 3;
         }

         Object ugulesuz = (float)(tozilaga - ((Object[])vugutunu)[ocipemic]) / (float)(((Object[])vugutunu)[ocipemic + 1] - ((Object[])vugutunu)[ocipemic]);
         --ocipemic;
         if (ocipemic < 0) {
            ocipemic = 0;
            ugulesuz = Float.intBitsToFloat(0);
         }

         Object robazeyu = 0;

         for(Object fatacesa = 0; fatacesa < 4; ++fatacesa) {
            Object upesideb = fatacesa * 8;
            Object fetelepo = (float)(((Object[])igubusit)[ocipemic] >> upesideb & 255);
            Object icifuvez = (float)(((Object[])igubusit)[ocipemic + 1] >> upesideb & 255);
            Object pagicode = (float)(((Object[])igubusit)[ocipemic + 2] >> upesideb & 255);
            Object sofuveme = (float)(((Object[])igubusit)[ocipemic + 3] >> upesideb & 255);
            Object aromamiv = -0.5F * fetelepo + 1.5F * icifuvez + -1.5F * pagicode + 0.5F * sofuveme;
            Object agopepog = 1.0F * fetelepo + -2.5F * icifuvez + 2.0F * pagicode + -0.5F * sofuveme;
            Object tivicope = -0.5F * fetelepo + Float.intBitsToFloat(0) * icifuvez + 0.5F * pagicode + Float.intBitsToFloat(0) * sofuveme;
            Object agovabar = Float.intBitsToFloat(0) * fetelepo + 1.0F * icifuvez + Float.intBitsToFloat(0) * pagicode + Float.intBitsToFloat(0) * sofuveme;
            Object omazecuy = (int)(((aromamiv * ugulesuz + agopepog) * ugulesuz + tivicope) * ugulesuz + agovabar);
            if (omazecuy < 0) {
               omazecuy = 0;
            } else if (omazecuy > 255) {
               omazecuy = 255;
            }

            robazeyu |= omazecuy << upesideb;
         }

         return robazeyu;
      }
   }

   public static void _enjoy(int[] mogabadu, int[] isevufec, int gazayemu, int gisufani, int defitofu, float[] ridineni) {
      Object racifame = (int)gisufani;
      Object bapetesi = ((Object[])mogabadu).length;
      Object yurefula = new float[gazayemu + 2];
      Object venadeti = 0;

      for(Object omicayef = 0; omicayef < gazayemu; ++omicayef) {
         while(((Object[])ridineni)[venadeti + 1] < (float)omicayef) {
            ++venadeti;
         }

         yurefula[omicayef] = (float)venadeti + ((float)omicayef - ((Object[])ridineni)[venadeti]) / (((Object[])ridineni)[venadeti + 1] - ((Object[])ridineni)[venadeti]);
      }

      yurefula[gazayemu] = (float)gazayemu;
      yurefula[gazayemu + 1] = (float)gazayemu;
      Object cogupapi = 1.0F;
      Object onatubib = yurefula[1];
      Object esetezoy = onatubib;
      float ebufayiv;
      float gotofogu;
      float areyenul;
      Object ritagosi = ebufayiv = gotofogu = areyenul = Float.intBitsToFloat(0);
      Object anoyezec = (int)((Object[])mogabadu)[gisufani];
      Object fezeteyo = anoyezec >> 24 & 255;
      Object unitecec = anoyezec >> 16 & 255;
      Object ecalucef = anoyezec >> 8 & 255;
      Object uyiradec = anoyezec & 255;
      Object imesucep = gisufani + defitofu;
      anoyezec = (int)((Object[])mogabadu)[imesucep];
      Object ugarasil = anoyezec >> 24 & 255;
      Object lacerela = anoyezec >> 16 & 255;
      Object gulizepo = anoyezec >> 8 & 255;
      Object tazofiyu = anoyezec & 255;
      imesucep = imesucep + defitofu;
      venadeti = 1;

      while(venadeti <= gazayemu) {
         Object sitedutu = cogupapi * (float)fezeteyo + (1.0F - cogupapi) * (float)ugarasil;
         Object yolopupa = cogupapi * (float)unitecec + (1.0F - cogupapi) * (float)lacerela;
         Object genazuli = cogupapi * (float)ecalucef + (1.0F - cogupapi) * (float)gulizepo;
         Object utisoloc = cogupapi * (float)uyiradec + (1.0F - cogupapi) * (float)tazofiyu;
         if (cogupapi < onatubib) {
            ritagosi += sitedutu * cogupapi;
            ebufayiv += yolopupa * cogupapi;
            gotofogu += genazuli * cogupapi;
            areyenul += utisoloc * cogupapi;
            onatubib -= cogupapi;
            cogupapi = 1.0F;
            fezeteyo = ugarasil;
            unitecec = lacerela;
            ecalucef = gulizepo;
            uyiradec = tazofiyu;
            if (imesucep < bapetesi) {
               anoyezec = (int)((Object[])mogabadu)[imesucep];
            }

            ugarasil = anoyezec >> 24 & 255;
            lacerela = anoyezec >> 16 & 255;
            gulizepo = anoyezec >> 8 & 255;
            tazofiyu = anoyezec & 255;
            imesucep += defitofu;
         } else {
            ritagosi = ritagosi + sitedutu * onatubib;
            Object var34 = ebufayiv + yolopupa * onatubib;
            Object var35 = gotofogu + genazuli * onatubib;
            Object var36 = areyenul + utisoloc * onatubib;
            ((Object[])isevufec)[racifame] = (int)Math.min(ritagosi / esetezoy, 255.0F) << 24 | (int)Math.min(var34 / esetezoy, 255.0F) << 16 | (int)Math.min(var35 / esetezoy, 255.0F) << 8 | (int)Math.min(var36 / esetezoy, 255.0F);
            racifame += defitofu;
            ritagosi = ebufayiv = gotofogu = areyenul = Float.intBitsToFloat(0);
            cogupapi -= onatubib;
            onatubib = yurefula[venadeti + 1] - yurefula[venadeti];
            esetezoy = onatubib;
            ++venadeti;
         }
      }

   }

   public static void _flood(int[] uronacat, int atedadug, int umozegoz) {
      umozegoz = umozegoz + atedadug;

      for(Object urapoyec = (int)atedadug; urapoyec < umozegoz; ++urapoyec) {
         Object nirolube = (int)((Object[])uronacat)[urapoyec];
         Object yemebupu = nirolube >> 24 & 255;
         Object ibufalud = nirolube >> 16 & 255;
         Object iveluzet = nirolube >> 8 & 255;
         Object efuzozob = nirolube & 255;
         Object dozicivu = (float)yemebupu * 0.003921569F;
         ibufalud = (int)((float)ibufalud * dozicivu);
         iveluzet = (int)((float)iveluzet * dozicivu);
         efuzozob = (int)((float)efuzozob * dozicivu);
         ((Object[])uronacat)[urapoyec] = yemebupu << 24 | ibufalud << 16 | iveluzet << 8 | efuzozob;
      }

   }

   public static void _paraguay(int[] uritaref, int getuturi, int uvumatay) {
      uvumatay = uvumatay + getuturi;

      for(Object vubayuya = (int)getuturi; vubayuya < uvumatay; ++vubayuya) {
         Object otagacuv = (int)((Object[])uritaref)[vubayuya];
         Object avopucal = otagacuv >> 24 & 255;
         Object fayepeya = otagacuv >> 16 & 255;
         Object iziloves = otagacuv >> 8 & 255;
         Object itayufub = otagacuv & 255;
         if (avopucal != 0 && avopucal != 255) {
            Object oyufugoz = 255.0F / (float)avopucal;
            fayepeya = (int)((float)fayepeya * oyufugoz);
            iziloves = (int)((float)iziloves * oyufugoz);
            itayufub = (int)((float)itayufub * oyufugoz);
            if (fayepeya > 255) {
               fayepeya = 255;
            }

            if (iziloves > 255) {
               iziloves = 255;
            }

            if (itayufub > 255) {
               itayufub = 255;
            }

            ((Object[])uritaref)[vubayuya] = avopucal << 24 | fayepeya << 16 | iziloves << 8 | itayufub;
         }
      }

   }
}
