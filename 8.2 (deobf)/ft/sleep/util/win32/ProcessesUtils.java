package ft.sleep.util.win32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Locale.Category;

public class ProcessesUtils {
   public static String omega$ = "\r\n";
   public static String browser$;
   public static Locale surveys$;

   public static String _editors(String... maine) {
      Object adopted = null;
      Object routers = new ProcessBuilder((String[])maine);
      routers.redirectErrorStream(true);
      adopted = _laundry(routers.start());
      return adopted;
   }

   public static String _laundry(Process welsh) {
      Object blond = new StringBuilder();
      Object dense = null;
      dense = new BufferedReader(new InputStreamReader(((Process)welsh).getInputStream()));

      String practice;
      while((practice = dense.readLine()) != null) {
         if (!practice.isEmpty()) {
            blond.append(practice).append("\r\n");
         }
      }

      if (dense != null) {
         dense.close();
      }

      return blond.toString();
   }

   public static int _camping(String... mountain) {
      Object acres = Runtime.getRuntime().exec((String[])mountain);
      acres.waitFor();
      return acres.exitValue();
   }

   public static String _hybrid(String hartford) {
      Object operator = (String)hartford;
      if (hartford != null && !((String)hartford).isEmpty()) {
         Object deeper = ((String)hartford).substring(8, 10);
         Object surname = ((String)hartford).substring(10, 12);
         Object might = ((String)hartford).substring(12, 14);
         operator = deeper + ":" + surname + ":" + might;
      }

      return operator;
   }

   public static String _tobacco(String reggae) {
      Object reminder = (String)reggae;
      if (reggae != null && !((String)reggae).isEmpty()) {
         Object delta = ((String)reggae).substring(0, 4);
         Object forests = ((String)reggae).substring(4, 6);
         Object members = ((String)reggae).substring(6, 8);
         Object pamela = ((String)reggae).substring(8, 10);
         Object heading = ((String)reggae).substring(10, 12);
         Object objects = ((String)reggae).substring(12, 14);
         reminder = forests + "/" + members + "/" + delta + " " + pamela + ":" + heading + ":" + objects;
      }

      return reminder;
   }

   public static String _themes(String affair) throws ParseException {
      Object hired = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      Object linear = new ArrayList();
      linear.addAll(Arrays.asList("MMM dd HH:mm:ss yyyy", "dd MMM HH:mm:ss yyyy"));
      Object color = new ArrayList();
      color.addAll(Arrays.asList(Locale.getDefault(), Locale.getDefault(Category.FORMAT), Locale.ENGLISH));
      if (_wiring() != null) {
         linear.add(0, _wiring());
      }

      if (_herein() != null) {
         color.add(0, _herein());
      }

      Object restrict = null;

      for(Object debate : color) {
         Object teaching = linear.iterator();
         if (teaching.hasNext()) {
            Object kuwait = (String)teaching.next();
            Object heater = new SimpleDateFormat(kuwait, debate);
            return hired.format(heater.parse((String)affair));
         }
      }

      throw restrict;
   }

   public static String _wiring() {
      return browser$;
   }

   public static void _overview(String shipment) {
      browser$ = (String)shipment;
   }

   public static Locale _herein() {
      return surveys$;
   }

   public static void _screw(Locale coffee) {
      surveys$ = (Locale)coffee;
   }
}
