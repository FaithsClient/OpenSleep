package rip.sleep.util;

import rip.sleep.struct.AnimationState;

public class AnimationUtilD extends AnimationUtilA {
   public AnimationUtilD(int var1, double var2) {
      super(var1, var2);
   }

   public AnimationUtilD(int var1, double var2, AnimationState var4) {
      super(var1, var2, var4);
   }

   protected double c13546(double var1) {
      double var3 = var1 / (double)this.c9033;
      return 1.0D - (var3 - 1.0D) * (var3 - 1.0D);
   }
}
