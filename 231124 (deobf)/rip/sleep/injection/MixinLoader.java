package rip.sleep.injection;

import antiLeak.Loader;
import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

public class MixinLoader implements IFMLLoadingPlugin {
   public static String Client_User;
   public static String Client_UserQQ;

   public static native void loader();

   public MixinLoader() {
      MixinBootstrap.init();
      Mixins.addConfiguration("rip.sleep.mixin.sleep.json");
      MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
   }

   public String[] getASMTransformerClass() {
      return new String[]{null};
   }

   public String getModContainerClass() {
      return null;
   }

   public String getSetupClass() {
      return null;
   }

   public void injectData(Map<String, Object> var1) {
   }

   public String getAccessTransformerClass() {
      return null;
   }

   static {
      Loader.registerNativesForClass(6, MixinLoader.class);
      antiLeak_nigger_clinit7();
   }

   // $FF: synthetic method
   private static native void antiLeak_nigger_clinit7();
}
