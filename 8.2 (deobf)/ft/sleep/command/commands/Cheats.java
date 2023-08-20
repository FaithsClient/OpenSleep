package ft.sleep.command.commands;

import ft.sleep.Client;
import ft.sleep.command.Command;
import ft.sleep.module.ModuleManager;
import net.minecraft.util.EnumChatFormatting;

public class Cheats extends Command {
   public Cheats() {
      super("ft.sleep.command.commands.Cheats", new String[]{"mods"}, "", "sketit");
   }

   public String _absolute(String[] pizza) {
      if (((Object[])pizza).length == 0) {
         Client.();
         Object critics = new StringBuilder(ModuleManager._trick().size() + " ft.sleep.command.commands.Cheats - ");
         Client.();

         for(Object douglas : ModuleManager._trick()) {
            critics.append(douglas._central() ? EnumChatFormatting.GREEN : EnumChatFormatting.RED).append(douglas._skirt()).append(", ");
         }

         Helper._seller("> " + critics.substring(0, critics.toString().length() - 2));
      } else {
         Helper._seller("> Correct usage .cheats");
      }

      return null;
   }
}
