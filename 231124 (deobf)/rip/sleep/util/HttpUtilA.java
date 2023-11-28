package rip.sleep.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class HttpUtilA {
   public static JSONObject c87184(String var0) {
      URL var10000 = new URL;
      URL var10001 = var10000;
      String var10002 = var0;

      try {
         var10001.<init>(var10002);
         URL var1 = var10000;
         HttpURLConnection var2 = (HttpURLConnection)var1.openConnection();
         var2.setRequestMethod("GET");
         var2.addRequestProperty("User-Agent", "Mozilla/4.76 (Sk1er-UHCStars V1.0)");
         InputStream var3 = var2.getInputStream();
         return new JSONObject(IOUtils.toString(var3, Charset.defaultCharset()));
      } catch (Exception var4) {
         var4.printStackTrace();
         return (new JSONObject()).put("succcess", false).put("cause", "API_DOWN");
      }
   }
}
