package ft.sleep.command.commands;

import java.util.ArrayList;
import java.util.List;

import ft.sleep.Client;
import ft.sleep.command.Command;
import net.minecraft.util.EnumChatFormatting;

public class setName extends Command {
   public static List tahoe$ = new ArrayList();

   public setName() {
      super("ft.sleep.command.commands.setName", new String[]{"sv", "setcustomname"}, "", "set custom name for a module.");
   }

   public String _absolute(String[] sepelula) {
      if (((Object[])sepelula).length == 0) {
         Helper._seller("Correct usage .sv <module> [name]");
         return null;
      } else {
         Object tadiseso = false;
         Object uzifebov = Client.()._runner((String)((Object[])sepelula)[0]);
         if (uzifebov != null) {
            tadiseso = true;
            if (((Object[])sepelula).length >= 2) {
               Object igacinis = new StringBuilder();

               for(Object ladozilo = 1; ladozilo < ((Object[])sepelula).length; ++ladozilo) {
                  Object cefitiye = (String)((Object[])sepelula)[ladozilo];
                  cefitiye = cefitiye.replace('&', '§');
                  igacinis.append(cefitiye).append(" ");
               }

               uzifebov._forestry(igacinis.toString().trim());
               Helper._seller(EnumChatFormatting.BLUE + uzifebov._skirt() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.GREEN + " set" + EnumChatFormatting.GRAY + " to " + EnumChatFormatting.YELLOW + igacinis.toString().trim());
            } else {
               uzifebov._forestry((String)null);
               Helper._seller(EnumChatFormatting.BLUE + uzifebov._skirt() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.RED + " reset");
            }
         }

         if (!tadiseso) {
            Helper._seller("ft.sleep.command.commands.Module name " + EnumChatFormatting.RED + ((Object[])sepelula)[0] + EnumChatFormatting.GRAY + " is invalid");
         }

         return null;
      }
   }
}
