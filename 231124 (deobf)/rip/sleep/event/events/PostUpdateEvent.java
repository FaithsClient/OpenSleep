package rip.sleep.event.events;

import rip.sleep.event.Event;

public class PostUpdateEvent extends Event {
   public float c34861;
   public float c48143;

   public PostUpdateEvent(float var1, float var2) {
      this.c34861 = var1;
      this.c48143 = var2;
   }

   public float c74012() {
      return this.c34861;
   }

   public void c6297(float var1) {
      this.c34861 = var1;
   }

   public float c86825() {
      return this.c48143;
   }

   public void c78602(float var1) {
      this.c48143 = var1;
   }
}
