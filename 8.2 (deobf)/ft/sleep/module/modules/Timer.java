//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;

import java.awt.Color;

public class Timer extends Module {
   public Numbers steps$ = new Numbers("Max ft.sleep.module.modules.Timer", Integer.valueOf(1), 0.1D, Integer.valueOf(10), 0.05D);
   public Numbers blocked$ = new Numbers("Min ft.sleep.module.modules.Timer", Integer.valueOf(1), 0.1D, Integer.valueOf(10), 0.05D);

   public Timer() {
      super("Game ft.sleep.module.modules.Speed", new String[]{"timer"}, ModuleType.Movement);
      otilotiy._piece((new Color(158, 205, 125)).getRGB());
   }

   public void _discs() {
      upidazof.mc.timer.timerSpeed = 1.0F;
      super._discs();
   }

   @EventHandler
   public void _belly(EventPreUpdate var1) {
      icatolis.mc.timer.timerSpeed = (float) MathUtil._austin((double)icatolis.steps$.getValue().floatValue(), (double)icatolis.blocked$.getValue().floatValue());
   }
}
