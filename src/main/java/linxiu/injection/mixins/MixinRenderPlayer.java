package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.rendering.EventPostRenderPlayer;
import linxiu.api.events.rendering.EventPreRenderPlayer;
import linxiu.api.events.rendering.RenderArmEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderPlayer.class)
public abstract class MixinRenderPlayer {

	@Shadow
	protected abstract ModelPlayer getMainModel();

	@Shadow
	protected abstract void setModelVisibilities(AbstractClientPlayer clientPlayer);

	@Inject(method = "doRender", at = @At("HEAD"))
	public void doRenderH(AbstractClientPlayer entity, double x, double y, double z, float entityYaw,
			float partialTicks, CallbackInfo ci) {
		EventPreRenderPlayer event = new EventPreRenderPlayer();
		EventBus.getInstance().call(event);
	}

	@Inject(method = "doRender", at = @At("RETURN"))
	public void doRender(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks,
			CallbackInfo ci) {
		EventPostRenderPlayer event2 = new EventPostRenderPlayer();
		EventBus.getInstance().call(event2);
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void renderRightArm(AbstractClientPlayer clientPlayer) {
		float f = 1.0F;
		GlStateManager.color(f, f, f);
		ModelPlayer modelplayer = this.getMainModel();
		this.setModelVisibilities(clientPlayer);
		modelplayer.swingProgress = 0.0F;
		modelplayer.isSneak = false;
		modelplayer.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, clientPlayer);
		RenderArmEvent renderModelEvent = new RenderArmEvent(clientPlayer, true);
		RenderArmEvent renderModelEventPost = new RenderArmEvent(clientPlayer, false);
		EventBus.getInstance().call(renderModelEvent);

		if (!renderModelEvent.isCancelled())
			modelplayer.renderRightArm();

		EventBus.getInstance().call(renderModelEventPost);
	}
}
