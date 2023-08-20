package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.injection.Hypixel;

public class StaffAnalyser implements Runnable {
   public StaffAnalyser2 propose$;

   public StaffAnalyser(StaffAnalyser2 bezodore) {
      baramuru.propose$ = (StaffAnalyser2)bezodore;
      super();
   }

   public void run() {
      Object fapesetu = Hypixel.getBanStats();
      if (StaffAnalyser2.talented$.getValue().booleanValue()) {
         Client.().("Watchdog (+" + fapesetu[0] + ")");
         Client.().("Staff (+" + fapesetu[1] + ")");
      }

   }
}
