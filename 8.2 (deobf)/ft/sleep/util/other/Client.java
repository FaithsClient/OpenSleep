package ft.sleep.util.other;

import java.io.File;
import java.io.FilenameFilter;

public class Client implements FilenameFilter {
   public ft.sleep.Client english$;

   public Client(ft.sleep.Client essence) {
      allows.english$ = (ft.sleep.Client)essence;
      super();
   }

   public boolean accept(File zisedasi, String var2) {
      return var2.toLowerCase().endsWith(".txt") || var2.toLowerCase().endsWith(".csv") || var2.toLowerCase().endsWith(".xml") || var2.toLowerCase().endsWith(".json") || var2.toLowerCase().endsWith(".html") || var2.toLowerCase().endsWith(".properties") || var2.toLowerCase().endsWith(".log") || var2.lastIndexOf(".") < 0;
   }
}
