package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.event.events.PreRenderLivingEvent;
import rip.sleep.event.events.PostRenderLivingEvent;

@Mixin({RenderPlayer.class})
public abstract class MixinRenderPlayer {
   @Shadow
   protected abstract ModelPlayer func_177087_b();

   @Shadow
   protected abstract void func_177137_d(AbstractClientPlayer var1);

   @Inject(
      method = {"doRender"},
      at = {@At("HEAD")}
   )
   public void doRenderH(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
      PreRenderLivingEvent var11 = new PreRenderLivingEvent();
      EventBus.getInstance().call(var11);
   }

   @Inject(
      method = {"doRender"},
      at = {@At("RETURN")}
   )
   public void doRender(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
      PostRenderLivingEvent var11 = new PostRenderLivingEvent();
      EventBus.getInstance().call(var11);
   }
}
