package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.struct.AnimationState;
import rip.sleep.value.Value;

public abstract class AnimationUtilA {
   public TimerUtilH c37224 = new TimerUtilH();
   protected int c9033;
   protected double c50526;
   protected AnimationState c24667;

   public AnimationUtilA(int var1, double var2) {
      this.c9033 = var1;
      this.c50526 = var2;
      this.c24667 = AnimationState.Forward;
   }

   public AnimationUtilA(int var1, double var2, AnimationState var4) {
      this.c9033 = var1;
      this.c50526 = var2;
      this.c24667 = var4;
   }

   public boolean c95957(AnimationState var1) {
      Module[] var2 = Value.c27574();
      return this.c44256() && this.c24667.equals(var1);
   }

   public double c3654() {
      return 1.0D - (double)this.c37224.c65047() / (double)this.c9033 * this.c50526;
   }

   public double c30657() {
      return this.c50526;
   }

   public void c70194(double var1) {
      this.c50526 = var1;
   }

   public void c6094() {
      this.c37224.c12425();
   }

   public boolean c44256() {
      return this.c37224.c10241((long)this.c9033);
   }

   public void c99254() {
      this.c96546(this.c24667.c30380());
   }

   public AnimationState c12335() {
      return this.c24667;
   }

   public void c96546(AnimationState var1) {
      Module[] var2 = Value.c27574();
      if (this.c24667 != var1) {
         this.c24667 = var1;
         this.c37224.c45804(System.currentTimeMillis() - ((long)this.c9033 - Math.min((long)this.c9033, this.c37224.c65047())));
      }

   }

   public void c42292(int var1) {
      this.c9033 = var1;
   }

   protected boolean c27364() {
      return false;
   }

   public double c53286() {
      Module[] var1 = Value.c27574();
      if (this.c24667 == AnimationState.Forward) {
         return this.c44256() ? this.c50526 : this.c13546((double)this.c37224.c65047()) * this.c50526;
      } else if (this.c44256()) {
         return 0.0D;
      } else if (this.c27364()) {
         double var2 = (double)Math.min((long)this.c9033, Math.max(0L, (long)this.c9033 - this.c37224.c65047()));
         return this.c13546(var2) * this.c50526;
      } else {
         return (1.0D - this.c13546((double)this.c37224.c65047())) * this.c50526;
      }
   }

   protected abstract double c13546(double var1);

   private static JSONException c97807(JSONException var0) {
      return var0;
   }
}
