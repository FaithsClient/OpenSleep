package rip.sleep.module.modules;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C16PacketClientStatus.EnumState;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PacketUtilA;
import rip.sleep.util.TimerUtilF;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class AutoArmor extends Module {
   private final ModeValue c63911 = new ModeValue("Mode", new String[]{"FakeInv", "OpenInv", "Basic"}, "FakeInv");
   private TimerUtilF c52931 = new TimerUtilF();
   private final NumberValue<Number> c47242 = new NumberValue<Number>("Delay", 1.0D, 0.0D, 10.0D, 1.0D);

   public AutoArmor() {
      super("Auto Armor", new String[]{"AutoArmor"}, ModuleType.c31770, ModuleType.c21190.c55384);
      super.c68609(true);
   }

   @EventTarget
   public void c50486(MotionUpdateEvent var1) {
      Value.c27574();
      this.c2159(this.c63911.c54460());
      long var3 = this.c47242.c53968().longValue() * 50L;
      if (!Objects.equals(this.c63911.c54460(), "OpenInv") || mc.currentScreen instanceof GuiInventory) {
         if ((mc.currentScreen == null || mc.currentScreen instanceof GuiInventory || mc.currentScreen instanceof GuiChat) && this.c52931.c75125(var3)) {
            this.c39423();
         }

      }
   }

   public void c39423() {
      Value.c27574();
      int var2 = 1;
      if (var2 < 5) {
         if (mc.thePlayer.inventoryContainer.getSlot(4 + var2).getHasStack()) {
            ItemStack var3 = mc.thePlayer.inventoryContainer.getSlot(4 + var2).getStack();
            if (c45475(var3, var2)) {
               ;
            }

            if (Objects.equals(this.c63911.c54460(), "FakeInv")) {
               C16PacketClientStatus var4 = new C16PacketClientStatus(EnumState.OPEN_INVENTORY_ACHIEVEMENT);
               PacketUtilA.sendPacketNoEvent(var4);
            }

            this.c47723(4 + var2);
         }

         int var8 = 9;
         if (var8 < 45) {
            if (mc.thePlayer.inventoryContainer.getSlot(var8).getHasStack()) {
               Minecraft var10 = mc;
               ItemStack var5 = mc.thePlayer.inventoryContainer.getSlot(var8).getStack();
               if (c45475(var5, var2) && c86386(var5) > 0.0F) {
                  if (Objects.equals(this.c63911.c54460(), "FakeInv")) {
                     C16PacketClientStatus var6 = new C16PacketClientStatus(EnumState.OPEN_INVENTORY_ACHIEVEMENT);
                     PacketUtilA.sendPacketNoEvent(var6);
                  }

                  this.c81357(var8);
                  if (Objects.equals(this.c63911.c54460(), "FakeInv")) {
                     PacketUtilA.sendPacketNoEvent(new C0DPacketCloseWindow(0));
                  }

                  this.c52931.c99119();
                  if (this.c47242.c53968().longValue() > 0L) {
                     return;
                  }
               }
            }

            ++var8;
         }

         ++var2;
      }

   }

   public static boolean c45475(ItemStack var0, int var1) {
      Value.c27574();
      float var3 = c86386(var0);
      String var4 = "";
      if (var1 == 1) {
         var4 = "helmet";
      }

      if (var1 == 2) {
         var4 = "chestplate";
      }

      if (var1 == 3) {
         var4 = "leggings";
      }

      if (var1 == 4) {
         var4 = "boots";
      }

      if (!var0.getUnlocalizedName().contains(var4)) {
         return false;
      } else {
         int var5 = 5;
         if (var5 < 45) {
            if (Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(var5).getHasStack()) {
               ItemStack var6 = Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(var5).getStack();
               if (c86386(var6) > var3 && var6.getUnlocalizedName().contains(var4)) {
                  return false;
               }
            }

            ++var5;
         }

         return true;
      }
   }

   public void c81357(int var1) {
      PlayerControllerMP var2 = mc.playerController;
      int var3 = mc.thePlayer.inventoryContainer.windowId;
      boolean var4 = false;
      boolean var5 = true;
      var2.windowClick(var3, var1, 0, 1, mc.thePlayer);
   }

   public void c47723(int var1) {
      PlayerControllerMP var2 = mc.playerController;
      int var3 = mc.thePlayer.inventoryContainer.windowId;
      boolean var4 = true;
      boolean var5 = true;
      var2.windowClick(var3, var1, 1, 4, mc.thePlayer);
   }

   public static float c86386(ItemStack var0) {
      Value.c27574();
      float var2 = 0.0F;
      if (var0.getItem() instanceof ItemArmor) {
         ItemArmor var3 = (ItemArmor)var0.getItem();
         var2 = (float)((double)var2 + (double)var3.damageReduceAmount + (double)((100 - var3.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, var0)) * 0.0075D);
         var2 = (float)((double)var2 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, var0) / 100.0D);
         var2 = (float)((double)var2 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, var0) / 100.0D);
         var2 = (float)((double)var2 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, var0) / 100.0D);
         var2 = (float)((double)var2 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var0) / 50.0D);
         var2 = (float)((double)var2 + (double)EnchantmentHelper.getEnchantmentLevel(Enchantment.featherFalling.effectId, var0) / 100.0D);
      }

      return var2;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   private static enum c56657 {
      c54778,
      c86794,
      c56066;
   }
}
