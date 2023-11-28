package rip.sleep.command.commands;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rip.sleep.command.Command;
import rip.sleep.value.Value;

public class QQCommand extends Command {
   public QQCommand() {
      super("qq", new String[]{"esu"}, "", "Check qq bind");
   }

   public static String c35447(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static String c35168(String var0, String var1) {
      JsonParser var3 = new JsonParser();
      Value.c27574();
      JsonElement var4 = var3.parse(var0);
      if (var4.isJsonObject()) {
         JsonObject var5 = var4.getAsJsonObject();
         JsonElement var6 = var5.get(var1);
         return var6.toString();
      } else {
         return null;
      }
   }

   public static String c6572(String var0, char var1) {
      Value.c27574();
      StringBuilder var3 = new StringBuilder();
      int var4 = 0;
      if (var4 < var0.length()) {
         if (var0.charAt(var4) != var1) {
            var3.append(var0.charAt(var4));
         }

         ++var4;
      }

      return var3.toString();
   }

   public String c23111(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   private static Exception c55411(Exception var0) {
      return var0;
   }
}
