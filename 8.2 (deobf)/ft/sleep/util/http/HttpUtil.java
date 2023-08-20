package ft.sleep.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;

public class HttpUtil {
   public static HttpURLConnection _stevens(URL inasocaz) throws IOException {
      Validate.notNull(inasocaz);
      Object curotaza = (HttpURLConnection)((URL)inasocaz).openConnection();
      curotaza.setConnectTimeout(15000);
      curotaza.setReadTimeout(15000);
      curotaza.setUseCaches(false);
      return curotaza;
   }

   public static String _barely(URL ugamupoz, boolean zenirozi) throws IOException {
      return (new HttpUtil())._fishing((URL)ugamupoz, (boolean)zenirozi);
   }

   public static String _plant(URL ravavale) throws IOException {
      return (new HttpUtil())._fishing((URL)ravavale, false);
   }

   public String _fishing(URL olympic, boolean bacteria) throws IOException {
      Validate.notNull(olympic);
      Object tourism = _stevens((URL)olympic);
      Object knife = null;
      tourism.setRequestProperty("user-agent", "Mozilla/5.0 AppIeWebKit");
      knife = tourism.getInputStream();
      Object output = IOUtils.toString(knife, Charsets.UTF_8);
      IOUtils.closeQuietly(knife);
      return output;
   }

   public static String _pokemon(String ogamivig, String zuzoyeva) {
      Object evuzeyap = null;
      Object ozomepuz = null;
      Object rebizofo = "";
      Object totedase = new URL((String)ogamivig);
      Object ifozimib = totedase.openConnection();
      ifozimib.setRequestProperty("accept", "*/*");
      ifozimib.setRequestProperty("connection", "Keep-Alive");
      ifozimib.setRequestProperty("user-agent", "Mozilla/5.0 AppIeWebKit");
      ifozimib.setDoOutput(true);
      ifozimib.setDoInput(true);
      evuzeyap = new PrintWriter(ifozimib.getOutputStream());
      evuzeyap.print((String)zuzoyeva);
      evuzeyap.flush();

      String ecamupol;
      for(ozomepuz = new BufferedReader(new InputStreamReader(ifozimib.getInputStream())); (ecamupol = ozomepuz.readLine()) != null; rebizofo = rebizofo + ecamupol) {
         ;
      }

      if (evuzeyap != null) {
         evuzeyap.close();
      }

      if (ozomepuz != null) {
         ozomepuz.close();
      }

      return rebizofo;
   }
}
