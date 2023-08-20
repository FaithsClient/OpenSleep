//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.module.modules.Reach;
import ft.sleep.util.scaffold.ServerUtils;
import ft.sleep.util.wtf.DimensionHelper2;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class WaterBucket extends Module {
   public static int finland$;
   public static int signs$;
   public static int thong$;
   public boolean mission$;
   public int filters$ = 0;
   public Option fitted$ = new Option("Swap", true);
   public Option reserve$ = new Option("Recycle", true);
   public Numbers maximize$ = new Numbers("Fall Distance", 3.0D, 1.0D, Integer.valueOf(10), 0.1D);

   public WaterBucket() {
      super("Water Bucket", new String[]{"ft.sleep.module.modules.WaterBucket"}, ModuleType.Combat);
   }

   public void _regime() {
      super._regime();
   }

   public void _discs() {
      super._discs();
   }

   @EventHandler
   public void _lowest(EventPreUpdate var1) {
      if (!ServerUtils._comedy() && Reach._latter() && !warned.mc.isGamePaused()) {
         if (DimensionHelper2._payable()) {
            warned._director();
         }

         if (warned._bills() && warned._dresses()) {
            warned.mission$ = true;
         }

         if (warned.mission$) {
            warned._derived();
            if (warned.mc.thePlayer.onGround || warned.mc.thePlayer.motionY > Double.longBitsToDouble(0L)) {
               warned._present();
            }
         }
      }

   }

   public boolean _bills() {
      if (performs.mc.thePlayer.fallDistance > performs.maximize$.getValue().floatValue() && performs.mc.thePlayer.rotationPitch >= 70.0F && performs.mc.thePlayer.motionY < -0.6D && !performs.mc.thePlayer.onGround && !performs.mc.thePlayer.capabilities.isFlying && !performs.mc.thePlayer.capabilities.isCreativeMode && !performs.mission$) {
         Object hearts = performs.mc.thePlayer.getPosition();

         for(Object ethiopia = 1; ethiopia < 3; ++ethiopia) {
            Object cables = hearts.down(ethiopia);
            Object varying = performs.mc.theWorld.getBlockState(cables).getBlock();
            if (varying.isBlockSolid(performs.mc.theWorld, cables, EnumFacing.UP)) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean _dresses() {
      if (sidubazo._chapters(sidubazo.mc.thePlayer.getHeldItem(), Items.water_bucket)) {
         return true;
      } else {
         for(Object epugeyev = 0; epugeyev < InventoryPlayer.getHotbarSize(); ++epugeyev) {
            if (sidubazo._chapters(sidubazo.mc.thePlayer.inventory.mainInventory[epugeyev], Items.water_bucket)) {
               sidubazo.mc.thePlayer.inventory.currentItem = epugeyev;
               return true;
            }
         }

         return false;
      }
   }

   public void _derived() {
      Object drinks = current.mc.thePlayer.getHeldItem();
      if (current._chapters(drinks, Items.water_bucket)) {
         Object story = current.mc.objectMouseOver;
         if (story.typeOfHit == MovingObjectType.BLOCK && story.sideHit == EnumFacing.UP) {
            current.mc.playerController.sendUseItem(current.mc.thePlayer, current.mc.theWorld, drinks);
         }
      }

   }

   public void _present() {
      Object yetipami = tilemelo.mc.thePlayer.getHeldItem();
      if (tilemelo._chapters(yetipami, Items.bucket) && tilemelo.reserve$.getValue().booleanValue()) {
         tilemelo.mc.playerController.sendUseItem(tilemelo.mc.thePlayer, tilemelo.mc.theWorld, yetipami);
      }

      if (tilemelo.fitted$.getValue().booleanValue() && tilemelo.filters$ != tilemelo.mc.thePlayer.inventory.currentItem) {
         tilemelo.mc.thePlayer.inventory.currentItem = tilemelo.filters$;
      }

      tilemelo.mission$ = false;
   }

   public boolean _chapters(ItemStack mizetuzi, Item sifuyebi) {
      return mizetuzi != null && ((ItemStack)mizetuzi).getItem() == sifuyebi;
   }
}
