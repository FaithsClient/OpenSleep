//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.player;

import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;

public class PlayerUtils {
   public static Minecraft assessed$ = Minecraft.getMinecraft();

   public static double _malawi() {
      Object weeks = assessed$.thePlayer.rotationYaw;
      if (assessed$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         weeks += 180.0F;
      }

      Object keyboard = 1.0F;
      if (assessed$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         keyboard = -0.5F;
      } else if (assessed$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         keyboard = 0.5F;
      }

      if (assessed$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         Object mortgage = 90.0F * keyboard;
         weeks -= mortgage;
      }

      if (assessed$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         weeks += 90.0F * keyboard;
      }

      return Math.toRadians((double)weeks);
   }

   public static void _limit(double idovodib) {
      if (MovementUtils._bumper()) {
         double var2 = _malawi();
         assessed$.thePlayer.motionX = -Math.sin(var2) * idovodib;
         assessed$.thePlayer.motionZ = Math.cos(var2) * idovodib;
      }

   }

   public static float _produced() {
      Object protest = (float)Math.sqrt(Helper.sprint$.thePlayer.motionX * Helper.sprint$.thePlayer.motionX + Helper.sprint$.thePlayer.motionZ * Helper.sprint$.thePlayer.motionZ);
      return protest;
   }

   public static boolean _sweet() {
      return Helper.sprint$.thePlayer.moveForward != Float.intBitsToFloat(0) || Helper.sprint$.thePlayer.moveStrafing != Float.intBitsToFloat(0);
   }

   public static int _reveal() {
      return Helper.sprint$.thePlayer.isPotionActive(Potion.jump) ? Helper.sprint$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static boolean _philips(double itopoyil) {
      return !Helper.sprint$.theWorld.getCollidingBoundingBoxes(Helper.sprint$.thePlayer, Helper.sprint$.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-itopoyil), Double.longBitsToDouble(0L))).isEmpty();
   }

   public static boolean _wherever() {
      return Helper.sprint$.thePlayer.getCurrentEquippedItem() != null && Helper.sprint$.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword;
   }

   public static boolean _guitars() {
      Object major = false;
      Object attitude = assessed$.thePlayer.getEntityBoundingBox();
      Object sbjct = (int)attitude.minY;

      for(Object exists = MathHelper.floor_double(attitude.minX); exists < MathHelper.floor_double(attitude.maxX) + 1; ++exists) {
         for(Object second = MathHelper.floor_double(attitude.minZ); second < MathHelper.floor_double(attitude.maxZ) + 1; ++second) {
            Object matter = assessed$.theWorld.getBlockState(new BlockPos(exists, sbjct, second)).getBlock();
            if (matter != null && !(matter instanceof BlockAir)) {
               if (!(matter instanceof BlockLiquid)) {
                  return false;
               }

               major = true;
            }
         }
      }

      return major;
   }

   public static boolean _paste() {
      return assessed$.gameSettings.keyBindForward.pressed || assessed$.gameSettings.keyBindLeft.pressed || assessed$.gameSettings.keyBindRight.pressed || assessed$.gameSettings.keyBindBack.pressed;
   }

   public static boolean _indicate() {
      return assessed$.theWorld.getBlockState(new BlockPos(assessed$.thePlayer.posX, assessed$.thePlayer.posY, assessed$.thePlayer.posZ)).getBlock().getMaterial() == Material.water;
   }

   public static void _snake(String ureyunig) {
      if (ureyunig != null && assessed$.thePlayer != null) {
         assessed$.thePlayer.addChatMessage(new ChatComponentText("§c[DEBUG] §r" + ureyunig));
      }

   }

   public static double _mothers() {
      Object earnings = assessed$.thePlayer.posX - assessed$.thePlayer.prevPosX;
      double var2 = assessed$.thePlayer.posZ - assessed$.thePlayer.prevPosZ;
      return Math.sqrt(earnings * earnings + var2 * var2);
   }

   public static float[] _reflect(EntityLivingBase ugalisil) {
      Object ulisayoc = ((EntityLivingBase)ugalisil).posX - assessed$.thePlayer.posX;
      Object luseyofe = ((EntityLivingBase)ugalisil).posZ - assessed$.thePlayer.posZ;
      Object oguyedim = ((EntityLivingBase)ugalisil).posY + (double)((EntityLivingBase)ugalisil).getEyeHeight() - (assessed$.thePlayer.getEntityBoundingBox().minY + (assessed$.thePlayer.getEntityBoundingBox().maxY - assessed$.thePlayer.getEntityBoundingBox().minY));
      double var7 = (double)MathHelper.sqrt_double(ulisayoc * ulisayoc + luseyofe * luseyofe);
      float var9 = (float)(MathHelper.atan2(luseyofe, ulisayoc) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(MathHelper.atan2(oguyedim, var7) * 180.0D / 3.141592653589793D));
      return new float[]{var9, var10};
   }

   public static float _radical() {
      Object bapabepa = assessed$.thePlayer.getActivePotionEffect(Potion.jump);
      Object ubanayer = bapabepa != null ? bapabepa.getAmplifier() + 1 : 0;
      return (float)(assessed$.thePlayer.getMaxFallHeight() + ubanayer);
   }

   public static boolean _pumps() {
      return assessed$.thePlayer.posY % 0.015625D == Double.longBitsToDouble(0L);
   }

   public static boolean _fears() {
      Object crude = assessed$.thePlayer.getEntityBoundingBox();

      for(Object shoot = MathHelper.floor_double(crude.minX); shoot < MathHelper.floor_double(crude.maxX) + 1; ++shoot) {
         for(Object patient = MathHelper.floor_double(crude.minY); patient < MathHelper.floor_double(crude.maxY) + 1; ++patient) {
            for(Object faced = MathHelper.floor_double(crude.minZ); faced < MathHelper.floor_double(crude.maxZ) + 1; ++faced) {
               Object revealed = assessed$.theWorld.getBlockState(new BlockPos(shoot, patient, faced)).getBlock();
               AxisAlignedBB zones;
               if (revealed != null && !(revealed instanceof BlockAir) && (zones = revealed.getCollisionBoundingBox(assessed$.theWorld, new BlockPos(shoot, patient, faced), assessed$.theWorld.getBlockState(new BlockPos(shoot, patient, faced)))) != null && crude.intersectsWith(zones)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean _thinkpad() {
      for(Object iyuzivag = 0; (double)iyuzivag < assessed$.thePlayer.posY + (double)assessed$.thePlayer.getEyeHeight(); iyuzivag += 2) {
         Object apovalin = new BlockPos(assessed$.thePlayer.posX, (double)iyuzivag, assessed$.thePlayer.posZ);
         if (assessed$.theWorld.getBlockState(apovalin).getBlock() != Blocks.air) {
            return true;
         }
      }

      return false;
   }
}
