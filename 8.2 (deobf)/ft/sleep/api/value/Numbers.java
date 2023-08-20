package ft.sleep.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class Numbers extends Value {
   private String name;
   public Number min;
   public Number max;
   public Number inc;
   public String tag;
   private final boolean integer;
   private String suffix = "";

   public Numbers(String name, Number value, Number min, Number max, Number inc) {
      super(name);
      this.setValue(value);
      this.min = min;
      this.max = max;
      this.inc = inc;
      this.integer = false;
      this.suffix = "";
   }

   public Numbers(String name, Number value, Number min, Number max, Number inc, String suffix) {
      super(name);
      this.setValue(value);
      this.min = min;
      this.max = max;
      this.inc = inc;
      this.integer = false;
      this.suffix = suffix;
   }

   public Numbers(String displayName, String name, Number value, Number min, Number max, Number inc) {
      super(displayName, name);
      this.setValue(value);
      this.min = min;
      this.max = max;
      this.inc = inc;
      this.integer = false;
   }

   public Number getValue() {
      return (Number)super.getValue();
   }

   public void setValue(Number value) {
      super.setValue(value);
   }

   public JsonElement toJson() {
      return new JsonPrimitive(this.getValue());
   }

   public void fromJson(JsonElement element) {
      if (element.isJsonPrimitive()) {
         this.setValue(element.getAsNumber());
      }

   }

   public Number getMinimum() {
      return this.min;
   }

   public Number getMaximum() {
      return this.max;
   }

   public void setIncrement(Number inc) {
      this.inc = inc;
   }

   public Number getIncrement() {
      return this.inc;
   }

   public String getId() {
      return this.name;
   }

   public String getSuffix() {
      return this.suffix;
   }

   public boolean isInteger() {
      return this.integer;
   }
}
