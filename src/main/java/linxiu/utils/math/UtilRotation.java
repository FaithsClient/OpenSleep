package linxiu.utils.math;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.MathHelper;

import java.util.Random;

public class UtilRotation {
    private static final Minecraft mc = Minecraft.getMinecraft();

    public static float[] getAngles(Entity entity) {
        double x = entity.posX - UtilRotation.mc.thePlayer.posX;
        double z = entity.posZ - UtilRotation.mc.thePlayer.posZ;
        double y = entity instanceof EntityEnderman ? entity.posY - UtilRotation.mc.thePlayer.posY : entity.posY + ((double)entity.getEyeHeight() - 1.9) - UtilRotation.mc.thePlayer.posY + ((double)UtilRotation.mc.thePlayer.getEyeHeight() - 1.9);
        double helper = MathHelper.sqrt_double(x * x + z * z);
        float newYaw = (float)Math.toDegrees(-Math.atan(x / z));
        float newPitch = (float)(-Math.toDegrees(Math.atan(y / helper)));
        if (z < 0.0 && x < 0.0) {
            newYaw = (float)(90.0 + Math.toDegrees(Math.atan(z / x)));
        } else if (z < 0.0 && x > 0.0) {
            newYaw = (float)(-90.0 + Math.toDegrees(Math.atan(z / x)));
        }
        return new float[]{newPitch, newYaw};
    }

    public static double getDistanceBetweenAngles(float angle1, float angle2) {
        float distance = Math.abs(angle1 - angle2) % 360.0f;
        if (distance > 180.0f) {
            distance = 360.0f - distance;
        }
        return distance;
    }

    public static void jitterEffect(Random rand) {
        if (rand.nextBoolean()) {
            UtilRotation.mc.thePlayer.rotationPitch = rand.nextBoolean() ? (float)((double)UtilRotation.mc.thePlayer.rotationPitch - (double)rand.nextFloat() * 0.8) : (float)((double)UtilRotation.mc.thePlayer.rotationPitch + (double)rand.nextFloat() * 0.8);
        } else {
            UtilRotation.mc.thePlayer.rotationYaw = rand.nextBoolean() ? (float)((double)UtilRotation.mc.thePlayer.rotationYaw - (double)rand.nextFloat() * 0.8) : (float)((double)UtilRotation.mc.thePlayer.rotationYaw + (double)rand.nextFloat() * 0.8);
        }
    }
}
