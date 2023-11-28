package rip.sleep.module.modules;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.TimerUtilB;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class InvManager extends Module {
   public final BooleanValue c78892 = new BooleanValue("BSG", false);
   public final BooleanValue c56163 = new BooleanValue("Open Inventory", true);
   public final NumberValue<Number> c7954 = new NumberValue<Number>("Delay", 5.0D, 0.0D, 10.0D, 1.0D);
   public final NumberValue<Number> c40672 = new NumberValue<Number>("Arrows", 128.0D, 64.0D, 512.0D, 64.0D);
   public final NumberValue<Number> c88569 = new NumberValue<Number>("Blocks", 128.0D, 64.0D, 512.0D, 64.0D);
   public final BooleanValue c43436 = new BooleanValue("Sword", true);
   public final NumberValue<Number> c43350 = new NumberValue<Number>("Sword Slot", () -> {
      return this.c43436.c1473();
   }, 1.0D, 1.0D, 9.0D, 1.0D);
   public final BooleanValue c91020 = new BooleanValue("Pickaxe", true);
   public final NumberValue<Number> c17600 = new NumberValue<Number>("Pickaxe Slot", () -> {
      return this.c91020.c1473();
   }, 2.0D, 1.0D, 9.0D, 1.0D);
   public final BooleanValue c5201 = new BooleanValue("Axe", true);
   public final NumberValue<Number> c39135 = new NumberValue<Number>("Axe Slot", () -> {
      return this.c5201.c1473();
   }, 3.0D, 1.0D, 9.0D, 1.0D);
   public final BooleanValue c69970 = new BooleanValue("Shovel", true);
   public final NumberValue<Number> c26542 = new NumberValue<Number>("Shovel Slot", () -> {
      return this.c69970.c1473();
   }, 4.0D, 1.0D, 9.0D, 1.0D);
   public final BooleanValue c78531 = new BooleanValue("Bow", true);
   public final NumberValue<Number> c53546 = new NumberValue<Number>("Bow Slot", () -> {
      return this.c78531.c1473();
   }, 5.0D, 1.0D, 9.0D, 1.0D);
   public final BooleanValue c50082 = new BooleanValue("Head", true);
   public final NumberValue<Number> c90281 = new NumberValue<Number>("Head Slot", () -> {
      return this.c50082.c1473();
   }, 6.0D, 1.0D, 9.0D, 1.0D);
   public final BooleanValue c18454 = new BooleanValue("Golden Apple", true);
   public final NumberValue<Number> c16421 = new NumberValue<Number>("Golden Apple Slot", () -> {
      return this.c18454.c1473();
   }, 7.0D, 1.0D, 9.0D, 1.0D);
   public final BooleanValue c42233 = new BooleanValue("Sticks", true);
   public final BooleanValue c60071 = new BooleanValue("Ores", true);
   public final BooleanValue c81279 = new BooleanValue("Buckets", true);
   private final TimerUtilB c18380 = new TimerUtilB();

   public InvManager() {
      super("Inv Manager", new String[]{"InvManager"}, ModuleType.c31770, ModuleType.c21190.c55384);
   }

   private boolean c36875(ItemStack var1) {
      Value.c27574();
      float var3 = this.c19874(var1);
      int var4 = 9;
      if (var4 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var4).getHasStack()) {
            ItemStack var5 = mc.thePlayer.inventoryContainer.getSlot(var4).getStack();
            if (this.c19874(var5) > var3 && var5.getItem() instanceof ItemSword) {
               return false;
            }
         }

         ++var4;
      }

      return var1.getItem() instanceof ItemSword;
   }

   private boolean c42406(ItemStack var1) {
      Module[] var2 = Value.c27574();
      if (this.c78892.c1473().booleanValue()) {
         if (var1.getDisplayName().contains("Tracking Device") || var1.getDisplayName().contains("Blitz Star") || var1.getDisplayName().contains("Bottle o' Enchanting")) {
            return true;
         }

         if (var1.getItem() instanceof ItemPotion) {
            List var3 = ((ItemPotion)var1.getItem()).getEffects(var1);
            Iterator var4 = var3.iterator();
            if (var4.hasNext()) {
               PotionEffect var5 = (PotionEffect)var4.next();
               if (var5.getPotionID() == Potion.damageBoost.getId()) {
                  return true;
               }
            }
         }

         if (var1.getItem() instanceof ItemEgg && var1.getDisplayName().contains("pawn")) {
            return true;
         }
      }

      return false;
   }

   private boolean c10385(ItemStack var1) {
      Module[] var2 = Value.c27574();
      return var1.getItem() instanceof ItemSkull && var1.getDisplayName().contains("Head") && !var1.getDisplayName().equalsIgnoreCase("Wither Skeleton Skull") && !var1.getDisplayName().equalsIgnoreCase("Zombie Head") && !var1.getDisplayName().equalsIgnoreCase("Creeper Head") && !var1.getDisplayName().equalsIgnoreCase("Skeleton Skull");
   }

   private boolean c73935(ItemStack var1) {
      return var1.getItem() instanceof ItemAppleGold;
   }

   @EventTarget
   public void c79015(MotionUpdateEvent var1) {
      AutoArmor var3 = (AutoArmor) ModuleManager.c25475(AutoArmor.class);
      Value.c27574();
      ChestStealer var4 = (ChestStealer) ModuleManager.c25475(ChestStealer.class);
      if (mc.currentScreen instanceof GuiInventory || !this.c56163.c1473().booleanValue()) {
         if (mc.currentScreen == null || mc.currentScreen instanceof GuiInventory || mc.currentScreen instanceof GuiChat) {
            int var5 = this.c43350.c53968().intValue() - 1;
            int var6 = this.c17600.c53968().intValue() - 1;
            int var7 = this.c53546.c53968().intValue() - 1;
            int var8 = this.c26542.c53968().intValue() - 1;
            int var9 = this.c39135.c53968().intValue() - 1;
            int var10 = this.c90281.c53968().intValue() - 1;
            int var11 = this.c16421.c53968().intValue() - 1;
            boolean var12 = this.c91020.c1473().booleanValue();
            boolean var13 = this.c69970.c1473().booleanValue();
            boolean var14 = this.c5201.c1473().booleanValue();
            boolean var15 = this.c43436.c1473().booleanValue();
            boolean var16 = this.c78531.c1473().booleanValue();
            boolean var17 = this.c50082.c1473().booleanValue();
            boolean var18 = this.c18454.c1473().booleanValue();
            long var19 = this.c7954.c53968().longValue() * 50L;
            int var21 = 9;
            if (var21 < 45) {
               ItemStack var22 = mc.thePlayer.inventoryContainer.getSlot(var21).getStack();
               if (var22 != null && this.c18380.c60452(var19)) {
                  if (this.c36875(var22) && var15 && this.c90028(var5)[0]) {
                     this.c44855(var21, var5);
                     this.c18380.c69505();
                  }

                  if (this.c87066(var22) && var12 && this.c90028(var6)[2]) {
                     this.c44855(var21, var6);
                     this.c18380.c69505();
                  }

                  if (this.c62385(var22) && var14 && this.c90028(var9)[1]) {
                     this.c44855(var21, var9);
                     this.c18380.c69505();
                  }

                  if (this.c97302(var22) && var16 && this.c90028(var7)[5] && !var22.getDisplayName().toLowerCase().contains("kit selector")) {
                     this.c44855(var21, var7);
                     this.c18380.c69505();
                  }

                  if (this.c10385(var22) && var17 && this.c90028(var10)[4]) {
                     this.c44855(var21, var10);
                     this.c18380.c69505();
                  }

                  if (this.c83993(var22) && var13 && this.c90028(var8)[3]) {
                     this.c44855(var21, var8);
                     this.c18380.c69505();
                  }

                  if (this.c73935(var22) && var18 && this.c90028(var11)[6]) {
                     this.c44855(var21, var11);
                     this.c18380.c69505();
                  }
               }

               ++var21;
            }

            var21 = 9;
            if (var21 < 45) {
               if (!mc.thePlayer.inventoryContainer.getSlot(var21).getHasStack()) {
                  ;
               }

               ItemStack var26 = mc.thePlayer.inventoryContainer.getSlot(var21).getStack();
               if (var26 != null && this.c36814(var26) && this.c18380.c60452(var19)) {
                  this.c47723(var21);
                  this.c18380.c69505();
               }

               ++var21;
            }
         }

      }
   }

   public void c47723(int var1) {
      mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, var1, 1, 4, mc.thePlayer);
   }

   public void c44855(int var1, int var2) {
      mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, var1, var2, 2, mc.thePlayer);
   }

   private boolean[] c90028(int var1) {
      Module[] var2 = Value.c27574();
      return new boolean[]{!mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getHasStack() || !this.c36875(mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getStack()), !mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getHasStack() || !this.c62385(mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getStack()), !mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getHasStack() || !this.c87066(mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getStack()), !mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getHasStack() || !this.c83993(mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getStack()), !mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getHasStack() || !this.c10385(mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getStack()), !mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getHasStack() || !this.c97302(mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getStack()), !mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getHasStack() || !this.c73935(mc.thePlayer.inventoryContainer.getSlot(var1 + 36).getStack())};
   }

   public boolean c62455() {
      Module[] var1 = Value.c27574();
      return !this.c18380.c93066(this.c7954.c53968().floatValue() * 150.0F);
   }

   private float c19874(ItemStack var1) {
      float var3 = 0.0F;
      Value.c27574();
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

   private int c74356() {
      int var2 = 0;
      Value.c27574();
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            Item var5 = var4.getItem();
            if (var4.getItem() instanceof ItemBlock && c85660(((ItemBlock)var5).getBlock())) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private static boolean c85660(Block var0) {
      Module[] var1 = Value.c27574();
      return (var0.isFullBlock() || var0 == Blocks.glass) && var0 != Blocks.sand && var0 != Blocks.gravel && var0 != Blocks.dispenser && var0 != Blocks.command_block && var0 != Blocks.noteblock && var0 != Blocks.furnace && var0 != Blocks.crafting_table && var0 != Blocks.tnt && var0 != Blocks.dropper && var0 != Blocks.beacon;
   }

   private int c93894() {
      Value.c27574();
      int var2 = 0;
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() == Items.arrow) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c19623() {
      int var2 = 0;
      Value.c27574();
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() == Items.iron_ingot) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c83714() {
      int var2 = 0;
      Value.c27574();
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() == Items.coal) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c60738() {
      Value.c27574();
      int var2 = 0;
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() instanceof ItemSword && this.c36875(var4)) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c31285() {
      Value.c27574();
      int var2 = 0;
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() instanceof ItemBow && this.c97302(var4)) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c26638() {
      Value.c27574();
      int var2 = 0;
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() instanceof ItemPickaxe && this.c87066(var4)) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c88453() {
      Value.c27574();
      int var2 = 0;
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() instanceof ItemAxe && this.c62385(var4)) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c91027() {
      Value.c27574();
      int var2 = 0;
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() instanceof ItemSkull && this.c83993(var4)) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private int c84253() {
      Value.c27574();
      int var2 = 0;
      int var3 = 0;
      if (var3 < 45) {
         if (mc.thePlayer.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
            if (var4.getItem() instanceof ItemSpade && this.c83993(var4)) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private boolean c87066(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      if (!(var3 instanceof ItemPickaxe)) {
         return false;
      } else {
         float var4 = this.c5832(var1);
         int var5 = 9;
         if (var5 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var5).getHasStack()) {
               ItemStack var6 = mc.thePlayer.inventoryContainer.getSlot(var5).getStack();
               if (this.c5832(var6) > var4 && var6.getItem() instanceof ItemPickaxe) {
                  return false;
               }
            }

            ++var5;
         }

         return true;
      }
   }

   private boolean c36814(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      String var4 = var1.getDisplayName();
      int var5 = Item.getIdFromItem(var3);
      if (this.c42406(var1)) {
         return false;
      } else if (var5 != 58 && !var4.toLowerCase().contains(EnumChatFormatting.OBFUSCATED + "||") && !var4.contains(EnumChatFormatting.GREEN + "Game Menu " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "Spectator Settings " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "Play Again " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "" + EnumChatFormatting.BOLD + "Teleporter " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "SkyWars Challenges " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "Collectibles " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "Kit Selector " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "Kill Effect Selector " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.WHITE + "Players: " + EnumChatFormatting.RED + "Hidden " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "Shop " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.WHITE + "Players: " + EnumChatFormatting.RED + "Visible " + EnumChatFormatting.GRAY + "(Right Click)") && !var4.equalsIgnoreCase(EnumChatFormatting.GOLD + "Excalibur") && !var4.equalsIgnoreCase("aDragon Sword") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "Cornucopia") && !var4.equalsIgnoreCase(EnumChatFormatting.RED + "Bloodlust") && !var4.equalsIgnoreCase(EnumChatFormatting.RED + "Artemis' Bow") && !var4.toLowerCase().contains("compass") && !var4.equalsIgnoreCase(EnumChatFormatting.GREEN + "Miner's Blessing") && !var4.equalsIgnoreCase(EnumChatFormatting.GOLD + "Axe of Perun") && !var4.equalsIgnoreCase(EnumChatFormatting.GOLD + "Cornucopia") && var5 != 116 && var5 != 145 && (var5 != 15 && var5 != 14 || !this.c60071.c1473().booleanValue()) && !var4.equalsIgnoreCase("§aAndúril") && var5 != 259 && var5 != 46) {
         int var6 = this.c43350.c53968().intValue() - 1;
         int var7 = this.c17600.c53968().intValue() - 1;
         int var8 = this.c53546.c53968().intValue() - 1;
         int var9 = this.c26542.c53968().intValue() - 1;
         int var10 = this.c39135.c53968().intValue() - 1;
         int var11 = this.c90281.c53968().intValue() - 1;
         boolean var12 = this.c91020.c1473().booleanValue();
         boolean var13 = this.c69970.c1473().booleanValue();
         boolean var14 = this.c5201.c1473().booleanValue();
         boolean var15 = this.c43436.c1473().booleanValue();
         boolean var16 = this.c78531.c1473().booleanValue();
         boolean var17 = this.c50082.c1473().booleanValue();
         if (((!this.c83993(var1) || this.c84253() >= 2) && (!(var1.getItem() instanceof ItemSpade) || var1 != mc.thePlayer.inventory.getStackInSlot(var9)) || !var13) && ((!this.c97302(var1) || this.c31285() >= 2) && (!(var1.getItem() instanceof ItemBow) || var1 != mc.thePlayer.inventory.getStackInSlot(var8)) || !var16) && ((!this.c10385(var1) || this.c91027() >= 2) && (!(var1.getItem() instanceof ItemSkull) || var1 != mc.thePlayer.inventory.getStackInSlot(var11)) || !var17) && ((!this.c62385(var1) || this.c88453() >= 2) && (!(var1.getItem() instanceof ItemAxe) || var1 != mc.thePlayer.inventory.getStackInSlot(var10)) || !var14) && ((!this.c87066(var1) || this.c26638() >= 2) && (!(var1.getItem() instanceof ItemPickaxe) || var1 != mc.thePlayer.inventory.getStackInSlot(var7)) || !var12) && ((!this.c36875(var1) || this.c60738() >= 2) && (!(var1.getItem() instanceof ItemSword) || var1 != mc.thePlayer.inventory.getStackInSlot(var6)) || !var15)) {
            if (var3 instanceof ItemArmor) {
               int var18 = 1;
               if (var18 < 5) {
                  if (mc.thePlayer.inventoryContainer.getSlot(4 + var18).getHasStack()) {
                     ItemStack var19 = mc.thePlayer.inventoryContainer.getSlot(4 + var18).getStack();
                     if (AutoArmor.c45475(var19, var18)) {
                        ;
                     }
                  }

                  if (AutoArmor.c45475(var1, var18)) {
                     return false;
                  }

                  ++var18;
               }
            }

            if ((!(var3 instanceof ItemBlock) || this.c74356() <= this.c88569.c53968().intValue() && c85660(((ItemBlock)var3).getBlock())) && (!(var3 instanceof ItemPotion) || !this.c50047(var1)) && (!(var3 instanceof ItemFood) || var3 instanceof ItemAppleGold || var3 == Items.bread || var3 == Items.pumpkin_pie || var3 == Items.baked_potato || var3 == Items.cooked_chicken || var3 == Items.carrot || var3 == Items.apple || var3 == Items.beef || var3 == Items.cooked_beef || var3 == Items.porkchop || var3 == Items.cooked_porkchop || var3 == Items.mushroom_stew || var3 == Items.cooked_fish || var3 == Items.melon) && !(var3 instanceof ItemHoe) && !(var3 instanceof ItemTool) && !(var3 instanceof ItemSword) && !(var3 instanceof ItemArmor)) {
               String var21 = var3.getUnlocalizedName();
               return !this.c42233.c1473().booleanValue() && var21.contains("stick") || var21.contains("egg") || this.c19623() > 64 && var3 == Items.iron_ingot || this.c83714() > 64 && var3 == Items.coal || var21.contains("string") || var21.contains("flint") || var21.contains("compass") || var21.contains("dyePowder") || var21.contains("feather") || var21.contains("chest") && !var4.toLowerCase().contains("collect") || var21.contains("snow") || var21.contains("torch") || var21.contains("seeds") || var21.contains("leather") || var21.contains("reeds") || var21.contains("record") || var21.contains("snowball") || var3 instanceof ItemGlassBottle || var3 instanceof ItemSlab || var5 == 113 || var5 == 106 || var5 == 325 || var5 == 326 && !this.c81279.c1473().booleanValue() || var5 == 327 || var5 == 111 || var5 == 85 || var5 == 188 || var5 == 189 || var5 == 190 || var5 == 191 || var5 == 401 || var5 == 192 || var5 == 81 || var5 == 32 || var21.contains("gravel") || var21.contains("flower") || var21.contains("tallgrass") || var3 instanceof ItemBow || var3 == Items.arrow && this.c93894() > (this.c78531.c1473().booleanValue() ? this.c40672.c53968().intValue() : 0) || var5 == 175 || var5 == 340 || var5 == 339 || var5 == 160 || var5 == 101 || var5 == 102 || var5 == 321 || var5 == 323 || var5 == 389 || var5 == 416 || var5 == 171 || var5 == 139 || var5 == 23 || var5 == 25 || var5 == 69 || var5 == 70 || var5 == 72 || var5 == 77 || var5 == 96 || var5 == 107 || var5 == 123 || var5 == 131 || var5 == 143 || var5 == 147 || var5 == 148 || var5 == 151 || var5 == 152 || var5 == 154 || var5 == 158 || var5 == 167 || var5 == 403 || var5 == 183 || var5 == 184 || var5 == 185 || var5 == 186 || var5 == 187 || var5 == 331 || var5 == 356 || var5 == 404 || var5 == 27 || var5 == 28 || var5 == 66 || var5 == 76 || var5 == 157 || var5 == 328 || var5 == 342 || var5 == 343 || var5 == 398 || var5 == 407 || var5 == 408 || var5 == 138 || var5 == 352 || var5 == 385 || var5 == 386 || var5 == 395 || var5 == 402 || var5 == 418 || var5 == 419 || var5 == 281 || var5 == 289 || var5 == 337 || var5 == 336 || var5 == 348 || var5 == 353 || var5 == 369 || var5 == 372 || var5 == 405 || var5 == 406 || var5 == 409 || var5 == 410 || var5 == 415 || var5 == 370 || var5 == 376 || var5 == 377 || var5 == 378 || var5 == 379 || var5 == 380 || var5 == 382 || var5 == 414 || var5 == 346 || var5 == 347 || var5 == 420 || var5 == 397 || var5 == 421 || var5 == 341 || var21.contains("sapling") || var21.contains("stairs") || var21.contains("door") || var21.contains("monster_egg") || var21.contains("sand") || var21.contains("piston");
            } else {
               return true;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean c83993(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      if (!(var3 instanceof ItemSpade)) {
         return false;
      } else {
         float var4 = this.c5832(var1);
         int var5 = 9;
         if (var5 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var5).getHasStack()) {
               ItemStack var6 = mc.thePlayer.inventoryContainer.getSlot(var5).getStack();
               if (this.c5832(var6) > var4 && var6.getItem() instanceof ItemSpade) {
                  return false;
               }
            }

            ++var5;
         }

         return true;
      }
   }

   private boolean c62385(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      if (!(var3 instanceof ItemAxe)) {
         return false;
      } else {
         float var4 = this.c5832(var1);
         int var5 = 9;
         if (var5 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var5).getHasStack()) {
               ItemStack var6 = mc.thePlayer.inventoryContainer.getSlot(var5).getStack();
               if (this.c5832(var6) > var4 && var6.getItem() instanceof ItemAxe && !this.c36875(var1)) {
                  return false;
               }
            }

            ++var5;
         }

         return true;
      }
   }

   private float c5832(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      if (!(var3 instanceof ItemTool)) {
         return 0.0F;
      } else {
         float var6;
         label36: {
            String var4 = var3.getUnlocalizedName();
            ItemTool var5 = (ItemTool)var3;
            if (var3 instanceof ItemPickaxe) {
               var6 = var5.getStrVsBlock(var1, Blocks.stone);
               if (!var4.toLowerCase().contains("gold")) {
                  break label36;
               }

               var6 = var6 - 5.0F;
            }

            if (var3 instanceof ItemSpade) {
               var6 = var5.getStrVsBlock(var1, Blocks.dirt);
               if (!var4.toLowerCase().contains("gold")) {
                  break label36;
               }

               var6 = var6 - 5.0F;
            }

            if (!(var3 instanceof ItemAxe)) {
               return 1.0F;
            }

            var6 = var5.getStrVsBlock(var1, Blocks.log);
            if (var4.toLowerCase().contains("gold")) {
               var6 = var6 - 5.0F;
               return 1.0F;
            }
         }

         var6 = (float)((double)var6 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var1) * 0.0075D);
         var6 = (float)((double)var6 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var1) / 100.0D);
         return var6;
      }
   }

   private float c25655(ItemStack var1) {
      return (float)(1 + EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, var1) + EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, var1) + EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, var1));
   }

   private boolean c50047(ItemStack var1) {
      Module[] var2 = Value.c27574();
      if (var1 != null && var1.getItem() instanceof ItemPotion) {
         ItemPotion var3 = (ItemPotion)var1.getItem();
         return var3.getEffects(var1) == null || this.c81480(var1, var3);
      } else {
         return false;
      }
   }

   public boolean c81480(ItemStack var1, ItemPotion var2) {
      Value.c27574();
      Iterator var4 = var2.getEffects(var1).iterator();
      if (var4.hasNext()) {
         PotionEffect var5 = (PotionEffect)var4.next();
         Potion var6 = Potion.potionTypes[var5.getPotionID()];
         if (var6.isBadEffect()) {
            return true;
         }
      }

      return false;
   }

   private boolean c97302(ItemStack var1) {
      Value.c27574();
      Item var3 = var1.getItem();
      if (!(var3 instanceof ItemBow)) {
         return false;
      } else {
         float var4 = this.c25655(var1);
         int var5 = 9;
         if (var5 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var5).getHasStack()) {
               ItemStack var6 = mc.thePlayer.inventoryContainer.getSlot(var5).getStack();
               if (this.c25655(var6) > var4 && var6.getItem() instanceof ItemBow) {
                  return false;
               }
            }

            ++var5;
         }

         return true;
      }
   }

   public void c71897() {
      this.c18380.c69505();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
