package rip.sleep.ui.misc;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiSelectWorld;
import rip.sleep.module.Module;
import rip.sleep.ui.element.elements.ChangeLogMenu;
import rip.sleep.ui.element.elements.InteractiveElement;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.RenderUtilA;
import rip.sleep.value.Value;

public class GuiSleepMainMenu extends GuiPanoramaScreen {
   ArrayList<InteractiveElement> c36736 = new ArrayList();
   private final InteractiveElement c54838;
   private final InteractiveElement c55126;
   private final InteractiveElement c40921;
   private final InteractiveElement c31922;

   public GuiSleepMainMenu() {
      this.c54838 = new InteractiveElement("Single Player", this.width / 2 - 75, this.height / 2);
      this.c89131(this.c54838);
      this.c55126 = new InteractiveElement("Multi Player", this.width / 2 - 75, this.height / 2 + 25);
      this.c89131(this.c55126);
      this.c31922 = new InteractiveElement("Alt Manager", this.width / 2 - 75, this.height / 2 + 50);
      this.c89131(this.c31922);
      this.c40921 = new InteractiveElement("Settings", this.width / 2 - 75, this.height / 2 + 75);
      this.c89131(this.c40921);
   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
      FontManager.c28966.c17470("", (double)(this.width - FontManager.c28966.c65036("") - 2), (double)(this.height - FontManager.c28966.c5657() - 2), (new Color(255, 255, 255)).getRGB());
      FontManager.c28966.c17470("", 3.0D, (double)(this.height - FontManager.c28966.c5657() - 2), (new Color(255, 255, 255)).getRGB());
      ChangeLogMenu.c89457();
      Value.c27574();
      int var5 = 0;
      if (var5 < this.c36736.size()) {
         InteractiveElement var6 = (InteractiveElement)this.c36736.get(var5);
         var6.c26187(var1, var2, this.width / 2 - 75, this.height / 2 + var5 * 25);
         ++var5;
      }

      this.c50441();
      this.c70916(var1, var2);
   }

   public void mouseClicked(int var1, int var2, int var3) throws IOException {
      Module[] var4 = Value.c27574();
      if (this.c54838.c35710(var1, var2)) {
         this.mc.displayGuiScreen(new GuiSelectWorld(this));
      }

      if (this.c55126.c35710(var1, var2)) {
         this.mc.displayGuiScreen(new GuiMultiplayer(this));
      }

      if (this.c40921.c35710(var1, var2)) {
         this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
      }

      if (this.c31922.c35710(var1, var2)) {
         this.mc.displayGuiScreen(new GuiAltManager());
      }

      if (RenderUtilA.c43580(this.width - 25, 5, 20, 20, var1, var2)) {
         this.mc.shutdown();
      }

      super.mouseClicked(var1, var2, var3);
   }

   private void c50441() {
      RenderUtilA.c15215(this.width / 2 - 105, this.height / 2 - 220, 250, 250, -1, "logo.png");
   }

   private void c30439() {
   }

   private void c70916(int var1, int var2) {
      Module[] var3 = Value.c27574();
      RenderUtilA.c69215(this.width - 25, 5, 20, 20, 2, RenderUtilA.c43580(this.width - 25, 5, 20, 20, var1, var2) ? 822083583 : (new Color(28, 28, 28, 120)).getRGB(), 0);
      RenderUtilA.c15215(this.width - 25, 5, 20, 20, -1, "cross.png");
   }

   private void c89131(InteractiveElement var1) {
      this.c36736.add(var1);
   }

   private static Exception c25853(Exception var0) {
      return var0;
   }
}
