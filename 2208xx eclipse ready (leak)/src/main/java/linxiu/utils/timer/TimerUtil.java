/*
 * Decompiled with CFR 0_132.
 */
package linxiu.utils.timer;

public class TimerUtil {
	public long lastMS = System.currentTimeMillis();

	public void reset() {
		this.lastMS = System.currentTimeMillis();
	}

	public boolean hasTimeElapsed(long time, boolean reset) {
		if (System.currentTimeMillis() - this.lastMS > time) {
			if (reset) {
				this.reset();
			}
			return true;
		}
		return false;
	}

	public boolean hasTimeElapsed(double time, boolean reset) {
		if (System.currentTimeMillis() - this.lastMS > time) {
			if (reset) {
				this.reset();
			}
			return true;
		}
		return false;
	}

	public boolean hasTimeElapsed(long time) {
		return System.currentTimeMillis() - this.lastMS > time;
	}

	public long getTime() {
		return System.currentTimeMillis() - this.lastMS;
	}

	public void setTime(long time) {
		this.lastMS = time;
	}

	public boolean delay(float milliSec) {
		return (float) (this.getTime() - this.lastMS) >= milliSec;
	}

	public boolean delay(Double milliSec) {
		return (float) (this.getTime() - this.lastMS) >= milliSec;
	}

	private long getCurrentMS() {
		return System.nanoTime() / 1000000L;
	}

	public boolean hasReached(double milliseconds) {
		return (double) (this.getCurrentMS() - this.lastMS) >= milliseconds;
	}
}