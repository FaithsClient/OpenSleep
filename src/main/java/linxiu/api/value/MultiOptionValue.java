package linxiu.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.List;

public class MultiOptionValue extends Value<Option> {

    private final List<Option> boolSettings;

    public boolean openList;

    public MultiOptionValue(String name, Option... booleanSettings) {
        super(name);
        boolSettings = Arrays.asList(booleanSettings);
    }

    public Option getSetting(String settingName) {
        return boolSettings.stream().filter(booleanSetting -> booleanSetting.getName().equalsIgnoreCase(settingName)).findFirst().orElse(null);
    }

    public List<Option> getBoolSettings() {
        return boolSettings;
    }

    @Override
    public JsonElement toJson() {
        final JsonObject jsonObject = new JsonObject();
        for (Option booleanSetting : getBoolSettings()) {
            jsonObject.addProperty(booleanSetting.getName(), booleanSetting.getValue());
        }
        return jsonObject;
    }

    @Override
    public void fromJson(JsonElement element) {
        if (!element.isJsonObject())return;
        for (Option booleanSetting : getBoolSettings()) {
            //循环设置boolean
            //第一个对应第一个的get
            //通过Name判断
            booleanSetting.setValue(element.getAsJsonObject().get(booleanSetting.getName()).getAsBoolean());
        }
    }
}
