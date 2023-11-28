package rip.sleep.ui.neverlose.components;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.modules.HUD;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;
import rip.sleep.ui.renderer.ComponentRenderer;
import rip.sleep.module.Module;
import rip.sleep.Sleep;

public class ComboComponent extends NeverLoseComponent<ModeValue> {
   private double c51541 = 3.0D;
   private double c56333 = 5.0D;

   public ComboComponent(ModeValue var1, ComponentRenderer var2) {
      super(var1, var2);
   }

   public void c60551(int var1, int var2) {
      Sleep var10000 = Sleep.INSTANCE;
      Value.c27574();
      int var4 = Sleep.c43802.c16525;
      Sleep var10001 = Sleep.INSTANCE;
      int var5 = Sleep.c43802.c9435;
      int var6 = (int)(this.c49717() + (float)this.c51261());
      IFontRenderer var14 = IFontManager.NL_FONT.c39582.c9044;
      String var22 = ((ModeValue)this.c93183).getName();
      float var10002 = (float)(var4 + 100) + this.c9605();
      float var10003 = (float)(var5 + var6 + 59);
      Sleep var10004 = Sleep.INSTANCE;
      var14.c18223(var22, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      float var15 = (float)(var4 + 170) + this.c9605();
      float var23 = (float)(var5 + var6 + 54);
      Sleep var10005 = Sleep.INSTANCE;
      RenderUtilE.c5737(var15, var23, 80.0F, 14.0F, 2.0F, Sleep.c43802.c45529() ? (new Color(255, 255, 255)).getRGB() : (new Color(15, 15, 15, 30)).getRGB(), 1.0F, (new Color(15, 15, 15, 0)).getRGB());
      Sleep var16 = Sleep.INSTANCE;
      if (!Sleep.c43802.c45529()) {
         RenderUtilD.c15402((float)(var4 + 170) + this.c9605(), (float)(var5 + var6 + 54), 80.0F, 14.0F, 20, new Color(15, 15, 15, 100));
      }

      IFontRenderer var17 = IFontManager.NL_FONT.c83066.c73459;
      String var24 = ((ModeValue)this.c93183).c54460();
      var10002 = (float)(var4 + 173) + this.c9605();
      var10003 = (float)(var5 + var6 + 59);
      var10004 = Sleep.INSTANCE;
      var17.c18223(var24, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      double var7 = (double)Minecraft.getDebugFPS() / 8.3D;
      if (((ModeValue)this.c93183).c46593 && this.c51541 > -3.0D) {
         this.c51541 -= 3.0D / var7;
      }

      if (!((ModeValue)this.c93183).c46593 && this.c51541 < 3.0D) {
         this.c51541 += 3.0D / var7;
      }

      if (((ModeValue)this.c93183).c46593 && this.c56333 < 8.0D) {
         this.c56333 += 3.0D / var7;
      }

      if (!((ModeValue)this.c93183).c46593 && this.c56333 > 5.0D) {
         this.c56333 -= 3.0D / var7;
      }

      double var18 = (double)((float)(var4 + 240) + this.c9605());
      double var25 = (double)(var5 + var6 + 55) + this.c56333;
      Sleep var30 = Sleep.INSTANCE;
      RenderUtilE.c88529(var18, var25, 2, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : (new Color(200, 200, 200)).getRGB(), this.c51541);
      if (((ModeValue)this.c93183).c46593) {
         GL11.glTranslatef(0.0F, 0.0F, 2.0F);
         float var19 = (float)(var4 + 170) + this.c9605();
         float var26 = (float)(var5 + var6 + 54 + 14);
         float var31 = (float)((ModeValue)this.c93183).c42690().length * 12.0F;
         var10005 = Sleep.INSTANCE;
         RenderUtilE.c5737(var19, var26, 80.0F, var31, 2.0F, Sleep.c43802.c45529() ? (new Color(255, 255, 255)).getRGB() : (new Color(15, 15, 15, 30)).getRGB(), 1.0F, (new Color(13, 24, 35, 0)).getRGB());
         Sleep var20 = Sleep.INSTANCE;
         if (!Sleep.c43802.c45529()) {
            RenderUtilD.c15402((float)(var4 + 170) + this.c9605(), (float)(var5 + var6 + 54 + 14), 80.0F, (float)((ModeValue)this.c93183).c42690().length * 12.0F, 20, new Color(15, 15, 15, 100));
         }

         String[] var9 = ((ModeValue)this.c93183).c42690();
         int var10 = var9.length;
         int var11 = 0;
         if (var11 < var10) {
            String var12 = var9[var11];
            if (var12.equals(((ModeValue)this.c93183).c54460())) {
               ;
            }

            IFontRenderer var21 = IFontManager.NL_FONT.c39582.c9044;
            var10002 = (float)(var4 + 173) + this.c9605();
            var31 = (float)(var5 + var6 + 61 + 12 + ((ModeValue)this.c93183).c28098(var12) * 12);
            int var34;
            if (var12.equals(((ModeValue)this.c93183).c54460())) {
               var34 = (new Color(HUD.c64734.c41161().intValue())).getRGB();
            } else {
               Sleep var35 = Sleep.INSTANCE;
               var34 = Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1;
            }

            var21.c18223(var12, var10002, var31, var34);
            ++var11;
         }

         GL11.glTranslatef(0.0F, 0.0F, -2.0F);
      }

   }

   public void c80028(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var3 == 1) {
         Sleep var10000 = Sleep.INSTANCE;
         float var8 = (float)(Sleep.c43802.c16525 + 170) + this.c9605();
         Sleep var10001 = Sleep.INSTANCE;
         if (RenderUtilE.c3863(var8, (float)(Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 54), 80.0F, 14.0F, var1, var2)) {
            ((ModeValue)this.c93183).c46593 = !((ModeValue)this.c93183).c46593;
         }
      }

      if (var3 == 0 && ((ModeValue)this.c93183).c46593) {
         float var9 = (float)var1;
         Sleep var12 = Sleep.INSTANCE;
         if (var9 >= (float)(Sleep.c43802.c16525 + 170) + this.c9605()) {
            var9 = (float)var1;
            var12 = Sleep.INSTANCE;
            if (var9 <= (float)(Sleep.c43802.c16525 + 170) + this.c9605() + 80.0F) {
               int var5 = 0;
               if (var5 < ((ModeValue)this.c93183).c42690().length) {
                  Sleep var11 = Sleep.INSTANCE;
                  int var6 = Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 59 + 12 + var5 * 12;
                  if (var2 >= var6 && var2 <= var6 + 12) {
                     ((ModeValue)this.c93183).c94243(((ModeValue)this.c93183).c66356(var5));
                  }

                  ++var5;
               }
            }
         }
      }

   }

   public void c66160(int var1, int var2, int var3) {
   }

   private static JSONException c99200(JSONException var0) {
      return var0;
   }
}
