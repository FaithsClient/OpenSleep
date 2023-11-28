package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.event.events.EventInventory;

@Mixin({ContainerPlayer.class})
public class MixinContainerPlayer {
   @Inject(
      method = {"onContainerClosed"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onContainerClosed(EntityPlayer var1, CallbackInfo var2) {
      EventInventory var3 = new EventInventory(var1);
      EventBus.getInstance().call(var3);
      if (var3.c58917()) {
         var2.cancel();
      }

   }
}
