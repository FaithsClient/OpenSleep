package rip.sleep.injection.in;

import net.minecraft.network.Packet;

public interface INetworkManager {
   void sendPacketNoEvent(Packet var1);

   void sendPacketFinal(Packet var1);
}
