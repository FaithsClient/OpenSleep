//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.PlayerUtils;
import ft.sleep.util.scaffold.ServerUtils;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;

public class LightningTrack extends Module {
   public LightningTrack() {
      super("Lightning Track", new String[]{"Lightning Track"}, ModuleType.Combat);
   }

   @EventHandler
   public void _belize(EventPacketReceive zufezezo) {
      if (!ServerUtils._comedy() && EventPacketReceive.getPacket() instanceof S2CPacketSpawnGlobalEntity) {
         Object aneguvet = (S2CPacketSpawnGlobalEntity)EventPacketReceive.getPacket();
         Object nuseceye = (int)((float)Math.round((double)aneguvet.func_149051_d() / 32.0D * 100.0D) / 100.0F);
         Object efatayud = (int)((float)Math.round((double)aneguvet.func_149050_e() / 32.0D * 100.0D) / 100.0F);
         int var5 = (int)((float)Math.round((double)aneguvet.func_149049_f() / 32.0D * 100.0D) / 100.0F);
         if (aneguvet.func_149053_g() == 1) {
            PlayerUtils._snake("Lightning struck at " + nuseceye + ", " + efatayud + ", " + var5 + " (" + (int)livuyivi.mc.thePlayer.getDistance((double)nuseceye, (double)efatayud, (double)var5) + " blocks away)");
         }
      }

   }
}
