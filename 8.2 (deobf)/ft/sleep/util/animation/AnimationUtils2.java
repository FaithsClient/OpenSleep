package ft.sleep.util.animation;

public class AnimationUtils2 {
   public static float called$ = Float.intBitsToFloat(0);
   public static boolean lesser$ = false;
   public static double twist$;

   public static float _presents(float smith, float appeared, float fortune) {
      Object fruit = (float)(twist$ * (double)(fortune / 1000.0F));
      if (smith < appeared) {
         if (smith + fruit < appeared) {
            smith = smith + fruit;
         } else {
            smith = appeared;
         }
      } else if (smith - fruit > appeared) {
         smith = smith - fruit;
      } else {
         smith = appeared;
      }

      return (float)smith;
   }

   public static float _effort(float dadupame, float ezasinip, float eyofecuv, float degusava) {
      return _presents((float)dadupame, (float)ezasinip, Math.max(10.0F, Math.abs((float)(dadupame - ezasinip)) * eyofecuv) * degusava);
   }

   public static float _moses() {
      called$ += (float)twist$;
      if (called$ > 360.0F) {
         called$ = Float.intBitsToFloat(0);
      }

      return called$;
   }
}
