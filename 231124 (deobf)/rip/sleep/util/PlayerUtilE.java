package rip.sleep.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.util.BlockPos;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class PlayerUtilE {
   public static boolean c49385 = true;
   private static Minecraft c49787 = Minecraft.getMinecraft();

   public static boolean c83654(Container var0) {
      Value.c27574();
      int var2 = 0;
      int var3 = var0.inventorySlots.size() == 90 ? 54 : 27;
      if (var2 < var3) {
         if (var0.getSlot(var2).getHasStack()) {
            return false;
         }

         ++var2;
      }

      return true;
   }

   public static Minecraft c9665() {
      return c49787;
   }

   public static boolean c47908() {
      Module[] var0 = Value.c27574();
      if (c49787 == null) {
         c49787 = Minecraft.getMinecraft();
      }

      if (c49787.thePlayer.getHeldItem() == null) {
         return false;
      } else if (!c49787.thePlayer.isBlocking() && (!c49787.thePlayer.isUsingItem() || !(c49787.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword))) {
         return c49787.thePlayer.getHeldItem().getItem() instanceof ItemSword && Minecraft.getMinecraft().gameSettings.keyBindUseItem.isPressed();
      } else {
         return true;
      }
   }

   public static String c86379(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static void c19138() {
      c49787.thePlayer.sendQueue.addToSendQueue(new C04PacketPlayerPosition(c49787.thePlayer.posX + c49787.thePlayer.motionX, c49787.thePlayer.posY - 110.0D, c49787.thePlayer.posZ + c49787.thePlayer.motionZ, true));
   }

   public static int c72305(int var0, int var1, int var2) {
      Module[] var3 = Value.c27574();
      return var0 + var1 > var2 ? var2 : var0 + var1;
   }

   public static int c45894(int var0, int var1, int var2) {
      Module[] var3 = Value.c27574();
      return var0 - var1 < var2 ? var2 : var0 - var1;
   }

   public static int c20170(int var0) {
      Module[] var1 = Value.c27574();
      return var0 <= 0 ? 1 : (var0 > 255 ? 255 : var0);
   }

   public static double c18779() {
      double var1 = 0.0D;
      Value.c27574();
      double var3 = c49787.thePlayer.posY;
      if (var3 > 0.0D) {
         if (var3 < 0.0D) {
            ;
         }

         Block var5 = c49787.theWorld.getBlockState(new BlockPos(c49787.thePlayer.posX, var3, c49787.thePlayer.posZ)).getBlock();
         if (var5.getMaterial() != Material.air && var5.isCollidable() && (var5.isFullBlock() || var5 instanceof BlockSlab || var5 instanceof BlockBarrier || var5 instanceof BlockStairs || var5 instanceof BlockGlass || var5 instanceof BlockStainedGlass)) {
            if (var5 instanceof BlockSlab) {
               var3 -= 0.5D;
            }

            var1 = var3;
         }

         var3 = var3 - 0.1D;
      }

      return c49787.thePlayer.posY - var1;
   }

   private static Exception c12765(Exception var0) {
      return var0;
   }
}
