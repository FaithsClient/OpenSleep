package linxiu.ui;

import net.minecraft.entity.Entity;

public class Rotation {

    private float yaw;
    private float pitch;

    public Rotation(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Rotation(Entity ent) {
        this.yaw = ent.rotationYaw;
        this.pitch = ent.rotationPitch;
    }

    public void add(float yaw, float pitch) {
        this.yaw += yaw;
        this.pitch += pitch;
    }

    public void remove(float yaw, float pitch) {
        this.yaw -= yaw;
        this.pitch -= pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float[] getBoth() {
        return new float[]{
                yaw, pitch
        };
    }
}
