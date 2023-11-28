package rip.sleep.util;

import rip.sleep.struct.AnimationState;

public class AnimationUtilC extends AnimationUtilA {
   public AnimationUtilC(int var1, double var2) {
      super(var1, var2);
   }

   public AnimationUtilC(int var1, double var2, AnimationState var4) {
      super(var1, var2, var4);
   }

   protected double c13546(double var1) {
      double var3 = var1 / (double)this.c9033;
      return -2.0D * Math.pow(var3, 3.0D) + 3.0D * Math.pow(var3, 2.0D);
   }
}
