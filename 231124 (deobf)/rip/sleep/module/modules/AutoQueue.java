package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Iterator;
import java.util.Objects;

import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.IChatComponent;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.ServerUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;
import rip.sleep.value.values.StringValue;

public class AutoQueue extends Module {
   private final ModeValue c37524 = new ModeValue("Mode", new String[]{"Standard", "FaceOff"}, "Standard");
   public static BooleanValue c60331 = new BooleanValue("Auto GG", true);
   public static BooleanValue c37493 = new BooleanValue("Auto Play", true);
   public static BooleanValue c75964 = new BooleanValue("Anti Afk", true);
   private final NumberValue<Number> c29647 = new NumberValue<Number>("GG Time", () -> {
      return c60331.c1473();
   }, Integer.valueOf(5000), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(500));
   private final NumberValue<Number> c10237 = new NumberValue<Number>("Play Time", () -> {
      return c37493.c1473();
   }, Integer.valueOf(5000), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(500));
   private final StringValue c54753 = new StringValue("GG Text", () -> {
      return c60331.c1473();
   }, "#Sleep");

   public AutoQueue() {
      super("Auto Queue", new String[]{"AutoQueue"}, ModuleType.c31770, ModuleType.c21190.c76367);
      this.c36162((new Color(158, 205, 125)).getRGB());
   }

   public void c83205() {
   }

   @EventTarget
   public void c57048(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (ServerUtilA.c77818()) {
         Packet var3 = PacketReceiveEvent.getPacket();
         if (var3 instanceof S02PacketChat) {
            S02PacketChat var4 = (S02PacketChat)var3;
            if (var4.getChatComponent().getFormattedText().contains("play again?")) {
               Iterator var5 = var4.getChatComponent().getSiblings().iterator();
               if (var5.hasNext()) {
                  IChatComponent var6 = (IChatComponent)var5.next();
                  String[] var7 = var6.toString().split("'");
                  int var8 = var7.length;
                  int var9 = 0;
                  if (var9 < var8) {
                     String var10 = var7[var9];
                     if (var10.startsWith("/play") && !var10.contains(".")) {
                        if (c60331.c1473().booleanValue()) {
                           (new Thread(() -> {
                              NumberValue var10000 = this.c29647;

                              try {
                                 Thread.sleep(var10000.c53968().longValue());
                              } catch (InterruptedException var2) {
                                 var2.printStackTrace();
                              }

                              mc.thePlayer.sendChatMessage("GG " + ((String)this.c54753.c36545()).replace('&', '§'));
                           })).start();
                        }

                        if (c37493.c1473().booleanValue()) {
                           (new Thread(() -> {
                              NumberValue var10000 = this.c10237;

                              try {
                                 Thread.sleep(var10000.c53968().longValue());
                              } catch (InterruptedException var3) {
                                 var3.printStackTrace();
                              }

                              mc.thePlayer.sendChatMessage(var10);
                           })).start();
                        }

                        if (!c37493.c1473().booleanValue()) {
                           return;
                        }

                        Sleep.getInstance().c83083().c43114().add(new Notification("Auto PlayJoined a new game", this.c10237.c53968().longValue()));
                     }

                     ++var9;
                  }
               }
            }
         }

      }
   }

   @EventTarget
   public void c31327(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (ServerUtilA.c92750()) {
         if (PacketReceiveEvent.getPacket() instanceof S02PacketChat) {
            S02PacketChat var3 = (S02PacketChat) PacketReceiveEvent.getPacket();
            String var4 = var3.getChatComponent().getUnformattedText();
            if (var4.contains("Winner - Red Team") || var4.contains("Winner - Blue Team") || var4.contains("Winner - Green Team") || var4.contains("Winner - Yellow Team")) {
               if (c60331.c1473().booleanValue()) {
                  (new Thread(() -> {
                     NumberValue var10000 = this.c29647;

                     try {
                        Thread.sleep(var10000.c53968().longValue());
                     } catch (InterruptedException var2) {
                        var2.printStackTrace();
                     }

                     mc.thePlayer.sendChatMessage("GG " + ((String)this.c54753.c36545()).replace('&', '§'));
                  })).start();
               }

               if (c37493.c1473().booleanValue()) {
                  (new Thread(() -> {
                     Module[] var1 = Value.c27574();
                     NumberValue var10000 = this.c10237;

                     try {
                        Thread.sleep(var10000.c53968().longValue());
                     } catch (InterruptedException var3) {
                        var3.printStackTrace();
                     }

                     String var2 = "/play mw_" + (Objects.equals(this.c37524.c54460(), "Standard") ? "standard" : "face_off");
                     mc.thePlayer.sendChatMessage(var2);
                  })).start();
               }
            }

            if (c75964.c1473().booleanValue() && var4.contains("You are AFK. Move around to return from AFK.")) {
               mc.thePlayer.sendChatMessage("/l");
               mc.thePlayer.sendChatMessage("/l mw");
            }
         }

      }
   }

   private static Exception c16603(Exception var0) {
      return var0;
   }
}
