package rip.sleep.util;

import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;
import net.java.games.input.Mouse;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Timer;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class PlayerUtilC {
   public static Minecraft c33875 = Minecraft.getMinecraft();
   private static final Random c51703 = new Random();
   private static Field c40904 = null;
   private static Field c94272 = null;
   private static Field c17000 = null;
   private static Field c78380 = null;
   private static final Random c42363 = new Random();

   public static List<Entity> c24454() {
      return c33875.theWorld.getLoadedEntityList();
   }

   public static boolean c19441() {
      double var0 = c33875.thePlayer.posX;
      double var2 = c33875.thePlayer.posY - 1.0D;
      double var4 = c33875.thePlayer.posZ;
      BlockPos var6 = new BlockPos(MathHelper.floor_double(var0), MathHelper.floor_double(var2), MathHelper.floor_double(var4));
      return c33875.theWorld.isAirBlock(var6);
   }

   public static int c48427(int var0) {
      Module[] var1 = Value.c27574();
      if (c33875.thePlayer.inventory.getStackInSlot(var0) == null) {
         return 0;
      } else {
         ItemStack var2 = c33875.thePlayer.inventory.getStackInSlot(var0);
         return var2.getItem() instanceof ItemBlock ? var2.stackSize : 0;
      }
   }

   public static void c68387(int var0) {
      Module[] var1 = Value.c27574();
      if (c57761()) {
         c33875.thePlayer.inventory.currentItem = var0;
      }
   }

   public static int c98328() {
      return c33875.thePlayer.inventory.currentItem;
   }

   public static Timer c35264() {
      Field var10000 = c40904;
      Minecraft var10001 = c33875;

      try {
         return (Timer)var10000.get(var10001);
      } catch (IllegalAccessException | IndexOutOfBoundsException var1) {
         return null;
      }
   }

   public static void c5677(Entity var0, float var1, boolean var2) {
      Module[] var3 = Value.c27574();
      if (var0 != null) {
         float[] var4 = c63028(var0);
         if (var4 != null) {
            float var5 = var4[0];
            float var6 = var4[1] + 4.0F + var1;
            c33875.getNetHandler().addToSendQueue(new C05PacketPlayerLook(var5, var6, c33875.thePlayer.onGround));
            PlayerUtilG.c11143("Send");
            c33875.thePlayer.rotationYaw = var5;
            c33875.thePlayer.rotationPitch = var6;
         }
      }

   }

   public static float[] c63028(Entity var0) {
      Module[] var1 = Value.c27574();
      if (var0 == null) {
         return null;
      } else {
         double var2 = var0.posX - c33875.thePlayer.posX;
         if (var0 instanceof EntityLivingBase) {
            EntityLivingBase var6 = (EntityLivingBase)var0;
            double var4 = var6.posY + (double)var6.getEyeHeight() * 0.9D - (c33875.thePlayer.posY + (double)c33875.thePlayer.getEyeHeight());
         }

         double var12 = (var0.getEntityBoundingBox().minY + var0.getEntityBoundingBox().maxY) / 2.0D - (c33875.thePlayer.posY + (double)c33875.thePlayer.getEyeHeight());
         double var13 = var0.posZ - c33875.thePlayer.posZ;
         double var8 = (double)MathHelper.sqrt_double(var2 * var2 + var13 * var13);
         float var10 = (float)(Math.atan2(var13, var2) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(var12, var8) * 180.0D / 3.141592653589793D));
         return new float[]{c33875.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var10 - c33875.thePlayer.rotationYaw), c33875.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var11 - c33875.thePlayer.rotationPitch)};
      }
   }

   public static boolean c39907() {
      // $FF: Couldn't be decompiled
   }

   public static Random c82653() {
      return c51703;
   }

   public static void c64179() {
      Module[] var0 = Value.c27574();
      Class var10000 = Minecraft.class;
      String var10001 = "field_71428_T";

      try {
         c40904 = var10000.getDeclaredField(var10001);
      } catch (Exception var5) {
         var10000 = Minecraft.class;
         var10001 = "timer";

         try {
            c40904 = var10000.getDeclaredField(var10001);
         } catch (Exception var4) {
            ;
         }
      }

      if (c40904 != null) {
         c40904.setAccessible(true);
      }

      var10000 = MouseEvent.class;
      var10001 = "button";

      try {
         c94272 = var10000.getDeclaredField(var10001);
         c17000 = MouseEvent.class.getDeclaredField("buttonstate");
         c78380 = Mouse.class.getDeclaredField("buttons");
      } catch (Exception var3) {
         ;
      }

   }

   public static void c62733(int var0, boolean var1) {
      Value.c27574();
      MouseEvent var3 = new MouseEvent();
      ObfuscationReflectionHelper.setPrivateValue(MouseEvent.class, var3, Integer.valueOf(var0), new String[]{"button"});
      ObfuscationReflectionHelper.setPrivateValue(MouseEvent.class, var3, Boolean.valueOf(var1), new String[]{"buttonstate"});
      MinecraftForge.EVENT_BUS.post(var3);
      ByteBuffer var4 = (ByteBuffer)ObfuscationReflectionHelper.getPrivateValue(Mouse.class, (Object)null, new String[]{"buttons"});
      var4.put(var0, (byte)(var1 ? 1 : 0));
      ObfuscationReflectionHelper.setPrivateValue(Mouse.class, (Object)null, var4, new String[]{"buttons"});
   }

   public static boolean c96154() {
      Module[] var0 = Value.c27574();
      if (c33875.thePlayer.getCurrentEquippedItem() == null) {
         return false;
      } else {
         Item var1 = c33875.thePlayer.getCurrentEquippedItem().getItem();
         return var1 instanceof ItemSword || var1 instanceof ItemAxe;
      }
   }

   public static float c65263() {
      Value.c27574();
      float var1 = c33875.thePlayer.rotationYaw;
      if (c33875.thePlayer.moveForward < 0.0F) {
         var1 += 180.0F;
      }

      float var2 = 1.0F;
      if (c33875.thePlayer.moveForward < 0.0F) {
         var2 = -0.5F;
      }

      if (c33875.thePlayer.moveForward > 0.0F) {
         var2 = 0.5F;
      }

      if (c33875.thePlayer.moveStrafing > 0.0F) {
         var1 -= 90.0F * var2;
      }

      if (c33875.thePlayer.moveStrafing < 0.0F) {
         var1 += 90.0F * var2;
      }

      var1 = var1 * 0.017453292F;
      return var1;
   }

   public static boolean c34171() {
      Module[] var0 = Value.c27574();
      return Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().theWorld == null;
   }

   public static void c35696(String var0) {
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(var0), (ClipboardOwner)null);
   }

   public static boolean c57761() {
      Module[] var0 = Value.c27574();
      return c33875.thePlayer != null && c33875.theWorld != null;
   }

   public static boolean c21898() {
      return c33875.currentScreen == null;
   }

   public static double c70315(Entity var0) {
      return ((double)(c33875.thePlayer.rotationYaw - c35697(var0)) % 360.0D + 540.0D) % 360.0D - 180.0D;
   }

   public static float c35697(Entity var0) {
      double var1 = var0.posX - c33875.thePlayer.posX;
      double var3 = var0.posZ - c33875.thePlayer.posZ;
      double var5 = Math.atan2(var1, var3) * 57.2957795D;
      return (float)(var5 * -1.0D);
   }

   public static boolean c86101(Entity var0, float var1) {
      var1 = (float)((double)var1 * 0.5D);
      Value.c27574();
      double var3 = ((double)(c33875.thePlayer.rotationYaw - c35697(var0)) % 360.0D + 540.0D) % 360.0D - 180.0D;
      return var3 > 0.0D && var3 < (double)var1 || (double)(-var1) < var3 && var3 < 0.0D;
   }

   public static void c23352(MotionUpdateEvent var0, Entity var1, float var2) {
      Module[] var3 = Value.c27574();
      if (var1 != null) {
         float[] var4 = c79337(var1, var2);
         if (var4 != null) {
            float var5 = var4[0];
            float var6 = var4[1] + 4.0F;
            MotionUpdateEvent.c20086 = var5;
            MotionUpdateEvent.c49492 = var6;
         }
      }

   }

   public static void c3299(Entity var0, float var1) {
      Module[] var2 = Value.c27574();
      if (var0 != null) {
         float[] var3 = c79337(var0, var1);
         if (var3 != null) {
            float var4 = var3[0];
            float var5 = var3[1] + 4.0F;
            c33875.thePlayer.rotationYaw = var4;
            c33875.thePlayer.rotationPitch = var5;
         }
      }

   }

   public static float[] c79337(Entity var0, float var1) {
      Module[] var2 = Value.c27574();
      if (var0 == null) {
         return null;
      } else {
         double var3 = var0.posX - c33875.thePlayer.posX;
         if (var0 instanceof EntityLivingBase) {
            EntityLivingBase var7 = (EntityLivingBase)var0;
            double var5 = var7.posY + (double)var7.getEyeHeight() * 0.9D - (c33875.thePlayer.posY + (double)c33875.thePlayer.getEyeHeight());
         }

         double var13 = (var0.getEntityBoundingBox().minY + var0.getEntityBoundingBox().maxY) / 2.0D + (double)var1 - (c33875.thePlayer.posY + (double)c33875.thePlayer.getEyeHeight());
         double var14 = var0.posZ - c33875.thePlayer.posZ;
         double var9 = (double)MathHelper.sqrt_double(var3 * var3 + var14 * var14);
         float var11 = (float)(Math.atan2(var14, var3) * 180.0D / 3.141592653589793D) - 90.0F;
         float var12 = (float)(-(Math.atan2(var13, var9) * 180.0D / 3.141592653589793D));
         return new float[]{c33875.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var11 - c33875.thePlayer.rotationYaw), c33875.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var12 - c33875.thePlayer.rotationPitch)};
      }
   }

   public static double c11965(Entity var0, float var1) {
      return (double)(c33875.thePlayer.rotationPitch - c68422(var0, var1));
   }

   public static float c68422(Entity var0, float var1) {
      double var2 = (double)c33875.thePlayer.getDistanceToEntity(var0);
      double var4 = c33875.thePlayer.posY - (var0.posY + (double)var1);
      double var6 = Math.atan2(var2, var4) * 180.0D / 3.141592653589793D;
      return (float)(90.0D - var6);
   }

   private static Exception c47004(Exception var0) {
      return var0;
   }

   public static enum c24800 {
      c33953,
      c64756;
   }
}
