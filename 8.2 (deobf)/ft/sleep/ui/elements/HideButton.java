//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Value;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

public class HideButton extends ValueButton {
   public Module create$;
   public double current$ = Double.longBitsToDouble(0L);
   public boolean product$;
   public ModuleType valley$;

   public HideButton(ModuleType secadiyu, Module edadadig, int eroderay, int pumunina) {
      super((ModuleType)secadiyu, (Value)null, (int)eroderay, (int)pumunina);
      udonesab.valley$ = (ModuleType)secadiyu;
      udonesab. = true;
      udonesab.product$ = false;
      udonesab.create$ = (Module)edadadig;
   }

   public void _oxygen(int zedotezu, int var2, Limitation var3) {
      GL11.glEnable(3089);
      var3._array();
      Gui.drawRect(0, 0, 0, 0, 0);
      Gui.drawRect(adesuzev.x - 9, adesuzev.y - 2, adesuzev.x + 90, adesuzev.y + 13, (new Color(5, 5, 5, 110)).getRGB());
      ft.sleep.ui.font.RenderUtil.drawRect((double)(adesuzev.x + 4), (double)adesuzev.y + 2.5D, (double)adesuzev.x + 3.5D, (double)adesuzev.y + 10.5D, (new Color(180, 180, 180)).getRGB());
      ft.sleep.ui.font.RenderUtil.drawRect((double)(adesuzev.x - 6), (double)adesuzev.y + 2.5D, (double)adesuzev.x - 5.5D, (double)adesuzev.y + 10.5D, (new Color(180, 180, 180)).getRGB());
      ft.sleep.ui.font.RenderUtil.drawRect((double)(adesuzev.x - 6), (double)adesuzev.y + 2.5D, (double)(adesuzev.x + 4), (double)(adesuzev.y + 2), (new Color(180, 180, 180)).getRGB());
      ft.sleep.ui.font.RenderUtil.drawRect((double)(adesuzev.x - 6), (double)(adesuzev.y + 11), (double)(adesuzev.x + 4), (double)adesuzev.y + 10.5D, (new Color(180, 180, 180)).getRGB());
      if (adesuzev.create$._wishlist()) {
         FontLoaders.logo18.drawStringWithShadow("v", (double)adesuzev.x + 3.5D - (double)FontLoaders.logo18.getStringWidth("v"), (double)adesuzev.y + 4.5D, (new Color(255, 255, 255)).getRGB());
      }

      FontLoaders.kiona14.drawStringWithShadow("ft.sleep.command.commands.Hidden", (double)(adesuzev.x + 5), (double)((float)adesuzev.y + 4.5F), (new Color(180, 180, 180)).getRGB());
      GL11.glDisable(3089);
   }

   public void _google(int ecegunit, int lolugebu, int abupugil) {
      if (ecegunit > ciligona.x - 7 && ecegunit < ciligona.x + 1 && lolugebu > ciligona.y + 2 && lolugebu < ciligona.y + FontLoaders.kiona17.getStringHeight(ciligona.create$._skirt()) + 6 && abupugil == 0) {
         ciligona.create$._bosnia(!ciligona.create$._wishlist());
      }

      super._google((int)ecegunit, (int)lolugebu, (int)abupugil);
   }
}
