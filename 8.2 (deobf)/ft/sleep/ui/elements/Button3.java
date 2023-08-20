//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import com.google.common.collect.Lists;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.ArrayList;

import ft.sleep.util.win32.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class Button3 {
   public Module chorus$;
   public Window gambling$;
   public int percent$;
   public int applying$;
   public int carmen$;
   public int incurred$;
   public int asian$;
   public int think$;
   public int geometry$;
   public double manager$ = Double.longBitsToDouble(0L);
   public ArrayList culture$ = Lists.newArrayList();
   public boolean lawyer$;
   public int crucial$;
   public ModuleType investor$;

   public Button3(ModuleType ebevunig, Module miditomo, int mepiculi, int ridefinu) {
      eyigufim.investor$ = (ModuleType)ebevunig;
      eyigufim.chorus$ = (Module)miditomo;
      eyigufim.percent$ = (int)mepiculi;
      eyigufim.applying$ = (int)ridefinu;
      Object vunilemu = ridefinu + 15;
      eyigufim.geometry$ = 0;

      for(Object samovobe : ((Module)miditomo)._exciting()) {
         eyigufim.culture$.add(new ValueButton2((ModuleType)ebevunig, samovobe, mepiculi + 5, vunilemu));
         vunilemu += 18;
      }

      if (miditomo == ModuleManager._herbs(HUD.class)) {
         eyigufim.culture$.add(new ColorValueButton2((ModuleType)ebevunig, mepiculi + 15, vunilemu));
      }

      eyigufim.culture$.add(new KeyBindButton((ModuleType)ebevunig, (Module)miditomo, mepiculi + 5, vunilemu));
      eyigufim.culture$.add(new HideButton2((ModuleType)ebevunig, (Module)miditomo, mepiculi + 5, vunilemu));
   }

   public static void _bunny(int enrolled, int divided, int strings, int genetic) {
      Object quest = Minecraft.getMinecraft();
      Object attacks = 1;
      Object schedule = quest.gameSettings.guiScale;
      if (schedule == 0) {
         schedule = 1000;
      }

      while(attacks < schedule && quest.displayWidth / (attacks + 1) >= 320 && quest.displayHeight / (attacks + 1) >= 240) {
         ++attacks;
      }

      GL11.glScissor(enrolled * attacks, quest.displayHeight - (divided + genetic) * attacks, strings * attacks, genetic * attacks);
   }

   public void _fathers(int olazuguz, int ozabepid, Limitation2 dabeloyu) {
      if (ipudupig.asian$ != 0) {
         Object efedacig = (Button3)ipudupig.gambling$.loved$.get(ipudupig.asian$ - 1);
         ipudupig.applying$ = efedacig.applying$ + 15 + (efedacig.lawyer$ ? 15 * efedacig.culture$.size() : 0);
      }

      for(Object var5 = 0; var5 < ipudupig.culture$.size(); ++var5) {
         ((ValueButton2)ipudupig.culture$.get(var5)).formed$ = ipudupig.applying$ + 14 + 15 * var5;
         ((ValueButton2)ipudupig.culture$.get(var5)).dozen$ = ipudupig.percent$ + 5;
      }

      if (ipudupig.gambling$.isolated$.name().equals("Combat")) {
         ipudupig.crucial$ = (new Color(225, 25, 25)).getRGB();
      } else if (ipudupig.gambling$.isolated$.name().equals("Render")) {
         ipudupig.crucial$ = (new Color(38, 160, 255)).getRGB();
      } else if (ipudupig.gambling$.isolated$.name().equals("Movement")) {
         ipudupig.crucial$ = (new Color(0, 150, 120)).getRGB();
      } else if (ipudupig.gambling$.isolated$.name().equals("Player")) {
         ipudupig.crucial$ = (new Color(128, 0, 128)).getRGB();
      } else if (ipudupig.gambling$.isolated$.name().equals("Legit")) {
         ipudupig.crucial$ = (new Color(255, 140, 205)).getRGB();
      }

      GL11.glPushMatrix();
      GL11.glEnable(3089);
      _bunny(ipudupig.percent$ - 5, ipudupig.applying$ - 5, 90, FontLoaders.TahomaBold13.getStringHeight(ipudupig.chorus$._skirt().toLowerCase()) + 5);
      ((Limitation2)dabeloyu)._singer();
      Gui.drawRect(ipudupig.percent$ - 5, ipudupig.applying$ - 5, ipudupig.percent$ + 85, ipudupig.applying$ + 5 + FontLoaders.TahomaBold13.getStringHeight(ipudupig.chorus$._skirt().toLowerCase()), (new Color(39, 39, 39)).getRGB());
      if (ipudupig.chorus$._central()) {
         ((Limitation2)dabeloyu)._singer();
         Gui.drawRect(ipudupig.percent$ - 4, ipudupig.applying$ - 6, ipudupig.percent$ + 84, ipudupig.applying$ + 9, ipudupig.crucial$);
      }

      if (ipudupig.chorus$._central()) {
         if (ipudupig.carmen$ < 180) {
            ipudupig.carmen$ += 10;
         }

         ((Limitation2)dabeloyu)._singer();
         FontLoaders.TahomaBold13.drawStringWithShadow(ipudupig.chorus$._skirt().toLowerCase(), (double)(ipudupig.percent$ + 81 - FontLoaders.TahomaBold13.getStringWidth(ipudupig.chorus$._skirt().toLowerCase())), (double)(ipudupig.applying$ + 1), (new Color(220, 220, 220)).getRGB());
      } else {
         if (ipudupig.carmen$ > 0) {
            ipudupig.carmen$ -= 10;
         }

         ((Limitation2)dabeloyu)._singer();
         FontLoaders.TahomaBold13.drawStringWithShadow(ipudupig.chorus$._skirt().toLowerCase(), (double)(ipudupig.percent$ + 81 - FontLoaders.TahomaBold13.getStringWidth(ipudupig.chorus$._skirt().toLowerCase())), (double)(ipudupig.applying$ + 1), (new Color(220, 220, 220)).getRGB());
      }

      if (ipudupig.chorus$._exciting().size() > 0) {
         GlStateManager.pushMatrix();
         GlStateManager.translate((float)(ipudupig.percent$ + 78), (float)(ipudupig.applying$ + 2), Float.intBitsToFloat(0));
         GlStateManager.rotate((float)ipudupig.incurred$, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
         if (ipudupig.lawyer$ && ipudupig.incurred$ < 180) {
            ipudupig.incurred$ += 10;
         } else if (!ipudupig.lawyer$ && ipudupig.incurred$ > 0) {
            ipudupig.incurred$ -= 10;
         }

         GlStateManager.translate((float)(-(ipudupig.percent$ + 78)), (float)(-(ipudupig.applying$ + 2)), Float.intBitsToFloat(0));
         GlStateManager.popMatrix();
      }

      GL11.glDisable(3089);
      GL11.glPopMatrix();
      if (ipudupig.lawyer$) {
         ipudupig.culture$.forEach(Button3::_classics);
      }

   }

   public void _debug(char slowly, int herbs) {
      pursuant.culture$.forEach(Button3::_boutique);
   }

   public boolean _urgent(int oviziler, int amiralir) {
      Object namitosa = oviziler >= uzeyefog.percent$ && oviziler <= uzeyefog.percent$ - 7 && amiralir >= uzeyefog.applying$ && amiralir <= uzeyefog.applying$ + FontLoaders.clickgui16.getStringHeight(uzeyefog.chorus$._skirt());
      return namitosa;
   }

   public void _alfred(int odepidob, int moyefiyi, int atazoyuc) {
      if (odepidob > ipiruzez.percent$ - 7 && odepidob < ipiruzez.percent$ + 85 && moyefiyi > ipiruzez.applying$ - 6 && moyefiyi < ipiruzez.applying$ + FontLoaders.clickgui16.getStringHeight(ipiruzez.chorus$._skirt())) {
         if (atazoyuc == 0) {
            ipiruzez.chorus$._serial(!ipiruzez.chorus$._central());
         }

         if (atazoyuc == 1 && !ipiruzez.culture$.isEmpty()) {
            boolean var4 = ipiruzez.lawyer$ = !ipiruzez.lawyer$;
         }

         if (atazoyuc == 2) {
            ipiruzez.chorus$._bosnia(!ipiruzez.chorus$._wishlist());
         }
      }

      if (ipiruzez.lawyer$) {
         ipiruzez.culture$.forEach(Button3::_folder);
      }

   }

   public void _pencil(Window griffin) {
      throwing.gambling$ = (Window)griffin;

      for(Object keeping = 0; keeping < throwing.gambling$.loved$.size(); ++keeping) {
         if (throwing.gambling$.loved$.get(keeping) == throwing) {
            throwing.asian$ = keeping;
            throwing.think$ = throwing.gambling$.loved$.size() - keeping;
            break;
         }
      }

   }

   public static void _folder(int oyozayiv, int fominiva, int igafefaf, ValueButton2 yatipoye) {
      ((ValueButton2)yatipoye)._warcraft((int)oyozayiv, (int)fominiva, (int)igafefaf);
   }

   public static void _boutique(char guzidugu, int lugenosi, ValueButton2 vurasano) {
      ((ValueButton2)vurasano)._replaced((char)guzidugu, (int)lugenosi);
   }

   public static void _classics(int extras, int served, Limitation2 ratio, ValueButton2 ringtone) {
      ((ValueButton2)ringtone)._workshop((int)extras, (int)served, (Limitation2)ratio);
   }
}
