package ft.sleep.util.win32;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WMIPowerShell implements WMIStub {
   public static String fairy$ = "-Namespace ";
   public static String brass$ = "-ComputerName ";
   public static String booking$ = "Get-WMIObject ";

   public static String _tourist(String oriental) throws WMIException {
      Object publish = null;
      Object consists = null;
      consists = PowerShell._somehow();
      Object jimmy = new HashMap();
      jimmy.put("maxWait", "20000");
      Object mitchell = consists._missile(jimmy)._ranch((String)oriental);
      if (mitchell._fitting()) {
         throw new WMIException("WMI operation finished in error: " + mitchell._hello());
      } else {
         publish = mitchell._hello().trim();
         consists.close();
         if (consists != null) {
            consists.close();
         }

         return publish;
      }
   }

   public String _coral(String iyibidab, String adanubem) throws WMIException {
      String var3 = "";
      if (!"*".equals(iyibidab)) {
         var3 = var3 + "-Namespace " + iyibidab;
      }

      return _tourist("Get-WMIObject " + var3 + " -List | Sort Name");
   }

   public String _airfare(String damaged, String chargers, String percent) throws WMIException {
      Object cancel = blind._cartoons((String)damaged, (String)chargers, (String)percent);
      cancel = cancel + " | ";
      cancel = cancel + "Select-Object * -excludeproperty \"_*\" | ";
      cancel = cancel + "Get-Member | select name | format-table -hidetableheader";
      return _tourist(cancel);
   }

   public String _signing(String disks, String pottery, String rally) throws WMIException {
      Object court = seattle._cartoons((String)disks, (String)pottery, (String)rally);
      court = court + " | ";
      court = court + "Select-Object * -excludeproperty \"_*\" | ";
      court = court + "Format-List *";
      return _tourist(court);
   }

   public String _drilling(String icitetov, List gamebosi, List uvulebiv, String tonapila, String ofogoder) throws WMIException {
      Object oyanesob = onugareb._cartoons((String)icitetov, (String)tonapila, (String)ofogoder);
      List inecacov;
      if (gamebosi != null && !((List)gamebosi).isEmpty()) {
         inecacov = (List)gamebosi;
      } else {
         inecacov = Collections.singletonList("*");
      }

      oyanesob = oyanesob + " | ";
      oyanesob = oyanesob + "Select-Object " + WMI4JavaUtil._scared(", ", inecacov) + " -excludeproperty \"_*\" | ";
      if (uvulebiv != null && !((List)uvulebiv).isEmpty()) {
         for(Object udetaceb : uvulebiv) {
            oyanesob = oyanesob + "Where-Object -FilterScript {" + udetaceb + "} | ";
         }
      }

      oyanesob = oyanesob + "Format-List *";
      return _tourist(oyanesob);
   }

   public String _cartoons(String morocco, String throat, String baseline) {
      Object angel = "Get-WMIObject " + morocco + " ";
      if (!"*".equals(throat)) {
         angel = angel + "-Namespace " + throat + " ";
      }

      if (!((String)baseline).isEmpty()) {
         angel = angel + "-ComputerName " + baseline + " ";
      }

      return angel;
   }
}
