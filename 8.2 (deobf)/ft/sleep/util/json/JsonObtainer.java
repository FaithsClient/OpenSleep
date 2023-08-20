package ft.sleep.util.json;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class JsonObtainer {
   public static JSONObject _opinions(String tinasibu) {
      Object ifapovut = new URL((String)tinasibu);
      Object dalabite = (HttpURLConnection)ifapovut.openConnection();
      dalabite.setRequestMethod("GET");
      dalabite.addRequestProperty("User-Agent", "Mozilla/4.76 (Sk1er-UHCStars V1.0)");
      Object ogifuber = dalabite.getInputStream();
      return new JSONObject(IOUtils.toString(ogifuber, Charset.defaultCharset()));
   }
}
