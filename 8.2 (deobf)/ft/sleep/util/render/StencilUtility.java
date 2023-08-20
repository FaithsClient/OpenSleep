//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;

public class StencilUtility {
   public static Minecraft windsor$ = Minecraft.getMinecraft();
   public static StencilUtility thereof$ = new StencilUtility();
   public HashMap regards$ = new HashMap();
   public int assault$ = 1;
   public boolean myspace$;

   public static StencilUtility _based() {
      return thereof$;
   }

   public void _details(boolean bucks) {
      messages.myspace$ = (boolean)bucks;
   }

   public static void _jamaica(Framebuffer igegunel) {
      if (igegunel != null && ((Framebuffer)igegunel).depthBuffer > -1) {
         _group((Framebuffer)igegunel);
         ((Framebuffer)igegunel).depthBuffer = -1;
      }

   }

   public static void _group(Framebuffer isonerup) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(((Framebuffer)isonerup).depthBuffer);
      Object abesogil = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, abesogil);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, windsor$.displayWidth, windsor$.displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, abesogil);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, abesogil);
   }

   public static void _israeli() {
      windsor$.getFramebuffer().bindFramebuffer(false);
      _jamaica(windsor$.getFramebuffer());
      GL11.glClear(1024);
      GL11.glEnable(2960);
      GL11.glStencilFunc(519, 1, 1);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glColorMask(false, false, false, false);
   }

   public static void _hottest(int suzeviga) {
      GL11.glColorMask(true, true, true, true);
      GL11.glStencilFunc(514, (int)suzeviga, 1);
      GL11.glStencilOp(7680, 7680, 7680);
   }

   public static void _injuries() {
      GL11.glDisable(2960);
   }

   public static void _naughty() {
      Object split = Minecraft.getMinecraft().getFramebuffer();
      if (split != null && split.depthBuffer > -1) {
         EXTFramebufferObject.glDeleteRenderbuffersEXT(split.depthBuffer);
         Object pleasure = EXTFramebufferObject.glGenRenderbuffersEXT();
         EXTFramebufferObject.glBindRenderbufferEXT(36161, pleasure);
         EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
         EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, pleasure);
         EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, pleasure);
         split.depthBuffer = -1;
      }

   }

   public void _belkin() {
      if (tizevera.assault$ == 1) {
         GL11.glClearStencil(0);
         GL11.glClear(1024);
      }

      GL11.glEnable(2960);
      ++tizevera.assault$;
      if (tizevera.assault$ > tizevera._nearest()) {
         System.out.println("ft.sleep.util.render.StencilUtil: Reached maximum amount of layers!");
         tizevera.assault$ = 1;
      }

   }

   public void _albums() {
      _naughty();
      missile._belkin();
   }

   public void _flights() {
      if (marine.assault$ == 1) {
         System.out.println("ft.sleep.util.render.StencilUtil: No layers found!");
      } else {
         --marine.assault$;
         if (marine.assault$ == 1) {
            GL11.glDisable(2960);
         } else {
            Object requests = (StencilUtility2)marine.regards$.remove(Integer.valueOf(marine.assault$));
            if (requests != null) {
               requests._claim();
            }
         }

      }
   }

   public void _audio() {
      GL11.glClearStencil(0);
      GL11.glClear(1024);
      ipinupom.regards$.clear();
      ipinupom.assault$ = 1;
   }

   public void _lanka() {
      acids._colored(new StencilUtility2(acids, acids.myspace$ ? 519 : 512, acids.assault$, acids._nearest(), 7681, 7680, 7680));
   }

   public void _seats(boolean stamp) {
      price._colored(new StencilUtility2(price, price.myspace$ ? 519 : 512, stamp ? price.assault$ : price.assault$ - 1, price._nearest(), 7681, 7681, 7681));
   }

   public void _metal() {
      justin._colored(new StencilUtility2(justin, 517, justin.assault$, justin._nearest(), 7680, 7680, 7680));
   }

   public void _ridge() {
      fobimefi._colored(new StencilUtility2(fobimefi, 514, fobimefi.assault$, fobimefi._nearest(), 7680, 7680, 7680));
   }

   public void _colored(StencilUtility2 coral) {
      GL11.glStencilFunc(StencilUtility2.meyer$, StencilUtility2.sorts$, StencilUtility2.hampton$);
      GL11.glStencilOp(StencilUtility2.sending$, StencilUtility2.dayton$, StencilUtility2.theta$);
      hollow.regards$.put(Integer.valueOf(hollow.assault$), coral);
   }

   public StencilUtility2 _korean() {
      return (StencilUtility2)vedufife.regards$.get(Integer.valueOf(vedufife.assault$));
   }

   public int _another() {
      return olerifod.assault$;
   }

   public int _lunch() {
      return GL11.glGetInteger(3415);
   }

   public int _nearest() {
      return (int)(Math.pow(2.0D, (double)anipuzoz._lunch()) - 1.0D);
   }

   public void _together(double asimafas, double imogavud, double asepopif) {
      GL11.glBegin(6);

      for(int var7 = 0; var7 <= 360; ++var7) {
         double var8 = Math.sin((double)var7 * 3.141592653589793D / 180.0D) * asepopif;
         double var10 = Math.cos((double)var7 * 3.141592653589793D / 180.0D) * asepopif;
         GL11.glVertex2d(asimafas + var8, imogavud + var10);
      }

      GL11.glEnd();
   }

   public void _happy(double fitipuve, double tuzapaga, double var5, double var7) {
      GL11.glBegin(7);
      GL11.glVertex2d((double)fitipuve, var7);
      GL11.glVertex2d(var5, var7);
      GL11.glVertex2d(var5, (double)tuzapaga);
      GL11.glVertex2d((double)fitipuve, (double)tuzapaga);
      GL11.glEnd();
   }
}
