package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.entity.Entity;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class AttackEntityEvent extends Event {
   public Entity c73001;
   private final boolean c62605;

   public AttackEntityEvent(Entity var1, boolean var2) {
      this.c73001 = var1;
      this.c62605 = var2;
   }

   public Entity c44489() {
      return this.c73001;
   }

   public boolean c47360() {
      return this.c62605;
   }

   public boolean c61001() {
      Module[] var1 = Value.c27574();
      return !this.c62605;
   }

   private static JSONException c83349(JSONException var0) {
      return var0;
   }
}
