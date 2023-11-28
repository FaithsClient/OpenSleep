package rip.sleep.ui.element.elements;

import java.awt.Color;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.ui.element.Element;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.ShaderUtilB;
import rip.sleep.value.Value;

public class ButtonB extends Element {
   private final String c836;

   public ButtonB(int var1, FontRenderer var2, int var3, int var4, int var5, int var6, String var7) {
      super(var1, var2, var3, var4, var5, var6);
      this.c836 = var7;
   }

   public void c41720() {
      Module[] var1 = Value.c27574();
      if (this.c95043()) {
         FontManager.c11121.c59386(this.c836, this.c46254 - (float) FontManager.c11121.c65036(this.c836) - 5.0F, this.c98483 + 5.0F, (new Color(-1)).getRGB());
         ShaderUtilB.c25830(this.c46254, this.c98483 + 15.0F, (float)this.c73424, 1.0F, 0.0F, new Color(-1));
         int var2 = this.c82534 ? this.c84152 : this.c23099;
         int var3 = this.c75770() - this.c44417;
         int var4 = this.c26869() - this.c44417;
         String var5 = this.c36421.trimStringToWidth(this.c78567().substring(this.c44417).replaceAll("(?s).", "*"), this.c30505());
         boolean var6 = var3 >= 0 && var3 <= var5.length();
         boolean var7 = this.c98807() && this.c16665 / 6 % 2 == 0 && var6;
         int var8 = this.c67239 ? (int)this.c46254 + 4 : (int)this.c46254;
         int var9 = this.c67239 ? (int)this.c98483 + (this.c51871 - 8) / 2 : (int)this.c98483;
         int var10 = var8;
         if (var4 > var5.length()) {
            var4 = var5.length();
         }

         if (!var5.isEmpty()) {
            String var11 = var5.substring(0, var3);
            var10 = this.c36421.drawStringWithShadow(var11, (float)var8, (float)var9, var2);
         }

         boolean var14 = this.c75770() < this.c78567().length() || this.c78567().length() >= this.c28002();
         int var12 = var10;
         if (!var6) {
            var12 = var3 > 0 ? var8 + this.c73424 : var8;
         }

         if (var14) {
            var12 = var10 - 1;
            --var10;
         }

         if (!var5.isEmpty() && var6 && var3 < var5.length()) {
            this.c36421.drawStringWithShadow(var5.substring(var3), (float)var10, (float)var9, var2);
         }

         if (var7) {
            if (var14) {
               Gui.drawRect(var12, var9 - 1, var12 + 1, var9 + 1 + this.c36421.FONT_HEIGHT, -3092272);
            }

            this.c36421.drawStringWithShadow("_", (float)var12, (float)var9, var2);
         }

         if (var4 != var3) {
            int var13 = var8 + this.c36421.getStringWidth(var5.substring(0, var4));
            this.c37578(var12, var9 - 1, var13 - 1, var9 + 1 + this.c36421.FONT_HEIGHT);
         }
      }

   }

   private static JSONException c70575(JSONException var0) {
      return var0;
   }
}
