package rip.sleep.module.modules;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;
import rip.sleep.module.ModuleType;

public class RejoinGame extends Module {
   public NumberValue<Number> c60551 = new NumberValue<Number>("Time", 150.0D, 0.0D, 1000.0D, 10.0D);

   public RejoinGame() {
      super("Rejoin Game", new String[]{"RejoinGame", "RejoinGame"}, ModuleType.c31770, ModuleType.c21190.c76367);
   }

   public void c83205() {
      Value.c27574();
      this.c23631(false);
      if (mc.thePlayer != null) {
         mc.thePlayer.sendChatMessage("/lobby");
         (new Thread(() -> {
            NumberValue var10000 = this.c60551;

            try {
               Thread.sleep(var10000.c53968().longValue());
            } catch (InterruptedException var2) {
               var2.printStackTrace();
            }

            mc.thePlayer.sendChatMessage("/back");
         })).start();
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
