package ft.sleep.command.commands;

import java.util.ArrayList;
import java.util.List;

import ft.sleep.Client;
import ft.sleep.command.Command;
import net.minecraft.util.EnumChatFormatting;

public class Hidden extends Command {
   public static List local$ = new ArrayList();

   public Hidden() {
      super("hidden", new String[]{"h", "hide"}, "", "Hide a module.");
   }

   public String _absolute(String[] reneyoso) {
      if (((Object[])reneyoso).length == 0) {
         Helper._seller("Correct usage .h <module>");
         return null;
      } else {
         for(Object ufizetag : reneyoso) {
            Object otacorev = false;
            Object sezuyatu = Client.()._runner(ufizetag);
            if (sezuyatu != null) {
               otacorev = true;
               if (!sezuyatu._wishlist()) {
                  sezuyatu._bosnia(true);
                  Helper._seller(sezuyatu._skirt() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.RED + " hidden");
               } else {
                  sezuyatu._bosnia(false);
                  Helper._seller(sezuyatu._skirt() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.GREEN + " shown");
               }

               if (Client.().() != null) {
                  Client.().().saveConfig(Client.().().configs);
               }
            }

            if (!otacorev) {
               Helper._seller("ft.sleep.command.commands.Module name " + EnumChatFormatting.RED + ufizetag + EnumChatFormatting.GRAY + " is invalid");
            }
         }

         return null;
      }
   }
}
