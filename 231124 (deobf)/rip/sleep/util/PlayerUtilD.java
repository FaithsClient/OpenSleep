package rip.sleep.util;

import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAnvilBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import rip.sleep.event.events.MoveEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class PlayerUtilD {
   private static final Minecraft c44300 = Minecraft.getMinecraft();

   public static double c34428() {
      Value.c27574();
      double var1 = 0.2873D;
      if (c44300.thePlayer.isPotionActive(Potion.moveSpeed)) {
         int var3 = c44300.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         var1 *= 1.0D + 0.2D * (double)(var3 + 1);
      }

      return var1;
   }

   public static boolean c82743(double var0) {
      return c27425(var0, true);
   }

   public static boolean c27425(double var0, boolean var2) {
      Module[] var3 = Value.c27574();
      if (var2) {
         int var4 = 0;
         if ((double)var4 < var0) {
            AxisAlignedBB var5 = c44300.thePlayer.getEntityBoundingBox().offset(0.0D, (double)(-var4), 0.0D);
            if (!c44300.theWorld.getCollidingBoundingBoxes(c44300.thePlayer, var5).isEmpty()) {
               return true;
            }

            var4 = var4 + 2;
         }
      }

      int var7 = 0;
      if ((double)var7 < var0) {
         if (c15285(0.0D, (double)(-var7), 0.0D).isFullBlock()) {
            return true;
         }

         ++var7;
      }

      return false;
   }

   public static boolean c22129() {
      return c82743(c44300.thePlayer.posY + (double)c44300.thePlayer.getEyeHeight());
   }

   public static boolean c80810(Entity var0) {
      Module[] var1 = Value.c27574();
      if (var0.posY < 0.0D) {
         return false;
      } else {
         int var2 = 0;
         if (var2 < (int)var0.posY + 2) {
            AxisAlignedBB var3 = var0.getEntityBoundingBox().offset(0.0D, (double)(-var2), 0.0D);
            if (!c44300.theWorld.getCollidingBoundingBoxes(var0, var3).isEmpty()) {
               return true;
            }

            var2 = var2 + 2;
         }

         return false;
      }
   }

   public static boolean c94197(Entity var0) {
      return c44300.theWorld.getBlockState(new BlockPos(var0.posX, var0.posY - 1.0D, var0.posZ)).getBlock() == Blocks.air;
   }

   public static void c22594(double var0) {
      Value.c27574();
      double var3 = (double)c44300.thePlayer.movementInput.moveForward;
      double var5 = (double)c44300.thePlayer.movementInput.moveStrafe;
      float var7 = c44300.thePlayer.rotationYaw;
      if (var3 != 0.0D) {
         if (var5 > 0.0D) {
            var7 += (float)(var3 > 0.0D ? -45 : 45);
         }

         if (var5 < 0.0D) {
            var7 += (float)(var3 > 0.0D ? 45 : -45);
         }

         var5 = 0.0D;
         if (var3 > 0.0D) {
            var3 = 1.0D;
         }

         if (var3 < 0.0D) {
            var3 = -1.0D;
         }
      }

      double var8 = Math.cos(Math.toRadians((double)(var7 + 90.0F)));
      double var10 = Math.sin(Math.toRadians((double)(var7 + 90.0F)));
      double var12 = var3 * var0 * var8 + var5 * var0 * var10;
      double var14 = var3 * var0 * var10 - var5 * var0 * var8;
      c44300.thePlayer.setPosition(c44300.thePlayer.posX + var12, c44300.thePlayer.posY, c44300.thePlayer.posZ + var14);
   }

   public static void c46133() {
      Module[] var0 = Value.c27574();
      if (c15426()) {
         float var1 = c44300.thePlayer.rotationYaw;
         if (c44300.thePlayer.moveForward < 0.0F) {
            var1 += 180.0F;
         }

         float var2 = 1.0F;
         if (c44300.thePlayer.moveForward < 0.0F) {
            var2 = -0.5F;
         }

         if (c44300.thePlayer.moveForward > 0.0F) {
            var2 = 0.5F;
         }

         if (c44300.thePlayer.moveStrafing > 0.0F) {
            var1 -= 90.0F * var2;
         }

         if (c44300.thePlayer.moveStrafing < 0.0F) {
            var1 += 90.0F * var2;
         }

         double var3 = Math.toRadians((double)var1);
         float var5 = (float)Math.sqrt(c44300.thePlayer.motionX * c44300.thePlayer.motionX + c44300.thePlayer.motionZ * c44300.thePlayer.motionZ);
         c44300.thePlayer.motionX = -Math.sin(var3) * (double)var5;
         c44300.thePlayer.motionZ = Math.cos(var3) * (double)var5;
      }
   }

   public static void c46640(double var0) {
      Module[] var2 = Value.c27574();
      if (c15426()) {
         float var3 = c44300.thePlayer.rotationYaw;
         if (c44300.thePlayer.moveForward < 0.0F) {
            var3 += 180.0F;
         }

         float var4 = 1.0F;
         if (c44300.thePlayer.moveForward < 0.0F) {
            var4 = -0.5F;
         }

         if (c44300.thePlayer.moveForward > 0.0F) {
            var4 = 0.5F;
         }

         if (c44300.thePlayer.moveStrafing > 0.0F) {
            var3 -= 90.0F * var4;
         }

         if (c44300.thePlayer.moveStrafing < 0.0F) {
            var3 += 90.0F * var4;
         }

         double var5 = Math.toRadians((double)var3);
         float var7 = (float)Math.sqrt(c44300.thePlayer.motionX * c44300.thePlayer.motionX + c44300.thePlayer.motionZ * c44300.thePlayer.motionZ);
         c44300.thePlayer.motionX = -Math.sin(var5) * var0;
         c44300.thePlayer.motionZ = Math.cos(var5) * var0;
      }
   }

   public static boolean c15426() {
      Module[] var0 = Value.c27574();
      return c44300.gameSettings.keyBindForward.isKeyDown() || c44300.gameSettings.keyBindLeft.isKeyDown() || c44300.gameSettings.keyBindRight.isKeyDown() || c44300.gameSettings.keyBindBack.isKeyDown();
   }

   public static boolean c92743(double var0) {
      Module[] var2 = Value.c27574();
      return !c44300.theWorld.getCollidingBoundingBoxes(c44300.thePlayer, c44300.thePlayer.getEntityBoundingBox().offset(0.0D, -var0, 0.0D)).isEmpty();
   }

   public static boolean c81787(double var0, Entity var2) {
      Module[] var3 = Value.c27574();
      return !c44300.theWorld.getCollidingBoundingBoxes(var2, var2.getEntityBoundingBox().offset(0.0D, -var0, 0.0D)).isEmpty();
   }

   public static int c29915() {
      Module[] var0 = Value.c27574();
      return c44300.thePlayer.isPotionActive(Potion.jump) ? c44300.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static int c6875() {
      Module[] var0 = Value.c27574();
      return c44300.thePlayer.isPotionActive(Potion.moveSpeed) ? c44300.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static boolean c84765(Item var0) {
      Module[] var1 = Value.c27574();
      return !(var0 instanceof ItemSword) && !(var0 instanceof ItemBow);
   }

   public static boolean c90302() {
      Value.c27574();
      int var1 = MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().minX);
      if (var1 < MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().maxX) + 1) {
         int var2 = MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().minY);
         if (var2 < MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().maxY) + 1) {
            int var3 = MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().minZ);
            if (var3 < MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().maxZ) + 1) {
               Block var4 = c44300.theWorld.getBlockState(new BlockPos(var1, var2, var3)).getBlock();
               if (!(var4 instanceof BlockAir)) {
                  AxisAlignedBB var5 = var4.getCollisionBoundingBox(c44300.theWorld, new BlockPos(var1, var2, var3), c44300.theWorld.getBlockState(new BlockPos(var1, var2, var3)));
                  if (var4 instanceof BlockHopper) {
                     var5 = new AxisAlignedBB((double)var1, (double)var2, (double)var3, (double)(var1 + 1), (double)(var2 + 1), (double)(var3 + 1));
                  }

                  if (var5 != null && c44300.thePlayer.getEntityBoundingBox().intersectsWith(var5)) {
                     return true;
                  }
               }

               ++var3;
            }

            ++var2;
         }

         ++var1;
      }

      return false;
   }

   public static boolean c64388(EntityPlayer var0) {
      Value.c27574();
      int var2 = MathHelper.floor_double(var0.getEntityBoundingBox().minX);
      if (var2 < MathHelper.floor_double(var0.getEntityBoundingBox().maxX) + 1) {
         int var3 = MathHelper.floor_double(var0.getEntityBoundingBox().minY);
         if (var3 < MathHelper.floor_double(var0.getEntityBoundingBox().maxY) + 1) {
            int var4 = MathHelper.floor_double(var0.getEntityBoundingBox().minZ);
            if (var4 < MathHelper.floor_double(var0.getEntityBoundingBox().maxZ) + 1) {
               Block var5 = c44300.theWorld.getBlockState(new BlockPos(var2, var3, var4)).getBlock();
               if (!(var5 instanceof BlockAir)) {
                  AxisAlignedBB var6 = var5.getCollisionBoundingBox(c44300.theWorld, new BlockPos(var2, var3, var4), c44300.theWorld.getBlockState(new BlockPos(var2, var3, var4)));
                  if (var5 instanceof BlockHopper) {
                     var6 = new AxisAlignedBB((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)(var3 + 1), (double)(var4 + 1));
                  }

                  if (var6 != null && var0.getEntityBoundingBox().intersectsWith(var6)) {
                     return true;
                  }
               }

               ++var4;
            }

            ++var3;
         }

         ++var2;
      }

      return false;
   }

   public static boolean c89195() {
      Module[] var0 = Value.c27574();
      if (c44300.thePlayer.isInWater()) {
         return true;
      } else {
         boolean var1 = false;
         int var2 = (int)c44300.thePlayer.getEntityBoundingBox().minY;
         int var3 = MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().minX);
         if (var3 < MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().maxX) + 1) {
            int var4 = MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().minZ);
            if (var4 < MathHelper.floor_double(c44300.thePlayer.getEntityBoundingBox().maxZ) + 1) {
               Block var5 = c44300.theWorld.getBlockState(new BlockPos(var3, var2, var4)).getBlock();
               if (var5.getMaterial() != Material.air) {
                  if (!(var5 instanceof BlockLiquid)) {
                     return false;
                  }

                  var1 = true;
               }

               ++var4;
            }

            ++var3;
         }

         return var1;
      }
   }

   public static boolean c65882() {
      Value.c27574();
      AxisAlignedBB var1 = c44300.thePlayer.getEntityBoundingBox();
      if (var1 == null) {
         return false;
      } else {
         var1 = var1.contract(0.01D, 0.0D, 0.01D).offset(0.0D, -0.01D, 0.0D);
         boolean var2 = false;
         int var3 = (int)var1.minY;
         int var4 = MathHelper.floor_double(var1.minX);
         if (var4 < MathHelper.floor_double(var1.maxX + 1.0D)) {
            int var5 = MathHelper.floor_double(var1.minZ);
            if (var5 < MathHelper.floor_double(var1.maxZ + 1.0D)) {
               Block var6 = c44300.theWorld.getBlockState(new BlockPos(var4, var3, var5)).getBlock();
               if (var6 != Blocks.air) {
                  if (!(var6 instanceof BlockLiquid)) {
                     return false;
                  }

                  var2 = true;
               }

               ++var5;
            }

            ++var4;
         }

         return var2;
      }
   }

   public static boolean c43819(double var0) {
      boolean var2 = c44300.theWorld.getBlockState(new BlockPos(c44300.thePlayer.posX, c44300.thePlayer.posY - var0, c44300.thePlayer.posZ)).getBlock().getMaterial().isLiquid();
      return var2;
   }

   public static boolean c57202(double var0) {
      Value.c27574();
      double var3 = c44300.thePlayer.getEntityBoundingBox().minX;
      if (var3 < c44300.thePlayer.getEntityBoundingBox().maxX) {
         double var5 = c44300.thePlayer.getEntityBoundingBox().minZ;
         if (var5 < c44300.thePlayer.getEntityBoundingBox().maxZ) {
            Block var7 = c44300.theWorld.getBlockState(new BlockPos(var3, c44300.thePlayer.posY - var0, var5)).getBlock();
            if (!(var7 instanceof BlockLiquid) && !(var7 instanceof BlockAir)) {
               return false;
            }

            var5 = var5 + 0.009999999776482582D;
         }

         var3 = var3 + 0.009999999776482582D;
      }

      return true;
   }

   public static void c64561(MoveEvent var0, double var1) {
      float var4 = c44300.thePlayer.rotationYaw;
      Value.c27574();
      double var5 = (double)c44300.thePlayer.movementInput.moveForward;
      double var7 = (double)c44300.thePlayer.movementInput.moveStrafe;
      if (var5 == 0.0D && var7 == 0.0D) {
         var0.c97676(0.0D);
         var0.c90383(0.0D);
      }

      if (var5 != 0.0D) {
         if (var7 > 0.0D) {
            var4 += (float)(var5 > 0.0D ? -45 : 45);
         }

         if (var7 < 0.0D) {
            var4 += (float)(var5 > 0.0D ? 45 : -45);
         }

         var7 = 0.0D;
         var5 = var5 > 0.0D ? 1.0D : -1.0D;
      }

      var0.c97676(var5 * var1 * Math.cos(Math.toRadians((double)var4 + 87.88867D)) + var7 * var1 * Math.sin(Math.toRadians((double)var4 + 87.88867D)));
      var0.c90383(var5 * var1 * Math.sin(Math.toRadians((double)var4 + 87.88867D)) - var7 * var1 * Math.cos(Math.toRadians((double)var4 + 87.88867D)));
   }

   public static void c38080(double var0) {
      Value.c27574();
      float var3 = c44300.thePlayer.rotationYaw;
      double var4 = (double)c44300.thePlayer.movementInput.moveForward;
      double var6 = (double)c44300.thePlayer.movementInput.moveStrafe;
      if (var4 == 0.0D && var6 == 0.0D) {
         c44300.thePlayer.motionX = 0.0D;
         c44300.thePlayer.motionZ = 0.0D;
      }

      if (var4 != 0.0D) {
         if (var6 > 0.0D) {
            var3 += (float)(var4 > 0.0D ? -45 : 45);
         }

         if (var6 < 0.0D) {
            var3 += (float)(var4 > 0.0D ? 45 : -45);
         }

         var6 = 0.0D;
         var4 = var4 > 0.0D ? 1.0D : -1.0D;
      }

      c44300.thePlayer.motionX = var4 * var0 * Math.cos(Math.toRadians((double)(var3 + 90.0F))) + var6 * var0 * Math.sin(Math.toRadians((double)(var3 + 90.0F)));
      c44300.thePlayer.motionZ = var4 * var0 * Math.sin(Math.toRadians((double)(var3 + 90.0F))) - var6 * var0 * Math.cos(Math.toRadians((double)(var3 + 90.0F)));
   }

   public static double c69686() {
      double var0 = c44300.thePlayer.posX - c44300.thePlayer.prevPosX;
      double var2 = c44300.thePlayer.posZ - c44300.thePlayer.prevPosZ;
      return Math.sqrt(var0 * var0 + var2 * var2);
   }

   public static double c32050(Entity var0) {
      double var1 = var0.posX - var0.prevPosX;
      double var3 = var0.posZ - var0.prevPosZ;
      return Math.sqrt(var1 * var1 + var3 * var3);
   }

   public static double c35932() {
      double var0 = c69686() * 20.0D;
      return ((double)((int)var0) + var0 - (double)((int)var0)) * (double) ChatUtilA.c14057().timerSpeed;
   }

   public static double c89248(Entity var0) {
      double var1 = c32050(var0) * 20.0D;
      return (double)((int)var1) + var1 - (double)((int)var1);
   }

   public static RotationUtilE c83813(double var0, double var2, double var4) {
      double var6 = var0 - c44300.thePlayer.posX;
      double var8 = var2 - c44300.thePlayer.posY - 1.2D;
      double var10 = var4 - c44300.thePlayer.posZ;
      double var12 = Math.hypot(var6, var10);
      float var14 = (float)(Math.atan2(var10, var6) * 180.0D / 3.141592653589793D) - 90.0F;
      float var15 = (float)(-(Math.atan2(var8, var12) * 180.0D / 3.141592653589793D));
      return new RotationUtilE(var14, var15);
   }

   public static RotationUtilE c26423(EntityLivingBase var0) {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();
      double var2 = var1.nextDouble(-0.05D, 0.1D);
      double var4 = var1.nextDouble(-0.05D, 0.1D);
      double var6 = var0.posX + var2;
      double var8 = var0.posY + (double)var0.getEyeHeight() / 2.05D + var4;
      double var10 = var0.posZ + var2;
      return c83813(var6, var8, var10);
   }

   public static float c29863() {
      Value.c27574();
      float var1 = 0.2873F;
      if (Minecraft.getMinecraft().thePlayer.isPotionActive(Potion.moveSpeed)) {
         int var2 = Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         var1 *= 1.0F + 0.2F * (float)(var2 + 1);
      }

      return var1;
   }

   public static double c50073() {
      Value.c27574();
      float var1 = c44300.thePlayer.rotationYaw;
      if (c44300.thePlayer.moveForward < 0.0F) {
         var1 += 180.0F;
      }

      float var2 = 1.0F;
      if (c44300.thePlayer.moveForward < 0.0F) {
         var2 = -0.5F;
      }

      if (c44300.thePlayer.moveForward > 0.0F) {
         var2 = 0.5F;
      }

      if (c44300.thePlayer.moveStrafing > 0.0F) {
         var1 -= 90.0F * var2;
      }

      if (c44300.thePlayer.moveStrafing < 0.0F) {
         var1 += 90.0F * var2;
      }

      return Math.toRadians((double)var1);
   }

   public static Block c24850(double var0, double var2, double var4) {
      return c44300.theWorld.getBlockState(new BlockPos(var0, var2, var4)).getBlock();
   }

   public static void c68600(double[] param0, BlockPos param1, double param2, double[] param4) {
      // $FF: Couldn't be decompiled
   }

   public static int c20530() {
      Value.c27574();
      int var1 = 36;
      if (var1 < 45) {
         ItemStack var2 = c44300.thePlayer.inventoryContainer.getSlot(var1).getStack();
         if (var2.getDisplayName().contains("Head") && var2.stackSize > 0) {
            return var1;
         }

         ++var1;
      }

      return -1;
   }

   public static Block c30831(double var0, double var2, double var4) {
      return c44300.theWorld.getBlockState(new BlockPos(c44300.thePlayer.posX + var0, c44300.thePlayer.posY + var2, c44300.thePlayer.posZ + var4)).getBlock();
   }

   public static boolean c45227() {
      return c44300.theWorld.getBlockState(new BlockPos(c44300.thePlayer.posX, c44300.thePlayer.posY, c44300.thePlayer.posZ)).getBlock().getMaterial() == Material.water;
   }

   public static Block c15285(double var0, double var2, double var4) {
      return c44300.theWorld.getBlockState((new BlockPos(c44300.thePlayer)).add(var0, var2, var4)).getBlock();
   }

   public static void c66495(int var0, boolean var1) {
      Module[] var2 = Value.c27574();
      int var3 = var0 == 0 ? c44300.gameSettings.keyBindAttack.getKeyCode() : c44300.gameSettings.keyBindUseItem.getKeyCode();
      KeyBinding.setKeyBindState(var3, var1);
      if (var1) {
         KeyBinding.onTick(var3);
      }

   }

   public static Block c95095(BlockPos var0) {
      return c44300.theWorld.getBlockState(var0).getBlock();
   }

   public static Block c50581(double var0, double var2, double var4) {
      return c44300.theWorld.getBlockState(new BlockPos(var0, var2, var4)).getBlock();
   }

   public static boolean c38575(Item var0) {
      Module[] var1 = Value.c27574();
      return var0 instanceof ItemAnvilBlock || var0.getUnlocalizedName().contains("sand") || var0.getUnlocalizedName().contains("gravel") || var0.getUnlocalizedName().contains("ladder") || var0.getUnlocalizedName().contains("tnt") || var0.getUnlocalizedName().contains("chest") || var0.getUnlocalizedName().contains("web");
   }

   private static Exception c29249(Exception var0) {
      return var0;
   }
}
