//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import ft.sleep.util.render.RenderUtil;
import ft.sleep.util.timer.PanoramaTimer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

public class Panorama extends GuiScreen {
   public DynamicTexture reset$ = new DynamicTexture(256, 256);
   public static ResourceLocation[] views$ = new ResourceLocation[]{new ResourceLocation("sleep/panorama/panorama_0.png"), new ResourceLocation("sleep/panorama/panorama_1.png"), new ResourceLocation("sleep/panorama/panorama_2.png"), new ResourceLocation("sleep/panorama/panorama_3.png"), new ResourceLocation("sleep/panorama/panorama_4.png"), new ResourceLocation("sleep/panorama/panorama_5.png")};

   public void updateScreen() {
      PanoramaTimer._citation(PanoramaTimer._holes() + 1);
   }

   public void __/* $FF was: */(float tablet) {
      Object chicken = Tessellator.getInstance();
      Object forums = chicken.getWorldRenderer();
      GlStateManager.matrixMode(5889);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GlStateManager.matrixMode(5888);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.rotate(180.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GlStateManager.rotate(90.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.disableCull();
      GlStateManager.depthMask(false);
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      Object announce = 8;

      for(Object overall = 0; overall < announce * announce; ++overall) {
         GlStateManager.pushMatrix();
         Object census = ((float)(overall % announce) / (float)announce - 0.5F) / 64.0F;
         Object master = ((float)(overall / announce) / (float)announce - 0.5F) / 64.0F;
         Object drive = Float.intBitsToFloat(0);
         GlStateManager.translate(census, master, drive);
         GlStateManager.rotate(MathHelper.sin(((float)PanoramaTimer._holes() + tablet) / 400.0F) * 25.0F + 20.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
         GlStateManager.rotate(-((float)PanoramaTimer._holes() + tablet) * 0.1F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));

         for(Object channels = 0; channels < 6; ++channels) {
            GlStateManager.pushMatrix();
            switch(channels) {
            case 1:
               GlStateManager.rotate(90.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
               break;
            case 2:
               GlStateManager.rotate(180.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
               break;
            case 3:
               GlStateManager.rotate(-90.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
               break;
            case 4:
               GlStateManager.rotate(90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
               break;
            case 5:
               GlStateManager.rotate(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
            }

            ranges.mc.getTextureManager().bindTexture(views$[channels]);
            forums.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            Object trout = 255 / (overall + 1);
            forums.pos(-1.0D, -1.0D, 1.0D).tex(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)).color(255, 255, 255, trout).endVertex();
            forums.pos(1.0D, -1.0D, 1.0D).tex(1.0D, Double.longBitsToDouble(0L)).color(255, 255, 255, trout).endVertex();
            forums.pos(1.0D, 1.0D, 1.0D).tex(1.0D, 1.0D).color(255, 255, 255, trout).endVertex();
            forums.pos(-1.0D, 1.0D, 1.0D).tex(Double.longBitsToDouble(0L), 1.0D).color(255, 255, 255, trout).endVertex();
            chicken.draw();
            GlStateManager.popMatrix();
         }

         GlStateManager.popMatrix();
         GlStateManager.colorMask(true, true, true, false);
      }

      forums.setTranslation(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
      GlStateManager.colorMask(true, true, true, true);
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.enableCull();
      GlStateManager.enableDepth();
   }

   public void ____/* $FF was: */() {
      Object knitting = inquire.mc.getTextureManager().getDynamicTextureLocation("background", inquire.reset$);
      inquire.mc.getTextureManager().bindTexture(knitting);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.colorMask(true, true, true, false);
      Object powder = Tessellator.getInstance();
      Object jamaica = powder.getWorldRenderer();
      jamaica.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      GlStateManager.disableAlpha();
      Object exist = 3;

      for(Object czech = 0; czech < exist; ++czech) {
         Object lower = 1.0F / (float)(czech + 1);
         Object polar = inquire.width;
         Object suggests = inquire.height;
         Object tribes = (float)(czech - exist / 2) / 256.0F;
         jamaica.pos((double)polar, (double)suggests, (double)inquire.zLevel).tex((double)(Float.intBitsToFloat(0) + tribes), 1.0D).color(1.0F, 1.0F, 1.0F, lower).endVertex();
         jamaica.pos((double)polar, Double.longBitsToDouble(0L), (double)inquire.zLevel).tex((double)(1.0F + tribes), 1.0D).color(1.0F, 1.0F, 1.0F, lower).endVertex();
         jamaica.pos(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)inquire.zLevel).tex((double)(1.0F + tribes), Double.longBitsToDouble(0L)).color(1.0F, 1.0F, 1.0F, lower).endVertex();
         jamaica.pos(Double.longBitsToDouble(0L), (double)suggests, (double)inquire.zLevel).tex((double)(Float.intBitsToFloat(0) + tribes), Double.longBitsToDouble(0L)).color(1.0F, 1.0F, 1.0F, lower).endVertex();
      }

      powder.draw();
      GlStateManager.enableAlpha();
      GlStateManager.colorMask(true, true, true, true);
   }

   public void __/* $FF was: */(float comutiba) {
      unovimun.mc.getFramebuffer().unbindFramebuffer();
      GlStateManager.viewport(0, 0, 256, 256);
      unovimun.((float)comutiba);
      unovimun.();
      unovimun.();
      unovimun.();
      unovimun.();
      unovimun.();
      unovimun.();
      unovimun.();
      unovimun.mc.getFramebuffer().bindFramebuffer(true);
      GlStateManager.viewport(0, 0, unovimun.mc.displayWidth, unovimun.mc.displayHeight);
      Object cilotuda = unovimun.width > unovimun.height ? 120.0F / (float)unovimun.width : 120.0F / (float)unovimun.height;
      Object banocamo = (float)unovimun.height * cilotuda / 256.0F;
      Object ozodibic = (float)unovimun.width * cilotuda / 256.0F;
      Object retovovi = unovimun.width;
      Object gevaneca = unovimun.height;
      Object zabeyibu = Tessellator.getInstance();
      Object fozineba = zabeyibu.getWorldRenderer();
      fozineba.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      fozineba.pos(Double.longBitsToDouble(0L), (double)gevaneca, (double)unovimun.zLevel).tex((double)(0.5F - banocamo), (double)(0.5F + ozodibic)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      fozineba.pos((double)retovovi, (double)gevaneca, (double)unovimun.zLevel).tex((double)(0.5F - banocamo), (double)(0.5F - ozodibic)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      fozineba.pos((double)retovovi, Double.longBitsToDouble(0L), (double)unovimun.zLevel).tex((double)(0.5F + banocamo), (double)(0.5F - ozodibic)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      fozineba.pos(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)unovimun.zLevel).tex((double)(0.5F + banocamo), (double)(0.5F + ozodibic)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      zabeyibu.draw();
   }

   public void drawScreen(int uroropir, int var2, float var3) {
      GlStateManager.disableAlpha();
      emeripoz.(var3);
      GlStateManager.enableAlpha();
      RenderUtil._newman(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)emeripoz.width, (double)emeripoz.height, 1879048192);
   }
}
