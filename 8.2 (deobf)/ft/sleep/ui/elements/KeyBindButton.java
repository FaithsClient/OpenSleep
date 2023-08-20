//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Value;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.elements.ValueButton2;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.ui.screen.ClickUi2;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class KeyBindButton extends ValueButton2 {
   public Module postings$;
   public double circle$ = Double.longBitsToDouble(0L);
   public boolean planet$;
   public ModuleType cheaper$;

   public KeyBindButton(ModuleType verunepa, Module rudebuni, int susegezu, int udenucas) {
      super((ModuleType)verunepa, (Value)null, (int)susegezu, (int)udenucas);
      elomasar.cheaper$ = (ModuleType)verunepa;
      elomasar. = true;
      elomasar.planet$ = false;
      elomasar.postings$ = (Module)rudebuni;
   }

   public void _workshop(int didilavo, int var2, Limitation2 var3) {
      GL11.glEnable(3089);
      var3._singer();
      Gui.drawRect(0, 0, 0, 0, 0);
      Gui.drawRect(cigavibu.x - 10, cigavibu.y - 4, cigavibu.x + 80, cigavibu.y + 11, (new Color(39, 39, 39)).getRGB());
      FontLoaders.TahomaBold13.drawStringWithShadow("ft.sleep.command.commands.Bind", (double)(cigavibu.x - 7), (double)(cigavibu.y + 2), (new Color(255, 255, 255)).getRGB());
      FontLoaders.TahomaBold13.drawStringWithShadow("" + Keyboard.getKeyName(cigavibu.postings$._owned()), (double)(cigavibu.x + 77 - FontLoaders.TahomaBold13.getStringWidth(Keyboard.getKeyName(cigavibu.postings$._owned()))), (double)(cigavibu.y + 2), (new Color(180, 180, 180)).getRGB());
      GL11.glDisable(3089);
   }

   public void _replaced(char ezuyumuy, int gucitilu) {
      if (yasisona.planet$) {
         yasisona.postings$._enrolled((int)gucitilu);
         if (gucitilu == 1) {
            yasisona.postings$._enrolled(0);
         }

         ClickUi2.antonio$ = false;
         yasisona.planet$ = false;
      }

      super._replaced((char)ezuyumuy, (int)gucitilu);
   }

   public void _warcraft(int besomama, int edurolas, int erizapot) {
      if (besomama > vepudosa.x - 7 && besomama < vepudosa.x + 85 && edurolas > vepudosa.y - 6 && edurolas < vepudosa.y + FontLoaders.clickgui18.getStringHeight(vepudosa.postings$._skirt()) + 5 && erizapot == 0) {
         ClickUi2.antonio$ = vepudosa.planet$ = !vepudosa.planet$;
      }

      super._warcraft((int)besomama, (int)edurolas, (int)erizapot);
   }
}
