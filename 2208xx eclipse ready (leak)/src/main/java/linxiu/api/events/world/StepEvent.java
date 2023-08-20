package linxiu.api.events.world;

import linxiu.api.Event;

public class StepEvent extends Event {
    private double stepHeight;
    private final boolean pre;

    public StepEvent(double stepHeight , boolean pre) {
        this.stepHeight = stepHeight;
        this.pre = pre;
    }

    public double getStepHeight() {
        return stepHeight;
    }

    public void setStepHeight(double stepHeight) {
        this.stepHeight = stepHeight;
    }

    public boolean isPre() {
        return pre;
    }

    public boolean isPost() {
        return !pre;
    }
}
