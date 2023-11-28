package rip.sleep.command.commands;

import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.module.modules.HUD;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;

public final class ClientNameCommand extends Command {
   private final List<Character> c36264 = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'k', 'm', 'o', 'l', 'n', 'r');

   public ClientNameCommand() {
      super("clientname", new String[]{"list"}, "", "sketit");
   }

   public String c23111(String... var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 0) {
         PlayerUtilG.c11143("Correct usage .clientname <name>");
         return null;
      } else {
         if (var1.length >= 2) {
            StringBuilder var3 = new StringBuilder();
            int var4 = 1;
            if (var4 < var1.length) {
               String var5 = var1[var4];
               var5 = var5.replace('&', '§');
               var3.append(var5).append(" ");
               ++var4;
            }

            PlayerUtilG.c11143(String.format("Changed client name to '%s§7' was '%s§7'.", var3.toString().trim(), HUD.c28241));
            HUD.c28241 = var3.toString().trim();
         }

         return null;
      }
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
