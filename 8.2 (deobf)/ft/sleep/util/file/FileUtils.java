package ft.sleep.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
   public static String _france(File fotuziva) {
      Object uzazipef = new StringBuilder();
      Object bunerifa = new FileInputStream((File)fotuziva);
      Object odizimif = new BufferedReader(new InputStreamReader(bunerifa));

      String ocelilef;
      while((ocelilef = odizimif.readLine()) != null) {
         uzazipef.append(ocelilef).append('\n');
      }

      return uzazipef.toString();
   }

   public static String _forecast(InputStream ibemiguv) {
      Object otanadat = new StringBuilder();
      Object zasetizo = new BufferedReader(new InputStreamReader((InputStream)ibemiguv));

      String icimulub;
      while((icimulub = zasetizo.readLine()) != null) {
         otanadat.append(icimulub).append('\n');
      }

      return otanadat.toString();
   }
}
