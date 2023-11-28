package rip.sleep.ui.renderer;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.ui.bingus.GuiBingusClickGui;
import rip.sleep.util.Frame;
import rip.sleep.value.Value;

public class KeyBindRenderer extends ModuleRenderer {
   public Module c26077;
   public double c19958 = 0.0D;
   public boolean c73161;
   public ModuleType c1963;

   public KeyBindRenderer(ModuleType var1, Module var2, int var3, int var4) {
      super(var1, (Value)null, var3, var4);
      this.c1963 = var1;
      this.c31377 = true;
      this.c73161 = false;
      this.c26077 = var2;
   }

   public void c74493(int var1, int var2, Frame var3) {
      GL11.glEnable(3089);
      var3.c94845();
      Gui.drawRect(0, 0, 0, 0, 0);
      Gui.drawRect(this.c20520 - 9, this.c61951 - 2, this.c20520 + 90, this.c61951 + 13, (new Color(5, 5, 5, 110)).getRGB());
      FontManager.c43464.c17470("KeyBind:", (double)(this.c20520 - 6), (double)(this.c61951 + 4), (new Color(180, 180, 180)).getRGB());
      FontManager.c43464.c17470("" + Keyboard.getKeyName(this.c26077.c93366()), (double)(this.c20520 + 57 - FontManager.c64931.c65036("KeyBind:")), (double)((float)this.c61951 + 4.0F), (new Color(255, 255, 255)).getRGB());
      GL11.glDisable(3089);
   }

   public void c89714(char var1, int var2) {
      Module[] var3 = Value.c27574();
      if (this.c73161) {
         this.c26077.c32946(var2);
         if (var2 == 1) {
            this.c26077.c32946(0);
         }

         GuiBingusClickGui.c65527 = false;
         this.c73161 = false;
      }

      super.c89714(var1, var2);
   }

   public void c35654(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var1 > this.c20520 - 7 && var1 < this.c20520 + 85 && var2 > this.c61951 + 2 && var2 < this.c61951 + FontManager.c54334.c25901(this.c26077.getName()) + 6 && var3 == 0) {
         GuiBingusClickGui.c65527 = this.c73161 = !this.c73161;
      }

      super.c35654(var1, var2, var3);
   }

   private static JSONException c90475(JSONException var0) {
      return var0;
   }
}
