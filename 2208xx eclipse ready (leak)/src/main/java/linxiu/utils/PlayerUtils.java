package linxiu.utils;

import linxiu.injection.interfaces.IKeyBinding;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;

public class PlayerUtils {
	

	public static double getDirection() {
		float var0 = mc.thePlayer.rotationYaw;
		if (mc.thePlayer.moveForward < 0.0F) {
			var0 += 180.0F;
		}

		float var1 = 1.0F;
		if (mc.thePlayer.moveForward < 0.0F) {
			var1 = -0.5F;
		} else if (mc.thePlayer.moveForward > 0.0F) {
			var1 = 0.5F;
		}

		if (mc.thePlayer.moveStrafing > 0.0F) {
			float var10001 = 90.0F * var1;
			var0 -= var10001;
		}

		if (mc.thePlayer.moveStrafing < 0.0F) {
			var0 += 90.0F * var1;
		}

		return Math.toRadians(var0);
	}

	public static void strafe(final double var0) {
		if (MovementUtils.isMoving()) {
			double var1 = getDirection();
			mc.thePlayer.motionX = -Math.sin(var1) * var0;
			mc.thePlayer.motionZ = Math.cos(var1) * var0;
		}
	}

	public static float getSpeed() {
		final float vel = (float) Math.sqrt(Helper.mc.thePlayer.motionX * Helper.mc.thePlayer.motionX
				+ Helper.mc.thePlayer.motionZ * Helper.mc.thePlayer.motionZ);
		return vel;
	}

	public static boolean isMoving2() {
		return ((Helper.mc.thePlayer.moveForward != 0.0F || Helper.mc.thePlayer.moveStrafing != 0.0F));
	}

	public static int getJumpEffect() {
		if (Helper.mc.thePlayer.isPotionActive(Potion.jump))
			return Helper.mc.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1;
		else
			return 0;
	}

	public static boolean isOnGround(double height) {
        return !Helper.mc.theWorld.getCollidingBoundingBoxes(Helper.mc.thePlayer,
                Helper.mc.thePlayer.getEntityBoundingBox().offset(0.0D, -height, 0.0D)).isEmpty();
	}

	public static boolean isHoldingSword() {
		return Helper.mc.thePlayer.getCurrentEquippedItem() != null
				&& Helper.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword;
	}

	private static final Minecraft mc = Minecraft.getMinecraft();

	public static boolean isInLiquid() {
		boolean inLiquid = false;
		AxisAlignedBB playerBB = mc.thePlayer.getEntityBoundingBox();
		int y = (int) playerBB.minY;
		for (int x = MathHelper.floor_double(playerBB.minX); x < MathHelper.floor_double(playerBB.maxX) + 1; ++x) {
			for (int z = MathHelper.floor_double(playerBB.minZ); z < MathHelper.floor_double(playerBB.maxZ) + 1; ++z) {
				Block block = mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
				if (block == null || block instanceof BlockAir)
					continue;
				if (!(block instanceof BlockLiquid)) {
					return false;
				}
				inLiquid = true;
			}
		}
		return inLiquid;
	}

	public static boolean MovementInput() {
		return ((IKeyBinding) mc.gameSettings.keyBindForward).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindLeft).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindRight).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindBack).getPress();
	}

	public static boolean isInWater() {
		return mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ))
				.getBlock().getMaterial() == Material.water;
	}

	public static void tellPlayer(String string) {
		if (string != null && mc.thePlayer != null)
			mc.thePlayer.addChatMessage(new ChatComponentText("§c[DEBUG] §r" + string));
	}

	public static void irc(String string) {
		if (string != null && mc.thePlayer != null)
			mc.thePlayer.addChatMessage(new ChatComponentText("§3[IRC] §r" + string));
	}

	public static void hack(String string) {
		if (string != null && mc.thePlayer != null)
			mc.thePlayer.addChatMessage(new ChatComponentText("§f[§0H§f] " + string));
	}

	public static double getLastDist() {
		double xDist = mc.thePlayer.posX - mc.thePlayer.prevPosX;
		double zDist = mc.thePlayer.posZ - mc.thePlayer.prevPosZ;
		return Math.sqrt(xDist * xDist + zDist * zDist);
	}

	public static float[] getNeededRotations(EntityLivingBase entityIn) {
		double d0 = entityIn.posX - mc.thePlayer.posX;
		double d1 = entityIn.posZ - mc.thePlayer.posZ;
		double d2 = entityIn.posY + entityIn.getEyeHeight() - (mc.thePlayer.getEntityBoundingBox().minY
				+ (mc.thePlayer.getEntityBoundingBox().maxY - mc.thePlayer.getEntityBoundingBox().minY));
		double d3 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
		float f = (float) (MathHelper.atan2(d1, d0) * 180.0D / Math.PI) - 90.0F;
		float f1 = (float) (-(MathHelper.atan2(d2, d3) * 180.0D / Math.PI));
		return new float[] { f, f1 };
	}

	public static float getMaxFallDist() {
		PotionEffect potioneffect = PlayerUtils.mc.thePlayer.getActivePotionEffect(Potion.jump);
		int f = potioneffect != null ? potioneffect.getAmplifier() + 1 : 0;
		return PlayerUtils.mc.thePlayer.getMaxFallHeight() + f;
	}

    public static boolean isMathGround() {
        return mc.thePlayer.posY % 0.015625 == 0;
    }

    public static boolean isInsideBlock() {
    	AxisAlignedBB playerBB = mc.thePlayer.getEntityBoundingBox();
        for (int x = MathHelper.floor_double(playerBB.minX); x < MathHelper.floor_double(
                playerBB.maxX) + 1; x++) {
            for (int y = MathHelper.floor_double(playerBB.minY); y < MathHelper.floor_double(
                    playerBB.maxY) + 1; y++) {
                for (int z = MathHelper.floor_double(playerBB.minZ); z < MathHelper.floor_double(
                        playerBB.maxZ) + 1; z++) {
                    final Block block = mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
                    final AxisAlignedBB boundingBox;
                    if (block != null && !(block instanceof BlockAir) && (boundingBox = block
                            .getCollisionBoundingBox(mc.theWorld, new BlockPos(x, y, z),
                                    mc.theWorld.getBlockState(new BlockPos(x, y, z)))) != null) {
                        if (playerBB.intersectsWith(boundingBox)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
