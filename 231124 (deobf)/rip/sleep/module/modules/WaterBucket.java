package rip.sleep.module.modules;

import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.WorldProviderHell;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.StartUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class WaterBucket extends Module {
   public boolean c57321;
   public int c15679 = 0;
   public BooleanValue c6680 = new BooleanValue("Swap", true);
   public BooleanValue c56886 = new BooleanValue("Recycle", true);
   public NumberValue<Number> c87296 = new NumberValue<Number>("Fall Distance", 3.0D, 1.0D, Integer.valueOf(10), 0.1D);

   public WaterBucket() {
      super("Water Bucket", new String[]{"WaterBucket"}, ModuleType.c31770, ModuleType.c21190.c76367);
   }

   public void c83205() {
      this.c57321 = false;
   }

   public void c71897() {
      this.c57321 = false;
   }

   @EventTarget
   public void c57173(StartUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if ((!Objects.isNull(mc.thePlayer) || !Objects.isNull(mc.theWorld)) && !(mc.thePlayer.worldObj.provider instanceof WorldProviderHell) && !mc.isGamePaused()) {
         if (this.c61559() && this.c93400()) {
            this.c57321 = true;
         }

         if (this.c57321) {
            this.c91134();
            if (mc.thePlayer.onGround || mc.thePlayer.motionY > 0.0D) {
               this.c1352();
            }
         }
      }

   }

   private boolean c61559() {
      Value.c27574();
      MovingObjectPosition var2 = mc.objectMouseOver;
      if (mc.thePlayer.fallDistance > this.c87296.c53968().floatValue() && !mc.thePlayer.onGround && mc.thePlayer.rotationPitch >= 70.0F && var2.typeOfHit == MovingObjectType.BLOCK && var2.sideHit == EnumFacing.UP && !mc.thePlayer.capabilities.isFlying && !mc.thePlayer.capabilities.isCreativeMode && !this.c57321) {
         Block var3 = mc.theWorld.getBlockState(var2.getBlockPos().up()).getBlock();
         return var3 != Blocks.water;
      } else {
         return false;
      }
   }

   private boolean c93400() {
      Module[] var1 = Value.c27574();
      if (this.c70075(mc.thePlayer.getHeldItem(), Items.water_bucket)) {
         this.c15679 = mc.thePlayer.inventory.currentItem;
         return true;
      } else {
         int var2 = 0;
         if (var2 < InventoryPlayer.getHotbarSize()) {
            if (this.c70075(mc.thePlayer.inventory.mainInventory[var2], Items.water_bucket)) {
               this.c15679 = mc.thePlayer.inventory.currentItem;
               mc.thePlayer.inventory.currentItem = var2;
               return true;
            }

            ++var2;
         }

         return false;
      }
   }

   private void c91134() {
      Value.c27574();
      ItemStack var2 = mc.thePlayer.getHeldItem();
      if (this.c70075(var2, Items.water_bucket) && mc.thePlayer.rotationPitch >= 70.0F) {
         MovingObjectPosition var3 = mc.objectMouseOver;
         if (var3.typeOfHit == MovingObjectType.BLOCK && var3.sideHit == EnumFacing.UP) {
            mc.playerController.sendUseItem(mc.thePlayer, mc.theWorld, var2);
         }
      }

   }

   private void c1352() {
      Value.c27574();
      ItemStack var2 = mc.thePlayer.getHeldItem();
      if (this.c70075(var2, Items.bucket) && this.c56886.c1473().booleanValue()) {
         mc.playerController.sendUseItem(mc.thePlayer, mc.theWorld, var2);
      }

      if (this.c6680.c1473().booleanValue() && this.c15679 != mc.thePlayer.inventory.currentItem) {
         mc.thePlayer.inventory.currentItem = this.c15679;
      }

      this.c57321 = false;
   }

   private boolean c70075(ItemStack var1, Item var2) {
      Module[] var3 = Value.c27574();
      return var1 != null && var1.getItem() == var2;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
