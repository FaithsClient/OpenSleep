//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Mode;
import java.awt.Color;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.module.modules.KillAura;
import ft.sleep.module.modules.Speed;
import ft.sleep.util.player.MoveUtils;
import ft.sleep.util.timer.MSTimer;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Criticals extends Module {
   public Mode injured$ = new Mode("Mode", new String[]{"Visual", "Watchdog"}, "Visual");
   public boolean appendix$ = false;
   public MSTimer keeping$ = new MSTimer();

   public Criticals() {
      super("ft.sleep.module.modules.Criticals", new String[]{"crits", "crit"}, ModuleType.updates$);
      vector._piece((new Color(235, 194, 138)).getRGB());
   }

   public void _regime() {
      super._regime();
      audit.keeping$._access();
   }

   public void _discs() {
      enacipaf.keeping$._access();
   }

   @EventHandler
   public void _poems(EventPacketSend fidevepa) {
      Object zemabade = EventPacketSend.packet;
      if (Objects.equals(cagebiva.injured$.getValue(), "Watchdog") && cagebiva.appendix$) {
         if (zemabade instanceof C03PacketPlayer) {
            C03PacketPlayer var3 = (C03PacketPlayer)EventPacketSend.getPacket();
            var3.onGround = false;
         }

         cagebiva.appendix$ = false;
      }

   }

   @EventHandler
   public void _teaches(EventPreUpdate var1) {
      brought._infants(Objects.equals(brought.injured$.getValue(), "Watchdog") ? "Watchdog 8" : brought.injured$.getValue());
      if (brought.mc.thePlayer.ridingEntity == null && !brought.mc.thePlayer.isInWeb && !brought.mc.thePlayer.isInLava() && !brought.mc.thePlayer.isInWater() && !brought.mc.thePlayer.isOnLadder()) {
         if (Objects.equals(brought.injured$.getValue(), "Watchdog")) {
            Client.î ?();
            Client.î ?();
            if (ModuleManager._herbs(KillAura.class)._central() && MoveUtils._archives(0.001D)) {
               Client.î ?();
               Client.î ?();
               if (!ModuleManager._herbs(Speed.class)._central() && KillAura.lesbians$ != null) {
                  brought.appendix$ = true;
               }
            }
         }

      }
   }
}
