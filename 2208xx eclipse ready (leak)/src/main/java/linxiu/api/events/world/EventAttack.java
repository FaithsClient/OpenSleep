package linxiu.api.events.world;



import linxiu.api.Event;
import net.minecraft.entity.Entity;

public class EventAttack extends Event {
    public Entity entity;
    private final boolean preAttack;

    public EventAttack(Entity targetEntity, boolean preAttack) {
        this.entity = targetEntity;
        this.preAttack = preAttack;
    }

    public Entity getEntity() {
        return entity;
    }

    public boolean isPreAttack() {
        return preAttack;
    }

    public boolean isPostAttack() {
        return !preAttack;
    }
}
