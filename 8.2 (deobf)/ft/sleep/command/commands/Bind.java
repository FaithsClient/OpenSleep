package ft.sleep.command.commands;

import ft.sleep.Client;
import ft.sleep.command.Command;
import ft.sleep.module.ModuleManager;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {
   public Bind() {
      super("ft.sleep.command.commands.Bind", new String[]{"b"}, "", "sketit");
   }

   public String _absolute(String[] elurobed) {
      if (((Object[])elurobed).length == 1 && ((String)((Object[])elurobed)[0]).equalsIgnoreCase("clear")) {
         Client.();
         Client.();

         for(Object cupofife : ModuleManager._trick()) {
            cupofife._enrolled(0);
         }

         PlayerUtils._snake("Cleared all binds.");
      }

      if (((Object[])elurobed).length >= 2) {
         Object var5 = Client.()._runner((String)((Object[])elurobed)[0]);
         if (var5 != null) {
            Object var6 = Keyboard.getKeyIndex(((String)((Object[])elurobed)[1]).toUpperCase());
            var5._enrolled(var6);
            Object uzecebop = new Object[]{var5._skirt(), var6 == 0 ? "none" : ((String)((Object[])elurobed)[1]).toUpperCase()};
            Helper._seller(String.format("> Bound %s to %s", uzecebop));
         } else {
            Helper._seller("> Invalid module name, double check spelling.");
         }
      } else {
         Helper._shopping("§bCorrect usage:§7 .bind <module> <key>");
      }

      return null;
   }
}
