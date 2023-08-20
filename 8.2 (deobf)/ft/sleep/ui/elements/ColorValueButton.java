//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Value;
import java.awt.Color;

import ft.sleep.module.ModuleType;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ColorValueButton extends ValueButton {
   public ModuleType invision$;
   public float[] mercedes$ = new float[]{Float.intBitsToFloat(0)};
   public int liberia$;
   public int amateur$ = (new Color(125, 125, 125)).getRGB();

   public ColorValueButton(ModuleType comimuse, int povabani, int pafefoba) {
      super((ModuleType)comimuse, (Value)null, (int)povabani, (int)pafefoba);
      vuvurada.invision$ = (ModuleType)comimuse;
      vuvurada. = true;
      vuvurada.liberia$ = -1111;
   }

   public void _oxygen(int himself, int black, Limitation manitoba) {
      Object samples = new float[]{cursor.mercedes$[0]};
      Object letter = cursor.x - 7;
      GL11.glEnable(3089);
      ((Limitation)manitoba)._array();
      Gui.drawRect(cursor.x - 10, cursor.y - 4, cursor.x + 80, cursor.y + 11, (new Color(0, 0, 0, 150)).getRGB());

      for(; letter < cursor.x + 79; ++letter) {
         Object grows = Color.getHSBColor(samples[0] / 255.0F, 0.7F, 1.0F);
         if (himself > letter - 1 && himself < letter + 1 && black > cursor.y - 6 && black < cursor.y + 12 && Mouse.isButtonDown(0)) {
            cursor.amateur$ = grows.getRGB();
            cursor.liberia$ = letter;
         }

         if (cursor.amateur$ == grows.getRGB()) {
            cursor.liberia$ = letter;
         }

         Gui.drawRect(letter - 1, cursor.y, letter, cursor.y + 8, grows.getRGB());
         samples[0] += 4.0F;
         if (samples[0] > 255.0F) {
            samples[0] -= 255.0F;
         }
      }

      Gui.drawRect(cursor.liberia$, cursor.y, cursor.liberia$ + 1, cursor.y + 8, -1);
      if (cursor.mercedes$[0] > 255.0F) {
         cursor.mercedes$[0] -= 255.0F;
      }

      GL11.glDisable(3089);
   }

   public void _warner(char var1, int var2) {
   }

   public void _google(int var1, int var2, int var3) {
   }
}
