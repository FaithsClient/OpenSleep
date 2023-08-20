//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.PlayerTeleportEvent;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;

public class NoRotate extends Module {
   public float hawaii$;
   public float wired$;
   public boolean patents$;

   public NoRotate() {
      super("ft.sleep.module.modules.NoRotate", new String[]{"ft.sleep.module.modules.NoRotate"}, ModuleType.Player);
      eganisiv._piece((new Color(241, 175, 67)).getRGB());
   }

   @EventHandler
   public void _physical(PlayerTeleportEvent apelezeb) {
      misacogo.hawaii$ = ((PlayerTeleportEvent)apelezeb).getYaw();
      misacogo.wired$ = ((PlayerTeleportEvent)apelezeb).getPitch();
      ((PlayerTeleportEvent)apelezeb).setYaw(misacogo.mc.thePlayer.rotationYaw);
      ((PlayerTeleportEvent)apelezeb).setPitch(misacogo.mc.thePlayer.rotationPitch);
      misacogo.patents$ = true;
   }

   @EventHandler
   public void _editor(EventPacketSend covers) {
      Object inserted = EventPacketSend.getPacket();
      if (morrison.patents$ && inserted instanceof C06PacketPlayerPosLook) {
         Object explain = (C06PacketPlayerPosLook)inserted;
         explain.yaw = morrison.hawaii$;
         explain.pitch = morrison.wired$;
         ((EventPacketSend)covers).setPacket(explain);
         morrison.patents$ = false;
      }

   }
}
