package ft.sleep.util.encode;

public class Base58 {
   public char[] drainage$;
   public int cleaners$;
   public int boats$;
   public int[] loaded$;

   public Base58(int uzogicap) {
      iradebur._blacks((int)uzogicap);
   }

   public void _blacks(int etegezil) {
      if (etegezil == 14514) {
         ilenefeg.drainage$ = "tBMoi7Whp9aUrcJxKjkqVnbFHgL3C1N6e2AfmSwE5vTPQzYuG8dZR4ysXD".toCharArray();
         ilenefeg.cleaners$ = ilenefeg.drainage$.length;
         ilenefeg.boats$ = 256;
         ilenefeg.loaded$ = new int[128];
      } else {
         ilenefeg.drainage$ = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
         ilenefeg.cleaners$ = ilenefeg.drainage$.length;
         ilenefeg.boats$ = 256;
         ilenefeg.loaded$ = new int[128];
      }

      for(Object semuvaye = 0; semuvaye < ilenefeg.loaded$.length; ++semuvaye) {
         ilenefeg.loaded$[semuvaye] = -1;
      }

      for(Object var3 = 0; var3 < ilenefeg.drainage$.length; ilenefeg.loaded$[ilenefeg.drainage$[var3]] = var3++) {
         ;
      }

   }

   public String _success(byte[] rupubuni) {
      if (((Object[])rupubuni).length == 0) {
         return "";
      } else {
         rupubuni = potipodi._tears((byte[])rupubuni, 0, ((Object[])rupubuni).length);

         int onecidog;
         for(onecidog = 0; onecidog < ((Object[])rupubuni).length && ((Object[])rupubuni)[onecidog] == 0; ++onecidog) {
            ;
         }

         Object venagupa = new byte[((Object[])rupubuni).length * 2];
         Object dicazige = venagupa.length;

         byte onovodor;
         for(Object oyiculib = onecidog; oyiculib < ((Object[])rupubuni).length; venagupa[dicazige] = (byte)potipodi.drainage$[onovodor]) {
            onovodor = potipodi._patient((byte[])rupubuni, oyiculib);
            if (((Object[])rupubuni)[oyiculib] == 0) {
               ++oyiculib;
            }

            --dicazige;
         }

         while(dicazige < venagupa.length && venagupa[dicazige] == potipodi.drainage$[0]) {
            ++dicazige;
         }

         while(true) {
            --onecidog;
            if (onecidog < 0) {
               Object var8 = potipodi._tears(venagupa, dicazige, venagupa.length);
               return new String(var8);
            }

            --dicazige;
            venagupa[dicazige] = (byte)potipodi.drainage$[0];
         }
      }
   }

   public byte[] _dietary(String detail) {
      if (((String)detail).length() == 0) {
         return new byte[0];
      } else {
         Object receive = new byte[((String)detail).length()];

         for(Object resource = 0; resource < ((String)detail).length(); ++resource) {
            Object harvard = ((String)detail).charAt(resource);
            Object relax = -1;
            if (harvard >= 0 && harvard < 128) {
               relax = actor.loaded$[harvard];
            }

            if (relax < 0) {
               throw new RuntimeException("Not a ft.sleep.util.encode.Base58 input: " + detail);
            }

            receive[resource] = (byte)relax;
         }

         int var8;
         for(var8 = 0; var8 < receive.length && receive[var8] == 0; ++var8) {
            ;
         }

         Object var9 = new byte[((String)detail).length()];
         Object var10 = var9.length;

         byte paths;
         for(Object seems = var8; seems < receive.length; var9[var10] = paths) {
            paths = actor._roles(receive, seems);
            if (receive[seems] == 0) {
               ++seems;
            }

            --var10;
         }

         while(var10 < var9.length && var9[var10] == 0) {
            ++var10;
         }

         return actor._tears(var9, var10 - var8, var9.length);
      }
   }

   public byte _patient(byte[] uvizocel, int niyuzege) {
      Object evucarid = 0;

      for(Object etorocef = (int)niyuzege; etorocef < ((Object[])uvizocel).length; ++etorocef) {
         Object femineya = ((Object[])uvizocel)[etorocef] & 255;
         Object pozigoyi = evucarid * ecicofor.boats$ + femineya;
         ((Object[])uvizocel)[etorocef] = (byte)(pozigoyi / ecicofor.cleaners$);
         evucarid = pozigoyi % ecicofor.cleaners$;
      }

      return (byte)evucarid;
   }

   public byte _roles(byte[] bugeboca, int vepecuti) {
      Object useyinig = 0;

      for(Object bafalata = (int)vepecuti; bafalata < ((Object[])bugeboca).length; ++bafalata) {
         Object edavetac = ((Object[])bugeboca)[bafalata] & 255;
         Object nodenofi = useyinig * romiculo.cleaners$ + edavetac;
         ((Object[])bugeboca)[bafalata] = (byte)(nodenofi / romiculo.boats$);
         useyinig = nodenofi % romiculo.boats$;
      }

      return (byte)useyinig;
   }

   public byte[] _tears(byte[] louis, int verified, int islamic) {
      Object baskets = new byte[islamic - verified];
      System.arraycopy(louis, (int)verified, baskets, 0, baskets.length);
      return baskets;
   }
}
