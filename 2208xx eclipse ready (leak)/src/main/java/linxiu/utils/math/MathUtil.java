/*
 * Decompiled with CFR 0_132.
 */
package linxiu.utils.math;

import linxiu.utils.Helper;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MathUtil {
	public static Random random = new Random();

	public static double toDecimalLength(double in, int places) {
		return Double.parseDouble(String.format("%." + places + "f", in));
	}

	public static double round(double in, int places) {
		places = (int) MathHelper.clamp_double(places, 0.0, 2.147483647E9);
		return Double.parseDouble(String.format("%." + places + "f", in));
	}

	public static boolean parsable(String s, byte type) {
		try {
			switch (type) {
			case 0: {
				Short.parseShort(s);
				break;
			}
			case 1: {
				Byte.parseByte(s);
				break;
			}
			case 2: {
				Integer.parseInt(s);
				break;
			}
			case 3: {
				Float.parseFloat(s);
				break;
			}
			case 4: {
				Double.parseDouble(s);
				break;
			}
			case 5: {
				Long.parseLong(s);
			}
			default: {
				break;
			}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static double square(double in) {
		return in * in;
	}

	public static double randomDouble(double min, double max) {
		return ThreadLocalRandom.current().nextDouble(min, max);
	}

	public static double getRandomInRange(double min, double max) {
		SecureRandom random = new SecureRandom();
		return random.nextDouble() * (max - min) + min;
	}

	public static double getBaseMovementSpeed() {
		double baseSpeed = 0.2873;
		if (Helper.mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
			int amplifier = Helper.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
			baseSpeed *= 1.0 + 0.2 * (double) (amplifier + 1);
		}
		return baseSpeed;
	}

	public static double getHighestOffset(double max) {
		double i = 0.0;
		while (i < max) {
			int[] arrn = new int[5];
			arrn[0] = -2;
			arrn[1] = -1;
			arrn[3] = 1;
			arrn[4] = 2;
			int[] arrn2 = arrn;
			int n = arrn.length;
			int n2 = 0;
			while (n2 < n) {
				int offset = arrn2[n2];
				if (Helper.mc.theWorld.getCollidingBoundingBoxes(Helper.mc.thePlayer,
						Helper.mc.thePlayer.getEntityBoundingBox().offset(Helper.mc.thePlayer.motionX * (double) offset,
								i, Helper.mc.thePlayer.motionZ * (double) offset))
						.size() > 0) {
					return i - 0.01;
				}
				++n2;
			}
			i += 0.01;
		}
		return max;
	}

	public static class NumberType {
		public static final byte SHORT = 0;
		public static final byte BYTE = 1;
		public static final byte INT = 2;
		public static final byte FLOAT = 3;
		public static final byte DOUBLE = 4;
		public static final byte LONG = 5;

		public static byte getByType(Class cls) {
			if (cls == Short.class) {
				return 0;
			}
			if (cls == Byte.class) {
				return 1;
			}
			if (cls == Integer.class) {
				return 2;
			}
			if (cls == Float.class) {
				return 3;
			}
			if (cls == Double.class) {
				return 4;
			}
			if (cls == Long.class) {
				return 5;
			}
			return -1;
		}
	}

	public static boolean inRange(double x, double y, double maxX, double maxY, double minX, double minY) {
		return x > minX && x < maxX && y > minY && y < maxY;
	}

	public static int getRandom(final int min, final int max) {
		if (max < min) {
			return 0;
		}
		return min + random.nextInt((max - min) + 1);
	}

	public static double getRandom(double min, double max) {
		Random random = new Random();
		double range = max - min;
		double scaled = random.nextDouble() * range;
		if (scaled > max) {
			scaled = max;
		}
		double shifted = scaled + min;

		if (shifted > max) {
			shifted = max;
		}
		return shifted;
	}

	public static int getNextPostion(int position, int toPosition, double count) {
		int pos = position;
		if (pos < toPosition) {
			int speed = (int) ((toPosition - pos) / count);
			if (speed < 1) {
				speed = 1;
			}
			pos += speed;
		} else if (pos > toPosition) {
			int speed = (int) ((pos - toPosition) / count);
			if (speed < 1) {
				speed = 1;
			}
			pos -= speed;
		}
		return pos;
	}

	public static Random getRandom() {
		return random;
	}

	public static int randomInt(int min, int max) {
		if (min > max)
			return min;
		return new Random().nextInt(max) + min;
	}

	public static boolean isFloat(final String num) {
		try {
			Float.parseFloat(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static double incValue(double val, double inc) {
		double one = 1.0 / inc;
		return Math.round(val * one) / one;
	}

	public static double roundToHalf(double d) {
		return Math.round(d * 2) / 2.0;
	}

	public static Random rand() {
		return random;
	}

	public static int getRandom_int(int min, int max) {
		if (min > max)
			return min;
		Random RANDOM = new Random();
		return RANDOM.nextInt(max) + min;
	}

	public static double getDifference(double base, double yaw) {
		final double bigger;
		if (base >= yaw)
			bigger = base - yaw;
		else
			bigger = yaw - base;
		return bigger;
	}

	public static double getRandom_double(double min, double max) {
		if (min > max) return min;
		Random RANDOM = new Random();
		return RANDOM.nextDouble() * (max - min) + min;
	}


}
