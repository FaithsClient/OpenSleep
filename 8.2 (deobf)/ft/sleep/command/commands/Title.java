package ft.sleep.command.commands;

import java.awt.Component;
import javax.swing.JOptionPane;

import ft.sleep.command.Command;
import org.lwjgl.opengl.Display;

public class Title extends Command {
   public Title() {
      super("title", new String[]{"settile", "st", "sett", "stitle"}, "", "Set ft.sleep.util.other.Client ft.sleep.command.commands.Title");
   }

   public String _absolute(String[] cizegebo) {
      String var2 = JOptionPane.showInputDialog((Component)null, "set title", (Object)null);
      if (var2 != null) {
         if (var2.contains("lnt")) {
            Display.setTitle("lynx");
         } else {
            Display.setTitle(var2);
            Helper._seller("> ft.sleep.util.other.Client ft.sleep.command.commands.Title was set to " + var2);
         }
      } else {
         Display.setTitle(Display.getTitle());
         Helper._seller("> ft.sleep.util.other.Client ft.sleep.command.commands.Title was set to " + Display.getTitle());
      }

      return null;
   }
}
