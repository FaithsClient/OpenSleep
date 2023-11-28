package rip.sleep.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Timer;
import org.json.JSONException;
import rip.sleep.wrapper.ChatWrapper;
import rip.sleep.module.Module;
import rip.sleep.Sleep;
import rip.sleep.value.Value;

public class ChatUtilA {
   public static final Minecraft mc = Minecraft.getMinecraft();
   public static boolean c24161 = true;

   public static void c32374(String var0) {
      Object[] var1 = new Object[2];
      Sleep.INSTANCE.getClass();
      var1[0] = EnumChatFormatting.BLUE + "Sleep" + EnumChatFormatting.GRAY + ": ";
      var1[1] = var0;
      mc.thePlayer.addChatMessage(new ChatComponentText(String.format("%s%s", var1)));
   }

   public static void c34080(String var0) {
      (new ChatWrapper.c83885(true, true)).c87734(var0).c30477(EnumChatFormatting.GRAY).c49484().c33039();
   }

   public static void c95995(String var0) {
      (new ChatWrapper.c83885(false, true)).c87734(var0).c30477(EnumChatFormatting.GRAY).c49484().c33039();
   }

   public static boolean c29634(String var0) {
      Module[] var1 = Value.c27574();
      return !mc.isSingleplayer() && mc.getCurrentServerData().serverIP.toLowerCase().contains(var0);
   }

   public static Timer c14057() {
      return mc.timer;
   }

   private static JSONException c91615(JSONException var0) {
      return var0;
   }
}
