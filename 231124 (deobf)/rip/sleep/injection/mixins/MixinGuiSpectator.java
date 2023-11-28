package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.client.gui.ScaledResolution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.event.events.Render2DEventA;

@Mixin({GuiSpectator.class})
public class MixinGuiSpectator {
   @Inject(
      method = {"renderTooltip"},
      at = {@At("RETURN")}
   )
   private void renderTooltipPost(ScaledResolution var1, float var2, CallbackInfo var3) {
      EventBus.getInstance().call(new Render2DEventA(var1, var2));
   }
}
