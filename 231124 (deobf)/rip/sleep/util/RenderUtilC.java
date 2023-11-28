package rip.sleep.util;

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
import org.json.JSONException;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RenderUtilC {
   private static final Minecraft c24674 = Minecraft.getMinecraft();

   public static void c80809(int var0, int var1, int var2, int var3) {
      int var4 = (new ScaledResolution(c24674)).getScaleFactor();
      GL11.glPushMatrix();
      GL11.glEnable(3089);
      GL11.glScissor(var0 * var4, c24674.displayHeight - (var1 + var3) * var4, var2 * var4, var3 * var4);
   }

   public static void c24680() {
      GL11.glDisable(3089);
      GL11.glPopMatrix();
   }

   public static void c6711(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      c32834(var0 + var8, var2 + var8, var4 - var8, var6 - var8, var10);
      c32834(var0 + var8, var2, var4 - var8, var2 + var8, var11);
      c32834(var0, var2, var0 + var8, var6, var11);
      c32834(var4 - var8, var2, var4, var6, var11);
      c32834(var0 + var8, var6 - var8, var4 - var8, var6, var11);
   }

   public static void c42147(int var0, int var1, int var2, int var3, float var4) {
      var0 = var0 - 5;
      var2 = var2 + 5;
      var1 = var1 - 5;
      var3 = var3 + 5;
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      c24674.getTextureManager().bindTexture(new ResourceLocation("sleep/shadow.png"));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
      GlStateManager.color(1.0F, 1.0F, 1.0F, var4);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
      GlStateManager.bindTexture(0);
      GlStateManager.resetColor();
      GlStateManager.enableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static void c77096(float var0, float var1, float var2, int var3) {
      GlStateManager.pushMatrix();
      Value.c27574();
      GlStateManager.disableTexture2D();
      GL11.glEnable(2881);
      GlStateManager.enableBlend();
      GL11.glBegin(9);
      RenderUtilG.c45410(var3);
      int var5 = 0;
      if (var5 <= 360) {
         GL11.glVertex2d((double)var0 + Math.sin((double)var5 * 3.141592653589793D / 180.0D) * (double)var2, (double)var1 + Math.cos((double)var5 * 3.141592653589793D / 180.0D) * (double)var2);
         ++var5;
      }

      GlStateManager.resetColor();
      GL11.glEnd();
      GL11.glDisable(2881);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
      GlStateManager.popMatrix();
   }

   public static void c32834(double var0, double var2, double var4, double var6, int var8) {
      Module[] var9 = Value.c27574();
      if (var0 < var4) {
         double var10 = var0;
         var0 = var4;
         var4 = var10;
      }

      if (var2 < var6) {
         double var16 = var2;
         var2 = var6;
         var6 = var16;
      }

      float var17 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var11, var12, var13, var17);
      var15.begin(7, DefaultVertexFormats.POSITION);
      var15.pos(var0, var6, 0.0D).endVertex();
      var15.pos(var4, var6, 0.0D).endVertex();
      var15.pos(var4, var2, 0.0D).endVertex();
      var15.pos(var0, var2, 0.0D).endVertex();
      var14.draw();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c71699(double var0, double var2, double var4, double var6, int var8, int var9) {
      float var10 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      float var14 = (float)(var9 >> 24 & 255) / 255.0F;
      float var15 = (float)(var9 >> 16 & 255) / 255.0F;
      float var16 = (float)(var9 >> 8 & 255) / 255.0F;
      float var17 = (float)(var9 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var18 = Tessellator.getInstance();
      WorldRenderer var19 = var18.getWorldRenderer();
      var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var19.pos(var4, var2, 0.0D).color(var11, var12, var13, var10).endVertex();
      var19.pos(var0, var2, 0.0D).color(var11, var12, var13, var10).endVertex();
      var19.pos(var0, var6, 0.0D).color(var15, var16, var17, var14).endVertex();
      var19.pos(var4, var6, 0.0D).color(var15, var16, var17, var14).endVertex();
      var18.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static void c65465(double var0, double var2, double var4, double var6, int var8, int var9) {
      float var10 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      float var14 = (float)(var9 >> 24 & 255) / 255.0F;
      float var15 = (float)(var9 >> 16 & 255) / 255.0F;
      float var16 = (float)(var9 >> 8 & 255) / 255.0F;
      float var17 = (float)(var9 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var18 = Tessellator.getInstance();
      WorldRenderer var19 = var18.getWorldRenderer();
      var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var19.pos(var0, var2, 0.0D).color(var11, var12, var13, var10).endVertex();
      var19.pos(var0, var6, 0.0D).color(var11, var12, var13, var10).endVertex();
      var19.pos(var4, var6, 0.0D).color(var15, var16, var17, var14).endVertex();
      var19.pos(var4, var2, 0.0D).color(var15, var16, var17, var14).endVertex();
      var18.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static void c61961(AxisAlignedBB var0) {
      GL11.glBegin(7);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glEnd();
   }

   public static void c37383(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13) {
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.disableDepth();
      GlStateManager.color(var10, var11, var12, var13);
      c61961(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableDepth();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static void c80646(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(1, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static Framebuffer c84114(Framebuffer var0) {
      Module[] var1 = Value.c27574();
      if (var0 != null && var0.framebufferWidth == c24674.displayWidth && var0.framebufferHeight == c24674.displayHeight) {
         return var0;
      } else {
         if (var0 != null) {
            var0.deleteFramebuffer();
         }

         return new Framebuffer(c24674.displayWidth, c24674.displayHeight, true);
      }
   }

   public static void c49685(int var0) {
      GL11.glBindTexture(3553, var0);
   }

   public static Color c27215(int var0, float var1) {
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
      return new Color(var2, var3, var4, var1);
   }

   public static double[] c9261(double var0, double var2, double var4) {
      FloatBuffer var7 = BufferUtils.createFloatBuffer(3);
      Value.c27574();
      IntBuffer var8 = BufferUtils.createIntBuffer(16);
      FloatBuffer var9 = BufferUtils.createFloatBuffer(16);
      FloatBuffer var10 = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat(2982, var9);
      GL11.glGetFloat(2983, var10);
      GL11.glGetInteger(2978, var8);
      boolean var11 = GLU.gluProject((float)var0, (float)var2, (float)var4, var9, var10, var8, var7);
      return var11 ? new double[]{(double)var7.get(0), (double)((float)Display.getHeight() - var7.get(1)), (double)var7.get(2)} : null;
   }

   public static void c61860() {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2896);
      GL11.glHint(3154, 4354);
   }

   public static void c67477() {
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glShadeModel(7424);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c29244(Color var0, float var1) {
      GlStateManager.color((float)var0.getRed() / 255.0F, (float)var0.getGreen() / 255.0F, (float)var0.getBlue() / 255.0F, var1 / 255.0F);
   }

   private static JSONException c96003(JSONException var0) {
      return var0;
   }
}
