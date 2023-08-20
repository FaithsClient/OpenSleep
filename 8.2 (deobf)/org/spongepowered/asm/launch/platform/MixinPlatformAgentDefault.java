package org.spongepowered.asm.launch.platform;

import java.net.URI;

public class MixinPlatformAgentDefault extends MixinPlatformAgentAbstract {
   public MixinPlatformAgentDefault(MixinPlatformManager manager, URI uri) {
      super(manager, uri);
   }

   public void prepare() {
      String compatibilityLevel = this.attributes.get("MixinCompatibilityLevel");
      if (compatibilityLevel != null) {
         this.manager.setCompatibilityLevel(compatibilityLevel);
      }

      String mixinConfigs = this.attributes.get("MixinConfigs");
      if (mixinConfigs != null) {
         for(String config : mixinConfigs.split(",")) {
            this.manager.addConfig(config.trim());
         }
      }

      String tokenProviders = this.attributes.get("MixinTokenProviders");
      if (tokenProviders != null) {
         for(String provider : tokenProviders.split(",")) {
            this.manager.addTokenProvider(provider.trim());
         }
      }

   }

   public void initPrimaryContainer() {
   }

   public void inject() {
   }

   public String getLaunchTarget() {
      return this.attributes.get("Main-Class");
   }
}
