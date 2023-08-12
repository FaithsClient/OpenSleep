package linxiu.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class TextValue extends Value<String> {

	public boolean TextHovered;

	public TextValue(String name, String value) {
		super(name);
		this.setValue(value);
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

	public boolean getTextHovered() {
		return TextHovered;
	}

	public void setTextHovered(boolean b) {
		TextHovered = b;
	}

	public void append(char typedChar) {
		setValue(getValue() + typedChar);
	}
}
