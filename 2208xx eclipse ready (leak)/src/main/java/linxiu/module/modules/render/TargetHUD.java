
package linxiu.module.modules.render;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.KillAura;
import linxiu.module.modules.render.targethud.Particles;
import linxiu.ui.font.CFontRenderer;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.ColorUtils;
import linxiu.utils.math.MathUtil;
import linxiu.utils.render.ColorUtil;
import linxiu.utils.render.Colors;
import linxiu.utils.render.RenderUtil;
import linxiu.utils.render.RenderUtils;
import linxiu.utils.targeth.AnimationUtil;
import linxiu.utils.targeth.Stencil;
import linxiu.utils.targeth.TargetHud;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public final class TargetHUD extends Module {
	private final Mode mode = new Mode("Mode",
			new String[] { "Vestige", "Zenith", "Bingus", "Zeriy", "Normal", "Stella", "Hanabi", "Skid", "Raven" },
			"Normal");
	private final Mode xymode = new Mode("XYMOD", new String[] { "Chat", "XY" }, "Chat");
	private int animWidth;
	double r2;
	private float displayHealth;
	private float health;
	private int ticks;
	private final List<Particles> particles = new ArrayList<>();
	private boolean sentParticles;
	private final double scale = 1;
	private final TimerUtil timer = new TimerUtil();
	private Entity lastTarget;
	private final TimerUtil timeUtil = new TimerUtil();
	private final ArrayList<EntityLivingBase> targetList = new ArrayList<>();
	public static ArrayList<UUID> uuidArrayList = new ArrayList<>();
	public static ArrayList<TargetHud> targetHudArrayList = new ArrayList<>();
	private static int hudX = 200, hudY = 200;
	public static Numbers<Number> yn = new Numbers("Y", "Y", 10.0, -1000.0, 1080.0, 10.0);
	public static Numbers<Number> xn = new Numbers("X", "X", 20.0, -1000.0, 1920.0, 10.0);

	public TargetHUD() {
		super("TargetHUD", new String[] { "TargetHUD" }, ModuleType.Render);
	}

	public static void drawScaledCustomSizeModalRect(double d, double e, float u, float v, int uWidth, int vHeight,
			float size, float size2, float tileWidth, float tileHeight) {
		float f = 1.0F / tileWidth;
		float f1 = 1.0F / tileHeight;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(d, e + size2, 0.0D).tex(u * f, (v + (float) vHeight) * f1).endVertex();
		worldrenderer.pos(d + size, e + size2, 0.0D).tex((u + (float) uWidth) * f, (v + (float) vHeight) * f1)
				.endVertex();
		worldrenderer.pos(d + size, e, 0.0D).tex((u + (float) uWidth) * f, v * f1).endVertex();
		worldrenderer.pos(d, e, 0.0D).tex(u * f, v * f1).endVertex();
		tessellator.draw();
	}

	public static void renderPlayerModelTexture(final double x, final double y, final float u, final float v,
			final int uWidth, final int vHeight, final int width, final int height, final float tileWidth,
			final float tileHeight, final AbstractClientPlayer target) {
		final ResourceLocation skin = target.getLocationSkin();
		Minecraft.getMinecraft().getTextureManager().bindTexture(skin);
		GL11.glEnable(GL11.GL_BLEND);
		drawScaledCustomSizeModalRect(x, y, u, v, uWidth, vHeight, width, height, tileWidth, tileHeight);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public static void drawRect(double left, double top, double right, double bottom, int color) {
		if (left < right) {
			int i = (int) left;
			left = right;
			right = i;
		}

		if (top < bottom) {
			int j = (int) top;
			top = bottom;
			bottom = j;
		}

		float f3 = (float) (color >> 24 & 255) / 255.0F;
		float f = (float) (color >> 16 & 255) / 255.0F;
		float f1 = (float) (color >> 8 & 255) / 255.0F;
		float f2 = (float) (color & 255) / 255.0F;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.color(f, f1, f2, f3);
		worldrenderer.begin(7, DefaultVertexFormats.POSITION);
		worldrenderer.pos(left, bottom, 0.0D).endVertex();
		worldrenderer.pos(right, bottom, 0.0D).endVertex();
		worldrenderer.pos(right, top, 0.0D).endVertex();
		worldrenderer.pos(left, top, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	private void drawNormalFace(EntityLivingBase e, float x, float y, float scale) {
		if (e instanceof EntityPlayer) {
			GlStateManager.color(1.0f, 1.0f, 1.0f, 0.5f);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			final List var5 = GuiPlayerTabOverlay.field_175252_a.sortedCopy(mc.thePlayer.sendQueue.getPlayerInfoMap());
			for (final Object aVar5 : var5) {
				final NetworkPlayerInfo var6 = (NetworkPlayerInfo) aVar5;
				if (mc.theWorld.getPlayerEntityByUUID(var6.getGameProfile().getId()) == e) {
					mc.getTextureManager().bindTexture(var6.getLocationSkin());
					drawScaledCustomSizeModalRect(x, y, 8.0f, 8.0f, 8, 8, (int) scale, (int) scale, 64.0f, 64.0f);
					if (((EntityPlayer) e).isWearing(EnumPlayerModelParts.HAT)) {
						drawScaledCustomSizeModalRect(x, y, 40.0f, 8.0f, 8, 8, (int) scale, (int) scale, 64.0f, 64.0f);
					}
					GlStateManager.bindTexture(0);
					break;
				}
			}
		}
	}

	private void drawString(String string, float x, float y, int color) {
		drawOutlinedString(string, x, y, color);
	}

	private final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-ORX]");

	public String stripColorCodes(String input) {
		return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
	}

	public void drawOutlinedString(String str, float x, float y, int internalCol) {
		mc.fontRendererObj.drawString(stripColorCodes(str), x - 0.5f, y, 0x000000, false);
		mc.fontRendererObj.drawString(stripColorCodes(str), x + 0.5f, y, 0x000000, false);
		mc.fontRendererObj.drawString(stripColorCodes(str), x, y - 0.5f, 0x000000, false);
		mc.fontRendererObj.drawString(stripColorCodes(str), x, y + 0.5f, 0x000000, false);
		mc.fontRendererObj.drawString(str, x, y, internalCol, false);
	}

	public float animation = 0;
	boolean nulltarget = false;
	private double healthBarWidth;
	private double healthBarWidth2;
	private double hudHeight;
	public DecimalFormat format = new DecimalFormat("0.0");
	public EntityLivingBase lastEnt;
	public float damageDelt = 0;
	public float lastPlayerHealth = -1;
	public float damageDeltToPlayer = 0;
	static double healthBarTarget = 0, healthBar = 0;
	private final TimerUtil animationTimer = new TimerUtil();
	private boolean hadTarget;
	private float lastHealth1;

	@EventHandler
	public void onRender2D(EventRender2D event) {
		KillAura killAura = (KillAura) ModuleManager.getModuleByClass(KillAura.class);
		boolean guichat = this.mc.currentScreen instanceof GuiChat;
		EntityLivingBase ent = mc.currentScreen instanceof GuiChat ? mc.thePlayer : KillAura.getTarget();
		ScaledResolution sr = new ScaledResolution(mc);
		ScaledResolution sr2 = new ScaledResolution(mc);
		int x = Objects.equals(xymode.getValue(), "Chat") ? hudX : xn.getValue().intValue();
		int y = Objects.equals(xymode.getValue(), "Chat") ? hudY : yn.getValue().intValue();
		final float nameWidth = 38;
		if (Objects.equals(mode.getValue(), "Vestige")) {
			boolean rendered = false;
			if (ent != null) {
				float mult = 0.006F;

				if (mult * animationTimer.getTime() < 2.1) {
					mult -= (float) (animationTimer.getTime() * 0.0000008);
				}

				mult *= animationTimer.getTime();
				mult = Math.min(mult, 1);
				renderTargetHUD(ent, mult);
				rendered = true;
				hadTarget = true;
			}

			if (!rendered) {
				if (hadTarget) {
					animationTimer.reset();
					hadTarget = false;
				}

				if (ent != null) {
					float mult = 0.006F;

					if (mult * animationTimer.getTime() < 2.1) {
						mult -= (float) (animationTimer.getTime() * 0.0000008);
					}

					mult *= animationTimer.getTime();
					// mult = Math.min(mult, 1);

					float finalMult = 1 - mult;

					if (finalMult > 0) {
						renderTargetHUD(ent, 1 - mult);
						rendered = true;
					} else {
						ent = null;
						rendered = false;
						lastHealth1 = 20;
					}
				}
			}

			if (!rendered && !(mc.currentScreen instanceof GuiChat)) {
				animationTimer.reset();
			}
		}
		if (Objects.equals(mode.getValue(), "Skid")) {
			ScaledResolution es = new ScaledResolution(mc);
			if (ent == null || !(ent instanceof EntityPlayer)) {
				this.animWidth = 0;
				this.r2 = 0;
				return;
			}
			int modelWidth = 22;
			int height = 34;
			int width = 2
					+ Math.max(mc.fontRendererObj.getStringWidth(ent.getDisplayName().getFormattedText()) + 12, 85);
			final String healthStr = String.valueOf((int) ent.getHealth() / 2.0f);
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y, 0F);
			RenderUtils.drawRect(0, 0, modelWidth + width, height, new Color(0, 0, 0, 180).getRGB());
			GlStateManager.color(1, 1, 1);
			int color = ent.getHealth() > 10.0f
					? RenderUtil.blend(new Color(-16711936), new Color(-256),
							1.0f / ent.getHealth() / 2.0f * (ent.getHealth() - 10.0f)).getRGB()
					: RenderUtil.blend(new Color(-256), new Color(-65536), 0.1f * ent.getHealth()).getRGB();
			String name = EnumChatFormatting.BOLD + "" + ent.getDisplayName().getFormattedText() + "";
			mc.fontRendererObj.drawStringWithShadow(name, modelWidth + 13, 3, -1);
			GlStateManager.pushMatrix();
			GlStateManager.scale(0.5, 0.5, 0.5);
			mc.fontRendererObj.drawStringWithShadow("Dist>> " + healthStr, modelWidth + 49, 39, -1);
			mc.fontRendererObj.drawStringWithShadow("Armor>> " + ent.getTotalArmorValue() + ".0", modelWidth + 110, 39,
					-1);
			mc.fontRendererObj.drawStringWithShadow("Heal>> " + (int) ent.getHealth() + ".0", modelWidth + 49, 53, -1);
			mc.fontRendererObj.drawStringWithShadow("Blocking>> " + ((EntityPlayer) ent).isBlocking(), modelWidth + 110,
					53, -1);
			GlStateManager.popMatrix();
			double healthLocation = (modelWidth + width - 2) * ent.getHealth() / ent.getMaxHealth();
			if (animWidth > healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}
			if (animWidth < healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}
			int lineWidth = 1;

			RenderUtil.drawGradientSideways(modelWidth + 13, 13, modelWidth + 13 + animWidth / 1.5, 12 + 4,
					new Color(HUD.colorValue.getValue()).getRGB(),
					getHealthColor(ent.getHealth(), ent.getMaxHealth()).getRGB());

			int armorX = 0;
			int rectX = 0;
			float hurtPercent = ent.hurtTime;
			float scale;
			if (hurtPercent == 0f) {
				scale = 1.0f;
			} else if (hurtPercent < 0.5f) {
				scale = 1.0f - (0.2f * hurtPercent * 1.0f);
			} else {
				scale = 0.8f + (0.2f * (hurtPercent - 0.5f) * 0.1f);
			}
			int size = 32;
			GL11.glPushMatrix();
			// GL11.glTranslatef((x - 53), (y + 43), 0f);
			// 受伤的缩放效果
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(((size * 0.5f * (1 - scale)) / scale), ((size * 0.5f * (1 - scale)) / scale), 0f);
			// 受伤的红色效果
			GL11.glColor4f(1f, 1 - hurtPercent, 1 - hurtPercent, 1f);
			// RenderUtils.quickDrawHead(((AbstractClientPlayer)
			// target).getLocationSkin(), 0, 0, size, size)
			// rectangleBordered(0.5f, 0.5f, 28.5f, 29.5f, 0.5f, 0x00000000,
			// Colors.getColor(128, 255));
			quickDrawHead(((AbstractClientPlayer) ent).getLocationSkin(), 1, 1, size, size);
			GL11.glPopMatrix();
			GlStateManager.popMatrix();
		}
		if (Objects.equals(mode.getValue(), "Raven")) {
			ScaledResolution es = new ScaledResolution(mc);
			if (ent == null || !(ent instanceof EntityPlayer)) {
				this.animWidth = 0;
				return;
			}
			int modelWidth = 22;
			int height = 28;
			int width = 2
					+ Math.max(mc.fontRendererObj.getStringWidth(ent.getDisplayName().getFormattedText()) + 25, 90);
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y, 0F);
			RenderUtils.drawRect(0, 0, modelWidth + width, height, new Color(0, 0, 0, 120).getRGB());
			GlStateManager.color(1, 1, 1);

			String name = EnumChatFormatting.BOLD + "Target：";
			mc.fontRendererObj.drawStringWithShadow(name + ent.getDisplayName().getFormattedText(), modelWidth - 18, 4,
					-1);
			;

			String name2 = EnumChatFormatting.WHITE + (EnumChatFormatting.BOLD + "Health：");
			mc.fontRendererObj.drawStringWithShadow(
					name2 + EnumChatFormatting.RESET + "" + String.valueOf((float) (int) (ent.getHealth()) / 2.0f),
					modelWidth - 17, 17,
					new Color(Colors.getHealthColor(ent.getHealth(), ent.getMaxHealth())).getRGB());

			double healthLocation = (width - 2) * ent.getHealth() / ent.getMaxHealth();
			if (animWidth > healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 2F);
			}
			if (animWidth < healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 2F);
			}
			RenderUtil.drawRect(modelWidth - 23, 28 - animWidth / 3 + 2.5, modelWidth - 22, 28,
					new Color(Colors.getHealthColor(ent.getHealth(), ent.getMaxHealth())).getRGB());

			GlStateManager.popMatrix();
		}
		if (Objects.equals(mode.getValue(), "Hanabi")) {
			CFontRenderer font = FontLoaders.TahomaBold14;
			CFontRenderer font1 = FontLoaders.TahomaBold18;
			if (ent != null) {
				int blackcolor = new Color(0, 0, 0, 180).getRGB();
				int blackcolor2 = new Color(200, 200, 200, 160).getRGB();
				float scaledWidth = sr2.getScaledWidth();
				float scaledHeight = sr2.getScaledHeight();
				nulltarget = ent == null;
				float health;
				double hpPercentage;
				Color hurt;
				int healthColor;
				String healthStr;
				if (nulltarget) {
					health = 0;
					hpPercentage = health / 20;
					hurt = Color.getHSBColor(300f / 360f, ((float) 0 / 10f) * 0.37f, 1f);
					healthStr = String.valueOf((float) 0 / 2.0f);
					healthColor = getHealthColor(0, 20).getRGB();
				} else {
					health = ent.getHealth();
					hpPercentage = health / ent.getMaxHealth();
					hurt = Color.getHSBColor(310f / 360f, ((float) ent.hurtTime / 10f), 1f);
					healthStr = String.valueOf((float) (int) (ent.getHealth()) / 2.0f);
					healthColor = getHealthColor(ent.getHealth(), ent.getMaxHealth()).getRGB();
				}
				hpPercentage = MathHelper.clamp_double(hpPercentage, 0.0, 1.0);
				double hpWidth = 140.0 * hpPercentage;

				if (nulltarget) {
					this.healthBarWidth2 = RenderUtil.getAnimationStateSmooth(0, this.healthBarWidth2,
							6f / Minecraft.getDebugFPS());
					this.healthBarWidth = RenderUtil.getAnimationStateSmooth(0, this.healthBarWidth,
							14f / Minecraft.getDebugFPS());

					this.hudHeight = RenderUtil.getAnimationStateSmooth(0.0, this.hudHeight,
							8f / Minecraft.getDebugFPS());
				} else {
					this.healthBarWidth2 = AnimationUtil.moveUD((float) this.healthBarWidth2, (float) hpWidth,
							6f / Minecraft.getDebugFPS(), 3f / Minecraft.getDebugFPS());
					this.healthBarWidth = RenderUtil.getAnimationStateSmooth(hpWidth, this.healthBarWidth,
							14f / Minecraft.getDebugFPS());

					this.hudHeight = RenderUtil.getAnimationStateSmooth(40.0, this.hudHeight,
							8f / Minecraft.getDebugFPS());
				}

				if (hudHeight == 0) {
					this.healthBarWidth2 = 140;
					this.healthBarWidth = 140;
				}

				GL11.glEnable(3089);
				RenderUtil.prepareScissorBox(x, (float) ((double) y + 40 - hudHeight), x + 140.0f,
						(float) ((double) y + 40));
				RenderUtil.drawRect(x, y, x + 140.0f, y + 40.0f, blackcolor);
				RenderUtil.drawRect(x, y + 37.0f, (x) + 140, y + 40f, new Color(0, 0, 0, 49).getRGB());

				RenderUtil.drawRect(x, y + 37.0f, (float) (x + this.healthBarWidth2), y + 40.0f,
						new Color(255, 0, 213, 220).getRGB());
				RenderUtil.drawGradientSideways(x, y + 37.0f, (x + this.healthBarWidth), y + 40.0f,
						new Color(0, 81, 179).getRGB(), healthColor);

				FontLoaders.TahomaBold16.drawStringWithShadow(healthStr,
						x + 40.0f + 85.0f - (float) font1.getStringWidth(healthStr) / 2.0f
								+ mc.fontRendererObj.getStringWidth("\u2764") / 1.9f,
						y + 29.0f, blackcolor2);
				mc.fontRendererObj.drawStringWithShadow("\u2764",
						x + 40.0f + 85.0f - (float) font1.getStringWidth(healthStr) / 2.0f
								- mc.fontRendererObj.getStringWidth("\u2764") / 1.9f,
						y + 26.5f, hurt.getRGB());

				CFontRenderer font2 = FontLoaders.TahomaBold12;
				if (nulltarget) {
					font2.drawStringWithShadow("XYZ:" + 0 + " " + 0 + " " + 0 + " | " + "Hurt: " + (false), x + 37.5f,
							y + 19f, ColorUtils.WHITE.c);
					font1.drawStringWithShadow("(No target)", x + 36.0f, y + 5.0f, ColorUtils.WHITE.c);
				} else {
					font2.drawStringWithShadow("XYZ:" + (int) ent.posX + " " + (int) ent.posY + " " + (int) ent.posZ
							+ " | " + "Hurt: " + (ent.hurtTime > 0), x + 37.5f, y + 19f, ColorUtils.WHITE.c);

					if ((ent instanceof EntityPlayer)) {
						font2.drawStringWithShadow(
								"Block:" + " " + (((EntityPlayer) ent).isBlocking() ? "true" : "false"), x + 37.5f,
								y + 29f, ColorUtils.WHITE.c);
					}

					font1.drawStringWithShadow(ent.getName(), x + 37f, y + 5.0f, ColorUtils.WHITE.c);

					if ((ent instanceof EntityPlayer)) {
						GlStateManager.resetColor();
						mc.getTextureManager().bindTexture(((AbstractClientPlayer) ent).getLocationSkin());

						GlStateManager.color(1, 1, 1);
						Gui.drawScaledCustomSizeModalRect(x + 3, y + 3, 8.0F, 8.0F, 8, 8, 32, 32, 64, 64);
					}
				}
				GL11.glDisable(3089);
			}
		}
		if (Objects.equals(mode.getValue(), "Normal")) {
			ScaledResolution es = new ScaledResolution(mc);
			if (ent == null || !(ent instanceof EntityPlayer)) {
				this.animWidth = 0;
				this.r2 = 0;
				return;
			}
			int modelWidth = 22;
			int height = 34;
			int width = 2
					+ Math.max(mc.fontRendererObj.getStringWidth(ent.getDisplayName().getFormattedText()) + 2, 85);
			final String healthStr = String.valueOf((int) ent.getHealth() / 2.0f);
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y, 0F);

			linxiu.ui.evaly.ClickUtils.RenderUtil.drawExhRect(0, 0, modelWidth + 3 + width, height + 2);
			GlStateManager.color(1, 1, 1);
			int color = ent.getHealth() > 10.0f
					? RenderUtil.blend(new Color(-16711936), new Color(-256),
							1.0f / ent.getHealth() / 2.0f * (ent.getHealth() - 10.0f)).getRGB()
					: RenderUtil.blend(new Color(-256), new Color(-65536), 0.1f * ent.getHealth()).getRGB();
			String name = EnumChatFormatting.BOLD + "" + ent.getDisplayName().getFormattedText() + "";
			FontLoaders.TahomaBold13.drawStringWithShadow(name, modelWidth + 13, 7, -1);
			FontLoaders.TahomaBold10.drawStringWithShadow("Dist: " + healthStr, modelWidth + 13, 21, -1);
			FontLoaders.TahomaBold10.drawStringWithShadow("Armor: " + ent.getTotalArmorValue() + ".0", modelWidth + 43,
					21, -1);
			FontLoaders.TahomaBold10.drawStringWithShadow("Heal: " + (int) ent.getHealth() + ".0", modelWidth + 13, 28f,
					-1);
			FontLoaders.TahomaBold10.drawStringWithShadow("Blocking: " + ((EntityPlayer) ent).isBlocking(),
					modelWidth + 43, 28f, -1);
			double healthLocation = (modelWidth + width - 2) * ent.getHealth() / ent.getMaxHealth();
			if (animWidth > healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}
			if (animWidth < healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}
			int lineWidth = 1;

			RenderUtil.drawGradientSideways(modelWidth + 13, 13, modelWidth + 13 + animWidth / 1.5, 12 + 4,
					new Color(HUD.colorValue.getValue()).getRGB(),
					getHealthColor(ent.getHealth(), ent.getMaxHealth()).getRGB());

			int armorX = 0;
			int rectX = 0;
			float hurtPercent = ent.hurtTime;
			float scale;
			if (hurtPercent == 0f) {
				scale = 1.0f;
			} else if (hurtPercent < 0.5f) {
				scale = 1.0f - (0.2f * hurtPercent * 1.0f);
			} else {
				scale = 0.8f + (0.2f * (hurtPercent - 0.5f) * 0.1f);
			}
			int size = 28;
			GL11.glPushMatrix();
			// GL11.glTranslatef((x - 53), (y + 43), 0f);
			// 受伤的缩放效果
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(((size * 0.5f * (1 - scale)) / scale), ((size * 0.5f * (1 - scale)) / scale), 0f);
			// 受伤的红色效果
			GL11.glColor4f(1f, 1 - hurtPercent, 1 - hurtPercent, 1f);
			// RenderUtils.quickDrawHead(((AbstractClientPlayer)
			// target).getLocationSkin(), 0, 0, size, size)
			// rectangleBordered(0.5f, 0.5f, 28.5f, 29.5f, 0.5f, 0x00000000,
			// Colors.getColor(128, 255));
			quickDrawHead(((AbstractClientPlayer) ent).getLocationSkin(), 4, 4, size, size);
			GL11.glPopMatrix();
			GlStateManager.popMatrix();
		}
		if (Objects.equals(mode.getValue(), "Stella")) {
			ScaledResolution es = new ScaledResolution(mc);
			if (ent == null || !(ent instanceof EntityPlayer)) {
				this.animWidth = 0;
				this.r2 = 0;
				return;
			}
			int modelWidth = 21;
			int height = 40;
			int width = 2
					+ Math.max(mc.fontRendererObj.getStringWidth(ent.getDisplayName().getFormattedText()) + 5, 85);
			final String healthStr = String.valueOf((int) ent.getHealth() / 2.0f);
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y, 0F);

			GlStateManager.color(1, 1, 1);
			RenderUtil.drawRoundedRect2(3, -2, (double) modelWidth + width, height, 4,
					new Color(41, 39, 44, 235).getRGB());
			int color = ent.getHealth() > 10.0f
					? RenderUtil.blend(new Color(255, 2, 12), new Color(-180),
							1.0f / ent.getHealth() / 2.0f * (ent.getHealth() - 10.0f)).getRGB()
					: RenderUtil.blend(new Color(-256), new Color(-65536), 0.1f * ent.getHealth()).getRGB();
			String name = "" + ent.getDisplayName().getFormattedText() + "";
			FontLoaders.TahomaBold16.drawStringWithShadow(name, modelWidth + 9, 4, -1);
			FontLoaders.TahomaBold12.drawStringWithShadow("Health: " + healthStr, modelWidth + 9, 14.8, -1);

			FontLoaders.logo10.drawStringWithShadow("s", modelWidth - 15, 28.5, new Color(255, 85, 85).getRGB());
			FontLoaders.logo10.drawStringWithShadow("r", modelWidth - 15, 35.5, new Color(87, 160, 250).getRGB());
			double healthLocation = (modelWidth + width - 2) * ent.getHealth() / ent.getMaxHealth();
			if (animWidth > healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}
			if (animWidth < healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}

			double armorlecotion = (modelWidth + width - 2) * ent.getTotalArmorValue();
			if (r2 > armorlecotion) {
				r2 = MathUtil.getNextPostion((int) r2, (int) armorlecotion, 20F);
			}
			if (r2 < armorlecotion) {
				r2 = MathUtil.getNextPostion((int) r2, (int) armorlecotion, 20F);
			}

			int lineWidth = 1;

			RenderUtils.drawRect(modelWidth - 9, 27.5, modelWidth - 9 + animWidth / 1.15, 26.5 + 3,
					Colors.getHealthColor(ent.getHealth(), ent.getMaxHealth()));

			RenderUtils.drawRect(modelWidth - 9, 34, modelWidth - 9 + r2 / 23, 33 + 3,
					new Color(87, 160, 250).getRGB());
			int armorX = 0;
			int rectX = 0;
			float hurtPercent = ent.hurtTime;
			float scale;
			if (hurtPercent == 0f) {
				scale = 1.0f;
			} else if (hurtPercent < 0.5f) {
				scale = 1.0f - (0.2f * hurtPercent * 1.0f);
			} else {
				scale = 0.8f + (0.2f * (hurtPercent - 0.5f) * 0.1f);
			}
			int size = 22;
			GL11.glPushMatrix();
			// 受伤的缩放效果
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(((size * 0.5f * (1 - scale)) / scale), ((size * 0.5f * (1 - scale)) / scale), 0f);
			// 受伤的红色效果
			GL11.glColor4f(1f, 1 - hurtPercent, 1 - hurtPercent, 1f);
			// RenderUtils.quickDrawHead(((AbstractClientPlayer)
			// target).getLocationSkin(), 0, 0, size, size)
			rectangleBordered(4.5f, 0.5f, 27.5f, 23.5f, 0.5f, 0x00000000, new Color(87, 160, 250).getRGB());
			quickDrawHead(((AbstractClientPlayer) ent).getLocationSkin(), 5, 1, size, size);
			GL11.glPopMatrix();
			GlStateManager.popMatrix();
		}
		if (Objects.equals(mode.getValue(), "Zeriy")) {
			ScaledResolution es = new ScaledResolution(mc);
			if (ent == null || !(ent instanceof EntityPlayer)) {
				this.animWidth = 0;
				this.r2 = 0;
				return;
			}

			int modelWidth = 22;
			int height = 34;
			int width = 2
					+ Math.max(mc.fontRendererObj.getStringWidth(ent.getDisplayName().getFormattedText()) + 2, 85);
			final String healthStr = String.valueOf((int) ent.getHealth() / 2.0f);
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y, 0F);
			RenderUtils.drawRect(0, 0, modelWidth + width, height, new Color(0, 5, 0, 130).getRGB());
			GlStateManager.color(1, 1, 1);
			int color = ent.getHealth() > 10.0f
					? RenderUtil.blend(new Color(-16711936), new Color(-256),
							1.0f / ent.getHealth() / 2.0f * (ent.getHealth() - 10.0f)).getRGB()
					: RenderUtil.blend(new Color(-256), new Color(-65536), 0.1f * ent.getHealth()).getRGB();
			String name = "" + ent.getDisplayName().getFormattedText() + "";
			// RenderUtils.drawEntityOnScreen(12, 30, 14, ent);
			FontLoaders.kiona14.drawStringWithShadow(name, modelWidth + 12, 6, -1);
			float shuzhi = ent.getHealth() / 2.0f == 10 ? 35 : 33;
			FontLoaders.logo10.drawStringWithShadow("s", modelWidth + 12, 16, new Color(238, 98, 119).getRGB());
			FontLoaders.kiona11.drawStringWithShadow(" " + healthStr + "HP",
					modelWidth + 12 + FontLoaders.logo10.getStringWidth("s"), 15, -1);
			FontLoaders.kiona11.drawStringWithShadow("  |",
					modelWidth + 16 + FontLoaders.kiona11.getStringWidth(" " + healthStr + "HP"), 14.5f, -1);
			FontLoaders.kiona11.drawStringWithShadow("hurtTime: " + ent.hurtTime,
					modelWidth + shuzhi + FontLoaders.kiona11.getStringWidth("  |"), 15f, -1);

			double healthLocation = (modelWidth + width - 2) * ent.getHealth() / ent.getMaxHealth();
			if (animWidth > healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}
			if (animWidth < healthLocation) {
				animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 20F);
			}

			double armorlecotion = (modelWidth + width - 2) * ent.getTotalArmorValue();
			if (r2 > armorlecotion) {
				r2 = MathUtil.getNextPostion((int) r2, (int) armorlecotion, 20F);
			}
			if (r2 < armorlecotion) {
				r2 = MathUtil.getNextPostion((int) r2, (int) armorlecotion, 20F);
			}

			// r2 = ((71.5 + rect)/20) * entity.getTotalArmorValue();
			int lineWidth = 1;
			RenderUtil.drawRect(0, 0.8f, modelWidth + width, 0, new Color(HUD.colorValue.getValue()).getRGB());
			RenderUtil.drawRoundedRect2(modelWidth + 12, 22, modelWidth + 12 + (modelWidth + width - 2) / 1.5, 21 + 4,
					2, new Color(0, 0, 0, 80).getRGB());
			RenderUtil.drawRoundedRect2(modelWidth + 12, 22, modelWidth + 12 + animWidth / 1.5, 21 + 4, 2,
					Colors.getHealthColor(ent.getHealth(), ent.getMaxHealth()));
			RenderUtil.drawRoundedRect2(modelWidth + 12, 27, modelWidth + 12 + (modelWidth + width - 2) / 1.5, 26 + 4,
					2, new Color(0, 0, 0, 80).getRGB());
			RenderUtil.drawRoundedRect2(modelWidth + 12, 27, modelWidth + 12 + r2 / 30, 26 + 4, 2,
					new Color(87, 130, 255).getRGB());

			int armorX = 0;
			int rectX = 0;
			float hurtPercent = ent.hurtTime;
			float scale;
			if (hurtPercent == 0f) {
				scale = 1.0f;
			} else if (hurtPercent < 0.5f) {
				scale = 1.0f - (0.2f * hurtPercent * 1.0f);
			} else {
				scale = 0.8f + (0.2f * (hurtPercent - 0.5f) * 0.1f);
			}
			int size = 27;
			GL11.glPushMatrix();
			// GL11.glTranslatef((x - 53), (y + 43), 0f);
			// 受伤的缩放效果
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(((size * 0.5f * (1 - scale)) / scale), ((size * 0.5f * (1 - scale)) / scale), 0f);
			// 受伤的红色效果
			GL11.glColor4f(1f, 1 - hurtPercent, 1 - hurtPercent, 1f);
			// RenderUtils.quickDrawHead(((AbstractClientPlayer)
			// target).getLocationSkin(), 0, 0, size, size)
			// rectangleBordered(0.5f, 0.5f, 28.5f, 29.5f, 0.5f, 0x00000000,
			// Colors.getColor(128, 255));
			quickDrawHead(((AbstractClientPlayer) ent).getLocationSkin(), 3, 4, size, size);
			GL11.glPopMatrix();
			GlStateManager.popMatrix();
		}
		if (Objects.equals(mode.getValue(), "Zenith")) {
			if (ent instanceof EntityLivingBase) {
				if (ent != null && !ent.isDead && (mc.thePlayer.getDistanceToEntity(ent) < 8)) {
					GlStateManager.pushMatrix();
					int xLeng = 2 + Math
							.max(mc.fontRendererObj.getStringWidth(ent.getDisplayName().getFormattedText()) + 17, 85);
					float yLeng = 50f;
					RenderUtil.rectangleBordered(x + 0.5, y + 0.5F, x + xLeng - 0.5F, y + yLeng - 0.5F, 0.8f,
							0x00000000, Colors.getColor(14));
					RenderUtil.rectangleBordered(x + 1.0F, y + 1.0F, x + xLeng - 1.0F, y + yLeng - 1.0F, 1.7D,
							Colors.getColor(30), Colors.getColor(80));

					String name = "" + ent.getDisplayName().getFormattedText() + "";
					FontLoaders.TahomaBold17.drawStringWithShadow(name, x + 8.5, y + 10, 16777215);
					double hpWidth = 70 * MathHelper.clamp_double(ent.getHealth() / ent.getMaxHealth(), 0D, 1D);
					RenderUtils.drawRect(x + 8.5F, y + 31F, x + hpWidth + 8.5F, y + 21 - 0.5F,
							ColorUtil.getBlendColor(ent.getHealth(), ent.getMaxHealth()).getRGB());
					FontLoaders.TahomaBold18.drawStringWithShadow((int) ent.getHealth() + " HP", x + 24.5f,
							y + 53f - FontLoaders.clickgui20.getHeight() - 22.2F, -1);
					if (ent instanceof EntityPlayer) {
						FontLoaders.TahomaBold14.drawStringWithShadow(
								String.valueOf("§4Blocking: " + ((EntityPlayer) ent).isBlocking()), x + 8.5f,
								y + 66f - FontLoaders.clickgui18.getHeight() - 22.2F, -1);
					}
					GlStateManager.popMatrix();
				}
			}
		}
		if (Objects.equals(mode.getValue(), "Bingus")) {
			if (ent == null || !(ent instanceof EntityPlayer)) {
				this.animWidth = 0;
				return;
			}
			if (ent != null) {
				RenderUtils.rect(x - 1.0f, y + 4.0f, 112.0f, 45.0f, new Color(5, 5, 5, 180));

				GL11.glPushMatrix();
				this.mc.fontRendererObj.drawStringWithShadow(ent.getName(), x + 22.0f, y + 6.0f,
						Colors.getHealthColor(ent.getHealth(), ent.getMaxHealth()));
				GlStateManager.translate(x, y, 1.0f);
				GL11.glScalef(2.0f, 2.0f, 2.0f);
				GlStateManager.translate(-x, -y, 1.0f);

				this.mc.fontRendererObj.drawStringWithShadow(
						Math.round(ent.getHealth() / 2.0f * 10.0) / 10.0 + " \u2764", x + 10.0f, y + 9.0f,
						Colors.getHealthColor(ent.getHealth(), ent.getMaxHealth()));
				GL11.glPopMatrix();
				GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
				GuiInventory.drawEntityOnScreen(x + 10, y + 44, 20, ent.rotationYaw, -ent.rotationPitch, ent);
				final int xHealthbar = -1;
				final int yHealthbar = 46;
				final float add = 112.0f;
				float healthLocation = add * ent.getHealth() / ent.getMaxHealth();

				if (animWidth > healthLocation) {
					animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 100F);
				}
				if (animWidth < healthLocation) {
					animWidth = MathUtil.getNextPostion(animWidth, (int) healthLocation, 100F);
				}
				RenderUtils.rect(x + xHealthbar, y + yHealthbar, animWidth, 3.0f,
						new Color(Colors.getHealthColor(ent.getHealth(), ent.getMaxHealth())));
			}
		}
	}

	public void rectangleBordered(double x, double y, double x1, double y1, double width, int internalColor,
			int borderColor) {
		rectangle(x + width, y + width, x1 - width, y1 - width, internalColor);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		rectangle(x + width, y, x1 - width, y + width, borderColor);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		rectangle(x, y, x + width, y1, borderColor);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		rectangle(x1 - width, y, x1, y1, borderColor);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		rectangle(x + width, y1 - width, x1 - width, y1, borderColor);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public void rectangle(double left, double top, double right, double bottom, int color) {

		double var5;

		if (left < right) {
			var5 = left;
			left = right;
			right = var5;
		}

		if (top < bottom) {
			var5 = top;
			top = bottom;
			bottom = var5;
		}

		float var11 = (float) (color >> 24 & 255) / 255.0F;
		float var6 = (float) (color >> 16 & 255) / 255.0F;
		float var7 = (float) (color >> 8 & 255) / 255.0F;
		float var8 = (float) (color & 255) / 255.0F;
		WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.color(var6, var7, var8, var11);
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(left, bottom, 0.0D).endVertex();
		worldRenderer.pos(right, bottom, 0.0D).endVertex();
		worldRenderer.pos(right, top, 0.0D).endVertex();
		worldRenderer.pos(left, top, 0.0D).endVertex();
		Tessellator.getInstance().draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public void drawScaledCustomSizeModalRect(int x, int y, float u, float v, int uWidth, int vHeight, int width,
			int height, float tileWidth, float tileHeight) {
		float f = 1.0F / tileWidth;
		float f1 = 1.0F / tileHeight;
		if (Objects.equals(mode.getValue(), "Normal")) {
			GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
		} else {
			GL11.glColor4f(1, 1, 1, 1);
		}
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer bufferbuilder = tessellator.getWorldRenderer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos(x, y + height, 0.0D).tex(u * f, (v + (float) vHeight) * f1).endVertex();
		bufferbuilder.pos(x + width, y + height, 0.0D).tex((u + (float) uWidth) * f, (v + (float) vHeight) * f1)
				.endVertex();
		bufferbuilder.pos(x + width, y, 0.0D).tex((u + (float) uWidth) * f, v * f1).endVertex();
		bufferbuilder.pos(x, y, 0.0D).tex(u * f, v * f1).endVertex();
		tessellator.draw();
	}

	public void quickDrawHead(ResourceLocation skin, int x, int y, int width, int height) {
		mc.getTextureManager().bindTexture(skin);
		drawScaledCustomSizeModalRect(x, y, 8F, 8F, 8, 8, width, height, 64F, 64F);
		drawScaledCustomSizeModalRect(x, y, 40F, 8F, 8, 8, width, height, 64F, 64F);
	}

	public void drawFace(double x, double y, float u, float v, int uWidth, int vHeight, int width, int height,
			float tileWidth, float tileHeight, AbstractClientPlayer target) {
		try {
			ResourceLocation skin = target.getLocationSkin();
			Minecraft.getMinecraft().getTextureManager().bindTexture(skin);
			GL11.glEnable(3042);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			Gui.drawScaledCustomSizeModalRect((int) x, (int) y, u, v, uWidth, vHeight, width, height, tileWidth,
					tileHeight);
			GL11.glDisable(3042);
		} catch (Exception var15) {
			var15.printStackTrace();
		}

	}

	public void onEnable() {
		super.onEnable();
	}

	public void onDisable() {
		super.onDisable();
	}

	private static int alphaToInt(float alpha, int offset) {
		return Math.min(255, (int) Math.ceil(alpha * 255.0F) + offset);
	}

	public int reAlpha(int color, float alpha) {
		try {
			Color c = new Color(color);
			float r = ((float) 1 / 255) * c.getRed();
			float g = ((float) 1 / 255) * c.getGreen();
			float b = ((float) 1 / 255) * c.getBlue();
			return new Color(r, g, b, alpha).getRGB();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return color;
	}

	public void drawRectB(final float x, final float y, final float w, final float h, final Color color) {
		RenderUtil.drawRect(x, y, x + w, y + h, color.getRGB());
	}

	public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
		drawEntityOnScreen(posX, posY, scale, mouseX, mouseY, ent, 135);
	}

	public static int getHealthColor(final EntityLivingBase player) {
		final float f = player.getHealth();
		final float f2 = player.getMaxHealth();
		final float f3 = Math.max(0.0f, Math.min(f, f2) / f2);
		return Color.HSBtoRGB(f3 / 3.0f, 1.0f, 0.75f) | 0xFF000000;
	}

	/**
	 * Draws the entity to the screen. Args: xPos, yPos, scale, mouseX, mouseY,
	 * entityLiving
	 */
	public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent,
			float rotate) {
		GlStateManager.enableColorMaterial();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) posX, (float) posY, 50.0F);
		GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		float f = ent.renderYawOffset;
		float f1 = ent.rotationYaw;
		float f2 = ent.rotationPitch;
		float f3 = ent.prevRotationYawHead;
		float f4 = ent.rotationYawHead;
		GlStateManager.rotate(rotate, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-((float) Math.atan(mouseY / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);
		ent.renderYawOffset = (float) Math.atan(mouseX / 40.0F) * 20.0F;
		ent.rotationYaw = (float) Math.atan(mouseX / 40.0F) * 40.0F;
		ent.rotationPitch = -((float) Math.atan(mouseY / 40.0F)) * 20.0F;
		ent.rotationYawHead = ent.rotationYaw;
		ent.prevRotationYawHead = ent.rotationYaw;
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
		rendermanager.setPlayerViewY(180.0F);
		rendermanager.setRenderShadow(false);
		rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		rendermanager.setRenderShadow(true);
		ent.renderYawOffset = f;
		ent.rotationYaw = f1;
		ent.rotationPitch = f2;
		ent.prevRotationYawHead = f3;
		ent.rotationYawHead = f4;
		GlStateManager.popMatrix();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	public static Color getHealthColor(float health, float maxHealth) {
		float[] fractions = new float[] { 0.0f, 0.5f, 1.0f };
		Color[] colors = new Color[] { new Color(0, 81, 179), new Color(41, 255, 255),
				new Color(HUD.color2Value.getValue()) };
		float progress = health / maxHealth;
		return blendColors(fractions, colors, progress).brighter();
	}

	public static int[] getFractionIndices(float[] fractions, float progress) {
		int startPoint;
		int[] range = new int[2];
		for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; ++startPoint) {
		}
		if (startPoint >= fractions.length) {
			startPoint = fractions.length - 1;
		}
		range[0] = startPoint - 1;
		range[1] = startPoint;
		return range;
	}

	public static Color blendColors(float[] fractions, Color[] colors, float progress) {
		if (fractions.length == colors.length) {
			int[] indices = getFractionIndices(fractions, progress);
			float[] range = new float[] { fractions[indices[0]], fractions[indices[1]] };
			Color[] colorRange = new Color[] { colors[indices[0]], colors[indices[1]] };
			float max = range[1] - range[0];
			float value = progress - range[0];
			float weight = value / max;
			return blend(colorRange[0], colorRange[1], 1.0f - weight);
		}
		throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
	}

	public static Color blend(Color color1, Color color2, double ratio) {
		float r = (float) ratio;
		float ir = 1.0f - r;
		float[] rgb1 = new float[3];
		float[] rgb2 = new float[3];
		color1.getColorComponents(rgb1);
		color2.getColorComponents(rgb2);
		return new Color(rgb1[0] * r + rgb2[0] * ir, rgb1[1] * r + rgb2[1] * ir, rgb1[2] * r + rgb2[2] * ir);
	}

	public static void drawFastRoundedRect(float x0, float y0, float x1, float y1, float radius, int color) {
		int Semicircle = 18;
		float f = 5.0F;
		float f2 = (color >> 24 & 0xFF) / 255.0F;
		float f3 = (color >> 16 & 0xFF) / 255.0F;
		float f4 = (color >> 8 & 0xFF) / 255.0F;
		float f5 = (color & 0xFF) / 255.0F;
		GL11.glDisable(2884);
		GL11.glDisable(3553);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(f3, f4, f5, f2);
		GL11.glBegin(5);
		GL11.glVertex2f(x0 + radius, y0);
		GL11.glVertex2f(x0 + radius, y1);
		GL11.glVertex2f(x1 - radius, y0);
		GL11.glVertex2f(x1 - radius, y1);
		GL11.glEnd();
		GL11.glBegin(5);
		GL11.glVertex2f(x0, y0 + radius);
		GL11.glVertex2f(x0 + radius, y0 + radius);
		GL11.glVertex2f(x0, y1 - radius);
		GL11.glVertex2f(x0 + radius, y1 - radius);
		GL11.glEnd();
		GL11.glBegin(5);
		GL11.glVertex2f(x1, y0 + radius);
		GL11.glVertex2f(x1 - radius, y0 + radius);
		GL11.glVertex2f(x1, y1 - radius);
		GL11.glVertex2f(x1 - radius, y1 - radius);
		GL11.glEnd();
		GL11.glBegin(6);
		float f6 = x1 - radius;
		float f7 = y0 + radius;
		GL11.glVertex2f(f6, f7);
		int j = 0;
		for (j = 0; j <= 18; j++) {
			float f8 = j * 5.0F;
			GL11.glVertex2f((float) (f6 + radius * Math.cos(Math.toRadians(f8))),
					(float) (f7 - radius * Math.sin(Math.toRadians(f8))));
		}
		GL11.glEnd();
		GL11.glBegin(6);
		f6 = x0 + radius;
		f7 = y0 + radius;
		GL11.glVertex2f(f6, f7);
		for (j = 0; j <= 18; j++) {
			float f9 = j * 5.0F;
			GL11.glVertex2f((float) (f6 - radius * Math.cos(Math.toRadians(f9))),
					(float) (f7 - radius * Math.sin(Math.toRadians(f9))));
		}
		GL11.glEnd();
		GL11.glBegin(6);
		f6 = x0 + radius;
		f7 = y1 - radius;
		GL11.glVertex2f(f6, f7);
		for (j = 0; j <= 18; j++) {
			float f10 = j * 5.0F;
			GL11.glVertex2f((float) (f6 - radius * Math.cos(Math.toRadians(f10))),
					(float) (f7 + radius * Math.sin(Math.toRadians(f10))));
		}
		GL11.glEnd();
		GL11.glBegin(6);
		f6 = x1 - radius;
		f7 = y1 - radius;
		GL11.glVertex2f(f6, f7);
		for (j = 0; j <= 18; j++) {
			float f11 = j * 5.0F;
			GL11.glVertex2f((float) (f6 + radius * Math.cos(Math.toRadians(f11))),
					(float) (f7 + radius * Math.sin(Math.toRadians(f11))));
		}
		GL11.glEnd();
		GL11.glEnable(3553);
		GL11.glEnable(2884);
		GL11.glDisable(3042);
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	private void drawHead(ResourceLocation skin, int x, int y, float width, float height, float alpha) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, 0);
		Stencil.write(false);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		drawFastRoundedRect(0f, 0F, width, height, 4F, new Color(0, 0, 0, 0).getRGB());
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		Stencil.erase(true);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ZERO);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
		mc.getTextureManager().bindTexture(skin);
		drawScaledCustomSizeModalRect(0, 0, 8F, 8F, 8, 8, width, height, 64F, 64F);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		Stencil.dispose();
		GL11.glPopMatrix();
	}

	public static void drawRoundedRect(double x, double y, double x1, double y1, double radius, int color) {
		GL11.glPushAttrib(0);
		GL11.glScaled(0.5D, 0.5D, 0.5D);
		x *= 2.0D;
		y *= 2.0D;
		x1 *= 2.0D;
		y1 *= 2.0D;
		GL11.glEnable(3042);
		GL11.glDisable(3553);

		float a = (color >> 24 & 0xFF) / 255.0F;
		float r = (color >> 16 & 0xFF) / 255.0F;
		float g = (color >> 8 & 0xFF) / 255.0F;
		float b = (color & 0xFF) / 255.0F;
		GL11.glColor4f(r, g, b, a);

		GL11.glEnable(2848);
		GL11.glBegin(9);
		int i;
		for (i = 0; i <= 90; i += 3)
			GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D,
					y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
		for (i = 90; i <= 180; i += 3)
			GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D,
					y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
		for (i = 0; i <= 90; i += 3)
			GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius,
					y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius);
		for (i = 90; i <= 180; i += 3)
			GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius,
					y + radius + Math.cos(i * Math.PI / 180.0D) * radius);
		GL11.glEnd();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
		GL11.glDisable(3042);
		GL11.glEnable(3553);
		GL11.glScaled(2.0D, 2.0D, 2.0D);
		GL11.glPopAttrib();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public void renderTargetHUD(EntityLivingBase ent, float mult) {
		FontRenderer fr = mc.fontRendererObj;
		int x = Objects.equals(xymode.getValue(), "Chat") ? hudX : xn.getValue().intValue();
		int y = Objects.equals(xymode.getValue(), "Chat") ? hudY : yn.getValue().intValue();
		int width = 130;
		int height = 50;
		float endX = x + width;
		float endY = y + height;

		float xAmount = endX - (width / 2);
		float yAmount = endY - (height / 2);

		float finalXAnim = xAmount - mult * xAmount;
		float finalYAnim = yAmount - mult * yAmount;

		GL11.glTranslatef(finalXAnim, finalYAnim, 0);
		GL11.glScalef(mult, mult, 0);

		drawRoundedRect(x, y, endX, endY, 6, 0x99000000);

		long timeElapsed = timer.getTime();
		timer.reset();

		timeElapsed = Math.max(timeElapsed, 1);

		float health = lastHealth1 - ((lastHealth1 - ent.getHealth()) * 0.013F * timeElapsed);

		health = Math.max(health, ent.getHealth());
		health = Math.min(20, health);

		for (float i = x + 5; i < x + health * 4; i++) {
			int color = -1;
			if (Objects.equals(HUD.mode.getValue(), "Rainbow")) {
				color = ColorUtil.interpolateColorsBackAndForth(5, (int) (i * 15), Client.INSTANCE.getClientColor(),
						Client.INSTANCE.getAlternateClientColor(), HUD.hueInterpolation.getValue()).getRGB();
			} else if (Objects.equals(HUD.mode.getValue(), "Fade")) {
				color = linxiu.utils.render.ColorUtils
						.getFadeRainbow(new Color(HUD.colorValue.getValue()), (int) (i * 13), 12).getRGB();
			} else {
				color = new Color(HUD.colorValue.getValue()).getRGB();
			}
			RenderUtils.drawRect(i, y + 35, i + 1, endY - 5, color);
		}

		quickDrawHead(((AbstractClientPlayer) ent).getLocationSkin(), (int) x + 85, (int) y + 5, 40, 40);
		fr.drawStringWithShadow(ent.getDisplayName().getFormattedText(), x + 5, y + 9, -1);
		fr.drawStringWithShadow((int) ent.getHealth() + " HP", x + 5, y + 21, -1);

		lastHealth1 = health;

		GL11.glScalef(1 / mult, 1 / mult, 0);
		GL11.glTranslatef(-finalXAnim, -finalYAnim, 0);
	}

	private void drawHelmet(final int x, final int y) {
		EntityLivingBase target = mc.currentScreen instanceof GuiChat ? mc.thePlayer : KillAura.getTarget();
		if (target == null || !(target instanceof EntityPlayer))
			return;
		GL11.glPushMatrix();
		final List<ItemStack> stuff = new ArrayList<>();
		int cock = -2;
		final ItemStack helmet = ((EntityPlayer) target).getCurrentArmor(3);
		if (helmet != null) {
			stuff.add(helmet);
		}

		for (final ItemStack yes : stuff) {
			if (Minecraft.getMinecraft().theWorld != null) {
				RenderHelper.enableGUIStandardItemLighting();
				cock += 20;
			}
			GlStateManager.pushMatrix();
			GlStateManager.disableAlpha();
			GlStateManager.clear(256);
			GlStateManager.enableBlend();
			Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(yes, cock + x, y);
			GlStateManager.disableBlend();
			GlStateManager.scale(0.5, 0.5, 0.5);
			GlStateManager.disableDepth();
			GlStateManager.disableLighting();
			GlStateManager.enableDepth();
			GlStateManager.scale(2.0f, 2.0f, 2.0f);
			GlStateManager.enableAlpha();
			GlStateManager.popMatrix();
		}
		GL11.glPopMatrix();
	}

	private void drawChest(final int x, final int y) {
		EntityLivingBase target = mc.currentScreen instanceof GuiChat ? mc.thePlayer : KillAura.getTarget();
		if (target == null || !(target instanceof EntityPlayer))
			return;
		GL11.glPushMatrix();
		final List<ItemStack> stuff = new ArrayList<>();
		int cock = -2;
		final ItemStack chest = ((EntityPlayer) target).getCurrentArmor(2);
		if (chest != null) {
			stuff.add(chest);
		}

		for (final ItemStack yes : stuff) {
			if (Minecraft.getMinecraft().theWorld != null) {
				RenderHelper.enableGUIStandardItemLighting();
				cock += 20;
			}
			GlStateManager.pushMatrix();
			GlStateManager.disableAlpha();
			GlStateManager.clear(256);
			GlStateManager.enableBlend();
			Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(yes, cock + x, y);
			GlStateManager.disableBlend();
			GlStateManager.scale(0.5, 0.5, 0.5);
			GlStateManager.disableDepth();
			GlStateManager.disableLighting();
			GlStateManager.enableDepth();
			GlStateManager.scale(2.0f, 2.0f, 2.0f);
			GlStateManager.enableAlpha();
			GlStateManager.popMatrix();
		}
		GL11.glPopMatrix();
	}

	private void drawLegs(final int x, final int y) {
		EntityLivingBase target = mc.currentScreen instanceof GuiChat ? mc.thePlayer : KillAura.getTarget();
		if (target == null || !(target instanceof EntityPlayer))
			return;
		GL11.glPushMatrix();
		final List<ItemStack> stuff = new ArrayList<>();
		int cock = -2;
		final ItemStack legs = ((EntityPlayer) target).getCurrentArmor(1);
		if (legs != null) {
			stuff.add(legs);
		}

		for (final ItemStack yes : stuff) {
			if (Minecraft.getMinecraft().theWorld != null) {
				RenderHelper.enableGUIStandardItemLighting();
				cock += 20;
			}
			GlStateManager.pushMatrix();
			GlStateManager.disableAlpha();
			GlStateManager.clear(256);
			GlStateManager.enableBlend();
			Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(yes, cock + x, y);
			GlStateManager.disableBlend();
			GlStateManager.scale(0.5, 0.5, 0.5);
			GlStateManager.disableDepth();
			GlStateManager.disableLighting();
			GlStateManager.enableDepth();
			GlStateManager.scale(2.0f, 2.0f, 2.0f);
			GlStateManager.enableAlpha();
			GlStateManager.popMatrix();
		}
		GL11.glPopMatrix();
	}

	private void drawBoots(final int x, final int y) {
		EntityLivingBase target = mc.currentScreen instanceof GuiChat ? mc.thePlayer : KillAura.getTarget();
		if (target == null || !(target instanceof EntityPlayer))
			return;
		GL11.glPushMatrix();
		final List<ItemStack> stuff = new ArrayList<>();
		int cock = -2;
		final ItemStack boots = ((EntityPlayer) target).getCurrentArmor(0);
		if (boots != null) {
			stuff.add(boots);
		}

		for (final ItemStack yes : stuff) {
			if (Minecraft.getMinecraft().theWorld != null) {
				RenderHelper.enableGUIStandardItemLighting();
				cock += 20;
			}
			GlStateManager.pushMatrix();
			GlStateManager.disableAlpha();
			GlStateManager.clear(256);
			GlStateManager.enableBlend();
			Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(yes, cock + x, y);
			GlStateManager.disableBlend();
			GlStateManager.scale(0.5, 0.5, 0.5);
			GlStateManager.disableDepth();
			GlStateManager.disableLighting();
			GlStateManager.enableDepth();
			GlStateManager.scale(2.0f, 2.0f, 2.0f);
			GlStateManager.enableAlpha();
			GlStateManager.popMatrix();
		}
		GL11.glPopMatrix();
	}

	public static int getHudX() {
		return hudX;
	}

	public static int getHudY() {
		return hudY;
	}

	public static void setHudX(int hudX) {
		TargetHUD.hudX = hudX;
	}

	public static void setHudY(int hudY) {
		TargetHUD.hudY = hudY;
	}

	public static boolean isHover(int mouseX, int mouseY) {
		return MathUtil.inRange(mouseX, mouseY, hudX + 110, hudY + 70, hudX, hudY - 50)
				&& ModuleManager.getModuleByClass(TargetHUD.class).isEnabled();
	}
}
