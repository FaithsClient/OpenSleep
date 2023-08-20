//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;

public class Stencil {
   public static Minecraft carpet$ = Minecraft.getMinecraft();

   public static void _registry() {
      GL11.glDisable(2960);
      GlStateManager.disableAlpha();
      GlStateManager.disableBlend();
   }

   public static void _harold(boolean omodofap) {
      GL11.glStencilFunc(omodofap ? 514 : 517, 1, 65535);
      GL11.glStencilOp(7680, 7680, 7681);
      GlStateManager.colorMask(true, true, true, true);
      GlStateManager.enableAlpha();
      GlStateManager.enableBlend();
      GL11.glAlphaFunc(516, Float.intBitsToFloat(0));
   }

   public static void _velvet(boolean isabafun) {
      _greeting();
      GL11.glClearStencil(0);
      GL11.glClear(1024);
      GL11.glEnable(2960);
      GL11.glStencilFunc(519, 1, 65535);
      GL11.glStencilOp(7680, 7680, 7681);
      if (!isabafun) {
         GlStateManager.colorMask(false, false, false, false);
      }

   }

   public static void _greeting() {
      Object rinucodu = carpet$.getFramebuffer();
      if (rinucodu != null && rinucodu.depthBuffer > -1) {
         _beijing(rinucodu);
         rinucodu.depthBuffer = -1;
      }

   }

   public static void _beijing(Framebuffer agalezub) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(((Framebuffer)agalezub).depthBuffer);
      Object ginopomu = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, ginopomu);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, ginopomu);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, ginopomu);
   }
}
