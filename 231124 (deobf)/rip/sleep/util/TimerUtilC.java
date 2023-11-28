package rip.sleep.util;

import net.minecraft.util.MathHelper;
import org.json.JSONException;
import rip.sleep.value.Value;

public final class TimerUtilC {
   private long c81968 = 0L;
   private long c22459 = -1L;
   private static String[] c21968;

   public boolean c36262(long var1) {
      Value.c27574();
      String[] var4 = c43728();
      if (this.c30205() >= var1) {
         this.c13539();
         return true;
      } else {
         return false;
      }
   }

   public boolean c17155(float var1) {
      Value.c27574();
      String[] var3 = c43728();
      return (float)(System.currentTimeMillis() - this.c22459) >= var1;
   }

   public boolean c27234(double var1) {
      Value.c27574();
      String[] var4 = c43728();
      return (double)MathHelper.clamp_float((float)(this.c43940() - this.c81968), 0.0F, (float)var1) >= var1;
   }

   public void c13539() {
      this.c22459 = System.currentTimeMillis();
      this.c81968 = this.c43940();
   }

   public long c30205() {
      return System.nanoTime() / 1000000L - this.c81968;
   }

   public long c43940() {
      return System.nanoTime() / 1000000L;
   }

   public double c82121() {
      return (double)(this.c43940() - this.c36657());
   }

   public long c36657() {
      return this.c81968;
   }

   public static void c35796(String[] var0) {
      c21968 = var0;
   }

   public static String[] c43728() {
      return c21968;
   }

   static {
      if (c43728() != null) {
         c35796(new String[4]);
      }

   }

   private static JSONException c3822(JSONException var0) {
      return var0;
   }
}
