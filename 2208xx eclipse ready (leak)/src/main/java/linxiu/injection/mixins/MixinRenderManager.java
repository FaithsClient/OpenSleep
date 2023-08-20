package linxiu.injection.mixins;

import linxiu.injection.interfaces.IRenderManager;
import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RenderManager.class)
public class MixinRenderManager implements IRenderManager {
	@Shadow
	private double renderPosX;
	@Shadow
	private double renderPosY;
	@Shadow
	private double renderPosZ;
	@Shadow
	private double viewerPosX;
	@Shadow
	private double viewerPosY;
	@Shadow
	private double viewerPosZ;

	@Override
	public double getVieWerPosX() {
		return viewerPosX;
	}

	@Override
	public double getVieWerPosY() {
		return viewerPosY;
	}

	@Override
	public double getVieWerPosZ() {
		return viewerPosZ;
	}

	@Override
	public double getRenderPosX() {
		return renderPosX;
	}

	@Override
	public double getRenderPosY() {
		return renderPosY;
	}

	@Override
	public double getRenderPosZ() {
		return renderPosZ;
	}
}
