//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.timer.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C16PacketClientStatus.EnumState;

public class AutoArmor extends Module {
   public Mode where$ = new Mode("Mode", new String[]{"FakeInv", "OpenInv", "Basic"}, "FakeInv");
   public TimerUtil european$ = new TimerUtil();
   public Numbers property$ = new Numbers("Delay", 1.0D, Double.longBitsToDouble(0L), 10.0D, 1.0D);

   public AutoArmor() {
      super("ft.sleep.module.modules.AutoArmor", new String[]{"ft.sleep.module.modules.AutoArmor"}, ModuleType.Player);
      super._bosnia(true);
   }

   @EventHandler
   public void _medal(EventPreUpdate umabomoy) {
      uyecamob._infants(uyecamob.where$.getValue());
      long var2 = uyecamob.property$.getValue().longValue() * ((long)1226681257 ^ 1226681243L);
      if (!Objects.equals(uyecamob.where$.getValue(), "OpenInv") || uyecamob.mc.currentScreen instanceof GuiInventory) {
         if ((uyecamob.mc.currentScreen == null || uyecamob.mc.currentScreen instanceof GuiInventory || uyecamob.mc.currentScreen instanceof GuiChat) && uyecamob.european$._refined(var2)) {
            uyecamob._align();
         }

      }
   }

   public void _align() {
      for(Object penucita = 1; penucita < 5; ++penucita) {
         if (bititoci.mc.thePlayer.inventoryContainer.getSlot(4 + penucita).getHasStack()) {
            Object unufedap = bititoci.mc.thePlayer.inventoryContainer.getSlot(4 + penucita).getStack();
            if (_tunnel(unufedap, penucita)) {
               continue;
            }

            if (Objects.equals(bititoci.where$.getValue(), "FakeInv")) {
               Object abivagam = new C16PacketClientStatus(EnumState.OPEN_INVENTORY_ACHIEVEMENT);
               PacketUtils._gratis(abivagam);
            }

            bititoci._reminder(4 + penucita);
         }

         for(Object var6 = 9; var6 < 45; ++var6) {
            if (bititoci.mc.thePlayer.inventoryContainer.getSlot(var6).getHasStack()) {
               Object var7 = bititoci.mc;
               Object eponasad = bititoci.mc.thePlayer.inventoryContainer.getSlot(var6).getStack();
               if (_tunnel(eponasad, penucita) && _tables(eponasad) > Float.intBitsToFloat(0)) {
                  if (Objects.equals(bititoci.where$.getValue(), "FakeInv")) {
                     Object ovugusen = new C16PacketClientStatus(EnumState.OPEN_INVENTORY_ACHIEVEMENT);
                     PacketUtils._gratis(ovugusen);
                  }

                  bititoci._ranges(var6);
                  if (Objects.equals(bititoci.where$.getValue(), "FakeInv")) {
                     PacketUtils._gratis(new C0DPacketCloseWindow(0));
                  }

                  bititoci.european$._display();
                  if (bititoci.property$.getValue().longValue() > ((long)212771711 ^ 212771711L)) {
                     return;
                  }
               }
            }
         }
      }

   }

   public static boolean _tunnel(ItemStack enable, int federal) {
      Object bufing = _tables((ItemStack)enable);
      Object suppose = "";
      if (federal == 1) {
         suppose = "helmet";
      } else if (federal == 2) {
         suppose = "chestplate";
      } else if (federal == 3) {
         suppose = "leggings";
      } else if (federal == 4) {
         suppose = "boots";
      }

      if (!((ItemStack)enable).getUnlocalizedName().contains(suppose)) {
         return false;
      } else {
         for(Object apart = 5; apart < 45; ++apart) {
            if (Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(apart).getHasStack()) {
               Object wound = Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(apart).getStack();
               if (_tables(wound) > bufing && wound.getUnlocalizedName().contains(suppose)) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public void _ranges(int fully) {
      Object checked = breach.mc.playerController;
      Object against = breach.mc.thePlayer.inventoryContainer.windowId;
      boolean var4 = false;
      boolean var5 = true;
      checked.windowClick(against, (int)fully, 0, 1, breach.mc.thePlayer);
   }

   public void _reminder(int igubutog) {
      Object gifilaba = idufoyet.mc.playerController;
      Object yedopaco = idufoyet.mc.thePlayer.inventoryContainer.windowId;
      boolean var4 = true;
      boolean var5 = true;
      gifilaba.windowClick(yedopaco, (int)igubutog, 1, 4, idufoyet.mc.thePlayer);
   }

   public static float _tables(ItemStack bapebano) {
      Object arigirid = Float.intBitsToFloat(0);
      if (((ItemStack)bapebano).getItem() instanceof ItemArmor) {
         Object yarifodu = (ItemArmor)((ItemStack)bapebano).getItem();
         arigirid = (float)((double)arigirid + (double)yarifodu.damageReduceAmount + (double)((100 - yarifodu.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, (ItemStack)bapebano)) * 0.0075D);
         arigirid = (float)((double)arigirid + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, (ItemStack)bapebano) / 100.0D);
         arigirid = (float)((double)arigirid + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, (ItemStack)bapebano) / 100.0D);
         arigirid = (float)((double)arigirid + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, (ItemStack)bapebano) / 100.0D);
         arigirid = (float)((double)arigirid + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)bapebano) / 50.0D);
         arigirid = (float)((double)arigirid + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.featherFalling.effectId, (ItemStack)bapebano) / 100.0D);
      }

      return arigirid;
   }
}
