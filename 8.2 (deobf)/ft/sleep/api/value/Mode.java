package ft.sleep.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class Mode extends Value {
   public String[] modes;
   public boolean openList;

   public Mode(String name, String[] modes, String value) {
      super(name);
      this.modes = modes;
      this.setValue(value);
   }

   public String getValue() {
      return (String)super.getValue();
   }

   public JsonElement toJson() {
      return new JsonPrimitive(this.getValue());
   }

   public void fromJson(JsonElement element) {
      if (element.isJsonPrimitive()) {
         this.setValue(element.getAsString());
      }

   }

   public String[] getModes() {
      return this.modes;
   }

   public String getModeAsString() {
      return this.getValue();
   }

   public String getModeGet(int i) {
      return this.modes[i];
   }

   public void setMode(String mode) {
      for(String e : this.modes) {
         if (e.equalsIgnoreCase(mode)) {
            this.setValue(e);
         }
      }

   }

   public int getModeListinde(String string) {
      String[] arrV = this.modes;
      int n = arrV.length;

      for(int n2 = 0; n2 < n; ++n2) {
         String e = arrV[n2];
         if (e.equalsIgnoreCase(string)) {
            return n2;
         }
      }

      return 0;
   }

   public boolean isValid(String name) {
      for(String e : this.modes) {
         if (e.equalsIgnoreCase(name)) {
            return true;
         }
      }

      return false;
   }
}
