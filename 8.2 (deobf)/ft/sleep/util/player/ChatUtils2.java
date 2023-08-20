//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.player;

import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent.Serializer;

public class ChatUtils2 {
   public ChatComponentText video$;
   public static String griffin$ = "§7";
   public static String promptly$ = "§1";
   public static String greater$ = "§7[§1Sleep§7] ";

   public ChatUtils2(ChatComponentText curicini) {
      tobiboge.video$ = (ChatComponentText)curicini;
   }

   public static String _shots(String elabunum, String teserute) {
      return ((String)elabunum).replaceAll("(?i)" + teserute + "([0-9a-fklmnor])", "§$1");
   }

   public void _circus() {
      Minecraft.getMinecraft().thePlayer.addChatMessage(eduridon.video$);
   }

   public ChatComponentText _overcome() {
      return harry.video$;
   }

   public ChatUtils2(ChatComponentText charge, ChatUtils2 var2) {
      this((ChatComponentText)charge);
   }

   public static void _wonder(String ciladape) {
      Object buyavaza = new JsonObject();
      buyavaza.addProperty("text", (String)ciladape);
      Minecraft.getMinecraft().thePlayer.addChatMessage(Serializer.jsonToComponent(buyavaza.toString()));
   }

   public static void _fashion(String oziyuvus) {
      _wonder("§7[§1Sleep§7] " + oziyuvus);
   }

   public static ChatComponentText _warriors(ChatUtils2 sigimuci) {
      return ((ChatUtils2)sigimuci)._overcome();
   }
}
