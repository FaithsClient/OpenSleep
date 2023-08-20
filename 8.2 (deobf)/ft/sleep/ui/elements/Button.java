//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import com.google.common.collect.Lists;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.ArrayList;

import ft.sleep.util.win32.Window2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class Button {
   public Module policy$;
   public Window2 patterns$;
   public int horses$;
   public int often$;
   public int sheer$;
   public int targets$;
   public int sexual$;
   public int combines$;
   public int frozen$;
   public double damaged$ = Double.longBitsToDouble(0L);
   public ArrayList perry$ = Lists.newArrayList();
   public boolean showing$;
   public int lately$;
   public ModuleType arrives$;

   public Button(ModuleType weird, Module targeted, int weapon, int method) {
      mouse.arrives$ = (ModuleType)weird;
      mouse.policy$ = (Module)targeted;
      mouse.horses$ = (int)weapon;
      mouse.often$ = (int)method;
      Object client = method + 15;
      mouse.frozen$ = 0;
      mouse.perry$.add(new HideButton((ModuleType)weird, (Module)targeted, weapon + 5, client));
      mouse.perry$.add(new KeyBindButton2((ModuleType)weird, (Module)targeted, weapon + 5, client));

      for(Object musical : ((Module)targeted)._exciting()) {
         mouse.perry$.add(new ValueButton((ModuleType)weird, musical, weapon + 5, client));
         client += 20;
      }

   }

   public static void _estates(int capable, int alike, int mails, int eastern) {
      Object declined = Minecraft.getMinecraft();
      Object compete = 1;
      Object bedding = declined.gameSettings.guiScale;
      if (bedding == 0) {
         bedding = 1000;
      }

      while(compete < bedding && declined.displayWidth / (compete + 1) >= 320 && declined.displayHeight / (compete + 1) >= 240) {
         ++compete;
      }

      GL11.glScissor(capable * compete, declined.displayHeight - (alike + eastern) * compete, mails * compete, eastern * compete);
   }

   public void _center(int besuzuli, int anoriciv, Limitation umizisub) {
      if (ulilifed.sexual$ != 0) {
         Object esapucug = (Button)ulilifed.patterns$.removing$.get(ulilifed.sexual$ - 1);
         ulilifed.often$ = esapucug.often$ + 15 + (esapucug.showing$ ? 15 * esapucug.perry$.size() : 0);
      }

      for(Object var6 = 0; var6 < ulilifed.perry$.size(); ++var6) {
         ((ValueButton)ulilifed.perry$.get(var6)).nikon$ = ulilifed.often$ + 14 + 15 * var6;
         ((ValueButton)ulilifed.perry$.get(var6)).inkjet$ = ulilifed.horses$ + 5;
      }

      if (ulilifed.patterns$.combo$.name().equals("Combat")) {
         ulilifed.lately$ = (new Color(231, 76, 60)).getRGB();
      } else if (ulilifed.patterns$.combo$.name().equals("Render")) {
         ulilifed.lately$ = (new Color(54, 1, 205)).getRGB();
      } else if (ulilifed.patterns$.combo$.name().equals("Movement")) {
         ulilifed.lately$ = (new Color(45, 203, 113)).getRGB();
      } else if (ulilifed.patterns$.combo$.name().equals("Player")) {
         ulilifed.lately$ = (new Color(141, 68, 173)).getRGB();
      } else if (ulilifed.patterns$.combo$.name().equals("Ghost")) {
         ulilifed.lately$ = (new Color(38, 154, 255)).getRGB();
      }

      GL11.glPushMatrix();
      GL11.glEnable(3089);
      _estates(ulilifed.horses$ - 5, ulilifed.often$ - 5, 90, FontLoaders.kiona14.getStringHeight(ulilifed.policy$._skirt()) + 5);
      ((Limitation)umizisub)._array();
      Gui.drawRect(ulilifed.horses$ - 4, ulilifed.often$ - 3, ulilifed.horses$ + 95, ulilifed.often$ + 7 + FontLoaders.kiona14.getStringHeight(ulilifed.policy$._skirt()), (new Color(5, 5, 5, 110)).getRGB());
      if (ulilifed.policy$._central()) {
         ((Limitation)umizisub)._array();
      }

      if (ulilifed.policy$._central()) {
         if (ulilifed.sheer$ < 180) {
            ulilifed.sheer$ += 10;
         }

         ((Limitation)umizisub)._array();
         FontLoaders.kiona14.drawStringWithShadow(ulilifed.policy$._skirt(), (double)(ulilifed.horses$ - 2), (double)(ulilifed.often$ + 3), (new Color(255, 255, 255)).getRGB());
         if (!ulilifed.showing$) {
            FontLoaders.logo10.drawStringWithShadow("h", (double)(ulilifed.horses$ + 91 - FontLoaders.logo10.getStringWidth("h")), (double)(ulilifed.often$ + 4), (new Color(255, 255, 255)).getRGB());
         } else {
            FontLoaders.logo10.drawStringWithShadow("i", (double)(ulilifed.horses$ + 91 - FontLoaders.logo10.getStringWidth("i")), (double)(ulilifed.often$ + 5), (new Color(255, 255, 255)).getRGB());
         }
      } else {
         if (ulilifed.sheer$ > 0) {
            ulilifed.sheer$ -= 10;
         }

         ((Limitation)umizisub)._array();
         GlStateManager.pushMatrix();
         float var5 = 0.5F;
         FontLoaders.kiona14.drawStringWithShadow(ulilifed.policy$._skirt(), (double)(ulilifed.horses$ - 2), (double)(ulilifed.often$ + 3), (new Color(180, 180, 180)).getRGB());
         if (!ulilifed.showing$) {
            FontLoaders.logo10.drawStringWithShadow("h", (double)(ulilifed.horses$ + 91 - FontLoaders.logo10.getStringWidth("h")), (double)(ulilifed.often$ + 5), (new Color(255, 255, 255)).getRGB());
         } else {
            FontLoaders.logo10.drawStringWithShadow("i", (double)(ulilifed.horses$ + 91 - FontLoaders.logo10.getStringWidth("i")), (double)(ulilifed.often$ + 5), (new Color(255, 255, 255)).getRGB());
         }

         GlStateManager.popMatrix();
      }

      GL11.glDisable(3089);
      GL11.glPopMatrix();
      if (ulilifed.showing$) {
         ulilifed.perry$.forEach(Button::_timing);
      }

   }

   public void _creator(char index, int lanes) {
      spain.perry$.forEach(Button::_embedded);
   }

   public boolean _readily(int unetorul, int apiyizit) {
      Object pirurolu = unetorul >= icocugaz.horses$ && unetorul <= icocugaz.horses$ - 7 && apiyizit >= icocugaz.often$ && apiyizit <= icocugaz.often$ + FontLoaders.kiona18.getStringHeight(icocugaz.policy$._skirt());
      return pirurolu;
   }

   public void _specific(int capitoyu, int doyacisa, int opumovas) {
      if (capitoyu > meneboca.horses$ - 7 && capitoyu < meneboca.horses$ + 85 && doyacisa > meneboca.often$ - 6 && doyacisa < meneboca.often$ + FontLoaders.kiona18.getStringHeight(meneboca.policy$._skirt())) {
         if (opumovas == 0) {
            meneboca.policy$._serial(!meneboca.policy$._central());
         }

         if (opumovas == 1 && !meneboca.perry$.isEmpty()) {
            boolean var4 = meneboca.showing$ = !meneboca.showing$;
         }

         if (opumovas == 2) {
            meneboca.policy$._bosnia(!meneboca.policy$._wishlist());
         }
      }

      if (meneboca.showing$) {
         meneboca.perry$.forEach(Button::_ratio);
      }

   }

   public void _birds(Window2 accepts) {
      coaching.patterns$ = (Window2)accepts;

      for(Object steven = 0; steven < coaching.patterns$.removing$.size(); ++steven) {
         if (coaching.patterns$.removing$.get(steven) == coaching) {
            coaching.sexual$ = steven;
            coaching.combines$ = coaching.patterns$.removing$.size() - steven;
            break;
         }
      }

   }

   public static void _ratio(int mozilla, int brain, int tiles, ValueButton humor) {
      ((ValueButton)humor)._google((int)mozilla, (int)brain, (int)tiles);
   }

   public static void _embedded(char acovasaf, int arilagoz, ValueButton gavesudo) {
      ((ValueButton)gavesudo)._warner((char)acovasaf, (int)arilagoz);
   }

   public static void _timing(int lafipode, int efasegoy, Limitation otecerus, ValueButton ranugaso) {
      ((ValueButton)ranugaso)._oxygen((int)lafipode, (int)efasegoy, (Limitation)otecerus);
   }
}
