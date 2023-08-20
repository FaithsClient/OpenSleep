package ft.sleep.config.configs;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import ft.sleep.config.FileConfig;
import ft.sleep.config.FileManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TargetConfig extends FileConfig {
   private final List targets = new ArrayList();

   public TargetConfig(File file) {
      super(file);
   }

   protected void loadConfig() throws IOException {
      this.clearTarget();

      try {
         JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(this.getFile())));
         if (jsonElement instanceof JsonNull) {
            return;
         }

         for(JsonElement targetElement : jsonElement.getAsJsonArray()) {
            JsonObject targetObject = targetElement.getAsJsonObject();
            this.addTarget(targetObject.get("playerName").getAsString());
         }
      } catch (IllegalStateException | JsonSyntaxException var5) {
         BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));

         String line;
         while((line = bufferedReader.readLine()) != null) {
            if (!line.contains("{") && !line.contains("}")) {
               line = line.replace(" ", "").replace("\"", "").replace(",", "");
               if (line.contains(":")) {
                  String[] data = line.split(":");
                  this.addTarget(data[0]);
               } else {
                  this.addTarget(line);
               }
            }
         }

         bufferedReader.close();
         this.saveConfig();
      }

   }

   protected void saveConfig() throws IOException {
      JsonArray jsonArray = new JsonArray();

      for(TargetConfig.Target target : this.getTargets()) {
         JsonObject friendObject = new JsonObject();
         friendObject.addProperty("playerName", target.getPlayerName());
         jsonArray.add(friendObject);
      }

      PrintWriter printWriter = new PrintWriter(new FileWriter(this.getFile()));
      printWriter.println(FileManager.PRETTY_GSON.toJson(jsonArray));
      printWriter.close();
   }

   public boolean addTarget(String playerName) {
      if (this.isTarget(playerName)) {
         return false;
      } else {
         this.targets.add(new TargetConfig.Target(playerName));
         return true;
      }
   }

   public boolean removeTarget(String playerName) {
      if (!this.isTarget(playerName)) {
         return false;
      } else {
         this.targets.removeIf((target) -> {
            return target.getPlayerName().equals(playerName);
         });
         return true;
      }
   }

   public boolean isTarget(String playerName) {
      for(TargetConfig.Target target : this.targets) {
         if (target.getPlayerName().equals(playerName)) {
            return true;
         }
      }

      return false;
   }

   public void clearTarget() {
      this.targets.clear();
   }

   public List getTargets() {
      return this.targets;
   }

   public static class Target {
      private final String playerName;

      public Target(String playerName) {
         this.playerName = playerName;
      }

      public String getPlayerName() {
         return this.playerName;
      }
   }
}
