package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.StartUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.TimerUtilG;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public class ChestStealer extends Module {
   private final NumberValue<Number> c1768 = new NumberValue<Number>("Delay", 80.0D, 0.0D, 1000.0D, 10.0D);
   private final TimerUtilG c32297 = new TimerUtilG();

   public ChestStealer() {
      super("Chest Stealer", new String[]{"cheststeal", "ChestStealer", "stealer"}, ModuleType.c31770, ModuleType.c21190.c76367);
      this.c36162((new Color(218, 97, 127)).getRGB());
   }

   @EventTarget
   private void c71217(StartUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer != null && mc.thePlayer.openContainer != null && mc.thePlayer.openContainer instanceof ContainerChest) {
         ContainerChest var3 = (ContainerChest) mc.thePlayer.openContainer;
         if (!StatCollector.translateToLocal("container.chest").equalsIgnoreCase(var3.getLowerChestInventory().func_145748_c_().getUnformattedText()) && !StatCollector.translateToLocal("container.chestDouble").equalsIgnoreCase(var3.getLowerChestInventory().func_145748_c_().getUnformattedText()) && !StatCollector.translateToLocal("container.chest").equalsIgnoreCase("LOW")) {
            return;
         }

         int var4 = 0;
         if (var4 < var3.getLowerChestInventory().getSizeInventory()) {
            if (var3.getLowerChestInventory().getStackInSlot(var4) != null && this.c32297.c13770(this.c1768.c53968().longValue()) && (!(var3.getLowerChestInventory().getStackInSlot(var4).getItem() instanceof ItemArmor) || this.c90254(var3, var3.getLowerChestInventory().getStackInSlot(var4), var4)) && (!(var3.getLowerChestInventory().getStackInSlot(var4).getItem() instanceof ItemSword) || (double)this.c19874(var3.getLowerChestInventory().getStackInSlot(var4)) >= this.c58918(var3, var4))) {
               mc.playerController.windowClick(var3.field_75152_c, var4, 0, 1, mc.thePlayer);
               mc.playerController.windowClick(var3.field_75152_c, var4, 1, 1, mc.thePlayer);
               this.c32297.c43667();
            }

            ++var4;
         }

         if (this.isEmpty()) {
            mc.thePlayer.closeScreen();
         }
      }

   }

   private boolean isEmpty() {
      Module[] var1 = Value.c27574();
      if (mc.thePlayer.openContainer != null && mc.thePlayer.openContainer instanceof ContainerChest) {
         ContainerChest var2 = (ContainerChest) mc.thePlayer.openContainer;
         int var3 = 0;
         if (var3 < var2.getLowerChestInventory().getSizeInventory()) {
            ItemStack var4 = var2.getLowerChestInventory().getStackInSlot(var3);
            if (var4.getItem() != null && (!(var4.getItem() instanceof ItemArmor) || this.c90254(var2, var4, var3)) && (!(var4.getItem() instanceof ItemSword) || (double)this.c19874(var4) >= this.c58918(var2, var3))) {
               return false;
            }

            ++var3;
         }
      }

      return true;
   }

   private boolean c90254(ContainerChest var1, ItemStack var2, int var3) {
      double var5 = (double)((ItemArmor)var2.getItem()).damageReduceAmount + this.c35895(var2);
      Value.c27574();
      double var7 = 0.0D;
      int var9 = 0;
      if (var2.getUnlocalizedName().contains("helmet")) {
         int var10 = 0;
         if (var10 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var10).getHasStack() && mc.thePlayer.inventoryContainer.getSlot(var10).getStack().getItem().getUnlocalizedName().contains("helmet")) {
               double var11 = (double)((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(var10).getStack().getItem()).damageReduceAmount + this.c35895(mc.thePlayer.inventoryContainer.getSlot(var10).getStack());
               if (var11 > var7) {
                  var7 = var11;
                  var9 = var10;
               }
            }

            ++var10;
         }

         var10 = 0;
         if (var10 < var1.getLowerChestInventory().getSizeInventory()) {
            if (var1.getLowerChestInventory().getStackInSlot(var10) != null && var1.getLowerChestInventory().getStackInSlot(var10).getUnlocalizedName().contains("helmet")) {
               double var28 = (double)((ItemArmor)var1.getLowerChestInventory().getStackInSlot(var10).getItem()).damageReduceAmount + this.c35895(var1.getLowerChestInventory().getStackInSlot(var10));
               if (var28 > var7) {
                  var7 = var28;
                  var9 = var10;
               }
            }

            ++var10;
         }
      }

      if (var2.getUnlocalizedName().contains("chestplate")) {
         int var16 = 0;
         if (var16 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var16).getHasStack() && mc.thePlayer.inventoryContainer.getSlot(var16).getStack().getItem().getUnlocalizedName().contains("chestplate")) {
               double var29 = (double)((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(var16).getStack().getItem()).damageReduceAmount + this.c35895(mc.thePlayer.inventoryContainer.getSlot(var16).getStack());
               if (var29 > var7) {
                  var7 = var29;
                  var9 = var16;
               }
            }

            ++var16;
         }

         var16 = 0;
         if (var16 < var1.getLowerChestInventory().getSizeInventory()) {
            if (var1.getLowerChestInventory().getStackInSlot(var16) != null && var1.getLowerChestInventory().getStackInSlot(var16).getUnlocalizedName().contains("chestplate")) {
               double var30 = (double)((ItemArmor)var1.getLowerChestInventory().getStackInSlot(var16).getItem()).damageReduceAmount + this.c35895(var1.getLowerChestInventory().getStackInSlot(var16));
               if (var30 > var7) {
                  var7 = var30;
                  var9 = var16;
               }
            }

            ++var16;
         }
      }

      if (var2.getUnlocalizedName().contains("leggings")) {
         int var20 = 0;
         if (var20 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var20).getHasStack() && mc.thePlayer.inventoryContainer.getSlot(var20).getStack().getItem().getUnlocalizedName().contains("leggings")) {
               double var31 = (double)((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(var20).getStack().getItem()).damageReduceAmount + this.c35895(mc.thePlayer.inventoryContainer.getSlot(var20).getStack());
               if (var31 > var7) {
                  var7 = var31;
                  var9 = var20;
               }
            }

            ++var20;
         }

         var20 = 0;
         if (var20 < var1.getLowerChestInventory().getSizeInventory()) {
            if (var1.getLowerChestInventory().getStackInSlot(var20) != null && var1.getLowerChestInventory().getStackInSlot(var20).getUnlocalizedName().contains("leggings")) {
               double var32 = (double)((ItemArmor)var1.getLowerChestInventory().getStackInSlot(var20).getItem()).damageReduceAmount + this.c35895(var1.getLowerChestInventory().getStackInSlot(var20));
               if (var32 > var7) {
                  var7 = var32;
                  var9 = var20;
               }
            }

            ++var20;
         }
      }

      if (var2.getUnlocalizedName().contains("boots")) {
         int var24 = 0;
         if (var24 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var24).getHasStack() && mc.thePlayer.inventoryContainer.getSlot(var24).getStack().getItem().getUnlocalizedName().contains("boots")) {
               double var33 = (double)((ItemArmor) mc.thePlayer.inventoryContainer.getSlot(var24).getStack().getItem()).damageReduceAmount + this.c35895(mc.thePlayer.inventoryContainer.getSlot(var24).getStack());
               if (var33 > var7) {
                  var7 = var33;
                  var9 = var24;
               }
            }

            ++var24;
         }

         var24 = 0;
         if (var24 < var1.getLowerChestInventory().getSizeInventory()) {
            if (var1.getLowerChestInventory().getStackInSlot(var24) != null && var1.getLowerChestInventory().getStackInSlot(var24).getUnlocalizedName().contains("boots")) {
               double var34 = (double)((ItemArmor)var1.getLowerChestInventory().getStackInSlot(var24).getItem()).damageReduceAmount + this.c35895(var1.getLowerChestInventory().getStackInSlot(var24));
               if (var34 > var7) {
                  var7 = var34;
                  var9 = var24;
               }
            }

            ++var24;
         }
      }

      return var5 >= var7 && var1.getLowerChestInventory().getStackInSlot(var9) == var2;
   }

   private double c35895(ItemStack var1) {
      Module[] var2 = Value.c27574();
      return var1.getItem() instanceof ItemArmor ? (double)((ItemArmor)var1.getItem()).damageReduceAmount + (double)((100 - ((ItemArmor)var1.getItem()).damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, var1)) * 0.0075D : 0.0D;
   }

   private double c58918(ContainerChest var1, int var2) {
      double var4 = 0.0D;
      Value.c27574();
      int var6 = 0;
      if (var6 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var6).getHasStack()) {
            ItemStack var7 = mc.thePlayer.inventoryContainer.getSlot(var6).getStack();
            if (var7.getItem() instanceof ItemSword && (double)this.c19874(var7) > var4) {
               var4 = (double)this.c19874(var7);
            }
         }

         ++var6;
      }

      var6 = 0;
      if (var6 < var1.getLowerChestInventory().getSizeInventory()) {
         if (var1.getLowerChestInventory().getStackInSlot(var6) != null) {
            ItemStack var11 = var1.getLowerChestInventory().getStackInSlot(var6);
            if (var6 != var2 && var11.getItem() instanceof ItemSword && (double)this.c19874(var11) > var4) {
               var4 = (double)this.c19874(var11);
            }
         }

         ++var6;
      }

      return var4;
   }

   private float c19874(ItemStack var1) {
      Value.c27574();
      float var3 = 0.0F;
      Item var4 = var1.getItem();
      if (var4 instanceof ItemTool) {
         var3 += this.c8004(var1);
      }

      if (var4 instanceof ItemSword) {
         var3 += this.c4441(var1);
      }

      ++var3;
      return var3;
   }

   private float c4441(ItemStack var1) {
      float var2 = ((ItemSword)var1.getItem()).getDamageVsEntity();
      var2 = var2 + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, var1) * 1.25F;
      var2 = var2 + (float)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var1) * 0.01F;
      return var2;
   }

   private float c8004(ItemStack var1) {
      return ((ItemTool)var1.getItem()).getToolMaterial().getEfficiencyOnProperMaterial();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
