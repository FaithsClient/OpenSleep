package ft.sleep.command.commands;

import ft.sleep.Client;
import ft.sleep.command.Command;
import ft.sleep.util.player.PlayerUtils;

public class Friend2 extends Command {
   public Friend blank$;

   public Friend2() {
      super("friend", new String[]{"f", "friend"}, "", "ft.sleep.command.commands.Friend ft.sleep.command.Command");
   }

   public String _absolute(String[] odecepuy) {
      if (((Object[])odecepuy).length >= 2) {
         Object aconenur = (String)((Object[])odecepuy)[0];
         Object cebofepu = -1;
         switch(aconenur.hashCode()) {
         case -934610812:
            if (aconenur.equals("remove")) {
               cebofepu = 1;
            }
            break;
         case 96417:
            if (aconenur.equals("add")) {
               cebofepu = 0;
            }
            break;
         case 3322014:
            if (aconenur.equals("list")) {
               cebofepu = 3;
            }
            break;
         case 94746189:
            if (aconenur.equals("clear")) {
               cebofepu = 2;
            }
         }

         switch(cebofepu) {
         case 0:
            bitunuri.blank$ = Friend.disks$;
            break;
         case 1:
            bitunuri.blank$ = Friend.zones$;
            break;
         case 2:
            bitunuri.blank$ = Friend.defend$;
            break;
         case 3:
            bitunuri.blank$ = Friend.deposit$;
         }

         if (bitunuri.blank$ == Friend.disks$ && !((String)((Object[])odecepuy)[1]).isEmpty()) {
            Client.().().friendsConfig.addFriend((String)((Object[])odecepuy)[1]);
            Client.().().saveConfig(Client.().().friendsConfig);
            PlayerUtils._snake("Add ft.sleep.command.commands.Friend : " + ((Object[])odecepuy)[1]);
            Client.().()._arabia().add(new Notification("Add friend " + ((Object[])odecepuy)[1]));
         } else if (bitunuri.blank$ == Friend.zones$ && !((String)((Object[])odecepuy)[1]).isEmpty()) {
            Client.().().friendsConfig.removeFriend((String)((Object[])odecepuy)[1]);
            Client.().().saveConfig(Client.().().friendsConfig);
            PlayerUtils._snake("Remove ft.sleep.command.commands.Friend : " + ((Object[])odecepuy)[1]);
            Client.().()._arabia().add(new Notification("Remove friend " + ((Object[])odecepuy)[1]));
         }
      } else if (bitunuri.blank$ == Friend.defend$ && !((String)((Object[])odecepuy)[1]).isEmpty()) {
         Client.().().friendsConfig.clearFriends();
         Client.().().saveConfig(Client.().().friendsConfig);
         PlayerUtils._snake("Clear ft.sleep.command.commands.Friend");
         Client.().()._arabia().add(new Notification("Clear all friends"));
      } else if (bitunuri.blank$ == Friend.deposit$) {
         PlayerUtils._snake("--- You have " + Client.().().friendsConfig.getFriends().size() + " friends ---");

         for(Object var5 : Client.().().friendsConfig.getFriends()) {
            PlayerUtils._snake(var5.getPlayerName());
         }

         PlayerUtils._snake("------");
      } else {
         PlayerUtils._snake("invalid syntax Valid .friend");
      }

      return null;
   }
}
