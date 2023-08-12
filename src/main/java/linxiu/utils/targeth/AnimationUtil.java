package linxiu.utils.targeth;

import linxiu.utils.RenderUtil;

public class AnimationUtil {

    public static float moveUD(float current, float end, float smoothSpeed, float minSpeed) {
        float movement = (end - current) * smoothSpeed;
        if (movement > 0) {
            movement = Math.max(minSpeed, movement);
            movement = Math.min(end - current, movement);
        } else if (movement < 0) {
            movement = Math.min(-minSpeed, movement);
            movement = Math.max(end - current, movement);
        }
        return current + movement;
    }


	public static float lstransition(float now, float desired, double speed) {

		final double dif = Math.abs(desired - now);

		float a = (float) Math.abs((desired - (desired - (Math.abs(desired - now)))) / (100 - (speed * 10)));

		float x = now;

		if (dif != 0 && dif < a)
			a = (float) dif;

		if (dif > 0) {
			if (now < desired) {
				x += a * RenderUtil.deltaTime;
			} else if (now > desired) {
				x -= a * RenderUtil.deltaTime;
			}
		} else {
			x = desired;
		}

		if(Math.abs(desired - x) < 0.05 && x != desired) {
			x = desired;
		}
		return x;
	}

    public static float calculateCompensation(float target, float current, long delta, int speed) {
        float diff = current - target;
        if (delta < 1L) {
            delta = 1L;
        }

        double xD;
        if (diff > (float) speed) {
            xD = (double) ((long) speed * delta / 16L) < 0.25D ? 0.5D : (double) ((long) speed * delta / 16L);
            current = (float) ((double) current - xD);
            if (current < target) {
                current = target;
            }
        } else if (diff < (float) (-speed)) {
            xD = (double) ((long) speed * delta / 16L) < 0.25D ? 0.5D : (double) ((long) speed * delta / 16L);
            current = (float) ((double) current + xD);
            if (current > target) {
                current = target;
            }
        } else {
            current = target;
        }

        return current;
    }

    public static float calculateCompensation(float target, float current, long delta, double speed) {
        float diff = current - target;
        if (delta < 1) {
            delta = 1;
        }
        if (delta > 1000) {
            delta = 16;
        }
        if (diff > speed) {
            double xD = (Math.max(speed * delta / (1000 / 60), 0.5));
            current -= xD;
            if (current < target) {
                current = target;
            }
        } else if (diff < -speed) {
            double xD = (Math.max(speed * delta / (1000 / 60), 0.5));
            current += xD;
            if (current > target) {
                current = target;
            }
        } else {
            current = target;
        }
        return current;
    }
}