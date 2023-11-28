package rip.sleep.module.modules;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PacketUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class AntiTrap extends Module {
   public static boolean c42949 = false;
   public BooleanValue c17194 = new BooleanValue("No Swing", false);
   public BooleanValue c29083 = new BooleanValue("Anti Sand Trap", true);
   private float c13739;
   private boolean c34279;

   public AntiTrap() {
      super("Anti Obby Trap", new String[]{"AntiObbyTrap"}, ModuleType.c31770, ModuleType.c21190.c76367);
   }

   @EventTarget
   public void c33517(MotionUpdateEvent var1) {
      Value.c27574();
      Sleep.getInstance();
      Sleep.c33759();
      if (!ModuleManager.c25475(Freecam.class).c24622()) {
         if (mc.theWorld.getBlockState(new BlockPos(var1.c524(), var1.c13885() + 1.0D, var1.c92054())).getBlock() == Blocks.obsidian || mc.theWorld.getBlockState(new BlockPos(var1.c524(), var1.c13885() + 1.0D, var1.c92054())).getBlock() == Blocks.cobblestone || mc.theWorld.getBlockState(new BlockPos(var1.c524(), var1.c13885() + 2.0D, var1.c92054())).getBlock() instanceof BlockFurnace) {
            var1.c78602(89.0F + ThreadLocalRandom.current().nextFloat());
            Block var3 = mc.theWorld.getBlockState(new BlockPos(var1.c524(), var1.c13885() - 1.0D, var1.c92054())).getBlock();
            BlockPos var4 = new BlockPos(var1.c524(), var1.c13885() - 1.0D, var1.c92054());
            if (this.c13739 == 0.0F) {
               this.c34279 = true;
               PacketUtilA.c61987(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, var4, EnumFacing.UP));
            }

            this.c66219(var4);
            PacketUtilA.c61987(new C0APacketAnimation());
            this.c13739 += var3.getPlayerRelativeBlockHardness(mc.thePlayer, mc.theWorld, var4);
            mc.theWorld.sendBlockBreakProgress(mc.thePlayer.getEntityId(), var4, (int)(this.c13739 * 10.0F) - 1);
            if (this.c13739 >= 1.0F) {
               PacketUtilA.c61987(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, var4, EnumFacing.UP));
               mc.playerController.onPlayerDestroyBlock(var4, EnumFacing.UP);
               this.c13739 = 0.0F;
               this.c34279 = false;
            }
         }

         this.c13739 = 0.0F;
         this.c34279 = false;
      }

   }

   @EventTarget
   public void c84514(MotionUpdateEvent var1) {
      Value.c27574();
      Sleep.getInstance();
      Sleep.c33759();
      if (!ModuleManager.c25475(Freecam.class).c24622()) {
         c42949 = false;
         BlockPos var3 = new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);
         Block var4 = mc.theWorld.getBlockState(var3.up()).getBlock();
         if (var4 == Blocks.gravel || var4 == Blocks.sand) {
            var3 = new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY + 1.0D, mc.thePlayer.posZ);
         }

         Block var5 = mc.theWorld.getBlockState(var3).getBlock();
         if (var5 == Blocks.gravel || var5 == Blocks.sand) {
            c42949 = false;
            if (this.c29083.c1473().booleanValue()) {
               var1.c78602(90.0F);
               this.c18515(var3, EnumFacing.UP);
            }
         }
      }

   }

   public boolean c57579() {
      return this.c34279;
   }

   public void c66219(BlockPos var1) {
      Block var3 = mc.theWorld.getBlockState(var1).getBlock();
      float var4 = 1.0F;
      Value.c27574();
      int var5 = -1;
      int var6 = 0;
      if (var6 < 9) {
         ItemStack var7 = mc.thePlayer.inventory.getStackInSlot(var6);
         if (var7 != null && var7.getStrVsBlock(var3) > var4) {
            var5 = var6;
            var7.getStrVsBlock(var3);
         }

         ++var6;
      }

      if (var5 != -1 && mc.thePlayer.inventory.getStackInSlot(mc.thePlayer.inventory.currentItem) != mc.thePlayer.inventory.getStackInSlot(var5)) {
         mc.thePlayer.inventory.currentItem = var5;
      }

   }

   public void c18515(BlockPos var1, EnumFacing var2) {
      Module[] var3 = Value.c27574();
      if (this.c17194.c1473().booleanValue()) {
         PacketUtilA.c61987(new C0APacketAnimation());
      }

      mc.thePlayer.swingItem();
      PacketUtilA.c61987(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, var1, var2));
      PacketUtilA.c61987(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, var1, var2));
      PacketUtilA.c61987(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, var1, var2));
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
