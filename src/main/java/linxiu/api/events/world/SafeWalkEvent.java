package linxiu.api.events.world;

import linxiu.api.Event;

public class SafeWalkEvent extends Event {

    public SafeWalkEvent(boolean safeWalking) {
        setCancelled(safeWalking);
    }
}
