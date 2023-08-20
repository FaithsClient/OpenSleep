package ft.sleep.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class Option extends Value {
   public int anim;

   public Option(String displayName, String name, Boolean enabled) {
      super(displayName, name);
      this.setValue(enabled);
   }

   public Option(String displayName, Boolean enabled) {
      super(displayName, displayName);
      this.setValue(enabled);
   }

   public Boolean getValue() {
      return (Boolean)super.getValue();
   }

   public JsonElement toJson() {
      return new JsonPrimitive(this.getValue());
   }

   public void fromJson(JsonElement element) {
      if (element.isJsonPrimitive()) {
         this.setValue(Boolean.valueOf(element.getAsBoolean()));
      }

   }

   public void toggle() {
      this.setValue(Boolean.valueOf(!this.getValue().booleanValue()));
   }
}
