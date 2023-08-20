//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.rendering.GuiCloseEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({GuiContainer.class})
public abstract class MixinGuiContainer extends GuiScreen {
   @Shadow
   public Container inventorySlots;

   @Overwrite
   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         EventBus.getInstance().call(new GuiCloseEvent(this));
         this.inventorySlots.onContainerClosed(this.mc.thePlayer);
      }

   }
}
