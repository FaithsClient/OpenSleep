//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;

public class AutoKill extends Module {
   public boolean symptoms$;

   public AutoKill() {
      super("ft.sleep.module.modules.AutoKill", new String[]{"ft.sleep.module.modules.AutoKill", "ft.sleep.module.modules.AutoKill"}, ModuleType.Player);
   }

   public void _regime() {
      excited._serial(false);
      if (excited.mc.thePlayer != null) {
         excited.mc.thePlayer.sendChatMessage("/kill");
      }
   }
}
