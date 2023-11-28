package rip.sleep.command.commands;

import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;

public class BindCommand extends Command {
   public BindCommand() {
      super("Bind", new String[]{"b"}, "", "sketit");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length == 1) {
         if (var1[0].equalsIgnoreCase("list")) {
            StringBuilder var3 = new StringBuilder();
            Sleep var10000 = Sleep.INSTANCE;
            Sleep.c33759();
            Iterator var4 = ModuleManager.c84590().iterator();
            if (var4.hasNext()) {
               Module var5 = (Module)var4.next();
               if (!Keyboard.getKeyName(var5.c93366()).equals("NONE")) {
                  var3.append(EnumChatFormatting.WHITE + var5.getName()).append(": ").append(EnumChatFormatting.GRAY + Keyboard.getKeyName(var5.c93366())).append(", ");
               }
            }

            ChatUtilA.c32374("Binds: ");
            String[] var11 = var3.toString().split(", ");
            int var6 = var11.length;
            int var7 = 0;
            if (var7 < var6) {
               String var8 = var11[var7];
               ChatUtilA.c32374(var8);
               ++var7;
            }
         }

         if (var1[0].equalsIgnoreCase("clear")) {
            Sleep.getInstance();
            Sleep.c33759();
            Iterator var9 = ModuleManager.c84590().iterator();
            if (var9.hasNext()) {
               Module var12 = (Module)var9.next();
               var12.c32946(0);
            }

            PlayerUtilG.c11143("Cleared all binds.");
            Minecraft.getMinecraft().thePlayer.sendChatMessage(".bind clickgui rshift");
         }
      }

      if (var1.length >= 2) {
         Sleep var16 = Sleep.INSTANCE;
         Module var10 = Sleep.c33759().c89891(var1[0]);
         int var13 = Keyboard.getKeyIndex(var1[1].toUpperCase());
         var10.c32946(var13);
         Object[] var14 = new Object[]{var10.getName(), "none"};
         ChatUtilA.c32374(String.format("> Bound %s to %s", var14));
         ChatUtilA.c32374("> Invalid module name, double check spelling.");
      }

      if (!var1[0].equalsIgnoreCase("list") && !var1[0].equalsIgnoreCase("clear")) {
         ChatUtilA.c32374("§bCorrect usage:§7 .bind <module> <key>");
         ChatUtilA.c32374("§bCorrect usage:§7 .bind list");
         ChatUtilA.c32374("§bCorrect usage:§7 .bind clear");
      }

      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
