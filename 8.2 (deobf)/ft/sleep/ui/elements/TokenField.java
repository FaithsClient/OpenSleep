//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.ui.screen.GuiTextField;
import ft.sleep.util.render.RoundedUtil;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class TokenField extends GuiTextField {
   public String aquarium$;

   public TokenField(int parozavo, FontRenderer tevonomi, int izorobon, int ocisedaz, int iyopatoc, int pebonuyi, String ivogosur) {
      super((int)parozavo, (FontRenderer)tevonomi, (int)izorobon, (int)ocisedaz, (int)iyopatoc, (int)pebonuyi);
      apivezuc.aquarium$ = (String)ivogosur;
   }

   public void ____/* $FF was: */() {
      if (ifubiven.()) {
         FontLoaders.TahomaBold18.drawString(ifubiven.aquarium$, ifubiven. - (float)FontLoaders.TahomaBold18.getStringWidth(ifubiven.aquarium$) - 5.0F, ifubiven. + 5.0F, -1);
         RoundedUtil._ticket(ifubiven., ifubiven. + 15.0F, (float)ifubiven.width, 1.0F, Float.intBitsToFloat(0), new Color(-1));
         Object volezati = ifubiven. ? ifubiven.�? : ifubiven.�?;
         Object esudeper = ifubiven.() - ifubiven.�?;
         Object sofulivi = ifubiven.() - ifubiven.�?;
         Object lacecige = FontLoaders.TahomaBold18.trimStringToWidth(ifubiven.�?().substring(ifubiven.�?), ifubiven.getWidth());
         Object ofuviral = esudeper >= 0 && esudeper <= lacecige.length();
         Object ucitaziz = ifubiven.() && ifubiven.�? / 6 % 2 == 0 && ofuviral;
         Object emesimib = ifubiven. ? (int)ifubiven. + 4 : (int)ifubiven.;
         Object rocutuga = ifubiven. ? (int)ifubiven. + (ifubiven.height - 8) / 2 : (int)ifubiven.;
         Object iguzagar = emesimib;
         if (sofulivi > lacecige.length()) {
            sofulivi = lacecige.length();
         }

         if (!lacecige.isEmpty()) {
            Object linelali = ofuviral ? lacecige.substring(0, esudeper) : lacecige;
            FontLoaders.TahomaBold18.drawString(linelali, (double)emesimib, (double)rocutuga, volezati, true);
         }

         Object var13 = ifubiven.() < ifubiven.�?().length() || ifubiven.�?().length() >= ifubiven.getMaxStringLength();
         Object afivirot = emesimib;
         if (!ofuviral) {
            afivirot = esudeper > 0 ? emesimib + ifubiven.width : emesimib;
         } else if (var13) {
            afivirot = emesimib - 1;
            iguzagar = emesimib - 1;
         }

         if (!lacecige.isEmpty() && ofuviral && esudeper < lacecige.length()) {
            FontLoaders.TahomaBold18.drawString(lacecige.substring(esudeper), (double)((float)iguzagar), (double)((float)rocutuga), volezati, true);
         }

         if (ucitaziz) {
            if (var13) {
               Gui.drawRect(afivirot, rocutuga - 1, afivirot + 1, rocutuga + 1 + ifubiven.�?.FONT_HEIGHT, -3092272);
            } else {
               FontLoaders.TahomaBold18.drawString("_", (double)((float)afivirot), (double)((float)rocutuga), volezati, true);
            }
         }

         if (sofulivi != esudeper) {
            Object rapurasi = emesimib + FontLoaders.TahomaBold18.getStringWidth(lacecige.substring(0, sofulivi));
            ifubiven.�?(afivirot, rocutuga - 1, rapurasi - 1, rocutuga + 1 + ifubiven.�?.FONT_HEIGHT);
         }
      }

   }
}
