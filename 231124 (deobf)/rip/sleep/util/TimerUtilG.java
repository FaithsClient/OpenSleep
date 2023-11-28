package rip.sleep.util;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public final class TimerUtilG {
   private long c63515 = -1L;

   public boolean c13770(long var1) {
      Module[] var3 = Value.c27574();
      return System.currentTimeMillis() >= this.c63515 + var1;
   }

   public long c89143(long var1) {
      return var1 + this.c63515 - System.currentTimeMillis();
   }

   public void c43667() {
      this.c63515 = System.currentTimeMillis();
   }

   private static JSONException c27995(JSONException var0) {
      return var0;
   }
}
