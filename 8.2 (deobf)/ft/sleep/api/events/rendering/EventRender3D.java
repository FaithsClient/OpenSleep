package ft.sleep.api.events.rendering;

import ft.sleep.api.Event;

public class EventRender3D extends Event {
   private float ticks;

   public EventRender3D() {
   }

   public EventRender3D(float ticks) {
      this.ticks = ticks;
   }

   public float getPartialTicks() {
      return this.ticks;
   }
}
