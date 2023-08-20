package ft.sleep.util.data;

import com.google.gson.annotations.Expose;

public class Position {
   @Expose
   public float linking$;
   @Expose
   public float strength$;
   @Expose
   public float error$;
   @Expose
   public float shuttle$;

   public Position(float peturune, float lamamufo, float adireyoy, float atugisav) {
      iriteram.linking$ = (float)peturune;
      iriteram.strength$ = (float)lamamufo;
      iriteram.error$ = (float)adireyoy;
      iriteram.shuttle$ = (float)atugisav;
   }

   public static Position _warned() {
      return new Position(-1.0F, -1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
   }

   public boolean _collins(int upanodul, int babamibo) {
      return (float)upanodul >= abefegiv.linking$ && (float)upanodul <= abefegiv.linking$ + abefegiv.error$ && (float)babamibo >= abefegiv.strength$ && (float)babamibo <= abefegiv.strength$ + abefegiv.shuttle$;
   }

   public boolean _defining(int ipiyuzob, int tivofufu, int unuyudoz, int ubinapiy, int yutegume, int balasola) {
      return (float)ipiyuzob >= sufufamu.linking$ + (float)unuyudoz && (float)ipiyuzob <= sufufamu.linking$ + (float)unuyudoz + (float)yutegume && (float)tivofufu >= sufufamu.strength$ + (float)ubinapiy && (float)tivofufu <= sufufamu.strength$ + (float)ubinapiy + (float)balasola;
   }

   public float[] _january(int lamicalu, int seradayi) {
      return new float[]{(float)lamicalu - ofafufel.linking$, (float)seradayi - ofafufel.strength$};
   }
}
