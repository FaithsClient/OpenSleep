package rip.sleep.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.vecmath.Vector3d;
import rip.sleep.injection.in.IEntityRenderer;
import rip.sleep.injection.in.IRenderManager;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Timer;
import org.json.JSONException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.GLU;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.modules.KillAura;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public final class RenderUtilD {
   private static final Minecraft c9886 = Minecraft.getMinecraft();
   private static final Frustum c14120 = new Frustum();
   public static double c15833;
   private static final double c81226 = 0.0D;
   private static final double c93645 = 0.0D;
   private static final Map<Integer, Boolean> c20622 = new HashMap();
   static int c41508;
   private static final TimerUtilB c31634 = new TimerUtilB();
   private static final HashMap<Double, Integer> c79219 = new HashMap();
   private static final IntBuffer c69797 = GLAllocation.createDirectIntBuffer(16);
   private static final FloatBuffer c63574 = GLAllocation.createDirectFloatBuffer(16);
   private static final FloatBuffer c76984 = GLAllocation.createDirectFloatBuffer(16);
   public static boolean c62301 = false;
   public static float c23935 = 0.0F;
   public static boolean c81051 = false;
   public static float c35764 = 0.0F;
   static Tessellator c62754 = Tessellator.getInstance();
   static WorldRenderer c40407 = c62754.getWorldRenderer();
   private static final FloatBuffer c84866 = GLAllocation.createDirectFloatBuffer(16);
   private static final FloatBuffer c27006 = GLAllocation.createDirectFloatBuffer(4);

   public static double c26089(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }

   public static boolean c29156(Entity var0) {
      Module[] var1 = Value.c27574();
      return c30686(var0.getEntityBoundingBox()) || var0.ignoreFrustumCheck;
   }

   private static boolean c30686(AxisAlignedBB var0) {
      Entity var1 = c9886.getRenderViewEntity();
      c14120.setPosition(var1.posX, var1.posY, var1.posZ);
      return c14120.isBoundingBoxInFrustum(var0);
   }

   public static void c5727(ResourceLocation var0, double var1, double var3, double var5, double var7) {
      c9886.getTextureManager().bindTexture(var0);
      float var9 = 1.0F / (float)var5;
      float var10 = 1.0F / (float)var7;
      Tessellator var11 = Tessellator.getInstance();
      WorldRenderer var12 = var11.getWorldRenderer();
      var12.begin(7, DefaultVertexFormats.POSITION_TEX);
      var12.pos(var1, var3 + var7, 0.0D).tex((double)(0.0F * var9), (double)((0.0F + (float)var7) * var10)).endVertex();
      var12.pos(var1 + var5, var3 + var7, 0.0D).tex((double)((0.0F + (float)var5) * var9), (double)((0.0F + (float)var7) * var10)).endVertex();
      var12.pos(var1 + var5, var3, 0.0D).tex((double)((0.0F + (float)var5) * var9), (double)(0.0F * var10)).endVertex();
      var12.pos(var1, var3, 0.0D).tex((double)(0.0F * var9), (double)(0.0F * var10)).endVertex();
      var11.draw();
   }

   public static void c4482(float var0, float var1, float var2, float var3, int var4) {
      float var5 = (float)(var4 >> 24 & 255) / 255.0F;
      float var6 = (float)(var4 >> 16 & 255) / 255.0F;
      float var7 = (float)(var4 >> 8 & 255) / 255.0F;
      float var8 = (float)(var4 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var6, var7, var8, var5);
      GL11.glBegin(7);
      GL11.glVertex2d((double)var2, (double)var1);
      GL11.glVertex2d((double)var0, (double)var1);
      GL11.glVertex2d((double)var0, (double)var3);
      GL11.glVertex2d((double)var2, (double)var3);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c34980(double var0, double var2, double var4, double var6, int var8, int var9) {
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
      GlStateManager.disableAlpha();
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
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void c42978(float var0, float var1, float var2, float var3) {
      ScaledResolution var4 = new ScaledResolution(c9886);
      int var5 = var4.getScaleFactor();
      GL11.glScissor((int)(var0 * (float)var5), (int)(((float)var4.getScaledHeight() - var3) * (float)var5), (int)((var2 - var0) * (float)var5), (int)((var3 - var1) * (float)var5));
   }

   public static void c91676(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      c4482(var0, var1, var2, var3, var6);
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

   public static void c20367() {
      GL11.glEnable(2848);
      GL11.glEnable(2881);
      GL11.glEnable(2832);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glHint(3153, 4354);
   }

   public static void c60785() {
      GL11.glDisable(2848);
      GL11.glDisable(2881);
      GL11.glEnable(2832);
   }

   public static void c63841(ScaledResolution var0) {
      c4482(0.0F, 0.0F, (float)var0.getScaledWidth(), (float)var0.getScaledHeight(), (new Color(34, 34, 34)).getRGB());
      c5727(new ResourceLocation("client/images/background.png"), 0.0D, 0.0D, (double)var0.getScaledWidth(), (double)var0.getScaledHeight());
   }

   public static void c13468(double var0, double var2, double var4, double var6, double var8, int var10, int var11, boolean var12) {
      c24215(var0 - var8, var2 - var8, var4 + var8, var6 + var8, var11);
      c24215(var0 + var8, var2 + var8, var4 - var8, var6 - var8, var10);
   }

   public static void c79354(double var0, double var2, double var4, double var6, double var8, int var10) {
      c24215(var0, var2, var0 + var4, var2 + var8, var10);
      c24215(var0, var2, var0 + var8, var2 + var6, var10);
      c24215(var0, var2 + var6 - var8, var0 + var4, var2 + var6, var10);
      c24215(var0 + var4 - var8, var2, var0 + var4, var2 + var6, var10);
   }

   public static void c58889(double var0, double var2, double var4, double var6, int var8, int var9) {
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
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0, var6);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d(var4, var6);
      GL11.glVertex2d(var4, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void c24215(double var0, double var2, double var4, double var6, int var8) {
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

   public static void c96691(double var0, double var2, double var4, double var6, float var8) {
      Module[] var9 = Value.c27574();
      if (var0 < var4) {
         double var10 = var0;
         var0 = var4;
         var4 = var10;
      }

      if (var2 < var6) {
         double var12 = var2;
         var2 = var6;
         var6 = var12;
      }

      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var11 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(0.1F, 0.1F, 0.1F, var8);
      var11.begin(7, DefaultVertexFormats.POSITION);
      var11.pos(var0, var6, 0.0D).endVertex();
      var11.pos(var4, var6, 0.0D).endVertex();
      var11.pos(var4, var2, 0.0D).endVertex();
      var11.pos(var0, var2, 0.0D).endVertex();
      var13.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c71151(AxisAlignedBB var0) {
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

   public static void c66013(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      c71151(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      c36389(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c72774(double var0, double var2, double var4, int var6, int var7, float var8) {
      float var9 = (float)(var6 >> 24 & 255) / 255.0F;
      float var10 = (float)(var6 >> 16 & 255) / 255.0F;
      float var11 = (float)(var6 >> 8 & 255) / 255.0F;
      float var12 = (float)(var6 & 255) / 255.0F;
      float var13 = (float)(var7 >> 24 & 255) / 255.0F;
      float var14 = (float)(var7 >> 16 & 255) / 255.0F;
      float var15 = (float)(var7 >> 8 & 255) / 255.0F;
      float var16 = (float)(var7 & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var9);
      c36389(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glLineWidth(var8);
      GL11.glColor4f(var14, var15, var16, var13);
      c36389(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c36389(AxisAlignedBB var0) {
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

   public static void c72575(double var0, double var2, double var4, double var6, int var8) {
      Module[] var9 = Value.c27574();
      if (var0 < var4) {
         double var10 = var0;
         var0 = var4;
         var4 = var10;
      }

      if (var2 < var6) {
         double var18 = var2;
         var2 = var6;
         var6 = var18;
      }

      float var12 = (float)(var8 >> 24 & 255) / 255.0F;
      float var13 = (float)(var8 >> 16 & 255) / 255.0F;
      float var14 = (float)(var8 >> 8 & 255) / 255.0F;
      float var15 = (float)(var8 & 255) / 255.0F;
      Tessellator var16 = Tessellator.getInstance();
      WorldRenderer var17 = var16.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var13, var14, var15, var12);
      var17.begin(7, DefaultVertexFormats.POSITION);
      var17.pos(var0, var6, 0.0D).endVertex();
      var17.pos(var4, var6, 0.0D).endVertex();
      var17.pos(var4, var2, 0.0D).endVertex();
      var17.pos(var0, var2, 0.0D).endVertex();
      var16.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c84676(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      c72575(var0 + var8, var2 + var8, var4 - var8, var6 - var8, var10);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c72575(var0 + var8, var2, var4 - var8, var2 + var8, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c72575(var0, var2, var0 + var8, var6, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c72575(var4 - var8, var2, var4, var6, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c72575(var0 + var8, var6 - var8, var4 - var8, var6, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c66739(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c14668(float var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      Value.c27574();
      GlStateManager.color(0.0F, 0.0F, 0.0F);
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

   public static void c49998(float var0, float var1, float var2, float var3, float var4, int var5) {
      c14668(var0, var1, var2, var3, var4, var4, var5);
   }

   public static void c70993(float var0, float var1, float var2, int var3) {
      c49998(var0, var1, 0.0F, 360.0F, var2, var3);
   }

   public static void c29386(float var0, float var1, float var2, float var3, float var4, int var5) {
      var0 = var0 + (float)((double)(var4 / 2.0F) + 0.5D);
      var1 = var1 + (float)((double)(var4 / 2.0F) + 0.5D);
      var2 = var2 - (float)((double)(var4 / 2.0F) + 0.5D);
      var3 = var3 - (float)((double)(var4 / 2.0F) + 0.5D);
      Gui.drawRect((int)var0, (int)var1, (int)var2, (int)var3, var5);
      c70993(var2 - var4 / 2.0F, var1 + var4 / 2.0F, var4, var5);
      c70993(var0 + var4 / 2.0F, var3 - var4 / 2.0F, var4, var5);
      c70993(var0 + var4 / 2.0F, var1 + var4 / 2.0F, var4, var5);
      c70993(var2 - var4 / 2.0F, var3 - var4 / 2.0F, var4, var5);
      Gui.drawRect((int)(var0 - var4 / 2.0F - 0.5F), (int)(var1 + var4 / 2.0F), (int)var2, (int)(var3 - var4 / 2.0F), var5);
      Gui.drawRect((int)var0, (int)(var1 + var4 / 2.0F), (int)(var2 + var4 / 2.0F + 0.5F), (int)(var3 - var4 / 2.0F), var5);
      Gui.drawRect((int)(var0 + var4 / 2.0F), (int)(var1 - var4 / 2.0F - 0.5F), (int)(var2 - var4 / 2.0F), (int)(var3 - var4 / 2.0F), var5);
      Gui.drawRect((int)(var0 + var4 / 2.0F), (int)var1, (int)(var2 - var4 / 2.0F), (int)(var3 + var4 / 2.0F + 0.5F), var5);
   }

   public static void c70228(ResourceLocation var0, int var1, int var2, int var3, int var4, Color var5) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f((float)var5.getRed() / 255.0F, (float)var5.getBlue() / 255.0F, (float)var5.getRed() / 255.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      Gui.drawModalRectWithCustomSizedTexture(var1, var2, 0.0F, 0.0F, var3, var4, (float)var3, (float)var4);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void c97934(float var0) {
      c23935 = var0;
      c62301 = true;
      c9886.thePlayer.rotationYawHead = var0;
   }

   public static void c15352() {
      c62301 = false;
   }

   public static float c18797() {
      return c23935;
   }

   public static void c68204(float var0) {
      c35764 = var0;
      c81051 = true;
   }

   public static void c6999() {
      c81051 = false;
   }

   public static float c73999() {
      return c35764;
   }

   public static void c75802(Color var0) {
      float var1 = (float)var0.getRed() / 255.0F;
      float var2 = (float)var0.getGreen() / 255.0F;
      float var3 = (float)var0.getBlue() / 255.0F;
      float var4 = (float)var0.getAlpha() / 255.0F;
      GlStateManager.color(var1, var2, var3, var4);
   }

   public static void c1980() {
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
   }

   public static void c99854() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glColor3d(1.0D, 1.0D, 1.0D);
   }

   public static void c77696(int var0, int var1, int var2, EntityLivingBase var3) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale((float)(-var2), (float)var2, (float)var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var4 = var3.renderYawOffset;
      float var5 = var3.rotationYaw;
      float var6 = var3.rotationPitch;
      float var7 = var3.prevRotationYawHead;
      float var8 = var3.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(0.0F, 1.0F, 0.0F, 0.0F);
      var3.renderYawOffset = (float)(10 * var3.ticksExisted % 360);
      var3.rotationYaw = (float)(10 * var3.ticksExisted % 360);
      var3.rotationPitch = 0.0F;
      var3.rotationYawHead = var3.rotationYaw;
      var3.prevRotationYawHead = var3.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var9 = Minecraft.getMinecraft().getRenderManager();
      var9.setPlayerViewY(180.0F);
      var9.setRenderShadow(false);
      var9.renderEntityWithPosYaw(var3, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var9.setRenderShadow(true);
      var3.renderYawOffset = var4;
      var3.rotationYaw = var5;
      var3.rotationPitch = var6;
      var3.prevRotationYawHead = var7;
      var3.rotationYawHead = var8;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static void c45040(ItemStack var0, int var1, int var2) {
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
      Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(var0, var1, var2);
      Minecraft.getMinecraft().getRenderItem().renderItemOverlays(Minecraft.getMinecraft().fontRendererObj, var0, var1, var2);
      Minecraft.getMinecraft().getRenderItem().zLevel = 0.0F;
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableCull();
      GlStateManager.enableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.disableLighting();
      GlStateManager.disableDepth();
      GlStateManager.enableDepth();
      GlStateManager.popMatrix();
   }

   public static int c88625(float var0, float var1) {
      float var2 = var0 / var1 / 3.0F;
      return Color.HSBtoRGB(var2, 1.0F, 1.0F);
   }

   public static void c26178(float var0, float var1, float var2, float var3, int var4) {
      c4482(var0, var1, var0 + var2, var1 + var3, var4);
   }

   public static double c60774(double var0, double var2, double var4) {
      return (1.0D - var4) * var0 + var4 * var2;
   }

   public static double c86345(double var0, double var2, float var4) {
      return var0 + (var2 - var0) * (double)var4;
   }

   public static float c51250(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public static void c20913() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void c95165() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void c35946(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c11584(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      c20913();
      c4482(var0, var1, var2, var3, var5);
      c35946(var6);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(var4);
      GL11.glBegin(3);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      GL11.glVertex2f(var0, var1);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      c95165();
   }

   public static void c3264() {
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

   public static void c45487(float var0) {
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

   public static void c40000(Entity var0, double var1, double var3, double var5, double var7, int var9, int var10) {
      Cylinder var11 = new Cylinder();
      GL11.glPushMatrix();
      GL11.glTranslated(var1, var3, var5);
      c35946(0);
      c45487(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      c35946(var10);
      GL11.glBegin(2);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), 0.0F, var9, 0);
      var11.setDrawStyle(100011);
      c3264();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GlStateManager.translate(var1, var3, var5);
      c45487(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      c35946(var10);
      GL11.glBegin(2);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), 0.0F, var9, 0);
      c3264();
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void c75224(Entity var0, double var1, double var3, double var5, double var7, int var9, int var10) {
      Cylinder var11 = new Cylinder();
      GL11.glPushMatrix();
      GL11.glTranslated(var1, var3, var5);
      c35946(0);
      c45487(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      c35946(var10);
      GL11.glBegin(3);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), 0.0F, var9, 0);
      var11.setDrawStyle(100011);
      c3264();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GlStateManager.translate(var1, var3, var5);
      c45487(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      c35946(var10);
      GL11.glBegin(3);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), 0.0F, var9, 0);
      c3264();
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void c43711(AxisAlignedBB var0) {
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

   public static void c51961(ResourceLocation var0, int var1, int var2, int var3, int var4) {
      new ScaledResolution(Minecraft.getMinecraft());
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
   }

   public static int c71054(int var0, int var1, float var2) {
      float var3 = 1.0F - var2;
      int var4 = (int)((float)(var0 >> 16 & 255) * var3 + (float)(var1 >> 16 & 255) * var2);
      int var5 = (int)((float)(var0 >> 8 & 255) * var3 + (float)(var1 >> 8 & 255) * var2);
      int var6 = (int)((float)(var0 & 255) * var3 + (float)(var1 & 255) * var2);
      int var7 = (int)((float)(var0 >> 24 & 255) * var3 + (float)(var1 >> 24 & 255) * var2);
      return (var7 & 255) << 24 | (var4 & 255) << 16 | (var5 & 255) << 8 | var6 & 255;
   }

   public static void c11604() {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
   }

   public static void c68793(int var0) {
      GL11.glColor4ub((byte)(var0 >> 16 & 255), (byte)(var0 >> 8 & 255), (byte)(var0 & 255), (byte)(var0 >> 24 & 255));
   }

   public static void c62268(Color var0) {
      float var1 = (float)var0.getRed() / 255.0F;
      float var2 = (float)var0.getGreen() / 255.0F;
      float var3 = (float)var0.getBlue() / 255.0F;
      float var4 = (float)var0.getAlpha() / 255.0F;
      GlStateManager.color(var1, var2, var3, var4);
   }

   public static void c68038(AxisAlignedBB var0, Color var1) {
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)var1.getRed() / 255.0F, (float)var1.getGreen() / 255.0F, (float)var1.getBlue() / 255.0F, 0.25F);
      c9711(var0);
      GlStateManager.resetColor();
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
   }

   public static void c9711(AxisAlignedBB var0) {
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

   public static void c72684() {
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

   public static void c19925() {
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      if (!GL11.glIsEnabled(2896)) {
         ;
      }

   }

   public static void c64796(BlockPos var0, int var1) {
      double var2 = (double)var0.getX() - c9886.getRenderManager().renderPosX + 0.5D;
      double var4 = (double)var0.getY() - c9886.getRenderManager().renderPosY + 0.5D;
      double var6 = (double)var0.getZ() - c9886.getRenderManager().renderPosZ + 0.5D;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
      float var10000 = (float)(c9886.thePlayer.posX - (double)var0.getX());
      var10000 = (float)(c9886.thePlayer.posY - (double)var0.getY());
      float var10 = (float)(var1 >> 16 & 255) / 255.0F;
      float var11 = (float)(var1 >> 8 & 255) / 255.0F;
      float var12 = (float)(var1 & 255) / 255.0F;
      float var13 = (float)(var1 >> 24 & 255) / 255.0F;
      GL11.glColor4f(var10, var11, var12, var13);
      GL11.glLoadIdentity();
      boolean var14 = c9886.gameSettings.viewBobbing;
      c9886.gameSettings.viewBobbing = false;
      ((IEntityRenderer)c9886.entityRenderer).runorientCamera(ChatUtilA.c14057().renderPartialTicks);
      GL11.glBegin(3);
      GL11.glVertex3d(0.0D, (double)c9886.thePlayer.getEyeHeight(), 0.0D);
      GL11.glVertex3d(var2, var4, var6);
      GL11.glVertex3d(var2, var4, var6);
      GL11.glEnd();
      c9886.gameSettings.viewBobbing = var14;
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c67976(double var0, double var2, double var4, int var6) {
      double var7 = var0 - c9886.getRenderManager().renderPosX;
      double var9 = var2 - c9886.getRenderManager().renderPosY;
      double var11 = var4 - c9886.getRenderManager().renderPosZ;
      float var13 = (float)(var6 >> 16 & 255) / 255.0F;
      float var14 = (float)(var6 >> 8 & 255) / 255.0F;
      float var15 = (float)(var6 & 255) / 255.0F;
      float var16 = (float)(var6 >> 24 & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth(1.0F);
      GL11.glColor4f(var13, var14, var15, var16);
      c36389(new AxisAlignedBB(var7, var9, var11, var7 + 1.0D, var9 + 1.0D, var11 + 1.0D));
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c18841(BlockPos var0) {
      Value.c27574();
      IBlockState var2 = c9886.theWorld.getBlockState(var0);
      Block var3 = var2.getBlock();
      GL11.glPushMatrix();
      GL11.glTranslated(-c9886.getRenderManager().renderPosX, -c9886.getRenderManager().renderPosY, -c9886.getRenderManager().renderPosZ);
      IBakedModel var4 = c9886.getBlockRendererDispatcher().getBlockModelShapes().getModelForState(var2);
      c9886.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
      c40407.begin(7, DefaultVertexFormats.BLOCK);
      c40407.setTranslation(0.0D, 0.0D, 0.0D);
      GL11.glDisable(2929);
      EnumFacing[] var5 = EnumFacing.values();
      int var6 = var5.length;
      int var7 = 0;
      if (var7 < var6) {
         EnumFacing var10000 = var5[var7];
         c9886.getBlockRendererDispatcher().getBlockModelRenderer().renderModel(c9886.theWorld, var4, var2, var0, c40407, false);
         ++var7;
      }

      GL11.glEnable(2929);
      c62754.draw();
      GL11.glPopMatrix();
   }

   private static void c15293(WorldRenderer var0, double var1, double var3, double var5, EnumFacing var7) {
      Module[] var8 = Value.c27574();
      switch(null.c71221[var7.ordinal()]) {
      case 1:
         var0.pos(var1, var3, var5).endVertex();
         var0.pos(var1, var3, var5 + 1.0D).endVertex();
         var0.pos(var1 + 1.0D, var3, var5 + 1.0D).endVertex();
         var0.pos(var1 + 1.0D, var3, var5).endVertex();
      case 2:
         var0.pos(var1, var3 + 1.0D, var5).endVertex();
         var0.pos(var1, var3 + 1.0D, var5 + 1.0D).endVertex();
         var0.pos(var1 + 1.0D, var3 + 1.0D, var5 + 1.0D).endVertex();
         var0.pos(var1 + 1.0D, var3 + 1.0D, var5).endVertex();
      case 3:
         var0.pos(var1, var3, var5).endVertex();
         var0.pos(var1 + 1.0D, var3, var5).endVertex();
         var0.pos(var1 + 1.0D, var3 + 1.0D, var5).endVertex();
         var0.pos(var1, var3 + 1.0D, var5).endVertex();
      case 4:
         var0.pos(var1, var3, var5 + 1.0D).endVertex();
         var0.pos(var1 + 1.0D, var3, var5 + 1.0D).endVertex();
         var0.pos(var1 + 1.0D, var3 + 1.0D, var5 + 1.0D).endVertex();
         var0.pos(var1, var3 + 1.0D, var5 + 1.0D).endVertex();
      case 5:
         var0.pos(var1, var3, var5).endVertex();
         var0.pos(var1, var3 + 1.0D, var5).endVertex();
         var0.pos(var1, var3 + 1.0D, var5 + 1.0D).endVertex();
         var0.pos(var1, var3, var5 + 1.0D).endVertex();
      case 6:
         var0.pos(var1 + 1.0D, var3, var5).endVertex();
         var0.pos(var1 + 1.0D, var3 + 1.0D, var5).endVertex();
         var0.pos(var1 + 1.0D, var3 + 1.0D, var5 + 1.0D).endVertex();
         var0.pos(var1 + 1.0D, var3, var5 + 1.0D).endVertex();
      default:
      }
   }

   public static void c75174(double var0, double var2, double var4, double var6, float var8, int var9, int var10) {
      c4482((float)var0, (float)var2, (float)var4, (float)var6, var10);
      float var11 = (float)(var9 >> 24 & 255) / 255.0F;
      float var12 = (float)(var9 >> 16 & 255) / 255.0F;
      float var13 = (float)(var9 >> 8 & 255) / 255.0F;
      float var14 = (float)(var9 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var12, var13, var14, var11);
      GL11.glLineWidth(var8);
      GL11.glBegin(1);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      GL11.glVertex2d(var4, var2);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var4, var2);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glPopMatrix();
      GL11.glColor4f(255.0F, 1.0F, 1.0F, 255.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void c97417(EntityLivingBase var0, Render3DEvent var1) {
      float var3 = 0.25F;
      Value.c27574();
      float var4 = 4.0F;
      GL11.glPushMatrix();
      double var5 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)var1.c36064();
      double var7 = var5 - ((IRenderManager)c9886.getRenderManager()).getVieWerPosX();
      double var9 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)var1.c36064();
      double var11 = var9 - ((IRenderManager)c9886.getRenderManager()).getVieWerPosY() + (double)var0.height * 1.1D;
      double var13 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)var1.c36064();
      GL11.glTranslated(var7, var11, var13 - ((IRenderManager)c9886.getRenderManager()).getVieWerPosZ());
      GL11.glRotatef(-var0.width, 0.0F, 1.0F, 0.0F);
      c35946(var0.hurtTime <= 0 ? (new Color(80, 255, 80, 80)).getRGB() : (new Color(255, 0, 0, 80)).getRGB());
      c45487(1.5F);
      Cylinder var15 = new Cylinder();
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      var15.draw(0.0F, 0.25F, 0.3F, 4, 1);
      var15.setDrawStyle(100012);
      GL11.glTranslated(0.0D, 0.0D, 0.3D);
      var15.draw(0.25F, 0.0F, 0.3F, 4, 1);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslated(0.0D, 0.0D, -0.3D);
      var15.draw(0.0F, 0.25F, 0.3F, 4, 1);
      GL11.glTranslated(0.0D, 0.0D, 0.3D);
      var15.draw(0.25F, 0.0F, 0.3F, 4, 1);
      c3264();
      GL11.glPopMatrix();
   }

   public static void c41893(Entity var0, Color var1) {
      RenderManager var2 = c9886.getRenderManager();
      Timer var3 = c9886.timer;
      GL11.glBlendFunc(770, 771);
      c37784(3042);
      c28586(3553, 2929);
      GL11.glDepthMask(false);
      double var4 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)var3.renderPartialTicks - var2.renderPosX;
      double var6 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)var3.renderPartialTicks - var2.renderPosY;
      double var8 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)var3.renderPartialTicks - var2.renderPosZ;
      AxisAlignedBB var10 = var0.getEntityBoundingBox();
      AxisAlignedBB var11 = new AxisAlignedBB(var10.minX - var0.posX + var4 - 0.1D, var10.minY - var0.posY + var6, var10.minZ - var0.posZ + var8 - 0.1D, var10.maxX - var0.posX + var4 + 0.1D, var10.maxY - var0.posY + var6 + 0.15D, var10.maxZ - var0.posZ + var8 + 0.1D);
      GL11.glLineWidth(1.0F);
      c37784(2848);
      c41270(var1.getRed(), var1.getGreen(), var1.getBlue(), var1.getAlpha() + 75);
      c43711(var11);
      c41270(var1.getRed(), var1.getGreen(), var1.getBlue(), var1.getAlpha());
      c9711(var11);
      GlStateManager.resetColor();
      GL11.glDepthMask(true);
      c85709();
   }

   public static void c96014(Entity var0, Color var1) {
      Module[] var2 = Value.c27574();
      if (KillAura.c19685 != null) {
         double var3 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager)c9886.getRenderManager()).getRenderPosX();
         double var5 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager)c9886.getRenderManager()).getRenderPosY();
         double var7 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager)c9886.getRenderManager()).getRenderPosZ();
         AxisAlignedBB var9 = var0.getEntityBoundingBox().offset(-var0.posX, -var0.posY, -var0.posZ).offset(var3, var5 - 0.41D, var7);
         c68038(new AxisAlignedBB(var9.minX, var9.maxY + 0.2D, var9.minZ, var9.maxX, var9.maxY + 0.26D, var9.maxZ), var1);
      }

   }

   private static void c44791(float var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8, float var9) {
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

   public static void c72884(float var0, float var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9) {
      c44791(var0, var1, var2, var3, (float)var4, (float)var5, var6, var7, var8, var9);
   }

   public static void c34429(int var0, int var1, int var2, NetworkPlayerInfo var3) {
      c9886.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
      byte var5 = 0;
      Value.c27574();
      byte var6 = 0;
      if (var3 != null) {
         if (var3.getResponseTime() < 0) {
            var5 = (boolean)5;
         }

         if (var3.getResponseTime() < 150) {
            var5 = (boolean)0;
         }

         if (var3.getResponseTime() < 300) {
            var5 = (boolean)1;
         }

         if (var3.getResponseTime() < 600) {
            var5 = (boolean)2;
         }

         if (var3.getResponseTime() < 1000) {
            var5 = (boolean)3;
         }

         var5 = (boolean)4;
      }

      var5 = 0;
      c31980(var1 + var0 - 11, var2, var6 * 10, 176 + var5 * 8, 10, 8);
   }

   public static void c31980(int var0, int var1, int var2, int var3, int var4, int var5) {
      float var6 = 0.00390625F;
      Tessellator var7 = Tessellator.getInstance();
      WorldRenderer var8 = var7.getWorldRenderer();
      var8.begin(7, DefaultVertexFormats.POSITION_TEX);
      var8.pos((double)var0, (double)(var1 + var5), 0.0D).tex((double)((float)var2 * var6), (double)((float)(var3 + var5) * var6)).endVertex();
      var8.pos((double)(var0 + var4), (double)(var1 + var5), 0.0D).tex((double)((float)(var2 + var4) * var6), (double)((float)(var3 + var5) * var6)).endVertex();
      var8.pos((double)(var0 + var4), (double)var1, 0.0D).tex((double)((float)(var2 + var4) * var6), (double)((float)var3 * var6)).endVertex();
      var8.pos((double)var0, (double)var1, 0.0D).tex((double)((float)var2 * var6), (double)((float)var3 * var6)).endVertex();
      var7.draw();
   }

   public static void c30513(double var0, double var2, double var4, double var6, Color var8) {
      c87589(var0, var2, var4, var6, true, var8);
   }

   public static void c87589(double var0, double var2, double var4, double var6, boolean var8, Color var9) {
      Value.c27574();
      c3920();
      if (var9 != null) {
         c755(var9);
      }

      c93156(var8 ? 6 : 1);
      c84997(var0, var2);
      c84997(var0 + var4, var2);
      c84997(var0 + var4, var2 + var6);
      c84997(var0, var2 + var6);
      c84997(var0, var2);
      c84997(var0, var2 + var6);
      c84997(var0 + var4, var2);
      c84997(var0 + var4, var2 + var6);
      c61258();
      c57303();
   }

   public static void c3920() {
      c21899(3042);
      GL11.glBlendFunc(770, 771);
      c39843(3553);
      c39843(2884);
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
   }

   public static void c21899(int var0) {
      GL11.glEnable(var0);
   }

   public static void c755(Color var0) {
      Module[] var1 = Value.c27574();
      if (var0 == null) {
         var0 = Color.white;
      }

      c28070((double)((float)var0.getRed() / 255.0F), (double)((float)var0.getGreen() / 255.0F), (double)((float)var0.getBlue() / 255.0F), (double)((float)var0.getAlpha() / 255.0F));
   }

   public static void c28070(double var0, double var2, double var4, double var6) {
      GL11.glColor4d(var0, var2, var4, var6);
   }

   public static void c68399(float var0) {
      GL11.glLineWidth(var0);
   }

   public static void c93156(int var0) {
      GL11.glBegin(var0);
   }

   public static void c84997(double var0, double var2) {
      GL11.glVertex2d(var0, var2);
   }

   public static void c61258() {
      GL11.glEnd();
   }

   public static void c57303() {
      GlStateManager.enableAlpha();
      GlStateManager.enableDepth();
      c21899(2884);
      c21899(3553);
      c39843(3042);
      c755(Color.white);
   }

   public static void c39843(int var0) {
      GL11.glDisable(var0);
   }

   public static void c43637(float var0, float var1, int var2, int var3, ResourceLocation var4, Color var5) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f((float)var5.getRed() / 255.0F, (float)var5.getGreen() / 255.0F, (float)var5.getBlue() / 255.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var4);
      Gui.drawModalRectWithCustomSizedTexture((int)var0, (int)var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void c47895(double var0, double var2, double var4, int var6) {
      Value.c27574();
      GL11.glEnable(32925);
      GL11.glEnable(2881);
      float var8 = (float)(var6 >> 24 & 255) / 255.0F;
      float var9 = (float)(var6 >> 16 & 255) / 255.0F;
      float var10 = (float)(var6 >> 8 & 255) / 255.0F;
      float var11 = (float)(var6 & 255) / 255.0F;
      boolean var12 = GL11.glIsEnabled(3042);
      boolean var13 = GL11.glIsEnabled(2848);
      boolean var14 = GL11.glIsEnabled(3553);
      if (!var12) {
         GL11.glEnable(3042);
      }

      if (!var13) {
         GL11.glEnable(2848);
      }

      if (var14) {
         GL11.glDisable(3553);
      }

      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(var9, var10, var11, var8);
      GL11.glBegin(9);
      int var15 = 0;
      if (var15 <= 360) {
         GL11.glVertex2d(var0 + Math.sin((double)var15 * 3.141526D / 180.0D) * var4, var2 + Math.cos((double)var15 * 3.141526D / 180.0D) * var4);
         ++var15;
      }

      GL11.glEnd();
      if (var14) {
         GL11.glEnable(3553);
      }

      if (!var13) {
         GL11.glDisable(2848);
      }

      if (!var12) {
         GL11.glDisable(3042);
      }

      GL11.glDisable(2881);
      GL11.glClear(0);
   }

   public static void c64461(float var0, float var1, float var2, float var3, int var4) {
      c29386(var0, var1, var2, var3, (float)var4, var4);
      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }

   public static int c71974(int var0, float var1) {
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

   public static void c71511(BlockPos var0, Color var1, int var2, float var3) {
      Module[] var4 = Value.c27574();
   }

   public static void c41270(int var0, int var1, int var2, int var3) {
      GL11.glColor4f((float)var0 / 255.0F, (float)var1 / 255.0F, (float)var2 / 255.0F, (float)var3 / 255.0F);
   }

   public static void c85709() {
      c20622.forEach(RenderUtilD::c88810);
   }

   public static void c37784(int var0) {
      c7797(var0, true);
   }

   public static void c30837(int... var0) {
      Value.c27574();
      int var3 = var0.length;
      int var4 = 0;
      if (var4 < var3) {
         int var5 = var0[var4];
         c7797(var5, true);
         ++var4;
      }

   }

   public static void c25601(int var0) {
      c7797(var0, true);
   }

   public static void c28586(int... var0) {
      Value.c27574();
      int var3 = var0.length;
      int var4 = 0;
      if (var4 < var3) {
         int var5 = var0[var4];
         c7797(var5, false);
         ++var4;
      }

   }

   public static void c7797(int var0, boolean var1) {
      c20622.put(Integer.valueOf(var0), Boolean.valueOf(GL11.glGetBoolean(var0)));
      c88810(var0, var1);
   }

   public static void c88810(int var0, boolean var1) {
      Module[] var2 = Value.c27574();
      if (var1) {
         GL11.glEnable(var0);
      }

      GL11.glDisable(var0);
   }

   public static int c7777(int var0, int var1, int var2) {
      long var3 = (long)var1 * 1000L;
      float var5 = (float)((System.currentTimeMillis() + (long)(var2 * var0)) % var3) / ((float)var3 / 2.0F);
      return Color.HSBtoRGB(var5, 0.55F, 0.9F);
   }

   public static Color c3965(int var0, int var1, float var2, float var3) {
      float var4 = (float)((System.currentTimeMillis() + (long)var0) % (long)var1) / (float)var1;
      return Color.getHSBColor(var4, var2, var3);
   }

   public static void c42673(float var0) {
   }

   public static void c69664(EntityLivingBase var0, Color var1, boolean var2) {
      GL11.glPushMatrix();
      Value.c27574();
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glEnable(2848);
      float var4 = 0.0F;
      float var5 = 0.0F;
      int var6 = 0;
      if (c31634.c59305(10L)) {
         ++c41508;
         c31634.c69505();
      }

      c78914(var0);
      GL11.glLineWidth(1.0F);
      GL11.glBegin(3);
      int var7 = c41508;
      if (var7 < 100 + c41508) {
         double var8 = (double)(2 * var7) * 3.141592653589793D / 100.0D;
         Color var10 = var2 ? c3965(var6, 1000, 0.8F, 1.0F) : var1;
         GL11.glColor3d((double)((float)var10.getRed() / 255.0F), (double)((float)var10.getGreen() / 255.0F), (double)((float)var10.getBlue() / 255.0F));
         GL11.glVertex3d(Math.cos(var8) * 0.5D, (double)var4, Math.sin(var8) * 0.5D);
         float var10000 = var4 + var0.height / 100.0F;
         var6 += 10;
         ++var7;
      }

      GL11.glEnd();
      GL11.glBegin(3);
      var7 = 50 + c41508;
      if (var7 < 150 + c41508) {
         double var15 = (double)(2 * var7) * 3.141592653589793D / 100.0D;
         Color var16 = var2 ? c3965(var6, 1000, 0.8F, 1.0F) : var1;
         GL11.glColor3d((double)((float)var16.getRed() / 255.0F), (double)((float)var16.getGreen() / 255.0F), (double)((float)var16.getBlue() / 255.0F));
         GL11.glVertex3d(Math.cos(var15) * 0.5D, (double)var5, Math.sin(var15) * 0.5D);
         float var17 = var5 + var0.height / 100.0F;
         var6 = var6 + 10;
         ++var7;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(2929);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
   }

   private static void c78914(Entity var0) {
      float var1 = c9886.timer.renderPartialTicks;
      double var2 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)var1 - ((IRenderManager)c9886.getRenderManager()).getRenderPosX();
      double var4 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)var1 - ((IRenderManager)c9886.getRenderManager()).getRenderPosY();
      double var6 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)var1 - ((IRenderManager)c9886.getRenderManager()).getRenderPosZ();
      GL11.glTranslated(var2, var4, var6);
      GL11.glNormal3d(0.0D, 1.0D, 0.0D);
      GL11.glRotated((double)(-c9886.getRenderManager().playerViewY), 0.0D, 1.0D, 0.0D);
   }

   public static void c8988(int var0, int var1, int var2, float var3, float var4, EntityLivingBase var5, float var6) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale((float)(-var2), (float)var2, (float)var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var7 = var5.renderYawOffset;
      float var8 = var5.rotationYaw;
      float var9 = var5.rotationPitch;
      float var10 = var5.prevRotationYawHead;
      float var11 = var5.rotationYawHead;
      GlStateManager.rotate(var6, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-((float)Math.atan((double)(var4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.renderYawOffset = (float)Math.atan((double)(var3 / 40.0F)) * 20.0F;
      var5.rotationYaw = (float)Math.atan((double)(var3 / 40.0F)) * 40.0F;
      var5.rotationPitch = -((float)Math.atan((double)(var4 / 40.0F))) * 20.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var12 = Minecraft.getMinecraft().getRenderManager();
      var12.setPlayerViewY(180.0F);
      var12.setRenderShadow(false);
      var12.renderEntityWithPosYaw(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var12.setRenderShadow(true);
      var5.renderYawOffset = var7;
      var5.rotationYaw = var8;
      var5.rotationPitch = var9;
      var5.prevRotationYawHead = var10;
      var5.rotationYawHead = var11;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static void c90797(double var0, double var2, double var4, double var6, double var8, Color var10) {
      double var11 = Math.abs(var4 - var0);
      double var13 = Math.abs(var6 - var2);
      double var15 = var11 / 4.0D;
      double var17 = var13 / 4.0D;
      c82517();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var8);
      c59336(var10);
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
      c32007();
   }

   public static void c59336(Color var0) {
      float var1 = (float)(var0.getRGB() >> 24 & 255) / 255.0F;
      float var2 = (float)(var0.getRGB() >> 16 & 255) / 255.0F;
      float var3 = (float)(var0.getRGB() >> 8 & 255) / 255.0F;
      float var4 = (float)(var0.getRGB() & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c82517() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void c32007() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c23072(Entity var0, Color var1) {
      RenderManager var2 = c9886.getRenderManager();
      Timer var3 = c9886.timer;
      GlStateManager.pushMatrix();
      GL11.glBlendFunc(770, 771);
      c37784(3042);
      c28586(3553, 2929);
      GL11.glDepthMask(false);
      double var4 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)var3.renderPartialTicks - var2.renderPosX;
      double var6 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)var3.renderPartialTicks - var2.renderPosY;
      double var8 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)var3.renderPartialTicks - var2.renderPosZ;
      AxisAlignedBB var10 = var0.getEntityBoundingBox();
      AxisAlignedBB var11 = new AxisAlignedBB(var10.minX - var0.posX + var4 - 0.05D, var10.minY - var0.posY + var6, var10.minZ - var0.posZ + var8 - 0.05D, var10.maxX - var0.posX + var4 + 0.05D, var10.maxY - var0.posY + var6 + 0.15D, var10.maxZ - var0.posZ + var8 + 0.05D);
      GL11.glTranslated(var4, var6, var8);
      GL11.glRotated((double)(-var0.getRotationYawHead()), 0.0D, 1.0D, 0.0D);
      GL11.glTranslated(-var4, -var6, -var8);
      GL11.glLineWidth(3.0F);
      c37784(2848);
      c41270(0, 0, 0, 255);
      c43711(var11);
      GL11.glLineWidth(1.0F);
      c37784(2848);
      c41270(var1.getRed(), var1.getGreen(), var1.getBlue(), 255);
      c43711(var11);
      GlStateManager.resetColor();
      GL11.glDepthMask(true);
      c85709();
      GlStateManager.popMatrix();
   }

   public static void c69751(double var0, double var2, double var4, double var6) {
      c24215(var0, var2, var4, var6, -16119286);
      double var8 = 0.5D;
      c24215(var0 + var8, var2 + var8, var4 - var8, var6 - var8, -12829636);
      var8 = 1.0D;
      c24215(var0 + var8, var2 + var8, var4 - var8, var6 - var8, -14540254);
      var8 = 2.5D;
      c24215(var0 + var8, var2 + var8, var4 - var8, var6 - var8, -12829636);
      var8 = 3.0D;
      c24215(var0 + var8, var2 + var8, var4 - var8, var6 - var8, -15329770);
   }

   public static void c11829(double var0, double var2, double var4, double var6, int var8, Color var9) {
      Value.c27574();
      GL11.glPushMatrix();
      GlStateManager.alphaFunc(516, 0.01F);
      var4 = var4 + (double)(var8 * 2);
      var6 = var6 + (double)(var8 * 2);
      var0 = var0 - (double)var8;
      var2 = var2 - (double)var8;
      double var11 = var0 - 0.25D;
      double var13 = var2 + 0.25D;
      double var15 = (double)((int)(var4 * var6 * 13212.0D / Math.sin((double)var8)));
      GL11.glEnable(3553);
      GL11.glDisable(2884);
      GL11.glEnable(3008);
      GlStateManager.enableBlend();
      int var17 = -1;
      if (c79219.containsKey(Double.valueOf(var15))) {
         var17 = ((Integer)c79219.get(Double.valueOf(var15))).intValue();
         GlStateManager.bindTexture(var17);
      }

      BufferedImage var18 = new BufferedImage((int)var4, (int)var6, 2);
      Graphics var19 = var18.getGraphics();
      var19.setColor(Color.WHITE);
      var19.fillRect(var8, var8, (int)(var4 - (double)(var8 * 2)), (int)(var6 - (double)(var8 * 2)));
      var19.dispose();
      BlurUtil var20 = new BlurUtil((float)var8);
      BufferedImage var21 = var20.filter(var18, (BufferedImage)null);
      var17 = TextureUtil.uploadTextureImageAllocate(TextureUtil.glGenTextures(), var21, true, false);
      c79219.put(Double.valueOf(var15), Integer.valueOf(var17));
      GL11.glColor4f((float)var9.getRed() / 255.0F, (float)var9.getGreen() / 255.0F, (float)var9.getBlue() / 255.0F, (float)var9.getAlpha() / 255.0F);
      GL11.glBegin(7);
      GL11.glTexCoord2f(0.0F, 0.0F);
      GL11.glVertex2d(var11, var13);
      GL11.glTexCoord2f(0.0F, 1.0F);
      GL11.glVertex2d(var11, var13 + var6);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2d(var11 + var4, var13 + var6);
      GL11.glTexCoord2f(1.0F, 0.0F);
      GL11.glVertex2d(var11 + var4, var13);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glEnable(2884);
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void c15402(float var0, float var1, float var2, float var3, int var4, Color var5) {
      GL11.glPushMatrix();
      GlStateManager.alphaFunc(516, 0.01F);
      var2 = var2 + (float)(var4 * 2);
      var3 = var3 + (float)(var4 * 2);
      var0 = var0 - (float)var4;
      var1 = var1 - (float)var4;
      float var7 = var0 - 0.25F;
      float var8 = var1 + 0.25F;
      double var9 = (double)((int)((double)(var2 * var3 * 13212.0F) / Math.sin((double)var4)));
      Value.c27574();
      GL11.glEnable(3553);
      GL11.glDisable(2884);
      GL11.glEnable(3008);
      GlStateManager.enableBlend();
      int var11 = -1;
      if (c79219.containsKey(Double.valueOf(var9))) {
         var11 = ((Integer)c79219.get(Double.valueOf(var9))).intValue();
         GlStateManager.bindTexture(var11);
      }

      BufferedImage var12 = new BufferedImage((int)var2, (int)var3, 2);
      Graphics var13 = var12.getGraphics();
      var13.setColor(Color.WHITE);
      var13.fillRect(var4, var4, (int)(var2 - (float)(var4 * 2)), (int)(var3 - (float)(var4 * 2)));
      var13.dispose();
      BlurUtil var14 = new BlurUtil((float)var4);
      BufferedImage var15 = var14.filter(var12, (BufferedImage)null);
      var11 = TextureUtil.uploadTextureImageAllocate(TextureUtil.glGenTextures(), var15, true, false);
      c79219.put(Double.valueOf(var9), Integer.valueOf(var11));
      GL11.glColor4f((float)var5.getRed() / 255.0F, (float)var5.getGreen() / 255.0F, (float)var5.getBlue() / 255.0F, (float)var5.getAlpha() / 255.0F);
      GL11.glBegin(7);
      GL11.glTexCoord2f(0.0F, 0.0F);
      GL11.glVertex2f(var7, var8);
      GL11.glTexCoord2f(0.0F, 1.0F);
      GL11.glVertex2f(var7, var8 + var3);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f(var7 + var2, var8 + var3);
      GL11.glTexCoord2f(1.0F, 0.0F);
      GL11.glVertex2f(var7 + var2, var8);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glEnable(2884);
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void c56300(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      Value.c27574();
      GlStateManager.color(0.0F, 0.0F, 0.0F, 0.0F);
      if (var2 > var3) {
         float var8 = var3;
         var3 = var2;
         var2 = var8;
      }

      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      c45487((float)var6);
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GL11.glBegin(3);
      if (var3 >= var2) {
         c14055(var5, 70);
         float var9 = (float)(Math.cos((double)var3 * 3.141592653589793D / 180.0D) * (double)var4 * 1.0D);
         float var10 = (float)(Math.sin((double)var3 * 3.141592653589793D / 180.0D) * (double)var4 * 1.0D);
         GL11.glVertex2f(var0 + var9, var1 + var10);
         float var11 = var3 - 4.0F;
      }

      GL11.glEnd();
      c3264();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c49138(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      Value.c27574();
      GlStateManager.color(0.0F, 0.0F, 0.0F, 0.0F);
      if (var2 > var3) {
         float var8 = var3;
         var3 = var2;
         var2 = var8;
      }

      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      c45487((float)var6);
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GL11.glBegin(3);
      if (var3 >= var2) {
         c14055(var5, 255);
         float var9 = (float)(Math.cos((double)var3 * 3.141592653589793D / 180.0D) * (double)var4 * 1.0D);
         float var10 = (float)(Math.sin((double)var3 * 3.141592653589793D / 180.0D) * (double)var4 * 1.0D);
         GL11.glVertex2f(var0 + var9, var1 + var10);
         float var11 = var3 - 4.0F;
      }

      GL11.glEnd();
      c3264();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c14055(int var0, int var1) {
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GlStateManager.color(var2, var3, var4, (float)var1 / 255.0F);
   }

   public static void c74242(float var0, float var1, float var2, float var3, float var4, boolean var5, Color var6) {
      Value.c27574();
      c28070(0.0D, 0.0D, 0.0D, 0.0D);
      if (var2 > var3) {
         float var11 = var3;
         var3 = var2;
         var2 = var11;
      }

      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      c33760(var6.getRGB());
      GL11.glEnable(2848);
      GL11.glLineWidth(2.0F);
      GL11.glBegin(3);
      if (var3 >= var2) {
         float var9 = (float)(Math.cos((double)var3 * 3.141592653589793D / 180.0D) * (double)var4 * 1.0D);
         float var8 = (float)(Math.sin((double)var3 * 3.141592653589793D / 180.0D) * (double)var4 * 1.0D);
         GL11.glVertex2f(var0 + var9, var1 + var8);
         float var10 = var3 - 4.0F;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(2848);
      GL11.glBegin(var5 ? 6 : 3);
      if (var3 >= var2) {
         float var13 = (float)Math.cos((double)var3 * 3.141592653589793D / 180.0D) * var4;
         float var12 = (float)Math.sin((double)var3 * 3.141592653589793D / 180.0D) * var4;
         GL11.glVertex2f(var0 + var13, var1 + var12);
         float var14 = var3 - 4.0F;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c33760(int var0) {
      GL11.glColor4ub((byte)(var0 >> 16 & 255), (byte)(var0 >> 8 & 255), (byte)(var0 & 255), (byte)(var0 >> 24 & 255));
   }

   public static void c77416(float var0) {
      c94802();
      GL11.glPushAttrib(1048575);
      GL11.glDisable(3008);
      GL11.glDisable(3553);
      GL11.glDisable(2896);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(var0);
      GL11.glEnable(2848);
      GL11.glEnable(2960);
      GL11.glClear(1024);
      GL11.glClearStencil(15);
      GL11.glStencilFunc(512, 1, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void c94802() {
      Value.c27574();
      Framebuffer var1 = Minecraft.getMinecraft().getFramebuffer();
      if (var1.depthBuffer > -1) {
         c6701(var1);
         var1.depthBuffer = -1;
      }

   }

   public static void c6701(Framebuffer var0) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(var0.depthBuffer);
      int var1 = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, var1);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, var1);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, var1);
   }

   public static void c11067() {
      GL11.glPolygonOffset(1.0F, 2000000.0F);
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

   public static void c37613(AxisAlignedBB var0) {
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

   public static void c38132(int var0) {
      Value.c27574();
      float var2 = (float)(var0 >> 24 & 255) / 255.0F;
      float var3 = (float)(var0 >> 16 & 255) / 255.0F;
      float var4 = (float)(var0 >> 8 & 255) / 255.0F;
      float var5 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var3, var4, var5, var2 == 0.0F ? 1.0F : var2);
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(10754);
      GL11.glPolygonOffset(1.0F, -2000000.0F);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
   }

   public static void c19347() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void c49560() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public static void c85907(float var0, float var1, float var2, float var3, float var4) {
      Module[] var5 = Value.c27574();
      if (var0 > var2) {
         float var6 = var0;
         var0 = var2;
         var2 = var6;
      }

      if (var1 > var3) {
         float var19 = var1;
         var1 = var3;
         var3 = var19;
      }

      double var7 = (double)(var0 + var4);
      double var9 = (double)(var1 + var4);
      double var11 = (double)(var2 - var4);
      double var13 = (double)(var3 - var4);
      GL11.glEnable(2848);
      GL11.glLineWidth(1.0F);
      GL11.glBegin(9);
      double var15 = 0.017453292519943295D;
      double var17 = 0.0D;
      if (var17 <= 90.0D) {
         GL11.glVertex2d(var11 + Math.sin(var17 * var15) * (double)var4, var13 + Math.cos(var17 * var15) * (double)var4);
         ++var17;
      }

      var17 = 90.0D;
      if (var17 <= 180.0D) {
         GL11.glVertex2d(var11 + Math.sin(var17 * var15) * (double)var4, var9 + Math.cos(var17 * var15) * (double)var4);
         ++var17;
      }

      var17 = 180.0D;
      if (var17 <= 270.0D) {
         GL11.glVertex2d(var7 + Math.sin(var17 * var15) * (double)var4, var9 + Math.cos(var17 * var15) * (double)var4);
         ++var17;
      }

      var17 = 270.0D;
      if (var17 <= 360.0D) {
         GL11.glVertex2d(var7 + Math.sin(var17 * var15) * (double)var4, var13 + Math.cos(var17 * var15) * (double)var4);
         ++var17;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
   }

   public static ScaledResolution c80598() {
      return new ScaledResolution(Minecraft.getMinecraft());
   }

   public static Vector3d c46412(ScaledResolution var0, double var1, double var3, double var5) {
      GL11.glGetFloat(2982, c84866);
      GL11.glGetFloat(2983, c76984);
      GL11.glGetInteger(2978, c69797);
      return GLU.gluProject((float)var1, (float)var3, (float)var5, c84866, c76984, c69797, c27006) ? new Vector3d((double)(c27006.get(0) / (float)var0.getScaleFactor()), (double)(((float)Display.getHeight() - c27006.get(1)) / (float)var0.getScaleFactor()), (double)c27006.get(2)) : null;
   }

   public static void c52026(double var0, double var2, int var4, int var5, double var6, int var8) {
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBegin(9);
      Value.c27574();
      c35946(var8);
      if (var4 <= var5) {
         double var11 = Math.sin((double)var4 * 3.141592653589793D / 180.0D) * var6;
         double var13 = Math.cos((double)var4 * 3.141592653589793D / 180.0D) * var6;
         GL11.glVertex2d(var0 + var11, var2 + var13);
         int var10 = var4 + 1;
      }

      GL11.glVertex2d(var0, var2);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void c31951(double var0, double var2, double var4, double var6, double var8, int var10) {
      float var11 = (float)Math.abs(var4 - var0);
      float var12 = (float)Math.abs(var6 - var2);
      var8 = Math.min(var8, (double)(var11 / 2.0F));
      var8 = Math.min(var8, (double)(var12 / 2.0F));
      c24215(var0, var2 + var8, var0 + (double)var11, var2 + (double)var12 - var8, var10);
      c24215(var0 + var8, var2, var0 + (double)var11 - var8, var2 + var8, var10);
      c24215(var0 + var8, var2 + (double)var12 - var8, var0 + (double)var11 - var8, var2 + (double)var12, var10);
      c52026((double)((float)(var0 + var8)), var2 + var8, 180, 271, var8, var10);
      c52026(var0 + var8, var2 + (double)var12 - var8, 270, 361, var8, var10);
      c52026(var0 + (double)var11 - var8, var2 + var8, 90, 181, var8, var10);
      c52026(var0 + (double)var11 - var8, var2 + (double)var12 - var8, 0, 91, var8, var10);
   }

   public static void c95978(double var0, double var2, int var4, int var5, double var6, int var8) {
      Value.c27574();
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBegin(9);
      c35946(var8);
      if (var4 <= var5) {
         double var11 = Math.sin((double)var4 * 3.141592653589793D / 180.0D) * var6;
         double var13 = Math.cos((double)var4 * 3.141592653589793D / 180.0D) * var6;
         GL11.glVertex2d(var0 + var11, var2 + var13);
         int var10 = var4 + 1;
      }

      GL11.glVertex2d(var0, var2);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void c87213(double var0, double var2, double var4, double var6, int var8, int var9) {
      double var10 = var4 - var0;
      double var12 = var6 - var2;
      c24215(var0, var2 + var12 / (double)var8, var0 + var12 / (double)var8, var2 + var12 - var12 / (double)var8, var9);
      c24215(var0 + var10 - var12 / (double)var8, var2 + var12 / (double)var8, var0 + var10, var2 + var12 - var12 / (double)var8, var9);
      c24215(var0 + var12 / (double)var8, var2, var0 + var10 - var12 / (double)var8, var2 + var12, var9);
      c95978(var0 + var12 / (double)var8, var2 + var12 / (double)var8, 180, 270, var12 / (double)var8, var9);
      c95978(var0 + var12 / (double)var8, var2 + var12 - var12 / (double)var8, 270, 360, var12 / (double)var8, var9);
      c95978(var0 + var10 - var12 / (double)var8, var2 + var12 / (double)var8, 90, 180, var12 / (double)var8, var9);
      c95978(var0 + var10 - var12 / (double)var8, var2 + var12 - var12 / (double)var8, 0, 90, var12 / (double)var8, var9);
   }

   public static void c8358(int var0, int var1, int var2, int var3, int var4) {
      c50993();
      c33760(var4);
      GL11.glBegin(7);
      GL11.glVertex2d((double)var0, (double)var1);
      GL11.glVertex2d((double)(var0 + var2), (double)var1);
      GL11.glVertex2d((double)(var0 + var2), (double)(var1 + var3));
      GL11.glVertex2d((double)var0, (double)(var1 + var3));
      GL11.glEnd();
      c87379();
   }

   public static void c50993() {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
   }

   public static void c87379() {
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static void c52429(BlockPos var0, int var1) {
      double var2 = (double)var0.getX() - c9886.getRenderManager().renderPosX;
      double var4 = (double)var0.getY() - c9886.getRenderManager().renderPosY;
      double var6 = (double)var0.getZ() - c9886.getRenderManager().renderPosZ;
      double var8 = c9886.theWorld.getBlockState(var0).getBlock().getBlockBoundsMaxY() - c9886.theWorld.getBlockState(var0).getBlock().getBlockBoundsMinY();
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
      c36389(new AxisAlignedBB(var2, var4, var6, var2 + 1.0D, var4 + var8, var6 + 1.0D));
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

   public static void c25325(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = 1.0F / var8;
      float var11 = 1.0F / var9;
      Tessellator var12 = Tessellator.getInstance();
      WorldRenderer var13 = var12.getWorldRenderer();
      var13.begin(7, DefaultVertexFormats.POSITION_TEX);
      var13.pos((double)var0, (double)(var1 + var7), 0.0D).tex((double)(var2 * var10), (double)((var3 + var5) * var11)).endVertex();
      var13.pos((double)(var0 + var6), (double)(var1 + var7), 0.0D).tex((double)((var2 + var4) * var10), (double)((var3 + var5) * var11)).endVertex();
      var13.pos((double)(var0 + var6), (double)var1, 0.0D).tex((double)((var2 + var4) * var10), (double)(var3 * var11)).endVertex();
      var13.pos((double)var0, (double)var1, 0.0D).tex((double)(var2 * var10), (double)(var3 * var11)).endVertex();
      var12.draw();
   }

   public static void c18490(double var0, double var2, double var4, double var6) {
      GL11.glEnable(3089);
      ScaledResolution var8 = new ScaledResolution(c9886);
      double var9 = (double)var8.getScaleFactor();
      double var11 = var6 * var9;
      double var13 = ((double)var8.getScaledHeight() - var2) * var9;
      double var15 = var0 * var9;
      double var17 = var4 * var9;
      GL11.glScissor((int)var15, (int)(var13 - var11), (int)var17, (int)var11);
   }

   public static void c61298(ResourceLocation var0, int var1, int var2, int var3, int var4, float var5) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, var5);
      c9886.getTextureManager().bindTexture(var0);
      Gui.drawScaledCustomSizeModalRect(var1, var2, 8.0F, 8.0F, 8, 8, var3, var4, 64.0F, 64.0F);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void c90897(float var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      ColorUtil.c29334(-1);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      var0 = var0 * 2.0F;
      Value.c27574();
      var1 = var1 * 2.0F;
      var2 = var2 * 2.0F;
      var3 = var3 * 2.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      ColorUtil.c29334(var6);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glLineWidth(var4);
      GL11.glBegin(2);
      int var9 = 0;
      if (var9 <= 90) {
         GL11.glVertex2d((double)(var0 + var5) + Math.sin((double)var9 * 3.141592653589793D / 180.0D) * (double)var5 * -1.0D, (double)(var1 + var5) + Math.cos((double)var9 * 3.141592653589793D / 180.0D) * (double)var5 * -1.0D);
         var9 = var9 + 3;
      }

      ColorUtil.c29334(var6);
      var9 = 90;
      if (var9 <= 180) {
         GL11.glVertex2d((double)(var0 + var5) + Math.sin((double)var9 * 3.141592653589793D / 180.0D) * (double)var5 * -1.0D, (double)(var3 - var5) + Math.cos((double)var9 * 3.141592653589793D / 180.0D) * (double)var5 * -1.0D);
         var9 = var9 + 3;
      }

      ColorUtil.c29334(var7);
      var9 = 0;
      if (var9 <= 90) {
         GL11.glVertex2d((double)(var2 - var5) + Math.sin((double)var9 * 3.141592653589793D / 180.0D) * (double)var5, (double)(var3 - var5) + Math.cos((double)var9 * 3.141592653589793D / 180.0D) * (double)var5);
         var9 = var9 + 3;
      }

      ColorUtil.c29334(var7);
      var9 = 90;
      if (var9 <= 180) {
         GL11.glVertex2d((double)(var2 - var5) + Math.sin((double)var9 * 3.141592653589793D / 180.0D) * (double)var5, (double)(var1 + var5) + Math.cos((double)var9 * 3.141592653589793D / 180.0D) * (double)var5);
         var9 = var9 + 3;
      }

      GL11.glEnd();
      GL11.glLineWidth(1.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      ColorUtil.c29334(-1);
   }

   public static void c84522(float var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8) {
      ColorUtil.c29334(-1);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      var0 = (float)((double)var0 * 2.0D);
      var1 = (float)((double)var1 * 2.0D);
      var2 = (float)((double)var2 * 2.0D);
      var3 = (float)((double)var3 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      Value.c27574();
      ColorUtil.c29334(var5);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glBegin(6);
      int var10 = 0;
      if (var10 <= 90) {
         GL11.glVertex2d((double)(var0 + var4) + Math.sin((double)var10 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D, (double)(var1 + var4) + Math.cos((double)var10 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D);
         var10 = var10 + 3;
      }

      ColorUtil.c29334(var6);
      var10 = 90;
      if (var10 <= 180) {
         GL11.glVertex2d((double)(var0 + var4) + Math.sin((double)var10 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D, (double)(var3 - var4) + Math.cos((double)var10 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D);
         var10 = var10 + 3;
      }

      ColorUtil.c29334(var7);
      var10 = 0;
      if (var10 <= 90) {
         GL11.glVertex2d((double)(var2 - var4) + Math.sin((double)var10 * 3.141592653589793D / 180.0D) * (double)var4, (double)(var3 - var4) + Math.cos((double)var10 * 3.141592653589793D / 180.0D) * (double)var4);
         var10 = var10 + 3;
      }

      ColorUtil.c29334(var8);
      var10 = 90;
      if (var10 <= 180) {
         GL11.glVertex2d((double)(var2 - var4) + Math.sin((double)var10 * 3.141592653589793D / 180.0D) * (double)var4, (double)(var1 + var4) + Math.cos((double)var10 * 3.141592653589793D / 180.0D) * (double)var4);
         var10 = var10 + 3;
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      ColorUtil.c29334(-1);
   }

   public static void c4994(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      ColorUtil.c29334(-1);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      var0 = (float)((double)var0 * 2.0D);
      var1 = (float)((double)var1 * 2.0D);
      var2 = (float)((double)var2 * 2.0D);
      var3 = (float)((double)var3 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      Value.c27574();
      ColorUtil.c29334(var5);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glBegin(6);
      int var8 = 0;
      if (var8 <= 90) {
         GL11.glVertex2d((double)(var0 + var4) + Math.sin((double)var8 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D, (double)(var1 + var4) + Math.cos((double)var8 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D);
         var8 = var8 + 3;
      }

      ColorUtil.c29334(var5);
      var8 = 90;
      if (var8 <= 180) {
         GL11.glVertex2d((double)(var0 + var4) + Math.sin((double)var8 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D, (double)(var3 - var4) + Math.cos((double)var8 * 3.141592653589793D / 180.0D) * (double)var4 * -1.0D);
         var8 = var8 + 3;
      }

      ColorUtil.c29334(var6);
      var8 = 0;
      if (var8 <= 90) {
         GL11.glVertex2d((double)(var2 - var4) + Math.sin((double)var8 * 3.141592653589793D / 180.0D) * (double)var4, (double)(var3 - var4) + Math.cos((double)var8 * 3.141592653589793D / 180.0D) * (double)var4);
         var8 = var8 + 3;
      }

      ColorUtil.c29334(var6);
      var8 = 90;
      if (var8 <= 180) {
         GL11.glVertex2d((double)(var2 - var4) + Math.sin((double)var8 * 3.141592653589793D / 180.0D) * (double)var4, (double)(var1 + var4) + Math.cos((double)var8 * 3.141592653589793D / 180.0D) * (double)var4);
         var8 = var8 + 3;
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      ColorUtil.c29334(-1);
   }

   private static JSONException c12376(JSONException var0) {
      return var0;
   }
}
