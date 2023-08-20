//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.ui.screen.GuiTextField;
import ft.sleep.util.render.RoundedUtil;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class PasswordTextField extends GuiTextField {
   public String reviewed$;

   public PasswordTextField(int softball, FontRenderer supplied, int fault, int madness, int doing, int programs, String profiles) {
      super((int)softball, (FontRenderer)supplied, (int)fault, (int)madness, (int)doing, (int)programs);
      blood.reviewed$ = (String)profiles;
   }

   public void ____/* $FF was: */() {
      if (susan.()) {
         FontLoaders.TahomaBold18.drawString(susan.reviewed$, susan. - (float)FontLoaders.TahomaBold18.getStringWidth(susan.reviewed$) - 5.0F, susan. + 5.0F, (new Color(-1)).getRGB());
         RoundedUtil._ticket(susan., susan. + 15.0F, (float)susan.width, 1.0F, Float.intBitsToFloat(0), new Color(-1));
         Object barry = susan. ? susan.�? : susan.�?;
         Object friend = susan.() - susan.�?;
         Object austin = susan.() - susan.�?;
         Object composed = susan.�?.trimStringToWidth(susan.�?().substring(susan.�?).replaceAll("(?s).", "*"), susan.getWidth());
         Object yemen = friend >= 0 && friend <= composed.length();
         Object external = susan.() && susan.�? / 6 % 2 == 0 && yemen;
         Object epinions = susan. ? (int)susan. + 4 : (int)susan.;
         Object quoted = susan. ? (int)susan. + (susan.height - 8) / 2 : (int)susan.;
         Object montana = epinions;
         if (austin > composed.length()) {
            austin = composed.length();
         }

         if (!composed.isEmpty()) {
            Object debian = yemen ? composed.substring(0, friend) : composed;
            montana = susan.�?.drawStringWithShadow(debian, (float)epinions, (float)quoted, barry);
         }

         Object var13 = susan.() < susan.�?().length() || susan.�?().length() >= susan.getMaxStringLength();
         Object harold = montana;
         if (!yemen) {
            harold = friend > 0 ? epinions + susan.width : epinions;
         } else if (var13) {
            harold = montana - 1;
            --montana;
         }

         if (!composed.isEmpty() && yemen && friend < composed.length()) {
            susan.�?.drawStringWithShadow(composed.substring(friend), (float)montana, (float)quoted, barry);
         }

         if (external) {
            if (var13) {
               Gui.drawRect(harold, quoted - 1, harold + 1, quoted + 1 + susan.�?.FONT_HEIGHT, -3092272);
            } else {
               susan.�?.drawStringWithShadow("_", (float)harold, (float)quoted, barry);
            }
         }

         if (austin != friend) {
            Object solomon = epinions + susan.�?.getStringWidth(composed.substring(0, austin));
            susan.�?(harold, quoted - 1, solomon - 1, quoted + 1 + susan.�?.FONT_HEIGHT);
         }
      }

   }
}
