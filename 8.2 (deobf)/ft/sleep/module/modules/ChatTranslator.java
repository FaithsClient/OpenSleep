//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import com.google.gson.JsonParser;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.ChatEvent;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Option;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.math.MathUtils;
import ft.sleep.util.packet.PacketUtils;
import ft.sleep.util.player.ChatUtils2;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class ChatTranslator extends Module {
   public HashMap chest$ = new HashMap();
   public Mode learned$ = new Mode("Api", new String[]{"YouDao"}, "YouDao");
   public Mode baghdad$ = new Mode("Language", new String[]{"Chinese", "English"}, "English");
   public static Option language$ = new Option("Party", false);
   public static Option raises$ = new Option("Msg", true);
   public static Option animated$ = new Option("Guild", false);
   public static Option project$ = new Option("Send Translator", true);
   public static Option erotica$ = new Option("Click Translator", true);

   public ChatTranslator() {
      super("Chat Translator", new String[]{"ft.sleep.module.modules.ChatTranslator", "translator"}, ModuleType.Player);
      zesadane._piece((new Color(218, 97, 127)).getRGB());
   }

   @EventHandler
   public void _banana(EventPacketSend lines) {
      if (EventPacketSend.getPacket() instanceof C01PacketChatMessage) {
         Object tomorrow = (C01PacketChatMessage)EventPacketSend.getPacket();
         if (project$.getValue().booleanValue() && tomorrow.getMessage().contains("fy-")) {
            ((EventPacketSend)lines).setCancelled(true);
            Object winners = _finnish(tomorrow.getMessage(), "", "fy-");
            Object danger = _finnish(tomorrow.getMessage(), "fy-", "");
            shooting._tubes(winners, danger);
         }
      }

      if (EventPacketSend.getPacket() instanceof C01PacketChatMessage) {
         Object var7 = (C01PacketChatMessage)EventPacketSend.getPacket();
         if (erotica$.getValue().booleanValue() && var7.getMessage().contains("fy1-")) {
            ((EventPacketSend)lines).setCancelled(true);
            Object var5 = _finnish(var7.getMessage(), "", "fy1-");
            Object var6 = _finnish(var7.getMessage(), "fy1-", "");
            shooting._earned(var5, var6);
         }
      }

   }

   @EventHandler
   public void _bowling(ChatEvent travel) {
      if (erotica$.getValue().booleanValue()) {
         ((ChatEvent)travel).getChatComponent().appendSibling((new ChatComponentText(EnumChatFormatting.GRAY + " [T]")).setChatStyle((new ChatStyle()).setChatClickEvent(new ClickEvent(Action.RUN_COMMAND, (new StringBuilder()).insert(0, "fy1-").append(EnumChatFormatting.getTextWithoutFormattingCodes(((ChatEvent)travel).getMessage())).toString())).setChatHoverEvent(new HoverEvent(net.minecraft.event.HoverEvent.Action.SHOW_TEXT, new ChatComponentText("Click on this to Translator this message.")))));
      }

   }

   @EventHandler
   public void _japanese(EventPacketReceive rimofafu) {
      if (EventPacketReceive.getPacket() instanceof S02PacketChat) {
         Object imeyumeg = (S02PacketChat)EventPacketReceive.getPacket();
         Object refasipa = imeyumeg.getChatComponent().getUnformattedText();
         if (ivazeluf._split(imeyumeg.getChatComponent())) {
            Object taponeco = _finnish(imeyumeg.getChatComponent().getFormattedText(), "", ":");
            Object bizenemi = _finnish(refasipa, ": ", "");
            if (!ivazeluf.chest$.containsKey(bizenemi)) {
               ivazeluf._workflow(taponeco, bizenemi);
            } else {
               ((EventPacketReceive)rimofafu).setCancelled(true);
               Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(imeyumeg.getChatComponent());
               ChatUtils2._wonder("§8[CT] " + taponeco + ": §3" + (String)ivazeluf.chest$.getOrDefault(bizenemi, bizenemi));
            }
         }
      }

   }

   public String _rated(String davidson) {
      Object stable = Objects.equals(dubai.baghdad$.getValue(), "chinese");
      Object lighter = dubai.learned$.getValue();
      byte var4 = -1;
      switch(lighter.hashCode()) {
      case -1640908013:
         if (lighter.equals("YouDao")) {
            var4 = 0;
         }
      default:
         switch(var4) {
         case 0:
            return "https://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i=" + davidson;
         default:
            return "";
         }
      }
   }

   public String _unity(String bottom) {
      Object casting = beaches.learned$.getValue();
      Object house = -1;
      switch(casting.hashCode()) {
      case -1640908013:
         if (casting.equals("YouDao")) {
            house = 0;
         }
      default:
         switch(house) {
         case 0:
            Object respect = (new JsonParser()).parse((String)bottom).getAsJsonObject();
            return respect.get("translateResult").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsJsonObject().get("tgt").getAsString();
         default:
            return "WRONG VALUE";
         }
      }
   }

   public static String _finnish(String pusevule, String yitorobo, String unidemam) {
      Object desagupi = "";
      int pezipise;
      if (((String)pusevule).isEmpty()) {
         pezipise = 0;
      } else {
         pezipise = ((String)pusevule).indexOf((String)yitorobo);
         if (pezipise > -1) {
            pezipise = pezipise + ((String)yitorobo).length();
         } else {
            pezipise = 0;
         }
      }

      Object meceliro = ((String)pusevule).indexOf((String)unidemam, pezipise);
      if (((String)unidemam).isEmpty()) {
         meceliro = ((String)pusevule).length();
      }

      desagupi = ((String)pusevule).substring(pezipise, meceliro);
      return desagupi;
   }

   public boolean _split(IChatComponent fields) {
      Object hundreds = ((IChatComponent)fields).getFormattedText();
      if (language$.getValue().booleanValue() && hundreds.startsWith("§r§9") && hundreds.contains(":") && hundreds.contains(">")) {
         return true;
      } else if (animated$.getValue().booleanValue() && hundreds.startsWith("§r§2Guild") && hundreds.contains(":") && hundreds.contains(">")) {
         return true;
      } else {
         return raises$.getValue().booleanValue() && hundreds.startsWith("§d") && hundreds.contains(":") && (hundreds.contains("From") || hundreds.contains("To"));
      }
   }

   public void _tubes(String pelepiyi, String zevecata) {
      (new Thread(imaburac::_moral)).start();
   }

   public void _expired(String iduzolur, String osodocom) {
      Object edeladoz = HttpClients.createDefault();
      Object gazubase = null;
      Object subegaye = new URL(afapepoc._rated((String)osodocom));
      Object efoyirov = new URI(subegaye.getProtocol(), subegaye.getUserInfo(), subegaye.getHost(), subegaye.getPort(), subegaye.getPath(), subegaye.getQuery(), subegaye.getRef());
      Object yibozapo = efoyirov.toString();
      Object upunodoc = new HttpGet(yibozapo);
      upunodoc.setHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Mobile Safari/537.36");
      Object odusigit = "null";
      Object amazutal = edeladoz.execute(upunodoc);
      Object zetinizi = null;
      Object visolosu = new BufferedReader(new InputStreamReader(amazutal.getEntity().getContent(), StandardCharsets.UTF_8));
      Object asepameb = null;
      Object zefidivu = new StringBuilder();

      String ratecunu;
      while((ratecunu = visolosu.readLine()) != null) {
         zefidivu.append(ratecunu);
      }

      odusigit = zefidivu.toString();
      if (visolosu != null) {
         if (asepameb != null) {
            visolosu.close();
         } else {
            visolosu.close();
         }
      }

      if (amazutal != null) {
         if (zetinizi != null) {
            amazutal.close();
         } else {
            amazutal.close();
         }
      }

      Object var23 = afapepoc._unity(odusigit);
      zetinizi = iduzolur + var23;
      PacketUtils._payroll(new C01PacketChatMessage(zetinizi));
      afapepoc.chest$.put(iduzolur, zetinizi);
      if (edeladoz != null) {
         if (gazubase != null) {
            edeladoz.close();
         } else {
            edeladoz.close();
         }
      }

   }

   public void _earned(String virepode, String segovubu) {
      (new Thread(icopofim::_dialog)).start();
   }

   public void _airline(String jeffrey, String homework) {
      Object briefing = HttpClients.createDefault();
      Object notre = null;
      Object cricket = new URL(couple._rated((String)homework));
      Object keywords = new URI(cricket.getProtocol(), cricket.getUserInfo(), cricket.getHost(), cricket.getPort(), cricket.getPath(), cricket.getQuery(), cricket.getRef());
      Object hamilton = keywords.toString();
      Object budget = new HttpGet(hamilton);
      budget.setHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Mobile Safari/537.36");
      Object toronto = "null";
      Object anatomy = briefing.execute(budget);
      Object monster = null;
      Object exterior = new BufferedReader(new InputStreamReader(anatomy.getEntity().getContent(), StandardCharsets.UTF_8));
      Object brass = null;
      Object fever = new StringBuilder();

      String founder;
      while((founder = exterior.readLine()) != null) {
         fever.append(founder);
      }

      toronto = fever.toString();
      if (exterior != null) {
         if (brass != null) {
            exterior.close();
         } else {
            exterior.close();
         }
      }

      if (anatomy != null) {
         if (monster != null) {
            anatomy.close();
         } else {
            anatomy.close();
         }
      }

      Object var23 = couple._unity(toronto);
      Object var24 = true;
      Object var26 = MathUtils._ultram(1, 9);
      if (var24) {
         ChatUtils2._wonder("§8[CT] " + jeffrey + ": §" + var26 + var23);
         couple.chest$.put(jeffrey, var23);
         var24 = false;
      }

      if (briefing != null) {
         if (notre != null) {
            briefing.close();
         } else {
            briefing.close();
         }
      }

   }

   public void _workflow(String idamazir, String sebabipa) {
      (new Thread(dunavoma::_making)).start();
   }

   public void _waves(String avovumol, String difonufi) {
      Object ipogafip = HttpClients.createDefault();
      Object fobipoli = new URL(folulivi._rated((String)difonufi));
      Object lagufana = new URI(fobipoli.getProtocol(), fobipoli.getUserInfo(), fobipoli.getHost(), fobipoli.getPort(), fobipoli.getPath(), fobipoli.getQuery(), fobipoli.getRef());
      Object eyiyitum = lagufana.toString();
      Object atavibez = new HttpGet(eyiyitum);
      atavibez.setHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Mobile Safari/537.36");
      Object abalamid = "null";
      Object usemeyiz = ipogafip.execute(atavibez);
      Object uzufimoy = null;
      Object obemilac = new BufferedReader(new InputStreamReader(usemeyiz.getEntity().getContent(), StandardCharsets.UTF_8));
      Object ituviges = null;
      Object bibofoco = new StringBuilder();

      String felapaza;
      while((felapaza = obemilac.readLine()) != null) {
         bibofoco.append(felapaza);
      }

      abalamid = bibofoco.toString();
      if (obemilac != null) {
         if (ituviges != null) {
            obemilac.close();
         } else {
            obemilac.close();
         }
      }

      if (usemeyiz != null) {
         if (uzufimoy != null) {
            usemeyiz.close();
         } else {
            usemeyiz.close();
         }
      }

      Object var20 = folulivi._unity(abalamid);
      ChatUtils2._wonder("§8[CT] " + avovumol + ": §3" + var20);
      folulivi.chest$.put(avovumol, var20);
   }

   public void _making(String typing, String screw) {
      forever._waves((String)typing, (String)screw);
   }

   public void _dialog(String clara, String search) {
      theaters._airline((String)clara, (String)search);
   }

   public void _moral(String guvegebu, String cunobica) {
      gozigami._expired((String)guvegebu, (String)cunobica);
   }
}
