package rip.sleep.command.commands;

import org.json.JSONException;
import rip.sleep.command.Command;
import rip.sleep.util.ChatUtilA;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class HelpCommand extends Command {
   public HelpCommand() {
      super("Help", new String[]{"list"}, "", "sketit");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 0) {
         ChatUtilA.c95995("§7§m§l----------------------------------");
         ChatUtilA.c95995("                    §b§lETB Client");
         ChatUtilA.c95995("§b.help >§7 list commands");
         ChatUtilA.c95995("§b.bind >§7 bind a module to a key");
         ChatUtilA.c95995("§b.t >§7 toggle a module on/off");
         ChatUtilA.c95995("§b.friend >§7 friend a player");
         ChatUtilA.c95995("§b.cheats >§7 list all modules");
         ChatUtilA.c95995("§b.config >§7 load a premade config");
         ChatUtilA.c95995("§7§m§l----------------------------------");
      }

      ChatUtilA.c34080("invalid syntax Valid .help");
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
