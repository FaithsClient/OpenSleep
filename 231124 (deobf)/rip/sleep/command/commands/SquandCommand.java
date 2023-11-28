package rip.sleep.command.commands;

import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.module.modules.PartyHUD;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;

public class SquandCommand extends Command {
   public SquandCommand.c43900 c1575;

   public SquandCommand() {
      super("Squad", new String[]{"sa", "squad"}, "", "Squad Command");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 1) {
         if (var1[0].equalsIgnoreCase("list")) {
            String var3 = PartyHUD.c18878().keySet().toString();
            PlayerUtilG.c11143("--- You have " + var3 + " Squad ---");
         }

         if (var1[0].equalsIgnoreCase("clear")) {
            PartyHUD.c94996();
            PlayerUtilG.c11143("Clear Squad");
            Sleep.getInstance().c83083().c43114().add(new Notification("Clear all Squad"));
         }
      }

      if (var1.length >= 2) {
         String var5 = var1[0];
         byte var4 = -1;
         switch(var5.hashCode()) {
         case 96417:
            if (!var5.equals("add")) {
               break;
            }

            var4 = 0;
         case -934610812:
            if (!var5.equals("remove")) {
               break;
            }

            var4 = 1;
         case 94746189:
            if (!var5.equals("clear")) {
               break;
            }

            var4 = 2;
         case 3322014:
            if (var5.equals("list")) {
               var4 = 3;
            }
         }

         switch(var4) {
         case 0:
            this.c1575 = SquandCommand.c43900.c73404;
         case 1:
            this.c1575 = SquandCommand.c43900.c41241;
         case 2:
            this.c1575 = SquandCommand.c43900.c85874;
         case 3:
            this.c1575 = SquandCommand.c43900.c88470;
         default:
            if (this.c1575 == SquandCommand.c43900.c73404 && !var1[1].isEmpty()) {
               var5 = PartyHUD.c18878().keySet().toString();
               if (var5.contains(var1[1])) {
                  return null;
               }

               PartyHUD.c63365(var1[1]);
               PlayerUtilG.c11143("Add Squad : " + var1[1]);
               Sleep.getInstance().c83083().c43114().add(new Notification("Add Squad " + var1[1]));
            }

            if (this.c1575 != SquandCommand.c43900.c41241 || var1[1].isEmpty()) {
               return null;
            }

            var5 = PartyHUD.c18878().keySet().toString();
            if (!var5.contains(var1[1])) {
               return null;
            }

            PartyHUD.c15222(var1[1]);
            PlayerUtilG.c11143("Remove Squad : " + var1[1]);
            Sleep.getInstance().c83083().c43114().add(new Notification("Remove Squad " + var1[1]));
         }
      }

      if (!var1[0].equalsIgnoreCase("list") && !var1[0].equalsIgnoreCase("clear")) {
         PlayerUtilG.c11143("invalid syntax Valid .Squad");
      }

      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }

   static enum c43900 {
      c73404,
      c41241,
      c85874,
      c88470;
   }
}
