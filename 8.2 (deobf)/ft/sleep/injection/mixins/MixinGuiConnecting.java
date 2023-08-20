package ft.sleep.injection.mixins;

import net.minecraft.client.multiplayer.GuiConnecting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiConnecting.class})
public class MixinGuiConnecting {
   @Inject(
      at = {@At("HEAD")},
      method = {"connect"}
   )
   private void onConnect(String ip, int port, CallbackInfo ci) {
      . = System.currentTimeMillis();
   }
}
