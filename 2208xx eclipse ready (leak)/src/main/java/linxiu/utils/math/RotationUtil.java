/*
 * Decompiled with CFR 0_132.
 */
package linxiu.utils.math;

import linxiu.api.events.world.EventPacketReceive;
import linxiu.ui.Rotation;
import linxiu.utils.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import java.util.Random;

public class RotationUtil {
	public static float pitch() {
		return Helper.mc.thePlayer.rotationPitch;
	}

	public static void pitch(float pitch) {
		Helper.mc.thePlayer.rotationPitch = pitch;
	}

	public static float yaw() {
		return Helper.mc.thePlayer.rotationYaw;
	}

	public static void yaw(float yaw) {
		Helper.mc.thePlayer.rotationYaw = yaw;
	}

	public static float[] faceTarget(Entity target, float p_706252, float p_706253, boolean miss) {
		double var6;
		double var4 = target.posX - Helper.mc.thePlayer.posX;
		double var8 = target.posZ - Helper.mc.thePlayer.posZ;
		if (target instanceof EntityLivingBase) {
			EntityLivingBase var10 = (EntityLivingBase) target;
			var6 = var10.posY + (double) var10.getEyeHeight()
					- (Helper.mc.thePlayer.posY + (double) Helper.mc.thePlayer.getEyeHeight());
		} else {
			var6 = (target.getEntityBoundingBox().minY + target.getEntityBoundingBox().maxY) / 2.0
					- (Helper.mc.thePlayer.posY + (double) Helper.mc.thePlayer.getEyeHeight());
		}
		Random rnd = new Random();
		double var14 = MathHelper.sqrt_double(var4 * var4 + var8 * var8);
		float var12 = (float) (Math.atan2(var8, var4) * 180.0 / 3.141592653589793) - 90.0f;
		float var13 = (float) (-Math.atan2(var6 - (target instanceof EntityPlayer ? 0.25 : 0.0), var14) * 180.0
				/ 3.141592653589793);
		float pitch = RotationUtil.changeRotation(Helper.mc.thePlayer.rotationPitch, var13, p_706253);
		float yaw = RotationUtil.changeRotation(Helper.mc.thePlayer.rotationYaw, var12, p_706252);
		return new float[] { yaw, pitch };
	}

	public static float changeRotation(float p_706631, float p_706632, float p_706633) {
		float var4 = MathHelper.wrapAngleTo180_float(p_706632 - p_706631);
		if (var4 > p_706633) {
			var4 = p_706633;
		}
		if (var4 < -p_706633) {
			var4 = -p_706633;
		}
		return p_706631 + var4;
	}

	public static float[] getRotationToEntity(Entity entity) {
		double pX = Minecraft.getMinecraft().thePlayer.posX;
		double pY = Minecraft.getMinecraft().thePlayer.posY
				+ (double) Minecraft.getMinecraft().thePlayer.getEyeHeight();
		double pZ = Minecraft.getMinecraft().thePlayer.posZ;
		double eX = entity.posX;
		double eY = entity.posY + (double) entity.getEyeHeight();
		double eZ = entity.posZ;
		double dX = pX - eX;
		double dY = pY - eY;
		double dZ = pZ - eZ;
		double dH = Math.sqrt(Math.pow(dX, 2.0D) + Math.pow(dZ, 2.0D));
		float yaw = 0.0F;
		float pitch = 0.0F;
		yaw = (float) (Math.toDegrees(Math.atan2(dZ, dX)) + 90.0D);
		pitch = (float) Math.toDegrees(Math.atan2(dH, dY));
		return new float[] { yaw, 90.0F - pitch };
	}

	public static float[] getRotations(Entity entity) {
		double diffY;
		if (entity == null) {
			return null;
		}
		double diffX = entity.posX - Helper.mc.thePlayer.posX;
		double diffZ = entity.posZ - Helper.mc.thePlayer.posZ;
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase elb = (EntityLivingBase) entity;
			diffY = elb.posY + ((double) elb.getEyeHeight() - 0.4)
					- (Helper.mc.thePlayer.posY + (double) Helper.mc.thePlayer.getEyeHeight());
		} else {
			diffY = (entity.getCollisionBoundingBox().minY + entity.getCollisionBoundingBox().maxY) / 2.0
					- (Helper.mc.thePlayer.posY + (double) Helper.mc.thePlayer.getEyeHeight());
		}
		double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / 3.141592653589793) - 90.0f;
		float pitch = (float) (-Math.atan2(diffY, dist) * 180.0 / 3.141592653589793);
		return new float[] { yaw, pitch };
	}

	public static float[] grabBlockRotations(BlockPos pos) {
		return RotationUtil.getVecRotation(
				Helper.mc.thePlayer.getPositionVector().addVector(0.0, Helper.mc.thePlayer.getEyeHeight(), 0.0),
				new Vec3((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5));
	}

	public static float[] getVecRotation(Vec3 position) {
		return RotationUtil.getVecRotation(
				Helper.mc.thePlayer.getPositionVector().addVector(0.0, Helper.mc.thePlayer.getEyeHeight(), 0.0),
				position);
	}

	public static Vec3 flat(Vec3 v) {
		return new Vec3(v.xCoord, 0.0, v.zCoord);
	}

	public static float[] getVecRotation(Vec3 origin, Vec3 position) {
		Vec3 difference = position.subtract(origin);
		double distance = flat(difference).lengthVector();
		float yaw = (float) Math.toDegrees(Math.atan2(difference.zCoord, difference.xCoord)) - 90.0f;
		float pitch = (float) (-Math.toDegrees(Math.atan2(difference.yCoord, distance)));
		return new float[] { yaw, pitch };
	}

	public static int wrapAngleToDirection(float yaw, int zones) {
		int angle = (int) ((double) (yaw + (float) (360 / (2 * zones))) + 0.5) % 360;
		if (angle < 0) {
			angle += 360;
		}
		return angle / (360 / zones);
	}

	public static boolean canEntityBeSeen(Entity e) {
		Vec3 vec1 = new Vec3(Helper.mc.thePlayer.posX, Helper.mc.thePlayer.posY + Helper.mc.thePlayer.getEyeHeight(),
				Helper.mc.thePlayer.posZ);

		AxisAlignedBB box = e.getEntityBoundingBox();
		Vec3 vec2 = new Vec3(e.posX, e.posY + (e.getEyeHeight() / 1.32F), e.posZ);
		double minx = e.posX - 0.25;
		double maxx = e.posX + 0.25;
		double miny = e.posY;
		double maxy = e.posY + Math.abs(e.posY - box.maxY);
		double minz = e.posZ - 0.25;
		double maxz = e.posZ + 0.25;
		boolean see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;
		if (see)
			return true;
		vec2 = new Vec3(maxx, miny, minz);
		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;
		if (see)
			return true;
		vec2 = new Vec3(minx, miny, minz);
		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;

		if (see)
			return true;
		vec2 = new Vec3(minx, miny, maxz);
		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;
		if (see)
			return true;
		vec2 = new Vec3(maxx, miny, maxz);
		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;
		if (see)
			return true;

		vec2 = new Vec3(maxx, maxy, minz);
		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;

		if (see)
			return true;
		vec2 = new Vec3(minx, maxy, minz);

		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;
		if (see)
			return true;
		vec2 = new Vec3(minx, maxy, maxz - 0.1);
		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;
		if (see)
			return true;
		vec2 = new Vec3(maxx, maxy, maxz);
		see = Helper.mc.theWorld.rayTraceBlocks(vec1, vec2) == null;
		return see;
	}

	public static float getYawDifference(float currentYaw, double targetX, double targetY, double targetZ) {
		double deltaX = targetX - Helper.mc.thePlayer.posX;
		double deltaY = targetY - Helper.mc.thePlayer.posY;
		double deltaZ = targetZ - Helper.mc.thePlayer.posZ;
		double yawToEntity = 0;
		double degrees = Math.toDegrees(Math.atan(deltaZ / deltaX));
		if ((deltaZ < 0.0D) && (deltaX < 0.0D)) {
			if (deltaX != 0)
				yawToEntity = 90.0D + degrees;
		} else if ((deltaZ < 0.0D) && (deltaX > 0.0D)) {
			if (deltaX != 0)
				yawToEntity = -90.0D + degrees;
		} else {
			if (deltaZ != 0)
				yawToEntity = Math.toDegrees(-Math.atan(deltaX / deltaZ));
		}
		return MathHelper.wrapAngleTo180_float(-(currentYaw - (float) yawToEntity));
	}

	public static float[] getRotationBlock(BlockPos pos) {
		return getRotationsByVec(
				Helper.mc.thePlayer.getPositionVector().addVector(0.0D, Helper.mc.thePlayer.getEyeHeight(), 0.0D),
				new Vec3((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D));
	}

	public static float[] m(BlockPos array) {
		Vec3 o = (new Vec3((double)array.getX() + 0.5D, (double) array.getY() + 0.5D,
				(double) array.getZ() + 0.5D))
				.subtract(Helper.mc.thePlayer.getPositionVector().addVector(0.0D, Helper.mc.thePlayer.getEyeHeight(), 0.0D));

		double q = flat(o).lengthVector();
		final float n = (float) Math.toDegrees(Math.atan2(o.zCoord, o.xCoord)) - 90.0f;
		float n2 = (float) (-Math.toDegrees(Math.atan2(o.yCoord, q)));
		if (n2 > 90.0f) {
			n2 = 90.0f;
		}
		if (n2 < -90.0f) {
			n2 = -90.0f;
		}
		return new float[] { n, n2 };
	}

	private static float[] getRotationsByVec(Vec3 origin, Vec3 position) {
		Vec3 difference = position.subtract(origin);
		double distance = flat(difference).lengthVector();
		float yaw = (float) Math.toDegrees(Math.atan2(difference.zCoord, difference.xCoord)) - 90.0f;
		float pitch = (float) (-Math.toDegrees(Math.atan2(difference.yCoord, distance)));
		float llllllllllllIlIIlIIlIlIlIIIlIIIl = Helper.mc.thePlayer.renderYawOffset
				+ MathHelper.wrapAngleTo180_float(yaw - Helper.mc.thePlayer.renderYawOffset);
		return new float[] { yaw, MathHelper.clamp_float(pitch, -90.0F, 90.0F), llllllllllllIlIIlIIlIlIlIIIlIIIl };
	}

	public static float getDistanceBetweenAngles(float angle1, float angle2) {
		float angle = Math.abs(angle1 - angle2) % 360.0f;
		if (angle > 180.0f) {
			angle = 360.0f - angle;
		}
		return angle;
	}

	public static float[] getAngles(EntityLivingBase entity) {
		if (entity == null)
			return null;
		final EntityPlayerSP player = Helper.mc.thePlayer;

		final double diffX = entity.posX - player.posX,
				diffY = entity.posY + entity.getEyeHeight() * 0.9 - (player.posY + player.getEyeHeight()),
				diffZ = entity.posZ - player.posZ, dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ); // @on

		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F,
				pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / Math.PI);

		return new float[] { player.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - player.rotationYaw),
				player.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - player.rotationPitch) };
	}

	public static float Random(EntityLivingBase ent) {
		int tick;
		int[] stage = { 2, 4, 6, 8, 10 };
		float Random = 0.0f;
		boolean yes = false;
		for (tick = 0; tick < 10; tick++) {
			if (ent.hurtTime <= stage[0])
				tick = stage[0];
			if (ent.hurtTime <= stage[1])
				tick = stage[1];
			if (ent.hurtTime <= stage[2])
				tick = stage[2];
			if (ent.hurtTime <= stage[3])
				tick = stage[3];
			if (ent.hurtTime <= stage[4])
				tick = stage[4];
			if (tick <= 2)
				Random = (float) (Math.random() * -0.05f);
			if (tick <= 4)
				Random = 0.0f;
			if (tick <= 6)
				Random = 0.0f;
			if (tick <= 8)
				Random = 0.0f;
			if (tick <= 10)
				Random = (float) (Math.random() * 0.05f);
		}
		if (Random > 1) {
			Random = 0.0f;
		}
		return Random;
	}

	public static float[] getRotations1(EntityLivingBase ent) {
		double x = ent.posX;
		double z = ent.posZ;
		double y = ent.posY + (ent.getEyeHeight() / 2.0F);
		Vec3 enemyCoords = new Vec3(ent.posX, y, ent.posZ);
		Vec3 myCoords = new Vec3(Helper.mc.thePlayer.posX, Helper.mc.thePlayer.posY + 1.35 + Random(ent) * 10,
				Helper.mc.thePlayer.posZ);
		return getVecRotation(myCoords, enemyCoords);
	}

	public static double[] getDistance(double x, double z, double y) {
		final double distance = MathHelper.sqrt_double(x * x + z * z), // @off
				yaw = Math.atan2(z, x) * 180.0D / Math.PI - 90.0F,
				pitch = -(Math.atan2(y, distance) * 180.0D / Math.PI); // @on

		return new double[] {
				Helper.mc.thePlayer.rotationYaw
						+ MathHelper.wrapAngleTo180_float((float) (yaw - Helper.mc.thePlayer.rotationYaw)),
				Helper.mc.thePlayer.rotationPitch
						+ MathHelper.wrapAngleTo180_float((float) (pitch - Helper.mc.thePlayer.rotationPitch)) };
	}

	public static boolean serverRotate(EventPacketReceive event, Rotation customRotation) {
		// ��ȡ���ݰ�
		final Packet<?> packet = EventPacketReceive.getPacket();

		// �ж��Ƿ�Ϊ�հ�

		// �ж����ݰ�����
		if (packet instanceof S08PacketPlayerPosLook) {
			S08PacketPlayerPosLook s08PacketPlayerPosLook = (S08PacketPlayerPosLook) packet;
			float yaw = s08PacketPlayerPosLook.getYaw();
			float pitch = s08PacketPlayerPosLook.getPitch();
			// �޸����ݰ�
			yaw = customRotation.getYaw();
			pitch = customRotation.getPitch();
			event.setPacket(s08PacketPlayerPosLook);
			return true;

		}
		return false;
	}

	public static float[] getRotations(double posX, double posY, double posZ) {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		double x = posX - player.posX;
		double y = posY - (player.posY + (double) player.getEyeHeight());
		double z = posZ - player.posZ;
		double dist = MathHelper.sqrt_double(x * x + z * z);
		float yaw = (float) (Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
		float pitch = (float) -(Math.atan2(y, dist) * 180.0D / Math.PI);
		return new float[] { yaw, pitch };
	}

	public static Rotation getRotationFromEyeHasPrev(double x, double y, double z) {
		double xDiff = x - (Minecraft.getMinecraft().thePlayer.prevPosX
				+ (Minecraft.getMinecraft().thePlayer.posX - Minecraft.getMinecraft().thePlayer.prevPosX));
		double yDiff = y - ((Minecraft.getMinecraft().thePlayer.prevPosY
				+ (Minecraft.getMinecraft().thePlayer.posY - Minecraft.getMinecraft().thePlayer.prevPosY))
				+ (Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().maxY
						- Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY));
		double zDiff = z - (Minecraft.getMinecraft().thePlayer.prevPosZ
				+ (Minecraft.getMinecraft().thePlayer.posZ - Minecraft.getMinecraft().thePlayer.prevPosZ));
		final double dist = MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
		return new Rotation((float) (Math.atan2(zDiff, xDiff) * 180D / Math.PI) - 90F,
				(float) -(Math.atan2(yDiff, dist) * 180D / Math.PI));
	}

	public static float getRotationDifference(float current, float target) {
		return MathHelper.wrapAngleTo180_float(target - current);
	}

	private static float getAngleDifference(final float a, final float b) {
		return ((((a - b) % 360F) + 540F) % 360F) - 180F;
	}

	public static Rotation getRotationFromEyeHasPrev(EntityLivingBase target) {
		final double x = (target.prevPosX + (target.posX - target.prevPosX));
		final double y = (target.prevPosY + (target.posY - target.prevPosY));
		final double z = (target.prevPosZ + (target.posZ - target.prevPosZ));
		return getRotationFromEyeHasPrev(x, y, z);
	}

}
