package rip.sleep.command.commands;

import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.module.modules.HUD;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;

public final class UsernameCommand extends Command {
   private final List<Character> c68585 = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'k', 'm', 'o', 'l', 'n', 'r');

   public UsernameCommand() {
      super("UserName", new String[]{"username"}, "", "custom username");
   }

   public String c23111(String... var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 0) {
         PlayerUtilG.c11143("Correct usage .username <name>");
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

            PlayerUtilG.c11143(String.format("Changed client name to '%s§7' was '%s§7'.", var3.toString().trim(), HUD.c27743));
            HUD.c27743 = var3.toString().trim();
         }

         return null;
      }
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
