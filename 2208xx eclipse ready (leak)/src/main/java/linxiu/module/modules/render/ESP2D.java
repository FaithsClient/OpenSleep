package linxiu.module.modules.render;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.value.Mode;
import linxiu.api.value.MultiOptionValue;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.AntiBot;
import linxiu.ui.RenderUtil;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.ColorUtils;
import linxiu.utils.render.ColorUtil;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ESP2D extends Module {

	private final MultiOptionValue elementValue = new MultiOptionValue("Element", new Option("Box", true),
			new Option("Items", true), new Option("INVISIBLES", true));

	private final Mode MODE = new Mode("MODE", new String[] { "Box", "Corner_A", "Corner_B", "Split" }, "Box");

	private final Map<EntityLivingBase, double[]> entityConvertedPointsMap = new HashMap<>();

	public ESP2D() {
		super("ESP2D", new String[] { "ESP2D" }, ModuleType.Render);
	}

	@EventHandler
	void onRender(EventRender3D event) {
		try {
			this.updatePositions();
		} catch (Exception exception) {
		}
	}

	@EventHandler
	void onOverlay(EventRender2D event) {
		GlStateManager.pushMatrix();
		ScaledResolution scaledRes = event.getSR();
		double twoDscale = (double) scaledRes.getScaleFactor() / Math.pow(scaledRes.getScaleFactor(), 2.0);
		GlStateManager.scale(twoDscale, twoDscale, twoDscale);
		for (Entity entity : this.entityConvertedPointsMap.keySet()) {

			boolean shouldRender;
			EntityPlayer ent = (EntityPlayer) entity;
			double[] renderPositions = this.entityConvertedPointsMap.get(entity);
			double[] renderPositionsBottom = new double[] { renderPositions[4], renderPositions[5],
					renderPositions[6] };
			double[] renderPositionsX = new double[] { renderPositions[7], renderPositions[8], renderPositions[9] };
			double[] renderPositionsX1 = new double[] { renderPositions[10], renderPositions[11], renderPositions[12] };
			double[] renderPositionsZ = new double[] { renderPositions[13], renderPositions[14], renderPositions[15] };
			double[] renderPositionsZ1 = new double[] { renderPositions[16], renderPositions[17], renderPositions[18] };
			double[] renderPositionsTop1 = new double[] { renderPositions[19], renderPositions[20],
					renderPositions[21] };
			double[] renderPositionsTop2 = new double[] { renderPositions[22], renderPositions[23],
					renderPositions[24] };
			boolean bl = shouldRender = renderPositions[3] > 0.0 && renderPositions[3] <= 1.0
					&& renderPositionsBottom[2] > 0.0 && renderPositionsBottom[2] <= 1.0 && renderPositionsX[2] > 0.0
					&& renderPositionsX[2] <= 1.0 && renderPositionsX1[2] > 0.0 && renderPositionsX1[2] <= 1.0
					&& renderPositionsZ[2] > 0.0 && renderPositionsZ[2] <= 1.0 && renderPositionsZ1[2] > 0.0
					&& renderPositionsZ1[2] <= 1.0 && renderPositionsTop1[2] > 0.0 && renderPositionsTop1[2] <= 1.0
					&& renderPositionsTop2[2] > 0.0 && renderPositionsTop2[2] <= 1.0;
			if ((double) mc.thePlayer.getDistanceToEntity(ent) < 2.5 && renderPositionsTop1[1] < 0.0) {
				shouldRender = false;
			}
			if (!shouldRender)
				continue;
			GlStateManager.pushMatrix();
			if ((elementValue.getSetting("INVISIBLES").getValue() || !ent.isInvisible())
					&& !(ent instanceof EntityPlayerSP) || !AntiBot.isBot(ent)) {
				try {
					GL11.glEnable(3042);
					GL11.glDisable(3553);
					RenderUtil.drawRect(0.0, 0.0, 0.0, 0.0, ColorUtils.getColor(0, 0));
					double[] xValues = new double[] { renderPositions[0], renderPositionsBottom[0], renderPositionsX[0],
							renderPositionsX1[0], renderPositionsZ[0], renderPositionsZ1[0], renderPositionsTop1[0],
							renderPositionsTop2[0] };
					double[] yValues = new double[] { renderPositions[1], renderPositionsBottom[1], renderPositionsX[1],
							renderPositionsX1[1], renderPositionsZ[1], renderPositionsZ1[1], renderPositionsTop1[1],
							renderPositionsTop2[1] };
					double x = renderPositions[0];
					double y = renderPositions[1];
					double endx = renderPositionsBottom[0];
					double endy = renderPositionsBottom[1];
					for (double bdubs : xValues) {
						if (!(bdubs < x))
							continue;
						x = bdubs;
					}
					for (double bdubs : xValues) {
						if (!(bdubs > endx))
							continue;
						endx = bdubs;
					}
					for (double bdubs : yValues) {
						if (!(bdubs < y))
							continue;
						y = bdubs;
					}
					for (double bdubs : yValues) {
						if (!(bdubs > endy))
							continue;
						endy = bdubs;
					}
					if (elementValue.getSetting("BOX").getValue()) {
						int color = new Color(255, 0, 0, 255).getRGB();
						if (!mc.thePlayer.canEntityBeSeen(ent)) {
							color = new Color(255, 255, 0, 255).getRGB();
						}
						double xDiff = (endx - x) / 4.0;
						double x2Diff = (endx - x) / (double) (MODE.getValue() == "Corner_B" ? 4 : 3);
						double yDiff = MODE.getValue() == "Corner_B" ? xDiff : (endy - y) / 4.0;
						switch (MODE.getValue()) {
						case "Box":
							RenderUtil.drawBordRect(x + 0.5, y + 0.5, endx - 0.5, endy - 0.5, 1.0,
									ColorUtils.getColor(0, 0, 0, 0), color);
							RenderUtil.drawBordRect(x - 0.5, y - 0.5, endx + 0.5, endy + 0.5, 1.0,
									ColorUtils.getColor(0, 0), ColorUtils.getColor(0, 150));
							RenderUtil.drawBordRect(x + 1.5, y + 1.5, endx - 1.5, endy - 1.5, 1.0,
									ColorUtils.getColor(0, 0), ColorUtils.getColor(0, 150));
							break;
						case "Split":
							RenderUtil.drawRect(x + 0.5, y + 0.5, x + 1.5, endy - 0.5, color);
							RenderUtil.drawRect(x - 0.5, y + 0.5, x + 0.5, endy - 0.5, ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.5, y + 2.5, x + 2.5, endy - 2.5, ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.0, y + 0.5, x + xDiff, y + 1.5, color);
							RenderUtil.drawRect(x - 0.5, y - 0.5, x + xDiff, y + 0.5, ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.5, y + 1.5, x + xDiff, y + 2.5, ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + xDiff, y - 0.5, x + xDiff + 1.0, y + 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.0, endy - 0.5, x + xDiff, endy - 1.5, color);
							RenderUtil.drawRect(x - 0.5, endy + 0.5, x + xDiff, endy - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.5, endy - 1.5, x + xDiff, endy - 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + xDiff, endy + 0.5, x + xDiff + 1.0, endy - 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 0.5, y + 0.5, endx - 1.5, endy - 0.5, color);
							RenderUtil.drawRect(endx + 0.5, y + 0.5, endx - 0.5, endy - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.5, y + 2.5, endx - 2.5, endy - 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.0, y + 0.5, endx - xDiff, y + 1.5, color);
							RenderUtil.drawRect(endx + 0.5, y - 0.5, endx - xDiff, y + 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.5, y + 1.5, endx - xDiff, y + 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - xDiff, y - 0.5, endx - xDiff - 1.0, y + 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.0, endy - 0.5, endx - xDiff, endy - 1.5, color);
							RenderUtil.drawRect(endx + 0.5, endy + 0.5, endx - xDiff, endy - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.5, endy - 1.5, endx - xDiff, endy - 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - xDiff, endy + 0.5, endx - xDiff - 1.0, endy - 2.5,
									ColorUtils.getColor(0, 150));
							break;
						case "Corner_A":
						case "Corner_B":
							RenderUtil.drawRect(x + 0.5, y + 0.5, x + 1.5, y + yDiff + 0.5, color);
							RenderUtil.drawRect(x + 0.5, endy - 0.5, x + 1.5, endy - yDiff - 0.5, color);
							RenderUtil.drawRect(x - 0.5, y + 0.5, x + 0.5, y + yDiff + 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.5, y + 2.5, x + 2.5, y + yDiff + 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x - 0.5, y + yDiff + 0.5, x + 2.5, y + yDiff + 1.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x - 0.5, endy - 0.5, x + 0.5, endy - yDiff - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.5, endy - 2.5, x + 2.5, endy - yDiff - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x - 0.5, endy - yDiff - 0.5, x + 2.5, endy - yDiff - 1.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.0, y + 0.5, x + x2Diff, y + 1.5, color);
							RenderUtil.drawRect(x - 0.5, y - 0.5, x + x2Diff, y + 0.5, ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.5, y + 1.5, x + x2Diff, y + 2.5, ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + x2Diff, y - 0.5, x + x2Diff + 1.0, y + 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.0, endy - 0.5, x + x2Diff, endy - 1.5, color);
							RenderUtil.drawRect(x - 0.5, endy + 0.5, x + x2Diff, endy - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + 1.5, endy - 1.5, x + x2Diff, endy - 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(x + x2Diff, endy + 0.5, x + x2Diff + 1.0, endy - 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 0.5, y + 0.5, endx - 1.5, y + yDiff + 0.5, color);
							RenderUtil.drawRect(endx - 0.5, endy - 0.5, endx - 1.5, endy - yDiff - 0.5, color);
							RenderUtil.drawRect(endx + 0.5, y + 0.5, endx - 0.5, y + yDiff + 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.5, y + 2.5, endx - 2.5, y + yDiff + 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx + 0.5, y + yDiff + 0.5, endx - 2.5, y + yDiff + 1.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx + 0.5, endy - 0.5, endx - 0.5, endy - yDiff - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.5, endy - 2.5, endx - 2.5, endy - yDiff - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx + 0.5, endy - yDiff - 0.5, endx - 2.5, endy - yDiff - 1.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.0, y + 0.5, endx - x2Diff, y + 1.5, color);
							RenderUtil.drawRect(endx + 0.5, y - 0.5, endx - x2Diff, y + 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.5, y + 1.5, endx - x2Diff, y + 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - x2Diff, y - 0.5, endx - x2Diff - 1.0, y + 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.0, endy - 0.5, endx - x2Diff, endy - 1.5, color);
							RenderUtil.drawRect(endx + 0.5, endy + 0.5, endx - x2Diff, endy - 0.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - 1.5, endy - 1.5, endx - x2Diff, endy - 2.5,
									ColorUtils.getColor(0, 150));
							RenderUtil.drawRect(endx - x2Diff, endy + 0.5, endx - x2Diff - 1.0, endy - 2.5,
									ColorUtils.getColor(0, 150));
							break;
						}
					}
					float health = ent.getHealth();
					float[] fractions = new float[] { 0.0f, 0.5f, 1.0f };
					Color[] colors = new Color[] { Color.RED, Color.YELLOW, Color.GREEN };
					float progress = health / ent.getMaxHealth();
					Color customColor = health >= 0.0f ? ColorUtil.blendColors(fractions, colors, progress).brighter()
							: Color.RED;
					double difference = y - endy + 0.5;
					double healthLocation = endy + difference * (double) progress;
					RenderUtil.drawBordRect(x - 6.5, y - 0.5, x - 2.5, endy, 1.0, ColorUtils.getColor(0, 100),
							ColorUtils.getColor(0, 150));
					RenderUtil.drawRect(x - 5.5, endy - 1.0, x - 3.5, healthLocation, customColor.getRGB());

					if (ent.getCurrentEquippedItem() != null && elementValue.getSetting("ITEMS").getValue()) {
						GlStateManager.pushMatrix();
						GlStateManager.scale(2.0f, 2.0f, 2.0f);
						String customName = ent.getCurrentEquippedItem().getDisplayName();
						float meme5 = (float) ((endx - x) / 2.0
								- (double) (FontLoaders.kiona10.getStringWidth(customName) / 1.0f));
						FontLoaders.kiona10.drawStringWithShadow(customName, (float) (x + (double) meme5) / 2.0f,
								(float) (endy
										+ (double) (FontLoaders.kiona10.getStringHeight(customName) / 2.0f * 2.0f))
										/ 2.0f + 1.0f,
								-1);
						GlStateManager.popMatrix();
					}

				} catch (Exception xValues) {
				}
			}
			GlStateManager.popMatrix();
			GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		}
		GL11.glScalef(1.0f, 1.0f, 1.0f);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		GlStateManager.popMatrix();
	}

	private void updatePositions() {
		this.entityConvertedPointsMap.clear();
		float pTicks = mc.timer.renderPartialTicks;
		for (Object e2 : mc.theWorld.getLoadedEntityList()) {
			EntityPlayer ent;
			if (!(e2 instanceof EntityPlayer) || (ent = (EntityPlayer) e2) == mc.thePlayer)
				continue;
			double x = ent.lastTickPosX + (ent.posX - ent.lastTickPosX) * (double) pTicks
					- mc.getRenderManager().viewerPosX + 0.36;
			double y = ent.lastTickPosY + (ent.posY - ent.lastTickPosY) * (double) pTicks
					- mc.getRenderManager().viewerPosY;
			double z = ent.lastTickPosZ + (ent.posZ - ent.lastTickPosZ) * (double) pTicks
					- mc.getRenderManager().viewerPosZ + 0.36;
			double topY = y += (double) ent.height + 0.15;
			double[] convertedPoints = RenderUtil.convertTo2D(x, y, z);
			double[] convertedPoints22 = RenderUtil.convertTo2D(x - 0.36, y, z - 0.36);
			double xd = 0.0;
			assert convertedPoints22 != null;
			if (!(convertedPoints22[2] >= 0.0) || !(convertedPoints22[2] < 1.0))
				continue;
			x = ent.lastTickPosX + (ent.posX - ent.lastTickPosX) * (double) pTicks - mc.getRenderManager().viewerPosX
					- 0.36;
			z = ent.lastTickPosZ + (ent.posZ - ent.lastTickPosZ) * (double) pTicks - mc.getRenderManager().viewerPosZ
					- 0.36;
			double[] convertedPointsBottom = RenderUtil.convertTo2D(x, y, z);
			y = ent.lastTickPosY + (ent.posY - ent.lastTickPosY) * (double) pTicks - mc.getRenderManager().viewerPosY
					- 0.05;
			double[] convertedPointsx = RenderUtil.convertTo2D(x, y, z);
			x = ent.lastTickPosX + (ent.posX - ent.lastTickPosX) * (double) pTicks - mc.getRenderManager().viewerPosX
					- 0.36;
			z = ent.lastTickPosZ + (ent.posZ - ent.lastTickPosZ) * (double) pTicks - mc.getRenderManager().viewerPosZ
					+ 0.36;
			double[] convertedPointsTop1 = RenderUtil.convertTo2D(x, topY, z);
			double[] convertedPointsx1 = RenderUtil.convertTo2D(x, y, z);
			x = ent.lastTickPosX + (ent.posX - ent.lastTickPosX) * (double) pTicks - mc.getRenderManager().viewerPosX
					+ 0.36;
			z = ent.lastTickPosZ + (ent.posZ - ent.lastTickPosZ) * (double) pTicks - mc.getRenderManager().viewerPosZ
					+ 0.36;
			double[] convertedPointsz = RenderUtil.convertTo2D(x, y, z);
			x = ent.lastTickPosX + (ent.posX - ent.lastTickPosX) * (double) pTicks - mc.getRenderManager().viewerPosX
					+ 0.36;
			z = ent.lastTickPosZ + (ent.posZ - ent.lastTickPosZ) * (double) pTicks - mc.getRenderManager().viewerPosZ
					- 0.36;
			double[] convertedPointsTop2 = RenderUtil.convertTo2D(x, topY, z);
			double[] convertedPointsz1 = RenderUtil.convertTo2D(x, y, z);

			this.entityConvertedPointsMap.put(ent,
					new double[] { convertedPoints[0], convertedPoints[1], xd, convertedPoints[2],
							convertedPointsBottom[0], convertedPointsBottom[1], convertedPointsBottom[2],
							convertedPointsx[0], convertedPointsx[1], convertedPointsx[2], convertedPointsx1[0],
							convertedPointsx1[1], convertedPointsx1[2], convertedPointsz[0], convertedPointsz[1],
							convertedPointsz[2], convertedPointsz1[0], convertedPointsz1[1], convertedPointsz1[2],
							convertedPointsTop1[0], convertedPointsTop1[1], convertedPointsTop1[2],
							convertedPointsTop2[0], convertedPointsTop2[1], convertedPointsTop2[2] });
		}
	}

}
