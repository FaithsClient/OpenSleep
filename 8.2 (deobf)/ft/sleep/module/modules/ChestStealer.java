//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventTick;
import ft.sleep.api.value.Numbers;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.timer.MSTimer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;

public class ChestStealer extends Module {
   public Numbers faculty$ = new Numbers("Delay", 80.0D, Double.longBitsToDouble(0L), 1000.0D, 10.0D);
   public MSTimer casual$ = new MSTimer();

   public ChestStealer() {
      super("ft.sleep.module.modules.ChestStealer", new String[]{"cheststeal", "chests", "stealer"}, ModuleType.Player);
      carey._piece((new Color(218, 97, 127)).getRGB());
   }

   @EventHandler
   public void _economy(EventTick unuyirep) {
      if (zodugafa.mc.thePlayer != null && zodugafa.mc.thePlayer.openContainer != null && zodugafa.mc.thePlayer.openContainer instanceof ContainerChest) {
         Object esumimic = (ContainerChest)zodugafa.mc.thePlayer.openContainer;
         if (!StatCollector.translateToLocal("container.chest").equalsIgnoreCase(esumimic.getLowerChestInventory().getDisplayName().getUnformattedText()) && !StatCollector.translateToLocal("container.chestDouble").equalsIgnoreCase(esumimic.getLowerChestInventory().getDisplayName().getUnformattedText()) && !StatCollector.translateToLocal("container.chest").equalsIgnoreCase("LOW")) {
            return;
         }

         for(int var3 = 0; var3 < esumimic.getLowerChestInventory().getSizeInventory(); ++var3) {
            if (esumimic.getLowerChestInventory().getStackInSlot(var3) != null && zodugafa.casual$._nitrogen(zodugafa.faculty$.getValue().longValue()) && (!(esumimic.getLowerChestInventory().getStackInSlot(var3).getItem() instanceof ItemArmor) || zodugafa._issues(esumimic, esumimic.getLowerChestInventory().getStackInSlot(var3), var3)) && (!(esumimic.getLowerChestInventory().getStackInSlot(var3).getItem() instanceof ItemSword) || (double)zodugafa._visit(esumimic.getLowerChestInventory().getStackInSlot(var3)) >= zodugafa._wrist(esumimic, var3))) {
               zodugafa.mc.playerController.windowClick(esumimic.windowId, var3, 0, 1, zodugafa.mc.thePlayer);
               zodugafa.mc.playerController.windowClick(esumimic.windowId, var3, 1, 1, zodugafa.mc.thePlayer);
               zodugafa.casual$._access();
            }
         }

         if (zodugafa._villa()) {
            zodugafa.mc.thePlayer.closeScreen();
         }
      }

   }

   public boolean _villa() {
      if (iluradun.mc.thePlayer.openContainer != null && iluradun.mc.thePlayer.openContainer instanceof ContainerChest) {
         Object udadalav = (ContainerChest)iluradun.mc.thePlayer.openContainer;

         for(Object orenovuy = 0; orenovuy < udadalav.getLowerChestInventory().getSizeInventory(); ++orenovuy) {
            Object pabutazo = udadalav.getLowerChestInventory().getStackInSlot(orenovuy);
            if (pabutazo != null && pabutazo.getItem() != null && (!(pabutazo.getItem() instanceof ItemArmor) || iluradun._issues(udadalav, pabutazo, orenovuy)) && (!(pabutazo.getItem() instanceof ItemSword) || (double)iluradun._visit(pabutazo) >= iluradun._wrist(udadalav, orenovuy))) {
               return false;
            }
         }
      }

      return true;
   }

   public boolean _issues(ContainerChest ucemapur, ItemStack yozuzizu, int everucon) {
      Object ofanagul = (double)((ItemArmor)((ItemStack)yozuzizu).getItem()).damageReduceAmount + egugayez._macro((ItemStack)yozuzizu);
      Object tayitupo = Double.longBitsToDouble(0L);
      int var8 = 0;
      if (((ItemStack)yozuzizu).getUnlocalizedName().contains("helmet")) {
         for(int var9 = 0; var9 < 45; ++var9) {
            if (egugayez.mc.thePlayer.inventoryContainer.getSlot(var9).getHasStack() && egugayez.mc.thePlayer.inventoryContainer.getSlot(var9).getStack().getItem().getUnlocalizedName().contains("helmet")) {
               double var10 = (double)((ItemArmor)egugayez.mc.thePlayer.inventoryContainer.getSlot(var9).getStack().getItem()).damageReduceAmount + egugayez._macro(egugayez.mc.thePlayer.inventoryContainer.getSlot(var9).getStack());
               if (var10 > tayitupo) {
                  tayitupo = var10;
                  var8 = var9;
               }
            }
         }

         for(int var12 = 0; var12 < ((ContainerChest)ucemapur).getLowerChestInventory().getSizeInventory(); ++var12) {
            if (((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var12) != null && ((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var12).getUnlocalizedName().contains("helmet")) {
               double var19 = (double)((ItemArmor)((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var12).getItem()).damageReduceAmount + egugayez._macro(((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var12));
               if (var19 > tayitupo) {
                  tayitupo = var19;
                  var8 = var12;
               }
            }
         }
      }

      if (((ItemStack)yozuzizu).getUnlocalizedName().contains("chestplate")) {
         for(int var13 = 0; var13 < 45; ++var13) {
            if (egugayez.mc.thePlayer.inventoryContainer.getSlot(var13).getHasStack() && egugayez.mc.thePlayer.inventoryContainer.getSlot(var13).getStack().getItem().getUnlocalizedName().contains("chestplate")) {
               double var20 = (double)((ItemArmor)egugayez.mc.thePlayer.inventoryContainer.getSlot(var13).getStack().getItem()).damageReduceAmount + egugayez._macro(egugayez.mc.thePlayer.inventoryContainer.getSlot(var13).getStack());
               if (var20 > tayitupo) {
                  tayitupo = var20;
                  var8 = var13;
               }
            }
         }

         for(int var14 = 0; var14 < ((ContainerChest)ucemapur).getLowerChestInventory().getSizeInventory(); ++var14) {
            if (((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var14) != null && ((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var14).getUnlocalizedName().contains("chestplate")) {
               double var21 = (double)((ItemArmor)((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var14).getItem()).damageReduceAmount + egugayez._macro(((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var14));
               if (var21 > tayitupo) {
                  tayitupo = var21;
                  var8 = var14;
               }
            }
         }
      }

      if (((ItemStack)yozuzizu).getUnlocalizedName().contains("leggings")) {
         for(int var15 = 0; var15 < 45; ++var15) {
            if (egugayez.mc.thePlayer.inventoryContainer.getSlot(var15).getHasStack() && egugayez.mc.thePlayer.inventoryContainer.getSlot(var15).getStack().getItem().getUnlocalizedName().contains("leggings")) {
               double var22 = (double)((ItemArmor)egugayez.mc.thePlayer.inventoryContainer.getSlot(var15).getStack().getItem()).damageReduceAmount + egugayez._macro(egugayez.mc.thePlayer.inventoryContainer.getSlot(var15).getStack());
               if (var22 > tayitupo) {
                  tayitupo = var22;
                  var8 = var15;
               }
            }
         }

         for(int var16 = 0; var16 < ((ContainerChest)ucemapur).getLowerChestInventory().getSizeInventory(); ++var16) {
            if (((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var16) != null && ((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var16).getUnlocalizedName().contains("leggings")) {
               double var23 = (double)((ItemArmor)((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var16).getItem()).damageReduceAmount + egugayez._macro(((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var16));
               if (var23 > tayitupo) {
                  tayitupo = var23;
                  var8 = var16;
               }
            }
         }
      }

      if (((ItemStack)yozuzizu).getUnlocalizedName().contains("boots")) {
         for(int var17 = 0; var17 < 45; ++var17) {
            if (egugayez.mc.thePlayer.inventoryContainer.getSlot(var17).getHasStack() && egugayez.mc.thePlayer.inventoryContainer.getSlot(var17).getStack().getItem().getUnlocalizedName().contains("boots")) {
               double var24 = (double)((ItemArmor)egugayez.mc.thePlayer.inventoryContainer.getSlot(var17).getStack().getItem()).damageReduceAmount + egugayez._macro(egugayez.mc.thePlayer.inventoryContainer.getSlot(var17).getStack());
               if (var24 > tayitupo) {
                  tayitupo = var24;
                  var8 = var17;
               }
            }
         }

         for(int var18 = 0; var18 < ((ContainerChest)ucemapur).getLowerChestInventory().getSizeInventory(); ++var18) {
            if (((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var18) != null && ((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var18).getUnlocalizedName().contains("boots")) {
               double var25 = (double)((ItemArmor)((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var18).getItem()).damageReduceAmount + egugayez._macro(((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var18));
               if (var25 > tayitupo) {
                  tayitupo = var25;
                  var8 = var18;
               }
            }
         }
      }

      return ofanagul >= tayitupo && ((ContainerChest)ucemapur).getLowerChestInventory().getStackInSlot(var8) == yozuzizu;
   }

   public double _macro(ItemStack forward) {
      return ((ItemStack)forward).getItem() instanceof ItemArmor ? (double)((ItemArmor)((ItemStack)forward).getItem()).damageReduceAmount + (double)((100 - ((ItemArmor)((ItemStack)forward).getItem()).damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, (ItemStack)forward)) * 0.0075D : Double.longBitsToDouble(0L);
   }

   public double _wrist(ContainerChest unonelus, int usogubim) {
      Object aloyayor = Double.longBitsToDouble(0L);

      for(Object fedasure = 0; fedasure < 45; ++fedasure) {
         if (befiniyi.mc.thePlayer.inventoryContainer.getSlot(fedasure).getHasStack()) {
            ItemStack var6 = befiniyi.mc.thePlayer.inventoryContainer.getSlot(fedasure).getStack();
            if (var6.getItem() instanceof ItemSword && (double)befiniyi._visit(var6) > aloyayor) {
               aloyayor = (double)befiniyi._visit(var6);
            }
         }
      }

      for(Object var7 = 0; var7 < ((ContainerChest)unonelus).getLowerChestInventory().getSizeInventory(); ++var7) {
         if (((ContainerChest)unonelus).getLowerChestInventory().getStackInSlot(var7) != null) {
            ItemStack var8 = ((ContainerChest)unonelus).getLowerChestInventory().getStackInSlot(var7);
            if (var7 != usogubim && var8.getItem() instanceof ItemSword && (double)befiniyi._visit(var8) > aloyayor) {
               aloyayor = (double)befiniyi._visit(var8);
            }
         }
      }

      return aloyayor;
   }

   public float _visit(ItemStack orabider) {
      Object puziguye = Float.intBitsToFloat(0);
      Object initorip = ((ItemStack)orabider).getItem();
      if (initorip instanceof ItemTool) {
         puziguye += curovipi._begins((ItemStack)orabider);
      }

      if (initorip instanceof ItemSword) {
         puziguye += curovipi._dinner((ItemStack)orabider);
      } else {
         ++puziguye;
      }

      return puziguye;
   }

   public float _dinner(ItemStack ezurugiz) {
      Object etaredid = ((ItemSword)((ItemStack)ezurugiz).getItem()).getDamageVsEntity();
      etaredid = etaredid + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)ezurugiz) * 1.25F;
      etaredid = etaredid + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)ezurugiz) * 0.01F;
      return etaredid;
   }

   public float _begins(ItemStack lamps) {
      return ((ItemTool)((ItemStack)lamps).getItem()).getToolMaterial().getEfficiencyOnProperMaterial();
   }
}
