package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.network.Packet;

public class PacketDispatchEvent extends Event {
   private final PacketDispatchEvent.c23173 c85499;
   private Packet<?> c58759;

   public PacketDispatchEvent(Packet<?> var1, PacketDispatchEvent.c23173 var2) {
      this.c85499 = var2;
      this.c58759 = var1;
   }

   public PacketDispatchEvent.c23173 c94537() {
      return this.c85499;
   }

   public Packet<?> c81894() {
      return this.c58759;
   }

   public void c48559(Packet<?> var1) {
      this.c58759 = var1;
   }

   public static enum c23173 {
      c19086,
      c81278;
   }
}
