//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.raytrace;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Objects;

import ft.sleep.module.modules.KillAura;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class RaycastUtils {
   public static Minecraft square$ = Minecraft.getMinecraft();

   public static Entity _walking(double zeborepo, RaycastUtils2 fegenaso) {
      boolean var3 = Objects.equals(KillAura.gender$.getValue(), "None") || Objects.equals(KillAura.gender$.getValue(), "Smart") && !KillAura._count(KillAura.lesbians$, 100.0F);
      return _rogers((double)zeborepo, var3 ? square$.thePlayer.rotationYaw : KillAura.minor$, var3 ? square$.thePlayer.rotationPitch : KillAura.telling$, (RaycastUtils2)fegenaso);
   }

   public static MovingObjectPosition _insured(Entity eyasavuc, double vanelisi, float rotubuza, float rozidota, float mumacice) {
      Object tusiseci = ((Entity)eyasavuc).getPositionEyes(1.0F);
      net.minecraft.util.Vec3 var7 = _sharing((float)mumacice, (float)rozidota);
      net.minecraft.util.Vec3 var8 = tusiseci.addVector(var7.xCoord * vanelisi, var7.yCoord * vanelisi, var7.zCoord * vanelisi);
      return ((Entity)eyasavuc).worldObj.rayTraceBlocks(tusiseci, var8, false, false, true);
   }

   public static MovingObjectPosition _mambo(Entity camel, float killer, float natural, double spouse) {
      if (camel != null && square$.theWorld != null) {
         Object loans = null;
         square$.pointedEntity = null;
         Object vacation = _insured((Entity)camel, (double)spouse, 1.0F, (float)killer, (float)natural);
         Object proved = (double)spouse;
         Object prospect = ((Entity)camel).getPositionEyes(1.0F);
         Object simpson = false;
         Object treasury = true;
         if (vacation != null && vacation.typeOfHit == MovingObjectType.BLOCK) {
            proved = vacation.hitVec.distanceTo(prospect);
         }

         Object niger = _sharing((float)natural, (float)killer);
         Object regards = prospect.addVector(niger.xCoord * spouse, niger.yCoord * spouse, niger.zCoord * spouse);
         Object hotels = null;
         Object tears = 1.0F;
         Object reader = square$.theWorld.getEntitiesInAABBexcluding((Entity)camel, ((Entity)camel).getEntityBoundingBox().addCoord(niger.xCoord * spouse, niger.yCoord * spouse, niger.zCoord * spouse).expand((double)tears, (double)tears, (double)tears), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         Object demands = proved;

         for(Object diagram = 0; diagram < reader.size(); ++diagram) {
            Object decrease = (Entity)reader.get(diagram);
            Object dentists = decrease.getCollisionBorderSize();
            AxisAlignedBB var22 = decrease.getEntityBoundingBox().expand((double)dentists, (double)dentists, (double)dentists);
            MovingObjectPosition var23 = var22.calculateIntercept(prospect, regards);
            if (var22.isVecInside(prospect)) {
               if (demands >= Double.longBitsToDouble(0L)) {
                  loans = decrease;
                  hotels = var23 == null ? prospect : var23.hitVec;
                  demands = Double.longBitsToDouble(0L);
               }
            } else if (var23 != null) {
               double var24 = prospect.distanceTo(var23.hitVec);
               if (var24 < demands || demands == Double.longBitsToDouble(0L)) {
                  boolean var26 = false;
                  if (decrease == ((Entity)camel).ridingEntity && !var26) {
                     if (demands == Double.longBitsToDouble(0L)) {
                        loans = decrease;
                        hotels = var23.hitVec;
                     }
                  } else {
                     loans = decrease;
                     hotels = var23.hitVec;
                     demands = var24;
                  }
               }
            }
         }

         if (loans != null && simpson && prospect.distanceTo(hotels) > spouse) {
            vacation = new MovingObjectPosition(MovingObjectType.MISS, hotels, (EnumFacing)null, new BlockPos(hotels));
         }

         if (loans != null && (demands < proved || vacation == null)) {
            vacation = new MovingObjectPosition(loans, hotels);
         }

         return vacation;
      } else {
         return null;
      }
   }

   public static Entity _rogers(double gusafevu, float cinesebe, float ufobolat, RaycastUtils2 irefeliy) {
      Object zidocaca = square$.getRenderViewEntity();
      if (zidocaca != null && square$.theWorld != null) {
         Object merivemi = (double)gusafevu;
         Object otituyun = zidocaca.getPositionEyes(1.0F);
         Object fisazusa = MathHelper.cos(-cinesebe * 0.017453292F - 3.1415927F);
         Object adigavof = MathHelper.sin(-cinesebe * 0.017453292F - 3.1415927F);
         Object zopomezo = -MathHelper.cos(-ufobolat * 0.017453292F);
         Object gesifodi = MathHelper.sin(-ufobolat * 0.017453292F);
         Object resacupe = new net.minecraft.util.Vec3((double)(adigavof * zopomezo), (double)gesifodi, (double)(fisazusa * zopomezo));
         Object izirezif = otituyun.addVector(resacupe.xCoord * gusafevu, resacupe.yCoord * gusafevu, resacupe.zCoord * gusafevu);
         Object nidayesa = square$.theWorld.getEntitiesInAABBexcluding(zidocaca, zidocaca.getEntityBoundingBox().addCoord(resacupe.xCoord * gusafevu, resacupe.yCoord * gusafevu, resacupe.zCoord * gusafevu).expand(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         Object orafizuc = null;

         for(Object irovozad : nidayesa) {
            if (((RaycastUtils2)irefeliy)._actively(irovozad)) {
               Object desenura = irovozad.getCollisionBorderSize();
               Object gasulagu = irovozad.getEntityBoundingBox().expand((double)desenura, (double)desenura, (double)desenura);
               MovingObjectPosition var21 = gasulagu.calculateIntercept(otituyun, izirezif);
               if (gasulagu.isVecInside(otituyun)) {
                  if (merivemi >= Double.longBitsToDouble(0L)) {
                     orafizuc = irovozad;
                     merivemi = Double.longBitsToDouble(0L);
                  }
               } else if (var21 != null) {
                  double var22 = otituyun.distanceTo(var21.hitVec);
                  if (var22 < merivemi || merivemi == Double.longBitsToDouble(0L)) {
                     if (irovozad == zidocaca.ridingEntity && !zidocaca.canRiderInteract()) {
                        if (merivemi == Double.longBitsToDouble(0L)) {
                           orafizuc = irovozad;
                        }
                     } else {
                        orafizuc = irovozad;
                        merivemi = var22;
                     }
                  }
               }
            }
         }

         return orafizuc;
      } else {
         return null;
      }
   }

   public static net.minecraft.util.Vec3 _happens(float ibicasen) {
      if (ibicasen == 1.0F) {
         return new net.minecraft.util.Vec3(square$.thePlayer.posX, square$.thePlayer.posY + (double)square$.thePlayer.getEyeHeight(), square$.thePlayer.posZ);
      } else {
         Object dobadulu = square$.thePlayer.prevPosX + (square$.thePlayer.posX - square$.thePlayer.prevPosX) * (double)ibicasen;
         Object iceritag = square$.thePlayer.prevPosY + (square$.thePlayer.posY - square$.thePlayer.prevPosY) * (double)ibicasen + (double)square$.thePlayer.getEyeHeight();
         double var5 = square$.thePlayer.prevPosZ + (square$.thePlayer.posZ - square$.thePlayer.prevPosZ) * (double)ibicasen;
         return new net.minecraft.util.Vec3(dobadulu, iceritag, var5);
      }
   }

   public static net.minecraft.util.Vec3 _mysimon(float between, float incident) {
      return _sharing((float)incident, (float)between);
   }

   public static net.minecraft.util.Vec3 _sharing(float imagine, float cheque) {
      Object neural = MathHelper.cos(-cheque * 0.017453292F - 3.1415927F);
      Object spoken = MathHelper.sin(-cheque * 0.017453292F - 3.1415927F);
      Object joshua = -MathHelper.cos(-imagine * 0.017453292F);
      Object oracle = MathHelper.sin(-imagine * 0.017453292F);
      return new net.minecraft.util.Vec3((double)(spoken * joshua), (double)oracle, (double)(neural * joshua));
   }

   public static MovingObjectPosition _sagem(double spirit, float viewed, float waiver) {
      Object works = _happens(1.0F);
      Object trailer = _mysimon((float)viewed, (float)waiver);
      net.minecraft.util.Vec3 var6 = works.addVector(trailer.xCoord * spirit, trailer.yCoord * spirit, trailer.zCoord * spirit);
      return square$.thePlayer.worldObj.rayTraceBlocks(works, var6, false, false, true);
   }
}
