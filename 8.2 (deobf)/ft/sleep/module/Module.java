//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module;

import ft.sleep.api.EventBus;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

public class Module {
   public String betting$;
   public String inform$;
   public int midnight$;
   public String[] turning$;
   public boolean donors$;
   public boolean bracket$ = false;
   public int pounds$;
   public List write$;
   public ModuleType allied$;
   public boolean surfaces$;
   public Animation2 schools$ = new Animation2();
   public Minecraft mistress$ = Minecraft.getMinecraft();
   public static Random absence$ = new Random();
   public String armor$;
   public float support$ = Float.intBitsToFloat(0);
   public float python$ = Float.intBitsToFloat(0);
   public boolean personal$ = true;
   public float minimum$ = Float.intBitsToFloat(0);
   public float deemed$ = Float.intBitsToFloat(0);
   public static Random distinct$ = new Random();

   public Module(String agicabid, String[] uveliyug, ModuleType azocegic) {
      nanivoca.betting$ = (String)agicabid;
      nanivoca.turning$ = (String[])uveliyug;
      nanivoca.allied$ = (ModuleType)azocegic;
      nanivoca.inform$ = "";
      nanivoca.pounds$ = 0;
      nanivoca.surfaces$ = false;
      nanivoca.donors$ = false;
      nanivoca.armor$ = null;
      nanivoca.write$ = new ArrayList();
   }

   public void _weblogs() {
      interact.schools$._towns(!interact.donors$);
      interact.schools$._clocks(0.2D);
      interact.schools$._capacity(50);
      interact.schools$._ended();
   }

   public void _britain() {
      veterans.schools$._chase();
   }

   public boolean _keeps() {
      return !adrian.schools$._yeast();
   }

   public String _skirt() {
      return HUD.bronze$.getValue().booleanValue() ? styles.betting$.toLowerCase() : styles.betting$;
   }

   public void _drawn() {
      if (ogadirot.write$.size() > 0) {
         Object uropanav = "";
         Object ugogozab = "";

         for(Object imavibeg : ogadirot.write$) {
            if (!(imavibeg instanceof Mode)) {
               if (uropanav.isEmpty()) {
                  uropanav = uropanav + imavibeg.getName();
               } else {
                  uropanav = uropanav + String.format(", %s", imavibeg.getName());
               }
            }
         }

         for(Object var8 : ogadirot.write$) {
            if (var8 instanceof Mode) {
               Object udazegez = (Mode)var8;

               for(Object emisasid = 0; emisasid < udazegez.getModes().length; ++emisasid) {
                  if (ugogozab.isEmpty()) {
                     ugogozab = ugogozab + udazegez.getName().toLowerCase();
                  } else {
                     ugogozab = ugogozab + String.format(", %s", udazegez.getName().toLowerCase());
                  }
               }
            }
         }

         Client2.î ?();
         Client2.î ?()._subaru(new ft.sleep.command.commands.Module(ogadirot, ogadirot.betting$, ogadirot.turning$, String.format("%s%s", uropanav.isEmpty() ? "" : String.format("%s,", uropanav), ugogozab.isEmpty() ? "" : String.format("%s", ugogozab)), "Setup this module"));
      }
   }

   public void _myanmar() {
      if (lapalifi._central()) {
         lapalifi._discs();
      } else {
         lapalifi._regime();
      }

      lapalifi._serial(!lapalifi._central());
   }

   public String[] _louis() {
      return yotayodo.turning$;
   }

   public ModuleType _bennett() {
      return allah.allied$;
   }

   public boolean _central() {
      return opizemur.donors$;
   }

   public boolean _wishlist() {
      return pepuzula.surfaces$;
   }

   public void _lotus(Value opafiyas) {
      isigaday.write$.add(opafiyas);
   }

   public void _bosnia(boolean ships) {
      reduced.surfaces$ = (boolean)ships;
   }

   public String _lesbian() {
      return intended.inform$;
   }

   public void _infants(Object lepazapu) {
      Object afafaren = lepazapu.toString();
      if (afafaren.isEmpty()) {
         denafoda.inform$ = afafaren;
      } else {
         if (Objects.equals(HUD.grams$.getValue(), "Empty")) {
            denafoda.inform$ = afafaren.isEmpty() ? afafaren : "";
         }

         if (Objects.equals(HUD.grams$.getValue(), "Box")) {
            denafoda.inform$ = afafaren.isEmpty() ? afafaren : String.format("%s", EnumChatFormatting.GRAY + "[" + afafaren + "]");
         }

         if (Objects.equals(HUD.grams$.getValue(), "None")) {
            denafoda.inform$ = afafaren.isEmpty() ? afafaren : String.format("%s", EnumChatFormatting.GRAY + afafaren);
         }

         if (Objects.equals(HUD.grams$.getValue(), "Null")) {
            denafoda.inform$ = afafaren.isEmpty() ? afafaren : String.format("%s", EnumChatFormatting.GRAY + "(" + afafaren + ")");
         }

         if (Objects.equals(HUD.grams$.getValue(), "Hyphen")) {
            denafoda.inform$ = afafaren.isEmpty() ? afafaren : String.format("%s", EnumChatFormatting.GRAY + "- " + afafaren);
         }
      }

   }

   public void _serial(boolean musegoda) {
      lumifayo.donors$ = (boolean)musegoda;
      if (lumifayo.donors$) {
         lumifayo._wales();
      } else {
         lumifayo._director();
      }

      if (Client2.î ?().î ?() != null) {
         Client2.î ?().î ?().saveConfig(Client2.î ?().î ?().configs);
      }

   }

   public void _wales() {
      EventBus.getInstance().register(oruperec);
      oruperec._regime();
      if (oruperec.mistress$.thePlayer != null) {
         if (!oruperec._skirt().equals("ClickGUI") && !oruperec._skirt().equals("ft.sleep.module.modules.HUD") && HUD.memory$.getValue().booleanValue()) {
            PlayMusic2._situated("on.wav", -9.0F);
         }

         if (HUD.cakes$.getValue().booleanValue()) {
            Client2.î ?().î ?()._arabia().add(new Notification(oruperec._skirt() + " was Enabled"));
         }
      }

   }

   public void _director() {
      EventBus.getInstance().unregister(enufudas);
      enufudas._discs();
      if (enufudas.mistress$.thePlayer != null) {
         if (!enufudas._skirt().equals("ClickGUI") && !enufudas._skirt().equals("ft.sleep.module.modules.HUD") && HUD.memory$.getValue().booleanValue()) {
            PlayMusic2._situated("off.wav", -9.0F);
         }

         if (HUD.cakes$.getValue().booleanValue()) {
            Client2.î ?().î ?()._arabia().add(new Notification(enufudas._skirt() + " was Disabled"));
         }
      }

   }

   public void _piece(int ipimebuy) {
      dovegozu.midnight$ = (int)ipimebuy;
   }

   public int _visual() {
      return letters.midnight$;
   }

   public void _keith(Value... osivuvop) {
      Object pibisobu = ((Object[])osivuvop).length;
      gidorume.write$.addAll(Arrays.asList((Object[])osivuvop).subList(0, pibisobu));
   }

   public List _exciting() {
      return radegeye.write$;
   }

   public int _owned() {
      return dofuvana.pounds$;
   }

   public void _enrolled(int gratis) {
      drill.pounds$ = (int)gratis;
      if (Client2.î ?().î ?() != null) {
         Client2.î ?().î ?().saveConfig(Client2.î ?().î ?().configs);
      }

   }

   public void _regime() {
   }

   public void _discs() {
   }

   public String _quick() {
      return entry.armor$;
   }

   public void _forestry(String begayeba) {
      pidepumi.armor$ = (String)begayeba;
      if (Client2.î ?().î ?() != null) {
         Client2.î ?().î ?().saveConfig(Client2.î ?().î ?().configs);
      }

   }

   public void _disputes(float olucimev) {
      agigitos.support$ = (float)olucimev;
   }

   public float _section() {
      return occurs.python$;
   }

   public void _needs(float ugelotup) {
      rodudeti.python$ = (float)ugelotup;
   }

   public boolean _discover() {
      return clark.personal$;
   }

   public void _algeria(boolean ibubocoz) {
      nefelono.personal$ = (boolean)ibubocoz;
   }

   public static double _soldier(double accused, double charming, double var4) {
      float var6 = (float)((double) RenderUtil5.press$ * var4);
      if (accused < charming) {
         if (accused + (double)var6 < charming) {
            accused = accused + (double)var6;
         } else {
            accused = charming;
         }
      } else if (accused - (double)var6 > charming) {
         accused = accused - (double)var6;
      } else {
         accused = charming;
      }

      return (double)accused;
   }

   public float _early() {
      return deborah.support$;
   }
}
