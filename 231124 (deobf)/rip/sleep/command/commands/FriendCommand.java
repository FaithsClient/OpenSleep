package rip.sleep.command.commands;

import java.util.Iterator;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.file.FriendFile;
import rip.sleep.module.Module;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;

public class FriendCommand extends Command {
   public FriendCommand.c23615 c45668;

   public FriendCommand() {
      super("friend", new String[]{"f", "friend"}, "", "Friend Command");
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
            this.c45668 = FriendCommand.c23615.c87859;
         case 1:
            this.c45668 = FriendCommand.c23615.c43117;
         case 2:
            this.c45668 = FriendCommand.c23615.c94560;
         case 3:
            this.c45668 = FriendCommand.c23615.c58357;
         default:
            if (this.c45668 == FriendCommand.c23615.c87859 && !var1[1].isEmpty()) {
               Sleep.getInstance().c43557().c25756.c78693(var1[1]);
               Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c25756);
               PlayerUtilG.c11143("Add Friend : " + var1[1]);
               Sleep.getInstance().c83083().c43114().add(new Notification("Add friend " + var1[1]));
            }

            if (this.c45668 != FriendCommand.c23615.c43117 || var1[1].isEmpty()) {
               return null;
            }

            Sleep.getInstance().c43557().c25756.c46491(var1[1]);
            Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c25756);
            PlayerUtilG.c11143("Remove Friend : " + var1[1]);
            Sleep.getInstance().c83083().c43114().add(new Notification("Remove friend " + var1[1]));
         }
      }

      if (this.c45668 == FriendCommand.c23615.c94560 && !var1[1].isEmpty()) {
         Sleep.getInstance().c43557().c25756.c492();
         Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c25756);
         PlayerUtilG.c11143("Clear Friend");
         Sleep.getInstance().c83083().c43114().add(new Notification("Clear all friends"));
      }

      if (this.c45668 == FriendCommand.c23615.c58357) {
         PlayerUtilG.c11143("--- You have " + Sleep.getInstance().c43557().c25756.c72817().size() + " friends ---");
         Iterator var5 = Sleep.getInstance().c43557().c25756.c72817().iterator();
         if (var5.hasNext()) {
            FriendFile.c73407 var6 = (FriendFile.c73407)var5.next();
            PlayerUtilG.c11143(var6.c19239());
         }

         PlayerUtilG.c11143("------");
      }

      PlayerUtilG.c11143("invalid syntax Valid .friend");
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }

   static enum c23615 {
      c87859,
      c43117,
      c94560,
      c58357;
   }
}
