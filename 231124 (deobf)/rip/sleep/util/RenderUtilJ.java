package rip.sleep.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.json.JSONException;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RenderUtilJ {
   static final Minecraft c58302 = Minecraft.getMinecraft();

   public static void c91259() {
      GL11.glDisable(2960);
      GlStateManager.disableAlpha();
      GlStateManager.disableBlend();
   }

   public static void c35472(boolean var0) {
      Module[] var1 = Value.c27574();
      GL11.glStencilFunc(var0 ? 514 : 517, 1, 65535);
      GL11.glStencilOp(7680, 7680, 7681);
      GlStateManager.colorMask(true, true, true, true);
      GlStateManager.enableAlpha();
      GlStateManager.enableBlend();
      GL11.glAlphaFunc(516, 0.0F);
   }

   public static void c13691(boolean var0) {
      Value.c27574();
      c48857();
      GL11.glClearStencil(0);
      GL11.glClear(1024);
      GL11.glEnable(2960);
      GL11.glStencilFunc(519, 1, 65535);
      GL11.glStencilOp(7680, 7680, 7681);
      if (!var0) {
         GlStateManager.colorMask(false, false, false, false);
      }

   }

   public static void c48857() {
      Value.c27574();
      Framebuffer var1 = c58302.getFramebuffer();
      if (var1 != null && var1.depthBuffer > -1) {
         c53023(var1);
         var1.depthBuffer = -1;
      }

   }

   public static void c53023(Framebuffer var0) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(var0.depthBuffer);
      int var1 = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, var1);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, var1);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, var1);
   }

   private static JSONException c16906(JSONException var0) {
      return var0;
   }
}
