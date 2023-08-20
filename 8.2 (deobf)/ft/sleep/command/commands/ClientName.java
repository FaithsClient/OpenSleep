package ft.sleep.command.commands;

import ft.sleep.command.Command;
import ft.sleep.module.modules.HUD;
import ft.sleep.util.player.PlayerUtils;

import java.util.Arrays;
import java.util.List;

public class ClientName extends Command {
   public List rainbow$ = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'k', 'm', 'o', 'l', 'n', 'r');

   public ClientName() {
      super("clientname", new String[]{"list"}, "", "sketit");
   }

   public String _absolute(String... grill) {
      if (((Object[])grill).length == 0) {
         PlayerUtils._snake("Correct usage .clientname <name>");
         return null;
      } else {
         if (((Object[])grill).length >= 2) {
            Object illinois = new StringBuilder();

            for(Object bedroom = 1; bedroom < ((Object[])grill).length; ++bedroom) {
               Object dealer = (String)((Object[])grill)[bedroom];
               dealer = dealer.replace('&', '§');
               illinois.append(dealer).append(" ");
            }

            PlayerUtils._snake(String.format("Changed client name to '%s§7' was '%s§7'.", illinois.toString().trim(), HUD.draft$));
            HUD.draft$ = illinois.toString().trim();
         }

         return null;
      }
   }
}
