package ft.sleep.util.win32;

public class OSDetector {
   public static String alive$ = System.getProperty("os.name").toLowerCase();

   public static boolean _abraham() {
      return alive$.contains("win");
   }

   public static boolean _gotta() {
      return alive$.contains("mac");
   }

   public static boolean _refine() {
      return alive$.contains("nix") || alive$.contains("nux") || alive$.contains("aix");
   }

   public static boolean _ending() {
      return alive$.contains("sunos");
   }
}
