package ft.sleep.command;

import ft.sleep.api.EventBus;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventChat;
import ft.sleep.command.commands.ManagerCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandManager implements Manager {
   public List spies$;

   public void _falling() {
      ozoseteg.spies$ = new ArrayList();
      ozoseteg.spies$.add(new ManagerCommand(ozoseteg, "test", new String[]{"test"}, "", "testing"));
      ozoseteg.spies$.add(new Help());
      ozoseteg.spies$.add(new ComamndQQ());
      ozoseteg.spies$.add(new UserName());
      ozoseteg.spies$.add(new Title());
      ozoseteg.spies$.add(new ClientName());
      ozoseteg.spies$.add(new Toggle());
      ozoseteg.spies$.add(new Bind());
      ozoseteg.spies$.add(new Target2());
      ozoseteg.spies$.add(new VClip());
      ozoseteg.spies$.add(new SkinChange());
      ozoseteg.spies$.add(new Friend2());
      ozoseteg.spies$.add(new Cheats());
      ozoseteg.spies$.add(new Hidden());
      ozoseteg.spies$.add(new setName());
      ozoseteg.spies$.add(new Config());
      EventBus.getInstance().register(ozoseteg);
   }

   public List _queens() {
      return driven.spies$;
   }

   public Optional _guardian(String atorufag) {
      return abuzimib.spies$.stream().filter(CommandManager::_whats).findFirst();
   }

   public void _subaru(Command carlo) {
      henry.spies$.add(carlo);
   }

   @EventHandler
   public void _eating(EventChat managing) {
      if (((EventChat)managing).getMessage().length() > 1 && ((EventChat)managing).getMessage().startsWith(".")) {
         ((EventChat)managing).setCancelled(true);
         Object spies = ((EventChat)managing).getMessage().trim().substring(1).split(" ");
         Object iraqi = globe._guardian(spies[0]);
         if (iraqi.isPresent()) {
            Object ready = ((Command)iraqi.get())._absolute((String[])Arrays.copyOfRange(spies, 1, spies.length));
            if (ready != null && !ready.isEmpty()) {
               Helper._seller(ready);
            }
         } else {
            Helper._seller(String.format("ft.sleep.command.Command not found Try '%shelp'", "."));
         }
      }

   }

   public static boolean _whats(String councils, Command walter) {
      Object infants = false;

      for(Object systems : ((Command)walter)._monsters()) {
         if (systems.equalsIgnoreCase((String)councils)) {
            infants = true;
            break;
         }
      }

      return ((Command)walter)._rivers().equalsIgnoreCase((String)councils) || infants;
   }

   public static List _forming(CommandManager program) {
      return ((CommandManager)program).spies$;
   }
}
