package linxiu.utils.targeth;

public class Translate {


	float x = 0f;
	float y = 0f;
	float z = 0f;

	private float lastUpdateX = 0f;
	private float lastUpdateY = 0f;
	private float lastUpdateZ = 0f;
	private float lastUpdateTargetX = 0f;
	private float lastUpdateTargetY = 0f;
	private float lastUpdateTargetZ = 0f;

	public void Update(float targetX, float targetY, float targetZ) {
		if (x == 0f || x == targetX || lastUpdateTargetX != targetX) {
			lastUpdateX = x;
			lastUpdateTargetX = targetX;
		}
		if (y == 0f || y == targetY || lastUpdateTargetY != targetY) {
			lastUpdateY = y;
			lastUpdateTargetY = targetY;
		}
		if (z == 0f || z == targetZ || lastUpdateTargetZ != targetZ) {
			lastUpdateZ = z;
			lastUpdateTargetZ = targetZ;
		}
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public void tanslate(float targetX, float targetY) {
		Update(targetX, targetY, 0f);
		x = AnimationUtils.Animation(lastUpdateX, x, targetX, 1f);
		y = AnimationUtils.Animation(lastUpdateY, y, targetY, 1f);
	}

	public void tanslate(float targetX, float targetY, float speed) {
		Update(targetX, targetY, 0f);
		x = AnimationUtils.Animation(lastUpdateX, x, targetX, speed);
		y = AnimationUtils.Animation(lastUpdateY, y, targetY, speed);
	}

	public void tanslate(float targetX, float targetY, float speedX, float speedY) {
		Update(targetX, targetY, 0f);
		x = AnimationUtils.Animation(lastUpdateX, x, targetX, speedX);
		y = AnimationUtils.Animation(lastUpdateY, y, targetY, speedY);
	}

	public void tanslate(float targetX, float targetY, float targetZ, float speedX, float speedY, float speedZ) {
		Update(targetX, targetY, targetZ);
		x = AnimationUtils.Animation(lastUpdateX, x, targetX, speedX);
		y = AnimationUtils.Animation(lastUpdateY, y, targetY, speedY);
		z = AnimationUtils.Animation(lastUpdateZ, z, targetZ, speedZ);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}
}
