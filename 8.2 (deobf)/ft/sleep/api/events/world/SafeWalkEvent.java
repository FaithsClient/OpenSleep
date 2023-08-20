package ft.sleep.api.events.world;

import ft.sleep.api.Event;

public class SafeWalkEvent extends Event {
   public SafeWalkEvent(boolean safeWalking) {
      this.setCancelled(safeWalking);
   }
}
