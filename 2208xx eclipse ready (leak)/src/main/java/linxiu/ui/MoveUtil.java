package linxiu.ui;

import linxiu.api.events.world.EventMove;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;

import javax.vecmath.Vector2d;

/**
 * MoveUtils, used to move in modules
 *
 * @author Liquidbounce
 * @since 13/02/2021
 */

public final class MoveUtil {

	private static final Minecraft mc = Minecraft.getMinecraft();

	/**
	 * Used to get the players speed
	 */
	public static double getSpeed() {
		// nigga hypot heavy
		return Math.hypot(mc.thePlayer.motionX, mc.thePlayer.motionZ);
	}

	/**
	 * Sets current speed to itself make strafe
	 */
	public static void strafe() {
		strafe(getSpeed());
	}

	/**
	 * Checks if the player is moving
	 */
	public static boolean isMoving() {
		return mc.thePlayer != null
				&& (mc.thePlayer.movementInput.moveForward != 0F || mc.thePlayer.movementInput.moveStrafe != 0F);
	}

	public static void stop() {
		mc.thePlayer.motionX = mc.thePlayer.motionZ = 0;
	}

	/**
	 * Sets players speed, with floats
	 */
	public void strafe(final float speed) {
		if (!isMoving())
			return;

		final double yaw = getDirection();

		mc.thePlayer.motionX = -MathHelper.sin((float) yaw) * speed;
		mc.thePlayer.motionZ = MathHelper.cos((float) yaw) * speed;
	}

	public static Block getBlockRelativeToPlayer(final double offsetX, final double offsetY, final double offsetZ) {
		return Minecraft.getMinecraft().theWorld.getBlockState(new BlockPos(Minecraft.getMinecraft().thePlayer.posX + offsetX, Minecraft.getMinecraft().thePlayer.posY + offsetY, Minecraft.getMinecraft().thePlayer.posZ + offsetZ)).getBlock();
	}

	/**
	 * Used to get the players speed, with doubles
	 */
	public static void strafe(final double speed) {
		if (!isMoving())
			return;

		final double yaw = getDirection();
		mc.thePlayer.motionX = -MathHelper.sin((float) yaw) * speed;
		mc.thePlayer.motionZ = MathHelper.cos((float) yaw) * speed;
	}

	public void forward(final double speed) {
		final double yaw = getDirection();

		mc.thePlayer.motionX = -Math.sin(yaw) * speed;
		mc.thePlayer.motionZ = Math.cos(yaw) * speed;
	}

	public double moveSpeed() {
		if (mc.gameSettings.keyBindSprint.isKeyDown()) {
			if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
				if (mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 == 1) {
					return 0.18386012061481244;
				} else {
					return 0.21450346015841276;
				}
			} else {
				return 0.15321676228437875;
			}
		} else {
			if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
				if (mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 == 1) {
					return 0.14143085686761;
				} else {
					return 0.16500264553372018;
				}
			} else {
				return 0.11785905094607611;
			}
		}
	}

	/**
	 * Gets the direction of were the player is looking
	 */
	public static double getDirection() {
		float rotationYaw = mc.thePlayer.rotationYaw;

		if (mc.thePlayer.moveForward < 0F)
			rotationYaw += 180F;

		float forward = 1F;

		if (mc.thePlayer.moveForward < 0F)
			forward = -0.5F;
		else if (mc.thePlayer.moveForward > 0F)
			forward = 0.5F;

		if (mc.thePlayer.moveStrafing > 0F)
			rotationYaw -= 90F * forward;
		if (mc.thePlayer.moveStrafing < 0F)
			rotationYaw += 90F * forward;

		return Math.toRadians(rotationYaw);
	}

	public double getDirectionWrappedTo90() {
		float rotationYaw = mc.thePlayer.rotationYaw;

		if (mc.thePlayer.moveForward < 0F && mc.thePlayer.moveStrafing == 0F)
			rotationYaw += 180F;

		final float forward = 1F;

		if (mc.thePlayer.moveStrafing > 0F)
			rotationYaw -= 90F * forward;
		if (mc.thePlayer.moveStrafing < 0F)
			rotationYaw += 90F * forward;

		return Math.toRadians(rotationYaw);
	}

	public double getDirection(final float yaw) {
		float rotationYaw = yaw;

		if (mc.thePlayer.moveForward < 0F)
			rotationYaw += 180F;

		float forward = 1F;

		if (mc.thePlayer.moveForward < 0F)
			forward = -0.5F;
		else if (mc.thePlayer.moveForward > 0F)
			forward = 0.5F;

		if (mc.thePlayer.moveStrafing > 0F)
			rotationYaw -= 90F * forward;
		if (mc.thePlayer.moveStrafing < 0F)
			rotationYaw += 90F * forward;

		return Math.toRadians(rotationYaw);
	}

	/**
	 * Used to get base movement speed
	 */
	public static double getBaseMoveSpeed() {
		double baseSpeed = 0.2873D;

		if (mc.thePlayer.isPotionActive(Potion.moveSpeed))
			baseSpeed *= 1.0D + 0.2D * (mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);

		return baseSpeed;
	}

	public double getBaseMoveSpeedOther() {
		double baseSpeed = 0.2875D;

		if (mc.thePlayer.isPotionActive(Potion.moveSpeed))
			baseSpeed *= 1.0D + 0.2D * (mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);

		return baseSpeed;
	}

	public double getJumpMotion(float motionY) {
		final Potion potion = Potion.jump;

		if (mc.thePlayer.isPotionActive(potion)) {
			final int amplifier = mc.thePlayer.getActivePotionEffect(potion).getAmplifier();
			motionY += (amplifier + 1) * 0.1F;
		}

		return motionY;
	}

	public static double getPredictedMotionY(final double motionY) {
		return (motionY - 0.08) * 0.98F;
	}

	public void setMoveEventSpeed(final EventMove moveEvent, final double moveSpeed) {
		setMoveEvent(moveEvent, moveSpeed, mc.thePlayer.rotationYaw, mc.thePlayer.movementInput.moveStrafe,
				mc.thePlayer.movementInput.moveForward);
	}

	public boolean isOnGround(final double height) {
		return !mc.theWorld
				.getCollidingBoundingBoxes(mc.thePlayer, mc.thePlayer.getEntityBoundingBox().offset(0.0, -height, 0.0))
				.isEmpty();
	}

	public Vector2d getMotion(final double moveSpeed) {
		final MovementInput movementInput = mc.thePlayer.movementInput;

		double moveForward = movementInput.moveForward;
		double moveStrafe = movementInput.moveStrafe;

		double rotationYaw = mc.thePlayer.rotationYaw;
		if (moveForward != 0.0D || moveStrafe != 0.0D) {
			if (moveStrafe > 0) {
				moveStrafe = 1;
			} else if (moveStrafe < 0) {
				moveStrafe = -1;
			}
			if (moveForward != 0.0D) {
				if (moveStrafe > 0.0D) {
					rotationYaw += moveForward > 0.0D ? -45 : 45;
				} else if (moveStrafe < 0.0D) {
					rotationYaw += moveForward > 0.0D ? 45 : -45;
				}
				moveStrafe = 0.0D;
				if (moveForward > 0.0D) {
					moveForward = 1.0D;
				} else if (moveForward < 0.0D) {
					moveForward = -1.0D;
				}
			}
			rotationYaw *= 0.995;
			final double cos = Math.cos(Math.toRadians(rotationYaw + 90.0F));
			final double sin = Math.sin(Math.toRadians(rotationYaw + 90.0F));
			return new Vector2d(moveForward * moveSpeed * cos + moveStrafe * moveSpeed * sin,
					moveForward * moveSpeed * sin - moveStrafe * moveSpeed * cos);
		}
		return new Vector2d(0, 0);
	}

	public void setMoveEvent(final EventMove moveEvent, final double moveSpeed, final float pseudoYaw,
			final double pseudoStrafe, final double pseudoForward) {
		double forward = pseudoForward;
		double strafe = pseudoStrafe;
		float yaw = pseudoYaw;

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
		if (strafe > 0.0D) {
			strafe = 1.0D;
		} else if (strafe < 0.0D) {
			strafe = -1.0D;
		}
		final double mx = Math.cos(Math.toRadians((yaw + 90.0F)));
		final double mz = Math.sin(Math.toRadians((yaw + 90.0F)));
		moveEvent.setX(forward * moveSpeed * mx + strafe * moveSpeed * mz);
		moveEvent.setZ(forward * moveSpeed * mz - strafe * moveSpeed * mx);
	}

}
