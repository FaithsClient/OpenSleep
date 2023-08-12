package linxiu.injection.mixins;

import linxiu.module.modules.uhc.Xray;
import linxiu.utils.render.ColorUtils;
import net.minecraft.client.renderer.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.nio.ByteOrder;
import java.nio.IntBuffer;

@Mixin(WorldRenderer.class)
public abstract class MixinWorldRenderer {
	@Shadow
	private boolean noColor;
	@Shadow
	public IntBuffer rawIntBuffer;

	private int field_179007_h;

	@Shadow
	protected abstract int getColorIndex(int p_78909_1_);

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void putColorMultiplier(float red, float green, float blue, int p_178978_4_) {
		int i = this.getColorIndex(p_178978_4_);
		int j = -1;

		if (!this.noColor) {
			j = this.rawIntBuffer.get(i);
			if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
				int k = (int) ((float) (j & 255) * red);
				int l = (int) ((float) (j >> 8 & 255) * green);
				int i1 = (int) ((float) (j >> 16 & 255) * blue);
				j = j & -16777216;
				j = j | i1 << 16 | l << 8 | k;

				if (Xray.isEnabled) {
					j = ColorUtils.getColor(k, l, i1, Xray.alpha);
				}
			} else {
				int j1 = (int) ((float) (j >> 24 & 255) * red);
				int k1 = (int) ((float) (j >> 16 & 255) * green);
				int l1 = (int) ((float) (j >> 8 & 255) * blue);
				j = j & 255;
				j = j | j1 << 24 | k1 << 16 | l1 << 8;
				if (Xray.isEnabled) {
					j = ColorUtils.getColor(j1, k1, l1, Xray.alpha);
				}
			}
		}
		this.rawIntBuffer.put(i, j);
	}
}
