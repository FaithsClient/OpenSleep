package rip.sleep.event.events;

import rip.sleep.event.Event;

public class SlowdownEvent extends Event {
   public float c10752;
   public float c63184;

   public SlowdownEvent(float var1, float var2) {
      this.c10752 = var1;
      this.c63184 = var2;
   }

   public float c3185() {
      return this.c63184;
   }

   public float c60583() {
      return this.c10752;
   }

   public void c66661(float var1) {
      this.c10752 = var1;
   }

   public void c45778(float var1) {
      this.c63184 = var1;
   }
}
