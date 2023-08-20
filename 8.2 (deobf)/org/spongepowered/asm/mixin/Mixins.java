package org.spongepowered.asm.mixin;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;

public final class Mixins {
   private static final Logger logger = LogManager.getLogger("mixin");
   private static final String CONFIGS_KEY = "mixin.configs.queue";
   private static final Set errorHandlers = new LinkedHashSet();

   public static void addConfigurations(String... configFiles) {
      MixinEnvironment fallback = MixinEnvironment.getDefaultEnvironment();

      for(String configFile : configFiles) {
         createConfiguration(configFile, fallback);
      }

   }

   public static void addConfiguration(String configFile) {
      createConfiguration(configFile, MixinEnvironment.getDefaultEnvironment());
   }

   /** @deprecated */
   @Deprecated
   static void addConfiguration(String configFile, MixinEnvironment fallback) {
      createConfiguration(configFile, fallback);
   }

   private static void createConfiguration(String configFile, MixinEnvironment fallback) {
      org.spongepowered.asm.mixin.transformer.Config config = null;

      try {
         config = org.spongepowered.asm.mixin.transformer.Config.create(configFile, fallback);
      } catch (Exception var4) {
         logger.error("Error encountered reading mixin config " + configFile + ": " + var4.getClass().getName() + " " + var4.getMessage(), var4);
      }

      registerConfiguration(config);
   }

   private static void registerConfiguration(org.spongepowered.asm.mixin.transformer.Config config) {
      if (config != null) {
         MixinEnvironment env = config.getEnvironment();
         if (env != null) {
            env.registerConfig(config.getName());
         }

         getConfigs().add(config);
      }
   }

   public static int getUnvisitedCount() {
      int count = 0;

      for(org.spongepowered.asm.mixin.transformer.Config config : getConfigs()) {
         if (!config.isVisited()) {
            ++count;
         }
      }

      return count;
   }

   public static Set getConfigs() {
      Set mixinConfigs = (Set)GlobalProperties.get("mixin.configs.queue");
      if (mixinConfigs == null) {
         mixinConfigs = new LinkedHashSet();
         GlobalProperties.put("mixin.configs.queue", mixinConfigs);
      }

      return mixinConfigs;
   }

   public static void registerErrorHandlerClass(String handlerName) {
      if (handlerName != null) {
         errorHandlers.add(handlerName);
      }

   }

   public static Set getErrorHandlerClasses() {
      return Collections.unmodifiableSet(errorHandlers);
   }
}
