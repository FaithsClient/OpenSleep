package rip.sleep.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.module.Module;
import wdm.PositionB;
import rip.sleep.value.Value;

public class RotationUtilA {
   private static final Minecraft c95594 = Minecraft.getMinecraft();

   public static float[] c82173(Entity var0) {
      double var1 = var0.posX - Minecraft.getMinecraft().thePlayer.posX;
      double var3 = var0.posZ - Minecraft.getMinecraft().thePlayer.posZ;
      double var5 = var0.posY + (double)var0.getEyeHeight() - (Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY + (Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().maxY - Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY));
      double var7 = (double)MathHelper.sqrt_double(var1 * var1 + var3 * var3);
      float var9 = (float)(MathHelper.atan2(var3, var1) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(MathHelper.atan2(var5, var7) * 180.0D / 3.141592653589793D));
      return new float[]{var9, var10};
   }

   public static float c88844(float var0, float var1) {
      Value.c27574();
      float var3 = Math.abs(var0 - var1) % 360.0F;
      if (var3 > 180.0F) {
         var3 = 360.0F - var3;
      }

      return var3;
   }

   public static RotationUtilE c67346(EntityLivingBase var0) {
      return c30931(var0.posX, var0.posY + (double)var0.getEyeHeight() - 0.4D, var0.posZ);
   }

   public static RotationUtilE c30931(double var0, double var2, double var4) {
      EntityPlayerSP var6 = c95594.thePlayer;
      double var7 = var0 - var6.posX;
      double var9 = var2 - (var6.posY + (double)var6.getEyeHeight());
      double var11 = var4 - var6.posZ;
      double var13 = (double)MathHelper.sqrt_double(var7 * var7 + var11 * var11);
      float var15 = (float)(Math.atan2(var11, var7) * 180.0D / 3.141592653589793D) - 90.0F;
      float var16 = (float)(-(Math.atan2(var9, var13) * 180.0D / 3.141592653589793D));
      return new RotationUtilE(var15, var16);
   }

   public static Vec3 c98737(float var0, float var1) {
      double var2 = Math.cos(Math.toRadians((double)(-var0)) - 3.141592653589793D);
      double var4 = Math.sin(Math.toRadians((double)(-var0)) - 3.141592653589793D);
      double var6 = -Math.cos(Math.toRadians((double)(-var1)));
      double var8 = Math.sin(Math.toRadians((double)(-var1)));
      return new Vec3(var4 * var6, var8, var2 * var6);
   }

   public static Vec3 c66891(RotationUtilE var0) {
      float var1 = (float)Math.cos((double)(-var0.c28107() * 0.017453292F - 3.1415927F));
      float var2 = (float)Math.sin((double)(-var0.c28107() * 0.017453292F - 3.1415927F));
      float var3 = (float)(-Math.cos((double)(-var0.c79255() * 0.017453292F)));
      float var4 = (float)Math.sin((double)(-var0.c79255() * 0.017453292F));
      return new Vec3((double)(var2 * var3), (double)var4, (double)(var1 * var3));
   }

   public static float c6019(float var0, float var1, float var2) {
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

   public static float c72474(float var0, Entity var1, double var2) {
      double var4 = var1.posX - Minecraft.getMinecraft().thePlayer.posX;
      double var6 = var1.posZ - Minecraft.getMinecraft().thePlayer.posZ;
      double var8 = var2 - 2.2D + (double)var1.getEyeHeight() - Minecraft.getMinecraft().thePlayer.posY;
      double var10 = (double)MathHelper.sqrt_double(var4 * var4 + var6 * var6);
      double var12 = -Math.toDegrees(Math.atan(var8 / var10));
      return -MathHelper.wrapAngleTo180_float(var0 - (float)var12) - 2.5F;
   }

   public static float c15179(float var0, double var1, double var3) {
      double var6 = var1 - Minecraft.getMinecraft().thePlayer.posX;
      Value.c27574();
      double var8 = var3 - Minecraft.getMinecraft().thePlayer.posZ;
      double var10 = 0.0D;
      if (var8 < 0.0D && var6 < 0.0D) {
         if (var6 == 0.0D) {
            return MathHelper.wrapAngleTo180_float(-(var0 - (float)var10));
         }

         var10 = 90.0D + Math.toDegrees(Math.atan(var8 / var6));
      }

      if (var8 < 0.0D && var6 > 0.0D) {
         if (var6 == 0.0D) {
            return MathHelper.wrapAngleTo180_float(-(var0 - (float)var10));
         }

         var10 = -90.0D + Math.toDegrees(Math.atan(var8 / var6));
      }

      if (var8 != 0.0D) {
         var10 = Math.toDegrees(-Math.atan(var6 / var8));
      }

      return MathHelper.wrapAngleTo180_float(-(var0 - (float)var10));
   }

   public static float[] c97182(BlockPos var0, EnumFacing var1) {
      double var3 = (double)var0.getX() + 0.5D - c95594.thePlayer.posX + (double)var1.getFrontOffsetX() / 2.0D;
      double var5 = (double)var0.getZ() + 0.5D - c95594.thePlayer.posZ + (double)var1.getFrontOffsetZ() / 2.0D;
      double var7 = (double)var0.getY() + 0.5D;
      Value.c27574();
      double var9 = c95594.thePlayer.posY + (double)c95594.thePlayer.getEyeHeight() - var7;
      double var11 = (double)MathHelper.sqrt_double(var3 * var3 + var5 * var5);
      float var13 = (float)(Math.atan2(var5, var3) * 180.0D / 3.141592653589793D) - 90.0F;
      float var14 = (float)(Math.atan2(var9, var11) * 180.0D / 3.141592653589793D);
      if (var13 < 0.0F) {
         var13 += 360.0F;
      }

      return new float[]{var13, var14};
   }

   public static float[] c30750(Entity var0) {
      Value.c27574();
      double var2 = (var0.posX - var0.lastTickPosX) * 0.4D;
      double var4 = (var0.posZ - var0.lastTickPosZ) * 0.4D;
      double var6 = (double)Minecraft.getMinecraft().thePlayer.getDistanceToEntity(var0);
      var6 = var6 - var6 % 0.8D;
      double var8 = 1.0D;
      double var10 = 1.0D;
      boolean var12 = var0.isSprinting();
      var8 = var6 / 0.8D * var2 * 1.25D;
      var10 = var6 / 0.8D * var4 * 1.25D;
      double var13 = var0.posX + var8 - Minecraft.getMinecraft().thePlayer.posX;
      double var15 = var0.posZ + var10 - Minecraft.getMinecraft().thePlayer.posZ;
      double var17 = Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight() - (var0.posY + (double)var0.getEyeHeight());
      double var19 = (double)Minecraft.getMinecraft().thePlayer.getDistanceToEntity(var0);
      float var21 = (float)Math.toDegrees(Math.atan2(var15, var13)) - 90.0F;
      double var22 = (double)MathHelper.sqrt_double(var13 * var13 + var15 * var15);
      float var24 = (float)(-(Math.atan2(var17, var22) * 180.0D / 3.141592653589793D)) + (float)var19 * 0.11F;
      return new float[]{var21, -var24};
   }

   public static float c23582(Entity var0) {
      Module[] var1 = Value.c27574();
      return Math.abs(c43538(var0)[0] - c95594.thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(c43538(var0)[0] - c95594.thePlayer.rotationYaw) % 360.0F : Math.abs(c43538(var0)[0] - c95594.thePlayer.rotationYaw) % 360.0F;
   }

   public static float c57669(Entity var0, boolean var1) {
      EntityPlayerSP var2 = c95594.thePlayer;
      double var3 = var0.prevPosX - var2.prevPosX;
      double var5 = var0.prevPosZ - var2.prevPosZ;
      float var7 = var2.prevRotationYaw;
      float var8 = (float)(Math.atan2(var5, var3) * 180.0D / 3.141592653589793D) - 90.0F;
      return var7 + MathHelper.wrapAngleTo180_float(var8 - var7);
   }

   public static Vec3 c91353(float var0, float var1) {
      float var2 = MathHelper.cos(-var1 * 0.017453292F - 3.1415927F);
      float var3 = MathHelper.sin(-var1 * 0.017453292F - 3.1415927F);
      float var4 = -MathHelper.cos(-var0 * 0.017453292F);
      float var5 = MathHelper.sin(-var0 * 0.017453292F);
      return new Vec3((double)(var3 * var4), (double)var5, (double)(var2 * var4));
   }

   public static float c17271(float var0, float var1, float var2) {
      float var3 = 0.006F;
      float var4 = var2 * var2 * var2 * var2 - var3 * (var3 * var0 * var0 + 2.0F * var1 * var2 * var2);
      return (float)Math.toDegrees(Math.atan(((double)(var2 * var2) - Math.sqrt((double)var4)) / (double)(var3 * var0)));
   }

   public static float[] c43538(Entity var0) {
      Module[] var1 = Value.c27574();
      if (var0 == null) {
         return null;
      } else {
         double var2 = var0.posX - c95594.thePlayer.posX;
         double var4 = var0.posZ - c95594.thePlayer.posZ;
         if (var0 instanceof EntityLivingBase) {
            EntityLivingBase var8 = (EntityLivingBase)var0;
            double var6 = var8.posY + (double)var8.getEyeHeight() - (c95594.thePlayer.posY + (double)c95594.thePlayer.getEyeHeight());
         }

         double var12 = (var0.getEntityBoundingBox().minY + var0.getEntityBoundingBox().maxY) / 2.0D - (c95594.thePlayer.posY + (double)c95594.thePlayer.getEyeHeight());
         double var13 = (double)MathHelper.sqrt_double(var2 * var2 + var4 * var4);
         float var10 = (float)(Math.atan2(var4, var2) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(var12, var13) * 180.0D / 3.141592653589793D));
         return new float[]{var10, var11};
      }
   }

   public static boolean c625(Entity var0, float var1) {
      Module[] var2 = Value.c27574();
      return (Math.abs(c43538(var0)[0] - c95594.thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(c43538(var0)[0] - c95594.thePlayer.rotationYaw) % 360.0F : Math.abs(c43538(var0)[0] - c95594.thePlayer.rotationYaw) % 360.0F) <= var1;
   }

   public static float c2679() {
      float var0 = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return var0 * var0 * var0 * 8.0F * 0.15F;
   }

   public static float c9982(float var0, float var1, float var2) {
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

   public static float c4415(double var0, double var2) {
      Value.c27574();
      double var5 = var0 - Minecraft.getMinecraft().thePlayer.posX;
      double var7 = var2 - Minecraft.getMinecraft().thePlayer.posZ;
      if (var7 < 0.0D && var5 < 0.0D) {
         double var9 = 90.0D + Math.toDegrees(Math.atan(var7 / var5));
      }

      if (var7 < 0.0D && var5 > 0.0D) {
         double var11 = -90.0D + Math.toDegrees(Math.atan(var7 / var5));
      }

      double var12 = Math.toDegrees(-Math.atan(var5 / var7));
      return MathHelper.wrapAngleTo180_float(-(Minecraft.getMinecraft().thePlayer.rotationYaw - (float)var12));
   }

   public static float[] c8250(Entity var0, double var1) {
      Module[] var3 = Value.c27574();
      if (var0 == null) {
         System.out.println("Fuck you ! Entity is nul!");
         return null;
      } else {
         double var4 = var0.posX - Minecraft.getMinecraft().thePlayer.posX;
         double var6 = var0.posZ - Minecraft.getMinecraft().thePlayer.posZ;
         PositionB var8 = new PositionB(var0.posX, var0.posY, var0.posZ);
         PositionB var9 = new PositionB(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight(), Minecraft.getMinecraft().thePlayer.posZ);
         double var10 = var0.getEntityBoundingBox().minY + 0.7D;
         if (var10 < var0.getEntityBoundingBox().maxY - 0.1D) {
            if (var9.c1740(new PositionB(var0.posX, var10, var0.posZ)) < var9.c1740(var8)) {
               var8 = new PositionB(var0.posX, var10, var0.posZ);
            }

            var10 = var10 + 0.1D;
         }

         if (var9.c1740(var8) >= var1) {
            return null;
         } else {
            var10 = var8.c72985() - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
            double var12 = (double)MathHelper.sqrt_double(var4 * var4 + var6 * var6);
            float var14 = (float)(Math.atan2(var6, var4) * 180.0D / 3.141592653589793D) - 90.0F;
            float var15 = (float)(-(Math.atan2(var10, var12) * 180.0D / 3.141592653589793D));
            return new float[]{var14, var15};
         }
      }
   }

   public static float c63455(double var0, double var2, float var4) {
      Value.c27574();
      double var6 = var0 - Minecraft.getMinecraft().thePlayer.posX;
      double var8 = var2 - Minecraft.getMinecraft().thePlayer.posZ;
      if (var8 < 0.0D && var6 < 0.0D) {
         double var10 = 90.0D + Math.toDegrees(Math.atan(var8 / var6));
      }

      if (var8 < 0.0D && var6 > 0.0D) {
         double var12 = -90.0D + Math.toDegrees(Math.atan(var8 / var6));
      }

      double var13 = Math.toDegrees(-Math.atan(var6 / var8));
      return MathHelper.wrapAngleTo180_float(-(var4 - (float)var13));
   }

   public static float[] c88961(Entity var0) {
      return null;
   }

   public static Vec3 getVectorForRotation(float var0, float var1) {
      float var2 = MathHelper.cos(-var0 * 0.017453292F - 3.1415927F);
      float var3 = MathHelper.sin(-var0 * 0.017453292F - 3.1415927F);
      float var4 = -MathHelper.cos(-var1 * 0.017453292F);
      float var5 = MathHelper.sin(-var1 * 0.017453292F);
      return new Vec3((double)(var3 * var4), (double)var5, (double)(var2 * var4));
   }

   public static float c80996() {
      return (float)(Math.pow((double)c95594.gameSettings.mouseSensitivity * 0.6D + 0.2D, 3.0D) * 1.2D);
   }

   public static float[] c16718(double var0, double var2, double var4) {
      double var6 = var0 - c95594.thePlayer.posX;
      double var8 = var2 - c95594.thePlayer.posY - (double)c95594.thePlayer.getEyeHeight();
      double var10 = var4 - c95594.thePlayer.posZ;
      double var12 = Math.sqrt(var6 * var6 + var10 * var10);
      float var14 = (float)Math.toDegrees(-Math.atan2(var6, var10));
      float var15 = (float)Math.toDegrees(-Math.atan2(var8, var12));
      return new float[]{var14, var15};
   }

   public static float[] c30890(EntityLivingBase var0, boolean var1) {
      Value.c27574();
      float var3 = c95594.timer.renderPartialTicks;
      double var4 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)var3;
      double var6 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)var3;
      double var8 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)var3;
      double var10 = c95594.thePlayer.posY - var6;
      double var12 = var10 >= 0.0D ? var6 + (double)var0.getEyeHeight() : (-var10 < (double)c95594.thePlayer.getEyeHeight() ? c95594.thePlayer.posY + (double)c95594.thePlayer.getEyeHeight() : var6);
      return c16718(var4, var12, var8);
   }

   private static JSONException c68013(JSONException var0) {
      return var0;
   }
}
