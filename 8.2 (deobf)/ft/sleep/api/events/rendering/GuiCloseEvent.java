package ft.sleep.api.events.rendering;

import ft.sleep.api.Event;
import net.minecraft.client.gui.GuiScreen;

public class GuiCloseEvent extends Event {
   private final GuiScreen screen;

   public GuiCloseEvent(GuiScreen screen) {
      this.screen = screen;
   }

   public GuiScreen getScreen() {
      return this.screen;
   }
}
