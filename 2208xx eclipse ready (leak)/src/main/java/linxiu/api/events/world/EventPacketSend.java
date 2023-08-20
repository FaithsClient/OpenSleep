/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.events.world;

import linxiu.api.Event;
import net.minecraft.network.Packet;

public class EventPacketSend extends Event {
	public static Packet<?> packet;
	private boolean sendPacketInEvent;

	public EventPacketSend(Packet packet) {
		this.packet = packet;
		this.sendPacketInEvent = false;
	}

	public static Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	public void sendPacketInEvent() {
		this.sendPacketInEvent = true;
	}

	public boolean isSendPacketInEvent() {
		return sendPacketInEvent;
	}
}