package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.entity.Entity;

public class EntityUpdateEvent extends Event {
   public Entity c4817;

   public EntityUpdateEvent(Entity var1) {
      this.c4817 = var1;
   }

   public Entity c44489() {
      return this.c4817;
   }
}
