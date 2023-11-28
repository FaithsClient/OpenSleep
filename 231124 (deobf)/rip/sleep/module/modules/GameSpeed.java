package rip.sleep.module.modules;

import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.util.MathUtilB;
import rip.sleep.event.EventTarget;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.values.NumberValue;

import java.awt.Color;

public final class GameSpeed extends Module {
   private final NumberValue c31840 = new NumberValue("Max Timer", Integer.valueOf(1), 0.1D, Integer.valueOf(10), 0.05D);
   private final NumberValue c91415 = new NumberValue("Min Timer", Integer.valueOf(1), 0.1D, Integer.valueOf(10), 0.05D);

   public GameSpeed() {
      super("Game Speed", new String[]{"timer"}, ModuleType.c62580, ModuleType.c21190.c88511);
      this.c36162((new Color(158, 205, 125)).getRGB());
   }

   public void c71897() {
      mc.timer.timerSpeed = 1.0F;
      super.c71897();
   }

   @EventTarget
   public void c11027(MotionUpdateEvent var1) {
      mc.timer.timerSpeed = (float) MathUtilB.c95323((double)this.c31840.c53968().floatValue(), (double)this.c91415.c53968().floatValue());
   }
}
