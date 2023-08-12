/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.events.rendering;

import linxiu.api.Event;
import net.minecraft.client.gui.ScaledResolution;

public class EventRender2D extends Event {
	public ScaledResolution sr;
	private final float pt;

	public EventRender2D(ScaledResolution sr, float pt) {
		this.sr = sr;
		this.pt = pt;
	}

	public ScaledResolution getSR() {
		return this.sr;
	}
	
	public float getPartialTicks() {
		return this.pt;
	}
	public float getPT() {
		return this.pt;
	}
}

