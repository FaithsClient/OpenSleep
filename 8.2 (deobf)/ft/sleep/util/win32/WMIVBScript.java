package ft.sleep.util.win32;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

public class WMIVBScript implements WMIStub {
   public static String fifty$ = "root/cimv2";
   public static String compile$ = "Set objWMIService=GetObject(\"winmgmts:{impersonationLevel=impersonate}!\\\\";
   public static String exist$ = "\r\n";

   public static String _ordinary(String rates) throws WMIException {
      Object plant = "";
      Object reports = null;
      Object hints = null;
      Object beings = null;
      reports = File.createTempFile("wmi4java" + (new Date()).getTime(), ".vbs");
      hints = new FileWriter(reports);
      hints.write((String)rates);
      hints.flush();
      hints.close();
      Object cluster = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/C", "cscript.exe", "/NoLogo", reports.getAbsolutePath()});
      Object centers = new BufferedReader(new InputStreamReader(cluster.getInputStream()));

      String karaoke;
      while((karaoke = centers.readLine()) != null) {
         if (!karaoke.isEmpty()) {
            plant = plant + karaoke + "\r\n";
         }
      }

      if (plant.isEmpty()) {
         beings = new BufferedReader(new InputStreamReader(cluster.getInputStream()));
         Object calvin = "";

         while((karaoke = beings.readLine()) != null) {
            if (!karaoke.isEmpty()) {
               calvin = calvin + karaoke + "\r\n";
            }
         }

         if (!calvin.isEmpty()) {
            throw new WMIException("WMI operation finished in error: " + calvin);
         }
      }

      if (hints != null) {
         hints.close();
      }

      if (reports != null) {
         reports.delete();
      }

      if (beings != null) {
         beings.close();
      }

      return plant.trim();
   }

   public String _coral(String eboyanim, String tezomute) throws WMIException {
      Object rebotiyo = new StringBuilder(200);
      Object efanidey = "root/cimv2";
      if (!"*".equals(eboyanim)) {
         efanidey = (String)eboyanim;
      }

      rebotiyo.append("Set objWMIService=GetObject(\"winmgmts:{impersonationLevel=impersonate}!\\\\").append((String)tezomute).append("/").append(efanidey).append("\")").append("\r\n");
      rebotiyo.append("Set colClasses = objWMIService.SubclassesOf()").append("\r\n");
      rebotiyo.append("For Each objClass in colClasses").append("\r\n");
      rebotiyo.append("For Each objClassQualifier In objClass.Qualifiers_").append("\r\n");
      rebotiyo.append("WScript.Echo objClass.Path_.Class").append("\r\n");
      rebotiyo.append("Next").append("\r\n");
      rebotiyo.append("Next").append("\r\n");
      return _ordinary(rebotiyo.toString());
   }

   public String _airfare(String posoluzo, String yelofalo, String fibuyoso) throws WMIException {
      Object uzilidon = new StringBuilder(200);
      Object edebugag = "root/cimv2";
      if (!"*".equals(yelofalo)) {
         edebugag = (String)yelofalo;
      }

      uzilidon.append("Set objWMIService=GetObject(\"winmgmts:{impersonationLevel=impersonate}!\\\\").append((String)fibuyoso).append("/").append(edebugag).append(":").append((String)posoluzo).append("\")").append("\r\n");
      uzilidon.append("For Each objClassProperty In objWMIService.Properties_").append("\r\n");
      uzilidon.append("WScript.Echo objClassProperty.Name").append("\r\n");
      uzilidon.append("Next").append("\r\n");
      return _ordinary(uzilidon.toString());
   }

   public String _signing(String superb, String ticket, String actions) throws WMIException {
      return execute._drilling((String)superb, (List)null, (List)null, (String)ticket, (String)actions);
   }

   public String _drilling(String ziruzila, List opofulor, List nenonoto, String edisipip, String amozobev) throws WMIException {
      List ricinodi;
      if (opofulor != null && !((List)opofulor).isEmpty()) {
         ricinodi = (List)opofulor;
      } else {
         ricinodi = WMI4Java._begun()._bored()._value((String)amozobev)._deleted((String)edisipip)._funny((String)ziruzila);
      }

      Object ozabugat = new StringBuilder(200);
      Object urusican = "root/cimv2";
      if (!"*".equals(edisipip)) {
         urusican = (String)edisipip;
      }

      ozabugat.append("Set objWMIService=GetObject(\"winmgmts:{impersonationLevel=impersonate}!\\\\").append((String)amozobev).append("/").append(urusican).append("\")").append("\r\n");
      ozabugat.append("Set colClasses = objWMIService.SubclassesOf()").append("\r\n");
      ozabugat.append("Set wmiQueryData = objWMIService.ExecQuery(\"Select ").append("*").append(" from ").append((String)ziruzila);
      if (nenonoto != null && !((List)nenonoto).isEmpty()) {
         ozabugat.append(" where ").append(WMI4JavaUtil._scared(" AND ", (Iterable)nenonoto));
      }

      ozabugat.append("\")").append("\r\n");
      ozabugat.append("For Each element In wmiQueryData").append("\r\n");

      for(Object cefipibu : ricinodi) {
         if (!cefipibu.equals("ConfigOptions")) {
            ozabugat.append("Wscript.Echo \"").append(cefipibu).append(": \" & ").append("element.").append(cefipibu).append("\r\n");
         } else {
            ozabugat.append("Wscript.Echo \"").append(cefipibu).append(": \" & ").append("Join(element.").append(cefipibu).append(", \"|\")").append("\r\n");
         }
      }

      ozabugat.append("Next").append("\r\n");
      return _ordinary(ozabugat.toString());
   }
}
