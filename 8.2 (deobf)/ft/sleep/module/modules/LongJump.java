//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.injection.interfaces.IEntityPlayerSP;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.MoveUtil;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class LongJump extends Module {
   public Numbers drives$ = new Numbers("Height", Integer.valueOf(1), 0.42D, Integer.valueOf(9), 0.1D);
   public Numbers intel$ = new Numbers("ft.sleep.module.modules.Speed", Integer.valueOf(1), 0.1D, Integer.valueOf(3), 0.1D);
   public int booth$;
   public double bytes$ = Double.longBitsToDouble(0L);
   public float simple$;
   public boolean handmade$ = false;

   public LongJump() {
      super("ft.sleep.module.modules.LongJump", new String[]{"ft.sleep.module.modules.LongJump"}, ModuleType.Movement);
   }

   public void _regime() {
      america.booth$ = 0;
   }

   @EventHandler
   public void _analyzed(EventPreUpdate diego) {
      if (whether.mc.thePlayer.hurtTime == 9) {
         whether.simple$ = whether.mc.thePlayer.rotationYaw;
         whether.mc.thePlayer.motionY = (double)whether.drives$.getValue().floatValue() - ((double)whether.drives$.getValue().floatValue() > 0.45D ? Math.random() / 1000.0D : Double.longBitsToDouble(0L));
         whether.bytes$ = (double)whether.intel$.getValue().floatValue() - Math.random() / 1000.0D;
      }

      if (whether.mc.thePlayer.ticksExisted <= 10) {
         MoveUtil._buried(whether.bytes$, whether.simple$);
         whether.bytes$ -= whether.bytes$ / 269.9D + Math.random() / 100.0D;
      }

      Object brief = whether._receptor(Items.fire_charge);
      if (((IEntityPlayerSP)whether.mc.thePlayer).getOnGroundTicks() == 1.0D) {
         MoveUtil._apparent();
      }

      if (brief != -1) {
         ++whether.booth$;
         whether._receiver(brief);
         if (whether.booth$ == 2) {
            KeyBinding.setKeyBindState(whether.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
         } else {
            KeyBinding.setKeyBindState(whether.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
         }

         ((EventPreUpdate)diego).setYaw(whether.mc.thePlayer.rotationYaw);
         ((EventPreUpdate)diego).setPitch(90.0F);
      }
   }

   public void _receiver(int lending) {
      if (lending >= 0 && lending <= 8) {
         giants.mc.thePlayer.inventory.currentItem = (int)lending;
         giants.mc.thePlayer.inventory.inventoryChanged = true;
      }
   }

   public int _receptor(Item jumping) {
      for(Object joining = 0; joining < 9; ++joining) {
         Object watches = groups.mc.thePlayer.inventory.getStackInSlot(joining);
         if (watches == null) {
            if (jumping == null) {
               return joining;
            }
         } else if (watches.getItem() == jumping) {
            return joining;
         }
      }

      return -1;
   }
}
