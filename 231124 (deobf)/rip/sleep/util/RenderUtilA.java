package rip.sleep.util;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.vecmath.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import rip.sleep.module.modules.HUD;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RenderUtilA {
   private static final Minecraft c57221 = Minecraft.getMinecraft();
   private static final Map<Integer, Boolean> c99981 = new HashMap();
   private static final Frustum c67584 = new Frustum();
   private static final IntBuffer c56526 = GLAllocation.createDirectIntBuffer(16);
   private static final FloatBuffer c88046 = GLAllocation.createDirectFloatBuffer(16);
   private static final FloatBuffer c42843 = GLAllocation.createDirectFloatBuffer(16);

   public static ScaledResolution c83093() {
      return new ScaledResolution(c57221);
   }

   public static Matrix4f c70124(int var0) {
      FloatBuffer var1 = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat(var0, var1);
      return (Matrix4f)(new Matrix4f()).load(var1);
   }

   public static boolean c43580(int var0, int var1, int var2, int var3, int var4, int var5) {
      Module[] var6 = Value.c27574();
      return var4 >= var0 && var4 <= var0 + var2 && var5 >= var1 && var5 <= var1 + var3;
   }

   public static void c15714(float var0, float var1, float var2, int var3, int var4, int var5) {
      Value.c27574();
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glBegin(6);
      c98707(var5);
      GL11.glVertex2f(var0, var1);
      float var7 = (float)var3;
      if (var7 <= (float)var4) {
         c98707(var5);
         GL11.glVertex2f((float)((double)var2 * Math.cos(3.141592653589793D * (double)var7 / 180.0D) + (double)var0), (float)((double)var2 * Math.sin(3.141592653589793D * (double)var7 / 180.0D) + (double)var1));
         ++var7;
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glEnable(2884);
      GL11.glDisable(3042);
   }

   public static void c15215(int var0, int var1, int var2, int var3, int var4, String var5) {
      Module[] var6 = Value.c27574();
      if (var4 == 0) {
         GlStateManager.color(1.0F, 1.0F, 1.0F);
      }

      c98707(var4);
      ResourceLocation var7 = new ResourceLocation("sleep/" + var5);
      c57221.getTextureManager().bindTexture(var7);
      GlStateManager.enableBlend();
      GL11.glTexParameteri(3553, 10240, 9729);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
      GlStateManager.disableBlend();
   }

   public static void c69215(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      Module[] var7 = Value.c27574();
      if (var6 == -1) {
         Gui.drawRect(var0, var1, var2 + var0, var1 + var3, var5);
      }

      if (var6 == 0) {
         Gui.drawRect(var0 + var4, var1 + var4, var0 + var2 - var4, var1 + var3 - var4, var5);
         Gui.drawRect(var0 + var4, var1, var0 + var2 - var4, var1 + var4, var5);
         Gui.drawRect(var0 + var2 - var4, var1 + var4, var0 + var2, var1 + var3 - var4, var5);
         Gui.drawRect(var0 + var4, var1 + var3 - var4, var0 + var2 - var4, var1 + var3, var5);
         Gui.drawRect(var0, var1 + var4, var0 + var4, var1 + var3 - var4, var5);
         c15714((float)(var0 + var4), (float)(var1 + var4), (float)var4, 180, 270, var5);
         c15714((float)(var0 + var2 - var4), (float)(var1 + var4), (float)var4, 270, 360, var5);
         c15714((float)(var0 + var4), (float)(var1 + var3 - var4), (float)var4, 90, 180, var5);
         c15714((float)(var0 + var2 - var4), (float)(var1 + var3 - var4), (float)var4, 0, 90, var5);
      }

      if (var6 == 1) {
         Gui.drawRect(0, 0, 0, 0, -1);
         Gui.drawRect(var0 + var4, var1 + var4, var0 + var2 - var4, var1 + var3 - var4, var5);
         Gui.drawRect(var0 + var4, var1, var0 + var2 - var4, var1 + var4, var5);
         Gui.drawRect(var0 + var2 - var4, var1 + var4, var0 + var2, var1 + var3 - var4, var5);
         Gui.drawRect(var0, var1 + var3 - var4, var0 + var2, var1 + var3, var5);
         Gui.drawRect(var0, var1 + var4, var0 + var4, var1 + var3 - var4, var5);
         c15714((float)(var0 + var4), (float)(var1 + var4), (float)var4, 180, 270, var5);
         c15714((float)(var0 + var2 - var4), (float)(var1 + var4), (float)var4, 270, 360, var5);
      }

      if (var6 == 2) {
         Gui.drawRect(0, 0, 0, 0, -1);
         Gui.drawRect(var0 + var4, var1 + var4, var0 + var2 - var4, var1 + var3 - var4, var5);
         Gui.drawRect(var0, var1, var0 + var2, var1 + var4, var5);
         Gui.drawRect(var0 + var2 - var4, var1 + var4, var0 + var2, var1 + var3 - var4, var5);
         Gui.drawRect(var0 + var4, var1 + var3 - var4, var0 + var2 - var4, var1 + var3, var5);
         Gui.drawRect(var0, var1 + var4, var0 + var4, var1 + var3 - var4, var5);
         c15714((float)(var0 + var4), (float)(var1 + var3 - var4), (float)var4, 90, 180, var5);
         c15714((float)(var0 + var2 - var4), (float)(var1 + var3 - var4), (float)var4, 0, 90, var5);
      }

   }

   public static void c66041(AxisAlignedBB var0) {
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

   public static void c67882(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13) {
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.disableDepth();
      GlStateManager.color(var10, var11, var12, var13);
      c66041(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableDepth();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static Vector3d c29053(double var0, double var2, double var4) {
      FloatBuffer var6 = GLAllocation.createDirectFloatBuffer(4);
      GL11.glGetFloat(2982, c88046);
      GL11.glGetFloat(2983, c42843);
      GL11.glGetInteger(2978, c56526);
      return GLU.gluProject((float)var0, (float)var2, (float)var4, c88046, c42843, c56526, var6) ? new Vector3d((double)(var6.get(0) / (float)c83093().getScaleFactor()), (double)(((float)Display.getHeight() - var6.get(1)) / (float)c83093().getScaleFactor()), (double)var6.get(2)) : null;
   }

   public static Vector c23104(Vector3f var0, int var1, int var2) {
      return c4181(var0, c70124(2982), c70124(2983), var1, var2);
   }

   public static void c6801(float var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      Value.c27574();
      float var8 = (float)(var6 >> 24 & 255) / 255.0F;
      float var9 = (float)(var6 >> 16 & 255) / 255.0F;
      float var10 = (float)(var6 >> 8 & 255) / 255.0F;
      float var11 = (float)(var6 & 255) / 255.0F;
      float var12 = var3 / var4;
      GL11.glColor4f(var9, var10, var11, var8);
      c19938(var0, var1, var2, var3, 0.5F, -16777216, 0);
      float var13 = var1 + var3 - var12;
      int var14 = 0;
      if ((float)var14 < var5) {
         c19938(var0 + 0.25F, var13, var2 - 0.5F, var12, 0.25F, -16777216, var6);
         float var10000 = var13 - var12;
         ++var14;
      }

   }

   public static double c19743(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }

   public static boolean c45634(Entity var0) {
      Module[] var1 = Value.c27574();
      return c52882(var0.getEntityBoundingBox()) || var0.ignoreFrustumCheck;
   }

   public static boolean c52882(AxisAlignedBB var0) {
      Entity var1 = Minecraft.getMinecraft().getRenderViewEntity();
      c67584.setPosition(var1.posX, var1.posY, var1.posZ);
      return c67584.isBoundingBoxInFrustum(var0);
   }

   public static Vector2f c4181(Vector3f var0, Matrix4f var1, Matrix4f var2, int var3, int var4) {
      Value.c27574();
      Vector4f var6 = c62136(c62136(new Vector4f(var0.x, var0.y, var0.z, 1.0F), var1), var2);
      Vector3f var7 = new Vector3f(var6.x / var6.w, var6.y / var6.w, var6.z / var6.w);
      float var8 = (var7.x + 1.0F) / 2.0F * (float)var3;
      float var9 = (1.0F - var7.y) / 2.0F * (float)var4;
      return (double)var7.z >= -1.0D && (double)var7.z <= 1.0D ? new Vector2f(var8, var9) : null;
   }

   public static void c87816(int var0, int var1, int var2, int var3, int var4, int var5, float var6) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.getInstance();
      WorldRenderer var10 = var9.getWorldRenderer();
      var10.begin(7, DefaultVertexFormats.POSITION_TEX);
      var10.pos((double)(var0 + 0), (double)(var1 + var5), (double)var6).tex((double)((float)(var2 + 0) * var7), (double)((float)(var3 + var5) * var8)).endVertex();
      var10.pos((double)(var0 + var4), (double)(var1 + var5), (double)var6).tex((double)((float)(var2 + var4) * var7), (double)((float)(var3 + var5) * var8)).endVertex();
      var10.pos((double)(var0 + var4), (double)(var1 + 0), (double)var6).tex((double)((float)(var2 + var4) * var7), (double)((float)(var3 + 0) * var8)).endVertex();
      var10.pos((double)(var0 + 0), (double)(var1 + 0), (double)var6).tex((double)((float)(var2 + 0) * var7), (double)((float)(var3 + 0) * var8)).endVertex();
      var9.draw();
   }

   public static void c67209(Color var0) {
      Module[] var1 = Value.c27574();
      if (var0 == null) {
         var0 = Color.white;
      }

      GL11.glColor4d((double)((float)var0.getRed() / 255.0F), (double)((float)var0.getGreen() / 255.0F), (double)((float)var0.getBlue() / 255.0F), (double)((float)var0.getAlpha() / 255.0F));
   }

   public static void c72289(double var0, double var2, double var4, Color var6) {
      c74912(var0, var2, var4, 360.0D, var6);
   }

   public static void c74912(double var0, double var2, double var4, double var6, Color var8) {
      var4 = var4 / 2.0D;
      Value.c27574();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2884);
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
      c67209(var8);
      GL11.glEnable(2848);
      GL11.glBegin(6);
      double var10 = 0.0D;
      if (var10 <= var6 / 4.0D) {
         double var12 = var10 * 4.0D * 6.283185307179586D / 360.0D;
         GL11.glVertex2d(var0 + var4 * Math.cos(var12) + var4, var2 + var4 * Math.sin(var12) + var4);
         ++var10;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GlStateManager.enableAlpha();
      GlStateManager.enableDepth();
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      c67209(Color.white);
   }

   public static Vector4f c62136(Vector4f var0, Matrix4f var1) {
      return new Vector4f(var0.x * var1.m00 + var0.y * var1.m10 + var0.z * var1.m20 + var0.w * var1.m30, var0.x * var1.m01 + var0.y * var1.m11 + var0.z * var1.m21 + var0.w * var1.m31, var0.x * var1.m02 + var0.y * var1.m12 + var0.z * var1.m22 + var0.w * var1.m32, var0.x * var1.m03 + var0.y * var1.m13 + var0.z * var1.m23 + var0.w * var1.m33);
   }

   public static void c46054(float var0, float var1, float var2, float var3) {
      ScaledResolution var4 = new ScaledResolution(c57221);
      c70278(var0 - 9.0F, var1 - 9.0F, 9.0F, 9.0F, "paneltopleft", var4);
      c70278(var0 - 9.0F, var1 + var3, 9.0F, 9.0F, "panelbottomleft", var4);
      c70278(var0 + var2, var1 + var3, 9.0F, 9.0F, "panelbottomright", var4);
      c70278(var0 + var2, var1 - 9.0F, 9.0F, 9.0F, "paneltopright", var4);
      c70278(var0 - 9.0F, var1, 9.0F, var3, "panelleft", var4);
      c70278(var0 + var2, var1, 9.0F, var3, "panelright", var4);
      c70278(var0, var1 - 9.0F, var2, 9.0F, "paneltop", var4);
      c70278(var0, var1 + var3, var2, 9.0F, "panelbottom", var4);
   }

   public static double c72015(double var0, double var2, double var4) {
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
      if (var10 < 0.1D) {
         var10 = 0.1D;
      }

      if (var7) {
         var2 += var10;
      }

      var2 = var2 - var10;
      return var2;
   }

   public static void c49630(double var0, double var2, double var4, double var6, double var8, int var10) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      double var12 = var0 + var4;
      Value.c27574();
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

   public static void c81386(double var0, double var2, double var4, double var6, double var8, float var10, int var11) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      double var13 = var0 + var4;
      double var15 = var2 + var6;
      Value.c27574();
      float var17 = (float)(var11 >> 24 & 255) / 255.0F;
      float var18 = (float)(var11 >> 16 & 255) / 255.0F;
      float var19 = (float)(var11 >> 8 & 255) / 255.0F;
      float var20 = (float)(var11 & 255) / 255.0F;
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      var0 = var0 * 2.0D;
      var2 = var2 * 2.0D;
      var13 = var13 * 2.0D;
      var15 = var15 * 2.0D;
      GL11.glLineWidth(var10);
      GL11.glDisable(3553);
      GL11.glColor4f(var18, var19, var20, var17);
      GL11.glEnable(2848);
      GL11.glBegin(2);
      int var21 = 0;
      if (var21 <= 90) {
         GL11.glVertex2d(var0 + var8 + Math.sin((double)var21 * 3.141592653589793D / 180.0D) * var8 * -1.0D, var2 + var8 + Math.cos((double)var21 * 3.141592653589793D / 180.0D) * var8 * -1.0D);
         var21 = var21 + 3;
      }

      var21 = 90;
      if (var21 <= 180) {
         GL11.glVertex2d(var0 + var8 + Math.sin((double)var21 * 3.141592653589793D / 180.0D) * var8 * -1.0D, var15 - var8 + Math.cos((double)var21 * 3.141592653589793D / 180.0D) * var8 * -1.0D);
         var21 = var21 + 3;
      }

      var21 = 0;
      if (var21 <= 90) {
         GL11.glVertex2d(var13 - var8 + Math.sin((double)var21 * 3.141592653589793D / 180.0D) * var8, var15 - var8 + Math.cos((double)var21 * 3.141592653589793D / 180.0D) * var8);
         var21 = var21 + 3;
      }

      var21 = 90;
      if (var21 <= 180) {
         GL11.glVertex2d(var13 - var8 + Math.sin((double)var21 * 3.141592653589793D / 180.0D) * var8, var2 + var8 + Math.cos((double)var21 * 3.141592653589793D / 180.0D) * var8);
         var21 = var21 + 3;
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

   public static void c24914(double var0, double var2, double var4, double var6) {
      ScaledResolution var8 = new ScaledResolution(Minecraft.getMinecraft());
      int var9 = var8.getScaleFactor();
      GL11.glScissor((int)(var0 * (double)((float)var9)), (int)(((double)((float)var8.getScaledHeight()) - var6) * (double)((float)var9)), (int)((var4 - var0) * (double)((float)var9)), (int)((var6 - var2) * (double)((float)var9)));
   }

   public static void c61773(int var0, int var1, int var2, int var3, float var4) {
      var0 = var0 - 5;
      var2 = var2 + 5;
      var1 = var1 - 5;
      var3 = var3 + 5;
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      c57221.getTextureManager().bindTexture(new ResourceLocation("sleep/shader/shadow.png"));
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

   public static void c70278(float var0, float var1, float var2, float var3, String var4, ScaledResolution var5) {
      GL11.glPushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      c57221.getTextureManager().bindTexture(new ResourceLocation("sleep/shader/" + var4 + ".png"));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      Gui.drawModalRectWithCustomSizedTexture((int)var0, (int)var1, 0.0F, 0.0F, (int)var2, (int)var3, (float)((int)var2), (float)((int)var3));
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GL11.glPopMatrix();
   }

   public static double[] c5182(double var0, double var2, double var4) {
      FloatBuffer var7 = BufferUtils.createFloatBuffer(3);
      IntBuffer var8 = BufferUtils.createIntBuffer(16);
      FloatBuffer var9 = BufferUtils.createFloatBuffer(16);
      Value.c27574();
      FloatBuffer var10 = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat(2982, var9);
      GL11.glGetFloat(2983, var10);
      GL11.glGetInteger(2978, var8);
      boolean var11 = GLU.gluProject((float)var0, (float)var2, (float)var4, var9, var10, var8, var7);
      return var11 ? new double[]{(double)var7.get(0), (double)((float)Display.getHeight() - var7.get(1)), (double)var7.get(2)} : null;
   }

   public static void c18401(float var0, float var1, float var2, float var3, int var4, int var5) {
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

   public static void c27632(double var0, double var2, double var4, double var6) {
      c28773(var0, var2, var0 + var4, var2 + var6, Color.BLACK.getRGB());
      c28773(var0 + 1.0D, var2 + 1.0D, var0 + var4 - 1.0D, var2 + var6 - 1.0D, (new Color(55, 55, 55)).getRGB());
      c28773(var0 + 1.0D, var2 + 1.5D, var0 + var4 - 2.0D, var2 + var6 - 1.5D, (new Color(30, 30, 30)).getRGB());
      c28773(var0 + 3.0D, var2 + 3.0D, var0 + var4 - 3.0D, var2 + var6 - 3.0D, (new Color(14, 14, 14)).getRGB());
   }

   public static void c32234(int var0, int var1, int var2, int var3) {
      GlStateManager.resetColor();
      c28773((double)var0, (double)var1, (double)(var0 + var2), (double)(var1 + var3), Color.BLACK.getRGB());
      c28773((double)var0, (double)var1, (double)(var0 + var2), (double)(var1 + var3), (new Color(55, 55, 55)).getRGB());
      c28773((double)(var0 + 1), (double)(var1 + 1), (double)(var0 + var2 - 1), (double)(var1 + var3 - 1), (new Color(14, 14, 14)).getRGB());
      GlStateManager.resetColor();
   }

   public static void c19127(double var0, double var2, double var4, double var6, double var8) {
      c70269(var0, var2 + -4.0D, var0 + var4 + var8, var2 + var6 + var8, 0.5D, (new Color(60, 60, 60)).getRGB(), (new Color(10, 10, 10)).getRGB());
      c70269(var0 + 1.0D, var2 + -3.0D, var0 + var4 + var8 - 1.0D, var2 + var6 + var8 - 1.0D, 1.0D, (new Color(40, 40, 40)).getRGB(), (new Color(40, 40, 40)).getRGB());
      c70269(var0 + 2.5D, var2 + -1.5D, var0 + var4 + var8 - 2.5D, var2 + var6 + var8 - 2.5D, 0.5D, (new Color(40, 40, 40)).getRGB(), (new Color(60, 60, 60)).getRGB());
      c70269(var0 + 2.5D, var2 + -1.5D, var0 + var4 + var8 - 2.5D, var2 + var6 + var8 - 2.5D, 0.5D, (new Color(22, 22, 22)).getRGB(), (new Color(255, 255, 255, 0)).getRGB());
   }

   public static void c40667(double var0, double var2, double var4, double var6, double var8) {
      c70269(var0 + 4.35D, var2 + 0.5D, var0 + var4 + var8 - 84.5D, var2 + var6 + var8 - 4.35D, 0.5D, (new Color(48, 48, 48)).getRGB(), (new Color(10, 10, 10)).getRGB());
      c70269(var0 + 5.0D, var2 + 1.0D, var0 + var4 + var8 - 85.0D, var2 + var6 + var8 - 5.0D, 0.5D, (new Color(17, 17, 17)).getRGB(), (new Color(255, 255, 255, 0)).getRGB());
   }

   public static void c98201(double var0, double var2, double var4, double var6) {
      c70269(var0 + 4.35D, var2 + 0.5D, var0 + var4 - 84.5D, var2 + var6 - 4.35D, 0.5D, (new Color(48, 48, 48)).getRGB(), (new Color(10, 10, 10)).getRGB());
      c70269(var0 + 5.0D, var2 + 1.0D, var0 + var4 - 85.0D, var2 + var6 - 5.0D, 0.5D, (new Color(17, 17, 17)).getRGB(), (new Color(255, 255, 255, 0)).getRGB());
   }

   public static void c263(float var0, float var1, float var2, float var3, int var4) {
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

   public static void c5699(float var0, float var1, float var2, float var3, float var4, int var5, float var6, int var7) {
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

      c263(var0 + var4, var1 + var4, var2 - var4 * 2.0F, var3 - var4 * 2.0F, var5);
      c263(var0 + var4, var1, var2 - var4 * 2.0F, var4, var5);
      c263(var0 + var4, var1 + var3 - var4, var2 - var4 * 2.0F, var4, var5);
      c263(var0, var1 + var4, var4, var3 - var4 * 2.0F, var5);
      c263(var0 + var2 - var4, var1 + var4, var4, var3 - var4 * 2.0F, var5);
      c67621();
      c98707(var5);
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
      c98707(var7);
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
      c51372();
   }

   public static void c67621() {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
   }

   public static void c51372() {
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static int c80726(int var0, float var1) {
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

   public static Color c37825(Color var0, float var1) {
      Color var2 = var0;
      float var10000 = 0.003921569F;
      Color var10001 = var0;

      try {
         float var3 = var10000 * (float)var10001.getRed();
         float var4 = 0.003921569F * (float)var2.getGreen();
         float var5 = 0.003921569F * (float)var2.getBlue();
         return new Color(var3, var4, var5, var1);
      } catch (Throwable var6) {
         var6.printStackTrace();
         return var0;
      }
   }

   public static void c61463(Runnable var0) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      var0.run();
      GL11.glEnable(3553);
      GlStateManager.disableBlend();
   }

   public static void c67415(int var0, Runnable var1) {
      GL11.glBegin(var0);
      var1.run();
      GL11.glEnd();
   }

   public static void c44302() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c10265(float var0, float var1, double var2, int var4, int var5, double var6, int var8) {
      var2 = var2 * 2.0D;
      var0 = var0 * 2.0F;
      var1 = var1 * 2.0F;
      float var10 = (float)(var4 >> 24 & 255) / 255.0F;
      float var11 = (float)(var4 >> 16 & 255) / 255.0F;
      float var12 = (float)(var4 >> 8 & 255) / 255.0F;
      float var13 = (float)(var4 & 255) / 255.0F;
      GL11.glDisable(2929);
      Value.c27574();
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

   public static void c92648(float var0, float var1, float var2, int var3, int var4) {
      GL11.glPushMatrix();
      var0 = var0 * 2.0F;
      var1 = var1 * 2.0F;
      float var6 = (float)(var4 >> 24 & 255) / 255.0F;
      float var7 = (float)(var4 >> 16 & 255) / 255.0F;
      float var8 = (float)(var4 >> 8 & 255) / 255.0F;
      float var9 = (float)(var4 & 255) / 255.0F;
      float var10 = (float)(6.2831852D / (double)var3);
      float var11 = (float)Math.cos((double)var10);
      float var12 = (float)Math.sin((double)var10);
      Value.c27574();
      float var19;
      float var13 = var19 = var2 * 2.0F;
      float var14 = 0.0F;
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
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
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
      GL11.glPopMatrix();
   }

   public static void c33912(float var0, float var1, float var2, int var3) {
      Value.c27574();
      GlStateManager.pushMatrix();
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

   public static void c11117(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      c66041(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      c62557(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c54320(Entity var0, double var1, boolean var3) {
      GL11.glPushMatrix();
      GL11.glDisable(3553);
      Value.c27574();
      GL11.glEnable(2848);
      GL11.glEnable(2832);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glHint(3153, 4354);
      GL11.glDepthMask(false);
      GlStateManager.alphaFunc(516, 0.0F);
      if (var3) {
         GL11.glShadeModel(7425);
      }

      GlStateManager.disableCull();
      GL11.glBegin(5);
      double var5 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)c57221.timer.renderPartialTicks - c57221.getRenderManager().renderPosX;
      double var7 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)c57221.timer.renderPartialTicks - c57221.getRenderManager().renderPosY + Math.sin((double)System.currentTimeMillis() / 200.0D) + 1.0D;
      double var9 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)c57221.timer.renderPartialTicks - c57221.getRenderManager().renderPosZ;
      float var12 = 0.0F;
      if ((double)var12 < 6.283185307179586D) {
         double var13 = var5 + var1 * Math.cos((double)var12);
         double var15 = var9 + var1 * Math.sin((double)var12);
         Color var11 = new Color(HUD.c64734.c41161().intValue());
         if (var3) {
            GL11.glColor4f((float)var11.getRed() / 255.0F, (float)var11.getGreen() / 255.0F, (float)var11.getBlue() / 255.0F, 0.0F);
            GL11.glVertex3d(var13, var7 - Math.cos((double)System.currentTimeMillis() / 200.0D) / 2.0D, var15);
            GL11.glColor4f((float)var11.getRed() / 255.0F, (float)var11.getGreen() / 255.0F, (float)var11.getBlue() / 255.0F, 0.85F);
         }

         GL11.glVertex3d(var13, var7, var15);
         var12 = (float)((double)var12 + 0.09817477042468103D);
      }

      GL11.glEnd();
      if (var3) {
         GL11.glShadeModel(7424);
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.enableCull();
      GL11.glDisable(2848);
      GL11.glDisable(2848);
      GL11.glEnable(2832);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
      GL11.glColor3f(255.0F, 255.0F, 255.0F);
   }

   public static void c70269(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      c28773(var0 + var8, var2 + var8, var4 - var8, var6 - var8, var10);
      c28773(var0 + var8, var2, var4 - var8, var2 + var8, var11);
      c28773(var0, var2, var0 + var8, var6, var11);
      c28773(var4 - var8, var2, var4, var6, var11);
      c28773(var0 + var8, var6 - var8, var4 - var8, var6, var11);
   }

   public static void c39593(double var0, double var2, double var4, double var6, double var8, int var10, int var11) {
      c28773(var0 + var8, var2 + var8, var0 + var4 - var8, var2 + var6 - var8, var10);
      c28773(var0 + var8, var2, var0 + var4 - var8, var2 + var2 + var8, var11);
      c28773(var0, var2, var0 + var0 + var8, var2 + var6, var11);
      c28773(var4 - var8, var2, var0 + var4, var2 + var6, var11);
      c28773(var0 + var8, var6 - var8, var0 + var4 - var8, var2 + var6, var11);
   }

   public static void c16798(int var0) {
      Value.c27574();
      float var2 = (float)(var0 >> 24 & 255) / 255.0F;
      float var3 = (float)(var0 >> 16 & 255) / 255.0F;
      float var4 = (float)(var0 >> 8 & 255) / 255.0F;
      float var5 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var3, var4, var5, var2 == 0.0F ? 1.0F : var2);
   }

   public static void c87625(Color var0) {
      float var2 = (float)(var0.getRGB() >> 24 & 255) / 255.0F;
      float var3 = (float)(var0.getRGB() >> 16 & 255) / 255.0F;
      Value.c27574();
      float var4 = (float)(var0.getRGB() >> 8 & 255) / 255.0F;
      float var5 = (float)(var0.getRGB() & 255) / 255.0F;
      GL11.glColor4f(var3, var4, var5, var2 == 0.0F ? 1.0F : var2);
   }

   public static void c56285(int var0, boolean var1) {
      Value.c27574();
      c99981.put(Integer.valueOf(var0), Boolean.valueOf(GL11.glGetBoolean(var0)));
      if (var1) {
         GL11.glEnable(var0);
      }

      GL11.glDisable(var0);
   }

   private static void c92103(int var0) {
      Value.c27574();
      Boolean var2 = (Boolean)c99981.get(Integer.valueOf(var0));
      if (var2 != null) {
         if (var2.booleanValue()) {
            GL11.glEnable(var0);
         }

         GL11.glDisable(var0);
      }

   }

   public static void c72995() {
      Value.c27574();
      Iterator var1 = c99981.keySet().iterator();
      if (var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         c92103(var2.intValue());
      }

   }

   public static void c89423(float var0) {
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

   public static void c10662() {
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

   public static void c19938(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      c28773((double)var0, (double)var1, (double)var2, (double)var3, var6);
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

   public static void c34031(double var0, double var2, double var4, double var6, float var8, int var9, int var10) {
      c28773(var0, var2, var4, var6, var10);
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

   public static int c98557(int var0) {
      int var1 = var0 >> 16 & 255;
      int var2 = var0 >> 8 & 255;
      int var3 = var0 & 255;
      short var4 = 255;
      return (var1 & 255) << 16 | (var2 & 255) << 8 | var3 & 255 | (var4 & 255) << 24;
   }

   public static int c11822(Color var0) {
      int var1 = var0.getRGB() >> 16 & 255;
      int var2 = var0.getRGB() >> 8 & 255;
      int var3 = var0.getRGB() & 255;
      short var4 = 255;
      return (var1 & 255) << 16 | (var2 & 255) << 8 | var3 & 255 | (var4 & 255) << 24;
   }

   public static int c88639(int var0, float var1) {
      int var2 = (int)((float)(var0 >> 16 & 255) * var1);
      int var3 = (int)((float)(var0 >> 8 & 255) * var1);
      int var4 = (int)((float)(var0 & 255) * var1);
      int var5 = var0 >> 24 & 255;
      return (var2 & 255) << 16 | (var3 & 255) << 8 | var4 & 255 | (var5 & 255) << 24;
   }

   public static void c4799(double var0, double var2, double var4, double var6) {
      Value.c27574();
      int var9 = (new ScaledResolution(Minecraft.getMinecraft())).getScaleFactor();
      if (var9 < 2 && Minecraft.getMinecraft().displayWidth / (var9 + 1) >= 320 && Minecraft.getMinecraft().displayHeight / (var9 + 1) >= 240) {
         ++var9;
      }

      GL11.glScissor((int)(var0 * (double)var9), (int)((double)Minecraft.getMinecraft().displayHeight - (var2 + var6) * (double)var9), (int)(var4 * (double)var9), (int)(var6 * (double)var9));
   }

   public static void c72443(String var0, float var1, float var2, int var3) {
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      c57221.fontRendererObj.drawString(var0, (int)(var1 * 2.0F - 1.0F), (int)(var2 * 2.0F), Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)(var1 * 2.0F + 1.0F), (int)(var2 * 2.0F), Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F - 1.0F), Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F + 1.0F), Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)(var1 * 2.0F), (int)(var2 * 2.0F), var3);
      GL11.glPopMatrix();
   }

   public static void c83230(String var0, float var1, float var2, int var3) {
      GL11.glPushMatrix();
      c57221.fontRendererObj.drawString(var0, (int)(var1 - 1.0F), (int)var2, Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)(var1 + 1.0F), (int)var2, Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)var1, (int)(var2 - 1.0F), Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)var1, (int)(var2 + 1.0F), Color.BLACK.getRGB());
      c57221.fontRendererObj.drawString(var0, (int)var1, (int)var2, var3);
      GL11.glPopMatrix();
   }

   public static void c28484(double var0, double var2, int var4, int var5) {
      c76826();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      c15930(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0 + 2.0D, var2 + 2.0D);
      GL11.glVertex2d(var0 + 5.0D, var2 - 2.0D);
      GL11.glEnd();
      GL11.glPopMatrix();
      c78741();
   }

   public static boolean c58363(float var0, float var1, float var2, float var3, int var4, int var5) {
      Module[] var6 = Value.c27574();
      return (float)var4 >= var0 && (float)var5 >= var1 && (float)var4 < var0 + var2 && (float)var5 < var1 + var3;
   }

   public static boolean c61022(int var0, int var1, double var2, double var4, double var6, double var8) {
      Module[] var10 = Value.c27574();
      return (double)var0 > var2 && (double)var0 < var6 && (double)var1 > var4 && (double)var1 < var8;
   }

   public static void c58362(double var0, double var2, int var4, int var5, double var6) {
      c76826();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      c15930(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0 + 3.0D, var2 + var6);
      GL11.glVertex2d(var0 + 6.0D, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      c78741();
   }

   public static void c15930(Color var0) {
      float var1 = (float)(var0.getRGB() >> 24 & 255) / 255.0F;
      float var2 = (float)(var0.getRGB() >> 16 & 255) / 255.0F;
      float var3 = (float)(var0.getRGB() >> 8 & 255) / 255.0F;
      float var4 = (float)(var0.getRGB() & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c76826() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void c78741() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c63909(BlockPos var0, int var1) {
      double var2 = (double)var0.getX() - c57221.getRenderManager().renderPosX;
      double var4 = (double)var0.getY() - c57221.getRenderManager().renderPosY;
      double var6 = (double)var0.getZ() - c57221.getRenderManager().renderPosZ;
      double var8 = c57221.theWorld.getBlockState(var0).getBlock().getBlockBoundsMaxY() - c57221.theWorld.getBlockState(var0).getBlock().getBlockBoundsMinY();
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
      c62557(new AxisAlignedBB(var2, var4, var6, var2 + 1.0D, var4 + var8, var6 + 1.0D));
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

   public static void c62557(AxisAlignedBB var0) {
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

   public static void c57917(int var0, float var1) {
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GlStateManager.color(var2, var3, var4, var1);
   }

   public static void c98707(int var0) {
      c57917(var0, (float)(var0 >> 24 & 255) / 255.0F);
   }

   public static void c37943(float var0, float var1, float var2, float var3, int var4, int var5) {
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

   public static void c45208(double var0, double var2, double var4, double var6, boolean var8, int var9, int var10) {
      GL11.glDisable(3553);
      Value.c27574();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glBegin(7);
      c98707(var9);
      if (var8) {
         GL11.glVertex2d(var0, var2);
         GL11.glVertex2d(var0, var6);
         c98707(var10);
         GL11.glVertex2d(var4, var6);
         GL11.glVertex2d(var4, var2);
      }

      GL11.glVertex2d(var0, var2);
      c98707(var10);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      c98707(var9);
      GL11.glVertex2d(var4, var2);
      GL11.glEnd();
      GL11.glDisable(3042);
      GL11.glShadeModel(7424);
      GL11.glEnable(3553);
   }

   public static void c91933(float var0, float var1, float var2, float var3) {
      Value.c27574();
      c28773((double)var0, (double)var1, (double)var2, (double)var3, RenderUtilG.c87305(16777215));
      if (var1 < var3) {
         float var5 = var0 + 0.0F;
         if (var5 < var2) {
            if (var5 <= var2 - 1.0F) {
               c28773((double)var5, (double)var1, (double)(var5 + 1.0F), (double)(var1 + 1.0F), RenderUtilG.c87305(8421504));
            }

            var5 = var5 + 2.0F;
         }

         ++var1;
      }

   }

   public static void c35798(int var0, int var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9) {
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

   public static void c37800(ResourceLocation var0, int var1, int var2, int var3, int var4) {
      c57221.getTextureManager().bindTexture(var0);
      c35798(var1, var2, 8.0F, 8.0F, 8, 8, var3, var4, 64.0F, 64.0F);
      c35798(var1, var2, 40.0F, 8.0F, 8, 8, var3, var4, 64.0F, 64.0F);
   }

   public static void c28773(double var0, double var2, double var4, double var6, int var8) {
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

   public static void c9761(double var0, double var2, double var4, double var6, Color var8) {
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

   public static void c80519(float var0, float var1, float var2, float var3, float var4, float var5, float var6, ResourceLocation var7) {
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

   public static void c32299(ResourceLocation var0, float var1, float var2, int var3, int var4) {
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

   private static JSONException c86731(JSONException var0) {
      return var0;
   }
}
