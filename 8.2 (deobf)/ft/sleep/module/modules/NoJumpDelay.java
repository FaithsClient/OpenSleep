package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;

public class NoJumpDelay extends Module {
   public static Numbers cycling$ = new Numbers("Min Delay", Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 10.0D, 1.0D);

   public NoJumpDelay() {
      super("No JumpDelay", new String[]{"ft.sleep.module.modules.NoJumpDelay", "ft.sleep.module.modules.NoJumpDelay"}, ModuleType.Combat);
   }

   @EventHandler
   public void _belle(EventPreUpdate var1) {
      chrysler._infants("" + cycling$.getValue().intValue());
   }
}
