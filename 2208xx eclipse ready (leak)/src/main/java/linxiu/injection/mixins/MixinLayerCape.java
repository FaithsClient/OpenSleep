package linxiu.injection.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.Color;
import java.util.Objects;

import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import linxiu.Client;
import linxiu.module.modules.render.Cape;
import linxiu.utils.render.ColorUtils;
import linxiu.utils.render.RenderUtils;

@Mixin(LayerCape.class)
@SideOnly(Side.CLIENT)
public class MixinLayerCape {

	@Shadow
	private final RenderPlayer playerRenderer;

	public MixinLayerCape(RenderPlayer playerRenderer) {
		this.playerRenderer = playerRenderer;
	}

	/**
	 * @author Standonts
	 */
	@Overwrite
	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_,
			float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		Cape cape = (Cape) Client.getINSTANCE().getModuleManager().getModuleByClass(Cape.class);
		if (entitylivingbaseIn.hasPlayerInfo() && !entitylivingbaseIn.isInvisible()
				&& entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername())
				&& entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE) && cape.isEnabled()) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.playerRenderer.bindTexture(new ResourceLocation("sleep/Skin/cape.png"));
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 0.0F, 0.125F);
			double d0 = entitylivingbaseIn.prevChasingPosX
					+ (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * (double) partialTicks
					- (entitylivingbaseIn.prevPosX
							+ (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * (double) partialTicks);
			double d1 = entitylivingbaseIn.prevChasingPosY
					+ (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * (double) partialTicks
					- (entitylivingbaseIn.prevPosY
							+ (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * (double) partialTicks);
			double d2 = entitylivingbaseIn.prevChasingPosZ
					+ (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * (double) partialTicks
					- (entitylivingbaseIn.prevPosZ
							+ (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * (double) partialTicks);
			float f = entitylivingbaseIn.prevRenderYawOffset
					+ (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
			double d3 = (double) MathHelper.sin(f * 3.1415927F / 180.0F);
			double d4 = (double) (-MathHelper.cos(f * 3.1415927F / 180.0F));
			float f1 = (float) d1 * 10.0F;
			f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
			float f2 = (float) (d0 * d3 + d2 * d4) * 100.0F;
			float f3 = (float) (d0 * d4 - d2 * d3) * 100.0F;
			if (f2 < 0.0F) {
				f2 = 0.0F;
			}

			if (f2 > 165.0F) {
				f2 = 165.0F;
			}

			if (f1 < -5.0F) {
				f1 = -5.0F;
			}

			float f4 = entitylivingbaseIn.prevCameraYaw
					+ (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
			f1 += MathHelper.sin((entitylivingbaseIn.prevDistanceWalkedModified
					+ (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified)
							* partialTicks)
					* 6.0F) * 32.0F * f4;
			if (entitylivingbaseIn.isSneaking()) {
				f1 += 25.0F;
				GL11.glTranslatef(0.0F, 0.142F, -0.0178F);
			}

			GL11.glRotatef(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			this.playerRenderer.getMainModel().renderCape(0.0625F);
			Cape hud = (Cape) Client.getINSTANCE().getModuleManager().getModuleByClass(Cape.class);
			if (Objects.equals(hud.overlayProperty.getValue(), "Exh")) {
				this.playerRenderer.bindTexture(new ResourceLocation("sleep/Skin/overlay.png"));
			} else {
				this.playerRenderer.bindTexture(new ResourceLocation("sleep/Skin/overlay1.png"));
			}
			float alpha;
			float red;
			int rgb;
			float green;
			if (Objects.equals(hud.arrayListColorModeProperty.getValue(), "Rainbow")) {
				rgb = RenderUtils.getRainbow(hud.rainbowSpeed.getValue().intValue(),
						hud.rainbowWidth.getValue().intValue(), (int) (System.currentTimeMillis() / 15L));
			} else {
				rgb = ColorUtils.getFadeRainbow(new Color(hud.red.getValue().floatValue(),
						hud.green.getValue().floatValue(), hud.blue.getValue().floatValue()), (int) (f3 / 11), 6)
						.getRGB();
			}
			alpha = 0.3F;
			red = (float) (rgb >> 16 & 255) / 255.0F;
			green = (float) (rgb >> 8 & 255) / 255.0F;
			float blue = (float) (rgb & 255) / 255.0F;
			GL11.glColor4f(red, green, blue, alpha);
			this.playerRenderer.getMainModel().renderCape(0.0625F);
			GL11.glPopMatrix();
		}
	}
}
