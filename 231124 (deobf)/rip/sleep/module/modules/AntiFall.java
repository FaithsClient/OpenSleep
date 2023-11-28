package rip.sleep.module.modules;

import java.util.concurrent.ConcurrentLinkedQueue;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PacketUtilA;
import rip.sleep.util.PlayerUtilD;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public class AntiFall extends Module {
   private final NumberValue<Number> c73821 = new NumberValue<Number>("FallDistance", 3.0D, 1.0D, 20.0D, 1.0D);
   private final ConcurrentLinkedQueue<C03PacketPlayer> c95185 = new ConcurrentLinkedQueue();
   private Vec3 c15323;

   public AntiFall() {
      super("Anti Fall", new String[]{"AntiFall"}, ModuleType.c62580, ModuleType.c21190.c88511);
   }

   @EventTarget
   public void c91663(PacketSendEvent var1) {
      Value.c27574();
      this.c2159("Watchdog");
      Packet var3 = PacketSendEvent.c81894();
      Sleep.getInstance();
      Sleep.c33759();
      if (!ModuleManager.c25475(FBJump.class).c24622()) {
         Sleep.getInstance();
         Sleep.c33759();
         if (!ModuleManager.c25475(Scaffold.class).c24622()) {
            if (var3 instanceof C03PacketPlayer) {
               C03PacketPlayer var4 = (C03PacketPlayer)var3;
               if (!this.c31833()) {
                  this.c95185.add(var4);
                  var1.cancel();
                  if (this.c15323 == null || mc.thePlayer.fallDistance <= this.c73821.c53968().floatValue()) {
                     return;
                  }

                  PacketUtilA.sendPacketNoEvent(new C04PacketPlayerPosition(this.c15323.xCoord, -420.0D, this.c15323.zCoord, false));
               }

               if (mc.thePlayer.onGround) {
                  this.c15323 = new Vec3(var4.x, var4.y, var4.z);
               }

               if (!this.c95185.isEmpty()) {
                  this.c95185.forEach(PacketUtilA::sendPacketNoEvent);
                  this.c95185.clear();
               }
            }

            return;
         }
      }

   }

   public boolean c77729(double var1, boolean var3) {
      Module[] var4 = Value.c27574();
      if (var3) {
         int var5 = 0;
         if ((double)var5 < var1) {
            AxisAlignedBB var6 = mc.thePlayer.getEntityBoundingBox().offset(0.0D, (double)(-var5), 0.0D);
            if (!mc.theWorld.getCollidingBoundingBoxes(mc.thePlayer, var6).isEmpty()) {
               return true;
            }

            var5 = var5 + 2;
         }
      }

      int var8 = 0;
      if ((double)var8 < var1) {
         if (PlayerUtilD.c15285(0.0D, (double)(-var8), 0.0D).isFullBlock()) {
            return true;
         }

         ++var8;
      }

      return false;
   }

   public boolean c3909(double var1) {
      return this.c77729(var1, true);
   }

   public boolean c31833() {
      return this.c3909(mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight());
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
