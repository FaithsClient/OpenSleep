package ft.sleep.util.win32;

public class OSDetector2 {
   public static String johnson$ = System.getProperty("os.name").toLowerCase();

   public static boolean _venues() {
      return johnson$.contains("win");
   }

   public static boolean _lovers() {
      return johnson$.contains("mac");
   }

   public static boolean _random() {
      return johnson$.contains("nix") || johnson$.contains("nux") || johnson$.contains("aix") || johnson$.matches("mac.*os.*x");
   }

   public static boolean _detector() {
      return johnson$.contains("linux");
   }

   public static boolean _article() {
      return johnson$.contains("sunos");
   }
}
