//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.MovementUtils;
import net.minecraft.block.material.Material;

public class FluidMove extends Module {
   public static Option venue$ = new Option("Cancel Water", false);
   public static Option fluid$ = new Option("Cancel Lava", false);
   public static Numbers dairy$ = new Numbers("Custom ft.sleep.module.modules.Speed", 0.15D, Double.longBitsToDouble(0L), 0.3D, 0.01D);
   public boolean katie$ = false;

   public FluidMove() {
      super("ft.sleep.module.modules.FluidMove", new String[]{"ft.sleep.module.modules.FluidMove"}, ModuleType.Movement);
   }

   public boolean _interval() {
      return !tender.mc.gameSettings.keyBindJump.isKeyDown();
   }

   @EventHandler
   public void _times(EventPreUpdate var1) {
      if (sectors.mc.thePlayer.worldObj.handleMaterialAcceleration(sectors.mc.thePlayer.getEntityBoundingBox().expand(Double.longBitsToDouble(0L), -0.4000000059604645D, Double.longBitsToDouble(0L)).contract(0.001D, 0.001D, 0.001D), Material.water, sectors.mc.thePlayer) && sectors._interval()) {
         MovementUtils._parallel(dairy$.getValue().floatValue());
      }

   }
}
