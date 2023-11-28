package rip.sleep.util;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.vecmath.Vector2f;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import rip.sleep.module.modules.KillAura;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.struct.VectorStructB;

public class RayTraceUtilB {
   public static Minecraft c25409 = Minecraft.getMinecraft();

   public static MovingObjectPosition c13110(double var0) {
      return c60917(var0, 0.0F);
   }

   public static MovingObjectPosition c60917(double var0, float var2) {
      return c97251(var0, var2, c25409.thePlayer);
   }

   public static MovingObjectPosition c97251(double var0, float var2, Entity var3) {
      Value.c27574();
      float var5 = c25409.timer.renderPartialTicks;
      if (!Objects.equals(KillAura.c92537.c54460(), "None") && (!Objects.equals(KillAura.c92537.c54460(), "Smart") || KillAura.c64006(KillAura.c19685, KillAura.c7038.c53968().floatValue()))) {
         boolean var26 = false;
      } else {
         boolean var10000 = true;
      }

      if (c25409.theWorld != null) {
         MovingObjectPosition var6 = c51012(var0, c25409.thePlayer.rotationYaw, c25409.thePlayer.rotationPitch);
         double var8 = var0;
         Vec3 var10 = var3.getPositionEyes(var5);
         if (var6 != null) {
            var8 = var6.hitVec.distanceTo(var10);
         }

         Vec3 var11 = c25409.thePlayer.getVectorForRotation(c25409.thePlayer.rotationPitch, c25409.thePlayer.rotationYaw);
         Vec3 var12 = var10.addVector(var11.xCoord * var0, var11.yCoord * var0, var11.zCoord * var0);
         Entity var13 = null;
         Vec3 var14 = null;
         float var15 = 1.0F;
         List var16 = c25409.theWorld.getEntitiesInAABBexcluding(var3, var3.getEntityBoundingBox().addCoord(var11.xCoord * var0, var11.yCoord * var0, var11.zCoord * var0).expand(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         double var17 = var8;
         Iterator var19 = var16.iterator();
         if (var19.hasNext()) {
            label61: {
               Entity var20 = (Entity)var19.next();
               float var21 = var20.getCollisionBorderSize() + var2;
               AxisAlignedBB var22 = var20.getEntityBoundingBox().expand((double)var21, (double)var21, (double)var21);
               MovingObjectPosition var23 = var22.calculateIntercept(var10, var12);
               if (var22.isVecInside(var10)) {
                  if (var8 < 0.0D) {
                     break label61;
                  }

                  var13 = var20;
                  var14 = var23 == null ? var10 : var23.hitVec;
                  var17 = 0.0D;
               }

               double var24 = var10.distanceTo(var23.hitVec);
               if (var24 < var17 || var17 == 0.0D) {
                  var13 = var20;
                  var14 = var23.hitVec;
                  var17 = var24;
               }
            }
         }

         if (var17 < var8 || var6 == null) {
            var6 = new MovingObjectPosition(var13, var14);
         }

         return var6;
      } else {
         return null;
      }
   }

   public static Entity c45144(double var0, RayTraceUtilB.c79609 var2) {
      Module[] var3 = Value.c27574();
      if (!Objects.equals(KillAura.c92537.c54460(), "None") && (!Objects.equals(KillAura.c92537.c54460(), "Smart") || KillAura.c64006(KillAura.c19685, KillAura.c7038.c53968().floatValue()))) {
         boolean var5 = false;
      } else {
         boolean var10000 = true;
      }

      return c52809(var0, c25409.thePlayer.rotationYaw, c25409.thePlayer.rotationPitch, var2);
   }

   public static MovingObjectPosition c37434(Entity var0, double var1, float var3, float var4, float var5) {
      Vec3 var6 = var0.getPositionEyes(1.0F);
      Vec3 var7 = c67507(var5, var4);
      Vec3 var8 = var6.addVector(var7.xCoord * var1, var7.yCoord * var1, var7.zCoord * var1);
      return var0.worldObj.rayTraceBlocks(var6, var8, false, false, true);
   }

   public static MovingObjectPosition c1146(Entity var0, float var1, float var2, double var3) {
      Module[] var5 = Value.c27574();
      if (c25409.theWorld != null) {
         Entity var6 = null;
         c25409.pointedEntity = null;
         MovingObjectPosition var7 = c37434(var0, var3, 1.0F, var1, var2);
         double var8 = var3;
         Vec3 var10 = var0.getPositionEyes(1.0F);
         boolean var11 = false;
         boolean var12 = true;
         if (var7 != null && var7.typeOfHit == MovingObjectType.BLOCK) {
            var8 = var7.hitVec.distanceTo(var10);
         }

         Vec3 var13 = c67507(var2, var1);
         Vec3 var14 = var10.addVector(var13.xCoord * var3, var13.yCoord * var3, var13.zCoord * var3);
         Vec3 var15 = null;
         float var16 = 1.0F;
         List var17 = c25409.theWorld.getEntitiesInAABBexcluding(var0, var0.getEntityBoundingBox().addCoord(var13.xCoord * var3, var13.yCoord * var3, var13.zCoord * var3).expand((double)var16, (double)var16, (double)var16), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         double var18 = var8;
         int var20 = 0;
         if (var20 < var17.size()) {
            label67: {
               Entity var21 = (Entity)var17.get(var20);
               float var22 = var21.getCollisionBorderSize();
               AxisAlignedBB var23 = var21.getEntityBoundingBox().expand((double)var22, (double)var22, (double)var22);
               MovingObjectPosition var24 = var23.calculateIntercept(var10, var14);
               if (var23.isVecInside(var10)) {
                  if (var8 < 0.0D) {
                     break label67;
                  }

                  var6 = var21;
                  var15 = var24 == null ? var10 : var24.hitVec;
                  var18 = 0.0D;
               }

               double var25 = var10.distanceTo(var24.hitVec);
               if (var25 < var18 || var18 == 0.0D) {
                  label71: {
                     boolean var27 = false;
                     if (var21 == var0.ridingEntity && !var27) {
                        if (var18 != 0.0D) {
                           break label71;
                        }

                        var15 = var24.hitVec;
                     }

                     var6 = var21;
                     var15 = var24.hitVec;
                     var18 = var25;
                  }
               }
            }

            ++var20;
         }

         if (var6 != null && var11 && var10.distanceTo(var15) > var3) {
            var7 = new MovingObjectPosition(MovingObjectType.MISS, var15, (EnumFacing)null, new BlockPos(var15));
         }

         if (var6 != null && (var18 < var8 || var7 == null)) {
            var7 = new MovingObjectPosition(var6, var15);
         }

         return var7;
      } else {
         return null;
      }
   }

   public static Entity c52809(double var0, float var2, float var3, RayTraceUtilB.c79609 var4) {
      Value.c27574();
      Entity var6 = c25409.getRenderViewEntity();
      if (c25409.theWorld == null) {
         return null;
      } else {
         double var7 = var0;
         Vec3 var9 = var6.getPositionEyes(1.0F);
         float var10 = MathHelper.cos(-var2 * 0.017453292F - 3.1415927F);
         float var11 = MathHelper.sin(-var2 * 0.017453292F - 3.1415927F);
         float var12 = -MathHelper.cos(-var3 * 0.017453292F);
         float var13 = MathHelper.sin(-var3 * 0.017453292F);
         Vec3 var14 = new Vec3((double)(var11 * var12), (double)var13, (double)(var10 * var12));
         Vec3 var15 = var9.addVector(var14.xCoord * var0, var14.yCoord * var0, var14.zCoord * var0);
         List var16 = c25409.theWorld.getEntitiesInAABBexcluding(var6, var6.getEntityBoundingBox().addCoord(var14.xCoord * var0, var14.yCoord * var0, var14.zCoord * var0).expand(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         Entity var17 = null;
         Iterator var18 = var16.iterator();
         if (var18.hasNext()) {
            Entity var19 = (Entity)var18.next();
            if (!var4.c4440(var19)) {
               ;
            }

            float var20 = var19.getCollisionBorderSize();
            AxisAlignedBB var21 = var19.getEntityBoundingBox().expand((double)var20, (double)var20, (double)var20);
            MovingObjectPosition var22 = var21.calculateIntercept(var9, var15);
            if (var21.isVecInside(var9)) {
               if (var0 < 0.0D) {
                  return var17;
               }

               var17 = var19;
               var7 = 0.0D;
            }

            double var23 = var9.distanceTo(var22.hitVec);
            if ((var23 < var7 || var7 == 0.0D) && (var19 != var6.ridingEntity || var7 == 0.0D)) {
               var17 = var19;
            }
         }

         return var17;
      }
   }

   public static Vec3 c61920(float var0) {
      if (var0 == 1.0F) {
         return new Vec3(c25409.thePlayer.posX, c25409.thePlayer.posY + (double)c25409.thePlayer.getEyeHeight(), c25409.thePlayer.posZ);
      } else {
         double var1 = c25409.thePlayer.prevPosX + (c25409.thePlayer.posX - c25409.thePlayer.prevPosX) * (double)var0;
         double var3 = c25409.thePlayer.prevPosY + (c25409.thePlayer.posY - c25409.thePlayer.prevPosY) * (double)var0 + (double)c25409.thePlayer.getEyeHeight();
         double var5 = c25409.thePlayer.prevPosZ + (c25409.thePlayer.posZ - c25409.thePlayer.prevPosZ) * (double)var0;
         return new Vec3(var1, var3, var5);
      }
   }

   public static Vec3 c66480(float var0, float var1) {
      return c67507(var1, var0);
   }

   public static final Vec3 c67507(float var0, float var1) {
      float var2 = MathHelper.cos(-var1 * 0.017453292F - 3.1415927F);
      float var3 = MathHelper.sin(-var1 * 0.017453292F - 3.1415927F);
      float var4 = -MathHelper.cos(-var0 * 0.017453292F);
      float var5 = MathHelper.sin(-var0 * 0.017453292F);
      return new Vec3((double)(var3 * var4), (double)var5, (double)(var2 * var4));
   }

   public static MovingObjectPosition c51012(double var0, float var2, float var3) {
      Vec3 var4 = c61920(1.0F);
      Vec3 var5 = c66480(var2, var3);
      Vec3 var6 = var4.addVector(var5.xCoord * var0, var5.yCoord * var0, var5.zCoord * var0);
      return c25409.thePlayer.worldObj.rayTraceBlocks(var4, var6, false, false, true);
   }

   public static VectorStructB c20642() {
      return new VectorStructB(c25409.thePlayer.posX, c25409.thePlayer.posY, c25409.thePlayer.posZ);
   }

   public static boolean c27247(Vector2f param0, EnumFacing param1, BlockPos param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   private static RuntimeException c95918(RuntimeException var0) {
      return var0;
   }

   public interface c79609 {
      boolean c4440(Entity var1);
   }
}
