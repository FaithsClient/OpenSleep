//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.player;

import ft.sleep.api.events.world.EventMove;
import ft.sleep.api.events.world.EventPreUpdate;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.vecmath.Vector2f;

import ft.sleep.util.rotation.RotationUtils6;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class MovementUtils {
   public static Minecraft warnings$ = Minecraft.getMinecraft();
   public static double rhythm$ = 0.41999998688698D;
   public static float niger$ = _gnome(6.283185307179586D);
   public static float subtle$ = _check(0.017453292519943295D);

   public static void _maine(EventMove apudocuf, double atedavuy, float emarizos, double epizireg, double sudiliru) {
      Object ozozodiy = (double)sudiliru;
      double var10 = (double)epizireg;
      float var12 = (float)emarizos;
      if (sudiliru == Double.longBitsToDouble(0L) && epizireg == Double.longBitsToDouble(0L)) {
         ((EventMove)apudocuf).setZ(Double.longBitsToDouble(0L));
         ((EventMove)apudocuf).setX(Double.longBitsToDouble(0L));
      } else {
         if (sudiliru != Double.longBitsToDouble(0L)) {
            if (epizireg > Double.longBitsToDouble(0L)) {
               var12 = emarizos + (float)(sudiliru > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (epizireg < Double.longBitsToDouble(0L)) {
               var12 = emarizos + (float)(sudiliru > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            var10 = Double.longBitsToDouble(0L);
            if (sudiliru > Double.longBitsToDouble(0L)) {
               ozozodiy = 1.0D;
            } else if (sudiliru < Double.longBitsToDouble(0L)) {
               ozozodiy = -1.0D;
            }
         }

         double var13 = Math.cos(Math.toRadians((double)(var12 + 90.0F)));
         double var15 = Math.sin(Math.toRadians((double)(var12 + 90.0F)));
         ((EventMove)apudocuf).setX(ozozodiy * atedavuy * var13 + var10 * atedavuy * var15);
         ((EventMove)apudocuf).setZ(ozozodiy * atedavuy * var15 - var10 * atedavuy * var13);
      }

   }

   public static void _stunning(EventMove umazuvev, double icevivoy, double linaminu, double usategog) {
      Object ilesepof = (double)linaminu;
      double var9 = (double)warnings$.thePlayer.movementInput.moveStrafe;
      float var11 = warnings$.thePlayer.rotationYaw;
      if (linaminu == Double.longBitsToDouble(0L) && var9 == Double.longBitsToDouble(0L)) {
         ((EventMove)umazuvev).setZ(Double.longBitsToDouble(0L));
         ((EventMove)umazuvev).setX(Double.longBitsToDouble(0L));
      } else {
         if (linaminu != Double.longBitsToDouble(0L)) {
            if (var9 > Double.longBitsToDouble(0L)) {
               var11 += (float)(linaminu > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (var9 < Double.longBitsToDouble(0L)) {
               var11 += (float)(linaminu > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            var9 = Double.longBitsToDouble(0L);
            if (linaminu > Double.longBitsToDouble(0L)) {
               ilesepof = 1.0D;
            } else if (linaminu < Double.longBitsToDouble(0L)) {
               ilesepof = -1.0D;
            }
         }

         double var12 = Math.cos(Math.toRadians((double)(var11 + 90.0F)));
         double var14 = Math.sin(Math.toRadians((double)(var11 + 90.0F)));
         ((EventMove)umazuvev).setX((ilesepof * icevivoy * var12 + var9 * icevivoy * var14) * usategog);
         ((EventMove)umazuvev).setZ((ilesepof * icevivoy * var14 - var9 * icevivoy * var12) * usategog);
      }

   }

   public static void _adopt(EventPreUpdate customer, double workshop, float carroll, double sticker, double assign) {
      Object keith = (double)assign;
      double var10 = (double)sticker;
      float var12 = (float)carroll;
      if (assign == Double.longBitsToDouble(0L) && sticker == Double.longBitsToDouble(0L)) {
         ((EventPreUpdate)customer).setZ(Double.longBitsToDouble(0L));
         ((EventPreUpdate)customer).setX(Double.longBitsToDouble(0L));
      } else {
         if (assign != Double.longBitsToDouble(0L)) {
            if (sticker > Double.longBitsToDouble(0L)) {
               var12 = carroll + (float)(assign > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (sticker < Double.longBitsToDouble(0L)) {
               var12 = carroll + (float)(assign > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            var10 = Double.longBitsToDouble(0L);
            if (assign > Double.longBitsToDouble(0L)) {
               keith = 1.0D;
            } else if (assign < Double.longBitsToDouble(0L)) {
               keith = -1.0D;
            }
         }

         double var13 = Math.cos(Math.toRadians((double)(var12 + 90.0F)));
         double var15 = Math.sin(Math.toRadians((double)(var12 + 90.0F)));
         ((EventPreUpdate)customer).setX(keith * workshop * var13 + var10 * workshop * var15);
         ((EventPreUpdate)customer).setZ(keith * workshop * var15 - var10 * workshop * var13);
      }

   }

   public static boolean _learn() {
      return !(warnings$.theWorld.getBlockState(new BlockPos(warnings$.thePlayer.posX, warnings$.thePlayer.getEntityBoundingBox().maxY + 0.41999998688697815D, warnings$.thePlayer.posZ)).getBlock() instanceof BlockAir);
   }

   public static void _roots(double atulesid, double nanavimu, double var4) {
      warnings$.thePlayer.setPosition(warnings$.thePlayer.posX + atulesid, warnings$.thePlayer.posY + nanavimu, warnings$.thePlayer.posZ + var4);
   }

   public static double _madness(double ulanisod) {
      double var2 = (double)ulanisod;
      if (warnings$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         var2 = ulanisod * (1.0D + 0.2D * (double)(warnings$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1));
      }

      return var2;
   }

   public static double _record(double assist) {
      if (warnings$.thePlayer.isPotionActive(Potion.jump)) {
         int var2 = warnings$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
         assist += (double)((float)(var2 + 1) * 0.1F);
      }

      return (double)assist;
   }

   public static boolean _plain() {
      return warnings$.thePlayer.onGround && warnings$.thePlayer.isCollidedVertically;
   }

   public static boolean _bumper() {
      return warnings$.thePlayer.moveForward != Float.intBitsToFloat(0) || warnings$.thePlayer.moveStrafing != Float.intBitsToFloat(0);
   }

   public static boolean _journey(EntityLivingBase muyusesa) {
      return ((EntityLivingBase)muyusesa).moveForward != Float.intBitsToFloat(0) || ((EntityLivingBase)muyusesa).moveStrafing != Float.intBitsToFloat(0);
   }

   public static boolean _courses(double garadegi) {
      return !warnings$.theWorld.getCollidingBoundingBoxes(warnings$.thePlayer, warnings$.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-garadegi), Double.longBitsToDouble(0L))).isEmpty();
   }

   public static int _colony() {
      return warnings$.thePlayer.isPotionActive(Potion.moveSpeed) ? warnings$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static void _redhead(EventMove asipodir, double iralurud, double fefelilo) {
      Object lopasuyo = (double)warnings$.thePlayer.movementInput.moveForward;
      Object nagaboma = (double)warnings$.thePlayer.movementInput.moveStrafe;
      float var9 = warnings$.thePlayer.rotationYaw;
      if (lopasuyo == Double.longBitsToDouble(0L) && nagaboma == Double.longBitsToDouble(0L)) {
         ((EventMove)asipodir).setX(Double.longBitsToDouble(0L));
         ((EventMove)asipodir).setZ(Double.longBitsToDouble(0L));
      } else {
         if (lopasuyo != Double.longBitsToDouble(0L)) {
            if (nagaboma > Double.longBitsToDouble(0L)) {
               var9 += (float)(lopasuyo > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (nagaboma < Double.longBitsToDouble(0L)) {
               var9 += (float)(lopasuyo > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            nagaboma = Double.longBitsToDouble(0L);
            if (lopasuyo > Double.longBitsToDouble(0L)) {
               lopasuyo = 1.0D;
            } else if (lopasuyo < Double.longBitsToDouble(0L)) {
               lopasuyo = -1.0D;
            }
         }

         double var10 = Math.sin(Math.toRadians((double)var9));
         double var12 = Math.cos(Math.toRadians((double)var9));
         ((EventMove)asipodir).setX((lopasuyo * iralurud * -var10 + nagaboma * iralurud * var12) * fefelilo);
         ((EventMove)asipodir).setZ((lopasuyo * iralurud * var12 - nagaboma * iralurud * -var10) * fefelilo);
      }

   }

   public static double _refer(double warning, double resulted) {
      // $FF: Couldn't be decompiled
   }

   public static void _mercy(double etucorac) {
      Object alipafoz = (double)warnings$.thePlayer.movementInput.moveForward;
      Object umepefup = (double)warnings$.thePlayer.movementInput.moveStrafe;
      Object zopozafu = (double)warnings$.thePlayer.rotationYaw;
      if (alipafoz == Double.longBitsToDouble(0L) && umepefup == Double.longBitsToDouble(0L)) {
         warnings$.thePlayer.motionX = Double.longBitsToDouble(0L);
         warnings$.thePlayer.motionZ = Double.longBitsToDouble(0L);
      } else {
         if (alipafoz != Double.longBitsToDouble(0L)) {
            if (umepefup > Double.longBitsToDouble(0L)) {
               zopozafu += (double)(alipafoz > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (umepefup < Double.longBitsToDouble(0L)) {
               zopozafu += (double)(alipafoz > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            umepefup = Double.longBitsToDouble(0L);
            if (alipafoz > Double.longBitsToDouble(0L)) {
               alipafoz = 1.0D;
            } else if (alipafoz < Double.longBitsToDouble(0L)) {
               alipafoz = -1.0D;
            }
         }

         double var8 = Math.sin(Math.toRadians(zopozafu));
         double var10 = Math.cos(Math.toRadians(zopozafu));
         warnings$.thePlayer.motionX = alipafoz * etucorac * -var8 + umepefup * etucorac * var10;
         warnings$.thePlayer.motionZ = alipafoz * etucorac * var10 - umepefup * etucorac * -var8;
      }

   }

   public static float _pulse() {
      return (float)Math.sqrt(warnings$.thePlayer.motionX * warnings$.thePlayer.motionX + warnings$.thePlayer.motionZ * warnings$.thePlayer.motionZ);
   }

   public static double _turkey(double nurses, boolean bless) {
      if (warnings$.thePlayer.isPotionActive(Potion.jump) && bless) {
         int var3 = warnings$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
         nurses += (double)((float)(var3 + 1) * 0.1F);
      }

      return (double)nurses;
   }

   public static boolean _chapter() {
      if (warnings$.thePlayer.isInWater()) {
         return true;
      } else {
         Object sedacugo = false;
         Object upayefey = (int)warnings$.thePlayer.getEntityBoundingBox().minY;

         for(Object deloyapo = MathHelper.floor_double(warnings$.thePlayer.getEntityBoundingBox().minX); deloyapo < MathHelper.floor_double(warnings$.thePlayer.getEntityBoundingBox().maxX) + 1; ++deloyapo) {
            for(Object ovubozob = MathHelper.floor_double(warnings$.thePlayer.getEntityBoundingBox().minZ); ovubozob < MathHelper.floor_double(warnings$.thePlayer.getEntityBoundingBox().maxZ) + 1; ++ovubozob) {
               Object recedope = warnings$.theWorld.getBlockState(new BlockPos(deloyapo, upayefey, ovubozob)).getBlock();
               if (recedope != null && recedope.getMaterial() != Material.air) {
                  if (!(recedope instanceof BlockLiquid)) {
                     return false;
                  }

                  sedacugo = true;
               }
            }
         }

         return sedacugo;
      }
   }

   public static double _careful(double growth) {
      // $FF: Couldn't be decompiled
   }

   public static double _michel() {
      return _careful(0.41999998688697815D);
   }

   public static float _monetary() {
      Object oredoyuy = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return oredoyuy * oredoyuy * oredoyuy * 8.0F * 0.15F;
   }

   public static void _serve(EventPreUpdate aluminum) {
      if (_bumper()) {
         Object ordered = Arrays.asList(0.125D, 0.25D, 0.375D, 0.625D, 0.75D, 0.015625D, 0.5D, 0.0625D, 0.875D, 0.1875D);
         Object online = ((EventPreUpdate)aluminum).getY() % 1.0D;
         ordered.sort(Comparator.comparingDouble(MovementUtils::_engage));
         Object famous = ((EventPreUpdate)aluminum).getY() - online + ((Double)ordered.get(0)).doubleValue();
         if (Math.abs(((Double)ordered.get(0)).doubleValue() - online) < 0.005D) {
            EventPreUpdate.setY(famous);
            EventPreUpdate.setOnground(true);
         } else {
            List var6 = Arrays.asList(0.715D, 0.945D, 0.09D, 0.155D, 0.14D, 0.045D, 0.63D, 0.31D);
            double var7 = ((EventPreUpdate)aluminum).getY() % 1.0D;
            var6.sort(Comparator.comparingDouble(MovementUtils::_haiti));
            famous = ((EventPreUpdate)aluminum).getY() - var7 + ((Double)var6.get(0)).doubleValue();
            if (Math.abs(((Double)var6.get(0)).doubleValue() - var7) < 0.005D) {
               EventPreUpdate.setY(famous);
            }
         }
      }

   }

   public static void _blocks(EventMove japanese, double framed) {
      _maine((EventMove)japanese, (double)framed, warnings$.thePlayer.rotationYaw, (double)warnings$.thePlayer.movementInput.moveStrafe, (double)warnings$.thePlayer.movementInput.moveForward);
   }

   public static boolean _clerk() {
      return warnings$.gameSettings.keyBindForward.isKeyDown() || warnings$.gameSettings.keyBindLeft.isKeyDown() || warnings$.gameSettings.keyBindRight.isKeyDown() || warnings$.gameSettings.keyBindBack.isKeyDown();
   }

   public static int _dealer() {
      return warnings$.thePlayer.isPotionActive(Potion.jump) ? warnings$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static boolean _pioneer() {
      Object uyizalam = warnings$.thePlayer.getEntityBoundingBox();
      if (uyizalam == null) {
         return false;
      } else {
         uyizalam = uyizalam.contract(0.01D, Double.longBitsToDouble(0L), 0.01D).offset(Double.longBitsToDouble(0L), -0.01D, Double.longBitsToDouble(0L));
         Object pidasuri = false;
         Object sotucilo = (int)uyizalam.minY;

         for(Object silifimo = MathHelper.floor_double(uyizalam.minX); silifimo < MathHelper.floor_double(uyizalam.maxX + 1.0D); ++silifimo) {
            for(Object gefonamo = MathHelper.floor_double(uyizalam.minZ); gefonamo < MathHelper.floor_double(uyizalam.maxZ + 1.0D); ++gefonamo) {
               Object relumema = warnings$.theWorld.getBlockState(new BlockPos(silifimo, sotucilo, gefonamo)).getBlock();
               if (relumema != Blocks.air) {
                  if (!(relumema instanceof BlockLiquid)) {
                     return false;
                  }

                  pidasuri = true;
               }
            }
         }

         return pidasuri;
      }
   }

   public static double _nevada() {
      Object clarke = 0.2873D;
      if (warnings$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         int var2 = warnings$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         clarke *= 1.0D + 0.2D * (double)(var2 + 1);
      }

      return clarke;
   }

   public static float _gnome(double oroyopif) {
      return (float)((double)Math.round(oroyopif * 1.0E8D) / 1.0E8D);
   }

   public static float _pubmed(float egalazuy) {
      Object numudifi = new Vector2f((float)warnings$.thePlayer.lastTickPosX, (float)warnings$.thePlayer.lastTickPosZ);
      Object egevoyeg = new Vector2f((float)warnings$.thePlayer.posX, (float)warnings$.thePlayer.posZ);
      Object ilegapon = new Vector2f(egevoyeg.x - numudifi.x, egevoyeg.y - numudifi.y);
      Object metinica = (double)ilegapon.x;
      double var6 = (double)ilegapon.y;
      if (metinica != Double.longBitsToDouble(0L) || var6 != Double.longBitsToDouble(0L)) {
         egalazuy = (float)Math.toDegrees((Math.atan2(-metinica, var6) + (double)niger$) % (double)niger$);
      }

      return (float)egalazuy;
   }

   public static float _check(double ibomopiz) {
      return (float)((double)Math.round(ibomopiz * 1.0E8D) / 1.0E8D);
   }

   public static double _limited() {
      return Math.sqrt(warnings$.thePlayer.motionX * warnings$.thePlayer.motionX + warnings$.thePlayer.motionZ * warnings$.thePlayer.motionZ);
   }

   public static double[] _herald(double bisamote) {
      return _glass(warnings$.thePlayer.rotationYaw * subtle$, (double)bisamote);
   }

   public static double[] _glass(float hazards, double heritage) {
      return new double[]{(double)(-MathHelper.sin((float)hazards)) * heritage, (double)MathHelper.cos((float)hazards) * heritage};
   }

   public static double _ivory() {
      Object command = new SecureRandom();
      Object quantity = command.nextDouble() * (1.0D / (double)System.currentTimeMillis());

      for(int var3 = 0; var3 < MathUtil._reply(MathUtil._reply(4, 6), MathUtil._reply(8, 20)); ++var3) {
         quantity *= 1.0D / (double)System.currentTimeMillis();
      }

      return quantity;
   }

   public static double _joins() {
      return Math.hypot(warnings$.thePlayer.motionX, warnings$.thePlayer.motionZ);
   }

   public static double _deposits() {
      Object nagesuzo = (double)warnings$.thePlayer.rotationYaw;
      if (warnings$.thePlayer.movementInput.moveForward < Float.intBitsToFloat(0)) {
         nagesuzo += 180.0D;
      }

      float var2 = 1.0F;
      if (warnings$.thePlayer.movementInput.moveForward < Float.intBitsToFloat(0)) {
         var2 = -0.5F;
      } else if (warnings$.thePlayer.movementInput.moveForward > Float.intBitsToFloat(0)) {
         var2 = 0.5F;
      }

      if (warnings$.thePlayer.movementInput.moveStrafe > Float.intBitsToFloat(0)) {
         nagesuzo -= (double)(90.0F * var2);
      }

      if (warnings$.thePlayer.movementInput.moveStrafe < Float.intBitsToFloat(0)) {
         nagesuzo += (double)(90.0F * var2);
      }

      return Math.toRadians(nagesuzo);
   }

   public static boolean _decade() {
      return warnings$.thePlayer.moveForward < Float.intBitsToFloat(0);
   }

   public static void _indeed(double fiscal) {
      warnings$.thePlayer.setPosition(warnings$.thePlayer.posX, warnings$.thePlayer.posY + fiscal, warnings$.thePlayer.posZ);
   }

   public static boolean _letter() {
      for(Object vocal = (int)warnings$.thePlayer.posY; vocal >= 0; --vocal) {
         if (!(warnings$.theWorld.getBlockState(new BlockPos(warnings$.thePlayer.posX, (double)vocal, warnings$.thePlayer.posZ)).getBlock() instanceof BlockAir)) {
            return true;
         }
      }

      return false;
   }

   public static void _parallel(float uleyibuv) {
      if (_bumper()) {
         Object padamoti = _deposits();
         warnings$.thePlayer.motionX = -Math.sin(padamoti) * (double)uleyibuv;
         warnings$.thePlayer.motionZ = Math.cos(padamoti) * (double)uleyibuv;
      }
   }

   public static void _large(float annually) {
      if (_bumper()) {
         warnings$.thePlayer.motionX = -Math.sin(_deposits()) * (double)annually;
         warnings$.thePlayer.motionZ = Math.cos(_deposits()) * (double)annually;
      }
   }

   public static void _smile(float ozubipoz, double fupogizo) {
      if (_bumper()) {
         double var3 = Math.toRadians((double)fupogizo);
         warnings$.thePlayer.motionX = -Math.sin(var3) * (double)ozubipoz;
         warnings$.thePlayer.motionZ = Math.cos(var3) * (double)ozubipoz;
      }
   }

   public static void _amend(EntityLivingBase labels, float lease, float portions, EventMove quarter, int scales) {
      if (_bumper()) {
         Object element = Double.longBitsToDouble(0L);
         Object grass = Double.longBitsToDouble(0L);
         Object tractor = Math.sqrt(((EventMove)quarter).x * ((EventMove)quarter).x + ((EventMove)quarter).z * ((EventMove)quarter).z);
         if (tractor > 1.0E-4D) {
            Object hormone = Double.longBitsToDouble(0L);
            if ((double)lease > 0.001D) {
               hormone = 1.0D;
            } else if ((double)lease < -0.001D) {
               hormone = -1.0D;
            }

            float var13 = 0.01F;
            if (scales == 1) {
               var13 = warnings$.thePlayer.getDistanceToEntity((Entity)labels);
            } else if (scales == 0) {
               var13 = (float)Math.sqrt((warnings$.thePlayer.posX - ((EntityLivingBase)labels).posX) * (warnings$.thePlayer.posX - ((EntityLivingBase)labels).posX) + (warnings$.thePlayer.posZ - ((EntityLivingBase)labels).posZ) * (warnings$.thePlayer.posZ - ((EntityLivingBase)labels).posZ));
            }

            if ((double)var13 < (double)portions - tractor) {
               element = -1.0D;
            } else if ((double)var13 > (double)portions + tractor) {
               element = 1.0D;
            } else {
               element = (double)(var13 - portions) / tractor;
            }

            if ((double)var13 < (double)portions + tractor * 2.0D && (double)var13 > (double)portions - tractor * 2.0D) {
               grass = 1.0D;
            }

            grass = grass * hormone;
            double var14 = (double) RotationUtils6._netscape(KillAura._versus()).brisbane$;
            double var16 = Math.sqrt(element * element + grass * grass);
            element = element / var16;
            grass = grass / var16;
            double var18 = Math.toDegrees(Math.asin(grass));
            if (var18 > Double.longBitsToDouble(0L)) {
               if (element < Double.longBitsToDouble(0L)) {
                  var18 = 180.0D - var18;
               }
            } else if (element < Double.longBitsToDouble(0L)) {
               var18 = -180.0D - var18;
            }

            var14 = Math.toRadians(var14 + var18);
            ((EventMove)quarter).x = -Math.sin(var14) * tractor;
            ((EventMove)quarter).z = Math.cos(var14) * tractor;
            warnings$.thePlayer.motionX = ((EventMove)quarter).x;
            warnings$.thePlayer.motionZ = ((EventMove)quarter).z;
         }
      }
   }

   public static void _dance() {
      _parallel(_pulse());
   }

   public static double _haiti(double azevenul, Double var2) {
      return Math.abs(var2.doubleValue() - azevenul);
   }

   public static double _engage(double putting, Double var2) {
      return Math.abs(var2.doubleValue() - putting);
   }
}
