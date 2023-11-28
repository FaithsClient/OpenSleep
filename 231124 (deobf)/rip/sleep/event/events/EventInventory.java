package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.entity.player.EntityPlayer;

public class EventInventory extends Event {
   private final EntityPlayer c91591;

   public EventInventory(EntityPlayer var1) {
      this.c91591 = var1;
   }

   public EntityPlayer c64782() {
      return this.c91591;
   }
}
