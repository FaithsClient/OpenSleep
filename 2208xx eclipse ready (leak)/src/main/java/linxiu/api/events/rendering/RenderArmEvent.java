package linxiu.api.events.rendering;

import linxiu.api.Event;
import net.minecraft.entity.Entity;

public class RenderArmEvent extends Event {

    private final Entity entity;
    private final boolean pre;

    public RenderArmEvent(Entity entity, boolean pre) {
        this.entity = entity;
        this.pre = pre;
    }

    public boolean isPre() {
        return pre;
    }

    public boolean isPost() {
        return !pre;
    }

    public Entity getEntity() {
        return entity;
    }
}
