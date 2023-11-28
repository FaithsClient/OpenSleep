package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.network.Packet;

public class PacketReceiveEvent extends Event {
   public static Packet c21835;

   public PacketReceiveEvent(Packet var1) {
      c21835 = var1;
   }

   public static Packet getPacket() {
      return c21835;
   }

   public void c48559(Packet var1) {
      c21835 = var1;
   }
}
