package rip.sleep.ui.misc;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;
import rip.sleep.unmap.c38359;
import rip.sleep.util.RenderUtilA;
import rip.sleep.value.Value;

public class GuiPanoramaScreen extends GuiScreen {
   private DynamicTexture c22896 = new DynamicTexture(256, 256);
   private static final ResourceLocation[] c95698 = new ResourceLocation[]{new ResourceLocation("sleep/panorama/panorama_0.png"), new ResourceLocation("sleep/panorama/panorama_1.png"), new ResourceLocation("sleep/panorama/panorama_2.png"), new ResourceLocation("sleep/panorama/panorama_3.png"), new ResourceLocation("sleep/panorama/panorama_4.png"), new ResourceLocation("sleep/panorama/panorama_5.png")};

   public void updateScreen() {
      c38359.c12252(c38359.c81937() + 1);
   }

   private void c53051(float var1) {
      Tessellator var3 = Tessellator.getInstance();
      WorldRenderer var4 = var3.getWorldRenderer();
      GlStateManager.matrixMode(5889);
      Value.c27574();
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GlStateManager.matrixMode(5888);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.disableCull();
      GlStateManager.depthMask(false);
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      byte var5 = 8;
      int var6 = 0;
      if (var6 < var5 * var5) {
         GlStateManager.pushMatrix();
         float var7 = ((float)(var6 % var5) / (float)var5 - 0.5F) / 64.0F;
         float var8 = ((float)(var6 / var5) / (float)var5 - 0.5F) / 64.0F;
         float var9 = 0.0F;
         GlStateManager.translate(var7, var8, var9);
         GlStateManager.rotate(MathHelper.sin(((float)c38359.c81937() + var1) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate(-((float)c38359.c81937() + var1) * 0.1F, 0.0F, 1.0F, 0.0F);
         int var10 = 0;
         if (var10 < 6) {
            GlStateManager.pushMatrix();
            switch(var10) {
            case 1:
               GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
            case 2:
               GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            case 3:
               GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
            case 4:
               GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            case 5:
               GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
            default:
               this.mc.getTextureManager().bindTexture(c95698[var10]);
               var4.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
               int var11 = 255 / (var6 + 1);
               var4.pos(-1.0D, -1.0D, 1.0D).tex(0.0D, 0.0D).color(255, 255, 255, var11).endVertex();
               var4.pos(1.0D, -1.0D, 1.0D).tex(1.0D, 0.0D).color(255, 255, 255, var11).endVertex();
               var4.pos(1.0D, 1.0D, 1.0D).tex(1.0D, 1.0D).color(255, 255, 255, var11).endVertex();
               var4.pos(-1.0D, 1.0D, 1.0D).tex(0.0D, 1.0D).color(255, 255, 255, var11).endVertex();
               var3.draw();
               GlStateManager.popMatrix();
               ++var10;
            }
         }

         GlStateManager.popMatrix();
         GlStateManager.colorMask(true, true, true, false);
         ++var6;
      }

      var4.setTranslation(0.0D, 0.0D, 0.0D);
      GlStateManager.colorMask(true, true, true, true);
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.enableCull();
      GlStateManager.enableDepth();
   }

   private void c51984() {
      ResourceLocation var2 = this.mc.getTextureManager().getDynamicTextureLocation("background", this.c22896);
      this.mc.getTextureManager().bindTexture(var2);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      GlStateManager.enableBlend();
      Value.c27574();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.colorMask(true, true, true, false);
      Tessellator var3 = Tessellator.getInstance();
      WorldRenderer var4 = var3.getWorldRenderer();
      var4.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      GlStateManager.disableAlpha();
      byte var5 = 3;
      int var6 = 0;
      if (var6 < var5) {
         float var7 = 1.0F / (float)(var6 + 1);
         int var8 = this.width;
         int var9 = this.height;
         float var10 = (float)(var6 - var5 / 2) / 256.0F;
         var4.pos((double)var8, (double)var9, (double)this.field_73735_i).tex((double)(0.0F + var10), 1.0D).color(1.0F, 1.0F, 1.0F, var7).endVertex();
         var4.pos((double)var8, 0.0D, (double)this.field_73735_i).tex((double)(1.0F + var10), 1.0D).color(1.0F, 1.0F, 1.0F, var7).endVertex();
         var4.pos(0.0D, 0.0D, (double)this.field_73735_i).tex((double)(1.0F + var10), 0.0D).color(1.0F, 1.0F, 1.0F, var7).endVertex();
         var4.pos(0.0D, (double)var9, (double)this.field_73735_i).tex((double)(0.0F + var10), 0.0D).color(1.0F, 1.0F, 1.0F, var7).endVertex();
         ++var6;
      }

      var3.draw();
      GlStateManager.enableAlpha();
      GlStateManager.colorMask(true, true, true, true);
   }

   private void c19386(float var1) {
      this.mc.getFramebuffer().unbindFramebuffer();
      GlStateManager.viewport(0, 0, 256, 256);
      this.c53051(var1);
      this.c51984();
      this.c51984();
      this.c51984();
      this.c51984();
      this.c51984();
      this.c51984();
      this.c51984();
      this.mc.getFramebuffer().bindFramebuffer(true);
      GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
      float var2 = this.width > this.height ? 120.0F / (float)this.width : 120.0F / (float)this.height;
      float var3 = (float)this.height * var2 / 256.0F;
      float var4 = (float)this.width * var2 / 256.0F;
      int var5 = this.width;
      int var6 = this.height;
      Tessellator var7 = Tessellator.getInstance();
      WorldRenderer var8 = var7.getWorldRenderer();
      var8.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      var8.pos(0.0D, (double)var6, (double)this.field_73735_i).tex((double)(0.5F - var3), (double)(0.5F + var4)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var8.pos((double)var5, (double)var6, (double)this.field_73735_i).tex((double)(0.5F - var3), (double)(0.5F - var4)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var8.pos((double)var5, 0.0D, (double)this.field_73735_i).tex((double)(0.5F + var3), (double)(0.5F - var4)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var8.pos(0.0D, 0.0D, (double)this.field_73735_i).tex((double)(0.5F + var3), (double)(0.5F + var4)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var7.draw();
   }

   public void drawScreen(int var1, int var2, float var3) {
      GlStateManager.disableAlpha();
      this.c19386(var3);
      GlStateManager.enableAlpha();
      RenderUtilA.c28773(0.0D, 0.0D, (double)this.width, (double)this.height, 1879048192);
   }

   private static JSONException c86506(JSONException var0) {
      return var0;
   }
}
