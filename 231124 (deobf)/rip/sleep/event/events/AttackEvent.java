package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.entity.Entity;

public final class AttackEvent extends Event {
   private Entity c77047;

   public AttackEvent(Entity var1) {
      this.c77047 = var1;
   }

   public Entity c20995() {
      return this.c77047;
   }
}
