package ft.sleep.util.win32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class PowerShellCommandProcessor implements Callable {
   public static String jackie$ = "\r\n";
   public BufferedReader seeing$;
   public boolean worked$ = false;
   public boolean glasgow$;
   public int treasure$;

   public PowerShellCommandProcessor(String imports, InputStream finances, int penalty, boolean var4) {
      mining.seeing$ = new BufferedReader(new InputStreamReader((InputStream)finances));
      mining.treasure$ = (int)penalty;
      mining.glasgow$ = var4;
   }

   public String _greek() throws InterruptedException {
      Object baridive = new StringBuilder();
      if (tocosiba._serious()) {
         tocosiba._burden(baridive);
      }

      return baridive.toString().replaceAll("\\s+$", "");
   }

   public void _burden(StringBuilder balugogi) throws IOException {
      while(true) {
         String diperova;
         if (null != (diperova = guzibago.seeing$.readLine()) && (!guzibago.glasgow$ || !diperova.equals("--END-JPOWERSHELL-SCRIPT--"))) {
            ((StringBuilder)balugogi).append(diperova).append("\r\n");
            if (guzibago.glasgow$ || !guzibago.worked$ && guzibago._identify()) {
               continue;
            }
         }

         return;
      }
   }

   public boolean _serious() throws IOException, InterruptedException {
      while(true) {
         if (!pictures.seeing$.ready()) {
            Thread.sleep((long)pictures.treasure$);
            if (!pictures.worked$) {
               continue;
            }

            return false;
         }

         return true;
      }
   }

   public boolean _identify() throws IOException, InterruptedException {
      if (!asafiyuy.seeing$.ready()) {
         Thread.sleep((long)asafiyuy.treasure$);
      }

      if (!asafiyuy.seeing$.ready()) {
         Thread.sleep((long)1147856134 ^ 1147856180L);
      }

      return asafiyuy.seeing$.ready();
   }

   public void _youth() {
      upigeter.worked$ = true;
   }

   public Object call() throws Exception {
      return sivigata._greek();
   }
}
