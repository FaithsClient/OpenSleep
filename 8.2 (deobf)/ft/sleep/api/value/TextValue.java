package ft.sleep.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class TextValue extends Value {
   public boolean TextHovered;

   public TextValue(String name, String value) {
      super(name);
      this.setValue(value);
   }

   public JsonElement toJson() {
      return new JsonPrimitive((String)this.getValue());
   }

   public void fromJson(JsonElement element) {
      if (element.isJsonPrimitive()) {
         this.setValue(element.getAsString());
      }

   }

   public boolean getTextHovered() {
      return this.TextHovered;
   }

   public void setTextHovered(boolean b) {
      this.TextHovered = b;
   }

   public void append(char typedChar) {
      this.setValue((String)this.getValue() + typedChar);
   }
}
