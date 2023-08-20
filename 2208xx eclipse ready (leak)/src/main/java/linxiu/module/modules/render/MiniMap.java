package linxiu.module.modules.render;

import java.awt.Color;
import java.util.Objects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Mouse;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.value.Numbers;
import linxiu.management.PlayerManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.player.Teams;
import linxiu.utils.RenderUtil;
import linxiu.utils.render.ColorUtils;
import linxiu.utils.render.RenderUtils;

public class MiniMap extends Module {
	private boolean dragging;
	float hue;
	private Numbers<Number> scale = new Numbers<Number>("Scale", "Scale", 2.0, 1.0, 5.0, 0.1);
	private Numbers<Number> x = new Numbers<Number>("X", "X", 500.0, 1.0, 1920.0, 5.0);
	private Numbers<Number> y = new Numbers<Number>("Y", "Y", 2.0, 1.0, 1080.0, 5.0);
	private Numbers<Number> size = new Numbers<Number>("Size", "Size", 125.0, 50.0, 500.0, 5.0);

	public MiniMap() {
		super("MiniMap", new String[] { "MiniMap" }, ModuleType.Render);
	}

	@EventHandler
	public void onGui(EventRender2D e) {
		ScaledResolution sr = new ScaledResolution(this.mc);
		int size1 = this.size.getValue().intValue();
		float xOffset = this.x.getValue().floatValue();
		float yOffset = this.y.getValue().floatValue();
		float playerOffsetX = (float) mc.thePlayer.posX;
		float playerOffSetZ = (float) mc.thePlayer.posZ;
		int var141 = sr.getScaledWidth();
		int var151 = sr.getScaledHeight();
		int mouseX = Mouse.getX() * var141 / this.mc.displayWidth;
		int mouseY = var151 - Mouse.getY() * var151 / this.mc.displayHeight - 1;
		if ((float) mouseX >= xOffset && (float) mouseX <= xOffset + (float) size1 && (float) mouseY >= yOffset - 3.0f
				&& (float) mouseY <= yOffset + 10.0f && Mouse.getEventButton() == 0) {
			this.dragging = !this.dragging;
			boolean bl = this.dragging;
		}
		if (this.dragging && this.mc.currentScreen instanceof GuiChat) {
			Object newValue = castNumber((String) Double.toString((double) (mouseX - size1 / 2)), (Object) 5);
			this.x.setValue((Double) ((Double) newValue));
			Object newValueY = castNumber((String) Double.toString((double) (mouseY - 2)), (Object) 5);
			this.y.setValue((Double) ((Double) newValueY));
		} else {
			this.dragging = false;
		}
		if (this.hue > 255.0f) {
			this.hue = 0.0f;
		}
		float h = this.hue;
		float h2 = this.hue + 85.0f;
		float h3 = this.hue + 170.0f;
		if (h > 255.0f) {
			h = 0.0f;
		}
		if (h2 > 255.0f) {
			h2 -= 255.0f;
		}
		if (h3 > 255.0f) {
			h3 -= 255.0f;
		}
		Color color33 = Color.getHSBColor((float) (h / 255.0f), (float) 0.9f, (float) 1.0f);
		Color color332 = Color.getHSBColor((float) (h2 / 255.0f), (float) 0.9f, (float) 1.0f);
		Color color333 = Color.getHSBColor((float) (h3 / 255.0f), (float) 0.9f, (float) 1.0f);
		int color1 = color33.getRGB();
		int color2 = color332.getRGB();
		int color3 = color333.getRGB();
		this.hue = (float) ((double) this.hue + 0.1);
		RenderUtil.rectangleBordered((double) xOffset, (double) yOffset, (double) (xOffset + (float) size1),
				(double) (yOffset + (float) size1), (double) 0.5, (int) ColorUtils.getColor((int) 90),
				(int) ColorUtils.getColor((int) 0));
		RenderUtil.rectangleBordered((double) (xOffset + 1.0f), (double) (yOffset + 1.0f),
				(double) (xOffset + (float) size1 - 1.0f), (double) (yOffset + (float) size1 - 1.0f), (double) 1.0,
				(int) ColorUtils.getColor((int) 90), (int) ColorUtils.getColor((int) 61));
		RenderUtil.rectangleBordered((double) ((double) xOffset + 2.5), (double) ((double) yOffset + 2.5),
				(double) ((double) (xOffset + (float) size1) - 2.5),
				(double) ((double) (yOffset + (float) size1) - 2.5), (double) 0.5, (int) ColorUtils.getColor((int) 61),
				(int) ColorUtils.getColor((int) 0));
		RenderUtils.drawRect((xOffset + 3.0f), (yOffset + 3.0f), (xOffset + (float) size1 - 3.0f),
				(yOffset + (float) size1 - 3.0f), new Color(0, 0, 0, 150).getRGB());
		RenderUtil.drawGradientSideways((double) (xOffset + 3.0f), (double) (yOffset + 3.0f),
				(double) (xOffset + (float) (size1 - 3)), (double) ((double) yOffset + 3.6),
				ColorUtils.getFadeRainbow(new Color(HUD.colorValue.getValue()), (int) (xOffset * 1), 5).getRGB(),
				ColorUtils.getFadeRainbow(new Color(HUD.color2Value.getValue()), (int) (xOffset * 1), 5).getRGB());
		// RenderUtil.drawGradientSideways((double) (xOffset + (float) (size1 / 2)),
		// (double) (yOffset + 3.0f),
		// (double) (xOffset + (float) size1 - 3.0f), (double) ((double) yOffset + 3.6),
		// (int) color2,
		// (int) color3);
		RenderUtil.rectangle((double) ((double) xOffset + ((double) (size1 / 2) - 0.5)),
				(double) ((double) yOffset + 3.5), (double) ((double) xOffset + ((double) (size1 / 2) + 0.5)),
				(double) ((double) (yOffset + (float) size1) - 3.5), (int) ColorUtils.getColor((int) 255, (int) 80));
		RenderUtil.rectangle((double) ((double) xOffset + 3.5),
				(double) ((double) yOffset + ((double) (size1 / 2) - 0.5)),
				(double) ((double) (xOffset + (float) size1) - 3.5),
				(double) ((double) yOffset + ((double) (size1 / 2) + 0.5)),
				(int) ColorUtils.getColor((int) 255, (int) 80));
		for (Object o : mc.theWorld.getLoadedEntityList()) {
			EntityPlayer ent;
			if (!(o instanceof EntityPlayer) || !(ent = (EntityPlayer) o).isEntityAlive() || ent == mc.thePlayer
					|| ent.isInvisible() || ent.isInvisibleToPlayer((EntityPlayer) mc.thePlayer))
				continue;
			float pTicks = this.mc.timer.renderPartialTicks;
			float posX = (float) ((ent.posX + (ent.posX - ent.lastTickPosX) * (double) pTicks - (double) playerOffsetX)
					* this.scale.getValue().doubleValue());
			float posZ = (float) ((ent.posZ + (ent.posZ - ent.lastTickPosZ) * (double) pTicks - (double) playerOffSetZ)
					* this.scale.getValue().doubleValue());

			int color = (PlayerManager.isFriend(ent)
					&& Teams.isOnSameTeam(ent))
							? Color.CYAN.getRGB()
							: Color.RED.getRGB();

			float cos = (float) Math.cos((double) mc.thePlayer.rotationYaw * 0.017453292519943295D);
			float sin = (float) Math.sin((double) mc.thePlayer.rotationYaw * 0.017453292519943295D);
			float rotY = -(posZ * cos - posX * sin);
			float rotX = -(posX * cos + posZ * sin);

			if (rotY > (size1 / 2 - 5f)) {
				rotY = (size1 / 2) - 5f;
			} else if (rotY < -(size1 / 2) + 5f) {
				rotY = -(size1 / 2) + 5f;
			}

			if (rotX > (size1 / 2) - 5.0F) {
				rotX = (size1 / 2 - 5);
			} else if (rotX < (-(size1 / 2 - 5))) {
				rotX = -((size1 / 2) - 5.0F);
			}

			RenderUtil.rectangleBordered((double) ((double) (xOffset + (float) (size1 / 2) + rotX) - 1.5),
					(double) ((double) (yOffset + (float) (size1 / 2) + rotY) - 1.5),
					(double) ((double) (xOffset + (float) (size1 / 2) + rotX) + 1.5),
					(double) ((double) (yOffset + (float) (size1 / 2) + rotY) + 1.5), (double) 0.5, (int) color,
					(int) ColorUtils.getColor((int) 46));
		}
	}

	public void onDisable() {
		super.onDisable();
	}

	public void onEnable() {
		super.isEnabled();
	}

	public static boolean isNumeric(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static Object castNumber(String newValueText, Object currentValue) {
		if (newValueText.contains("")) {
			if (newValueText.toLowerCase().contains("f")) {
				return Float.parseFloat(newValueText);
			} else {
				return Double.parseDouble(newValueText);
			}
		} else {
			if (isNumeric(newValueText)) {
				return Integer.parseInt(newValueText);
			}
		}
		return newValueText;
	}

	private float findAngle(float x, float x2, float y, float y2) {
		return (float) (Math.atan2(y2 - y, x2 - x) * 180 / Math.PI);
	}
}
