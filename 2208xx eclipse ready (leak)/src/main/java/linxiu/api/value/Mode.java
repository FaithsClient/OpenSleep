/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.value;

import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class Mode extends Value<String> {
	public String[] modes;
	public boolean openList;

	public Mode(String name, String[] modes, String value) {
		super(name);
		this.modes = modes;
		this.setValue(value);
	}

	@Override
	public String getValue() {
		return super.getValue();
	}

	@Override
	public JsonElement toJson() {
		return new JsonPrimitive(getValue());
	}

	@Override
	public void fromJson(JsonElement element) {
		if (element.isJsonPrimitive())
			setValue(element.getAsString());
	}

	public String[] getModes() {
		return this.modes;
	}

	public String getModeAsString() {
		return (this.getValue());
	}

	public String getModeGet(int i) {
		return modes[i];
	}

	public void setMode(String mode) {
		String[] arrV = this.modes;
		int n = arrV.length;
		int n2 = 0;
		while (n2 < n) {
			String e = arrV[n2];
			if (e.equalsIgnoreCase(mode)) {
				this.setValue(e);
			}
			++n2;
		}
	}

	public int getModeListinde(String string) {
		String[] arrV = this.modes;
		int n = arrV.length;
		int n2 = 0;
		while (n2 < n) {
			String e = arrV[n2];
			if (e.equalsIgnoreCase(string)) {
				return n2;
			}
			++n2;
		}

		return 0;
	}

	public boolean isValid(String name) {
		String[] arrV = this.modes;
		int n = arrV.length;
		int n2 = 0;
		while (n2 < n) {
			String e = arrV[n2];
			if (e.equalsIgnoreCase(name)) {
				return true;
			}
			++n2;
		}
		return false;
	}
}