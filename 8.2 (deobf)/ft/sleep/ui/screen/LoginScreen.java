//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

import ft.sleep.util.auth.MicrosoftAccount;
import ft.sleep.util.auth.MicrosoftAuthCallback;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public class LoginScreen extends GuiScreen {
   public GuiScreen methods$;
   public String mostly$;
   public Consumer newer$;
   public MicrosoftAuthCallback lower$ = new MicrosoftAuthCallback();
   public GuiButton hopkins$;
   public String platinum$;

   public LoginScreen(GuiScreen response, String learn, Consumer dosage) {
      sound.methods$ = (GuiScreen)response;
      sound.mostly$ = (String)learn;
      sound.newer$ = (Consumer)dosage;
   }

   public void initGui() {
      super.initGui();
      ametedar.buttonList.add(new GuiButton(1, ametedar.width / 2 - 60, ametedar.height - 28, 150, 20, "Cancel"));
      ametedar.buttonList.add(ametedar.hopkins$ = new GuiButton(3, ametedar.width / 2 - 50, ametedar.height / 2 + 12, 100, 20, "Start"));
   }

   public void actionPerformed(GuiButton ofurusar) throws IOException {
      if (((GuiButton)ofurusar).id == 1) {
         unorizes.mc.displayGuiScreen(unorizes.methods$);
      } else if (((GuiButton)ofurusar).id == 3) {
         unorizes.();
      }

      super.actionPerformed((GuiButton)ofurusar);
   }

   public void mouseClicked(int networks, int deposits, int moore) throws IOException {
      super.mouseClicked((int)networks, (int)deposits, (int)moore);
   }

   public void drawScreen(int ocucamep, int epizotob, float afonipat) {
      ilemadac.drawDefaultBackground();
      ilemadac.drawCenteredString(ilemadac.fontRendererObj, ilemadac.mostly$, ilemadac.width / 2, 5, -1);
      if (ilemadac.platinum$ != null) {
         ilemadac.drawCenteredString(ilemadac.fontRendererObj, ilemadac.platinum$, ilemadac.width / 2, ilemadac.height / 3 * 2, -26368);
         ilemadac.drawCenteredString(ilemadac.fontRendererObj, SharedIAS.latina$[(int)(System.currentTimeMillis() / ((long)-1464659841 ^ -1464659891L) % (long) SharedIAS.latina$.length)], ilemadac.width / 2, ilemadac.height / 3 * 2 + 10, -26368);
      }

      ilemadac.hopkins$.visible = ilemadac.platinum$ == null;
      super.drawScreen((int)ocucamep, (int)epizotob, (float)afonipat);
   }

   public void keyTyped(char imolusey, int ucapigog) throws IOException {
      if (ucapigog == 1) {
         liragage.mc.displayGuiScreen(liragage.methods$);
      } else {
         super.keyTyped((char)imolusey, (int)ucapigog);
      }
   }

   public void onGuiClosed() {
      Executor var10000 = SharedIAS.omaha$;
      MicrosoftAuthCallback var10001 = learned.lower$;
      learned.lower$.getClass();
      var10000.execute(var10001::close);
      super.onGuiClosed();
   }

   public void updateScreen() {
      document.hopkins$.enabled = document.platinum$ == null;
      super.updateScreen();
   }

   public void ____/* $FF was: */() {
      alert.platinum$ = "";
      SharedIAS.omaha$.execute(alert::);
   }

   public void ___/* $FF was: �?*/(String saruludo) {
      Desktop.getDesktop().browse(new URI((String)saruludo));
   }

   public void ____/* $FF was: */() {
      related.platinum$ = "Check your browser.";
      related.�?("https://login.live.com/oauth20_authorize.srf?client_id=54fd49e4-2103-4044-9603-2b028c814ec3&response_type=code&scope=XboxLive.signin%20XboxLive.offline_access&redirect_uri=http://localhost:59125&prompt=select_account");
      related.lower$._deluxe(related::�?, "You can close this window.").whenComplete(related::�?);
   }

   public void _/* $FF was: �?*/(MicrosoftAccount abosomas, Throwable febeceyu) {
      if (fasoduyo.mc.currentScreen == fasoduyo) {
         if (febeceyu != null) {
            fasoduyo.mc.addScheduledTask(fasoduyo::�?);
         } else if (abosomas == null) {
            fasoduyo.mc.addScheduledTask(fasoduyo::);
         } else {
            fasoduyo.mc.addScheduledTask(fasoduyo::�?);
         }
      }
   }

   public void _/* $FF was: �?*/(MicrosoftAccount memory) {
      rivers.newer$.accept(memory);
      rivers.mc.displayGuiScreen(rivers.methods$);
   }

   public void ____/* $FF was: */() {
      ipurizif.mc.displayGuiScreen(ipurizif.methods$);
   }

   public void _/* $FF was: �?*/(Throwable senegal) {
      array.mc.displayGuiScreen(new IASAlertScreen(array::, EnumChatFormatting.RED + "An error has occurred.", String.valueOf(senegal)));
   }

   public void ____/* $FF was: */() {
      zulugosi.mc.displayGuiScreen(zulugosi.methods$);
   }

   public void _/* $FF was: �?*/(String nafayide, Object[] yicizodo) {
      ecaronut.platinum$ = String.format((String)nafayide, (Object[])yicizodo);
   }
}
