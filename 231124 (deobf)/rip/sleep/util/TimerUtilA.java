package rip.sleep.util;

import net.minecraft.util.MathHelper;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public final class TimerUtilA {
   private long c59632 = 0L;
   private long c17033 = -1L;

   public boolean c66164(long var1) {
      Module[] var3 = Value.c27574();
      if (this.c85975() >= var1) {
         this.c91771();
         return true;
      } else {
         return false;
      }
   }

   public boolean c38482(float var1) {
      Module[] var2 = Value.c27574();
      return (float)(System.currentTimeMillis() - this.c17033) >= var1;
   }

   public boolean c73531(double var1) {
      Module[] var3 = Value.c27574();
      return (double)MathHelper.clamp_float((float)(this.c64335() - this.c59632), 0.0F, (float)var1) >= var1;
   }

   public void c91771() {
      this.c17033 = System.currentTimeMillis();
      this.c59632 = this.c64335();
   }

   public long c85975() {
      return System.nanoTime() / 1000000L - this.c59632;
   }

   public long c64335() {
      return System.nanoTime() / 1000000L;
   }

   public double c63041() {
      return (double)(this.c64335() - this.c68678());
   }

   public long c68678() {
      return this.c59632;
   }

   private static JSONException c64058(JSONException var0) {
      return var0;
   }
}
