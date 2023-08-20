//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.module.modules.HUD;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.util.render.RenderUtil;
import ft.sleep.util.render.RoundedUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class LoginButton extends GuiButton {
   public ResourceLocation crack$;

   public LoginButton(int gerogupe, int zetapeci, int unudesey, int idunuces, int sorucose, String ufunimag) {
      super((int)gerogupe, (int)zetapeci, (int)unudesey, (int)idunuces, (int)sorucose, (String)ufunimag);
      vibagufi.crack$ = null;
   }

   public LoginButton(int germany, int railroad, int barbara, int aside, int viewing, String indices, ResourceLocation heads) {
      super((int)germany, (int)railroad, (int)barbara, (int)aside, (int)viewing, (String)indices);
      future.crack$ = (ResourceLocation)heads;
   }

   public void drawButton(Minecraft capacity, int learners, int var3) {
      RoundedUtil._ticket((float)(legacy.xPosition - 20), (float)(legacy.yPosition - 14), (float)(FontLoaders.SF18.getStringWidth(legacy.displayString) + 39), 40.0F, 1.0F, legacy.hovered ? new Color(HUD.during$.getValue().intValue()) : new Color(0, 0, 0, 100));
      legacy.hovered = learners >= legacy.xPosition && var3 >= legacy.yPosition && learners < legacy.xPosition + FontLoaders.SF18.getStringWidth(legacy.displayString) + 29 && var3 < legacy.yPosition + 40;
      if (legacy.crack$ != null) {
         RenderUtil._marked(legacy.crack$, (float)(legacy.xPosition - 10), (float)(legacy.yPosition - 1), 14, 14);
      }

      FontLoaders.SF18.drawString(legacy.displayString, (float)(legacy.xPosition - (legacy.displayString.equals("Microsoft Login") ? 18 : (legacy.displayString.equals("Direct Login") ? 22 : 14)) + FontLoaders.SF18.getStringWidth(legacy.displayString) / 2), (float)(legacy.yPosition + (legacy.displayString.equals("Microsoft Login") ? 3 : 6)), -1);
   }

   public boolean mousePressed(Minecraft sobifeye, int reyoposu, int var3) {
      return voyeceta.enabled && voyeceta.visible && reyoposu >= voyeceta.xPosition && var3 >= voyeceta.yPosition && reyoposu < voyeceta.xPosition + FontLoaders.SF18.getStringWidth(voyeceta.displayString) + 29 && var3 < voyeceta.yPosition + 20;
   }
}
