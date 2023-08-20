package linxiu.config.configs;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import linxiu.config.FileConfig;

public class FriendsConfig extends FileConfig {

    private final List<Friend> friends = new ArrayList<>();

    /**
     * Constructor of config
     *
     * @param file of config
     */
    public FriendsConfig(final File file) {
        super(file);
    }

    /**
     * Load config from file
     *
     * @throws IOException
     */
    @Override
    protected void loadConfig() throws IOException {
        clearFriends();

        final BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile()));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            if(!line.contains("{") && !line.contains("}")) {
                line = line.replace(" ", "").replace("\"", "").replace(",", "");

                if(line.contains(":")) {
                    String[] data = line.split(":");
                    addFriend(data[0]);
                }else
                    addFriend(line);
            }
        }
        bufferedReader.close();
    }

    /**
     * Save config to file
     *
     * @throws IOException
     */
    @Override
    protected void saveConfig() throws IOException {
        final PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
        for(final Friend friend : getFriends())
            printWriter.append(friend.getPlayerName()).append(":");
        printWriter.close();
    }


    /**
     * Add friend to config
     *
     * @param playerName of friend
     * @return of successfully added friend
     */
    public boolean addFriend(final String playerName) {
        if(isFriend(playerName))
            return false;

        friends.add(new Friend(playerName));
        return true;
    }

    /**
     * Remove friend from config
     *
     * @param playerName of friend
     */
    public boolean removeFriend(final String playerName) {
        if(!isFriend(playerName))
            return false;

        friends.removeIf(friend -> friend.getPlayerName().equals(playerName));
        return true;
    }

    /**
     * Check is friend
     *
     * @param playerName of friend
     * @return is friend
     */
    public boolean isFriend(final String playerName) {
        for(final Friend friend : friends)
            if(friend.getPlayerName().equals(playerName))
                return true;
        return false;
    }

    /**
     * Clear all friends from config
     */
    public void clearFriends() {
        friends.clear();
    }

    /**
     * Get friends
     *
     * @return list of friends
     */
    public List<Friend> getFriends() {
        return friends;
    }

    public class Friend {

        private final String playerName;


        /**
         * @param playerName of friend
         */
        Friend(final String playerName) {
            this.playerName = playerName;
        }

        /**
         * @return name of friend
         */
        public String getPlayerName() {
            return playerName;
        }

    }
}
