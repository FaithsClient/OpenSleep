package linxiu.config.configs;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import linxiu.Client;
import linxiu.api.value.Value;
import linxiu.config.FileConfig;
import linxiu.config.FileManager;
import linxiu.module.Module;
import linxiu.module.modules.render.TargetHUD;
import linxiu.module.modules.render.TargetList;
import linxiu.utils.targeth.TargetHud;

import java.io.*;
import java.util.Map;

public class Configs extends FileConfig {

	public Configs(final File file) {
		super(file);
	}

	@Override
	protected void loadConfig() throws IOException {
		final JsonElement jsonElement = new JsonParser().parse(new BufferedReader(new FileReader(getFile())));

		if (jsonElement instanceof JsonNull)
			return;

		for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {

			final Module module = Client.getINSTANCE().getModuleManager().getModule(entry.getKey());
			final JsonObject jsonModule = (JsonObject) entry.getValue();

			// 设置开关
			if (module != null) {
				module.setEnabled(jsonModule.get("State").getAsBoolean());
				module.setKey(jsonModule.get("KeyBind").getAsInt());
				if (entry.getKey().equalsIgnoreCase("Target_Hud")) {
	                JsonObject jsonHudValue = (JsonObject) entry.getValue();

	                if (jsonHudValue.has("hud_x"))
	                    TargetHUD.setHudX( jsonHudValue.get("hud_x").getAsInt());
	                if (jsonHudValue.has("hud_y"))
	                	TargetHUD.setHudY(jsonHudValue.get("hud_y").getAsInt());

	            }
	            if (entry.getKey().equalsIgnoreCase("Target_List")) {
	                JsonObject jsonListValue = (JsonObject) entry.getValue();

	                if (jsonListValue.has("list_x"))
	                    TargetList.setListX( jsonListValue.get("list_x").getAsInt());
	                if (jsonListValue.has("list_y"))
	                	TargetList.setListY(jsonListValue.get("list_y").getAsInt());
	            }
	            
				if (jsonModule.has("CustomName"))
					module.setCustomName(jsonModule.get("CustomName").getAsString());

				if (jsonModule.has("Array"))
					module.setRemoved(jsonModule.get("Array").getAsBoolean());

				// 设置Value
				for (final Value<?> moduleValue : module.getValues()) {
					final JsonElement element = jsonModule.get(moduleValue.getName());

					if (element != null)
						moduleValue.fromJson(element);
				}
			}

		}
	}

	@Override
	protected void saveConfig() throws IOException {
		final JsonObject jsonObject = new JsonObject();
		final JsonObject jsonTargets = new JsonObject();
        final JsonObject jsonTargetHud = new JsonObject();
        final JsonObject jsonTargetList = new JsonObject();
        jsonTargetHud.addProperty("hud_x", TargetHUD.getHudX());
        jsonTargetHud.addProperty("hud_y", TargetHUD.getHudY());
        jsonObject.add("Target_Hud", jsonTargetHud);
        
        
        jsonTargetList.addProperty("list_x", TargetList.getListX());
        jsonTargetList.addProperty("list_y", TargetList.getListY());
        jsonObject.add("Target_List", jsonTargetList);
		for (final Module module : Client.INSTANCE.getModuleManager().getModules()) {
			final JsonObject jsonMod = new JsonObject();
			jsonMod.addProperty("State", module.isEnabled());
			jsonMod.addProperty("KeyBind", module.getKey());
			jsonMod.addProperty("Array", module.wasRemoved());
			jsonMod.addProperty("CustomName", module.getCustomName());

			jsonObject.add(module.getName(), jsonMod);

			// 保存Value
			if (!module.getValues().isEmpty()) {
				for (Value<?> value : module.getValues()) {
					jsonMod.add(value.getName(), value.toJson());
				}
			}
		}

		final PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
		printWriter.println(FileManager.PRETTY_GSON.toJson(jsonObject));
		printWriter.close();
	}
}
