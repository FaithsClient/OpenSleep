package linxiu.injection.mixins;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Render.class)
public abstract class MixinRender {
	@Shadow protected RenderManager renderManager;
	@Shadow
	public <T extends Entity> void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {}
	@Shadow
	protected abstract <T extends Entity> boolean bindEntityTexture(T entity);
}
