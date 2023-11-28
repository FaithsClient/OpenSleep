package rip.sleep.injection.mixins;

import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.ui.misc.GuiSleepMainMenu;
import rip.sleep.util.ChatUtilA;

@Mixin({GuiMainMenu.class})
public abstract class MixinGuiMainMenu {
   @Inject(
      method = {"initGui"},
      at = {@At("HEAD")}
   )
   public void initGui(CallbackInfo var1) {
      ChatUtilA.mc.displayGuiScreen(new GuiSleepMainMenu());
   }
}
