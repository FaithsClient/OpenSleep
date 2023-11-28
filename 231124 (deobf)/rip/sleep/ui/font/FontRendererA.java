package rip.sleep.ui.font;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class FontRendererA {
   float c49263 = 512.0F;
   FontRendererA.c52846[] c80928 = new FontRendererA.c52846[256];
   Font c75091;
   boolean c80235;
   boolean c81657;
   int c7765 = -1;
   int c37475 = 0;
   DynamicTexture c62647;

   public FontRendererA(Font var1, boolean var2, boolean var3) {
      this.c75091 = var1;
      this.c80235 = var2;
      this.c81657 = var3;
      this.c62647 = this.c35557(var1, var2, var3, this.c80928);
   }

   protected DynamicTexture c35557(Font var1, boolean var2, boolean var3, FontRendererA.c52846[] var4) {
      BufferedImage var5 = this.c72903(var1, var2, var3, var4);
      DynamicTexture var10000 = new DynamicTexture;
      DynamicTexture var10001 = var10000;
      BufferedImage var10002 = var5;

      try {
         var10001.<init>(var10002);
         return var10000;
      } catch (Exception var7) {
         var7.printStackTrace();
         return null;
      }
   }

   public int c25901(String var1) {
      return this.c5657();
   }

   public int c5657() {
      return (this.c7765 - 8) / 2;
   }

   protected BufferedImage c72903(Font var1, boolean var2, boolean var3, FontRendererA.c52846[] var4) {
      int var5 = (int)this.c49263;
      BufferedImage var6 = new BufferedImage(var5, var5, 2);
      Graphics2D var7 = (Graphics2D)var6.getGraphics();
      var7.setFont(var1);
      var7.setColor(new Color(255, 255, 255, 0));
      var7.fillRect(0, 0, var5, var5);
      var7.setColor(Color.WHITE);
      var7.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
      var7.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      var7.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      FontMetrics var8 = var7.getFontMetrics();
      int var9 = 0;
      int var10 = 0;
      int var11 = 1;

      for(int var12 = 0; var12 < var4.length; ++var12) {
         char var13 = (char)var12;
         FontRendererA.c52846 var14 = new FontRendererA.c52846();
         Rectangle2D var15 = var8.getStringBounds(String.valueOf(var13), var7);
         var14.c84059 = var15.getBounds().width + 8;
         var14.c98802 = var15.getBounds().height;
         if (var10 + var14.c84059 >= var5) {
            var10 = 0;
            var11 += var9;
            var9 = 0;
         }

         if (var14.c98802 > var9) {
            var9 = var14.c98802;
         }

         var14.c81855 = var10;
         var14.c47285 = var11;
         if (var14.c98802 > this.c7765) {
            this.c7765 = var14.c98802;
         }

         var4[var12] = var14;
         var7.drawString(String.valueOf(var13), var10 + 2, var11 + var8.getAscent());
         var10 += var14.c84059;
      }

      return var6;
   }

   public void c97475(FontRendererA.c52846[] var1, char var2, float var3, float var4) throws ArrayIndexOutOfBoundsException {
      FontRendererA var10000 = this;
      float var10001 = var3;
      float var10002 = var4;
      FontRendererA.c52846[] var10003 = var1;
      char var10004 = var2;

      try {
         var10000.c25749(var10001, var10002, (float)var10003[var10004].c84059, (float)var1[var2].c98802, (float)var1[var2].c81855, (float)var1[var2].c47285, (float)var1[var2].c84059, (float)var1[var2].c98802);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   protected void c25749(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = var5 / this.c49263;
      float var10 = var6 / this.c49263;
      float var11 = var7 / this.c49263;
      float var12 = var8 / this.c49263;
      GL11.glTexCoord2f(var9 + var11, var10);
      GL11.glVertex2d((double)(var1 + var3), (double)var2);
      GL11.glTexCoord2f(var9, var10);
      GL11.glVertex2d((double)var1, (double)var2);
      GL11.glTexCoord2f(var9, var10 + var12);
      GL11.glVertex2d((double)var1, (double)(var2 + var4));
      GL11.glTexCoord2f(var9, var10 + var12);
      GL11.glVertex2d((double)var1, (double)(var2 + var4));
      GL11.glTexCoord2f(var9 + var11, var10 + var12);
      GL11.glVertex2d((double)(var1 + var3), (double)(var2 + var4));
      GL11.glTexCoord2f(var9 + var11, var10);
      GL11.glVertex2d((double)(var1 + var3), (double)var2);
   }

   public void c65253(boolean var1) {
      Module[] var2 = Value.c27574();
      if (this.c80235 != var1) {
         this.c80235 = var1;
         this.c62647 = this.c35557(this.c75091, var1, this.c81657, this.c80928);
      }

   }

   public boolean c13351() {
      return this.c81657;
   }

   public void c3727(boolean var1) {
      Module[] var2 = Value.c27574();
      if (this.c81657 != var1) {
         this.c81657 = var1;
         this.c62647 = this.c35557(this.c75091, this.c80235, var1, this.c80928);
      }

   }

   public void c23129(Font var1) {
      this.c75091 = var1;
      this.c62647 = this.c35557(var1, this.c80235, this.c81657, this.c80928);
   }

   private static ArrayIndexOutOfBoundsException c13237(ArrayIndexOutOfBoundsException var0) {
      return var0;
   }

   protected static class c52846 {
      public int c84059;
      public int c98802;
      public int c81855;
      public int c47285;
   }
}
