//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.Value;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ValueButton2 {
   public Value rentals$;
   public String perform$;
   public boolean quotes$;
   public boolean sponsors$;
   public int dozen$;
   public int formed$;
   public double edited$;
   public ModuleType garden$;

   public ValueButton2(ModuleType script, Value diesel, int prophet, int celtic) {
      raise.garden$ = (ModuleType)script;
      raise.quotes$ = false;
      raise.edited$ = Double.longBitsToDouble(0L);
      raise.rentals$ = (Value)diesel;
      raise.dozen$ = (int)prophet;
      raise.formed$ = (int)celtic;
      raise.perform$ = "";
      if (raise.rentals$ instanceof Option) {
         raise.sponsors$ = ((Boolean)raise.rentals$.getValue()).booleanValue();
      } else if (raise.rentals$ instanceof Mode) {
         raise.perform$ = String.valueOf(raise.rentals$.getValue());
      } else if (diesel instanceof Numbers) {
         Object taste = (Numbers)diesel;
         raise.perform$ = raise.perform$ + (taste.isInteger() ? (double)taste.getValue().intValue() : taste.getValue().doubleValue());
      }

      raise.edited$ = Double.longBitsToDouble(0L);
   }

   public void _workshop(int eguzenel, int ifaculiz, Limitation2 zipaduci) {
      if (!enicemen.quotes$) {
         if (eguzenel > enicemen.dozen$ - 7 && eguzenel < enicemen.dozen$ + 85 && ifaculiz > enicemen.formed$ - 6 && ifaculiz < enicemen.formed$ + FontLoaders.clickgui18.getStringHeight(enicemen.rentals$.getDisplayName()) + 6) {
            if (enicemen.edited$ + 10.0D < 200.0D) {
               enicemen.edited$ += 10.0D;
            } else {
               enicemen.edited$ = 200.0D;
            }
         } else if (enicemen.edited$ - 6.0D > Double.longBitsToDouble(0L)) {
            enicemen.edited$ -= 6.0D;
         } else {
            enicemen.edited$ = Double.longBitsToDouble(0L);
         }

         if (enicemen.rentals$ instanceof Option) {
            enicemen.sponsors$ = ((Boolean)enicemen.rentals$.getValue()).booleanValue();
         } else if (enicemen.rentals$ instanceof Mode) {
            enicemen.perform$ = String.valueOf(enicemen.rentals$.getValue());
         } else if (enicemen.rentals$ instanceof Numbers) {
            Object erivotaf = (Numbers)enicemen.rentals$;
            enicemen.perform$ = String.valueOf(erivotaf.isInteger() ? (double)erivotaf.getValue().intValue() : erivotaf.getValue().doubleValue());
            if (eguzenel > enicemen.dozen$ - 7 && eguzenel < enicemen.dozen$ + 85 && ifaculiz > enicemen.formed$ + FontLoaders.clickgui14.getStringHeight(enicemen.rentals$.getDisplayName()) - 10 && ifaculiz < enicemen.formed$ + FontLoaders.clickgui14.getStringHeight(enicemen.rentals$.getDisplayName()) + 2 && Mouse.isButtonDown(0)) {
               Object ezorumur = erivotaf.getMinimum().doubleValue();
               Object fufetoru = erivotaf.getMaximum().doubleValue();
               Object miyizuya = erivotaf.getIncrement().doubleValue();
               Object odasezen = (double)eguzenel - ((double)enicemen.dozen$ + 1.0D);
               double var13 = odasezen / 68.0D;
               var13 = Math.min(Math.max(Double.longBitsToDouble(0L), var13), 1.0D);
               double var15 = (fufetoru - ezorumur) * var13;
               double var17 = ezorumur + var15;
               var17 = (double)Math.round(var17 * (1.0D / miyizuya)) / (1.0D / miyizuya);
               erivotaf.setValue(Double.valueOf(var17));
            }
         }

         int var19;
         if (enicemen.garden$.name().equals("Combat")) {
            var19 = (new Color(225, 25, 25)).getRGB();
         } else if (enicemen.garden$.name().equals("Render")) {
            var19 = (new Color(38, 160, 255)).getRGB();
         } else if (enicemen.garden$.name().equals("Movement")) {
            var19 = (new Color(0, 150, 120)).getRGB();
         } else if (enicemen.garden$.name().equals("Player")) {
            var19 = (new Color(128, 0, 128)).getRGB();
         } else if (enicemen.garden$.name().equals("Legit")) {
            var19 = (new Color(255, 140, 205)).getRGB();
         } else {
            var19 = (new Color(38, 154, 255)).getRGB();
         }

         GL11.glEnable(3089);
         ((Limitation2)zipaduci)._singer();
         Gui.drawRect(enicemen.dozen$ - 10, enicemen.formed$ - 4, enicemen.dozen$ + 80, enicemen.formed$ + 11, (new Color(39, 39, 39)).getRGB());
         if (enicemen.rentals$ instanceof Option) {
            FontLoaders.TahomaBold13.drawStringWithShadow(enicemen.rentals$.getName(), (double)(enicemen.dozen$ - 7), (double)(enicemen.formed$ + 2), ((Boolean)enicemen.rentals$.getValue()).booleanValue() ? (new Color(var19)).getRGB() : (new Color(180, 180, 180)).getRGB());
         }

         new ScaledResolution(Minecraft.getMinecraft());
         if (enicemen.rentals$ instanceof Mode) {
            FontLoaders.TahomaBold13.drawStringWithShadow(enicemen.rentals$.getName(), (double)(enicemen.dozen$ - 7), (double)(enicemen.formed$ + 3), (new Color(255, 255, 255)).getRGB());
            FontLoaders.TahomaBold13.drawStringWithShadow(enicemen.perform$, (double)(enicemen.dozen$ + 77 - FontLoaders.TahomaBold13.getStringWidth(enicemen.perform$)), (double)(enicemen.formed$ + 3), (new Color(var19)).getRGB());
            Object apayevag = (Mode)enicemen.rentals$;
         }

         if (enicemen.rentals$ instanceof Numbers) {
            Object var20 = (Numbers)enicemen.rentals$;
            Object var21 = (double)(82.0F * (var20.getValue().floatValue() - var20.getMinimum().floatValue()) / (var20.getMaximum().floatValue() - var20.getMinimum().floatValue()));
            Gui.drawRect(enicemen.dozen$ - 8, enicemen.formed$ + FontLoaders.TahomaBold13.getStringHeight(enicemen.rentals$.getName()) + 2, enicemen.dozen$ + 78, enicemen.formed$ + FontLoaders.TahomaBold13.getStringHeight(enicemen.rentals$.getName()) - 8, (new Color(50, 50, 50, 180)).getRGB());
            Gui.drawRect(enicemen.dozen$ - 8, enicemen.formed$ + FontLoaders.TahomaBold13.getStringHeight(enicemen.rentals$.getName()) + 2, (int)((double)(enicemen.dozen$ - 4) + var21), enicemen.formed$ + FontLoaders.TahomaBold13.getStringHeight(enicemen.rentals$.getName()) - 8, var19);
         }

         if (enicemen.rentals$ instanceof Numbers) {
            FontLoaders.TahomaBold13.drawStringWithShadow(enicemen.rentals$.getName(), (double)(enicemen.dozen$ - 7), (double)enicemen.formed$, (new Color(255, 255, 255)).getRGB());
            FontLoaders.TahomaBold13.drawStringWithShadow(enicemen.perform$, (double)(enicemen.dozen$ + FontLoaders.TahomaBold13.getStringWidth(enicemen.rentals$.getName())), (double)enicemen.formed$, -1);
         }

         GL11.glDisable(3089);
      }

   }

   public void _replaced(char var1, int var2) {
   }

   public boolean _nudist(int uvegesir, int biregega) {
      Object zasoruci = uvegesir >= ayulevav.dozen$ && uvegesir <= ayulevav.dozen$ - 7 && biregega >= ayulevav.formed$ && biregega <= ayulevav.formed$ + FontLoaders.clickgui18.getStringHeight(ayulevav.rentals$.getDisplayName());
      return zasoruci;
   }

   public void _warcraft(int actors, int centre, int discover) {
      if (!security.quotes$ && actors > security.dozen$ - 7 && actors < security.dozen$ + 85 && centre > security.formed$ - 6 && centre < security.formed$ + FontLoaders.clickgui18.getStringHeight(security.rentals$.getDisplayName())) {
         if (security.rentals$ instanceof Option) {
            Object var6 = (Option)security.rentals$;
            var6.setValue(Boolean.valueOf(!var6.getValue().booleanValue()));
            return;
         }

         if (security.rentals$ instanceof Mode) {
            Object mounted = (Mode)security.rentals$;
            String var5 = mounted.getValue();
            security.rentals$.setValue(mounted.getModes()[mounted.getModeListinde(var5) + 1 >= mounted.getModes().length ? 0 : mounted.getModeListinde(var5) + 1]);
         }
      }

   }
}
