/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.events.world;

import linxiu.api.Event;

public class EventPostUpdate
extends Event {
	public static double x;
	public static double z;
    public float yaw;
    public float pitch;

    public EventPostUpdate(double x,double z,float yaw, float pitch) {
    	this.x = x;
    	this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }
}

