package rip.sleep.ui.element.elements;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.module.modules.HUD;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.RenderUtilA;
import rip.sleep.util.ShaderUtilB;
import rip.sleep.value.Value;

public class LoginButton extends GuiButton {
   public ResourceLocation c12931;

   public LoginButton(int var1, int var2, int var3, int var4, int var5, String var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.c12931 = null;
   }

   public LoginButton(int var1, int var2, int var3, int var4, int var5, String var6, ResourceLocation var7) {
      super(var1, var2, var3, var4, var5, var6);
      this.c12931 = var7;
   }

   public void drawButton(Minecraft var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      ShaderUtilB.c25830((float)(this.xPosition - 20), (float)(this.yPosition - 14), (float)(FontManager.c17232.c65036(this.displayString) + 39), 40.0F, 1.0F, this.hovered ? new Color(HUD.c64734.c41161().intValue()) : new Color(0, 0, 0, 100));
      this.hovered = var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + FontManager.c17232.c65036(this.displayString) + 29 && var3 < this.yPosition + 40;
      if (this.c12931 != null) {
         RenderUtilA.c32299(this.c12931, (float)(this.xPosition - 10), (float)(this.yPosition - 1), 14, 14);
      }

      FontManager.c17232.c59386(this.displayString, (float)(this.xPosition - (this.displayString.equals("Microsoft Login") ? 18 : (this.displayString.equals("Direct Login") ? 22 : 14)) + FontManager.c17232.c65036(this.displayString) / 2), (float)(this.yPosition + (this.displayString.equals("Microsoft Login") ? 3 : 6)), -1);
   }

   public boolean mousePressed(Minecraft var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      return this.enabled && this.visible && var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + FontManager.c17232.c65036(this.displayString) + 29 && var3 < this.yPosition + 20;
   }

   private static JSONException c41741(JSONException var0) {
      return var0;
   }
}
