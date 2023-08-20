//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.scaffold;

import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ServerUtils {
   public static Minecraft boring$ = Minecraft.getMinecraft();
   public static ServerData tucson$;
   public static Pattern legally$ = Pattern.compile("(?i)§[0-9A-FK-OR]");

   public static boolean _handbook() {
      Object sarepeva = boring$.theWorld.getScoreboard();
      Object nosidebu = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      Object enopulom = _disposal(nosidebu.getDisplayName());
      Object teyonuce = new String[]{"SKYBLOCK", "空岛生存"};

      for(String var7 : teyonuce) {
         if (enopulom.contains(var7)) {
            return true;
         }
      }

      return false;
   }

   public static boolean _trend() {
      Object izimizof = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      if (izimizof == null) {
         return false;
      } else {
         Object azobazon = _disposal(izimizof.getDisplayName());
         Object ayofuyon = new String[]{"SKYWARS", "战争战墙"};

         for(Object mimunuza : ayofuyon) {
            if (azobazon.contains(mimunuza)) {
               return true;
            }
         }

         return false;
      }
   }

   public static boolean _bloom() {
      Object iyapifos = boring$.theWorld.getScoreboard();
      Object acisibel = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      Object litodivu = _disposal(acisibel.getDisplayName());
      Object idefutas = new String[]{"BLITZ SG", "闪电饥饿游戏"};

      for(String var7 : idefutas) {
         if (litodivu.contains(var7)) {
            return true;
         }
      }

      return false;
   }

   public static boolean _optical() {
      Object ucozesor = boring$.theWorld.getScoreboard();
      Object abinagav = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      Object zigacizi = _disposal(abinagav.getDisplayName());
      Object aralapir = new String[]{"Pit"};

      for(String var7 : aralapir) {
         if (zigacizi.contains(var7)) {
            return true;
         }
      }

      return false;
   }

   public static boolean _charges() {
      Object vapuyiru = boring$.theWorld.getScoreboard();
      Object oretofev = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      Object evogidim = _disposal(oretofev.getDisplayName());
      Object ogobetel = new String[]{"UHC", "极限生存冠军", "极限生存", "闪电饥饿游戏", "BLITZ SG", "MEGA WALLS", "超级战墙", "丢锅大战"};

      for(String var7 : ogobetel) {
         if (evogidim.contains(var7)) {
            return true;
         }
      }

      return false;
   }

   public static boolean _comedy() {
      Object enovefol = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      if (enovefol == null) {
         return false;
      } else {
         Object bidayeca = _disposal(enovefol.getDisplayName());
         Object ucemomum = new String[]{"MEGA WALLS", "超级战墙"};

         for(Object ovetibut : ucemomum) {
            if (bidayeca.contains(ovetibut)) {
               return true;
            }
         }

         return false;
      }
   }

   public static boolean _ordering() {
      Object odusodup = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      if (odusodup == null) {
         return false;
      } else {
         Object royemege = _disposal(odusodup.getDisplayName());
         Object gupagomu = new String[]{"HYPIXEL UHC", "UHC", "UHC CHAMPIONS", "极限生存冠军", "极限生存"};

         for(Object rovesaya : gupagomu) {
            if (royemege.contains(rovesaya)) {
               return true;
            }
         }

         return false;
      }
   }

   public static boolean _leeds() {
      Object cebizutu = boring$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
      Object matizasa = _disposal(cebizutu.getDisplayName());
      Object uzilifid = new String[]{"MURDER MYSTERY", "密室�?�?"};

      for(Object uneyiyic : uzilifid) {
         if (matizasa.contains(uneyiyic)) {
            return true;
         }
      }

      return false;
   }

   public static String _occasion(String iloyinab) {
      return Pattern.compile("[^a-z A-Z]").matcher((CharSequence)iloyinab).replaceAll("");
   }

   public static String _disposal(String dallas) {
      return legally$.matcher((CharSequence)dallas).replaceAll("");
   }

   public static String _writings(String sepefota) {
      return ((String)sepefota).replaceAll("(?i)\\u00A7.", "");
   }

   public static String _deaths(String diyuyidu) {
      Object ofuzasem = new StringBuilder();
      Object udapicim = 'r';
      Object meconosu = false;

      for(char var7 : ((String)diyuyidu).toCharArray()) {
         if (var7 <= '�?') {
            if (var7 == 167) {
               meconosu = true;
            } else {
               if (udapicim != var7) {
                  ofuzasem.append('§');
                  ofuzasem.append(var7);
                  udapicim = var7;
               }

               meconosu = false;
            }
         }
      }

      return ofuzasem.toString();
   }

   public static void _debut() {
      if (tucson$ != null) {
         boring$.displayGuiScreen(new GuiConnecting(new GuiMultiplayer(new GuiMainMenu()), boring$, tucson$));
      }

   }

   public static String _hanging() {
      Object yasayure = "Singleplayer";
      if (boring$.theWorld.isRemote) {
         Object meditiro = boring$.getCurrentServerData();
         yasayure = meditiro.serverIP;
      }

      return yasayure;
   }

   public static boolean _supply(String pobeloti) {
      return boring$.getCurrentServerData().serverIP.contains((CharSequence)pobeloti);
   }
}
