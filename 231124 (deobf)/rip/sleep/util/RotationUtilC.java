package rip.sleep.util;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.json.JSONException;
import rip.sleep.unmap.c39134;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RotationUtilC {
   private static final Minecraft mc = Minecraft.getMinecraft();
   private static final Random c9199 = new Random();
   private static RotationUtilC c89278;

   public float c4879(Entity var1) {
      Module[] var2 = Value.c27574();
      if (var1 == null) {
         return mc.thePlayer.rotationYaw;
      } else {
         double var3 = var1.posX - mc.thePlayer.posX;
         double var5 = var1.posZ - mc.thePlayer.posZ;
         float var7 = (float)(Math.atan2(var5, var3) * 180.0D / 3.141592653589793D) - 90.0F;
         return mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var7 - mc.thePlayer.rotationYaw);
      }
   }

   public float c13465(Entity var1) {
      Module[] var2 = Value.c27574();
      if (var1 == null) {
         return mc.thePlayer.rotationPitch;
      } else {
         if (var1 instanceof EntityLivingBase) {
            EntityLivingBase var5 = (EntityLivingBase)var1;
            double var3 = var5.posY + (double)var5.getEyeHeight() - (mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight());
         }

         double var12 = (var1.getEntityBoundingBox().minY + var1.getEntityBoundingBox().maxY) / 2.0D - (mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight());
         double var13 = var1.posX - mc.thePlayer.posX;
         double var7 = var1.posZ - mc.thePlayer.posZ;
         double var9 = (double)MathHelper.sqrt_double(var13 * var13 + var7 * var7);
         float var11 = (float)(-(Math.atan2(var12, var9) * 180.0D / 3.141592653589793D));
         return mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var11 - mc.thePlayer.rotationPitch) + 1.0F;
      }
   }

   public static Vec3 c86199(Vec3 var0, AxisAlignedBB var1) {
      return new Vec3(MathHelper.clamp_double(var0.xCoord, var1.minX, var1.maxX), MathHelper.clamp_double(var0.yCoord, var1.minY, var1.maxY), MathHelper.clamp_double(var0.zCoord, var1.minZ, var1.maxZ));
   }

   public float[] c73432(float var1, float var2) {
      Value.c27574();
      float var4 = Math.abs(var1 - var2);
      if (var4 < 0.0F) {
         var4 += 360.0F;
      }

      if (var4 >= 360.0F) {
         var4 -= 360.0F;
      }

      float var5 = 360.0F - var4;
      float var6 = 0.0F;
      if (var4 > var5) {
         ++var6;
      }

      if (var4 > var5) {
         var4 = var5;
      }

      return new float[]{var4, var6};
   }

   public float c40035(Vec3 var1) {
      double var2 = mc.thePlayer.posX - var1.xCoord;
      double var4 = mc.thePlayer.posZ - var1.zCoord;
      return (float)((double)((float)Math.atan2(var4, var2)) / 3.141592653589793D * 180.0D) - 90.0F;
   }

   public float c35863(Entity var1, Entity var2) {
      Vec3 var3 = new Vec3(var2.posX, var2.posY, var2.posZ);
      double var4 = var1.posX - (var3.xCoord + (var2.posX - var2.lastTickPosX));
      double var6 = var1.posZ - (var3.zCoord + (var2.posZ - var2.lastTickPosZ));
      return (float)((double)((float)Math.atan2(var6, var4)) / 3.141592653589793D * 180.0D) - 90.0F;
   }

   public Vec3 c73595(float var1, float var2) {
      return this.c13667(var1, var2, 1.0F);
   }

   public final Vec3 c97963(float var1, float var2) {
      float var3 = MathHelper.cos(-var2 * 0.017453292F - 3.1415927F);
      float var4 = MathHelper.sin(-var2 * 0.017453292F - 3.1415927F);
      float var5 = -MathHelper.cos(-var1 * 0.017453292F);
      float var6 = MathHelper.sin(-var1 * 0.017453292F);
      return new Vec3((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   public Vec3 c13667(float var1, float var2, float var3) {
      return this.c97963(var2, var1);
   }

   static float c96782(float var0, float var1, float var2) {
      Value.c27574();
      float var4 = MathHelper.wrapAngleTo180_float(var1 - var0);
      if (var4 > var2) {
         var4 = var2;
      }

      if (var4 < -var2) {
         var4 = -var2;
      }

      return var0 + var4;
   }

   public float[] c17792(float var1, float var2, float var3, float var4) {
      var1 = (float)((double)var1 + (double)var3 * 0.15D);
      var2 = (float)((double)var2 + (double)var4 * 0.15D);
      return new float[]{var1, var2};
   }

   public static float[] c61380(float var0, float var1, boolean var2) {
      Value.c27574();
      float var4 = mc.gameSettings.mouseSensitivity;
      if (var4 == 0.0F) {
         var4 = 0.0070422534F;
      }

      var4 = Math.max(0.1F, var4);
      int var5 = (int)((var0 - c39134.c49330) / (var4 / 2.0F));
      int var6 = (int)((var1 - c39134.c21639) / (var4 / 2.0F)) * -1;
      if (var2) {
         var5 = (int)((double)var5 - ((double)var5 % 0.5D + 0.25D));
         var6 = (int)((double)var6 - ((double)var6 % 0.5D + 0.25D));
      }

      float var7 = var4 * 0.6F + 0.2F;
      float var8 = (float)(Math.pow((double)var7, 3.0D) * 8.0D);
      float var9 = (float)var5 * var8;
      float var10 = (float)var6 * var8;
      float var11 = (float)((double)c39134.c49330 + (double)var9 * 0.15D);
      float var12 = (float)((double)c39134.c21639 - (double)var10 * 0.15D);
      return new float[]{var11, var12};
   }

   public static float[] c38390(Entity var0, boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, double var7, boolean var9, float var10, double var11, boolean var13, int var14) {
      MathUtilG var16 = MathUtilG.c25892();
      double var17 = (mc.thePlayer.getEntityBoundingBox().minX + mc.thePlayer.getEntityBoundingBox().maxX) / 2.0D;
      double var19 = mc.thePlayer.getEntityBoundingBox().minY + (double) mc.thePlayer.getEyeHeight();
      Value.c27574();
      double var21 = (mc.thePlayer.getEntityBoundingBox().minZ + mc.thePlayer.getEntityBoundingBox().maxZ) / 2.0D;
      double var23 = var0.posX - var17;
      double var25 = var0.posY + (double)var0.getEyeHeight() - var19;
      double var27 = var0.posZ - var21;
      if (var6) {
         Vec3 var29 = c86199(mc.thePlayer.getPositionEyes(mc.timer.renderPartialTicks), var0.getEntityBoundingBox()).addVector(-var7 / 10.0D, -var7 / 10.0D, -var7 / 10.0D);
         var23 = var29.xCoord - var17;
         var25 = var29.yCoord - var19;
         var27 = var29.zCoord - var21;
      }

      if (!(var0 instanceof EntityLivingBase)) {
         var25 = (var0.getEntityBoundingBox().minY + var0.getEntityBoundingBox().maxY) / 2.0D - (mc.thePlayer.getEntityBoundingBox().minY + (double) mc.thePlayer.getEyeHeight());
      }

      if (var13) {
         var25 *= (double)var14 * 0.02D;
      }

      if (var2) {
         float var44 = (float)MathHelper.getRandomDoubleInRange(new Random(), 0.015D, 0.018D);
         float var30 = (float)MathHelper.getRandomDoubleInRange(new Random(), 0.01D, (double)var44);
         float var31 = (float)MathHelper.getRandomDoubleInRange(new Random(), -0.1D, -0.3D);
         var23 += var16.c42564((double)(-var30), (double)var30);
         var27 += var16.c42564((double)(-var30), (double)var30);
         var25 += var16.c42564((double)var31, -0.01D);
      }

      if (var4) {
         boolean var45 = var0.isSprinting();
         boolean var47 = mc.thePlayer.isSprinting();
         float var48 = 0.1F;
         float var32 = 1.25F;
         float var33 = 1.25F;
         float var34 = (float)((var0.posX - var0.prevPosX) * (double)var32);
         float var35 = (float)((var0.posZ - var0.prevPosZ) * (double)var32);
         float var36 = (float)((mc.thePlayer.posX - mc.thePlayer.prevPosX) * (double)var33);
         float var37 = (float)((mc.thePlayer.posZ - mc.thePlayer.prevPosZ) * (double)var33);
         if (var34 != 0.0F && var35 != 0.0F || var36 != 0.0F && var37 != 0.0F) {
            var23 += (double)(var34 + var36);
            var27 += (double)(var35 + var37);
         }
      }

      double var46 = (double)MathHelper.sqrt_double(var23 * var23 + var27 * var27);
      float var49 = (float)(MathHelper.atan2(var27, var23) * 180.0D / 3.141592653589793D) - 90.0F;
      float var50 = (float)(-(MathHelper.atan2(var25, var46) * 180.0D / 3.141592653589793D));
      double var51 = (double) mc.thePlayer.getDistanceToEntity(var0);
      double var52 = var11 + 1.0D;
      double var53 = Math.hypot((double)(c39134.c49330 - var49), (double)(c39134.c21639 - var50));
      double var39 = var53 * ((var52 - var51) / var52);
      float var42 = c96782(c39134.c21639, var50, MathHelper.abs((float)var39));
      if (!var5) {
         return new float[]{var49, c45473(var42)};
      } else {
         float[] var43 = c61380(var49, var42, var1);
         return new float[]{var43[0], c45473(var43[1])};
      }
   }

   public float[] c41781(BlockPos var1, double var2, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, float var10) {
      Module[] var11 = Value.c27574();
      double var12 = (double)var1.getX() + this.c59420(0.45D, 0.5D) - (mc.thePlayer.getEntityBoundingBox().minX + mc.thePlayer.getEntityBoundingBox().maxX) / 2.0D - mc.thePlayer.motionX;
      double var14 = (double)var1.getY() - var2 - (mc.thePlayer.getEntityBoundingBox().minY + (double) mc.thePlayer.getEyeHeight());
      double var16 = (double)var1.getZ() + this.c59420(0.45D, 0.5D) - (mc.thePlayer.getEntityBoundingBox().minZ + mc.thePlayer.getEntityBoundingBox().maxZ) / 2.0D - mc.thePlayer.motionZ;
      var14 = var14 + this.c59420(-0.05D, 0.05D);
      double var18 = (double)MathHelper.sqrt_double(var12 * var12 + var16 * var16);
      float var20 = (float)(MathHelper.atan2(var16, var12) * 180.0D / 3.141592653589793D) - 90.0F;
      float var21 = (float)(-(MathHelper.atan2(var14, var18) * 180.0D / 3.141592653589793D));
      float var23 = c96782(c39134.c21639, var21, var10);
      if (!var5) {
         return new float[]{var20, c45473(var23)};
      } else {
         float[] var24 = c61380(var20, var23, var4);
         return new float[]{var24[0], c45473(var24[1])};
      }
   }

   public double c59420(double var1, double var3) {
      Module[] var5 = Value.c27574();
      if (var1 > var3) {
         System.err.println("The minimal value cannot be higher than the max value");
         return var1;
      } else {
         var3 = var3 - var1;
         return Math.random() * var3 + var1;
      }
   }

   public static float c45473(float var0) {
      return MathHelper.clamp_float(var0, -90.0F, 90.0F);
   }

   public Entity c18457(double var1, float var3, float var4) {
      return this.c48652(var1, var3, var4, 1.0F);
   }

   public Entity c48652(double var1, float var3, float var4, float var5) {
      Entity var7 = mc.getRenderViewEntity();
      Value.c27574();
      Entity var8 = null;
      if (mc.theWorld != null) {
         MovingObjectPosition var9 = var7.rayTrace(var1, var5);
         Vec3 var10 = var7.getPositionEyes(1.0F);
         boolean var11 = false;
         double var12 = var1;
         if (var9 != null) {
            var12 = var9.hitVec.distanceTo(var10);
         }

         Vec3 var14 = this.c13667(var3, var4, var5);
         Vec3 var15 = var10.addVector(var14.xCoord * var1, var14.yCoord * var1, var14.zCoord * var1);
         var8 = null;
         Vec3 var16 = null;
         float var17 = 1.0F;
         List var18 = mc.theWorld.getEntitiesInAABBexcluding(var7, var7.getEntityBoundingBox().addCoord(var14.xCoord * var1, var14.yCoord * var1, var14.zCoord * var1).expand((double)var17, (double)var17, (double)var17), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         double var19 = var12;
         int var21 = 0;
         if (var21 < var18.size()) {
            label79: {
               Entity var22 = (Entity)var18.get(var21);
               float var23 = var22.getCollisionBorderSize();
               AxisAlignedBB var24 = var22.getEntityBoundingBox().expand((double)var23, (double)var23, (double)var23);
               MovingObjectPosition var25 = var24.calculateIntercept(var10, var15);
               if (var24.isVecInside(var10)) {
                  if (var1 < 0.0D) {
                     break label79;
                  }

                  var8 = var22;
                  var16 = var25 == null ? var10 : var25.hitVec;
                  var1 = 0.0D;
               }

               double var26 = var10.distanceTo(var25.hitVec);
               if (var26 < var1 || var1 == 0.0D) {
                  label86: {
                     boolean var28 = false;
                     if (var22 == var7.ridingEntity && !var28) {
                        if (var12 != 0.0D) {
                           break label86;
                        }

                        var16 = var25.hitVec;
                     }

                     var8 = var22;
                     var16 = var25.hitVec;
                     var19 = var26;
                  }
               }
            }

            ++var21;
         }

         if (var8 != null && var11 && var10.distanceTo(var16) > var1) {
            var8 = null;
            var9 = new MovingObjectPosition(MovingObjectType.MISS, var16, (EnumFacing)null, new BlockPos(var16));
         }

         if (var8 != null && (var19 < var12 || mc.objectMouseOver == null)) {
            var9 = new MovingObjectPosition(var8, var16);
            if (var8 instanceof EntityLivingBase || var8 instanceof EntityItemFrame) {
               return var8;
            }
         }

         if (var9 != null && var9.entityHit != null) {
            return var9.entityHit;
         }
      }

      return var8;
   }

   public MovingObjectPosition c8505(float var1, float var2, float var3) {
      return this.c40630(mc.thePlayer, var1, var2, var3);
   }

   public MovingObjectPosition c40630(Entity var1, float var2, float var3, float var4) {
      Vec3 var5 = var1.getPositionEyes(1.0F);
      Vec3 var6 = this.c73595(var2, var3);
      Vec3 var7 = var5.addVector(var6.xCoord * (double)var4, var6.yCoord * (double)var4, var6.zCoord * (double)var4);
      return mc.theWorld.rayTraceBlocks(var5, var7, false, false, true);
   }

   public MovingObjectPosition c50252(float var1, float var2) {
      Value.c27574();
      float var4 = mc.playerController.getBlockReachDistance();
      Vec3 var5 = this.c73595(var1, var2);
      Vec3 var6 = mc.thePlayer.getPositionEyes(1.0F);
      Vec3 var7 = var6.addVector(var5.xCoord * (double)var4, var5.yCoord * (double)var4, var5.zCoord * (double)var4);
      MovingObjectPosition var8 = mc.theWorld.rayTraceBlocks(var6, var7, false, false, false);
      return var8 != null && var8.typeOfHit == MovingObjectType.BLOCK ? var8 : null;
   }

   public static RotationUtilC c31369() {
      Module[] var0 = Value.c27574();
      if (c89278 == null) {
         c89278 = new RotationUtilC();
      }

      return c89278;
   }

   private static JSONException c34276(JSONException var0) {
      return var0;
   }
}
