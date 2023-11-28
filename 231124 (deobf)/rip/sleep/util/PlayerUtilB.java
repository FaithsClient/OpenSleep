package rip.sleep.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.event.events.MoveEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class PlayerUtilB {
   private static final Minecraft c45822 = Minecraft.getMinecraft();
   public static final List<Double> c52318 = new ArrayList();

   public static double c69767(double var0) {
      Module[] var2 = Value.c27574();
      if (c45822.thePlayer.isPotionActive(Potion.jump)) {
         int var3 = c45822.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
         var0 += (double)((float)(var3 + 1) * 0.1F);
      }

      return var0;
   }

   public static double c78227() {
      return c78810(c45822.thePlayer);
   }

   public static double c78810(EntityLivingBase var0) {
      return c15048(var0, 0.2D);
   }

   public static double c15048(EntityLivingBase var0, double var1) {
      Value.c27574();
      double var4 = 0.2873D;
      if (var0.isPotionActive(Potion.moveSpeed)) {
         int var6 = var0.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         var4 *= 1.0D + var1 * (double)(var6 + 1);
      }

      return var4;
   }

   public static void c52485() {
      c92362(c29122());
   }

   public static void c14107(MoveEvent var0) {
      c9624(var0, (double)c29122());
   }

   public static void c20816(float var0) {
      if (c23027()) {
         double var1 = c65593();
         c45822.thePlayer.motionX = -Math.sin(var1) * (double)var0;
         c45822.thePlayer.motionZ = Math.cos(var1) * (double)var0;
      }
   }

   public static void c92362(float var0) {
      if (PlayerUtil.c71257()) {
         double var1 = (double)c6953();
         c45822.thePlayer.motionX = -Math.sin(var1) * (double)var0;
         c45822.thePlayer.motionZ = Math.cos(var1) * (double)var0;
      }

   }

   public static float c3701() {
      return (float)c22069(c45822.thePlayer.motionX, c45822.thePlayer.motionZ);
   }

   public static double c22069(double var0, double var2) {
      return Math.sqrt(var0 * var0 + var2 * var2);
   }

   public static void c9624(MoveEvent var0, double var1) {
      if (c23027()) {
         double var3 = c99446();
         var0.c97676(c45822.thePlayer.motionX = -Math.sin(var3) * var1);
         var0.c90383(c45822.thePlayer.motionZ = Math.cos(var3) * var1);
      }
   }

   public static final void c29437(double var0) {
      Module[] var2 = Value.c27574();
      if (c23027()) {
         double var3 = c6665(true);
         c45822.thePlayer.motionX = -Math.sin(var3) * var0;
         c45822.thePlayer.motionZ = Math.cos(var3) * var0;
      }
   }

   public final void c76291(double var1, double var3) {
      c45822.thePlayer.motionX = -Math.sin(var3) * var1;
      c45822.thePlayer.motionZ = Math.cos(var3) * var1;
   }

   public static double c85690(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = c45822.thePlayer.rotationYaw;
      if (c45822.thePlayer.moveForward < 0.0F) {
         var4 += 180.0F;
      }

      float var5 = 1.0F;
      if (c45822.thePlayer.moveForward < 0.0F) {
         var5 = -0.5F;
      }

      if (c45822.thePlayer.moveForward > 0.0F) {
         var5 = 0.5F;
      }

      if (c45822.thePlayer.moveStrafing > 0.0F) {
         var4 -= 90.0F * var5;
      }

      if (c45822.thePlayer.moveStrafing < 0.0F) {
         var4 += 90.0F * var5;
      }

      return Math.toRadians((double)var4);
   }

   public static double c65593() {
      return c85690(c45822.thePlayer.rotationYaw, c45822.thePlayer.moveForward, c45822.thePlayer.moveStrafing);
   }

   public static double c73673(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = var0;
      if (var2 < 0.0F) {
         var4 = var0 + 180.0F;
      }

      float var5 = 1.0F;
      if (var2 < 0.0F) {
         var5 = -0.5F;
      }

      if (var2 > 0.0F) {
         var5 = 0.5F;
      }

      if (var1 > 0.0F) {
         var4 -= 90.0F * var5;
      }

      if (var1 < 0.0F) {
         var4 += 90.0F * var5;
      }

      return Math.toRadians((double)var4);
   }

   public static float c6953() {
      Value.c27574();
      float var1 = c45822.thePlayer.rotationYaw;
      float var2 = 45.0F;
      if (c45822.thePlayer.moveForward < 0.0F) {
         var2 = -45.0F;
         var1 += 180.0F;
      }

      if (c45822.thePlayer.moveStrafing > 0.0F) {
         var1 -= var2;
         if (c45822.thePlayer.moveForward != 0.0F) {
            return var1;
         }

         var1 -= 45.0F;
      }

      if (c45822.thePlayer.moveStrafing < 0.0F) {
         var1 += var2;
         if (c45822.thePlayer.moveForward == 0.0F) {
            var1 += 45.0F;
         }
      }

      return var1;
   }

   public static double c99446() {
      Value.c27574();
      float var1 = c45822.thePlayer.rotationYaw;
      if (c45822.thePlayer.moveForward < 0.0F) {
         var1 += 180.0F;
      }

      float var2 = 1.0F;
      if (c45822.thePlayer.moveForward < 0.0F) {
         var2 = -0.5F;
      }

      if (c45822.thePlayer.moveForward > 0.0F) {
         var2 = 0.5F;
      }

      if (c45822.thePlayer.moveStrafing > 0.0F) {
         var1 -= 90.0F * var2;
      }

      if (c45822.thePlayer.moveStrafing < 0.0F) {
         var1 += 90.0F * var2;
      }

      return Math.toRadians((double)var1);
   }

   public static float c60455(float var0, float var1, float var2) {
      Module[] var3 = Value.c27574();
      if (var0 == 0.0F && var1 == 0.0F) {
         return var2;
      } else {
         boolean var4 = var0 < 0.0F;
         float var5 = 90.0F * (var0 > 0.0F ? 0.5F : (var4 ? -0.5F : 1.0F));
         if (var4) {
            var2 += 180.0F;
         }

         if (var1 > 0.0F) {
            var2 -= var5;
         }

         if (var1 < 0.0F) {
            var2 += var5;
         }

         return var2;
      }
   }

   public static boolean c91714() {
      Value.c27574();
      double var1 = c45822.thePlayer.posY;
      if (var1 > 0.0D) {
         if (!(c45822.theWorld.getBlockState(new BlockPos(c45822.thePlayer.posX, var1, c45822.thePlayer.posZ)).getBlock() instanceof BlockAir)) {
            return false;
         }

         --var1;
      }

      return true;
   }

   public final void c49200() {
      c29437((double)c29122());
   }

   public static boolean c23027() {
      Module[] var0 = Value.c27574();
      return c45822.thePlayer != null && (c45822.thePlayer.movementInput.moveForward != 0.0F || c45822.thePlayer.movementInput.moveStrafe != 0.0F);
   }

   public static float c29122() {
      return (float)Math.sqrt(c45822.thePlayer.motionX * c45822.thePlayer.motionX + c45822.thePlayer.motionZ * c45822.thePlayer.motionZ);
   }

   public static double c58098() {
      double var0 = 0.2875D;
      if (c45822.thePlayer.isPotionActive(Potion.moveSpeed)) {
         var0 *= 1.0D + 0.2D * (double)(c45822.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
      }

      return var0;
   }

   public static double c44981(double var0, double var2, double var4) {
      Value.c27574();
      c52318.clear();
      c52318.add(Double.valueOf(var2 - var2 / 159.9999985D));
      c52318.add(Double.valueOf(var2 - (var0 - var2) / 33.3D));
      double var7 = c45822.thePlayer.isInWater() ? 0.8899999856948853D : (c45822.thePlayer.isInLava() ? 0.5350000262260437D : 0.9800000190734863D);
      c52318.add(Double.valueOf(var2 - var4 * (1.0D - var7)));
      return ((Double)Collections.min(c52318)).doubleValue();
   }

   public static final double c6665(boolean var0) {
      float var2 = c45822.thePlayer.rotationYawHead;
      Value.c27574();
      float var3 = 1.0F;
      double var4 = (double)c45822.thePlayer.movementInput.moveForward;
      double var6 = (double)c45822.thePlayer.movementInput.moveStrafe;
      float var8 = c45822.thePlayer.rotationYaw;
      if (var4 < 0.0D) {
         var2 += 180.0F;
      }

      if (var4 < 0.0D) {
         var3 = -0.5F;
      }

      if (var4 > 0.0D) {
         var3 = 0.5F;
      }

      if (var6 > 0.0D) {
         var2 -= 90.0F * var3;
      }

      if (var6 < 0.0D) {
         var2 += 90.0F * var3;
      }

      return Math.toRadians((double)var2);
   }

   public static boolean c58323(double var0) {
      double var3 = Math.min(c45822.thePlayer.posX - var0, c45822.thePlayer.posX + var0);
      double var5 = Math.min(c45822.thePlayer.posY, c45822.thePlayer.posY);
      double var7 = Math.min(c45822.thePlayer.posZ - var0, c45822.thePlayer.posZ + var0);
      Value.c27574();
      double var9 = Math.max(c45822.thePlayer.posX - var0, c45822.thePlayer.posX + var0);
      double var11 = Math.max(c45822.thePlayer.posY, c45822.thePlayer.posY);
      double var13 = Math.max(c45822.thePlayer.posZ - var0, c45822.thePlayer.posZ + var0);
      int var15 = (int)var3;
      if ((double)var15 <= var9) {
         int var16 = (int)var5;
         if ((double)var16 <= var11) {
            int var17 = (int)var7;
            if ((double)var17 <= var13) {
               if (!c14344(new Vec3((double)var15, (double)var16, (double)var17)) && c14344(new Vec3((double)var15, (double)(var16 + 1), (double)var17))) {
                  return true;
               }

               ++var17;
            }

            ++var16;
         }

         ++var15;
      }

      return false;
   }

   public static boolean c14344(Vec3 var0) {
      Value.c27574();
      BlockPos var2 = new BlockPos(var0);
      return !c96976(var2) && !c96976(var2.add(0, 1, 0)) ? c443(var2.add(0, -1, 0)) : false;
   }

   private static boolean c96976(BlockPos var0) {
      Value.c27574();
      Block var2 = c45822.theWorld.getBlockState(var0).getBlock();
      return var2 instanceof BlockSlab || var2 instanceof BlockStairs || var2 instanceof BlockCactus || var2 instanceof BlockChest || var2 instanceof BlockEnderChest || var2 instanceof BlockSkull || var2 instanceof BlockPane || var2 instanceof BlockFence || var2 instanceof BlockWall || var2 instanceof BlockGlass || var2 instanceof BlockPistonBase || var2 instanceof BlockPistonExtension || var2 instanceof BlockPistonMoving || var2 instanceof BlockStainedGlass || var2 instanceof BlockTrapDoor;
   }

   private static boolean c443(BlockPos var0) {
      Value.c27574();
      Block var2 = c45822.theWorld.getBlockState(var0).getBlock();
      return !(var2 instanceof BlockFence) && !(var2 instanceof BlockWall);
   }

   public static void c59838(double var0) {
      c69851(var0, c45822.thePlayer.rotationYaw);
   }

   public static void c77649(MoveEvent var0, double var1, float var3) {
      Value.c27574();
      double var5 = (double)c45822.thePlayer.movementInput.moveForward;
      double var7 = (double)c45822.thePlayer.movementInput.moveStrafe;
      if (var5 == 0.0D && var7 == 0.0D) {
         c45822.thePlayer.motionX = var0.c49055 = 0.0D;
         c45822.thePlayer.motionZ = var0.c27627 = 0.0D;
      }

      if (var5 != 0.0D) {
         if (var7 > 0.0D) {
            var3 += (float)(var5 > 0.0D ? -45 : 45);
         }

         if (var7 < 0.0D) {
            var3 += (float)(var5 > 0.0D ? 45 : -45);
         }

         var7 = 0.0D;
         if (var5 > 0.0D) {
            var5 = 1.0D;
         }

         if (var5 < 0.0D) {
            var5 = -1.0D;
         }
      }

      c45822.thePlayer.motionX = var0.c49055 = var5 * var1 * Math.cos(Math.toRadians((double)(var3 + 90.0F))) + var7 * var1 * Math.sin(Math.toRadians((double)(var3 + 90.0F)));
      c45822.thePlayer.motionZ = var0.c27627 = var5 * var1 * Math.sin(Math.toRadians((double)(var3 + 90.0F))) - var7 * var1 * Math.cos(Math.toRadians((double)(var3 + 90.0F)));
   }

   public static void c86357(MoveEvent var0, double var1) {
      c77649(var0, var1, c45822.thePlayer.rotationYaw);
   }

   public static void c69851(double var0, float var2) {
      double var4 = (double)c45822.thePlayer.movementInput.moveForward;
      Value.c27574();
      double var6 = (double)c45822.thePlayer.movementInput.moveStrafe;
      if (var4 == 0.0D && var6 == 0.0D) {
         c45822.thePlayer.motionX = 0.0D;
         c45822.thePlayer.motionZ = 0.0D;
      }

      if (var4 != 0.0D) {
         if (var6 > 0.0D) {
            var2 += (float)(var4 > 0.0D ? -45 : 45);
         }

         if (var6 < 0.0D) {
            var2 += (float)(var4 > 0.0D ? 45 : -45);
         }

         var6 = 0.0D;
         if (var4 > 0.0D) {
            var4 = 1.0D;
         }

         if (var4 < 0.0D) {
            var4 = -1.0D;
         }
      }

      c45822.thePlayer.motionX = var4 * var0 * Math.cos(Math.toRadians((double)(var2 + 90.0F))) + var6 * var0 * Math.sin(Math.toRadians((double)(var2 + 90.0F)));
      c45822.thePlayer.motionZ = var4 * var0 * Math.sin(Math.toRadians((double)(var2 + 90.0F))) - var6 * var0 * Math.cos(Math.toRadians((double)(var2 + 90.0F)));
   }

   public static boolean c7036(double var0, double var2, double var4, double var6) {
      Value.c27574();
      double var10001 = c45822.thePlayer.posX - var0;
      var10001 = c45822.thePlayer.posY - var2;
      double var10000 = c45822.thePlayer.posZ - var4;
      double var15 = Math.sqrt(c45822.thePlayer.getDistanceSq(var0, var2, var4));
      double var19 = (double)(Math.round(var15 / var6 + 0.49999999999D) - 1L);
      double var21 = c45822.thePlayer.posX;
      double var23 = c45822.thePlayer.posY;
      double var25 = c45822.thePlayer.posZ;
      int var27 = 1;
      if ((double)var27 < var19) {
         double var28 = (var0 - c45822.thePlayer.posX) / var19;
         var21 = var21 + var28;
         double var30 = (var4 - c45822.thePlayer.posZ) / var19;
         var25 = var25 + var30;
         double var32 = (var2 - c45822.thePlayer.posY) / var19;
         var23 = var23 + var32;
         AxisAlignedBB var34 = new AxisAlignedBB(var21 - 0.3D, var23, var25 - 0.3D, var21 + 0.3D, var23 + 1.8D, var25 + 0.3D);
         if (!c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var34).isEmpty()) {
            return false;
         }

         ++var27;
      }

      return true;
   }

   public static boolean c94639(double var0) {
      Module[] var2 = Value.c27574();
      return !c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, c45822.thePlayer.getEntityBoundingBox().offset(0.0D, -var0, 0.0D)).isEmpty();
   }

   public static boolean c70029(Entity var0, double var1) {
      Module[] var3 = Value.c27574();
      return !c45822.theWorld.getCollidingBoundingBoxes(var0, var0.getEntityBoundingBox().offset(0.0D, -var1, 0.0D)).isEmpty();
   }

   public static int c92246() {
      Module[] var0 = Value.c27574();
      return c45822.thePlayer.isPotionActive(Potion.jump) ? c45822.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static int c13533() {
      Module[] var0 = Value.c27574();
      return c45822.thePlayer.isPotionActive(Potion.moveSpeed) ? c45822.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static int c40450(EntityPlayer var0) {
      Module[] var1 = Value.c27574();
      return var0.isPotionActive(Potion.moveSpeed) ? var0.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static Block c79515(EntityPlayer var0, double var1) {
      return c45822.theWorld.getBlockState(new BlockPos(var0.posX, var0.posY - var1, var0.posZ)).getBlock();
   }

   public static Block c73237(double var0, double var2, double var4) {
      EntityPlayerSP var6 = c45822.thePlayer;
      return c45822.theWorld.getBlockState(new BlockPos(var6.posX + var0, var6.posY + var2, var6.posZ + var4)).getBlock();
   }

   public static float c87548(Entity var0) {
      Module[] var1 = Value.c27574();
      if (c45822.thePlayer.isCollidedVertically && c45822.thePlayer.onGround) {
         return 0.0F;
      } else {
         float var2 = (float)var0.posY;
         if (var2 > 0.0F) {
            int[] var3 = new int[]{53, 67, 108, 109, 114, 128, 134, 135, 136, 156, 163, 164, 180};
            int[] var4 = new int[]{6, 27, 28, 30, 31, 32, 37, 38, 39, 40, 50, 51, 55, 59, 63, 65, 66, 68, 69, 70, 72, 75, 76, 77, 83, 92, 93, 94, 104, 105, 106, 115, 119, 131, 132, 143, 147, 148, 149, 150, 157, 171, 175, 176, 177};
            Block var5 = c45822.theWorld.getBlockState(new BlockPos(var0.posX, (double)(var2 - 1.0F), var0.posZ)).getBlock();
            if (!(var5 instanceof BlockAir)) {
               if (Block.getIdFromBlock(var5) != 44 && Block.getIdFromBlock(var5) != 126) {
                  int var7 = var3.length;
                  int var8 = 0;
                  if (var8 < var7) {
                     int var9 = var3[var8];
                     if (Block.getIdFromBlock(var5) == var9) {
                        return (float)(var0.posY - (double)var2 - 1.0D) < 0.0F ? 0.0F : (float)(var0.posY - (double)var2 - 1.0D);
                     }

                     ++var8;
                  }

                  var7 = var4.length;
                  var8 = 0;
                  if (var8 < var7) {
                     int var15 = var4[var8];
                     if (Block.getIdFromBlock(var5) == var15) {
                        return (float)(var0.posY - (double)var2) < 0.0F ? 0.0F : (float)(var0.posY - (double)var2);
                     }

                     ++var8;
                  }

                  return (float)(var0.posY - (double)var2 + var5.getBlockBoundsMaxY() - 1.0D);
               }

               return (float)(var0.posY - (double)var2 - 0.5D) < 0.0F ? 0.0F : (float)(var0.posY - (double)var2 - 0.5D);
            }

            --var2;
         }

         return 0.0F;
      }
   }

   public static float[] c23826(BlockPos var0, EnumFacing var1) {
      double var3 = (double)var0.getX() + 0.5D - c45822.thePlayer.posX + (double)var1.getFrontOffsetX() / 2.0D;
      Value.c27574();
      double var5 = (double)var0.getZ() + 0.5D - c45822.thePlayer.posZ + (double)var1.getFrontOffsetZ() / 2.0D;
      double var7 = (double)var0.getY() + 0.5D;
      double var9 = c45822.thePlayer.posY + (double)c45822.thePlayer.getEyeHeight() - var7;
      double var11 = (double)MathHelper.sqrt_double(var3 * var3 + var5 * var5);
      float var13 = (float)(Math.atan2(var5, var3) * 180.0D / 3.141592653589793D) - 90.0F;
      float var14 = (float)(Math.atan2(var9, var11) * 180.0D / 3.141592653589793D);
      if (var13 < 0.0F) {
         var13 += 360.0F;
      }

      return new float[]{var13, var14};
   }

   public static boolean c11193() {
      Value.c27574();
      AxisAlignedBB var1 = new AxisAlignedBB(c45822.thePlayer.posX - 0.3D, c45822.thePlayer.posY + (double)c45822.thePlayer.getEyeHeight(), c45822.thePlayer.posZ + 0.3D, c45822.thePlayer.posX + 0.3D, c45822.thePlayer.posY + 2.5D, c45822.thePlayer.posZ - 0.3D);
      return !c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var1).isEmpty();
   }

   public static boolean c8409(double var0) {
      Value.c27574();
      AxisAlignedBB var3 = new AxisAlignedBB(c45822.thePlayer.posX - 0.3D, c45822.thePlayer.posY + 2.0D, c45822.thePlayer.posZ + 0.3D, c45822.thePlayer.posX + 0.3D, c45822.thePlayer.posY + 3.0D, c45822.thePlayer.posZ - 0.3D);
      if (!c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(0.3D + var0, 0.0D, 0.0D)).isEmpty()) {
         return true;
      } else if (!c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(-0.3D - var0, 0.0D, 0.0D)).isEmpty()) {
         return true;
      } else if (!c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(0.0D, 0.0D, 0.3D + var0)).isEmpty()) {
         return true;
      } else {
         return !c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(0.0D, 0.0D, -0.3D - var0)).isEmpty();
      }
   }

   public static boolean c62125(double var0) {
      Value.c27574();
      AxisAlignedBB var3 = new AxisAlignedBB(c45822.thePlayer.posX - 0.3D, c45822.thePlayer.posY + 0.5D, c45822.thePlayer.posZ + 0.3D, c45822.thePlayer.posX + 0.3D, c45822.thePlayer.posY + 1.9D, c45822.thePlayer.posZ - 0.3D);
      if (!c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(0.3D + var0, 0.0D, 0.0D)).isEmpty()) {
         return true;
      } else if (!c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(-0.3D - var0, 0.0D, 0.0D)).isEmpty()) {
         return true;
      } else if (!c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(0.0D, 0.0D, 0.3D + var0)).isEmpty()) {
         return true;
      } else {
         return !c45822.theWorld.getCollidingBoundingBoxes(c45822.thePlayer, var3.offset(0.0D, 0.0D, -0.3D - var0)).isEmpty();
      }
   }

   public static void c53860(double var0) {
      if (PlayerUtil.c71257()) {
         double var2 = c99446();
         c45822.thePlayer.motionX = -Math.sin(var2) * var0;
         c45822.thePlayer.motionZ = Math.cos(var2) * var0;
      }

   }

   private static JSONException c21777(JSONException var0) {
      return var0;
   }
}
