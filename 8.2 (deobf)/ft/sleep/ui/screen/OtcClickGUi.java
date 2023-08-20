//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import ft.sleep.module.ModuleType;
import ft.sleep.module.modules.HUD;
import ft.sleep.ui.elements.OtcScroll;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ft.sleep.util.render.RenderUtil4;
import ft.sleep.util.render.RoundedUtil;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class OtcClickGUi extends GuiScreen {
   public float awful$ = 320.0F;
   public float firefox$ = Float.intBitsToFloat(0);
   public float howto$ = 130.0F;
   public float easier$ = 120.0F;
   public int hydrogen$;
   public int enables$;
   public boolean thomas$;
   public List pixel$ = new ArrayList();

   public int ____/* $FF was: î ”î ”î ‘î ”*/() {
      return super.height * 2;
   }

   public OtcClickGUi() {
      for(Object tampa : ModuleType.values()) {
         engineer.pixel$.add(new CategoryScreen(tampa, engineer.firefox$));
         engineer.firefox$ += (float)(FontLoaders.TahomaBold13.getStringWidth(engineer.î ?(tampa)) + 10);
      }

   }

   public String _/* $FF was: î ?*/(ModuleType workout) {
      if (((ModuleType)workout).name().equals("Combat")) {
         return "combat";
      } else if (((ModuleType)workout).name().equals("Player")) {
         return "player";
      } else if (((ModuleType)workout).name().equals("Movement")) {
         return "move";
      } else if (((ModuleType)workout).name().equals("Render")) {
         return "visuals";
      } else if (((ModuleType)workout).name().equals("World")) {
         return "world";
      } else if (((ModuleType)workout).name().equals("Misc")) {
         return "misc";
      } else {
         return ((ModuleType)workout).name().equals("Exploit") ? "exploit" : "";
      }
   }

   public void initGui() {
      super.initGui();
   }

   public void drawScreen(int viewer, int spent, float writing) {
      if (dylan.thomas$) {
         dylan.awful$ = (float)(dylan.hydrogen$ + viewer);
         dylan.howto$ = (float)(dylan.enables$ + spent);
      }

      Object ordering = HUD.during$.getHSB();
      Object discs = Color.getHSBColor(ordering[0], ordering[1], 0.5F);
      Object motels = new ScaledResolution(dylan.mc);
      RenderUtil4._oakland(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)motels.getScaledWidth(), (double)motels.getScaledHeight(), (new Color(0, 0, 0, 120)).getRGB());
      RoundedUtil._ticket(dylan.awful$, dylan.howto$, 290.0F, dylan.easier$ + 180.0F, 3.0F, new Color(44, 47, 56));
      RoundedUtil._ticket(dylan.awful$, dylan.howto$ - 25.0F, 290.0F, dylan.easier$ - 100.0F, 3.0F, new Color(44, 47, 56));
      RoundedUtil._animal(dylan.awful$ - 1.0F, dylan.howto$ - 28.0F, 292.0F, dylan.easier$ - 118.0F, 3.0F, discs, new Color(HUD.during$.getValue().intValue()));
      FontLoaders.TahomaBold18.drawString("onetap.su", dylan.awful$ + 11.0F, dylan.howto$ - 20.0F, (new Color(255, 255, 255)).getRGB());
      RoundedUtil._ticket(dylan.awful$ + 64.0F, dylan.howto$ - 23.0F, 0.5F, dylan.easier$ - 105.0F, 1.0F, new Color(255, 255, 255, 150));
      Object trustee = dylan.î ?();
      if (trustee == null) {
         FontLoaders.TahomaBold18.drawString("-------------------", (float)((int)dylan.awful$ + 109), (float)((int)dylan.howto$ + 40), (new Color(255, 255, 255)).getRGB());
         FontLoaders.TahomaBold18.drawString("  Select one of", (float)((int)dylan.awful$ + 109), (float)((int)dylan.howto$ + 50), (new Color(255, 255, 255)).getRGB());
         FontLoaders.TahomaBold18.drawString("-------------------", (float)((int)dylan.awful$ + 109), (float)((int)dylan.howto$ + 60), (new Color(255, 255, 255)).getRGB());
      }

      dylan.pixel$.forEach(OtcClickGUi::î ?);
      super.drawScreen((int)viewer, (int)spent, (float)writing);
   }

   public void mouseClicked(int alimovat, int alecutut, int elosoved) throws IOException {
      if (elosoved == 0) {
         for(Object igucubel : gonazesa.pixel$) {
            if (igucubel._thompson((int)alimovat, (int)alecutut)) {
               for(Object maguyima : gonazesa.pixel$) {
                  maguyima._divide(false);
               }

               igucubel._divide(true);
            }
         }
      }

      if (gonazesa.î ?((int)alimovat, (int)alecutut)) {
         gonazesa.hydrogen$ = (int)(gonazesa.awful$ - (float)alimovat);
         gonazesa.enables$ = (int)(gonazesa.howto$ - (float)alecutut);
         gonazesa.thomas$ = true;
      }

      Object var8 = gonazesa.î ?();
      if (var8 != null) {
         var8._belongs((int)alimovat, (int)alecutut, (int)elosoved);
      }

      super.mouseClicked((int)alimovat, (int)alecutut, (int)elosoved);
   }

   public CategoryScreen _/* $FF was: î ?*/() {
      return (CategoryScreen)torigeto.pixel$.stream().filter(CategoryScreen::_particle).findAny().orElse((Object)null);
   }

   public boolean _/* $FF was: î ?*/(int titisasi, int dezobiva) {
      return (float)titisasi >= safigogi.awful$ && (float)titisasi <= safigogi.awful$ + 45.0F + 105.0F + 270.0F && (float)dezobiva >= safigogi.howto$ - 30.0F && (float)dezobiva <= safigogi.howto$ - 50.0F + 45.0F;
   }

   public static OtcScroll _/* $FF was: î ?*/() {
      Object ivegagim = Mouse.getDWheel();
      if (ivegagim > 0) {
         return OtcScroll.carey$;
      } else {
         return ivegagim < 0 ? OtcScroll.standing$ : null;
      }
   }

   public void mouseReleased(int burden, int fallen, int choir) {
      if (choir == 0) {
         chubby.thomas$ = false;
      }

      chubby.pixel$.forEach(OtcClickGUi::î ?);
      super.mouseReleased((int)burden, (int)fallen, (int)choir);
   }

   public void keyTyped(char forge, int gordon) throws IOException {
      refuse.pixel$.forEach(OtcClickGUi::î ?);
      super.keyTyped((char)forge, (int)gordon);
   }

   public float ___/* $FF was: î ‘î ”î ?*/() {
      return credit.awful$;
   }

   public float ___/* $FF was: î ‘î ”î ?*/() {
      return palace.howto$;
   }

   public float ___/* $FF was: î ‘î ‘î ?*/() {
      return (float)ureyubub.hydrogen$;
   }

   public float ___/* $FF was: î ‘î ‘î ?*/() {
      return (float)ulugecey.enables$;
   }

   public int getHeight() {
      return (int)belasero.easier$;
   }

   public static void _/* $FF was: î ?*/(char nadusaba, int mobososa, CategoryScreen sitogise) {
      ((CategoryScreen)sitogise)._surprise((char)nadusaba, (int)mobososa);
   }

   public static void _/* $FF was: î ?*/(int ideal, int inbox, int presents, CategoryScreen sandy) {
      ((CategoryScreen)sandy)._samsung((int)ideal, (int)inbox, (int)presents);
   }

   public static void _/* $FF was: î ?*/(int fezafafi, int zotisutu, CategoryScreen vefubevo) {
      ((CategoryScreen)vefubevo)._worse((int)fezafafi, (int)zotisutu);
   }
}
