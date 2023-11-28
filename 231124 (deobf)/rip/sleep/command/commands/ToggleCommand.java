package rip.sleep.command.commands;

import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.value.Value;

public class ToggleCommand extends Command {
   public ToggleCommand() {
      super("t", new String[]{"toggle", "togl", "turnon", "enable"}, "", "Toggles a specified Module");
   }

   public String c23111(String[] var1) {
      Value.c27574();
      String var3 = "";
      if (var1.length > 1) {
         var3 = var1[1];
      }

      if (var1.length < 1) {
         ChatUtilA.c95995("§bCorrect usage:§7 .t <module>");
      }

      boolean var4 = false;
      Module var5 = Sleep.c33759().c89891(var1[0]);
      if (var5 != null) {
         var5.c23631(!var5.c24622());
         var4 = true;
         if (var5.c24622()) {
            ChatUtilA.c34080("> " + var5.getName() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.GREEN + " enabled");
         }

         ChatUtilA.c34080("> " + var5.getName() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.RED + " disabled");
         if (Sleep.getInstance().c43557() != null) {
            Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c94512);
         }
      }

      ChatUtilA.c34080("> Module name " + EnumChatFormatting.RED + var1[0] + EnumChatFormatting.GRAY + " is invalid");
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
