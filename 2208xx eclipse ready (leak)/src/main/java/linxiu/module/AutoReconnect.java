/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module;

public class AutoReconnect {
	public final static double MAX = 60000;
	public final static double MIN = 1000;

	public static boolean isEnabled = true;
	public static float delay = 5000;

	public AutoReconnect(float value) {
		isEnabled = value < MAX;
		delay = value;
	}

	public static float getDelay() {
		return delay;
	}
	
    public static void setDelay(float packet) {
        delay = packet;
    }
	
	public static boolean isEnabled() {
		return isEnabled;
	}
}