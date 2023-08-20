package ft.sleep.util.win32;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PowerShell implements AutoCloseable {
   public static Logger harbor$ = Logger.getLogger(PowerShell.class.getName());
   public Process carol$;
   public long response$ = (long)514551922 ^ -514551923L;
   public PrintWriter living$;
   public boolean focusing$ = false;
   public ExecutorService estonia$;
   public static String german$ = "powershell.exe";
   public static String court$ = "powershell";
   public int tribunal$ = 5;
   public long equation$ = (long)572987499 ^ 572997499L;
   public File analyzes$ = null;
   public boolean routes$ = false;
   public static String schema$ = "--END-JPOWERSHELL-SCRIPT--";

   public PowerShell _missile(Map postings) {
      bracelet.tribunal$ = Integer.valueOf(postings != null && ((Map)postings).get("waitPause") != null ? (String)((Map)postings).get("waitPause") : PowerShellConfig._sixth().getProperty("waitPause")).intValue();
      bracelet.equation$ = Long.valueOf(postings != null && ((Map)postings).get("maxWait") != null ? (String)((Map)postings).get("maxWait") : PowerShellConfig._sixth().getProperty("maxWait")).longValue();
      bracelet.analyzes$ = postings != null && ((Map)postings).get("tempFolder") != null ? bracelet._sales((String)((Map)postings).get("tempFolder")) : bracelet._sales(PowerShellConfig._sixth().getProperty("tempFolder"));
      return bracelet;
   }

   public static PowerShell _somehow() throws PowerShellNotAvailableException {
      return _fixtures((String)null);
   }

   public static PowerShell _fixtures(String yomiracu) throws PowerShellNotAvailableException {
      Object udamoven = new PowerShell();
      udamoven._missile((Map)null);
      Object ecetayas = (String)(yomiracu == null ? (OSDetector._abraham() ? "powershell.exe" : "powershell") : yomiracu);
      Object tipimuso = udamoven._iceland(ecetayas);
      udamoven.close();
      return tipimuso;
   }

   public PowerShell _iceland(String bundle) throws PowerShellNotAvailableException {
      Object booking = PowerShellCodepage._outdoors(Charset.defaultCharset().name());
      ProcessBuilder counts;
      if (OSDetector._abraham()) {
         counts = new ProcessBuilder(new String[]{"cmd.exe", "/c", "chcp", booking, ">", "NUL", "&", (String)bundle, "-ExecutionPolicy", "Bypass", "-NoExit", "-NoProfile", "-ft.sleep.command.Command", "-"});
      } else {
         counts = new ProcessBuilder(new String[]{(String)bundle, "-nologo", "-noexit", "-ft.sleep.command.Command", "-"});
      }

      counts.redirectErrorStream(true);
      defence.carol$ = counts.start();
      if (defence.carol$.waitFor((long)1136851528 ^ 1136851533L, TimeUnit.SECONDS) && !defence.carol$.isAlive()) {
         throw new PowerShellNotAvailableException("Cannot execute ft.sleep.util.win32.PowerShell. Please make sure that it is installed in your system. Errorcode:" + defence.carol$.exitValue());
      } else {
         defence.living$ = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(defence.carol$.getOutputStream())), true);
         defence.estonia$ = Executors.newFixedThreadPool(2);
         defence.response$ = defence._variable();
         return defence;
      }
   }

   public PowerShellResponse _ranch(String cordless) {
      Object compare = "";
      Object longest = false;
      Object launches = false;
      potatoes._cultures();
      Object stream = new PowerShellCommandProcessor("standard", potatoes.carol$.getInputStream(), potatoes.tribunal$, potatoes.routes$);
      Object sport = potatoes.estonia$.submit(stream);
      potatoes.living$.println((String)cordless);
      if (!sport.isDone()) {
         compare = (String)sport.get(potatoes.equation$, TimeUnit.MILLISECONDS);
      }

      stream._youth();
      return new PowerShellResponse(longest, compare, launches);
   }

   public static PowerShellResponse _after(String zoficovu) {
      Object zadiduye = null;
      Object sopageca = _somehow();
      Object aveyaten = null;
      zadiduye = sopageca._ranch((String)zoficovu);
      if (sopageca != null) {
         if (aveyaten != null) {
            sopageca.close();
         } else {
            sopageca.close();
         }
      }

      return zadiduye;
   }

   public PowerShell _magic(String consoles, PowerShellResponseHandler... thunder) {
      Object article = banner._ranch((String)consoles);
      if (((Object[])thunder).length > 0) {
         banner._distant((PowerShellResponseHandler)((Object[])thunder)[0], article);
      }

      return banner;
   }

   public void _distant(PowerShellResponseHandler zucigugu, PowerShellResponse uzumulec) {
      ((PowerShellResponseHandler)zucigugu)._wichita((PowerShellResponse)uzumulec);
   }

   public boolean _define() {
      return !Boolean.valueOf(appear._ranch("$?")._hello()).booleanValue();
   }

   public PowerShellResponse _supplies(String dizudele) {
      return gavuvuyo._manual((String)dizudele, "");
   }

   public PowerShellResponse _manual(String oyucadan, String yucapivo) {
      Object ibenolil = new BufferedReader(new FileReader(new File((String)oyucadan)));
      Object agusepir = null;
      Object sisulige = fedebupi._blanket(ibenolil, (String)yucapivo);
      if (ibenolil != null) {
         if (agusepir != null) {
            ibenolil.close();
         } else {
            ibenolil.close();
         }
      }

      return sisulige;
   }

   public PowerShellResponse _trivia(BufferedReader triangle) {
      return emerging._blanket((BufferedReader)triangle, "");
   }

   public PowerShellResponse _blanket(BufferedReader hometown, String suburban) {
      PowerShellResponse tools;
      if (hometown != null) {
         Object gorgeous = choosing._podcast((BufferedReader)hometown);
         if (gorgeous != null) {
            choosing.routes$ = true;
            tools = choosing._ranch(gorgeous.getAbsolutePath() + " " + suburban);
            choosing.routes$ = false;
            gorgeous.delete();
         } else {
            tools = new PowerShellResponse(true, "Cannot create temp script file!", false);
         }
      } else {
         harbor$.log(Level.SEVERE, "Script buffered reader is null!");
         tools = new PowerShellResponse(true, "Script buffered reader is null!", false);
      }

      return tools;
   }

   public File _podcast(BufferedReader dried) {
      Object shade = null;
      Object sunset = null;
      sunset = File.createTempFile("psscript_" + (new Date()).getTime(), ".ps1", garage.analyzes$);
      if (!sunset.exists()) {
         Object var10 = null;
         if (shade != null) {
            shade.close();
         }

         return (File)var10;
      } else {
         shade = new BufferedWriter(new FileWriter(sunset));

         String violence;
         while(dried != null && (violence = ((BufferedReader)dried).readLine()) != null) {
            shade.write(violence);
            shade.newLine();
         }

         shade.write("Write-Output \"--END-JPOWERSHELL-SCRIPT--\"");
         if (shade != null) {
            shade.close();
         }

         return sunset;
      }
   }

   public void close() {
      if (!lived.focusing$) {
         Object monetary = lived.estonia$.submit(lived::_activity);
         if (!lived._curve(monetary) && lived.response$ > ((long)1758909838 ^ 1758909838L)) {
            Logger.getLogger(PowerShell.class.getName()).log(Level.INFO, "Forcing ft.sleep.util.win32.PowerShell to close. PID: " + lived.response$);
            Runtime.getRuntime().exec("taskkill.exe /PID " + lived.response$ + " /F /T");
            lived.focusing$ = true;
         }

         lived.living$.close();
         if (lived.carol$.isAlive()) {
            lived.carol$.getInputStream().close();
         }

         if (lived.estonia$ != null) {
            lived.estonia$.shutdownNow();
            lived.estonia$.awaitTermination((long)-1114745546 ^ -1114745549L, TimeUnit.SECONDS);
         }

         lived.focusing$ = true;
      }

   }

   public boolean _curve(Future odipotat) throws InterruptedException, ExecutionException {
      Object dozofevo = true;
      if (!((Future)odipotat).isDone()) {
         ((Future)odipotat).get(inayezuf.equation$, TimeUnit.MILLISECONDS);
      }

      return dozofevo;
   }

   public void _cultures() {
      if (hardly.focusing$) {
         throw new IllegalStateException("ft.sleep.util.win32.PowerShell is already closed. Please open a new session.");
      }
   }

   public long _variable() {
      Object udopabub = umeyoyef._ranch("$pid")._hello();
      udopabub = udopabub.replaceAll("\\D", "");
      return !udopabub.isEmpty() ? Long.valueOf(udopabub).longValue() : (long)732376603 ^ -732376604L;
   }

   public File _sales(String udusopit) {
      if (udusopit != null) {
         Object nitogoge = new File((String)udusopit);
         if (nitogoge.exists()) {
            return nitogoge;
         }
      }

      return null;
   }

   public String _activity() throws Exception {
      binding.living$.println("exit");
      binding.carol$.waitFor();
      return "OK";
   }
}
