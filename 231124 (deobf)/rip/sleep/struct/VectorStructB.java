package rip.sleep.struct;

import org.json.JSONException;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class VectorStructB {
   private final double c63936;
   private final double c50092;
   private final double c35515;

   public VectorStructB(double var1, double var3, double var5) {
      this.c63936 = var1;
      this.c50092 = var3;
      this.c35515 = var5;
   }

   public VectorStructB c25858(double var1, double var3, double var5) {
      return new VectorStructB(this.c63936 + var1, this.c50092 + var3, this.c35515 + var5);
   }

   public VectorStructB c32516(VectorStructB var1) {
      return this.c25858(var1.c63936, var1.c50092, var1.c35515);
   }

   public VectorStructB c95204(double var1, double var3, double var5) {
      return this.c25858(-var1, -var3, -var5);
   }

   public VectorStructB c51656(VectorStructB var1) {
      return this.c25858(-var1.c63936, -var1.c50092, -var1.c35515);
   }

   public double c92109() {
      return Math.sqrt(this.c63936 * this.c63936 + this.c50092 * this.c50092 + this.c35515 * this.c35515);
   }

   public double c71335() {
      return this.c63936;
   }

   public double c20755() {
      return this.c50092;
   }

   public double c96564() {
      return this.c35515;
   }

   public VectorStructB c9107(double var1) {
      return new VectorStructB(this.c63936 * var1, this.c50092 * var1, this.c35515 * var1);
   }

   public boolean equals(Object var1) {
      Module[] var2 = Value.c27574();
      if (!(var1 instanceof VectorStructB)) {
         return false;
      } else {
         VectorStructB var3 = (VectorStructB)var1;
         return Math.floor(this.c63936) == Math.floor(var3.c63936) && Math.floor(this.c50092) == Math.floor(var3.c50092) && Math.floor(this.c35515) == Math.floor(var3.c35515);
      }
   }

   private static JSONException c48186(JSONException var0) {
      return var0;
   }
}
