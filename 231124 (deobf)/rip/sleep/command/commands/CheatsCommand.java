package rip.sleep.command.commands;

import java.util.Iterator;
import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.value.Value;

public class CheatsCommand extends Command {
   public CheatsCommand() {
      super("Cheats", new String[]{"mods"}, "", "sketit");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 0) {
         Sleep.c33759();
         StringBuilder var3 = new StringBuilder(ModuleManager.c84590().size() + " Cheats - ");
         Sleep.c33759();
         Iterator var4 = ModuleManager.c84590().iterator();
         if (var4.hasNext()) {
            Module var5 = (Module)var4.next();
            var3.append(var5.c24622() ? EnumChatFormatting.GREEN : EnumChatFormatting.RED).append(var5.getName()).append(", ");
         }

         ChatUtilA.c34080("> " + var3.substring(0, var3.toString().length() - 2));
      }

      ChatUtilA.c34080("> Correct usage .cheats");
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
