package rip.sleep.command.commands;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.value.Value;

public class HiddenCommand extends Command {
   public static List<String> c21386 = new ArrayList();

   public HiddenCommand() {
      super("hidden", new String[]{"h", "hide"}, "", "Hide a module.");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 0) {
         ChatUtilA.c34080("Correct usage .h <module>");
         return null;
      } else {
         int var4 = var1.length;
         int var5 = 0;
         if (var5 < var4) {
            String var6 = var1[var5];
            boolean var7 = false;
            Module var8 = Sleep.c33759().c89891(var6);
            if (var8 != null) {
               var7 = true;
               if (!var8.c41971()) {
                  var8.c68609(true);
                  ChatUtilA.c34080(var8.getName() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.RED + " hidden");
               }

               var8.c68609(false);
               ChatUtilA.c34080(var8.getName() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.GREEN + " shown");
               if (Sleep.getInstance().c43557() != null) {
                  Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c94512);
               }
            }

            ChatUtilA.c34080("Module name " + EnumChatFormatting.RED + var6 + EnumChatFormatting.GRAY + " is invalid");
            ++var5;
         }

         return null;
      }
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
