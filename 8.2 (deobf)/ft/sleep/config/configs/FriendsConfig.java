package ft.sleep.config.configs;

import ft.sleep.config.FileConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FriendsConfig extends FileConfig {
   private final List friends = new ArrayList();

   public FriendsConfig(File file) {
      super(file);
   }

   protected void loadConfig() throws IOException {
      this.clearFriends();
      BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));

      String line;
      while((line = bufferedReader.readLine()) != null) {
         if (!line.contains("{") && !line.contains("}")) {
            line = line.replace(" ", "").replace("\"", "").replace(",", "");
            if (line.contains(":")) {
               String[] data = line.split(":");
               this.addFriend(data[0]);
            } else {
               this.addFriend(line);
            }
         }
      }

      bufferedReader.close();
   }

   protected void saveConfig() throws IOException {
      PrintWriter printWriter = new PrintWriter(new FileWriter(this.getFile()));

      for(FriendsConfig.Friend friend : this.getFriends()) {
         printWriter.append(friend.getPlayerName()).append(":");
      }

      printWriter.close();
   }

   public boolean addFriend(String playerName) {
      if (this.isFriend(playerName)) {
         return false;
      } else {
         this.friends.add(new FriendsConfig.Friend(playerName));
         return true;
      }
   }

   public boolean removeFriend(String playerName) {
      if (!this.isFriend(playerName)) {
         return false;
      } else {
         this.friends.removeIf((friend) -> {
            return friend.getPlayerName().equals(playerName);
         });
         return true;
      }
   }

   public boolean isFriend(String playerName) {
      for(FriendsConfig.Friend friend : this.friends) {
         if (friend.getPlayerName().equals(playerName)) {
            return true;
         }
      }

      return false;
   }

   public void clearFriends() {
      this.friends.clear();
   }

   public List getFriends() {
      return this.friends;
   }

   public class Friend {
      private final String playerName;

      Friend(String playerName) {
         this.playerName = playerName;
      }

      public String getPlayerName() {
         return this.playerName;
      }
   }
}
