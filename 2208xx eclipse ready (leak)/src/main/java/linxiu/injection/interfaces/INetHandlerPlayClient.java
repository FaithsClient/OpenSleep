package linxiu.injection.interfaces;

import net.minecraft.network.Packet;

public interface INetHandlerPlayClient {
	boolean getDoneLoadingTerrain();

	void addToSendQueueSilent(Packet packetIn);
}
