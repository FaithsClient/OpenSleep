package linxiu.module.modules.render;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.RLEEvent;
import linxiu.api.events.rendering.RenderArmEvent;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IRendererLivingEntity;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.render.ColorUtil;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Chams extends Module {

	// ����delta
	private final TimerUtil pulseTimer = new TimerUtil();

	private boolean pulsing;
	private float nope;

	private final Mode modeValue = new Mode("Color", new String[] { "Custom", "Rainbow", "Health", "Team" }, "Custom");

	private final Option coloredValue = new Option("Colored", true), pulseValue = new Option("Pulse", false),
			handValue = new Option("Hand", true), fillValue = new Option("Fill", true);

	private final Numbers<Number> redValue = new Numbers<>("Red", "Red color", 255.0, .0, 255.0, 5.0),
			greenValue = new Numbers<>("Green", "Green color", 255.0, .0, 255.0, 5.0),
			blueValue = new Numbers<>("Blue", "Blue color", 255.0, .0, 255.0, 5.0),
			alphaValue = new Numbers<>("Alpha", "Alpha color", 35.0, .0, 255.0, 5.0);

	public Chams() {
		super("Chams", new String[] { "Chams" }, ModuleType.Render);

	}

	@Override
	public void onEnable() {
		super.onEnable();
		pulseTimer.reset();

		pulsing = false;
		nope = 0.0F;
	}

	@EventHandler
	void onRenderModel(RenderArmEvent event) {
		if (!handValue.getValue())
			return;
		try {
			if (event.getEntity() == mc.thePlayer && mc.gameSettings.thirdPersonView == 0) {
				if (event.isPre()) {
					GlStateManager.enableBlend();
					GlStateManager.disableDepth();
					GlStateManager.disableLighting();
					GlStateManager.disableTexture2D();
					mc.entityRenderer.disableLightmap();

					/*
					 * ����COLOR
					 */

					Color color = getColor2();

					switch (modeValue.getValue()) {
					case "Rainbow":
						Color rain = ColorUtil.getRainbow(10, 1, 1);
						color = new Color(rain.getRed(), rain.getGreen(), rain.getBlue(),
								alphaValue.getValue().intValue());
						break;
					case "Health":
						Color blend = ColorUtil.getBlendColor(mc.thePlayer.getHealth(), mc.thePlayer.getMaxHealth());
						color = new Color(blend.getRed(), blend.getGreen(), blend.getBlue(),
								alphaValue.getValue().intValue());
						break;
					case "Team":
						String text = mc.thePlayer.getDisplayName().getFormattedText();
						if (Character.toLowerCase(text.charAt(0)) == '§') {
							char oneMore = Character.toLowerCase(text.charAt(1));
							int colorCode = "0123456789abcdefklmnorg".indexOf(oneMore);
							if (colorCode < 16) {
								try {
									int newColor = mc.fontRendererObj.getColorCode((char) colorCode);
									color = new Color((newColor >> 16), (newColor >> 8 & 0xFF), (newColor & 0xFF),
											alphaValue.getValue().intValue());
								} catch (ArrayIndexOutOfBoundsException ignored) {
								}
							}
						} else {
							color = new Color(255, 255, 255, alphaValue.getValue().intValue());
						}
						break;
					}

					GlStateManager.color(.003921569f * color.getRed(), .003921569f * color.getGreen(),
							.003921569f * color.getBlue(), .003921569f * color.getAlpha());
				}
				if (event.isPost()) {
					GlStateManager.resetColor();

					mc.entityRenderer.enableLightmap();
					GlStateManager.enableLighting();
					GlStateManager.enableDepth();
					GlStateManager.disableBlend();
					GlStateManager.enableTexture2D();
				}
			}
		} catch (Exception ignored) {
		}
	}

	@EventHandler
	void onRLE(RLEEvent e) {
		if (e.getEntity() instanceof EntityPlayer && e.isPre()) {
			if (coloredValue.getValue()) {
				e.setCancelled(true);
				try {
					Render<EntityLivingBase> render = mc.getRenderManager().getEntityRenderObject(e.getEntity());
					if (render != null && mc.getRenderManager().renderEngine != null
							&& render instanceof RendererLivingEntity) {
						RendererLivingEntity<EntityLivingBase> rendererLivingEntity = (RendererLivingEntity<EntityLivingBase>) render;

						GlStateManager.pushMatrix();
						GlStateManager.disableTexture2D();
						GlStateManager.disableAlpha();
						mc.entityRenderer.disableLightmap();

						GlStateManager.enableBlend();
						if (fillValue.getValue())
							GlStateManager.disableLighting();

						/*
						 * ����COLOR
						 */

						Color color = getColor2();

						switch (modeValue.getValue()) {
						case "Rainbow":
							Color rain = ColorUtil.getRainbow(10, 1, 1);
							color = new Color(rain.getRed(), rain.getGreen(), rain.getBlue(),
									alphaValue.getValue().intValue());
							break;
						case "Health":
							Color blend = ColorUtil.getBlendColor(e.getEntity().getHealth(),
									e.getEntity().getMaxHealth());
							color = new Color(blend.getRed(), blend.getGreen(), blend.getBlue(),
									alphaValue.getValue().intValue());
							break;
						case "Team":
							String text = e.getEntity().getDisplayName().getFormattedText();
							if (Character.toLowerCase(text.charAt(0)) == '§') {
								char oneMore = Character.toLowerCase(text.charAt(1));
								int colorCode = "0123456789abcdefklmnorg".indexOf(oneMore);
								if (colorCode < 16) {
									try {
										int newColor = mc.fontRendererObj.getColorCode((char) colorCode);
										color = new Color((newColor >> 16), (newColor >> 8 & 0xFF), (newColor & 0xFF),
												alphaValue.getValue().intValue());
									} catch (ArrayIndexOutOfBoundsException ignored) {
									}
								}
							} else {
								color = new Color(255, 255, 255, alphaValue.getValue().intValue());
							}
							break;
						}

						if (pulseValue.getValue() && pulseTimer.hasTimeElapsed(15)) {
							if (pulsing && nope >= 0.5F) {
								pulsing = false;
							}

							if (!pulsing && nope <= 0.0F) {
								pulsing = true;
							}

							if (pulsing)
								nope += .02F;
							else
								nope -= .015F;

							if (nope > 1.0F)
								nope = 1.0F;
							else if (nope < 0.0F)
								nope = 0.0F;
							pulseTimer.reset();
						}

						GlStateManager.color(.003921569f * color.getRed(), .003921569f * color.getGreen(),
								.003921569f * color.getBlue(),
								pulseValue.getValue() ? nope : .003921569f * color.getAlpha());

						GlStateManager.disableDepth();
						((IRendererLivingEntity) rendererLivingEntity).doRenderModel(e.getEntity(), e.getLimbSwing(),
								e.getLimbSwingAmount(), e.getAgeInTicks(), e.getRotationYawHead(), e.getRotationPitch(),
								e.getOffset());
						GlStateManager.enableDepth();

						((IRendererLivingEntity) rendererLivingEntity).doRenderModel(e.getEntity(), e.getLimbSwing(),
								e.getLimbSwingAmount(), e.getAgeInTicks(), e.getRotationYawHead(), e.getRotationPitch(),
								e.getOffset());

						GlStateManager.resetColor();

						if (fillValue.getValue())
							GlStateManager.enableLighting();
						GlStateManager.disableBlend();

						mc.entityRenderer.enableLightmap();
						GlStateManager.enableAlpha();
						GlStateManager.enableTexture2D();
						GlStateManager.popMatrix();

						((IRendererLivingEntity) rendererLivingEntity).doRenderLayers(e.getEntity(), e.getLimbSwing(),
								e.getLimbSwingAmount(), e.getTick(), e.getAgeInTicks(), e.getRotationYawHead(),
								e.getRotationPitch(), e.getOffset());

						GlStateManager.popMatrix();
					}
				} catch (Exception ignored) {
				}
			} else {
				GL11.glEnable(32823);
				GL11.glPolygonOffset(1.0F, -1100000.0F);
			}
		} else if (!coloredValue.getValue() && e.getEntity() instanceof EntityPlayer && e.isPost()) {
			GL11.glDisable(32823);
			GL11.glPolygonOffset(1.0F, 1100000.0F);
		}
	}

	public Color getColor2() {
		return new Color(redValue.getValue().intValue(), greenValue.getValue().intValue(),
				blueValue.getValue().intValue(), alphaValue.getValue().intValue());
	}

	public static int getRainbow(int speed, int offset) {
		float hue = (float) ((System.currentTimeMillis() + offset / 2) % speed * 2);
		hue /= speed;
		return Color.getHSBColor(hue, 1.0F, 1.0F).getRGB();
	}
}
