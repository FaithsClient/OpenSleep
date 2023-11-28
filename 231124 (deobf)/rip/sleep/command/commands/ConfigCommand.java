package rip.sleep.command.commands;

import java.io.File;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.command.Command;
import rip.sleep.file.TargetFile;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.value.Value;

public class ConfigCommand extends Command {
   public static final File c7849;
   public final File c17172;

   public ConfigCommand() {
      super("ConfigManager", new String[]{"config"}, "", "Load or Save Local Config");
      this.c17172 = new File(c7849, "configs");
   }

   public String c23111(String[] var1) {
      Value.c27574();
      TargetFile var3 = new TargetFile(new File(this.c17172, var1[1] + ".json"));
      if (var1.length == 2 && var1[0].equalsIgnoreCase("save")) {
         if (Sleep.INSTANCE.c43557() != null) {
            Sleep.getInstance().c43557().c63824(var3);
         }

         ChatUtilA.c95995("Save");
      }

      if (var1.length == 2 && var1[0].equalsIgnoreCase("load") && Sleep.INSTANCE.c43557() != null) {
         Sleep var10000 = Sleep.INSTANCE;
         Sleep.c33759();
         Iterator var4 = ModuleManager.c84590().iterator();
         if (var4.hasNext()) {
            Module var5 = (Module)var4.next();
            if (var5.c24622()) {
               var5.c23631(false);
            }
         }

         Sleep.getInstance().c43557().c2789(var3);
         ChatUtilA.c95995("load");
      }

      if (var1.length != 2) {
         ChatUtilA.c95995("§7§m§l==================================");
         ChatUtilA.c95995("§b§lSleep ConfigManager");
         ChatUtilA.c95995("§b.cm save <Configuration name> :§7 Save Config");
         ChatUtilA.c95995("§b.cm load <Configuration name> :§7 Load Config");
         ChatUtilA.c95995("§b.cm remove <Configuration name> :§7 Remove Config");
         ChatUtilA.c95995("§7§m§l==================================");
      }

      return null;
   }

   static {
      c7849 = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "Sleep");
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
