package ft.sleep.api.events.world;

import ft.sleep.api.Event;

public class SlowdownEvent extends Event {
   public float forward;
   public float strafe;

   public SlowdownEvent(float forward, float strafe) {
      this.forward = forward;
      this.strafe = strafe;
   }

   public float getStrafe() {
      return this.strafe;
   }

   public float getForward() {
      return this.forward;
   }
}
