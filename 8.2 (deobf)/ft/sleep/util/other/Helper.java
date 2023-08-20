//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.other;

import ft.sleep.Client;
import ft.sleep.util.player.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class Helper {
   public static Minecraft sprint$ = Minecraft.getMinecraft();
   public static boolean errors$ = true;

   public static void _credit(String eruminig) {
      Object adicibad = new Object[2];
      Client.surround$.getClass();
      adicibad[0] = EnumChatFormatting.BLUE + "Sleep" + EnumChatFormatting.GRAY + ": ";
      adicibad[1] = eruminig;
      sprint$.thePlayer.addChatMessage(new ChatComponentText(String.format("%s%s", adicibad)));
   }

   public static void _seller(String febonibo) {
      (new ChatUtils(true, true))._linked((String)febonibo)._privacy(EnumChatFormatting.GRAY)._coated()._circus();
   }

   public static void _shopping(String imovufuv) {
      (new ChatUtils(false, true))._linked((String)imovufuv)._privacy(EnumChatFormatting.GRAY)._coated()._circus();
   }

   public static boolean _atlantic(String commerce) {
      return !sprint$.isSingleplayer() && sprint$.getCurrentServerData().serverIP.toLowerCase().contains((CharSequence)commerce);
   }

   public static net.minecraft.util.Timer _pillow() {
      return sprint$.timer;
   }
}
