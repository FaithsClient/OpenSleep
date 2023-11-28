package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.value.Value;

public class MathUtilE {
   private float c32585;
   private float c45099;
   private long c95342;

   public MathUtilE(float var1, float var2) {
      this.c32585 = var1;
      this.c45099 = var2;
      this.c95342 = System.currentTimeMillis();
   }

   public void c21288(float var1, float var2, float var3) {
      long var4 = System.currentTimeMillis();
      long var6 = var4 - this.c95342;
      this.c95342 = var4;
      int var8 = (int)(Math.abs(var1 - this.c32585) * var3);
      int var9 = (int)(Math.abs(var2 - this.c45099) * var3);
      this.c32585 = this.c83797(var1, this.c32585, var6, var8);
      this.c45099 = this.c83797(var2, this.c45099, var6, var9);
   }

   public float c57180() {
      return this.c32585;
   }

   public void c88148(float var1) {
      this.c32585 = var1;
   }

   public float c19122() {
      return this.c45099;
   }

   public void c67761(float var1) {
      this.c45099 = var1;
   }

   public float c83797(float var1, float var2, long var3, int var5) {
      Value.c27574();
      float var7 = var2 - var1;
      if (var3 < 1L) {
         var3 = 1L;
      }

      if (var7 > (float)var5) {
         double var8 = (double)((long)var5 * var3 / 16L) < 0.25D ? 0.5D : (double)((long)var5 * var3 / 16L);
         var2 = (float)((double)var2 - var8);
         if (var2 >= var1) {
            return var2;
         }

         var2 = var1;
      }

      if (var7 < (float)(-var5)) {
         double var11 = (double)((long)var5 * var3 / 16L) < 0.25D ? 0.5D : (double)((long)var5 * var3 / 16L);
         var2 = (float)((double)var2 + var11);
         if (var2 <= var1) {
            return var2;
         }
      }

      var2 = var1;
      return var2;
   }

   private static JSONException c96400(JSONException var0) {
      return var0;
   }
}
