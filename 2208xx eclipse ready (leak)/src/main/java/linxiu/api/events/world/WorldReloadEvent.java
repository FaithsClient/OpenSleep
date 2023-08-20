package linxiu.api.events.world;

import linxiu.api.Event;
import net.minecraft.client.multiplayer.WorldClient;

public class WorldReloadEvent extends Event {

    private final WorldClient world;

    public WorldReloadEvent(WorldClient world) {
        this.world = world;
    }

    public WorldClient getWorld() {
        return world;
    }
}
