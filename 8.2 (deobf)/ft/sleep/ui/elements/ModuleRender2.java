package ft.sleep.ui.elements;

import ft.sleep.Client;
import ft.sleep.api.value.ColorValue;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.TextValue;
import ft.sleep.api.value.Value;
import ft.sleep.module.Module;
import ft.sleep.module.modules.HUD;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import ft.sleep.util.data.Position;
import ft.sleep.util.render.RenderUtil4;
import ft.sleep.util.render.RoundedUtil;
import ft.sleep.value.*;
import org.lwjgl.input.Keyboard;

public class ModuleRender2 {
   public Position involves$;
   public float facing$;
   public float ladder$;
   public float equally$ = Float.intBitsToFloat(0);
   public Module forward$;
   public boolean figure$;
   public boolean garcia$;
   public int travis$ = 0;
   public int validity$ = 0;
   public List graph$ = new ArrayList();
   public float holders$;
   public float holidays$;

   public ModuleRender2(Module tunisia, float hopkins, float wisdom, float mixing, float romania) {
      gourmet.forward$ = (Module)tunisia;
      Object settled = 20;

      for(Value var8 : ((Module)tunisia)._exciting()) {
         if (var8 instanceof Numbers) {
            gourmet.graph$.add(new NumberSetting((Numbers)var8, (float)hopkins, wisdom + (float)settled, 0, 0, gourmet));
            settled += 16;
         }

         if (var8 instanceof Option) {
            gourmet.graph$.add(new BoolSetting((Option)var8, (float)hopkins, wisdom + (float)settled - 6.0F, 0, 0, gourmet));
            settled += 16;
         }

         if (var8 instanceof Mode) {
            gourmet.graph$.add(new ListSetting((Mode)var8, (float)hopkins, wisdom + (float)settled, -6, 0, gourmet));
            settled += 22;
         }

         if (var8 instanceof ft.sleep.api.value.MultiOptionValue) {
            gourmet.graph$.add(new MultiOptionValue((ft.sleep.api.value.MultiOptionValue)var8, (float)hopkins, wisdom + (float)settled, -6, 0, gourmet));
            settled += 22;
         }

         if (var8 instanceof TextValue) {
            gourmet.graph$.add(new TextSetting((TextValue)var8, (float)hopkins, wisdom + (float)settled, -6, 0, gourmet));
            settled += 22;
         }

         if (var8 instanceof ColorValue) {
            gourmet.graph$.add(new ColorSetting((ColorValue)var8, (float)hopkins, wisdom + (float)settled, -6, 0, gourmet));
            settled += 22;
         }
      }

      gourmet.travis$ = settled;
      gourmet.involves$ = new Position((float)hopkins, (float)wisdom, (float)mixing, (float)settled);
   }

   public void _units(int seminar, int clothing) {
      edwards.holders$ = Client.surround$.conflict$.();
      edwards.holidays$ = Client.surround$.conflict$.();
      edwards.ladder$ = edwards.involves$.linking$;
      edwards.facing$ = edwards.involves$.strength$ + (float)edwards._assumes();
      Object grown = HUD.during$.getHSB();
      Object perfume = Color.getHSBColor(grown[0], grown[1], 0.5F);
      RoundedUtil._ticket(edwards.holders$ + 5.0F + edwards.ladder$, edwards.holidays$ + 17.0F + edwards.facing$, 135.0F, edwards.involves$.shuttle$, 3.0F, new Color(50, 54, 65));
      RoundedUtil._animal(edwards.holders$ + 5.0F + edwards.ladder$, edwards.holidays$ + 18.0F + edwards.facing$, 135.0F, 1.5F, 1.0F, perfume, new Color(HUD.during$.getValue().intValue()));
      FontLoaders.TahomaBold16.drawString(edwards.forward$._skirt(), edwards.holders$ + 5.0F + edwards.ladder$, edwards.holidays$ + 17.0F + edwards.facing$ - 8.0F, (new Color(255, 255, 255)).getRGB());
      RenderUtil4._knowing(edwards.holders$ + 5.0F + edwards.ladder$ + 4.0F, edwards.holidays$ + 17.0F + edwards.facing$ + 8.0F, 7.0F, 7.0F, 1.0F, edwards.forward$._central() ? (new Color(86, 94, 115)).getRGB() : (new Color(50, 54, 65)).getRGB(), 1.0F, edwards.forward$._central() ? (new Color(86, 94, 115)).getRGB() : (new Color(85, 90, 96)).getRGB());
      if (edwards._appear((int)seminar, (int)clothing)) {
         RenderUtil4._knowing(edwards.holders$ + 5.0F + edwards.ladder$ + 4.0F, edwards.holidays$ + 17.0F + edwards.facing$ + 8.0F, 7.0F, 7.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), 1.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

      FontLoaders.TahomaBold11.drawString("Enable", edwards.holders$ + 5.0F + edwards.ladder$ + 4.0F + 10.0F, edwards.holidays$ + 17.0F + edwards.facing$ + 8.0F + 3.0F, (new Color(200, 200, 200)).getRGB());

      for(Object editors : edwards.graph$) {
         editors.((int)seminar, (int)clothing);
      }

      RenderUtil4._knowing(edwards.holders$ + 5.0F + edwards.ladder$ + 115.0F - (float)FontLoaders.TahomaBold11.getStringWidth(edwards.garcia$ ? "..." : Keyboard.getKeyName(edwards.forward$._owned()).toLowerCase()) + 13.0F, edwards.holidays$ + 17.0F + edwards.facing$ + 8.0F + 0.5F, (float)(FontLoaders.TahomaBold11.getStringWidth(edwards.garcia$ ? "..." : Keyboard.getKeyName(edwards.forward$._owned()).toLowerCase()) + 4), 7.0F, 1.0F, (new Color(28, 32, 40)).getRGB(), 1.0F, (new Color(86, 94, 115)).getRGB());
      FontLoaders.TahomaBold11.drawString(edwards.garcia$ ? "..." : Keyboard.getKeyName(edwards.forward$._owned()).toLowerCase(), edwards.holders$ + 5.0F + edwards.ladder$ + 117.0F - (float)FontLoaders.TahomaBold11.getStringWidth(edwards.garcia$ ? "..." : Keyboard.getKeyName(edwards.forward$._owned()).toLowerCase()) + 13.0F, edwards.holidays$ + 17.0F + edwards.facing$ + 11.0F, -1);
      if (edwards._install((int)seminar, (int)clothing)) {
         RenderUtil4._knowing(edwards.holders$ + 5.0F + edwards.ladder$ + 115.0F - (float)FontLoaders.TahomaBold11.getStringWidth(edwards.garcia$ ? "..." : Keyboard.getKeyName(edwards.forward$._owned()).toLowerCase()) + 13.0F, edwards.holidays$ + 17.0F + edwards.facing$ + 8.0F + 0.5F, (float)(FontLoaders.TahomaBold11.getStringWidth(edwards.garcia$ ? "..." : Keyboard.getKeyName(edwards.forward$._owned()).toLowerCase()) + 4), 7.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), 1.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

   }

   public boolean _returns() {
      return somocamo.figure$;
   }

   public void _pointer(boolean prefer) {
      modify.figure$ = (boolean)prefer;
   }

   public void _buttons(int telecom, int along, int lanka) {
      if (phones._install((int)telecom, (int)along) && lanka == 0) {
         phones.garcia$ = true;
      }

      if (!phones._install((int)telecom, (int)along) && phones.garcia$ && lanka == 0) {
         phones.garcia$ = false;
      }

      if (phones._appear((int)telecom, (int)along) && lanka == 0) {
         phones.forward$._myanmar();
      }

      if (phones.garcia$ && lanka == 1) {
         phones.forward$._enrolled(0);
         phones.garcia$ = false;
      }

      phones.graph$.forEach(ModuleRender2::_airport);
   }

   public void _mortgage(int osorariv, int orayebos, int imomocin) {
      ilovoyir.graph$.forEach(ModuleRender2::_dennis);
   }

   public void _muslim(char history, int footwear) {
      invest.graph$.forEach(ModuleRender2::_spain);
      if (invest.garcia$) {
         if (footwear == 211) {
            footwear = 0;
         }

         invest.forward$._enrolled((int)footwear);
         invest.garcia$ = false;
      }

   }

   public boolean _appear(int cabitive, int mayugozu) {
      return (float)cabitive >= isopevid.holders$ + 5.0F + isopevid.ladder$ + 4.0F && (float)cabitive <= isopevid.holders$ + 5.0F + isopevid.ladder$ + 4.0F + 15.0F && (float)mayugozu >= isopevid.holidays$ + 17.0F + isopevid.facing$ + 8.0F && (float)mayugozu <= isopevid.holidays$ + 17.0F + isopevid.facing$ + 8.0F + 6.0F;
   }

   public boolean _install(int ledusora, int ozifivit) {
      return (float)ledusora >= yebudica.holders$ + 5.0F + yebudica.ladder$ + 115.0F - (float)FontLoaders.TahomaBold11.getStringWidth(Keyboard.getKeyName(yebudica.forward$._owned()).toLowerCase()) + 13.0F && (float)ledusora <= yebudica.holders$ + 5.0F + yebudica.ladder$ + 115.0F - (float)FontLoaders.TahomaBold11.getStringWidth(Keyboard.getKeyName(yebudica.forward$._owned()).toLowerCase()) + 13.0F + (float)FontLoaders.TahomaBold11.getStringWidth(Keyboard.getKeyName(yebudica.forward$._owned()).toLowerCase()) + 3.0F && (float)ozifivit >= yebudica.holidays$ + 17.0F + yebudica.facing$ + 8.0F + 0.5F && (float)ozifivit <= yebudica.holidays$ + 17.0F + yebudica.facing$ + 8.0F + 0.5F + 7.0F;
   }

   public Module _location() {
      return cetazibu.forward$;
   }

   public float _terrace() {
      return tomayuva.involves$.strength$ + (float)tomayuva._assumes();
   }

   public float _hyundai() {
      return ((Downward)emirates.graph$.get(emirates.graph$.size() - 1)).();
   }

   public void _spencer(float antigua) {
      musician.involves$.strength$ = (float)antigua;
   }

   public int _assumes() {
      return fegafuvi.validity$;
   }

   public void _spanish(int nenizami) {
      acozumon.validity$ = (int)nenizami;
   }

   public float _obesity() {
      return apibavab.equally$;
   }

   public void _sister(float walked) {
      cleared.equally$ = (float)walked;
   }

   public static void _spain(char isurafer, int fayusero, Downward ubeyelis) {
      ((Downward)ubeyelis).((char)isurafer, (int)fayusero);
   }

   public static void _dennis(int fuvisoto, int imopided, int meyucusi, Downward nasuzide) {
      ((Downward)nasuzide).((int)fuvisoto, (int)imopided, (int)meyucusi);
   }

   public static void _airport(int genetics, int apparent, int click, Downward retailer) {
      ((Downward)retailer).((int)genetics, (int)apparent, (int)click);
   }
}
