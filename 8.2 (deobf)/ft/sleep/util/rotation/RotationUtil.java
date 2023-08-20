//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.rotation;

import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPreUpdate;
import java.util.Random;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class RotationUtil {
   public static float _century() {
      return Helper.sprint$.thePlayer.rotationPitch;
   }

   public static void _software(float eradapeb) {
      Helper.sprint$.thePlayer.rotationPitch = (float)eradapeb;
   }

   public static float _filme() {
      return Helper.sprint$.thePlayer.rotationYaw;
   }

   public static void _brief(float greek) {
      Helper.sprint$.thePlayer.rotationYaw = (float)greek;
   }

   public static float[] _rider(Entity outdoors, float general, float lotus, boolean healing) {
      Object friday = ((Entity)outdoors).posX - Helper.sprint$.thePlayer.posX;
      Object portion = ((Entity)outdoors).posZ - Helper.sprint$.thePlayer.posZ;
      double johnny;
      if (outdoors instanceof EntityLivingBase) {
         Object texts = (EntityLivingBase)outdoors;
         johnny = texts.posY + (double)texts.getEyeHeight() - (Helper.sprint$.thePlayer.posY + (double) Helper.sprint$.thePlayer.getEyeHeight());
      } else {
         johnny = (((Entity)outdoors).getEntityBoundingBox().minY + ((Entity)outdoors).getEntityBoundingBox().maxY) / 2.0D - (Helper.sprint$.thePlayer.posY + (double) Helper.sprint$.thePlayer.getEyeHeight());
      }

      new Random();
      Object cheats = (double)MathHelper.sqrt_double(friday * friday + portion * portion);
      float var13 = (float)(Math.atan2(portion, friday) * 180.0D / 3.141592653589793D) - 90.0F;
      float var14 = (float)(-Math.atan2(johnny - (outdoors instanceof EntityPlayer ? 0.25D : Double.longBitsToDouble(0L)), cheats) * 180.0D / 3.141592653589793D);
      float var15 = _retreat(Helper.sprint$.thePlayer.rotationPitch, var14, (float)lotus);
      float var16 = _retreat(Helper.sprint$.thePlayer.rotationYaw, var13, (float)general);
      return new float[]{var16, var15};
   }

   public static float _retreat(float andale, float liberia, float stadium) {
      Object saddam = MathHelper.wrapAngleTo180_float((float)(liberia - andale));
      if (saddam > stadium) {
         saddam = (float)stadium;
      }

      if (saddam < -stadium) {
         saddam = (float)(-stadium);
      }

      return andale + saddam;
   }

   public static float[] _techno(Entity ayoborad) {
      Object oramapob = Minecraft.getMinecraft().thePlayer.posX;
      Object oyeyivuf = Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight();
      Object irocusuf = Minecraft.getMinecraft().thePlayer.posZ;
      Object lisocada = ((Entity)ayoborad).posX;
      Object yolezice = ((Entity)ayoborad).posY + (double)((Entity)ayoborad).getEyeHeight();
      Object gogiyiro = ((Entity)ayoborad).posZ;
      double var13 = oramapob - lisocada;
      double var15 = oyeyivuf - yolezice;
      double var17 = irocusuf - gogiyiro;
      double var19 = Math.sqrt(Math.pow(var13, 2.0D) + Math.pow(var17, 2.0D));
      float var21 = Float.intBitsToFloat(0);
      float var22 = Float.intBitsToFloat(0);
      var21 = (float)(Math.toDegrees(Math.atan2(var17, var13)) + 90.0D);
      var22 = (float)Math.toDegrees(Math.atan2(var19, var15));
      return new float[]{var21, 90.0F - var22};
   }

   public static float[] _economic(Entity apufemil) {
      if (apufemil == null) {
         return null;
      } else {
         Object gemebilo = ((Entity)apufemil).posX - Helper.sprint$.thePlayer.posX;
         Object tefuvaro = ((Entity)apufemil).posZ - Helper.sprint$.thePlayer.posZ;
         double bisarevi;
         if (apufemil instanceof EntityLivingBase) {
            EntityLivingBase var7 = (EntityLivingBase)apufemil;
            bisarevi = var7.posY + ((double)var7.getEyeHeight() - 0.4D) - (Helper.sprint$.thePlayer.posY + (double) Helper.sprint$.thePlayer.getEyeHeight());
         } else {
            bisarevi = (((Entity)apufemil).getCollisionBoundingBox().minY + ((Entity)apufemil).getCollisionBoundingBox().maxY) / 2.0D - (Helper.sprint$.thePlayer.posY + (double) Helper.sprint$.thePlayer.getEyeHeight());
         }

         double var11 = (double)MathHelper.sqrt_double(gemebilo * gemebilo + tefuvaro * tefuvaro);
         float var9 = (float)(Math.atan2(tefuvaro, gemebilo) * 180.0D / 3.141592653589793D) - 90.0F;
         float var10 = (float)(-Math.atan2(bisarevi, var11) * 180.0D / 3.141592653589793D);
         return new float[]{var9, var10};
      }
   }

   public static float[] _forces(BlockPos ogatelul) {
      return _hamilton(Helper.sprint$.thePlayer.getPositionVector().addVector(Double.longBitsToDouble(0L), (double) Helper.sprint$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L)), new net.minecraft.util.Vec3((double)((BlockPos)ogatelul).getX() + 0.5D, (double)((BlockPos)ogatelul).getY() + 0.5D, (double)((BlockPos)ogatelul).getZ() + 0.5D));
   }

   public static float[] _measured(net.minecraft.util.Vec3 refresh) {
      return _hamilton(Helper.sprint$.thePlayer.getPositionVector().addVector(Double.longBitsToDouble(0L), (double) Helper.sprint$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L)), (net.minecraft.util.Vec3)refresh);
   }

   public static net.minecraft.util.Vec3 _viruses(net.minecraft.util.Vec3 dofefuto) {
      return new net.minecraft.util.Vec3(((net.minecraft.util.Vec3)dofefuto).xCoord, Double.longBitsToDouble(0L), ((net.minecraft.util.Vec3)dofefuto).zCoord);
   }

   public static float[] _hamilton(net.minecraft.util.Vec3 dulapuri, net.minecraft.util.Vec3 sarevebi) {
      Object nobinuya = ((net.minecraft.util.Vec3)sarevebi).subtract((net.minecraft.util.Vec3)dulapuri);
      Object uporupet = _viruses(nobinuya).lengthVector();
      Object eyefuler = (float)Math.toDegrees(Math.atan2(nobinuya.zCoord, nobinuya.xCoord)) - 90.0F;
      float var6 = (float)(-Math.toDegrees(Math.atan2(nobinuya.yCoord, uporupet)));
      return new float[]{eyefuler, var6};
   }

   public static int _japan(float solving, int bennett) {
      Object rules = (int)((double)(solving + (float)(360 / (2 * bennett))) + 0.5D) % 360;
      if (rules < 0) {
         rules += 360;
      }

      return rules / (360 / bennett);
   }

   public static boolean _pocket(Entity briefs) {
      Object appeals = new net.minecraft.util.Vec3(Helper.sprint$.thePlayer.posX, Helper.sprint$.thePlayer.posY + (double) Helper.sprint$.thePlayer.getEyeHeight(), Helper.sprint$.thePlayer.posZ);
      Object mandate = ((Entity)briefs).getEntityBoundingBox();
      Object posting = new net.minecraft.util.Vec3(((Entity)briefs).posX, ((Entity)briefs).posY + (double)(((Entity)briefs).getEyeHeight() / 1.32F), ((Entity)briefs).posZ);
      Object streams = ((Entity)briefs).posX - 0.25D;
      Object returns = ((Entity)briefs).posX + 0.25D;
      Object campus = ((Entity)briefs).posY;
      Object problems = ((Entity)briefs).posY + Math.abs(((Entity)briefs).posY - mandate.maxY);
      double var12 = ((Entity)briefs).posZ - 0.25D;
      double var14 = ((Entity)briefs).posZ + 0.25D;
      boolean var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
      if (var16) {
         return true;
      } else {
         posting = new net.minecraft.util.Vec3(returns, campus, var12);
         var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
         if (var16) {
            return true;
         } else {
            posting = new net.minecraft.util.Vec3(streams, campus, var12);
            var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
            if (var16) {
               return true;
            } else {
               posting = new net.minecraft.util.Vec3(streams, campus, var14);
               var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
               if (var16) {
                  return true;
               } else {
                  posting = new net.minecraft.util.Vec3(returns, campus, var14);
                  var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
                  if (var16) {
                     return true;
                  } else {
                     posting = new net.minecraft.util.Vec3(returns, problems, var12);
                     var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
                     if (var16) {
                        return true;
                     } else {
                        posting = new net.minecraft.util.Vec3(streams, problems, var12);
                        var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
                        if (var16) {
                           return true;
                        } else {
                           posting = new net.minecraft.util.Vec3(streams, problems, var14 - 0.1D);
                           var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
                           if (var16) {
                              return true;
                           } else {
                              posting = new net.minecraft.util.Vec3(returns, problems, var14);
                              var16 = Helper.sprint$.theWorld.rayTraceBlocks(appeals, posting) == null;
                              return var16;
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public static float _locked(float gesizimu, double bugasari, double tosefegi, double zonozebe) {
      Object sulobato = bugasari - Helper.sprint$.thePlayer.posX;
      double var9 = tosefegi - Helper.sprint$.thePlayer.posY;
      double var11 = zonozebe - Helper.sprint$.thePlayer.posZ;
      double var13 = Double.longBitsToDouble(0L);
      double var15 = Math.toDegrees(Math.atan(var11 / sulobato));
      if (var11 < Double.longBitsToDouble(0L) && sulobato < Double.longBitsToDouble(0L)) {
         if (sulobato != Double.longBitsToDouble(0L)) {
            var13 = 90.0D + var15;
         }
      } else if (var11 < Double.longBitsToDouble(0L) && sulobato > Double.longBitsToDouble(0L)) {
         if (sulobato != Double.longBitsToDouble(0L)) {
            var13 = -90.0D + var15;
         }
      } else if (var11 != Double.longBitsToDouble(0L)) {
         var13 = Math.toDegrees(-Math.atan(sulobato / var11));
      }

      return MathHelper.wrapAngleTo180_float(-(gesizimu - (float)var13));
   }

   public static float _troops(float elopaned, double igufizac, double evigules, double nayesifa) {
      Object yigugoye = igufizac - Helper.sprint$.thePlayer.posX;
      double var9 = evigules - Helper.sprint$.thePlayer.posY;
      double var11 = nayesifa - Helper.sprint$.thePlayer.posZ;
      double var13 = (double)MathHelper.sqrt_double(yigugoye * yigugoye + var11 * var11);
      double var15 = -Math.toDegrees(Math.atan(var9 / var13));
      return -MathHelper.wrapAngleTo180_float(elopaned - (float)var15) - 2.5F;
   }

   public static float[] _kings(BlockPos cizugodi) {
      return _futures(Helper.sprint$.thePlayer.getPositionVector().addVector(Double.longBitsToDouble(0L), (double) Helper.sprint$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L)), new net.minecraft.util.Vec3((double)((BlockPos)cizugodi).getX() + 0.5D, (double)((BlockPos)cizugodi).getY() + 0.5D, (double)((BlockPos)cizugodi).getZ() + 0.5D));
   }

   public static float[] _futures(net.minecraft.util.Vec3 required, net.minecraft.util.Vec3 report) {
      Object agency = ((net.minecraft.util.Vec3)report).subtract((net.minecraft.util.Vec3)required);
      Object fujitsu = _viruses(agency).lengthVector();
      Object headers = (float)Math.toDegrees(Math.atan2(agency.zCoord, agency.xCoord)) - 90.0F;
      Object karen = (float)(-Math.toDegrees(Math.atan2(agency.yCoord, fujitsu)));
      float var7 = Helper.sprint$.thePlayer.renderYawOffset + MathHelper.wrapAngleTo180_float(headers - Helper.sprint$.thePlayer.renderYawOffset);
      return new float[]{headers, MathHelper.clamp_float(karen, -90.0F, 90.0F), var7};
   }

   public static float _trucks(float fibagipi, float obugapey) {
      Object luvidulu = Math.abs((float)(fibagipi - obugapey)) % 360.0F;
      if (luvidulu > 180.0F) {
         luvidulu = 360.0F - luvidulu;
      }

      return luvidulu;
   }

   public static float[] _barriers(EntityLivingBase odotigad) {
      if (odotigad == null) {
         return null;
      } else {
         Object amaburid = Helper.sprint$.thePlayer;
         Object ovaciloc = ((EntityLivingBase)odotigad).posX - amaburid.posX;
         Object ezecofeb = ((EntityLivingBase)odotigad).posY + (double)((EntityLivingBase)odotigad).getEyeHeight() * 0.9D - (amaburid.posY + (double)amaburid.getEyeHeight());
         Object opasebet = ((EntityLivingBase)odotigad).posZ - amaburid.posZ;
         double var8 = (double)MathHelper.sqrt_double(ovaciloc * ovaciloc + opasebet * opasebet);
         float var10 = (float)(Math.atan2(opasebet, ovaciloc) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(ezecofeb, var8) * 180.0D / 3.141592653589793D));
         return new float[]{amaburid.rotationYaw + MathHelper.wrapAngleTo180_float(var10 - amaburid.rotationYaw), amaburid.rotationPitch + MathHelper.wrapAngleTo180_float(var11 - amaburid.rotationPitch)};
      }
   }

   public static float _updating(EntityLivingBase goods) {
      Object vertical = new int[]{2, 4, 6, 8, 10};
      Object parish = Float.intBitsToFloat(0);
      boolean var4 = false;

      for(Object costumes = 0; costumes < 10; ++costumes) {
         if (((EntityLivingBase)goods).hurtTime <= vertical[0]) {
            costumes = vertical[0];
         }

         if (((EntityLivingBase)goods).hurtTime <= vertical[1]) {
            costumes = vertical[1];
         }

         if (((EntityLivingBase)goods).hurtTime <= vertical[2]) {
            costumes = vertical[2];
         }

         if (((EntityLivingBase)goods).hurtTime <= vertical[3]) {
            costumes = vertical[3];
         }

         if (((EntityLivingBase)goods).hurtTime <= vertical[4]) {
            costumes = vertical[4];
         }

         if (costumes <= 2) {
            parish = (float)(Math.random() * -0.05000000074505806D);
         }

         if (costumes <= 4) {
            parish = Float.intBitsToFloat(0);
         }

         if (costumes <= 6) {
            parish = Float.intBitsToFloat(0);
         }

         if (costumes <= 8) {
            parish = Float.intBitsToFloat(0);
         }

         if (costumes <= 10) {
            parish = (float)(Math.random() * 0.05000000074505806D);
         }
      }

      if (parish > 1.0F) {
         parish = Float.intBitsToFloat(0);
      }

      return parish;
   }

   public static float[] _numbers(EntityLivingBase becufibi) {
      Object savufobu = ((EntityLivingBase)becufibi).posX;
      Object viboyife = ((EntityLivingBase)becufibi).posZ;
      double var5 = ((EntityLivingBase)becufibi).posY + (double)(((EntityLivingBase)becufibi).getEyeHeight() / 2.0F);
      net.minecraft.util.Vec3 var7 = new net.minecraft.util.Vec3(((EntityLivingBase)becufibi).posX, var5, ((EntityLivingBase)becufibi).posZ);
      net.minecraft.util.Vec3 var8 = new net.minecraft.util.Vec3(Helper.sprint$.thePlayer.posX, Helper.sprint$.thePlayer.posY + 1.35D + (double)(_updating((EntityLivingBase)becufibi) * 10.0F), Helper.sprint$.thePlayer.posZ);
      return _hamilton(var8, var7);
   }

   public static double[] _butts(double covering, double stretch, double helps) {
      double var6 = (double)MathHelper.sqrt_double((double)(covering * covering + stretch * stretch));
      double var8 = Math.atan2((double)stretch, (double)covering) * 180.0D / 3.141592653589793D - 90.0D;
      double var10 = -(Math.atan2((double)helps, var6) * 180.0D / 3.141592653589793D);
      return new double[]{(double)(Helper.sprint$.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float((float)(var8 - (double) Helper.sprint$.thePlayer.rotationYaw))), (double)(Helper.sprint$.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float((float)(var10 - (double) Helper.sprint$.thePlayer.rotationPitch)))};
   }

   public static boolean _civil(EventPacketReceive realtors, Rotation expedia) {
      Object possibly = EventPacketReceive.getPacket();
      if (possibly instanceof S08PacketPlayerPosLook) {
         Object write = (S08PacketPlayerPosLook)possibly;
         float var4 = write.getYaw();
         float var5 = write.getPitch();
         var4 = ((Rotation)expedia)._pontiac();
         var5 = ((Rotation)expedia)._nerve();
         ((EventPacketReceive)realtors).setPacket(write);
         return true;
      } else {
         return false;
      }
   }

   public static float[] _nirvana(double eresesuy, double timidasi, double ribipuso) {
      Object usomefon = Minecraft.getMinecraft().thePlayer;
      Object luralezo = eresesuy - usomefon.posX;
      Object yiyenera = timidasi - (usomefon.posY + (double)usomefon.getEyeHeight());
      double var11 = ribipuso - usomefon.posZ;
      double var13 = (double)MathHelper.sqrt_double(luralezo * luralezo + var11 * var11);
      float var15 = (float)(Math.atan2(var11, luralezo) * 180.0D / 3.141592653589793D) - 90.0F;
      float var16 = (float)(-(Math.atan2(yiyenera, var13) * 180.0D / 3.141592653589793D));
      return new float[]{var15, var16};
   }

   public static Rotation _horror(double intent, double beliefs, double levels) {
      Object password = intent - (Minecraft.getMinecraft().thePlayer.prevPosX + (Minecraft.getMinecraft().thePlayer.posX - Minecraft.getMinecraft().thePlayer.prevPosX));
      double var8 = beliefs - (Minecraft.getMinecraft().thePlayer.prevPosY + (Minecraft.getMinecraft().thePlayer.posY - Minecraft.getMinecraft().thePlayer.prevPosY) + (Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().maxY - Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY));
      double var10 = levels - (Minecraft.getMinecraft().thePlayer.prevPosZ + (Minecraft.getMinecraft().thePlayer.posZ - Minecraft.getMinecraft().thePlayer.prevPosZ));
      double var12 = (double)MathHelper.sqrt_double(password * password + var10 * var10);
      return new Rotation((float)(Math.atan2(var10, password) * 180.0D / 3.141592653589793D) - 90.0F, (float)(-(Math.atan2(var8, var12) * 180.0D / 3.141592653589793D)));
   }

   public static float _ought(float itobigin, float aguzesef) {
      return MathHelper.wrapAngleTo180_float((float)(aguzesef - itobigin));
   }

   public static float _brain(float agents, float expansys) {
      return ((agents - expansys) % 360.0F + 540.0F) % 360.0F - 180.0F;
   }

   public static Rotation _briefly(EntityLivingBase voters) {
      Object shops = ((EntityLivingBase)voters).prevPosX + (((EntityLivingBase)voters).posX - ((EntityLivingBase)voters).prevPosX);
      Object magnet = ((EntityLivingBase)voters).prevPosY + (((EntityLivingBase)voters).posY - ((EntityLivingBase)voters).prevPosY);
      double var5 = ((EntityLivingBase)voters).prevPosZ + (((EntityLivingBase)voters).posZ - ((EntityLivingBase)voters).prevPosZ);
      return _horror(shops, magnet, var5);
   }

   public static float[] _muslims(float[] erecesic, float[] onomalif) {
      Object dapunebe = Minecraft.getMinecraft();
      Object ogedalir = (float)((Object[])erecesic)[0];
      Object basilalu = (float)((Object[])erecesic)[1];
      Object emipapid = (float)((Object[])onomalif)[0];
      Object ocezisuy = (float)((Object[])onomalif)[1];
      Object migepaye = dapunebe.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      Object inozofes = migepaye * migepaye * migepaye * 1.2F;
      Object obaronit = ogedalir - emipapid;
      Object tenofoce = basilalu - ocezisuy;
      Object agutopam = obaronit - obaronit % inozofes;
      Object segomeza = tenofoce - tenofoce % inozofes;
      Object dagabida = emipapid + agutopam;
      Object simelibo = ocezisuy + segomeza;
      return new float[]{dagabida, simelibo};
   }

   public static float[] _yours(Vector3d nicoruse, Vector3d pucevara) {
      Object yunisoza = ((Vector3d)pucevara).x - ((Vector3d)nicoruse).x;
      Object icatenab = ((Vector3d)pucevara).y - ((Vector3d)nicoruse).y;
      Object netoluda = ((Vector3d)pucevara).z - ((Vector3d)nicoruse).z;
      double var8 = Math.sqrt(yunisoza * yunisoza + netoluda * netoluda);
      float var10 = (float)Math.toDegrees(Math.atan2(netoluda, yunisoza)) - 90.0F;
      float var11 = (float)(-Math.toDegrees(Math.atan2(icatenab, var8)));
      return new float[]{MathHelper.wrapAngleTo180_float(var10), MathHelper.wrapAngleTo180_float(var11)};
   }

   public static void _backup(EventPreUpdate saving, float[] ensemble, float subjects, boolean costa) {
      Object jacob = new float[]{EventPreUpdate.getPrevYaw(), EventPreUpdate.getPrevPitch()};
      Object outlined = new float[]{_haven(jacob[0], (float)((Object[])ensemble)[0], (float)subjects), _haven(jacob[1], (float)((Object[])ensemble)[1], (float)subjects)};
      outlined[0] = MathHelper.wrapAngleTo180_float(outlined[0] - jacob[0]) + jacob[0];
      outlined[1] = MathHelper.wrapAngleTo180_float(outlined[1] - jacob[1]) + jacob[1];
      outlined = _memorial(outlined, jacob);
      if (!costa) {
         Minecraft.getMinecraft().thePlayer.rotationYaw = outlined[0];
         Minecraft.getMinecraft().thePlayer.rotationPitch = outlined[1];
      }

      ((EventPreUpdate)saving).setYaw(outlined[0]);
      ((EventPreUpdate)saving).setPitch(outlined[1]);
   }

   public static float[] _memorial(float[] avocagop, float[] ovavayel) {
      Object opofefil = new float[]{(float)(((Object[])avocagop)[0] - ((Object[])ovavayel)[0]), (float)(((Object[])avocagop)[1] - ((Object[])ovavayel)[1])};
      Object opubifim = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      Object esedovot = opubifim * opubifim * opubifim * 1.2F;
      ((Object[])avocagop)[0] -= opofefil[0] % esedovot;
      ((Object[])avocagop)[1] -= opofefil[1] % esedovot;
      return (float[])avocagop;
   }

   public static float _haven(float vugiguyu, float ilulazib, float iciduvel) {
      Object nosupude = MathHelper.wrapAngleTo180_float((float)(ilulazib - vugiguyu));
      if (nosupude > iciduvel) {
         nosupude = (float)iciduvel;
      }

      if (nosupude < -iciduvel) {
         nosupude = (float)(-iciduvel);
      }

      return vugiguyu + nosupude;
   }

   public static float[] _pipes(EntityLivingBase ficeruru) {
      Object ecepibay = ((EntityLivingBase)ficeruru).posX + (((EntityLivingBase)ficeruru).posX - ((EntityLivingBase)ficeruru).lastTickPosX) - Minecraft.getMinecraft().thePlayer.posX;
      Object posagiro = ((EntityLivingBase)ficeruru).posY - 3.5D + (double)((EntityLivingBase)ficeruru).getEyeHeight() - Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight();
      Object sidoteso = ((EntityLivingBase)ficeruru).posZ + (((EntityLivingBase)ficeruru).posZ - ((EntityLivingBase)ficeruru).lastTickPosZ) - Minecraft.getMinecraft().thePlayer.posZ;
      double var7 = Math.sqrt(Math.pow(ecepibay, 2.0D) + Math.pow(sidoteso, 2.0D));
      float var9 = (float)Math.toDegrees(-Math.atan(ecepibay / sidoteso));
      float var10 = (float)(-Math.toDegrees(Math.atan(posagiro / var7)));
      if (ecepibay < Double.longBitsToDouble(0L) && sidoteso < Double.longBitsToDouble(0L)) {
         var9 = (float)(90.0D + Math.toDegrees(Math.atan(sidoteso / ecepibay)));
      } else if (ecepibay > Double.longBitsToDouble(0L) && sidoteso < Double.longBitsToDouble(0L)) {
         var9 = (float)(-90.0D + Math.toDegrees(Math.atan(sidoteso / ecepibay)));
      }

      return new float[]{var9, var10};
   }

   public static float[] _aaron(double edilevol, double tisamiya, double yitazeya) {
      Object imecuzab = edilevol - Minecraft.getMinecraft().thePlayer.posX;
      Object gadimoba = tisamiya - Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight();
      double var10 = yitazeya - Minecraft.getMinecraft().thePlayer.posZ;
      double var12 = Math.sqrt(Math.pow(imecuzab, 2.0D) + Math.pow(var10, 2.0D));
      float var14 = (float)Math.toDegrees(-Math.atan(imecuzab / var10));
      float var15 = (float)(-Math.toDegrees(Math.atan(gadimoba / var12)));
      if (imecuzab < Double.longBitsToDouble(0L) && var10 < Double.longBitsToDouble(0L)) {
         var14 = (float)(90.0D + Math.toDegrees(Math.atan(var10 / imecuzab)));
      } else if (imecuzab > Double.longBitsToDouble(0L) && var10 < Double.longBitsToDouble(0L)) {
         var14 = (float)(-90.0D + Math.toDegrees(Math.atan(var10 / imecuzab)));
      }

      return new float[]{var14, var15};
   }

   public static Vector3d2 _compact() {
      return new Vector3d2(Helper.sprint$.thePlayer.posX, Helper.sprint$.thePlayer.posY, Helper.sprint$.thePlayer.posZ);
   }

   public static Vector2f _producer(Vector3d2 username) {
      return _politics(_compact()._diploma(Double.longBitsToDouble(0L), (double) Helper.sprint$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L)), (Vector3d2)username);
   }

   public static Vector2f _politics(Vector3d2 gallery, Vector3d2 carbon) {
      Object illness = ((Vector3d2)carbon)._cassette((Vector3d2)gallery);
      Object familiar = Math.hypot(illness._adrian(), illness._alien());
      Object carry = (float)(MathHelper.atan2(illness._alien(), illness._adrian()) * 180.0D / 3.1415927410125732D) - 90.0F;
      float var6 = (float)(-(MathHelper.atan2(illness._monroe(), familiar) * 180.0D / 3.1415927410125732D));
      return new Vector2f(carry, var6);
   }

   public static float _birth(float broadway, double wichita, double skilled) {
      Object storm = Minecraft.getMinecraft();
      Object removing = wichita - storm.thePlayer.posX;
      double var8 = skilled - storm.thePlayer.posZ;
      double var10 = Double.longBitsToDouble(0L);
      if (var8 < Double.longBitsToDouble(0L) && removing < Double.longBitsToDouble(0L)) {
         if (removing != Double.longBitsToDouble(0L)) {
            var10 = 90.0D + Math.toDegrees(Math.atan(var8 / removing));
         }
      } else if (var8 < Double.longBitsToDouble(0L) && removing > Double.longBitsToDouble(0L)) {
         if (removing != Double.longBitsToDouble(0L)) {
            var10 = -90.0D + Math.toDegrees(Math.atan(var8 / removing));
         }
      } else if (var8 != Double.longBitsToDouble(0L)) {
         var10 = Math.toDegrees(-Math.atan(removing / var8));
      }

      return MathHelper.wrapAngleTo180_float(-(broadway - (float)var10));
   }

   public static float _scanner(float seyoferi, Entity fitopayu, double osupayen) {
      Object uvopapen = ((Entity)fitopayu).posX - Minecraft.getMinecraft().thePlayer.posX;
      Object gufegefa = ((Entity)fitopayu).posZ - Minecraft.getMinecraft().thePlayer.posZ;
      double var8 = osupayen - 2.2D + (double)((Entity)fitopayu).getEyeHeight() - Minecraft.getMinecraft().thePlayer.posY;
      double var10 = (double)MathHelper.sqrt_double(uvopapen * uvopapen + gufegefa * gufegefa);
      var8 = ((Entity)fitopayu).posY - 3.5D + (((Entity)fitopayu).posY - ((Entity)fitopayu).lastTickPosY) + (double)((Entity)fitopayu).getEyeHeight() * 1.3185D - Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight() - 0.25592D;
      double var14 = Math.sqrt(Math.pow(uvopapen, 2.0D) + Math.pow(gufegefa, 2.0D));
      double var12 = (double)((float)((double)((float)(-Math.toDegrees(Math.atan(var8 / var14))) - 2.0F) + (double)((Entity)fitopayu).getDistanceToEntity(Minecraft.getMinecraft().thePlayer) * 0.2D) + 1.0F);
      return -MathHelper.wrapAngleTo180_float(seyoferi - (float)var12);
   }

   public static float _gardens(float mupezeru, float amefanip) {
      return MathHelper.wrapAngleTo180_float((float)(-(mupezeru - amefanip)));
   }
}
