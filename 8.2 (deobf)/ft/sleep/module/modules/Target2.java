package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.command.Command;
import ft.sleep.ui.notification.Notification;
import ft.sleep.util.player.PlayerUtils;

public class Target2 extends Command {
   public Target weddings$;

   public Target2() {
      super("ft.sleep.module.modules.Target", new String[]{"ft.sleep.module.modules.Target", "target"}, "target", "ft.sleep.module.modules.Target Player");
   }

   public String _absolute(String[] otinotis) {
      if (((Object[])otinotis).length >= 2) {
         Object azefemoc = (String)((Object[])otinotis)[0];
         Object imavisof = -1;
         switch(azefemoc.hashCode()) {
         case -934610812:
            if (azefemoc.equals("remove")) {
               imavisof = 1;
            }
            break;
         case 96417:
            if (azefemoc.equals("add")) {
               imavisof = 0;
            }
            break;
         case 3322014:
            if (azefemoc.equals("list")) {
               imavisof = 3;
            }
            break;
         case 94746189:
            if (azefemoc.equals("clear")) {
               imavisof = 2;
            }
         }

         switch(imavisof) {
         case 0:
            divevope.weddings$ = Target.screen$;
            break;
         case 1:
            divevope.weddings$ = Target.peers$;
            break;
         case 2:
            divevope.weddings$ = Target.riding$;
            break;
         case 3:
            divevope.weddings$ = Target.helping$;
         }

         if (divevope.weddings$ == Target.screen$ && !((String)((Object[])otinotis)[1]).isEmpty()) {
            Client.surround$.().targetConfig.addTarget((String)((Object[])otinotis)[1]);
            Client.surround$.().saveConfig(Client.surround$.().targetConfig);
            PlayerUtils._snake("Add ft.sleep.module.modules.Target : " + ((Object[])otinotis)[1]);
            Client.surround$.()._arabia().add(new Notification("Add target " + ((Object[])otinotis)[1]));
         } else if (divevope.weddings$ == Target.peers$ && !((String)((Object[])otinotis)[1]).isEmpty()) {
            Client.surround$.().targetConfig.removeTarget((String)((Object[])otinotis)[1]);
            Client.surround$.().saveConfig(Client.surround$.().targetConfig);
            PlayerUtils._snake("Remove ft.sleep.module.modules.Target : " + ((Object[])otinotis)[1]);
            Client.surround$.()._arabia().add(new Notification("Remove target " + ((Object[])otinotis)[1]));
         }
      } else if (divevope.weddings$ == Target.riding$) {
         Client.surround$.().targetConfig.clearTarget();
         Client.surround$.().saveConfig(Client.surround$.().targetConfig);
         PlayerUtils._snake("Clear ft.sleep.module.modules.Target");
         Client.surround$.()._arabia().add(new Notification("Clear targets"));
      } else if (divevope.weddings$ == Target.helping$) {
         PlayerUtils._snake("--- You have " + Client.surround$.().targetConfig.getTargets().size() + " Targets ---");

         for(Object var5 : Client.surround$.().targetConfig.getTargets()) {
            PlayerUtils._snake(var5.getPlayerName());
         }

         PlayerUtils._snake("------");
      } else {
         PlayerUtils._snake("invalid syntax Valid .target");
      }

      return null;
   }
}
