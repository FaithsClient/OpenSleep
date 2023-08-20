//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.rotation;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class RotationUtils5 {
   public static Minecraft overhead$ = Minecraft.getMinecraft();
   public static Random valued$ = new Random();
   public static RotationUtils5 various$;

   public float _crest(Entity rapudulu) {
      if (rapudulu == null) {
         return overhead$.thePlayer.rotationYaw;
      } else {
         Object sovagopu = ((Entity)rapudulu).posX - overhead$.thePlayer.posX;
         Object ayebapam = ((Entity)rapudulu).posZ - overhead$.thePlayer.posZ;
         float var6 = (float)(Math.atan2(ayebapam, sovagopu) * 180.0D / 3.141592653589793D) - 90.0F;
         return overhead$.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var6 - overhead$.thePlayer.rotationYaw);
      }
   }

   public float _entitled(Entity coupons) {
      if (coupons == null) {
         return overhead$.thePlayer.rotationPitch;
      } else {
         double redeem;
         if (coupons instanceof EntityLivingBase) {
            Object carrying = (EntityLivingBase)coupons;
            redeem = carrying.posY + (double)carrying.getEyeHeight() - (overhead$.thePlayer.posY + (double)overhead$.thePlayer.getEyeHeight());
         } else {
            redeem = (((Entity)coupons).getEntityBoundingBox().minY + ((Entity)coupons).getEntityBoundingBox().maxY) / 2.0D - (overhead$.thePlayer.posY + (double)overhead$.thePlayer.getEyeHeight());
         }

         Object var11 = ((Entity)coupons).posX - overhead$.thePlayer.posX;
         Object begin = ((Entity)coupons).posZ - overhead$.thePlayer.posZ;
         double var8 = (double)MathHelper.sqrt_double(var11 * var11 + begin * begin);
         float var10 = (float)(-(Math.atan2(redeem, var8) * 180.0D / 3.141592653589793D));
         return overhead$.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var10 - overhead$.thePlayer.rotationPitch) + 1.0F;
      }
   }

   public static net.minecraft.util.Vec3 _fisher(net.minecraft.util.Vec3 guzuseri, AxisAlignedBB asebetum) {
      return new net.minecraft.util.Vec3(MathHelper.clamp_double(((net.minecraft.util.Vec3)guzuseri).xCoord, ((AxisAlignedBB)asebetum).minX, ((AxisAlignedBB)asebetum).maxX), MathHelper.clamp_double(((net.minecraft.util.Vec3)guzuseri).yCoord, ((AxisAlignedBB)asebetum).minY, ((AxisAlignedBB)asebetum).maxY), MathHelper.clamp_double(((net.minecraft.util.Vec3)guzuseri).zCoord, ((AxisAlignedBB)asebetum).minZ, ((AxisAlignedBB)asebetum).maxZ));
   }

   public float[] _adidas(float ebiyutof, float pezibige) {
      Object aceyonub = Math.abs((float)(ebiyutof - pezibige));
      if (aceyonub < Float.intBitsToFloat(0)) {
         aceyonub += 360.0F;
      }

      if (aceyonub >= 360.0F) {
         aceyonub -= 360.0F;
      }

      Object uzapasad = 360.0F - aceyonub;
      Object epeviyar = Float.intBitsToFloat(0);
      if (aceyonub > uzapasad) {
         ++epeviyar;
      }

      if (aceyonub > uzapasad) {
         aceyonub = uzapasad;
      }

      return new float[]{aceyonub, epeviyar};
   }

   public float _ambien(net.minecraft.util.Vec3 uzedafep) {
      Object temecafu = overhead$.thePlayer.posX - ((net.minecraft.util.Vec3)uzedafep).xCoord;
      double var4 = overhead$.thePlayer.posZ - ((net.minecraft.util.Vec3)uzedafep).zCoord;
      return (float)((double)((float)Math.atan2(var4, temecafu)) / 3.141592653589793D * 180.0D) - 90.0F;
   }

   public float _imports(Entity ipaturur, Entity vicarubu) {
      Object nuyomiti = new net.minecraft.util.Vec3(((Entity)vicarubu).posX, ((Entity)vicarubu).posY, ((Entity)vicarubu).posZ);
      Object vidolefi = ((Entity)ipaturur).posX - (nuyomiti.xCoord + (((Entity)vicarubu).posX - ((Entity)vicarubu).lastTickPosX));
      double var6 = ((Entity)ipaturur).posZ - (nuyomiti.zCoord + (((Entity)vicarubu).posZ - ((Entity)vicarubu).lastTickPosZ));
      return (float)((double)((float)Math.atan2(var6, vidolefi)) / 3.141592653589793D * 180.0D) - 90.0F;
   }

   public net.minecraft.util.Vec3 _weight(float uvanucib, float loladeye) {
      return iyesoyev._awesome((float)uvanucib, (float)loladeye, 1.0F);
   }

   public net.minecraft.util.Vec3 _shoot(float bonus, float orbit) {
      Object filled = MathHelper.cos(-orbit * 0.017453292F - 3.1415927F);
      Object phoenix = MathHelper.sin(-orbit * 0.017453292F - 3.1415927F);
      Object lesser = -MathHelper.cos(-bonus * 0.017453292F);
      Object algebra = MathHelper.sin(-bonus * 0.017453292F);
      return new net.minecraft.util.Vec3((double)(phoenix * lesser), (double)algebra, (double)(filled * lesser));
   }

   public net.minecraft.util.Vec3 _awesome(float highs, float silence, float var3) {
      return merry._shoot((float)silence, (float)highs);
   }

   public static float _mouth(float nomepepa, float geverimo, float efelilul) {
      Object orosesup = MathHelper.wrapAngleTo180_float((float)(geverimo - nomepepa));
      if (orosesup > efelilul) {
         orosesup = (float)efelilul;
      }

      if (orosesup < -efelilul) {
         orosesup = (float)(-efelilul);
      }

      return nomepepa + orosesup;
   }

   public float[] _rouge(float romolala, float ovoretub, float doyabeco, float fosubuco) {
      romolala = (float)((double)romolala + (double)doyabeco * 0.15D);
      ovoretub = (float)((double)ovoretub + (double)fosubuco * 0.15D);
      return new float[]{(float)romolala, (float)ovoretub};
   }

   public static float[] _moore(float signal, float restore, boolean sugar) {
      Object manually = overhead$.gameSettings.mouseSensitivity;
      if (manually == Float.intBitsToFloat(0)) {
         manually = 0.0070422534F;
      }

      manually = Math.max(0.1F, manually);
      Object insert = (int)((signal - RotationHook.shield$) / (manually / 2.0F));
      Object alabama = (int)((restore - RotationHook.assess$) / (manually / 2.0F)) * -1;
      if (sugar) {
         insert = (int)((double)insert - ((double)insert % 0.5D + 0.25D));
         alabama = (int)((double)alabama - ((double)alabama % 0.5D + 0.25D));
      }

      Object basis = manually * 0.6F + 0.2F;
      Object untitled = (float)(Math.pow((double)basis, 3.0D) * 8.0D);
      Object lauren = (float)insert * untitled;
      Object fotos = (float)alabama * untitled;
      Object situated = (float)((double)RotationHook.shield$ + (double)lauren * 0.15D);
      Object educated = (float)((double)RotationHook.assess$ - (double)fotos * 0.15D);
      return new float[]{situated, educated};
   }

   public static float[] _locks(Entity saudi, boolean first, boolean weights, boolean gotta, boolean nebraska, boolean ricky, boolean guest, double contrary, boolean absent, float fares, double trained, boolean sharp, int sally) {
      // $FF: Couldn't be decompiled
   }

   public float[] _chuck(BlockPos anobuvef, double eminunam, boolean munosubo, boolean evayumat, boolean eyelotif, boolean foyafenu, boolean cadefozi, boolean ibasaval, float esoniven) {
      Object pilorana = (double)((BlockPos)anobuvef).getX() + (foyafenu ? vibisili._somebody(0.45D, 0.5D) : 0.5D) - (overhead$.thePlayer.getEntityBoundingBox().minX + overhead$.thePlayer.getEntityBoundingBox().maxX) / 2.0D - (eyelotif ? overhead$.thePlayer.motionX : Double.longBitsToDouble(0L));
      Object atarutis = (double)((BlockPos)anobuvef).getY() - eminunam - (overhead$.thePlayer.getEntityBoundingBox().minY + (double)overhead$.thePlayer.getEyeHeight());
      Object debupebo = (double)((BlockPos)anobuvef).getZ() + (foyafenu ? vibisili._somebody(0.45D, 0.5D) : 0.5D) - (overhead$.thePlayer.getEntityBoundingBox().minZ + overhead$.thePlayer.getEntityBoundingBox().maxZ) / 2.0D - (eyelotif ? overhead$.thePlayer.motionZ : Double.longBitsToDouble(0L));
      if (cadefozi) {
         atarutis += vibisili._somebody(-0.05D, 0.05D);
      }

      Object osobucuc = (double)MathHelper.sqrt_double(pilorana * pilorana + debupebo * debupebo);
      float var19 = (float)(MathHelper.atan2(debupebo, pilorana) * 180.0D / 3.141592653589793D) - 90.0F;
      float var20 = (float)(-(MathHelper.atan2(atarutis, osobucuc) * 180.0D / 3.141592653589793D));
      float var21 = ibasaval ? var19 : _mouth(RotationHook.shield$, var19, (float)esoniven);
      float var22 = _mouth(RotationHook.assess$, var20, (float)esoniven);
      if (!evayumat) {
         return new float[]{var21, _escorts(var22)};
      } else {
         float[] var23 = _moore(var21, var22, (boolean)munosubo);
         return new float[]{var23[0], _escorts(var23[1])};
      }
   }

   public double _somebody(double ozone, double var3) {
      if (ozone > var3) {
         System.err.println("The minimal value cannot be higher than the max value");
         return (double)ozone;
      } else {
         var3 = var3 - ozone;
         return Math.random() * var3 + ozone;
      }
   }

   public static float _escorts(float severe) {
      return MathHelper.clamp_float((float)severe, -90.0F, 90.0F);
   }

   public Entity _moments(double devoboyu, float adumavet, float var4) {
      return vogocigu._learners((double)devoboyu, (float)adumavet, var4, 1.0F);
   }

   public Entity _learners(double visitors, float dropped, float critical, float italian) {
      Object raymond = overhead$.getRenderViewEntity();
      Object sentence = null;
      if (raymond != null && overhead$.theWorld != null) {
         Object ranking = raymond.rayTrace((double)visitors, (float)italian);
         Object aircraft = raymond.getPositionEyes(1.0F);
         Object advocate = false;
         Object valley = (double)visitors;
         if (ranking != null) {
            valley = ranking.hitVec.distanceTo(aircraft);
         }

         Object vanilla = because._awesome((float)dropped, (float)critical, (float)italian);
         Object demand = aircraft.addVector(vanilla.xCoord * visitors, vanilla.yCoord * visitors, vanilla.zCoord * visitors);
         sentence = null;
         Object holder = null;
         Object finest = 1.0F;
         Object plugin = overhead$.theWorld.getEntitiesInAABBexcluding(raymond, raymond.getEntityBoundingBox().addCoord(vanilla.xCoord * visitors, vanilla.yCoord * visitors, vanilla.zCoord * visitors).expand((double)finest, (double)finest, (double)finest), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         Object segment = valley;

         for(Object asked = 0; asked < plugin.size(); ++asked) {
            Object compound = (Entity)plugin.get(asked);
            Object writings = compound.getCollisionBorderSize();
            Object tracker = compound.getEntityBoundingBox().expand((double)writings, (double)writings, (double)writings);
            MovingObjectPosition var24 = tracker.calculateIntercept(aircraft, demand);
            if (tracker.isVecInside(aircraft)) {
               if (visitors >= Double.longBitsToDouble(0L)) {
                  sentence = compound;
                  holder = var24 == null ? aircraft : var24.hitVec;
                  visitors = Double.longBitsToDouble(0L);
               }
            } else if (var24 != null) {
               double var25 = aircraft.distanceTo(var24.hitVec);
               if (var25 < visitors || visitors == Double.longBitsToDouble(0L)) {
                  boolean var27 = false;
                  if (compound == raymond.ridingEntity && !var27) {
                     if (segment == Double.longBitsToDouble(0L)) {
                        sentence = compound;
                        holder = var24.hitVec;
                     }
                  } else {
                     sentence = compound;
                     holder = var24.hitVec;
                     segment = var25;
                  }
               }
            }
         }

         if (sentence != null && advocate && aircraft.distanceTo(holder) > visitors) {
            sentence = null;
            ranking = new MovingObjectPosition(MovingObjectType.MISS, holder, (EnumFacing)null, new BlockPos(holder));
         }

         if (sentence != null && (segment < valley || overhead$.objectMouseOver == null)) {
            ranking = new MovingObjectPosition(sentence, holder);
            if (sentence instanceof EntityLivingBase || sentence instanceof EntityItemFrame) {
               return sentence;
            }
         }

         if (ranking != null && ranking.entityHit != null) {
            return ranking.entityHit;
         }
      }

      return sentence;
   }

   public MovingObjectPosition _stones(float repairs, float insights, float equally) {
      return believe._herbal(overhead$.thePlayer, (float)repairs, (float)insights, (float)equally);
   }

   public MovingObjectPosition _herbal(Entity sagocevo, float emetodir, float yeloboyo, float vesilaro) {
      Object ucetamor = ((Entity)sagocevo).getPositionEyes(1.0F);
      Object simiyoza = nobabece._weight((float)emetodir, (float)yeloboyo);
      Object befasiyi = ucetamor.addVector(simiyoza.xCoord * (double)vesilaro, simiyoza.yCoord * (double)vesilaro, simiyoza.zCoord * (double)vesilaro);
      return overhead$.theWorld.rayTraceBlocks(ucetamor, befasiyi, false, false, true);
   }

   public MovingObjectPosition _cottage(float petatopu, float otucucus) {
      Object uteyagog = overhead$.playerController.getBlockReachDistance();
      Object mosocafi = asurupoz._weight((float)petatopu, (float)otucucus);
      Object umuroteb = overhead$.thePlayer.getPositionEyes(1.0F);
      Object bebanoma = umuroteb.addVector(mosocafi.xCoord * (double)uteyagog, mosocafi.yCoord * (double)uteyagog, mosocafi.zCoord * (double)uteyagog);
      Object esazacug = overhead$.theWorld.rayTraceBlocks(umuroteb, bebanoma, false, false, false);
      return esazacug != null && esazacug.typeOfHit == MovingObjectType.BLOCK ? esazacug : null;
   }

   public static RotationUtils5 _butler() {
      if (various$ == null) {
         various$ = new RotationUtils5();
      }

      return various$;
   }
}
