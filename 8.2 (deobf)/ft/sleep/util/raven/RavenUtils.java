//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.raven;

import ft.sleep.api.events.world.EventPreUpdate;
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
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class RavenUtils {
   public static Minecraft channel$ = Minecraft.getMinecraft();
   public static Random effect$ = new Random();
   public static Field entering$ = null;
   public static Field aspects$ = null;
   public static Field created$ = null;
   public static Field longest$ = null;
   public static Random reform$ = new Random();

   public static List _striking() {
      return channel$.theWorld.getLoadedEntityList();
   }

   public static boolean _tract() {
      Object gurucoca = channel$.thePlayer.posX;
      Object nedogaso = channel$.thePlayer.posY - 1.0D;
      double var4 = channel$.thePlayer.posZ;
      BlockPos var6 = new BlockPos(MathHelper.floor_double(gurucoca), MathHelper.floor_double(nedogaso), MathHelper.floor_double(var4));
      return channel$.theWorld.isAirBlock(var6);
   }

   public static int _share(int pointed) {
      if (channel$.thePlayer.inventory.getStackInSlot((int)pointed) == null) {
         return 0;
      } else {
         Object reduce = channel$.thePlayer.inventory.getStackInSlot((int)pointed);
         return reduce.getItem() instanceof ItemBlock ? reduce.stackSize : 0;
      }
   }

   public static void _stand(int infrared) {
      if (_cable()) {
         channel$.thePlayer.inventory.currentItem = (int)infrared;
      }
   }

   public static int _jesus() {
      return channel$.thePlayer.inventory.currentItem;
   }

   public static net.minecraft.util.Timer _finder() {
      return (net.minecraft.util.Timer)entering$.get(channel$);
   }

   public static void _remained(Entity gender, float soviet, boolean suites) {
      if (gender != null) {
         Object clicks = _andale((Entity)gender);
         if (clicks != null) {
            Object kings = clicks[0];
            Object findings = clicks[1] + 4.0F + soviet;
            if (suites) {
               channel$.getNetHandler().addToSendQueue(new C05PacketPlayerLook(kings, findings, channel$.thePlayer.onGround));
               PlayerUtils._snake("Send");
            } else {
               channel$.thePlayer.rotationYaw = kings;
               channel$.thePlayer.rotationPitch = findings;
            }
         }
      }

   }

   public static float[] _andale(Entity ignore) {
      if (ignore == null) {
         return null;
      } else {
         Object suffered = ((Entity)ignore).posX - channel$.thePlayer.posX;
         double anaheim;
         if (ignore instanceof EntityLivingBase) {
            Object music = (EntityLivingBase)ignore;
            anaheim = music.posY + (double)music.getEyeHeight() * 0.9D - (channel$.thePlayer.posY + (double)channel$.thePlayer.getEyeHeight());
         } else {
            anaheim = (((Entity)ignore).getEntityBoundingBox().minY + ((Entity)ignore).getEntityBoundingBox().maxY) / 2.0D - (channel$.thePlayer.posY + (double)channel$.thePlayer.getEyeHeight());
         }

         Object var11 = ((Entity)ignore).posZ - channel$.thePlayer.posZ;
         double var7 = (double)MathHelper.sqrt_double(suffered * suffered + var11 * var11);
         float var9 = (float)(Math.atan2(var11, suffered) * 180.0D / 3.141592653589793D) - 90.0F;
         float var10 = (float)(-(Math.atan2(anaheim, var7) * 180.0D / 3.141592653589793D));
         return new float[]{channel$.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var9 - channel$.thePlayer.rotationYaw), channel$.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var10 - channel$.thePlayer.rotationPitch)};
      }
   }

   public static boolean _leaves() {
      if (!_cable()) {
         return false;
      } else {
         return !channel$.isSingleplayer() && channel$.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.net");
      }
   }

   public static Random _revised() {
      return effect$;
   }

   public static void _attorney() {
      entering$ = Minecraft.class.getDeclaredField("timer");
      if (entering$ != null) {
         entering$.setAccessible(true);
      }

      aspects$ = MouseEvent.class.getDeclaredField("button");
      created$ = MouseEvent.class.getDeclaredField("buttonstate");
      longest$ = Mouse.class.getDeclaredField("buttons");
   }

   public static void _empty(int blade, boolean bottles) {
      Object artist = new MouseEvent();
      ObfuscationReflectionHelper.setPrivateValue(MouseEvent.class, artist, Integer.valueOf((int)blade), new String[]{"button"});
      ObfuscationReflectionHelper.setPrivateValue(MouseEvent.class, artist, Boolean.valueOf((boolean)bottles), new String[]{"buttonstate"});
      MinecraftForge.EVENT_BUS.post(artist);
      Object strict = (ByteBuffer)ObfuscationReflectionHelper.getPrivateValue(Mouse.class, (Object)null, new String[]{"buttons"});
      strict.put((int)blade, (byte)(bottles ? 1 : 0));
      ObfuscationReflectionHelper.setPrivateValue(Mouse.class, (Object)null, strict, new String[]{"buttons"});
   }

   public static boolean _daily() {
      if (channel$.thePlayer.getCurrentEquippedItem() == null) {
         return false;
      } else {
         Object cegetifu = channel$.thePlayer.getCurrentEquippedItem().getItem();
         return cegetifu instanceof ItemSword || cegetifu instanceof ItemAxe;
      }
   }

   public static float _powder() {
      Object jewelry = channel$.thePlayer.rotationYaw;
      if (channel$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         jewelry += 180.0F;
      }

      Object treasure = 1.0F;
      if (channel$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         treasure = -0.5F;
      } else if (channel$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         treasure = 0.5F;
      }

      if (channel$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         jewelry -= 90.0F * treasure;
      }

      if (channel$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         jewelry += 90.0F * treasure;
      }

      jewelry = jewelry * 0.017453292F;
      return jewelry;
   }

   public static boolean _finger() {
      return Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().theWorld == null;
   }

   public static void _marcus(String edocanif) {
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection((String)edocanif), (ClipboardOwner)null);
   }

   public static boolean _cable() {
      return channel$.thePlayer != null && channel$.theWorld != null;
   }

   public static boolean _chester() {
      return channel$.currentScreen == null;
   }

   public static double _legends(Entity gusepeco) {
      return ((double)(channel$.thePlayer.rotationYaw - _throwing((Entity)gusepeco)) % 360.0D + 540.0D) % 360.0D - 180.0D;
   }

   public static float _throwing(Entity donald) {
      Object towers = ((Entity)donald).posX - channel$.thePlayer.posX;
      Object often = ((Entity)donald).posZ - channel$.thePlayer.posZ;
      double var5 = Math.atan2(towers, often) * 57.2957795D;
      return (float)(var5 * -1.0D);
   }

   public static boolean _markets(Entity evans, float exact) {
      exact = (float)((double)exact * 0.5D);
      Object cowboy = ((double)(channel$.thePlayer.rotationYaw - _throwing((Entity)evans)) % 360.0D + 540.0D) % 360.0D - 180.0D;
      return cowboy > Double.longBitsToDouble(0L) && cowboy < (double)exact || (double)(-exact) < cowboy && cowboy < Double.longBitsToDouble(0L);
   }

   public static void _carter(EventPreUpdate gireyugu, Entity meyegube, float yudezedu) {
      if (meyegube != null) {
         Object icitepuz = _carolina((Entity)meyegube, (float)yudezedu);
         if (icitepuz != null) {
            Object olezerav = icitepuz[0];
            float var5 = icitepuz[1] + 4.0F;
            EventPreUpdate.yaw = olezerav;
            EventPreUpdate.pitch = var5;
         }
      }

   }

   public static void _hosts(Entity atarabad, float apivilab) {
      if (atarabad != null) {
         Object vevucatu = _carolina((Entity)atarabad, (float)apivilab);
         if (vevucatu != null) {
            Object ranegice = vevucatu[0];
            Object fezicago = vevucatu[1] + 4.0F;
            channel$.thePlayer.rotationYaw = ranegice;
            channel$.thePlayer.rotationPitch = fezicago;
         }
      }

   }

   public static float[] _carolina(Entity ebatozed, float cavucazo) {
      if (ebatozed == null) {
         return null;
      } else {
         Object vibaremu = ((Entity)ebatozed).posX - channel$.thePlayer.posX;
         double dicineda;
         if (ebatozed instanceof EntityLivingBase) {
            Object aluzatuv = (EntityLivingBase)ebatozed;
            dicineda = aluzatuv.posY + (double)aluzatuv.getEyeHeight() * 0.9D - (channel$.thePlayer.posY + (double)channel$.thePlayer.getEyeHeight());
         } else {
            dicineda = (((Entity)ebatozed).getEntityBoundingBox().minY + ((Entity)ebatozed).getEntityBoundingBox().maxY) / 2.0D + (double)cavucazo - (channel$.thePlayer.posY + (double)channel$.thePlayer.getEyeHeight());
         }

         Object var12 = ((Entity)ebatozed).posZ - channel$.thePlayer.posZ;
         double var8 = (double)MathHelper.sqrt_double(vibaremu * vibaremu + var12 * var12);
         float var10 = (float)(Math.atan2(var12, vibaremu) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(dicineda, var8) * 180.0D / 3.141592653589793D));
         return new float[]{channel$.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var10 - channel$.thePlayer.rotationYaw), channel$.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var11 - channel$.thePlayer.rotationPitch)};
      }
   }

   public static double _marine(Entity gudazava, float uvivemuy) {
      return (double)(channel$.thePlayer.rotationPitch - _frontier((Entity)gudazava, (float)uvivemuy));
   }

   public static float _frontier(Entity ileyariy, float imesalup) {
      Object enilarat = (double)channel$.thePlayer.getDistanceToEntity((Entity)ileyariy);
      Object obarubuz = channel$.thePlayer.posY - (((Entity)ileyariy).posY + (double)imesalup);
      double var6 = Math.atan2(enilarat, obarubuz) * 180.0D / 3.141592653589793D;
      return (float)(90.0D - var6);
   }
}
