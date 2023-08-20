/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.events.misc;

import linxiu.api.Event;
import net.minecraft.util.IChatComponent;

public class EventChat extends Event {
	private String message;

	public EventChat(String message) {
		this.message = message;

	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
