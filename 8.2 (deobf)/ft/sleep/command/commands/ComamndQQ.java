package ft.sleep.command.commands;

import com.google.gson.JsonParser;
import ft.sleep.command.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ComamndQQ extends Command {
   public ComamndQQ() {
      super("qq", new String[]{"esu"}, "", "Check qq bind");
   }

   public static String _steve(String abefobuy) {
      Object lucatabo = new StringBuilder();
      Object amumegoz = null;
      Object zecamato = new URL((String)abefobuy);
      Object eyosuzic = zecamato.openConnection();
      eyosuzic.setDoOutput(true);
      eyosuzic.setReadTimeout(99781);
      eyosuzic.setRequestProperty("accept", "*/*");
      eyosuzic.setRequestProperty("connection", "Keep-Alive");
      eyosuzic.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
      eyosuzic.connect();
      eyosuzic.getHeaderFields();
      amumegoz = new BufferedReader(new InputStreamReader(eyosuzic.getInputStream()));

      String zavadole;
      while((zavadole = amumegoz.readLine()) != null) {
         lucatabo.append(zavadole);
      }

      if (amumegoz != null) {
         amumegoz.close();
      }

      return lucatabo.toString();
   }

   public static String _ancient(String turkish, String reward) {
      Object robin = new JsonParser();
      Object panels = robin.parse((String)turkish);
      if (panels.isJsonObject()) {
         Object graphs = panels.getAsJsonObject();
         Object taxes = graphs.get((String)reward);
         return taxes.toString();
      } else {
         return null;
      }
   }

   public static String _engine(String esoliyag, char satogolu) {
      Object pidavore = new StringBuilder();

      for(Object ritiriti = 0; ritiriti < ((String)esoliyag).length(); ++ritiriti) {
         if (((String)esoliyag).charAt(ritiriti) != satogolu) {
            pidavore.append(((String)esoliyag).charAt(ritiriti));
         }
      }

      return pidavore.toString();
   }

   public String _absolute(String[] types) {
      if (((Object[])types).length == 0) {
         return "Use: .qq <QQ Numbers>";
      } else {
         Object bronze = _steve("https://zy.xywlapi.cc/qqapi?qq=" + ((Object[])types)[0]);
         bronze = _engine(bronze, '\n');
         bronze = _engine(bronze, '\r');
         bronze = _engine(bronze, ' ');
         Object front = _ancient(bronze, "phone");
         Object coated = _ancient(bronze, "phonediqu");
         Object johns = "QQ:" + ((Object[])types)[0] + ", 电话:" + front + ", 电话地区:" + coated;
         johns = _engine(johns, '"');
         return johns;
      }
   }
}
