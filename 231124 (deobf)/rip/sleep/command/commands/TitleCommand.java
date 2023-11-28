package rip.sleep.command.commands;

import java.awt.Component;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.lwjgl.opengl.Display;
import rip.sleep.command.Command;
import rip.sleep.util.ChatUtilA;
import rip.sleep.value.Value;

public class TitleCommand extends Command {
   public TitleCommand() {
      super("title", new String[]{"settile", "st", "sett", "stitle"}, "", "Set Client Title");
   }

   public String c23111(String[] var1) {
      Value.c27574();
      String var3 = JOptionPane.showInputDialog((Component)null, "set title", (Object)null);
      if (var3 != null) {
         if (var3.contains("lnt")) {
            Display.setTitle("lynx");
         }

         Display.setTitle(var3);
         ChatUtilA.c34080("> Client Title was set to " + var3);
      }

      Display.setTitle(Display.getTitle());
      ChatUtilA.c34080("> Client Title was set to " + Display.getTitle());
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
