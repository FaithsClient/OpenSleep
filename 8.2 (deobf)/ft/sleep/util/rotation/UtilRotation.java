//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.rotation;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.MathHelper;

public class UtilRotation {
   public static Minecraft florida$ = Minecraft.getMinecraft();

   public static float[] _ruled(Entity vilonega) {
      Object sucepiga = ((Entity)vilonega).posX - florida$.thePlayer.posX;
      Object ofebasuv = ((Entity)vilonega).posZ - florida$.thePlayer.posZ;
      Object betarobi = vilonega instanceof EntityEnderman ? ((Entity)vilonega).posY - florida$.thePlayer.posY : ((Entity)vilonega).posY + ((double)((Entity)vilonega).getEyeHeight() - 1.9D) - florida$.thePlayer.posY + ((double)florida$.thePlayer.getEyeHeight() - 1.9D);
      double var7 = (double)MathHelper.sqrt_double(sucepiga * sucepiga + ofebasuv * ofebasuv);
      float var9 = (float)Math.toDegrees(-Math.atan(sucepiga / ofebasuv));
      float var10 = (float)(-Math.toDegrees(Math.atan(betarobi / var7)));
      if (ofebasuv < Double.longBitsToDouble(0L) && sucepiga < Double.longBitsToDouble(0L)) {
         var9 = (float)(90.0D + Math.toDegrees(Math.atan(ofebasuv / sucepiga)));
      } else if (ofebasuv < Double.longBitsToDouble(0L) && sucepiga > Double.longBitsToDouble(0L)) {
         var9 = (float)(-90.0D + Math.toDegrees(Math.atan(ofebasuv / sucepiga)));
      }

      return new float[]{var10, var9};
   }

   public static double _korea(float mofabada, float amozofoc) {
      Object gebefuco = Math.abs((float)(mofabada - amozofoc)) % 360.0F;
      if (gebefuco > 180.0F) {
         gebefuco = 360.0F - gebefuco;
      }

      return (double)gebefuco;
   }

   public static void _florist(Random rights) {
      if (((Random)rights).nextBoolean()) {
         florida$.thePlayer.rotationPitch = ((Random)rights).nextBoolean() ? (float)((double)florida$.thePlayer.rotationPitch - (double)((Random)rights).nextFloat() * 0.8D) : (float)((double)florida$.thePlayer.rotationPitch + (double)((Random)rights).nextFloat() * 0.8D);
      } else {
         florida$.thePlayer.rotationYaw = ((Random)rights).nextBoolean() ? (float)((double)florida$.thePlayer.rotationYaw - (double)((Random)rights).nextFloat() * 0.8D) : (float)((double)florida$.thePlayer.rotationYaw + (double)((Random)rights).nextFloat() * 0.8D);
      }

   }
}
