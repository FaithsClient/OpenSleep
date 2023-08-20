//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ft.sleep.config.configs.AltsConfig;
import ft.sleep.config.configs.Configs;
import ft.sleep.config.configs.FriendsConfig;
import ft.sleep.config.configs.TargetConfig;
import java.io.File;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FileManager {
   public final File dir;
   public final File configsdir;
   public final FileConfig configs;
   public final FriendsConfig friendsConfig;
   public final TargetConfig targetConfig;
   public AltsConfig altsConfig;
   public boolean firstStart;
   public static final Gson PRETTY_GSON = (new GsonBuilder()).setPrettyPrinting().create();

   public FileManager() {
      this.dir = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "sleep");
      this.configsdir = new File(this.dir, "configs");
      this.configs = new Configs(new File(this.configsdir, "default.json"));
      this.friendsConfig = new FriendsConfig(new File(this.dir, "friends.json"));
      this.targetConfig = new TargetConfig(new File(this.dir, "targets.json"));
      this.altsConfig = new AltsConfig(new File(this.dir, "alts.json"));
      this.firstStart = false;
      this.setupFolder();
   }

   public void setupFolder() {
      if (!this.dir.exists()) {
         this.dir.mkdir();
         this.firstStart = true;
      }

      if (!this.configsdir.exists()) {
         this.configsdir.mkdir();
         this.firstStart = true;
      }

   }

   public void loadAllConfigs() {
      for(Field field : this.getClass().getDeclaredFields()) {
         if (field.getType() == FileConfig.class) {
            try {
               if (!field.isAccessible()) {
                  field.setAccessible(true);
               }

               FileConfig fileConfig = (FileConfig)field.get(this);
               this.loadConfig(fileConfig);
            } catch (IllegalAccessException var6) {
               ;
            }
         }
      }

   }

   public void loadConfigs(FileConfig... configs) {
      for(FileConfig fileConfig : configs) {
         this.loadConfig(fileConfig);
      }

   }

   public void loadConfig(FileConfig config) {
      if (!config.hasConfig()) {
         î ”î ‘î ?.î ?().info("[FileManager] Skipped loading config: " + config.getFile().getName() + ".");
         this.saveConfig(config, true);
      } else {
         try {
            config.loadConfig();
            î ”î ‘î ?.î ?().info("[FileManager] Loaded config: " + config.getFile().getName() + ".");
         } catch (Throwable var3) {
            î ”î ‘î ?.î ?().error("[FileManager] Failed to load config file: " + config.getFile().getName() + ".", var3);
         }

      }
   }

   public void saveAllConfigs() {
      for(Field field : this.getClass().getDeclaredFields()) {
         if (field.getType() == FileConfig.class) {
            try {
               if (!field.isAccessible()) {
                  field.setAccessible(true);
               }

               FileConfig fileConfig = (FileConfig)field.get(this);
               this.saveConfig(fileConfig);
            } catch (IllegalAccessException var6) {
               ;
            }
         }
      }

   }

   public void saveConfigs(FileConfig... configs) {
      for(FileConfig fileConfig : configs) {
         this.saveConfig(fileConfig);
      }

   }

   public void saveConfig(FileConfig config) {
      this.saveConfig(config, false);
   }

   private void saveConfig(FileConfig config, boolean ignoreStarting) {
      if (ignoreStarting || !î ”î ‘î ?.î ‘î ”î ?) {
         try {
            if (!config.hasConfig()) {
               config.createConfig();
            }

            config.saveConfig();
         } catch (Throwable var4) {
            ;
         }

      }
   }
}
