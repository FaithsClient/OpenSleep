//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Value;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

public class HideButton2 extends ValueButton2 {
   public Module follows$;
   public double lived$ = Double.longBitsToDouble(0L);
   public boolean canon$;
   public ModuleType proteins$;

   public HideButton2(ModuleType chick, Module dollar, int packard, int adapted) {
      super((ModuleType)chick, (Value)null, (int)packard, (int)adapted);
      chapel.proteins$ = (ModuleType)chick;
      chapel. = true;
      chapel.canon$ = false;
      chapel.follows$ = (Module)dollar;
   }

   public void _workshop(int decline, int retained, Limitation2 var3) {
      GL11.glEnable(3089);
      var3._singer();
      Gui.drawRect(0, 0, 0, 0, 0);
      int var4;
      if (noted.proteins$.name().equals("Combat")) {
         var4 = (new Color(225, 25, 25)).getRGB();
      } else if (noted.proteins$.name().equals("Render")) {
         var4 = (new Color(38, 160, 255)).getRGB();
      } else if (noted.proteins$.name().equals("Movement")) {
         var4 = (new Color(0, 150, 120)).getRGB();
      } else if (noted.proteins$.name().equals("Player")) {
         var4 = (new Color(128, 0, 128)).getRGB();
      } else if (noted.proteins$.name().equals("Legit")) {
         var4 = (new Color(255, 140, 205)).getRGB();
      } else {
         var4 = (new Color(38, 154, 255)).getRGB();
      }

      Gui.drawRect(noted.x - 9, noted.y - 5, noted.x + 90, noted.y + 13, (new Color(39, 39, 39)).getRGB());
      if (noted.follows$._wishlist()) {
         FontLoaders.logo18.drawStringWithShadow("j", (double)noted.x + 77.5D - (double)FontLoaders.logo18.getStringWidth("j"), (double)noted.y + 1.5D, (new Color(var4)).getRGB());
      }

      FontLoaders.TahomaBold13.drawStringWithShadow("ft.sleep.command.commands.Hidden", (double)(noted.x - 7), (double)((float)noted.y + 0.5F), (new Color(255, 255, 255)).getRGB());
      GL11.glDisable(3089);
   }

   public void _warcraft(int ugonolez, int zaredoza, int omucogov) {
      if (ugonolez > umomozuz.x - 7 && ugonolez < umomozuz.x + 85 && zaredoza > umomozuz.y - 6 && zaredoza < umomozuz.y + FontLoaders.clickgui17.getStringHeight(umomozuz.follows$._skirt()) + 5 && omucogov == 0) {
         umomozuz.follows$._bosnia(!umomozuz.follows$._wishlist());
      }

      super._warcraft((int)ugonolez, (int)zaredoza, (int)omucogov);
   }
}
