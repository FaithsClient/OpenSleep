package linxiu.utils;

import com.mojang.authlib.GameProfile;
import linxiu.utils.math.Vec2f;
import linxiu.utils.math.Vec3f;
import linxiu.utils.render.gl.GLClientState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
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
	private static final Frustum frustrum = new Frustum();
	public static float deltaTime;

	static {
		tessellator = Tessellation.createExpanding(4, 1.0f, 2.0f);
		csBuffer = new ArrayList<Integer>();
		ENABLE_CLIENT_STATE = GL11::glEnableClientState;
		DISABLE_CLIENT_STATE = GL11::glEnableClientState;
	}

	public RenderUtil() {
		super();
	}

	/*
	 * �ʺ�Ч��
	 */
	public static Color rainbowEffect(long offset, float saturation, float fade) {
		float hue = (float) (System.nanoTime() + offset) / 1.0E10F % 1.0F;
		long color = Long
				.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, saturation, 1.0F)).intValue()), 16);
		Color c = new Color((int) color);
		return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade,
				c.getAlpha() / 255.0F);
	}

	public static void glColor(int hex) {
		float alpha = (hex >> 24 & 0xFF) / 255.0F;
		float red = (hex >> 16 & 0xFF) / 255.0F;
		float green = (hex >> 8 & 0xFF) / 255.0F;
		float blue = (hex & 0xFF) / 255.0F;
		GL11.glColor4f(red, green, blue, alpha);
	}

	public static void glColor(float alpha, int redRGB, int greenRGB, int blueRGB) {
		float red = 0.003921569F * redRGB;
		float green = 0.003921569F * greenRGB;
		float blue = 0.003921569F * blueRGB;
		GL11.glColor4f(red, green, blue, alpha);
	}

	public static int getHexRGB(final int hex) {
		return 0xFF000000 | hex;
	}

	public static void checkSetupFBO() {
		Framebuffer fbo = Minecraft.getMinecraft().getFramebuffer();
		if (fbo == null)
			return;
		if (fbo.depthBuffer <= -1)
			return;
		EXTFramebufferObject.glDeleteRenderbuffersEXT(fbo.depthBuffer);
		int stencil_depth_buffer_ID = EXTFramebufferObject.glGenRenderbuffersEXT();
		EXTFramebufferObject.glBindRenderbufferEXT(36161, stencil_depth_buffer_ID);
		EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041,
				Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161,
				stencil_depth_buffer_ID);
		EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161,
				stencil_depth_buffer_ID);
		fbo.depthBuffer = -1;
	}

	public static void outlineOne() {
		GL11.glPushAttrib(1048575);
		GL11.glDisable(3008);
		GL11.glDisable(3553);
		GL11.glDisable(2896);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glLineWidth(2.0f);
		GL11.glEnable(2848);
		GL11.glEnable(2960);
		GL11.glClear(1024);
		GL11.glClearStencil(15);
		GL11.glStencilFunc(512, 1, 15);
		GL11.glStencilOp(7681, 7681, 7681);
		GL11.glPolygonMode(1032, 6913);
	}

	public static void outlineTwo() {
		GL11.glStencilFunc(512, 0, 15);
		GL11.glStencilOp(7681, 7681, 7681);
		GL11.glPolygonMode(1032, 6914);
	}

	public static void outlineThree() {
		GL11.glStencilFunc(514, 1, 15);
		GL11.glStencilOp(7680, 7680, 7680);
		GL11.glPolygonMode(1032, 6913);
	}

	public static void outlineFour() {
		GL11.glDepthMask(false);
		GL11.glDisable(2929);
		GL11.glEnable(10754);
		GL11.glPolygonOffset(1.0f, -2000000.0f);
		GL11.glColor4f(0.9529412f, 0.6117647f, 0.07058824f, 1.0f);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
	}

	public static void outlineFive() {
		GL11.glPolygonOffset(1.0f, 2000000.0f);
		GL11.glDisable(10754);
		GL11.glEnable(2929);
		GL11.glDepthMask(true);
		GL11.glDisable(2960);
		GL11.glDisable(2848);
		GL11.glHint(3154, 4352);
		GL11.glEnable(3042);
		GL11.glEnable(2896);
		GL11.glEnable(3553);
		GL11.glEnable(3008);
		GL11.glPopAttrib();
	}

	public static void drawTexture(int x, int y, int width, int height, int angle, ResourceLocation texture) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GL11.glColor4f(255f, 255f, 255f, 255f);
		if (angle <= 0) {
			Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, width, height);
		} else {
			GlStateManager.pushMatrix();
			int x1 = x + 5;
			int y1 = 240 / 2 - 130;
			GlStateManager.translate(x1, y1 + y + 15f, 0f);
			GlStateManager.rotate(angle, 0f, 0f, 1f);
			GlStateManager.translate(-x1, -(y1 + y + 15f), 0f);
			Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 10, 10, 10, 10);
			GlStateManager.popMatrix();
		}
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

	// ����������
	public static void drawTriangle(Vec2f point1, Vec2f point2, Vec2f point3, float lineWidth, int color,
			boolean isFull) {
		float alpha = (float) (color >> 24 & 255) / 255.0F;
		float red = (float) (color >> 16 & 255) / 255.0F;
		float green = (float) (color >> 8 & 255) / 255.0F;
		float blue = (float) (color & 255) / 255.0F;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glPushMatrix();
		GL11.glColor4f(red, green, blue, alpha);
		GL11.glLineWidth(lineWidth);
		GL11.glBegin(isFull ? GL11.GL_TRIANGLES : GL11.GL_LINES);
		GL11.glVertex2f(point1.getX(), point1.getY());
		GL11.glVertex2f(point2.getX(), point2.getY());
		GL11.glVertex2f(point3.getX(), point3.getY());
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
	}

	public static void drawPixel(float xc, float yc, float x, float y, float pointSize, int color) {
		final float f = (color >> 24 & 0xFF) / 255.0f;
		final float f2 = (color >> 16 & 0xFF) / 255.0f;
		final float f3 = (color >> 8 & 0xFF) / 255.0f;
		final float f4 = (color & 0xFF) / 255.0f;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glPushMatrix();
		GL11.glColor4f(f2, f3, f4, f);
		GL11.glPointSize(pointSize);
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glVertex2f(xc + x, yc + y);
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
	}

	/**
	 * ��һ��Բ
	 * 
	 * @param x         Բ�ĵ�x����
	 * @param y         Բ�ĵ�y����
	 * @param r         Բ�İ뾶
	 * @param lineWidth ��Բ��������ϸ
	 * @param isFull    Բ�Ƿ�Ϊʵ�ģ����Ϊtrue������ʵ�ġ����Ϊfalse�����ǿ���
	 * @param color     Բ����ɫ
	 */
	public static void drawCircle(float x, float y, float r, float lineWidth, boolean isFull, int color) {
		drawCircle((int) x, (int) y, r, 10, lineWidth, 360, isFull, color);
	}

	public static void drawCircle(int cx, int cy, double r, final int segments, final float lineWidth, final int part,
			final boolean isFull, final int c) {
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		r *= 2.0;
		cx *= 2;
		cy *= 2;
		final float f2 = (c >> 24 & 0xFF) / 255.0f;
		final float f3 = (c >> 16 & 0xFF) / 255.0f;
		final float f4 = (c >> 8 & 0xFF) / 255.0f;
		final float f5 = (c & 0xFF) / 255.0f;
		GL11.glEnable(3042);
		GL11.glLineWidth(lineWidth);
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(f3, f4, f5, f2);
		GL11.glBegin(3);
		for (int i = segments - part; i <= segments; ++i) {
			final double x = Math.sin(i * 3.141592653589793 / 180.0) * r;
			final double y = Math.cos(i * 3.141592653589793 / 180.0) * r;
			GL11.glVertex2d(cx + x, cy + y);
			if (isFull)
				GL11.glVertex2d(cx, cy);
		}
		GL11.glEnd();
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
	}

	/**
	 * ��һ������
	 * 
	 * @param x          ���ε�x����
	 * @param y          ���ε�y����
	 * @param r          ���εİ뾶
	 * @param angle      ���εĽǶ�
	 * @param startAngle ��ʼ�����εĽǶ�
	 * @param lineWidth  �����ε��ߵĴֶ�
	 * @param c          ���ε���ɫ
	 * @param isFull     �����Ƿ�Ϊʵ�ģ���Ϊtrue����ʵ�ģ���Ϊfalse���ǿ���
	 * @param isClose    �����Ƿ��գ�������isFullΪtrueʱ���˲�����������
	 */
	public static void drawSector(float x, float y, double r, int angle, int startAngle, float lineWidth, int c,
			boolean isFull, boolean isClose) {
		if (angle <= 0) {
			return;
		}
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		r *= 2.0;
		x *= 2;
		y *= 2;
		final float f2 = (c >> 24 & 0xFF) / 255.0f;
		final float f3 = (c >> 16 & 0xFF) / 255.0f;
		final float f4 = (c >> 8 & 0xFF) / 255.0f;
		final float f5 = (c & 0xFF) / 255.0f;
		GL11.glEnable(3042);
		GlStateManager.enableAlpha();
		GL11.glLineWidth(lineWidth);
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(f3, f4, f5, f2);
		GL11.glBegin(3);
		for (int i = startAngle; i <= angle + startAngle; i++) {
			double x2 = Math.sin(i * 3.141592653589793 / 180.0) * r;
			double y2 = Math.cos(i * 3.141592653589793 / 180.0) * r;
			GL11.glVertex2d(x + x2, y + y2);
			if (isFull)
				GL11.glVertex2d(x, y);
		}
		if (isClose && !isFull && angle < 360) {
			double startX = Math.sin(startAngle * 3.141592653589793 / 180.0) * r;
			double startY = Math.cos(startAngle * 3.141592653589793 / 180.0) * r;
			GL11.glVertex2d(x, y);
			GL11.glVertex2d(x + startX, y + startY);
		}
		GL11.glEnd();
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
	}

	public static void drawRect2(double left, double top, double right, double bottom, int color) {
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

	/**
	 * ����Բ�߾���
	 */
	public static void drawYBrect(float x, float y, float width, float height, float lineWidth, int color,
			boolean isFull) {
		drawSector(x, y + height / 2, height / 2, 180, 180, lineWidth, color, isFull, false);
		if (isFull) {
			drawRectWH(x, y, width, height, color);
		} else {
			drawLine(x, y, x + width, y, lineWidth, color);
			drawLine(x, y + height, x + width, y + height, lineWidth, color);
		}
		drawSector(x + width, y + height / 2, height / 2, 180, 0, lineWidth, color, isFull, false);
	}

	public static void drawYBrect2(float x, float y, float width, float height, float r, int color) {
		// left
		drawSector(x + r + 0.5F, y + r + 0.5F, r, 90, 180, 1, color, true, false);
		drawRect(0, 0, 0, 0, 0);
		// right
		drawSector(x + width - r - 0.5F, y + r + 0.5F, r, 90, 90, 1, color, true, false);
		drawRect(0, 0, 0, 0, 0);
		// left - down
		drawSector(x + r + 0.5F, y + height - r - 0.5F, r, 90, 270, 1, color, true, false);
		drawRect(0, 0, 0, 0, 0);
		// left - right
		drawSector(x + width - r - 0.5F, y + height - r - 0.5F, r, 90, 360, 1, color, true, false);
		drawRect(0, 0, 0, 0, 0);

		// Middle
		drawRect(x + r, y, x + r + width - 2 * r, y + height, color);
		// Left
		drawRect(x, y + r, x + r, y + height - r, color);
		// Right
		drawRect(x + width - r, y + r, x + width, y + height - r, color);
	}

	/**
	 * ����һ������
	 * 
	 * @param x     ���ε�x����
	 * @param y     ���ε�y����
	 * @param w     ���εĿ��
	 * @param h     ���εĸ߶�
	 * @param color ���ε���ɫ
	 */
	public static void drawRectWH(float x, float y, float w, float h, int color) {
		Gui.drawRect((int) x, (int) y, (int) (w + x), (int) (h + y), color);
	}

	public static void drawRect(double x, double y, double x2, double y2, int color) {
		Gui.drawRect((int) x, (int) y, (int) x2, (int) y2, color);
	}

	public static void drawKXRect(float x, float y, float width, float height, float lineWidth, int color) {
		float alpha = (float) (color >> 24 & 255) / 255.0F;
		float red = (float) (color >> 16 & 255) / 255.0F;
		float green = (float) (color >> 8 & 255) / 255.0F;
		float blue = (float) (color & 255) / 255.0F;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glPushMatrix();
		GL11.glColor4f(red, green, blue, alpha);
		GL11.glLineWidth(lineWidth);
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glVertex2f(x + width, y + height);
		GL11.glVertex2f(x, y + height);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x, y + height);
		GL11.glVertex2f(x + width, y);
		GL11.glVertex2f(x + width, y + height);
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
	}

	public static void drawBorderedRect(final float x, final float y, final float x2, final float y2, final float l1,
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
		GL11.glVertex2d(x, y);
		GL11.glVertex2d(x, y2);
		GL11.glVertex2d(x2, y2);
		GL11.glVertex2d(x2, y);
		GL11.glVertex2d((double) x - l1, y);
		GL11.glVertex2d((double) x2 + l1, y);
		GL11.glVertex2d(x, y2);
		GL11.glVertex2d(x2, y2);
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
	}

	// ��ȡ��Ļ���
	public static int width() {
		return new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth();
	}

	// ��ȡ��Ļ�߶�
	public static int height() {
		return new ScaledResolution(Minecraft.getMinecraft()).getScaledHeight();
	}

	public static double interpolation(final double newPos, final double oldPos) {
		return oldPos + (newPos - oldPos) * Helper.getTimer().renderPartialTicks;
	}

	public static double interpolate(double newPos, double oldPos) {
		return oldPos + (newPos - oldPos) * (double) Helper.getTimer().renderPartialTicks;
	}

	public static void GuiPost() {
		GL11.glDisable(3042);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glColor3d(1.0, 1.0, 1.0);
	}

	public static void pre() {
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glHint(3154, 4354);
	}

	public static void post() {
		GL11.glDepthMask(true);
		GL11.glEnable(2929);
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public static void startDrawing() {
		GL11.glEnable(3042);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glDisable(3553);
		GL11.glDisable(2929);
		// Helper.mc.entityRenderer.setupCameraTransform(Helper.getTimer().renderPartialTicks,
		// 0);
	}

	public static void pre3D() {
		GL11.glPushMatrix();
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glHint(3154, 4354);
	}

	public static void post3D() {
		GL11.glEnable(2929);
		GL11.glDisable(2848);
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public static void stopDrawing() {
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

	public static void drawLine(float x, float y, float x1, float y1, float lineWidth, int color) {
		GL11.glPushMatrix();
		GL11.glLineWidth(lineWidth);
		final float f = (color >> 24 & 0xFF) / 255.0f;
		final float f2 = (color >> 16 & 0xFF) / 255.0f;
		final float f3 = (color >> 8 & 0xFF) / 255.0f;
		final float f4 = (color & 0xFF) / 255.0f;
		GL11.glColor4f(f2, f3, f4, f);
		setupRender(true);
		setupClientState(GLClientState.VERTEX, true);
		RenderUtil.tessellator.addVertex(x, y, 0).addVertex(x1, y1, 0).draw(3);
		setupClientState(GLClientState.VERTEX, false);
		setupRender(false);
		GL11.glPopMatrix();
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

	public static void drawLine(final float x, final float y, final float z, final float x1, final float y1,
			final float z1, final float width, int color) {
		GL11.glPushMatrix();
		GL11.glLineWidth(width);
		final float f = (color >> 24 & 0xFF) / 255.0f;
		final float f2 = (color >> 16 & 0xFF) / 255.0f;
		final float f3 = (color >> 8 & 0xFF) / 255.0f;
		final float f4 = (color & 0xFF) / 255.0f;
		GL11.glColor4f(f2, f3, f4, f);
		setupRender(true);
		setupClientState(GLClientState.VERTEX, true);
		RenderUtil.tessellator.addVertex(x, y, z).addVertex(x1, y1, z1).draw(3);
		setupClientState(GLClientState.VERTEX, false);
		setupRender(false);
		GL11.glPopMatrix();
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

	public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
		float f = (float) (col1 >> 24 & 255) / 255.0f;
		float f1 = (float) (col1 >> 16 & 255) / 255.0f;
		float f2 = (float) (col1 >> 8 & 255) / 255.0f;
		float f3 = (float) (col1 & 255) / 255.0f;
		float f4 = (float) (col2 >> 24 & 255) / 255.0f;
		float f5 = (float) (col2 >> 16 & 255) / 255.0f;
		float f6 = (float) (col2 >> 8 & 255) / 255.0f;
		float f7 = (float) (col2 & 255) / 255.0f;
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
	}

	public static Vec3 interpolateRender(EntityPlayer player) {
		float part = Helper.getTimer().renderPartialTicks;
		double interpX = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double) part;
		double interpY = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double) part;
		double interpZ = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double) part;
		return new Vec3(interpX, interpY, interpZ);
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

	public static void drawCircle(float cx, float cy, float r, int num_segments, int c) {
		GL11.glPushMatrix();
		cx *= 2.0F;
		cy *= 2.0F;
		float f = (float) (c >> 24 & 255) / 255.0F;
		float f1 = (float) (c >> 16 & 255) / 255.0F;
		float f2 = (float) (c >> 8 & 255) / 255.0F;
		float f3 = (float) (c & 255) / 255.0F;
		float theta = (float) (6.2831852D / (double) num_segments);
		float p = (float) Math.cos(theta);
		float s = (float) Math.sin(theta);
		float x = r *= 2.0F;
		float y = 0.0F;
		enableGL2D();
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glBegin(2);

		for (int ii = 0; ii < num_segments; ++ii) {
			GL11.glVertex2f(x + cx, y + cy);
			float t = x;
			x = p * x - s * y;
			y = s * t + p * y;
		}

		GL11.glEnd();
		GL11.glScalef(2.0F, 2.0F, 2.0F);
		disableGL2D();
		GL11.glPopMatrix();
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

	public static double interpolate(double current, double old, double scale) {
		return old + (current - old) * scale;
	}

	public static void drawBorderedRect(double x2, double d2, double x22, double e2, float l1, int col1, int col2) {
		RenderUtil.drawRect(x2, d2, x22, e2, col2);
		float f2 = (float) (col1 >> 24 & 0xFF) / 255.0f;
		float f22 = (float) (col1 >> 16 & 0xFF) / 255.0f;
		float f3 = (float) (col1 >> 8 & 0xFF) / 255.0f;
		float f4 = (float) (col1 & 0xFF) / 255.0f;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glPushMatrix();
		GL11.glColor4f(f22, f3, f4, f2);
		GL11.glLineWidth(l1);
		GL11.glBegin(1);
		GL11.glVertex2d(x2, d2);
		GL11.glVertex2d(x2, e2);
		GL11.glVertex2d(x22, e2);
		GL11.glVertex2d(x22, d2);
		GL11.glVertex2d(x2, d2);
		GL11.glVertex2d(x22, d2);
		GL11.glVertex2d(x2, e2);
		GL11.glVertex2d(x22, e2);
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
	}

	public static void drawEntityOnScreen(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_,
			float p_147046_4_, EntityLivingBase p_147046_5_) {
		GlStateManager.enableColorMaterial();
		GlStateManager.pushMatrix();
		GlStateManager.translate(p_147046_0_, p_147046_1_, 40.0f);
		GlStateManager.scale(-p_147046_2_, p_147046_2_, p_147046_2_);
		GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
		float var6 = p_147046_5_.renderYawOffset;
		float var7 = p_147046_5_.rotationYaw;
		float var8 = p_147046_5_.rotationPitch;
		float var9 = p_147046_5_.prevRotationYawHead;
		float var10 = p_147046_5_.rotationYawHead;
		GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
		GlStateManager.rotate(-((float) Math.atan(p_147046_4_ / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
		p_147046_5_.renderYawOffset = (float) Math.atan(p_147046_3_ / 40.0f) * -14.0f;
		p_147046_5_.rotationYaw = (float) Math.atan(p_147046_3_ / 40.0f) * -14.0f;
		p_147046_5_.rotationPitch = -((float) Math.atan(p_147046_4_ / 40.0f)) * 15.0f;
		p_147046_5_.rotationYawHead = p_147046_5_.rotationYaw;
		p_147046_5_.prevRotationYawHead = p_147046_5_.rotationYaw;
		GlStateManager.translate(0.0f, 0.0f, 0.0f);
		RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
		var11.setPlayerViewY(180.0f);
		var11.setRenderShadow(false);
		var11.renderEntityWithPosYaw(p_147046_5_, 0.0, 0.0, 0.0, 0.0f, 1.0f);
		var11.setRenderShadow(true);
		p_147046_5_.renderYawOffset = var6;
		p_147046_5_.rotationYaw = var7;
		p_147046_5_.rotationPitch = var8;
		p_147046_5_.prevRotationYawHead = var9;
		p_147046_5_.rotationYawHead = var10;
		GlStateManager.popMatrix();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	public static void doGlScissor(int x, int y, int width, int height) {
		Minecraft mc = Minecraft.getMinecraft();
		int scaleFactor = 1;
		int k = mc.gameSettings.guiScale;
		if (k == 0) {
			k = 1000;
		}
		while (scaleFactor < k && mc.displayWidth / (scaleFactor + 1) >= 320
				&& mc.displayHeight / (scaleFactor + 1) >= 240) {
			++scaleFactor;
		}
		GL11.glScissor(x * scaleFactor, mc.displayHeight - (y + height) * scaleFactor,
				width * scaleFactor, height * scaleFactor);
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

	public static void circle(final float x, final float y, final float radius, final int fill) {
		arc(x, y, 0.0f, 360.0f, radius, fill);
	}

	public static void arc(final float x, final float y, final float start, final float end, final float radius,
			final int color) {
		arcEllipse(x, y, start, end, radius, radius, color);
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

	private static final Minecraft mc = Minecraft.getMinecraft();

	public static void startGlScissor(int x, int y, int width, int height) {
		int scaleFactor = new ScaledResolution(mc).getScaleFactor();
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_SCISSOR_TEST);
		GL11.glScissor((x * scaleFactor), (mc.displayHeight - (y + height) * scaleFactor), (width * scaleFactor),
				(height * scaleFactor));
	}

	public static void stopGlScissor() {
		GL11.glDisable(GL11.GL_SCISSOR_TEST);
		GL11.glPopMatrix();
	}

	public static void drawBordRect(double x, double y, double x1, double y1, double width, int internalColor,
			int borderColor) {
		drawRect(x + width, y + width, x1 - width, y1 - width, internalColor);
		drawRect(x + width, y, x1 - width, y + width, borderColor);
		drawRect(x, y, x + width, y1, borderColor);
		drawRect(x1 - width, y, x1, y1, borderColor);
		drawRect(x + width, y1 - width, x1 - width, y1, borderColor);
	}

	public static void drawPlayerHead(String playerName, int x, int y, int width, int height) {
		for (Object player : Minecraft.getMinecraft().theWorld.getLoadedEntityList()) {
			if (player instanceof EntityPlayer) {
				EntityPlayer ply = (EntityPlayer) player;
				if (playerName.equalsIgnoreCase(ply.getName())) {
					GameProfile profile = new GameProfile(ply.getUniqueID(), ply.getName());
					NetworkPlayerInfo networkplayerinfo1 = new NetworkPlayerInfo(profile);
					ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
					GL11.glDisable(2929);
					GL11.glEnable(3042);
					GL11.glDepthMask(false);
					OpenGlHelper.glBlendFunc(770, 771, 1, 0);
					GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
					Minecraft.getMinecraft().getTextureManager().bindTexture(networkplayerinfo1.getLocationSkin());
					Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, width, height);
					GL11.glDepthMask(true);
					GL11.glDisable(3042);
					GL11.glEnable(2929);
				}
			}
		}
	}

	public static void drawImage(ResourceLocation image, int x, int y, int width, int height) {
		drawImage(image, x, y, width, height, 1.0f);
	}

	public static void drawImage(ResourceLocation image, int x, int y, int width, int height, float alpha) {
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		GL11.glDisable(2929);
		GL11.glEnable(3042);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, alpha);
		Minecraft.getMinecraft().getTextureManager().bindTexture(image);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height,
				(float) width, (float) height);
		GL11.glDepthMask(true);
		GL11.glDisable(3042);
		GL11.glEnable(2929);
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

	public static Color makeDarker(Color curColor, int distance) {
		int red = curColor.getRed();
		int green = curColor.getGreen();
		int blue = curColor.getBlue();
		red -= distance;
		green -= distance;
		blue -= distance;
		if (red < 0)
			red = 0;
		if (green < 0)
			green = 0;
		if (blue < 0)
			blue = 0;
		return new Color(red, green, blue);
	}

	public static void prepareScissorBox(ScaledResolution sr, float x, float y, float width, float height) {
		float x2 = x + width;
		float y2 = y + height;
		int factor = sr.getScaleFactor();
		GL11.glScissor((int) (x * factor), (int) ((sr.getScaledHeight() - y2) * factor), (int) ((x2 - x) * factor),
				(int) ((y2 - y) * factor));

	}

	public static void prepareScissorBox(float x, float y, float x2, float y2) {
		ScaledResolution scale = new ScaledResolution(mc);
		int factor = scale.getScaleFactor();
		GL11.glScissor((int) (x * (float) factor), (int) (((float) scale.getScaledHeight() - y2) * (float) factor),
				(int) ((x2 - x) * (float) factor), (int) ((y2 - y) * (float) factor));
	}

	public static void drawScaledRect(int x, int y, float u, float v, int uWidth, int vHeight, int width, int height,
			float tileWidth, float tileHeight) {
		Gui.drawScaledCustomSizeModalRect(x, y, u, v, uWidth, vHeight, width, height, tileWidth, tileHeight);
	}

	public static void drawIcon(float x, float y, int sizex, int sizey, ResourceLocation resourceLocation) {
		GL11.glPushMatrix();
		Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GlStateManager.enableRescaleNormal();
		GlStateManager.enableAlpha();
		GlStateManager.alphaFunc(516, 0.1f);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(770, 771);
		GL11.glTranslatef(x, y, 0.0f);
		RenderUtil.drawScaledRect(0, 0, 0.0f, 0.0f, sizex, sizey, sizex, sizey, sizex, sizey);
		GlStateManager.disableAlpha();
		GlStateManager.disableRescaleNormal();
		GlStateManager.disableLighting();
		GlStateManager.disableRescaleNormal();
		GL11.glDisable(2848);
		GlStateManager.disableBlend();
		GL11.glPopMatrix();
	}

	public static double getDrugAnimation(double animation, double finalState, double speed) {
		float add = (float) (0.01 * speed);
		if (animation < finalState) {
			if (animation + add < finalState)
				animation += add;
			else
				animation = finalState;
		} else {
			if (animation - add > finalState)
				animation -= add;
			else
				animation = finalState;
		}
		return animation;
	}

	public static void drawGradientSidewaysV(double left, double top, double right, double bottom, int col1, int col2) {
		float f = (float) (col1 >> 24 & 255) / 255.0f;
		float f1 = (float) (col1 >> 16 & 255) / 255.0f;
		float f2 = (float) (col1 >> 8 & 255) / 255.0f;
		float f3 = (float) (col1 & 255) / 255.0f;
		float f4 = (float) (col2 >> 24 & 255) / 255.0f;
		float f5 = (float) (col2 >> 16 & 255) / 255.0f;
		float f6 = (float) (col2 >> 8 & 255) / 255.0f;
		float f7 = (float) (col2 & 255) / 255.0f;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(2848);
		GL11.glShadeModel(7425);
		GL11.glPushMatrix();
		GL11.glBegin(7);
		GL11.glColor4f(f1, f2, f3, f);
		GL11.glVertex2d(left, bottom);
		GL11.glVertex2d(right, bottom);
		GL11.glColor4f(f5, f6, f7, f4);
		GL11.glVertex2d(right, top);
		GL11.glVertex2d(left, top);
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
		GL11.glDisable(2848);
		GL11.glShadeModel(7424);
		Gui.drawRect(0, 0, 0, 0, 0);
	}

	public static float getAnimationState(float animation, float finalState, float speed) {
		float add = deltaTime * speed;
		animation = animation < finalState ? (animation + add < finalState ? (animation += add) : finalState)
				: (animation - add > finalState ? (animation -= add) : finalState);
		return animation;
	}

	public static double getAnimationState(double animation, double finalState, double speed) {
		float add = (float) (0.01 * speed);
		if (animation < finalState) {
			if (animation + add < finalState)
				animation += add;
			else
				animation = finalState;
		} else {
			if (animation - add > finalState)
				animation -= add;
			else
				animation = finalState;
		}
		return animation;
	}

	public static void drawRoundedRect2(final double x, final double y, final double width, final double height,
			double radius, int color) {
		RenderUtil.drawRoundedRect(x, y, width - x, height - y, radius, color);
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

	public static void color(int color) {
		float f = (float) (color >> 24 & 255) / 255.0f;
		float f1 = (float) (color >> 16 & 255) / 255.0f;
		float f2 = (float) (color >> 8 & 255) / 255.0f;
		float f3 = (float) (color & 255) / 255.0f;
		GL11.glColor4f(f1, f2, f3, f);
	}

	public static void resetColor() {
		GlStateManager.color(1, 1, 1, 1);
	}

}
