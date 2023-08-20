package ft.sleep.injection.mixins;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.Packet;

class InboundHandlerTuplePacketListener {
   private final Packet packet;
   private final GenericFutureListener[] futureListeners;

   @SafeVarargs
   public InboundHandlerTuplePacketListener(Packet inPacket, GenericFutureListener... inFutureListeners) {
      this.packet = inPacket;
      this.futureListeners = inFutureListeners;
   }
}
