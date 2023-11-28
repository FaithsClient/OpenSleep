package rip.sleep.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RenderUtilE extends ChatUtilA {
   private static final List<Integer> c78935 = new ArrayList();
   private static final Consumer<Integer> c54155 = GL11::glEnableClientState;
   private static final Consumer<Integer> c70074 = GL11::glEnableClientState;
   protected static float c21399;
   public static float c32884;

   public static float c39372(float var0, float var1, float var2, float var3) {
      return c44649(var0, var1, Math.max(10.0F, Math.abs(var0 - var1) * var2) * var3);
   }

   public static double c74149(double var0, double var2, double var4) {
      Module[] var6 = Value.c27574();
      boolean var7 = var0 > var2;
      if (var4 < 0.0D) {
         var4 = 0.0D;
      }

      if (var4 > 1.0D) {
         var4 = 1.0D;
      }

      if (var0 == var2) {
         return var0;
      } else {
         double var8 = Math.max(var0, var2) - Math.min(var0, var2);
         double var10 = var8 * var4;
         if (var10 < 0.1D) {
            var10 = 0.1D;
         }

         if (var7) {
            if (var2 + var10 > var0) {
               var2 = var0;
            }

            var2 += var10;
         }

         if (var2 - var10 < var0) {
            var2 = var0;
         }

         var2 = var2 - var10;
         return var2;
      }
   }

   public static void c48321(int var0, int var1, int var2, int var3) {
      Value.c27574();
      Minecraft var5 = Minecraft.getMinecraft();
      int var6 = 1;
      int var7 = var5.gameSettings.guiScale;
      if (var7 == 0) {
         var7 = 1000;
      }

      if (var6 < var7 && var5.displayWidth / (var6 + 1) >= 320 && var5.displayHeight / (var6 + 1) >= 240) {
         ++var6;
      }

      GL11.glScissor(var0 * var6, var5.displayHeight - (var1 + var3) * var6, var2 * var6, var3 * var6);
   }

   public static float c44649(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = c32884 * var2;
      if (var0 < var1) {
         if (var0 + var4 < var1) {
            float var10000 = var0 + var4;
         }

         var0 = var1;
      }

      if (var0 - var4 > var1) {
         float var5 = var0 - var4;
      }

      return var1;
   }

   public static void c73183() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void c58708() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   private static void c37816(WorldRenderer var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      var0.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var0.pos((double)(var1 + 0), (double)(var2 + 0), 0.0D).color(var5, var6, var7, var8).endVertex();
      var0.pos((double)(var1 + 0), (double)(var2 + var4), 0.0D).color(var5, var6, var7, var8).endVertex();
      var0.pos((double)(var1 + var3), (double)(var2 + var4), 0.0D).color(var5, var6, var7, var8).endVertex();
      var0.pos((double)(var1 + var3), (double)(var2 + 0), 0.0D).color(var5, var6, var7, var8).endVertex();
      Tessellator.getInstance().draw();
   }

   public static Framebuffer c53497(Framebuffer var0) {
      Module[] var1 = Value.c27574();
      if (var0 != null && var0.framebufferWidth == mc.displayWidth && var0.framebufferHeight == mc.displayHeight) {
         return var0;
      } else {
         if (var0 != null) {
            var0.deleteFramebuffer();
         }

         return new Framebuffer(mc.displayWidth, mc.displayHeight, true);
      }
   }

   public static void c35893() {
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

   public static void c78702() {
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c32141(double var0, double var2, double var4, double var6, int var8, int var9) {
      float var10 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      float var14 = (float)(var9 >> 24 & 255) / 255.0F;
      float var15 = (float)(var9 >> 16 & 255) / 255.0F;
      float var16 = (float)(var9 >> 8 & 255) / 255.0F;
      float var17 = (float)(var9 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(var11, var12, var13, var10);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d(var4, var2);
      GL11.glVertex2d(var0, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      Gui.drawRect(0, 0, 0, 0, 0);
   }

   public static void c15146(float var0, float var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9) {
      c29966(var0, var1, var2, var3, (float)var4, (float)var5, var6, var7, var8, var9);
   }

   public static void c23603(Entity var0, int var1, float var2) {
      Module[] var3 = Value.c27574();
      if (var0 != null) {
         double var4 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().viewerPosX;
         double var6 = (double)var0.getEyeHeight() + var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().viewerPosY;
         double var8 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().viewerPosZ;
         float var10 = (float)(var1 >> 24 & 255) / 255.0F;
         float var11 = (float)(var1 >> 16 & 255) / 255.0F;
         float var12 = (float)(var1 >> 8 & 255) / 255.0F;
         float var13 = (float)(var1 & 255) / 255.0F;
         GL11.glPushMatrix();
         GL11.glEnable(3042);
         GL11.glEnable(2848);
         GL11.glDisable(2929);
         GL11.glDisable(3553);
         GL11.glBlendFunc(770, 771);
         GL11.glEnable(3042);
         GL11.glLineWidth(var2);
         GL11.glColor4f(var11, var12, var13, var10);
         GL11.glBegin(2);
         GL11.glVertex3d(0.0D, 0.0D + (double) mc.thePlayer.getEyeHeight(), 0.0D);
         GL11.glVertex3d(var4, var6, var8);
         GL11.glEnd();
         GL11.glDisable(3042);
         GL11.glEnable(3553);
         GL11.glEnable(2929);
         GL11.glDisable(2848);
         GL11.glDisable(3042);
         GL11.glPopMatrix();
      }
   }

   public static void c8759(Entity var0, int var1, boolean var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var0 != null) {
         double var5 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().viewerPosX;
         double var7 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().viewerPosY;
         double var9 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().viewerPosZ;
         if (var0 instanceof EntityPlayer && var2 && ((EntityPlayer)var0).hurtTime != 0) {
            var1 = Color.RED.getRGB();
         }

         float var11 = (float)(var1 >> 24 & 255) / 255.0F;
         float var12 = (float)(var1 >> 16 & 255) / 255.0F;
         float var13 = (float)(var1 >> 8 & 255) / 255.0F;
         float var14 = (float)(var1 & 255) / 255.0F;
         if (var3 == 1) {
            GlStateManager.pushMatrix();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            GL11.glLineWidth(3.0F);
            GL11.glColor4f(var12, var13, var14, var11);
            RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(var0.getEntityBoundingBox().minX - 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().minY - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().minZ - 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ), var0.getEntityBoundingBox().maxX + 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().maxY + 0.1D - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().maxZ + 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ)));
            c37046(new AxisAlignedBB(var0.getEntityBoundingBox().minX - 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().minY - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().minZ - 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ), var0.getEntityBoundingBox().maxX + 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().maxY + 0.1D - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().maxZ + 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ)), var12, var13, var14);
            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            GL11.glDisable(3042);
            GlStateManager.popMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         if (var3 == 2 || var3 == 3) {
            boolean var15 = var3 == 2;
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glLineWidth(3.0F);
            GL11.glDisable(3553);
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            GL11.glColor4d((double)var12, (double)var13, (double)var14, (double)var11);
            RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(var0.getEntityBoundingBox().minX - 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().minY - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().minZ - 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ), var0.getEntityBoundingBox().maxX + 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().maxY + 0.1D - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().maxZ + 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ)));
            c37046(new AxisAlignedBB(var0.getEntityBoundingBox().minX - 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().minY - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().minZ - 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ), var0.getEntityBoundingBox().maxX + 0.05D - var0.posX + (var0.posX - mc.getRenderManager().viewerPosX), var0.getEntityBoundingBox().maxY + 0.1D - var0.posY + (var0.posY - mc.getRenderManager().viewerPosY), var0.getEntityBoundingBox().maxZ + 0.05D - var0.posZ + (var0.posZ - mc.getRenderManager().viewerPosZ)), var12, var13, var14);
            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            GL11.glDisable(3042);
         }

         if (var3 == 4) {
            GL11.glPushMatrix();
            GL11.glTranslated(var5, var7 - 0.2D, var9);
            GL11.glScalef(0.03F, 0.03F, 0.03F);
            GL11.glRotated((double)(-mc.getRenderManager().playerViewY), 0.0D, 1.0D, 0.0D);
            GlStateManager.disableDepth();
            Gui.drawRect(-20, -1, -26, 75, Color.black.getRGB());
            Gui.drawRect(-21, 0, -25, 74, var1);
            Gui.drawRect(20, -1, 26, 75, Color.black.getRGB());
            Gui.drawRect(21, 0, 25, 74, var1);
            Gui.drawRect(-20, -1, 21, 5, Color.black.getRGB());
            Gui.drawRect(-21, 0, 24, 4, var1);
            Gui.drawRect(-20, 70, 21, 75, Color.black.getRGB());
            Gui.drawRect(-21, 71, 25, 74, var1);
            GlStateManager.enableDepth();
            GL11.glPopMatrix();
         }

      }
   }

   public static void c37046(AxisAlignedBB var0, float var1, float var2, float var3) {
      float var5 = 0.25F;
      Tessellator var6 = Tessellator.getInstance();
      Value.c27574();
      WorldRenderer var7 = var6.getWorldRenderer();
      var7.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var6.draw();
      var7.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var6.draw();
      var7.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var6.draw();
      var7.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var6.draw();
      var7.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var6.draw();
      var7.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 0.25F).endVertex();
      var6.draw();
      Module.c75539(new Module[1]);
   }

   public static void c79081(double var0, double var2, double var4, double var6, double var8, Color var10) {
      double var11 = Math.abs(var4 - var0);
      double var13 = Math.abs(var6 - var2);
      double var15 = var11 / 4.0D;
      double var17 = var13 / 4.0D;
      c2834();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var8);
      c16505(var10);
      GL11.glBegin(3);
      GL11.glVertex2d(var0 + var15, var2);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0, var2 + var17);
      GL11.glEnd();
      GL11.glBegin(3);
      GL11.glVertex2d(var0, var2 + var13 - var17);
      GL11.glVertex2d(var0, var2 + var13);
      GL11.glVertex2d(var0 + var15, var2 + var13);
      GL11.glEnd();
      GL11.glBegin(3);
      GL11.glVertex2d(var0 + var11 - var15, var2 + var13);
      GL11.glVertex2d(var0 + var11, var2 + var13);
      GL11.glVertex2d(var0 + var11, var2 + var13 - var17);
      GL11.glEnd();
      GL11.glBegin(3);
      GL11.glVertex2d(var0 + var11, var2 + var17);
      GL11.glVertex2d(var0 + var11, var2);
      GL11.glVertex2d(var0 + var11 - var15, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      c19649();
   }

   public static void c12235(BlockPos var0, int var1) {
      double var2 = (double)var0.getX() - mc.getRenderManager().renderPosX;
      double var4 = (double)var0.getY() - mc.getRenderManager().renderPosY;
      double var6 = (double)var0.getZ() - mc.getRenderManager().renderPosZ;
      double var8 = mc.theWorld.getBlockState(var0).getBlock().getBlockBoundsMaxY() - mc.theWorld.getBlockState(var0).getBlock().getBlockBoundsMinY();
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
      c44394(new AxisAlignedBB(var2, var4, var6, var2 + 1.0D, var4 + var8, var6 + 1.0D));
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

   public static void c44394(AxisAlignedBB var0) {
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

   public static void c7826(double var0, double var2, double var4, double var6, double var8, double var10) {
      float var12 = 0.00390625F;
      float var13 = 0.00390625F;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(7, DefaultVertexFormats.POSITION_TEX);
      var15.pos(var0 + 0.0D, var2 + var10, (double)c21399).tex((double)((float)(var4 + 0.0D) * var12), (double)((float)(var6 + var10) * var13)).endVertex();
      var15.pos(var0 + var8, var2 + var10, (double)c21399).tex((double)((float)(var4 + var8) * var12), (double)((float)(var6 + var10) * var13)).endVertex();
      var15.pos(var0 + var8, var2 + 0.0D, (double)c21399).tex((double)((float)(var4 + var8) * var12), (double)((float)(var6 + 0.0D) * var13)).endVertex();
      var15.pos(var0 + 0.0D, var2 + 0.0D, (double)c21399).tex((double)((float)(var4 + 0.0D) * var12), (double)((float)(var6 + 0.0D) * var13)).endVertex();
      var14.draw();
   }

   private static void c29966(float var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8, float var9) {
      float var10 = 1.0F / var8;
      float var11 = 1.0F / var9;
      Tessellator var12 = Tessellator.getInstance();
      WorldRenderer var13 = var12.getWorldRenderer();
      var13.begin(7, DefaultVertexFormats.POSITION_TEX);
      var13.pos((double)var0, (double)(var1 + (float)var7), 0.0D).tex((double)(var2 * var10), (double)((var3 + var5) * var11)).endVertex();
      var13.pos((double)(var0 + (float)var6), (double)(var1 + (float)var7), 0.0D).tex((double)((var2 + var4) * var10), (double)((var3 + var5) * var11)).endVertex();
      var13.pos((double)(var0 + (float)var6), (double)var1, 0.0D).tex((double)((var2 + var4) * var10), (double)(var3 * var11)).endVertex();
      var13.pos((double)var0, (double)var1, 0.0D).tex((double)(var2 * var10), (double)(var3 * var11)).endVertex();
      var12.draw();
   }

   public static int c15018(int var0, float var1) {
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

   public static void c88529(double var0, double var2, int var4, int var5, double var6) {
      c2834();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      c16505(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0 + 3.0D, var2 + var6);
      GL11.glVertex2d(var0 + 6.0D, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      c19649();
   }

   public static void c82661(float var0) {
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(516, (float)((double)var0 * 0.01D));
   }

   public static void c50903(float var0, float var1, float var2, Color var3, float var4) {
      c82661(0.0F);
      GL11.glShadeModel(7425);
      c12628(() -> {
         c42003(6, () -> {
            Value.c27574();
            c57186(var3.getRGB(), var4);
            GL11.glVertex2d((double)var0, (double)var1);
            c57186(var3.getRGB(), 0.0F);
            int var6 = 0;
            if (var6 <= 100) {
               double var7 = (double)var6 * 0.06283D + 3.1415D;
               double var9 = Math.sin(var7) * (double)var2;
               double var11 = Math.cos(var7) * (double)var2;
               GL11.glVertex2d((double)var0 + var9, (double)var1 + var11);
               ++var6;
            }

         });
      });
      GL11.glShadeModel(7424);
      c82661(1.0F);
   }

   public static Color c14245(Color var0, float var1) {
      int var3 = var0.getRed();
      Value.c27574();
      int var4 = var0.getGreen();
      int var5 = var0.getBlue();
      int var6 = var0.getAlpha();
      int var7 = (int)(1.0D / (1.0D - (double)var1));
      if (var3 == 0 && var4 == 0 && var5 == 0) {
         return new Color(var7, var7, var7, var6);
      } else {
         if (var3 > 0 && var3 < var7) {
            var3 = var7;
         }

         if (var4 > 0 && var4 < var7) {
            var4 = var7;
         }

         if (var5 > 0 && var5 < var7) {
            var5 = var7;
         }

         return new Color(Math.min((int)((float)var3 / var1), 255), Math.min((int)((float)var4 / var1), 255), Math.min((int)((float)var5 / var1), 255), var6);
      }
   }

   public static double c4477(double var0, double var2, double var4) {
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

   public static void c26771(double var0, double var2, double var4, double var6, int var8) {
      c80882();
      c12628(() -> {
         c42003(7, () -> {
            c24918(var8);
            GL11.glVertex2d(var0, var2);
            GL11.glVertex2d(var0, var2 + var6);
            GL11.glVertex2d(var0 + var4, var2 + var6);
            GL11.glVertex2d(var0 + var4, var2);
         });
      });
   }

   public static void c24911(float var0, float var1, double var2, int var4, int var5, double var6, int var8) {
      var2 = var2 * 2.0D;
      var0 = var0 * 2.0F;
      var1 = var1 * 2.0F;
      float var10 = (float)(var4 >> 24 & 255) / 255.0F;
      Value.c27574();
      float var11 = (float)(var4 >> 16 & 255) / 255.0F;
      float var12 = (float)(var4 >> 8 & 255) / 255.0F;
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

   public static void c30951(float var0, float var1, float var2, float var3, float var4, int var5) {
      c99488(var0, var1, var2, var3, var4, var4, var5);
   }

   public static void c99488(float var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      GlStateManager.color(0.0F, 0.0F, 0.0F);
      Value.c27574();
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      float var8 = 0.0F;
      if (var2 > var3) {
         var8 = var3;
         var3 = var2;
         var2 = var8;
      }

      float var9 = (float)(var6 >> 24 & 255) / 255.0F;
      float var10 = (float)(var6 >> 16 & 255) / 255.0F;
      float var11 = (float)(var6 >> 8 & 255) / 255.0F;
      float var12 = (float)(var6 & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var10, var11, var12, var9);
      if (var9 > 0.5F) {
         GL11.glEnable(2848);
         GL11.glLineWidth(2.0F);
         GL11.glBegin(3);
         if (var3 >= var2) {
            float var16 = (float)Math.cos((double)var3 * 3.141592653589793D / 180.0D) * var4 * 1.001F;
            float var17 = (float)Math.sin((double)var3 * 3.141592653589793D / 180.0D) * var5 * 1.001F;
            GL11.glVertex2f(var0 + var16, var1 + var17);
            float var15 = var3 - 4.0F;
         }

         GL11.glEnd();
         GL11.glDisable(2848);
      }

      GL11.glBegin(6);
      if (var3 >= var2) {
         float var20 = (float)Math.cos((double)var3 * 3.141592653589793D / 180.0D) * var4;
         float var21 = (float)Math.sin((double)var3 * 3.141592653589793D / 180.0D) * var5;
         GL11.glVertex2f(var0 + var20, var1 + var21);
         float var19 = var3 - 4.0F;
      }

      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c52316(float var0, float var1, int var2, int var3, float var4, ResourceLocation var5, int var6) {
      Value.c27574();
      GL11.glPushMatrix();
      GL11.glEnable(3553);
      mc.getTextureManager().bindTexture(var5);
      GL11.glEnable(2881);
      GL11.glBlendFunc(770, 771);
      c24918(var6);
      GL11.glBegin(9);
      if (var2 < var3) {
         double var8 = (double)var2 * 0.017453292519943295D;
         double var18 = Math.sin(var8);
         double var20 = Math.cos(var8);
         double var10 = var18 * (double)var4;
         double var12 = var20 * (double)var4;
         double var14 = var18 * 0.5D + 0.5D;
         double var16 = var20 * 0.5D + 0.5D;
         GL11.glTexCoord2d((double)var0 + var14, (double)var1 + var16);
         GL11.glVertex2d((double)var0 + var10, (double)var1 + var12);
         int var22 = var2 + 1;
      }

      GL11.glEnd();
      GL11.glDisable(2881);
      GL11.glDisable(3553);
      GL11.glPopMatrix();
   }

   public static void c3352(float var0, float var1, float var2, AnimationUtilA var3, int var4) {
      GL11.glTranslatef(var0, var1, 0.0F);
      c12628(() -> {
         c42003(5, () -> {
            Value.c27574();
            c24918(var4);
            double var4x = c3362(0.0D, (double)var2 / 2.0D, var3.c53286()).doubleValue();
            if (var3.c53286() >= 0.48D) {
               GL11.glVertex2d((double)(var2 / 2.0F), c3362((double)var2 / 2.0D, 0.0D, var3.c53286()).doubleValue());
            }

            GL11.glVertex2d(0.0D, var4x);
            if (var3.c53286() < 0.48D) {
               GL11.glVertex2d((double)(var2 / 2.0F), c3362((double)var2 / 2.0D, 0.0D, var3.c53286()).doubleValue());
            }

            GL11.glVertex2d((double)var2, var4x);
         });
      });
      GL11.glTranslatef(-var0, -var1, 0.0F);
   }

   public static void c42003(int var0, Runnable var1) {
      GL11.glBegin(var0);
      var1.run();
      GL11.glEnd();
   }

   public static void c12628(Runnable var0) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      var0.run();
      GL11.glEnable(3553);
      GlStateManager.disableBlend();
   }

   public static Double c3362(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static double c9536(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }

   public static int c99539(int var0) {
      int var1 = var0 >> 16 & 255;
      int var2 = var0 >> 8 & 255;
      int var3 = var0 & 255;
      short var4 = 255;
      return (var1 & 255) << 16 | (var2 & 255) << 8 | var3 & 255 | (var4 & 255) << 24;
   }

   public static int c73214(int var0, float var1) {
      int var2 = (int)((float)(var0 >> 16 & 255) * var1);
      int var3 = (int)((float)(var0 >> 8 & 255) * var1);
      int var4 = (int)((float)(var0 & 255) * var1);
      int var5 = var0 >> 24 & 255;
      return (var2 & 255) << 16 | (var3 & 255) << 8 | var4 & 255 | (var5 & 255) << 24;
   }

   public static Color c95489(Color var0, float var1) {
      return new Color(Math.max((int)((float)var0.getRed() * var1), 0), Math.max((int)((float)var0.getGreen() * var1), 0), Math.max((int)((float)var0.getBlue() * var1), 0), var0.getAlpha());
   }

   public static void c43222(float var0, float var1, float var2, float var3, int var4, int var5) {
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

   public static void c83436(double var0, double var2, double var4, double var6, boolean var8, int var9, int var10) {
      Value.c27574();
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glBegin(7);
      c24918(var9);
      if (var8) {
         GL11.glVertex2d(var0, var2);
         GL11.glVertex2d(var0, var6);
         c24918(var10);
         GL11.glVertex2d(var4, var6);
         GL11.glVertex2d(var4, var2);
      }

      GL11.glVertex2d(var0, var2);
      c24918(var10);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      c24918(var9);
      GL11.glVertex2d(var4, var2);
      GL11.glEnd();
      GL11.glDisable(3042);
      GL11.glShadeModel(7424);
      GL11.glEnable(3553);
   }

   public static void c77921(float var0, float var1, float var2, float var3) {
      c72819(var0, var1, var2, var3, c99539(16777215));
      Value.c27574();
      boolean var5 = false;
      if (var1 < var3) {
         boolean var8;
         float var6 = var0 + (float)((var8 = !var5) ? 1 : 0);
         if (var6 < var2) {
            if (var6 <= var2 - 1.0F) {
               c72819(var6, var1, var6 + 1.0F, var1 + 1.0F, c99539(8421504));
            }

            var6 = var6 + 2.0F;
         }

         ++var1;
      }

   }

   public static void c75685(double var0, double var2, int var4, int var5) {
      c2834();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      c16505(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0 + 2.0D, var2 + 3.0D);
      GL11.glVertex2d(var0 + 6.0D, var2 - 2.0D);
      GL11.glEnd();
      GL11.glPopMatrix();
      c19649();
   }

   public static void c87745(int var0) {
      c15866(new Color(var0));
   }

   public static void c16505(Color var0) {
      float var1 = (float)(var0.getRGB() >> 24 & 255) / 255.0F;
      float var2 = (float)(var0.getRGB() >> 16 & 255) / 255.0F;
      float var3 = (float)(var0.getRGB() >> 8 & 255) / 255.0F;
      float var4 = (float)(var0.getRGB() & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c706(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c15866(Color var0) {
      float var1 = (float)var0.getRed() / 255.0F;
      float var2 = (float)var0.getGreen() / 255.0F;
      float var3 = (float)var0.getBlue() / 255.0F;
      float var4 = (float)var0.getAlpha() / 255.0F;
      GL11.glColor4f(var1, var2, var3, var4);
   }

   public static void c2834() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void c19649() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c31072(double var0, double var2, double var4, double var6) {
      Value.c27574();
      int var9 = (new ScaledResolution(Minecraft.getMinecraft())).getScaleFactor();
      if (var9 < 2 && Minecraft.getMinecraft().displayWidth / (var9 + 1) >= 320 && Minecraft.getMinecraft().displayHeight / (var9 + 1) >= 240) {
         ++var9;
      }

      GL11.glScissor((int)(var0 * (double)var9), (int)((double)Minecraft.getMinecraft().displayHeight - (var2 + var6) * (double)var9), (int)(var4 * (double)var9), (int)(var6 * (double)var9));
   }

   public static int c43911() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth();
   }

   public static boolean c3863(float var0, float var1, float var2, float var3, int var4, int var5) {
      Module[] var6 = Value.c27574();
      return (float)var4 >= var0 && (float)var5 >= var1 && (float)var4 < var0 + var2 && (float)var5 < var1 + var3;
   }

   public static int c36065() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledHeight();
   }

   public static void c27595(float var0, float var1, float var2, Runnable var3) {
      GL11.glPushMatrix();
      GL11.glTranslatef(var0, var1, 0.0F);
      GL11.glScalef(var2, var2, 1.0F);
      GL11.glTranslatef(-var0, -var1, 0.0F);
      var3.run();
      GL11.glPopMatrix();
   }

   public static void c32271(float var0, float var1, float var2, float var3, float var4, int var5) {
      var0 = (float)((double)var0 + (double)(var4 / 2.0F) + 0.5D);
      var1 = (float)((double)var1 + (double)(var4 / 2.0F) + 0.5D);
      var2 = (float)((double)var2 - ((double)(var4 / 2.0F) + 0.5D));
      var3 = (float)((double)var3 - ((double)(var4 / 2.0F) + 0.5D));
      c72819(var0, var1, var2, var3, var5);
      c55583(var2 - var4 / 2.0F, var1 + var4 / 2.0F, var4, var5);
      c55583(var0 + var4 / 2.0F, var3 - var4 / 2.0F, var4, var5);
      c55583(var0 + var4 / 2.0F, var1 + var4 / 2.0F, var4, var5);
      c55583(var2 - var4 / 2.0F, var3 - var4 / 2.0F, var4, var5);
      c72819(var0 - var4 / 2.0F - 0.5F, var1 + var4 / 2.0F, var2, var3 - var4 / 2.0F, var5);
      c72819(var0, var1 + var4 / 2.0F, var2 + var4 / 2.0F + 0.5F, var3 - var4 / 2.0F, var5);
      c72819(var0 + var4 / 2.0F, var1 - var4 / 2.0F - 0.5F, var2 - var4 / 2.0F, var3 - var4 / 2.0F, var5);
      c72819(var0 + var4 / 2.0F, var1, var2 - var4 / 2.0F, var3 + var4 / 2.0F + 0.5F, var5);
   }

   public static void c55583(float var0, float var1, float var2, int var3) {
      GL11.glEnable(3042);
      c30951(var0, var1, 0.0F, 360.0F, var2, var3);
      GL11.glDisable(3042);
   }

   public static int c76834(int var0) {
      return -16777216 | var0;
   }

   public static void c5737(float var0, float var1, float var2, float var3, float var4, int var5, float var6, int var7) {
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

      c73045(var0 + var4, var1 + var4, var2 - var4 * 2.0F, var3 - var4 * 2.0F, var5);
      c73045(var0 + var4, var1, var2 - var4 * 2.0F, var4, var5);
      c73045(var0 + var4, var1 + var3 - var4, var2 - var4 * 2.0F, var4, var5);
      c73045(var0, var1 + var4, var4, var3 - var4 * 2.0F, var5);
      c73045(var0 + var2 - var4, var1 + var4, var4, var3 - var4 * 2.0F, var5);
      c17238();
      c24918(var5);
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
      c24918(var7);
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
      c31867();
   }

   public static void c31867() {
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static void c73045(float var0, float var1, float var2, float var3, int var4) {
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

   public static void c14205(ResourceLocation var0, int var1, int var2, int var3, int var4) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      Gui.drawModalRectWithCustomSizedTexture(var1, var2, 0.0F, 0.0F, var3, var4, (float)var3, (float)var4);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glEnable(3042);
   }

   public static void c58675(ResourceLocation var0, float var1, float var2, float var3, float var4) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      Gui.drawModalRectWithCustomSizedTexture((int)var1, (int)var2, 0.0F, 0.0F, (int)var3, (int)var4, var3, var4);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glEnable(3042);
   }

   public static void c39284(ResourceLocation var0, float var1, float var2, float var3, float var4, float var5) {
      GlStateManager.disableDepth();
      GlStateManager.enableBlend();
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, var5);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      c90852(var1, var2, 0.0F, 0.0F, var3, var4, var3, var4);
      GL11.glDepthMask(true);
      GlStateManager.disableBlend();
      GlStateManager.enableDepth();
      GlStateManager.resetColor();
   }

   public static void c17238() {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
   }

   public static void c58241(int var0, int var1, int var2, int var3, ResourceLocation var4) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var4);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void c42986(ResourceLocation var0, float var1, float var2, float var3, float var4, int var5) {
      GlStateManager.disableDepth();
      GlStateManager.enableBlend();
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      float var6 = (float)(var5 >> 24 & 255) / 255.0F;
      float var7 = (float)(var5 >> 16 & 255) / 255.0F;
      float var8 = (float)(var5 >> 8 & 255) / 255.0F;
      float var9 = (float)(var5 & 255) / 255.0F;
      GL11.glColor4f(var7, var8, var9, var6);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      c90852(var1, var2, 0.0F, 0.0F, var3, var4, var3, var4);
      GL11.glDepthMask(true);
      GlStateManager.disableBlend();
      GlStateManager.enableDepth();
      GlStateManager.resetColor();
   }

   public static void c90852(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = 1.0F / var6;
      float var9 = 1.0F / var7;
      Tessellator var10 = Tessellator.getInstance();
      WorldRenderer var11 = var10.getWorldRenderer();
      var11.begin(7, DefaultVertexFormats.POSITION_TEX);
      var11.pos((double)var0, (double)(var1 + var5), 0.0D).tex((double)(var2 * var8), (double)((var3 + var5) * var9)).endVertex();
      var11.pos((double)(var0 + var4), (double)(var1 + var5), 0.0D).tex((double)((var2 + var4) * var8), (double)((var3 + var5) * var9)).endVertex();
      var11.pos((double)(var0 + var4), (double)var1, 0.0D).tex((double)((var2 + var4) * var8), (double)(var3 * var9)).endVertex();
      var11.pos((double)var0, (double)var1, 0.0D).tex((double)(var2 * var8), (double)(var3 * var9)).endVertex();
      var10.draw();
   }

   public static void c72819(float var0, float var1, float var2, float var3, int var4) {
      Module[] var5 = Value.c27574();
      if (var0 < var2) {
         float var6 = var0;
         var0 = var2;
         var2 = var6;
      }

      if (var1 < var3) {
         float var12 = var1;
         var1 = var3;
         var3 = var12;
      }

      float var13 = (float)(var4 >> 24 & 255) / 255.0F;
      float var7 = (float)(var4 >> 16 & 255) / 255.0F;
      float var8 = (float)(var4 >> 8 & 255) / 255.0F;
      float var9 = (float)(var4 & 255) / 255.0F;
      Tessellator var10 = Tessellator.getInstance();
      WorldRenderer var11 = var10.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var7, var8, var9, var13);
      var11.begin(7, DefaultVertexFormats.POSITION);
      var11.pos((double)var0, (double)var3, 0.0D).endVertex();
      var11.pos((double)var2, (double)var3, 0.0D).endVertex();
      var11.pos((double)var2, (double)var1, 0.0D).endVertex();
      var11.pos((double)var0, (double)var1, 0.0D).endVertex();
      var10.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c32646(float var0, float var1, float var2, float var3, Color var4) {
      c72819(var0, var1, var2, var3, var4.getRGB());
   }

   public static void c45105(double var0, double var2, double var4, double var6, int var8) {
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
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c44835(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      c72819(var0, var1, var2, var3, var6);
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

   public static void c63485() {
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
   }

   public static void c49213() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glColor3d(1.0D, 1.0D, 1.0D);
   }

   public static void c41352() {
      GL11.glEnable(3042);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
   }

   public static void c23260() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static Color c34337(Color var0, Color var1, double var2) {
      float var4 = (float)var2;
      float var5 = 1.0F - var4;
      float[] var6 = new float[3];
      float[] var7 = new float[3];
      var0.getColorComponents(var6);
      var1.getColorComponents(var7);
      Color var8 = new Color(var6[0] * var4 + var7[0] * var5, var6[1] * var4 + var7[1] * var5, var6[2] * var4 + var7[2] * var5);
      return var8;
   }

   public static void c80882() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c57186(int var0, float var1) {
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GlStateManager.color(var2, var3, var4, var1);
   }

   public static void c8687(boolean var0) {
      Module[] var1 = Value.c27574();
      if (var0) {
         GlStateManager.enableBlend();
         GL11.glEnable(2848);
         GlStateManager.disableDepth();
         GlStateManager.disableTexture2D();
         GlStateManager.blendFunc(770, 771);
         GL11.glHint(3154, 4354);
      }

      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
      GL11.glDisable(2848);
      GlStateManager.enableDepth();
      GlStateManager.depthMask(!var0);
   }

   public static void c24918(int var0) {
      c57186(var0, (float)(var0 >> 24 & 255) / 255.0F);
   }

   public static int c54152(int var0, float var1) {
      Color var2 = new Color(var0);
      return c7378(var2, var1).getRGB();
   }

   public static Color c7378(Color var0, float var1) {
      var1 = Math.min(1.0F, Math.max(0.0F, var1));
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), (int)((float)var0.getAlpha() * var1));
   }

   public static float c60700(float var0, float var1, double var2) {
      return c3362((double)var0, (double)var1, (double)((float)var2)).floatValue();
   }

   public static int c25849(int var0, int var1, double var2) {
      return c3362((double)var0, (double)var1, (double)((float)var2)).intValue();
   }

   public static Color c58163(Color var0, Color var1, float var2) {
      var2 = Math.min(1.0F, Math.max(0.0F, var2));
      return new Color(c25849(var0.getRed(), var1.getRed(), (double)var2), c25849(var0.getGreen(), var1.getGreen(), (double)var2), c25849(var0.getBlue(), var1.getBlue(), (double)var2), c25849(var0.getAlpha(), var1.getAlpha(), (double)var2));
   }

   public static void c11655(int var0) {
      GL11.glBindTexture(3553, var0);
   }

   public static void c39067(ItemStack var0, float var1, float var2) {
      RenderHelper.disableStandardItemLighting();
      GlStateManager.pushMatrix();
      RenderHelper.enableGUIStandardItemLighting();
      GlStateManager.disableAlpha();
      GlStateManager.clear(256);
      mc.getRenderItem().zLevel = -150.0F;
      GlStateManager.disableLighting();
      GlStateManager.disableDepth();
      GlStateManager.disableBlend();
      GlStateManager.enableLighting();
      GlStateManager.enableDepth();
      GlStateManager.disableLighting();
      GlStateManager.disableDepth();
      GlStateManager.disableTexture2D();
      GlStateManager.disableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.enableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
      GlStateManager.enableLighting();
      GlStateManager.enableDepth();
      mc.getRenderItem().renderItemIntoGUI(var0, (int)var1, (int)var2);
      mc.getRenderItem().zLevel = 0.0F;
      RenderHelper.enableGUIStandardItemLighting();
      GlStateManager.disableLighting();
      GlStateManager.disableDepth();
      GlStateManager.disableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.pushMatrix();
      GlStateManager.translate(var1, var2, 0.0F);
      mc.getRenderItem().renderItemOverlayIntoGUI(mc.fontRendererObj, var0, 0, 0, (String)null);
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.popMatrix();
   }

   private static JSONException c24145(JSONException var0) {
      return var0;
   }
}
