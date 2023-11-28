package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.client.gui.GuiScreen;

public class DisplayScreenEvent extends Event {
   private final GuiScreen c43235;

   public DisplayScreenEvent(GuiScreen var1) {
      this.c43235 = var1;
   }

   public GuiScreen c81173() {
      return this.c43235;
   }
}
