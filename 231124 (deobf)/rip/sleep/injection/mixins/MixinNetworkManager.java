package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import com.google.common.collect.Queues;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import rip.sleep.injection.in.INetworkManager;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.util.PacketUtilA;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.event.events.PacketDispatchEvent;

@Mixin({NetworkManager.class})
public abstract class MixinNetworkManager implements INetworkManager {
   @Final
   @Shadow
   private EnumPacketDirection field_179294_g;
   @Final
   @Shadow
   private final ReentrantReadWriteLock field_181680_j = new ReentrantReadWriteLock();
   @Final
   @Shadow
   private final Queue<InboundHandlerTuplePacketListener> field_150745_j = Queues.newConcurrentLinkedQueue();

   @Shadow
   public abstract boolean func_150724_d();

   @Shadow
   protected abstract void func_150732_b(Packet var1, GenericFutureListener[] var2);

   @Shadow
   protected abstract void func_150733_h();

   @Inject(
      method = {"channelRead0"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void read(ChannelHandlerContext var1, Packet var2, CallbackInfo var3) {
      PacketDispatchEvent var4 = new PacketDispatchEvent(var2, PacketDispatchEvent.c23173.c19086);
      if (this.field_179294_g == EnumPacketDirection.CLIENTBOUND) {
         EventBus.getInstance().call(var4);
      }

      PacketReceiveEvent var5 = new PacketReceiveEvent(var2);
      EventBus.getInstance().call(var5);
      if (var4.c58917() || var5.c58917()) {
         var3.cancel();
      }

   }

   @Inject(
      method = {"dispatchPacket"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void send(Packet var1, GenericFutureListener<? extends Future<? super Void>>[] var2, CallbackInfo var3) {
      PacketDispatchEvent var4 = new PacketDispatchEvent(var1, PacketDispatchEvent.c23173.c81278);
      EventBus.getInstance().call(var4);
      if (var4.c58917()) {
         var3.cancel();
      }

   }

   @Inject(
      method = {"sendPacket(Lnet/minecraft/network/Packet;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void send(Packet var1, CallbackInfo var2) {
      PacketSendEvent var3 = new PacketSendEvent(var1);
      if (!PacketUtilA.isCancelled(var1)) {
         EventBus.getInstance().call(var3);
      }

      if (var3.c58917()) {
         var2.cancel();
      }

   }

   public void sendPacketNoEvent(Packet var1) {
      if (this.func_150724_d()) {
         this.func_150733_h();
         this.func_150732_b(var1, (GenericFutureListener[])null);
      } else {
         WriteLock var2 = this.field_181680_j.writeLock();
         var2.lock();
         MixinNetworkManager var10000 = this;

         try {
            var10000.field_150745_j.add(new InboundHandlerTuplePacketListener(var1, (GenericFutureListener[])null));
         } finally {
            var2.unlock();
         }
      }

   }
}
