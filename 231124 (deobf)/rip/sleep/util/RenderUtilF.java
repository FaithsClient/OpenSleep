package rip.sleep.util;

import com.mojang.authlib.GameProfile;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import rip.sleep.Sleep;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.modules.Camera;
import rip.sleep.module.modules.HUD;
import rip.sleep.module.modules.KillAura;
import rip.sleep.value.Value;

public class RenderUtilF {
   private static final List<Integer> c41115 = new ArrayList();
   private static final Consumer<Integer> c58553 = GL11::glEnableClientState;
   private static final Consumer<Integer> c77382 = GL11::glEnableClientState;
   private static final Frustum c21381 = new Frustum();
   public static float c75973;
   private static final Minecraft c19420 = Minecraft.getMinecraft();

   public static Color c13639(long var0, float var2, float var3) {
      float var4 = (float)(System.nanoTime() + var0) / 1.0E1F % 1.0F;
      long var5 = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(var4, var2, 1.0F).intValue()), 16);
      Color var7 = new Color((int)var5);
      return new Color((float)var7.getRed() / 255.0F * var3, (float)var7.getGreen() / 255.0F * var3, (float)var7.getBlue() / 255.0F * var3, (float)var7.getAlpha() / 255.0F);
   }

   public static void c86698(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c48941(float var0, int var1, int var2, int var3) {
      float var4 = 0.003921569F * (float)var1;
      float var5 = 0.003921569F * (float)var2;
      float var6 = 0.003921569F * (float)var3;
      GL11.glColor4f(var4, var5, var6, var0);
   }

   public static int c72897(int var0) {
      return -16777216 | var0;
   }

   public static void c52079() {
      Value.c27574();
      Framebuffer var1 = Minecraft.getMinecraft().getFramebuffer();
      if (var1 != null) {
         if (var1.depthBuffer > -1) {
            EXTFramebufferObject.glDeleteRenderbuffersEXT(var1.depthBuffer);
            int var2 = EXTFramebufferObject.glGenRenderbuffersEXT();
            EXTFramebufferObject.glBindRenderbufferEXT(36161, var2);
            EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
            EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, var2);
            EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, var2);
            var1.depthBuffer = -1;
         }
      }
   }

   public static void c55614() {
      GL11.glPushAttrib(1048575);
      GL11.glDisable(3008);
      GL11.glDisable(3553);
      GL11.glDisable(2896);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(2.0F);
      GL11.glEnable(2848);
      GL11.glEnable(2960);
      GL11.glClear(1024);
      GL11.glClearStencil(15);
      GL11.glStencilFunc(512, 1, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void c43981() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public static void c77956() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void c682() {
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(10754);
      GL11.glPolygonOffset(1.0F, -2000000.0F);
      GL11.glColor4f(0.9529412F, 0.6117647F, 0.07058824F, 1.0F);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
   }

   public static void c74543() {
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

   public static void c74875(int var0, int var1, int var2, int var3, int var4, ResourceLocation var5) {
      Minecraft.getMinecraft().getTextureManager().bindTexture(var5);
      Value.c27574();
      GL11.glColor4f(255.0F, 255.0F, 255.0F, 255.0F);
      if (var4 <= 0) {
         Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
      }

      GlStateManager.pushMatrix();
      int var7 = var0 + 5;
      byte var8 = -10;
      GlStateManager.translate((float)var7, (float)(var8 + var1) + 15.0F, 0.0F);
      GlStateManager.rotate((float)var4, 0.0F, 0.0F, 1.0F);
      GlStateManager.translate((float)(-var7), -((float)(var8 + var1) + 15.0F), 0.0F);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, 10, 10, 10.0F, 10.0F);
      GlStateManager.popMatrix();
   }

   public static void c6666(int var0, int var1, int var2, int var3, ResourceLocation var4) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      c96647(HUD.c64734.c41161().intValue());
      Minecraft.getMinecraft().getTextureManager().bindTexture(var4);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void c32641(float var0, float var1, float var2, float var3, float var4, int var5) {
      float var6 = (float)(var5 >> 24 & 255) / 255.0F;
      float var7 = (float)(var5 >> 16 & 255) / 255.0F;
      float var8 = (float)(var5 >> 8 & 255) / 255.0F;
      float var9 = (float)(var5 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var7, var8, var9, var6);
      GL11.glPointSize(var4);
      GL11.glBegin(0);
      GL11.glVertex2f(var0 + var2, var1 + var3);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void c96804(float var0, float var1, float var2, float var3, boolean var4, int var5) {
      c84609((int)var0, (int)var1, (double)var2, 10, var3, 360, var4, var5);
   }

   public static void c84609(int var0, int var1, double var2, int var4, float var5, int var6, boolean var7, int var8) {
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      var2 = var2 * 2.0D;
      var0 = var0 * 2;
      var1 = var1 * 2;
      Value.c27574();
      float var10 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glLineWidth(var5);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(var11, var12, var13, var10);
      GL11.glBegin(3);
      int var14 = var4 - var6;
      if (var14 <= var4) {
         double var15 = Math.sin((double)var14 * 3.141592653589793D / 180.0D) * var2;
         double var17 = Math.cos((double)var14 * 3.141592653589793D / 180.0D) * var2;
         GL11.glVertex2d((double)var0 + var15, (double)var1 + var17);
         if (var7) {
            GL11.glVertex2d((double)var0, (double)var1);
         }

         ++var14;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
   }

   public static void c85626(float var0, float var1, double var2, int var4, int var5, float var6, int var7, boolean var8, boolean var9) {
      Module[] var10 = Value.c27574();
      if (var4 > 0) {
         GL11.glScalef(0.5F, 0.5F, 0.5F);
         var2 = var2 * 2.0D;
         var0 = var0 * 2.0F;
         var1 = var1 * 2.0F;
         float var11 = (float)(var7 >> 24 & 255) / 255.0F;
         float var12 = (float)(var7 >> 16 & 255) / 255.0F;
         float var13 = (float)(var7 >> 8 & 255) / 255.0F;
         float var14 = (float)(var7 & 255) / 255.0F;
         GL11.glEnable(3042);
         GlStateManager.enableAlpha();
         GL11.glLineWidth(var6);
         GL11.glDisable(3553);
         GL11.glEnable(2848);
         GL11.glBlendFunc(770, 771);
         GL11.glColor4f(var12, var13, var14, var11);
         GL11.glBegin(3);
         if (var5 <= var4 + var5) {
            double var16 = Math.sin((double)var5 * 3.141592653589793D / 180.0D) * var2;
            double var18 = Math.cos((double)var5 * 3.141592653589793D / 180.0D) * var2;
            GL11.glVertex2d((double)var0 + var16, (double)var1 + var18);
            if (var8) {
               GL11.glVertex2d((double)var0, (double)var1);
            }

            int var15 = var5 + 1;
         }

         if (var9 && !var8 && var4 < 360) {
            double var23 = Math.sin((double)var5 * 3.141592653589793D / 180.0D) * var2;
            double var17 = Math.cos((double)var5 * 3.141592653589793D / 180.0D) * var2;
            GL11.glVertex2d((double)var0, (double)var1);
            GL11.glVertex2d((double)var0 + var23, (double)var1 + var17);
         }

         GL11.glEnd();
         GL11.glDisable(2848);
         GL11.glEnable(3553);
         GL11.glDisable(3042);
         GL11.glScalef(2.0F, 2.0F, 2.0F);
      }
   }

   public static void c54555(double var0, double var2, double var4, double var6, int var8) {
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

   public static void c23150(float var0, float var1, float var2, float var3, float var4, int var5) {
      c85626(var0 + var4 + 0.5F, var1 + var4 + 0.5F, (double)var4, 90, 180, 1.0F, var5, true, false);
      c38259(0.0D, 0.0D, 0.0D, 0.0D, 0);
      c85626(var0 + var2 - var4 - 0.5F, var1 + var4 + 0.5F, (double)var4, 90, 90, 1.0F, var5, true, false);
      c38259(0.0D, 0.0D, 0.0D, 0.0D, 0);
      c85626(var0 + var4 + 0.5F, var1 + var3 - var4 - 0.5F, (double)var4, 90, 270, 1.0F, var5, true, false);
      c38259(0.0D, 0.0D, 0.0D, 0.0D, 0);
      c85626(var0 + var2 - var4 - 0.5F, var1 + var3 - var4 - 0.5F, (double)var4, 90, 360, 1.0F, var5, true, false);
      c38259(0.0D, 0.0D, 0.0D, 0.0D, 0);
      c38259((double)(var0 + var4), (double)var1, (double)(var0 + var4 + var2 - 2.0F * var4), (double)(var1 + var3), var5);
      c38259((double)var0, (double)(var1 + var4), (double)(var0 + var4), (double)(var1 + var3 - var4), var5);
      c38259((double)(var0 + var2 - var4), (double)(var1 + var4), (double)(var0 + var2), (double)(var1 + var3 - var4), var5);
   }

   public static void c63743(float var0, float var1, float var2, float var3, int var4) {
      Gui.drawRect((int)var0, (int)var1, (int)(var2 + var0), (int)(var3 + var1), var4);
   }

   public static void c38259(double var0, double var2, double var4, double var6, int var8) {
      Gui.drawRect((int)var0, (int)var2, (int)var4, (int)var6, var8);
   }

   public static void c6005(float var0, float var1, float var2, float var3, float var4, int var5) {
      float var6 = (float)(var5 >> 24 & 255) / 255.0F;
      float var7 = (float)(var5 >> 16 & 255) / 255.0F;
      float var8 = (float)(var5 >> 8 & 255) / 255.0F;
      float var9 = (float)(var5 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var7, var8, var9, var6);
      GL11.glLineWidth(var4);
      GL11.glBegin(1);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0 + var2, var1);
      GL11.glVertex2f(var0 + var2, var1 + var3);
      GL11.glVertex2f(var0, var1 + var3);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0, var1 + var3);
      GL11.glVertex2f(var0 + var2, var1);
      GL11.glVertex2f(var0 + var2, var1 + var3);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void c85499(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      Gui.drawRect((int)var0, (int)var1, (int)var2, (int)var3, var6);
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
      GL11.glVertex2d((double)var0 - (double)var4, (double)var1);
      GL11.glVertex2d((double)var2 + (double)var4, (double)var1);
      GL11.glVertex2d((double)var0, (double)var3);
      GL11.glVertex2d((double)var2, (double)var3);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static int c56546() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth();
   }

   public static int c68373() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledHeight();
   }

   public static double c69648(double var0, double var2) {
      return var2 + (var0 - var2) * (double) ChatUtilA.c14057().renderPartialTicks;
   }

   public static double c1320(double var0, double var2) {
      return var2 + (var0 - var2) * (double) ChatUtilA.c14057().renderPartialTicks;
   }

   public static void c86868() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glColor3d(1.0D, 1.0D, 1.0D);
   }

   public static void c25653() {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glHint(3154, 4354);
   }

   public static void c59993() {
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c25087() {
      GL11.glEnable(3042);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
   }

   public static void c46840() {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glHint(3154, 4354);
   }

   public static void c62705() {
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c66450() {
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static Color c14326(Color var0, Color var1, double var2) {
      float var4 = (float)var2;
      float var5 = 1.0F - var4;
      float[] var6 = new float[3];
      float[] var7 = new float[3];
      var0.getColorComponents(var6);
      var1.getColorComponents(var7);
      Color var8 = new Color(var6[0] * var4 + var7[0] * var5, var6[1] * var4 + var7[1] * var5, var6[2] * var4 + var7[2] * var5);
      return var8;
   }

   public static void c66712(boolean var0) {
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

   public static void c34359(double var0, double var2, double var4, double var6, int var8, int var9) {
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
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
   }

   public static Vec3 c57111(EntityPlayer var0) {
      float var1 = ChatUtilA.c14057().renderPartialTicks;
      double var2 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)var1;
      double var4 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)var1;
      double var6 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)var1;
      return new Vec3(var2, var4, var6);
   }

   public static void c48010(double var0, double var2, double var4, double var6, int var8) {
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

   public static void c78669(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      c48010(var0 + var8, var2 + var8, var4 - var8, var6 - var8, var10);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c48010(var0 + var8, var2, var4 - var8, var2 + var8, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c48010(var0, var2, var0 + var8, var6, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c48010(var4 - var8, var2, var4, var6, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      c48010(var0 + var8, var6 - var8, var4 - var8, var6, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c57581(float var0, float var1, float var2, int var3, int var4) {
      GL11.glPushMatrix();
      var0 = var0 * 2.0F;
      var1 = var1 * 2.0F;
      Value.c27574();
      float var6 = (float)(var4 >> 24 & 255) / 255.0F;
      float var7 = (float)(var4 >> 16 & 255) / 255.0F;
      float var8 = (float)(var4 >> 8 & 255) / 255.0F;
      float var9 = (float)(var4 & 255) / 255.0F;
      float var10 = (float)(6.2831852D / (double)var3);
      float var11 = (float)Math.cos((double)var10);
      float var12 = (float)Math.sin((double)var10);
      float var19;
      float var13 = var19 = var2 * 2.0F;
      float var14 = 0.0F;
      c58632();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glColor4f(var7, var8, var9, var6);
      GL11.glBegin(2);
      int var15 = 0;
      if (var15 < var3) {
         GL11.glVertex2f(var13 + var0, var14 + var1);
         float var20 = var11 * var13 - var12 * var14;
         var14 = var12 * var13 + var11 * var14;
         ++var15;
      }

      GL11.glEnd();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      c9027();
      GL11.glPopMatrix();
   }

   public static void c58632() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void c9027() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static double c4688(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }

   public static void c11088(double var0, double var2, double var4, double var6, float var8, int var9, int var10) {
      c38259(var0, var2, var4, var6, var10);
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
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static float[] c24537(EntityLivingBase var0, float var1) {
      KillAura var3 = (KillAura) ModuleManager.c25475(KillAura.class);
      Camera var4 = (Camera) ModuleManager.c25475(Camera.class);
      float var5 = c83685(var0.prevRenderYawOffset, var0.renderYawOffset, var1);
      float var6 = c83685(var0.prevRotationYawHead, var0.rotationYawHead, var1);
      float var10000 = var0.prevRotationPitch + (var0.rotationPitch - var0.prevRotationPitch) * var1;
      Value.c27574();
      float var8 = var6 - var5;
      float var7 = c83685(MotionUpdateEvent.c94080, MotionUpdateEvent.c49492, var1);
      if (!Objects.equals(Camera.c94474.c54460(), "Head")) {
         var5 = c83685(Sleep.c34963, Sleep.c6432, var1);
      }

      if (Objects.equals(Camera.c94474.c54460(), "Zenith")) {
         var5 -= var8 + Camera.c42900.c53968().floatValue();
      }

      var6 = c83685(Sleep.c34963, Sleep.c6432, var1);
      return new float[]{var5, var6, var7};
   }

   public static float[] c9812(EntityLivingBase var0, float var1) {
      KillAura var3 = (KillAura) ModuleManager.c25475(KillAura.class);
      Value.c27574();
      Camera var4 = (Camera) ModuleManager.c25475(Camera.class);
      float var5 = c83685(var0.prevRenderYawOffset, var0.renderYawOffset, var1);
      float var6 = c83685(var0.prevRotationYawHead, var0.rotationYawHead, var1);
      float var10000 = var0.prevRotationPitch + (var0.rotationPitch - var0.prevRotationPitch) * var1;
      float var8 = var6 - var5;
      float var7 = c83685(MotionUpdateEvent.c94080, MotionUpdateEvent.c49492, var1);
      if (!Objects.equals(Camera.c94474.c54460(), "Head")) {
         var5 = c83685(Sleep.c34963, Sleep.c6432, var1);
      }

      float var9 = var8 + 50.0F;
      if (Objects.equals(Camera.c94474.c54460(), "Zenith")) {
         var5 -= var9;
      }

      var6 = c83685(Sleep.c34963, Sleep.c6432, var1);
      return new float[]{var5, var6, var7};
   }

   public static float[] c76283(EntityLivingBase var0, float var1) {
      float var5;
      float var7;
      float var8;
      label24: {
         Value.c27574();
         KillAura var3 = (KillAura) ModuleManager.c25475(KillAura.class);
         Camera var4 = (Camera) ModuleManager.c25475(Camera.class);
         var5 = c83685(var0.prevRenderYawOffset, var0.renderYawOffset, var1);
         float var6 = c83685(var0.prevRotationYawHead, var0.rotationYawHead, var1);
         float var10000 = var0.prevRotationPitch + (var0.rotationPitch - var0.prevRotationPitch) * var1;
         var8 = var6 - var5;
         var7 = c83685(MotionUpdateEvent.c94080, MotionUpdateEvent.c49492, var1);
         if (Objects.equals(Camera.c94474.c54460(), "Astolfo")) {
            if (!KillAura.c64006(KillAura.c19685, 100.0F)) {
               break label24;
            }

            var5 = c83685(Sleep.c34963, Sleep.c6432, var1);
         }

         if (!Objects.equals(Camera.c94474.c54460(), "Head")) {
            var5 = c83685(Sleep.c34963, Sleep.c6432, var1);
         }
      }

      float var9 = PlayerUtil.c71257() ? var8 + Camera.c42900.c53968().floatValue() : var8;
      if (Objects.equals(Camera.c94474.c54460(), "Zenith")) {
         var5 -= var9;
      }

      float var10 = c83685(Sleep.c34963, Sleep.c6432, var1);
      return new float[]{var5, var10, var7};
   }

   protected static float c83685(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = var1 - var0;
      if (var4 < -180.0F) {
         var4 += 360.0F;
      }

      if (var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      return var0 + var2 * var4;
   }

   public static void c65252(int var0, int var1, int var2, float var3, float var4, EntityLivingBase var5) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var0, (float)var1, 40.0F);
      GlStateManager.scale((float)(-var2), (float)var2, (float)var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = var5.renderYawOffset;
      float var7 = var5.rotationYaw;
      float var8 = var5.rotationPitch;
      float var9 = var5.prevRotationYawHead;
      float var10 = var5.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-((float)Math.atan((double)(var4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.renderYawOffset = (float)Math.atan((double)(var3 / 40.0F)) * -14.0F;
      var5.rotationYaw = (float)Math.atan((double)(var3 / 40.0F)) * -14.0F;
      var5.rotationPitch = -((float)Math.atan((double)(var4 / 40.0F))) * 15.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
      var11.setPlayerViewY(180.0F);
      var11.setRenderShadow(false);
      var11.renderEntityWithPosYaw(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var11.setRenderShadow(true);
      var5.renderYawOffset = var6;
      var5.rotationYaw = var7;
      var5.rotationPitch = var8;
      var5.prevRotationYawHead = var9;
      var5.rotationYawHead = var10;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static void c75339(int var0, int var1, int var2, int var3) {
      Minecraft var5 = Minecraft.getMinecraft();
      Value.c27574();
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

   public static void c94675(float var0, float var1, float var2, float var3, float var4, int var5) {
      var0 = var0 + (float)((double)(var4 / 2.0F) + 0.5D);
      var1 = var1 + (float)((double)(var4 / 2.0F) + 0.5D);
      var2 = var2 - (float)((double)(var4 / 2.0F) + 0.5D);
      var3 = var3 - (float)((double)(var4 / 2.0F) + 0.5D);
      Gui.drawRect((int)var0, (int)var1, (int)var2, (int)var3, var5);
      c14090(var2 - var4 / 2.0F, var1 + var4 / 2.0F, var4, var5);
      c14090(var0 + var4 / 2.0F, var3 - var4 / 2.0F, var4, var5);
      c14090(var0 + var4 / 2.0F, var1 + var4 / 2.0F, var4, var5);
      c14090(var2 - var4 / 2.0F, var3 - var4 / 2.0F, var4, var5);
      Gui.drawRect((int)(var0 - var4 / 2.0F - 0.5F), (int)(var1 + var4 / 2.0F), (int)var2, (int)(var3 - var4 / 2.0F), var5);
      Gui.drawRect((int)var0, (int)(var1 + var4 / 2.0F), (int)(var2 + var4 / 2.0F + 0.5F), (int)(var3 - var4 / 2.0F), var5);
      Gui.drawRect((int)(var0 + var4 / 2.0F), (int)(var1 - var4 / 2.0F - 0.5F), (int)(var2 - var4 / 2.0F), (int)(var3 - var4 / 2.0F), var5);
      Gui.drawRect((int)(var0 + var4 / 2.0F), (int)var1, (int)(var2 - var4 / 2.0F), (int)(var3 + var4 / 2.0F + 0.5F), var5);
   }

   public static void c14090(float var0, float var1, float var2, int var3) {
      c24574(var0, var1, 0.0F, 360.0F, var2, var3);
   }

   public static void c24574(float var0, float var1, float var2, float var3, float var4, int var5) {
      c20525(var0, var1, var2, var3, var4, var4, var5);
   }

   public static void c20525(float var0, float var1, float var2, float var3, float var4, float var5, int var6) {
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

   public static void c28323(int var0, int var1, int var2, int var3) {
      int var4 = (new ScaledResolution(c19420)).getScaleFactor();
      GL11.glPushMatrix();
      GL11.glEnable(3089);
      GL11.glScissor(var0 * var4, c19420.displayHeight - (var1 + var3) * var4, var2 * var4, var3 * var4);
   }

   public static void c67431() {
      GL11.glDisable(3089);
      GL11.glPopMatrix();
   }

   public static void c71363(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      c38259(var0 + var8, var2 + var8, var4 - var8, var6 - var8, var10);
      c38259(var0 + var8, var2, var4 - var8, var2 + var8, var11);
      c38259(var0, var2, var0 + var8, var6, var11);
      c38259(var4 - var8, var2, var4, var6, var11);
      c38259(var0 + var8, var6 - var8, var4 - var8, var6, var11);
   }

   public static void c73096(String var0, int var1, int var2, int var3, int var4) {
      Value.c27574();
      Iterator var6 = Minecraft.getMinecraft().theWorld.getLoadedEntityList().iterator();
      if (var6.hasNext()) {
         Object var7 = var6.next();
         if (var7 instanceof EntityPlayer) {
            EntityPlayer var8 = (EntityPlayer)var7;
            if (var0.equalsIgnoreCase(var8.getName())) {
               GameProfile var9 = new GameProfile(var8.getUniqueID(), var8.getName());
               NetworkPlayerInfo var10 = new NetworkPlayerInfo(var9);
               new ScaledResolution(Minecraft.getMinecraft());
               GL11.glDisable(2929);
               GL11.glEnable(3042);
               GL11.glDepthMask(false);
               OpenGlHelper.glBlendFunc(770, 771, 1, 0);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               Minecraft.getMinecraft().getTextureManager().bindTexture(var10.getLocationSkin());
               Gui.drawModalRectWithCustomSizedTexture(var1, var2, 0.0F, 0.0F, var3, var4, (float)var3, (float)var4);
               GL11.glDepthMask(true);
               GL11.glDisable(3042);
               GL11.glEnable(2929);
            }
         }
      }

   }

   public static void c18639(ResourceLocation var0, int var1, int var2, int var3, int var4) {
      c72114(var0, var1, var2, var3, var4, 1.0F);
   }

   public static void c72114(ResourceLocation var0, int var1, int var2, int var3, int var4, float var5) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, var5);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      Gui.drawModalRectWithCustomSizedTexture(var1, var2, 0.0F, 0.0F, var3, var4, (float)var3, (float)var4);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void c82808(AxisAlignedBB var0) {
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

   public static Color c82293(Color var0, int var1) {
      int var3 = var0.getRed();
      Value.c27574();
      int var4 = var0.getGreen();
      int var5 = var0.getBlue();
      var3 = var3 - var1;
      var4 = var4 - var1;
      var5 = var5 - var1;
      if (var3 < 0) {
         var3 = 0;
      }

      if (var4 < 0) {
         var4 = 0;
      }

      if (var5 < 0) {
         var5 = 0;
      }

      return new Color(var3, var4, var5);
   }

   public static void c328(ScaledResolution var0, float var1, float var2, float var3, float var4) {
      float var5 = var1 + var3;
      float var6 = var2 + var4;
      int var7 = var0.getScaleFactor();
      GL11.glScissor((int)(var1 * (float)var7), (int)(((float)var0.getScaledHeight() - var6) * (float)var7), (int)((var5 - var1) * (float)var7), (int)((var6 - var2) * (float)var7));
   }

   public static void c51242(float var0, float var1, float var2, float var3) {
      ScaledResolution var4 = new ScaledResolution(c19420);
      int var5 = var4.getScaleFactor();
      GL11.glScissor((int)(var0 * (float)var5), (int)(((float)var4.getScaledHeight() - var3) * (float)var5), (int)((var2 - var0) * (float)var5), (int)((var3 - var1) * (float)var5));
   }

   public static void c75057(int var0, int var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9) {
      Gui.drawScaledCustomSizeModalRect(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public static void c71970(float var0, float var1, int var2, int var3, ResourceLocation var4) {
      GL11.glPushMatrix();
      Minecraft.getMinecraft().getTextureManager().bindTexture(var4);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GlStateManager.enableRescaleNormal();
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      GL11.glTranslatef(var0, var1, 0.0F);
      c75057(0, 0, 0.0F, 0.0F, var2, var3, var2, var3, (float)var2, (float)var3);
      GlStateManager.disableAlpha();
      GlStateManager.disableRescaleNormal();
      GlStateManager.disableLighting();
      GlStateManager.disableRescaleNormal();
      GL11.glDisable(2848);
      GlStateManager.disableBlend();
      GL11.glPopMatrix();
   }

   public static double c89849(double var0, double var2, double var4) {
      Value.c27574();
      float var7 = (float)(0.01D * var4);
      if (var0 < var2) {
         if (var0 + (double)var7 < var2) {
            double var10000 = var0 + (double)var7;
         }

         var0 = var2;
      }

      if (var0 - (double)var7 > var2) {
         double var8 = var0 - (double)var7;
      }

      return var2;
   }

   public static void c54273(double var0, double var2, double var4, double var6, int var8, int var9) {
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

   public static float c95047(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = c75973 * var2;
      var0 = var0 < var1 ? (var0 + var4 < var1 ? var0 + var4 : var1) : (var0 - var4 > var1 ? var0 - var4 : var1);
      return var0;
   }

   public static double c42266(double var0, double var2, double var4) {
      Value.c27574();
      float var7 = (float)(0.01D * var4);
      if (var0 < var2) {
         if (var0 + (double)var7 < var2) {
            double var10000 = var0 + (double)var7;
         }

         var0 = var2;
      }

      if (var0 - (double)var7 > var2) {
         double var8 = var0 - (double)var7;
      }

      return var2;
   }

   public static void c6631(double var0, double var2, double var4, double var6, double var8, int var10) {
      c48209(var0, var2, var4 - var0, var6 - var2, var8, var10);
   }

   public static double c9977() {
      return Minecraft.getDebugFPS() > 0 ? 1.0D / (double)Minecraft.getDebugFPS() : 1.0D;
   }

   public static void c63437(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      c82808(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      c68297(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c48209(double var0, double var2, double var4, double var6, double var8, int var10) {
      Value.c27574();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      double var12 = var0 + var4;
      double var14 = var2 + var6;
      float var16 = (float)(var10 >> 24 & 255) / 255.0F;
      float var17 = (float)(var10 >> 16 & 255) / 255.0F;
      float var18 = (float)(var10 >> 8 & 255) / 255.0F;
      float var19 = (float)(var10 & 255) / 255.0F;
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      var0 = var0 * 2.0D;
      var2 = var2 * 2.0D;
      var12 = var12 * 2.0D;
      var14 = var14 * 2.0D;
      GL11.glDisable(3553);
      GL11.glColor4f(var17, var18, var19, var16);
      GL11.glEnable(2848);
      GL11.glBegin(9);
      int var20 = 0;
      if (var20 <= 90) {
         GL11.glVertex2d(var0 + var8 + Math.sin((double)var20 * 3.141592653589793D / 180.0D) * var8 * -1.0D, var2 + var8 + Math.cos((double)var20 * 3.141592653589793D / 180.0D) * var8 * -1.0D);
         var20 = var20 + 3;
      }

      var20 = 90;
      if (var20 <= 180) {
         GL11.glVertex2d(var0 + var8 + Math.sin((double)var20 * 3.141592653589793D / 180.0D) * var8 * -1.0D, var14 - var8 + Math.cos((double)var20 * 3.141592653589793D / 180.0D) * var8 * -1.0D);
         var20 = var20 + 3;
      }

      var20 = 0;
      if (var20 <= 90) {
         GL11.glVertex2d(var12 - var8 + Math.sin((double)var20 * 3.141592653589793D / 180.0D) * var8, var14 - var8 + Math.cos((double)var20 * 3.141592653589793D / 180.0D) * var8);
         var20 = var20 + 3;
      }

      var20 = 90;
      if (var20 <= 180) {
         GL11.glVertex2d(var12 - var8 + Math.sin((double)var20 * 3.141592653589793D / 180.0D) * var8, var2 + var8 + Math.cos((double)var20 * 3.141592653589793D / 180.0D) * var8);
         var20 = var20 + 3;
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void c68297(AxisAlignedBB var0) {
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

   public static void c96647(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c94433() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c88029(double var0, double var2, float var4, float var5, double var6, double var8, float var10, float var11) {
      float var12 = 1.0F / var10;
      float var13 = 1.0F / var11;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(7, DefaultVertexFormats.POSITION_TEX);
      var15.pos(var0, var2 + var8, 0.0D).tex((double)(var4 * var12), (double)((var5 + (float)var8) * var13)).endVertex();
      var15.pos(var0 + var6, var2 + var8, 0.0D).tex((double)((var4 + (float)var6) * var12), (double)((var5 + (float)var8) * var13)).endVertex();
      var15.pos(var0 + var6, var2, 0.0D).tex((double)((var4 + (float)var6) * var12), (double)(var5 * var13)).endVertex();
      var15.pos(var0, var2, 0.0D).tex((double)(var4 * var12), (double)(var5 * var13)).endVertex();
      var14.draw();
   }

   public static void c39900(ResourceLocation var0, float var1, float var2, float var3, float var4) {
      Value.c27574();
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      if (Objects.equals(HUD.c49595.c54460(), "Rainbow")) {
         c96647(RenderUtilG.c61874(5, (int)(var2 * 20.0F), Sleep.INSTANCE.c27940(), Sleep.INSTANCE.c19118(), HUD.c11055.c1473().booleanValue()).getRGB());
      }

      if (Objects.equals(HUD.c49595.c54460(), "Category")) {
         c96647(-1);
      }

      if (Objects.equals(HUD.c49595.c54460(), "Astolfo")) {
         c96647(RenderUtilG.c72816((int)(var2 * 50.0F)));
      }

      if (Objects.equals(HUD.c49595.c54460(), "Fade")) {
         c96647(ColorUtil.c3182(new Color(HUD.c64734.c41161().intValue()), (int)(var2 / 11.0F), HUD.c78194.c53968().intValue()).getRGB());
      }

      c96647(HUD.c64734.c41161().intValue());
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      c88029((double)var1, (double)var2, 0.0F, 0.0F, (double)var3, (double)var4, var3, var4);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void c80877(double var0, double var2, double var4, double var6, int var8, int var9) {
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

   public static void c48481(double var0, double var2, double var4, int var6, int var7, float var8, float var9) {
      float var10 = (float)(var6 >> 16 & 255) / 255.0F;
      float var11 = (float)(var6 >> 8 & 255) / 255.0F;
      float var12 = (float)(var6 & 255) / 255.0F;
      float var13 = (float)(var7 >> 16 & 255) / 255.0F;
      float var14 = (float)(var7 >> 8 & 255) / 255.0F;
      float var15 = (float)(var7 & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var8);
      c82808(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glLineWidth(var9);
      GL11.glColor4f(var13, var14, var15, var8);
      c68297(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c35355(double var0, double var2, double var4, double var6, double var8, Color var10) {
      double var11 = Math.abs(var4 - var0);
      double var13 = Math.abs(var6 - var2);
      double var15 = var11 / 4.0D;
      double var17 = var13 / 4.0D;
      c97875();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var8);
      c83954(var10);
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
      c30688();
   }

   public static void c97875() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void c30688() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c83954(Color var0) {
      float var1 = (float)(var0.getRGB() >> 24 & 255) / 255.0F;
      float var2 = (float)(var0.getRGB() >> 16 & 255) / 255.0F;
      float var3 = (float)(var0.getRGB() >> 8 & 255) / 255.0F;
      float var4 = (float)(var0.getRGB() & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   private static JSONException c38677(JSONException var0) {
      return var0;
   }
}
