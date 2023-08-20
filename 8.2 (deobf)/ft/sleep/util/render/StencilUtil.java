//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

public class StencilUtil {
   public static void _tariff(Framebuffer serbia) {
      GL30.glDeleteRenderbuffers(((Framebuffer)serbia).depthBuffer);
      Object vegas = GL30.glGenRenderbuffers();
      GL30.glBindRenderbuffer(36161, vegas);
      GL30.glRenderbufferStorage(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
      GL30.glFramebufferRenderbuffer(36160, 36128, 36161, vegas);
      GL30.glFramebufferRenderbuffer(36160, 36096, 36161, vegas);
   }

   public static void _dancing(Framebuffer zunutuna) {
      if (zunutuna != null && ((Framebuffer)zunutuna).depthBuffer > -1) {
         _tariff((Framebuffer)zunutuna);
         ((Framebuffer)zunutuna).depthBuffer = -1;
      }

   }

   public static void _murphy() {
      _charts(Minecraft.getMinecraft().getFramebuffer());
   }

   public static void _charts(Framebuffer leyemifi) {
      ((Framebuffer)leyemifi).bindFramebuffer(false);
      _dancing((Framebuffer)leyemifi);
      GL11.glClear(1280);
      GL11.glEnable(2960);
   }

   public static void _country() {
      GL11.glStencilFunc(519, 1, 1);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glColorMask(false, false, false, false);
   }

   public static void _mirrors(int blanket) {
      GL11.glColorMask(true, true, true, true);
      GL11.glStencilFunc(514, (int)blanket, 1);
      GL11.glStencilOp(7680, 7680, 7680);
   }

   public static void _involve() {
      GL11.glDisable(2960);
   }
}
