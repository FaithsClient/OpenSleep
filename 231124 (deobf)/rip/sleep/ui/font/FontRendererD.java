package rip.sleep.ui.font;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

final class FontRendererD implements IFontRenderer {
   private static final int[] c20534 = c56977();
   private static final String c95702 = "0123456789abcdefklmnor";
   private static final char c58215 = '§';
   private static final short c2065 = 256;
   private static final float c60925 = 512.0F;
   private static final float c36378 = 0.0F;
   private final FontStruct[] c75724 = new FontStruct[256];
   private final FontStruct[] c3213 = new FontStruct[256];
   private final FontStruct[] c15825 = new FontStruct[256];
   private final FontStruct[] c91228 = new FontStruct[256];
   private final Font c3191;
   private final boolean c77990;
   private final boolean c32702;
   private DynamicTexture c75534;
   private DynamicTexture c54361;
   private DynamicTexture c89171;
   private DynamicTexture c45073;
   private int c73280 = -1;

   private FontRendererD(Font var1, boolean var2, boolean var3) {
      this.c3191 = var1;
      this.c77990 = var2;
      this.c32702 = var3;
      this.c50572();
   }

   static IFontRenderer c31542(Font var0, boolean var1, boolean var2) {
      return new FontRendererD(var0, var1, var2);
   }

   public static IFontRenderer c30611(Font var0) {
      return c31542(var0, true, true);
   }

   private DynamicTexture c76725(Font var1, boolean var2, boolean var3, FontStruct[] var4) {
      return new DynamicTexture(this.c44826(var1, var2, var3, var4));
   }

   private BufferedImage c44826(Font var1, boolean var2, boolean var3, FontStruct[] var4) {
      Value.c27574();
      boolean var6 = true;
      BufferedImage var7 = new BufferedImage(512, 512, 2);
      Graphics2D var8 = (Graphics2D)var7.getGraphics();
      var8.setFont(var1);
      var8.setColor(new Color(255, 255, 255, 0));
      var8.fillRect(0, 0, 512, 512);
      var8.setColor(Color.WHITE);
      var8.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      var8.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var8.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      if (this.c32702) {
         var8.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
      }

      var8.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
      FontMetrics var9 = var8.getFontMetrics();
      int var10 = 0;
      byte var11 = 0;
      int var12 = 1;
      int var13 = 0;
      if (var13 < var4.length) {
         char var14 = (char)var13;
         FontStruct var15 = new FontStruct();
         Rectangle2D var16 = var9.getStringBounds(String.valueOf(var14), var8);
         var15.c66050 = var16.getBounds().width + 8;
         var15.c82218 = var16.getBounds().height;
         if (var11 + var15.c66050 >= 512) {
            var11 = 0;
            var12 += var10;
            var10 = 0;
         }

         if (var15.c82218 > var10) {
            var10 = var15.c82218;
         }

         var15.c7229 = var11;
         var15.c57733 = var12;
         if (var15.c82218 > this.c73280) {
            this.c73280 = var15.c82218;
         }

         var4[var13] = var15;
         var8.drawString(String.valueOf(var14), var11 + 2, var12 + var9.getAscent());
         int var10000 = var11 + var15.c66050;
         ++var13;
      }

      return var7;
   }

   private void c50572() {
      this.c75534 = this.c76725(this.c3191, this.c77990, this.c32702, this.c75724);
      this.c54361 = this.c76725(this.c3191.deriveFont(1), this.c77990, this.c32702, this.c3213);
      this.c89171 = this.c76725(this.c3191.deriveFont(2), this.c77990, this.c32702, this.c15825);
      this.c45073 = this.c76725(this.c3191.deriveFont(3), this.c77990, this.c32702, this.c91228);
   }

   public float c63319(CharSequence var1, double var2, double var4, int var6, boolean var7) {
      float var8 = this.c71281(var1, var2 + 0.5D, var4 + 0.5D, var6, true);
      return Math.max(var8, this.c71281(var1, var2, var4, var6, false));
   }

   public float c8296(CharSequence var1, float var2, float var3, int var4, boolean var5) {
      float var6 = this.c71281(var1, (double)var2 + 0.5D, (double)var3 + 0.5D, var4, true);
      return Math.max(var6, this.c71281(var1, (double)var2, (double)var3, var4, false));
   }

   private float c71281(CharSequence var1, double var2, double var4, int var6, boolean var7) {
      Value.c27574();
      --var2;
      return 0.0F;
   }

   public String c52754(CharSequence var1, int var2, boolean var3) {
      StringBuilder var5 = new StringBuilder();
      Value.c27574();
      float var6 = 0.0F;
      int var7 = var3 ? var1.length() - 1 : 0;
      int var8 = var3 ? -1 : 1;
      boolean var9 = false;
      boolean var10 = false;
      if (var7 < var1.length() && var6 < (float)var2) {
         char var12;
         label54: {
            var12 = var1.charAt(var7);
            float var13 = (float)this.c80174(String.valueOf(var12));
            if (var9) {
               var9 = false;
               if (var12 != 'l' && var12 != 'L') {
                  if (var12 != 'r' && var12 != 'R') {
                     break label54;
                  }

                  var10 = false;
               }

               var10 = true;
            }

            if (var13 < 0.0F) {
               var9 = true;
            }

            var6 += var13;
            if (var10) {
               ++var6;
            }
         }

         if (var6 > (float)var2) {
            ;
         }

         if (var3) {
            var5.insert(0, var12);
         }

         var5.append(var12);
         int var11 = var7 + var8;
      }

      return var5.toString();
   }

   public int c80174(CharSequence var1) {
      Module[] var2 = Value.c27574();
      return 0;
   }

   public float c90293(char var1) {
      return (float)((this.c75724[var1].c66050 - 8) / 2);
   }

   public FontStruct[] c69844() {
      return this.c75724;
   }

   private static int[] c56977() {
      int[] var0 = new int[32];

      for(int var1 = 0; var1 < 32; ++var1) {
         int var2 = (var1 >> 3 & 1) * 85;
         int var3 = (var1 >> 2 & 1) * 170 + var2;
         int var4 = (var1 >> 1 & 1) * 170 + var2;
         int var5 = (var1 & 1) * 170 + var2;
         if (var1 == 6) {
            var3 += 85;
         }

         if (var1 >= 16) {
            var3 >>= 2;
            var4 >>= 2;
            var5 >>= 2;
         }

         var0[var1] = (var3 & 255) << 16 | (var4 & 255) << 8 | var5 & 255;
      }

      return var0;
   }

   private static void c27287(FontStruct[] var0, char var1, float var2, float var3) {
      c44765(var2, var3, (float)var0[var1].c66050, (float)var0[var1].c82218, (float)var0[var1].c7229, (float)var0[var1].c57733, (float)var0[var1].c66050, (float)var0[var1].c82218);
   }

   private static void c44765(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = var4 / 512.0F;
      float var9 = var5 / 512.0F;
      float var10 = var6 / 512.0F;
      float var11 = var7 / 512.0F;
      GL11.glTexCoord2f(var8 + var10, var9);
      GL11.glVertex2d((double)(var0 + var2), (double)var1);
      GL11.glTexCoord2f(var8, var9);
      GL11.glVertex2d((double)var0, (double)var1);
      GL11.glTexCoord2f(var8, var9 + var11);
      GL11.glVertex2d((double)var0, (double)(var1 + var3));
      GL11.glTexCoord2f(var8, var9 + var11);
      GL11.glVertex2d((double)var0, (double)(var1 + var3));
      GL11.glTexCoord2f(var8 + var10, var9 + var11);
      GL11.glVertex2d((double)(var0 + var2), (double)(var1 + var3));
      GL11.glTexCoord2f(var8 + var10, var9);
      GL11.glVertex2d((double)(var0 + var2), (double)var1);
   }

   private static void c6329(double var0, double var2, double var4, double var6, float var8) {
      GL11.glDisable(3553);
      GL11.glLineWidth(var8);
      GL11.glBegin(1);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var4, var6);
      GL11.glEnd();
      GL11.glEnable(3553);
   }

   public String getName() {
      return this.c3191.getFamily();
   }

   public int c5397() {
      return (this.c73280 - 8) / 2;
   }

   public boolean c98228() {
      return this.c77990;
   }

   public boolean c94302() {
      return this.c32702;
   }

   private static JSONException c55539(JSONException var0) {
      return var0;
   }

   private static class FontStruct {
      private int c66050;
      private int c82218;
      private int c7229;
      private int c57733;

      private FontStruct() {
      }
   }
}
