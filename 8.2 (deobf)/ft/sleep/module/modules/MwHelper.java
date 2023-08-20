//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventChat;
import ft.sleep.api.events.world.EventPostUpdate;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.TextValue;
import java.awt.Color;
import java.util.HashSet;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import org.lwjgl.input.Keyboard;

public class MwHelper extends Module {
   public TextValue packet$ = new TextValue("Look ft.sleep.command.commands.Bind", "2");
   public static ft.sleep.api.value.MultiOptionValue guinea$ = new ft.sleep.api.value.MultiOptionValue("Element", new Option[]{new Option("McLook", true), new Option("NoJumpP", false), new Option("NoJumpP2", true), new Option("AutoBack", true), new Option("AntiSpam", true), new Option("AutoRespawn", true)});
   public boolean polished$;

   public MwHelper() {
      super("MwAddons", new String[]{"MwAddons"}, ModuleType.Combat);
      sepoyocu._piece((new Color(158, 205, 125)).getRGB());
   }

   public void _regime() {
      super._regime();
   }

   public boolean _forests() {
      Object moceyema = Keyboard.getKeyIndex(((String)sesuzume.packet$.getValue()).toUpperCase());
      return Keyboard.isKeyDown(moceyema);
   }

   @EventHandler
   public void _matching(EventPostUpdate var1) {
      if (guinea$.getSetting("AutoRespawn").getValue().booleanValue() && bucifove.mc.thePlayer.isDead) {
         bucifove.mc.thePlayer.respawnPlayer();
      }

      if (guinea$.getSetting("McLook").getValue().booleanValue()) {
         if (bucifove._forests()) {
            bucifove.mc.gameSettings.thirdPersonView = 1;
            bucifove.polished$ = false;
         } else if (!bucifove.polished$) {
            bucifove.mc.gameSettings.thirdPersonView = 0;
            bucifove.polished$ = true;
         }
      }

   }

   @EventHandler
   public void _lessons(EventChat urerepev) {
      if (guinea$.getSetting("AutoBack").getValue().booleanValue()) {
         Object uduconul = ((EventChat)urerepev).getMessage();
         Object falebezo = new HashSet();
         falebezo.add("Bad client inventory move.");
         falebezo.add("Flying or related.");
         falebezo.add("A kick occurred in your connection, so you were put in the MegaWalls Champions lobby!");
         falebezo.add("A kick occurred in your connection, so you were put in the UHC Champions lobby!");
         falebezo.add("You were spawned in Limbo.");
         if (falebezo.contains(uduconul)) {
            if (lusugebo.mc.thePlayer == null) {
               return;
            }

            lusugebo._bunch();
         }
      }

   }

   public void _bunch() {
      onion.mc.thePlayer.sendChatMessage("/lobby");
      (new Thread(onion::_celebs)).start();
   }

   public void _celebs() {
      Thread.sleep((long)1331675426 ^ 1331675572L);
      ifinasam.mc.thePlayer.sendChatMessage("/back");
   }
}
