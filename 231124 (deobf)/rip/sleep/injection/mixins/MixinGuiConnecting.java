package rip.sleep.injection.mixins;

import net.minecraft.client.multiplayer.GuiConnecting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.Sleep;

@Mixin({GuiConnecting.class})
public class MixinGuiConnecting {
   @Inject(
      at = {@At("HEAD")},
      method = {"connect"}
   )
   private void onConnect(String var1, int var2, CallbackInfo var3) {
      Sleep.c6391 = System.currentTimeMillis();
   }
}
