package rip.sleep.module.modules;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.RenderUtilF;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;

public class ChestESP extends Module {
   public static ModeValue c8784 = new ModeValue("Mode", new String[]{"Filled", "Box"}, "Box");
   private final IntBuffer c20463 = GLAllocation.createDirectIntBuffer(16);
   private final FloatBuffer c61267 = GLAllocation.createDirectFloatBuffer(16);
   private final FloatBuffer c97440 = GLAllocation.createDirectFloatBuffer(16);
   private final FloatBuffer c43835 = GLAllocation.createDirectFloatBuffer(4);

   public ChestESP() {
      super("Chest ESP", new String[]{"ChestESP"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   private void c36494(TileEntity var1) {
      double var3 = (double)var1.getPos().getX();
      Value.c27574();
      double var5 = (double)var1.getPos().getY();
      double var7 = (double)var1.getPos().getZ();
      AxisAlignedBB var9 = null;
      Block var10 = mc.theWorld.getBlockState(new BlockPos(var3, var5, var7)).getBlock();
      Block var11 = mc.theWorld.getBlockState(new BlockPos(var3 + 1.0D, var5, var7)).getBlock();
      Block var12 = mc.theWorld.getBlockState(new BlockPos(var3 - 1.0D, var5, var7)).getBlock();
      Block var13 = mc.theWorld.getBlockState(new BlockPos(var3, var5, var7 + 1.0D)).getBlock();
      Block var14 = mc.theWorld.getBlockState(new BlockPos(var3, var5, var7 - 1.0D)).getBlock();
      if (var11 == var10) {
         var9 = this.c39805(var3, var5, var7);
      } else if (var14 == var10) {
         var9 = this.c80390(var3, var5, var7);
      } else if (var12 != var10 && var13 != var10) {
         var9 = this.c47722(var3, var5, var7);
      }

      GlStateManager.disableAlpha();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      GlStateManager.disableTexture2D();
      GlStateManager.disableDepth();
      GL11.glEnable(2848);
      float[] var15 = this.c45636();
      c19984(var9, 1.0F, this.c93099(var15[0] / 255.0F, var15[1] / 255.0F, var15[2] / 255.0F, 0.2F));
      GL11.glDisable(2848);
      GlStateManager.enableDepth();
      GlStateManager.enableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.enableAlpha();
   }

   public static void c69637(AxisAlignedBB var0) {
      Module[] var1 = Value.c27574();
      if (var0 != null) {
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glEnd();
      }
   }

   public static void c45097(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c19984(AxisAlignedBB var0, float var1, int var2) {
      GL11.glLineWidth(var1);
      GL11.glEnable(2848);
      GL11.glEnable(2881);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      c45097(var2);
      c69637(var0);
      GL11.glDisable(2848);
      GL11.glDisable(2881);
   }

   private AxisAlignedBB c47722(double var1, double var3, double var5) {
      RenderManager var7 = mc.getRenderManager();
      return new AxisAlignedBB(var1 + 0.05000000074505806D - mc.getRenderManager().renderPosX, var3 - mc.getRenderManager().renderPosY, var5 + 0.05000000074505806D - mc.getRenderManager().renderPosZ, var1 + 0.949999988079071D - mc.getRenderManager().renderPosX, var3 + 0.8999999761581421D - mc.getRenderManager().renderPosY, var5 + 0.949999988079071D - mc.getRenderManager().renderPosZ);
   }

   private AxisAlignedBB c80390(double var1, double var3, double var5) {
      RenderManager var7 = mc.getRenderManager();
      return new AxisAlignedBB(var1 + 0.05000000074505806D - mc.getRenderManager().renderPosX, var3 - mc.getRenderManager().renderPosY, var5 + 0.05000000074505806D - mc.getRenderManager().renderPosZ - 1.0D, var1 + 0.949999988079071D - mc.getRenderManager().renderPosX, var3 + 0.8999999761581421D - mc.getRenderManager().renderPosY, var5 + 0.949999988079071D - mc.getRenderManager().renderPosZ);
   }

   private AxisAlignedBB c39805(double var1, double var3, double var5) {
      RenderManager var7 = mc.getRenderManager();
      return new AxisAlignedBB(var1 + 0.05000000074505806D - mc.getRenderManager().renderPosX, var3 - mc.getRenderManager().renderPosY, var5 + 0.05000000074505806D - mc.getRenderManager().renderPosZ, var1 + 1.9500000476837158D - mc.getRenderManager().renderPosX, var3 + 0.8999999761581421D - mc.getRenderManager().renderPosY, var5 + 0.949999988079071D - mc.getRenderManager().renderPosZ);
   }

   public float[] c45636() {
      Color var1 = new Color(HUD.c64734.c41161().intValue());
      return new float[]{(float)var1.getRed(), (float)var1.getGreen(), (float)var1.getBlue(), 200.0F};
   }

   public int c93099(float var1, float var2, float var3, float var4) {
      return ((int)(var4 * 255.0F) & 255) << 24 | ((int)(var1 * 255.0F) & 255) << 16 | ((int)(var2 * 255.0F) & 255) << 8 | (int)(var3 * 255.0F) & 255;
   }

   @EventTarget
   public void c41033(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if (((String)c8784.c26356).equals("Filled")) {
         Iterator var3 = mc.theWorld.loadedTileEntityList.iterator();
         if (var3.hasNext()) {
            TileEntity var4 = (TileEntity)var3.next();
            if ((var4 instanceof TileEntityChest || var4 instanceof TileEntityEnderChest) && !var4.isInvalid() && mc.theWorld.getBlockState(var4.getPos()) != null) {
               this.c36494(var4);
            }
         }
      }

   }

   @EventTarget
   public void c21825(Render2DEventA var1) {
      Module[] var2 = Value.c27574();
      if (((String)c8784.c26356).equals("Box")) {
         Iterator var3 = ((List) mc.theWorld.loadedTileEntityList.stream().filter((var0) -> {
            return var0 instanceof TileEntityChest;
         }).collect(Collectors.toList())).iterator();
         if (var3.hasNext()) {
            TileEntity var4 = (TileEntity)var3.next();
            BlockPos var5 = var4.getPos();
            AxisAlignedBB var6 = new AxisAlignedBB((double)var5.getX(), (double)var5.getY(), (double)var5.getZ(), (double)(var5.getX() + 1), (double)(var5.getY() + 1), (double)(var5.getZ() + 1));
            List var7 = Arrays.asList(new Vector3d(var6.minX, var6.minY, var6.minZ), new Vector3d(var6.minX, var6.maxY, var6.minZ), new Vector3d(var6.maxX, var6.minY, var6.minZ), new Vector3d(var6.maxX, var6.maxY, var6.minZ), new Vector3d(var6.minX, var6.minY, var6.maxZ), new Vector3d(var6.minX, var6.maxY, var6.maxZ), new Vector3d(var6.maxX, var6.minY, var6.maxZ), new Vector3d(var6.maxX, var6.maxY, var6.maxZ));
            mc.entityRenderer.setupCameraTransform(var1.c36064(), 0);
            Vector4d var8 = null;
            Iterator var9 = var7.iterator();
            if (var9.hasNext()) {
               Vector3d var10 = (Vector3d)var9.next();
               var10 = this.c98041(var1.c26056(), var10.x - mc.getRenderManager().viewerPosX, var10.y - mc.getRenderManager().viewerPosY, var10.z - mc.getRenderManager().viewerPosZ);
               if (var10 != null && var10.z >= 0.0D && var10.z < 1.0D) {
                  if (var8 == null) {
                     var8 = new Vector4d(var10.x, var10.y, var10.z, 0.0D);
                  }

                  var8.x = Math.min(var10.x, var8.x);
                  var8.y = Math.min(var10.y, var8.y);
                  var8.z = Math.max(var10.x, var8.z);
                  var8.w = Math.max(var10.y, var8.w);
               }
            }

            mc.entityRenderer.setupOverlayRendering();
            if (var8 != null) {
               double var17 = var8.x;
               double var11 = var8.y;
               double var13 = var8.z;
               double var15 = var8.w;
               RenderUtilF.c35355(var17, var11, var13, var15, 3.0D, Color.BLACK);
               RenderUtilF.c35355(var17, var11, var13, var15, 1.0D, new Color(HUD.c64734.c41161().intValue()));
            }
         }
      }

   }

   private Vector3d c98041(ScaledResolution var1, double var2, double var4, double var6) {
      GL11.glGetFloat(2982, this.c61267);
      GL11.glGetFloat(2983, this.c97440);
      GL11.glGetInteger(2978, this.c20463);
      return GLU.gluProject((float)var2, (float)var4, (float)var6, this.c61267, this.c97440, this.c20463, this.c43835) ? new Vector3d((double)(this.c43835.get(0) / (float)var1.getScaleFactor()), (double)(((float)Display.getHeight() - this.c43835.get(1)) / (float)var1.getScaleFactor()), (double)this.c43835.get(2)) : null;
   }

   public void c30361() {
      this.c56662();
      GL11.glPushAttrib(1048575);
      GL11.glDisable(3008);
      GL11.glDisable(3553);
      GL11.glDisable(2896);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(3.0F);
      GL11.glEnable(2848);
      GL11.glEnable(2960);
      GL11.glClear(1024);
      GL11.glClearStencil(15);
      GL11.glStencilFunc(512, 1, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6913);
   }

   public void c56662() {
      Value.c27574();
      Framebuffer var2 = Minecraft.getMinecraft().getFramebuffer();
      if (var2 != null && var2.depthBuffer > -1) {
         this.c37931(var2);
         var2.depthBuffer = -1;
      }

   }

   public void c37931(Framebuffer var1) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(var1.depthBuffer);
      int var2 = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, var2);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, var2);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, var2);
   }

   public void c75834() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public void c74498() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public void c99942() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public void c46103() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public void c56075(int var1) {
      this.c36162(var1);
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(10754);
      GL11.glPolygonOffset(1.0F, -2000000.0F);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
   }

   public void c36162(int var1) {
      float var3 = (float)(var1 >> 24 & 255) / 255.0F;
      float var4 = (float)(var1 >> 16 & 255) / 255.0F;
      Value.c27574();
      float var5 = (float)(var1 >> 8 & 255) / 255.0F;
      float var6 = (float)(var1 & 255) / 255.0F;
      if (var3 == 0.0F) {
         var3 = 1.0F;
      }

      GL11.glColor4f(var4, var5, var6, var3);
   }

   public void c75997() {
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

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
