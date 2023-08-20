package ft.sleep.api.events.rendering;

import ft.sleep.api.Event;
import net.minecraft.entity.Entity;

public class EventLivingUpdate extends Event {
   public Entity entity;

   public EventLivingUpdate(Entity targetEntity) {
      this.entity = targetEntity;
   }

   public Entity getEntity() {
      return this.entity;
   }
}
