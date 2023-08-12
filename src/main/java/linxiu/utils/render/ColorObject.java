/*
 * Decompiled with CFR 0.146.
 */
package linxiu.utils.render;

public class ColorObject {
	public static int red;
	public static int green;
	public static int blue;
	public int alpha;

	public ColorObject(int red, int green, int blue, int alpha) {
		ColorObject.red = red;
		ColorObject.green = green;
		ColorObject.blue = blue;
		this.alpha = alpha;
	}

	public static int getRed() {
		return red;
	}

	public static int getGreen() {
		return green;
	}

	public static int getBlue() {
		return blue;
	}

	public int getAlpha() {
		return this.alpha;
	}

	public void setRed(int red) {
		ColorObject.red = red;
	}

	public void setGreen(int green) {
		ColorObject.green = green;
	}

	public void setBlue(int blue) {
		ColorObject.blue = blue;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public void updateColors(int red, int green, int blue, int alpha) {
		ColorObject.red = red;
		ColorObject.green = green;
		ColorObject.blue = blue;
		this.alpha = alpha;
	}
}
