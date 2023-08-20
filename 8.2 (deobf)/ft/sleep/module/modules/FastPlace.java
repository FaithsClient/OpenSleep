//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventTick;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemSnowball;

public class FastPlace extends Module {
   public Numbers smith$ = new Numbers("Place Ticks", 1.0D, Double.longBitsToDouble(0L), 4.0D, 1.0D);
   public Option studio$ = new Option("Blocks", true);
   public Option content$ = new Option("Projectiles", true);

   public FastPlace() {
      super("ft.sleep.module.modules.FastPlace", new String[]{"fPlace", "fc", "fp"}, ModuleType.Player);
      veyubunu._piece((new Color(226, 197, 78)).getRGB());
   }

   public boolean _appeal() {
      if (product.mc.thePlayer != null && product.mc.thePlayer.getCurrentEquippedItem() != null && product.mc.thePlayer.getCurrentEquippedItem().getItem() != null) {
         Object gained = product.mc.thePlayer.getCurrentEquippedItem().getItem();
         return product.studio$.getValue().booleanValue() && gained instanceof ItemBlock || product.content$.getValue().booleanValue() && (gained instanceof ItemSnowball || gained instanceof ItemEgg);
      } else {
         return false;
      }
   }

   @EventHandler
   public void _depends(EventTick var1) {
      if (utovomen._appeal()) {
         utovomen.mc.rightClickDelayTimer = Math.min(utovomen.mc.rightClickDelayTimer, utovomen.smith$.getValue().intValue());
      }

   }
}
