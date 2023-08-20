//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.rendering.EventPostRenderPlayer;
import ft.sleep.api.events.rendering.EventPreRenderPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderPlayer.class})
public abstract class MixinRenderPlayer {
   @Shadow
   protected abstract ModelPlayer getMainModel();

   @Shadow
   protected abstract void setModelVisibilities(AbstractClientPlayer var1);

   @Inject(
      method = {"doRender"},
      at = {@At("HEAD")}
   )
   public void doRenderH(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
      EventPreRenderPlayer event = new EventPreRenderPlayer();
      EventBus.getInstance().call(event);
   }

   @Inject(
      method = {"doRender"},
      at = {@At("RETURN")}
   )
   public void doRender(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
      EventPostRenderPlayer event2 = new EventPostRenderPlayer();
      EventBus.getInstance().call(event2);
   }
}
