//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Value;
import java.awt.Color;

import ft.sleep.module.ModuleType;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ColorValueButton2 extends ValueButton2 {
   public ModuleType lined$;
   public float[] coaching$ = new float[]{Float.intBitsToFloat(0)};
   public int rooms$;
   public int papua$ = (new Color(125, 125, 125)).getRGB();

   public ColorValueButton2(ModuleType dotacali, int biruleve, int pafovosa) {
      super((ModuleType)dotacali, (Value)null, (int)biruleve, (int)pafovosa);
      fezicepu.lined$ = (ModuleType)dotacali;
      fezicepu. = true;
      fezicepu.rooms$ = -1111;
   }

   public void _workshop(int cancer, int kernel, Limitation2 sterling) {
      Object cultures = new float[]{doubt.coaching$[0]};
      Object betty = doubt.x - 7;
      GL11.glEnable(3089);
      ((Limitation2)sterling)._singer();
      Gui.drawRect(doubt.x - 10, doubt.y - 4, doubt.x + 80, doubt.y + 11, (new Color(39, 39, 39)).getRGB());

      for(; betty < doubt.x + 79; ++betty) {
         Object chuck = Color.getHSBColor(cultures[0] / 255.0F, 0.7F, 1.0F);
         if (cancer > betty - 1 && cancer < betty + 1 && kernel > doubt.y - 6 && kernel < doubt.y + 12 && Mouse.isButtonDown(0)) {
            doubt.papua$ = chuck.getRGB();
            doubt.rooms$ = betty;
         }

         if (doubt.papua$ == chuck.getRGB()) {
            doubt.rooms$ = betty;
         }

         Gui.drawRect(betty - 1, doubt.y, betty, doubt.y + 8, chuck.getRGB());
         cultures[0] += 4.0F;
         if (cultures[0] > 255.0F) {
            cultures[0] -= 255.0F;
         }
      }

      Gui.drawRect(doubt.rooms$, doubt.y, doubt.rooms$ + 1, doubt.y + 8, -1);
      if (doubt.coaching$[0] > 255.0F) {
         doubt.coaching$[0] -= 255.0F;
      }

      GL11.glDisable(3089);
   }

   public void _replaced(char var1, int var2) {
   }

   public void _warcraft(int var1, int var2, int var3) {
   }
}
