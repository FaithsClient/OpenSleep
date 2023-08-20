package ft.sleep.api.events.world;

import ft.sleep.api.Event;
import net.minecraft.entity.Entity;

public class EventAttack extends Event {
   public Entity entity;
   private final boolean preAttack;

   public EventAttack(Entity targetEntity, boolean preAttack) {
      this.entity = targetEntity;
      this.preAttack = preAttack;
   }

   public Entity getEntity() {
      return this.entity;
   }

   public boolean isPreAttack() {
      return this.preAttack;
   }

   public boolean isPostAttack() {
      return !this.preAttack;
   }
}
