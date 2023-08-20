//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.value.Numbers;
import java.util.ArrayList;
import java.util.List;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AntiFall extends Module {
   public Numbers modes$ = new Numbers("FallDistance", 3.0D, 1.0D, 20.0D, 1.0D);
   public TimerUtil tones$ = new TimerUtil();
   public boolean closing$;
   public double mongolia$;
   public List oriental$ = new ArrayList();

   public AntiFall() {
      super("ft.sleep.module.modules.AntiFall", new String[]{"ft.sleep.module.modules.AntiFall"}, ModuleType.Movement);
   }

   @EventHandler
   public void _typing(EventPacketSend gelafugu) {
      if (EventPacketSend.getPacket() instanceof C03PacketPlayer) {
         if (!lilagugi._forge()) {
            if (lilagugi.mc.thePlayer.fallDistance < lilagugi.modes$.getValue().floatValue()) {
               ((EventPacketSend)gelafugu).cancel();
               lilagugi.oriental$.add(EventPacketSend.getPacket());
            } else if (!lilagugi.oriental$.isEmpty()) {
               for(Object zezinamu : lilagugi.oriental$) {
                  Object umapubil = (C03PacketPlayer)zezinamu;
                  double var5 = umapubil.y;
                  var5 = lilagugi.mongolia$;
                  PacketUtils._gratis(zezinamu);
               }

               lilagugi.oriental$.clear();
            }
         } else {
            lilagugi.mongolia$ = lilagugi.mc.thePlayer.posY;
            if (!lilagugi.oriental$.isEmpty()) {
               lilagugi.oriental$.forEach(PacketUtils::_gratis);
               lilagugi.oriental$.clear();
            }
         }
      }

   }

   public boolean _forge() {
      if (suicide.mc.thePlayer.posY < Double.longBitsToDouble(0L)) {
         return false;
      } else {
         for(Object sides = 0; sides < (int)suicide.mc.thePlayer.posY + 2; sides += 2) {
            Object therapy = suicide.mc.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-sides), Double.longBitsToDouble(0L));
            if (!suicide.mc.theWorld.getCollidingBoundingBoxes(suicide.mc.thePlayer, therapy).isEmpty()) {
               return true;
            }
         }

         return false;
      }
   }
}
