//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.packet;

import ft.sleep.injection.interfaces.INetworkManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;

public class PacketUtils {
   public static Minecraft dreams$ = Minecraft.getMinecraft();

   public static void _gratis(Packet amizusen) {
      if (Minecraft.getMinecraft().thePlayer != null) {
         ((INetworkManager)Minecraft.getMinecraft().thePlayer.sendQueue.getNetworkManager()).sendPacketNoEvent((Packet)amizusen);
      }

   }

   public static void _payroll(Packet izavaral) {
      if (dreams$.thePlayer != null) {
         dreams$.thePlayer.sendQueue.addToSendQueue((Packet)izavaral);
      }

   }
}
