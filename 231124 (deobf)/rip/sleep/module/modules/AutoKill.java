package rip.sleep.module.modules;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;

public class AutoKill extends Module {
   public AutoKill() {
      super("Auto Kill", new String[]{"AutoKill", "AutoKill"}, ModuleType.c31770, ModuleType.c21190.c76367);
   }

   public void c83205() {
      Value.c27574();
      this.c23631(false);
      if (mc.thePlayer != null) {
         mc.thePlayer.sendChatMessage("/kill");
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
