/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class Option extends Value<Boolean> {
	public int anim;

	public Option(String displayName, String name, Boolean enabled) {
		super(displayName, name);
		this.setValue(enabled);
	}

	public Option(String displayName, Boolean enabled) {
		super(displayName, displayName);
		this.setValue(enabled);
	}

	@Override
	public Boolean getValue() {
		return super.getValue();
	}

	@Override
	public JsonElement toJson() {
		return new JsonPrimitive(getValue());
	}

	@Override
	public void fromJson(JsonElement element) {
		if (element.isJsonPrimitive())
			setValue(element.getAsBoolean());
	}

	public void toggle() {
		setValue(!getValue());
	}
}
