//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.timer.TimerUtil;
import net.minecraft.item.ItemSkull;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.potion.Potion;

public class AutoHead extends Module {
   public Numbers cookie$ = new Numbers("Delay", Integer.valueOf(750), Integer.valueOf(0), Integer.valueOf(3000), Integer.valueOf(50));
   public Numbers babes$ = new Numbers("Health %", Integer.valueOf(50), Integer.valueOf(1), Integer.valueOf(99), Integer.valueOf(1));
   public TimerUtil opens$ = new TimerUtil();

   public AutoHead() {
      super("Auto Head", new String[]{"ft.sleep.module.modules.AutoHead"}, ModuleType.updates$);
   }

   @EventHandler
   public void _right(EventPreUpdate oboyutol) {
      if (!ServerUtils._comedy() && lifefori.mc.thePlayer != null && lifefori.mc.theWorld != null && (!lifefori.mc.thePlayer.isPotionActive(Potion.moveSpeed) || !lifefori.mc.thePlayer.isPotionActive(Potion.regeneration)) && lifefori.mc.thePlayer.getHealth() / lifefori.mc.thePlayer.getMaxHealth() * 100.0F <= lifefori.babes$.getValue().floatValue() && lifefori.opens$._refined(lifefori.cookie$.getValue().longValue())) {
         for(Object mavudugi = 0; mavudugi < 45; ++mavudugi) {
            Object vigegofi = lifefori.mc.thePlayer.inventoryContainer.getSlot(mavudugi).getStack();
            if (vigegofi != null && vigegofi.getItem() instanceof ItemSkull && vigegofi.getDisplayName().contains("Head")) {
               int var4 = lifefori.mc.thePlayer.inventory.currentItem;
               if (mavudugi - 36 < 0) {
                  lifefori.mc.playerController.windowClick(lifefori.mc.thePlayer.inventoryContainer.windowId, mavudugi, 8, 2, lifefori.mc.thePlayer);
                  PacketUtils._gratis(new C09PacketHeldItemChange(8));
               } else {
                  PacketUtils._gratis(new C09PacketHeldItemChange(mavudugi - 36));
               }

               PacketUtils._gratis(new C08PacketPlayerBlockPlacement(vigegofi));
               lifefori.mc.thePlayer.inventory.currentItem = var4;
               PacketUtils._gratis(new C09PacketHeldItemChange(var4));
               lifefori.opens$._display();
            }
         }
      }

   }
}
