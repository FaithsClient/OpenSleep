package linxiu.utils.render;

import linxiu.utils.Helper;
import linxiu.utils.math.Vec2f;
import linxiu.utils.math.Vec3f;
import linxiu.utils.render.gl.GLClientState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import tessellate.Tessellation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RenderUtil {
	public static final Tessellation tessellator;
	private static final List<Integer> csBuffer;
	private static final Consumer<Integer> ENABLE_CLIENT_STATE;
	private static final Consumer<Integer> DISABLE_CLIENT_STATE;
	public static float delta;

	static {
		tessellator = Tessellation.createExpanding(4, 1.0f, 2.0f);
		csBuffer = new ArrayList<Integer>();
		ENABLE_CLIENT_STATE = GL11::glEnableClientState;
		DISABLE_CLIENT_STATE = GL11::glEnableClientState;
	}

	public RenderUtil() {
		super();
	}

	public static int width() {
		return new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth();
	}

	public static int height() {
		return new ScaledResolution(Minecraft.getMinecraft()).getScaledHeight();
	}

	public static int getHexRGB(final int hex) {
		return 0xFF000000 | hex;
	}

	public static void drawCustomImage(int x, int y, int width, int height, ResourceLocation image) {
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height,
				(float) width, (float) height);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
	}

	public static void drawRect(float left, float top, float right, float bottom, int color) {

		float e;

		if (left < right) {
			e = left;
			left = right;
			right = e;
		}

		if (top < bottom) {
			e = top;
			top = bottom;
			bottom = e;
		}

		float a = (float) (color >> 24 & 255) / 255.0F;
		float b = (float) (color >> 16 & 255) / 255.0F;
		float c = (float) (color >> 8 & 255) / 255.0F;
		float d = (float) (color & 255) / 255.0F;
		WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.color(b, c, d, a);
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

	public static void pre() {
		GL11.glDisable(2929);
		GL11.glDisable(3553);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
	}

	public static void post() {
		GL11.glDisable(3042);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glColor3d(1.0, 1.0, 1.0);
	}

	public static void startDrawing() {
		GL11.glEnable(3042);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glDisable(3553);
		GL11.glDisable(2929);
		// Helper.mc.entityRenderer.setupCameraTransform(Helper.mc.timer.renderPartialTicks,
		// 0);
	}

	public static void stopDrawing() {
		GL11.glDisable(3042);
		GL11.glEnable(3553);
		GL11.glDisable(2848);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
	}

	public static Color blend(final Color color1, final Color color2, final double ratio) {
		final float r = (float) ratio;
		final float ir = 1.0f - r;
		final float[] rgb1 = new float[3];
		final float[] rgb2 = new float[3];
		color1.getColorComponents(rgb1);
		color2.getColorComponents(rgb2);
		final Color color3 = new Color(rgb1[0] * r + rgb2[0] * ir, rgb1[1] * r + rgb2[1] * ir,
				rgb1[2] * r + rgb2[2] * ir);
		return color3;
	}

	public static void drawLine(final Vec2f start, final Vec2f end, final float width) {
		drawLine(start.getX(), start.getY(), end.getX(), end.getY(), width);
	}

	public static void drawLine(final Vec3f start, final Vec3f end, final float width) {
		drawLine((float) start.getX(), (float) start.getY(), (float) start.getZ(), (float) end.getX(),
				(float) end.getY(), (float) end.getZ(), width);
	}

	public static void drawLine(final float x, final float y, final float x1, final float y1, final float width) {
		drawLine(x, y, 0.0f, x1, y1, 0.0f, width);
	}

	public static void drawLine(final float x, final float y, final float z, final float x1, final float y1,
			final float z1, final float width) {
		GL11.glLineWidth(width);
		setupRender(true);
		setupClientState(GLClientState.VERTEX, true);
		RenderUtil.tessellator.addVertex(x, y, z).addVertex(x1, y1, z1).draw(3);
		setupClientState(GLClientState.VERTEX, false);
		setupRender(false);
	}

	public static void setupClientState(final GLClientState state, final boolean enabled) {
		RenderUtil.csBuffer.clear();
		if (state.ordinal() > 0) {
			RenderUtil.csBuffer.add(state.getCap());
		}
		RenderUtil.csBuffer.add(32884);
		RenderUtil.csBuffer.forEach(enabled ? RenderUtil.ENABLE_CLIENT_STATE : RenderUtil.DISABLE_CLIENT_STATE);
	}

	public static void setupRender(final boolean start) {
		if (start) {
			GlStateManager.enableBlend();
			GL11.glEnable(2848);
			GlStateManager.disableDepth();
			GlStateManager.disableTexture2D();
			GlStateManager.blendFunc(770, 771);
			GL11.glHint(3154, 4354);
		} else {
			GlStateManager.disableBlend();
			GlStateManager.enableTexture2D();
			GL11.glDisable(2848);
			GlStateManager.enableDepth();
		}
		GlStateManager.depthMask(!start);
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

	public static void drawOutlinedBoundingBox(AxisAlignedBB aa) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(1, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa.minX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.minZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.maxX, aa.maxY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.minY, aa.maxZ).endVertex();
		worldRenderer.pos(aa.minX, aa.maxY, aa.maxZ).endVertex();
		tessellator.draw();
	}

	public static void rectangle(double left, double top, double right, double bottom, int color) {
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
		float var11 = (float) (color >> 24 & 255) / 255.0f;
		float var6 = (float) (color >> 16 & 255) / 255.0f;
		float var7 = (float) (color >> 8 & 255) / 255.0f;
		float var8 = (float) (color & 255) / 255.0f;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.color(var6, var7, var8, var11);
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(left, bottom, 0.0).endVertex();
		worldRenderer.pos(right, bottom, 0.0).endVertex();
		worldRenderer.pos(right, top, 0.0).endVertex();
		worldRenderer.pos(left, top, 0.0).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public static void rectangleBordered(double x, double y, double x1, double y1, double width, int internalColor,
			int borderColor) {
		RenderUtil.rectangle(x + width, y + width, x1 - width, y1 - width, internalColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtil.rectangle(x + width, y, x1 - width, y + width, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtil.rectangle(x, y, x + width, y1, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtil.rectangle(x1 - width, y, x1, y1, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtil.rectangle(x + width, y1 - width, x1 - width, y1, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public static void drawGradientRect(double left, double top, double right, double bottom, int startColor,
			int endColor) {
		float f = (float) (startColor >> 24 & 0xFF) / 255.0f;
		float f1 = (float) (startColor >> 16 & 0xFF) / 255.0f;
		float f2 = (float) (startColor >> 8 & 0xFF) / 255.0f;
		float f3 = (float) (startColor & 0xFF) / 255.0f;
		float f4 = (float) (endColor >> 24 & 0xFF) / 255.0f;
		float f5 = (float) (endColor >> 16 & 0xFF) / 255.0f;
		float f6 = (float) (endColor >> 8 & 0xFF) / 255.0f;
		float f7 = (float) (endColor & 0xFF) / 255.0f;
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.shadeModel(7425);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
		worldrenderer.pos(right, top, 0.0).color(f1, f2, f3, f).endVertex();
		worldrenderer.pos(left, top, 0.0).color(f1, f2, f3, f).endVertex();
		worldrenderer.pos(left, bottom, 0.0).color(f5, f6, f7, f4).endVertex();
		worldrenderer.pos(right, bottom, 0.0).color(f5, f6, f7, f4).endVertex();
		tessellator.draw();
		GlStateManager.shadeModel(7424);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
	}

	public static void drawRoundedRect2(float x, float y, float x1, float y1, int borderC, int insideC) {
		R2DUtils.enableGL2D();
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		R2DUtils.drawVLine(x *= 2.0f, (y *= 2.0f) + 1.0f, (y1 *= 2.0f) - 2.0f, borderC);
		R2DUtils.drawVLine((x1 *= 2.0f) - 1.0f, y + 1.0f, y1 - 2.0f, borderC);
		R2DUtils.drawHLine(x + 0.0f, x1 - 1.0f, y, borderC);
		R2DUtils.drawHLine(x + 0.0f, x1 - 1.0f, y1 - 1.0f, borderC);
		R2DUtils.drawHLine(x + 2.0f, x + 1.0f, y + 1.0f, borderC);
		R2DUtils.drawHLine(x1 - 2.0f, x1 - 2.0f, y + 1.0f, borderC);
		R2DUtils.drawHLine(x1 - 2.0f, x1 - 2.0f, y1 - 2.0f, borderC);
		R2DUtils.drawHLine(x + 1.0f, x + 1.0f, y1 - 2.0f, borderC);
		R2DUtils.drawRect(x + 1.0f, y + 1.0f, x1 - 1.0f, y1 - 1.0f, insideC);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
		R2DUtils.disableGL2D();
		Gui.drawRect(0, 0, 0, 0, 0);
	}

	public static class R2DUtils {
		public static void enableGL2D() {
			GL11.glDisable(2929);
			GL11.glEnable(3042);
			GL11.glDisable(3553);
			GL11.glBlendFunc(770, 771);
			GL11.glDepthMask(true);
			GL11.glEnable(2848);
			GL11.glHint(3154, 4354);
			GL11.glHint(3155, 4354);
		}

		public static void disableGL2D() {
			GL11.glEnable(3553);
			GL11.glDisable(3042);
			GL11.glEnable(2929);
			GL11.glDisable(2848);
			GL11.glHint(3154, 4352);
			GL11.glHint(3155, 4352);
		}

		public static void drawRoundedRect(float x, float y, float x1, float y1, int borderC, int insideC) {
			R2DUtils.enableGL2D();
			GL11.glScalef(0.5f, 0.5f, 0.5f);
			R2DUtils.drawVLine(x *= 2.0f, (y *= 2.0f) + 1.0f, (y1 *= 2.0f) - 2.0f, borderC);
			R2DUtils.drawVLine((x1 *= 2.0f) - 1.0f, y + 1.0f, y1 - 2.0f, borderC);
			R2DUtils.drawHLine(x + 2.0f, x1 - 3.0f, y, borderC);
			R2DUtils.drawHLine(x + 2.0f, x1 - 3.0f, y1 - 1.0f, borderC);
			R2DUtils.drawHLine(x + 1.0f, x + 1.0f, y + 1.0f, borderC);
			R2DUtils.drawHLine(x1 - 2.0f, x1 - 2.0f, y + 1.0f, borderC);
			R2DUtils.drawHLine(x1 - 2.0f, x1 - 2.0f, y1 - 2.0f, borderC);
			R2DUtils.drawHLine(x + 1.0f, x + 1.0f, y1 - 2.0f, borderC);
			R2DUtils.drawRect(x + 1.0f, y + 1.0f, x1 - 1.0f, y1 - 1.0f, insideC);
			GL11.glScalef(2.0f, 2.0f, 2.0f);
			R2DUtils.disableGL2D();
			Gui.drawRect(0, 0, 0, 0, 0);
		}

		public static void drawRect(double x2, double y2, double x1, double y1, int color) {
			R2DUtils.enableGL2D();
			R2DUtils.glColor(color);
			R2DUtils.drawRect(x2, y2, x1, y1);
			R2DUtils.disableGL2D();
		}

		private static void drawRect(double x2, double y2, double x1, double y1) {
			GL11.glBegin(7);
			GL11.glVertex2d(x2, y1);
			GL11.glVertex2d(x1, y1);
			GL11.glVertex2d(x1, y2);
			GL11.glVertex2d(x2, y2);
			GL11.glEnd();
		}

		public static void glColor(int hex) {
			float alpha = (float) (hex >> 24 & 255) / 255.0f;
			float red = (float) (hex >> 16 & 255) / 255.0f;
			float green = (float) (hex >> 8 & 255) / 255.0f;
			float blue = (float) (hex & 255) / 255.0f;
			GL11.glColor4f(red, green, blue, alpha);
		}

		public static void drawRect(float x, float y, float x1, float y1, int color) {
			R2DUtils.enableGL2D();
			glColor(color);
			R2DUtils.drawRect(x, y, x1, y1);
			R2DUtils.disableGL2D();
		}

		public static void drawBorderedRect(float x, float y, float x1, float y1, float width, int borderColor) {
			R2DUtils.enableGL2D();
			glColor(borderColor);
			R2DUtils.drawRect(x + width, y, x1 - width, y + width);
			R2DUtils.drawRect(x, y, x + width, y1);
			R2DUtils.drawRect(x1 - width, y, x1, y1);
			R2DUtils.drawRect(x + width, y1 - width, x1 - width, y1);
			R2DUtils.disableGL2D();
		}

		public static void drawBorderedRect(float x, float y, float x1, float y1, int insideC, int borderC) {
			R2DUtils.enableGL2D();
			GL11.glScalef(0.5f, 0.5f, 0.5f);
			R2DUtils.drawVLine(x *= 2.0f, y *= 2.0f, y1 *= 2.0f, borderC);
			R2DUtils.drawVLine((x1 *= 2.0f) - 1.0f, y, y1, borderC);
			R2DUtils.drawHLine(x, x1 - 1.0f, y, borderC);
			R2DUtils.drawHLine(x, x1 - 2.0f, y1 - 1.0f, borderC);
			R2DUtils.drawRect(x + 1.0f, y + 1.0f, x1 - 1.0f, y1 - 1.0f, insideC);
			GL11.glScalef(2.0f, 2.0f, 2.0f);
			R2DUtils.disableGL2D();
		}

		public static void drawGradientRect(float x, float y, float x1, float y1, int topColor, int bottomColor) {
			R2DUtils.enableGL2D();
			GL11.glShadeModel(7425);
			GL11.glBegin(7);
			glColor(topColor);
			GL11.glVertex2f(x, y1);
			GL11.glVertex2f(x1, y1);
			glColor(bottomColor);
			GL11.glVertex2f(x1, y);
			GL11.glVertex2f(x, y);
			GL11.glEnd();
			GL11.glShadeModel(7424);
			R2DUtils.disableGL2D();
		}

		public static void drawHLine(float x, float y, float x1, int y1) {
			if (y < x) {
				float var5 = x;
				x = y;
				y = var5;
			}
			R2DUtils.drawRect(x, x1, y + 1.0f, x1 + 1.0f, y1);
		}

		public static void drawVLine(float x, float y, float x1, int y1) {
			if (x1 < y) {
				float var5 = y;
				y = x1;
				x1 = var5;
			}
			R2DUtils.drawRect(x, y + 1.0f, x + 1.0f, x1, y1);
		}

		public static void drawHLine(float x, float y, float x1, int y1, int y2) {
			if (y < x) {
				float var5 = x;
				x = y;
				y = var5;
			}
			R2DUtils.drawGradientRect(x, x1, y + 1.0f, x1 + 1.0f, y1, y2);
		}

		public static void drawRect(float x, float y, float x1, float y1) {
			GL11.glBegin(7);
			GL11.glVertex2f(x, y1);
			GL11.glVertex2f(x1, y1);
			GL11.glVertex2f(x1, y);
			GL11.glVertex2f(x, y);
			GL11.glEnd();
		}
	}

	public static void drawRoundedRect(double x, double y, double width, double height, double radius, int color) {
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		double x1 = x + width;
		double y1 = y + height;
		float f = (color >> 24 & 0xFF) / 255.0F;
		float f1 = (color >> 16 & 0xFF) / 255.0F;
		float f2 = (color >> 8 & 0xFF) / 255.0F;
		float f3 = (color & 0xFF) / 255.0F;
		GL11.glPushAttrib(0);
		GL11.glScaled(0.5, 0.5, 0.5);

		x *= 2;
		y *= 2;
		x1 *= 2;
		y1 *= 2;

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);

		GL11.glBegin(GL11.GL_POLYGON);

		for (int i = 0; i <= 90; i += 3) {
			GL11.glVertex2d(x + radius + +(Math.sin((i * Math.PI / 180)) * (radius * -1)),
					y + radius + (Math.cos((i * Math.PI / 180)) * (radius * -1)));
		}

		for (int i = 90; i <= 180; i += 3) {
			GL11.glVertex2d(x + radius + (Math.sin((i * Math.PI / 180)) * (radius * -1)),
					y1 - radius + (Math.cos((i * Math.PI / 180)) * (radius * -1)));
		}

		for (int i = 0; i <= 90; i += 3) {
			GL11.glVertex2d(x1 - radius + (Math.sin((i * Math.PI / 180)) * radius),
					y1 - radius + (Math.cos((i * Math.PI / 180)) * radius));
		}

		for (int i = 90; i <= 180; i += 3) {
			GL11.glVertex2d(x1 - radius + (Math.sin((i * Math.PI / 180)) * radius),
					y + radius + (Math.cos((i * Math.PI / 180)) * radius));
		}

		GL11.glEnd();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		GL11.glScaled(2, 2, 2);

		GL11.glPopAttrib();
		GL11.glColor4f(1, 1, 1, 1);
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();

	}

	public static void drawRoundedRect2(final double x, final double y, final double width, final double height,
			double radius, int color) {
		RenderUtil.drawRoundedRect(x, y, width - x, height - y, radius, color);
	}

	public static void drawBorderedRect12(final float x, final float y, final float x2, final float y2, final float l1,
			final int col1, final int col2) {
		Gui.drawRect((int) x, (int) y, (int) x2, (int) y2, col2);
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
		float radius = 2.0f;
		// GL11.glVertex2d((double) x, (double) y);
		// GL11.glVertex2d((double) x, (double) y2);

		GL11.glVertex2d((double) x + 2.2, y);
		GL11.glVertex2d((double) x2 - 2.2, y);
		GL11.glVertex2d((double) x + 2.2, y2);
		GL11.glVertex2d((double) x2 - 2.2, y2);
		for (int i = 0; i <= 90; i += 3) {
			GL11.glVertex2d(x + radius + +(Math.sin((i * Math.PI / 180)) * (radius * -1)),
					y + radius + (Math.cos((i * Math.PI / 180)) * (radius * -1)));
		}

		for (int i = 90; i <= 180; i += 3) {
			GL11.glVertex2d(x + radius + (Math.sin((i * Math.PI / 180)) * (radius * -1)),
					y2 - radius + (Math.cos((i * Math.PI / 180)) * (radius * -1)));
		}

		for (int i = 0; i <= 90; i += 3) {
			GL11.glVertex2d(x2 - radius + (Math.sin((i * Math.PI / 180)) * radius),
					y2 - radius + (Math.cos((i * Math.PI / 180)) * radius));
		}

		for (int i = 90; i <= 180; i += 3) {
			GL11.glVertex2d(x2 - radius + (Math.sin((i * Math.PI / 180)) * radius),
					y + radius + (Math.cos((i * Math.PI / 180)) * radius));
		}

		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);

	}

	public static void color(final double red, final double green, final double blue, final double alpha) {
		GL11.glColor4d(red, green, blue, alpha);
	}

	public void color(final double red, final double green, final double blue) {
		color(red, green, blue, 1);
	}

	public static void color(Color color) {
		if (color == null)
			color = Color.white;
		color(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
	}

	public void color(Color color, final int alpha) {
		if (color == null)
			color = Color.white;
		color(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, 0.5);
	}

	public static void drawRect(double left, double top, double right, double bottom, int colour) {
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		glColor(colour);
		GL11.glBegin(7);
		GL11.glVertex2d(left, bottom);
		GL11.glVertex2d(right, bottom);
		GL11.glVertex2d(right, top);
		GL11.glVertex2d(left, top);
		GL11.glEnd();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static Color glColor(int hex) {
		float alpha = (hex >> 24 & 0xFF) / 256.0f;
		float red = (hex >> 16 & 0xFF) / 255.0f;
		float green = (hex >> 8 & 0xFF) / 255.0f;
		float blue = (hex & 0xFF) / 255.0f;
		GL11.glColor4f(red, green, blue, alpha);
		return new Color(red, green, blue, alpha);
	}

	public static double interpolate(double prev, double cur, float delta) {
		return prev + (cur - prev) * delta;
	}

	public static int rainbow(float seconds, float saturation, float brightness, long index) {
		float hue = ((System.currentTimeMillis() + index) % (int) (seconds * 1000)) / (seconds * 1000);
		return Color.HSBtoRGB(hue, saturation, brightness);
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

	public static void drawSmallString(String s, float x, float y, int color) {
		GL11.glPushMatrix();
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s, x * 2, y * 2, color);
		GL11.glPopMatrix();
	}

	public static void setColor(int colorHex) {
		float alpha = (float) (colorHex >> 24 & 255) / 255.0F;
		float red = (float) (colorHex >> 16 & 255) / 255.0F;
		float green = (float) (colorHex >> 8 & 255) / 255.0F;
		float blue = (float) (colorHex & 255) / 255.0F;
		GL11.glColor4f(red, green, blue, alpha == 0.0F ? 1.0F : alpha);
	}

	public static void enableGL3D(float lineWidth) {
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
		GL11.glLineWidth(lineWidth);
	}

	public static void disableGL3D() {
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

	public static void drawExeterCrossESP(EntityLivingBase entity, int rgb, double x, double y, double z) {
		AxisAlignedBB axisAlignedBB = new AxisAlignedBB(x - 0.4D, y, z - 0.4D, x + 0.4D, y + 2.0D, z + 0.4D);
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);
		GlStateManager.translate(-x, -y, -z);
		enableGL3D(1.0F);
		setColor(rgb);
		drawOutlinedBoundingBox(axisAlignedBB);
		disableGL3D();
		GlStateManager.popMatrix();
	}

	public static void drawWolframEntityESP(EntityLivingBase entity, int rgb, double posX, double posY, double posZ) {
		GL11.glPushMatrix();
		GL11.glTranslated(posX, posY, posZ);
		GL11.glRotatef(-entity.rotationYaw, 0.0F, 1.0F, 0.0F);
		setColor(rgb);
		enableGL3D(1.0F);
		Cylinder c = new Cylinder();
		GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
		c.setDrawStyle(100011);
		c.draw(0.5F, 0.5F, entity.height + 0.1F, 18, 1);
		disableGL3D();
		GL11.glPopMatrix();
	}

	public static void prepareScissorBox(float x, float y, float x2, float y2) {
		ScaledResolution scale = new ScaledResolution(Minecraft.getMinecraft());
		int factor = scale.getScaleFactor();
		GL11.glScissor((int) (x * (float) factor), (int) (((float) scale.getScaledHeight() - y2) * (float) factor),
				(int) ((x2 - x) * (float) factor), (int) ((y2 - y) * (float) factor));
	}

	public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
		float f = (col1 >> 24 & 0xFF) / 255.0F;
		float f1 = (col1 >> 16 & 0xFF) / 255.0F;
		float f2 = (col1 >> 8 & 0xFF) / 255.0F;
		float f3 = (col1 & 0xFF) / 255.0F;

		float f4 = (col2 >> 24 & 0xFF) / 255.0F;
		float f5 = (col2 >> 16 & 0xFF) / 255.0F;
		float f6 = (col2 >> 8 & 0xFF) / 255.0F;
		float f7 = (col2 & 0xFF) / 255.0F;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glShadeModel(7425);

		GL11.glPushMatrix();
		GL11.glBegin(7);
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glVertex2d(left, top);
		GL11.glVertex2d(left, bottom);

		GL11.glColor4f(f5, f6, f7, f4);
		GL11.glVertex2d(right, bottom);
		GL11.glVertex2d(right, top);
		GL11.glEnd();
		GL11.glPopMatrix();

		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
		GL11.glShadeModel(7424);
		GL11.glColor4d(255, 255, 255, 255);
	}

	public static double getAnimationStateSmooth(double target, double current, double speed) {
		boolean larger = target > current;
		if (speed < 0.0) {
			speed = 0.0;
		} else if (speed > 1.0) {
			speed = 1.0;
		}
		if (target == current) {
			return target;
		}
		double dif = Math.max(target, current) - Math.min(target, current);
		double factor = dif * speed;
		if (factor < 0.1) {
			factor = 0.1;
		}
		if (larger) {
			if (current + factor > target) {
				current = target;
			} else {
				current += factor;
			}
		} else {
			if (current - factor < target) {
				current = target;
			} else {
				current -= factor;
			}
		}
		return current;
	}

	public static void drawSmallOutlineString(String s, float x, float y, int color) {
		GL11.glPushMatrix();
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (x * 2 - 1), (int) (y * 2), Color.BLACK.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (x * 2 + 1), (int) (y * 2), Color.BLACK.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2 - 1), Color.BLACK.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2 + 1), Color.BLACK.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (x * 2), (int) (y * 2), color);
		GL11.glPopMatrix();
	}

    public static void glColor(Color hex) {
        float alpha = (float) (hex.getRGB() >> 24 & 255) / 255.0f;
        float red = (float) (hex.getRGB() >> 16 & 255) / 255.0f;
        float green = (float) (hex.getRGB() >> 8 & 255) / 255.0f;
        float blue = (float) (hex.getRGB() & 255) / 255.0f;
        GL11.glColor4f(red, green, blue, alpha == 0.0f ? 1.0f : alpha);
    }

	public static void drawTraces(Entity entity, Color color) {

		double x = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * Helper.getTimer().renderPartialTicks
				- Minecraft.getMinecraft().getRenderManager().renderPosX);
		double y = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * Helper.getTimer().renderPartialTicks
				- Minecraft.getMinecraft().getRenderManager().renderPosY);
		double z = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * Helper.getTimer().renderPartialTicks
				- Minecraft.getMinecraft().getRenderManager().renderPosZ);

		Vec3 eyeVector = new Vec3(0.0, 0.0, 1.0)
				.rotatePitch((float) -Math.toRadians(Minecraft.getMinecraft().thePlayer.rotationPitch))
				.rotateYaw((float) -Math.toRadians(Minecraft.getMinecraft().thePlayer.rotationYaw));

		RenderUtil.glColor(color);

		GL11.glVertex3d(eyeVector.xCoord, Minecraft.getMinecraft().thePlayer.eyeHeight + eyeVector.yCoord,
				eyeVector.zCoord);
		GL11.glVertex3d(x, y, z);
		GL11.glVertex3d(x, y, z);
		GL11.glVertex3d(x, y + entity.height, z);
	}

    public static void enableSmoothLine(float width) {//瞎几把起的名�?
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

    public static void disableSmoothLine() {//瞎鸡巴起的名�?
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

    public static boolean isHovering(float mouseX, float mouseY, float xLeft, float yUp, float xRight, float yBottom) {
        return mouseX > xLeft && mouseX < xRight && mouseY > yUp && mouseY < yBottom;
    }
}
