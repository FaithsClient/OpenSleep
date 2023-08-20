package ft.sleep.util.win32;

import java.util.Properties;

public class PowerShellConfig {
   public static String genre$ = "jpowershell.properties";
   public static Properties agency$;

   public static Properties _sixth() {
      if (agency$ == null) {
         agency$ = new Properties();
         agency$.load(PowerShellConfig.class.getClassLoader().getResourceAsStream("jpowershell.properties"));
      }

      return agency$;
   }
}
