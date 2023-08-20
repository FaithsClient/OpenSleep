//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.inventory;

import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class InventoryUtils {
   public static List gloves$ = Arrays.asList(Blocks.enchanting_table, Blocks.chest, Blocks.ender_chest, Blocks.trapped_chest, Blocks.anvil, Blocks.sand, Blocks.web, Blocks.torch, Blocks.crafting_table, Blocks.furnace, Blocks.waterlily, Blocks.dispenser, Blocks.stone_pressure_plate, Blocks.wooden_pressure_plate, Blocks.noteblock, Blocks.dropper, Blocks.tnt, Blocks.standing_banner, Blocks.wall_banner, Blocks.redstone_torch, Blocks.gravel, Blocks.cactus, Blocks.bed, Blocks.lever, Blocks.standing_sign, Blocks.wall_sign, Blocks.jukebox, Blocks.oak_fence, Blocks.spruce_fence, Blocks.birch_fence, Blocks.jungle_fence, Blocks.dark_oak_fence, Blocks.oak_fence_gate, Blocks.spruce_fence_gate, Blocks.birch_fence_gate, Blocks.jungle_fence_gate, Blocks.dark_oak_fence_gate, Blocks.nether_brick_fence, Blocks.trapdoor, Blocks.melon_block, Blocks.brewing_stand, Blocks.cauldron, Blocks.skull, Blocks.hopper, Blocks.carpet, Blocks.redstone_wire, Blocks.light_weighted_pressure_plate, Blocks.heavy_weighted_pressure_plate, Blocks.daylight_detector);
   public static Minecraft lodge$ = Minecraft.getMinecraft();

   public static int _losing(int olesepus, int ovesodof, Item econozof) {
      for(Object ecimigon = (int)olesepus; ecimigon < ovesodof; ++ecimigon) {
         Object isolalon = Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(ecimigon).getStack();
         if (isolalon != null && isolalon.getItem() == econozof) {
            return ecimigon;
         }
      }

      return -1;
   }

   public static boolean _centre() {
      for(Object ezenotat = 36; ezenotat < 45; ++ezenotat) {
         Object eyeyobef = Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(ezenotat).getStack();
         if (eyeyobef == null) {
            return true;
         }
      }

      return false;
   }

   public static int _renew() {
      for(Object larefiyo = 36; larefiyo < 45; ++larefiyo) {
         Object ripedefe = Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(larefiyo).getStack();
         if (ripedefe != null && ripedefe.getItem() instanceof ItemBlock && ripedefe.stackSize > 0) {
            Object amoyebef = (ItemBlock)ripedefe.getItem();
            Object dipimogi = amoyebef.getBlock();
            if (dipimogi.isFullCube() && !gloves$.contains(dipimogi)) {
               return larefiyo;
            }
         }
      }

      return -1;
   }

   public static float _snapshot(ItemStack eticamen) {
      if (((ItemStack)eticamen).getItem() instanceof ItemSword) {
         Object tirivigi = (ItemSword)((ItemStack)eticamen).getItem();
         Object uvoyusat = (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)eticamen) * 1.25F;
         Object lasifaci = (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)eticamen) * 1.5F;
         return tirivigi.getDamageVsEntity() + uvoyusat + lasifaci;
      } else {
         return Float.intBitsToFloat(0);
      }
   }

   public static void _prepare(int olegedin) {
      lodge$.playerController.windowClick(0, (int)olegedin, 1, 4, lodge$.thePlayer);
   }

   public static void _charm(int efirifiy, int cufobucu) {
      lodge$.playerController.windowClick(lodge$.thePlayer.inventoryContainer.windowId, (int)efirifiy, (int)cufobucu, 2, lodge$.thePlayer);
   }

   public static void _dealtime(int redocibi, int lutedova, boolean ufipabuy) {
      lodge$.playerController.windowClick(lodge$.thePlayer.inventoryContainer.windowId, (int)redocibi, (int)lutedova, ufipabuy ? 1 : 0, lodge$.thePlayer);
   }
}
