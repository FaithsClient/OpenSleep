package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.rendering.EventRender2D;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.client.gui.ScaledResolution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiSpectator.class})
public class MixinGuiSpectator {
   @Inject(
      method = {"renderTooltip"},
      at = {@At("RETURN")}
   )
   private void renderTooltipPost(ScaledResolution p_175264_1_, float p_175264_2_, CallbackInfo callbackInfo) {
      EventBus.getInstance().call(new EventRender2D(p_175264_1_, p_175264_2_));
   }
}
