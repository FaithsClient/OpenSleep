package rip.sleep.module.modules;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.util.HashMap;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.ChatReceivedEvent;
import rip.sleep.event.events.ClickEvent;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.wrapper.ChatWrapper;

public class ChatTranslator extends Module {
   private HashMap c43847 = new HashMap();
   public ModeValue c53711 = new ModeValue("Send Language", new String[]{"Chinese", "English"}, "English");
   public ModeValue c76168 = new ModeValue("Click Language", new String[]{"Chinese", "English"}, "English");
   public ModeValue c65648 = new ModeValue("Other Language", new String[]{"Chinese", "English"}, "English");
   public static BooleanValue c67628 = new BooleanValue("Party", false);
   public static BooleanValue c82158 = new BooleanValue("Msg", true);
   public static BooleanValue c36069 = new BooleanValue("Guild", false);
   public static BooleanValue c56199 = new BooleanValue("Send Translator", true);
   public static BooleanValue c4490 = new BooleanValue("Click Translator", true);

   public ChatTranslator() {
      super("Chat Translator", new String[]{"ChatTranslator", "translator"}, ModuleType.c31770, ModuleType.c21190.c76367);
      this.c36162((new Color(218, 97, 127)).getRGB());
   }

   @EventTarget
   public void c31580(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (PacketSendEvent.c81894() instanceof C01PacketChatMessage) {
         C01PacketChatMessage var5 = (C01PacketChatMessage) PacketSendEvent.c81894();
         if (c56199.c1473().booleanValue() && var5.getMessage().contains("fy-")) {
            var1.c8253(true);
            String var3 = c54716(var5.getMessage(), "", "fy-");
            String var4 = c54716(var5.getMessage(), "fy-", "");
            this.c70959(var3, var4);
         }
      }

      if (PacketSendEvent.c81894() instanceof C01PacketChatMessage) {
         C01PacketChatMessage var8 = (C01PacketChatMessage) PacketSendEvent.c81894();
         if (c4490.c1473().booleanValue() && var8.getMessage().contains("fy1-")) {
            var1.c8253(true);
            String var6 = c54716(var8.getMessage(), "", "fy1-");
            String var7 = c54716(var8.getMessage(), "fy1-", "");
            this.c69656(var6, var7);
         }
      }

   }

   @EventTarget
   public void c73308(ChatReceivedEvent var1) {
      if (c4490.c1473().booleanValue()) {
         var1.c70851().appendSibling((new ChatComponentText(EnumChatFormatting.GRAY + " [T]")).setChatStyle((new ChatStyle()).setChatClickEvent(new ClickEvent(Action.RUN_COMMAND, (new StringBuilder()).insert(0, "fy1-").append(EnumChatFormatting.getTextWithoutFormattingCodes(var1.c49307())).toString())).setChatHoverEvent(new HoverEvent(net.minecraft.event.HoverEvent.Action.SHOW_TEXT, new ChatComponentText("Click on this to Translator this message.")))));
      }

   }

   @EventTarget
   public void c98799(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (PacketReceiveEvent.getPacket() instanceof S02PacketChat) {
         S02PacketChat var5 = (S02PacketChat) PacketReceiveEvent.getPacket();
         String var3 = var5.getChatComponent().getUnformattedText();
         if (this.c14673(var5.getChatComponent())) {
            String var4 = c54716(var5.getChatComponent().getFormattedText(), "", ":");
            String var6 = c54716(var3, ": ", "");
            if (!this.c43847.containsKey(var6)) {
               this.c42799(var4, var6);
            }

            var1.c8253(true);
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(var5.getChatComponent());
            ChatWrapper.c77151("§8[CT] " + var4 + ": §3" + (String)this.c43847.getOrDefault(var6, var6));
         }
      }

   }

   private String c62696(String var1) {
      Value.c27574();
      boolean var3 = Objects.equals(this.c53711.c54460(), "Chinese");
      return "https://translate.googleapis.com/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=" + "zh_cn" + "&q=" + var1;
   }

   private String c47392(String var1) {
      Value.c27574();
      boolean var3 = Objects.equals(this.c76168.c54460(), "Chinese");
      return "https://translate.googleapis.com/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=" + "zh_cn" + "&q=" + var1;
   }

   private String c8447(String var1) {
      Value.c27574();
      boolean var3 = Objects.equals(this.c65648.c54460(), "Chinese");
      return "https://translate.googleapis.com/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=" + "zh_cn" + "&q=" + var1;
   }

   private String c49607(String var1) {
      JsonObject var2 = (new JsonParser()).parse(var1).getAsJsonObject();
      return var2.get("sentences").getAsJsonArray().get(0).getAsJsonObject().get("trans").getAsString();
   }

   public static String c54716(String var0, String var1, String var2) {
      Value.c27574();
      String var4 = "";
      if (var0.isEmpty()) {
         boolean var5 = false;
      }

      int var8 = var0.indexOf(var1);
      if (var8 > -1) {
         int var10000 = var8 + var1.length();
      }

      var8 = 0;
      int var6 = var0.indexOf(var2, var8);
      if (var2.isEmpty()) {
         var6 = var0.length();
      }

      var4 = var0.substring(var8, var6);
      return var4;
   }

   private boolean c14673(IChatComponent var1) {
      Value.c27574();
      String var3 = var1.getFormattedText();
      if (c67628.c1473().booleanValue() && var3.startsWith("§r§9") && var3.contains(":") && var3.contains(">")) {
         return true;
      } else if (c36069.c1473().booleanValue() && var3.startsWith("§r§2Guild") && var3.contains(":") && var3.contains(">")) {
         return true;
      } else {
         return c82158.c1473().booleanValue() && var3.startsWith("§d") && var3.contains(":") && (var3.contains("From") || var3.contains("To"));
      }
   }

   private void c70959(String var1, String var2) {
      (new Thread(() -> {
         this.c4988(var1, var2);
      })).start();
   }

   private void c4988(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private void c69656(String var1, String var2) {
      (new Thread(() -> {
         this.c49575(var1, var2);
      })).start();
   }

   private void c49575(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private void c42799(String var1, String var2) {
      (new Thread(() -> {
         this.c41076(var1, var2);
      })).start();
   }

   private void c41076(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private static Throwable c70969(Throwable var0) {
      return var0;
   }
}
