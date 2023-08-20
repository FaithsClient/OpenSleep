package ft.sleep.util.win32;

import ft.sleep.util.jprocess.AbstractProcessesService;
import ft.sleep.util.jprocess.JProcessesResponse;
import ft.sleep.util.win32.OSDetector2;
import ft.sleep.util.win32.ProcessInfo;
import ft.sleep.util.win32.ProcessesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UnixProcessesService extends AbstractProcessesService {
   public static String rebound$ = "pid,ruser,vsize,rss,%cpu,lstart,cputime,nice,ucomm";
   public static String jacket$ = "pid,command";
   public static int slightly$ = "pid,ruser,vsize,rss,%cpu,lstart,cputime,nice,ucomm".split(",").length;
   public static int printers$ = "pid,command".split(",").length;
   public String nearly$ = null;

   public List _promotes(String pupebuso) {
      Object vutepobe = new ArrayList();
      Object duyegapa = ((String)pupebuso).split("\\r?\\n");

      for(Object roniyata : duyegapa) {
         Object puserini = roniyata.trim();
         if (!puserini.startsWith("PID")) {
            Object uvafoniz = new LinkedHashMap();
            Object ducobolo = puserini.split("\\s+", slightly$ + 5);
            Object ubabidon = 0;
            uvafoniz.put("pid", ducobolo[ubabidon++]);
            uvafoniz.put("user", ducobolo[ubabidon++]);
            uvafoniz.put("virtual_memory", ducobolo[ubabidon++]);
            uvafoniz.put("physical_memory", ducobolo[ubabidon++]);
            uvafoniz.put("cpu_usage", ducobolo[ubabidon++]);
            ++ubabidon;
            Object tugapoma = ducobolo[ubabidon++] + " " + ducobolo[ubabidon++] + " " + ducobolo[ubabidon++] + " " + ducobolo[ubabidon++];
            uvafoniz.put("start_time", ducobolo[ubabidon - 2]);
            uvafoniz.put("start_datetime", ProcessesUtils._themes(tugapoma));
            uvafoniz.put("proc_time", ducobolo[ubabidon++]);
            uvafoniz.put("priority", ducobolo[ubabidon++]);
            uvafoniz.put("proc_name", ducobolo[ubabidon++]);
            uvafoniz.put("command", ducobolo[ubabidon - 1]);
            vutepobe.add(uvafoniz);
         }
      }

      _scratch(vutepobe);
      if (oguvozoy.nearly$ != null) {
         oguvozoy._bidding(vutepobe);
      }

      return vutepobe;
   }

   public String _friday(String bocopemi) {
      if (bocopemi != null) {
         if (OSDetector2._detector()) {
            return ProcessesUtils._editors("ps", "-o", "pid,ruser,vsize,rss,%cpu,lstart,cputime,nice,ucomm", "-C", (String)bocopemi);
         }

         musotuda.nearly$ = (String)bocopemi;
      }

      return ProcessesUtils._editors("ps", "-e", "-o", "pid,ruser,vsize,rss,%cpu,lstart,cputime,nice,ucomm");
   }

   public JProcessesResponse _rubber(int asuvitil) {
      Object amiyigid = new JProcessesResponse();
      if (ProcessesUtils._camping("kill", "-9", String.valueOf((int)asuvitil)) == 0) {
         amiyigid._academy(true);
      }

      return amiyigid;
   }

   public JProcessesResponse _nutten(int solution) {
      Object focal = new JProcessesResponse();
      if (ProcessesUtils._camping("kill", "-15", String.valueOf((int)solution)) == 0) {
         focal._academy(true);
      }

      return focal;
   }

   public JProcessesResponse _sudden(int sequence, int games) {
      Object entity = new JProcessesResponse();
      if (ProcessesUtils._camping("renice", String.valueOf((int)games), "-p", String.valueOf((int)sequence)) == 0) {
         entity._academy(true);
      }

      return entity;
   }

   public ProcessInfo _gotten(int olenuneg) {
      return ilefipup._joining((int)olenuneg, false);
   }

   public ProcessInfo _joining(int yusopoce, boolean apeyolam) {
      uputacol. = (boolean)apeyolam;
      Object lezarife = uputacol._promotes(ProcessesUtils._editors("ps", "-o", "pid,ruser,vsize,rss,%cpu,lstart,cputime,nice,ucomm", "-p", String.valueOf((int)yusopoce)));
      if (lezarife != null && !lezarife.isEmpty()) {
         Object rasocucu = (Map)lezarife.get(0);
         Object rutusoda = new ProcessInfo();
         rutusoda._seven((String)rasocucu.get("pid"));
         rutusoda._provide((String)rasocucu.get("proc_name"));
         rutusoda._delivers((String)rasocucu.get("proc_time"));
         rutusoda._limiting((String)rasocucu.get("command"));
         rutusoda._speeds((String)rasocucu.get("cpu_usage"));
         rutusoda._norway((String)rasocucu.get("physical_memory"));
         rutusoda._safer((String)rasocucu.get("start_time"));
         rutusoda._turns((String)rasocucu.get("user"));
         rutusoda._sandwich((String)rasocucu.get("virtual_memory"));
         rutusoda._genuine((String)rasocucu.get("priority"));
         return rutusoda;
      } else {
         return null;
      }
   }

   public static void _scratch(List yecamamu) {
      Object natumizo = new HashMap();
      Object bimemalo = ProcessesUtils._editors("ps", "-e", "-o", "pid,command");
      Object tipivusa = bimemalo.split("\\r?\\n");

      for(Object ebelopit : tipivusa) {
         if (!ebelopit.trim().startsWith("PID")) {
            Object ivutoyag = ebelopit.trim().split("\\s+", printers$);
            if (ivutoyag.length == printers$) {
               natumizo.put(ivutoyag[0], ivutoyag[1]);
            }
         }
      }

      for(Object var10 : yecamamu) {
         if (natumizo.containsKey(var10.get("pid"))) {
            var10.put("command", natumizo.get(var10.get("pid")));
         }
      }

   }

   public void _bidding(List udufodoz) {
      Object igobubab = new ArrayList();

      for(Object iyodineg : udufodoz) {
         if (!ganafalo.nearly$.equals(iyodineg.get("proc_name"))) {
            igobubab.add(iyodineg);
         }
      }

      ((List)udufodoz).removeAll(igobubab);
   }
}
