package rip.sleep.ui.neverlose.components;

import java.awt.Color;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.util.RenderUtilE;
import rip.sleep.util.ShaderUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.IntValue;
import rip.sleep.ui.renderer.ComponentRenderer;
import rip.sleep.module.Module;
import rip.sleep.Sleep;

public class IntSliderComponent extends NeverLoseComponent<IntValue> {
   public IntValue c18411;
   private float c145;
   private float c30479;
   private float c23904;
   private float c40872;
   private boolean c63907;
   private boolean c66360;
   private boolean c90285;
   private float c2156;
   private float c18317;
   private float c46529;

   public IntSliderComponent(IntValue var1, ComponentRenderer var2) {
      super(var1, var2);
      this.c18411 = var1;
      this.c99086(var1.c41161().intValue());
   }

   public void c60551(int var1, int var2) {
      Sleep var10001 = Sleep.INSTANCE;
      this.c2156 = (float) Sleep.c43802.c16525;
      var10001 = Sleep.INSTANCE;
      this.c18317 = (float) Sleep.c43802.c9435;
      this.c46529 = this.c49717() + (float)this.c51261();
      Value.c27574();
      float var4 = this.c2156 + 100.0F + this.c9605() + 138.0F;
      float var5 = this.c18317 + this.c46529 + 57.0F - 3.0F;
      float var6 = 11.0F;
      float var7 = 5.0F;
      IFontRenderer var10000 = IFontManager.NL_FONT.c16126.c55770;
      String var59 = ((IntValue)this.c93183).getName();
      float var10002 = this.c2156 + 100.0F + this.c9605();
      float var10003 = this.c18317 + this.c46529 + 57.0F;
      Sleep var10004 = Sleep.INSTANCE;
      var10000.c18223(var59, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      int var8 = RenderUtilE.c99539(0);
      ShaderUtilA.c88870(var4 - 0.5F, var5 - 0.5F, var6 + 0.5F, new Color(var8));
      short var9 = 255;
      int var10 = this.c18411.c41161().intValue();
      int var11 = var10 >> 24 & 255;
      int var12 = Math.min(var9, var11);
      if (var11 < 255) {
         ShaderUtilA.c88870(var4, var5, var6, new Color(16777215));
      }

      int var13 = (new Color(var10 >> 16 & 255, var10 >> 8 & 255, var10 & 255, var12)).getRGB();
      ShaderUtilA.c88870(var4, var5, var6, new Color(var13));
      if (this.c18411.c47112()) {
         GL11.glTranslated(0.0D, 0.0D, 3.0D);
         float var18 = this.c12045();
         float var19 = this.c73936();
         float var20 = this.c81117();
         float var21 = this.c63870();
         RenderUtilE.c44835(var18, var19, var18 + var20, var19 + var21 + 70.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), (new Color(85, 90, 96)).getRGB());
         float var22 = var20 - 9.0F - 8.0F;
         float var23 = var18 + 3.0F;
         float var24 = var19 + 3.0F;
         float var25 = var23 + var22;
         float var26 = var24 + var22;
         int var27 = (new Color(255, 255, 255, Math.min(var9, 180))).getRGB();
         if ((float)var1 <= var23 || (float)var2 <= var24 || (float)var1 >= var25 || (float)var2 >= var26) {
            this.c63907 = false;
         }

         RenderUtilE.c72819(var23 - 0.5F, var24 - 0.5F, var25 + 0.5F, var26 + 0.5F, RenderUtilE.c99539(0));
         this.c84449(var23, var24, var25, var26);
         float var28 = this.c30479 * (var25 - var23);
         float var29 = (1.0F - this.c23904) * (var26 - var24);
         if (this.c63907) {
            float var17 = var25 - var23;
            float var16 = (float)var1 - var23;
            this.c30479 = var16 / var17;
            var28 = var16;
            float var15 = var26 - var24;
            float var14 = (float)var2 - var24;
            this.c23904 = 1.0F - var14 / var15;
            var29 = var14;
            this.c97324(Color.HSBtoRGB(this.c145, this.c30479, this.c23904), false);
         }

         float var46 = var23 + var28 - 0.5F;
         float var44 = var24 + var29 - 0.5F;
         float var42 = var23 + var28 + 0.5F;
         float var40 = var24 + var29 + 0.5F;
         RenderUtilE.c72819(var46 - 0.5F, var44 - 0.5F, var46, var40 + 0.5F, var8);
         RenderUtilE.c72819(var42, var44 - 0.5F, var42 + 0.5F, var40 + 0.5F, var8);
         RenderUtilE.c72819(var46, var44 - 0.5F, var42, var44, var8);
         RenderUtilE.c72819(var46, var40, var42, var40 + 0.5F, var8);
         RenderUtilE.c72819(var46, var44, var42, var40, var27);
         var28 = var25 + 3.0F;
         var46 = var28 + 8.0F;
         if ((float)var1 <= var28 || (float)var2 <= var24 || (float)var1 >= var46 || (float)var2 >= var26) {
            this.c66360 = false;
         }

         var42 = var26 - var24;
         var40 = (1.0F - this.c145) * var42;
         if (this.c66360) {
            float var30 = (float)var2 - var24;
            this.c145 = 1.0F - var30 / var42;
            var40 = var30;
            this.c97324(Color.HSBtoRGB(this.c145, this.c30479, this.c23904), false);
         }

         RenderUtilE.c72819(var28 - 0.5F, var24 - 0.5F, var46 + 0.5F, var26 + 0.5F, var8);
         float var50 = var26 - var24;
         float var31 = var50 / 5.0F;
         int var33 = 0;
         if ((float)var33 < 5.0F) {
            boolean var34 = (float)var33 == 4.0F;
            RenderUtilE.c43222(var28, var24, var46, var24 + var31, RenderUtilE.c99539(Color.HSBtoRGB(1.0F - 0.2F * (float)var33, 1.0F, 1.0F)), RenderUtilE.c99539(Color.HSBtoRGB(1.0F - 0.2F * (float)(var33 + 1), 1.0F, 1.0F)));
            float var32 = var24 + var31;
            ++var33;
         }

         float var56 = var24 + var40 - 0.5F;
         float var35 = var24 + var40 + 0.5F;
         RenderUtilE.c72819(var28 - 0.5F, var56 - 0.5F, var28, var35 + 0.5F, var8);
         RenderUtilE.c72819(var46, var56 - 0.5F, var46 + 0.5F, var35 + 0.5F, var8);
         RenderUtilE.c72819(var28, var56 - 0.5F, var46, var56, var8);
         RenderUtilE.c72819(var28, var35, var46, var35 + 0.5F, var8);
         RenderUtilE.c72819(var28, var56, var46, var35, var27);
         var29 = var26 + 3.0F;
         var44 = var29 + 8.0F;
         if ((float)var1 <= var23 || (float)var2 <= var29 || (float)var1 >= var25 || (float)var2 >= var44) {
            this.c90285 = false;
         }

         int var36 = Color.HSBtoRGB(this.c145, this.c30479, this.c23904);
         int var37 = var36 >> 16 & 255;
         int var38 = var36 >> 8 & 255;
         int var39 = var36 & 255;
         var50 = var25 - var23;
         var31 = this.c40872 * var50;
         if (this.c90285) {
            float var53 = (float)var1 - var23;
            this.c40872 = var53 / var50;
            var31 = var53;
            this.c97324((new Color(var37, var38, var39, (int)(this.c40872 * 255.0F))).getRGB(), true);
         }

         RenderUtilE.c72819(var23 - 0.5F, var29 - 0.5F, var25 + 0.5F, var44 + 0.5F, var8);
         RenderUtilE.c77921(var23, var29, var25, var44);
         RenderUtilE.c83436((double)var23, (double)var29, (double)var25, (double)var44, true, (new Color(var37, var38, var39, 0)).getRGB(), (new Color(var37, var38, var39, Math.min(var9, 255))).getRGB());
         float var54 = var23 + var31 - 0.5F;
         var35 = var23 + var31 + 0.5F;
         RenderUtilE.c72819(var54 - 0.5F, var29, var35 + 0.5F, var44, var8);
         RenderUtilE.c72819(var54, var29, var35, var44, var27);
         GL11.glTranslated(0.0D, 0.0D, -3.0D);
      }

   }

   public boolean c91570(int var1, int var2) {
      Module[] var3 = Value.c27574();
      return (float)var1 >= this.c2156 + 100.0F + this.c9605() + 138.0F && (float)var1 <= this.c2156 + 100.0F + this.c9605() + 138.0F + 13.0F && (float)var2 >= this.c18317 + this.c46529 + 57.0F - 3.0F && (double)var2 <= (double)(this.c18317 + this.c46529 + 57.0F - 3.0F) - 0.5D + 8.0D;
   }

   public void c80028(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var3 == 1 && this.c91570(var1, var2)) {
         this.c18411.c57429(!this.c18411.c47112());
      }

      if (this.c18411.c47112() && var3 == 0) {
         float var5 = this.c12045();
         float var6 = this.c73936();
         float var7 = this.c81117();
         float var8 = this.c63870();
         float var9 = var7 - 9.0F - 8.0F;
         float var10 = var5 + 3.0F;
         float var11 = var6 + 3.0F;
         float var12 = var10 + var9;
         float var13 = var11 + var9;
         float var14 = var13 + 3.0F;
         float var15 = var14 + 8.0F;
         float var16 = var12 + 3.0F;
         float var17 = var16 + 8.0F;
         this.c63907 = !this.c63907 && (float)var1 > var10 && (float)var2 > var11 && (float)var1 < var12 && (float)var2 < var13;
         this.c90285 = !this.c90285 && (float)var1 > var10 && (float)var2 > var14 && (float)var1 < var12 && (float)var2 < var15;
         this.c66360 = !this.c66360 && (float)var1 > var16 && (float)var2 > var11 && (float)var1 < var17 && (float)var2 < var13;
      }

   }

   public void c66160(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (this.c66360) {
         this.c66360 = false;
      }

      if (this.c63907) {
         this.c63907 = false;
      }

      if (this.c90285) {
         this.c90285 = false;
      }

   }

   public void c97324(int var1, boolean var2) {
      Module[] var3 = Value.c27574();
      this.c18411.c28440(Integer.valueOf(var1));
      this.c18411.c28440(Integer.valueOf((new Color(var1 >> 16 & 255, var1 >> 8 & 255, var1 & 255, (int)(this.c40872 * 255.0F))).getRGB()));
   }

   private void c84449(float var1, float var2, float var3, float var4) {
      int var5 = RenderUtilE.c99539(Color.HSBtoRGB(this.c145, 1.0F, 1.0F));
      RenderUtilE.c83436((double)var1, (double)var2, (double)var3, (double)var4, true, RenderUtilE.c99539(16777215), var5);
      RenderUtilE.c43222(var1, var2, var3, var4, 0, RenderUtilE.c99539(0));
   }

   public void c99086(int var1) {
      float[] var2 = this.c54761(var1);
      this.c145 = var2[0];
      this.c30479 = var2[1];
      this.c23904 = var2[2];
      this.c40872 = (float)(var1 >> 24 & 255) / 255.0F;
   }

   private float[] c54761(int var1) {
      int var2 = var1 >> 16 & 255;
      int var3 = var1 >> 8 & 255;
      int var4 = var1 & 255;
      return Color.RGBtoHSB(var2, var3, var4, (float[])null);
   }

   public float c12045() {
      return this.c2156 + 100.0F + this.c9605() + 138.0F + 11.0F - 80.333336F;
   }

   public float c73936() {
      return this.c18317 + this.c46529 + 57.0F - 3.0F + 5.0F;
   }

   public float c81117() {
      float var1 = this.c2156 + 100.0F + this.c9605() + 125.0F + 11.0F;
      return var1 - this.c12045();
   }

   public float c63870() {
      return 11.0F;
   }

   private static JSONException c99200(JSONException var0) {
      return var0;
   }
}
