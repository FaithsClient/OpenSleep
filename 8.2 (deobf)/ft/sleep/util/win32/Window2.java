//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.win32;

import com.google.common.collect.Lists;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.ArrayList;

import ft.sleep.util.render.RenderUtil5;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class Window2 {
   public ModuleType combo$;
   public ArrayList removing$ = Lists.newArrayList();
   public boolean released$;
   public boolean relief$;
   public int clearly$;
   public int fought$;
   public int carbon$;
   public int labels$;
   public int inches$;
   public int toshiba$;
   public int reforms$;
   public int females$;
   public double terror$;
   public int fairly$;
   public int sarah$;
   public int geology$;

   public Window2(ModuleType ayayogus, int tutiyavu, int gotepiga) {
      fovavupi.combo$ = (ModuleType)ayayogus;
      fovavupi.clearly$ = (int)tutiyavu;
      fovavupi.fought$ = (int)gotepiga;
      fovavupi.toshiba$ = 120;
      Object vudasala = gotepiga + 25;

      for(Object yaloribu : ModuleManager._trick()) {
         if (yaloribu._bennett() == ayayogus) {
            fovavupi.removing$.add(new Button((ModuleType)ayayogus, yaloribu, tutiyavu + 5, vudasala));
            vudasala += 15;
         }
      }

      for(Object var8 : fovavupi.removing$) {
         var8._birds(fovavupi);
      }

   }

   public void _paris(int arobeyuy, int olicumep) {
      Object ofivigil = 0;
      Object tefasedi = facoselo.fought$ + 20;
      facoselo.sarah$ = 15;

      for(Object ubevicav : facoselo.removing$) {
         ubevicav.often$ = tefasedi - facoselo.geology$;
         tefasedi += 15;
         facoselo.sarah$ += 15;
         if (ubevicav.showing$) {
            for(Object teremipu : ubevicav.perry$) {
               ofivigil += 15;
               facoselo.sarah$ += 15;
            }
         }

         ofivigil += 15;
      }

      Object var10 = 15 + ofivigil;
      if (var10 > 316) {
         var10 = 316;
      }

      if (facoselo.relief$) {
         facoselo.carbon$ = var10;
         facoselo.terror$ = 180.0D;
      } else {
         facoselo.carbon$ = 0;
         facoselo.terror$ = Double.longBitsToDouble(0L);
      }

      Object var11 = arobeyuy > facoselo.clearly$ - 2 && arobeyuy < facoselo.clearly$ + 92 && olicumep > facoselo.fought$ - 2 && olicumep < facoselo.fought$ + facoselo.carbon$;
      if (var11) {
         facoselo._checkout(var10);
      }

      if (facoselo.combo$.name().equals("Combat")) {
         facoselo.fairly$ = (new Color(231, 76, 60)).getRGB();
      } else if (facoselo.combo$.name().equals("Visual")) {
         facoselo.fairly$ = (new Color(54, 1, 205)).getRGB();
      } else if (facoselo.combo$.name().equals("Movement")) {
         facoselo.fairly$ = (new Color(45, 203, 113)).getRGB();
      } else if (facoselo.combo$.name().equals("Player")) {
         facoselo.fairly$ = (new Color(141, 68, 173)).getRGB();
      } else if (facoselo.combo$.name().equals("Other")) {
         facoselo.fairly$ = (new Color(38, 154, 255)).getRGB();
      }

      if (facoselo.carbon$ > 0) {
         ;
      }

      RenderUtil5._wooden((double)facoselo.clearly$, (double)(facoselo.fought$ + 4), (double)(facoselo.clearly$ + 101), (double)(facoselo.fought$ + 17), (new Color(255, 255, 255, 235)).getRGB(), (new Color(255, 255, 255, 235)).getRGB());
      new ScaledResolution(Minecraft.getMinecraft());
      if (facoselo.combo$.name().equals("Combat")) {
         FontLoaders.kiona16.drawStringWithShadow("Blatant", (double)(facoselo.clearly$ + 3), (double)(facoselo.fought$ + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (facoselo.combo$.name().equals("Render")) {
         FontLoaders.kiona16.drawStringWithShadow("Visual", (double)(facoselo.clearly$ + 3), (double)(facoselo.fought$ + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (facoselo.combo$.name().equals("Movement")) {
         FontLoaders.kiona16.drawStringWithShadow("Movement", (double)(facoselo.clearly$ + 3), (double)(facoselo.fought$ + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (facoselo.combo$.name().equals("Player")) {
         FontLoaders.kiona16.drawStringWithShadow("Player", (double)(facoselo.clearly$ + 3), (double)(facoselo.fought$ + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (facoselo.combo$.name().equals("Legit")) {
         FontLoaders.kiona16.drawStringWithShadow("Legit", (double)(facoselo.clearly$ + 3), (double)(facoselo.fought$ + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (facoselo.carbon$ > 0) {
         for(Object semolipe : facoselo.removing$) {
            semolipe._center((int)arobeyuy, (int)olicumep, new Limitation(facoselo.clearly$, facoselo.fought$ + 16, facoselo.clearly$ + 90, facoselo.fought$ + facoselo.carbon$));
         }
      }

      if (facoselo.released$) {
         if (!Mouse.isButtonDown(0)) {
            facoselo.released$ = false;
         }

         facoselo.clearly$ = arobeyuy - facoselo.labels$;
         facoselo.fought$ = olicumep - facoselo.inches$;
         ((Button)facoselo.removing$.get(0)).often$ = facoselo.fought$ + 22 - facoselo.geology$;

         for(Object var14 : facoselo.removing$) {
            var14.horses$ = facoselo.clearly$ + 5;
         }
      }

   }

   public static void _elderly(int surround, int sodium, int factors, int bigger) {
      Object cornell = Minecraft.getMinecraft();
      Object smile = 1;
      Object coming = cornell.gameSettings.guiScale;
      if (coming == 0) {
         coming = 1000;
      }

      while(smile < coming && cornell.displayWidth / (smile + 1) >= 320 && cornell.displayHeight / (smile + 1) >= 240) {
         ++smile;
      }

      GL11.glScissor(surround * smile, cornell.displayHeight - (sodium + bigger) * smile, factors * smile, bigger * smile);
   }

   public void _checkout(int economic) {
      if (Mouse.hasWheel()) {
         Object tahoe = Mouse.getDWheel();
         if (classic.sarah$ - economic <= 0) {
            return;
         }

         if (tahoe < 0) {
            if (classic.geology$ < classic.sarah$ - economic) {
               classic.geology$ += 20;
               if (classic.geology$ < 0) {
                  classic.geology$ = 0;
               }
            }
         } else if (tahoe > 0) {
            classic.geology$ -= 20;
            if (classic.geology$ < 0) {
               classic.geology$ = 0;
            }
         }
      }

   }

   public void _heavily(char pulling, int bradley) {
      employer.removing$.forEach(Window2::_shine);
   }

   public void _contact(int timeline, int basic, int phases) {
      if (timeline > shake.clearly$ - 2 && timeline < shake.clearly$ + 92 && basic > shake.fought$ - 2 && basic < shake.fought$ + 17 + shake.carbon$) {
         shake.females$ = (int)((float)shake.females$ - (float)(phases / 120 * 28));
      }

   }

   public void _reduces(int annual, int domestic, int radius) {
      if (annual > salaries.clearly$ - 2 && annual < salaries.clearly$ + 92 && domestic > salaries.fought$ - 2 && domestic < salaries.fought$ + 17) {
         if (radius == 1) {
            boolean var4 = salaries.relief$ = !salaries.relief$;
         }

         if (radius == 0) {
            salaries.released$ = true;
            salaries.labels$ = annual - salaries.clearly$;
            salaries.inches$ = domestic - salaries.fought$;
         }
      }

      if (salaries.relief$) {
         salaries.removing$.stream().filter(salaries::_option).forEach(Window2::_ringtone);
      }

   }

   public static void _ringtone(int vatoyaco, int ucinenag, int baticefa, Button tinepibu) {
      ((Button)tinepibu)._specific((int)vatoyaco, (int)ucinenag, (int)baticefa);
   }

   public boolean _option(Button uyodaviz) {
      return ((Button)uyodaviz).often$ < uvoriman.fought$ + uvoriman.carbon$;
   }

   public static void _shine(char otomobub, int vutegita, Button egayonur) {
      ((Button)egayonur)._creator((char)otomobub, (int)vutegita);
   }
}
