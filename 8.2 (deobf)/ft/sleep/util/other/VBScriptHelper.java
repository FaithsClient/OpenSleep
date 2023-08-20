package ft.sleep.util.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VBScriptHelper {
   public static String adobe$ = "\r\n";

   public static String _bigger(String rocusipe) {
      Object fenenuca = "";
      Object guvilazu = null;
      Object naboyubo = null;
      Object osazedop = null;
      Object upudeyan = null;
      guvilazu = File.createTempFile("wmi4java" + (new Date()).getTime(), ".vbs");
      naboyubo = new FileWriter(guvilazu);
      naboyubo.write((String)rocusipe);
      naboyubo.flush();
      naboyubo.close();
      Object ziyofoce = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/C", "cscript.exe", "/NoLogo", guvilazu.getAbsolutePath()});
      osazedop = new BufferedReader(new InputStreamReader(ziyofoce.getInputStream()));

      String focumosi;
      while((focumosi = osazedop.readLine()) != null) {
         if (!focumosi.isEmpty()) {
            fenenuca = fenenuca + focumosi + "\r\n";
         }
      }

      if (fenenuca.isEmpty()) {
         upudeyan = new BufferedReader(new InputStreamReader(ziyofoce.getInputStream()));
         Object uvireyup = "";

         while((focumosi = upudeyan.readLine()) != null) {
            if (!focumosi.isEmpty()) {
               uvireyup = uvireyup + focumosi + "\r\n";
            }
         }

         if (!uvireyup.isEmpty()) {
            Logger.getLogger(VBScriptHelper.class.getName()).log(Level.SEVERE, "WMI operation finished in error: ");
         }

         upudeyan.close();
      }

      if (osazedop != null) {
         osazedop.close();
      }

      if (upudeyan != null) {
         upudeyan.close();
      }

      if (naboyubo != null) {
         naboyubo.close();
      }

      if (guvilazu != null) {
         guvilazu.delete();
      }

      return fenenuca.trim();
   }

   public static String _expansys() {
      Object itozapul = new StringBuilder(200);
      itozapul.append("Set objWMIService=GetObject(\"winmgmts:{impersonationLevel=impersonate}!\\\\").append(".").append("/").append("root/cimv2").append("\")").append("\r\n");
      itozapul.append("Set colProcessList = objWMIService.ExecQuery(\"Select * from Win32_Process\")").append("\r\n");
      itozapul.append("For Each objProcess in colProcessList").append("\r\n");
      itozapul.append("colProperties = objProcess.GetOwner(strNameOfUser,strUserDomain)").append("\r\n");
      itozapul.append("Wscript.Echo objProcess.ProcessId & \":\" & strNameOfUser").append("\r\n");
      itozapul.append("Next").append("\r\n");
      return _bigger(itozapul.toString());
   }

   public static String _chairman(int selected, int valid) {
      Object randy = new StringBuilder(200);
      randy.append("Set objWMIService=GetObject(\"winmgmts:{impersonationLevel=impersonate}!\\\\").append(".").append("/").append("root/cimv2").append("\")").append("\r\n");
      randy.append("Set colProcesses = objWMIService.ExecQuery(\"Select * from Win32_Process Where ProcessId = ").append((int)selected).append("\")").append("\r\n");
      randy.append("For Each objProcess in colProcesses").append("\r\n");
      randy.append("objProcess.SetPriority(").append((int)valid).append(")").append("\r\n");
      randy.append("Next").append("\r\n");
      return _bigger(randy.toString());
   }
}
