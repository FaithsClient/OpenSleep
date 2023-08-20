package ft.sleep.util.animation;

public class AnimationUtils {
   public static float _sudan(float adidemev, float amarimed, float ogisetuv, float binusaba) {
      Object lebafaci = Math.abs((float)(ogisetuv - amarimed));
      Object osovipaz = (double)(lebafaci * binusaba / 100.0F * RenderUtil2.helen$);
      float var7 = (float)amarimed;
      System.out.println(lebafaci);
      if (adidemev < ogisetuv) {
         var7 = (float)((double)amarimed + Math.max(0.05000000074505806D, osovipaz));
         if (var7 >= ogisetuv) {
            var7 = (float)ogisetuv;
         }
      }

      if (adidemev > ogisetuv) {
         var7 = (float)((double)var7 - Math.max(0.05000000074505806D, osovipaz));
         if (var7 <= ogisetuv) {
            var7 = (float)ogisetuv;
         }
      }

      return var7;
   }
}
