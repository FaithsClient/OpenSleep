//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.inventory;

import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class SlotUtil {
   public static Minecraft margaret$ = Minecraft.getMinecraft();
   public static List dallas$ = Arrays.asList(Blocks.enchanting_table, Blocks.chest, Blocks.ender_chest, Blocks.trapped_chest, Blocks.anvil, Blocks.sand, Blocks.web, Blocks.torch, Blocks.crafting_table, Blocks.furnace, Blocks.waterlily, Blocks.dispenser, Blocks.stone_pressure_plate, Blocks.wooden_pressure_plate, Blocks.noteblock, Blocks.dropper, Blocks.tnt, Blocks.standing_banner, Blocks.wall_banner, Blocks.redstone_torch);
   public List comic$ = Arrays.asList(Blocks.enchanting_table, Blocks.chest, Blocks.ender_chest, Blocks.trapped_chest, Blocks.anvil, Blocks.crafting_table, Blocks.furnace, Blocks.dispenser, Blocks.iron_door, Blocks.oak_door, Blocks.noteblock, Blocks.dropper);

   public int _reject() {
      for(Object ranger = 36; ranger < 45; ++ranger) {
         Object material = margaret$.thePlayer.inventoryContainer.getSlot(ranger).getStack();
         if (material != null && material.getItem() instanceof ItemBlock && material.stackSize > 0) {
            Object anger = ((ItemBlock)material.getItem()).getBlock();
            if ((anger.isFullBlock() || anger instanceof BlockGlass || anger instanceof BlockStainedGlass || anger instanceof BlockTNT) && !dallas$.contains(anger)) {
               return ranger - 36;
            }
         }
      }

      return -1;
   }

   public int _fence() {
      Object sized = -1;
      Object morning = -1.0F;
      Object resist = -1;

      for(Object wheels = 0; wheels < 9; ++wheels) {
         Object regard = margaret$.thePlayer.inventory.getStackInSlot(wheels);
         if (regard != null && regard.getItem() instanceof ItemSword) {
            Object weather = (ItemSword)regard.getItem();
            Object hiking = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, regard);
            Object pushed = weather.getDamageVsEntity() + (float)hiking * 1.25F;
            Object cabinets = weather.getMaxDamage();
            if (morning < pushed) {
               morning = pushed;
               sized = cabinets;
               resist = wheels;
            }

            if (pushed == morning && cabinets > sized) {
               sized = cabinets;
               resist = wheels;
            }
         }
      }

      return resist;
   }

   public int _patches(Item rirafafi) {
      for(Object udoyigut = 0; udoyigut < 9; ++udoyigut) {
         Object cavezibi = margaret$.thePlayer.inventory.getStackInSlot(udoyigut);
         if (cavezibi == null) {
            if (rirafafi == null) {
               return udoyigut;
            }
         } else if (cavezibi.getItem() == rirafafi) {
            return udoyigut;
         }
      }

      return -1;
   }

   public int _gospel(Block ozevivop) {
      for(Object figozefo = 0; figozefo < 9; ++figozefo) {
         Object edeyabar = margaret$.thePlayer.inventory.getStackInSlot(figozefo);
         if (edeyabar == null) {
            if (ozevivop == null) {
               return figozefo;
            }
         } else if (edeyabar.getItem() instanceof ItemBlock && ((ItemBlock)edeyabar.getItem()).getBlock() == ozevivop) {
            return figozefo;
         }
      }

      return -1;
   }

   public int _defines(BlockPos sources) {
      Object counsel = 1.0F;
      Object granted = -1;
      Object nodes = margaret$.theWorld.getBlockState((BlockPos)sources);

      for(Object streets = 0; streets < 9; ++streets) {
         Object webcam = margaret$.thePlayer.inventory.getStackInSlot(streets);
         if (webcam != null) {
            Object debut = webcam.getStrVsBlock(nodes.getBlock());
            if (debut > counsel) {
               counsel = debut;
               granted = streets;
            }
         }
      }

      return granted;
   }

   public static ItemStack _stating(int batuyivu) {
      return batuyivu < 9 && batuyivu >= 0 ? margaret$.thePlayer.inventory.mainInventory[batuyivu] : null;
   }

   public static float _dragon(Block movulosu, int gecogova) {
      Object nasicofi = 1.0F;
      if (margaret$.thePlayer.inventory.mainInventory[gecogova] != null) {
         nasicofi *= margaret$.thePlayer.inventory.mainInventory[gecogova].getStrVsBlock((Block)movulosu);
      }

      return nasicofi;
   }

   public static float _doing(EntityPlayer onatigil, World bisitole, BlockPos fatovesu, int anatadot) {
      Object vadaruzo = margaret$.theWorld.getBlockState((BlockPos)fatovesu).getBlock();
      float var5 = vadaruzo.getBlockHardness((World)bisitole, (BlockPos)fatovesu);
      return var5 < Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : (!_parish(vadaruzo, (int)anatadot) ? _emphasis(vadaruzo, (int)anatadot) / var5 / 100.0F : _emphasis(vadaruzo, (int)anatadot) / var5 / 30.0F);
   }

   public static boolean _parish(Block dragon, int itunes) {
      if (((Block)dragon).getMaterial().isToolNotRequired()) {
         return true;
      } else {
         Object lands = margaret$.thePlayer.inventory.getStackInSlot((int)itunes);
         return lands != null && lands.canHarvestBlock((Block)dragon);
      }
   }

   public static float _emphasis(Block pavilion, int avoid) {
      Object thomson = _dragon((Block)pavilion, (int)avoid);
      if (thomson > 1.0F) {
         Object express = EnchantmentHelper.getEfficiencyModifier(margaret$.thePlayer);
         Object clause = _stating((int)avoid);
         if (express > 0 && clause != null) {
            thomson += (float)(express * express + 1);
         }
      }

      if (margaret$.thePlayer.isPotionActive(Potion.digSpeed)) {
         thomson *= 1.0F + (float)(margaret$.thePlayer.getActivePotionEffect(Potion.digSpeed).getAmplifier() + 1) * 0.2F;
      }

      if (margaret$.thePlayer.isPotionActive(Potion.digSlowdown)) {
         float var5;
         switch(margaret$.thePlayer.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) {
         case 0:
            var5 = 0.3F;
            break;
         case 1:
            var5 = 0.09F;
            break;
         case 2:
            var5 = 0.0027F;
            break;
         case 3:
         default:
            var5 = 8.1E-4F;
         }

         thomson *= var5;
      }

      if (margaret$.thePlayer.isInsideOfMaterial(Material.water) && !EnchantmentHelper.getAquaAffinityModifier(margaret$.thePlayer)) {
         thomson /= 5.0F;
      }

      if (!margaret$.thePlayer.onGround) {
         thomson /= 5.0F;
      }

      return thomson;
   }
}
