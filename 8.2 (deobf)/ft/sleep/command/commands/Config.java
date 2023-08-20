//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.command.commands;

import ft.sleep.Client;
import ft.sleep.command.Command;
import ft.sleep.config.configs.Configs;
import java.io.File;

import ft.sleep.module.ModuleManager;
import net.minecraft.client.Minecraft;

public class Config extends Command {
   public static File prepared$;
   public File control$;

   public Config() {
      super("ConfigManager", new String[]{"config"}, "", "Load or Save Local ft.sleep.command.commands.Config");
      nogececa.control$ = new File(prepared$, "configs");
   }

   public String _absolute(String[] opevolac) {
      Object yurutidi = new Configs(new File(ulevezec.control$, ((Object[])opevolac)[1] + ".json"));
      if (((Object[])opevolac).length == 2 && ((String)((Object[])opevolac)[0]).equalsIgnoreCase("save")) {
         if (Client.surround$.�?() != null) {
            Client.�?().�?().saveConfig(yurutidi);
         }

         Helper._shopping("Save");
      }

      if (((Object[])opevolac).length == 2 && ((String)((Object[])opevolac)[0]).equalsIgnoreCase("load") && Client.surround$.�?() != null) {
         Client.�?();

         for(Object vazunalu : ModuleManager._trick()) {
            if (vazunalu._central()) {
               vazunalu._serial(false);
            }
         }

         Client.�?().�?().loadConfig(yurutidi);
         Helper._shopping("load");
      }

      if (((Object[])opevolac).length != 2) {
         Helper._shopping("§7§m§l==================================");
         Helper._shopping("§b§lSleep ConfigManager");
         Helper._shopping("§b.cm save <Configuration name> :§7 Save ft.sleep.command.commands.Config");
         Helper._shopping("§b.cm load <Configuration name> :§7 Load ft.sleep.command.commands.Config");
         Helper._shopping("§b.cm remove <Configuration name> :§7 Remove ft.sleep.command.commands.Config");
         Helper._shopping("§7§m§l==================================");
      }

      return null;
   }

   static {
      prepared$ = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "Sleep");
   }
}
