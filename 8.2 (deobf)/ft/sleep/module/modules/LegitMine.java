//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventTick;
import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;

public class LegitMine extends Module {
   public Numbers asylum$ = new Numbers("Ticks", 2.0D, Double.longBitsToDouble(0L), 9.0D, 1.0D);
   public Numbers chrome$ = new Numbers("Break Delay", Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 5.0D, 1.0D);
   public Numbers course$ = new Numbers("Block Break", 0.3D, 0.1D, 0.9D, 0.05D);
   public Numbers graphic$ = new Numbers("Mine ft.sleep.module.modules.Speed", 1.0D, 1.0D, 1.6D, 0.05D);

   public LegitMine() {
      super("Legit Mine", new String[]{"ft.sleep.module.modules.LegitMine"}, ModuleType.updates$);
   }

   @EventHandler
   public void _lighting(EventTick var1) {
      if (ziziveso.mc.thePlayer.ticksExisted % ziziveso.asylum$.getValue().intValue() == 0) {
         ziziveso.mc.playerController.blockHitDelay = ziziveso.mc.playerController.blockHitDelay > ziziveso.chrome$.getValue().intValue() ? ziziveso.chrome$.getValue().intValue() : ziziveso.mc.playerController.blockHitDelay;
         if (ziziveso.mc.playerController.curBlockDamageMP * ziziveso.graphic$.getValue().floatValue() > 1.0F - ziziveso.course$.getValue().floatValue()) {
            ziziveso.mc.playerController.curBlockDamageMP = 1.0F;
         }
      }

   }
}
