/*
 * Decompiled With CFR Tool Code By ProdiGai QQ:1719993693 Version: 0.148.
 */
package linxiu.api.events.misc;

import linxiu.api.Event;

public class EventJump extends Event {
    private double motionY;
    private final boolean pre;

    public EventJump(double motionY, boolean pre) {
    	this.motionY = motionY;
        this.pre = pre;
    }

    public double getMotionY() {
        return motionY;
    }
    public void setMotionY(double motiony) {
        this.motionY = motiony;
    }

    public boolean isPre() {
        return pre;
    }

    public boolean isPost() {
        return !pre;
    }
}

