package rip.sleep.util;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rip.sleep.injection.in.IEntityRenderer;
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
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RenderUtilB {
   private static final Minecraft c53297 = Minecraft.getMinecraft();
   private static final Map<Integer, Boolean> c98520 = new HashMap();

   public static void c51840(float var0, float var1, float var2, Runnable var3) {
      GL11.glPushMatrix();
      GL11.glTranslatef(var0, var1, 0.0F);
      GL11.glScalef(var2, var2, 1.0F);
      GL11.glTranslatef(-var0, -var1, 0.0F);
      var3.run();
      GL11.glPopMatrix();
   }

   public static void c78875(float var0, float var1, float var2, float var3, int var4, int var5) {
      var2 = var0 + var2;
      var3 = var1 + var3;
      float var6 = (float)(var4 >> 24 & 255) / 255.0F;
      float var7 = (float)(var4 >> 16 & 255) / 255.0F;
      float var8 = (float)(var4 >> 8 & 255) / 255.0F;
      float var9 = (float)(var4 & 255) / 255.0F;
      float var10 = (float)(var5 >> 24 & 255) / 255.0F;
      float var11 = (float)(var5 >> 16 & 255) / 255.0F;
      float var12 = (float)(var5 >> 8 & 255) / 255.0F;
      float var13 = (float)(var5 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var15.pos((double)var2, (double)var1, 0.0D).color(var7, var8, var9, var6).endVertex();
      var15.pos((double)var0, (double)var1, 0.0D).color(var7, var8, var9, var6).endVertex();
      var15.pos((double)var0, (double)var3, 0.0D).color(var11, var12, var13, var10).endVertex();
      var15.pos((double)var2, (double)var3, 0.0D).color(var11, var12, var13, var10).endVertex();
      var14.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void c12036(double var0, double var2, double var4, double var6) {
      c28359(var0, var2, var0 + var4, var2 + var6, Color.BLACK.getRGB());
      c28359(var0 + 1.0D, var2 + 1.0D, var0 + var4 - 1.0D, var2 + var6 - 1.0D, (new Color(55, 55, 55)).getRGB());
      c28359(var0 + 1.0D, var2 + 1.5D, var0 + var4 - 2.0D, var2 + var6 - 1.5D, (new Color(30, 30, 30)).getRGB());
      c28359(var0 + 3.0D, var2 + 3.0D, var0 + var4 - 3.0D, var2 + var6 - 3.0D, (new Color(14, 14, 14)).getRGB());
   }

   public static void c45341(float var0, float var1, float var2, float var3, int var4) {
      float var5 = (float)(var4 >> 24 & 255) / 255.0F;
      float var6 = (float)(var4 >> 16 & 255) / 255.0F;
      float var7 = (float)(var4 >> 8 & 255) / 255.0F;
      float var8 = (float)(var4 & 255) / 255.0F;
      Tessellator var9 = Tessellator.getInstance();
      WorldRenderer var10 = var9.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var6, var7, var8, var5);
      var10.begin(7, DefaultVertexFormats.POSITION);
      var10.pos((double)var0, (double)(var1 + var3), 0.0D).endVertex();
      var10.pos((double)(var0 + var2), (double)(var1 + var3), 0.0D).endVertex();
      var10.pos((double)(var0 + var2), (double)var1, 0.0D).endVertex();
      var10.pos((double)var0, (double)var1, 0.0D).endVertex();
      var9.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c19676(float var0, float var1, float var2, float var3, float var4, int var5, float var6, int var7) {
      Module[] var8 = Value.c27574();
      if (var5 == 16777215) {
         var5 = -65794;
      }

      if (var7 == 16777215) {
         var7 = -65794;
      }

      if (var4 < 0.0F) {
         var4 = 0.0F;
      }

      if (var4 > var2 / 2.0F) {
         var4 = var2 / 2.0F;
      }

      if (var4 > var3 / 2.0F) {
         var4 = var3 / 2.0F;
      }

      c45341(var0 + var4, var1 + var4, var2 - var4 * 2.0F, var3 - var4 * 2.0F, var5);
      c45341(var0 + var4, var1, var2 - var4 * 2.0F, var4, var5);
      c45341(var0 + var4, var1 + var3 - var4, var2 - var4 * 2.0F, var4, var5);
      c45341(var0, var1 + var4, var4, var3 - var4 * 2.0F, var5);
      c45341(var0 + var2 - var4, var1 + var4, var4, var3 - var4 * 2.0F, var5);
      c50895();
      c93630(var5);
      GL11.glBegin(6);
      float var9 = var0 + var4;
      float var10 = var1 + var4;
      GL11.glVertex2d((double)var9, (double)var10);
      int var11 = (int)Math.min(Math.max(var4, 10.0F), 90.0F);
      int var12 = 0;
      if (var12 < var11 + 1) {
         double var13 = 6.283185307179586D * (double)(var12 + 180) / (double)(var11 * 4);
         GL11.glVertex2d((double)var9 + Math.sin(var13) * (double)var4, (double)var10 + Math.cos(var13) * (double)var4);
         ++var12;
      }

      GL11.glEnd();
      GL11.glBegin(6);
      var9 = var0 + var2 - var4;
      var10 = var1 + var4;
      GL11.glVertex2d((double)var9, (double)var10);
      var11 = (int)Math.min(Math.max(var4, 10.0F), 90.0F);
      var12 = 0;
      if (var12 < var11 + 1) {
         double var44 = 6.283185307179586D * (double)(var12 + 90) / (double)(var11 * 4);
         GL11.glVertex2d((double)var9 + Math.sin(var44) * (double)var4, (double)var10 + Math.cos(var44) * (double)var4);
         ++var12;
      }

      GL11.glEnd();
      GL11.glBegin(6);
      var9 = var0 + var4;
      var10 = var1 + var3 - var4;
      GL11.glVertex2d((double)var9, (double)var10);
      var11 = (int)Math.min(Math.max(var4, 10.0F), 90.0F);
      var12 = 0;
      if (var12 < var11 + 1) {
         double var45 = 6.283185307179586D * (double)(var12 + 270) / (double)(var11 * 4);
         GL11.glVertex2d((double)var9 + Math.sin(var45) * (double)var4, (double)var10 + Math.cos(var45) * (double)var4);
         ++var12;
      }

      GL11.glEnd();
      GL11.glBegin(6);
      var9 = var0 + var2 - var4;
      var10 = var1 + var3 - var4;
      GL11.glVertex2d((double)var9, (double)var10);
      var11 = (int)Math.min(Math.max(var4, 10.0F), 90.0F);
      var12 = 0;
      if (var12 < var11 + 1) {
         double var46 = 6.283185307179586D * (double)var12 / (double)(var11 * 4);
         GL11.glVertex2d((double)var9 + Math.sin(var46) * (double)var4, (double)var10 + Math.cos(var46) * (double)var4);
         ++var12;
      }

      GL11.glEnd();
      c93630(var7);
      GL11.glLineWidth(var6);
      GL11.glBegin(3);
      var9 = var0 + var4;
      var10 = var1 + var4;
      var11 = (int)Math.min(Math.max(var4, 10.0F), 90.0F);
      double var47 = 6.283185307179586D * (double)(var11 + 180) / (double)(var11 * 4);
      GL11.glVertex2d((double)var9 + Math.sin(var47) * (double)var4, (double)var10 + Math.cos(var47) * (double)var4);
      var12 = var11 - 1;
      GL11.glVertex2d((double)(var0 + var4), (double)var1);
      GL11.glVertex2d((double)(var0 + var2 - var4), (double)var1);
      var9 = var0 + var2 - var4;
      var10 = var1 + var4;
      var47 = 6.283185307179586D * (double)(var11 + 90) / (double)(var11 * 4);
      GL11.glVertex2d((double)var9 + Math.sin(var47) * (double)var4, (double)var10 + Math.cos(var47) * (double)var4);
      var12 = var11 - 1;
      GL11.glVertex2d((double)(var0 + var2), (double)(var1 + var4));
      GL11.glVertex2d((double)(var0 + var2), (double)(var1 + var3 - var4));
      var9 = var0 + var2 - var4;
      var10 = var1 + var3 - var4;
      var47 = 6.283185307179586D * (double)var11 / (double)(var11 * 4);
      GL11.glVertex2d((double)var9 + Math.sin(var47) * (double)var4, (double)var10 + Math.cos(var47) * (double)var4);
      var12 = var11 - 1;
      GL11.glVertex2d((double)(var0 + var2 - var4), (double)(var1 + var3));
      GL11.glVertex2d((double)(var0 + var4), (double)(var1 + var3));
      var9 = var0 + var4;
      var10 = var1 + var3 - var4;
      var47 = 6.283185307179586D * (double)(var11 + 270) / (double)(var11 * 4);
      GL11.glVertex2d((double)var9 + Math.sin(var47) * (double)var4, (double)var10 + Math.cos(var47) * (double)var4);
      var12 = var11 - 1;
      GL11.glVertex2d((double)var0, (double)(var1 + var3 - var4));
      GL11.glVertex2d((double)var0, (double)(var1 + var4));
      GL11.glEnd();
      c83432();
   }

   public static void c50895() {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
   }

   public static void c83432() {
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static int c28660(int var0, float var1) {
      try {
         Color var2 = new Color(var0);
         float var3 = 0.003921569F * (float)var2.getRed();
         float var4 = 0.003921569F * (float)var2.getGreen();
         float var5 = 0.003921569F * (float)var2.getBlue();
         return (new Color(var3, var4, var5, var1)).getRGB();
      } catch (Throwable var6) {
         var6.printStackTrace();
         return var0;
      }
   }

   public static void c28157(Runnable var0) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      var0.run();
      GL11.glEnable(3553);
      GlStateManager.disableBlend();
   }

   public static void c35606(int var0, Runnable var1) {
      GL11.glBegin(var0);
      var1.run();
      GL11.glEnd();
   }

   public static void c24912(float var0, float var1, float var2, AnimationUtilA var3, int var4) {
      GL11.glTranslatef(var0, var1, 0.0F);
      c28157(() -> {
         c35606(5, () -> {
            Value.c27574();
            c93630(var4);
            double var4x = c55280(0.0D, (double)var2 / 2.0D, var3.c53286()).doubleValue();
            if (var3.c53286() >= 0.48D) {
               GL11.glVertex2d((double)(var2 / 2.0F), c55280((double)var2 / 2.0D, 0.0D, var3.c53286()).doubleValue());
            }

            GL11.glVertex2d(0.0D, var4x);
            if (var3.c53286() < 0.48D) {
               GL11.glVertex2d((double)(var2 / 2.0F), c55280((double)var2 / 2.0D, 0.0D, var3.c53286()).doubleValue());
            }

            GL11.glVertex2d((double)var2, var4x);
         });
      });
      GL11.glTranslatef(-var0, -var1, 0.0F);
   }

   public static Double c55280(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static void c91857() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static double c62457(double var0, double var2, double var4) {
      Module[] var6 = Value.c27574();
      boolean var7 = var0 > var2;
      if (var4 < 0.0D) {
         var4 = 0.0D;
      }

      if (var4 > 1.0D) {
         var4 = 1.0D;
      }

      double var8 = Math.max(var0, var2) - Math.min(var0, var2);
      double var10 = var8 * var4;
      return var2 + var10;
   }

   public static void c92423(float var0, float var1, double var2, int var4, int var5, double var6, int var8) {
      var2 = var2 * 2.0D;
      var0 = var0 * 2.0F;
      var1 = var1 * 2.0F;
      float var10 = (float)(var4 >> 24 & 255) / 255.0F;
      float var11 = (float)(var4 >> 16 & 255) / 255.0F;
      float var12 = (float)(var4 >> 8 & 255) / 255.0F;
      Value.c27574();
      float var13 = (float)(var4 & 255) / 255.0F;
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glLineWidth((float)var8);
      GL11.glEnable(2848);
      GL11.glColor4f(var11, var12, var13, var10);
      GL11.glBegin(3);
      if ((double)var5 <= var6) {
         GL11.glVertex2d((double)var0 + Math.sin((double)var5 * 3.141592653589793D / 180.0D) * var2, (double)var1 + Math.cos((double)var5 * 3.141592653589793D / 180.0D) * var2);
         int var14 = var5 + 1;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void c843(Entity var0, Color var1) {
      double var2 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)c53297.timer.renderPartialTicks - c53297.getRenderManager().renderPosX;
      double var4 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)c53297.timer.renderPartialTicks - c53297.getRenderManager().renderPosY;
      double var6 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)c53297.timer.renderPartialTicks - c53297.getRenderManager().renderPosZ;
      Vec3 var8 = (new Vec3(0.0D, 0.0D, 1.0D)).rotatePitch((float)(-Math.toRadians((double)c53297.thePlayer.rotationPitch))).rotateYaw((float)(-Math.toRadians((double)c53297.thePlayer.rotationYaw)));
      c22871(var1);
      GL11.glVertex3d(var8.xCoord, (double)c53297.thePlayer.eyeHeight + var8.yCoord, var8.zCoord);
      GL11.glVertex3d(var2, var4, var6);
      GL11.glVertex3d(var2, var4, var6);
      GL11.glVertex3d(var2, var4 + (double)var0.height, var6);
   }

   public static void c57575(float var0, float var1, float var2, int var3) {
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

   public static void c94081(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      c20861(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      c97310(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c20861(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static void c8514(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      c28359(var0 + var8, var2 + var8, var4 - var8, var6 - var8, var10);
      c28359(var0 + var8, var2, var4 - var8, var2 + var8, var11);
      c28359(var0, var2, var0 + var8, var6, var11);
      c28359(var4 - var8, var2, var4, var6, var11);
      c28359(var0 + var8, var6 - var8, var4 - var8, var6, var11);
   }

   public static void c96476(int var0) {
      float var2 = (float)(var0 >> 24 & 255) / 255.0F;
      Value.c27574();
      float var3 = (float)(var0 >> 16 & 255) / 255.0F;
      float var4 = (float)(var0 >> 8 & 255) / 255.0F;
      float var5 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var3, var4, var5, var2 == 0.0F ? 1.0F : var2);
   }

   public static void c22871(Color var0) {
      Value.c27574();
      float var2 = (float)(var0.getRGB() >> 24 & 255) / 255.0F;
      float var3 = (float)(var0.getRGB() >> 16 & 255) / 255.0F;
      float var4 = (float)(var0.getRGB() >> 8 & 255) / 255.0F;
      float var5 = (float)(var0.getRGB() & 255) / 255.0F;
      GL11.glColor4f(var3, var4, var5, var2 == 0.0F ? 1.0F : var2);
   }

   public static void c5869(int var0, boolean var1) {
      Value.c27574();
      c98520.put(Integer.valueOf(var0), Boolean.valueOf(GL11.glGetBoolean(var0)));
      if (var1) {
         GL11.glEnable(var0);
      }

      GL11.glDisable(var0);
   }

   private static void c6000(int var0) {
      Value.c27574();
      Boolean var2 = (Boolean)c98520.get(Integer.valueOf(var0));
      if (var2 != null) {
         if (var2.booleanValue()) {
            GL11.glEnable(var0);
         }

         GL11.glDisable(var0);
      }

   }

   public static void c71555() {
      Value.c27574();
      Iterator var1 = c98520.keySet().iterator();
      if (var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         c6000(var2.intValue());
      }

   }

   public static void c51514(float var0) {
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
      GL11.glLineWidth(var0);
   }

   public static void c9654() {
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

   public static void c34603(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      c28359((double)var0, (double)var1, (double)var2, (double)var3, var6);
      float var7 = (float)(var5 >> 24 & 255) / 255.0F;
      float var8 = (float)(var5 >> 16 & 255) / 255.0F;
      float var9 = (float)(var5 >> 8 & 255) / 255.0F;
      float var10 = (float)(var5 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var8, var9, var10, var7);
      GL11.glLineWidth(var4);
      GL11.glBegin(1);
      GL11.glVertex2d((double)var0, (double)var1);
      GL11.glVertex2d((double)var0, (double)var3);
      GL11.glVertex2d((double)var2, (double)var3);
      GL11.glVertex2d((double)var2, (double)var1);
      GL11.glVertex2d((double)var0, (double)var1);
      GL11.glVertex2d((double)var2, (double)var1);
      GL11.glVertex2d((double)var0, (double)var3);
      GL11.glVertex2d((double)var2, (double)var3);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static int c67638(int var0) {
      int var1 = var0 >> 16 & 255;
      int var2 = var0 >> 8 & 255;
      int var3 = var0 & 255;
      short var4 = 255;
      return (var1 & 255) << 16 | (var2 & 255) << 8 | var3 & 255 | (var4 & 255) << 24;
   }

   public static int c77516(int var0, float var1) {
      int var2 = (int)((float)(var0 >> 16 & 255) * var1);
      int var3 = (int)((float)(var0 >> 8 & 255) * var1);
      int var4 = (int)((float)(var0 & 255) * var1);
      int var5 = var0 >> 24 & 255;
      return (var2 & 255) << 16 | (var3 & 255) << 8 | var4 & 255 | (var5 & 255) << 24;
   }

   public static void c34870(double var0, double var2, double var4, double var6) {
      Value.c27574();
      int var9 = (new ScaledResolution(Minecraft.getMinecraft())).getScaleFactor();
      if (var9 < 2 && Minecraft.getMinecraft().displayWidth / (var9 + 1) >= 320 && Minecraft.getMinecraft().displayHeight / (var9 + 1) >= 240) {
         ++var9;
      }

      GL11.glScissor((int)(var0 * (double)var9), (int)((double)Minecraft.getMinecraft().displayHeight - (var2 + var6) * (double)var9), (int)(var4 * (double)var9), (int)(var6 * (double)var9));
   }

   public static void c1887(String var0, float var1, float var2, int var3) {
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F - 1.0F), (int)(var2 * 2.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F + 1.0F), (int)(var2 * 2.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F - 1.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F + 1.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F), var3);
      GL11.glPopMatrix();
   }

   public static void c97319(String var0, float var1, float var2, int var3) {
      GL11.glPushMatrix();
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F - 1.0F), (int)(var2 * 2.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F + 1.0F), (int)(var2 * 2.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F - 1.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F + 1.0F), Color.BLACK.getRGB());
      c53297.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F), var3);
      GL11.glPopMatrix();
   }

   public static void c98091(double var0, double var2, int var4, int var5) {
      c62716();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      c15816(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0 + 2.0D, var2 + 2.0D);
      GL11.glVertex2d(var0 + 5.0D, var2 - 2.0D);
      GL11.glEnd();
      GL11.glPopMatrix();
      c85610();
   }

   public static boolean c36440(float var0, float var1, float var2, float var3, int var4, int var5) {
      Module[] var6 = Value.c27574();
      return (float)var4 >= var0 && (float)var5 >= var1 && (float)var4 < var0 + var2 && (float)var5 < var1 + var3;
   }

   public static void c80076(double var0, double var2, int var4, int var5, double var6) {
      c62716();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      c15816(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0 + 3.0D, var2 + var6);
      GL11.glVertex2d(var0 + 6.0D, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      c85610();
   }

   public static void c15816(Color var0) {
      float var1 = (float)(var0.getRGB() >> 24 & 255) / 255.0F;
      float var2 = (float)(var0.getRGB() >> 16 & 255) / 255.0F;
      float var3 = (float)(var0.getRGB() >> 8 & 255) / 255.0F;
      float var4 = (float)(var0.getRGB() & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c62716() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void c85610() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c61637(BlockPos var0, int var1) {
      double var2 = (double)var0.getX() - c53297.getRenderManager().renderPosX;
      double var4 = (double)var0.getY() - c53297.getRenderManager().renderPosY;
      double var6 = (double)var0.getZ() - c53297.getRenderManager().renderPosZ;
      double var8 = c53297.theWorld.getBlockState(var0).getBlock().getBlockBoundsMaxY() - c53297.theWorld.getBlockState(var0).getBlock().getBlockBoundsMinY();
      float var10 = (float)(var1 >> 16 & 255) / 255.0F;
      float var11 = (float)(var1 >> 8 & 255) / 255.0F;
      float var12 = (float)(var1 & 255) / 255.0F;
      float var13 = (float)(var1 >> 24 & 255) / 255.0F;
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
      c97310(new AxisAlignedBB(var2, var4, var6, var2 + 1.0D, var4 + var8, var6 + 1.0D));
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

   public static void c92859(BlockPos var0, int var1) {
      Minecraft var2 = Minecraft.getMinecraft();
      double var3 = (double)var0.getX() - var2.getRenderManager().renderPosX + 0.5D;
      double var5 = (double)var0.getY() - var2.getRenderManager().renderPosY + 0.5D;
      double var7 = (double)var0.getZ() - var2.getRenderManager().renderPosZ + 0.5D;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
      float var9 = (float)(var1 >> 16 & 255) / 255.0F;
      float var10 = (float)(var1 >> 8 & 255) / 255.0F;
      float var11 = (float)(var1 & 255) / 255.0F;
      float var12 = (float)(var1 >> 24 & 255) / 255.0F;
      GL11.glColor4f(var9, var10, var11, var12);
      GL11.glLoadIdentity();
      boolean var13 = var2.gameSettings.viewBobbing;
      var2.gameSettings.viewBobbing = false;
      ((IEntityRenderer)var2.entityRenderer).runorientCamera(var2.timer.renderPartialTicks);
      GL11.glBegin(3);
      GL11.glVertex3d(0.0D, (double)var2.thePlayer.getEyeHeight(), 0.0D);
      GL11.glVertex3d(var3, var5, var7);
      GL11.glVertex3d(var3, var5, var7);
      GL11.glEnd();
      var2.gameSettings.viewBobbing = var13;
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c97310(AxisAlignedBB var0) {
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

   public static void c17433(int var0, float var1) {
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GlStateManager.color(var2, var3, var4, var1);
   }

   public static void c93630(int var0) {
      c17433(var0, (float)(var0 >> 24 & 255) / 255.0F);
   }

   public static void c26218(float var0, float var1, float var2, float var3, int var4, int var5) {
      float var6 = (float)(var4 >> 24 & 255) / 255.0F;
      float var7 = (float)(var4 >> 16 & 255) / 255.0F;
      float var8 = (float)(var4 >> 8 & 255) / 255.0F;
      float var9 = (float)(var4 & 255) / 255.0F;
      float var10 = (float)(var5 >> 24 & 255) / 255.0F;
      float var11 = (float)(var5 >> 16 & 255) / 255.0F;
      float var12 = (float)(var5 >> 8 & 255) / 255.0F;
      float var13 = (float)(var5 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var15.pos((double)var2, (double)var1, 0.0D).color(var7, var8, var9, var6).endVertex();
      var15.pos((double)var0, (double)var1, 0.0D).color(var7, var8, var9, var6).endVertex();
      var15.pos((double)var0, (double)var3, 0.0D).color(var11, var12, var13, var10).endVertex();
      var15.pos((double)var2, (double)var3, 0.0D).color(var11, var12, var13, var10).endVertex();
      var14.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void c97276(double var0, double var2, double var4, double var6, boolean var8, int var9, int var10) {
      Value.c27574();
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glBegin(7);
      c93630(var9);
      if (var8) {
         GL11.glVertex2d(var0, var2);
         GL11.glVertex2d(var0, var6);
         c93630(var10);
         GL11.glVertex2d(var4, var6);
         GL11.glVertex2d(var4, var2);
      }

      GL11.glVertex2d(var0, var2);
      c93630(var10);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      c93630(var9);
      GL11.glVertex2d(var4, var2);
      GL11.glEnd();
      GL11.glDisable(3042);
      GL11.glShadeModel(7424);
      GL11.glEnable(3553);
   }

   public static void c10108(float var0, float var1, float var2, float var3) {
      Value.c27574();
      c28359((double)var0, (double)var1, (double)var2, (double)var3, RenderUtilG.c87305(16777215));
      if (var1 < var3) {
         float var5 = var0 + 0.0F;
         if (var5 < var2) {
            if (var5 <= var2 - 1.0F) {
               c28359((double)var5, (double)var1, (double)(var5 + 1.0F), (double)(var1 + 1.0F), RenderUtilG.c87305(8421504));
            }

            var5 = var5 + 2.0F;
         }

         ++var1;
      }

   }

   public static void c61439(int var0, int var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9) {
      float var10 = 1.0F / var8;
      float var11 = 1.0F / var9;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Tessellator var12 = Tessellator.getInstance();
      WorldRenderer var13 = var12.getWorldRenderer();
      var13.begin(7, DefaultVertexFormats.POSITION_TEX);
      var13.pos((double)var0, (double)(var1 + var7), 0.0D).tex((double)(var2 * var10), (double)((var3 + (float)var5) * var11)).endVertex();
      var13.pos((double)(var0 + var6), (double)(var1 + var7), 0.0D).tex((double)((var2 + (float)var4) * var10), (double)((var3 + (float)var5) * var11)).endVertex();
      var13.pos((double)(var0 + var6), (double)var1, 0.0D).tex((double)((var2 + (float)var4) * var10), (double)(var3 * var11)).endVertex();
      var13.pos((double)var0, (double)var1, 0.0D).tex((double)(var2 * var10), (double)(var3 * var11)).endVertex();
      var12.draw();
   }

   public static void c64056(ResourceLocation var0, int var1, int var2, int var3, int var4) {
      c53297.getTextureManager().bindTexture(var0);
      c61439(var1, var2, 8.0F, 8.0F, 8, 8, var3, var4, 64.0F, 64.0F);
      c61439(var1, var2, 40.0F, 8.0F, 8, 8, var3, var4, 64.0F, 64.0F);
   }

   public static void c28359(double var0, double var2, double var4, double var6, int var8) {
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

   public static void c1602(double var0, double var2, double var4, double var6, Color var8) {
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

      float var17 = (float)(var8.getRGB() >> 24 & 255) / 255.0F;
      float var11 = (float)(var8.getRGB() >> 16 & 255) / 255.0F;
      float var12 = (float)(var8.getRGB() >> 8 & 255) / 255.0F;
      float var13 = (float)(var8.getRGB() & 255) / 255.0F;
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

   public static void c73564(float var0, float var1, float var2, float var3, float var4, float var5, float var6, ResourceLocation var7) {
      Minecraft.getMinecraft().getTextureManager().bindTexture(var7);
      float var8 = 1.0F / var2;
      float var9 = 1.0F / var3;
      GL11.glColor4f(var4, var5, var6, 1.0F);
      Tessellator var10 = Tessellator.getInstance();
      WorldRenderer var11 = var10.getWorldRenderer();
      var11.begin(7, DefaultVertexFormats.POSITION_TEX);
      var11.pos((double)var0, (double)(var1 + var3), 0.0D).tex(0.0D, (double)(var3 * var9)).endVertex();
      var11.pos((double)(var0 + var2), (double)(var1 + var3), 0.0D).tex((double)(var2 * var8), (double)(var3 * var9)).endVertex();
      var11.pos((double)(var0 + var2), (double)var1, 0.0D).tex((double)(var2 * var8), 0.0D).endVertex();
      var11.pos((double)var0, (double)var1, 0.0D).tex(0.0D, 0.0D).endVertex();
      var10.draw();
   }

   public static void c16178(ResourceLocation var0, float var1, float var2, int var3, int var4) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      float var5 = 1.0F / (float)var3;
      float var6 = 1.0F / (float)var4;
      Tessellator var7 = Tessellator.getInstance();
      WorldRenderer var8 = var7.getWorldRenderer();
      var8.begin(7, DefaultVertexFormats.POSITION_TEX);
      var8.pos((double)var1, (double)(var2 + (float)var4), 0.0D).tex((double)(0.0F * var5), (double)((float)var4 * var6)).endVertex();
      var8.pos((double)(var1 + (float)var3), (double)(var2 + (float)var4), 0.0D).tex((double)((float)var3 * var5), (double)((float)var4 * var6)).endVertex();
      var8.pos((double)(var1 + (float)var3), (double)var2, 0.0D).tex((double)((float)var3 * var5), (double)(0.0F * var6)).endVertex();
      var8.pos((double)var1, (double)var2, 0.0D).tex((double)(0.0F * var5), (double)(0.0F * var6)).endVertex();
      var7.draw();
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   private static JSONException c57537(JSONException var0) {
      return var0;
   }
}
