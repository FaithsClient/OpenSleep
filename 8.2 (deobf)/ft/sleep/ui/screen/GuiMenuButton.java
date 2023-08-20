//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.util.render.RenderUtil2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiMenuButton extends GuiButton {
   public float service$ = 1.0F;
   public float cutting$;

   public GuiMenuButton(int scored, int utilize, int vault, int injury, int through, String berlin) {
      super((int)scored, (int)utilize, (int)vault, (int)injury, (int)through, (String)berlin);
   }

   public void drawButton(Minecraft ayacafid, int ugonamuc, int vazizupo) {
      if (uralugat.visible) {
         uralugat.hovered = ugonamuc >= uralugat.xPosition && vazizupo >= uralugat.yPosition - 2 && ugonamuc < uralugat.xPosition + 120 && vazizupo < uralugat.yPosition + 100;
         uralugat.cutting$ = uralugat.hovered ? 1.8F : 1.0F;
         Object ebuticem = (uralugat.cutting$ - uralugat.service$) * Float.intBitsToFloat(0);
         uralugat.service$ = 1.0F + ebuticem;
         GlStateManager.pushMatrix();
         GlStateManager.scale(uralugat.service$, uralugat.service$, uralugat.service$);
         uralugat.mouseDragged((Minecraft)ayacafid, (int)ugonamuc, (int)vazizupo);
         Object efudofuf = uralugat.hovered ? Colors._nickname(160, 160, 160, 255) : -1;
         GlStateManager.pushMatrix();
         RenderUtil2._carnival((float)uralugat.xPosition, (float)uralugat.yPosition, (float)(uralugat.xPosition + 120), (float)(uralugat.yPosition + 100), 0.3F, uralugat.hovered ? (new Color(160, 160, 160)).getRGB() : (new Color(80, 80, 80)).getRGB(), (new Color(18, 18, 18)).getRGB());
         FontLoaders.Tahoma18.drawString(uralugat.displayString.toLowerCase(), (float)(uralugat.xPosition + 60 - FontLoaders.Tahoma18.getStringWidth(uralugat.displayString) / 2 - 2), (float)(uralugat.yPosition + 12), efudofuf);
         Gui.drawRect(0, 0, 0, 0, 0);
         GlStateManager.popMatrix();
         GlStateManager.popMatrix();
      }

   }
}
