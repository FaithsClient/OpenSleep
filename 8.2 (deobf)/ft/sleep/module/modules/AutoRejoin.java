//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.value.Numbers;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;

public class AutoRejoin extends Module {
   public Numbers identity$ = new Numbers("Time", 150.0D, Double.longBitsToDouble(0L), 1000.0D, 10.0D);

   public AutoRejoin() {
      super("Rejoin Game", new String[]{"RejoinGame", "RejoinGame"}, ModuleType.Player);
   }

   public void _regime() {
      camemuva._serial(false);
      if (camemuva.mc.thePlayer != null) {
         camemuva.mc.thePlayer.sendChatMessage("/lobby");
         (new Thread(camemuva::_ellen)).start();
      }
   }

   public void _ellen() {
      Thread.sleep(haiti.identity$.getValue().longValue());
      haiti.mc.thePlayer.sendChatMessage("/back");
   }
}
