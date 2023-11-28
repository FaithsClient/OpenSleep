package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.struct.AnimationState;
import rip.sleep.value.Value;

public class AnimationUtilB extends AnimationUtilA {
   public AnimationUtilB(int var1, double var2) {
      super(var1, var2);
   }

   public AnimationUtilB(int var1, double var2, AnimationState var4) {
      super(var1, var2, var4);
   }

   protected double c13546(double var1) {
      Value.c27574();
      double var4 = var1 / (double)this.c9033;
      return var4 < 0.5D ? 2.0D * Math.pow(var4, 2.0D) : 1.0D - Math.pow(-2.0D * var4 + 2.0D, 2.0D) / 2.0D;
   }

   private static JSONException c41432(JSONException var0) {
      return var0;
   }
}
