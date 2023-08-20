package ft.sleep.util.color;

import java.awt.Color;
import java.util.function.Supplier;

public enum PaletteUtil {
   mistake$(PaletteUtil::_cheese),
   report$(PaletteUtil::_hearing),
   sources$(PaletteUtil::_cooking),
   dental$(PaletteUtil::_msgstr),
   senators$(PaletteUtil::_rough);

   public Supplier spectrum$;
   public static PaletteUtil[] norfolk$ = new PaletteUtil[]{mistake$, report$, sources$, dental$, senators$};

   public PaletteUtil(Supplier narrow) {
      humans.spectrum$ = (Supplier)narrow;
   }

   public static Color _trader(Color afadifag) {
      return _patients((Color)afadifag, 2, 100);
   }

   public static Color _patients(Color uvazadal, int guzabono, int borimife) {
      Object ipemofam = new float[3];
      Color.RGBtoHSB(((Color)uvazadal).getRed(), ((Color)uvazadal).getGreen(), ((Color)uvazadal).getBlue(), ipemofam);
      Object opayeyiz = Math.abs(((float)(System.currentTimeMillis() % ((long)-1393338299 ^ -1393336427L)) / 1000.0F + (float)guzabono / (float)borimife * 2.0F) % 2.0F - 1.0F);
      opayeyiz = 0.5F + 0.5F * opayeyiz;
      ipemofam[2] = opayeyiz % 2.0F;
      return new Color(Color.HSBtoRGB(ipemofam[0], ipemofam[1], ipemofam[2]));
   }

   public Color _sectors() {
      return (Color)produces.spectrum$.get();
   }

   public static Color _rough() {
      return new Color(116, 202, 255);
   }

   public static Color _msgstr() {
      return new Color(133, 46, 215);
   }

   public static Color _cooking() {
      return new Color(198, 139, 255);
   }

   public static Color _hearing() {
      return Color.WHITE;
   }

   public static Color _cheese() {
      return new Color(0, 255, 138);
   }
}
