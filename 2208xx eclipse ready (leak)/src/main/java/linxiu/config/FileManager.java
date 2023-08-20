package linxiu.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import linxiu.Client;
import linxiu.config.configs.Configs;
import linxiu.config.configs.FriendsConfig;
import linxiu.config.configs.TargetConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.File;
import java.lang.reflect.Field;


@SideOnly(Side.CLIENT)
public class FileManager  {

    public final File dir = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "Sleep");
    public final File configsdir = new File(dir, "configs");

    public final FileConfig configs = new Configs(new File(configsdir, "default.json"));
    public final FriendsConfig friendsConfig = new FriendsConfig(new File(dir,"friends.json"));
    public final TargetConfig targetConfig = new TargetConfig(new File(dir,"targets.json"));

    public boolean firstStart =  false;

    public static final Gson PRETTY_GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Constructor of file manager
     * Setup everything important
     */
    public FileManager() {
        setupFolder();
    }

    /**
     * Setup folder
     */
    public void setupFolder() {
        if(!dir.exists()) {
            dir.mkdir();
            firstStart = true;
        }
        if (!configsdir.exists()){
            //防止没有文件夹报错
            configsdir.mkdir();
            firstStart = true;
        }

    }

    /**
     * Load all configs in file manager
     */
    public void loadAllConfigs() {
        for(final Field field : getClass().getDeclaredFields()) {
            if(field.getType() == FileConfig.class) {
                try {
                    if(!field.isAccessible())
                        field.setAccessible(true);

                    final FileConfig fileConfig = (FileConfig) field.get(this);
                    loadConfig(fileConfig);
                }catch(final IllegalAccessException e) {
                }
            }
        }
    }

    /**
     * Load a list of configs
     *
     * @param configs list
     */
    public void loadConfigs(final FileConfig... configs) {
        for(final FileConfig fileConfig : configs)
            loadConfig(fileConfig);
    }

    /**
     * Load one config
     *
     * @param config to load
     */
    public void loadConfig(final FileConfig config) {
        if(!config.hasConfig()) {

            saveConfig(config, true);
            return;
        }

        try {

            config.loadConfig();

        }catch(final Throwable ignored) {

        }
    }

    /**
     * Save all configs in file manager
     */
    public void saveAllConfigs() {
        for(final Field field : getClass().getDeclaredFields()) {
            if(field.getType() == FileConfig.class) {
                try {
                    if(!field.isAccessible())
                        field.setAccessible(true);

                    final FileConfig fileConfig = (FileConfig) field.get(this);
                    saveConfig(fileConfig);
                }catch(final IllegalAccessException e) {

                }
            }
        }
    }

    /**
     * Save a list of configs
     *
     * @param configs list
     */
    public void saveConfigs(final FileConfig... configs) {
        for(final FileConfig fileConfig : configs)
            saveConfig(fileConfig);
    }

    /**
     * Save one config
     *
     * @param config to save
     */
    public void saveConfig(final FileConfig config) {
        saveConfig(config, false);
    }

    /**
     * Save one config
     *
     * @param config         to save
     * @param ignoreStarting check starting
     */
    private void saveConfig(final FileConfig config, final boolean ignoreStarting) {
        if (!ignoreStarting && Client.isStarting)
            return;

        try {
            if(!config.hasConfig())
                config.createConfig();

            config.saveConfig();

        }catch(final Throwable t) {

        }
    }

}
