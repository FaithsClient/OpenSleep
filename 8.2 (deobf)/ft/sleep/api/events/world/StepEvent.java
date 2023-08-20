package ft.sleep.api.events.world;

import ft.sleep.api.Event;

public class StepEvent extends Event {
   private double stepHeight;
   private boolean pre;

   public StepEvent(double stepHeight, boolean pre) {
      this.stepHeight = stepHeight;
      this.pre = pre;
   }

   public double getStepHeight() {
      return this.stepHeight;
   }

   public void setStepHeight(double stepHeight) {
      this.stepHeight = stepHeight;
   }

   public boolean isPre() {
      return this.pre;
   }

   public boolean isPost() {
      return !this.pre;
   }
}
