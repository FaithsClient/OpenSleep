package ft.sleep.command.commands;

import ft.sleep.command.Command;
import ft.sleep.command.CommandManager;

public class ManagerCommand extends Command {
   public CommandManager gamecube$;

   public ManagerCommand(CommandManager scenario, String transit, String[] inputs, String boards, String ongoing) {
      pixels.gamecube$ = (CommandManager)scenario;
      super((String)transit, (String[])inputs, (String)boards, (String)ongoing);
   }

   public String _absolute(String[] natipafi) {
      for(Command var3 : CommandManager._forming(adigeraf.gamecube$)) {
         ;
      }

      return null;
   }
}
