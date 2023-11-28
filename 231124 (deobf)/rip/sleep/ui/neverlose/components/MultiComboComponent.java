package rip.sleep.ui.neverlose.components;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.modules.HUD;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.MultiBooleanValue;
import rip.sleep.ui.renderer.ComponentRenderer;
import rip.sleep.module.Module;
import rip.sleep.Sleep;

public class MultiComboComponent extends NeverLoseComponent<MultiBooleanValue> {
   private double c60752 = 3.0D;
   private double c84269 = 5.0D;

   public MultiComboComponent(MultiBooleanValue var1, ComponentRenderer var2) {
      super(var1, var2);
   }

   public void c60551(int var1, int var2) {
      Value.c27574();
      Sleep var10001 = Sleep.INSTANCE;
      int var4 = Sleep.c43802.c16525;
      Sleep var10000 = Sleep.INSTANCE;
      int var5 = Sleep.c43802.c9435;
      int var6 = (int)(this.c49717() + (float)this.c51261());
      IFontRenderer var13 = IFontManager.NL_FONT.c39582.c9044;
      String var21 = ((MultiBooleanValue)this.c93183).getName();
      float var10002 = (float)(var4 + 100) + this.c9605();
      float var10003 = (float)(var5 + var6 + 59);
      Sleep var10004 = Sleep.INSTANCE;
      var13.c18223(var21, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      float var14 = (float)(var4 + 170) + this.c9605();
      float var22 = (float)(var5 + var6 + 54);
      Sleep var10005 = Sleep.INSTANCE;
      RenderUtilE.c5737(var14, var22, 80.0F, 14.0F, 2.0F, Sleep.c43802.c45529() ? (new Color(255, 255, 255)).getRGB() : (new Color(15, 15, 15, 30)).getRGB(), 1.0F, (new Color(13, 24, 35, 0)).getRGB());
      Sleep var15 = Sleep.INSTANCE;
      if (!Sleep.c43802.c45529()) {
         RenderUtilD.c15402((float)(var4 + 170) + this.c9605(), (float)(var5 + var6 + 54), 80.0F, 14.0F, 20, new Color(15, 15, 15, 100));
      }

      StringBuilder var7 = new StringBuilder("");
      Iterator var8 = ((MultiBooleanValue)this.c93183).c97929().iterator();
      if (var8.hasNext()) {
         BooleanValue var9 = (BooleanValue)var8.next();
         if (var9.c1473().booleanValue()) {
            var7.append(var9.getName()).append(", ");
         }
      }

      if (var7.length() > 0) {
         var7.deleteCharAt(var7.lastIndexOf(","));
      }

      IFontRenderer var16 = IFontManager.NL_FONT.c83066.c73459;
      String var23 = IFontManager.NL_FONT.c83066.c73459.c65781(var7.toString().equalsIgnoreCase("") ? "..." : var7.toString() + "", 60);
      var10002 = (float)(var4 + 173) + this.c9605();
      var10003 = (float)(var5 + var6 + 59);
      var10004 = Sleep.INSTANCE;
      var16.c18223(var23, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      double var12 = (double)Minecraft.getDebugFPS() / 8.3D;
      if (((MultiBooleanValue)this.c93183).c97349 && this.c60752 > -3.0D) {
         this.c60752 -= 3.0D / var12;
      }

      if (!((MultiBooleanValue)this.c93183).c97349 && this.c60752 < 3.0D) {
         this.c60752 += 3.0D / var12;
      }

      if (((MultiBooleanValue)this.c93183).c97349 && this.c84269 < 8.0D) {
         this.c84269 += 3.0D / var12;
      }

      if (!((MultiBooleanValue)this.c93183).c97349 && this.c84269 > 5.0D) {
         this.c84269 -= 3.0D / var12;
      }

      double var17 = (double)((float)(var4 + 240) + this.c9605());
      double var24 = (double)(var5 + var6 + 55) + this.c84269;
      Sleep var30 = Sleep.INSTANCE;
      RenderUtilE.c88529(var17, var24, 2, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : (new Color(200, 200, 200)).getRGB(), this.c60752);
      if (((MultiBooleanValue)this.c93183).c97349) {
         GL11.glTranslatef(0.0F, 0.0F, 2.0F);
         float var18 = (float)(var4 + 170) + this.c9605();
         float var25 = (float)(var5 + var6 + 54 + 14);
         float var31 = (float)((MultiBooleanValue)this.c93183).c97929().size() * 12.0F;
         var10005 = Sleep.INSTANCE;
         RenderUtilE.c5737(var18, var25, 80.0F, var31, 2.0F, Sleep.c43802.c45529() ? (new Color(255, 255, 255)).getRGB() : (new Color(15, 15, 15, 30)).getRGB(), 1.0F, (new Color(13, 24, 35, 0)).getRGB());
         Sleep var19 = Sleep.INSTANCE;
         if (!Sleep.c43802.c45529()) {
            RenderUtilD.c15402((float)(var4 + 170) + this.c9605(), (float)(var5 + var6 + 54 + 14), 80.0F, (float)((MultiBooleanValue)this.c93183).c97929().size() * 12.0F, 20, new Color(15, 15, 15, 100));
         }

         Iterator var10 = ((MultiBooleanValue)this.c93183).c97929().iterator();
         if (var10.hasNext()) {
            BooleanValue var11 = (BooleanValue)var10.next();
            IFontRenderer var20 = IFontManager.NL_FONT.c83066.c73459;
            String var26 = var11.getName();
            var10002 = (float)(var4 + 173) + this.c9605();
            var31 = (float)(var5 + var6 + 60 + 12 + ((MultiBooleanValue)this.c93183).c97929().indexOf(var11) * 12);
            int var34;
            if (var11.c1473().booleanValue()) {
               var34 = (new Color(HUD.c64734.c41161().intValue())).getRGB();
            } else {
               Sleep var35 = Sleep.INSTANCE;
               var34 = Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1;
            }

            var20.c18223(var26, var10002, var31, var34);
         }

         GL11.glTranslatef(0.0F, 0.0F, -2.0F);
      }

   }

   public boolean c98436() {
      Value.c27574();
      Iterator var2 = ((MultiBooleanValue)this.c93183).c97929().iterator();
      if (var2.hasNext()) {
         BooleanValue var3 = (BooleanValue)var2.next();
         if (var3.c1473().booleanValue()) {
            return false;
         }
      }

      return true;
   }

   public int c16227() {
      Value.c27574();
      int var2 = 0;
      Iterator var3 = ((MultiBooleanValue)this.c93183).c97929().iterator();
      if (var3.hasNext()) {
         BooleanValue var4 = (BooleanValue)var3.next();
         if (var4.c1473().booleanValue()) {
            ++var2;
         }
      }

      return var2;
   }

   public void c80028(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var3 == 1) {
         Sleep var10000 = Sleep.INSTANCE;
         float var8 = (float)(Sleep.c43802.c16525 + 170) + this.c9605();
         Sleep var10001 = Sleep.INSTANCE;
         if (RenderUtilE.c3863(var8, (float)(Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 54), 80.0F, 14.0F, var1, var2)) {
            ((MultiBooleanValue)this.c93183).c97349 = !((MultiBooleanValue)this.c93183).c97349;
         }
      }

      if (var3 == 0 && ((MultiBooleanValue)this.c93183).c97349) {
         float var9 = (float)var1;
         Sleep var12 = Sleep.INSTANCE;
         if (var9 >= (float)(Sleep.c43802.c16525 + 170) + this.c9605()) {
            var9 = (float)var1;
            var12 = Sleep.INSTANCE;
            if (var9 <= (float)(Sleep.c43802.c16525 + 170) + this.c9605() + 80.0F) {
               int var5 = 0;
               if (var5 < ((MultiBooleanValue)this.c93183).c97929().size()) {
                  Sleep var11 = Sleep.INSTANCE;
                  int var6 = Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 57 + 12 + var5 * 12;
                  if (var2 >= var6 && var2 <= var6 + 11) {
                     if (!((BooleanValue)((MultiBooleanValue)this.c93183).c97929().get(var5)).c1473().booleanValue() && !((BooleanValue)((MultiBooleanValue)this.c93183).c97929().get(0)).c1473().booleanValue() && this.c98436()) {
                        ;
                     }

                     ((BooleanValue)((MultiBooleanValue)this.c93183).c97929().get(var5)).c26405();
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
