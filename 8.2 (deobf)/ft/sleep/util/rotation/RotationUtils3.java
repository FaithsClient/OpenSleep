//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.rotation;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

public class RotationUtils3 {
   public static Minecraft phillips$ = Minecraft.getMinecraft();

   public static float[] _besides(Entity ocadepuy) {
      Object magirase = ((Entity)ocadepuy).posX - Minecraft.getMinecraft().thePlayer.posX;
      Object ebomiyez = ((Entity)ocadepuy).posZ - Minecraft.getMinecraft().thePlayer.posZ;
      Object utiponol = ((Entity)ocadepuy).posY + (double)((Entity)ocadepuy).getEyeHeight() - (Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY + (Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().maxY - Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY));
      double var7 = (double)MathHelper.sqrt_double(magirase * magirase + ebomiyez * ebomiyez);
      float var9 = (float)(MathHelper.atan2(ebomiyez, magirase) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(MathHelper.atan2(utiponol, var7) * 180.0D / 3.141592653589793D));
      return new float[]{var9, var10};
   }

   public static float _smallest(float cigodidu, float pegivepe) {
      Object abenavip = Math.abs((float)(cigodidu - pegivepe)) % 360.0F;
      if (abenavip > 180.0F) {
         abenavip = 360.0F - abenavip;
      }

      return abenavip;
   }

   public static float _upset(float habitat, float hyundai, float aerial) {
      Object horror = MathHelper.wrapAngleTo180_float((float)(hyundai - habitat));
      if (horror > aerial) {
         horror = (float)aerial;
      }

      if (horror < -aerial) {
         horror = (float)(-aerial);
      }

      return habitat + horror;
   }

   public static float _names(float saturday, Entity comes, double webpage) {
      Object florence = ((Entity)comes).posX - Minecraft.getMinecraft().thePlayer.posX;
      Object reaches = ((Entity)comes).posZ - Minecraft.getMinecraft().thePlayer.posZ;
      double var8 = webpage - 2.2D + (double)((Entity)comes).getEyeHeight() - Minecraft.getMinecraft().thePlayer.posY;
      double var10 = (double)MathHelper.sqrt_double(florence * florence + reaches * reaches);
      double var12 = -Math.toDegrees(Math.atan(var8 / var10));
      return -MathHelper.wrapAngleTo180_float(saturday - (float)var12) - 2.5F;
   }

   public static float _scales(float virginia, double cruise, double scratch) {
      Object bookings = cruise - Minecraft.getMinecraft().thePlayer.posX;
      double var7 = scratch - Minecraft.getMinecraft().thePlayer.posZ;
      double var9 = Double.longBitsToDouble(0L);
      if (var7 < Double.longBitsToDouble(0L) && bookings < Double.longBitsToDouble(0L)) {
         if (bookings != Double.longBitsToDouble(0L)) {
            var9 = 90.0D + Math.toDegrees(Math.atan(var7 / bookings));
         }
      } else if (var7 < Double.longBitsToDouble(0L) && bookings > Double.longBitsToDouble(0L)) {
         if (bookings != Double.longBitsToDouble(0L)) {
            var9 = -90.0D + Math.toDegrees(Math.atan(var7 / bookings));
         }
      } else if (var7 != Double.longBitsToDouble(0L)) {
         var9 = Math.toDegrees(-Math.atan(bookings / var7));
      }

      return MathHelper.wrapAngleTo180_float(-(virginia - (float)var9));
   }

   public static float[] _fortune(BlockPos effects, EnumFacing lesson) {
      Object democrat = (double)((BlockPos)effects).getX() + 0.5D - phillips$.thePlayer.posX + (double)((EnumFacing)lesson).getFrontOffsetX() / 2.0D;
      Object frozen = (double)((BlockPos)effects).getZ() + 0.5D - phillips$.thePlayer.posZ + (double)((EnumFacing)lesson).getFrontOffsetZ() / 2.0D;
      Object athens = (double)((BlockPos)effects).getY() + 0.5D;
      Object designed = phillips$.thePlayer.posY + (double)phillips$.thePlayer.getEyeHeight() - athens;
      double var10 = (double)MathHelper.sqrt_double(democrat * democrat + frozen * frozen);
      float var12 = (float)(Math.atan2(frozen, democrat) * 180.0D / 3.141592653589793D) - 90.0F;
      float var13 = (float)(Math.atan2(designed, var10) * 180.0D / 3.141592653589793D);
      if (var12 < Float.intBitsToFloat(0)) {
         var12 += 360.0F;
      }

      return new float[]{var12, var13};
   }

   public static float[] _exact(Entity elliott) {
      Object cambodia = (((Entity)elliott).posX - ((Entity)elliott).lastTickPosX) * 0.4D;
      Object stolen = (((Entity)elliott).posZ - ((Entity)elliott).lastTickPosZ) * 0.4D;
      Object powell = (double)Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)elliott);
      powell = powell - powell % 0.8D;
      Object minerals = 1.0D;
      Object meeting = 1.0D;
      Object birth = ((Entity)elliott).isSprinting();
      minerals = powell / 0.8D * cambodia * (birth ? 1.25D : 1.0D);
      meeting = powell / 0.8D * stolen * (birth ? 1.25D : 1.0D);
      Object newbie = ((Entity)elliott).posX + minerals - Minecraft.getMinecraft().thePlayer.posX;
      double var14 = ((Entity)elliott).posZ + meeting - Minecraft.getMinecraft().thePlayer.posZ;
      double var16 = Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight() - (((Entity)elliott).posY + (double)((Entity)elliott).getEyeHeight());
      double var18 = (double)Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)elliott);
      float var20 = (float)Math.toDegrees(Math.atan2(var14, newbie)) - 90.0F;
      double var21 = (double)MathHelper.sqrt_double(newbie * newbie + var14 * var14);
      float var23 = (float)(-(Math.atan2(var16, var21) * 180.0D / 3.141592653589793D)) + (float)var18 * 0.11F;
      return new float[]{var20, -var23};
   }

   public static float _digest(Entity uvacutom) {
      return Math.abs(_mixed((Entity)uvacutom)[0] - phillips$.thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(_mixed((Entity)uvacutom)[0] - phillips$.thePlayer.rotationYaw) % 360.0F : Math.abs(_mixed((Entity)uvacutom)[0] - phillips$.thePlayer.rotationYaw) % 360.0F;
   }

   public static float _premier(Entity airline, boolean reynolds) {
      Object transmit = phillips$.thePlayer;
      Object surrey = (reynolds ? ((Entity)airline).prevPosX : ((Entity)airline).posX) - (reynolds ? transmit.prevPosX : transmit.posX);
      Object equal = (reynolds ? ((Entity)airline).prevPosZ : ((Entity)airline).posZ) - (reynolds ? transmit.prevPosZ : transmit.posZ);
      float var7 = reynolds ? transmit.prevRotationYaw : transmit.rotationYaw;
      float var8 = (float)(Math.atan2(equal, surrey) * 180.0D / 3.141592653589793D) - 90.0F;
      return var7 + MathHelper.wrapAngleTo180_float(var8 - var7);
   }

   public static net.minecraft.util.Vec3 _custom(float visadoyo, float afiposed) {
      Object sicusezo = MathHelper.cos(-afiposed * 0.017453292F - 3.1415927F);
      Object cefobodu = MathHelper.sin(-afiposed * 0.017453292F - 3.1415927F);
      Object usoliyod = -MathHelper.cos(-visadoyo * 0.017453292F);
      Object uyudizir = MathHelper.sin(-visadoyo * 0.017453292F);
      return new net.minecraft.util.Vec3((double)(cefobodu * usoliyod), (double)uyudizir, (double)(sicusezo * usoliyod));
   }

   public static float _refresh(float cells, float marriott, float saturn) {
      Object latvia = 0.006F;
      Object miracle = saturn * saturn * saturn * saturn - latvia * (latvia * cells * cells + 2.0F * marriott * saturn * saturn);
      return (float)Math.toDegrees(Math.atan(((double)(saturn * saturn) - Math.sqrt((double)miracle)) / (double)(latvia * cells)));
   }

   public static float[] _mixed(Entity ayadiyoz) {
      if (ayadiyoz == null) {
         return null;
      } else {
         Object vuniceza = ((Entity)ayadiyoz).posX - phillips$.thePlayer.posX;
         Object ucirilel = ((Entity)ayadiyoz).posZ - phillips$.thePlayer.posZ;
         double diyotimu;
         if (ayadiyoz instanceof EntityLivingBase) {
            EntityLivingBase var7 = (EntityLivingBase)ayadiyoz;
            diyotimu = var7.posY + (double)var7.getEyeHeight() - (phillips$.thePlayer.posY + (double)phillips$.thePlayer.getEyeHeight());
         } else {
            diyotimu = (((Entity)ayadiyoz).getEntityBoundingBox().minY + ((Entity)ayadiyoz).getEntityBoundingBox().maxY) / 2.0D - (phillips$.thePlayer.posY + (double)phillips$.thePlayer.getEyeHeight());
         }

         double var11 = (double)MathHelper.sqrt_double(vuniceza * vuniceza + ucirilel * ucirilel);
         float var9 = (float)(Math.atan2(ucirilel, vuniceza) * 180.0D / 3.141592653589793D) - 90.0F;
         float var10 = (float)(-(Math.atan2(diyotimu, var11) * 180.0D / 3.141592653589793D));
         return new float[]{var9, var10};
      }
   }

   public static boolean _packed(Entity avamomuz, float lonorumo) {
      return (Math.abs(_mixed((Entity)avamomuz)[0] - phillips$.thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(_mixed((Entity)avamomuz)[0] - phillips$.thePlayer.rotationYaw) % 360.0F : Math.abs(_mixed((Entity)avamomuz)[0] - phillips$.thePlayer.rotationYaw) % 360.0F) <= lonorumo;
   }

   public static float _viewer() {
      Object insects = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return insects * insects * insects * 8.0F * 0.15F;
   }

   public static float _sword(float viking, float tooth, float becomes) {
      Object academy = MathHelper.wrapAngleTo180_float((float)(tooth - viking));
      if (academy > becomes) {
         academy = (float)becomes;
      }

      if (academy < -becomes) {
         academy = (float)(-becomes);
      }

      return viking + academy;
   }

   public static float _dressed(double perfect, double michigan) {
      Object yeast = perfect - Minecraft.getMinecraft().thePlayer.posX;
      double var6 = michigan - Minecraft.getMinecraft().thePlayer.posZ;
      double var8;
      if (var6 < Double.longBitsToDouble(0L) && yeast < Double.longBitsToDouble(0L)) {
         var8 = 90.0D + Math.toDegrees(Math.atan(var6 / yeast));
      } else if (var6 < Double.longBitsToDouble(0L) && yeast > Double.longBitsToDouble(0L)) {
         var8 = -90.0D + Math.toDegrees(Math.atan(var6 / yeast));
      } else {
         var8 = Math.toDegrees(-Math.atan(yeast / var6));
      }

      return MathHelper.wrapAngleTo180_float(-(Minecraft.getMinecraft().thePlayer.rotationYaw - (float)var8));
   }

   public static float[] _generous(Entity circle, double florists) {
      if (circle == null) {
         System.out.println("Fuck you ! Entity is nul!");
         return null;
      } else {
         Object beverly = ((Entity)circle).posX - Minecraft.getMinecraft().thePlayer.posX;
         Object hardware = ((Entity)circle).posZ - Minecraft.getMinecraft().thePlayer.posZ;
         Object trees = new RotationUtils(((Entity)circle).posX, ((Entity)circle).posY, ((Entity)circle).posZ);
         Object trash = new RotationUtils(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight(), Minecraft.getMinecraft().thePlayer.posZ);

         for(Object clock = ((Entity)circle).getEntityBoundingBox().minY + 0.7D; clock < ((Entity)circle).getEntityBoundingBox().maxY - 0.1D; clock += 0.1D) {
            if (trash._quote(new RotationUtils(((Entity)circle).posX, clock, ((Entity)circle).posZ)) < trash._quote(trees)) {
               trees = new RotationUtils(((Entity)circle).posX, clock, ((Entity)circle).posZ);
            }
         }

         if (trash._quote(trees) >= florists) {
            return null;
         } else {
            Object var15 = trees._bidder() - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
            double var11 = (double)MathHelper.sqrt_double(beverly * beverly + hardware * hardware);
            float var13 = (float)(Math.atan2(hardware, beverly) * 180.0D / 3.141592653589793D) - 90.0F;
            float var14 = (float)(-(Math.atan2(var15, var11) * 180.0D / 3.141592653589793D));
            return new float[]{var13, var14};
         }
      }
   }

   public static float _dealing(double peputace, double ametinig, float guladese) {
      Object etecotug = peputace - Minecraft.getMinecraft().thePlayer.posX;
      double var7 = ametinig - Minecraft.getMinecraft().thePlayer.posZ;
      double var9;
      if (var7 < Double.longBitsToDouble(0L) && etecotug < Double.longBitsToDouble(0L)) {
         var9 = 90.0D + Math.toDegrees(Math.atan(var7 / etecotug));
      } else if (var7 < Double.longBitsToDouble(0L) && etecotug > Double.longBitsToDouble(0L)) {
         var9 = -90.0D + Math.toDegrees(Math.atan(var7 / etecotug));
      } else {
         var9 = Math.toDegrees(-Math.atan(etecotug / var7));
      }

      return MathHelper.wrapAngleTo180_float(-(guladese - (float)var9));
   }

   public static float[] _breeds(Entity soborile) {
      if (soborile == null) {
         return null;
      } else {
         Object genuduse = Minecraft.getMinecraft();
         Object eziraven = ((Entity)soborile).posX - genuduse.thePlayer.posX;
         Object covemabu = ((Entity)soborile).posY + (double)(((Entity)soborile).getEyeHeight() / 2.0F) - (genuduse.thePlayer.posY + (double)genuduse.thePlayer.getEyeHeight());
         Object enegutof = ((Entity)soborile).posZ - genuduse.thePlayer.posZ;
         double var8 = (double)MathHelper.sqrt_double(eziraven * eziraven + enegutof * enegutof);
         float var10 = (float)(Math.atan2(enegutof, eziraven) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(covemabu, var8) * 180.0D / 3.141592653589793D));
         return new float[]{(genuduse.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var10 - genuduse.thePlayer.rotationYaw)) % 360.0F, (genuduse.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var11 - genuduse.thePlayer.rotationPitch)) % 360.0F};
      }
   }
}
