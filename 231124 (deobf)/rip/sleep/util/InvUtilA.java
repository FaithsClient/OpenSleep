package rip.sleep.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class InvUtilA {
   private static Minecraft c54758 = Minecraft.getMinecraft();
   public static int c1047 = 37;
   public static int c27810 = 38;
   public static int c38428 = 39;

   public static int c36263() {
      Value.c27574();
      int var1 = 0;
      if (var1 < 8) {
         if (c54758.thePlayer.inventory.mainInventory[var1] == null) {
            return var1;
         }

         ++var1;
      }

      return c54758.thePlayer.inventory.currentItem + (c54758.thePlayer.inventory.getCurrentItem() == null ? 0 : (c54758.thePlayer.inventory.currentItem < 8 ? 4 : -1));
   }

   public static int c22021(int var0) {
      return c54758.thePlayer.inventory.mainInventory[var0] == null ? var0 : c36263();
   }

   public static void c75207(int var0) {
      c54758.playerController.windowClick(c54758.thePlayer.inventoryContainer.windowId, var0, 0, 1, c54758.thePlayer);
   }

   public static void c28939(int var0, int var1) {
      c54758.playerController.windowClick(c54758.thePlayer.inventoryContainer.windowId, var0, var1, 2, c54758.thePlayer);
   }

   public static boolean c44635() {
      Module[] var0 = Value.c27574();
      return !Arrays.asList(c54758.thePlayer.inventory.mainInventory).contains((Object)null);
   }

   public static int c13829(int var0) {
      return 8 - var0;
   }

   public static void c62201() {
      c54758.playerController.sendUseItem(c54758.thePlayer, c54758.theWorld, c54758.thePlayer.inventory.getCurrentItem());
   }

   public static ItemStack c62075() {
      Module[] var0 = Value.c27574();
      return c54758.thePlayer.getCurrentEquippedItem() == null ? new ItemStack(Blocks.air) : c54758.thePlayer.getCurrentEquippedItem();
   }

   public static ItemStack c54670(int var0) {
      Module[] var1 = Value.c27574();
      return c54758.thePlayer.inventory.mainInventory[var0] == null ? new ItemStack(Blocks.air) : c54758.thePlayer.inventory.mainInventory[var0];
   }

   public static List<ItemStack> c88041() {
      ArrayList var0 = new ArrayList();
      var0.addAll(Arrays.asList(c54758.thePlayer.inventory.mainInventory).subList(0, 9));
      return var0;
   }

   public static List<ItemStack> c55620() {
      ArrayList var1 = new ArrayList();
      var1.addAll(Arrays.asList(c54758.thePlayer.inventory.mainInventory).subList(0, 35));
      Value.c27574();
      int var2 = 0;
      if (var2 < 4) {
         var1.add(c54758.thePlayer.inventory.armorItemInSlot(var2));
         ++var2;
      }

      return var1;
   }

   public static List<ItemStack> c14421() {
      ArrayList var0 = new ArrayList();
      var0.addAll(Arrays.asList(c54758.thePlayer.inventory.mainInventory).subList(9, 35));
      return var0;
   }

   public static int c88181() {
      Value.c27574();
      int var1 = 0;
      if (var1 < 9) {
         if (c54758.thePlayer.inventory.mainInventory[var1] == null) {
            return var1;
         }

         ++var1;
      }

      return -1;
   }

   public static float c73090(ItemStack var0) {
      Module[] var1 = Value.c27574();
      if (var0 != null && var0.getItem() instanceof ItemArmor) {
         ItemArmor var2 = (ItemArmor)var0.getItem();
         float var3 = 0.0F;
         var3 = var3 + (float)var2.damageReduceAmount;
         if (EnchantmentHelper.getEnchantments(var0).size() <= 0) {
            var3 = (float)((double)var3 - 0.1D);
         }

         int var4 = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, var0);
         var3 = (float)((double)var3 + (double)var4 * 0.2D);
         return var3;
      } else {
         return -1.0F;
      }
   }

   public static boolean c52148() {
      Module[] var0 = Value.c27574();
      if (c54758.thePlayer.inventory.getCurrentItem() != null) {
         return false;
      } else {
         return c54758.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemAxe || c54758.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemSword;
      }
   }

   public static boolean c97178() {
      Module[] var0 = Value.c27574();
      return c54758.thePlayer.getHeldItem() != null && c54758.thePlayer.getHeldItem().getItem() instanceof ItemSword;
   }

   public static void c25306() {
      Value.c27574();
      int var1 = 9;
      if (var1 < 45) {
         if (c54758.thePlayer.inventoryContainer.getSlot(var1).getHasStack()) {
            ItemStack var2 = c54758.thePlayer.inventoryContainer.getSlot(var1).getStack();
            if (c6967(var2) && c1047 != var1 && !c73375(var2)) {
               if (!c54758.thePlayer.inventoryContainer.getSlot(c1047).getHasStack()) {
                  c28939(var1, c1047 - 36);
               }

               if (!c6967(c54758.thePlayer.inventoryContainer.getSlot(c1047).getStack())) {
                  c28939(var1, c1047 - 36);
               }
            }
         }

         ++var1;
      }

   }

   public static void c69671() {
      Value.c27574();
      int var1 = 9;
      if (var1 < 45) {
         if (c54758.thePlayer.inventoryContainer.getSlot(var1).getHasStack()) {
            ItemStack var2 = c54758.thePlayer.inventoryContainer.getSlot(var1).getStack();
            if (c75078(var2) && c38428 != var1 && !c73375(var2)) {
               if (!c54758.thePlayer.inventoryContainer.getSlot(c38428).getHasStack()) {
                  c28939(var1, c38428 - 36);
               }

               if (!c75078(c54758.thePlayer.inventoryContainer.getSlot(c38428).getStack())) {
                  c28939(var1, c38428 - 36);
               }
            }
         }

         ++var1;
      }

   }

   public static void c81066() {
      Value.c27574();
      int var1 = 9;
      if (var1 < 45) {
         if (c54758.thePlayer.inventoryContainer.getSlot(var1).getHasStack()) {
            ItemStack var2 = c54758.thePlayer.inventoryContainer.getSlot(var1).getStack();
            if (c16475(var2) && c27810 != var1 && !c73375(var2)) {
               if (!c54758.thePlayer.inventoryContainer.getSlot(c27810).getHasStack()) {
                  c28939(var1, c27810 - 36);
               }

               if (!c16475(c54758.thePlayer.inventoryContainer.getSlot(c27810).getStack())) {
                  c28939(var1, c27810 - 36);
               }
            }
         }

         ++var1;
      }

   }

   public static boolean c6967(ItemStack var0) {
      Value.c27574();
      Item var2 = var0.getItem();
      if (!(var2 instanceof ItemPickaxe)) {
         return false;
      } else {
         float var3 = c67779(var0);
         int var4 = 9;
         if (var4 < 45) {
            if (c54758.thePlayer.inventoryContainer.getSlot(var4).getHasStack()) {
               ItemStack var5 = c54758.thePlayer.inventoryContainer.getSlot(var4).getStack();
               if (c67779(var5) > var3 && var5.getItem() instanceof ItemPickaxe) {
                  return false;
               }
            }

            ++var4;
         }

         return true;
      }
   }

   public static boolean c75078(ItemStack var0) {
      Value.c27574();
      Item var2 = var0.getItem();
      if (!(var2 instanceof ItemSpade)) {
         return false;
      } else {
         float var3 = c67779(var0);
         int var4 = 9;
         if (var4 < 45) {
            if (c54758.thePlayer.inventoryContainer.getSlot(var4).getHasStack()) {
               ItemStack var5 = c54758.thePlayer.inventoryContainer.getSlot(var4).getStack();
               if (c67779(var5) > var3 && var5.getItem() instanceof ItemSpade) {
                  return false;
               }
            }

            ++var4;
         }

         return true;
      }
   }

   public static boolean c16475(ItemStack var0) {
      Value.c27574();
      Item var2 = var0.getItem();
      if (!(var2 instanceof ItemAxe)) {
         return false;
      } else {
         float var3 = c67779(var0);
         int var4 = 9;
         if (var4 < 45) {
            if (c54758.thePlayer.inventoryContainer.getSlot(var4).getHasStack()) {
               ItemStack var5 = c54758.thePlayer.inventoryContainer.getSlot(var4).getStack();
               if (c67779(var5) > var3 && var5.getItem() instanceof ItemAxe && !c73375(var0)) {
                  return false;
               }
            }

            ++var4;
         }

         return true;
      }
   }

   public static float c67779(ItemStack var0) {
      Value.c27574();
      Item var2 = var0.getItem();
      if (!(var2 instanceof ItemTool)) {
         return 0.0F;
      } else {
         float var6;
         label36: {
            String var3 = var2.getUnlocalizedName();
            ItemTool var4 = (ItemTool)var2;
            var6 = 1.0F;
            if (var2 instanceof ItemPickaxe) {
               var6 = var4.getStrVsBlock(var0, Blocks.stone);
               if (!var3.toLowerCase().contains("gold")) {
                  break label36;
               }

               var6 = var6 - 5.0F;
            }

            if (var2 instanceof ItemSpade) {
               var6 = var4.getStrVsBlock(var0, Blocks.dirt);
               if (!var3.toLowerCase().contains("gold")) {
                  break label36;
               }

               var6 = var6 - 5.0F;
            }

            if (!(var2 instanceof ItemAxe)) {
               return 1.0F;
            }

            var6 = var4.getStrVsBlock(var0, Blocks.log);
            if (var3.toLowerCase().contains("gold")) {
               var6 = var6 - 5.0F;
               return 1.0F;
            }
         }

         var6 = (float)((double)var6 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var0) * 0.0075D);
         var6 = (float)((double)var6 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var0) / 100.0D);
         return var6;
      }
   }

   public static boolean c73375(ItemStack var0) {
      Value.c27574();
      float var2 = c40050(var0);
      int var3 = 9;
      if (var3 < 45) {
         if (c54758.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = c54758.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (c40050(var4) > var2 && var4.getItem() instanceof ItemSword) {
               return false;
            }
         }

         ++var3;
      }

      return var0.getItem() instanceof ItemSword;
   }

   public static float c40050(ItemStack var0) {
      Value.c27574();
      float var2 = 0.0F;
      Item var3 = var0.getItem();
      if (var3 instanceof ItemTool) {
         ItemTool var4 = (ItemTool)var3;
         var2 += (float)var4.func_77612_l();
      }

      if (var3 instanceof ItemSword) {
         ItemSword var6 = (ItemSword)var3;
         var2 += var6.getDamageVsEntity();
      }

      var2 = var2 + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, var0) * 1.25F + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var0) * 0.01F;
      return var2;
   }

   public static boolean c12899(Item var0) {
      Module[] var1 = Value.c27574();
      return var0 == null || Item.getIdFromItem(var0) == 0;
   }

   public static int c61307(ItemStack var0, Enchantment var1) {
      Module[] var2 = Value.c27574();
      if (var0 != null && var0.getEnchantmentTagList() != null && !var0.getEnchantmentTagList().hasNoTags()) {
         int var3 = 0;
         if (var3 < var0.getEnchantmentTagList().tagCount()) {
            NBTTagCompound var4 = var0.getEnchantmentTagList().getCompoundTagAt(var3);
            if (var4.hasKey("ench") && var4.getShort("ench") == var1.effectId || var4.hasKey("id") && var4.getShort("id") == var1.effectId) {
               return var4.getShort("lvl");
            }

            ++var3;
         }

         return 0;
      } else {
         return 0;
      }
   }

   private static JSONException c53366(JSONException var0) {
      return var0;
   }
}
