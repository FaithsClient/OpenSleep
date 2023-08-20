package ft.sleep.api.events.world;

import ft.sleep.api.Event;
import net.minecraft.client.multiplayer.WorldClient;

public class WorldReloadEvent extends Event {
   private final WorldClient world;

   public WorldReloadEvent(WorldClient world) {
      this.world = world;
   }

   public WorldClient getWorld() {
      return this.world;
   }
}
