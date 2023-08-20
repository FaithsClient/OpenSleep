package ft.sleep.injection;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;

public class Hypixel {
   public static int lastTotalWatchdogBans = -1;
   public static int lastTotalStaffBans = -1;
   public static int[] bansAtStart = new int[2];
   public static int[] bansSinceStart = new int[2];
   public static long timeSinceLastCheck = 0L;

   public static HttpURLConnection createUrlConnection(URL url) throws IOException {
      Validate.notNull(url);
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setConnectTimeout(15000);
      connection.setReadTimeout(15000);
      connection.setUseCaches(false);
      return connection;
   }

   public String performGetRequestWithoutStatic(URL url, boolean withKey) throws IOException {
      Validate.notNull(url);
      HttpURLConnection connection = createUrlConnection(url);
      InputStream inputStream = null;
      connection.setRequestProperty("user-agent", "Mozilla/5.0 AppIeWebKit");

      String var6;
      try {
         try {
            inputStream = connection.getInputStream();
            String var10 = IOUtils.toString(inputStream, Charsets.UTF_8);
            return var10;
         } catch (IOException var11) {
            IOUtils.closeQuietly(inputStream);
            inputStream = connection.getErrorStream();
            if (inputStream == null) {
               throw var11;
            }
         }

         String result = IOUtils.toString(inputStream, Charsets.UTF_8);
         var6 = result;
      } finally {
         IOUtils.closeQuietly(inputStream);
      }

      return var6;
   }

   public static String performGetRequest(URL url) throws IOException {
      return (new ()).performGetRequestWithoutStatic(url, false);
   }

   public static int[] getBanStats() {
      try {
         String result = .performGetRequest(new URL("https://api.slothpixel.me/api/bans"));
         Gson gson = new Gson();
         BanStats banStats = (BanStats)gson.fromJson(result, BanStats.class);
         int watchdogBans = banStats.getWatchdog().getTotal() - lastTotalWatchdogBans;
         int staffBans = banStats.getStaff().getTotal() - lastTotalStaffBans;
         if (lastTotalStaffBans == -1 && lastTotalWatchdogBans == -1) {
            lastTotalStaffBans = banStats.getStaff().getTotal();
            lastTotalWatchdogBans = banStats.getWatchdog().getTotal();
            bansAtStart = new int[]{lastTotalWatchdogBans, lastTotalStaffBans};
         }

         bansSinceStart = new int[]{banStats.getWatchdog().getTotal() - bansAtStart[0], banStats.getStaff().getTotal() - bansAtStart[1]};
         lastTotalStaffBans = banStats.getStaff().getTotal();
         lastTotalWatchdogBans = banStats.getWatchdog().getTotal();
         timeSinceLastCheck = System.currentTimeMillis();
         return new int[]{watchdogBans, staffBans};
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }
}
