package linxiu.injection.interfaces;

import net.minecraft.network.PacketBuffer;

public interface IMixinC17PacketCustomPayload {

	PacketBuffer setData(PacketBuffer data);

	String setChannel(String channel);

}
