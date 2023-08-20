package ft.sleep.util.animation;

public class EaseInOutQuad extends Animation {
   public EaseInOutQuad(int azatimol, double detoraba) {
      super((int)azatimol, (double)detoraba);
   }

   public EaseInOutQuad(int attach, double memphis, Direction var4) {
      super((int)attach, (double)memphis, var4);
   }

   public double _canyon(double efocipab) {
      double var3 = efocipab / (double)vitiroga.;
      return var3 < 0.5D ? 2.0D * Math.pow(var3, 2.0D) : 1.0D - Math.pow(-2.0D * var3 + 2.0D, 2.0D) / 2.0D;
   }
}
