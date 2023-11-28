package rip.sleep.ui.misc;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.Sys;
import rip.sleep.interfaces.IAccount;
import rip.sleep.value.Value;
import rip.sleep.util.IASShared;
import rip.sleep.account.MicrosoftAccount;
import rip.sleep.module.Module;

public class GuiLoginScreen extends GuiScreen {
   private final GuiScreen c60631;
   private final String c97738;
   private final Consumer<IAccount> c52934;
   private final c72832 c20834 = new c72832();
   private GuiButton c61569;
   private String c50394;

   public GuiLoginScreen(GuiScreen var1, String var2, Consumer<IAccount> var3) {
      this.c60631 = var1;
      this.c97738 = var2;
      this.c52934 = var3;
   }

   public void initGui() {
      super.initGui();
      this.buttonList.add(new GuiButton(1, this.width / 2 - 60, this.height - 28, 150, 20, "Cancel"));
      this.buttonList.add(this.c61569 = new GuiButton(3, this.width / 2 - 50, this.height / 2 + 12, 100, 20, "Start"));
   }

   public void actionPerformed(GuiButton var1) throws IOException {
      Module[] var2 = Value.c27574();
      if (var1.id == 1) {
         this.mc.displayGuiScreen(this.c60631);
      }

      if (var1.id == 3) {
         this.c42207();
      }

      super.actionPerformed(var1);
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      super.mouseClicked(var1, var2, var3);
   }

   public void drawScreen(int var1, int var2, float var3) {
      Value.c27574();
      this.drawDefaultBackground();
      this.func_73732_a(this.fontRendererObj, this.c97738, this.width / 2, 5, -1);
      if (this.c50394 != null) {
         this.func_73732_a(this.fontRendererObj, this.c50394, this.width / 2, this.height / 3 * 2, -26368);
         this.func_73732_a(this.fontRendererObj, IASShared.c86445[(int)(System.currentTimeMillis() / 50L % (long) IASShared.c86445.length)], this.width / 2, this.height / 3 * 2 + 10, -26368);
      }

      this.c61569.visible = this.c50394 == null;
      super.drawScreen(var1, var2, var3);
   }

   public void keyTyped(char var1, int var2) throws IOException {
      Module[] var3 = Value.c27574();
      if (var2 == 1) {
         this.mc.displayGuiScreen(this.c60631);
      } else {
         super.keyTyped(var1, var2);
      }
   }

   public void onGuiClosed() {
      Executor var10000 = IASShared.c59270;
      c72832 var10001 = this.c20834;
      this.c20834.getClass();
      var10000.execute(var10001::close);
      super.onGuiClosed();
   }

   public void updateScreen() {
      this.c61569.enabled = this.c50394 == null;
      super.updateScreen();
   }

   private void c42207() {
      this.c50394 = "";
      IASShared.c59270.execute(() -> {
         this.c50394 = "Check your browser.";
         this.c18273("https://login.live.com/oauth20_authorize.srf?client_id=54fd49e4-2103-4044-9603-2b028c814ec3&response_type=code&scope=XboxLive.signin%20XboxLive.offline_access&redirect_uri=http://localhost:59125&prompt=select_account");
         this.c20834.c63595((var1, var2) -> {
            this.c50394 = String.format(var1, var2);
         }, "You can close this window.").whenComplete((var1, var2) -> {
            if (this.mc.currentScreen == this) {
               this.mc.addScheduledTask(() -> {
                  this.mc.displayGuiScreen(new GuiCancellableScreen(() -> {
                     this.mc.displayGuiScreen(this.c60631);
                  }, EnumChatFormatting.RED + "An error has occurred.", String.valueOf(var2)));
               });
            }
         });
      });
   }

   private void c18273(String var1) {
      try {
         Desktop.getDesktop().browse(new URI(var1));
      } catch (Throwable var3) {
         Sys.openURL(var1);
      }

   }

   // $FF: synthetic method
   private void c89306(MicrosoftAccount var1) {
      this.c52934.accept(var1);
      this.mc.displayGuiScreen(this.c60631);
   }

   // $FF: synthetic method
   private void c60357() {
      this.mc.displayGuiScreen(this.c60631);
   }

   private static Exception c26131(Exception var0) {
      return var0;
   }
}
