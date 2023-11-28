package rip.sleep.ui.font;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.modules.HUD;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class FontRendererB extends FontRendererA {
   private static final int c46966 = 1;
   protected FontRendererA.c52846[] c20766 = new FontRendererA.c52846[256];
   protected FontRendererA.c52846[] c70084 = new FontRendererA.c52846[256];
   protected FontRendererA.c52846[] c87539 = new FontRendererA.c52846[256];
   private final int[] c9979 = new int[32];
   private final String c81792 = "0123456789abcdefklmnor";
   protected DynamicTexture c87916;
   protected DynamicTexture c75485;
   protected DynamicTexture c12049;
   private final Pattern c76403 = Pattern.compile("(?i)§[0-9A-FK-ORX]");

   public FontRendererB(Font var1, boolean var2, boolean var3) {
      super(var1, var2, var3);
      this.c68881();
      this.c84655();
   }

   public void c17470(String var1, double var2, double var4, int var6) {
      GL11.glTranslated(0.5D, 0.5D, 0.0D);
      this.c12918(var1, var2, var4, var6, true);
      GL11.glTranslated(-0.5D, -0.5D, 0.0D);
      this.c12918(var1, var2, var4, var6, false);
   }

   public String c4075(String var1) {
      return this.c76403.matcher(var1).replaceAll("");
   }

   public void c3888(String var1, double var2, double var4, int var6) {
      this.c12918(this.c4075(var1), var2 - 0.5D, var4, 0, false);
      this.c12918(this.c4075(var1), var2 + 0.5D, var4, 0, false);
      this.c12918(this.c4075(var1), var2, var4 - 0.5D, 0, false);
      this.c12918(this.c4075(var1), var2, var4 + 0.5D, 0, false);
      this.c12918(var1, var2, var4, var6, false);
   }

   public void c59386(String var1, float var2, float var3, int var4) {
      this.c12918(var1, (double)var2, (double)var3, var4, false);
   }

   public void c88545(String var1, float var2, float var3, int var4) {
      this.c59386(var1, var2 - (float)(this.c65036(var1) / 2) - 1.0F, var3, var4);
   }

   public void c10173(String var1, float var2, float var3, int var4) {
      this.c17470(var1, (double)(var2 - (float)(this.c65036(var1) / 2) - 1.0F), (double)var3, var4);
   }

   public void c52525(String var1, double var2, double var4, int var6) {
      this.c17470(var1, var2 - (double)(this.c65036(var1) / 2) - 1.0D, var4, var6);
   }

   public void c12918(String var1, double var2, double var4, int var6, boolean var7) {
      Value.c27574();
      --var2;
      if (var1 != "" && var1.length() != 0) {
         if (var6 == 553648127) {
            var6 = 16777215;
         }

         if ((var6 & -67108864) == 0) {
            var6 |= -16777216;
         }

         if (var7) {
            var6 = (var6 & 16579836) >> 2 | var6 & -16777216;
         }

         FontRendererA.c52846[] var9 = this.c80928;
         float var10 = (float)(var6 >> 24 & 255) / 255.0F;
         boolean var11 = false;
         boolean var12 = false;
         boolean var13 = false;
         boolean var14 = false;
         boolean var15 = false;
         boolean var16 = true;
         var2 = var2 * 2.0D;
         var4 = (var4 - 3.0D) * 2.0D;
         GL11.glPushMatrix();
         GlStateManager.scale(0.5D, 0.5D, 1.0D);
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(770, 771);
         GlStateManager.color((float)(var6 >> 16 & 255) / 255.0F, (float)(var6 >> 8 & 255) / 255.0F, (float)(var6 & 255) / 255.0F, var10);
         GlStateManager.enableTexture2D();
         GlStateManager.bindTexture(this.c62647.getGlTextureId());
         GL11.glBindTexture(3553, this.c62647.getGlTextureId());
         int var17 = 0;
         if (var17 < var1.length()) {
            char var18 = var1.charAt(var17);
            char var19 = var17 > 0 ? var1.charAt(var17 - 1) : 46;
            if (var19 == 167) {
               ;
            }

            if (var18 == 167 && var17 < var1.length()) {
               int var20 = "0123456789abcdefklmnor".indexOf(var1.toLowerCase(Locale.ENGLISH).charAt(var17 + 1));
               if (var20 < 16) {
                  var12 = false;
                  var13 = false;
                  var11 = false;
                  var15 = false;
                  var14 = false;
                  GlStateManager.bindTexture(this.c62647.getGlTextureId());
                  var9 = this.c80928;
                  if (var20 < 0 || var20 > 15) {
                     var20 = 15;
                  }

                  if (var7) {
                     var20 += 16;
                  }

                  int var21 = this.c9979[var20];
                  GlStateManager.color((float)(var21 >> 16 & 255) / 255.0F, (float)(var21 >> 8 & 255) / 255.0F, (float)(var21 & 255) / 255.0F, var10);
               }

               if (var20 == 16) {
                  var11 = true;
               }

               if (var20 == 17) {
                  var12 = true;
                  if (var13) {
                     GlStateManager.bindTexture(this.c12049.getGlTextureId());
                     var9 = this.c87539;
                  }

                  GlStateManager.bindTexture(this.c87916.getGlTextureId());
                  var9 = this.c20766;
               }

               if (var20 == 18) {
                  var14 = true;
               }

               if (var20 == 19) {
                  var15 = true;
               }

               if (var20 == 20) {
                  var13 = true;
                  if (var12) {
                     GlStateManager.bindTexture(this.c12049.getGlTextureId());
                     var9 = this.c87539;
                  }

                  GlStateManager.bindTexture(this.c75485.getGlTextureId());
                  var9 = this.c70084;
               }

               var12 = false;
               var13 = false;
               var11 = false;
               var15 = false;
               var14 = false;
               GlStateManager.color((float)(var6 >> 16 & 255) / 255.0F, (float)(var6 >> 8 & 255) / 255.0F, (float)(var6 & 255) / 255.0F, var10);
               GlStateManager.bindTexture(this.c62647.getGlTextureId());
               var9 = this.c80928;
               ++var17;
            }

            if (var18 < var9.length) {
               if (var18 > 255) {
                  ;
               }

               if (var11) {
                  ++var18;
               }

               GL11.glBegin(4);
               this.c97475(var9, var18, (float)var2, (float)var4);
               GL11.glEnd();
               if (var14) {
                  this.c55666(var2 + 0.0D, var4 + (double)(var9[var18].c98802 / 2), var2 + (double)var9[var18].c84059, var4 + (double)(var9[var18].c98802 / 2), 3.0F);
               }

               if (var15) {
                  this.c55666(var2 + 0.0D, var4 + (double)var9[var18].c98802 - 15.0D, var2 + (double)var9[var18].c84059, var4 + (double)var9[var18].c98802 - 15.0D, 1.0F);
               }

               double var10000 = var2 + (double)var9[var18].c84059 - HUD.c73918.c53968().doubleValue() + (double)this.c37475;
            }

            ++var17;
         }

         GL11.glPopMatrix();
         GlStateManager.disableBlend();
         GlStateManager.bindTexture(0);
      }
   }

   public int c65036(String var1) {
      Module[] var2 = Value.c27574();
      return 0;
   }

   public void c23129(Font var1) {
      super.c23129(var1);
      this.c84655();
   }

   public void c65253(boolean var1) {
      super.c65253(var1);
      this.c84655();
   }

   public void c3727(boolean var1) {
      super.c3727(var1);
      this.c84655();
   }

   private void c84655() {
      this.c87916 = this.c35557(this.c75091.deriveFont(1), this.c80235, this.c81657, this.c20766);
      this.c75485 = this.c35557(this.c75091.deriveFont(2), this.c80235, this.c81657, this.c70084);
      this.c12049 = this.c35557(this.c75091.deriveFont(3), this.c80235, this.c81657, this.c87539);
   }

   private void c55666(double var1, double var3, double var5, double var7, float var9) {
      GL11.glDisable(3553);
      GL11.glLineWidth(var9);
      GL11.glBegin(1);
      GL11.glVertex2d(var1, var3);
      GL11.glVertex2d(var5, var7);
      GL11.glEnd();
      GL11.glEnable(3553);
   }

   public List<String> c98102(String var1, double var2) {
      Value.c27574();
      ArrayList var5 = new ArrayList();
      if ((double)this.c65036(var1) > var2) {
         String[] var6 = var1.split(" ");
         StringBuilder var7 = new StringBuilder();
         char var8 = '\uffff';
         int var10 = var6.length;
         int var11 = 0;
         if (var11 < var10) {
            String var12 = var6[var11];
            int var13 = 0;
            if (var13 < var12.toCharArray().length) {
               char var14 = var12.toCharArray()[var13];
               if (var14 == 167 && var13 < var12.toCharArray().length - 1) {
                  var8 = var12.toCharArray()[var13 + 1];
               }

               ++var13;
            }

            if ((double)this.c65036(var7 + var12 + " ") < var2) {
               var7.append(var12).append(" ");
            }

            var5.add(var7.toString());
            var7 = new StringBuilder("§" + var8 + var12 + " ");
            ++var11;
         }

         if (var7.length() > 0) {
            if ((double)this.c65036(var7.toString()) < var2) {
               var5.add("§" + var8 + var7 + " ");
               var7 = new StringBuilder();
            }

            var5.addAll(this.c28909(var7.toString(), var2));
         }
      }

      var5.add(var1);
      return var5;
   }

   public List<String> c28909(String var1, double var2) {
      ArrayList var5 = new ArrayList();
      Value.c27574();
      StringBuilder var6 = new StringBuilder();
      char var7 = '\uffff';
      char[] var8 = var1.toCharArray();
      int var9 = 0;
      if (var9 < var8.length) {
         char var10 = var8[var9];
         if (var10 == 167 && var9 < var8.length - 1) {
            var7 = var8[var9 + 1];
         }

         if ((double)this.c65036(var6.toString() + var10) < var2) {
            var6.append(var10);
         }

         var5.add(var6.toString());
         var6 = new StringBuilder("§" + var7 + var10);
         ++var9;
      }

      if (var6.length() > 0) {
         var5.add(var6.toString());
      }

      return var5;
   }

   private void c68881() {
      for(int var1 = 0; var1 < 32; ++var1) {
         int var2 = (var1 >> 3 & 1) * 85;
         int var3 = (var1 >> 2 & 1) * 170 + var2;
         int var4 = (var1 >> 1 & 1) * 170 + var2;
         int var5 = (var1 & 1) * 170 + var2;
         if (var1 == 6) {
            var3 += 85;
         }

         if (var1 >= 16) {
            var3 /= 4;
            var4 /= 4;
            var5 /= 4;
         }

         this.c9979[var1] = (var3 & 255) << 16 | (var4 & 255) << 8 | var5 & 255;
      }

   }

   public String c55229(String var1, int var2) {
      return this.c63896(var1, var2, false);
   }

   public String c52935(String var1, int var2, boolean var3) {
      var1 = var1.replaceAll(".", ".");
      return this.c63896(var1, var2, var3);
   }

   private float c37361(char var1) {
      Module[] var2 = Value.c27574();
      if (var1 == 167) {
         return -1.0F;
      } else if (var1 == ' ') {
         return 2.0F;
      } else {
         int var3 = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000".indexOf(var1);
         if (var1 > 0 && var3 != -1) {
            return (float)this.c80928[var3].c84059 / 2.0F - 4.0F;
         } else if ((float)this.c80928[var1].c84059 / 2.0F - 4.0F != 0.0F) {
            int var4 = (int)((float)this.c80928[var1].c84059 / 2.0F - 4.0F) >>> 4;
            int var5 = (int)((float)this.c80928[var1].c84059 / 2.0F - 4.0F) & 15;
            var4 = var4 & 15;
            ++var5;
            return (float)((var5 - var4) / 2 + 1);
         } else {
            return 0.0F;
         }
      }
   }

   public String c63896(String var1, int var2, boolean var3) {
      Value.c27574();
      StringBuilder var5 = new StringBuilder();
      float var6 = 0.0F;
      int var7 = var3 ? var1.length() - 1 : 0;
      int var8 = var3 ? -1 : 1;
      boolean var9 = false;
      boolean var10 = false;
      if (var7 < var1.length() && var6 < (float)var2) {
         char var12;
         label54: {
            var12 = var1.charAt(var7);
            float var13 = this.c37361(var12);
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

   private static JSONException c13382(JSONException var0) {
      return var0;
   }
}
