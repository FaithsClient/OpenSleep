package linxiu.utils.targeth;

import linxiu.utils.RenderUtil;

public class AnimationUtils {

	public static float Animation(float lastUpdate, float now, float desired, float speed) {

		float difference = Math.abs(desired - now);
		double AnimationSpeed = (difference * speed / 100) * RenderUtil.deltaTime;
		float animation = now;

		System.out.println(difference);

		if (lastUpdate < desired) {
			animation += Math.max(0.05f, AnimationSpeed);
			if (animation >= desired)
				animation = desired;
		}

		if (lastUpdate > desired) {
			animation -= Math.max(0.05f, AnimationSpeed);
			if (animation <= desired)
				animation = desired;
		}

		return animation;
	}
}
