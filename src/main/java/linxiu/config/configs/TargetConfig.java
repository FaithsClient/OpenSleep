package linxiu.config.configs;


import com.google.gson.*;

import linxiu.config.FileConfig;
import linxiu.config.FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TargetConfig extends FileConfig {

    private final List<Target> targets = new ArrayList<>();

    /**
     * Constructor of config
     *
     * @param file of config
     */
    public TargetConfig(final File file) {
        super(file);
    }

    /**
     * Load config from file
     *
     * @throws IOException
     */
    @Override
    protected void loadConfig() throws IOException {
        clearTarget();
        try {
            final JsonElement jsonElement = new JsonParser().parse(new BufferedReader(new FileReader(getFile())));

            if (jsonElement instanceof JsonNull)
                return;

            for (final JsonElement targetElement : jsonElement.getAsJsonArray()) {
                JsonObject targetObject = targetElement.getAsJsonObject();
                addTarget(targetObject.get("playerName").getAsString());
            }

        } catch (JsonSyntaxException | IllegalStateException ex) {
            //When the JSON Parse fail, the client try to load and update the old config

            final BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.contains("{") && !line.contains("}")) {
                    line = line.replace(" ", "").replace("\"", "").replace(",", "");

                    if (line.contains(":")) {
                        String[] data = line.split(":");
                        addTarget(data[0]);
                    } else
                        addTarget(line);
                }
            }
            bufferedReader.close();

            //Save the friends into a new valid JSON file
            saveConfig();

        }
    }

    /**
     * Save config to file
     *
     * @throws IOException
     */
    @Override
    protected void saveConfig() throws IOException {
        final JsonArray jsonArray = new JsonArray();

        for (final Target target : getTargets()) {
            JsonObject friendObject = new JsonObject();
            friendObject.addProperty("playerName", target.getPlayerName());
            jsonArray.add(friendObject);
        }

        final PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
        printWriter.println(FileManager.PRETTY_GSON.toJson(jsonArray));
        printWriter.close();
    }



    /**
     * Add Target to config
     *
     * @param playerName of friend
     * @return of successfully added friend
     */
    public boolean addTarget(final String playerName) {
        if(isTarget(playerName))
            return false;

        targets.add(new Target(playerName));
        return true;
    }

    /**
     * Remove friend from config
     *
     * @param playerName of friend
     */
    public boolean removeTarget(final String playerName) {
        if(!isTarget(playerName))
            return false;

        targets.removeIf(target -> target.getPlayerName().equals(playerName));
        return true;
    }

    /**
     * Check is Target
     *
     * @param playerName of friend
     * @return is friend
     */
    public boolean isTarget(final String playerName) {
        for(final Target target : targets)
            if(target.getPlayerName().equals(playerName))
                return true;
        return false;
    }

    /**
     * Clear all Target from config
     */
    public void clearTarget() {
        targets.clear();
    }

    /**
     * Get Target
     *
     * @return list of Target
     */
    public List<Target> getTargets() {
        return targets;
    }

    public static class Target {

        private final String playerName;

        /**
         * @param playerName of Target
         */
        public Target(final String playerName) {
            this.playerName = playerName;

        }

        /**
         * @return name of Target
         */
        public String getPlayerName() {
            return playerName;
        }


    }
}
