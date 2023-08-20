package ft.sleep.command.commands;

import ft.sleep.Client;
import ft.sleep.command.Command;
import ft.sleep.module.Module;
import net.minecraft.util.EnumChatFormatting;

public class Toggle extends Command {
   public Toggle() {
      super("t", new String[]{"toggle", "togl", "turnon", "enable"}, "", "Toggles a specified ft.sleep.command.commands.Module");
   }

   public String _absolute(String[] bovibibo) {
      Object damayela = "";
      if (((Object[])bovibibo).length > 1) {
         damayela = (String)((Object[])bovibibo)[1];
      } else if (((Object[])bovibibo).length < 1) {
         Helper._shopping("§bCorrect usage:§7 .t <module>");
      }

      Object cifiyune = false;
      Module var4 = Client.()._runner((String)((Object[])bovibibo)[0]);
      if (var4 != null) {
         var4._serial(!var4._central());
         cifiyune = true;
         if (var4._central()) {
            Helper._seller("> " + var4._skirt() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.GREEN + " enabled");
         } else {
            Helper._seller("> " + var4._skirt() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.RED + " disabled");
         }

         if (Client.().() != null) {
            Client.().().saveConfig(Client.().().configs);
         }
      }

      if (!cifiyune) {
         Helper._seller("> ft.sleep.command.commands.Module name " + EnumChatFormatting.RED + ((Object[])bovibibo)[0] + EnumChatFormatting.GRAY + " is invalid");
      }

      return null;
   }
}
