package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.JumpEvent;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.notification.Notification;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class LegitSpeed extends Module {
   public static final NumberValue<Number> c68456 = new NumberValue<Number>("Boost", 0.1D, 0.0D, 0.2D, 0.01D);
   public static final NumberValue<Number> c83071 = new NumberValue<Number>("Boost 1", 0.1D, 0.0D, 0.2D, 0.01D);
   public static final NumberValue<Number> c32580 = new NumberValue<Number>("Boost 2", 0.1D, 0.0D, 0.2D, 0.01D);
   public static final NumberValue<Number> c93581 = new NumberValue<Number>("Boost 3", 0.1D, 0.0D, 0.2D, 0.01D);
   public static BooleanValue c47530 = new BooleanValue("Lagback check", false);

   public LegitSpeed() {
      super("Legit Speed", new String[]{"LegitSpeed"}, ModuleType.c62580, ModuleType.c21190.c88511);
      this.c36162((new Color(99, 248, 91)).getRGB());
   }

   @EventTarget
   public void c49159(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (c47530.c1473().booleanValue() && PacketReceiveEvent.getPacket() instanceof S08PacketPlayerPosLook) {
         Sleep.INSTANCE.c83083().c43114().add(new Notification("LegitSpeed was disabled to prevent flags/errors", 3000L));
         this.c23631(false);
      }

   }

   @EventTarget
   public void c5134(JumpEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer != null && c25464() > 0 && mc.thePlayer.moveForward > 0.0F && mc.thePlayer.isSprinting() && c33659() > 20) {
         if (mc.thePlayer.onGround) {
            if (!mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
               float var3 = c68456.c53968().floatValue();
               mc.thePlayer.motionX *= (double)(1.0F + (float)c25464() * var3);
               mc.thePlayer.motionZ *= (double)(1.0F + (float)c25464() * var3);
            }

            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 0) {
               float var4 = c83071.c53968().floatValue();
               mc.thePlayer.motionX *= (double)(1.0F + (float)c25464() * var4);
               mc.thePlayer.motionZ *= (double)(1.0F + (float)c25464() * var4);
            }

            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 1) {
               float var5 = c32580.c53968().floatValue();
               mc.thePlayer.motionX *= (double)(1.0F + (float)c25464() * var5);
               mc.thePlayer.motionZ *= (double)(1.0F + (float)c25464() * var5);
            }

            if (mc.thePlayer.isPotionActive(Potion.moveSpeed) && mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 2) {
               float var6 = c93581.c53968().floatValue();
               mc.thePlayer.motionX *= (double)(1.0F + (float)c25464() * var6);
               mc.thePlayer.motionZ *= (double)(1.0F + (float)c25464() * var6);
            }
         }

      }
   }

   public static int c25464() {
      Module[] var0 = Value.c27574();
      return Minecraft.getMinecraft().thePlayer.isPotionActive(Potion.moveSpeed) ? Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static int c33659() {
      Module[] var0 = Value.c27574();
      return Minecraft.getMinecraft().thePlayer.isPotionActive(Potion.moveSpeed) ? Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.moveSpeed).getDuration() : 0;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
