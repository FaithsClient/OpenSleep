//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.rotation;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.EventTick;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3i;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class RotationUtils6 {
   public static Minecraft essay$ = Minecraft.getMinecraft();
   public static Random customs$ = new Random();
   public static int twice$;
   public static RotationUtils2 declare$;
   public static RotationUtils2 mercury$ = new RotationUtils2(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
   public static boolean string$ = false;
   public static double shock$ = customs$.nextDouble();
   public static double chance$ = customs$.nextDouble();
   public static double floor$ = customs$.nextDouble();

   public static double[] _trails(Entity omebeciy) {
      Object ibovapir = (double) Helper._pillow().renderPartialTicks;
      double[] var3 = new double[]{((Entity)omebeciy).lastTickPosX + (((Entity)omebeciy).posX - ((Entity)omebeciy).lastTickPosX) * ibovapir, ((Entity)omebeciy).lastTickPosY + (((Entity)omebeciy).posY - ((Entity)omebeciy).lastTickPosY) * ibovapir, ((Entity)omebeciy).lastTickPosZ + (((Entity)omebeciy).posZ - ((Entity)omebeciy).lastTickPosZ) * ibovapir};
      return var3;
   }

   public static float _latinas(float osucagon, float aravocet, float isaronil) {
      Object doreniva = 0.006F;
      Object caremito = isaronil * isaronil * isaronil * isaronil - doreniva * (doreniva * osucagon * osucagon + 2.0F * aravocet * isaronil * isaronil);
      return (float)Math.toDegrees(Math.atan(((double)(isaronil * isaronil) - Math.sqrt((double)caremito)) / (double)(doreniva * osucagon)));
   }

   public static float[] _radios(double senate, double liked, double mexico) {
      Object steering = essay$.thePlayer;
      Object together = senate - steering.posX;
      Object claim = liked - (steering.posY + (double)steering.getEyeHeight());
      double var11 = mexico - steering.posZ;
      double var13 = (double)MathHelper.sqrt_double(together * together + var11 * var11);
      float var15 = (float)(Math.atan2(var11, together) * 180.0D / 3.141592653589793D) - 90.0F;
      float var16 = (float)(-(Math.atan2(claim, var13) * 180.0D / 3.141592653589793D));
      return new float[]{var15, var16};
   }

   public static boolean _pressed(Entity vinamope, float ramanura) {
      return (Math.abs(_repairs((Entity)vinamope)[0] - essay$.thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(_repairs((Entity)vinamope)[0] - essay$.thePlayer.rotationYaw) % 360.0F : Math.abs(_repairs((Entity)vinamope)[0] - essay$.thePlayer.rotationYaw) % 360.0F) <= ramanura;
   }

   public static float _austria(Entity majority) {
      return Math.abs(_repairs((Entity)majority)[0] - essay$.thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(_repairs((Entity)majority)[0] - essay$.thePlayer.rotationYaw) % 360.0F : Math.abs(_repairs((Entity)majority)[0] - essay$.thePlayer.rotationYaw) % 360.0F;
   }

   public static float[] _skating(Entity croatia) {
      Object trucks = ((Entity)croatia).posX - essay$.thePlayer.posX;
      Object reverse = ((Entity)croatia).posY + (double)((Entity)croatia).getEyeHeight() * 0.9D - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
      Object field = ((Entity)croatia).posZ - essay$.thePlayer.posZ;
      double var7 = (double)MathHelper.ceiling_float_int((float)(trucks * trucks + field * field));
      float var9 = (float)(Math.atan2(field, trucks) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(Math.atan2(reverse, var7) * 180.0D / 3.141592653589793D));
      return new float[]{essay$.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var9 - essay$.thePlayer.rotationYaw), essay$.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var10 - essay$.thePlayer.rotationPitch)};
   }

   public static float[] _cloth(EntityLivingBase marker) {
      Object teacher = ((EntityLivingBase)marker).posX - essay$.thePlayer.posX;
      Object global = ((EntityLivingBase)marker).posZ - essay$.thePlayer.posZ;
      Object cause = ((EntityLivingBase)marker).posY + (double)((EntityLivingBase)marker).getEyeHeight() * 0.9D - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
      double var7 = (double)MathHelper.sqrt_double(teacher * teacher + global * global);
      float var9 = (float)(Math.atan2(global, teacher) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(Math.atan2(cause, var7) * 180.0D / 3.141592653589793D));
      return new float[]{var9, var10};
   }

   public static float[] _sticker(net.minecraft.util.Vec3 bikini) {
      Object embedded = ((net.minecraft.util.Vec3)bikini).xCoord - essay$.thePlayer.posX;
      Object protocol = ((net.minecraft.util.Vec3)bikini).yCoord - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
      Object sacred = ((net.minecraft.util.Vec3)bikini).zCoord - essay$.thePlayer.posZ;
      double var7 = (double)MathHelper.sqrt_double(embedded * embedded + sacred * sacred);
      float var9 = (float)(Math.atan2(sacred, embedded) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(Math.atan2(protocol, var7) * 180.0D / 3.141592653589793D));
      return new float[]{var9, var10};
   }

   public static float[] _relevant(float[] nazaraca) {
      Object ceboleya = MathHelper.wrapAngleTo180_float(essay$.thePlayer.rotationYaw - ((Object[])nazaraca)[0]);
      Object pasotibi = MathHelper.wrapAngleTo180_float(essay$.thePlayer.rotationPitch - ((Object[])nazaraca)[1]);
      return new float[]{ceboleya + ((Object[])nazaraca)[0], pasotibi + ((Object[])nazaraca)[1]};
   }

   public static float[] _beach(BlockPos motors, EnumFacing steady) {
      return _blades((double)((BlockPos)motors).getX(), (double)((BlockPos)motors).getY(), (double)((BlockPos)motors).getZ(), (EnumFacing)steady);
   }

   public static float[] _blades(double clearly, double degree, double reprint, EnumFacing var6) {
      EntityPig var7 = new EntityPig(essay$.theWorld);
      var7.posX = clearly + 0.5D;
      var7.posY = degree + 0.5D;
      var7.posZ = reprint + 0.5D;
      var7.posX += (double)var6.getDirectionVec().getX() * 0.5D;
      var7.posY += (double)var6.getDirectionVec().getY() * 0.5D;
      var7.posZ += (double)var6.getDirectionVec().getZ() * 0.5D;
      return _repairs(var7);
   }

   public static float[] _repairs(Entity irativeb) {
      if (irativeb == null) {
         return null;
      } else {
         Object egevagov = ((Entity)irativeb).posX - essay$.thePlayer.posX;
         Object mubavoma = ((Entity)irativeb).posZ - essay$.thePlayer.posZ;
         double ivegedov;
         if (irativeb instanceof EntityLivingBase) {
            EntityLivingBase var7 = (EntityLivingBase)irativeb;
            ivegedov = var7.posY + (double)var7.getEyeHeight() - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
         } else {
            ivegedov = (((Entity)irativeb).getEntityBoundingBox().minY + ((Entity)irativeb).getEntityBoundingBox().maxY) / 2.0D - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
         }

         double var11 = (double)MathHelper.sqrt_double(egevagov * egevagov + mubavoma * mubavoma);
         float var9 = (float)(Math.atan2(mubavoma, egevagov) * 180.0D / 3.141592653589793D) - 90.0F;
         float var10 = (float)(-(Math.atan2(ivegedov, var11) * 180.0D / 3.141592653589793D));
         return new float[]{var9, var10};
      }
   }

   public static float[] _showcase(double musupisu, double isifevoc, double mafirupu) {
      Object zocemise = musupisu - essay$.thePlayer.posX;
      Object oceminur = mafirupu - essay$.thePlayer.posZ;
      double var10 = isifevoc - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
      double var12 = (double)MathHelper.sqrt_double(zocemise * zocemise + oceminur * oceminur);
      float var14 = (float)(Math.atan2(oceminur, zocemise) * 180.0D / 3.141592653589793D) - 90.0F;
      float var15 = (float)(-(Math.atan2(var10, var12) * 180.0D / 3.141592653589793D));
      return new float[]{var14, var15};
   }

   public static float[] _closer(EntityLivingBase yonimoyo, double ededacil, double zinurozo, double udinevaz) {
      Object odegirub = ((EntityLivingBase)yonimoyo).posX;
      Object dozadelu = ((EntityLivingBase)yonimoyo).posZ;
      Object cayugeru = ((EntityLivingBase)yonimoyo).posY + (double)(((EntityLivingBase)yonimoyo).getEyeHeight() / 2.0F);
      double var13 = odegirub - ededacil;
      double var15 = dozadelu - udinevaz;
      double var17 = cayugeru - zinurozo - 0.6D;
      double var19 = (double)MathHelper.sqrt_double(var13 * var13 + var15 * var15);
      float var21 = (float)(Math.atan2(var15, var13) * 180.0D / 3.141592653589793D) - 90.0F;
      float var22 = (float)(-(Math.atan2(var17, var19) * 180.0D / 3.141592653589793D));
      return new float[]{var21, var22};
   }

   public static float _cartoon(Entity wesley) {
      Object played = ((Entity)wesley).posX - essay$.thePlayer.posX;
      Object source = ((Entity)wesley).posZ - essay$.thePlayer.posZ;
      double var5 = Double.longBitsToDouble(0L);
      if (source < Double.longBitsToDouble(0L) && played < Double.longBitsToDouble(0L)) {
         var5 = 90.0D + Math.toDegrees(Math.atan(source / played));
      } else if (source < Double.longBitsToDouble(0L) && played > Double.longBitsToDouble(0L)) {
         double var7 = -90.0D + Math.toDegrees(Math.atan(source / played));
      } else {
         Math.toDegrees(-Math.atan(played / source));
      }

      return MathHelper.wrapAngleTo180_float(-(essay$.thePlayer.rotationYaw - (float)var5));
   }

   public static float _require(Entity browse) {
      Object bolivia = ((Entity)browse).posX - essay$.thePlayer.posX;
      Object favor = ((Entity)browse).posZ - essay$.thePlayer.posZ;
      Object began = ((Entity)browse).posY - 1.6D + (double)((Entity)browse).getEyeHeight() - essay$.thePlayer.posY;
      double var7 = (double)MathHelper.sqrt_double(bolivia * bolivia + favor * favor);
      double var9 = -Math.toDegrees(Math.atan(began / var7));
      return -MathHelper.wrapAngleTo180_float(essay$.thePlayer.rotationPitch - (float)var9);
   }

   public static double _sessions(double pipageri, double ubisodod, double mepapomo, double irocenun, double yutazini, double perusopu, double ubugofad, double zaganele, double obeyegas, double afofofim, double osazofiv, double var22) {
      double var24 = Math.sqrt((double)(irocenun * irocenun + yutazini * yutazini + perusopu * perusopu));
      if (var24 == Double.longBitsToDouble(0L)) {
         var24 = 1.0D;
      }

      double var26 = (double)(ubugofad - pipageri);
      double var28 = (double)(zaganele - ubisodod);
      double var30 = (double)(obeyegas - mepapomo);
      double var32 = Math.sqrt(var26 * var26 + var28 * var28 + var30 * var30);
      double var34 = var32 * irocenun / var24;
      double var36 = var32 * yutazini / var24;
      double var38 = var32 * perusopu / var24;
      double var40 = Double.longBitsToDouble(0L);
      var40 = var40 + Math.max(Math.abs(var26 - var34) - (afofofim / 2.0D + var22), Double.longBitsToDouble(0L));
      var40 = var40 + Math.max(Math.abs(var30 - var38) - (afofofim / 2.0D + var22), Double.longBitsToDouble(0L));
      var40 = var40 + Math.max(Math.abs(var28 - var36) - (osazofiv / 2.0D + var22), Double.longBitsToDouble(0L));
      if (var40 > 1.0D) {
         var40 = Math.sqrt(var40);
      }

      return var40;
   }

   public static double _buffalo(double ufimudib, double var2) {
      return ((ufimudib - var2) % 360.0D + 540.0D) % 360.0D - 180.0D;
   }

   public static float[] _directed(Entity rover, float cheat, float special, boolean designer) {
      Object collapse = ((Entity)rover).posX - essay$.thePlayer.posX;
      Object strong = ((Entity)rover).posZ - essay$.thePlayer.posZ;
      if (rover instanceof EntityLivingBase) {
         Object joyce = (EntityLivingBase)rover;
         collapse = joyce.posY + (double)joyce.getEyeHeight() - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
      } else {
         collapse = (((Entity)rover).getEntityBoundingBox().minY + ((Entity)rover).getEntityBoundingBox().maxY) / 2.0D - (essay$.thePlayer.posY + (double)essay$.thePlayer.getEyeHeight());
      }

      Object var17 = new Random();
      Object raised = designer ? (float)var17.nextInt(15) * 0.25F + 5.0F : Float.intBitsToFloat(0);
      Object silver = (double)MathHelper.sqrt_double(collapse * collapse + strong * strong);
      Object variety = (float)(Math.atan2(strong + (double)raised, collapse) * 180.0D / 3.141592653589793D) - 90.0F;
      float var13 = (float)(-(Math.atan2(collapse - (double)(rover instanceof EntityPlayer ? 0.5F : Float.intBitsToFloat(0)) + (double)raised, silver) * 180.0D / 3.141592653589793D));
      float var14 = _realize(essay$.thePlayer.rotationPitch, var13, (float)special);
      float var15 = _realize(essay$.thePlayer.rotationYaw, variety, (float)cheat);
      return new float[]{var15, var14};
   }

   public static net.minecraft.util.Vec3 _centers(float striking, float bumper) {
      Object videos = MathHelper.cos(-striking * 0.017453292F - 3.1415927F);
      Object heating = MathHelper.sin(-striking * 0.017453292F - 3.1415927F);
      Object titans = -MathHelper.cos(-bumper * 0.017453292F);
      Object dress = MathHelper.sin(-bumper * 0.017453292F);
      return new net.minecraft.util.Vec3((double)(heating * titans), (double)dress, (double)(videos * titans));
   }

   public static float _realize(float disable, float counties, float europe) {
      Object charms = MathHelper.wrapAngleTo180_float((float)(counties - disable));
      if (charms > europe) {
         charms = (float)europe;
      }

      if (charms < -europe) {
         charms = (float)(-europe);
      }

      return disable + charms;
   }

   @EventHandler
   public void _proceeds(EventPacketSend dressed) {
      Object runtime = EventPacketSend.getPacket();
      if (runtime instanceof C03PacketPlayer) {
         C03PacketPlayer var3 = (C03PacketPlayer)runtime;
         if (declare$ != null && !string$ && (declare$._combat() != mercury$._combat() || declare$._mileage() != mercury$._mileage())) {
            var3.yaw = declare$._combat();
            var3.pitch = declare$._mileage();
            var3.rotating = true;
         }

         if (var3.rotating) {
            mercury$ = new RotationUtils2(var3.yaw, var3.pitch);
         }
      }

   }

   public static float _classic(double export, double minority, float trends) {
      Object relate = export - essay$.thePlayer.posX;
      double var7 = minority - essay$.thePlayer.posZ;
      double var9 = var7 < Double.longBitsToDouble(0L) && relate < Double.longBitsToDouble(0L) ? 90.0D + Math.toDegrees(Math.atan(var7 / relate)) : (var7 < Double.longBitsToDouble(0L) && relate > Double.longBitsToDouble(0L) ? -90.0D + Math.toDegrees(Math.atan(var7 / relate)) : Math.toDegrees(-Math.atan(relate / var7)));
      return MathHelper.wrapAngleTo180_float(-(trends - (float)var9));
   }

   public static float _invite(float packet, float listing) {
      return ((packet - listing) % 360.0F + 540.0F) % 360.0F - 180.0F;
   }

   public static double _turner(RotationUtils2 stylus, RotationUtils2 analyzes) {
      return Math.hypot((double)_invite(((RotationUtils2)stylus)._combat(), ((RotationUtils2)analyzes)._combat()), (double)(((RotationUtils2)stylus)._mileage() - ((RotationUtils2)analyzes)._mileage()));
   }

   public static double _brook(RotationUtils2 dresses) {
      return mercury$ == null ? Double.longBitsToDouble(0L) : _turner((RotationUtils2)dresses, mercury$);
   }

   public static net.minecraft.util.Vec3 _measure(RotationUtils2 tours) {
      Object philip = (float)Math.cos((double)(-((RotationUtils2)tours)._combat() * 0.017453292F - 3.1415927F));
      Object dynamic = (float)Math.sin((double)(-((RotationUtils2)tours)._combat() * 0.017453292F - 3.1415927F));
      Object methods = (float)(-Math.cos((double)(-((RotationUtils2)tours)._mileage() * 0.017453292F)));
      Object varies = (float)Math.sin((double)(-((RotationUtils2)tours)._mileage() * 0.017453292F));
      return new net.minecraft.util.Vec3((double)(dynamic * methods), (double)varies, (double)(philip * methods));
   }

   public static RotationUtils4 _career(AxisAlignedBB fraser, boolean sunrise) {
      Object pension = null;

      for(Object handy = 0.15D; handy < 0.85D; handy += 0.1D) {
         for(Object elderly = 0.15D; elderly < 1.0D; elderly += 0.1D) {
            for(Object qatar = 0.15D; qatar < 0.85D; qatar += 0.1D) {
               net.minecraft.util.Vec3 var9 = new net.minecraft.util.Vec3(((AxisAlignedBB)fraser).minX + (((AxisAlignedBB)fraser).maxX - ((AxisAlignedBB)fraser).minX) * handy, ((AxisAlignedBB)fraser).minY + (((AxisAlignedBB)fraser).maxY - ((AxisAlignedBB)fraser).minY) * elderly, ((AxisAlignedBB)fraser).minZ + (((AxisAlignedBB)fraser).maxZ - ((AxisAlignedBB)fraser).minZ) * qatar);
               RotationUtils2 var10 = _natural(var9, (boolean)sunrise);
               RotationUtils4 var11 = new RotationUtils4(var9, var10);
               if (pension == null || _brook(var11._vocals()) < _brook(pension._vocals())) {
                  pension = var11;
               }
            }
         }
      }

      return pension;
   }

   public static RotationUtils4 _derby(BlockPos zuzupize) {
      if (zuzupize == null) {
         return null;
      } else {
         Object irisecom = null;

         for(Object tofosalu = 0.1D; tofosalu < 0.9D; tofosalu += 0.1D) {
            for(Object opuleloz = 0.1D; opuleloz < 0.9D; opuleloz += 0.1D) {
               for(Object zavesuza = 0.1D; zavesuza < 0.9D; zavesuza += 0.1D) {
                  Object nididifu = new net.minecraft.util.Vec3(essay$.thePlayer.posX, essay$.thePlayer.getEntityBoundingBox().minY + (double)essay$.thePlayer.getEyeHeight(), essay$.thePlayer.posZ);
                  Object unibobem = (new net.minecraft.util.Vec3((Vec3i)zuzupize)).addVector(tofosalu, opuleloz, zavesuza);
                  Object ogatonen = nididifu.distanceTo(unibobem);
                  Object ozofuroy = unibobem.xCoord - nididifu.xCoord;
                  Object agogosed = unibobem.yCoord - nididifu.yCoord;
                  Object izufibir = unibobem.zCoord - nididifu.zCoord;
                  double var18 = Math.sqrt(ozofuroy * ozofuroy + izufibir * izufibir);
                  RotationUtils2 var20 = new RotationUtils2(MathHelper.wrapAngleTo180_float((float)Math.toDegrees(Math.atan2(izufibir, ozofuroy)) - 90.0F), MathHelper.wrapAngleTo180_float((float)(-Math.toDegrees(Math.atan2(agogosed, var18)))));
                  net.minecraft.util.Vec3 var21 = _measure(var20);
                  net.minecraft.util.Vec3 var22 = nididifu.addVector(var21.xCoord * ogatonen, var21.yCoord * ogatonen, var21.zCoord * ogatonen);
                  MovingObjectPosition var23 = essay$.theWorld.rayTraceBlocks(nididifu, var22, false, false, true);
                  if (var23 != null && var23.typeOfHit == MovingObjectType.BLOCK) {
                     RotationUtils4 var24 = new RotationUtils4(unibobem, var20);
                     if (irisecom == null || _brook(var24._vocals()) < _brook(irisecom._vocals())) {
                        irisecom = var24;
                     }
                  }
               }
            }
         }

         return irisecom;
      }
   }

   @EventHandler
   public void _certain(EventTick var1) {
      if (declare$ != null) {
         ++twice$;
         if (twice$ > 15) {
            _shift();
         }
      }

      if (customs$.nextGaussian() > 0.8D) {
         shock$ = Math.random();
      }

      if (customs$.nextGaussian() > 0.8D) {
         chance$ = Math.random();
      }

      if (customs$.nextGaussian() > 0.8D) {
         floor$ = Math.random();
      }

   }

   public static void _notes(RotationUtils2 cipufebe) {
      _combine((RotationUtils2)cipufebe, 0);
   }

   public static void _combine(RotationUtils2 gucunoro, int zilotayu) {
      if (!Double.isNaN((double)((RotationUtils2)gucunoro)._combat()) && !Double.isNaN((double)((RotationUtils2)gucunoro)._mileage()) && ((RotationUtils2)gucunoro)._mileage() <= 90.0F && ((RotationUtils2)gucunoro)._mileage() >= -90.0F) {
         ((RotationUtils2)gucunoro)._duration(Float.valueOf(essay$.gameSettings.mouseSensitivity));
         declare$ = (RotationUtils2)gucunoro;
         twice$ = (int)zilotayu;
      }
   }

   public static void _scholars() {
      if (mercury$ != null) {
         declare$ = mercury$;
         twice$ = 0;
      }
   }

   public static void _shift() {
      twice$ = 0;
      declare$ = null;
   }

   public static RotationUtils2 _natural(net.minecraft.util.Vec3 lafanara, boolean ipogicuy) {
      Object anevagov = new net.minecraft.util.Vec3(essay$.thePlayer.posX, essay$.thePlayer.getEntityBoundingBox().minY + (double)essay$.thePlayer.getEyeHeight(), essay$.thePlayer.posZ);
      if (ipogicuy) {
         anevagov.addVector(essay$.thePlayer.motionX, essay$.thePlayer.motionY, essay$.thePlayer.motionZ);
      }

      Object usasucal = ((net.minecraft.util.Vec3)lafanara).xCoord - anevagov.xCoord;
      Object ovulacub = ((net.minecraft.util.Vec3)lafanara).yCoord - anevagov.yCoord;
      double var7 = ((net.minecraft.util.Vec3)lafanara).zCoord - anevagov.zCoord;
      return new RotationUtils2(MathHelper.wrapAngleTo180_float((float)Math.toDegrees(Math.atan2(var7, usasucal)) - 90.0F), MathHelper.wrapAngleTo180_float((float)(-Math.toDegrees(Math.atan2(ovulacub, Math.sqrt(usasucal * usasucal + var7 * var7))))));
   }

   public static float _nelson() {
      Object stood = Minecraft.getMinecraft().thePlayer.rotationYaw;
      Object seniors = 1.0F;
      if (Minecraft.getMinecraft().thePlayer.movementInput.moveForward < Float.intBitsToFloat(0)) {
         stood += 180.0F;
         seniors = -0.5F;
      } else if (Minecraft.getMinecraft().thePlayer.movementInput.moveForward > Float.intBitsToFloat(0)) {
         seniors = 0.5F;
      }

      if (Minecraft.getMinecraft().thePlayer.movementInput.moveStrafe > Float.intBitsToFloat(0)) {
         stood -= 90.0F * seniors;
      }

      if (Minecraft.getMinecraft().thePlayer.movementInput.moveStrafe < Float.intBitsToFloat(0)) {
         stood += 90.0F * seniors;
      }

      return stood * 0.017453292F;
   }

   public static float[] _angeles(int lightbox, double pregnant, int maldives) {
      EntitySnowball var4 = new EntitySnowball(Minecraft.getMinecraft().theWorld);
      var4.posX = (double)lightbox + 0.5D;
      var4.posY = pregnant + 0.5D;
      var4.posZ = (double)maldives + 0.5D;
      return _lease(var4);
   }

   public static float[] _lease(Entity insider) {
      if (insider == null) {
         return null;
      } else {
         Object singer = Minecraft.getMinecraft();
         Object prayer = ((Entity)insider).posX - singer.thePlayer.posX;
         Object image = ((Entity)insider).posY + (double)(((Entity)insider).getEyeHeight() / 2.0F) - (singer.thePlayer.posY + (double)singer.thePlayer.getEyeHeight());
         Object unsigned = ((Entity)insider).posZ - singer.thePlayer.posZ;
         double var8 = (double)MathHelper.sqrt_double(prayer * prayer + unsigned * unsigned);
         float var10 = (float)(Math.atan2(unsigned, prayer) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(image, var8) * 180.0D / 3.141592653589793D));
         return new float[]{(singer.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var10 - singer.thePlayer.rotationYaw)) % 360.0F, (singer.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var11 - singer.thePlayer.rotationPitch)) % 360.0F};
      }
   }

   public static net.minecraft.util.Vec3 _howard(net.minecraft.util.Vec3 gatuvace, AxisAlignedBB urapemom) {
      return new net.minecraft.util.Vec3(MathHelper.clamp_double(((net.minecraft.util.Vec3)gatuvace).xCoord, ((AxisAlignedBB)urapemom).minX, ((AxisAlignedBB)urapemom).maxX), MathHelper.clamp_double(((net.minecraft.util.Vec3)gatuvace).yCoord, ((AxisAlignedBB)urapemom).minY, ((AxisAlignedBB)urapemom).maxY), MathHelper.clamp_double(((net.minecraft.util.Vec3)gatuvace).zCoord, ((AxisAlignedBB)urapemom).minZ, ((AxisAlignedBB)urapemom).maxZ));
   }

   public static float _merchant(float apubayay) {
      return MathHelper.clamp_float((float)apubayay, -90.0F, 90.0F);
   }

   public static float _sapphire(float ilopipiv, float izipidec, float bivinafa) {
      Object ezipibac = MathHelper.wrapAngleTo180_float((float)(izipidec - ilopipiv));
      if (ezipibac > bivinafa) {
         ezipibac = (float)bivinafa;
      }

      if (ezipibac < -bivinafa) {
         ezipibac = (float)(-bivinafa);
      }

      return ilopipiv + ezipibac;
   }

   public static float _stuff(net.minecraft.util.Vec3 erotica) {
      Object hills = (float)(((net.minecraft.util.Vec3)erotica).xCoord - essay$.thePlayer.posX);
      Object estate = (float)(((net.minecraft.util.Vec3)erotica).zCoord - essay$.thePlayer.posZ);
      Object destiny = (float)(StrictMath.atan2((double)estate, (double)hills) * 180.0D / 3.141592653589793D) - 90.0F;
      Object swing = essay$.thePlayer.rotationYaw;
      return swing + MathHelper.wrapAngleTo180_float(destiny - swing);
   }

   public static RotationUtils2 _netscape(EntityLivingBase eyedipuy) {
      return _apply(((EntityLivingBase)eyedipuy).posX, ((EntityLivingBase)eyedipuy).posY + (double)((EntityLivingBase)eyedipuy).getEyeHeight() - 0.4D, ((EntityLivingBase)eyedipuy).posZ);
   }

   public static RotationUtils2 _apply(double imofabem, double unanicod, double otaguzuz) {
      Object esisevan = essay$.thePlayer;
      Object ucuzatey = imofabem - esisevan.posX;
      Object adaripif = unanicod - (esisevan.posY + (double)esisevan.getEyeHeight());
      double var11 = otaguzuz - esisevan.posZ;
      double var13 = (double)MathHelper.sqrt_double(ucuzatey * ucuzatey + var11 * var11);
      float var15 = (float)(Math.atan2(var11, ucuzatey) * 180.0D / 3.141592653589793D) - 90.0F;
      float var16 = (float)(-(Math.atan2(adaripif, var13) * 180.0D / 3.141592653589793D));
      return new RotationUtils2(var15, var16);
   }

   public static net.minecraft.util.Vec3 _himself(float zitonudu, float upimizap) {
      Object usegofuf = Math.cos(Math.toRadians((double)(-zitonudu)) - 3.141592653589793D);
      Object opivufut = Math.sin(Math.toRadians((double)(-zitonudu)) - 3.141592653589793D);
      double var6 = -Math.cos(Math.toRadians((double)(-upimizap)));
      double var8 = Math.sin(Math.toRadians((double)(-upimizap)));
      return new net.minecraft.util.Vec3(opivufut * var6, var8, usegofuf * var6);
   }
}
