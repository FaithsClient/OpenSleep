package linxiu.api.events.world;


import linxiu.api.Event;
import net.minecraft.network.Packet;

public class EventPacketReceive extends Event {
	public static Packet packet;

	public EventPacketReceive(Packet packet) {
		EventPacketReceive.packet = packet;
	}

	public static Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		EventPacketReceive.packet = packet;
	}
}
