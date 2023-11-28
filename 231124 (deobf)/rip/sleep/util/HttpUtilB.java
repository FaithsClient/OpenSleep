package rip.sleep.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.lang3.Validate;

public class HttpUtilB {
   public static HttpURLConnection c68621(URL var0) throws IOException {
      Validate.notNull(var0);
      HttpURLConnection var1 = (HttpURLConnection)var0.openConnection();
      var1.setConnectTimeout(15000);
      var1.setReadTimeout(15000);
      var1.setUseCaches(false);
      return var1;
   }

   public static String c52546(URL var0, boolean var1) throws IOException {
      return (new HttpUtilB()).c58737(var0, var1);
   }

   public static String c29551(URL var0) throws IOException {
      return (new HttpUtilB()).c58737(var0, false);
   }

   public String c58737(URL param1, boolean param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public static String c470(String param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   private static IOException c90587(IOException var0) {
      return var0;
   }
}
