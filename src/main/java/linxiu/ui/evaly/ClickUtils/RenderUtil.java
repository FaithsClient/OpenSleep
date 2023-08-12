package linxiu.ui.evaly.ClickUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

import linxiu.injection.interfaces.IEntityRenderer;
import linxiu.utils.render.ColorUtil;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static net.minecraft.client.renderer.GlStateManager.disableBlend;
import static net.minecraft.client.renderer.GlStateManager.enableTexture2D;
import static org.lwjgl.opengl.GL11.*;

public class RenderUtil {

	private static final Minecraft mc = Minecraft.getMinecraft();
	private static final Map<Integer, Boolean> glCapMap = new HashMap<>();

	public static void scale(float x, float y, float scale, Runnable data) {
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, 0);
		GL11.glScalef(scale, scale, 1);
		GL11.glTranslatef(-x, -y, 0);
		data.run();
		GL11.glPopMatrix();
	}

	public static void drawGradientRect2(float left, float top, float right, float bottom, int startColor,
			int endColor) {
		right = left + right;
		bottom = top + bottom;
		float f = (float) (startColor >> 24 & 255) / 255.0F;
		float f1 = (float) (startColor >> 16 & 255) / 255.0F;
		float f2 = (float) (startColor >> 8 & 255) / 255.0F;
		float f3 = (float) (startColor & 255) / 255.0F;
		float f4 = (float) (endColor >> 24 & 255) / 255.0F;
		float f5 = (float) (endColor >> 16 & 255) / 255.0F;
		float f6 = (float) (endColor >> 8 & 255) / 255.0F;
		float f7 = (float) (endColor & 255) / 255.0F;
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.shadeModel(7425);
		Tessellator tessellator = Tessellator.getInstance();
		final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
		worldrenderer.pos(right, top, 0).color(f1, f2, f3, f).endVertex();
		worldrenderer.pos(left, top, 0).color(f1, f2, f3, f).endVertex();
		worldrenderer.pos(left, bottom, 0).color(f5, f6, f7, f4).endVertex();
		worldrenderer.pos(right, bottom, 0).color(f5, f6, f7, f4).endVertex();
		tessellator.draw();
		GlStateManager.shadeModel(7424);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
	}

	public static void drawExhRect(double x, double y, double dragX, double dragY) {
		drawRect(x, y, x + dragX, y + dragY, Color.BLACK.getRGB());
		drawRect(x + 1, y + 1, x + dragX - 1, y + dragY - 1, new Color(55, 55, 55).getRGB());
		drawRect(x + 1, y + 1.5, x + dragX - 2, y + dragY - 1.5, new Color(30, 30, 30).getRGB());
		drawRect(x + 3, y + 3, x + dragX - 3, y + dragY - 3, new Color(14, 14, 14).getRGB());
	}

	public static void drawRDRect(float left, float top, float width, float height, int color) {
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
		worldrenderer.pos(left, top + height, 0.0D).endVertex();
		worldrenderer.pos(left + width, top + height, 0.0D).endVertex();
		worldrenderer.pos(left + width, top, 0.0D).endVertex();
		worldrenderer.pos(left, top, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawRoundedRect(float x, float y, float width, float height, float edgeRadius, int color,
			float borderWidth, int borderColor) {
		if (color == 16777215)
			color = -65794;
		if (borderColor == 16777215)
			borderColor = -65794;

		if (edgeRadius < 0.0F) {
			edgeRadius = 0.0F;
		}

		if (edgeRadius > width / 2.0F) {
			edgeRadius = width / 2.0F;
		}

		if (edgeRadius > height / 2.0F) {
			edgeRadius = height / 2.0F;
		}

		drawRDRect(x + edgeRadius, y + edgeRadius, width - edgeRadius * 2.0F, height - edgeRadius * 2.0F, color);
		drawRDRect(x + edgeRadius, y, width - edgeRadius * 2.0F, edgeRadius, color);
		drawRDRect(x + edgeRadius, y + height - edgeRadius, width - edgeRadius * 2.0F, edgeRadius, color);
		drawRDRect(x, y + edgeRadius, edgeRadius, height - edgeRadius * 2.0F, color);
		drawRDRect(x + width - edgeRadius, y + edgeRadius, edgeRadius, height - edgeRadius * 2.0F, color);
		enableRender2D();
		color(color);
		GL11.glBegin(6);
		float centerX = x + edgeRadius;
		float centerY = y + edgeRadius;
		GL11.glVertex2d(centerX, centerY);
		int vertices = (int) Math.min(Math.max(edgeRadius, 10.0F), 90.0F);

		int i;
		double angleRadians;
		for (i = 0; i < vertices + 1; ++i) {
			angleRadians = 6.283185307179586D * (double) (i + 180) / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glEnd();
		GL11.glBegin(6);
		centerX = x + width - edgeRadius;
		centerY = y + edgeRadius;
		GL11.glVertex2d(centerX, centerY);
		vertices = (int) Math.min(Math.max(edgeRadius, 10.0F), 90.0F);

		for (i = 0; i < vertices + 1; ++i) {
			angleRadians = 6.283185307179586D * (double) (i + 90) / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glEnd();
		GL11.glBegin(6);
		centerX = x + edgeRadius;
		centerY = y + height - edgeRadius;
		GL11.glVertex2d(centerX, centerY);
		vertices = (int) Math.min(Math.max(edgeRadius, 10.0F), 90.0F);

		for (i = 0; i < vertices + 1; ++i) {
			angleRadians = 6.283185307179586D * (double) (i + 270) / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glEnd();
		GL11.glBegin(6);

		centerX = x + width - edgeRadius;
		centerY = y + height - edgeRadius;
		GL11.glVertex2d(centerX, centerY);
		vertices = (int) Math.min(Math.max(edgeRadius, 10.0F), 90.0F);

		for (i = 0; i < vertices + 1; ++i) {
			angleRadians = 6.283185307179586D * (double) i / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glEnd();
		color(borderColor);
		GL11.glLineWidth(borderWidth);
		GL11.glBegin(3);
		centerX = x + edgeRadius;
		centerY = y + edgeRadius;
		vertices = (int) Math.min(Math.max(edgeRadius, 10.0F), 90.0F);

		for (i = vertices; i >= 0; --i) {
			angleRadians = 6.283185307179586D * (double) (i + 180) / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glVertex2d((x + edgeRadius), y);
		GL11.glVertex2d((x + width - edgeRadius), y);
		centerX = x + width - edgeRadius;
		centerY = y + edgeRadius;

		for (i = vertices; i >= 0; --i) {
			angleRadians = 6.283185307179586D * (double) (i + 90) / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glVertex2d((x + width), (y + edgeRadius));
		GL11.glVertex2d((x + width), (y + height - edgeRadius));
		centerX = x + width - edgeRadius;
		centerY = y + height - edgeRadius;

		for (i = vertices; i >= 0; --i) {
			angleRadians = 6.283185307179586D * (double) i / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glVertex2d((x + width - edgeRadius), (y + height));
		GL11.glVertex2d((x + edgeRadius), (y + height));

		centerX = x + edgeRadius;
		centerY = y + height - edgeRadius;

		for (i = vertices; i >= 0; --i) {
			angleRadians = 6.283185307179586D * (double) (i + 270) / (double) (vertices * 4);
			GL11.glVertex2d((double) centerX + Math.sin(angleRadians) * (double) edgeRadius,
					(double) centerY + Math.cos(angleRadians) * (double) edgeRadius);
		}

		GL11.glVertex2d(x, y + height - edgeRadius);
		GL11.glVertex2d(x, y + edgeRadius);
		GL11.glEnd();
		disableRender2D();
	}

	public static void enableRender2D() {
		GL11.glEnable(3042);
		GL11.glDisable(2884);
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(1.0f);
	}

	public static void disableRender2D() {
		GL11.glDisable(3042);
		GL11.glEnable(2884);
		GL11.glEnable(3553);
		GL11.glDisable(2848);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.shadeModel(7424);
		GlStateManager.disableBlend();
		GlStateManager.enableTexture2D();
	}

	public static int reAlpha(int color, float alpha) {
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

	public static void setup2DRendering(Runnable f) {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glDisable(GL_TEXTURE_2D);
		f.run();
		glEnable(GL_TEXTURE_2D);
		GlStateManager.disableBlend();
	}

	public static void render(int mode, Runnable render) {
		glBegin(mode);
		render.run();
		glEnd();
	}

	public static void drawClickGuiArrow(float x, float y, float size, Animation animation, int color) {
		glTranslatef(x, y, 0);
		setup2DRendering(() -> render(GL_TRIANGLE_STRIP, () -> {
			color(color);

			double interpolation = interpolate(0.0, size / 2.0, animation.getOutput());
			if (animation.getOutput() >= .48) {
				glVertex2d(size / 2f, interpolate(size / 2.0, 0.0, animation.getOutput()));
			}
			glVertex2d(0, interpolation);

			if (animation.getOutput() < .48) {
				glVertex2d(size / 2f, interpolate(size / 2.0, 0.0, animation.getOutput()));
			}
			glVertex2d(size, interpolation);

		}));
		glTranslatef(-x, -y, 0);
	}

	public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
		return (oldValue + (newValue - oldValue) * interpolationValue);
	}

	public static void resetColor() {
		GlStateManager.color(1, 1, 1, 1);
	}

	public static double animate(double endPoint, double current, double speed) {
		boolean shouldContinueAnimation = endPoint > current;
		if (speed < 0.0D) {
			speed = 0.0D;
		} else if (speed > 1.0D) {
			speed = 1.0D;
		}

		double dif = Math.max(endPoint, current) - Math.min(endPoint, current);
		double factor = dif * speed;
		return current + (shouldContinueAnimation ? factor : -factor);
	}

	public static void drawArc(float n, float n2, double n3, final int n4, final int n5, final double n6,
			final int n7) {
		n3 *= 2.0;
		n *= 2.0f;
		n2 *= 2.0f;
		final float n8 = (n4 >> 24 & 0xFF) / 255.0f;
		final float n9 = (n4 >> 16 & 0xFF) / 255.0f;
		final float n10 = (n4 >> 8 & 0xFF) / 255.0f;
		final float n11 = (n4 & 0xFF) / 255.0f;
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glDepthMask(true);
		GL11.glEnable(2848);
		GL11.glHint(3154, 4354);
		GL11.glHint(3155, 4354);
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		GL11.glLineWidth((float) n7);
		GL11.glEnable(2848);
		GL11.glColor4f(n9, n10, n11, n8);
		GL11.glBegin(3);
		int n12 = n5;
		while (n12 <= n6) {
			GL11.glVertex2d(n + Math.sin(n12 * 3.141592653589793 / 180.0) * n3,
					n2 + Math.cos(n12 * 3.141592653589793 / 180.0) * n3);
			++n12;
		}
		GL11.glEnd();
		GL11.glDisable(2848);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
		GL11.glDisable(2848);
		GL11.glHint(3154, 4352);
		GL11.glHint(3155, 4352);
	}

	public static void drawTraces(Entity entity, Color color) {

		double x = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks
				- mc.getRenderManager().renderPosX);
		double y = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks
				- mc.getRenderManager().renderPosY);
		double z = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks
				- mc.getRenderManager().renderPosZ);

		Vec3 eyeVector = new Vec3(0.0, 0.0, 1.0).rotatePitch((float) -Math.toRadians(mc.thePlayer.rotationPitch))
				.rotateYaw((float) -Math.toRadians(mc.thePlayer.rotationYaw));

		RenderUtil.glColor(color);

		GL11.glVertex3d(eyeVector.xCoord, mc.thePlayer.eyeHeight + eyeVector.yCoord, eyeVector.zCoord);
		GL11.glVertex3d(x, y, z);
		GL11.glVertex3d(x, y, z);
		GL11.glVertex3d(x, y + entity.height, z);
	}

	public static void drawCircle(float x, float y, float radius, int color) {

		GlStateManager.pushMatrix();

		GlStateManager.disableTexture2D();

		GL11.glEnable(GL11.GL_POLYGON_SMOOTH);
		GlStateManager.enableBlend();

		GL11.glBegin(GL11.GL_POLYGON);

		ColorUtil.glColor(color);
		for (int i = 0; i <= 360; ++i) {
			GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * radius, y + Math.cos(i * Math.PI / 180.0D) * radius);
		}
		GlStateManager.resetColor();
		GL11.glEnd();

		GL11.glDisable(GL11.GL_POLYGON_SMOOTH);
		GlStateManager.disableBlend();

		GlStateManager.enableTexture2D();
		GlStateManager.popMatrix();
	}


	public static void drawEntityESP(double x, double y, double z, double width, double height, float red, float green,
			float blue, float alpha, float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWdith) {
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glDisable(2929);
		GL11.glDepthMask(false);
		GL11.glColor4f(red, green, blue, alpha);
		RenderUtil.drawBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width));
		GL11.glLineWidth(lineWdith);
		GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
		RenderUtil
				.drawOutlinedBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width));
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glPopMatrix();
	}

	public static void drawBoundingBox(AxisAlignedBB aa) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		tessellator.draw();
	}

	public static void drawBordRect(double x, double y, double x1, double y1, double width, int internalColor,
			int borderColor) {
		drawRect(x + width, y + width, x1 - width, y1 - width, internalColor);
		drawRect(x + width, y, x1 - width, y + width, borderColor);
		drawRect(x, y, x + width, y1, borderColor);
		drawRect(x1 - width, y, x1, y1, borderColor);
		drawRect(x + width, y1 - width, x1 - width, y1, borderColor);
	}

	public static void glColor(int hex) {
		float alpha = (float) (hex >> 24 & 255) / 255.0f;
		float red = (float) (hex >> 16 & 255) / 255.0f;
		float green = (float) (hex >> 8 & 255) / 255.0f;
		float blue = (float) (hex & 255) / 255.0f;
		GL11.glColor4f(red, green, blue, alpha == 0.0f ? 1.0f : alpha);
	}

	public static void glColor(Color hex) {
		float alpha = (float) (hex.getRGB() >> 24 & 255) / 255.0f;
		float red = (float) (hex.getRGB() >> 16 & 255) / 255.0f;
		float green = (float) (hex.getRGB() >> 8 & 255) / 255.0f;
		float blue = (float) (hex.getRGB() & 255) / 255.0f;
		GL11.glColor4f(red, green, blue, alpha == 0.0f ? 1.0f : alpha);
	}

	public static void setGLCap(int cap, boolean flag) {
		glCapMap.put(cap, GL11.glGetBoolean(cap));
		if (flag) {
			GL11.glEnable(cap);
		} else {
			GL11.glDisable(cap);
		}
	}

	private static void revertGLCap(int cap) {
		Boolean origCap = glCapMap.get(cap);
		if (origCap != null) {
			if (origCap) {
				GL11.glEnable(cap);
			} else {
				GL11.glDisable(cap);
			}
		}
	}

	public static void revertAllCaps() {
		for (Integer cap : glCapMap.keySet()) {
			revertGLCap(cap);
		}
	}

	public static void enableSmoothLine(float width) {// 瞎几把起的名�?
		GL11.glDisable(3008);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(3553);
		GL11.glDisable(2929);
		GL11.glDepthMask(false);
		GL11.glEnable(2884);
		GL11.glEnable(2848);
		GL11.glHint(3154, 4354);
		GL11.glHint(3155, 4354);
		GL11.glLineWidth(width);
	}

	public static void disableSmoothLine() {// 瞎鸡巴起的名�?
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDisable(3042);
		GL11.glEnable(3008);
		GL11.glDepthMask(true);
		GL11.glCullFace(1029);
		GL11.glDisable(2848);
		GL11.glHint(3154, 4352);
		GL11.glHint(3155, 4352);
	}

	public static void drawBorderedRect(final float x, final float y, final float x2, final float y2, final float l1,
			final int col1, final int col2) {
		drawRect(x, y, x2, y2, col2);
		final float f = (col1 >> 24 & 0xFF) / 255.0f;
		final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
		final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
		final float f4 = (col1 & 0xFF) / 255.0f;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glPushMatrix();
		GL11.glColor4f(f2, f3, f4, f);
		GL11.glLineWidth(l1);
		GL11.glBegin(1);
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x, y2);
		GL11.glVertex2d(x2, y2);
		GL11.glVertex2d(x2, y);
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x2, y);
		GL11.glVertex2d(x, y2);
		GL11.glVertex2d(x2, y2);
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
	}

	public static int getColor(int color) {
		int r = color >> 16 & 0xFF;
		int g = color >> 8 & 0xFF;
		int b = color & 0xFF;
		int a = 255;
		return (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF | (a & 0xFF) << 24;
	}

	public static int darker(int color, float factor) {
		int r = (int) ((float) (color >> 16 & 255) * factor);
		int g = (int) ((float) (color >> 8 & 255) * factor);
		int b = (int) ((float) (color & 255) * factor);
		int a = color >> 24 & 255;
		return (r & 255) << 16 | (g & 255) << 8 | b & 255 | (a & 255) << 24;
	}

	public static void scissor(final double x, final double y, final double width, final double height) {
		int scaleFactor;
		for (scaleFactor = new ScaledResolution(Minecraft.getMinecraft()).getScaleFactor(); scaleFactor < 2
				&& Minecraft.getMinecraft().displayWidth / (scaleFactor + 1) >= 320
				&& Minecraft.getMinecraft().displayHeight / (scaleFactor + 1) >= 240; ++scaleFactor) {
		}
		GL11.glScissor((int) (x * scaleFactor),
				(int) (Minecraft.getMinecraft().displayHeight - (y + height) * scaleFactor),
				(int) (width * scaleFactor), (int) (height * scaleFactor));
	}

	public static void drawSmallOutlineString(String s, float x, float y, int color) {
		GL11.glPushMatrix();
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		mc.fontRendererObj.drawString(s, (int) (x * 2 - 1), (int) (y * 2), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2 + 1), (int) (y * 2), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2 - 1), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2 + 1), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2), color);
		GL11.glPopMatrix();
	}

	public static void drawOutlineString(String s, float x, float y, int color) {
		GL11.glPushMatrix();
		mc.fontRendererObj.drawString(s, (int) (x * 2 - 1), (int) (y * 2), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2 + 1), (int) (y * 2), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2 - 1), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2 + 1), Color.BLACK.getRGB());
		mc.fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2), color);
		GL11.glPopMatrix();
	}

	public static void drawCheck(double x, double y, int lineWidth, int color) {
		start2D();
		GL11.glPushMatrix();
		GL11.glLineWidth(lineWidth);
		setColor(new Color(color));
		GL11.glBegin(GL_LINE_STRIP);
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x + 2, y + 2);
		GL11.glVertex2d(x + 5, y - 2);
		GL11.glEnd();
		GL11.glPopMatrix();
		stop2D();
	}

	public static boolean isHovering(float x, float y, float width, float height, int mouseX, int mouseY) {
		return mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
	}

	public static void drawArrow(double x, double y, int lineWidth, int color, double length) {
		start2D();
		GL11.glPushMatrix();
		GL11.glLineWidth(lineWidth);
		setColor(new Color(color));
		GL11.glBegin(GL_LINE_STRIP);
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x + 3, y + length);
		GL11.glVertex2d(x + 3 * 2, y);
		GL11.glEnd();
		GL11.glPopMatrix();
		stop2D();
	}

	public static void setColor(Color color) {
		float alpha = (color.getRGB() >> 24 & 0xFF) / 255.0F;
		float red = (color.getRGB() >> 16 & 0xFF) / 255.0F;
		float green = (color.getRGB() >> 8 & 0xFF) / 255.0F;
		float blue = (color.getRGB() & 0xFF) / 255.0F;
		GL11.glColor4f(red, green, blue, alpha);
	}

	public static void start2D() {
		glEnable(3042);
		glDisable(3553);
		glBlendFunc(770, 771);
		glEnable(2848);
	}

	public static void stop2D() {
		glEnable(3553);
		glDisable(3042);
		glDisable(2848);
		enableTexture2D();
		disableBlend();
		glColor4f(1, 1, 1, 1);
	}

	// XRay From novoline.cc
	public static void drawSolidBlockESP(BlockPos pos, int color) {
		double xPos = pos.getX() - mc.getRenderManager().renderPosX,
				yPos = pos.getY() - mc.getRenderManager().renderPosY,
				zPos = pos.getZ() - mc.getRenderManager().renderPosZ;
		double height = mc.theWorld.getBlockState(pos).getBlock().getBlockBoundsMaxY()
				- mc.theWorld.getBlockState(pos).getBlock().getBlockBoundsMinY();
		float f = (float) (color >> 16 & 0xFF) / 255.0f;
		float f2 = (float) (color >> 8 & 0xFF) / 255.0f;
		float f3 = (float) (color & 0xFF) / 255.0f;
		float f4 = (float) (color >> 24 & 0xFF) / 255.0f;
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(3553);
		GL11.glDisable(2929);
		GL11.glDepthMask(false);
		GL11.glLineWidth(1.0f);
		GL11.glColor4f(f, f2, f3, f4);
		drawOutlinedBoundingBox(new AxisAlignedBB(xPos, yPos, zPos, xPos + 1.0, yPos + height, zPos + 1.0));
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glDisable(3042);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(2929);
		GlStateManager.disableBlend();
		GL11.glPopMatrix();
	}

	public static void drawLine(BlockPos blockPos, int color) {
		Minecraft mc = Minecraft.getMinecraft();
		double renderPosXDelta = blockPos.getX() - mc.getRenderManager().renderPosX + 0.5D;
		double renderPosYDelta = blockPos.getY() - mc.getRenderManager().renderPosY + 0.5D;
		double renderPosZDelta = blockPos.getZ() - mc.getRenderManager().renderPosZ + 0.5D;
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glEnable(2848);
		GL11.glDisable(2929);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(1.0F);
		float f = (float) (color >> 16 & 0xFF) / 255.0f;
		float f2 = (float) (color >> 8 & 0xFF) / 255.0f;
		float f3 = (float) (color & 0xFF) / 255.0f;
		float f4 = (float) (color >> 24 & 0xFF) / 255.0f;
		GL11.glColor4f(f, f2, f3, f4);
		GL11.glLoadIdentity();
		boolean previousState = mc.gameSettings.viewBobbing;
		mc.gameSettings.viewBobbing = false;
        ((IEntityRenderer)mc.entityRenderer).runorientCamera(mc.timer.renderPartialTicks);
		GL11.glBegin(3);
		GL11.glVertex3d(0.0D, mc.thePlayer.getEyeHeight(), 0.0D);
		GL11.glVertex3d(renderPosXDelta, renderPosYDelta, renderPosZDelta);
		GL11.glVertex3d(renderPosXDelta, renderPosYDelta, renderPosZDelta);
		GL11.glEnd();
		mc.gameSettings.viewBobbing = previousState;
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDisable(2848);
		GL11.glDisable(3042);
		GL11.glPopMatrix();
	}

	public static void drawOutlinedBoundingBox(AxisAlignedBB axisAlignedBB) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(1, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		tessellator.draw();
	}

	public static void color(int color, float alpha) {
		float r = (float) (color >> 16 & 255) / 255.0F;
		float g = (float) (color >> 8 & 255) / 255.0F;
		float b = (float) (color & 255) / 255.0F;
		GlStateManager.color(r, g, b, alpha);
	}

	public static void color(int color) {
		color(color, (float) (color >> 24 & 255) / 255.0F);
	}

	public static void drawGradientRect(float left, float top, float right, float bottom, int startColor,
			int endColor) {
		float f = (float) (startColor >> 24 & 255) / 255.0F;
		float f1 = (float) (startColor >> 16 & 255) / 255.0F;
		float f2 = (float) (startColor >> 8 & 255) / 255.0F;
		float f3 = (float) (startColor & 255) / 255.0F;
		float f4 = (float) (endColor >> 24 & 255) / 255.0F;
		float f5 = (float) (endColor >> 16 & 255) / 255.0F;
		float f6 = (float) (endColor >> 8 & 255) / 255.0F;
		float f7 = (float) (endColor & 255) / 255.0F;
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.shadeModel(7425);
		Tessellator tessellator = Tessellator.getInstance();
		final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
		worldrenderer.pos(right, top, 0).color(f1, f2, f3, f).endVertex();
		worldrenderer.pos(left, top, 0).color(f1, f2, f3, f).endVertex();
		worldrenderer.pos(left, bottom, 0).color(f5, f6, f7, f4).endVertex();
		worldrenderer.pos(right, bottom, 0).color(f5, f6, f7, f4).endVertex();
		tessellator.draw();
		GlStateManager.shadeModel(7424);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
	}

	public static void drawGradientRect(double left, double top, double right, double bottom, boolean sideways,
			int startColor, int endColor) {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glBegin(GL11.GL_QUADS);
		RenderUtil.color(startColor);
		if (sideways) {
			GL11.glVertex2d(left, top);
			GL11.glVertex2d(left, bottom);
			RenderUtil.color(endColor);
			GL11.glVertex2d(right, bottom);
			GL11.glVertex2d(right, top);
		} else {
			GL11.glVertex2d(left, top);
			RenderUtil.color(endColor);
			GL11.glVertex2d(left, bottom);
			GL11.glVertex2d(right, bottom);
			RenderUtil.color(startColor);
			GL11.glVertex2d(right, top);
		}
		GL11.glEnd();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public static void drawCheckeredBackground(float x, float y, float x2, float y2) {
		RenderUtil.drawRect(x, y, x2, y2, ColorUtil.getColor(16777215));
		for (; y < y2; ++y) {
			for (float x1 = x + (float) 0; x1 < x2; x1 += 2.0F) {
				if (x1 <= x2 - 1.0F) {
					RenderUtil.drawRect(x1, y, x1 + 1.0F, y + 1.0F, ColorUtil.getColor(8421504));
				}
			}
		}
	}

	public static void drawScaledCustomSizeModalRect(int x, int y, float u, float v, int uWidth, int vHeight, int width,
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

	public static void quickDrawHead(ResourceLocation skin, int x, int y, int width, int height) {
		mc.getTextureManager().bindTexture(skin);
		drawScaledCustomSizeModalRect(x, y, 8F, 8F, 8, 8, width, height, 64F, 64F);
		drawScaledCustomSizeModalRect(x, y, 40F, 8F, 8, 8, width, height, 64F, 64F);
	}

	public static void drawRect(double left, double top, double right, double bottom, int color) {
		if (left < right) {
			double i = left;
			left = right;
			right = i;
		}

		if (top < bottom) {
			double j = top;
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
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawRect(double left, double top, double right, double bottom, Color color) {
		if (left < right) {
			double i = left;
			left = right;
			right = i;
		}

		if (top < bottom) {
			double j = top;
			top = bottom;
			bottom = j;
		}
		float f3 = (float) (color.getRGB() >> 24 & 255) / 255.0F;
		float f = (float) (color.getRGB() >> 16 & 255) / 255.0F;
		float f1 = (float) (color.getRGB() >> 8 & 255) / 255.0F;
		float f2 = (float) (color.getRGB() & 255) / 255.0F;
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
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawImage(float x, float y, float width, float height, float r, float g, float b,
			ResourceLocation image) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		float f = 1.0f / width;
		float f1 = 1.0f / height;
		GL11.glColor4f(r, g, b, 1.0f);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(x, y + height, 0.0).tex(0.0, height * f1).endVertex();
		worldrenderer.pos(x + width, y + height, 0.0).tex(width * f, height * f1).endVertex();
		worldrenderer.pos(x + width, y, 0.0).tex(width * f, 0.0).endVertex();
		worldrenderer.pos(x, y, 0.0).tex(0.0, 0.0).endVertex();
		tessellator.draw();
	}

	public static void drawImage(ResourceLocation image, float x, float y, int width, int height) {
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		float f = 1.0f / (float) width;
		float f1 = 1.0f / (float) height;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(x, (y + (float) height), 0.0).tex((0.0f * f), ((float) height * f1)).endVertex();
		worldrenderer.pos((x + (float) width), (y + (float) height), 0.0)
				.tex(((float) width * f), ((float) height * f1)).endVertex();
		worldrenderer.pos((x + (float) width), y, 0.0).tex(((float) width * f), (0.0f * f1)).endVertex();
		worldrenderer.pos(x, y, 0.0).tex((0.0f * f), (0.0f * f1)).endVertex();
		tessellator.draw();
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
	}

}
