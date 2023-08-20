package ft.sleep.command.commands;

import ft.sleep.command.Command;
import ft.sleep.module.modules.HUD;
import ft.sleep.util.player.PlayerUtils;

import java.util.Arrays;
import java.util.List;

public class UserName extends Command {
   public List ignore$ = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'k', 'm', 'o', 'l', 'n', 'r');

   public UserName() {
      super("ft.sleep.command.commands.UserName", new String[]{"username"}, "", "custom username");
   }

   public String _absolute(String... bitedifa) {
      if (((Object[])bitedifa).length == 0) {
         PlayerUtils._snake("Correct usage .username <name>");
         return null;
      } else {
         if (((Object[])bitedifa).length >= 2) {
            Object dulumapa = new StringBuilder();

            for(Object dedeporu = 1; dedeporu < ((Object[])bitedifa).length; ++dedeporu) {
               Object sibarozo = (String)((Object[])bitedifa)[dedeporu];
               sibarozo = sibarozo.replace('&', '§');
               dulumapa.append(sibarozo).append(" ");
            }

            PlayerUtils._snake(String.format("Changed client name to '%s§7' was '%s§7'.", dulumapa.toString().trim(), HUD.columns$));
            HUD.columns$ = dulumapa.toString().trim();
         }

         return null;
      }
   }
}
