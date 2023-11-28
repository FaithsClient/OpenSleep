package rip.sleep.ui.misc;

import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class GuiCancellableScreen extends GuiScreen {
   private final Runnable c80625;
   private final String c85756;
   private final String c95317;
   private List<String> c95979;

   public GuiCancellableScreen(Runnable var1, String var2, String var3) {
      this.c80625 = var1;
      this.c85756 = var2;
      this.c95317 = var3;
   }

   public void initGui() {
      this.buttonList.add(new GuiButton(0, this.width / 2 - 50, this.height - 28, 100, 20, "Back"));
      this.c95979 = this.fontRendererObj.listFormattedStringToWidth(this.c95317, this.width - 50);
      super.initGui();
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      Module[] var2 = Value.c27574();
      if (var1.id == 0) {
         this.c80625.run();
      }

      super.actionPerformed(var1);
   }

   public void drawScreen(int var1, int var2, float var3) {
      Value.c27574();
      this.drawDefaultBackground();
      this.func_73732_a(this.fontRendererObj, this.c85756, this.width / 2, 30, -1);
      if (this.c95979 != null) {
         int var5 = 0;
         if (var5 < this.c95979.size()) {
            this.func_73732_a(this.fontRendererObj, (String)this.c95979.get(var5), this.width / 2, 50 + var5 * 10, -1);
            ++var5;
         }
      }

      super.drawScreen(var1, var2, var3);
   }

   private static Exception c994(Exception var0) {
      return var0;
   }
}
