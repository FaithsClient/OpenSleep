package rip.sleep.event.events;

import rip.sleep.event.Event;

public class Render3DEvent extends Event {
   private float c80570;

   public Render3DEvent() {
   }

   public Render3DEvent(float var1) {
      this.c80570 = var1;
   }

   public float c36064() {
      return this.c80570;
   }
}
