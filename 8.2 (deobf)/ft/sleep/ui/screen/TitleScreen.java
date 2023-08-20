//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import ft.sleep.ui.elements.Button2;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import ft.sleep.ui.screen.GuiAltManager;
import ft.sleep.util.changelog.ChangeLogUtils3;
import ft.sleep.util.render.RenderUtil;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiSelectWorld;

public class TitleScreen extends Panorama {
   public ArrayList agreed$ = new ArrayList();
   public Button2 shortly$;
   public Button2 layer$;
   public Button2 myrtle$;
   public Button2 varying$;

   public TitleScreen() {
      johnston.shortly$ = new Button2("Single Player", johnston.width / 2 - 75, johnston.height / 2);
      johnston._poultry(johnston.shortly$);
      johnston.layer$ = new Button2("Multi Player", johnston.width / 2 - 75, johnston.height / 2 + 25);
      johnston._poultry(johnston.layer$);
      johnston.varying$ = new Button2("Alt ft.sleep.util.interfaces.Manager", johnston.width / 2 - 75, johnston.height / 2 + 50);
      johnston._poultry(johnston.varying$);
      johnston.myrtle$ = new Button2("Settings", johnston.width / 2 - 75, johnston.height / 2 + 75);
      johnston._poultry(johnston.myrtle$);
   }

   public void drawScreen(int ditiyevi, int adivepov, float gopogigu) {
      super.drawScreen((int)ditiyevi, (int)adivepov, (float)gopogigu);
      FontLoaders.kiona16.drawStringWithShadow("", (double)(epusonub.width - FontLoaders.kiona16.getStringWidth("") - 2), (double)(epusonub.height - FontLoaders.kiona16.getHeight() - 2), (new Color(255, 255, 255)).getRGB());
      FontLoaders.kiona16.drawStringWithShadow("", 3.0D, (double)(epusonub.height - FontLoaders.kiona16.getHeight() - 2), (new Color(255, 255, 255)).getRGB());
      ChangeLogUtils3._adults();

      for(Object upabutad = 0; upabutad < epusonub.agreed$.size(); ++upabutad) {
         Object atuyonod = (Button2)epusonub.agreed$.get(upabutad);
         atuyonod._march((int)ditiyevi, (int)adivepov, epusonub.width / 2 - 75, epusonub.height / 2 + upabutad * 25);
      }

      epusonub._arrivals();
      epusonub._timely((int)ditiyevi, (int)adivepov);
   }

   public void _farmers(int nenoyofu, int uvusomel, int zutuyeti) throws IOException {
      if (cagupago.shortly$._chinese((int)nenoyofu, (int)uvusomel)) {
         cagupago.mc.displayGuiScreen(new GuiSelectWorld(cagupago));
      } else if (cagupago.layer$._chinese((int)nenoyofu, (int)uvusomel)) {
         cagupago.mc.displayGuiScreen(new GuiMultiplayer(cagupago));
      } else if (cagupago.myrtle$._chinese((int)nenoyofu, (int)uvusomel)) {
         cagupago.mc.displayGuiScreen(new GuiOptions(cagupago, cagupago.mc.gameSettings));
      } else if (cagupago.varying$._chinese((int)nenoyofu, (int)uvusomel)) {
         cagupago.mc.displayGuiScreen(new GuiAltManager());
      } else if (RenderUtil._issue(cagupago.width - 25, 5, 20, 20, (int)nenoyofu, (int)uvusomel)) {
         cagupago.mc.shutdown();
      }

      super.mouseClicked((int)nenoyofu, (int)uvusomel, (int)zutuyeti);
   }

   public void _arrivals() {
      RenderUtil._purposes(igepotap.width / 2 - 130, igepotap.height / 2 - 220, 250, 250, -1, "logo2.png");
   }

   public void _jonathan() {
   }

   public void _timely(int hamburg, int returned) {
      RenderUtil._orbit(suite.width - 25, 5, 20, 20, 2, RenderUtil._issue(suite.width - 25, 5, 20, 20, (int)hamburg, (int)returned) ? 822083583 : (new Color(28, 28, 28, 120)).getRGB(), 0);
      RenderUtil._purposes(suite.width - 25, 5, 20, 20, -1, "cross.png");
   }

   public void _poultry(Button2 ironimiz) {
      iyayediy.agreed$.add(ironimiz);
   }
}
