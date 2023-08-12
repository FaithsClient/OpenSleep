package linxiu.api.events.rendering;



import linxiu.api.Event;
import net.minecraft.client.gui.ScaledResolution;

public class EventRenderGui extends Event {
   public ScaledResolution sr;

   public EventRenderGui(ScaledResolution sr2) {
      this.sr = sr2;
   }

   public ScaledResolution getResolution() {
      return this.sr;
   }
}
