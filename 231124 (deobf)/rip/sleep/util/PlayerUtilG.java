package rip.sleep.util;

import rip.sleep.injection.in.IEntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class PlayerUtilG {
   private static final Minecraft c53466 = Minecraft.getMinecraft();

   public static double c85255() {
      Value.c27574();
      float var1 = c53466.thePlayer.rotationYaw;
      if (c53466.thePlayer.moveForward < 0.0F) {
         var1 += 180.0F;
      }

      float var2 = 1.0F;
      if (c53466.thePlayer.moveForward < 0.0F) {
         var2 = -0.5F;
      }

      if (c53466.thePlayer.moveForward > 0.0F) {
         var2 = 0.5F;
      }

      if (c53466.thePlayer.moveStrafing > 0.0F) {
         float var3 = 90.0F * var2;
         var1 -= var3;
      }

      if (c53466.thePlayer.moveStrafing < 0.0F) {
         var1 += 90.0F * var2;
      }

      return Math.toRadians((double)var1);
   }

   public static void c26858(double var0) {
      if (PlayerUtil.c71257()) {
         double var2 = c85255();
         c53466.thePlayer.motionX = -Math.sin(var2) * var0;
         c53466.thePlayer.motionZ = Math.cos(var2) * var0;
      }

   }

   public static float c80081() {
      float var0 = (float)Math.sqrt(ChatUtilA.mc.thePlayer.motionX * ChatUtilA.mc.thePlayer.motionX + ChatUtilA.mc.thePlayer.motionZ * ChatUtilA.mc.thePlayer.motionZ);
      return var0;
   }

   public static boolean c25285() {
      Module[] var0 = Value.c27574();
      return ChatUtilA.mc.thePlayer.moveForward != 0.0F || ChatUtilA.mc.thePlayer.moveStrafing != 0.0F;
   }

   public static int c23459() {
      Module[] var0 = Value.c27574();
      return ChatUtilA.mc.thePlayer.isPotionActive(Potion.jump) ? ChatUtilA.mc.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static boolean c36327(double var0) {
      Module[] var2 = Value.c27574();
      return !ChatUtilA.mc.theWorld.getCollidingBoundingBoxes(ChatUtilA.mc.thePlayer, ChatUtilA.mc.thePlayer.getEntityBoundingBox().offset(0.0D, -var0, 0.0D)).isEmpty();
   }

   public static boolean c42924() {
      Module[] var0 = Value.c27574();
      return ChatUtilA.mc.thePlayer.getCurrentEquippedItem() != null && ChatUtilA.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword;
   }

   public static boolean c15741() {
      boolean var1 = false;
      Value.c27574();
      AxisAlignedBB var2 = c53466.thePlayer.getEntityBoundingBox();
      int var3 = (int)var2.minY;
      int var4 = MathHelper.floor_double(var2.minX);
      if (var4 < MathHelper.floor_double(var2.maxX) + 1) {
         int var5 = MathHelper.floor_double(var2.minZ);
         if (var5 < MathHelper.floor_double(var2.maxZ) + 1) {
            Block var6 = c53466.theWorld.getBlockState(new BlockPos(var4, var3, var5)).getBlock();
            if (var6 instanceof BlockAir) {
               ;
            }

            if (!(var6 instanceof BlockLiquid)) {
               return false;
            }

            var1 = true;
            ++var5;
         }

         ++var4;
      }

      return var1;
   }

   public static boolean c12178() {
      Module[] var0 = Value.c27574();
      return c53466.gameSettings.keyBindForward.pressed || c53466.gameSettings.keyBindLeft.pressed || c53466.gameSettings.keyBindRight.pressed || c53466.gameSettings.keyBindBack.pressed;
   }

   public static boolean c91233() {
      return c53466.theWorld.getBlockState(new BlockPos(c53466.thePlayer.posX, c53466.thePlayer.posY, c53466.thePlayer.posZ)).getBlock().getMaterial() == Material.water;
   }

   public static void c11143(String var0) {
      Module[] var1 = Value.c27574();
      if (c53466.thePlayer != null) {
         c53466.thePlayer.addChatMessage(new ChatComponentText("§c[DEBUG] §r" + var0));
      }

   }

   public static double c64091() {
      double var0 = c53466.thePlayer.posX - c53466.thePlayer.prevPosX;
      double var2 = c53466.thePlayer.posZ - c53466.thePlayer.prevPosZ;
      return Math.sqrt(var0 * var0 + var2 * var2);
   }

   public static float[] c81096(EntityLivingBase var0) {
      double var1 = var0.posX - c53466.thePlayer.posX;
      double var3 = var0.posZ - c53466.thePlayer.posZ;
      double var5 = var0.posY + (double)var0.getEyeHeight() - (c53466.thePlayer.getEntityBoundingBox().minY + (c53466.thePlayer.getEntityBoundingBox().maxY - c53466.thePlayer.getEntityBoundingBox().minY));
      double var7 = (double)MathHelper.sqrt_double(var1 * var1 + var3 * var3);
      float var9 = (float)(MathHelper.atan2(var3, var1) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(MathHelper.atan2(var5, var7) * 180.0D / 3.141592653589793D));
      return new float[]{var9, var10};
   }

   public static float c39780() {
      Value.c27574();
      PotionEffect var1 = c53466.thePlayer.getActivePotionEffect(Potion.jump);
      int var2 = var1 != null ? var1.getAmplifier() + 1 : 0;
      return (float)(c53466.thePlayer.getMaxFallHeight() + var2);
   }

   public static boolean c94648() {
      Module[] var0 = Value.c27574();
      return c53466.thePlayer.posY % 0.015625D == 0.0D;
   }

   public static boolean c81970() {
      AxisAlignedBB var1 = c53466.thePlayer.getEntityBoundingBox();
      Value.c27574();
      int var2 = MathHelper.floor_double(var1.minX);
      if (var2 < MathHelper.floor_double(var1.maxX) + 1) {
         int var3 = MathHelper.floor_double(var1.minY);
         if (var3 < MathHelper.floor_double(var1.maxY) + 1) {
            int var4 = MathHelper.floor_double(var1.minZ);
            if (var4 < MathHelper.floor_double(var1.maxZ) + 1) {
               Block var5 = c53466.theWorld.getBlockState(new BlockPos(var2, var3, var4)).getBlock();
               AxisAlignedBB var6;
               if (!(var5 instanceof BlockAir) && (var6 = var5.getCollisionBoundingBox(c53466.theWorld, new BlockPos(var2, var3, var4), c53466.theWorld.getBlockState(new BlockPos(var2, var3, var4)))) != null && var1.intersectsWith(var6)) {
                  return true;
               }

               ++var4;
            }

            ++var3;
         }

         ++var2;
      }

      return false;
   }

   public static boolean c5865() {
      Value.c27574();
      int var1 = 0;
      if ((double)var1 < c53466.thePlayer.posY + (double)c53466.thePlayer.getEyeHeight()) {
         BlockPos var2 = new BlockPos(c53466.thePlayer.posX, (double)var1, c53466.thePlayer.posZ);
         if (c53466.theWorld.getBlockState(var2).getBlock() != Blocks.air) {
            return true;
         }

         var1 = var1 + 2;
      }

      return false;
   }

   public static boolean c13194() {
      Module[] var0 = Value.c27574();
      return c53466.gameSettings.keyBindAttack.isKeyDown() && ((IEntityPlayer)c53466.thePlayer).isAllowEdit() && c53466.objectMouseOver.typeOfHit.equals(MovingObjectType.BLOCK);
   }

   private static JSONException c81527(JSONException var0) {
      return var0;
   }
}
