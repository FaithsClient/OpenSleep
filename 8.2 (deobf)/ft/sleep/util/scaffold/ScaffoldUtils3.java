//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.scaffold;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventTick;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class ScaffoldUtils3 {
   public static Minecraft husband$ = Minecraft.getMinecraft();
   public static ScaffoldUtils2 fibre$;
   public static int relation$;
   public static Random blast$ = new Random();
   public static double pipeline$ = blast$.nextDouble();
   public static double outlined$ = blast$.nextDouble();
   public static double council$ = blast$.nextDouble();

   public static float _february() {
      return husband$.thePlayer.rotationPitch;
   }

   public static void _happened(float zavezufa) {
      husband$.thePlayer.rotationPitch = (float)zavezufa;
   }

   public static float _alias() {
      return husband$.thePlayer.rotationYaw;
   }

   public static void _relate(float libecilu) {
      husband$.thePlayer.rotationYaw = (float)libecilu;
   }

   public static void _readings() {
      relation$ = 0;
      fibre$ = null;
   }

   public static float[] _whenever(int absolute, double captured, int eight) {
      EntitySnowball var4 = new EntitySnowball(Minecraft.getMinecraft().theWorld);
      var4.posX = (double)absolute + 0.5D;
      var4.posY = captured + 0.5D;
      var4.posZ = (double)eight + 0.5D;
      return _rewards(var4);
   }

   public static float[] _rewards(Entity wheel) {
      if (wheel == null) {
         return null;
      } else {
         Object glossary = Minecraft.getMinecraft();
         Object stamps = ((Entity)wheel).posX - glossary.thePlayer.posX;
         Object thread = ((Entity)wheel).posY + (double)(((Entity)wheel).getEyeHeight() / 2.0F) - (glossary.thePlayer.posY + (double)glossary.thePlayer.getEyeHeight());
         Object mills = ((Entity)wheel).posZ - glossary.thePlayer.posZ;
         double var8 = (double)MathHelper.sqrt_double(stamps * stamps + mills * mills);
         float var10 = (float)(Math.atan2(mills, stamps) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(thread, var8) * 180.0D / 3.141592653589793D));
         return new float[]{(glossary.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var10 - glossary.thePlayer.rotationYaw)) % 360.0F, (glossary.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var11 - glossary.thePlayer.rotationPitch)) % 360.0F};
      }
   }

   public static float _digit() {
      Object acebutis = Minecraft.getMinecraft().thePlayer.rotationYaw;
      Object taguzebe = 1.0F;
      if (Minecraft.getMinecraft().thePlayer.movementInput.moveForward < Float.intBitsToFloat(0)) {
         acebutis += 180.0F;
         taguzebe = -0.5F;
      } else if (Minecraft.getMinecraft().thePlayer.movementInput.moveForward > Float.intBitsToFloat(0)) {
         taguzebe = 0.5F;
      }

      if (Minecraft.getMinecraft().thePlayer.movementInput.moveStrafe > Float.intBitsToFloat(0)) {
         acebutis -= 90.0F * taguzebe;
      }

      if (Minecraft.getMinecraft().thePlayer.movementInput.moveStrafe < Float.intBitsToFloat(0)) {
         acebutis += 90.0F * taguzebe;
      }

      return acebutis * 0.017453292F;
   }

   public static float _filling() {
      Object exciting = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return exciting * exciting * exciting * 8.0F * 0.15F;
   }

   public static void _heroes(ScaffoldUtils2 romogaze) {
      _region((ScaffoldUtils2)romogaze, 0);
   }

   public static void _region(ScaffoldUtils2 string, int makeup) {
      if (!Double.isNaN((double)((ScaffoldUtils2)string)._infected()) && !Double.isNaN((double)((ScaffoldUtils2)string)._aside()) && ((ScaffoldUtils2)string)._aside() <= 90.0F && ((ScaffoldUtils2)string)._aside() >= -90.0F) {
         fibre$ = (ScaffoldUtils2)string;
         relation$ = (int)makeup;
      }
   }

   public static float _stations(float tracks, float sizes, float teeth) {
      Object nascar = MathHelper.wrapAngleTo180_float((float)(sizes - tracks));
      if (nascar > teeth) {
         nascar = (float)teeth;
      }

      if (nascar < -teeth) {
         nascar = (float)(-teeth);
      }

      return tracks + nascar;
   }

   public static float[] _games(Entity annex, float downtown, float equality, boolean slope) {
      Object alice = ((Entity)annex).posX - husband$.thePlayer.posX;
      Object passport = ((Entity)annex).posZ - husband$.thePlayer.posZ;
      double outputs;
      if (annex instanceof EntityLivingBase) {
         Object trying = (EntityLivingBase)annex;
         outputs = trying.posY + (double)trying.getEyeHeight() - (husband$.thePlayer.posY + (double)husband$.thePlayer.getEyeHeight());
      } else {
         outputs = (((Entity)annex).getEntityBoundingBox().minY + ((Entity)annex).getEntityBoundingBox().maxY) / 2.0D - (husband$.thePlayer.posY + (double)husband$.thePlayer.getEyeHeight());
      }

      new Random();
      Object arrival = (double)MathHelper.sqrt_double(alice * alice + passport * passport);
      float var13 = (float)(Math.atan2(passport, alice) * 180.0D / 3.141592653589793D) - 90.0F;
      float var14 = (float)(-Math.atan2(outputs - (annex instanceof EntityPlayer ? 0.25D : Double.longBitsToDouble(0L)), arrival) * 180.0D / 3.141592653589793D);
      float var15 = _shelf(husband$.thePlayer.rotationPitch, var14, (float)equality);
      float var16 = _shelf(husband$.thePlayer.rotationYaw, var13, (float)downtown);
      return new float[]{var16, var15};
   }

   public static float[] _popular(Entity uruteyed) {
      Object isiconun = ((Entity)uruteyed).posX + (((Entity)uruteyed).posX - ((Entity)uruteyed).lastTickPosX);
      Object cozasuga = ((Entity)uruteyed).posZ + (((Entity)uruteyed).posZ - ((Entity)uruteyed).lastTickPosZ);
      double var5 = ((Entity)uruteyed).posY + (double)(((Entity)uruteyed).getEyeHeight() / 2.0F);
      return _bodies(isiconun, cozasuga, var5);
   }

   public static float[] _bodies(double merit, double clients, double passion) {
      Object toilet = merit - Minecraft.getMinecraft().thePlayer.posX;
      Object weblogs = clients - Minecraft.getMinecraft().thePlayer.posZ;
      double var10 = passion - Minecraft.getMinecraft().thePlayer.posY - 1.2D;
      double var12 = (double)MathHelper.sqrt_double(toilet * toilet + weblogs * weblogs);
      float var14 = (float)(Math.atan2(weblogs, toilet) * 180.0D / 3.141592653589793D) - 90.0F;
      float var15 = (float)(-(Math.atan2(var10, var12) * 180.0D / 3.141592653589793D));
      return new float[]{var14, var15};
   }

   public static float[] _opposed(ScaffoldUtils ebecopez, ScaffoldUtils itofiped) {
      Object iyenozug = ((ScaffoldUtils)itofiped).oldest$ - ((ScaffoldUtils)ebecopez).oldest$;
      Object imeboyil = ((ScaffoldUtils)itofiped).pirates$ - ((ScaffoldUtils)ebecopez).pirates$;
      Object fetumuca = ((ScaffoldUtils)itofiped).billing$ - ((ScaffoldUtils)ebecopez).billing$;
      double var8 = Math.sqrt(iyenozug * iyenozug + fetumuca * fetumuca);
      float var10 = (float)Math.toDegrees(Math.atan2(fetumuca, iyenozug)) - 90.0F;
      float var11 = (float)(-Math.toDegrees(Math.atan2(imeboyil, var8)));
      return new float[]{MathHelper.wrapAngleTo180_float(var10), MathHelper.wrapAngleTo180_float(var11)};
   }

   public static float _shelf(float bloom, float ceremony, float mother) {
      Object respond = MathHelper.wrapAngleTo180_float((float)(ceremony - bloom));
      if (respond > mother) {
         respond = (float)mother;
      }

      if (respond < -mother) {
         respond = (float)(-mother);
      }

      return bloom + respond;
   }

   public static double[] _surgical(Entity gedizata) {
      Object tiyagipu = husband$.thePlayer.posX;
      Object opilitof = husband$.thePlayer.posY + (double)husband$.thePlayer.getEyeHeight();
      Object ayamimac = husband$.thePlayer.posZ;
      Object ecuzutag = ((Entity)gedizata).posX;
      Object ocuyedut = ((Entity)gedizata).posY + (double)(((Entity)gedizata).height / 2.0F);
      Object eyugafep = ((Entity)gedizata).posZ;
      double var13 = tiyagipu - ecuzutag;
      double var15 = opilitof - ocuyedut;
      double var17 = ayamimac - eyugafep;
      double var19 = Math.sqrt(Math.pow(var13, 2.0D) + Math.pow(var17, 2.0D));
      double var21 = Math.toDegrees(Math.atan2(var17, var13)) + 90.0D;
      double var23 = Math.toDegrees(Math.atan2(var19, var15));
      return new double[]{var21, 90.0D - var23};
   }

   public static float[] _intake(Entity osazaviy) {
      if (osazaviy == null) {
         return null;
      } else {
         Object isogecub = ((Entity)osazaviy).posX - husband$.thePlayer.posX;
         Object eroyarip = ((Entity)osazaviy).posZ - husband$.thePlayer.posZ;
         double zitamize;
         if (osazaviy instanceof EntityLivingBase) {
            EntityLivingBase var7 = (EntityLivingBase)osazaviy;
            zitamize = var7.posY + ((double)var7.getEyeHeight() - 0.4D) - (husband$.thePlayer.posY + (double)husband$.thePlayer.getEyeHeight());
         } else {
            zitamize = (((Entity)osazaviy).getEntityBoundingBox().minY + ((Entity)osazaviy).getEntityBoundingBox().maxY) / 2.0D - (husband$.thePlayer.posY + (double)husband$.thePlayer.getEyeHeight());
         }

         double var11 = (double)MathHelper.sqrt_double(isogecub * isogecub + eroyarip * eroyarip);
         float var9 = (float)(Math.atan2(eroyarip, isogecub) * 180.0D / 3.141592653589793D) - 90.0F;
         float var10 = (float)(-Math.atan2(zitamize, var11) * 180.0D / 3.141592653589793D);
         return new float[]{var9, var10};
      }
   }

   public static float _eclipse(float atevazes, float usorecel) {
      Object yaramavo = Math.abs((float)(atevazes - usorecel)) % 360.0F;
      if (yaramavo > 180.0F) {
         yaramavo = Float.intBitsToFloat(0);
      }

      return yaramavo;
   }

   public static float[] _trained(BlockPos igidufat) {
      return _restrict(husband$.thePlayer.getPositionVector().addVector(Double.longBitsToDouble(0L), (double)husband$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L)), new net.minecraft.util.Vec3((double)((BlockPos)igidufat).getX() + 0.5D, (double)((BlockPos)igidufat).getY() + 0.5D, (double)((BlockPos)igidufat).getZ() + 0.5D));
   }

   public static float[] _balloon(net.minecraft.util.Vec3 msgid) {
      return _restrict(husband$.thePlayer.getPositionVector().addVector(Double.longBitsToDouble(0L), (double)husband$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L)), (net.minecraft.util.Vec3)msgid);
   }

   public static float[] _restrict(net.minecraft.util.Vec3 drove, net.minecraft.util.Vec3 lifetime) {
      Object prizes = ((net.minecraft.util.Vec3)lifetime).subtract((net.minecraft.util.Vec3)drove);
      Object joins = (new net.minecraft.util.Vec3(prizes.xCoord, Double.longBitsToDouble(0L), prizes.zCoord)).lengthVector();
      Object mistakes = (float)Math.toDegrees(Math.atan2(prizes.zCoord, prizes.xCoord)) - 90.0F;
      float var6 = (float)(-Math.toDegrees(Math.atan2(prizes.yCoord, joins)));
      return new float[]{mistakes, var6};
   }

   public static int _hours(float ufocupas, int evibiyep) {
      Object vimudani = (int)((double)(ufocupas + (float)(360 / (2 * evibiyep))) + 0.5D) % 360;
      if (vimudani < 0) {
         vimudani += 360;
      }

      return vimudani / (360 / evibiyep);
   }

   @EventHandler
   public void _literacy(EventTick var1) {
      if (fibre$ != null) {
         --relation$;
         if (relation$ <= 0) {
            _readings();
         }
      }

      if (blast$.nextGaussian() > 0.8D) {
         pipeline$ = Math.random();
      }

      if (blast$.nextGaussian() > 0.8D) {
         outlined$ = Math.random();
      }

      if (blast$.nextGaussian() > 0.8D) {
         council$ = Math.random();
      }

   }
}
