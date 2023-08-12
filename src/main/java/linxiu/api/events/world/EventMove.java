/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.events.world;

import linxiu.api.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

public class EventMove extends Event {
	public double x;
	double y;
	public double z;

	public EventMove(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}