package linxiu.api.events;

public class Rotation {
    private final float rotationYaw;
    private final float rotationPitch;

	public Rotation(float yaw, float pitch) {
		rotationYaw = yaw;
		rotationPitch = pitch;
	}

	public float getRotationYaw() {
		return rotationYaw;
	}
	
	public float getRotationPitch() {
		return rotationPitch;
	}
}