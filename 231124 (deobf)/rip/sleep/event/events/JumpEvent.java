package rip.sleep.event.events;

import rip.sleep.event.Event;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class JumpEvent extends Event {
   private double c92858;
   private final boolean c22032;

   public JumpEvent(double var1, boolean var3) {
      this.c92858 = var1;
      this.c22032 = var3;
   }

   public double c44349() {
      return this.c92858;
   }

   public void c93873(double var1) {
      this.c92858 = var1;
   }

   public boolean c1161() {
      return this.c22032;
   }

   public boolean c64297() {
      Module[] var1 = Value.c27574();
      return !this.c22032;
   }

   private static JSONException c83349(JSONException var0) {
      return var0;
   }
}
