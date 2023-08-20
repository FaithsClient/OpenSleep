//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Value;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.elements.ValueButton;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.ui.screen.ClickUi;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class KeyBindButton2 extends ValueButton {
   public Module comes$;
   public double touched$ = Double.longBitsToDouble(0L);
   public boolean fountain$;
   public ModuleType state$;

   public KeyBindButton2(ModuleType dominant, Module predict, int remix, int andrews) {
      super((ModuleType)dominant, (Value)null, (int)remix, (int)andrews);
      fighter.state$ = (ModuleType)dominant;
      fighter. = true;
      fighter.fountain$ = false;
      fighter.comes$ = (Module)predict;
   }

   public void _oxygen(int given, int var2, Limitation var3) {
      GL11.glEnable(3089);
      var3._array();
      Gui.drawRect(0, 0, 0, 0, 0);
      Gui.drawRect(drums.x - 9, drums.y - 2, drums.x + 90, drums.y + 13, (new Color(5, 5, 5, 110)).getRGB());
      FontLoaders.kiona14.drawStringWithShadow("KeyBind:", (double)(drums.x - 6), (double)(drums.y + 4), (new Color(180, 180, 180)).getRGB());
      FontLoaders.kiona14.drawStringWithShadow("" + Keyboard.getKeyName(drums.comes$._owned()), (double)(drums.x + 57 - FontLoaders.TahomaBold14.getStringWidth("KeyBind:")), (double)((float)drums.y + 4.0F), (new Color(255, 255, 255)).getRGB());
      GL11.glDisable(3089);
   }

   public void _warner(char sublime, int sigma) {
      if (fought.fountain$) {
         fought.comes$._enrolled((int)sigma);
         if (sigma == 1) {
            fought.comes$._enrolled(0);
         }

         ClickUi.dover$ = false;
         fought.fountain$ = false;
      }

      super._warner((char)sublime, (int)sigma);
   }

   public void _google(int plans, int marsh, int living) {
      if (plans > blades.x - 7 && plans < blades.x + 85 && marsh > blades.y + 2 && marsh < blades.y + FontLoaders.kiona17.getStringHeight(blades.comes$._skirt()) + 6 && living == 0) {
         ClickUi.dover$ = blades.fountain$ = !blades.fountain$;
      }

      super._google((int)plans, (int)marsh, (int)living);
   }
}
