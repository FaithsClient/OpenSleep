package rip.sleep.util;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.vecmath.Vector2f;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.MoveEvent;
import rip.sleep.module.modules.KillAura;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class PlayerUtil {
   private static final Minecraft c67534 = Minecraft.getMinecraft();
   public static final double c48967 = 0.41999998688698D;
   public static final float c10412 = c39880(6.283185307179586D);
   public static final float c77597 = c42018(0.017453292519943295D);

   public static void c25906(MoveEvent var0, double var1, float var3, double var4, double var6) {
      Value.c27574();
      double var9 = var6;
      double var11 = var4;
      float var13 = var3;
      if (var6 == 0.0D && var4 == 0.0D) {
         var0.c90383(0.0D);
         var0.c97676(0.0D);
      }

      if (var6 != 0.0D) {
         if (var4 > 0.0D) {
            var13 = var3 + (float)(var6 > 0.0D ? -45 : 45);
         }

         if (var4 < 0.0D) {
            var13 += (float)(var6 > 0.0D ? 45 : -45);
         }

         var11 = 0.0D;
         if (var6 > 0.0D) {
            var9 = 1.0D;
         }

         if (var9 < 0.0D) {
            var9 = -1.0D;
         }
      }

      double var14 = Math.cos(Math.toRadians((double)(var13 + 90.0F)));
      double var16 = Math.sin(Math.toRadians((double)(var13 + 90.0F)));
      var0.c97676(var9 * var1 * var14 + var11 * var1 * var16);
      var0.c90383(var9 * var1 * var16 - var11 * var1 * var14);
   }

   public static void c80120(MoveEvent var0, double var1, double var3, double var5) {
      Value.c27574();
      double var8 = var3;
      double var10 = (double)c67534.thePlayer.movementInput.moveStrafe;
      float var12 = c67534.thePlayer.rotationYaw;
      if (var3 == 0.0D && var10 == 0.0D) {
         var0.c90383(0.0D);
         var0.c97676(0.0D);
      }

      if (var3 != 0.0D) {
         if (var10 > 0.0D) {
            var12 += (float)(var3 > 0.0D ? -45 : 45);
         }

         if (var10 < 0.0D) {
            var12 += (float)(var3 > 0.0D ? 45 : -45);
         }

         var10 = 0.0D;
         if (var3 > 0.0D) {
            var8 = 1.0D;
         }

         if (var8 < 0.0D) {
            var8 = -1.0D;
         }
      }

      double var13 = Math.cos(Math.toRadians((double)(var12 + 90.0F)));
      double var15 = Math.sin(Math.toRadians((double)(var12 + 90.0F)));
      var0.c97676((var8 * var1 * var13 + var10 * var1 * var15) * var5);
      var0.c90383((var8 * var1 * var15 - var10 * var1 * var13) * var5);
   }

   public static void c30474(MotionUpdateEvent var0, double var1, float var3, double var4, double var6) {
      Value.c27574();
      double var9 = var6;
      double var11 = var4;
      float var13 = var3;
      if (var6 == 0.0D && var4 == 0.0D) {
         var0.c90383(0.0D);
         var0.c97676(0.0D);
      }

      if (var6 != 0.0D) {
         if (var4 > 0.0D) {
            var13 = var3 + (float)(var6 > 0.0D ? -45 : 45);
         }

         if (var4 < 0.0D) {
            var13 += (float)(var6 > 0.0D ? 45 : -45);
         }

         var11 = 0.0D;
         if (var6 > 0.0D) {
            var9 = 1.0D;
         }

         if (var9 < 0.0D) {
            var9 = -1.0D;
         }
      }

      double var14 = Math.cos(Math.toRadians((double)(var13 + 90.0F)));
      double var16 = Math.sin(Math.toRadians((double)(var13 + 90.0F)));
      var0.c97676(var9 * var1 * var14 + var11 * var1 * var16);
      var0.c90383(var9 * var1 * var16 - var11 * var1 * var14);
   }

   public static boolean c24484() {
      Module[] var0 = Value.c27574();
      return !(c67534.theWorld.getBlockState(new BlockPos(c67534.thePlayer.posX, c67534.thePlayer.getEntityBoundingBox().maxY + 0.41999998688697815D, c67534.thePlayer.posZ)).getBlock() instanceof BlockAir);
   }

   public static void c95079(double var0, double var2, double var4) {
      c67534.thePlayer.setPosition(c67534.thePlayer.posX + var0, c67534.thePlayer.posY + var2, c67534.thePlayer.posZ + var4);
   }

   public static double c53121(double var0) {
      double var2 = var0;
      if (c67534.thePlayer.isPotionActive(Potion.moveSpeed)) {
         var2 = var0 * (1.0D + 0.2D * (double)(c67534.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1));
      }

      return var2;
   }

   public static double c52427(double var0) {
      Module[] var2 = Value.c27574();
      if (c67534.thePlayer.isPotionActive(Potion.jump)) {
         int var3 = c67534.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
         var0 += (double)((float)(var3 + 1) * 0.1F);
      }

      return var0;
   }

   public static boolean c59000() {
      Module[] var0 = Value.c27574();
      return c67534.thePlayer.onGround && c67534.thePlayer.isCollidedVertically;
   }

   public static boolean c71257() {
      Module[] var0 = Value.c27574();
      return c67534.thePlayer.moveForward != 0.0F || c67534.thePlayer.moveStrafing != 0.0F;
   }

   public static boolean c20675(EntityLivingBase var0) {
      Module[] var1 = Value.c27574();
      return var0.moveForward != 0.0F || var0.moveStrafing != 0.0F;
   }

   public static boolean c30408(double var0) {
      Module[] var2 = Value.c27574();
      return !c67534.theWorld.getCollidingBoundingBoxes(c67534.thePlayer, c67534.thePlayer.getEntityBoundingBox().offset(0.0D, -var0, 0.0D)).isEmpty();
   }

   public static int c94609() {
      Module[] var0 = Value.c27574();
      return c67534.thePlayer.isPotionActive(Potion.moveSpeed) ? c67534.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static void c29993(MoveEvent var0, double var1, double var3) {
      double var6 = (double)c67534.thePlayer.movementInput.moveForward;
      Value.c27574();
      double var8 = (double)c67534.thePlayer.movementInput.moveStrafe;
      float var10 = c67534.thePlayer.rotationYaw;
      if (var6 == 0.0D && var8 == 0.0D) {
         var0.c97676(0.0D);
         var0.c90383(0.0D);
      }

      if (var6 != 0.0D) {
         if (var8 > 0.0D) {
            var10 += (float)(var6 > 0.0D ? -45 : 45);
         }

         if (var8 < 0.0D) {
            var10 += (float)(var6 > 0.0D ? 45 : -45);
         }

         var8 = 0.0D;
         if (var6 > 0.0D) {
            var6 = 1.0D;
         }

         if (var6 < 0.0D) {
            var6 = -1.0D;
         }
      }

      double var11 = Math.sin(Math.toRadians((double)var10));
      double var13 = Math.cos(Math.toRadians((double)var10));
      var0.c97676((var6 * var1 * -var11 + var8 * var1 * var13) * var3);
      var0.c90383((var6 * var1 * var13 - var8 * var1 * -var11) * var3);
   }

   public static double c37056(double var0, double var2) {
      Value.c27574();
      Random var7 = new Random();
      double var8 = var7.nextDouble() * (var2 - var0);
      if (var8 > var2) {
         var8 = var2;
      }

      double var5;
      return (var5 = var8 + var0) <= var2 ? var5 : var2;
   }

   public static void c12666(double var0) {
      double var3 = (double)c67534.thePlayer.movementInput.moveForward;
      Value.c27574();
      double var5 = (double)c67534.thePlayer.movementInput.moveStrafe;
      double var7 = (double)c67534.thePlayer.rotationYaw;
      if (var3 == 0.0D && var5 == 0.0D) {
         c67534.thePlayer.motionX = 0.0D;
         c67534.thePlayer.motionZ = 0.0D;
      }

      if (var3 != 0.0D) {
         if (var5 > 0.0D) {
            var7 += (double)(var3 > 0.0D ? -45 : 45);
         }

         if (var5 < 0.0D) {
            var7 += (double)(var3 > 0.0D ? 45 : -45);
         }

         var5 = 0.0D;
         if (var3 > 0.0D) {
            var3 = 1.0D;
         }

         if (var3 < 0.0D) {
            var3 = -1.0D;
         }
      }

      double var9 = Math.sin(Math.toRadians(var7));
      double var11 = Math.cos(Math.toRadians(var7));
      c67534.thePlayer.motionX = var3 * var0 * -var9 + var5 * var0 * var11;
      c67534.thePlayer.motionZ = var3 * var0 * var11 - var5 * var0 * -var9;
   }

   public static int c80200() {
      Value.c27574();
      double var1 = c48832();
      if (var1 != 0.221D && var1 != 0.2873D) {
         if (var1 != 0.34476D && var1 != 0.2652D) {
            return var1 != 0.3094D && (var1 <= 0.40221D || var1 >= 0.40223D) ? -1 : 2;
         } else {
            return 1;
         }
      } else {
         return 0;
      }
   }

   public static float c24185() {
      return (float)Math.sqrt(c67534.thePlayer.motionX * c67534.thePlayer.motionX + c67534.thePlayer.motionZ * c67534.thePlayer.motionZ);
   }

   public static double c10168(double var0, boolean var2) {
      Module[] var3 = Value.c27574();
      if (c67534.thePlayer.isPotionActive(Potion.jump) && var2) {
         int var4 = c67534.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
         var0 += (double)((float)(var4 + 1) * 0.1F);
      }

      return var0;
   }

   public static boolean c61628() {
      Module[] var0 = Value.c27574();
      if (c67534.thePlayer.isInWater()) {
         return true;
      } else {
         boolean var1 = false;
         int var2 = (int)c67534.thePlayer.getEntityBoundingBox().minY;
         int var3 = MathHelper.floor_double(c67534.thePlayer.getEntityBoundingBox().minX);
         if (var3 < MathHelper.floor_double(c67534.thePlayer.getEntityBoundingBox().maxX) + 1) {
            int var4 = MathHelper.floor_double(c67534.thePlayer.getEntityBoundingBox().minZ);
            if (var4 < MathHelper.floor_double(c67534.thePlayer.getEntityBoundingBox().maxZ) + 1) {
               Block var5 = c67534.theWorld.getBlockState(new BlockPos(var3, var2, var4)).getBlock();
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

   public static double c7943(double var0) {
      Module[] var2 = Value.c27574();
      if (c61628()) {
         return 0.13499999955296516D;
      } else {
         return c67534.thePlayer.isPotionActive(Potion.jump) ? var0 + (double)(((float)c67534.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1.0F) * 0.1F) : var0;
      }
   }

   public static double c4570() {
      return c7943(0.41999998688697815D);
   }

   public static float c54490() {
      float var0 = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return var0 * var0 * var0 * 8.0F * 0.15F;
   }

   public static void c58298(MotionUpdateEvent var0) {
      Module[] var1 = Value.c27574();
      if (c71257()) {
         List var2 = Arrays.asList(0.125D, 0.25D, 0.375D, 0.625D, 0.75D, 0.015625D, 0.5D, 0.0625D, 0.875D, 0.1875D);
         double var3 = var0.c13885() % 1.0D;
         var2.sort(Comparator.comparingDouble((var2x) -> {
            return Math.abs(var2x.doubleValue() - var3);
         }));
         double var5 = var0.c13885() - var3 + ((Double)var2.get(0)).doubleValue();
         if (Math.abs(((Double)var2.get(0)).doubleValue() - var3) < 0.005D) {
            MotionUpdateEvent.c59560(var5);
            MotionUpdateEvent.c93198(true);
         }

         List var7 = Arrays.asList(0.715D, 0.945D, 0.09D, 0.155D, 0.14D, 0.045D, 0.63D, 0.31D);
         double var8 = var0.c13885() % 1.0D;
         var7.sort(Comparator.comparingDouble((var2x) -> {
            return Math.abs(var2x.doubleValue() - var8);
         }));
         var5 = var0.c13885() - var8 + ((Double)var7.get(0)).doubleValue();
         if (Math.abs(((Double)var7.get(0)).doubleValue() - var8) < 0.005D) {
            MotionUpdateEvent.c59560(var5);
         }
      }

   }

   public static void c78541(MoveEvent var0, double var1) {
      c25906(var0, var1, c67534.thePlayer.rotationYaw, (double)c67534.thePlayer.movementInput.moveStrafe, (double)c67534.thePlayer.movementInput.moveForward);
   }

   public static boolean c78108() {
      Module[] var0 = Value.c27574();
      return c67534.gameSettings.keyBindForward.isKeyDown() || c67534.gameSettings.keyBindLeft.isKeyDown() || c67534.gameSettings.keyBindRight.isKeyDown() || c67534.gameSettings.keyBindBack.isKeyDown();
   }

   public static int c25891() {
      Module[] var0 = Value.c27574();
      return c67534.thePlayer.isPotionActive(Potion.jump) ? c67534.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static boolean c57263() {
      Value.c27574();
      AxisAlignedBB var1 = c67534.thePlayer.getEntityBoundingBox();
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
               Block var6 = c67534.theWorld.getBlockState(new BlockPos(var4, var3, var5)).getBlock();
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

   public static double c48832() {
      Value.c27574();
      double var1 = 0.2873D;
      if (c67534.thePlayer.isPotionActive(Potion.moveSpeed)) {
         int var3 = c67534.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         var1 *= 1.0D + 0.2D * (double)(var3 + 1);
      }

      return var1;
   }

   public static float c39880(double var0) {
      return (float)((double)Math.round(var0 * 1.0E8D) / 1.0E8D);
   }

   public static float c63858(float var0) {
      Value.c27574();
      Vector2f var2 = new Vector2f((float)c67534.thePlayer.lastTickPosX, (float)c67534.thePlayer.lastTickPosZ);
      Vector2f var3 = new Vector2f((float)c67534.thePlayer.posX, (float)c67534.thePlayer.posZ);
      Vector2f var4 = new Vector2f(var3.x - var2.x, var3.y - var2.y);
      double var5 = (double)var4.x;
      double var7 = (double)var4.y;
      if (var5 != 0.0D || var7 != 0.0D) {
         var0 = (float)Math.toDegrees((Math.atan2(-var5, var7) + (double)c10412) % (double)c10412);
      }

      return var0;
   }

   public static float c42018(double var0) {
      return (float)((double)Math.round(var0 * 1.0E8D) / 1.0E8D);
   }

   public static double c8108() {
      return Math.sqrt(c67534.thePlayer.motionX * c67534.thePlayer.motionX + c67534.thePlayer.motionZ * c67534.thePlayer.motionZ);
   }

   public static double[] c54545(double var0) {
      return c95938(c67534.thePlayer.rotationYaw * c77597, var0);
   }

   public static double[] c95938(float var0, double var1) {
      return new double[]{(double)(-MathHelper.sin(var0)) * var1, (double)MathHelper.cos(var0) * var1};
   }

   public static double c21883() {
      Value.c27574();
      SecureRandom var1 = new SecureRandom();
      double var2 = var1.nextDouble() * (1.0D / (double)System.currentTimeMillis());
      int var4 = 0;
      if (var4 < MathUtilB.c11508(MathUtilB.c11508(4, 6), MathUtilB.c11508(8, 20))) {
         var2 *= 1.0D / (double)System.currentTimeMillis();
         ++var4;
      }

      return var2;
   }

   public static double c20474() {
      return Math.hypot(c67534.thePlayer.motionX, c67534.thePlayer.motionZ);
   }

   public static double c84530() {
      Value.c27574();
      double var1 = (double)c67534.thePlayer.rotationYaw;
      if (c67534.thePlayer.movementInput.moveForward < 0.0F) {
         var1 += 180.0D;
      }

      float var3 = 1.0F;
      if (c67534.thePlayer.movementInput.moveForward < 0.0F) {
         var3 = -0.5F;
      }

      if (c67534.thePlayer.movementInput.moveForward > 0.0F) {
         var3 = 0.5F;
      }

      if (c67534.thePlayer.movementInput.moveStrafe > 0.0F) {
         var1 -= (double)(90.0F * var3);
      }

      if (c67534.thePlayer.movementInput.moveStrafe < 0.0F) {
         var1 += (double)(90.0F * var3);
      }

      return Math.toRadians(var1);
   }

   public static boolean c8563() {
      Module[] var0 = Value.c27574();
      return c67534.thePlayer.moveForward < 0.0F;
   }

   public static void c69626(double var0) {
      c67534.thePlayer.setPosition(c67534.thePlayer.posX, c67534.thePlayer.posY + var0, c67534.thePlayer.posZ);
   }

   public static boolean c29258() {
      Value.c27574();
      int var1 = (int)c67534.thePlayer.posY;
      if (!(c67534.theWorld.getBlockState(new BlockPos(c67534.thePlayer.posX, (double)var1, c67534.thePlayer.posZ)).getBlock() instanceof BlockAir)) {
         return true;
      } else {
         --var1;
         return false;
      }
   }

   public static void c16498(float var0) {
      if (c71257()) {
         double var1 = c84530();
         c67534.thePlayer.motionX = -Math.sin(var1) * (double)var0;
         c67534.thePlayer.motionZ = Math.cos(var1) * (double)var0;
      }
   }

   public static void c5564(float var0) {
      Module[] var1 = Value.c27574();
      if (c71257()) {
         c67534.thePlayer.motionX = -Math.sin(c84530()) * (double)var0;
         c67534.thePlayer.motionZ = Math.cos(c84530()) * (double)var0;
      }
   }

   public static void c93440(float var0, double var1) {
      if (c71257()) {
         double var3 = Math.toRadians(var1);
         c67534.thePlayer.motionX = -Math.sin(var3) * (double)var0;
         c67534.thePlayer.motionZ = Math.cos(var3) * (double)var0;
      }
   }

   public static void c34805(EntityLivingBase var0, float var1, float var2, MoveEvent var3, int var4) {
      Module[] var5 = Value.c27574();
      if (c71257()) {
         double var6 = 0.0D;
         double var8 = 0.0D;
         double var10 = Math.sqrt(var3.c49055 * var3.c49055 + var3.c27627 * var3.c27627);
         if (var10 > 1.0E-4D) {
            double var12 = 0.0D;
            if ((double)var1 > 0.001D) {
               var12 = 1.0D;
            }

            if ((double)var1 < -0.001D) {
               var12 = -1.0D;
            }

            float var14 = 0.01F;
            if (var4 == 1) {
               var14 = c67534.thePlayer.getDistanceToEntity(var0);
            }

            if (var4 == 0) {
               var14 = (float)Math.sqrt((c67534.thePlayer.posX - var0.posX) * (c67534.thePlayer.posX - var0.posX) + (c67534.thePlayer.posZ - var0.posZ) * (c67534.thePlayer.posZ - var0.posZ));
            }

            if ((double)var14 < (double)var2 - var10) {
               var6 = -1.0D;
            }

            if ((double)var14 > (double)var2 + var10) {
               var6 = 1.0D;
            }

            var6 = (double)(var14 - var2) / var10;
            if ((double)var14 < (double)var2 + var10 * 2.0D && (double)var14 > (double)var2 - var10 * 2.0D) {
               var8 = 1.0D;
            }

            double var15;
            double var19;
            label40: {
               var8 = var8 * var12;
               var15 = (double) RotationUtilA.c67346(KillAura.c79073()).c41918;
               double var17 = Math.sqrt(var6 * var6 + var8 * var8);
               var6 = var6 / var17;
               var8 = var8 / var17;
               var19 = Math.toDegrees(Math.asin(var8));
               if (var19 > 0.0D) {
                  if (var6 >= 0.0D) {
                     break label40;
                  }

                  var19 = 180.0D - var19;
               }

               if (var6 < 0.0D) {
                  var19 = -180.0D - var19;
               }
            }

            var15 = Math.toRadians(var15 + var19);
            var3.c49055 = -Math.sin(var15) * var10;
            var3.c27627 = Math.cos(var15) * var10;
            c67534.thePlayer.motionX = var3.c49055;
            c67534.thePlayer.motionZ = var3.c27627;
         }
      }
   }

   public static void c8829() {
      c16498(c24185());
   }

   public static Block c59727(BlockPos var0) {
      return c67534.theWorld.getBlockState(var0).getBlock();
   }

   public static float c84699() {
      Value.c27574();
      float var1 = c67534.thePlayer.rotationYaw;
      if (c67534.thePlayer.moveForward > 0.0F) {
         if (c67534.thePlayer.moveStrafing > 0.0F) {
            var1 -= 45.0F;
         }

         if (c67534.thePlayer.moveStrafing >= 0.0F) {
            return var1;
         }

         var1 += 45.0F;
      }

      if (c67534.thePlayer.moveForward < 0.0F) {
         if (c67534.thePlayer.moveStrafing > 0.0F) {
            var1 -= 135.0F;
         }

         if (c67534.thePlayer.moveStrafing < 0.0F) {
            var1 += 135.0F;
         }

         var1 -= 180.0F;
      }

      if (c67534.thePlayer.moveStrafing > 0.0F) {
         var1 -= 90.0F;
      }

      if (c67534.thePlayer.moveStrafing < 0.0F) {
         var1 += 90.0F;
      }

      return var1;
   }

   public static void c70057(MoveEvent var0) {
      Value.c27574();
      double var2 = 0.41999998688697815D;
      if (c67534.thePlayer.isPotionActive(Potion.jump)) {
         var2 += (double)((float)(c67534.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
      }

      var0.c59560(c67534.thePlayer.motionY = var2);
   }

   public static double c82120() {
      return c22510(c67534.thePlayer.rotationYaw);
   }

   public static float c31349() {
      return c37776(c67534.thePlayer.rotationYaw);
   }

   public static float c37776(float var0) {
      Value.c27574();
      float var2 = c67534.thePlayer.moveForward;
      float var3 = c67534.thePlayer.moveStrafing;
      boolean var4 = var2 > 0.0F;
      boolean var5 = var2 < 0.0F;
      boolean var6 = var3 > 0.0F;
      boolean var7 = var3 < 0.0F;
      float var8 = 0.0F;
      var8 = var8 + 180.0F;
      var8 = var8 + (var4 ? (float)(var6 ? -45 : (var7 ? 45 : 0)) : (var5 ? (float)(var6 ? 45 : (var7 ? -45 : 0)) : (float)(var6 ? -90 : (var7 ? 90 : 0))));
      var8 = var8 + var0;
      return MathHelper.wrapAngleTo180_float(var8);
   }

   public static double c22510(float var0) {
      Value.c27574();
      float var2 = var0;
      if (c67534.thePlayer.moveForward < 0.0F) {
         var2 = var0 + 180.0F;
      }

      float var3 = 1.0F;
      if (c67534.thePlayer.moveForward < 0.0F) {
         var3 = -0.5F;
      }

      if (c67534.thePlayer.moveForward > 0.0F) {
         var3 = 0.5F;
      }

      if (c67534.thePlayer.moveStrafing > 0.0F) {
         var2 -= 70.0F * var3;
      }

      if (c67534.thePlayer.moveStrafing < 0.0F) {
         var2 += 70.0F * var3;
      }

      return Math.toRadians((double)var2);
   }

   public static void c98214() {
      c67534.thePlayer.motionX = c67534.thePlayer.motionZ = 0.0D;
   }

   public static void c28798(float var0, float var1) {
      if (c71257()) {
         float var2 = (float)Math.toRadians((double)var1);
         c67534.thePlayer.motionX = -Math.sin((double)var2) * (double)var0;
         c67534.thePlayer.motionZ = Math.cos((double)var2) * (double)var0;
      }
   }

   public static void c98475(double var0, float var2) {
      Module[] var3 = Value.c27574();
      if (c71257()) {
         var2 = (float)Math.toRadians((double)var2);
         c67534.thePlayer.motionX = (double)(-MathHelper.sin(var2)) * var0;
         c67534.thePlayer.motionZ = (double)MathHelper.cos(var2) * var0;
      }
   }

   public static void c75623(MoveEvent var0, double var1) {
      Value.c27574();
      float var4 = (float)Math.toRadians((double)c84699());
      if (c71257()) {
         var0.c97676(c67534.thePlayer.motionX = -Math.sin((double)var4) * var1);
         var0.c90383(c67534.thePlayer.motionZ = Math.cos((double)var4) * var1);
      }

      var0.c97676(c67534.thePlayer.motionX = 0.0D);
      var0.c90383(c67534.thePlayer.motionZ = 0.0D);
   }

   public static int c74275() {
      Module[] var0 = Value.c27574();
      return c67534.thePlayer.isPotionActive(Potion.moveSpeed) ? 1 + c67534.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() : 0;
   }

   public static void c86285(double var0) {
      c10879(var0, c67534.thePlayer.rotationYaw, (double)c67534.thePlayer.movementInput.moveStrafe, (double)c67534.thePlayer.movementInput.moveForward);
   }

   public static void c10879(double var0, float var2, double var3, double var5) {
      Module[] var7 = Value.c27574();
      if (var5 != 0.0D) {
         if (var3 > 0.0D) {
            var2 += (float)(var5 > 0.0D ? -45 : 45);
         }

         if (var3 < 0.0D) {
            var2 += (float)(var5 > 0.0D ? 45 : -45);
         }

         var3 = 0.0D;
         if (var5 > 0.0D) {
            var5 = 1.0D;
         }

         if (var5 < 0.0D) {
            var5 = -1.0D;
         }
      }

      if (var3 > 0.0D) {
         var3 = 1.0D;
      }

      if (var3 < 0.0D) {
         var3 = -1.0D;
      }

      double var8 = Math.cos(Math.toRadians((double)(var2 + 90.0F)));
      double var10 = Math.sin(Math.toRadians((double)(var2 + 90.0F)));
      c67534.thePlayer.motionX = var5 * var0 * var8 + var3 * var0 * var10;
      c67534.thePlayer.motionZ = var5 * var0 * var10 - var3 * var0 * var8;
   }

   public static double c24124() {
      Value.c27574();
      double var1 = (double)c67534.thePlayer.capabilities.getWalkSpeed() * 2.873D;
      if (c67534.thePlayer.isPotionActive(Potion.moveSlowdown)) {
         var1 /= 1.0D + 0.2D * (double)(c67534.thePlayer.getActivePotionEffect(Potion.moveSlowdown).getAmplifier() + 1);
      }

      if (c67534.thePlayer.isPotionActive(Potion.moveSpeed)) {
         var1 *= 1.0D + 0.2D * (double)(c67534.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
      }

      return var1;
   }

   private static JSONException c5183(JSONException var0) {
      return var0;
   }
}
