//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import com.google.common.collect.Queues;
import ft.sleep.api.EventBus;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.PacketEvent;
import ft.sleep.injection.interfaces.INetworkManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({NetworkManager.class})
public abstract class MixinNetworkManager implements INetworkManager {
   @Final
   @Shadow
   private EnumPacketDirection direction;
   @Final
   @Shadow
   private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
   @Final
   @Shadow
   private final Queue outboundPacketsQueue = Queues.newConcurrentLinkedQueue();

   @Shadow
   public abstract boolean isChannelOpen();

   @Shadow
   protected abstract void dispatchPacket(Packet var1, GenericFutureListener[] var2);

   @Shadow
   protected abstract void flushOutboundQueue();

   @Inject(
      method = {"channelRead0"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void read(ChannelHandlerContext p_channelRead0_1_, Packet p_channelRead0_2_, CallbackInfo callback) {
      PacketEvent event = new PacketEvent(p_channelRead0_2_, PacketEvent.State.INCOMING);
      if (this.direction == EnumPacketDirection.CLIENTBOUND) {
         EventBus.getInstance().call(event);
      }

      EventPacketReceive event2 = new EventPacketReceive(p_channelRead0_2_);
      EventBus.getInstance().call(event2);
      if (event.isCancelled() || event2.isCancelled()) {
         callback.cancel();
      }

   }

   @Inject(
      method = {"sendPacket(Lnet/minecraft/network/Packet;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void send(Packet packetIn, CallbackInfo callback) {
      PacketEvent packetEvent = new PacketEvent(packetIn, PacketEvent.State.OUTGOING);
      if (this.direction == EnumPacketDirection.CLIENTBOUND) {
         EventBus.getInstance().call(packetEvent);
      }

      EventPacketSend event = new EventPacketSend(packetIn);
      EventBus.getInstance().call(event);
      if (event.isCancelled() || packetEvent.isCancelled()) {
         callback.cancel();
      }

   }

   public void sendPacketNoEvent(Packet packetIn) {
      if (this.isChannelOpen()) {
         this.flushOutboundQueue();
         this.dispatchPacket(packetIn, (GenericFutureListener[])null);
      } else {
         WriteLock writeLock = this.readWriteLock.writeLock();
         writeLock.lock();

         try {
            this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(packetIn, (GenericFutureListener[])null));
         } finally {
            writeLock.unlock();
         }
      }

   }
}
