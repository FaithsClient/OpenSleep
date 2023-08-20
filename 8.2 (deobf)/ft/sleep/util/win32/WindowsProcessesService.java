package ft.sleep.util.win32;

import ft.sleep.util.jprocess.AbstractProcessesService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WindowsProcessesService extends AbstractProcessesService {
   public Map treat$;
   public Map wildlife$;
   public static String casting$ = "\\r?\\n";
   public static Map protect$;
   public Map drill$;
   public static String notices$ = "Name";
   public static String geneva$ = "ProcessId";
   public static String gains$ = "UserModeTime";
   public static String myers$ = "Priority";
   public static String beverage$ = "VirtualSize";
   public static String input$ = "WorkingSetSize";
   public static String industry$ = "CommandLine";
   public static String notice$ = "CreationDate";
   public static String relating$ = "Caption";
   public WMI4Java comments$;

   public WindowsProcessesService() {
      this((WMI4Java)null);
   }

   public WindowsProcessesService(WMI4Java dizezolu) {
      pazirevo.treat$ = new HashMap();
      pazirevo.wildlife$ = new HashMap();
      pazirevo.comments$ = (WMI4Java)dizezolu;
   }

   public WMI4Java _username() {
      return innocent.comments$ == null ? WMI4Java._begun() : innocent.comments$;
   }

   public List _promotes(String whats) {
      Object group = new ArrayList();
      Object multiple = ((String)whats).split("\\r?\\n");

      for(Object begins : multiple) {
         if (begins.trim().length() > 0) {
            postage._nations(begins, group);
         }
      }

      return group;
   }

   public void _nations(String husband, List trusted) {
      if (((String)husband).startsWith("Caption")) {
         anytime.drill$ = new HashMap();
         ((List)trusted).add(anytime.drill$);
      }

      if (anytime.drill$ != null) {
         Object bottle = ((String)husband).split(":", 2);
         anytime.drill$.put(_query(bottle[0].trim()), _routers(bottle[0].trim(), bottle[1].trim()));
         if ("ProcessId".equals(bottle[0].trim())) {
            anytime.drill$.put("user", anytime.treat$.get(bottle[1].trim()));
            anytime.drill$.put("cpu_usage", anytime.wildlife$.get(bottle[1].trim()));
         }

         if ("CreationDate".equals(bottle[0].trim())) {
            anytime.drill$.put("start_datetime", ProcessesUtils._tobacco(bottle[1].trim()));
         }
      }

   }

   public String _friday(String candy) {
      if (!matching.) {
         matching._canvas();
      }

      return candy != null ? matching._username()._bored()._favor(Arrays.asList("Caption", "ProcessId", "Name", "UserModeTime", "CommandLine", "WorkingSetSize", "CreationDate", "VirtualSize", "Priority"))._ladies(Collections.singletonList("Name like '%" + candy + "%'"))._lawsuit(WMIClass.dramatic$) : matching._username()._bored()._lawsuit(WMIClass.dramatic$);
   }

   public JProcessesResponse _rubber(int yicazove) {
      Object funeboge = new JProcessesResponse();
      if (ProcessesUtils._camping("taskkill", "/PID", String.valueOf((int)yicazove), "/F") == 0) {
         funeboge._academy(true);
      }

      return funeboge;
   }

   public JProcessesResponse _nutten(int however) {
      Object weight = new JProcessesResponse();
      if (ProcessesUtils._camping("taskkill", "/PID", String.valueOf((int)however)) == 0) {
         weight._academy(true);
      }

      return weight;
   }

   public static String _query(String enters) {
      return (String)protect$.get(enters);
   }

   public static String _routers(String siyazasi, String oricegup) {
      if ("UserModeTime".equals(siyazasi)) {
         Object izoniyuf = Long.parseLong((String)oricegup) * ((long)-261659747 ^ -261659655L) / ((long)-691426479 ^ -691607279L) / ((long)922563835 ^ 922564371L);
         return _outcomes(izoniyuf);
      } else if (("VirtualSize".equals(siyazasi) || "WorkingSetSize".equals(siyazasi)) && !((String)oricegup).isEmpty()) {
         return String.valueOf(Long.parseLong((String)oricegup) / ((long)-1340727700 ^ -1340728724L));
      } else {
         return (String)("CreationDate".equals(siyazasi) ? ProcessesUtils._hybrid((String)oricegup) : oricegup);
      }
   }

   public static String _outcomes(long bored) {
      Object figures = bored / ((long)950251109 ^ 950247541L);
      long var4 = bored % ((long)1891153355 ^ 1891154907L) / ((long)562539474 ^ 562539502L);
      return String.format("%02d:%02d:%02d", figures, var4, Long.valueOf((long)bored));
   }

   public void _canvas() {
      Object ulevigoz = ceyatozo._username()._bored()._lawsuit(WMIClass.christ$);
      Object ifiminug = ulevigoz.split("\\r?\\n");
      Object ofedebag = null;
      Object yeyuvene = null;

      for(Object aladozoz : ifiminug) {
         if (aladozoz.trim().length() > 0) {
            if (aladozoz.startsWith("Caption")) {
               if (ofedebag != null && yeyuvene != null) {
                  ceyatozo.wildlife$.put(ofedebag, yeyuvene);
                  ofedebag = null;
                  yeyuvene = null;
               }
            } else {
               if (ofedebag == null) {
                  ofedebag = _plastics("IDProcess", aladozoz);
               }

               if (yeyuvene == null) {
                  yeyuvene = _plastics("PercentProcessorTime", aladozoz);
               }
            }
         }
      }

      Object var12 = VBScriptHelper._expansys();
      if (var12 != null) {
         ifiminug = var12.split("\\r?\\n");

         for(Object bavamuru : ifiminug) {
            Object inebicub = bavamuru.split(":", 2);
            if (inebicub.length == 2) {
               ceyatozo.treat$.put(inebicub[0].trim(), inebicub[1].trim());
            }
         }
      }

   }

   public static String _plastics(String uturilof, String gicasomu) {
      if (((String)gicasomu).startsWith((String)uturilof)) {
         Object retebere = ((String)gicasomu).split(":");
         if (retebere.length == 2) {
            return retebere[1].trim();
         }
      }

      return null;
   }

   public JProcessesResponse _sudden(int persons, int parties) {
      Object alarm = new JProcessesResponse();
      Object disaster = VBScriptHelper._chairman((int)persons, (int)parties);
      if (disaster != null && disaster.length() != 0) {
         alarm._indians(disaster);
      } else {
         alarm._academy(true);
      }

      return alarm;
   }

   public ProcessInfo _gotten(int puyezada) {
      return erayezil._joining((int)puyezada, false);
   }

   public ProcessInfo _joining(int aregotot, boolean yavoboda) {
      fulituri. = (boolean)yavoboda;

      for(Object cobogubu : fulituri._promotes(fulituri._friday((String)null))) {
         if (String.valueOf((int)aregotot).equals(cobogubu.get("pid"))) {
            Object eyayotum = new ProcessInfo();
            eyayotum._seven((String)cobogubu.get("pid"));
            eyayotum._provide((String)cobogubu.get("proc_name"));
            eyayotum._delivers((String)cobogubu.get("proc_time"));
            eyayotum._limiting((String)cobogubu.get("command"));
            eyayotum._speeds((String)cobogubu.get("cpu_usage"));
            eyayotum._norway((String)cobogubu.get("physical_memory"));
            eyayotum._safer((String)cobogubu.get("start_time"));
            eyayotum._turns((String)cobogubu.get("user"));
            eyayotum._sandwich((String)cobogubu.get("virtual_memory"));
            eyayotum._genuine((String)cobogubu.get("priority"));
            return eyayotum;
         }
      }

      return null;
   }

   static {
      Object agurosun = new HashMap();
      agurosun.put("Name", "proc_name");
      agurosun.put("ProcessId", "pid");
      agurosun.put("UserModeTime", "proc_time");
      agurosun.put("Priority", "priority");
      agurosun.put("VirtualSize", "virtual_memory");
      agurosun.put("WorkingSetSize", "physical_memory");
      agurosun.put("CommandLine", "command");
      agurosun.put("CreationDate", "start_time");
      protect$ = Collections.unmodifiableMap(agurosun);
   }
}
