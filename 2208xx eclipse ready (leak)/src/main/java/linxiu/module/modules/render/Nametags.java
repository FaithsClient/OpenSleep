package linxiu.module.modules.render;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IRenderManager;

import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.player.IRC;
import linxiu.ui.IRCUser;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.ColorUtils;
import linxiu.utils.render.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import java.awt.*;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.minecraft.client.renderer.GlStateManager.disableBlend;
import static net.minecraft.client.renderer.GlStateManager.enableTexture2D;

public class Nametags extends Module {
	private final Mode tagFont = new Mode("Font Mode", new String[] { "Client", "Vanilla" }, "Vanilla");
	private final Mode healthmode = new Mode("Health Mode", new String[] { "Bar", "Value" }, "Value");

	public static Numbers<Number> scale = new Numbers<Number>("scale", 0.5, 0.0, 5.0, 0.1);
	public static Numbers<Number> backgroundAlpha = new Numbers<Number>("alpha", 100.0, 0.0, 255.0, 1.0);
	public static Numbers<Number> renderDistance = new Numbers<Number>("distance", 192.0, 4.0, 256.0, 1.0);
	public static Option Distance = new Option("range", true);
	public static Option Armor = new Option("Armor", true);
	public static Option Background = new Option("Background", true);
	public static Option Head = new Option("Head", true);
	public static Option Outline = new Option("Outline", true);
	public static Option Health = new Option("Health", true);
	public static final Option INVISIBLES = new Option("Invisibles", false);
	private final List<Player> validEntities = new CopyOnWriteArrayList<>();

	public Nametags() {
		super("NameTags", new String[] { "tags" }, ModuleType.Render);
	}

	@Override
	public void onDisable() {
		this.validEntities.clear();
	}

	private Player getPlayerByEntity(EntityLivingBase entity) {
		return this.validEntities.stream().filter(player -> player.entity.equals(entity)).findFirst().orElse(null);
	}

	@EventHandler
	public void onRender2D(EventRender2D render2DEvent) {
		this.validEntities.forEach(Player::render);
	}

	@EventHandler
	private void onRender(EventRender3D event) {
		this.mc.theWorld.getLoadedEntityList().stream() //
				.filter(EntityPlayer.class::isInstance) //
				.filter(entity -> (!INVISIBLES.getValue().booleanValue() && !entity.isInvisible())) //
				.filter(Entity::isEntityAlive) //
				.map(EntityLivingBase.class::cast) //
				.filter(entity -> !this.validEntities.contains(getPlayerByEntity(entity))) //
				.forEach(entity -> this.validEntities.add(new Player(entity))); //

		this.validEntities.forEach(player -> {
			if (!player.entity.isEntityAlive()
					|| this.mc.thePlayer.getDistanceToEntity(player.entity) > renderDistance.getValue().intValue()) {
				this.validEntities.remove(player);
			}
			
			if (!this.mc.theWorld.getLoadedEntityList().contains(player.entity)
					|| player.entity.getDisplayName().getFormattedText().contains("NPC")
					|| player.entity.getDisplayName().getUnformattedText().equalsIgnoreCase(player.entity.getName()))
				this.validEntities.remove(player);
			
			final float x = (float) (player.entity.lastTickPosX
					+ (player.entity.posX - player.entity.lastTickPosX) * event.getPartialTicks()
					- ((IRenderManager) mc.getRenderManager()).getRenderPosX()), //
					y = (float) (player.entity.lastTickPosY + 2.3
							+ (player.entity.posY + 2.3 - (player.entity.lastTickPosY + 2.3)) * event.getPartialTicks()
							- ((IRenderManager) mc.getRenderManager()).getRenderPosY()), //
					z = (float) (player.entity.lastTickPosZ
							+ (player.entity.posZ - player.entity.lastTickPosZ) * event.getPartialTicks()
							- ((IRenderManager) mc.getRenderManager()).getRenderPosZ());
			player.positions = player.convertTo2D(x, y, z);
		});
	}

	private class Player {

		private final EntityLivingBase entity;
		private double[] positions = { 0, 0, 0 };

		public Player(EntityLivingBase entity) {
			this.entity = entity;
		}

		void render() {
			GL11.glPushMatrix();
			final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
			final float x = (float) (this.positions[0] / scaledResolution.getScaleFactor()), //
					y = (float) (this.positions[1] / scaledResolution.getScaleFactor()), //
					z = (float) (this.positions[2] / scaledResolution.getScaleFactor());

			final String health = Nametags.Health.getValue().booleanValue()
					? Objects.equals(healthmode.getValue(), "Value")
							? EnumChatFormatting.WHITE + " [" + EnumChatFormatting.RESET
									+ (int) (this.entity.getHealth() + this.entity.getAbsorptionAmount())
									+ EnumChatFormatting.RED + "\u2764" + EnumChatFormatting.WHITE + "]"
							: ""
					: "";//
			final String distance = Distance.getValue().booleanValue()
					? EnumChatFormatting.WHITE + "[" + EnumChatFormatting.GREEN
							+ (int) Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this.entity)
							+ EnumChatFormatting.WHITE + "] "
					: "";
			String formattedName = this.entity.getDisplayName().getFormattedText();

			IRCUser user = IRCUser.getIRCUserByIGN(entity.getName());
			if (IRC.check) {
				if (!this.entity.getName().isEmpty() && user != null) {
					formattedName += " \u00A77[\u00A7b" + user.username + "\u00A77]\u00A7r";
				}
			}

			GL11.glTranslatef(x, y, z);

			float amp = 1;
			switch (Minecraft.getMinecraft().gameSettings.guiScale) {
			case 0:
				amp = 0.5F;
				break;
			case 1:
				amp = 2.0F;
				break;
			case 3:
				amp = 0.6666666666666667F;
			}

			if (this.positions[2] < 0.0 || this.positions[2] >= 1.0) {
				GlStateManager.popMatrix();
				return;
			}

			ScaledResolution res = new ScaledResolution(mc);
			double scale2 = res.getScaleFactor() / Math.pow(res.getScaleFactor(), scale.getValue().doubleValue());
			GL11.glScaled(scale2, scale2, scale2);

			GlStateManager.disableDepth();

			String sad = Client.getINSTANCE().getFileManager().friendsConfig.isFriend(entity.getName())
					? EnumChatFormatting.AQUA + formattedName
					: EnumChatFormatting.RESET + formattedName;

			String content = distance + sad;
			final float rectLength = Math.abs(-(getStringWidth(content) / 2) - 3 - (getStringWidth(content) / 2 + 4)),
					maxHealth = (int) (this.entity.getMaxHealth() + this.entity.getAbsorptionAmount()),
					amplifier = 100 / maxHealth,
					percent = (int) ((this.entity.getHealth() + this.entity.getAbsorptionAmount()) * amplifier),
					space = rectLength / 100; // @on
			int n = Health.getValue() && Objects.equals(healthmode.getValue(), "Value") ? 15 : 0;
			final float contentWidth = getStringWidth(content) / 2F;

			final ScaledResolution resolution = new ScaledResolution(Minecraft.getMinecraft());

			float width = resolution.getScaledWidth() / 2F;
			float height = resolution.getScaledHeight() / 2F;

			float sizePerPixelX = FontLoaders.SF18.getStringWidth(content) / 2F * 0.5F;
			float sizePerPixelY = 15 * 0.45F;

			float xBnd1 = width / amp + sizePerPixelX;
			float xBnd2 = width / amp - sizePerPixelX;
			float yBnd1 = height / amp - sizePerPixelY;
			float yBnd2 = height / amp + sizePerPixelY;

			/*
			 * if (mc.gameSettings.thirdPersonView == 0 && this.positions[0] >= xBnd2 * 2 &&
			 * this.positions[0] <= xBnd1 * 2 && this.positions[1] >= yBnd1 * 2 &&
			 * this.positions[1] <= yBnd2 * 2) {
			 * SFBOLD_20.drawString("Middle click to teleport!",
			 * -(SFBOLD_20.stringWidth("Middle click to teleport") / 2F), -getYOffset() -
			 * 18, 0xffffffff, true);
			 * 
			 * if (Mouse.isButtonDown(2)) { if (tpTimer.delay(1000)) { String command =
			 * mc.isSingleplayer() ? "/tp" : ".tp"; mc.player.sendChatMessage(command + " "
			 * + entity.getName()); tpTimer.reset(); } } }
			 */
			int n2 = Health.getValue() && Objects.equals(healthmode.getValue(), "Value") ? -15 : 0;
			if (Background.getValue().booleanValue()) {
				RenderUtils.drawRect(-contentWidth - 2 - n, -8.0F - getYOffset(),
						getStringWidth(content + health) / 2F + //
								(Objects.equals(healthmode.getValue(), "Bar") ? 2 : getStringWidth(health) + n2 - n), //
						(Health.getValue() ? Objects.equals(healthmode.getValue(), "Bar") ? 6 : 5 : 5) - getYOffset(), //
						new Color(0, 0, 0, backgroundAlpha.getValue().intValue()).getRGB());
			}
			if (entity != Minecraft.getMinecraft().thePlayer) {
				if (Head.getValue().booleanValue()) {
					quickDrawHead(((AbstractClientPlayer) entity).getLocationSkin(),
							(int) ((float) -contentWidth - 15.4f - n), (int) ((float) -8.5F - getYOffset()), 13, 13);
				}

				if (Armor.getValue().booleanValue()) {
					renderArmor((EntityPlayer) this.entity);
				}
			}
			drawString(content, -contentWidth - n, -getYOffset() - 5, ColorUtils.WHITE.c);
			drawString(health, contentWidth - n, -getYOffset() - 5, getHealthColor());

			if (Health.getValue().booleanValue() && Objects.equals(healthmode.getValue(), "Bar")) {
				drawRect(-contentWidth - 2, 5 - getYOffset(), -contentWidth - 5 + percent * space, 6 - getYOffset(),
						getHealthColor());
			}

			GlStateManager.enableDepth();
			GL11.glPopMatrix();
		}

		private void drawString(String string, float x, float y, int color) {
			if (Objects.equals(tagFont.getValue(), "Client")) {
				FontLoaders.SF18.drawStringWithShadow(string, x, y, color);
			} else {
				if (Outline.getValue()) {
					drawOutlinedString(string, x, y, color);
				} else {
					mc.fontRendererObj.drawString(string, x, y, color, false);
				}
			}
		}

		public boolean inTeam(ICommandSender entity0, ICommandSender entity1) {
			String s = "\u00a7" + teamColor(entity0);

			return entity0.getDisplayName().getFormattedText().contains(s)
					&& entity1.getDisplayName().getFormattedText().contains(s);
		}

		public boolean inTeamWithMinecraftPlayer(ICommandSender entity) {
			return inTeam(Minecraft.getMinecraft().thePlayer, entity);
		}

		public String teamColor(ICommandSender player) {
			Matcher matcher = Pattern.compile("\u00a7(.).*\u00a7r").matcher(player.getDisplayName().getFormattedText());
			return matcher.find() ? matcher.group(1) : "f";
		}

		private float getStringWidth(String string) {
			if (Objects.equals(tagFont.getValue(), "Client")) {
				return FontLoaders.SF18.getStringWidth(string);
			} else {
				return mc.fontRendererObj.getStringWidth(string);
			}
		}

		private float getYOffset() {
			final float distanceToEntity = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this.entity);

			if (Objects.equals(healthmode.getValue(), "Bar")) {
				return (float) Math
						.max(getDistance() * (distanceToEntity >= 110 ? 0.058 : 0.032 + 4 / distanceToEntity), 1);
			} else {
				return (float) Math.max(getDistance() * (distanceToEntity >= 110 ? 0.046 : 0.02 + 4 / distanceToEntity),
						1);
			}
		}

		private int getHealthColor() {
			final float f = this.entity.getHealth(), // @off
					f1 = this.entity.getMaxHealth(), f2 = Math.max(0.0F, Math.min(f, f1) / f1); // @on
			return Color.HSBtoRGB(f2 / 3.0F, 1, 1) | 0xFF000000;
		}

		private int getDistance() {
			final int diffX = (int) Math.abs(Minecraft.getMinecraft().thePlayer.posX - this.entity.posX), // @off
					diffY = (int) Math.abs(Minecraft.getMinecraft().thePlayer.posY - this.entity.posY),
					diffZ = (int) Math.abs(Minecraft.getMinecraft().thePlayer.posZ - this.entity.posZ); // @on
			return (int) Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
		}

		private double[] convertTo2D(double x, double y, double z) {
			final FloatBuffer screenCoords = BufferUtils.createFloatBuffer(3);
			final IntBuffer viewport = BufferUtils.createIntBuffer(16);
			final FloatBuffer modelView = BufferUtils.createFloatBuffer(16);
			final FloatBuffer projection = BufferUtils.createFloatBuffer(16);

			GL11.glGetFloat(2982, modelView);
			GL11.glGetFloat(2983, projection);
			GL11.glGetInteger(2978, viewport);

			final boolean result = GLU.gluProject((float) x, (float) y, (float) z, modelView, projection, viewport,
					screenCoords);
			return result
					? new double[] { (double) screenCoords.get(0),
							(double) ((float) Display.getHeight() - screenCoords.get(1)), (double) screenCoords.get(2) }
					: null;
		}

		public void drawRect(float left, float top, float right, float bottom, int col1) {
			final float f = (col1 >> 24 & 0xFF) / 255.0F, // @off
					f1 = (col1 >> 16 & 0xFF) / 255.0F, f2 = (col1 >> 8 & 0xFF) / 255.0F, f3 = (col1 & 0xFF) / 255.0F; // @on

			GL11.glEnable(3042);
			GL11.glDisable(3553);
			GL11.glBlendFunc(770, 771);
			GL11.glEnable(2848);

			GL11.glPushMatrix();
			GL11.glColor4f(f1, f2, f3, f);
			GL11.glBegin(7);
			GL11.glVertex2d(right, top);
			GL11.glVertex2d(left, top);
			GL11.glVertex2d(left, bottom);
			GL11.glVertex2d(right, bottom);
			GL11.glEnd();
			GL11.glPopMatrix();

			GL11.glEnable(3553);
			GL11.glDisable(3042);
			GL11.glDisable(2848);
			enableTexture2D();
			disableBlend();
			GL11.glColor4f(1, 1, 1, 1);
		}

		private void renderArmor(EntityPlayer player) {
			ItemStack[] renderStack = player.inventory.armorInventory;
			ItemStack armourStack;
			int xOffset = 0;

			for (ItemStack aRenderStack : renderStack) {
				armourStack = aRenderStack;

				if (armourStack != null)
					xOffset -= 8;
			}

			if (player.getCurrentEquippedItem() != null) {
				xOffset -= 8;

				final ItemStack stock = player.getCurrentEquippedItem().copy();

				if (stock.hasEffect() && (stock.getItem() instanceof ItemTool || stock.getItem() instanceof ItemArmor))
					stock.stackSize = 1;

				renderItemStack(stock, xOffset, -32 - getYOffset() * 1.5f);
				xOffset += 16;
			}

			renderStack = player.inventory.armorInventory;

			for (int index = 3; index >= 0; index--) {
				armourStack = renderStack[index];

				if (armourStack != null) {
					renderItemStack(armourStack, xOffset, -25 - getYOffset() * 1.5f);
					xOffset += 16;
				}
			}

			GlStateManager.color(1, 1, 1, 1);
		}

		public void drawScaledCustomSizeModalRect(int x, int y, float u, float v, int uWidth, int vHeight, int width,
				int height, float tileWidth, float tileHeight) {
			float f = 1.0F / tileWidth;
			float f1 = 1.0F / tileHeight;
			GL11.glColor4f(1, 1, 1, 1);
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

		private void renderItemStack(final ItemStack stack, int x, float y) {
			GlStateManager.pushMatrix();
			GlStateManager.depthMask(true);
			GlStateManager.clear(256);
			RenderHelper.enableStandardItemLighting();

			Minecraft.getMinecraft().getRenderItem().zLevel = -150.0F;

			GlStateManager.disableDepth();
			GlStateManager.disableTexture2D();
			GlStateManager.enableBlend();
			GlStateManager.enableAlpha();
			GlStateManager.enableTexture2D();
			GlStateManager.enableLighting();
			GlStateManager.enableDepth();
			GlStateManager.scale(0.7, 0.7, 0.7);
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(stack, x, (int) y);
			Minecraft.getMinecraft().getRenderItem().renderItemOverlays(mc.fontRendererObj, stack, x, (int) y);
			Minecraft.getMinecraft().getRenderItem().zLevel = 0.0f;

			RenderHelper.disableStandardItemLighting();
			GlStateManager.disableCull();
			GlStateManager.enableAlpha();
			GlStateManager.disableBlend();
			GlStateManager.disableLighting();
			final float s = 0.5F;
			GlStateManager.scale(s, s, s);
			GlStateManager.disableDepth();
			GlStateManager.enableDepth();
			GlStateManager.scale(2.0F, 2.0F, 2.0F);
			GlStateManager.popMatrix();
		}
	}

	// region Lombok
	public List<Player> getValidEntities() {
		return this.validEntities;
	}
	// endregion

	public String stripColorCodes(String input) {
		return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
	}

	private final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-ORX]");

	public void drawOutlinedString(String str, float x, float y, int internalCol) {
		mc.fontRendererObj.drawString(stripColorCodes(str), x - 0.5f, y, 0x000000, false);
		mc.fontRendererObj.drawString(stripColorCodes(str), x + 0.5f, y, 0x000000, false);
		mc.fontRendererObj.drawString(stripColorCodes(str), x, y - 0.5f, 0x000000, false);
		mc.fontRendererObj.drawString(stripColorCodes(str), x, y + 0.5f, 0x000000, false);
		mc.fontRendererObj.drawString(str, x, y, internalCol, false);
	}
}