package linxiu.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public final class MathUtils {
	public static int randomNumber(int max, int min) {
		return (int) (Math.random() * (double) (max - min)) + min;
	}

	public static double roundToPlace(double value, int places) {
		if (places < 0) {
			return value;
		} else {
			BigDecimal bd = new BigDecimal(value);
			bd = bd.setScale(places, RoundingMode.HALF_UP);
			return bd.doubleValue();
		}
	}

	public static double getIncremental(double val, double inc) {
		double one = 1.0D / inc;
		return (double) Math.round(val * one) / one;
	}

	public static boolean isInteger(Double variable) {
		return variable.doubleValue() == Math.floor(variable.doubleValue())
				&& !Double.isInfinite(variable.doubleValue());
	}

	public static float clampValue(final float value, final float floor, final float cap) {
		if (value < floor) {
			return floor;
		}
		return Math.min(value, cap);
	}
	public static int randomInt(int min, int max) {
		if(min > max) return min;
		return new Random().nextInt(max) + min;
	}
	public static int clampValue(final int value, final int floor, final int cap) {
		if (value < floor) {
			return floor;
		}
		return Math.min(value, cap);
	}

	public static double round(final double value, final double inc) {
		if (inc == 0.0)
			return value;
		else if (inc == 1.0)
			return Math.round(value);
		else {
			final double halfOfInc = inc / 2.0;
			final double floored = Math.floor(value / inc) * inc;

			if (value >= floored + halfOfInc)
				return new BigDecimal(Math.ceil(value / inc) * inc).doubleValue();
			else
				return new BigDecimal(floored).doubleValue();
		}
	}

    public static float calculateGaussianValue(float x, float sigma) {
        double PI = 3.141592653;
        double output = 1.0 / Math.sqrt(2.0 * PI * (sigma * sigma));
        return (float) (output * Math.exp(-(x * x) / (2.0 * (sigma * sigma))));
    }

    public static Double interpolate(double oldValue, double newValue, double interpolationValue){
        return (oldValue + (newValue - oldValue) * interpolationValue);
    }

    public static float interpolateFloat(float oldValue, float newValue, double interpolationValue){
        return interpolate(oldValue, newValue, (float) interpolationValue).floatValue();
    }
}
