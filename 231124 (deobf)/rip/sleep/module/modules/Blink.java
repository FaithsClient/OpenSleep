package rip.sleep.module.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PacketUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class Blink extends Module {
   private final ConcurrentLinkedQueue<Packet<?>> c67277 = new ConcurrentLinkedQueue();
   private final BooleanValue c82718 = new BooleanValue("Pulse", false);
   private final NumberValue<Number> c66662 = new NumberValue<Number>("Tick Delay", Integer.valueOf(20), Integer.valueOf(4), Integer.valueOf(100), Integer.valueOf(1));
   private EntityOtherPlayerMP c15348;
   List<Vec3> c6035 = new ArrayList();

   public Blink() {
      super("Blink", new String[]{"blonk"}, ModuleType.c62580, ModuleType.c21190.c37885);
   }

   public void c83205() {
      this.c6035.clear();
   }

   @EventTarget
   private void c72864(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer != null && !mc.thePlayer.isDead && !mc.isSingleplayer() && mc.thePlayer.ticksExisted >= 50) {
         Packet var3 = PacketSendEvent.c81894();
         if (PacketSendEvent.c81894() instanceof C03PacketPlayer || PacketSendEvent.c81894() instanceof C0BPacketEntityAction || var3 instanceof C0FPacketConfirmTransaction || PacketSendEvent.c81894() instanceof C08PacketPlayerBlockPlacement) {
            this.c67277.add(PacketSendEvent.c81894());
            var1.cancel();
         }

         if (PacketSendEvent.c81894() instanceof C0APacketAnimation || PacketSendEvent.c81894() instanceof C02PacketUseEntity) {
            var1.cancel();
         }

         if (this.c82718.c1473().booleanValue() && !this.c67277.isEmpty() && mc.thePlayer.ticksExisted % this.c66662.c53968().intValue() == 0 && Math.random() > 0.1D) {
            this.c67277.forEach(PacketUtilA::sendPacketNoEvent);
            this.c67277.clear();
         }

      } else {
         this.c67277.clear();
      }
   }

   @EventTarget
   public void c20352(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer.ticksExisted <= 5) {
         this.c19741();
      }

      if (mc.thePlayer.ticksExisted >= 50) {
         if (mc.thePlayer.lastTickPosX != mc.thePlayer.posX || mc.thePlayer.lastTickPosY != mc.thePlayer.posY || mc.thePlayer.lastTickPosZ != mc.thePlayer.posZ) {
            this.c6035.add(new Vec3(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ));
         }

         if (this.c82718.c1473().booleanValue() && this.c6035.size() > this.c66662.c53968().intValue()) {
            this.c6035.remove(0);
         }

         if (this.c82718.c1473().booleanValue() && this.c15348 != null) {
            mc.theWorld.removeEntityFromWorld(this.c15348.getEntityId());
         }

      }
   }

   public void c71897() {
      this.c67277.forEach(PacketUtilA::sendPacketNoEvent);
      this.c67277.clear();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
