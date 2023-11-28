package rip.sleep.util;

import java.util.Random;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.struct.VectorStructB;

public class PlayerUtilF {
   public static float c45510() {
      return ChatUtilA.mc.thePlayer.rotationPitch;
   }

   public static void c27128(float var0) {
      ChatUtilA.mc.thePlayer.rotationPitch = var0;
   }

   public static float c60215() {
      return ChatUtilA.mc.thePlayer.rotationYaw;
   }

   public static void c16098(float var0) {
      ChatUtilA.mc.thePlayer.rotationYaw = var0;
   }

   public static float[] c14047(Entity var0, float var1, float var2, boolean var3) {
      Value.c27574();
      double var7 = var0.posX - ChatUtilA.mc.thePlayer.posX;
      double var9 = var0.posZ - ChatUtilA.mc.thePlayer.posZ;
      if (var0 instanceof EntityLivingBase) {
         EntityLivingBase var11 = (EntityLivingBase)var0;
         double var5 = var11.posY + (double)var11.getEyeHeight() - (ChatUtilA.mc.thePlayer.posY + (double) ChatUtilA.mc.thePlayer.getEyeHeight());
      }

      double var18 = (var0.getEntityBoundingBox().minY + var0.getEntityBoundingBox().maxY) / 2.0D - (ChatUtilA.mc.thePlayer.posY + (double) ChatUtilA.mc.thePlayer.getEyeHeight());
      new Random();
      double var12 = (double)MathHelper.sqrt_double(var7 * var7 + var9 * var9);
      float var14 = (float)(Math.atan2(var9, var7) * 180.0D / 3.141592653589793D) - 90.0F;
      float var15 = (float)(-Math.atan2(var18 - (var0 instanceof EntityPlayer ? 0.25D : 0.0D), var12) * 180.0D / 3.141592653589793D);
      float var16 = c55769(ChatUtilA.mc.thePlayer.rotationPitch, var15, var2);
      float var17 = c55769(ChatUtilA.mc.thePlayer.rotationYaw, var14, var1);
      return new float[]{var17, var16};
   }

   public static float c55769(float var0, float var1, float var2) {
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

   public static float[] c19336(Entity var0) {
      double var1 = Minecraft.getMinecraft().thePlayer.posX;
      double var3 = Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight();
      double var5 = Minecraft.getMinecraft().thePlayer.posZ;
      double var7 = var0.posX;
      double var9 = var0.posY + (double)var0.getEyeHeight();
      double var11 = var0.posZ;
      double var13 = var1 - var7;
      double var15 = var3 - var9;
      double var17 = var5 - var11;
      double var19 = Math.sqrt(Math.pow(var13, 2.0D) + Math.pow(var17, 2.0D));
      float var21 = 0.0F;
      float var22 = 0.0F;
      var21 = (float)(Math.toDegrees(Math.atan2(var17, var13)) + 90.0D);
      var22 = (float)Math.toDegrees(Math.atan2(var19, var15));
      return new float[]{var21, 90.0F - var22};
   }

   public static float[] c32813(Entity var0) {
      Module[] var1 = Value.c27574();
      if (var0 == null) {
         return null;
      } else {
         double var4 = var0.posX - ChatUtilA.mc.thePlayer.posX;
         double var6 = var0.posZ - ChatUtilA.mc.thePlayer.posZ;
         if (var0 instanceof EntityLivingBase) {
            EntityLivingBase var8 = (EntityLivingBase)var0;
            double var2 = var8.posY + ((double)var8.getEyeHeight() - 0.4D) - (ChatUtilA.mc.thePlayer.posY + (double) ChatUtilA.mc.thePlayer.getEyeHeight());
         }

         double var12 = (var0.getCollisionBoundingBox().minY + var0.getCollisionBoundingBox().maxY) / 2.0D - (ChatUtilA.mc.thePlayer.posY + (double) ChatUtilA.mc.thePlayer.getEyeHeight());
         double var13 = (double)MathHelper.sqrt_double(var4 * var4 + var6 * var6);
         float var10 = (float)(Math.atan2(var6, var4) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-Math.atan2(var12, var13) * 180.0D / 3.141592653589793D);
         return new float[]{var10, var11};
      }
   }

   public static float[] c6484(BlockPos var0) {
      return c18655(ChatUtilA.mc.thePlayer.getPositionVector().addVector(0.0D, (double) ChatUtilA.mc.thePlayer.getEyeHeight(), 0.0D), new Vec3((double)var0.getX() + 0.5D, (double)var0.getY() + 0.5D, (double)var0.getZ() + 0.5D));
   }

   public static float[] c67024(Vec3 var0) {
      return c18655(ChatUtilA.mc.thePlayer.getPositionVector().addVector(0.0D, (double) ChatUtilA.mc.thePlayer.getEyeHeight(), 0.0D), var0);
   }

   public static Vec3 c24489(Vec3 var0) {
      return new Vec3(var0.xCoord, 0.0D, var0.zCoord);
   }

   public static float[] c18655(Vec3 var0, Vec3 var1) {
      Vec3 var2 = var1.subtract(var0);
      double var3 = c24489(var2).lengthVector();
      float var5 = (float)Math.toDegrees(Math.atan2(var2.zCoord, var2.xCoord)) - 90.0F;
      float var6 = (float)(-Math.toDegrees(Math.atan2(var2.yCoord, var3)));
      return new float[]{var5, var6};
   }

   public static int c13341(float var0, int var1) {
      Value.c27574();
      int var3 = (int)((double)(var0 + (float)(360 / (2 * var1))) + 0.5D) % 360;
      if (var3 < 0) {
         var3 += 360;
      }

      return var3 / (360 / var1);
   }

   public static boolean c86687(Entity var0) {
      Vec3 var2 = new Vec3(ChatUtilA.mc.thePlayer.posX, ChatUtilA.mc.thePlayer.posY + (double) ChatUtilA.mc.thePlayer.getEyeHeight(), ChatUtilA.mc.thePlayer.posZ);
      AxisAlignedBB var3 = var0.getEntityBoundingBox();
      Vec3 var4 = new Vec3(var0.posX, var0.posY + (double)(var0.getEyeHeight() / 1.32F), var0.posZ);
      Value.c27574();
      double var5 = var0.posX - 0.25D;
      double var7 = var0.posX + 0.25D;
      double var9 = var0.posY;
      double var11 = var0.posY + Math.abs(var0.posY - var3.maxY);
      double var13 = var0.posZ - 0.25D;
      double var15 = var0.posZ + 0.25D;
      boolean var17 = ChatUtilA.mc.theWorld.rayTraceBlocks(var2, var4) == null;
      return true;
   }

   public static float c26164(float var0, double var1, double var3, double var5) {
      Value.c27574();
      double var8 = var1 - ChatUtilA.mc.thePlayer.posX;
      double var10 = var3 - ChatUtilA.mc.thePlayer.posY;
      double var12 = var5 - ChatUtilA.mc.thePlayer.posZ;
      double var14 = 0.0D;
      double var16 = Math.toDegrees(Math.atan(var12 / var8));
      if (var12 < 0.0D && var8 < 0.0D) {
         if (var8 == 0.0D) {
            return MathHelper.wrapAngleTo180_float(-(var0 - (float)var14));
         }

         var14 = 90.0D + var16;
      }

      if (var12 < 0.0D && var8 > 0.0D) {
         if (var8 == 0.0D) {
            return MathHelper.wrapAngleTo180_float(-(var0 - (float)var14));
         }

         var14 = -90.0D + var16;
      }

      if (var12 != 0.0D) {
         var14 = Math.toDegrees(-Math.atan(var8 / var12));
      }

      return MathHelper.wrapAngleTo180_float(-(var0 - (float)var14));
   }

   public static float c55683(float var0, double var1, double var3, double var5) {
      double var7 = var1 - ChatUtilA.mc.thePlayer.posX;
      double var9 = var3 - ChatUtilA.mc.thePlayer.posY;
      double var11 = var5 - ChatUtilA.mc.thePlayer.posZ;
      double var13 = (double)MathHelper.sqrt_double(var7 * var7 + var11 * var11);
      double var15 = -Math.toDegrees(Math.atan(var9 / var13));
      return -MathHelper.wrapAngleTo180_float(var0 - (float)var15) - 2.5F;
   }

   public static float[] c85252(BlockPos var0) {
      return c24798(ChatUtilA.mc.thePlayer.getPositionVector().addVector(0.0D, (double) ChatUtilA.mc.thePlayer.getEyeHeight(), 0.0D), new Vec3((double)var0.getX() + 0.5D, (double)var0.getY() + 0.5D, (double)var0.getZ() + 0.5D));
   }

   private static float[] c24798(Vec3 var0, Vec3 var1) {
      Vec3 var2 = var1.subtract(var0);
      double var3 = c24489(var2).lengthVector();
      float var5 = (float)Math.toDegrees(Math.atan2(var2.zCoord, var2.xCoord)) - 90.0F;
      float var6 = (float)(-Math.toDegrees(Math.atan2(var2.yCoord, var3)));
      float var7 = ChatUtilA.mc.thePlayer.renderYawOffset + MathHelper.wrapAngleTo180_float(var5 - ChatUtilA.mc.thePlayer.renderYawOffset);
      return new float[]{var5, MathHelper.clamp_float(var6, -90.0F, 90.0F), var7};
   }

   public static float c74612(float var0, float var1) {
      Value.c27574();
      float var3 = Math.abs(var0 - var1) % 360.0F;
      if (var3 > 180.0F) {
         var3 = 360.0F - var3;
      }

      return var3;
   }

   public static float[] c72653(EntityLivingBase var0) {
      return null;
   }

   public static float c61005(EntityLivingBase var0) {
      Value.c27574();
      int[] var3 = new int[]{2, 4, 6, 8, 10};
      float var4 = 0.0F;
      boolean var5 = false;
      int var2 = 0;
      if (var2 < 10) {
         if (var0.hurtTime <= var3[0]) {
            var2 = var3[0];
         }

         if (var0.hurtTime <= var3[1]) {
            var2 = var3[1];
         }

         if (var0.hurtTime <= var3[2]) {
            var2 = var3[2];
         }

         if (var0.hurtTime <= var3[3]) {
            var2 = var3[3];
         }

         if (var0.hurtTime <= var3[4]) {
            var2 = var3[4];
         }

         if (var2 <= 2) {
            var4 = (float)(Math.random() * -0.05000000074505806D);
         }

         if (var2 <= 4) {
            var4 = 0.0F;
         }

         if (var2 <= 6) {
            var4 = 0.0F;
         }

         if (var2 <= 8) {
            var4 = 0.0F;
         }

         if (var2 <= 10) {
            var4 = (float)(Math.random() * 0.05000000074505806D);
         }

         ++var2;
      }

      if (var4 > 1.0F) {
         var4 = 0.0F;
      }

      return var4;
   }

   public static float[] c7898(EntityLivingBase var0) {
      double var1 = var0.posX;
      double var3 = var0.posZ;
      double var5 = var0.posY + (double)(var0.getEyeHeight() / 2.0F);
      Vec3 var7 = new Vec3(var0.posX, var5, var0.posZ);
      Vec3 var8 = new Vec3(ChatUtilA.mc.thePlayer.posX, ChatUtilA.mc.thePlayer.posY + 1.35D + (double)(c61005(var0) * 10.0F), ChatUtilA.mc.thePlayer.posZ);
      return c18655(var8, var7);
   }

   public static double[] c99106(double var0, double var2, double var4) {
      double var6 = (double)MathHelper.sqrt_double(var0 * var0 + var2 * var2);
      double var8 = Math.atan2(var2, var0) * 180.0D / 3.141592653589793D - 90.0D;
      double var10 = -(Math.atan2(var4, var6) * 180.0D / 3.141592653589793D);
      return new double[]{(double)(ChatUtilA.mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float((float)(var8 - (double) ChatUtilA.mc.thePlayer.rotationYaw))), (double)(ChatUtilA.mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float((float)(var10 - (double) ChatUtilA.mc.thePlayer.rotationPitch)))};
   }

   public static boolean c10957(PacketReceiveEvent var0, RotationUtilE var1) {
      Value.c27574();
      Packet var3 = PacketReceiveEvent.getPacket();
      if (var3 instanceof S08PacketPlayerPosLook) {
         S08PacketPlayerPosLook var4 = (S08PacketPlayerPosLook)var3;
         float var5 = var4.getYaw();
         float var6 = var4.getPitch();
         var5 = var1.c28107();
         var6 = var1.c79255();
         var0.c48559(var4);
         return true;
      } else {
         return false;
      }
   }

   public static float[] c53905(double var0, double var2, double var4) {
      EntityPlayerSP var6 = Minecraft.getMinecraft().thePlayer;
      double var7 = var0 - var6.posX;
      double var9 = var2 - (var6.posY + (double)var6.getEyeHeight());
      double var11 = var4 - var6.posZ;
      double var13 = (double)MathHelper.sqrt_double(var7 * var7 + var11 * var11);
      float var15 = (float)(Math.atan2(var11, var7) * 180.0D / 3.141592653589793D) - 90.0F;
      float var16 = (float)(-(Math.atan2(var9, var13) * 180.0D / 3.141592653589793D));
      return new float[]{var15, var16};
   }

   public static RotationUtilE c60383(double var0, double var2, double var4) {
      double var6 = var0 - (Minecraft.getMinecraft().thePlayer.prevPosX + (Minecraft.getMinecraft().thePlayer.posX - Minecraft.getMinecraft().thePlayer.prevPosX));
      double var8 = var2 - (Minecraft.getMinecraft().thePlayer.prevPosY + (Minecraft.getMinecraft().thePlayer.posY - Minecraft.getMinecraft().thePlayer.prevPosY) + (Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().maxY - Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY));
      double var10 = var4 - (Minecraft.getMinecraft().thePlayer.prevPosZ + (Minecraft.getMinecraft().thePlayer.posZ - Minecraft.getMinecraft().thePlayer.prevPosZ));
      double var12 = (double)MathHelper.sqrt_double(var6 * var6 + var10 * var10);
      return new RotationUtilE((float)(Math.atan2(var10, var6) * 180.0D / 3.141592653589793D) - 90.0F, (float)(-(Math.atan2(var8, var12) * 180.0D / 3.141592653589793D)));
   }

   public static float c75319(float var0, float var1) {
      return MathHelper.wrapAngleTo180_float(var1 - var0);
   }

   private static float c78370(float var0, float var1) {
      return ((var0 - var1) % 360.0F + 540.0F) % 360.0F - 180.0F;
   }

   public static RotationUtilE c69351(EntityLivingBase var0) {
      double var1 = var0.prevPosX + (var0.posX - var0.prevPosX);
      double var3 = var0.prevPosY + (var0.posY - var0.prevPosY);
      double var5 = var0.prevPosZ + (var0.posZ - var0.prevPosZ);
      return c60383(var1, var3, var5);
   }

   public static float[] c63803(float[] var0, float[] var1) {
      Minecraft var2 = Minecraft.getMinecraft();
      float var3 = var0[0];
      float var4 = var0[1];
      float var5 = var1[0];
      float var6 = var1[1];
      float var7 = var2.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      float var8 = var7 * var7 * var7 * 1.2F;
      float var9 = var3 - var5;
      float var10 = var4 - var6;
      float var11 = var9 - var9 % var8;
      float var12 = var10 - var10 % var8;
      float var13 = var5 + var11;
      float var14 = var6 + var12;
      return new float[]{var13, var14};
   }

   public static float[] c66573(Vector3d var0, Vector3d var1) {
      double var2 = var1.x - var0.x;
      double var4 = var1.y - var0.y;
      double var6 = var1.z - var0.z;
      double var8 = Math.sqrt(var2 * var2 + var6 * var6);
      float var10 = (float)Math.toDegrees(Math.atan2(var6, var2)) - 90.0F;
      float var11 = (float)(-Math.toDegrees(Math.atan2(var4, var8)));
      return new float[]{MathHelper.wrapAngleTo180_float(var10), MathHelper.wrapAngleTo180_float(var11)};
   }

   public static void c45770(MotionUpdateEvent var0, float[] var1, float var2, boolean var3) {
      Value.c27574();
      float[] var5 = new float[]{MotionUpdateEvent.c16556(), MotionUpdateEvent.c42229()};
      float[] var6 = new float[]{c93937(var5[0], var1[0], var2), c93937(var5[1], var1[1], var2)};
      var6[0] = MathHelper.wrapAngleTo180_float(var6[0] - var5[0]) + var5[0];
      var6[1] = MathHelper.wrapAngleTo180_float(var6[1] - var5[1]) + var5[1];
      var6 = c81152(var6, var5);
      Minecraft.getMinecraft().thePlayer.rotationYaw = var6[0];
      Minecraft.getMinecraft().thePlayer.rotationPitch = var6[1];
      var0.c6297(var6[0]);
      var0.c78602(var6[1]);
   }

   public static float[] c81152(float[] var0, float[] var1) {
      float[] var2 = new float[]{var0[0] - var1[0], var0[1] - var1[1]};
      float var3 = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      float var4 = var3 * var3 * var3 * 1.2F;
      var0[0] -= var2[0] % var4;
      var0[1] -= var2[1] % var4;
      return var0;
   }

   public static float c93937(float var0, float var1, float var2) {
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

   public static float[] c7007(EntityLivingBase var0) {
      Value.c27574();
      double var2 = var0.posX + (var0.posX - var0.lastTickPosX) - Minecraft.getMinecraft().thePlayer.posX;
      double var4 = var0.posY - 3.5D + (double)var0.getEyeHeight() - Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight();
      double var6 = var0.posZ + (var0.posZ - var0.lastTickPosZ) - Minecraft.getMinecraft().thePlayer.posZ;
      double var8 = Math.sqrt(Math.pow(var2, 2.0D) + Math.pow(var6, 2.0D));
      float var10 = (float)Math.toDegrees(-Math.atan(var2 / var6));
      float var11 = (float)(-Math.toDegrees(Math.atan(var4 / var8)));
      if (var2 < 0.0D && var6 < 0.0D) {
         var10 = (float)(90.0D + Math.toDegrees(Math.atan(var6 / var2)));
      }

      if (var2 > 0.0D && var6 < 0.0D) {
         var10 = (float)(-90.0D + Math.toDegrees(Math.atan(var6 / var2)));
      }

      return new float[]{var10, var11};
   }

   public static float[] c36553(double var0, double var2, double var4) {
      Value.c27574();
      double var7 = var0 - Minecraft.getMinecraft().thePlayer.posX;
      double var9 = var2 - Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight();
      double var11 = var4 - Minecraft.getMinecraft().thePlayer.posZ;
      double var13 = Math.sqrt(Math.pow(var7, 2.0D) + Math.pow(var11, 2.0D));
      float var15 = (float)Math.toDegrees(-Math.atan(var7 / var11));
      float var16 = (float)(-Math.toDegrees(Math.atan(var9 / var13)));
      if (var7 < 0.0D && var11 < 0.0D) {
         var15 = (float)(90.0D + Math.toDegrees(Math.atan(var11 / var7)));
      }

      if (var7 > 0.0D && var11 < 0.0D) {
         var15 = (float)(-90.0D + Math.toDegrees(Math.atan(var11 / var7)));
      }

      return new float[]{var15, var16};
   }

   public static VectorStructB c74292() {
      return new VectorStructB(ChatUtilA.mc.thePlayer.posX, ChatUtilA.mc.thePlayer.posY, ChatUtilA.mc.thePlayer.posZ);
   }

   public static Vector2f c58501(VectorStructB var0) {
      return c92529(c74292().c25858(0.0D, (double) ChatUtilA.mc.thePlayer.getEyeHeight(), 0.0D), var0);
   }

   public static Vector2f c92529(VectorStructB var0, VectorStructB var1) {
      VectorStructB var2 = var1.c51656(var0);
      double var3 = Math.hypot(var2.c71335(), var2.c96564());
      float var5 = (float)(MathHelper.atan2(var2.c96564(), var2.c71335()) * 180.0D / 3.1415927410125732D) - 90.0F;
      float var6 = (float)(-(MathHelper.atan2(var2.c20755(), var3) * 180.0D / 3.1415927410125732D));
      return new Vector2f(var5, var6);
   }

   public static float c86058(float var0, double var1, double var3) {
      Minecraft var6 = Minecraft.getMinecraft();
      Value.c27574();
      double var7 = var1 - var6.thePlayer.posX;
      double var9 = var3 - var6.thePlayer.posZ;
      double var11 = 0.0D;
      if (var9 < 0.0D && var7 < 0.0D) {
         if (var7 == 0.0D) {
            return MathHelper.wrapAngleTo180_float(-(var0 - (float)var11));
         }

         var11 = 90.0D + Math.toDegrees(Math.atan(var9 / var7));
      }

      if (var9 < 0.0D && var7 > 0.0D) {
         if (var7 == 0.0D) {
            return MathHelper.wrapAngleTo180_float(-(var0 - (float)var11));
         }

         var11 = -90.0D + Math.toDegrees(Math.atan(var9 / var7));
      }

      if (var9 != 0.0D) {
         var11 = Math.toDegrees(-Math.atan(var7 / var9));
      }

      return MathHelper.wrapAngleTo180_float(-(var0 - (float)var11));
   }

   public static float c44415(float var0, Entity var1, double var2) {
      double var4 = var1.posX - Minecraft.getMinecraft().thePlayer.posX;
      double var6 = var1.posZ - Minecraft.getMinecraft().thePlayer.posZ;
      double var8 = var2 - 2.2D + (double)var1.getEyeHeight() - Minecraft.getMinecraft().thePlayer.posY;
      double var10 = (double)MathHelper.sqrt_double(var4 * var4 + var6 * var6);
      var8 = var1.posY - 3.5D + (var1.posY - var1.lastTickPosY) + (double)var1.getEyeHeight() * 1.3185D - Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight() - 0.25592D;
      double var14 = Math.sqrt(Math.pow(var4, 2.0D) + Math.pow(var6, 2.0D));
      double var12 = (double)((float)((double)((float)(-Math.toDegrees(Math.atan(var8 / var14))) - 2.0F) + (double)var1.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) * 0.2D) + 1.0F);
      return -MathHelper.wrapAngleTo180_float(var0 - (float)var12);
   }

   public static float c51903(float var0, float var1) {
      return MathHelper.wrapAngleTo180_float(-(var0 - var1));
   }

   public Vector2f c202(Vec3 var1, EnumFacing var2) {
      return c34370(new VectorStructB(var1.xCoord, var1.yCoord, var1.zCoord), var2);
   }

   public static Vector2f c34370(VectorStructB var0, EnumFacing var1) {
      double var2 = var0.c71335() + 0.5D;
      double var4 = var0.c20755() + 0.5D;
      double var6 = var0.c96564() + 0.5D;
      var2 = var2 + (double)var1.getDirectionVec().getX() * 0.5D;
      var4 = var4 + (double)var1.getDirectionVec().getY() * 0.5D;
      var6 = var6 + (double)var1.getDirectionVec().getZ() * 0.5D;
      return c58501(new VectorStructB(var2, var4, var6));
   }

   public static float[] c99987(double var0, double var2, double var4) {
      double var6 = var0 - ChatUtilA.mc.thePlayer.posX;
      double var8 = var2 - ChatUtilA.mc.thePlayer.posY - (double) ChatUtilA.mc.thePlayer.getEyeHeight();
      double var10 = var4 - ChatUtilA.mc.thePlayer.posZ;
      double var12 = Math.sqrt(var6 * var6 + var10 * var10);
      float var14 = (float)Math.toDegrees(-Math.atan2(var6, var10));
      float var15 = (float)Math.toDegrees(-Math.atan2(var8, var12));
      return new float[]{var14, var15};
   }

   private static JSONException c98015(JSONException var0) {
      return var0;
   }
}
