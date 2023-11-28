package rip.sleep.struct;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class DirectionStruct {
   private Minecraft c89313;
   private FontRenderer c58250;
   public int c85686 = 2;
   public int c30361 = 0;
   public int c32264 = 150;
   public int c7676 = 20;
   public int c53515 = 500;
   public int c42374 = 0;
   public int c99064 = 0;
   private int c54157;
   private int c9644;
   private int c89750;

   public DirectionStruct(Minecraft var1) {
      this.c89313 = var1;
      this.c58250 = var1.fontRendererObj;
   }

   public void c4106(int var1) {
      int var3 = this.c9914((int)this.c89313.thePlayer.rotationYaw);
      Value.c27574();
      this.c54157 = this.c53515 * var3 / 360;
      this.c9644 = var1 / 2;
      Gui.drawRect(this.c9644 - this.c32264 / 2, this.c30361, this.c9644 + this.c32264 / 2, this.c30361 + this.c7676, (new Color(0, 0, 0, 70)).getRGB());
      new ScaledResolution(this.c89313);
      if (this.c99064 != 0) {
         this.c89750 = Color.HSBtoRGB((float)this.c99064 / 100.0F, 1.0F, 1.0F);
      }

      this.c89750 = -1;
      if (this.c85686 >= 0) {
         this.c77660("S", 0, 1.5D);
         this.c77660("W", 90, 1.5D);
         this.c77660("N", 180, 1.5D);
         this.c77660("E", 270, 1.5D);
      }

      if (this.c85686 >= 1) {
         this.c77660("SW", 45, 1.0D);
         this.c77660("NW", 135, 1.0D);
         this.c77660("NE", 225, 1.0D);
         this.c77660("SE", 315, 1.0D);
      }

      if (this.c85686 >= 2) {
         this.c77660("15", 15, 0.75D);
         this.c77660("30", 30, 0.75D);
         this.c77660("60", 60, 0.75D);
         this.c77660("75", 75, 0.75D);
         this.c77660("105", 105, 0.75D);
         this.c77660("120", 120, 0.75D);
         this.c77660("150", 150, 0.75D);
         this.c77660("165", 165, 0.75D);
         this.c77660("195", 195, 0.75D);
         this.c77660("210", 210, 0.75D);
         this.c77660("240", 240, 0.75D);
         this.c77660("255", 255, 0.75D);
         this.c77660("285", 285, 0.75D);
         this.c77660("300", 300, 0.75D);
         this.c77660("330", 330, 0.75D);
         this.c77660("345", 345, 0.75D);
      }

   }

   private void c77660(String var1, int var2, double var3) {
      Value.c27574();
      int var6 = this.c53515 * var2 / 360 - this.c54157;
      if (var6 > this.c53515 / 2) {
         var6 -= this.c53515;
      }

      if (var6 < -this.c53515 / 2) {
         var6 += this.c53515;
      }

      double var7 = 1.0D - (double)Math.abs(var6) / ((double)this.c32264 / 2.0D);
      if (var7 > 0.1D) {
         int var9 = this.c89750 & 16777215;
         int var10 = var9 | (int)(var7 * 255.0D) << 24;
         int var11 = this.c9644 + var6 - (int)((double)this.c58250.getStringWidth(var1) * var3 / 2.0D);
         int var12 = this.c30361 + this.c7676 / 2 - (int)((double)this.c58250.FONT_HEIGHT * var3 / 2.0D);
         GL11.glEnable(3042);
         GL11.glPushMatrix();
         GL11.glTranslated((double)(-var11) * (var3 - 1.0D), (double)(-var12) * (var3 - 1.0D), 0.0D);
         GL11.glScaled(var3, var3, 1.0D);
         this.c58250.drawStringWithShadow(var1, (float)var11, (float)var12, var10);
         GL11.glPopMatrix();
         GL11.glDisable(3042);
      }

   }

   private int c9914(int var1) {
      Module[] var2 = Value.c27574();
      if (var1 > 360) {
         var1 %= 360;
      }

      if (var1 < 0) {
         var1 += 360;
      }

      return var1;
   }

   private static JSONException c10412(JSONException var0) {
      return var0;
   }
}
