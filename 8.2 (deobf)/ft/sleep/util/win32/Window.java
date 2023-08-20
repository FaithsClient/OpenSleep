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

public class Window {
   public ModuleType isolated$;
   public ArrayList loved$ = Lists.newArrayList();
   public boolean isaac$;
   public boolean chris$;
   public int alert$;
   public int louise$;
   public int incoming$;
   public int whole$;
   public int consoles$;
   public int disaster$;
   public int density$;
   public int peaceful$;
   public double murray$;
   public int problem$;
   public int expand$;
   public int nothing$;

   public Window(ModuleType layuriza, int bananeli, int amufebey) {
      obudener.isolated$ = (ModuleType)layuriza;
      obudener.alert$ = (int)bananeli;
      obudener.louise$ = (int)amufebey;
      obudener.disaster$ = 120;
      Object ureyurop = amufebey + 25;

      for(Object pumiriba : ModuleManager._trick()) {
         if (pumiriba._bennett() == layuriza) {
            obudener.loved$.add(new Button3((ModuleType)layuriza, pumiriba, bananeli + 5, ureyurop));
            ureyurop += 15;
         }
      }

      for(Object var8 : obudener.loved$) {
         var8._pencil(obudener);
      }

   }

   public void _turkish(int edoguren, int eyacucir) {
      Object ofigupus = 0;
      Object upifasod = fasarabo.louise$ + 20;
      fasarabo.expand$ = 15;

      for(Object azivorul : fasarabo.loved$) {
         azivorul.applying$ = upifasod - fasarabo.nothing$;
         upifasod += 15;
         fasarabo.expand$ += 15;
         if (azivorul.lawyer$) {
            for(Object vusanudu : azivorul.culture$) {
               ofigupus += 15;
               fasarabo.expand$ += 15;
            }
         }

         ofigupus += 15;
      }

      Object var10 = 15 + ofigupus;
      if (var10 > 316) {
         var10 = 316;
      }

      if (fasarabo.chris$) {
         fasarabo.incoming$ = var10;
         fasarabo.murray$ = 180.0D;
      } else {
         fasarabo.incoming$ = 0;
         fasarabo.murray$ = Double.longBitsToDouble(0L);
      }

      Object var11 = edoguren > fasarabo.alert$ - 2 && edoguren < fasarabo.alert$ + 92 && eyacucir > fasarabo.louise$ - 2 && eyacucir < fasarabo.louise$ + fasarabo.incoming$;
      if (var11) {
         fasarabo._tours(var10);
      }

      if (fasarabo.isolated$.name().equals("Combat")) {
         fasarabo.problem$ = (new Color(225, 25, 25)).getRGB();
      } else if (fasarabo.isolated$.name().equals("Render")) {
         fasarabo.problem$ = (new Color(38, 160, 255)).getRGB();
      } else if (fasarabo.isolated$.name().equals("Movement")) {
         fasarabo.problem$ = (new Color(0, 150, 120)).getRGB();
      } else if (fasarabo.isolated$.name().equals("Player")) {
         fasarabo.problem$ = (new Color(128, 0, 128)).getRGB();
      } else if (fasarabo.isolated$.name().equals("Legit")) {
         fasarabo.problem$ = (new Color(255, 140, 205)).getRGB();
      }

      if (fasarabo.incoming$ > 0) {
         RenderUtil5._botswana((double)fasarabo.alert$ - 0.5D, (double)fasarabo.louise$ - 0.5D, (double)fasarabo.alert$ + 90.5D, (double)fasarabo.louise$ + 1.5D + (double)fasarabo.incoming$, 1.0D, fasarabo.problem$, fasarabo.problem$);
         RenderUtil5._botswana((double)fasarabo.alert$, (double)fasarabo.louise$, (double)(fasarabo.alert$ + 90), (double)fasarabo.louise$ + 1.0D + (double)fasarabo.incoming$, 1.0D, (new Color(39, 39, 39)).getRGB(), (new Color(39, 39, 39)).getRGB());
      }

      RenderUtil5._wooden((double)fasarabo.alert$, (double)fasarabo.louise$, (double)(fasarabo.alert$ + 90), (double)(fasarabo.louise$ + 17), (new Color(25, 25, 25)).getRGB(), (new Color(25, 25, 25)).getRGB());
      new ScaledResolution(Minecraft.getMinecraft());
      if (fasarabo.isolated$.name().equals("Combat")) {
         FontLoaders.TahomaBold14.drawStringWithShadow("combat", (double)(fasarabo.alert$ + 3), (double)(fasarabo.louise$ + 6), (new Color(220, 220, 220)).getRGB());
         FontLoaders.logog18.drawString("D", (float)(fasarabo.alert$ + 80), (float)(fasarabo.louise$ + 7), -1);
      }

      if (fasarabo.isolated$.name().equals("Render")) {
         FontLoaders.TahomaBold14.drawStringWithShadow("visual", (double)(fasarabo.alert$ + 3), (double)(fasarabo.louise$ + 6), (new Color(220, 220, 220)).getRGB());
         FontLoaders.logog18.drawString("C", (float)(fasarabo.alert$ + 79), (float)(fasarabo.louise$ + 7), -1);
      }

      if (fasarabo.isolated$.name().equals("Movement")) {
         FontLoaders.TahomaBold14.drawStringWithShadow("movement", (double)(fasarabo.alert$ + 3), (double)(fasarabo.louise$ + 6), (new Color(220, 220, 220)).getRGB());
         FontLoaders.logog18.drawString("A", (float)(fasarabo.alert$ + 80), (float)(fasarabo.louise$ + 7), -1);
      }

      if (fasarabo.isolated$.name().equals("Player")) {
         FontLoaders.TahomaBold14.drawStringWithShadow("player", (double)(fasarabo.alert$ + 3), (double)(fasarabo.louise$ + 6), (new Color(220, 220, 220)).getRGB());
         FontLoaders.logog18.drawString("B", (float)(fasarabo.alert$ + 80), (float)(fasarabo.louise$ + 7), -1);
      }

      if (fasarabo.isolated$.name().equals("Legit")) {
         FontLoaders.TahomaBold14.drawStringWithShadow("ghost", (double)(fasarabo.alert$ + 3), (double)(fasarabo.louise$ + 6), (new Color(220, 220, 220)).getRGB());
         FontLoaders.logog18.drawString("K", (float)(fasarabo.alert$ + 80), (float)(fasarabo.louise$ + 7), -1);
      }

      if (fasarabo.incoming$ > 0) {
         for(Object ifetireg : fasarabo.loved$) {
            ifetireg._fathers((int)edoguren, (int)eyacucir, new Limitation2(fasarabo.alert$, fasarabo.louise$ + 16, fasarabo.alert$ + 90, fasarabo.louise$ + fasarabo.incoming$));
         }
      }

      if (fasarabo.isaac$) {
         if (!Mouse.isButtonDown(0)) {
            fasarabo.isaac$ = false;
         }

         fasarabo.alert$ = edoguren - fasarabo.whole$;
         fasarabo.louise$ = eyacucir - fasarabo.consoles$;
         ((Button3)fasarabo.loved$.get(0)).applying$ = fasarabo.louise$ + 22 - fasarabo.nothing$;

         for(Object var14 : fasarabo.loved$) {
            var14.percent$ = fasarabo.alert$ + 5;
         }
      }

   }

   public static void _eagles(int eclipse, int endif, int dancing, int mature) {
      Object counting = Minecraft.getMinecraft();
      Object hosts = 1;
      Object encoding = counting.gameSettings.guiScale;
      if (encoding == 0) {
         encoding = 1000;
      }

      while(hosts < encoding && counting.displayWidth / (hosts + 1) >= 320 && counting.displayHeight / (hosts + 1) >= 240) {
         ++hosts;
      }

      GL11.glScissor(eclipse * hosts, counting.displayHeight - (endif + mature) * hosts, dancing * hosts, mature * hosts);
   }

   public void _tours(int pills) {
      if (Mouse.hasWheel()) {
         Object comedy = Mouse.getDWheel();
         if (roster.expand$ - pills <= 0) {
            return;
         }

         if (comedy < 0) {
            if (roster.nothing$ < roster.expand$ - pills) {
               roster.nothing$ += 20;
               if (roster.nothing$ < 0) {
                  roster.nothing$ = 0;
               }
            }
         } else if (comedy > 0) {
            roster.nothing$ -= 20;
            if (roster.nothing$ < 0) {
               roster.nothing$ = 0;
            }
         }
      }

   }

   public void _emily(char eyarenis, int asecevus) {
      enamudab.loved$.forEach(Window::_member);
   }

   public void _revenge(int refund, int diamonds, int grounds) {
      if (refund > analog.alert$ - 2 && refund < analog.alert$ + 92 && diamonds > analog.louise$ - 2 && diamonds < analog.louise$ + 17 + analog.incoming$) {
         analog.peaceful$ = (int)((float)analog.peaceful$ - (float)(grounds / 120 * 28));
      }

   }

   public void _athletes(int isifafim, int mopezice, int yizodebo) {
      if (isifafim > cugeyepo.alert$ - 2 && isifafim < cugeyepo.alert$ + 92 && mopezice > cugeyepo.louise$ - 2 && mopezice < cugeyepo.louise$ + 17) {
         if (yizodebo == 1) {
            boolean var4 = cugeyepo.chris$ = !cugeyepo.chris$;
         }

         if (yizodebo == 0) {
            cugeyepo.isaac$ = true;
            cugeyepo.whole$ = isifafim - cugeyepo.alert$;
            cugeyepo.consoles$ = mopezice - cugeyepo.louise$;
         }
      }

      if (cugeyepo.chris$) {
         cugeyepo.loved$.stream().filter(cugeyepo::_sodium).forEach(Window::_simon);
      }

   }

   public static void _simon(int ogalofey, int defepuga, int diyotige, Button3 isupicuz) {
      ((Button3)isupicuz)._alfred((int)ogalofey, (int)defepuga, (int)diyotige);
   }

   public boolean _sodium(Button3 unknown) {
      return ((Button3)unknown).applying$ < officer.louise$ + officer.incoming$;
   }

   public static void _member(char obidodob, int etileduy, Button3 lotegire) {
      ((Button3)lotegire)._debug((char)obidodob, (int)etileduy);
   }
}
