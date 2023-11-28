package rip.sleep.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import org.json.JSONException;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RenderUtilI {
   static Minecraft c23110 = Minecraft.getMinecraft();

   public static void c13212(Framebuffer var0) {
      Module[] var1 = Value.c27574();
      if (var0 != null && var0.depthBuffer > -1) {
         c89022(var0);
         var0.depthBuffer = -1;
      }

   }

   public static void c89022(Framebuffer var0) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(var0.depthBuffer);
      int var1 = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, var1);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, c23110.displayWidth, c23110.displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, var1);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, var1);
   }

   public static void c76654() {
      c23110.getFramebuffer().bindFramebuffer(false);
      c13212(c23110.getFramebuffer());
      GL11.glClear(1024);
      GL11.glEnable(2960);
      GL11.glStencilFunc(519, 1, 1);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glColorMask(false, false, false, false);
   }

   public static void c54943(int var0) {
      GL11.glColorMask(true, true, true, true);
      GL11.glStencilFunc(514, var0, 1);
      GL11.glStencilOp(7680, 7680, 7680);
   }

   public static void c42439() {
      GL11.glDisable(2960);
   }

   private static JSONException c82690(JSONException var0) {
      return var0;
   }
}
