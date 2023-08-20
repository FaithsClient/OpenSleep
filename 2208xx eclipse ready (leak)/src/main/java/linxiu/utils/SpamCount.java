package linxiu.utils;

import net.minecraft.util.IChatComponent;

public class SpamCount {
	private IChatComponent message;
	private int counter = 1;
	private long time;

	public SpamCount(IChatComponent message) {
		this.message = message;
		this.time = System.currentTimeMillis();
	}

	public void increaseCounter() {
		++this.counter;
	}

	public int getCounter() {
		return this.counter;
	}

	public void resetCounter() {
		this.counter = 1;
	}

	public long getTime() {
		return this.time;
	}

	public boolean isSame(IChatComponent mes) {
		return this.message.getUnformattedText().equals(mes.getUnformattedText());
	}

	public void setTime(Long time) {
		this.time = time;
	}
}
