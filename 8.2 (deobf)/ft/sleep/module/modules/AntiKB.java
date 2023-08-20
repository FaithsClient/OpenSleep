//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;

import ft.sleep.module.Module;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;

public class AntiKB extends Module {
   public Numbers victory$ = new Numbers("Vertical", 100.0D, Double.longBitsToDouble(0L), 100.0D, 5.0D);
   public Numbers borders$ = new Numbers("Horizontal", Double.longBitsToDouble(0L), -100.0D, 100.0D, 5.0D);
   public Numbers senate$ = new Numbers("C-Hangce", 100.0D, Double.longBitsToDouble(0L), 100.0D, 1.0D);
   public Option freely$ = new Option("Ka ft.sleep.module.modules.Target", false);
   public Option pickup$ = new Option("On ft.sleep.module.modules.Target", false);
   public Option itself$ = new Option("Only Ground", false);
   public Option newport$ = new Option("Sprinting", false);

   public AntiKB() {
      super("Anti KB", new String[]{"ft.sleep.module.modules.AntiKB"}, ModuleType.rolls$);
      require._piece((new Color(191, 191, 191)).getRGB());
   }

   @EventHandler
   public void _urban(EventPreUpdate var1) {
      ireyotul._infants(ireyotul.borders$.getValue() + "%");
   }

   public void _discs() {
   }

   @EventHandler
   public void _damage(EventPacketReceive bulletin) {
      if (!computer.itself$.getValue().booleanValue() || computer.mc.thePlayer.onGround) {
         if (!computer.newport$.getValue().booleanValue() || computer.mc.thePlayer.isSprinting()) {
            if (!computer.freely$.getValue().booleanValue() || KillAura._versus() != null) {
               if (!computer.pickup$.getValue().booleanValue() || computer.mc.objectMouseOver != null && computer.mc.objectMouseOver.entityHit != null) {
                  Object counter = EventPacketReceive.getPacket();
                  Object clarity = computer.borders$.getValue().doubleValue();
                  Object episodes = computer.victory$.getValue().doubleValue();
                  if (counter instanceof S12PacketEntityVelocity) {
                     Object planning = (S12PacketEntityVelocity)counter;
                     if (planning.getEntityID() == computer.mc.thePlayer.getEntityId()) {
                        if (clarity == Double.longBitsToDouble(0L)) {
                           ((EventPacketReceive)bulletin).setCancelled(true);
                           if (episodes != Double.longBitsToDouble(0L)) {
                              computer.mc.thePlayer.motionY = (double)planning.getMotionY() / 8000.0D;
                           }

                           return;
                        }

                        planning.motionX = (int)((double)planning.motionX * (clarity / 100.0D));
                        planning.motionY = (int)((double)planning.motionY * (episodes / 100.0D));
                        planning.motionZ = (int)((double)planning.motionZ * (clarity / 100.0D));
                     }
                  }

                  if (counter instanceof S27PacketExplosion) {
                     Object var14 = (S27PacketExplosion)counter;
                     Object disabled = var14.getX();
                     double var10 = var14.getY();
                     double var12 = var14.getZ();
                     if (clarity == Double.longBitsToDouble(0L) && episodes == Double.longBitsToDouble(0L)) {
                        ((EventPacketReceive)bulletin).setCancelled(true);
                        return;
                     }

                     double var10000 = disabled * (clarity / 100.0D);
                     var10000 = var10 * (episodes / 100.0D);
                     var10000 = var12 * (clarity / 100.0D);
                  }

               }
            }
         }
      }
   }
}
