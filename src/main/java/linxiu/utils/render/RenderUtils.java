package linxiu.utils.render;

import linxiu.api.events.rendering.EventRender3D;
import linxiu.injection.interfaces.IEntityRenderer;
import linxiu.injection.interfaces.IRenderManager;
import linxiu.module.modules.combat.KillAura;
import linxiu.utils.Helper;
import linxiu.utils.timer.TimeHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.util.glu.Cylinder;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static net.minecraft.client.renderer.GlStateManager.disableBlend;
import static net.minecraft.client.renderer.GlStateManager.enableTexture2D;
import static org.lwjgl.opengl.GL11.*;

public final class RenderUtils {
	private static final Minecraft mc = Minecraft.getMinecraft();
	private static final Frustum frustrum = new Frustum();
	public static double healthPercent;
	private static final double lastP = 0;
	private static final double diffP = 0;
	private static final Map<Integer, Boolean> glCapMap = new HashMap<>();
	static int animationX;
	private static final TimeHelper animationTimer = new TimeHelper();

	public static double interpolate(double current, double old, double scale) {
		return old + (current - old) * scale;
	}

	public static boolean isInViewFrustrum(Entity entity) {
		return RenderUtils.isInViewFrustrum(entity.getEntityBoundingBox()) || entity.ignoreFrustumCheck;
	}

	private static boolean isInViewFrustrum(AxisAlignedBB bb) {
		Entity current = mc.getRenderViewEntity();
		frustrum.setPosition(current.posX, current.posY, current.posZ);
		return frustrum.isBoundingBoxInFrustum(bb);
	}

	public static void drawImg(ResourceLocation loc, double posX, double posY, double width, double height) {
		mc.getTextureManager().bindTexture(loc);
		float f = 1.0f / (float) width;
		float f1 = 1.0f / (float) height;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(posX, posY + height, 0.0).tex(0.0f * f, (0.0f + (float) height) * f1).endVertex();
		worldrenderer.pos(posX + width, posY + height, 0.0)
				.tex((0.0f + (float) width) * f, (0.0f + (float) height) * f1).endVertex();
		worldrenderer.pos(posX + width, posY, 0.0).tex((0.0f + (float) width) * f, 0.0f * f1).endVertex();
		worldrenderer.pos(posX, posY, 0.0).tex(0.0f * f, 0.0f * f1).endVertex();
		tessellator.draw();
	}

	public static void drawRect(float left, float top, float right, float bottom, int col1) {
		final float f = (col1 >> 24 & 0xFF) / 255.0F, // @off
				f1 = (col1 >> 16 & 0xFF) / 255.0F, f2 = (col1 >> 8 & 0xFF) / 255.0F, f3 = (col1 & 0xFF) / 255.0F; // @on

		glEnable(3042);
		glDisable(3553);
		GL11.glBlendFunc(770, 771);
		glEnable(2848);

		GL11.glPushMatrix();
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glBegin(7);
		GL11.glVertex2d(right, top);
		GL11.glVertex2d(left, top);
		GL11.glVertex2d(left, bottom);
		GL11.glVertex2d(right, bottom);
		GL11.glEnd();
		GL11.glPopMatrix();

		glEnable(3553);
		glDisable(3042);
		glDisable(2848);
		enableTexture2D();
		disableBlend();
		GL11.glColor4f(1, 1, 1, 1);
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

	public static void prepareScissorBox(float x, float y, float x2, float y2) {
		ScaledResolution scale = new ScaledResolution(mc);
		int factor = scale.getScaleFactor();
		GL11.glScissor((int) (x * (float) factor), (int) (((float) scale.getScaledHeight() - y2) * (float) factor),
				(int) ((x2 - x) * (float) factor), (int) ((y2 - y) * (float) factor));
	}

	public static void drawBorderedRect2(final float x, final float y, final float x2, final float y2, final float l1,
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

	public static void startSmooth() {
		GL11.glEnable(2848);
		GL11.glEnable(2881);
		GL11.glEnable(2832);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glHint(3154, 4354);
		GL11.glHint(3155, 4354);
		GL11.glHint(3153, 4354);
	}

	public static void endSmooth() {
		GL11.glDisable(2848);
		GL11.glDisable(2881);
		GL11.glEnable(2832);
	}

	public static void drawMenuBackground(ScaledResolution sr) {
		RenderUtils.drawRect(0, 0, sr.getScaledWidth(), sr.getScaledHeight(), new Color(34, 34, 34).getRGB());

		RenderUtils.drawImg(new ResourceLocation("client/images/background.png"), 0, 0, sr.getScaledWidth(),
				sr.getScaledHeight());
	}

	public static void drawBorderedRect(double left, double top, double right, double bottom, double borderWidth,
			int insideColor, int borderColor, boolean borderIncludedInBounds) {
		drawRect(left - (!borderIncludedInBounds ? borderWidth : 0), top - (!borderIncludedInBounds ? borderWidth : 0),
				right + (!borderIncludedInBounds ? borderWidth : 0),
				bottom + (!borderIncludedInBounds ? borderWidth : 0), borderColor);
		drawRect(left + (borderIncludedInBounds ? borderWidth : 0), top + (borderIncludedInBounds ? borderWidth : 0),
				right - ((borderIncludedInBounds ? borderWidth : 0)),
				bottom - ((borderIncludedInBounds ? borderWidth : 0)), insideColor);
	}

	public static void drawOutline(double x, double y, double width, double height, double lineWidth, int color) {
		RenderUtils.drawRect(x, y, x + width, y + lineWidth, color);
		RenderUtils.drawRect(x, y, x + lineWidth, y + height, color);
		RenderUtils.drawRect(x, y + height - lineWidth, x + width, y + height, color);
		RenderUtils.drawRect(x + width - lineWidth, y, x + width, y + height, color);
	}

	public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
		float f = (col1 >> 24 & 255) / 255.0f;
		float f1 = (col1 >> 16 & 255) / 255.0f;
		float f2 = (col1 >> 8 & 255) / 255.0f;
		float f3 = (col1 & 255) / 255.0f;
		float f4 = (col2 >> 24 & 255) / 255.0f;
		float f5 = (col2 >> 16 & 255) / 255.0f;
		float f6 = (col2 >> 8 & 255) / 255.0f;
		float f7 = (col2 & 255) / 255.0f;
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
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawRect(double left, double top, double right, double bottom, float opacity) {
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

		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.color(.1F, .1F, .1F, opacity);
		worldrenderer.begin(7, DefaultVertexFormats.POSITION);
		worldrenderer.pos(left, bottom, 0.0D).endVertex();
		worldrenderer.pos(right, bottom, 0.0D).endVertex();
		worldrenderer.pos(right, top, 0.0D).endVertex();
		worldrenderer.pos(left, top, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawBoundingBox(AxisAlignedBB aa2) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.minX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.minZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.maxY, aa2.maxZ).endVertex();
		worldRenderer.pos(aa2.maxX, aa2.minY, aa2.maxZ).endVertex();
		tessellator.draw();
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
		RenderUtils.drawBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width));
		GL11.glLineWidth(lineWdith);
		GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
		RenderUtils
				.drawOutlinedBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width));
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glPopMatrix();
	}

	public static void drawblock(double a2, double a22, double a3, int a4, int a5, float a6) {
		float a7 = (float) (a4 >> 24 & 0xFF) / 255.0f;
		float a8 = (float) (a4 >> 16 & 0xFF) / 255.0f;
		float a9 = (float) (a4 >> 8 & 0xFF) / 255.0f;
		float a10 = (float) (a4 & 0xFF) / 255.0f;
		float a11 = (float) (a5 >> 24 & 0xFF) / 255.0f;
		float a12 = (float) (a5 >> 16 & 0xFF) / 255.0f;
		float a13 = (float) (a5 >> 8 & 0xFF) / 255.0f;
		float a14 = (float) (a5 & 0xFF) / 255.0f;
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glDisable(2929);
		GL11.glDepthMask(false);
		GL11.glColor4f(a8, a9, a10, a7);
		drawOutlinedBoundingBox(new AxisAlignedBB(a2, a22, a3, a2 + 1.0, a22 + 1.0, a3 + 1.0));
		GL11.glLineWidth(a6);
		GL11.glColor4f(a12, a13, a14, a11);
		drawOutlinedBoundingBox(new AxisAlignedBB(a2, a22, a3, a2 + 1.0, a22 + 1.0, a3 + 1.0));
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDepthMask(true);
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
		RenderUtils.rectangle(x + width, y + width, x1 - width, y1 - width, internalColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtils.rectangle(x + width, y, x1 - width, y + width, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtils.rectangle(x, y, x + width, y1, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtils.rectangle(x1 - width, y, x1, y1, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		RenderUtils.rectangle(x + width, y1 - width, x1 - width, y1, borderColor);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public static void color(int color) {
		float f2 = (float) (color >> 24 & 0xFF) / 255.0f;
		float f1 = (float) (color >> 16 & 0xFF) / 255.0f;
		float f22 = (float) (color >> 8 & 0xFF) / 255.0f;
		float f3 = (float) (color & 0xFF) / 255.0f;
		GL11.glColor4f(f1, f22, f3, f2);
	}

	public static void arcEllipse(final float x, final float y, float start, float end, final float w, final float h,
			final int color) {
		GlStateManager.color(0.0f, 0.0f, 0.0f);
		GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.0f);
		float temp = 0.0f;
		if (start > end) {
			temp = end;
			end = start;
			start = temp;
		}
		final float var11 = (color >> 24 & 0xFF) / 255.0f;
		final float var12 = (color >> 16 & 0xFF) / 255.0f;
		final float var13 = (color >> 8 & 0xFF) / 255.0f;
		final float var14 = (color & 0xFF) / 255.0f;
		final Tessellator var15 = Tessellator.getInstance();
		final WorldRenderer var16 = var15.getWorldRenderer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.color(var12, var13, var14, var11);
		if (var11 > 0.5f) {
			GL11.glEnable(2848);
			GL11.glLineWidth(2.0f);
			GL11.glBegin(3);
			for (float i = end; i >= start; i -= 4.0f) {
				final float ldx = (float) Math.cos(i * 3.141592653589793 / 180.0) * w * 1.001f;
				final float ldy = (float) Math.sin(i * 3.141592653589793 / 180.0) * h * 1.001f;
				GL11.glVertex2f(x + ldx, y + ldy);
			}
			GL11.glEnd();
			GL11.glDisable(2848);
		}
		GL11.glBegin(6);
		for (float i = end; i >= start; i -= 4.0f) {
			final float ldx = (float) Math.cos(i * 3.141592653589793 / 180.0) * w;
			final float ldy = (float) Math.sin(i * 3.141592653589793 / 180.0) * h;
			GL11.glVertex2f(x + ldx, y + ldy);
		}
		GL11.glEnd();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void arc(final float x, final float y, final float start, final float end, final float radius,
			final int color) {
		arcEllipse(x, y, start, end, radius, radius, color);
	}

	public static void circle(final float x, final float y, final float radius, final int fill) {
		arc(x, y, 0.0f, 360.0f, radius, fill);
	}

	public static void drawRoundedRect(float x, float y, float x2, float y2, final float round, final int color) {
		x += (float) (round / 2.0f + 0.5);
		y += (float) (round / 2.0f + 0.5);
		x2 -= (float) (round / 2.0f + 0.5);
		y2 -= (float) (round / 2.0f + 0.5);
		Gui.drawRect((int) x, (int) y, (int) x2, (int) y2, color);
		circle(x2 - round / 2.0f, y + round / 2.0f, round, color);
		circle(x + round / 2.0f, y2 - round / 2.0f, round, color);
		circle(x + round / 2.0f, y + round / 2.0f, round, color);
		circle(x2 - round / 2.0f, y2 - round / 2.0f, round, color);
		Gui.drawRect((int) (x - round / 2.0f - 0.5f), (int) (y + round / 2.0f), (int) x2, (int) (y2 - round / 2.0f),
				color);
		Gui.drawRect((int) x, (int) (y + round / 2.0f), (int) (x2 + round / 2.0f + 0.5f), (int) (y2 - round / 2.0f),
				color);
		Gui.drawRect((int) (x + round / 2.0f), (int) (y - round / 2.0f - 0.5f), (int) (x2 - round / 2.0f),
				(int) (y2 - round / 2.0f), color);
		Gui.drawRect((int) (x + round / 2.0f), (int) y, (int) (x2 - round / 2.0f), (int) (y2 + round / 2.0f + 0.5f),
				color);
	}

	public static void drawImage(ResourceLocation image, int x, int y, int width, int height, Color color) {
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f((float) color.getRed() / 255.0f, (float) color.getBlue() / 255.0f,
				(float) color.getRed() / 255.0f, 1.0f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
	}

	public static boolean SetCustomYaw = false;
	public static float CustomYaw = 0;

	public static void setCustomYaw(float customYaw) {
		CustomYaw = customYaw;
		SetCustomYaw = true;
		mc.thePlayer.rotationYawHead = customYaw;
	}

	public static void resetPlayerYaw() {
		SetCustomYaw = false;
	}

	public static float getCustomYaw() {

		return CustomYaw;

	}

	public static boolean SetCustomPitch = false;
	public static float CustomPitch = 0;

	public static void setCustomPitch(float customPitch) {
		CustomPitch = customPitch;
		SetCustomPitch = true;
	}

	public static void resetPlayerPitch() {
		SetCustomPitch = false;
	}

	public static float getCustomPitch() {

		return CustomPitch;

	}

	public static void glColor(final Color color) {
		final float red = color.getRed() / 255F;
		final float green = color.getGreen() / 255F;
		final float blue = color.getBlue() / 255F;
		final float alpha = color.getAlpha() / 255F;

		GlStateManager.color(red, green, blue, alpha);
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

	public static void drawEntityOnScreen(int posX, int posY, int scale, EntityLivingBase ent) {
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
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(0, 1.0F, 0.0F, 0.0F);
		ent.renderYawOffset = (10 * ent.ticksExisted) % 360;
		ent.rotationYaw = (10 * ent.ticksExisted) % 360;
		ent.rotationPitch = 0;
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

	public static void renderItemStack(ItemStack stack, int x, int y) {
		GlStateManager.pushMatrix();
		GlStateManager.depthMask(true);
		GlStateManager.clear(256);
		RenderHelper.enableStandardItemLighting();
		Minecraft.getMinecraft().getRenderItem().zLevel = -150.0f;
		GlStateManager.disableDepth();
		GlStateManager.disableTexture2D();
		GlStateManager.enableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
		GlStateManager.enableLighting();
		GlStateManager.enableDepth();
		Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(stack, x, y);
		Minecraft.getMinecraft().getRenderItem().renderItemOverlays(Minecraft.getMinecraft().fontRendererObj, stack, x,
				y);
		Minecraft.getMinecraft().getRenderItem().zLevel = 0.0f;
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableCull();
		GlStateManager.enableAlpha();
		GlStateManager.disableBlend();
		GlStateManager.disableLighting();
		GlStateManager.disableDepth();
		GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static int getColorFromPercentage(float current, float max) {
		float percentage = (current / max) / 3;
		return Color.HSBtoRGB(percentage, 1.0F, 1.0F);
	}

	// Alerithe code do not question
	// - From Alerithe :)
	public static void drawRectSized(float x, float y, float width, float height, int color) {
		drawRect(x, y, x + width, y + height, color);
	}

	// Linear interpolation, https://en.wikipedia.org/wiki/Linear_interpolation
	// - Also from Alerithe
	public static double lerp(double v0, double v1, double t) {
		return (1.0 - t) * v0 + t * v1;
	}

	public static double interpolate(double old, double now, float partialTicks) {
		return old + (now - old) * partialTicks;
	}

	public static float interpolate(float old, float now, float partialTicks) {
		return old + (now - old) * partialTicks;
	}

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

	public static void glColor(int hex) {
		float alpha = (float) (hex >> 24 & 255) / 255.0F;
		float red = (float) (hex >> 16 & 255) / 255.0F;
		float green = (float) (hex >> 8 & 255) / 255.0F;
		float blue = (float) (hex & 255) / 255.0F;
		GL11.glColor4f(red, green, blue, alpha);
	}

	public static void drawBorderedRectReliant(float x, float y, float x1, float y1, float lineWidth, int inside,
			int border) {
		enableGL2D();
		drawRect(x, y, x1, y1, inside);
		glColor(border);
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(lineWidth);
		GL11.glBegin(3);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x, y1);
		GL11.glVertex2f(x1, y1);
		GL11.glVertex2f(x1, y);
		GL11.glVertex2f(x, y);
		GL11.glEnd();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		disableGL2D();
	}

	public static void disableSmoothLine() {
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

	public static void enableSmoothLine(float width) {
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

	public static void TScylinder1(final Entity player, final double x, final double y, final double z,
			final double range, int s, int color) {
		Cylinder c = new Cylinder();
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		glColor(0);// color4f
		enableSmoothLine(3.5f);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
		glColor(color);
		GL11.glBegin(2);
		GL11.glEnd();
		c.draw((float) (range + 0.25), (float) (range + 0.25), 0.0f, s, 0);
		c.setDrawStyle(100011);

		disableSmoothLine();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GlStateManager.translate(x, y, z);
		enableSmoothLine(3.5f);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
		glColor(color);
		GL11.glBegin(2);
		GL11.glEnd();
		c.draw((float) (range + 0.25), (float) (range + 0.25), 0.0f, s, 0);

		disableSmoothLine();
		GlStateManager.resetColor();
		GL11.glPopMatrix();
	}

	public static void TScylinder2(final Entity player, final double x, final double y, final double z,
			final double range, int s, int color) {
		Cylinder c = new Cylinder();
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		glColor(0);// color4f
		enableSmoothLine(3.5f);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
		glColor(color);
		GL11.glBegin(3);
		GL11.glEnd();
		c.draw((float) (range + 0.25), (float) (range + 0.25), 0.0f, s, 0);
		c.setDrawStyle(100011);

		disableSmoothLine();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GlStateManager.translate(x, y, z);
		enableSmoothLine(3.5f);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
		glColor(color);
		GL11.glBegin(3);
		GL11.glEnd();
		c.draw((float) (range + 0.25), (float) (range + 0.25), 0.0f, s, 0);

		disableSmoothLine();
		GlStateManager.resetColor();
		GL11.glPopMatrix();
	}

	public static void drawSelectionBoundingBox(AxisAlignedBB boundingBox) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).endVertex();
		worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).endVertex();
		worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(3, DefaultVertexFormats.POSITION);
		worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).endVertex();
		worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).endVertex();
		worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(1, DefaultVertexFormats.POSITION);
		worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).endVertex();
		worldRenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).endVertex();
		worldRenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).endVertex();
		worldRenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).endVertex();
		tessellator.draw();
	}

	public static void drawImage(ResourceLocation image, int x, int y, int width, int height) {
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
	}

	public static int fadeTo(final int startColor, final int endColor, final float progress) {
		final float invert = 1.0f - progress;
		final int r = (int) ((startColor >> 16 & 0xFF) * invert + (endColor >> 16 & 0xFF) * progress);
		final int g = (int) ((startColor >> 8 & 0xFF) * invert + (endColor >> 8 & 0xFF) * progress);
		final int b = (int) ((startColor & 0xFF) * invert + (endColor & 0xFF) * progress);
		final int a = (int) ((startColor >> 24 & 0xFF) * invert + (endColor >> 24 & 0xFF) * progress);
		return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF);
	}

	public static void enableBlending() {
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
	}

	public static void color1(int color) {

		GL11.glColor4ub((byte) (color >> 16 & 0xFF), (byte) (color >> 8 & 0xFF), (byte) (color & 0xFF),
				(byte) (color >> 24 & 0xFF));
	}

	public static void glColor2(Color color) {
		float red = (float) color.getRed() / 255.0F;
		float green = (float) color.getGreen() / 255.0F;
		float blue = (float) color.getBlue() / 255.0F;
		float alpha = (float) color.getAlpha() / 255.0F;
		GlStateManager.color(red, green, blue, alpha);
	}

	public static void drawAxisAlignedBB(AxisAlignedBB axisAlignedBB, Color color) {
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(3042);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(3553);
		GL11.glDisable(2929);
		GL11.glDepthMask(false);
		GL11.glColor4f(color.getRed() / 255.F, color.getGreen() / 255.F, color.getBlue() / 255.F, 0.25F);
		drawFilledBox(axisAlignedBB);
		GlStateManager.resetColor();
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
	}

	public static void drawFilledBox(AxisAlignedBB axisAlignedBB) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
		worldRenderer.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
		tessellator.draw();
	}

	public static void pre3D() {
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glShadeModel(7425);
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glDisable(2929);
		GL11.glDisable(2896);
		GL11.glDepthMask(false);
		GL11.glHint(3154, 4354);
	}

	public static void post3D() {
		GL11.glDepthMask(true);
		GL11.glEnable(2929);
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (!GL11.glIsEnabled(2896)) {
			// GL11.glEnable(2896);
		}

	}

	public static void drawLine(BlockPos var0, int var1) {
		double renderPosXDelta = (double) var0.getX() - ((IRenderManager) mc.getRenderManager()).getRenderPosX() + 0.5D;
		double renderPosYDelta = (double) var0.getY() - ((IRenderManager) mc.getRenderManager()).getRenderPosY() + 0.5D;
		double renderPosZDelta = (double) var0.getZ() - ((IRenderManager) mc.getRenderManager()).getRenderPosZ() + 0.5D;
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glEnable(2848);
		GL11.glDisable(2929);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(1.0F);
		float blockPos9 = (float) (Minecraft.getMinecraft().thePlayer.posX - (double) var0.getX());
		float blockPos7 = (float) (Minecraft.getMinecraft().thePlayer.posY - (double) var0.getY());
		float f = (float) (var1 >> 16 & 0xFF) / 255.0f;
		float f2 = (float) (var1 >> 8 & 0xFF) / 255.0f;
		float f3 = (float) (var1 & 0xFF) / 255.0f;
		float f4 = (float) (var1 >> 24 & 0xFF) / 255.0f;
		GL11.glColor4f(f, f2, f3, f4);
		GL11.glLoadIdentity();
		boolean previousState = mc.gameSettings.viewBobbing;
		mc.gameSettings.viewBobbing = false;
		((IEntityRenderer) mc.entityRenderer).runorientCamera(Helper.getTimer().renderPartialTicks);
		GL11.glBegin(3);
		GL11.glVertex3d(0.0D, Minecraft.getMinecraft().thePlayer.getEyeHeight(), 0.0D);
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

	public static void drawSolidBlockESP(BlockPos var0, int var1) {
		double var2 = (double) var0.getX() - ((IRenderManager) mc.getRenderManager()).getRenderPosX();
		double var4 = (double) var0.getY() - ((IRenderManager) mc.getRenderManager()).getRenderPosY();
		double var6 = (double) var0.getZ() - ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
		double var8 = mc.theWorld.getBlockState(var0).getBlock().getBlockBoundsMaxY()
				- mc.theWorld.getBlockState(var0).getBlock().getBlockBoundsMinY();
		float var10 = (float) (var1 >> 16 & 255) / 255.0F;
		float var11 = (float) (var1 >> 8 & 255) / 255.0F;
		float var12 = (float) (var1 & 255) / 255.0F;
		float var13 = (float) (var1 >> 24 & 255) / 255.0F;
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glDisable(3553);
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(3553);
		GL11.glDisable(2929);
		GL11.glDepthMask(false);
		GL11.glLineWidth(1.0F);
		GL11.glColor4f(var10, var11, var12, var13);
		drawOutlinedBoundingBox(new AxisAlignedBB(var2, var4, var6, var2 + 1.0D, var4 + var8, var6 + 1.0D));
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glDisable(3042);
		GL11.glEnable(3553);
		GL11.glDisable(2848);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
		GlStateManager.disableBlend();
		GL11.glPopMatrix();
	}

	public static void drawBorderedRect(double x, double y, double x2, double y2, float l1, int col1, int col2) {
		drawRect((float) x, (float) y, (float) x2, (float) y2, col2);

		final float f = (col1 >> 24 & 0xFF) / 255.0F, // @off
				f1 = (col1 >> 16 & 0xFF) / 255.0F, f2 = (col1 >> 8 & 0xFF) / 255.0F, f3 = (col1 & 0xFF) / 255.0F; // @on

		glEnable(3042);
		glDisable(3553);
		GL11.glBlendFunc(770, 771);
		glEnable(2848);

		GL11.glPushMatrix();
		GL11.glColor4f(f1, f2, f3, f);
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
		enableTexture2D();
		disableBlend();
		GL11.glPopMatrix();
		GL11.glColor4f(255, 1, 1, 255);
		glEnable(3553);
		glDisable(3042);
		glDisable(2848);
	}

	public static void drawExhi(EntityLivingBase it, EventRender3D event) {
		final float radius = 0.25f;
		final float side = 4.0f;
		GL11.glPushMatrix();
		final double n = it.lastTickPosX + (it.posX - it.lastTickPosX) * event.getPartialTicks();
		final double n2 = n - ((IRenderManager) mc.getRenderManager()).getVieWerPosX();
		final double n3 = it.lastTickPosY + (it.posY - it.lastTickPosY) * event.getPartialTicks();
		final double n4 = n3 - ((IRenderManager) mc.getRenderManager()).getVieWerPosY() + it.height * 1.1;
		final double n5 = it.lastTickPosZ + (it.posZ - it.lastTickPosZ) * event.getPartialTicks();
		GL11.glTranslated(n2, n4, n5 - ((IRenderManager) mc.getRenderManager()).getVieWerPosZ());
		GL11.glRotatef(-it.width, 0.0f, 1.0f, 0.0f);
		glColor((it.hurtTime <= 0) ? new Color(80, 255, 80, 80).getRGB() : new Color(255, 0, 0, 80).getRGB());
		enableSmoothLine(1.5f);
		final Cylinder c = new Cylinder();
		GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
		c.draw(0.0f, radius, 0.3f, (int) side, 1);
		c.setDrawStyle(100012);
		GL11.glTranslated(0.0, 0.0, 0.3);
		c.draw(radius, 0.0f, 0.3f, (int) side, 1);
		GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
		GL11.glTranslated(0.0, 0.0, -0.3);
		c.draw(0.0f, radius, 0.3f, (int) side, 1);
		GL11.glTranslated(0.0, 0.0, 0.3);
		c.draw(radius, 0.0f, 0.3f, (int) side, 1);
		disableSmoothLine();
		GL11.glPopMatrix();
	}

	public static void drawPlatform(final Entity entity, final Color color) {
		final double x = entity.lastTickPosX
				+ (entity.posX - entity.lastTickPosX) * Helper.getTimer().renderPartialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosX();
		final double y = entity.lastTickPosY
				+ (entity.posY - entity.lastTickPosY) * Helper.getTimer().renderPartialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosY();
		final double z = entity.lastTickPosZ
				+ (entity.posZ - entity.lastTickPosZ) * Helper.getTimer().renderPartialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
		final AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox()
				.offset(-entity.posX, -entity.posY, -entity.posZ).offset(x, y, z);
		drawAxisAlignedBB(new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY - 0.1, axisAlignedBB.minZ,
				axisAlignedBB.maxX + 0.1, axisAlignedBB.maxY + 0.2, axisAlignedBB.maxZ + 0.1), color);
	}

	public static void drawAuraMark(final Entity entity, final Color color) {
		if (KillAura.target != null) {
			final double x = entity.lastTickPosX
					+ (entity.posX - entity.lastTickPosX) * Helper.getTimer().renderPartialTicks
					- ((IRenderManager) mc.getRenderManager()).getRenderPosX();
			final double y = entity.lastTickPosY
					+ (entity.posY - entity.lastTickPosY) * Helper.getTimer().renderPartialTicks
					- ((IRenderManager) mc.getRenderManager()).getRenderPosY();
			final double z = entity.lastTickPosZ
					+ (entity.posZ - entity.lastTickPosZ) * Helper.getTimer().renderPartialTicks
					- ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
			final AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox()
					.offset(-entity.posX, -entity.posY, -entity.posZ).offset(x, y - 0.41, z);
			drawAxisAlignedBB(new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.maxY + 0.2, axisAlignedBB.minZ,
					axisAlignedBB.maxX, axisAlignedBB.maxY + 0.26, axisAlignedBB.maxZ), color);
		}
	}

	private static void drawBoundTexture(float x, float y, float u, float v, float uWidth, float vHeight, int width,
			int height, float tileWidth, float tileHeight) {
		float f = 1.0F / tileWidth;
		float f1 = 1.0F / tileHeight;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(x, y + height, 0.0D).tex(u * f, (v + vHeight) * f1).endVertex();
		worldrenderer.pos(x + width, y + height, 0.0D).tex((u + uWidth) * f, (v + vHeight) * f1).endVertex();
		worldrenderer.pos(x + width, y, 0.0D).tex((u + uWidth) * f, v * f1).endVertex();
		worldrenderer.pos(x, y, 0.0D).tex(u * f, v * f1).endVertex();
		tessellator.draw();
	}

	public static void drawScaledCustomSizeModalRect(float x, float y, float u, float v, int uWidth, int vHeight,
			int width, int height, float tileWidth, float tileHeight) {
		drawBoundTexture(x, y, u, v, uWidth, vHeight, width, height, tileWidth, tileHeight);
	}

	public static void drawPing(int x, int x0, int y, NetworkPlayerInfo playerInfo) {
		mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
		int offset = 0;
		int i = 0;
		if (playerInfo != null) {
			if (playerInfo.getResponseTime() < 0)
				offset = 5;
			if (playerInfo.getResponseTime() < 150)
				offset = 0;
			if (playerInfo.getResponseTime() < 300)
				offset = 1;
			if (playerInfo.getResponseTime() < 600)
				offset = 2;
			if (playerInfo.getResponseTime() < 1000)
				offset = 3;
			else
				offset = 4;
		} else
			offset = 0;

		drawTexturedModalRect(x0 + x - 11, y, i * 10, 176 + offset * 8, 10, 8);
	}

	public static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
		float f = 0.00390625F;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(x, y + height, 0).tex((float) textureX * f, (float) (textureY + height) * f).endVertex();
		worldrenderer.pos(x + width, y + height, 0).tex((float) (textureX + width) * f, (float) (textureY + height) * f)
				.endVertex();
		worldrenderer.pos(x + width, y, 0).tex((float) (textureX + width) * f, (float) textureY * f).endVertex();
		worldrenderer.pos(x, y, 0).tex((float) textureX * f, (float) textureY * f).endVertex();
		tessellator.draw();
	}

	public static void rect(final double x, final double y, final double width, final double height,
			final Color color) {
		rect(x, y, width, height, true, color);
	}

	public static void rect(final double x, final double y, final double width, final double height,
			final boolean filled, final Color color) {
		start();
		if (color != null)
			color(color);
		begin(filled ? GL11.GL_TRIANGLE_FAN : GL11.GL_LINES);

		{
			vertex(x, y);
			vertex(x + width, y);
			vertex(x + width, y + height);
			vertex(x, y + height);
			if (!filled) {
				vertex(x, y);
				vertex(x, y + height);
				vertex(x + width, y);
				vertex(x + width, y + height);
			}
		}
		end();
		stop();
	}

	public static void start() {
		enable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		disable(GL11.GL_TEXTURE_2D);
		disable(GL11.GL_CULL_FACE);
		GlStateManager.disableAlpha();
		GlStateManager.disableDepth();
	}

	public static void enable(final int glTarget) {
		GL11.glEnable(glTarget);
	}

	public static void color(Color color) {
		if (color == null)
			color = Color.white;
		color(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
	}

	public static void color(final double red, final double green, final double blue, final double alpha) {
		GL11.glColor4d(red, green, blue, alpha);
	}

	public static void lineWidth(final float width) {
		GL11.glLineWidth(width);
	}

	public static void begin(final int glMode) {
		GL11.glBegin(glMode);
	}

	public static void vertex(final double x, final double y) {
		GL11.glVertex2d(x, y);
	}

	public static void end() {
		GL11.glEnd();
	}

	public static void stop() {
		GlStateManager.enableAlpha();
		GlStateManager.enableDepth();
		enable(GL11.GL_CULL_FACE);
		enable(GL11.GL_TEXTURE_2D);
		disable(GL11.GL_BLEND);
		color(Color.white);
	}

	public static void disable(final int glTarget) {
		GL11.glDisable(glTarget);
	}

	public static void drawImage(float x, float y, final int width, final int height, final ResourceLocation image,
			Color color) {
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, 1.0f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		Gui.drawModalRectWithCustomSizedTexture((int) x, (int) y, 0.0f, 0.0f, width, height, (float) width,
				(float) height);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
	}

	public static void drawCircle(double x, double y, double radius, int c) {
		GL11.glEnable(GL13.GL_MULTISAMPLE);
		GL11.glEnable(GL11.GL_POLYGON_SMOOTH);
		float alpha = (float) (c >> 24 & 255) / 255.0f;
		float red = (float) (c >> 16 & 255) / 255.0f;
		float green = (float) (c >> 8 & 255) / 255.0f;
		float blue = (float) (c & 255) / 255.0f;
		boolean blend = GL11.glIsEnabled(3042);
		boolean line = GL11.glIsEnabled(2848);
		boolean texture = GL11.glIsEnabled(3553);
		if (!blend) {
			GL11.glEnable(3042);
		}
		if (!line) {
			GL11.glEnable(2848);
		}
		if (texture) {
			GL11.glDisable(3553);
		}
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(red, green, blue, alpha);
		GL11.glBegin(9);
		int i = 0;
		while (i <= 360) {
			GL11.glVertex2d(x + Math.sin((double) i * 3.141526 / 180.0) * radius,
					y + Math.cos((double) i * 3.141526 / 180.0) * radius);
			++i;
		}
		GL11.glEnd();
		if (texture) {
			GL11.glEnable(3553);
		}
		if (!line) {
			GL11.glDisable(2848);
		}
		if (!blend) {
			GL11.glDisable(3042);
		}
		GL11.glDisable(GL11.GL_POLYGON_SMOOTH);
		GL11.glClear(0);
	}

	public static void drawRoundRect(float x, float y, float x1, float y1, int color) {
		drawRoundedRect(x, y, x1, y1, color, color);
		GlStateManager.color(1, 1, 1);
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

	public static void drawBlockBox(final BlockPos blockPos, final Color color, final int width, float partialTicks) {
		if (width == 0)
			return;
		final RenderManager renderManager = mc.getRenderManager();

		final double x = blockPos.getX() - renderManager.viewerPosX;
		final double y = blockPos.getY() - renderManager.viewerPosY;
		final double z = blockPos.getZ() - renderManager.viewerPosZ;

		AxisAlignedBB axisAlignedBB = new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0);
		final Block block = mc.theWorld.getBlockState(blockPos).getBlock();

		if (block != null) {
			final EntityPlayer player = mc.thePlayer;

			final double posX = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
			final double posY = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
			final double posZ = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;

			block.setBlockBoundsBasedOnState(mc.theWorld, blockPos);

			axisAlignedBB = block.getSelectedBoundingBox(mc.theWorld, blockPos)
					.expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D)
					.offset(-posX, -posY, -posZ);
		}

		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		enableGlCap(GL_BLEND);
		disableGlCap(GL_TEXTURE_2D, GL_DEPTH_TEST);
		glDepthMask(false);

		glColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha() != 255 ? color.getAlpha() : 26);
		// drawFilledBox(axisAlignedBB);

		glLineWidth((float) width);
		enableGlCap(GL_LINE_SMOOTH);
		glColor(color);

		drawSelectionBoundingBox(axisAlignedBB);

		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		glDepthMask(true);
		resetCaps();
	}

	public static void glColor(final int red, final int green, final int blue, final int alpha) {
		GL11.glColor4f(red / 255F, green / 255F, blue / 255F, alpha / 255F);
	}

	public static void resetCaps() {
		glCapMap.forEach(RenderUtils::setGlState);
	}

	public static void enableGlCap(final int cap) {
		setGlCap(cap, true);
	}

	public static void enableGlCap(final int... caps) {
		for (final int cap : caps)
			setGlCap(cap, true);
	}

	public static void disableGlCap(final int cap) {
		setGlCap(cap, true);
	}

	public static void disableGlCap(final int... caps) {
		for (final int cap : caps)
			setGlCap(cap, false);
	}

	public static void setGlCap(final int cap, final boolean state) {
		glCapMap.put(cap, glGetBoolean(cap));
		setGlState(cap, state);
	}

	public static void setGlState(final int cap, final boolean state) {
		if (state)
			glEnable(cap);
		else
			glDisable(cap);
	}

	public static int getRainbow(int speed, int width, int offset) {
		long speedTime = (long) width * 1000L;
		float time = (float) ((System.currentTimeMillis() + (long) (offset * speed)) % speedTime)
				/ ((float) speedTime / 2.0F);
		return Color.HSBtoRGB(time, 0.55F, 0.9F);
	}

	public static Color getRainbow(int offset, int speed, float saturation, float brightness) {
		float hue = ((System.currentTimeMillis() + offset) % speed) / (float) speed;
		return Color.getHSBColor(hue, saturation, brightness);
	}

	public static void drawIcarusESP(EntityLivingBase target, Color color, boolean rainbow) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		float animationY = 0.0f;
		float animationY2 = 0.0f;
		int currentOffset = 0;
		if (animationTimer.hasReached(10)) {
			animationX++;
			animationTimer.reset();
		}

		translateRotate(target);
		GL11.glLineWidth(1f);
		GL11.glBegin(GL11.GL_LINE_STRIP);

		for (int i = animationX; i < 100 + animationX; i++) {
			final double c = (2 * i * Math.PI / 100);
			Color pick = rainbow ? getRainbow(currentOffset, 1000, (float) 0.8, 1f) : color;
			GL11.glColor3d(pick.getRed() / 255f, pick.getGreen() / 255f, pick.getBlue() / 255f);
			GL11.glVertex3d((Math.cos(c) * 0.5), animationY, (Math.sin(c) * 0.5));
			animationY += target.height / 100;
			currentOffset += 10;
		}
		GL11.glEnd();

		GL11.glBegin(GL11.GL_LINE_STRIP);

		for (int i = 50 + animationX; i < 150 + animationX; i++) {
			final double c = (2 * i * Math.PI / 100);
			Color pick = rainbow ? getRainbow(currentOffset, 1000, (float) 0.8, 1f) : color;
			GL11.glColor3d(pick.getRed() / 255f, pick.getGreen() / 255f, pick.getBlue() / 255f);
			GL11.glVertex3d((Math.cos(c) * 0.5), animationY2, (Math.sin(c) * 0.5));
			animationY2 += target.height / 100;
			currentOffset += 10;
		}
		GL11.glEnd();

		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}

	private static void translateRotate(Entity entity) {
		final float partialTicks = mc.timer.renderPartialTicks;
		final double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosX();
		final double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosY();
		final double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
		GL11.glTranslated(x, y, z);
		GL11.glNormal3d(0.0, 1.0, 0.0);
		GL11.glRotated(-mc.getRenderManager().playerViewY, 0.0, 1.0, 0.0);
	}
}
