package rip.sleep.command.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;

public class SetNameCommand extends Command {
   public static List<String> c74757 = new ArrayList();

   public SetNameCommand() {
      super("setName", new String[]{"sv", "setcustomname"}, "", "set custom name for a module.");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 0) {
         ChatUtilA.c34080("Correct usage .sv <module> [name]");
         return null;
      } else {
         boolean var3 = false;
         if (var1.length == 1) {
            if (var1[0].equalsIgnoreCase("clear")) {
               var3 = true;
               Sleep.getInstance();
               Sleep.c33759();
               Iterator var4 = ModuleManager.c84590().iterator();
               if (var4.hasNext()) {
                  Module var5 = (Module)var4.next();
                  var5.c45577((String)null);
               }

               PlayerUtilG.c11143("Cleared all Set Name.");
            }

            if (var1[0].equalsIgnoreCase("list")) {
               var3 = true;
               StringBuilder var13 = new StringBuilder();
               Sleep var10000 = Sleep.INSTANCE;
               Sleep.c33759();
               Iterator var15 = ModuleManager.c84590().iterator();
               if (var15.hasNext()) {
                  Module var6 = (Module)var15.next();
                  if (var6.c15191() != null) {
                     var13.append(EnumChatFormatting.WHITE + var6.getName()).append(": ").append(EnumChatFormatting.GRAY + var6.c15191()).append(", ");
                  }
               }

               ChatUtilA.c32374("SetName: ");
               String[] var16 = var13.toString().split(", ");
               int var7 = var16.length;
               int var8 = 0;
               if (var8 < var7) {
                  String var9 = var16[var8];
                  ChatUtilA.c32374(var9);
                  ++var8;
               }
            }
         }

         Module var14 = Sleep.c33759().c89891(var1[0]);
         var3 = true;
         if (var1.length >= 2) {
            StringBuilder var17 = new StringBuilder();
            int var18 = 1;
            if (var18 < var1.length) {
               String var20 = var1[var18];
               var20 = var20.replace('&', '§');
               var17.append(var20).append(" ");
               ++var18;
            }

            var14.c45577(var17.toString().trim());
            ChatUtilA.c34080(EnumChatFormatting.BLUE + var14.getName() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.GREEN + " set" + EnumChatFormatting.GRAY + " to " + EnumChatFormatting.YELLOW + var17.toString().trim());
         }

         var14.c45577((String)null);
         ChatUtilA.c34080(EnumChatFormatting.BLUE + var14.getName() + EnumChatFormatting.GRAY + " was" + EnumChatFormatting.RED + " reset");
         ChatUtilA.c34080("Module name " + EnumChatFormatting.RED + var1[0] + EnumChatFormatting.GRAY + " is invalid");
         return null;
      }
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
