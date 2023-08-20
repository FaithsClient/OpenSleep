package ft.sleep.util.data;

import com.google.gson.annotations.Expose;

public class Position2 {
   @Expose
   public float function$;
   @Expose
   public float weather$;
   @Expose
   public float predict$;
   @Expose
   public float guess$;

   public Position2(float dazupabu, float rizisapa, float ucufumol, float toforuze) {
      fudifino.function$ = (float)dazupabu;
      fudifino.weather$ = (float)rizisapa;
      fudifino.predict$ = (float)ucufumol;
      fudifino.guess$ = (float)toforuze;
   }

   public static Position2 _spine() {
      return new Position2(-1.0F, -1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
   }

   public boolean _families(int crime, int leaders) {
      return (float)crime >= integer.function$ && (float)crime <= integer.function$ + integer.predict$ && (float)leaders >= integer.weather$ && (float)leaders <= integer.weather$ + integer.guess$;
   }

   public boolean _selling(int avabunub, int ufacoyoc, int peduleme, int omayusis, int obitaziv, int udobufat) {
      return (float)avabunub >= sivigibu.function$ + (float)peduleme && (float)avabunub <= sivigibu.function$ + (float)peduleme + (float)obitaziv && (float)ufacoyoc >= sivigibu.weather$ + (float)omayusis && (float)ufacoyoc <= sivigibu.weather$ + (float)omayusis + (float)udobufat;
   }

   public float[] _garlic(int yutorama, int igazenos) {
      return new float[]{(float)yutorama - iluvaced.function$, (float)igazenos - iluvaced.weather$};
   }
}
