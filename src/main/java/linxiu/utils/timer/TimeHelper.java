package linxiu.utils.timer;

public class TimeHelper {
	public long lastMs;

	public long prevMS;

	public TimeHelper() {
		this.lastMs = 0L;
	}

	public boolean isDelayComplete(final long delay) {

		return System.currentTimeMillis() - this.lastMs > delay;
	}

	public long getCurrentMS() {
		return System.nanoTime() / 1000000L;
	}

	public void reset() {
		this.lastMs = System.currentTimeMillis();
	}

	public long getLastMs() {
		return this.lastMs;
	}

	public void setLastMs(final int i) {
		this.lastMs = System.currentTimeMillis() + i;
	}

	public boolean hasReached(final long milliseconds) {
		return this.getCurrentMS() - this.lastMs >= milliseconds;
	}

	public boolean isDelayComplete(float delay) {
		return System.currentTimeMillis() - this.lastMs > delay;
	}

	public boolean isDelayComplete(Double delay) {
		return System.currentTimeMillis() - this.lastMs > delay;
	}

	public boolean reach(final long milliseconds) {
		return System.currentTimeMillis() - this.lastMs >= milliseconds;
	}

	public long getTime() {
		return System.nanoTime() / 1000000L;
	}

	public boolean check(float milliseconds) {
		return getTime() >= milliseconds;
	}

	public boolean reach(final double milliseconds) {
		return System.currentTimeMillis() - this.lastMs >= milliseconds;
	}

	public long elapsed() {
		return System.currentTimeMillis() - this.lastMs;
	}

	public boolean delay(float var1) {
		return (float) (this.getTime() - this.prevMS) >= var1;
	}

	public boolean delay(float nextDelay, boolean reset) {
		if (System.currentTimeMillis() - lastMs >= nextDelay) {
			if (reset) {
				this.reset();
			}
			return true;
		}
		return false;
	}

    public boolean hasReached(double milliseconds) {
        if ((double)(this.getCurrentMS() - this.lastMs) >= milliseconds) {
            return true;
        }
        return false;
    }
}