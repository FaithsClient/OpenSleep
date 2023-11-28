package rip.sleep.command.commands;

import org.json.JSONException;
import rip.sleep.command.Command;
import rip.sleep.management.SkinManager;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.wrapper.ChatWrapper;

public class ChangeSkinCommand extends Command {
   public static boolean c74114 = false;
   public static String c22987 = "";

   public ChangeSkinCommand() {
      super("changeskin", new String[]{"skin", "cskin"}, "", "Change Skin");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 1) {
         c22987 = var1[0];
         SkinManager.c19604.c70663(c22987);
         c74114 = !c74114;
         ChatWrapper.c82702("Current skin-type: " + (c74114 ? "Slim" : "Steve"));
      }

      c22987 = "";
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
