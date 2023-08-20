package ft.sleep.config.configs;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ft.sleep.api.value.Value;
import ft.sleep.config.FileConfig;
import ft.sleep.config.FileManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

public class Configs extends FileConfig {
   public Configs(File file) {
      super(file);
   }

   protected void loadConfig() throws IOException {
      JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(this.getFile())));
      if (!(jsonElement instanceof JsonNull)) {
         for(Entry entry : jsonElement.getAsJsonObject().entrySet()) {
            .();
             module = .().((String)entry.getKey());
            JsonObject jsonModule = (JsonObject)entry.getValue();
            if (((String)entry.getKey()).equalsIgnoreCase("user")) {
               JsonObject jsonListValue = (JsonObject)entry.getValue();
               if (jsonListValue.has("name1")) {
                  .(jsonListValue.get("name1").getAsString());
               }
            }

            if (module != null) {
               module.(jsonModule.get("State").getAsBoolean());
               module.setKey(jsonModule.get("KeyBind").getAsInt());
               if (((String)entry.getKey()).equalsIgnoreCase("Target_Hud")) {
                  JsonObject jsonHudValue = (JsonObject)entry.getValue();
                  if (jsonHudValue.has("hud_x")) {
                     .(jsonHudValue.get("hud_x").getAsInt());
                  }

                  if (jsonHudValue.has("hud_y")) {
                     .(jsonHudValue.get("hud_y").getAsInt());
                  }
               }

               if (((String)entry.getKey()).equalsIgnoreCase("Target_List")) {
                  JsonObject jsonListValue = (JsonObject)entry.getValue();
                  if (jsonListValue.has("list_x")) {
                     .(jsonListValue.get("list_x").getAsInt());
                  }

                  if (jsonListValue.has("list_y")) {
                     .(jsonListValue.get("list_y").getAsInt());
                  }
               }

               if (jsonModule.has("CustomName")) {
                  module.(jsonModule.get("CustomName").getAsString());
               }

               if (jsonModule.has("Array")) {
                  module.(jsonModule.get("Array").getAsBoolean());
               }

               for(Value moduleValue : module.()) {
                  JsonElement element = jsonModule.get(moduleValue.getName());
                  if (element != null) {
                     moduleValue.fromJson(element);
                  }
               }
            }
         }

      }
   }

   protected void saveConfig() throws IOException {
      JsonObject jsonObject = new JsonObject();
      new JsonObject();
      JsonObject jsonTargetHud = new JsonObject();
      JsonObject jsonTargetList = new JsonObject();
      JsonObject jsonusername = new JsonObject();
      jsonusername.addProperty("name1", .);
      jsonObject.add("user", jsonusername);
      jsonTargetHud.addProperty("hud_x", Integer.valueOf(.()));
      jsonTargetHud.addProperty("hud_y", Integer.valueOf(.()));
      jsonObject.add("Target_Hud", jsonTargetHud);
      jsonTargetList.addProperty("list_x", Integer.valueOf(.()));
      jsonTargetList.addProperty("list_y", Integer.valueOf(.()));
      jsonObject.add("Target_List", jsonTargetList);
      .();

      for( module : .()) {
         JsonObject jsonMod = new JsonObject();
         jsonMod.addProperty("State", Boolean.valueOf(module.()));
         jsonMod.addProperty("KeyBind", Integer.valueOf(module.getKey()));
         jsonMod.addProperty("Array", Boolean.valueOf(module.()));
         jsonMod.addProperty("CustomName", module.());
         jsonObject.add(module.getName(), jsonMod);
         if (!module.().isEmpty()) {
            for(Value value : module.()) {
               jsonMod.add(value.getName(), value.toJson());
            }
         }
      }

      PrintWriter printWriter = new PrintWriter(new FileWriter(this.getFile()));
      printWriter.println(FileManager.PRETTY_GSON.toJson(jsonObject));
      printWriter.close();
   }
}
