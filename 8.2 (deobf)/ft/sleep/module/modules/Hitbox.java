package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import net.minecraft.entity.Entity;

public class Hitbox extends Module {
   public static Numbers checking$ = new Numbers("Extra Blocks", 0.25D, 0.05D, 1.0D, 0.05D);

   public Hitbox() {
      super("Hitboxes", new String[]{"ft.sleep.module.modules.Hitbox"}, ModuleType.Combat);
   }

   @EventHandler
   public void _centres(EventPreUpdate var1) {
   }

   public static float _measures(Entity force) {
      Object being = (Hitbox)ModuleManager._herbs(Hitbox.class);
      Object anthony = (KillAura) ModuleManager._herbs(KillAura.class);
      return being._central() && anthony._desire((Entity)force) ? checking$.getValue().floatValue() : Float.intBitsToFloat(0);
   }
}
