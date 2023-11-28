package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import net.minecraft.util.Timer;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MoveEvent;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.ChatUtilA;
import rip.sleep.util.PlayerUtil;
import rip.sleep.util.PlayerUtilB;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class Speed extends Module {
   private ModeValue c65729 = new ModeValue("Mode", new String[]{"Hypixel"}, "Hypixel");
   public static final NumberValue<Number> c42501 = new NumberValue<Number>("Speed 1", 0.6D, 0.6D, 1.0D, 0.01D);
   public static final NumberValue<Number> c2694 = new NumberValue<Number>("Speed 2", 0.6D, 0.6D, 1.0D, 0.01D);
   public static final NumberValue<Number> c55471 = new NumberValue<Number>("Speed 3", 0.6D, 0.6D, 1.0D, 0.01D);
   public static BooleanValue c9616 = new BooleanValue("Lag backcheck", false);

   public Speed() {
      super("Speed", new String[]{"Speed"}, ModuleType.c62580, ModuleType.c21190.c88511);
      this.c36162((new Color(99, 248, 91)).getRGB());
   }

   public void c83205() {
      ChatUtilA.c14057().timerSpeed = 1.0F;
   }

   public void c71897() {
      ChatUtilA.c14057().timerSpeed = 1.0F;
   }

   @EventTarget
   public void c49159(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (c9616.c1473().booleanValue() && PacketReceiveEvent.getPacket() instanceof S08PacketPlayerPosLook) {
         Sleep.INSTANCE.c83083().c43114().add(new Notification("Speed was disabled to prevent flags/errors", 3000L));
         this.c23631(false);
      }

   }

   @EventTarget
   public void c47175(MoveEvent var1) {
      Value.c27574();
      this.c2159(this.c65729.c54460());
      if (this.c65729.c54460().equals("Hypixel")) {
         if (InvMove.c54228) {
            return;
         }

         if (PlayerUtil.c78108() && !PlayerUtil.c61628() && !PlayerUtil.c57263() && mc.thePlayer.onGround) {
            var1.c59560(mc.thePlayer.motionY = 0.41999998688698D + (double) PlayerUtil.c25891() * 0.1D);
            if (!mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
               float var3 = 0.6F;
               PlayerUtilB.c9624(var1, (double)var3);
            }

            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 0) {
               float var4 = c42501.c53968().floatValue();
               PlayerUtilB.c9624(var1, (double)var4 + (double) PlayerUtil.c74275() * 0.08D);
            }

            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 1) {
               float var5 = c2694.c53968().floatValue();
               PlayerUtilB.c9624(var1, (double)var5 + (double) PlayerUtil.c74275() * 0.08D);
            }

            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 2) {
               float var6 = c55471.c53968().floatValue();
               PlayerUtilB.c9624(var1, (double)var6 + (double) PlayerUtil.c74275() * 0.08D);
            }
         }
      }

   }

   public static void c43045(Timer var0, float var1) {
      var0.timerSpeed = var1;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
