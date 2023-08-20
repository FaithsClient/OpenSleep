package ft.sleep.command.commands;

import ft.sleep.command.Command;
import ft.sleep.util.other.Helper;

public class Help extends Command {
   public Help() {
      super("ft.sleep.command.commands.Help", new String[]{"list"}, "", "sketit");
   }

   public String _absolute(String[] assure) {
      if (((Object[])assure).length == 0) {
         Helper._shopping("§7§m§l----------------------------------");
         Helper._shopping("                    §b§lETB ft.sleep.util.other.Client");
         Helper._shopping("§b.help >§7 list commands");
         Helper._shopping("§b.bind >§7 bind a module to a key");
         Helper._shopping("§b.t >§7 toggle a module on/off");
         Helper._shopping("§b.friend >§7 friend a player");
         Helper._shopping("§b.cheats >§7 list all modules");
         Helper._shopping("§b.config >§7 load a premade config");
         Helper._shopping("§7§m§l----------------------------------");
      } else {
         Helper._seller("invalid syntax Valid .help");
      }

      return null;
   }
}
