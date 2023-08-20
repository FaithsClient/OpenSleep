package ft.sleep.api.events.world;

import ft.sleep.api.Event;
import net.minecraft.network.Packet;

public class EventPacketReceive extends Event {
   public static Packet packet;

   public EventPacketReceive(Packet packet) {
      packet = packet;
   }

   public static Packet getPacket() {
      return packet;
   }

   public void setPacket(Packet packet) {
      packet = packet;
   }
}
