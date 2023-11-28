package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.client.multiplayer.WorldClient;

public class WorldEvent extends Event {
   private final WorldClient c72481;

   public WorldEvent(WorldClient var1) {
      this.c72481 = var1;
   }

   public WorldClient c84687() {
      return this.c72481;
   }
}
