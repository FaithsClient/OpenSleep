package ft.sleep.value;

import ft.sleep.Client;
import ft.sleep.api.value.TextValue;
import ft.sleep.api.value.Value;
import ft.sleep.module.modules.HUD;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.util.render.RenderUtil4;
import org.lwjgl.input.Keyboard;

public class TextSetting extends Downward {
   public TextValue arise$;
   public float viewing$;
   public float medium$;
   public float easily$;

   public TextSetting(TextValue order, float papers, float loose, int kinase, int hairy, ModuleRender2 pipeline) {
      super((Value)order, (float)papers, (float)loose, (int)kinase, (int)hairy, (ModuleRender2)pipeline);
      deficit.arise$ = (TextValue)order;
   }

   public void __/* $FF was: */(int twenty, int bathroom) {
      study.viewing$ = Client.surround$.conflict$.();
      study.medium$ = Client.surround$.conflict$.();
      study.easily$ = study..strength$ + (float)study.();
      RenderUtil4._knowing(study.viewing$ + 5.0F + study..linking$ + 55.0F, study.medium$ + 17.0F + study.easily$ + 8.0F, 75.0F, 11.0F, 1.0F, (new Color(59, 63, 72)).getRGB(), 1.0F, study.arise$.getTextHovered() ? (new Color(HUD.during$.getValue().intValue())).getRGB() : (new Color(85, 90, 96)).getRGB());
      if (study._voices((int)twenty, (int)bathroom) && !study.arise$.getTextHovered()) {
         RenderUtil4._knowing(study.viewing$ + 5.0F + study..linking$ + 55.0F, study.medium$ + 17.0F + study.easily$ + 8.0F, 75.0F, 11.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), 1.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

      FontLoaders.TahomaBold11.drawString(study.arise$.getName(), study.viewing$ + 5.0F + study..linking$ + 4.0F, study.medium$ + 17.0F + study.easily$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      if (FontLoaders.TahomaBold12.getStringWidth(study.arise$.getTextHovered() ? (String)study.arise$.getValue() + "_" : (String)study.arise$.getValue()) > 70) {
         FontLoaders.TahomaBold12.drawString(FontLoaders.Tahoma16.trimStringToWidth(study.arise$.getTextHovered() ? (String)study.arise$.getValue() + "_" : (String)study.arise$.getValue(), 78, true), study.viewing$ + 5.0F + study..linking$ + 57.0F, study.medium$ + 17.0F + study.easily$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      } else if (((String)study.arise$.getValue()).isEmpty() && !study.arise$.getTextHovered()) {
         FontLoaders.TahomaBold12.drawString("Type Here...", study.viewing$ + 5.0F + study..linking$ + 57.0F, study.medium$ + 17.0F + study.easily$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      } else {
         FontLoaders.TahomaBold12.drawString(study.arise$.getTextHovered() ? (String)study.arise$.getValue() + "_" : (String)study.arise$.getValue(), study.viewing$ + 5.0F + study..linking$ + 57.0F, study.medium$ + 17.0F + study.easily$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      }

   }

   public boolean _voices(int disizame, int avanafon) {
      return (float)disizame >= motoboya.viewing$ + 5.0F + motoboya..linking$ + 55.0F && (float)disizame <= motoboya.viewing$ + 5.0F + motoboya..linking$ + 55.0F + 75.0F && (float)avanafon >= motoboya.medium$ + 17.0F + motoboya.easily$ + 8.0F && (float)avanafon <= motoboya.medium$ + 17.0F + motoboya.easily$ + 8.0F + 11.0F;
   }

   public void __/* $FF was: */(int irutelap, int guyifimo, int var3) {
      if (besaliva._voices((int)irutelap, (int)guyifimo)) {
         besaliva.arise$.setTextHovered(!besaliva.arise$.getTextHovered());
      } else if (besaliva.arise$.getTextHovered()) {
         besaliva.arise$.setTextHovered(false);
      }

   }

   public void _/* $FF was: */(char eyafutub, int nevacori) {
      if (etufarov.arise$.getTextHovered()) {
         if (nevacori == 1) {
            etufarov.arise$.setTextHovered(false);
         } else if (nevacori != 14 && nevacori != 157 && nevacori != 29 && nevacori != 54 && nevacori != 42 && nevacori != 15 && nevacori != 58 && nevacori != 211 && nevacori != 199 && nevacori != 210 && nevacori != 200 && nevacori != 208 && nevacori != 205 && nevacori != 203 && nevacori != 56 && nevacori != 184 && nevacori != 197 && nevacori != 70 && nevacori != 207 && nevacori != 201 && nevacori != 209 && nevacori != 221 && nevacori != 59 && nevacori != 60 && nevacori != 61 && nevacori != 62 && nevacori != 63 && nevacori != 64 && nevacori != 65 && nevacori != 66 && nevacori != 67 && nevacori != 68 && nevacori != 87 && nevacori != 88) {
            etufarov.arise$.append((char)eyafutub);
         }

         if (((TextValue)etufarov.).getTextHovered() && Keyboard.isKeyDown(14) && ((String)etufarov.arise$.getValue()).length() >= 1) {
            etufarov.arise$.setValue(((String)etufarov.arise$.getValue()).substring(0, ((String)etufarov.arise$.getValue()).length() - 1));
         }
      }

   }

   public void __/* $FF was: */(int var1, int var2, int var3) {
   }
}
