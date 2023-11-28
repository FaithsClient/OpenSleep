package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.network.Packet;

public class PacketSendEvent extends Event {
   public static Packet<?> c26827;

   public PacketSendEvent(Packet var1) {
      c26827 = var1;
   }

   public static Packet c81894() {
      return c26827;
   }

   public void c48559(Packet var1) {
      c26827 = var1;
   }
}
