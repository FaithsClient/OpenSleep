package rip.sleep.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.lang3.Validate;

public class HttpUtilD {
   public static int c33768 = -1;
   public static int c14678 = -1;
   public static int[] c64587 = new int[2];
   public static int[] c84272 = new int[2];
   public static long c21473 = 0L;

   public static HttpURLConnection c37971(URL var0) throws IOException {
      Validate.notNull(var0);
      HttpURLConnection var1 = (HttpURLConnection)var0.openConnection();
      var1.setConnectTimeout(15000);
      var1.setReadTimeout(15000);
      var1.setUseCaches(false);
      return var1;
   }

   public String c50141(URL param1, boolean param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public static String c24828(URL var0) throws IOException {
      return (new HttpUtilB()).c58737(var0, false);
   }

   public static int[] c60972() {
      // $FF: Couldn't be decompiled
   }

   private static Exception c16375(Exception var0) {
      return var0;
   }
}
