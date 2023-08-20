
package linxiu.api.events.misc;

import linxiu.api.Event;
import net.minecraft.client.Minecraft;

public class StrafeEvent extends Event {

	private static final Minecraft mc = Minecraft.getMinecraft();
	private float strafe;
	private float forward;
	private float friction;
	private final float yaw;

	public StrafeEvent(float strafe, float forward, float friction, float yaw) {
		this.strafe = strafe;
		this.forward = forward;
		this.friction = friction;
        this.yaw = yaw;
	}

	public float getStrafe() {
		return strafe;
	}

	public void setStrafe(float strafe) {
		this.strafe = strafe;
	}

	public float getForward() {
		return forward;
	}

	public void setForward(float forward) {
		this.forward = forward;
	}

	public float getFriction() {
		return friction;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}

	public void setMotionPartialStrafe(float friction, float strafeComponent) {
		float remainder = 1F - strafeComponent;
		if (forward != 0 && strafe != 0)
			friction *= 0.91;
		if (mc.thePlayer.onGround) {
			setMotion(friction);
		} else {
			mc.thePlayer.motionX *= strafeComponent;
			mc.thePlayer.motionZ *= strafeComponent;
			setFriction(friction * remainder);
		}
	}

	public void setMotion(double speed) {
		mc.thePlayer.motionX = 0;
		mc.thePlayer.motionZ = 0;
		speed *= strafe != 0 && forward != 0 ? 0.91 : 1;
		setFriction((float) speed);
	}

	public float getYaw() {
		return yaw;
	}
}
