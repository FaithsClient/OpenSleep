package rip.sleep.module.modules;

import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.InvUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class AutoTool extends Module {
   private final BooleanValue c54691 = new BooleanValue("Sword-Swap", false);
   private final BooleanValue c68755 = new BooleanValue("Hold-Check", false);
   public static BooleanValue c56373 = new BooleanValue("Auto-Pick", false);
   public static BooleanValue c38795 = new BooleanValue("Auto-Back", false);
   private int c79844;
   private boolean c1617;

   public AutoTool() {
      super("Auto Tool", new String[]{"AutoTool"}, ModuleType.c31770, ModuleType.c21190.c76367);
      super.c68609(true);
   }

   public void c71897() {
      Module[] var1 = Value.c27574();
      if (c38795.c1473().booleanValue() && this.c1617) {
         mc.thePlayer.inventory.currentItem = this.c79844;
         this.c1617 = false;
      }

   }

   public Entity c15224(double var1) {
      Entity var4 = null;
      Value.c27574();
      Iterator var7 = mc.theWorld.loadedEntityList.iterator();
      if (var7.hasNext()) {
         Entity var8 = (Entity)var7.next();
         if (mc.thePlayer.onGround && mc.thePlayer.isCollidedVertically && var8 instanceof EntityItem) {
            double var9 = (double) mc.thePlayer.getDistanceToEntity(var8);
            if (var9 <= var1) {
               var4 = var8;
            }
         }
      }

      return var4;
   }

   @EventTarget
   public void c86165(EndTickEvent var1) {
      Module[] var2 = Value.c27574();
      if (c38795.c1473().booleanValue()) {
         if ((Mouse.isButtonDown(0) || mc.gameSettings.keyBindAttack.isKeyDown()) && mc.objectMouseOver != null && mc.objectMouseOver.typeOfHit == MovingObjectType.BLOCK) {
            if (!this.c1617) {
               this.c79844 = mc.thePlayer.inventory.currentItem;
            }

            this.c1617 = true;
         }

         if (this.c1617) {
            mc.thePlayer.inventory.currentItem = this.c79844;
            this.c1617 = false;
         }

         this.c79844 = mc.thePlayer.inventory.currentItem;
      }

   }

   @EventTarget
   public void c30241(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (PacketSendEvent.c81894() instanceof C02PacketUseEntity && ((C02PacketUseEntity) PacketSendEvent.c81894()).getAction().equals(Action.ATTACK)) {
         boolean var3 = !mc.thePlayer.isEating();
         if (var3 && this.c54691.c1473().booleanValue()) {
            this.c90497();
         }
      }

      if (PacketSendEvent.c81894() instanceof C07PacketPlayerDigging) {
         C07PacketPlayerDigging var5 = (C07PacketPlayerDigging) PacketSendEvent.c81894();
         if (var5.getStatus() == net.minecraft.network.play.client.C07PacketPlayerDigging.Action.START_DESTROY_BLOCK && (mc.objectMouseOver.typeOfHit == MovingObjectType.BLOCK || !this.c68755.c1473().booleanValue()) && !mc.thePlayer.capabilities.isCreativeMode) {
            BlockPos var4 = this.c68755.c1473().booleanValue() ? mc.objectMouseOver.getBlockPos() : var5.getPosition();
            if (!this.c68755.c1473().booleanValue()) {
               mc.thePlayer.inventory.currentItem = this.c83953(var4);
               mc.playerController.updateController();
            }
         }
      }

   }

   public void c90497() {
      int var2 = 0;
      double var3 = -1.0D;
      Value.c27574();
      int var5 = 36;
      if (var5 < 45) {
         if (mc.thePlayer.inventoryContainer.inventorySlots.toArray()[var5] != null) {
            ItemStack var6 = mc.thePlayer.inventoryContainer.getSlot(var5).getStack();
            if (var6.getItem() instanceof ItemSword) {
               double var7 = ((AttributeModifier)var6.getAttributeModifiers().get("generic.attackDamage").toArray()[0]).getAmount() + (double) InvUtilA.c61307(var6, Enchantment.sharpness) * 1.25D + (double) InvUtilA.c61307(var6, Enchantment.fireAspect);
               if (var7 > var3) {
                  var2 = var5 - 36;
                  var3 = var7;
               }
            }
         }

         ++var5;
      }

      if (var3 > -1.0D) {
         mc.thePlayer.inventory.currentItem = var2;
         mc.playerController.updateController();
      }

   }

   private int c13060(Item var1) {
      Value.c27574();
      byte var3 = 0;
      int var4 = -1;
      int var5 = 36;
      if (var5 < 45) {
         ItemStack var6 = mc.thePlayer.inventoryContainer.getSlot(var5).getStack();
         if (var6.getItem() == var1) {
            int var7 = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var6);
            if (var7 > var3) {
               var4 = var5 - 36;
            }
         }

         ++var5;
      }

      return var4 >= 0 ? var4 : -1;
   }

   private int c83953(BlockPos var1) {
      Block var3 = mc.theWorld.getBlockState(var1).getBlock();
      int var4 = 0;
      float var5 = 0.1F;
      Value.c27574();
      int var6 = 36;
      if (var6 < 45) {
         ItemStack var7 = mc.thePlayer.inventoryContainer.getSlot(var6).getStack();
         if (var7.getItem().getStrVsBlock(var7, var3) > var5) {
            var4 = var6 - 36;
            var5 = var7.getItem().getStrVsBlock(var7, var3);
         }

         ++var6;
      }

      if (this.c13060(Items.stone_pickaxe) != -1 && (mc.theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.coal_ore || mc.theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.lapis_ore || mc.theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.iron_ore || mc.theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock() == Blocks.stone)) {
         var4 = this.c13060(Items.stone_pickaxe);
         if ((float)var4 > 0.1F) {
            return var4;
         }
      } else if (var5 > 0.1F) {
         return var4;
      }

      return mc.thePlayer.inventory.currentItem;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
