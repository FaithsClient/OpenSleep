package ft.sleep.util.data;

import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.Objects;

public class Logs {
   public String motels$;
   public String bottle$;
   public int supreme$;
   public int charter$;
   public static int shape$ = (new Color(255, 80, 80)).getRGB();
   public static int process$ = (new Color(135, 227, 49)).getRGB();
   public static int donor$ = (new Color(255, 215, 100)).getRGB();
   public static int groove$ = (new Color(255, 255, 255)).getRGB();

   public Logs(String nucigiro, String betinedu, int sududozu) {
      enoyorit.motels$ = (String)nucigiro;
      enoyorit.bottle$ = (String)betinedu;
      enoyorit.supreme$ = (int)sududozu;
   }

   public void _sunrise() {
      opayibon.charter$ = 8 * opayibon.supreme$ + 12;
      FontLoaders.ICON15.drawString(opayibon.bottle$, 100.0F, (float)(6 + opayibon.charter$), opayibon._towers(opayibon.bottle$));
      FontLoaders.SF15.drawString(opayibon.motels$, (float)(103 + FontLoaders.ICON15.getStringWidth(opayibon.bottle$)), (float)(5 + opayibon.charter$), -1);
   }

   public int _towers(String paniparu) {
      if (Objects.equals(paniparu, "I")) {
         return shape$;
      } else if (((String)paniparu).equals("J")) {
         return donor$;
      } else if (((String)paniparu).equals("H")) {
         return process$;
      } else {
         return ((String)paniparu).equals("K") ? groove$ : -1;
      }
   }
}
