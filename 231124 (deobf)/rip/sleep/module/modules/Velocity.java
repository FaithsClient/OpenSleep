package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Iterator;
import java.util.Objects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtilB;
import rip.sleep.util.TimerUtilC;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class Velocity extends Module {
   private final ModeValue c13694 = new ModeValue("Mode", new String[]{"Reverse", "Hypixel"}, "Reverse");
   private BooleanValue c463 = new BooleanValue("Set Suffix", true);
   private BooleanValue c56281 = new BooleanValue("Air 00", () -> {
      return this.c13694.c54460().equalsIgnoreCase("Hypixel");
   }, false);
   public NumberValue<Number> c3180 = new NumberValue<Number>("RStrength", () -> {
      return this.c13694.c54460().equalsIgnoreCase("Reverse");
   }, 1.0F, 0.0F, 1.0F, 0.01D);
   public TimerUtilC c92320 = new TimerUtilC();
   int c94981 = 0;
   boolean c34956 = false;

   public Velocity() {
      super("Velocity", new String[]{"velocity"}, ModuleType.c13050, ModuleType.c21190.c47958);
      this.c36162((new Color(191, 191, 191)).getRGB());
   }

   @EventTarget
   private void c73835(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c463.c1473().booleanValue()) {
         this.c2159(this.c13694.c54460());
      }

      this.c2159("");
      if (!mc.thePlayer.isInWater() && !mc.thePlayer.isInLava() && !mc.thePlayer.isInWeb) {
         if (Objects.equals(this.c13694.c54460(), "Reverse")) {
            if (!mc.thePlayer.onGround && mc.thePlayer.hurtTime > 8) {
               PlayerUtilB.c20816(PlayerUtilB.c3701() * this.c3180.c53968().floatValue());
            }

            if (this.c92320.c27234(80.0D)) {
               return;
            }
         }

      }
   }

   @EventTarget
   private void c93300(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (Objects.equals(this.c13694.c54460(), "Reverse") && PacketReceiveEvent.getPacket() instanceof S12PacketEntityVelocity) {
         this.c92320.c13539();
      }

      if (Objects.equals(this.c13694.c54460(), "Hypixel") && PacketReceiveEvent.getPacket() instanceof S12PacketEntityVelocity) {
         S12PacketEntityVelocity var3 = (S12PacketEntityVelocity) PacketReceiveEvent.getPacket();
         if (var3.getEntityID() == mc.thePlayer.getEntityId()) {
            var1.cancel();
            if (this.c56281.c1473().booleanValue()) {
               if (this.c34956 || this.c94981 > 5 && !mc.thePlayer.onGround) {
                  return;
               }

               mc.thePlayer.motionY = (double)var3.motionY / 8000.0D;
            }

            mc.thePlayer.motionY = (double)var3.motionY / 8000.0D;
         }
      }

   }

   @EventTarget
   private void c5786(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (Objects.equals(this.c13694.c54460(), "Hypixel") && this.c56281.c1473().booleanValue()) {
         if (mc.thePlayer.hurtTime == 9) {
            this.c34956 = false;
         }

         if (c29398() && this.c74701()) {
            this.c34956 = true;
         }

         if (!mc.thePlayer.onGround) {
            ++this.c94981;
         }

         this.c94981 = 0;
      }

   }

   public static boolean c29398() {
      Minecraft var1 = Minecraft.getMinecraft();
      Value.c27574();
      EntityPlayerSP var2 = var1.thePlayer;
      WorldClient var3 = var1.theWorld;
      double var4 = 5.0D;
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

   public boolean c74701() {
      double var1 = mc.thePlayer.posX;
      double var3 = mc.thePlayer.posY;
      double var5 = mc.thePlayer.posZ;
      return mc.theWorld.getBlockState(new BlockPos(var1, var3 - 4.0D, var5)).getBlock() == Blocks.air;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
