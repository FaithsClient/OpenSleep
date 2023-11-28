package rip.sleep.injection.mixins;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.Packet;

class InboundHandlerTuplePacketListener {
   private final Packet packet;
   private final GenericFutureListener<? extends Future<? super Void>>[] futureListeners;

   @SafeVarargs
   public InboundHandlerTuplePacketListener(Packet var1, GenericFutureListener<? extends Future<? super Void>>... var2) {
      this.packet = var1;
      this.futureListeners = var2;
   }
}
