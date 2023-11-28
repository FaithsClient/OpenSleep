package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.client.gui.ScaledResolution;

public class Render2DEventA extends Event {
   public ScaledResolution c73807;
   private final float c35221;

   public Render2DEventA(ScaledResolution var1, float var2) {
      this.c73807 = var1;
      this.c35221 = var2;
   }

   public ScaledResolution c26056() {
      return this.c73807;
   }

   public float c36064() {
      return this.c35221;
   }

   public float c80324() {
      return this.c35221;
   }
}
