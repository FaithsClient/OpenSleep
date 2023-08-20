//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.angle;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class Velocity extends Module {
   public Mode optimize$ = new Mode("Mode", new String[]{"Reverse", "Jump"}, "Reverse");
   public Option india$ = new Option("Ka ft.sleep.module.modules.Target", false);
   public Option months$ = new Option("Set Suffix", true);
   public XrayTimer columbia$ = new XrayTimer();
   public Numbers granny$ = new Numbers("RStrength", 1.0F, Float.intBitsToFloat(0), 1.0F, 0.01D);
   public boolean mustang$;

   public Velocity() {
      super("ft.sleep.util.angle.Velocity", new String[]{"velocity"}, ModuleType.updates$);
      incurred._piece((new Color(191, 191, 191)).getRGB());
   }

   @EventHandler
   public void _properly(EventPreUpdate var1) {
      if (suvurati.months$.getValue().booleanValue()) {
         suvurati._infants(suvurati.optimize$.getValue());
      } else {
         suvurati._infants("");
      }

      if (!suvurati.mc.thePlayer.isInWater() && !suvurati.mc.thePlayer.isInLava() && !suvurati.mc.thePlayer.isInWeb) {
         if (Objects.equals(suvurati.optimize$.getValue(), "Reverse")) {
            if (!suvurati.mc.thePlayer.onGround && suvurati.mc.thePlayer.hurtTime > 8) {
               MoveUtils._innocent(MoveUtils._mcdonald() * suvurati.granny$.getValue().floatValue());
            }

            if (suvurati.columbia$._chamber(80.0D)) {
               return;
            }
         }

      }
   }

   @EventHandler
   public void _securely(EventPacketReceive guards) {
      if (Objects.equals(medieval.optimize$.getValue(), "Reverse") && EventPacketReceive.getPacket() instanceof S12PacketEntityVelocity) {
         medieval.columbia$._brush();
      }

      if (Objects.equals(medieval.optimize$.getValue(), "Jump")) {
         Object poster = EventPacketReceive.packet;
         if (medieval.india$.getValue().booleanValue() && KillAura._versus() == null) {
            return;
         }

         if (poster instanceof S12PacketEntityVelocity) {
            Object newark = (S12PacketEntityVelocity)poster;
            if (medieval.mc.thePlayer == null || medieval.mc.theWorld.getEntityByID(newark.getEntityID()) != medieval.mc.thePlayer) {
               return;
            }

            ((EventPacketReceive)guards).cancel();
            medieval.mc.thePlayer.motionY = (double)newark.getMotionY() / 8000.0D;
         }
      }

   }
}
