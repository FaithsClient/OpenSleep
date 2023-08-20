//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.TextValue;
import java.awt.Color;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.notification.Notification;
import ft.sleep.util.scaffold.ServerUtils;
import net.minecraft.network.play.server.S02PacketChat;

public class AutoQueue extends Module {
   public Mode mills$ = new Mode("Mode", new String[]{"Standard", "FaceOff"}, "Standard");
   public static Option greene$ = new Option("Auto GG", true);
   public static Option decor$ = new Option("Auto Play", true);
   public static Option began$ = new Option("Anti Afk", true);
   public Numbers pharmacy$ = new Numbers("GG Time", Integer.valueOf(5000), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(500));
   public Numbers textiles$ = new Numbers("Play Time", Integer.valueOf(5000), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(500));
   public TextValue passive$ = new TextValue("GG Text", "#Sleep");

   public AutoQueue() {
      super("Auto Queue", new String[]{"ft.sleep.module.modules.AutoQueue"}, ModuleType.Combat);
      bilibuye._piece((new Color(158, 205, 125)).getRGB());
   }

   public void _regime() {
   }

   @EventHandler
   public void _minerals(EventPacketReceive irazaten) {
      if (ServerUtils._trend()) {
         Object acavelud = EventPacketReceive.getPacket();
         if (acavelud instanceof S02PacketChat) {
            Object yirezuya = (S02PacketChat)acavelud;
            if (yirezuya.getChatComponent().getFormattedText().contains("play again?")) {
               for(Object elegitoy : yirezuya.getChatComponent().getSiblings()) {
                  for(String var9 : elegitoy.toString().split("'")) {
                     if (var9.startsWith("/play") && !var9.contains(".")) {
                        if (greene$.getValue().booleanValue()) {
                           (new Thread(yabolume::_handled)).start();
                        }

                        if (decor$.getValue().booleanValue()) {
                           (new Thread(yabolume::_slope)).start();
                        }

                        if (decor$.getValue().booleanValue()) {
                           Client.î ?().î ?()._arabia().add(new Notification("Auto PlayJoined a new game", yabolume.textiles$.getValue().longValue()));
                        }
                        break;
                     }
                  }
               }
            }
         }

      }
   }

   @EventHandler
   public void _below(EventPacketReceive azinadic) {
      if (ServerUtils._comedy()) {
         if (EventPacketReceive.getPacket() instanceof S02PacketChat) {
            Object zututulu = (S02PacketChat)EventPacketReceive.getPacket();
            String var3 = zututulu.getChatComponent().getUnformattedText();
            if (var3.contains("Winner - Red Team") || var3.contains("Winner - Blue Team") || var3.contains("Winner - Green Team") || var3.contains("Winner - Yellow Team")) {
               if (greene$.getValue().booleanValue()) {
                  (new Thread(duvetoca::_lives)).start();
               }

               if (decor$.getValue().booleanValue()) {
                  (new Thread(duvetoca::_missing)).start();
               }
            }

            if (began$.getValue().booleanValue() && var3.contains("You are AFK. Move around to return from AFK.")) {
               duvetoca.mc.thePlayer.sendChatMessage("/l");
               duvetoca.mc.thePlayer.sendChatMessage("/l mw");
            }
         }

      }
   }

   public void _missing() {
      Thread.sleep(accent.textiles$.getValue().longValue());
      Object achieved = "/play mw_" + (Objects.equals(accent.mills$.getValue(), "Standard") ? "standard" : "face_off");
      accent.mc.thePlayer.sendChatMessage(achieved);
   }

   public void _lives() {
      Thread.sleep(around.pharmacy$.getValue().longValue());
      around.mc.thePlayer.sendChatMessage("GG " + ((String)around.passive$.getValue()).replace('&', 'Â§'));
   }

   public void _slope(String zusevelu) {
      Thread.sleep(vigosito.textiles$.getValue().longValue());
      vigosito.mc.thePlayer.sendChatMessage((String)zusevelu);
   }

   public void _handled() {
      Thread.sleep(irosomip.pharmacy$.getValue().longValue());
      irosomip.mc.thePlayer.sendChatMessage("GG " + ((String)irosomip.passive$.getValue()).replace('&', 'Â§'));
   }
}
