package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import rip.sleep.event.events.DisplayScreenEvent;

@Mixin({GuiContainer.class})
public abstract class MixinGuiContainer extends GuiScreen {
   @Shadow
   public Container field_147002_h;

   @Overwrite
   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         EventBus.getInstance().call(new DisplayScreenEvent(this));
         this.field_147002_h.onContainerClosed(this.mc.thePlayer);
      }

   }
}
