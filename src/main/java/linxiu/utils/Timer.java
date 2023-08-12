package linxiu.utils;

public class Timer {
	private long prevMS = 0L;
	private final long time;

	public long lastMS = System.currentTimeMillis();

	public Timer() {
		this.time = System.nanoTime() / 1000000L;
	}

	public boolean delay(float milliSec) {
		return (float) MathUtils.getIncremental((double) (this.getTime() - this.prevMS), 50.0D) >= milliSec;
	}

	public boolean hasTimeElapsed(long time, boolean reset) {
		if (System.currentTimeMillis() - lastMS > time) {
			if (reset)
				reset();
			return true;
		}

		return false;
	}

	public void reset() {
		this.prevMS = this.getTime();
	}

	public long getTime() {
		return System.nanoTime() / 1000000L;
	}

	public long getDifference() {
		return this.getTime() - this.prevMS;
	}

	public void setDifference(long difference) {
		this.prevMS = this.getTime() - difference;
	}

	public long time() {
		return System.nanoTime() / 1000000L - this.time;
	}

	public boolean hasTimeElapsed(final long time) {
        return this.time() >= time;
    }
}
