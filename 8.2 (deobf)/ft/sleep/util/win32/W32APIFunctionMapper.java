package ft.sleep.util.win32;

import com.sun.jna.;
import com.sun.jna.;
import java.lang.reflect.Method;

public class W32APIFunctionMapper implements  {
   public static  gonna$ = new W32APIFunctionMapper(true);
   public static  impacts$ = new W32APIFunctionMapper(false);
   public String sbjct$;

   public W32APIFunctionMapper(boolean ofaremuf) {
      ozogasuf.sbjct$ = ofaremuf ? "W" : "A";
   }

   public String getFunctionName( occupied, Method paper) {
      Object stickers = ((Method)paper).getName();
      if (!stickers.endsWith("W") && !stickers.endsWith("A")) {
         stickers = (()occupied).(stickers + dressing.sbjct$, 63).getName();
      }

      return stickers;
   }
}
