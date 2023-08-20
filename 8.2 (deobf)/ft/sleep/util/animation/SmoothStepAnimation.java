package ft.sleep.util.animation;

import ft.sleep.util.animation.Animation;
import ft.sleep.util.animation.Direction;

public class SmoothStepAnimation extends Animation {
   public SmoothStepAnimation(int oporuveb, double givocibu) {
      super((int)oporuveb, (double)givocibu);
   }

   public SmoothStepAnimation(int capesalu, double sucovoca, Direction var4) {
      super((int)capesalu, (double)sucovoca, var4);
   }

   public double _canyon(double fibre) {
      double var3 = fibre / (double)housing.;
      return -2.0D * Math.pow(var3, 3.0D) + 3.0D * Math.pow(var3, 2.0D);
   }
}
