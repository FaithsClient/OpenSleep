package ft.sleep.module.modules;

import ft.sleep.command.Command;
import ft.sleep.util.player.ChatUtils2;

public class SkinChange extends Command {
   public static boolean training$ = false;
   public static String intent$ = "";

   public SkinChange() {
      super("changeskin", new String[]{"skin", "cskin"}, "", "Change Skin");
   }

   public String _absolute(String[] imuvagul) {
      if (((Object[])imuvagul).length == 1) {
         intent$ = (String)((Object[])imuvagul)[0];
         Yarukon.reached$._hispanic(intent$);
         training$ = !training$;
         ChatUtils2._fashion("Current skin-type: " + (training$ ? "Slim" : "Steve"));
      } else {
         intent$ = "";
      }

      return null;
   }
}
