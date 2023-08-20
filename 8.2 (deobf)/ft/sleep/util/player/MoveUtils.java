//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.player;

import ft.sleep.api.events.world.EventMove;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

public class MoveUtils {
   public static Minecraft social$ = Minecraft.getMinecraft();
   public static List mature$ = new ArrayList();

   public static double _stood(double fewer) {
      if (social$.thePlayer.isPotionActive(Potion.jump)) {
         int var2 = social$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
         fewer += (double)((float)(var2 + 1) * 0.1F);
      }

      return (double)fewer;
   }

   public static double _almost() {
      return _merit(social$.thePlayer);
   }

   public static double _merit(EntityLivingBase ogomivig) {
      return _hindu((EntityLivingBase)ogomivig, 0.2D);
   }

   public static double _hindu(EntityLivingBase builder, double bridge) {
      Object candles = 0.2873D;
      if (((EntityLivingBase)builder).isPotionActive(Potion.moveSpeed)) {
         int var5 = ((EntityLivingBase)builder).getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         candles *= 1.0D + bridge * (double)(var5 + 1);
      }

      return candles;
   }

   public static void _purse() {
      _mobility(_decided());
   }

   public static void _pepper(EventMove gugotezo) {
      _cabin((EventMove)gugotezo, (double)_decided());
   }

   public static void _innocent(float osolobab) {
      if (_saddam()) {
         Object neturota = _clinics();
         social$.thePlayer.motionX = -Math.sin(neturota) * (double)osolobab;
         social$.thePlayer.motionZ = Math.cos(neturota) * (double)osolobab;
      }
   }

   public static void _mobility(float valued) {
      if (MovementUtils._bumper()) {
         Object nursery = (double)_solve();
         social$.thePlayer.motionX = -Math.sin(nursery) * (double)valued;
         social$.thePlayer.motionZ = Math.cos(nursery) * (double)valued;
      }

   }

   public static float _mcdonald() {
      return (float)_repeat(social$.thePlayer.motionX, social$.thePlayer.motionZ);
   }

   public static double _repeat(double lonitova, double var2) {
      return Math.sqrt(lonitova * lonitova + var2 * var2);
   }

   public static void _cabin(EventMove reguyava, double fedibube) {
      if (_saddam()) {
         double var3 = _found();
         ((EventMove)reguyava).setX(social$.thePlayer.motionX = -Math.sin(var3) * fedibube);
         ((EventMove)reguyava).setZ(social$.thePlayer.motionZ = Math.cos(var3) * fedibube);
      }
   }

   public static void _reports(double mecapato) {
      if (_saddam()) {
         double var2 = _crossing(true);
         social$.thePlayer.motionX = -Math.sin(var2) * mecapato;
         social$.thePlayer.motionZ = Math.cos(var2) * mecapato;
      }
   }

   public void _invited(double ecitemoy, double var3) {
      social$.thePlayer.motionX = -Math.sin(var3) * ecitemoy;
      social$.thePlayer.motionZ = Math.cos(var3) * ecitemoy;
   }

   public static double _mention(float eyezizov, float yinesazi, float var2) {
      float var3 = social$.thePlayer.rotationYaw;
      if (social$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         var3 += 180.0F;
      }

      float var4 = 1.0F;
      if (social$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         var4 = -0.5F;
      } else if (social$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         var4 = 0.5F;
      }

      if (social$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         var3 -= 90.0F * var4;
      }

      if (social$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         var3 += 90.0F * var4;
      }

      return Math.toRadians((double)var3);
   }

   public static double _clinics() {
      return _mention(social$.thePlayer.rotationYaw, social$.thePlayer.moveForward, social$.thePlayer.moveStrafing);
   }

   public static double _handle(float sacirudi, float ogisumuy, float etolofaz) {
      Object ebecepum = (float)sacirudi;
      if (etolofaz < Float.intBitsToFloat(0)) {
         ebecepum = sacirudi + 180.0F;
      }

      Object vitesafi = 1.0F;
      if (etolofaz < Float.intBitsToFloat(0)) {
         vitesafi = -0.5F;
      } else if (etolofaz > Float.intBitsToFloat(0)) {
         vitesafi = 0.5F;
      }

      if (ogisumuy > Float.intBitsToFloat(0)) {
         ebecepum -= 90.0F * vitesafi;
      }

      if (ogisumuy < Float.intBitsToFloat(0)) {
         ebecepum += 90.0F * vitesafi;
      }

      return Math.toRadians((double)ebecepum);
   }

   public static float _solve() {
      Object radar = social$.thePlayer.rotationYaw;
      Object stage = 45.0F;
      if (social$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         stage = -45.0F;
         radar += 180.0F;
      }

      if (social$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         radar -= stage;
         if (social$.thePlayer.moveForward == Float.intBitsToFloat(0)) {
            radar -= 45.0F;
         }
      } else if (social$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         radar += stage;
         if (social$.thePlayer.moveForward == Float.intBitsToFloat(0)) {
            radar += 45.0F;
         }
      }

      return radar;
   }

   public static double _found() {
      Object meant = social$.thePlayer.rotationYaw;
      if (social$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         meant += 180.0F;
      }

      Object rotary = 1.0F;
      if (social$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         rotary = -0.5F;
      } else if (social$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         rotary = 0.5F;
      }

      if (social$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         meant -= 90.0F * rotary;
      }

      if (social$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         meant += 90.0F * rotary;
      }

      return Math.toRadians((double)meant);
   }

   public static float _payments(float ifodusuc, float tofenapu, float erilalem) {
      if (ifodusuc == Float.intBitsToFloat(0) && tofenapu == Float.intBitsToFloat(0)) {
         return (float)erilalem;
      } else {
         Object ogezunun = ifodusuc < Float.intBitsToFloat(0);
         Object icizesuv = 90.0F * (ifodusuc > Float.intBitsToFloat(0) ? 0.5F : (ogezunun ? -0.5F : 1.0F));
         if (ogezunun) {
            erilalem += 180.0F;
         }

         if (tofenapu > Float.intBitsToFloat(0)) {
            erilalem -= icizesuv;
         } else if (tofenapu < Float.intBitsToFloat(0)) {
            erilalem += icizesuv;
         }

         return (float)erilalem;
      }
   }

   public static boolean _voltage() {
      for(Object maleruva = social$.thePlayer.posY; maleruva > Double.longBitsToDouble(0L); --maleruva) {
         if (!(social$.theWorld.getBlockState(new BlockPos(social$.thePlayer.posX, maleruva, social$.thePlayer.posZ)).getBlock() instanceof BlockAir)) {
            return false;
         }
      }

      return true;
   }

   public void _cream() {
      _reports((double)_decided());
   }

   public static boolean _saddam() {
      return social$.thePlayer != null && (social$.thePlayer.movementInput.moveForward != Float.intBitsToFloat(0) || social$.thePlayer.movementInput.moveStrafe != Float.intBitsToFloat(0));
   }

   public static float _decided() {
      return (float)Math.sqrt(social$.thePlayer.motionX * social$.thePlayer.motionX + social$.thePlayer.motionZ * social$.thePlayer.motionZ);
   }

   public static double _gifts() {
      Object berry = 0.2875D;
      if (social$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         berry *= 1.0D + 0.2D * (double)(social$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
      }

      return berry;
   }

   public static double _obtained(double obaratof, double emabobum, double var4) {
      mature$.clear();
      mature$.add(Double.valueOf(emabobum - emabobum / 159.9999985D));
      mature$.add(Double.valueOf(emabobum - (obaratof - emabobum) / 33.3D));
      double var6 = social$.thePlayer.isInWater() ? 0.8899999856948853D : (social$.thePlayer.isInLava() ? 0.5350000262260437D : 0.9800000190734863D);
      mature$.add(Double.valueOf(emabobum - var4 * (1.0D - var6)));
      return ((Double)Collections.min(mature$)).doubleValue();
   }

   public static double _crossing(boolean daniel) {
      Object deferred = social$.thePlayer.rotationYawHead;
      Object level = 1.0F;
      Object paxil = (double)social$.thePlayer.movementInput.moveForward;
      double var5 = (double)social$.thePlayer.movementInput.moveStrafe;
      float var7 = social$.thePlayer.rotationYaw;
      if (paxil < Double.longBitsToDouble(0L)) {
         deferred += 180.0F;
      }

      if (paxil < Double.longBitsToDouble(0L)) {
         level = -0.5F;
      } else if (paxil > Double.longBitsToDouble(0L)) {
         level = 0.5F;
      }

      if (var5 > Double.longBitsToDouble(0L)) {
         deferred -= 90.0F * level;
      } else if (var5 < Double.longBitsToDouble(0L)) {
         deferred += 90.0F * level;
      }

      return Math.toRadians((double)deferred);
   }

   public static boolean _pointed(double accident) {
      Object manual = Math.min(social$.thePlayer.posX - accident, social$.thePlayer.posX + accident);
      Object womens = Math.min(social$.thePlayer.posY, social$.thePlayer.posY);
      Object safety = Math.min(social$.thePlayer.posZ - accident, social$.thePlayer.posZ + accident);
      Object hourly = Math.max(social$.thePlayer.posX - accident, social$.thePlayer.posX + accident);
      double var10 = Math.max(social$.thePlayer.posY, social$.thePlayer.posY);
      double var12 = Math.max(social$.thePlayer.posZ - accident, social$.thePlayer.posZ + accident);

      for(int var14 = (int)manual; (double)var14 <= hourly; ++var14) {
         for(int var15 = (int)womens; (double)var15 <= var10; ++var15) {
            for(int var16 = (int)safety; (double)var16 <= var12; ++var16) {
               if (!_hunter(new net.minecraft.util.Vec3((double)var14, (double)var15, (double)var16)) && _hunter(new net.minecraft.util.Vec3((double)var14, (double)(var15 + 1), (double)var16))) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean _hunter(net.minecraft.util.Vec3 trace) {
      Object rounds = new BlockPos((net.minecraft.util.Vec3)trace);
      return !_capture(rounds) && !_capture(rounds.add(0, 1, 0)) ? _inputs(rounds.add(0, -1, 0)) : false;
   }

   public static boolean _capture(BlockPos church) {
      Object bases = social$.theWorld.getBlockState((BlockPos)church).getBlock();
      return bases instanceof BlockSlab || bases instanceof BlockStairs || bases instanceof BlockCactus || bases instanceof BlockChest || bases instanceof BlockEnderChest || bases instanceof BlockSkull || bases instanceof BlockPane || bases instanceof BlockFence || bases instanceof BlockWall || bases instanceof BlockGlass || bases instanceof BlockPistonBase || bases instanceof BlockPistonExtension || bases instanceof BlockPistonMoving || bases instanceof BlockStainedGlass || bases instanceof BlockTrapDoor;
   }

   public static boolean _inputs(BlockPos giloyayu) {
      Object zebolivi = social$.theWorld.getBlockState((BlockPos)giloyayu).getBlock();
      return !(zebolivi instanceof BlockFence) && !(zebolivi instanceof BlockWall);
   }

   public static void _approved(double plumbing) {
      _peace((double)plumbing, social$.thePlayer.rotationYaw);
   }

   public static void _exterior(EventMove indeed, double deviant, float struggle) {
      Object gains = (double)social$.thePlayer.movementInput.moveForward;
      double var6 = (double)social$.thePlayer.movementInput.moveStrafe;
      if (gains == Double.longBitsToDouble(0L) && var6 == Double.longBitsToDouble(0L)) {
         social$.thePlayer.motionX = ((EventMove)indeed).x = Double.longBitsToDouble(0L);
         social$.thePlayer.motionZ = ((EventMove)indeed).z = Double.longBitsToDouble(0L);
      } else {
         if (gains != Double.longBitsToDouble(0L)) {
            if (var6 > Double.longBitsToDouble(0L)) {
               struggle += (float)(gains > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (var6 < Double.longBitsToDouble(0L)) {
               struggle += (float)(gains > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            var6 = Double.longBitsToDouble(0L);
            if (gains > Double.longBitsToDouble(0L)) {
               gains = 1.0D;
            } else if (gains < Double.longBitsToDouble(0L)) {
               gains = -1.0D;
            }
         }

         social$.thePlayer.motionX = ((EventMove)indeed).x = gains * deviant * Math.cos(Math.toRadians((double)(struggle + 90.0F))) + var6 * deviant * Math.sin(Math.toRadians((double)(struggle + 90.0F)));
         social$.thePlayer.motionZ = ((EventMove)indeed).z = gains * deviant * Math.sin(Math.toRadians((double)(struggle + 90.0F))) - var6 * deviant * Math.cos(Math.toRadians((double)(struggle + 90.0F)));
      }

   }

   public static void _rapidly(EventMove sopogaro, double yatosulu) {
      _exterior((EventMove)sopogaro, (double)yatosulu, social$.thePlayer.rotationYaw);
   }

   public static void _peace(double dozen, float titanium) {
      Object aware = (double)social$.thePlayer.movementInput.moveForward;
      double var5 = (double)social$.thePlayer.movementInput.moveStrafe;
      if (aware == Double.longBitsToDouble(0L) && var5 == Double.longBitsToDouble(0L)) {
         social$.thePlayer.motionX = Double.longBitsToDouble(0L);
         social$.thePlayer.motionZ = Double.longBitsToDouble(0L);
      } else {
         if (aware != Double.longBitsToDouble(0L)) {
            if (var5 > Double.longBitsToDouble(0L)) {
               titanium += (float)(aware > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (var5 < Double.longBitsToDouble(0L)) {
               titanium += (float)(aware > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            var5 = Double.longBitsToDouble(0L);
            if (aware > Double.longBitsToDouble(0L)) {
               aware = 1.0D;
            } else if (aware < Double.longBitsToDouble(0L)) {
               aware = -1.0D;
            }
         }

         social$.thePlayer.motionX = aware * dozen * Math.cos(Math.toRadians((double)(titanium + 90.0F))) + var5 * dozen * Math.sin(Math.toRadians((double)(titanium + 90.0F)));
         social$.thePlayer.motionZ = aware * dozen * Math.sin(Math.toRadians((double)(titanium + 90.0F))) - var5 * dozen * Math.cos(Math.toRadians((double)(titanium + 90.0F)));
      }

   }

   public static boolean _approach(double yopugusi, double ededefen, double inanorey, double oruzalec) {
      double var10000 = social$.thePlayer.posX - yopugusi;
      var10000 = social$.thePlayer.posY - ededefen;
      var10000 = social$.thePlayer.posZ - inanorey;
      Object sinedifu = Math.sqrt(social$.thePlayer.getDistanceSq((double)yopugusi, (double)ededefen, (double)inanorey));
      double var18 = (double)(Math.round(sinedifu / oruzalec + 0.49999999999D) - ((long)-916114561 ^ -916114562L));
      double var20 = social$.thePlayer.posX;
      double var22 = social$.thePlayer.posY;
      double var24 = social$.thePlayer.posZ;

      for(int var26 = 1; (double)var26 < var18; ++var26) {
         double var27 = (yopugusi - social$.thePlayer.posX) / var18;
         var20 += var27;
         double var29 = (inanorey - social$.thePlayer.posZ) / var18;
         var24 += var29;
         double var31 = (ededefen - social$.thePlayer.posY) / var18;
         var22 += var31;
         AxisAlignedBB var33 = new AxisAlignedBB(var20 - 0.3D, var22, var24 - 0.3D, var20 + 0.3D, var22 + 1.8D, var24 + 0.3D);
         if (!social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var33).isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public static boolean _archives(double yezuvonu) {
      return !social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, social$.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-yezuvonu), Double.longBitsToDouble(0L))).isEmpty();
   }

   public static boolean _draws(Entity biseteve, double itulomam) {
      return !social$.theWorld.getCollidingBoundingBoxes((Entity)biseteve, ((Entity)biseteve).getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-itulomam), Double.longBitsToDouble(0L))).isEmpty();
   }

   public static int _realtor() {
      return social$.thePlayer.isPotionActive(Potion.jump) ? social$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static int _males() {
      return social$.thePlayer.isPotionActive(Potion.moveSpeed) ? social$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static int _receive(EntityPlayer yuconava) {
      return ((EntityPlayer)yuconava).isPotionActive(Potion.moveSpeed) ? ((EntityPlayer)yuconava).getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static Block _uploaded(EntityPlayer motelayo, double gibuvire) {
      return social$.theWorld.getBlockState(new BlockPos(((EntityPlayer)motelayo).posX, ((EntityPlayer)motelayo).posY - gibuvire, ((EntityPlayer)motelayo).posZ)).getBlock();
   }

   public static Block _cindy(double rating, double dividend, double var4) {
      EntityPlayerSP var6 = social$.thePlayer;
      return social$.theWorld.getBlockState(new BlockPos(var6.posX + rating, var6.posY + dividend, var6.posZ + var4)).getBlock();
   }

   public static float _orders(Entity pulusezi) {
      if (social$.thePlayer.isCollidedVertically && social$.thePlayer.onGround) {
         return Float.intBitsToFloat(0);
      } else {
         for(Object igubusir = (float)((Entity)pulusezi).posY; igubusir > Float.intBitsToFloat(0); --igubusir) {
            Object mudabuti = new int[]{53, 67, 108, 109, 114, 128, 134, 135, 136, 156, 163, 164, 180};
            Object bovadabe = new int[]{6, 27, 28, 30, 31, 32, 37, 38, 39, 40, 50, 51, 55, 59, 63, 65, 66, 68, 69, 70, 72, 75, 76, 77, 83, 92, 93, 94, 104, 105, 106, 115, 119, 131, 132, 143, 147, 148, 149, 150, 157, 171, 175, 176, 177};
            Object pacavucu = social$.theWorld.getBlockState(new BlockPos(((Entity)pulusezi).posX, (double)(igubusir - 1.0F), ((Entity)pulusezi).posZ)).getBlock();
            if (!(pacavucu instanceof BlockAir)) {
               if (Block.getIdFromBlock(pacavucu) != 44 && Block.getIdFromBlock(pacavucu) != 126) {
                  for(Object afatofey : mudabuti) {
                     if (Block.getIdFromBlock(pacavucu) == afatofey) {
                        return (float)(((Entity)pulusezi).posY - (double)igubusir - 1.0D) < Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : (float)(((Entity)pulusezi).posY - (double)igubusir - 1.0D);
                     }
                  }

                  for(Object var12 : bovadabe) {
                     if (Block.getIdFromBlock(pacavucu) == var12) {
                        return (float)(((Entity)pulusezi).posY - (double)igubusir) < Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : (float)(((Entity)pulusezi).posY - (double)igubusir);
                     }
                  }

                  return (float)(((Entity)pulusezi).posY - (double)igubusir + pacavucu.getBlockBoundsMaxY() - 1.0D);
               }

               return (float)(((Entity)pulusezi).posY - (double)igubusir - 0.5D) < Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : (float)(((Entity)pulusezi).posY - (double)igubusir - 0.5D);
            }
         }

         return Float.intBitsToFloat(0);
      }
   }

   public static float[] _naples(BlockPos egonofid, EnumFacing itecuvol) {
      Object bidunecu = (double)((BlockPos)egonofid).getX() + 0.5D - social$.thePlayer.posX + (double)((EnumFacing)itecuvol).getFrontOffsetX() / 2.0D;
      Object anilezim = (double)((BlockPos)egonofid).getZ() + 0.5D - social$.thePlayer.posZ + (double)((EnumFacing)itecuvol).getFrontOffsetZ() / 2.0D;
      Object afefazen = (double)((BlockPos)egonofid).getY() + 0.5D;
      Object dotumego = social$.thePlayer.posY + (double)social$.thePlayer.getEyeHeight() - afefazen;
      double var10 = (double)MathHelper.sqrt_double(bidunecu * bidunecu + anilezim * anilezim);
      float var12 = (float)(Math.atan2(anilezim, bidunecu) * 180.0D / 3.141592653589793D) - 90.0F;
      float var13 = (float)(Math.atan2(dotumego, var10) * 180.0D / 3.141592653589793D);
      if (var12 < Float.intBitsToFloat(0)) {
         var12 += 360.0F;
      }

      return new float[]{var12, var13};
   }

   public static boolean _sample() {
      Object ufilidim = new AxisAlignedBB(social$.thePlayer.posX - 0.3D, social$.thePlayer.posY + (double)social$.thePlayer.getEyeHeight(), social$.thePlayer.posZ + 0.3D, social$.thePlayer.posX + 0.3D, social$.thePlayer.posY + 2.5D, social$.thePlayer.posZ - 0.3D);
      return !social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, ufilidim).isEmpty();
   }

   public static boolean _sydney(double armor) {
      AxisAlignedBB var2 = new AxisAlignedBB(social$.thePlayer.posX - 0.3D, social$.thePlayer.posY + 2.0D, social$.thePlayer.posZ + 0.3D, social$.thePlayer.posX + 0.3D, social$.thePlayer.posY + 3.0D, social$.thePlayer.posZ - 0.3D);
      if (!social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(0.3D + armor, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))).isEmpty()) {
         return true;
      } else if (!social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(-0.3D - armor, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))).isEmpty()) {
         return true;
      } else if (!social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0.3D + armor)).isEmpty()) {
         return true;
      } else {
         return !social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), -0.3D - armor)).isEmpty();
      }
   }

   public static boolean _offset(double rolling) {
      AxisAlignedBB var2 = new AxisAlignedBB(social$.thePlayer.posX - 0.3D, social$.thePlayer.posY + 0.5D, social$.thePlayer.posZ + 0.3D, social$.thePlayer.posX + 0.3D, social$.thePlayer.posY + 1.9D, social$.thePlayer.posZ - 0.3D);
      if (!social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(0.3D + rolling, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))).isEmpty()) {
         return true;
      } else if (!social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(-0.3D - rolling, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))).isEmpty()) {
         return true;
      } else if (!social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0.3D + rolling)).isEmpty()) {
         return true;
      } else {
         return !social$.theWorld.getCollidingBoundingBoxes(social$.thePlayer, var2.offset(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), -0.3D - rolling)).isEmpty();
      }
   }

   public static void _topic(double abecupub) {
      if (MovementUtils._bumper()) {
         double var2 = _found();
         social$.thePlayer.motionX = -Math.sin(var2) * abecupub;
         social$.thePlayer.motionZ = Math.cos(var2) * abecupub;
      }

   }
}
