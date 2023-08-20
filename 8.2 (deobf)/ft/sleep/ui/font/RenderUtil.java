//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.font;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class RenderUtil {
   private static final Minecraft mc = Minecraft.getMinecraft();

   public static void startGlScissor(int x, int y, int width, int height) {
      int scaleFactor = (new ScaledResolution(mc)).getScaleFactor();
      GL11.glPushMatrix();
      GL11.glEnable(3089);
      GL11.glScissor(x * scaleFactor, mc.displayHeight - (y + height) * scaleFactor, width * scaleFactor, height * scaleFactor);
   }

   public static void stopGlScissor() {
      GL11.glDisable(3089);
      GL11.glPopMatrix();
   }

   public static void drawBordRect(double x, double y, double x1, double y1, double width, int internalColor, int borderColor) {
      drawRect(x + width, y + width, x1 - width, y1 - width, internalColor);
      drawRect(x + width, y, x1 - width, y + width, borderColor);
      drawRect(x, y, x + width, y1, borderColor);
      drawRect(x1 - width, y, x1, y1, borderColor);
      drawRect(x + width, y1 - width, x1 - width, y1, borderColor);
   }

   public static void drawShadow(int x, int y, int width, int height, float sAlpha) {
      x = x - 5;
      width = width + 5;
      y = y - 5;
      height = height + 5;
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      mc.getTextureManager().bindTexture(new ResourceLocation("sleep/shadow.png"));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, (float)width, (float)height);
      GlStateManager.color(1.0F, 1.0F, 1.0F, sAlpha);
      Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, (float)width, (float)height);
      GlStateManager.bindTexture(0);
      GlStateManager.resetColor();
      GlStateManager.enableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static void drawCircle(float x, float y, float radius, int color) {
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GL11.glEnable(2881);
      GlStateManager.enableBlend();
      GL11.glBegin(9);
      �?.�?(color);

      for(int i = 0; i <= 360; ++i) {
         GL11.glVertex2d((double)x + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)y + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      GlStateManager.resetColor();
      GL11.glEnd();
      GL11.glDisable(2881);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
      GlStateManager.popMatrix();
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

      float f3 = (float)(color >> 24 & 255) / 255.0F;
      float f = (float)(color >> 16 & 255) / 255.0F;
      float f1 = (float)(color >> 8 & 255) / 255.0F;
      float f2 = (float)(color & 255) / 255.0F;
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
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void drawVerticalGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
      float f = (float)(col1 >> 24 & 255) / 255.0F;
      float f1 = (float)(col1 >> 16 & 255) / 255.0F;
      float f2 = (float)(col1 >> 8 & 255) / 255.0F;
      float f3 = (float)(col1 & 255) / 255.0F;
      float f4 = (float)(col2 >> 24 & 255) / 255.0F;
      float f5 = (float)(col2 >> 16 & 255) / 255.0F;
      float f6 = (float)(col2 >> 8 & 255) / 255.0F;
      float f7 = (float)(col2 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator tessellator = Tessellator.getInstance();
      WorldRenderer world = tessellator.getWorldRenderer();
      world.begin(7, DefaultVertexFormats.POSITION_COLOR);
      world.pos(right, top, 0.0D).color(f1, f2, f3, f).endVertex();
      world.pos(left, top, 0.0D).color(f1, f2, f3, f).endVertex();
      world.pos(left, bottom, 0.0D).color(f5, f6, f7, f4).endVertex();
      world.pos(right, bottom, 0.0D).color(f5, f6, f7, f4).endVertex();
      tessellator.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static void drawHorizontalGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
      float f = (float)(col1 >> 24 & 255) / 255.0F;
      float f1 = (float)(col1 >> 16 & 255) / 255.0F;
      float f2 = (float)(col1 >> 8 & 255) / 255.0F;
      float f3 = (float)(col1 & 255) / 255.0F;
      float f4 = (float)(col2 >> 24 & 255) / 255.0F;
      float f5 = (float)(col2 >> 16 & 255) / 255.0F;
      float f6 = (float)(col2 >> 8 & 255) / 255.0F;
      float f7 = (float)(col2 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator tessellator = Tessellator.getInstance();
      WorldRenderer world = tessellator.getWorldRenderer();
      world.begin(7, DefaultVertexFormats.POSITION_COLOR);
      world.pos(left, top, 0.0D).color(f1, f2, f3, f).endVertex();
      world.pos(left, bottom, 0.0D).color(f1, f2, f3, f).endVertex();
      world.pos(right, bottom, 0.0D).color(f5, f6, f7, f4).endVertex();
      world.pos(right, top, 0.0D).color(f5, f6, f7, f4).endVertex();
      tessellator.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static void drawBoundingBox(AxisAlignedBB bb) {
      GL11.glBegin(7);
      GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
      GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
      GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
      GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
      GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
      GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
      GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
      GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
      GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
      GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
      GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
      GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
      GL11.glVertex3d(bb.maxX, bb.minY, bb.minZ);
      GL11.glVertex3d(bb.maxX, bb.maxY, bb.minZ);
      GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
      GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
      GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
      GL11.glVertex3d(bb.maxX, bb.minY, bb.maxZ);
      GL11.glVertex3d(bb.maxX, bb.maxY, bb.maxZ);
      GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
      GL11.glVertex3d(bb.minX, bb.minY, bb.minZ);
      GL11.glVertex3d(bb.minX, bb.minY, bb.maxZ);
      GL11.glVertex3d(bb.minX, bb.maxY, bb.maxZ);
      GL11.glVertex3d(bb.minX, bb.maxY, bb.minZ);
      GL11.glEnd();
   }

   public static void drawBoundingBox(double x, double y, double z, double width, double height, float red, float green, float blue, float alpha) {
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.disableDepth();
      GlStateManager.color(red, green, blue, alpha);
      drawBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableDepth();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
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

   public static Framebuffer createFrameBuffer(Framebuffer framebuffer) {
      if (framebuffer != null && framebuffer.framebufferWidth == mc.displayWidth && framebuffer.framebufferHeight == mc.displayHeight) {
         return framebuffer;
      } else {
         if (framebuffer != null) {
            framebuffer.deleteFramebuffer();
         }

         return new Framebuffer(mc.displayWidth, mc.displayHeight, true);
      }
   }

   public static void bindTexture(int texture) {
      GL11.glBindTexture(3553, texture);
   }

   public static Color glColor(int color, float alpha) {
      float red = (float)(color >> 16 & 255) / 255.0F;
      float green = (float)(color >> 8 & 255) / 255.0F;
      float blue = (float)(color & 255) / 255.0F;
      GL11.glColor4f(red, green, blue, alpha);
      return new Color(red, green, blue, alpha);
   }

   public static double[] convertTo2D(double x, double y, double z) {
      FloatBuffer screenCoords = BufferUtils.createFloatBuffer(3);
      IntBuffer viewport = BufferUtils.createIntBuffer(16);
      FloatBuffer modelView = BufferUtils.createFloatBuffer(16);
      FloatBuffer projection = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat(2982, modelView);
      GL11.glGetFloat(2983, projection);
      GL11.glGetInteger(2978, viewport);
      boolean result = GLU.gluProject((float)x, (float)y, (float)z, modelView, projection, viewport, screenCoords);
      return result ? new double[]{(double)screenCoords.get(0), (double)((float)Display.getHeight() - screenCoords.get(1)), (double)screenCoords.get(2)} : null;
   }

   public static void pre3D() {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2896);
      GL11.glHint(3154, 4354);
   }

   public static void post3D() {
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glShadeModel(7424);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void color(Color color, float alpha) {
      GlStateManager.color((float)color.getRed() / 255.0F, (float)color.getGreen() / 255.0F, (float)color.getBlue() / 255.0F, alpha / 255.0F);
   }
}
