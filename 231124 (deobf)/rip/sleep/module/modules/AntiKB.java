package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class AntiKB extends Module {
   public NumberValue<Number> c32799 = new NumberValue<Number>("Vertical", 100.0D, 0.0D, 100.0D, 5.0D);
   public NumberValue<Number> c75258 = new NumberValue<Number>("Horizontal", 0.0D, -100.0D, 100.0D, 5.0D);
   public NumberValue<Number> c98352 = new NumberValue<Number>("C-Hangce", 100.0D, 0.0D, 100.0D, 1.0D);
   private final BooleanValue c49007 = new BooleanValue("Ka Target", false);
   private final BooleanValue c99162 = new BooleanValue("On Target", false);
   private final BooleanValue c26510 = new BooleanValue("Only Ground", false);
   private final BooleanValue c45804 = new BooleanValue("Sprinting", false);

   public AntiKB() {
      super("Anti KB", new String[]{"AntiKB"}, ModuleType.c13050, ModuleType.c21190.c28329);
      this.c36162((new Color(191, 191, 191)).getRGB());
   }

   @EventTarget
   public void c458(MotionUpdateEvent var1) {
      this.c2159(this.c75258.c53968() + "%");
   }

   public void c71897() {
   }

   @EventTarget
   public void c19091(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (!this.c26510.c1473().booleanValue() || mc.thePlayer.onGround) {
         if (!this.c45804.c1473().booleanValue() || mc.thePlayer.isSprinting()) {
            if (!this.c49007.c1473().booleanValue() || KillAura.c79073() != null) {
               if (!this.c99162.c1473().booleanValue() || mc.objectMouseOver != null && mc.objectMouseOver.entityHit != null) {
                  Packet var3 = PacketReceiveEvent.getPacket();
                  double var4 = this.c75258.c53968().doubleValue();
                  double var6 = this.c32799.c53968().doubleValue();
                  if (var3 instanceof S12PacketEntityVelocity) {
                     S12PacketEntityVelocity var8 = (S12PacketEntityVelocity)var3;
                     if (var8.getEntityID() == mc.thePlayer.getEntityId()) {
                        if (var4 == 0.0D) {
                           var1.c8253(true);
                           if (var6 != 0.0D) {
                              mc.thePlayer.motionY = (double)var8.getMotionY() / 8000.0D;
                           }

                           return;
                        }

                        var8.motionX = (int)((double)var8.motionX * (var4 / 100.0D));
                        var8.motionY = (int)((double)var8.motionY * (var6 / 100.0D));
                        var8.motionZ = (int)((double)var8.motionZ * (var4 / 100.0D));
                     }
                  }

                  if (var3 instanceof S27PacketExplosion) {
                     S27PacketExplosion var15 = (S27PacketExplosion)var3;
                     double var9 = var15.getX();
                     double var11 = var15.getY();
                     double var13 = var15.getZ();
                     if (var4 == 0.0D && var6 == 0.0D) {
                        var1.c8253(true);
                        return;
                     }

                     double var10000 = var9 * (var4 / 100.0D);
                     var10000 = var11 * (var6 / 100.0D);
                     var10000 = var13 * (var4 / 100.0D);
                  }

               }
            }
         }
      }
   }

   public static boolean c29398() {
      Minecraft var1 = Minecraft.getMinecraft();
      EntityPlayerSP var2 = var1.thePlayer;
      WorldClient var3 = var1.theWorld;
      double var4 = 5.0D;
      Value.c27574();
      Iterator var6 = var3.loadedEntityList.iterator();
      if (var6.hasNext()) {
         Entity var7 = (Entity)var6.next();
         if (!(var7 instanceof EntityPlayerSP) && "Fireball".equals(var7.getName())) {
            double var8 = var2.getDistanceSqToEntity(var7);
            if (var8 <= var4 * var4) {
               return true;
            }
         }
      }

      return false;
   }

   public static boolean c61143() {
      Value.c27574();
      Minecraft var1 = Minecraft.getMinecraft();
      EntityPlayerSP var2 = var1.thePlayer;
      WorldClient var3 = var1.theWorld;
      BlockPos var4 = var2.getPosition();
      byte var5 = 4;
      BlockPos var6 = var4.down(var5);
      return var3.isAirBlock(var6);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
