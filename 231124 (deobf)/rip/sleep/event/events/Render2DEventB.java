package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.client.gui.ScaledResolution;

public class Render2DEventB extends Event {
   public ScaledResolution c52164;

   public Render2DEventB(ScaledResolution var1) {
      this.c52164 = var1;
   }

   public ScaledResolution c92270() {
      return this.c52164;
   }
}
