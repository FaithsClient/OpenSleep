package rip.sleep.struct;

import net.minecraft.util.Vec3;

public class VectorStructA {
   private final double c40845;
   private final double c9030;
   private final double c24998;

   public VectorStructA(double var1, double var3, double var5) {
      this.c40845 = var1;
      this.c9030 = var3;
      this.c24998 = var5;
   }

   public double c45404() {
      return this.c40845;
   }

   public double c79215() {
      return this.c9030;
   }

   public double c63917() {
      return this.c24998;
   }

   public VectorStructA c55041(double var1, double var3, double var5) {
      return new VectorStructA(this.c40845 + var1, this.c9030 + var3, this.c24998 + var5);
   }

   public VectorStructA c76366() {
      return new VectorStructA(Math.floor(this.c40845), Math.floor(this.c9030), Math.floor(this.c24998));
   }

   public double c31189(VectorStructA var1) {
      return Math.pow(var1.c40845 - this.c40845, 2.0D) + Math.pow(var1.c9030 - this.c9030, 2.0D) + Math.pow(var1.c24998 - this.c24998, 2.0D);
   }

   public VectorStructA c62144(VectorStructA var1) {
      return this.c55041(var1.c45404(), var1.c79215(), var1.c63917());
   }

   public Vec3 c64488() {
      return new Vec3(this.c40845, this.c9030, this.c24998);
   }

   public String toString() {
      return "[" + this.c40845 + ";" + this.c9030 + ";" + this.c24998 + "]";
   }
}
