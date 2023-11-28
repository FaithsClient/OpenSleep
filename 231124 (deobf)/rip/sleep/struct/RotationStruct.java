package rip.sleep.struct;

import rip.sleep.util.RotationUtilA;

public class RotationStruct {
   private float c72677;
   private float c77083;
   private float c3429;
   private float c38901;

   public RotationStruct(float var1, float var2) {
      this.c3429 = this.c72677 = var1;
      this.c38901 = this.c77083 = var2;
   }

   public void c87872(float var1, float var2) {
      this.c3429 = this.c72677;
      this.c38901 = this.c77083;
      float var3 = RotationUtilA.c80996();
      float var4 = var1 - this.c72677;
      float var5 = var2 - this.c77083;
      float var6 = var4 - var4 % var3;
      float var7 = var5 - var5 % var3;
      this.c72677 += var6;
      this.c77083 += var7;
      this.c77083 = Math.max(-90.0F, Math.min(90.0F, this.c77083));
   }

   public float c14509() {
      return this.c72677;
   }

   public float c86023() {
      return this.c77083;
   }

   public float c46822() {
      return this.c3429;
   }

   public float c40346() {
      return this.c38901;
   }
}
