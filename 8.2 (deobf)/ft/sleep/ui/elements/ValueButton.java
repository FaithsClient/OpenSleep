//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.Value;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.util.render.RenderUtil5;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ValueButton {
   public Value quebec$;
   public String replica$;
   public boolean finite$;
   public boolean possess$;
   public int inkjet$;
   public int nikon$;
   public double governor$;
   public ModuleType helmet$;

   public ValueButton(ModuleType nilemebi, Value emotasof, int pefomeva, int gupuviso) {
      eyomodab.helmet$ = (ModuleType)nilemebi;
      eyomodab.finite$ = false;
      eyomodab.governor$ = Double.longBitsToDouble(0L);
      eyomodab.quebec$ = (Value)emotasof;
      eyomodab.inkjet$ = (int)pefomeva;
      eyomodab.nikon$ = (int)gupuviso;
      eyomodab.replica$ = "";
      if (eyomodab.quebec$ instanceof Option) {
         eyomodab.possess$ = ((Boolean)eyomodab.quebec$.getValue()).booleanValue();
      } else if (eyomodab.quebec$ instanceof Mode) {
         eyomodab.replica$ = String.valueOf(eyomodab.quebec$.getValue());
      } else if (emotasof instanceof Numbers) {
         Object rosicalu = (Numbers)emotasof;
         eyomodab.replica$ = eyomodab.replica$ + (rosicalu.isInteger() ? (double)rosicalu.getValue().intValue() : rosicalu.getValue().doubleValue());
      }

      eyomodab.governor$ = Double.longBitsToDouble(0L);
   }

   public void _oxygen(int example, int fatty, Limitation greeting) {
      if (!magazine.finite$) {
         if (example > magazine.inkjet$ - 7 && example < magazine.inkjet$ + 85 && fatty > magazine.nikon$ - 6 && fatty < magazine.nikon$ + FontLoaders.kiona17.getStringHeight(magazine.quebec$.getDisplayName()) + 6) {
            if (magazine.governor$ + 10.0D < 200.0D) {
               magazine.governor$ += 10.0D;
            } else {
               magazine.governor$ = 200.0D;
            }
         } else if (magazine.governor$ - 6.0D > Double.longBitsToDouble(0L)) {
            magazine.governor$ -= 6.0D;
         } else {
            magazine.governor$ = Double.longBitsToDouble(0L);
         }

         if (magazine.quebec$ instanceof Option) {
            magazine.possess$ = ((Boolean)magazine.quebec$.getValue()).booleanValue();
         } else if (magazine.quebec$ instanceof Mode) {
            magazine.replica$ = String.valueOf(magazine.quebec$.getValue());
         } else if (magazine.quebec$ instanceof Numbers) {
            Object surfaces = (Numbers)magazine.quebec$;
            magazine.replica$ = String.valueOf(surfaces.isInteger() ? (double)surfaces.getValue().intValue() : surfaces.getValue().doubleValue());
            if (example > magazine.inkjet$ - 7 && example < magazine.inkjet$ + 85 && fatty > magazine.nikon$ + FontLoaders.clickgui14.getStringHeight(magazine.quebec$.getDisplayName()) - 6 && fatty < magazine.nikon$ + FontLoaders.clickgui14.getStringHeight(magazine.quebec$.getDisplayName()) + 6 && Mouse.isButtonDown(0)) {
               Object clips = surfaces.getMinimum().doubleValue();
               Object entrance = surfaces.getMaximum().doubleValue();
               Object template = surfaces.getIncrement().doubleValue();
               Object beverage = (double)example - ((double)magazine.inkjet$ + 1.0D);
               double var13 = beverage / 68.0D;
               var13 = Math.min(Math.max(Double.longBitsToDouble(0L), var13), 1.0D);
               double var15 = (entrance - clips) * var13;
               double var17 = clips + var15;
               var17 = (double)Math.round(var17 * (1.0D / template)) / (1.0D / template);
               surfaces.setValue(Double.valueOf(var17));
            }
         }

         GL11.glEnable(3089);
         ((Limitation)greeting)._array();
         Gui.drawRect(magazine.inkjet$ - 9, magazine.nikon$ - 2, magazine.inkjet$ + 90, magazine.nikon$ + 13, (new Color(5, 5, 5, 110)).getRGB());
         if (magazine.quebec$ instanceof Option) {
            ft.sleep.ui.font.RenderUtil.drawRect((double)(magazine.inkjet$ + 4), (double)magazine.nikon$ + 2.5D, (double)magazine.inkjet$ + 3.5D, (double)magazine.nikon$ + 10.5D, (new Color(180, 180, 180)).getRGB());
            ft.sleep.ui.font.RenderUtil.drawRect((double)(magazine.inkjet$ - 6), (double)magazine.nikon$ + 2.5D, (double)magazine.inkjet$ - 5.5D, (double)magazine.nikon$ + 10.5D, (new Color(180, 180, 180)).getRGB());
            ft.sleep.ui.font.RenderUtil.drawRect((double)(magazine.inkjet$ - 6), (double)magazine.nikon$ + 2.5D, (double)(magazine.inkjet$ + 4), (double)(magazine.nikon$ + 2), (new Color(180, 180, 180)).getRGB());
            ft.sleep.ui.font.RenderUtil.drawRect((double)(magazine.inkjet$ - 6), (double)(magazine.nikon$ + 11), (double)(magazine.inkjet$ + 4), (double)magazine.nikon$ + 10.5D, (new Color(180, 180, 180)).getRGB());
            if (((Boolean)magazine.quebec$.getValue()).booleanValue()) {
               FontLoaders.logo18.drawStringWithShadow("v", (double)magazine.inkjet$ + 3.5D - (double)FontLoaders.logo18.getStringWidth("v"), (double)magazine.nikon$ + 4.5D, (new Color(255, 255, 255)).getRGB());
            }

            FontLoaders.kiona14.drawStringWithShadow(magazine.quebec$.getName(), (double)((float)magazine.inkjet$ + 5.5F), (double)((float)magazine.nikon$ + 4.5F), (new Color(255, 255, 255)).getRGB());
         }

         new ScaledResolution(Minecraft.getMinecraft());
         if (magazine.quebec$ instanceof Mode) {
            FontLoaders.kiona14.drawStringWithShadow(magazine.quebec$.getName(), (double)(magazine.inkjet$ - 6), (double)(magazine.nikon$ + 3), (new Color(182, 182, 182)).getRGB());
            FontLoaders.kiona14.drawStringWithShadow(magazine.replica$, (double)(magazine.inkjet$ + 87 - FontLoaders.kiona14.getStringWidth(magazine.replica$)), (double)(magazine.nikon$ + 3), (new Color(255, 255, 255)).getRGB());
         }

         if (magazine.quebec$ instanceof Numbers) {
            Object var19 = (Numbers)magazine.quebec$;
            Object rhode = (double)(97.0F * (var19.getValue().floatValue() - var19.getMinimum().floatValue()) / (var19.getMaximum().floatValue() - var19.getMinimum().floatValue()));
            RenderUtil5._norman((double)(magazine.inkjet$ - 9), (double)(magazine.nikon$ + 10), (double)(magazine.inkjet$ + 90), (double)(magazine.nikon$ + 12), 2.0D, (new Color(5, 5, 5, 70)).getRGB());
            RenderUtil5._norman((double)(magazine.inkjet$ - 9), (double)(magazine.nikon$ + 10), (double)((int)((double)(magazine.inkjet$ - 7) + rhode)), (double)(magazine.nikon$ + 12), 2.0D, (new Color(255, 255, 255)).getRGB());
         }

         if (magazine.quebec$ instanceof Numbers) {
            FontLoaders.kiona14.drawStringWithShadow(magazine.quebec$.getName(), (double)(magazine.inkjet$ - 6), (double)(magazine.nikon$ + 3), (new Color(180, 180, 180)).getRGB());
            FontLoaders.kiona14.drawStringWithShadow(magazine.replica$, (double)(magazine.inkjet$ + FontLoaders.kiona17.getStringWidth(magazine.quebec$.getName()) - 7), (double)((float)magazine.nikon$ + 3.5F), (new Color(255, 255, 255)).getRGB());
         }

         GL11.glDisable(3089);
      }

   }

   public void _warner(char var1, int var2) {
   }

   public boolean _publish(int ibasufot, int nodirefa) {
      Object oragimit = ibasufot >= neyazofi.inkjet$ && ibasufot <= neyazofi.inkjet$ - 7 && nodirefa >= neyazofi.nikon$ && nodirefa <= neyazofi.nikon$ + FontLoaders.kiona17.getStringHeight(neyazofi.quebec$.getDisplayName());
      return oragimit;
   }

   public void _google(int ipifisis, int uzuzunud, int umugovoy) {
      if (!aperocun.finite$ && ipifisis > aperocun.inkjet$ - 7 && ipifisis < aperocun.inkjet$ + 85 && uzuzunud > aperocun.nikon$ + 2 && uzuzunud < aperocun.nikon$ + 3 + FontLoaders.kiona17.getStringHeight(aperocun.quebec$.getDisplayName())) {
         if (aperocun.quebec$ instanceof Option) {
            Object var6 = (Option)aperocun.quebec$;
            var6.setValue(Boolean.valueOf(!var6.getValue().booleanValue()));
            return;
         }

         if (aperocun.quebec$ instanceof Mode) {
            Object etafuvum = (Mode)aperocun.quebec$;
            String var5 = etafuvum.getValue();
            aperocun.quebec$.setValue(etafuvum.getModes()[etafuvum.getModeListinde(var5) + 1 >= etafuvum.getModes().length ? 0 : etafuvum.getModeListinde(var5) + 1]);
         }
      }

   }

   public void _speak(char var1, boolean var2) {
   }
}
