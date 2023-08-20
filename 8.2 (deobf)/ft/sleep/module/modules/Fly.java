//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.PlayerUtil;

public class Fly extends Module {
   public Numbers accused$ = new Numbers("Motion ft.sleep.module.modules.Speed", 15.0D, Double.longBitsToDouble(0L), 20.0D, 0.5D);

   public Fly() {
      super("ft.sleep.module.modules.Fly", new String[0], ModuleType.Movement);
   }

   public void _regime() {
      super._regime();
   }

   public void _discs() {
      super._discs();
      PlayerUtil._opera(Double.longBitsToDouble(0L));
      doyoyuya.mc.thePlayer.motionY = Double.longBitsToDouble(0L);
   }

   @EventHandler
   public void _switched(EventPreUpdate var1) {
      if (idereyel.mc.gameSettings.keyBindJump.isKeyDown()) {
         idereyel.mc.thePlayer.motionY = 2.0D;
      } else if (idereyel.mc.gameSettings.keyBindSneak.isKeyDown()) {
         idereyel.mc.thePlayer.motionY = -2.0D;
      } else {
         idereyel.mc.thePlayer.motionY = Double.longBitsToDouble(0L);
      }

      PlayerUtil._opera(PlayerUtil._democrat() * idereyel.accused$.getValue().doubleValue());
   }
}
