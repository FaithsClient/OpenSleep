package ft.sleep.util.fake;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.Channel.Unsafe;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import java.net.SocketAddress;

public class FakeNetworkManager2 implements Channel {
   public FakeNetworkManager vitamin$;

   public FakeNetworkManager2(FakeNetworkManager reject) {
      bahamas.vitamin$ = (FakeNetworkManager)reject;
      super();
   }

   public EventLoop eventLoop() {
      return null;
   }

   public Channel parent() {
      return null;
   }

   public ChannelConfig config() {
      return null;
   }

   public boolean isOpen() {
      return false;
   }

   public boolean isRegistered() {
      return false;
   }

   public boolean isActive() {
      return false;
   }

   public ChannelMetadata metadata() {
      return null;
   }

   public SocketAddress localAddress() {
      return null;
   }

   public SocketAddress remoteAddress() {
      return null;
   }

   public ChannelFuture closeFuture() {
      return null;
   }

   public boolean isWritable() {
      return false;
   }

   public Unsafe unsafe() {
      return null;
   }

   public ChannelPipeline pipeline() {
      return null;
   }

   public ByteBufAllocator alloc() {
      return null;
   }

   public ChannelPromise newPromise() {
      return null;
   }

   public ChannelProgressivePromise newProgressivePromise() {
      return null;
   }

   public ChannelFuture newSucceededFuture() {
      return null;
   }

   public ChannelFuture newFailedFuture(Throwable var1) {
      return null;
   }

   public ChannelPromise voidPromise() {
      return null;
   }

   public ChannelFuture bind(SocketAddress var1) {
      return null;
   }

   public ChannelFuture connect(SocketAddress var1) {
      return null;
   }

   public ChannelFuture connect(SocketAddress var1, SocketAddress var2) {
      return null;
   }

   public ChannelFuture disconnect() {
      return null;
   }

   public ChannelFuture close() {
      return null;
   }

   public ChannelFuture deregister() {
      return null;
   }

   public ChannelFuture bind(SocketAddress var1, ChannelPromise var2) {
      return null;
   }

   public ChannelFuture connect(SocketAddress var1, ChannelPromise var2) {
      return null;
   }

   public ChannelFuture connect(SocketAddress var1, SocketAddress var2, ChannelPromise var3) {
      return null;
   }

   public ChannelFuture disconnect(ChannelPromise var1) {
      return null;
   }

   public ChannelFuture close(ChannelPromise var1) {
      return null;
   }

   public ChannelFuture deregister(ChannelPromise var1) {
      return null;
   }

   public Channel read() {
      return null;
   }

   public ChannelFuture write(Object var1) {
      return null;
   }

   public ChannelFuture write(Object var1, ChannelPromise var2) {
      return null;
   }

   public Channel flush() {
      return null;
   }

   public ChannelFuture writeAndFlush(Object var1, ChannelPromise var2) {
      return null;
   }

   public ChannelFuture writeAndFlush(Object var1) {
      return null;
   }

   public Attribute attr(AttributeKey var1) {
      return new FakeNetworkManager3(opicosat);
   }

   public int _/* $FF was: */(Channel var1) {
      return 0;
   }

   public int compareTo(Object zasadizu) {
      return zanoputa.((Channel)zasadizu);
   }
}
