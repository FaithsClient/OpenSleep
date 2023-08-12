package linxiu.utils;

import linxiu.Client;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.module.modules.combat.KillAura;
import linxiu.module.modules.combat.TargetStrafe;
import linxiu.utils.math.MathUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

import javax.vecmath.Vector2f;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MovementUtils {

	private static final Minecraft mc = Minecraft.getMinecraft();
	public static final double JUMP_MOTION = 0.41999998688698;

	public static void watchdog(float d) {
		double yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
		boolean isMoving = Minecraft.getMinecraft().thePlayer.moveForward != 0.0F
				|| Minecraft.getMinecraft().thePlayer.moveStrafing != 0.0F;
		boolean isMovingForward = Minecraft.getMinecraft().thePlayer.moveForward > 0.0F;
		boolean isMovingBackward = Minecraft.getMinecraft().thePlayer.moveForward < 0.0F;
		boolean isMovingRight = Minecraft.getMinecraft().thePlayer.moveStrafing > 0.0F;
		boolean isMovingLeft = Minecraft.getMinecraft().thePlayer.moveStrafing < 0.0F;
		boolean isMovingSideways = isMovingLeft || isMovingRight;
		boolean isMovingStraight = isMovingForward || isMovingBackward;
		if (isMoving) {
			if (isMovingForward && !isMovingSideways) {
				yaw += 0.0D;
			} else if (isMovingBackward && !isMovingSideways) {
				yaw += 180.0D;
			} else if (isMovingForward && isMovingLeft) {
				yaw += 45.0D;
			} else if (isMovingForward) {
				yaw -= 45.0D;
			} else if (!isMovingStraight && isMovingLeft) {
				yaw += 90.0D;
			} else if (!isMovingStraight && isMovingRight) {
				yaw -= 90.0D;
			} else if (isMovingBackward && isMovingLeft) {
				yaw += 135.0D;
			} else if (isMovingBackward) {
				yaw -= 135.0D;
			}
			yaw = Math.toRadians(yaw);
			Minecraft.getMinecraft().thePlayer.motionX = -Math.sin(yaw) * (double) d;
			Minecraft.getMinecraft().thePlayer.motionZ = Math.cos(yaw) * (double) d;
		}
	}

	public static void watchdog(EventMove e, double d) {
		double yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
		boolean isMoving = Minecraft.getMinecraft().thePlayer.moveForward != 0.0F
				|| Minecraft.getMinecraft().thePlayer.moveStrafing != 0.0F;
		boolean isMovingForward = Minecraft.getMinecraft().thePlayer.moveForward > 0.0F;
		boolean isMovingBackward = Minecraft.getMinecraft().thePlayer.moveForward < 0.0F;
		boolean isMovingRight = Minecraft.getMinecraft().thePlayer.moveStrafing > 0.0F;
		boolean isMovingLeft = Minecraft.getMinecraft().thePlayer.moveStrafing < 0.0F;
		boolean isMovingSideways = isMovingLeft || isMovingRight;
		boolean isMovingStraight = isMovingForward || isMovingBackward;
		if (isMoving) {
			if (isMovingForward && !isMovingSideways) {
				yaw += 0.0D;
			} else if (isMovingBackward && !isMovingSideways) {
				yaw += 180.0D;
			} else if (isMovingForward && isMovingLeft) {
				yaw += 45.0D;
			} else if (isMovingForward) {
				yaw -= 45.0D;
			} else if (!isMovingStraight && isMovingLeft) {
				yaw += 90.0D;
			} else if (!isMovingStraight && isMovingRight) {
				yaw -= 90.0D;
			} else if (isMovingBackward && isMovingLeft) {
				yaw += 135.0D;
			} else if (isMovingBackward) {
				yaw -= 135.0D;
			}

			yaw = Math.toRadians(yaw);
			e.x = -Math.sin(yaw) * d;
			e.z = Math.cos(yaw) * d;
		}
	}

	public static void watchdog(double d) {
		double yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
		boolean isMoving = Minecraft.getMinecraft().thePlayer.moveForward != 0.0F
				|| Minecraft.getMinecraft().thePlayer.moveStrafing != 0.0F;
		boolean isMovingForward = Minecraft.getMinecraft().thePlayer.moveForward > 0.0F;
		boolean isMovingBackward = Minecraft.getMinecraft().thePlayer.moveForward < 0.0F;
		boolean isMovingRight = Minecraft.getMinecraft().thePlayer.moveStrafing > 0.0F;
		boolean isMovingLeft = Minecraft.getMinecraft().thePlayer.moveStrafing < 0.0F;
		boolean isMovingSideways = isMovingLeft || isMovingRight;
		boolean isMovingStraight = isMovingForward || isMovingBackward;
		if (isMoving) {
			if (isMovingForward && !isMovingSideways) {
				yaw += 0.0D;
			} else if (isMovingBackward && !isMovingSideways) {
				yaw += 180.0D;
			} else if (isMovingForward && isMovingLeft) {
				yaw += 45.0D;
			} else if (isMovingForward) {
				yaw -= 45.0D;
			} else if (!isMovingStraight && isMovingLeft) {
				yaw += 90.0D;
			} else if (!isMovingStraight && isMovingRight) {
				yaw -= 90.0D;
			} else if (isMovingBackward && isMovingLeft) {
				yaw += 135.0D;
			} else if (isMovingBackward) {
				yaw -= 135.0D;
			}

			yaw = Math.toRadians(yaw);
			Minecraft.getMinecraft().thePlayer.motionX = -Math.sin(yaw) * d;
			Minecraft.getMinecraft().thePlayer.motionZ = Math.cos(yaw) * d;
		}
	}

	public static void setSpeed(final EventMove moveEvent, final double moveSpeed, final float pseudoYaw,
			final double pseudoStrafe, final double pseudoForward) {
		double forward = pseudoForward;
		double strafe = pseudoStrafe;
		float yaw = pseudoYaw;

		if (forward == 0.0 && strafe == 0.0) {
			moveEvent.setZ(0);
			moveEvent.setX(0);
		} else {
			if (forward != 0.0) {
				if (strafe > 0.0) {
					yaw += ((forward > 0.0) ? -45 : 45);
				} else if (strafe < 0.0) {
					yaw += ((forward > 0.0) ? 45 : -45);
				}
				strafe = 0.0;
				if (forward > 0.0) {
					forward = 1.0;
				} else if (forward < 0.0) {
					forward = -1.0;
				}
			}
			final double cos = Math.cos(Math.toRadians(yaw + 90.0f));
			final double sin = Math.sin(Math.toRadians(yaw + 90.0f));

			moveEvent.setX((forward * moveSpeed * cos + strafe * moveSpeed * sin));
			moveEvent.setZ((forward * moveSpeed * sin - strafe * moveSpeed * cos));
		}
	}

	public static void setMotion(final EventMove moveEvent, final double moveSpeed, final double pseudoForward,
			final double pseudoStrafe) {
		double forward = pseudoForward;
		double strafe = mc.thePlayer.movementInput.moveStrafe;
		float yaw = mc.thePlayer.rotationYaw;

		if (forward == 0.0 && strafe == 0.0) {
			moveEvent.setZ(0);
			moveEvent.setX(0);
		} else {
			if (forward != 0.0) {
				if (strafe > 0.0) {
					yaw += ((forward > 0.0) ? -45 : 45);
				} else if (strafe < 0.0) {
					yaw += ((forward > 0.0) ? 45 : -45);
				}
				strafe = 0.0;
				if (forward > 0.0) {
					forward = 1.0;
				} else if (forward < 0.0) {
					forward = -1.0;
				}
			}
			final double cos = Math.cos(Math.toRadians(yaw + 90.0f));
			final double sin = Math.sin(Math.toRadians(yaw + 90.0f));

			moveEvent.setX((forward * moveSpeed * cos + strafe * moveSpeed * sin) * pseudoStrafe);
			moveEvent.setZ((forward * moveSpeed * sin - strafe * moveSpeed * cos) * pseudoStrafe);
		}
	}

	public static void setCockSpeed(final EventPreUpdate moveEvent, final double moveSpeed, final float pseudoYaw,
			final double pseudoStrafe, final double pseudoForward) {
		double forward = pseudoForward;
		double strafe = pseudoStrafe;
		float yaw = pseudoYaw;

		if (forward == 0.0 && strafe == 0.0) {
			moveEvent.setZ(0);
			moveEvent.setX(0);
		} else {
			if (forward != 0.0) {
				if (strafe > 0.0) {
					yaw += ((forward > 0.0) ? -45 : 45);
				} else if (strafe < 0.0) {
					yaw += ((forward > 0.0) ? 45 : -45);
				}
				strafe = 0.0;
				if (forward > 0.0) {
					forward = 1.0;
				} else if (forward < 0.0) {
					forward = -1.0;
				}
			}
			final double cos = Math.cos(Math.toRadians(yaw + 90.0f));
			final double sin = Math.sin(Math.toRadians(yaw + 90.0f));

			moveEvent.setX((forward * moveSpeed * cos + strafe * moveSpeed * sin));
			moveEvent.setZ((forward * moveSpeed * sin - strafe * moveSpeed * cos));
		}
	}

	public static boolean isBlockAbovePlayer() {
		return !(mc.theWorld.getBlockState(
				new BlockPos(mc.thePlayer.posX, mc.thePlayer.getEntityBoundingBox().maxY + 0.42F, mc.thePlayer.posZ))
				.getBlock() instanceof BlockAir);
	}

	/**
	 * teleport local player relative to local players coordinates
	 *
	 * @param x x
	 * @param y y
	 * @param z z
	 */
	public static void setPos(double x, double y, double z) {
		mc.thePlayer.setPosition(mc.thePlayer.posX + x, mc.thePlayer.posY + y, mc.thePlayer.posZ + z);
	}

	public static double getBaseMoveSpeed3(double speed) {
		double baseSpeed = speed;
		if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
			baseSpeed *= 1 + 0.2 * (mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
		}

		return baseSpeed;
	}

	/**
	 * @param baseJumpHeight base jump height e.g. 0.42D
	 * @return {@code baseJumpHeight} multiplied by jump boost modifier
	 */
	public static double getJumpBoostModifier(double baseJumpHeight) {
		if (mc.thePlayer.isPotionActive(Potion.jump)) {
			int amplifier = mc.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
			baseJumpHeight += (float) (amplifier + 1) * 0.1F;
		}

		return baseJumpHeight;
	}

	public static boolean isOnGround() {
		return mc.thePlayer.onGround && mc.thePlayer.isCollidedVertically;
	}

	public static boolean isMoving() {
		return mc.thePlayer != null
				&& (mc.thePlayer.movementInput.moveForward != 0F || mc.thePlayer.movementInput.moveStrafe != 0F);
	}

	public static boolean isOnGround(double height) {
		return !mc.theWorld.getCollidingBoundingBoxes(mc.thePlayer,
				mc.thePlayer.getEntityBoundingBox().offset(0.0D, -height, 0.0D)).isEmpty();
	}

	public static int getSpeedEffect() {
		if (mc.thePlayer.isPotionActive(Potion.moveSpeed))
			return mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1;
		else
			return 0;
	}

	public static void setSpeed(EventMove moveEvent, double moveSpeed, double v1) {
		double forward = mc.thePlayer.movementInput.moveForward;
		double strafe = mc.thePlayer.movementInput.moveStrafe;
		float yaw = mc.thePlayer.rotationYaw;
		if ((forward == 0.0D) && (strafe == 0.0D)) {
			moveEvent.setX(0.0);
			moveEvent.setZ(0.0);
		} else {
			if (forward != 0.0D) {
				if (strafe > 0.0D) {
					yaw += (forward > 0.0D ? -45 : 45);
				} else if (strafe < 0.0D) {
					yaw += (forward > 0.0D ? 45 : -45);
				}
				strafe = 0.0D;
				if (forward > 0.0D) {
					forward = 1;
				} else if (forward < 0.0D) {
					forward = -1;
				}
			}
			double v9 = Math.sin(Math.toRadians(yaw));
			double v11 = Math.cos(Math.toRadians(yaw));
			moveEvent.setX((forward * moveSpeed * -v9 + strafe * moveSpeed * v11) * v1);
			moveEvent.setZ((forward * moveSpeed * v11 - strafe * moveSpeed * -v9) * v1);
		}
	}

	public static double W(double a, double a2) {
		double a3;
		Random a4 = new Random();
		double a5 = a4.nextDouble() * (a2 - a);
		if (a5 > a2) {
			a5 = a2;
		}
		if ((a3 = a5 + a) <= a2)
			return a3;
		return a2;
	}

	public static void setMotion(double speed) {
		double forward = mc.thePlayer.movementInput.moveForward;
		double strafe = mc.thePlayer.movementInput.moveStrafe;
		double yaw = mc.thePlayer.rotationYaw;
		if (forward == 0.0D && strafe == 0.0D) {
			mc.thePlayer.motionX = 0.0D;
			mc.thePlayer.motionZ = 0.0D;
		} else {
			if (forward != 0.0D) {
				if (strafe > 0.0D) {
					yaw += ((forward > 0.0D) ? -45 : 45);
				} else if (strafe < 0.0D) {
					yaw += ((forward > 0.0D) ? 45 : -45);
				}
				strafe = 0.0D;
				if (forward > 0.0D) {
					forward = 1.0D;
				} else if (forward < 0.0D) {
					forward = -1.0D;
				}
			}
			double v9 = Math.sin(Math.toRadians(yaw));
			double v11 = Math.cos(Math.toRadians(yaw));
			double movespeed = speed;
			mc.thePlayer.motionX = ((forward * movespeed * -v9 + strafe * movespeed * v11));
			mc.thePlayer.motionZ = ((forward * movespeed * v11 - strafe * movespeed * -v9));
		}
	}

	public static float getSpeed() {
		return (float) Math
				.sqrt(mc.thePlayer.motionX * mc.thePlayer.motionX + mc.thePlayer.motionZ * mc.thePlayer.motionZ);
	}

	public static double getJumpBoostModifier(double baseJumpHeight, boolean potionJumpHeight) {
		if (mc.thePlayer.isPotionActive(Potion.jump) && potionJumpHeight) {
			int amplifier = mc.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
			baseJumpHeight += ((float) (amplifier + 1) * 0.1f);

		}
		return baseJumpHeight;
	}

	public static boolean isInLiquid() {
		if (mc.thePlayer.isInWater()) {
			return true;
		} else {
			boolean inLiquid = false;
			int y = (int) mc.thePlayer.getEntityBoundingBox().minY;

			for (int x = MathHelper.floor_double(mc.thePlayer.getEntityBoundingBox().minX); x < MathHelper
					.floor_double(mc.thePlayer.getEntityBoundingBox().maxX) + 1; ++x) {
				for (int z = MathHelper.floor_double(mc.thePlayer.getEntityBoundingBox().minZ); z < MathHelper
						.floor_double(mc.thePlayer.getEntityBoundingBox().maxZ) + 1; ++z) {
					Block block = mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
					if (block != null && block.getMaterial() != Material.air) {
						if (!(block instanceof BlockLiquid)) {
							return false;
						}

						inLiquid = true;
					}
				}
			}

			return inLiquid;
		}
	}

	public static double getJumpHeight(double baseJumpHeight) {
		if (isInLiquid()) {
			return 0.221 * 0.115D / 0.221 + 0.02F;
		} else if (mc.thePlayer.isPotionActive(Potion.jump)) {
			return baseJumpHeight + (mc.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1.0F) * 0.1F;
		}
		return baseJumpHeight;
	}

	public static double getJumpHeight() {
		return getJumpHeight(0.41999998688697815D);
	}

	public static float getSensitivityMultiplier() {
		float f = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
		return f * f * f * 8.0F * 0.15F;
	}

	public static void bypassOffSet(EventPreUpdate event) {
		if (MovementUtils.isMoving()) {
			List<Double> BypassOffset = Arrays.asList(0.125, 0.25, 0.375, 0.625, 0.75, 0.015625, 0.5, 0.0625, 0.875,
					0.1875);
			double d3 = event.getY() % 1.0;
			BypassOffset.sort(Comparator.comparingDouble(PreY -> Math.abs(PreY - d3)));
			double acc = event.getY() - d3 + BypassOffset.get(0);
			if (Math.abs(BypassOffset.get(0) - d3) < 0.005) {
				EventPreUpdate.setY(acc);
				EventPreUpdate.setOnground(true);
			} else {
				List<Double> BypassOffset2 = Arrays.asList(0.715, 0.945, 0.09, 0.155, 0.14, 0.045, 0.63, 0.31);
				double d3_ = event.getY() % 1.0;
				BypassOffset2.sort(Comparator.comparingDouble(PreY -> Math.abs(PreY - d3_)));
				acc = event.getY() - d3_ + BypassOffset2.get(0);
				if (Math.abs(BypassOffset2.get(0) - d3_) < 0.005) {
					EventPreUpdate.setY(acc);
				}
			}
		}
	}

	public static void setSpeed(final EventMove moveEvent, final double moveSpeed) {
		setSpeed(moveEvent, moveSpeed, mc.thePlayer.rotationYaw, mc.thePlayer.movementInput.moveStrafe,
				mc.thePlayer.movementInput.moveForward);
	}

	public static boolean MovementInput() {
		return mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown()
				|| mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown();
	}

	public static int getJumpEffect() {
		return mc.thePlayer.isPotionActive(Potion.jump)
				? mc.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1
				: 0;
	}

	public static boolean isOnLiquid() {
		AxisAlignedBB boundingBox = mc.thePlayer.getEntityBoundingBox();
		if (boundingBox == null) {
			return false;
		}
		boundingBox = boundingBox.contract(0.01D, 0.0D, 0.01D).offset(0.0D, -0.01D, 0.0D);
		boolean onLiquid = false;
		int y = (int) boundingBox.minY;
		for (int x = MathHelper.floor_double(boundingBox.minX); x < MathHelper
				.floor_double(boundingBox.maxX + 1.0D); x++) {
			for (int z = MathHelper.floor_double(boundingBox.minZ); z < MathHelper
					.floor_double(boundingBox.maxZ + 1.0D); z++) {
				Block block = mc.theWorld.getBlockState((new BlockPos(x, y, z))).getBlock();
				if (block != Blocks.air) {
					if (!(block instanceof BlockLiquid)) {
						return false;
					}
					onLiquid = true;
				}
			}
		}
		return onLiquid;
	}

	public static double getBaseMoveSpeed() {
		double baseSpeed = 0.2873;
		if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
			int amplifier = mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
			baseSpeed *= 1.0 + 0.2 * (double) (amplifier + 1);
		}
		return baseSpeed;
	}

	public static float roundToFloat(double d) {
		return (float) ((double) Math.round(d * 1.0E8D) / 1.0E8D);
	}

	public static final float PI2 = roundToFloat((Math.PI * 2D));

	public static float getMoveYaw(float yaw) {
		Vector2f from = new Vector2f((float) mc.thePlayer.lastTickPosX, (float) mc.thePlayer.lastTickPosZ),
				to = new Vector2f((float) mc.thePlayer.posX, (float) mc.thePlayer.posZ),
				diff = new Vector2f(to.x - from.x, to.y - from.y);

		double x = diff.x, z = diff.y;
		if (x != 0 || z != 0) {
			yaw = (float) Math.toDegrees((Math.atan2(-x, z) + PI2) % PI2);
		}
		return yaw;
	}

	public static final float deg2Rad = roundToFloat2(0.017453292519943295D);

	public static float roundToFloat2(double d) {
		return (float) ((double) Math.round(d * 1.0E8D) / 1.0E8D);
	}

	public static double getCurrentMotion() {
		return Math.sqrt(mc.thePlayer.motionX * mc.thePlayer.motionX + mc.thePlayer.motionZ * mc.thePlayer.motionZ);
	}

	public static double[] yawPos(double value) {
		return yawPos(mc.thePlayer.rotationYaw * deg2Rad, value);
	}

	public static double[] yawPos(float yaw, double value) {
		return new double[] { -MathHelper.sin(yaw) * value, MathHelper.cos(yaw) * value };
	}

	public static double getRandomHypixelValues() {
		SecureRandom secureRandom = new SecureRandom();
		double value = secureRandom.nextDouble() * (1.0 / System.currentTimeMillis());
		for (int i = 0; i < MathUtil.randomInt(MathUtil.randomInt(4, 6), MathUtil.randomInt(8, 20)); i++)
			value *= (1.0 / System.currentTimeMillis());
		return value;
	}

	public static double getHorizontalMotion() {
		return Math.hypot(mc.thePlayer.motionX, mc.thePlayer.motionZ);
	}

    public static double getDirection() {
        float rotationYaw = mc.thePlayer.rotationYaw;

        if(mc.thePlayer.moveForward < 0F)
            rotationYaw += 180F;

        float forward = 1F;
        if(mc.thePlayer.moveForward < 0F)
            forward = -0.5F;
        else if(mc.thePlayer.moveForward > 0F)
            forward = 0.5F;

        if(mc.thePlayer.moveStrafing > 0F)
            rotationYaw -= 90F * forward;

        if(mc.thePlayer.moveStrafing < 0F)
            rotationYaw += 90F * forward;

        return Math.toRadians(rotationYaw);
    }

	public static float getDirection2() {
		final TargetStrafe targetStrafe = (TargetStrafe) Client.INSTANCE.getModuleManager().getModuleByClass(TargetStrafe.class);
		if (targetStrafe != null && targetStrafe.isEnabled() && targetStrafe.canStrafe())
			return (float) Math.toRadians(PlayerUtils.getNeededRotations(KillAura.getTarget())[0]);
		float yaw = mc.thePlayer.rotationYaw;
		float roundedStrafing = Math.max(-1, Math.min(1, Math.round(mc.thePlayer.moveStrafing * 100))),
				roundedForward = Math.max(-1, Math.min(1, Math.round(mc.thePlayer.moveForward * 100)));
		if (roundedStrafing != 0)
			yaw -= 90 * roundedStrafing * (roundedForward != 0 ? roundedForward * 0.5 : 1);
		if (isMovingBackward()) yaw += 180;
		return (float) Math.toRadians(yaw);
	}
	
	public static boolean isMovingBackward() {
		return mc.thePlayer.moveForward < 0;
	}
	
	public static void vClip(double value) {
		mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + value, mc.thePlayer.posZ);
	}
	
	public static boolean isOverVoid() {
		if (mc.thePlayer.capabilities.isFlying || mc.thePlayer.capabilities.allowFlying) return false;
		/*for (int i = 2; i >= -100; i--)
			if (!mc.theWorld.isAirBlock(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY + i, mc.thePlayer.posZ)))
				return false;*/
		for (int i = 2; i >= -100; i--) {
			for (double xx = -getSpeed() * 10; xx <= getSpeed() * 10; xx++) {
				for (double zz = -getSpeed() * 10; zz <= getSpeed() * 10; zz++) {
					double x = (-(Math.sin(getDirection2()) * xx));
					double z = ((Math.cos(getDirection2()) * xx));
					if (!mc.theWorld.isAirBlock(new BlockPos(mc.thePlayer.posX + x, mc.thePlayer.posY + i, mc.thePlayer.posZ + z)))
						return false;
				}
			}
		}
		return true;
	}
}
