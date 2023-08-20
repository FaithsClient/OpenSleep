package ft.sleep.api.events.world;

import ft.sleep.api.Event;
import net.minecraft.network.Packet;

public class PacketEvent extends Event {
   private final PacketEvent.State state;
   private final Packet packet;

   public PacketEvent(Packet packet, PacketEvent.State state) {
      this.state = state;
      this.packet = packet;
   }

   public PacketEvent.State getState() {
      return this.state;
   }

   public Packet getPacket() {
      return this.packet;
   }

   public static enum State {
      INCOMING,
      OUTGOING;
   }
}
