package rip.sleep.module.modules;

import java.awt.Color;
import java.util.HashSet;

import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.ChatSendEvent;
import rip.sleep.event.events.PostUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.MultiBooleanValue;
import rip.sleep.value.values.StringValue;
import rip.sleep.module.ModuleType;

public class MWAddons extends Module {
   private final StringValue c1282 = new StringValue("Look Bind", () -> {
      return c34018.c72319("McLook").c1473();
   }, "2");
   public static MultiBooleanValue c34018 = new MultiBooleanValue("Element", new BooleanValue[]{new BooleanValue("McLook", true), new BooleanValue("NoJumpP", false), new BooleanValue("NoJumpP2", true), new BooleanValue("AutoBack", true), new BooleanValue("AntiSpam", true), new BooleanValue("AutoRespawn", true)});
   private boolean c79990;

   public MWAddons() {
      super("Mw Addons", new String[]{"MwAddons"}, ModuleType.c62580, ModuleType.c21190.c37885);
      this.c36162((new Color(158, 205, 125)).getRGB());
   }

   public void c83205() {
      super.c83205();
   }

   @EventTarget
   public void c73059(PostUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c34018.c72319("AutoRespawn").c1473().booleanValue() && mc.thePlayer.isDead) {
         mc.thePlayer.respawnPlayer();
      }

      if (c34018.c72319("McLook").c1473().booleanValue()) {
         if (Mouse.isButtonDown(2)) {
            mc.gameSettings.thirdPersonView = 1;
            this.c79990 = false;
         }

         if (!this.c79990) {
            mc.gameSettings.thirdPersonView = 0;
            this.c79990 = true;
         }
      }

   }

   @EventTarget
   private void c16267(ChatSendEvent var1) {
      if (c34018.c72319("AutoBack").c1473().booleanValue()) {
         String var2 = var1.c49307();
         HashSet var3 = new HashSet();
         var3.add("Bad client inventory move.");
         var3.add("Flying or related.");
         var3.add("A kick occurred in your connection, so you were put in the MegaWalls Champions lobby!");
         var3.add("A kick occurred in your connection, so you were put in the UHC Champions lobby!");
         var3.add("You were spawned in Limbo.");
         if (var3.contains(var2)) {
            if (mc.thePlayer == null) {
               return;
            }

            this.c50624();
         }
      }

   }

   private void c50624() {
      mc.thePlayer.sendChatMessage("/lobby");
      (new Thread(() -> {
         long var10000 = 150L;

         try {
            Thread.sleep(var10000);
         } catch (InterruptedException var1) {
            var1.printStackTrace();
         }

         mc.thePlayer.sendChatMessage("/back");
      })).start();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
