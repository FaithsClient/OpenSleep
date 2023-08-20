//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.packet.PacketUtils;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Module {
   public NoFall() {
      super("ft.sleep.module.modules.NoFall", new String[]{"ft.sleep.module.modules.NoFall"}, ModuleType.Player);
   }

   @EventHandler
   public void _empire(EventPreUpdate var1) {
      if (!bonifoza.mc.thePlayer.isSpectator() && !bonifoza.mc.thePlayer.capabilities.allowFlying && !bonifoza.mc.thePlayer.capabilities.disableDamage) {
         if ((double)bonifoza.mc.thePlayer.fallDistance - bonifoza.mc.thePlayer.motionY > 3.0D && bonifoza._rural()) {
            PacketUtils._payroll(new C03PacketPlayer(true));
            bonifoza.mc.thePlayer.fallDistance = Float.intBitsToFloat(0);
         }

      }
   }

   public boolean _rural() {
      if (megutuva.mc.thePlayer.posY < Double.longBitsToDouble(0L)) {
         return false;
      } else {
         for(Object arudimen = 0; arudimen < (int)megutuva.mc.thePlayer.posY + 2; arudimen += 2) {
            Object ronopafa = megutuva.mc.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-arudimen), Double.longBitsToDouble(0L));
            if (!megutuva.mc.theWorld.getCollidingBoundingBoxes(megutuva.mc.thePlayer, ronopafa).isEmpty()) {
               return true;
            }
         }

         return false;
      }
   }
}
