//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.font;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

public class Utils {
   public static boolean fuck = true;
   private static Minecraft mc = Minecraft.getMinecraft();

   public static boolean isContainerEmpty(Container container) {
      int i = 0;

      for(int slotAmount = container.inventorySlots.size() == 90 ? 54 : 27; i < slotAmount; ++i) {
         if (container.getSlot(i).getHasStack()) {
            return false;
         }
      }

      return true;
   }

   public static Minecraft getMinecraft() {
      return mc;
   }

   public static boolean canBlock() {
      if (mc == null) {
         mc = Minecraft.getMinecraft();
      }

      if (mc.thePlayer.getHeldItem() == null) {
         return false;
      } else if (!mc.thePlayer.isBlocking() && (!mc.thePlayer.isUsingItem() || !(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword))) {
         return mc.thePlayer.getHeldItem().getItem() instanceof ItemSword && Minecraft.getMinecraft().gameSettings.keyBindUseItem.isPressed();
      } else {
         return true;
      }
   }

   public static String getMD5(String input) {
      StringBuilder res = new StringBuilder();

      try {
         MessageDigest algorithm = MessageDigest.getInstance("MD5");
         algorithm.reset();
         algorithm.update(input.getBytes());

         for(byte aMd5 : algorithm.digest()) {
            String tmp = Integer.toHexString(255 & aMd5);
            if (tmp.length() == 1) {
               res.append("0").append(tmp);
            } else {
               res.append(tmp);
            }
         }
      } catch (NoSuchAlgorithmException var9) {
         ;
      }

      return res.toString();
   }

   public static void breakAnticheats() {
      mc.thePlayer.sendQueue.addToSendQueue(new C04PacketPlayerPosition(mc.thePlayer.posX + mc.thePlayer.motionX, mc.thePlayer.posY - 110.0D, mc.thePlayer.posZ + mc.thePlayer.motionZ, true));
   }

   public static int add(int number, int add, int max) {
      return number + add > max ? max : number + add;
   }

   public static int remove(int number, int remove, int min) {
      return number - remove < min ? min : number - remove;
   }

   public static int check(int number) {
      return number <= 0 ? 1 : (number > 255 ? 255 : number);
   }

   public static double getDist() {
      double distance = 0.0D;

      for(double i = mc.thePlayer.posY; i > 0.0D && i >= 0.0D; i -= 0.1D) {
         Block block = mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, i, mc.thePlayer.posZ)).getBlock();
         if (block.getMaterial() != Material.air && block.isCollidable() && (block.isFullBlock() || block instanceof BlockSlab || block instanceof BlockBarrier || block instanceof BlockStairs || block instanceof BlockGlass || block instanceof BlockStainedGlass)) {
            if (block instanceof BlockSlab) {
               i -= 0.5D;
            }

            distance = i;
            break;
         }
      }

      return mc.thePlayer.posY - distance;
   }
}
