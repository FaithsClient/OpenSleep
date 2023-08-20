package ft.sleep.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MultiOptionValue extends Value {
   private final List boolSettings;
   public boolean openList;

   public MultiOptionValue(String name, Option... booleanSettings) {
      super(name);
      this.boolSettings = Arrays.asList(booleanSettings);
   }

   public Option getSetting(String settingName) {
      return (Option)this.boolSettings.stream().filter((booleanSetting) -> {
         return booleanSetting.getName().equalsIgnoreCase(settingName);
      }).findFirst().orElse((Object)null);
   }

   public List getBoolSettings() {
      return this.boolSettings;
   }

   public JsonElement toJson() {
      JsonObject jsonObject = new JsonObject();

      for(Option booleanSetting : this.getBoolSettings()) {
         jsonObject.addProperty(booleanSetting.getName(), booleanSetting.getValue());
      }

      return jsonObject;
   }

   public void fromJson(JsonElement element) {
      if (element.isJsonObject()) {
         for(Option booleanSetting : this.getBoolSettings()) {
            booleanSetting.setValue(Boolean.valueOf(element.getAsJsonObject().get(booleanSetting.getName()).getAsBoolean()));
         }

      }
   }
}
