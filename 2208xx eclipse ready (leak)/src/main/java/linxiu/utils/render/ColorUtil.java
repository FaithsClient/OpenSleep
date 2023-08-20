package linxiu.utils.render;

import com.ibm.icu.text.NumberFormat;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.regex.Pattern;

public class ColorUtil {

	public static final String COLORRESET = "\2477";

	public static Color getRainbow(float second, float sat, float bright) {
		float hue = (System.currentTimeMillis() % (int) (second * 1000)) / (second * 1000);
		return new Color(Color.HSBtoRGB(hue, sat, bright));
	}

	public static Color getRainbow(float second, float sat, float bright, long index) {
		float hue = ((System.currentTimeMillis() + index) % (int) (second * 1000)) / (second * 1000);
		return new Color(Color.HSBtoRGB(hue, sat, bright));
	}

	public static Color getFadeRainbow(Color color, int index, int count) {
		float[] hsb = new float[3];
		Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
		float brightness = Math.abs(
				((float) (System.currentTimeMillis() % 2000L) / 1000.0f + (float) index / (float) count * 2.0f) % 2.0f
						- 1.0f);
		brightness = 0.5f + 0.5f * brightness;
		hsb[2] = brightness % 2.0f;
		return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
	}

	public static Color getBlendColor(double current, double max) {
		long base = Math.round(max / 5);
		if (current >= base * 5)
			return new Color(15, 255, 15);
		else if (current >= base * 4)
			return new Color(166, 255, 0);
		else if (current >= base * 3)
			return new Color(255, 191, 0);
		else if (current >= base * 2)
			return new Color(255, 89, 0);
		else
			return new Color(255, 0, 0);
	}

	public static Color getDarker(Color before, int dark, int alpha) {
		int rDank = Math.max(before.getRed() - dark, 0);
		int gDank = Math.max(before.getGreen() - dark, 0);
		int bDank = Math.max(before.getBlue() - dark, 0);
		return new Color(rDank, gDank, bDank, alpha);
	}

	public static Color getLighter(Color before, int light, int alpha) {
		int rDank = Math.min(before.getRed() + light, 255);
		int gDank = Math.min(before.getGreen() + light, 255);
		int bDank = Math.min(before.getBlue() + light, 255);
		return new Color(rDank, gDank, bDank, alpha);
	}

    public static void glColor(int color) {
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;
        float alpha = (color >> 24 & 0xFF) / 255.0F;
        GL11.glColor4f(red, green, blue, alpha);
    }

	public static Color reAlpha(Color before, int alpha) {
		return new Color(before.getRed(), before.getGreen(), before.getBlue(), alpha);
	}

	public static int getColor(int red, int green, int blue, int alpha) {
		int color = 0;
		color |= alpha << 24;
		color |= red << 16;
		color |= green << 8;
		return color |= blue;
	}

	public static int getColor(int brightness) {
		return ColorUtil.getColor(brightness, brightness, brightness, 255);
	}

	public static Color rainbow(long time, float count, float fade) {
		float hue = (time + (1 + count) * 2.0E8f) / 1.0E10f % 1.0f;
		long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, 0.7f, 1.0f)), 16);
		Color c = new Color((int) color);
		return new Color((float) c.getRed() / 255.0f * fade, (float) c.getGreen() / 255.0f * fade,
				(float) c.getBlue() / 255.0f * fade, (float) c.getAlpha() / 255.0f);
	}

	public static Color blend(final Color color1, final Color color2, final double ratio) {
		final float r = (float) ratio;
		final float ir = 1.0f - r;
		final float[] rgb1 = new float[3];
		final float[] rgb2 = new float[3];
		color1.getColorComponents(rgb1);
		color2.getColorComponents(rgb2);
		float red = rgb1[0] * r + rgb2[0] * ir;
		float green = rgb1[1] * r + rgb2[1] * ir;
		float blue = rgb1[2] * r + rgb2[2] * ir;
		if (red < 0.0f) {
			red = 0.0f;
		} else if (red > 255.0f) {
			red = 255.0f;
		}
		if (green < 0.0f) {
			green = 0.0f;
		} else if (green > 255.0f) {
			green = 255.0f;
		}
		if (blue < 0.0f) {
			blue = 0.0f;
		} else if (blue > 255.0f) {
			blue = 255.0f;
		}
		Color color3 = null;
		try {
			color3 = new Color(red, green, blue);
		} catch (final IllegalArgumentException exp) {
			final NumberFormat nf = NumberFormat.getNumberInstance();
			// System.out.println(nf.format(red) + "; " + nf.format(green) + ";
			// " + nf.format(blue));
			exp.printStackTrace();
		}
		return color3;
	}

	public static Color blendColors(final float[] fractions, final Color[] colors, final float progress) {
		if (fractions == null) {
			throw new IllegalArgumentException("Fractions can't be null");
		}
		if (colors == null) {
			throw new IllegalArgumentException("Colours can't be null");
		}
		if (fractions.length == colors.length) {
			final int[] getFractionBlack = getFraction(fractions, progress);
			final float[] range = new float[] { fractions[getFractionBlack[0]], fractions[getFractionBlack[1]] };
			final Color[] colorRange = new Color[] { colors[getFractionBlack[0]], colors[getFractionBlack[1]] };
			final float max = range[1] - range[0];
			final float value = progress - range[0];
			final float weight = value / max;
			return blend(colorRange[0], colorRange[1], 1.0f - weight);
		}
		throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
	}

	public static int[] getFraction(final float[] fractions, final float progress) {
		int startPoint;
		final int[] range = new int[2];
		for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; ++startPoint) {
		}
		if (startPoint >= fractions.length) {
			startPoint = fractions.length - 1;
		}
		range[0] = startPoint - 1;
		range[1] = startPoint;
		return range;
	}

	public static int interpolateColor(Color color1, Color color2, float amount) {
		amount = Math.min(1, Math.max(0, amount));
		return interpolateColorC(color1, color2, amount).getRGB();
	}

	public static int interpolateColor(int color1, int color2, float amount) {
		amount = Math.min(1, Math.max(0, amount));
		Color cColor1 = new Color(color1);
		Color cColor2 = new Color(color2);
		return interpolateColorC(cColor1, cColor2, amount).getRGB();
	}

	public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
		return (oldValue + (newValue - oldValue) * interpolationValue);
	}

	public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
		return interpolate(oldValue, newValue, (float) interpolationValue).floatValue();
	}

	public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
		return interpolate(oldValue, newValue, (float) interpolationValue).intValue();
	}

	public static Color interpolateColorC(Color color1, Color color2, float amount) {
		amount = Math.min(1, Math.max(0, amount));
		return new Color(interpolateInt(color1.getRed(), color2.getRed(), amount),
				interpolateInt(color1.getGreen(), color2.getGreen(), amount),
				interpolateInt(color1.getBlue(), color2.getBlue(), amount),
				interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
	}

	public static Color interpolateColorHue(Color color1, Color color2, float amount) {
		amount = Math.min(1, Math.max(0, amount));

		float[] color1HSB = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
		float[] color2HSB = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);

		Color resultColor = Color.getHSBColor(interpolateFloat(color1HSB[0], color2HSB[0], amount),
				interpolateFloat(color1HSB[1], color2HSB[1], amount),
				interpolateFloat(color1HSB[2], color2HSB[2], amount));

		return new Color(resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue(),
				interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
	}

	public static Color interpolateColorsBackAndForth(int speed, int index, Color start, Color end, boolean trueColor) {
		int angle = (int) (((System.currentTimeMillis()) / speed + index) % 360);
		angle = (angle >= 180 ? 360 - angle : angle) * 2;
		return trueColor ? ColorUtil.interpolateColorHue(start, end, angle / 360f)
				: ColorUtil.interpolateColorC(start, end, angle / 360f);
	}

	private static final Pattern COLOR_PATTERN = Pattern.compile("(?i)ยง[0-9A-FK-OR]");

	public static String stripColor(String input) {
		return COLOR_PATTERN.matcher(input).replaceAll("");
	}
}
