package linxiu.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.*;

import java.util.Random;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventTick;

public class RotationUtils {
	public static Minecraft mc = Minecraft.getMinecraft();
	private static Random random = new Random();
	private static int keepLength;

	public static Rotation targetRotation;
	public static Rotation serverRotation = new Rotation(0, 0);
	public static boolean keepCurrentRotation = false;
	private static double x = random.nextDouble();
	private static double y = random.nextDouble();
	private static double z = random.nextDouble();

	public static double[] interpolate(Entity entity) {
		double partialTicks = Helper.getTimer().renderPartialTicks;
		double[] pos = new double[] { entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks,
				entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks,
				entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks };
		return pos;
	}

	public static float getTrajAngleSolutionLow(float d3, float d1, float velocity) {
		float g = 0.006F;
		float sqrt = velocity * velocity * velocity * velocity
				- g * (g * (d3 * d3) + 2.0F * d1 * (velocity * velocity));
		return (float) Math.toDegrees(Math.atan((velocity * velocity - Math.sqrt(sqrt)) / (g * d3)));
	}

	public static float[] getNeededRotations(final Vector3d current, final Vector3d target) {
		final double diffX = target.x - current.x;
		final double diffY = target.y - current.y;
		final double diffZ = target.z - current.z;
		final double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0f;
		final float pitch = (float) (-Math.toDegrees(Math.atan2(diffY, diffXZ)));
		return new float[] { MathHelper.wrapAngleTo180_float(yaw), MathHelper.wrapAngleTo180_float(pitch) };
	}

	public static float[] getRotations(final double posX, final double posY, final double posZ) {
		final EntityPlayerSP player = mc.thePlayer;
		final double x = posX - player.posX;
		final double y = posY - (player.posY + player.getEyeHeight());
		final double z = posZ - player.posZ;
		final double dist = MathHelper.sqrt_double(x * x + z * z);
		final float yaw = (float) (Math.atan2(z, x) * 180.0 / 3.141592653589793) - 90.0f;
		final float pitch = (float) (-(Math.atan2(y, dist) * 180.0 / 3.141592653589793));
		return new float[] { yaw, pitch };
	}

	public static boolean isVisibleFOV(final Entity e, final float fov) {
		return ((Math.abs(RotationUtils.getRotations(e)[0] - mc.thePlayer.rotationYaw) % 360.0f > 180.0f)
				? (360.0f - Math.abs(RotationUtils.getRotations(e)[0] - mc.thePlayer.rotationYaw) % 360.0f)
				: (Math.abs(RotationUtils.getRotations(e)[0] - mc.thePlayer.rotationYaw) % 360.0f)) <= fov;
	}

	public static float getYawToEntity(final Entity e) {
		return ((Math.abs(RotationUtils.getRotations(e)[0] - mc.thePlayer.rotationYaw) % 360.0f > 180.0f)
				? (360.0f - Math.abs(RotationUtils.getRotations(e)[0] - mc.thePlayer.rotationYaw) % 360.0f)
				: (Math.abs(RotationUtils.getRotations(e)[0] - mc.thePlayer.rotationYaw) % 360.0f));
	}

	public static float[] getRotation(Entity a1) {
		double v1 = a1.posX - mc.thePlayer.posX;
		double v3 = a1.posY + (double) a1.getEyeHeight() * 0.9
				- (mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight());
		double v5 = a1.posZ - mc.thePlayer.posZ;

		double v7 = MathHelper.ceiling_float_int((float) (v1 * v1 + v5 * v5));
		float v9 = (float) (Math.atan2(v5, v1) * 180.0 / 3.141592653589793) - 90.0f;
		float v10 = (float) (-(Math.atan2(v3, v7) * 180.0 / 3.141592653589793));
		return new float[] { mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(v9 - mc.thePlayer.rotationYaw),
				mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(v10 - mc.thePlayer.rotationPitch) };
	}

	// Best method
	public static float[] getRotationToEntity(final EntityLivingBase entity) {
		double xDiff = entity.posX - mc.thePlayer.posX;
		double zDiff = entity.posZ - mc.thePlayer.posZ;
		double yDiff = (entity.posY + entity.getEyeHeight() * 0.9) - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());

		double distance = MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);

		float yaw = (float) (Math.atan2(zDiff, xDiff) * 180.0D / Math.PI) - 90.0F;
		float pitch = (float) (-(Math.atan2(yDiff, distance) * 180.0D / Math.PI));

		return new float[] { yaw, pitch };
	}

	public static float[] getRotationToLocation(final Vec3 loc) {
		double xDiff = loc.xCoord - mc.thePlayer.posX;
		double yDiff = loc.yCoord - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		double zDiff = loc.zCoord - mc.thePlayer.posZ;

		double distance = MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);

		float yaw = (float) (Math.atan2(zDiff, xDiff) * 180.0D / Math.PI) - 90.0F;
		float pitch = (float) (-(Math.atan2(yDiff, distance) * 180.0D / Math.PI));

		return new float[] { yaw, pitch };
	}

	public static float[] naturalRotation(float[] rotation) {
		float baseYaw = MathHelper.wrapAngleTo180_float(mc.thePlayer.rotationYaw - rotation[0]);
		float basePitch = MathHelper.wrapAngleTo180_float(mc.thePlayer.rotationPitch - rotation[1]);

		return new float[] { baseYaw + rotation[0], basePitch + rotation[1] };
	}

	public static float[] getRotations(final BlockPos pos, final EnumFacing facing) {
		return getRotations(pos.getX(), pos.getY(), pos.getZ(), facing);
	}

	public static float[] getRotations(final double x, final double y, final double z, final EnumFacing facing) {
		final EntityPig temp = new EntityPig(mc.theWorld);
		temp.posX = x + 0.5;
		temp.posY = y + 0.5;
		temp.posZ = z + 0.5;

		temp.posX += facing.getDirectionVec().getX() * 0.5;
		temp.posY += facing.getDirectionVec().getY() * 0.5;
		temp.posZ += facing.getDirectionVec().getZ() * 0.5;

		return getRotations(temp);
	}

	// Skidded from Minecraft
	public static float[] getRotations(final Entity entity) {
		if (entity == null) {
			return null;
		}
		final double diffX = entity.posX - mc.thePlayer.posX;
		final double diffZ = entity.posZ - mc.thePlayer.posZ;
		double diffY;
		if (entity instanceof EntityLivingBase) {
			final EntityLivingBase elb = (EntityLivingBase) entity;
			diffY = elb.posY + (elb.getEyeHeight()) - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		} else {
			diffY = (entity.getEntityBoundingBox().minY + entity.getEntityBoundingBox().maxY) / 2.0
					- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		}
		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / Math.PI) - 90.0f;
		final float pitch = (float) (-(Math.atan2(diffY, dist) * 180.0 / Math.PI));
		return new float[] { yaw, pitch };
	}

	public static float[] getRotationsToPos(final double x, final double y, final double z) {
		final double diffX = x - mc.thePlayer.posX;
		final double diffZ = z - mc.thePlayer.posZ;
		final double diffY = y - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / Math.PI) - 90.0f;
		final float pitch = (float) (-(Math.atan2(diffY, dist) * 180.0 / Math.PI));
		return new float[] { yaw, pitch };
	}

	public static float[] getRotations(final EntityLivingBase ent, final double Ix, final double Iy, final double Iz) {
		final double x = ent.posX;
		final double z = ent.posZ;
		final double y = ent.posY + ent.getEyeHeight() / 2.0f;

		final double xDiff = x - Ix;
		final double zDiff = z - Iz;
		final double yDiff = y - Iy - 0.6;
		final double dist = MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
		final float yaw = (float) (Math.atan2(zDiff, xDiff) * 180.0 / 3.141592653589793) - 90.0f;
		final float pitch = (float) (-(Math.atan2(yDiff, dist) * 180.0 / 3.141592653589793));
		return new float[] { yaw, pitch };

	}

	public static float getYawChangeToEntity(final Entity entity) {
		final double deltaX = entity.posX - mc.thePlayer.posX;
		final double deltaZ = entity.posZ - mc.thePlayer.posZ;
		double yawToEntity1 = 0.0;
		if (deltaZ < 0.0 && deltaX < 0.0) {
			yawToEntity1 = 90.0 + Math.toDegrees(Math.atan(deltaZ / deltaX));
		} else if (deltaZ < 0.0 && deltaX > 0.0) {
			final double yawToEntity2 = -90.0 + Math.toDegrees(Math.atan(deltaZ / deltaX));
		} else {
			Math.toDegrees(-Math.atan(deltaX / deltaZ));
		}
		return MathHelper.wrapAngleTo180_float(-(mc.thePlayer.rotationYaw - (float) yawToEntity1));
	}

	public static float getPitchChangeToEntity(final Entity entity) {
		final double deltaX = entity.posX - mc.thePlayer.posX;
		final double deltaZ = entity.posZ - mc.thePlayer.posZ;
		final double deltaY = entity.posY - 1.6 + entity.getEyeHeight() - mc.thePlayer.posY;
		final double distanceXZ = MathHelper.sqrt_double(deltaX * deltaX + deltaZ * deltaZ);
		final double pitchToEntity = -Math.toDegrees(Math.atan(deltaY / distanceXZ));
		return -MathHelper.wrapAngleTo180_float(mc.thePlayer.rotationPitch - (float) pitchToEntity);
	}

	private static double directionCheck(final double sourceX, final double sourceY, final double sourceZ,
			final double dirX, final double dirY, final double dirZ, final double targetX, final double targetY,
			final double targetZ, final double targetWidth, final double targetHeight, final double precision) {
		double dirLength = Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
		if (dirLength == 0.0) {
			dirLength = 1.0;
		}
		final double dX = targetX - sourceX;
		final double dY = targetY - sourceY;
		final double dZ = targetZ - sourceZ;
		final double targetDist = Math.sqrt(dX * dX + dY * dY + dZ * dZ);
		final double xPrediction = targetDist * dirX / dirLength;
		final double yPrediction = targetDist * dirY / dirLength;
		final double zPrediction = targetDist * dirZ / dirLength;
		double off = 0.0;
		off += Math.max(Math.abs(dX - xPrediction) - (targetWidth / 2.0 + precision), 0.0);
		off += Math.max(Math.abs(dZ - zPrediction) - (targetWidth / 2.0 + precision), 0.0);
		off += Math.max(Math.abs(dY - yPrediction) - (targetHeight / 2.0 + precision), 0.0);
		if (off > 1.0) {
			off = Math.sqrt(off);
		}
		return off;
	}

	public static double angleDifference(final double a, final double b) {
		return ((a - b) % 360.0 + 540.0) % 360.0 - 180.0;
	}

	public static float[] faceTarget(final Entity target, float Yaw, final float Pitch, final boolean miss) {
		double var4 = target.posX - mc.thePlayer.posX;
		final double var5 = target.posZ - mc.thePlayer.posZ;
		if (target instanceof EntityLivingBase) {
			final EntityLivingBase var6 = (EntityLivingBase) target;
			var4 = var6.posY + var6.getEyeHeight() - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		} else {
			var4 = (target.getEntityBoundingBox().minY + target.getEntityBoundingBox().maxY) / 2.0
					- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		}
		final Random rnd = new Random();
		final float offset = miss ? (rnd.nextInt(15) * 0.25f + 5.0f) : 0.0f;
		final double var7 = MathHelper.sqrt_double(var4 * var4 + var5 * var5);
		final float var8 = (float) (Math.atan2(var5 + offset, var4) * 180.0 / 3.141592653589793) - 90.0f;
		final float var9 = (float) (-(Math.atan2(var4 - ((target instanceof EntityPlayer) ? 0.5f : 0.0f) + offset, var7)
				* 180.0 / 3.141592653589793));
		final float pitch = changeRotation(mc.thePlayer.rotationPitch, var9, Pitch);
		final float yaw = changeRotation(mc.thePlayer.rotationYaw, var8, Yaw);
		return new float[] { yaw, pitch };
	}

	public static Vec3 getVectorForRotation(float yaw, float pitch) {
		// radians
		float yawCos = MathHelper.cos(-yaw * 0.017453292F - (float) Math.PI);
		float yawSin = MathHelper.sin(-yaw * 0.017453292F - (float) Math.PI);
		float pitchCos = -MathHelper.cos(-pitch * 0.017453292F);
		float pitchSin = MathHelper.sin(-pitch * 0.017453292F);
		return new Vec3(yawSin * pitchCos, pitchSin, yawCos * pitchCos);
	}

	public static float changeRotation(final float p_70663_1_, final float p_70663_2_, final float p_70663_3_) {
		float var4 = MathHelper.wrapAngleTo180_float(p_70663_2_ - p_70663_1_);
		if (var4 > p_70663_3_) {
			var4 = p_70663_3_;
		}
		if (var4 < -p_70663_3_) {
			var4 = -p_70663_3_;
		}
		return p_70663_1_ + var4;
	}

	@EventHandler
	public void onPacket(final EventPacketSend event) {
		final Packet packet = event.getPacket();

		if (packet instanceof C03PacketPlayer) {
			final C03PacketPlayer packetPlayer = (C03PacketPlayer) packet;

			if (targetRotation != null && !keepCurrentRotation && (targetRotation.getYaw() != serverRotation.getYaw()
					|| targetRotation.getPitch() != serverRotation.getPitch())) {
				packetPlayer.yaw = targetRotation.getYaw();
				packetPlayer.pitch = targetRotation.getPitch();
				packetPlayer.rotating = true;
			}

			if (packetPlayer.rotating)
				serverRotation = new Rotation(packetPlayer.yaw, packetPlayer.pitch);
		}
	}

	public static float getYawChangeGiven(double posX, double posZ, float yaw) {
		double deltaX = posX - mc.thePlayer.posX;
		double deltaZ = posZ - mc.thePlayer.posZ;
		double yawToEntity = deltaZ < 0.0 && deltaX < 0.0 ? 90.0 + Math.toDegrees(Math.atan(deltaZ / deltaX))
				: (deltaZ < 0.0 && deltaX > 0.0 ? -90.0 + Math.toDegrees(Math.atan(deltaZ / deltaX))
						: Math.toDegrees(-Math.atan(deltaX / deltaZ)));
		return MathHelper.wrapAngleTo180_float(-(yaw - (float) yawToEntity));
	}

	private static float getAngleDifference(final float a, final float b) {
		return ((((a - b) % 360F) + 540F) % 360F) - 180F;
	}

	public static double getRotationDifference(final Rotation a, final Rotation b) {
		return Math.hypot(getAngleDifference(a.getYaw(), b.getYaw()), a.getPitch() - b.getPitch());
	}

	public static double getRotationDifference(final Rotation rotation) {
		return serverRotation == null ? 0D : getRotationDifference(rotation, serverRotation);
	}

	public static Vec3 getVectorForRotation(final Rotation rotation) {
		float yawCos = (float) Math.cos(-rotation.getYaw() * 0.017453292F - (float) Math.PI);
		float yawSin = (float) Math.sin(-rotation.getYaw() * 0.017453292F - (float) Math.PI);
		float pitchCos = (float) -Math.cos(-rotation.getPitch() * 0.017453292F);
		float pitchSin = (float) Math.sin(-rotation.getPitch() * 0.017453292F);
		return new Vec3(yawSin * pitchCos, pitchSin, yawCos * pitchCos);
	}

	public static VecRotation searchCenter(final AxisAlignedBB bb, final boolean predict) {

		VecRotation vecRotation = null;

		for (double xSearch = 0.15D; xSearch < 0.85D; xSearch += 0.1D) {
			for (double ySearch = 0.15D; ySearch < 1D; ySearch += 0.1D) {
				for (double zSearch = 0.15D; zSearch < 0.85D; zSearch += 0.1D) {
					final Vec3 vec3 = new Vec3(bb.minX + (bb.maxX - bb.minX) * xSearch,
							bb.minY + (bb.maxY - bb.minY) * ySearch, bb.minZ + (bb.maxZ - bb.minZ) * zSearch);
					final Rotation rotation = toRotation(vec3, predict);

					final VecRotation currentVec = new VecRotation(vec3, rotation);

					if (vecRotation == null || (getRotationDifference(currentVec.getRotation()) < getRotationDifference(
							vecRotation.getRotation())))
						vecRotation = currentVec;
				}
			}
		}

		return vecRotation;
	}

	public static VecRotation faceBlock(final BlockPos blockPos) {
		if (blockPos == null)
			return null;

		VecRotation vecRotation = null;

		for (double xSearch = 0.1D; xSearch < 0.9D; xSearch += 0.1D) {
			for (double ySearch = 0.1D; ySearch < 0.9D; ySearch += 0.1D) {
				for (double zSearch = 0.1D; zSearch < 0.9D; zSearch += 0.1D) {
					final Vec3 eyesPos = new Vec3(mc.thePlayer.posX,
							mc.thePlayer.getEntityBoundingBox().minY + mc.thePlayer.getEyeHeight(), mc.thePlayer.posZ);
					final Vec3 posVec = new Vec3(blockPos).addVector(xSearch, ySearch, zSearch);
					final double dist = eyesPos.distanceTo(posVec);

					final double diffX = posVec.xCoord - eyesPos.xCoord;
					final double diffY = posVec.yCoord - eyesPos.yCoord;
					final double diffZ = posVec.zCoord - eyesPos.zCoord;

					final double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);

					final Rotation rotation = new Rotation(
							MathHelper.wrapAngleTo180_float((float) Math.toDegrees(Math.atan2(diffZ, diffX)) - 90F),
							MathHelper.wrapAngleTo180_float((float) -Math.toDegrees(Math.atan2(diffY, diffXZ))));

					final Vec3 rotationVector = getVectorForRotation(rotation);
					final Vec3 vector = eyesPos.addVector(rotationVector.xCoord * dist, rotationVector.yCoord * dist,
							rotationVector.zCoord * dist);
					final MovingObjectPosition obj = mc.theWorld.rayTraceBlocks(eyesPos, vector, false, false, true);

					if (obj != null && obj.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
						final VecRotation currentVec = new VecRotation(posVec, rotation);

						if (vecRotation == null || getRotationDifference(
								currentVec.getRotation()) < getRotationDifference(vecRotation.getRotation()))
							vecRotation = currentVec;
					}
				}
			}
		}

		return vecRotation;
	}

	@EventHandler
	public void onTick(final EventTick event) {
		if (targetRotation != null) {
			keepLength++;

			// Advanced Anti Cheat, huh
			if (keepLength > 15)
				reset();
		}

		if (random.nextGaussian() > 0.8D)
			x = Math.random();
		if (random.nextGaussian() > 0.8D)
			y = Math.random();
		if (random.nextGaussian() > 0.8D)
			z = Math.random();
	}

	public static void setTargetRotation(final Rotation rotation) {
		setTargetRotation(rotation, 0);
	}

	/**
	 * Set your target rotation
	 *
	 * @param rotation your target rotation
	 */
	public static void setTargetRotation(final Rotation rotation, final int keepLength) {
		if (Double.isNaN(rotation.getYaw()) || Double.isNaN(rotation.getPitch()) || rotation.getPitch() > 90
				|| rotation.getPitch() < -90)
			return;

		rotation.fixedSensitivity(mc.gameSettings.mouseSensitivity);
		targetRotation = rotation;
		RotationUtils.keepLength = keepLength;
	}

	public static void setToServerRotation() {
		if (serverRotation == null)
			return;

		targetRotation = serverRotation;
		keepLength = 0;
	}

	/**
	 * Reset your target rotation
	 */
	public static void reset() {
		keepLength = 0;
		targetRotation = null;
	}

	public static Rotation toRotation(final Vec3 vec, final boolean predict) {
		final Vec3 eyesPos = new Vec3(mc.thePlayer.posX,
				mc.thePlayer.getEntityBoundingBox().minY + mc.thePlayer.getEyeHeight(), mc.thePlayer.posZ);

		if (predict)
			eyesPos.addVector(mc.thePlayer.motionX, mc.thePlayer.motionY, mc.thePlayer.motionZ);

		final double diffX = vec.xCoord - eyesPos.xCoord;
		final double diffY = vec.yCoord - eyesPos.yCoord;
		final double diffZ = vec.zCoord - eyesPos.zCoord;

		return new Rotation(MathHelper.wrapAngleTo180_float((float) Math.toDegrees(Math.atan2(diffZ, diffX)) - 90F),
				MathHelper.wrapAngleTo180_float(
						(float) (-Math.toDegrees(Math.atan2(diffY, Math.sqrt(diffX * diffX + diffZ * diffZ))))));
	}

	public static class VecRotation {
		Vec3 vec;
		Rotation rotation;

		public VecRotation(Vec3 vec, Rotation rotation) {
			this.vec = vec;
			this.rotation = rotation;
		}

		public Rotation getRotation() {
			return this.rotation;
		}

		public Vec3 getVec() {
			return vec;
		}
	}

	public static class Rotation {
		public float yaw;
		public float pitch;

		public Rotation(float yaw, float pitch) {
			this.yaw = yaw;
			this.pitch = pitch;
			fixedSensitivity(MinecraftInstance.mc.gameSettings.mouseSensitivity);
		}

		public void setYaw(float yaw) {
			this.yaw = yaw;
		}

		public void setPitch(float pitch) {
			this.pitch = pitch;
		}

		public float getYaw() {
			return this.yaw;
		}

		public float getPitch() {
			return this.pitch;
		}

		public void toPlayer(EntityPlayer player) {
			if (Float.isNaN(yaw) || Float.isNaN(pitch))
				return;

			fixedSensitivity(mc.gameSettings.mouseSensitivity);

			player.rotationYaw = yaw;
			player.rotationPitch = pitch;
		}

		public void fixedSensitivity(Float sensitivity) {
			float f = sensitivity * 0.6F + 0.2F;
			float gcd = f * f * f * 1.2F;

			yaw -= yaw % gcd;
			pitch -= pitch % gcd;
		}

	}

	public static float clampRotation() {
		float rotationYaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
		float n = 1.0f;
		if (Minecraft.getMinecraft().thePlayer.movementInput.moveForward < 0.0f) {
			rotationYaw += 180.0f;
			n = -0.5f;
		} else if (Minecraft.getMinecraft().thePlayer.movementInput.moveForward > 0.0f) {
			n = 0.5f;
		}
		if (Minecraft.getMinecraft().thePlayer.movementInput.moveStrafe > 0.0f) {
			rotationYaw -= 90.0f * n;
		}
		if (Minecraft.getMinecraft().thePlayer.movementInput.moveStrafe < 0.0f) {
			rotationYaw += 90.0f * n;
		}
		return rotationYaw * 0.017453292f;
	}

	public static float[] getFacingRotations2(final int paramInt1, final double d, final int paramInt3) {
		final EntitySnowball localEntityPig = new EntitySnowball(Minecraft.getMinecraft().theWorld);
		localEntityPig.posX = paramInt1 + 0.5;
		localEntityPig.posY = d + 0.5;
		localEntityPig.posZ = paramInt3 + 0.5;
		return getRotationsNeeded(localEntityPig);
	}

	public static float[] getRotationsNeeded(final Entity entity) {
		if (entity == null) {
			return null;
		}
		Minecraft mc = Minecraft.getMinecraft();
		final double xSize = entity.posX - mc.thePlayer.posX;
		final double ySize = entity.posY + entity.getEyeHeight() / 2
				- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		final double zSize = entity.posZ - mc.thePlayer.posZ;
		final double theta = MathHelper.sqrt_double(xSize * xSize + zSize * zSize);
		final float yaw = (float) (Math.atan2(zSize, xSize) * 180 / Math.PI) - 90;
		final float pitch = (float) (-(Math.atan2(ySize, theta) * 180 / Math.PI));
		return new float[] {
				(mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - mc.thePlayer.rotationYaw)) % 360,
				(mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - mc.thePlayer.rotationPitch))
						% 360.0f };
	}

	public static Vec3 getBestVector(Vec3 look, AxisAlignedBB axisAlignedBB) {
		return new Vec3(MathHelper.clamp_double(look.xCoord, axisAlignedBB.minX, axisAlignedBB.maxX),
				MathHelper.clamp_double(look.yCoord, axisAlignedBB.minY, axisAlignedBB.maxY),
				MathHelper.clamp_double(look.zCoord, axisAlignedBB.minZ, axisAlignedBB.maxZ));
	}

	public static float[] facePlayer(Entity e, boolean a3, boolean heuristics, boolean smooth, boolean prediction,
			boolean mouseFix, boolean bestVector, double inaccuracy, boolean clampYaw, float rotationSpeed,
			double range, boolean custom, int customRange) {
		final RandomUtil randomUtil = RandomUtil.getInstance();

		final double eyeX = (mc.thePlayer.getEntityBoundingBox().minX + mc.thePlayer.getEntityBoundingBox().maxX) / 2;
		final double eyeY = mc.thePlayer.getEntityBoundingBox().minY + mc.thePlayer.getEyeHeight();
		final double eyeZ = (mc.thePlayer.getEntityBoundingBox().minZ + mc.thePlayer.getEntityBoundingBox().maxZ) / 2;

		double x = e.posX - eyeX;
		double y = e.posY + e.getEyeHeight() - eyeY;
		double z = e.posZ - eyeZ;

		if (bestVector) {
			final Vec3 bestVec = getBestVector(
					mc.thePlayer.getPositionEyes(mc.timer.renderPartialTicks),
					e.getEntityBoundingBox()).addVector(-inaccuracy / 10, -inaccuracy / 10, -inaccuracy / 10);
			x = bestVec.xCoord - eyeX;
			y = bestVec.yCoord - eyeY;
			z = bestVec.zCoord - eyeZ;
		}

		if (!(e instanceof EntityLivingBase)) {
			y = (e.getEntityBoundingBox().minY + e.getEntityBoundingBox().maxY) / 2.0D
					- (mc.thePlayer.getEntityBoundingBox().minY + (double) mc.thePlayer.getEyeHeight());
		}

		if (custom)
			y *= customRange * 0.02;

		if (heuristics) {
			final float randomPitch = (float) MathHelper.getRandomDoubleInRange(new Random(), 0.015, 0.018);
			float randomizedPitch = (float) MathHelper.getRandomDoubleInRange(new Random(), 0.010, randomPitch);
			float randomizedYaw = (float) MathHelper.getRandomDoubleInRange(new Random(), -0.1, -0.3);
			x += randomUtil.getRandomDouble(-randomizedPitch, randomizedPitch);
			z += randomUtil.getRandomDouble(-randomizedPitch, randomizedPitch);
			y += randomUtil.getRandomDouble(randomizedYaw, -0.01);
		}

		if (prediction) {
			boolean sprinting = e.isSprinting();
			boolean sprintingPlayer = mc.thePlayer.isSprinting();

			float walkingSpeed = 0.10000000149011612f; // https://minecraft.fandom.com/wiki/Sprinting

			float sprintMultiplication = sprinting ? 1.25f : walkingSpeed;
			float sprintMultiplicationPlayer = sprintingPlayer ? 1.25f : walkingSpeed;

			float xMultiplication = (float) ((e.posX - e.prevPosX) * sprintMultiplication);
			float zMultiplication = (float) ((e.posZ - e.prevPosZ) * sprintMultiplication);

			float xMultiplicationPlayer = (float) ((mc.thePlayer.posX - mc.thePlayer.prevPosX)
					* sprintMultiplicationPlayer);
			float zMultiplicationPlayer = (float) ((mc.thePlayer.posZ - mc.thePlayer.prevPosZ)
					* sprintMultiplicationPlayer);

			if (xMultiplication != 0.0f && zMultiplication != 0.0f
					|| xMultiplicationPlayer != 0.0f && zMultiplicationPlayer != 0.0f) {
				x += xMultiplication + xMultiplicationPlayer;
				z += zMultiplication + zMultiplicationPlayer;
			}
		}

		double angle = MathHelper.sqrt_double(x * x + z * z);

		float yawAngle = (float) (MathHelper.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
		float pitchAngle = (float) (-(MathHelper.atan2(y, angle) * 180.0D / Math.PI));

		double rangeToEntity = mc.thePlayer.getDistanceToEntity(e);
		double rangeSetting = range + 1;

		double rotationDelta = Math.hypot(RotationHook.yaw - yawAngle, RotationHook.pitch - pitchAngle);
		double speed = rotationDelta * ((rangeSetting - rangeToEntity) / rangeSetting);

		float yaw = clampYaw ? yawAngle
				: updateRotation(RotationHook.yaw, yawAngle, smooth ? MathHelper.abs((float) speed) : rotationSpeed);
		float pitch = updateRotation(RotationHook.pitch, pitchAngle,
				smooth ? MathHelper.abs((float) speed) : rotationSpeed);

		if (!mouseFix)
			return new float[] { yaw, clampPitch(pitch) };
		final float[] mouseSensitivity = applyMouseSensitivity(yaw, pitch, a3);

		return new float[] { mouseSensitivity[0], clampPitch(mouseSensitivity[1]) };
	}

	public static float[] applyMouseSensitivity(float yaw, float pitch, boolean a3) {
		float sensitivity = mc.gameSettings.mouseSensitivity;
		if (sensitivity == 0) {
			sensitivity = 0.0070422534F; // 1% Sensitivity <- to fix 0.0 sensitivity
		}
		sensitivity = Math.max(0.1F, sensitivity);
		int deltaYaw = (int) ((yaw - RotationHook.yaw) / (sensitivity / 2));
		int deltaPitch = (int) ((pitch - RotationHook.pitch) / (sensitivity / 2)) * -1;

		if (a3) {
			deltaYaw -= deltaYaw % 0.5 + 0.25;
			deltaPitch -= deltaPitch % 0.5 + 0.25;
		}
		float f = sensitivity * 0.6F + 0.2F;
		float f1 = (float) (Math.pow(f, 3.0) * 8F);
		float f2 = (float) deltaYaw * f1;
		float f3 = (float) deltaPitch * f1;

		float endYaw = (float) ((double) RotationHook.yaw + (double) f2 * 0.15);
		float endPitch = (float) ((double) RotationHook.pitch - (double) f3 * 0.15);
		return new float[] { endYaw, endPitch };
	}

	public static float clampPitch(float pitch) {
		return MathHelper.clamp_float(pitch, -90, 90);
	}

	static float updateRotation(float currentRotation, float nextRotation, float rotationSpeed) {
		float f = MathHelper.wrapAngleTo180_float(nextRotation - currentRotation);
		if (f > rotationSpeed) {
			f = rotationSpeed;
		}
		if (f < -rotationSpeed) {
			f = -rotationSpeed;
		}
		return currentRotation + f;
	}
}
