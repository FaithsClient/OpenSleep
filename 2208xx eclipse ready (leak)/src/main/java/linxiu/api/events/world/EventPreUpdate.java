/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.events.world;

import java.util.Objects;

import linxiu.api.Event;
import linxiu.injection.interfaces.IEntityLivingBase;
import linxiu.utils.Helper;

public class EventPreUpdate extends Event {
	public static float yaw;
	public static float pitch;
	public double x;
	public static double y;
	public double z;
	public static boolean ground;
	private boolean alwaysSend;
	private final boolean isPre;
	public static float prevYaw;
	public static float prevPitch;

	public EventPreUpdate(float prevYaw, float prevPitch, float yaw2, float pitch2, double x, double y, double z,
			boolean ground) {
		yaw = yaw2;
		pitch = pitch2;
		this.x = x;
		EventPreUpdate.y = y;
		this.z = z;
		EventPreUpdate.ground = ground;
		EventPreUpdate.prevPitch = prevPitch;
		EventPreUpdate.prevYaw = prevYaw;
		this.isPre = true;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		EventPreUpdate.yaw = yaw;
		Helper.mc.thePlayer.rotationYawHead = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		EventPreUpdate.pitch = pitch;
		((IEntityLivingBase) Helper.mc.thePlayer).setrotationPitchHead(pitch);
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public static void setY(double y2) {
		y = y2;
	}

	public boolean isOnground() {
		return ground;
	}

	public static void setOnground(boolean ground2) {
		ground = ground2;
	}
}
