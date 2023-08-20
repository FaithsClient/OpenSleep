package ft.sleep.util.changelog;

import java.awt.Color;

public enum ChangeLogUtils {
   strict$((new Color(100, 200, 100, 255)).getRGB()),
   seafood$((new Color(75, 125, 200, 255)).getRGB()),
   appeared$((new Color(200, 75, 75, 255)).getRGB()),
   estimate$((new Color(200, 200, 200, 255)).getRGB()),
   spare$((new Color(200, 175, 50, 255)).getRGB());

   public int warning$;
   public static ChangeLogUtils[] facial$ = new ChangeLogUtils[]{strict$, seafood$, appeared$, estimate$, spare$};

   public ChangeLogUtils(int korean) {
      nickname.warning$ = (int)korean;
   }
}
