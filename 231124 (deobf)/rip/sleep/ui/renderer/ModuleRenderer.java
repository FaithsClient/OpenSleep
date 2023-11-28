package rip.sleep.ui.renderer;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.Frame;
import rip.sleep.util.RenderUtilC;
import rip.sleep.util.RenderUtilF;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class ModuleRenderer {
   public Value c40249;
   public String c7798;
   public boolean c31377;
   public boolean c15615;
   public int c20520;
   public int c61951;
   public double c53458;
   public ModuleType c61289;

   public ModuleRenderer(ModuleType var1, Value var2, int var3, int var4) {
      Value.c27574();
      super();
      this.c61289 = var1;
      this.c31377 = false;
      this.c53458 = 0.0D;
      this.c40249 = var2;
      this.c20520 = var3;
      this.c61951 = var4;
      this.c7798 = "";
      if (this.c40249 instanceof BooleanValue) {
         this.c15615 = ((Boolean)this.c40249.c36545()).booleanValue();
      }

      if (this.c40249 instanceof ModeValue) {
         this.c7798 = String.valueOf(this.c40249.c36545());
      }

      if (var2 instanceof NumberValue) {
         NumberValue var6 = (NumberValue)var2;
         this.c7798 = this.c7798 + (var6.c65697() ? (double)var6.c53968().intValue() : var6.c53968().doubleValue());
      }

      this.c53458 = 0.0D;
   }

   public void c74493(int var1, int var2, Frame var3) {
      Module[] var4 = Value.c27574();
      if (!this.c31377) {
         if (var1 > this.c20520 - 7 && var1 < this.c20520 + 85 && var2 > this.c61951 - 6 && var2 < this.c61951 + FontManager.c54334.c25901(this.c40249.c33395()) + 6) {
            if (this.c53458 + 10.0D < 200.0D) {
               this.c53458 += 10.0D;
            }

            this.c53458 = 200.0D;
         }

         if (this.c53458 - 6.0D > 0.0D) {
            this.c53458 -= 6.0D;
         }

         this.c53458 = 0.0D;
         if (this.c40249 instanceof BooleanValue) {
            this.c15615 = ((Boolean)this.c40249.c36545()).booleanValue();
         }

         if (this.c40249 instanceof ModeValue) {
            this.c7798 = String.valueOf(this.c40249.c36545());
         }

         if (this.c40249 instanceof NumberValue) {
            NumberValue var5 = (NumberValue)this.c40249;
            this.c7798 = String.valueOf(var5.c65697() ? (double)var5.c53968().intValue() : var5.c53968().doubleValue());
            if (var1 > this.c20520 - 7 && var1 < this.c20520 + 85 && var2 > this.c61951 + FontManager.c18826.c25901(this.c40249.c33395()) - 6 && var2 < this.c61951 + FontManager.c18826.c25901(this.c40249.c33395()) + 6 && Mouse.isButtonDown(0)) {
               double var6 = var5.c61905().doubleValue();
               double var8 = var5.c36673().doubleValue();
               double var10 = var5.c18780().doubleValue();
               double var12 = (double)var1 - ((double)this.c20520 + 1.0D);
               double var14 = var12 / 68.0D;
               var14 = Math.min(Math.max(0.0D, var14), 1.0D);
               double var16 = (var8 - var6) * var14;
               double var18 = var6 + var16;
               var18 = (double)Math.round(var18 * (1.0D / var10)) / (1.0D / var10);
               var5.c70375(Double.valueOf(var18));
            }
         }

         GL11.glEnable(3089);
         var3.c94845();
         Gui.drawRect(this.c20520 - 9, this.c61951 - 2, this.c20520 + 90, this.c61951 + 13, (new Color(5, 5, 5, 110)).getRGB());
         if (this.c40249 instanceof BooleanValue) {
            RenderUtilC.c32834((double)(this.c20520 + 4), (double)this.c61951 + 2.5D, (double)this.c20520 + 3.5D, (double)this.c61951 + 10.5D, (new Color(180, 180, 180)).getRGB());
            RenderUtilC.c32834((double)(this.c20520 - 6), (double)this.c61951 + 2.5D, (double)this.c20520 - 5.5D, (double)this.c61951 + 10.5D, (new Color(180, 180, 180)).getRGB());
            RenderUtilC.c32834((double)(this.c20520 - 6), (double)this.c61951 + 2.5D, (double)(this.c20520 + 4), (double)(this.c61951 + 2), (new Color(180, 180, 180)).getRGB());
            RenderUtilC.c32834((double)(this.c20520 - 6), (double)(this.c61951 + 11), (double)(this.c20520 + 4), (double)this.c61951 + 10.5D, (new Color(180, 180, 180)).getRGB());
            if (((Boolean)this.c40249.c36545()).booleanValue()) {
               FontManager.c60037.c17470("v", (double)this.c20520 + 3.5D - (double) FontManager.c60037.c65036("v"), (double)this.c61951 + 4.5D, (new Color(255, 255, 255)).getRGB());
            }

            FontManager.c43464.c17470(this.c40249.getName(), (double)((float)this.c20520 + 5.5F), (double)((float)this.c61951 + 4.5F), (new Color(255, 255, 255)).getRGB());
         }

         new ScaledResolution(Minecraft.getMinecraft());
         if (this.c40249 instanceof ModeValue) {
            FontManager.c43464.c17470(this.c40249.getName(), (double)(this.c20520 - 6), (double)(this.c61951 + 3), (new Color(182, 182, 182)).getRGB());
            FontManager.c43464.c17470(this.c7798, (double)(this.c20520 + 87 - FontManager.c43464.c65036(this.c7798)), (double)(this.c61951 + 3), (new Color(255, 255, 255)).getRGB());
         }

         if (this.c40249 instanceof NumberValue) {
            NumberValue var20 = (NumberValue)this.c40249;
            double var7 = (double)(97.0F * (var20.c53968().floatValue() - var20.c61905().floatValue()) / (var20.c36673().floatValue() - var20.c61905().floatValue()));
            RenderUtilF.c6631((double)(this.c20520 - 9), (double)(this.c61951 + 10), (double)(this.c20520 + 90), (double)(this.c61951 + 12), 2.0D, (new Color(5, 5, 5, 70)).getRGB());
            RenderUtilF.c6631((double)(this.c20520 - 9), (double)(this.c61951 + 10), (double)((int)((double)(this.c20520 - 7) + var7)), (double)(this.c61951 + 12), 2.0D, (new Color(255, 255, 255)).getRGB());
         }

         if (this.c40249 instanceof NumberValue) {
            FontManager.c43464.c17470(this.c40249.getName(), (double)(this.c20520 - 6), (double)(this.c61951 + 3), (new Color(180, 180, 180)).getRGB());
            FontManager.c43464.c17470(this.c7798, (double)(this.c20520 + FontManager.c54334.c65036(this.c40249.getName()) - 7), (double)((float)this.c61951 + 3.5F), (new Color(255, 255, 255)).getRGB());
         }

         GL11.glDisable(3089);
      }

   }

   public void c89714(char var1, int var2) {
   }

   private boolean c71295(int var1, int var2) {
      Module[] var3 = Value.c27574();
      boolean var4 = var1 >= this.c20520 && var1 <= this.c20520 - 7 && var2 >= this.c61951 && var2 <= this.c61951 + FontManager.c54334.c25901(this.c40249.c33395());
      return var4;
   }

   public void c35654(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (!this.c31377 && var1 > this.c20520 - 7 && var1 < this.c20520 + 85 && var2 > this.c61951 + 2 && var2 < this.c61951 + 3 + FontManager.c54334.c25901(this.c40249.c33395())) {
         if (this.c40249 instanceof BooleanValue) {
            BooleanValue var7 = (BooleanValue)this.c40249;
            var7.c28440(Boolean.valueOf(!var7.c1473().booleanValue()));
            return;
         }

         if (this.c40249 instanceof ModeValue) {
            ModeValue var5 = (ModeValue)this.c40249;
            String var6 = var5.c54460();
            this.c40249.c28440(var5.c42690()[var5.c28098(var6) + 1 >= var5.c42690().length ? 0 : var5.c28098(var6) + 1]);
         }
      }

   }

   public void c65855(char var1, boolean var2) {
   }

   private static JSONException c46628(JSONException var0) {
      return var0;
   }
}
