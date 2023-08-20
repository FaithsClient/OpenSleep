package ft.sleep.util.discord;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DiscordRPC3 {
   public static String sharp$ = "3.4.0";
   public static String explorer$ = "1.6.2";

   public static void _owners(String gibimapu, DiscordEventHandlers2 udeyugup, boolean edubonib) {
      DiscordRPC2.marilyn$.((String)gibimapu, (DiscordEventHandlers2)udeyugup, edubonib ? 1 : 0, (String)null);
   }

   public static void _feedback(String michel, String antonio) {
      DiscordRPC2.marilyn$.((String)michel, (String)antonio);
   }

   public static void _sides(String maziviza, DiscordEventHandlers2 ezapicog, boolean agozasor, String ulatosiz) {
      DiscordRPC2.marilyn$.((String)maziviza, (DiscordEventHandlers2)ezapicog, agozasor ? 1 : 0, (String)ulatosiz);
   }

   public static void _kerry(String china, String voice) {
      DiscordRPC2.marilyn$.((String)china, (String)voice);
   }

   public static void _precious(DiscordEventHandlers2 rocks) {
      DiscordRPC2.marilyn$.((DiscordEventHandlers2)rocks);
   }

   public static void _earning() {
      DiscordRPC2.marilyn$.();
   }

   public static void _becomes() {
      DiscordRPC2.marilyn$.();
   }

   public static void _alloy(DiscordRichPresence olomefam) {
      DiscordRPC2.marilyn$.((DiscordRichPresence)olomefam);
   }

   public static void _enquiry() {
      DiscordRPC2.marilyn$.();
   }

   public static void _southern(String vitamin, DiscordRPC thailand) {
      DiscordRPC2.marilyn$.((String)vitamin, ((DiscordRPC)thailand).avoid$);
   }

   public static void _license() {
      Object atitafad = System.mapLibraryName("discord-rpc");
      Object gufiremu = new OSUtil();
      String ceniveyo;
      String gipisobe;
      if (gufiremu._warren()) {
         Object abaseped = new File(System.getProperty("user.home") + File.separator + "Library" + File.separator + "Application Support" + File.separator);
         gipisobe = "darwin";
         ceniveyo = abaseped + File.separator + "discord-rpc" + File.separator + atitafad;
      } else if (gufiremu._claims()) {
         Object var11 = new File(System.getenv("TEMP"));
         Object uzebeciz = System.getProperty("sun.arch.data.model").equals("64");
         gipisobe = uzebeciz ? "win-x64" : "win-x86";
         ceniveyo = var11 + File.separator + "discord-rpc" + File.separator + atitafad;
      } else {
         Object var12 = new File(System.getProperty("user.home"), ".discord-rpc");
         gipisobe = "linux";
         ceniveyo = var12 + File.separator + atitafad;
      }

      Object opupesuc = "/" + gipisobe + "/" + atitafad;
      Object var13 = new File(ceniveyo);
      Object asabazos = DiscordRPC3.class.getResourceAsStream(opupesuc);
      Object yimosubu = _comment(var13);
      _prospect(asabazos, yimosubu);
      var13.deleteOnExit();
      if (yimosubu != null) {
         yimosubu.close();
      }

      if (asabazos != null) {
         asabazos.close();
      }

      System.load(var13.getAbsolutePath());
   }

   public static void _prospect(InputStream celenuro, OutputStream irasures) throws IOException {
      Object cudevulo = new byte[4096];

      int ramanuda;
      while(-1 != (ramanuda = ((InputStream)celenuro).read(cudevulo))) {
         ((OutputStream)irasures).write(cudevulo, 0, ramanuda);
      }

   }

   public static FileOutputStream _comment(File ulofofod) throws IOException {
      if (((File)ulofofod).exists()) {
         if (((File)ulofofod).isDirectory()) {
            throw new IOException("File '" + ulofofod + "' exists but is a directory");
         }

         if (!((File)ulofofod).canWrite()) {
            throw new IOException("File '" + ulofofod + "' cannot be written to");
         }
      } else {
         Object eyepapus = ((File)ulofofod).getParentFile();
         if (eyepapus != null && !eyepapus.mkdirs() && !eyepapus.isDirectory()) {
            throw new IOException("Directory '" + eyepapus + "' could not be created");
         }
      }

      return new FileOutputStream((File)ulofofod);
   }

   static {
      _license();
   }
}
