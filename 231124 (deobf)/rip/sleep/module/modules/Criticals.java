package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Objects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtil;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;

public class Criticals extends Module {
   private final ModeValue c787 = new ModeValue("Mode", new String[]{"Visual", "Watchdog"}, "Visual");
   public int c5211;

   public Criticals() {
      super("Criticals", new String[]{"crits", "crit"}, ModuleType.c13050, ModuleType.c21190.c47958);
      this.c36162((new Color(235, 194, 138)).getRGB());
   }

   public void c83205() {
      super.c83205();
      this.c5211 = 0;
   }

   public void c71897() {
   }

   @EventTarget
   private void c10213(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      Packet var3 = PacketSendEvent.c26827;
      if (Objects.equals(this.c787.c54460(), "Watchdog")) {
         if (!mc.thePlayer.onGround) {
            this.c5211 = 0;
         }

         if (mc.thePlayer.onGround && PlayerUtil.c30408(0.001D) && !mc.gameSettings.keyBindJump.isKeyDown()) {
            Sleep.getInstance();
            Sleep.c33759();
            if (ModuleManager.c25475(KillAura.class).c24622()) {
               Sleep.getInstance();
               Sleep.c33759();
               if (!ModuleManager.c25475(Speed.class).c24622() && PacketSendEvent.c81894() instanceof C03PacketPlayer) {
                  C03PacketPlayer var4 = (C03PacketPlayer) PacketSendEvent.c81894();
                  if (KillAura.c19685 != null) {
                     ++this.c5211;
                     if (this.c5211 == 1) {
                        var4.onGround = false;
                     }

                     this.c5211 = 0;
                     return;
                  }
               }
            }
         }
      }

   }

   public boolean c82907() {
      Module[] var1 = Value.c27574();
      boolean var10000;
      if (this.c24622()) {
         Sleep.getInstance();
         Sleep.c33759();
         if (ModuleManager.c25475(KillAura.class).c24622() && KillAura.c79073() != null && !PlayerUtilG.c13194() && mc.thePlayer.onGround && !PlayerUtilG.c15741() && !PlayerUtilG.c81970() && !mc.thePlayer.movementInput.jump) {
            var10000 = true;
            return var10000;
         }
      }

      var10000 = false;
      return var10000;
   }

   @EventTarget
   private void c73835(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      this.c2159(Objects.equals(this.c787.c54460(), "Watchdog") ? "Hypixel" : this.c787.c54460());
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
