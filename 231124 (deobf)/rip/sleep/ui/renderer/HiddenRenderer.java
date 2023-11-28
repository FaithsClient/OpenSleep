package rip.sleep.ui.renderer;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.Frame;
import rip.sleep.util.RenderUtilC;
import rip.sleep.value.Value;

public class HiddenRenderer extends ModuleRenderer {
   public Module c2433;
   public double c79316 = 0.0D;
   public boolean c89793;
   public ModuleType c16617;

   public HiddenRenderer(ModuleType var1, Module var2, int var3, int var4) {
      super(var1, (Value)null, var3, var4);
      this.c16617 = var1;
      this.c31377 = true;
      this.c89793 = false;
      this.c2433 = var2;
   }

   public void c74493(int var1, int var2, Frame var3) {
      Value.c27574();
      GL11.glEnable(3089);
      var3.c94845();
      Gui.drawRect(0, 0, 0, 0, 0);
      Gui.drawRect(this.c20520 - 9, this.c61951 - 2, this.c20520 + 90, this.c61951 + 13, (new Color(5, 5, 5, 110)).getRGB());
      RenderUtilC.c32834((double)(this.c20520 + 4), (double)this.c61951 + 2.5D, (double)this.c20520 + 3.5D, (double)this.c61951 + 10.5D, (new Color(180, 180, 180)).getRGB());
      RenderUtilC.c32834((double)(this.c20520 - 6), (double)this.c61951 + 2.5D, (double)this.c20520 - 5.5D, (double)this.c61951 + 10.5D, (new Color(180, 180, 180)).getRGB());
      RenderUtilC.c32834((double)(this.c20520 - 6), (double)this.c61951 + 2.5D, (double)(this.c20520 + 4), (double)(this.c61951 + 2), (new Color(180, 180, 180)).getRGB());
      RenderUtilC.c32834((double)(this.c20520 - 6), (double)(this.c61951 + 11), (double)(this.c20520 + 4), (double)this.c61951 + 10.5D, (new Color(180, 180, 180)).getRGB());
      if (this.c2433.c41971()) {
         FontManager.c60037.c17470("v", (double)this.c20520 + 3.5D - (double) FontManager.c60037.c65036("v"), (double)this.c61951 + 4.5D, (new Color(255, 255, 255)).getRGB());
      }

      FontManager.c43464.c17470("Hidden", (double)(this.c20520 + 5), (double)((float)this.c61951 + 4.5F), (new Color(180, 180, 180)).getRGB());
      GL11.glDisable(3089);
   }

   public void c35654(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var1 > this.c20520 - 7 && var1 < this.c20520 + 1 && var2 > this.c61951 + 2 && var2 < this.c61951 + FontManager.c54334.c25901(this.c2433.getName()) + 6 && var3 == 0) {
         this.c2433.c68609(!this.c2433.c41971());
      }

      super.c35654(var1, var2, var3);
   }

   private static JSONException c90475(JSONException var0) {
      return var0;
   }
}
