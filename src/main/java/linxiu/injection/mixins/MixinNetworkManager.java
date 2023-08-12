/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package linxiu.injection.mixins;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.events.misc.EventPacket;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventPacketSend;
import linxiu.injection.interfaces.INetworkManager;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Mixin(NetworkManager.class)
public abstract class MixinNetworkManager implements INetworkManager {

	@Shadow
	private Channel channel;
	@Final
	@Shadow
	private Queue outboundPacketsQueue;

	@Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
	private void channelRead0(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
		EventPacketReceive event = new EventPacketReceive(packet);
		EventBus.getInstance().call(event);
		if (event.isCancelled())
			callbackInfo.cancel();

	}

	@Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
	private void sendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
		EventPacketSend event = new EventPacketSend(packet);
		EventBus.getInstance().call(event);
		if (event.isCancelled())
			callbackInfo.cancel();


	}

	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	@Shadow
	public abstract boolean isChannelOpen();

	@Override
	public void sendPacketNoEvent(final Packet packet) {
		if (this.channel != null && this.channel.isOpen()) {
			this.flushOutboundQueue();
			this.dispatchPacket(packet, null);
		} else {
			this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(packet,
					(GenericFutureListener<? extends Future<? super Void>>[]) null));
		}
	}

	@Override
	public void sendPacketSilent(Packet packetIn) {
		if (this.isChannelOpen()) {
			this.flushOutboundQueue();
			this.dispatchPacket(packetIn, null);
		} else {
			this.readWriteLock.writeLock().lock();

			try {
				this.outboundPacketsQueue
						.add(new InboundHandlerTuplePacketListener(packetIn, (GenericFutureListener[]) null));
			} finally {
				this.readWriteLock.writeLock().unlock();
			}
		}
	}

	@Shadow
	protected abstract void dispatchPacket(Packet a, GenericFutureListener[] a2);

	@Shadow
	protected abstract void flushOutboundQueue();

}

class InboundHandlerTuplePacketListener {
	private final Packet packet;
	private final GenericFutureListener<? extends Future<? super Void>>[] futureListeners;

	@SafeVarargs
	public InboundHandlerTuplePacketListener(Packet inPacket,
			GenericFutureListener<? extends Future<? super Void>>... inFutureListeners) {
		this.packet = inPacket;
		this.futureListeners = inFutureListeners;
	}
}
