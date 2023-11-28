package rip.sleep.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.struct.OffsetFacing;
import rip.sleep.interfaces.IInstanceAccess;
import rip.sleep.value.Value;

public class RayTraceUtilA implements IInstanceAccess {
   public static OffsetFacing c81999(double var0, int var2) {
      return c25294(c56767.thePlayer.posX, var0 - 1.0D, c56767.thePlayer.posZ, var2);
   }

   public static OffsetFacing c25294(double var0, double var2, double var4, int var6) {
      Value.c27574();
      BlockPos var8 = new BlockPos(var0, var2, var4);
      EnumFacing var9 = c87779(PlayerUtil.c84699()).getOpposite();
      ArrayList var10 = new ArrayList();
      var10.add(var9);
      EnumFacing[] var11 = EnumFacing.values();
      int var12 = var11.length;
      int var13 = 0;
      if (var13 < var12) {
         EnumFacing var14 = var11[var13];
         if (var14 != var9 && var14 != EnumFacing.UP) {
            var10.add(var14);
         }

         ++var13;
      }

      CopyOnWriteArrayList var19 = new CopyOnWriteArrayList();
      var19.add(var8);
      var12 = 0;
      if (var12 < var6) {
         ArrayList var23 = new ArrayList(var19);
         if (!var19.isEmpty()) {
            Iterator var24 = var19.iterator();
            if (var24.hasNext()) {
               BlockPos var15 = (BlockPos)var24.next();
               Iterator var16 = var10.iterator();
               if (var16.hasNext()) {
                  EnumFacing var17 = (EnumFacing)var16.next();
                  BlockPos var18 = var15.offset(var17);
                  if (c28418(var18)) {
                     var19.add(var18);
                  }

                  return new OffsetFacing(var18, var17.getOpposite());
               }
            }
         }

         Iterator var25 = var23.iterator();
         if (var25.hasNext()) {
            BlockPos var26 = (BlockPos)var25.next();
            var19.remove(var26);
         }

         var23.clear();
         ++var12;
      }

      return null;
   }

   public static Vec3 c80666(BlockPos var0, EnumFacing var1, boolean var2) {
      Value.c27574();
      Vec3 var4 = new Vec3(var0);
      double var5 = 0.5D;
      double var7 = 0.5D;
      var5 = 0.45D + Math.random() * 0.1D;
      var7 = 0.45D + Math.random() * 0.1D;
      if (var1 == EnumFacing.UP) {
         var4 = var4.addVector(var5, 1.0D, var7);
      }

      if (var1 == EnumFacing.DOWN) {
         var4 = var4.addVector(var5, 0.0D, var7);
      }

      if (var1 == EnumFacing.EAST) {
         var4 = var4.addVector(1.0D, var5, var7);
      }

      if (var1 == EnumFacing.WEST) {
         var4 = var4.addVector(0.0D, var5, var7);
      }

      if (var1 == EnumFacing.NORTH) {
         var4 = var4.addVector(var5, var7, 0.0D);
      }

      if (var1 == EnumFacing.SOUTH) {
         var4 = var4.addVector(var5, var7, 1.0D);
      }

      return var4;
   }

   public static EnumFacing c87779(float var0) {
      return EnumFacing.getHorizontal(MathHelper.floor_double((double)(var0 * 4.0F / 360.0F) + 0.5D) & 3);
   }

   public static boolean c82224(BlockPos var0) {
      Block var1 = c56767.theWorld.getBlockState(var0).getBlock();
      return var1 instanceof BlockAir;
   }

   public static boolean c28418(BlockPos var0) {
      Value.c27574();
      Block var2 = c56767.theWorld.getBlockState(var0).getBlock();
      return var2 instanceof BlockAir || var2 instanceof BlockLiquid;
   }

   public static MovingObjectPosition c77027(float var0, float var1) {
      float var2 = c56767.timer.renderPartialTicks;
      float var3 = c56767.playerController.getBlockReachDistance();
      Vec3 var4 = c56767.thePlayer.getPositionEyes(var2);
      Vec3 var5 = c56767.thePlayer.getVectorForRotation(var1, var0);
      Vec3 var6 = var4.addVector(var5.xCoord * (double)var3, var5.yCoord * (double)var3, var5.zCoord * (double)var3);
      return c56767.theWorld.rayTraceBlocks(var4, var6, false, false, true);
   }

   public static MovingObjectPosition c54469(float var0, float var1, float var2, float var3) {
      float var4 = c56767.timer.renderPartialTicks;
      float var5 = c56767.playerController.getBlockReachDistance();
      Vec3 var6 = c56767.thePlayer.getPositionEyes(var4);
      float var7 = var3 + (var1 - var3) * var4;
      float var8 = var2 + (var0 - var2) * var4;
      Vec3 var9 = c56767.thePlayer.getVectorForRotation(var7, var8);
      Vec3 var10 = var6.addVector(var9.xCoord * (double)var5, var9.yCoord * (double)var5, var9.zCoord * (double)var5);
      return c56767.theWorld.rayTraceBlocks(var6, var10, false, false, true);
   }

   public static boolean c79040() {
      Value.c27574();
      int var1 = (int)c56767.thePlayer.posY;
      if (!(c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX, (double)var1, c56767.thePlayer.posZ)).getBlock() instanceof BlockAir)) {
         return true;
      } else {
         --var1;
         return false;
      }
   }

   public static boolean c11770(int var0) {
      Value.c27574();
      int var2 = (int)c56767.thePlayer.posY;
      if (var2 >= (int)c56767.thePlayer.posY - var0) {
         if (!(c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX, (double)var2, c56767.thePlayer.posZ)).getBlock() instanceof BlockAir)) {
            return true;
         }

         --var2;
      }

      return false;
   }

   public static boolean c15321(double var0) {
      Module[] var2 = Value.c27574();
      return c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX + var0, c56767.thePlayer.posY - 1.0D, c56767.thePlayer.posZ + var0)).getBlock() instanceof BlockAir && c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX - var0, c56767.thePlayer.posY - 1.0D, c56767.thePlayer.posZ - var0)).getBlock() instanceof BlockAir && c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX - var0, c56767.thePlayer.posY - 1.0D, c56767.thePlayer.posZ)).getBlock() instanceof BlockAir && c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX + var0, c56767.thePlayer.posY - 1.0D, c56767.thePlayer.posZ)).getBlock() instanceof BlockAir && c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX, c56767.thePlayer.posY - 1.0D, c56767.thePlayer.posZ + var0)).getBlock() instanceof BlockAir && c56767.theWorld.getBlockState(new BlockPos(c56767.thePlayer.posX, c56767.thePlayer.posY - 1.0D, c56767.thePlayer.posZ - var0)).getBlock() instanceof BlockAir;
   }

   public static List<EntityLivingBase> c51901() {
      return Arrays.asList(Minecraft.getMinecraft().theWorld.loadedEntityList.stream().filter((var0) -> {
         return var0 instanceof EntityLivingBase;
      }).filter((var0) -> {
         return var0 != Minecraft.getMinecraft().thePlayer;
      }).map((var0) -> {
         return (EntityLivingBase)var0;
      }).toArray((var0) -> {
         return new EntityLivingBase[var0];
      }));
   }

   private static JSONException c14498(JSONException var0) {
      return var0;
   }
}
