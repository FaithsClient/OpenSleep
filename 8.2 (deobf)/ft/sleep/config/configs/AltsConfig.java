package ft.sleep.config.configs;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.util.UUID;

public class AltsConfig extends FileConfig {
   public final List alts = new ArrayList();
   public final List accounts = new ArrayList();

   public AltsConfig(File file) {
      super(file);
   }

   protected void loadConfig() throws IOException {
      JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(this.getFile())));
      if (!(jsonElement instanceof JsonNull)) {
         for(JsonElement accountElement : jsonElement.getAsJsonArray()) {
            JsonObject accountObject = accountElement.getAsJsonObject();
            if (this.accountExists(accountObject.get("name").getAsString())) {
               return;
            }

            if (accountObject.get("type").getAsString().equalsIgnoreCase("microsoft")) {
               this.addAccount(accountObject.get("name").getAsString(), accountObject.get("accessToken").getAsString(), accountObject.get("refreshToken").getAsString(), UUID.fromString(accountObject.get("uuid").getAsString()));
            }

            if (accountObject.get("type").getAsString().equalsIgnoreCase("offline")) {
               this.addAccount(accountObject.get("name").getAsString());
            }
         }

      }
   }

   protected void saveConfig() throws IOException {
      JsonArray jsonArray = new JsonArray();

      for( minecraftAccount : this.accounts) {
         JsonObject friendObject = new JsonObject();
         if (minecraftAccount instanceof ) {
             ma = ()minecraftAccount;
            friendObject.addProperty("type", "microsoft");
            friendObject.addProperty("name", ma.name());
            friendObject.addProperty("accessToken", ma.());
            friendObject.addProperty("refreshToken", ma.());
            friendObject.addProperty("uuid", ma.().toString());
            friendObject.addProperty("size", Integer.valueOf(this.alts.size()));
            jsonArray.add(friendObject);
         }

         if (minecraftAccount instanceof ) {
            friendObject.addProperty("type", "offline");
            friendObject.addProperty("name", minecraftAccount.name());
            friendObject.addProperty("uuid", minecraftAccount.().toString());
            friendObject.addProperty("size", Integer.valueOf(this.alts.size()));
            jsonArray.add(friendObject);
         }
      }

      PrintWriter printWriter = new PrintWriter(new FileWriter(this.getFile()));
      printWriter.println(FileManager.PRETTY_GSON.toJson(jsonArray));
      printWriter.close();
   }

   public void addAccount(String name) {
      if (!this.accountExists(name)) {
         this.alts.add(new (new (name, .(name))));
         this.accounts.add(new (name, .(name)));
      }
   }

   public void addAccount(String name, String accessToken, String refreshToken, UUID uuid) {
      if (!this.accountExists(name)) {
         this.alts.add(new (new (name, accessToken, refreshToken, uuid)));
         this.accounts.add(new (name, accessToken, refreshToken, uuid));
      }
   }

   public void removeAccount( ac) {
      this.accounts.remove(this.accounts.get(this.accounts.indexOf(ac.) + 1));
      this.alts.remove(ac);
   }

   public boolean accountExists(String name) {
      for( minecraftAccount : this.accounts) {
         if (minecraftAccount.name().equals(name)) {
            return true;
         }
      }

      return false;
   }
}
