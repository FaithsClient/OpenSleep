package ft.sleep.api.events.misc;

import ft.sleep.api.Event;
import net.minecraft.network.Packet;

public class EventPacket extends Event {
   private Packet packet;
   private EventPacket.PacketType packetType;

   public EventPacket(Packet packet, EventPacket.PacketType packetType) {
      this.packet = packet;
      this.packetType = packetType;
   }

   public Packet getPacket() {
      return this.packet;
   }

   public void setPacket(Packet packet) {
      this.packet = packet;
   }

   public EventPacket.PacketType getPacketType() {
      return this.packetType;
   }

   public void setPacketType(EventPacket.PacketType packetType) {
      this.packetType = packetType;
   }

   public static enum PacketType {
      Client,
      Server;
   }
}
