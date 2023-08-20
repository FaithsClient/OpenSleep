//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventJump;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;

public class LegitSpeed extends Module {
   public static Numbers tulsa$ = new Numbers("Boost 1", 0.1D, Double.longBitsToDouble(0L), 0.2D, 0.01D);
   public static Numbers feature$ = new Numbers("Boost 2", 0.1D, Double.longBitsToDouble(0L), 0.2D, 0.01D);
   public static Numbers classes$ = new Numbers("Boost 3", 0.1D, Double.longBitsToDouble(0L), 0.2D, 0.01D);
   public static Option strip$ = new Option("Lagback check", false);

   public LegitSpeed() {
      super("Legit ft.sleep.module.modules.Speed", new String[]{"ft.sleep.module.modules.LegitSpeed"}, ModuleType.Movement);
      romance._piece((new Color(99, 248, 91)).getRGB());
   }

   @EventHandler
   public void _fabulous(EventPacketReceive var1) {
      if (strip$.getValue().booleanValue() && EventPacketReceive.getPacket() instanceof S08PacketPlayerPosLook) {
         Client.surround$.î ?()._arabia().add(new Notification("ft.sleep.module.modules.LegitSpeed was disabled to prevent flags/errors", (long)1658322375 ^ 1658320511L));
         views._serial(false);
      }

   }

   @EventHandler
   public void _ports(EventJump labobiya) {
      if (vazeporo.mc.thePlayer != null && _referral() > 0 && vazeporo.mc.thePlayer.moveForward > Float.intBitsToFloat(0) && vazeporo.mc.thePlayer.isSprinting() && _cables() > 20) {
         if (vazeporo.mc.thePlayer.onGround && vazeporo.mc.thePlayer.isPotionActive(Potion.moveSpeed) && vazeporo.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 0) {
            float var2 = tulsa$.getValue().floatValue();
            vazeporo.mc.thePlayer.motionX *= (double)(1.0F + (float)_referral() * var2);
            vazeporo.mc.thePlayer.motionZ *= (double)(1.0F + (float)_referral() * var2);
         }

         if (vazeporo.mc.thePlayer.isPotionActive(Potion.moveSpeed) && vazeporo.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 1) {
            float var3 = feature$.getValue().floatValue();
            vazeporo.mc.thePlayer.motionX *= (double)(1.0F + (float)_referral() * var3);
            vazeporo.mc.thePlayer.motionZ *= (double)(1.0F + (float)_referral() * var3);
         }

         if (vazeporo.mc.thePlayer.isPotionActive(Potion.moveSpeed) && vazeporo.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 2) {
            float var4 = classes$.getValue().floatValue();
            vazeporo.mc.thePlayer.motionX *= (double)(1.0F + (float)_referral() * var4);
            vazeporo.mc.thePlayer.motionZ *= (double)(1.0F + (float)_referral() * var4);
         }

      }
   }

   public static int _referral() {
      return Minecraft.getMinecraft().thePlayer.isPotionActive(Potion.moveSpeed) ? Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static int _cables() {
      return Minecraft.getMinecraft().thePlayer.isPotionActive(Potion.moveSpeed) ? Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.moveSpeed).getDuration() : 0;
   }
}
