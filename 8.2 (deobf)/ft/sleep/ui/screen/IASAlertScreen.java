//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class IASAlertScreen extends GuiScreen {
   public Runnable steering$;
   public String assembly$;
   public String stages$;
   public List fantasy$;

   public IASAlertScreen(Runnable fabuyonu, String utiyalaz, String ugeyosep) {
      iliceles.steering$ = (Runnable)fabuyonu;
      iliceles.assembly$ = (String)utiyalaz;
      iliceles.stages$ = (String)ugeyosep;
   }

   public void initGui() {
      ciroresi.buttonList.add(new GuiButton(0, ciroresi.width / 2 - 50, ciroresi.height - 28, 100, 20, "Back"));
      ciroresi.fantasy$ = ciroresi.fontRendererObj.listFormattedStringToWidth(ciroresi.stages$, ciroresi.width - 50);
      super.initGui();
   }

   public void actionPerformed(GuiButton heavy) throws IOException {
      if (((GuiButton)heavy).id == 0) {
         metal.steering$.run();
      }

      super.actionPerformed((GuiButton)heavy);
   }

   public void drawScreen(int blend, int plane, float damage) {
      homes.drawDefaultBackground();
      homes.drawCenteredString(homes.fontRendererObj, homes.assembly$, homes.width / 2, 30, -1);
      if (homes.fantasy$ != null) {
         for(Object evening = 0; evening < homes.fantasy$.size(); ++evening) {
            homes.drawCenteredString(homes.fontRendererObj, (String)homes.fantasy$.get(evening), homes.width / 2, 50 + evening * 10, -1);
         }
      }

      super.drawScreen((int)blend, (int)plane, (float)damage);
   }
}
