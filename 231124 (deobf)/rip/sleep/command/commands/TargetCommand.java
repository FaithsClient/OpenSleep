package rip.sleep.command.commands;

import java.util.Iterator;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.JsonUtilA;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;

public class TargetCommand extends Command {
   public TargetCommand.c60284 c9271;

   public TargetCommand() {
      super("Target", new String[]{"Target", "target"}, "target", "Target Player");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length >= 2) {
         String var3 = var1[0];
         byte var4 = -1;
         switch(var3.hashCode()) {
         case 96417:
            if (!var3.equals("add")) {
               break;
            }

            var4 = 0;
         case -934610812:
            if (!var3.equals("remove")) {
               break;
            }

            var4 = 1;
         case 94746189:
            if (!var3.equals("clear")) {
               break;
            }

            var4 = 2;
         case 3322014:
            if (var3.equals("list")) {
               var4 = 3;
            }
         }

         switch(var4) {
         case 0:
            this.c9271 = TargetCommand.c60284.c42937;
         case 1:
            this.c9271 = TargetCommand.c60284.c32154;
         case 2:
            this.c9271 = TargetCommand.c60284.c90967;
         case 3:
            this.c9271 = TargetCommand.c60284.c27545;
         default:
            if (this.c9271 == TargetCommand.c60284.c42937 && !var1[1].isEmpty()) {
               Sleep.INSTANCE.c43557().c36876.c30803(var1[1]);
               Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c36876);
               PlayerUtilG.c11143("Add Target : " + var1[1]);
               Sleep.INSTANCE.c83083().c43114().add(new Notification("Add target " + var1[1]));
            }

            if (this.c9271 != TargetCommand.c60284.c32154 || var1[1].isEmpty()) {
               return null;
            }

            Sleep.INSTANCE.c43557().c36876.c36634(var1[1]);
            Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c36876);
            PlayerUtilG.c11143("Remove Target : " + var1[1]);
            Sleep.INSTANCE.c83083().c43114().add(new Notification("Remove target " + var1[1]));
         }
      }

      if (this.c9271 == TargetCommand.c60284.c90967) {
         Sleep.INSTANCE.c43557().c36876.c87689();
         Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c36876);
         PlayerUtilG.c11143("Clear Target");
         Sleep.INSTANCE.c83083().c43114().add(new Notification("Clear targets"));
      }

      if (this.c9271 == TargetCommand.c60284.c27545) {
         PlayerUtilG.c11143("--- You have " + Sleep.INSTANCE.c43557().c36876.c5425().size() + " Targets ---");
         Iterator var5 = Sleep.INSTANCE.c43557().c36876.c5425().iterator();
         if (var5.hasNext()) {
            JsonUtilA.c16238 var6 = (JsonUtilA.c16238)var5.next();
            PlayerUtilG.c11143(var6.c40734());
         }

         PlayerUtilG.c11143("------");
      }

      PlayerUtilG.c11143("invalid syntax Valid .target");
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }

   static enum c60284 {
      c42937,
      c32154,
      c90967,
      c27545;
   }
}
