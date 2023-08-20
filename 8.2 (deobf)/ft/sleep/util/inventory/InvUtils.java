//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ft.sleep.module.modules.Scaffold;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public class InvUtils {
   public static Minecraft realm$ = Minecraft.getMinecraft();
   public static int signup$ = 37;
   public static int creature$ = 38;
   public static int listings$ = 39;

   public static int _susan() {
      for(Object ebooks = 0; ebooks < 8; ++ebooks) {
         if (realm$.thePlayer.inventory.mainInventory[ebooks] == null) {
            return ebooks;
         }
      }

      return realm$.thePlayer.inventory.currentItem + (realm$.thePlayer.inventory.getCurrentItem() == null ? 0 : (realm$.thePlayer.inventory.currentItem < 8 ? 4 : -1));
   }

   public static int _taxation(int grande) {
      // $FF: Couldn't be decompiled
   }

   public static void _music(int partly) {
      realm$.playerController.windowClick(realm$.thePlayer.inventoryContainer.windowId, (int)partly, 0, 1, realm$.thePlayer);
   }

   public static void _daisy(int uyifisov, int otacorel) {
      realm$.playerController.windowClick(realm$.thePlayer.inventoryContainer.windowId, (int)uyifisov, (int)otacorel, 2, realm$.thePlayer);
   }

   public static boolean _trustee() {
      return !Arrays.asList(realm$.thePlayer.inventory.mainInventory).contains((Object)null);
   }

   public static int _tension(int agafamuc) {
      return 8 - agafamuc;
   }

   public static void _congress() {
      realm$.playerController.sendUseItem(realm$.thePlayer, realm$.theWorld, realm$.thePlayer.inventory.getCurrentItem());
   }

   public static ItemStack _realized() {
      return realm$.thePlayer.getCurrentEquippedItem() == null ? new ItemStack(Blocks.air) : realm$.thePlayer.getCurrentEquippedItem();
   }

   public static ItemStack _accurate(int tickets) {
      return realm$.thePlayer.inventory.mainInventory[tickets] == null ? new ItemStack(Blocks.air) : realm$.thePlayer.inventory.mainInventory[tickets];
   }

   public static List _envelope() {
      Object ogisefid = new ArrayList();
      ogisefid.addAll(Arrays.asList(realm$.thePlayer.inventory.mainInventory).subList(0, 9));
      return ogisefid;
   }

   public static List _permits() {
      Object adaptor = new ArrayList();
      adaptor.addAll(Arrays.asList(realm$.thePlayer.inventory.mainInventory).subList(0, 35));

      for(Object intel = 0; intel < 4; ++intel) {
         adaptor.add(realm$.thePlayer.inventory.armorItemInSlot(intel));
      }

      return adaptor;
   }

   public static List _scheme() {
      Object adinevil = new ArrayList();
      adinevil.addAll(Arrays.asList(realm$.thePlayer.inventory.mainInventory).subList(9, 35));
      return adinevil;
   }

   public static int _trustees() {
      for(Object senator = 0; senator < 9; ++senator) {
         if (realm$.thePlayer.inventory.mainInventory[senator] == null) {
            return senator;
         }
      }

      return -1;
   }

   public static float _dream(ItemStack believed) {
      if (believed != null && ((ItemStack)believed).getItem() instanceof ItemArmor) {
         Object managers = (ItemArmor)((ItemStack)believed).getItem();
         Object tunes = Float.intBitsToFloat(0);
         tunes = tunes + (float)managers.damageReduceAmount;
         if (EnchantmentHelper.getEnchantments((ItemStack)believed).size() <= 0) {
            tunes = (float)((double)tunes - 0.1D);
         }

         Object wilson = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, (ItemStack)believed);
         tunes = (float)((double)tunes + (double)wilson * 0.2D);
         return tunes;
      } else {
         return -1.0F;
      }
   }

   public static boolean _appears() {
      if (realm$.thePlayer.inventory.getCurrentItem() != null) {
         return false;
      } else {
         return realm$.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemAxe || realm$.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemSword;
      }
   }

   public static boolean _height() {
      return realm$.thePlayer.getHeldItem() != null && realm$.thePlayer.getHeldItem().getItem() instanceof ItemSword;
   }

   public static void _fabrics() {
      for(Object ebibudog = 9; ebibudog < 45; ++ebibudog) {
         if (realm$.thePlayer.inventoryContainer.getSlot(ebibudog).getHasStack()) {
            Object zazalemi = realm$.thePlayer.inventoryContainer.getSlot(ebibudog).getStack();
            if (_george(zazalemi) && signup$ != ebibudog && !_helps(zazalemi)) {
               if (!realm$.thePlayer.inventoryContainer.getSlot(signup$).getHasStack()) {
                  _daisy(ebibudog, signup$ - 36);
               } else if (!_george(realm$.thePlayer.inventoryContainer.getSlot(signup$).getStack())) {
                  _daisy(ebibudog, signup$ - 36);
               }
            }
         }
      }

   }

   public static void _oliver() {
      for(Object zalocegi = 9; zalocegi < 45; ++zalocegi) {
         if (realm$.thePlayer.inventoryContainer.getSlot(zalocegi).getHasStack()) {
            Object yavicugo = realm$.thePlayer.inventoryContainer.getSlot(zalocegi).getStack();
            if (_starting(yavicugo) && listings$ != zalocegi && !_helps(yavicugo)) {
               if (!realm$.thePlayer.inventoryContainer.getSlot(listings$).getHasStack()) {
                  _daisy(zalocegi, listings$ - 36);
               } else if (!_starting(realm$.thePlayer.inventoryContainer.getSlot(listings$).getStack())) {
                  _daisy(zalocegi, listings$ - 36);
               }
            }
         }
      }

   }

   public static void _sunny() {
      for(Object vazunavo = 9; vazunavo < 45; ++vazunavo) {
         if (realm$.thePlayer.inventoryContainer.getSlot(vazunavo).getHasStack()) {
            Object agugifaz = realm$.thePlayer.inventoryContainer.getSlot(vazunavo).getStack();
            if (_annex(agugifaz) && creature$ != vazunavo && !_helps(agugifaz)) {
               if (!realm$.thePlayer.inventoryContainer.getSlot(creature$).getHasStack()) {
                  _daisy(vazunavo, creature$ - 36);
               } else if (!_annex(realm$.thePlayer.inventoryContainer.getSlot(creature$).getStack())) {
                  _daisy(vazunavo, creature$ - 36);
               }
            }
         }
      }

   }

   public static boolean _george(ItemStack ipazarib) {
      Object debinecu = ((ItemStack)ipazarib).getItem();
      if (!(debinecu instanceof ItemPickaxe)) {
         return false;
      } else {
         Object iyironap = _anxiety((ItemStack)ipazarib);

         for(Object ucerulog = 9; ucerulog < 45; ++ucerulog) {
            if (realm$.thePlayer.inventoryContainer.getSlot(ucerulog).getHasStack()) {
               Object ozegotat = realm$.thePlayer.inventoryContainer.getSlot(ucerulog).getStack();
               if (_anxiety(ozegotat) > iyironap && ozegotat.getItem() instanceof ItemPickaxe) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public static boolean _starting(ItemStack ometomub) {
      Object oroyezat = ((ItemStack)ometomub).getItem();
      if (!(oroyezat instanceof ItemSpade)) {
         return false;
      } else {
         Object sevavulu = _anxiety((ItemStack)ometomub);

         for(Object ufabufed = 9; ufabufed < 45; ++ufabufed) {
            if (realm$.thePlayer.inventoryContainer.getSlot(ufabufed).getHasStack()) {
               Object avilubob = realm$.thePlayer.inventoryContainer.getSlot(ufabufed).getStack();
               if (_anxiety(avilubob) > sevavulu && avilubob.getItem() instanceof ItemSpade) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public static boolean _annex(ItemStack tsunami) {
      Object bobby = ((ItemStack)tsunami).getItem();
      if (!(bobby instanceof ItemAxe)) {
         return false;
      } else {
         Object auditor = _anxiety((ItemStack)tsunami);

         for(Object serves = 9; serves < 45; ++serves) {
            if (realm$.thePlayer.inventoryContainer.getSlot(serves).getHasStack()) {
               Object wiley = realm$.thePlayer.inventoryContainer.getSlot(serves).getStack();
               if (_anxiety(wiley) > auditor && wiley.getItem() instanceof ItemAxe && !_helps((ItemStack)tsunami)) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public static float _anxiety(ItemStack chapter) {
      Object herbal = ((ItemStack)chapter).getItem();
      if (!(herbal instanceof ItemTool)) {
         return Float.intBitsToFloat(0);
      } else {
         Object visible = herbal.getUnlocalizedName();
         Object julia = (ItemTool)herbal;
         Object sending = 1.0F;
         if (herbal instanceof ItemPickaxe) {
            sending = julia.getStrVsBlock((ItemStack)chapter, Blocks.stone);
            if (visible.toLowerCase().contains("gold")) {
               sending -= 5.0F;
            }
         } else if (herbal instanceof ItemSpade) {
            sending = julia.getStrVsBlock((ItemStack)chapter, Blocks.dirt);
            if (visible.toLowerCase().contains("gold")) {
               sending -= 5.0F;
            }
         } else {
            if (!(herbal instanceof ItemAxe)) {
               return 1.0F;
            }

            sending = julia.getStrVsBlock((ItemStack)chapter, Blocks.log);
            if (visible.toLowerCase().contains("gold")) {
               sending -= 5.0F;
            }
         }

         sending = (float)((double)sending + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, (ItemStack)chapter) * 0.0075D);
         sending = (float)((double)sending + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)chapter) / 100.0D);
         return sending;
      }
   }

   public static boolean _helps(ItemStack thong) {
      Object royalty = _martial((ItemStack)thong);

      for(Object faster = 9; faster < 45; ++faster) {
         if (realm$.thePlayer.inventoryContainer.getSlot(faster).getHasStack()) {
            Object bicycle = realm$.thePlayer.inventoryContainer.getSlot(faster).getStack();
            if (_martial(bicycle) > royalty && bicycle.getItem() instanceof ItemSword) {
               return false;
            }
         }
      }

      if (((ItemStack)thong).getItem() instanceof ItemSword) {
         return true;
      } else {
         return false;
      }
   }

   public static float _martial(ItemStack adavidam) {
      Object dufelonu = Float.intBitsToFloat(0);
      Object ibasedon = ((ItemStack)adavidam).getItem();
      if (ibasedon instanceof ItemTool) {
         Object ozoradaf = (ItemTool)ibasedon;
         dufelonu += (float)ozoradaf.getMaxDamage();
      }

      if (ibasedon instanceof ItemSword) {
         Object var5 = (ItemSword)ibasedon;
         dufelonu += var5.getDamageVsEntity();
      }

      dufelonu = dufelonu + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)adavidam) * 1.25F + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)adavidam) * 0.01F;
      return dufelonu;
   }

   public static boolean _velocity(Item banarere) {
      return banarere == null || Item.getIdFromItem((Item)banarere) == 0;
   }

   public static int _careers() {
      for(Object uvodetey = 36; uvodetey < 45; ++uvodetey) {
         Object ipetafuv = realm$.thePlayer.inventoryContainer.getSlot(uvodetey).getStack();
         if (ipetafuv != null && ipetafuv.getItem() instanceof ItemBlock && ipetafuv.stackSize > 0) {
            Object atubelin = (ItemBlock)ipetafuv.getItem();
            Object agezemir = atubelin.getBlock();
            if (agezemir.isFullCube() && !Scaffold.football$.contains(agezemir)) {
               return uvodetey;
            }
         }
      }

      for(Object var4 = 36; var4 < 45; ++var4) {
         Object var5 = realm$.thePlayer.inventoryContainer.getSlot(var4).getStack();
         if (var5 != null && var5.getItem() instanceof ItemBlock && var5.stackSize > 0) {
            Object var6 = (ItemBlock)var5.getItem();
            Object var7 = var6.getBlock();
            if (!Scaffold.football$.contains(var7)) {
               return var4;
            }
         }
      }

      return -1;
   }

   public static int _sorted(ItemStack iyapolad, Enchantment iyosoter) {
      if (iyapolad != null && ((ItemStack)iyapolad).getEnchantmentTagList() != null && !((ItemStack)iyapolad).getEnchantmentTagList().hasNoTags()) {
         for(Object nobuneco = 0; nobuneco < ((ItemStack)iyapolad).getEnchantmentTagList().tagCount(); ++nobuneco) {
            Object yesasibo = ((ItemStack)iyapolad).getEnchantmentTagList().getCompoundTagAt(nobuneco);
            if (yesasibo.hasKey("ench") && yesasibo.getShort("ench") == ((Enchantment)iyosoter).effectId || yesasibo.hasKey("id") && yesasibo.getShort("id") == ((Enchantment)iyosoter).effectId) {
               return yesasibo.getShort("lvl");
            }
         }

         return 0;
      } else {
         return 0;
      }
   }
}
