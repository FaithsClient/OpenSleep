package rip.sleep.util;

import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

@SideOnly(Side.CLIENT)
public class ServerUtilA {
   private static Minecraft c65213 = Minecraft.getMinecraft();
   public static ServerData c66105;
   private static Pattern c13888 = Pattern.compile("(?i)§[0-9A-FK-OR]");

   public static boolean c96282() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         Scoreboard var1 = c65213.theWorld.getScoreboard();
         ScoreObjective var2 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         String var3 = c1621(var2.getDisplayName());
         String[] var4 = new String[]{"SKYBLOCK", "空岛生存"};
         int var6 = var4.length;
         int var7 = 0;
         if (var7 < var6) {
            String var8 = var4[var7];
            if (var3.contains(var8)) {
               return true;
            }

            ++var7;
         }

         return false;
      }
   }

   public static boolean c77818() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         ScoreObjective var1 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         if (var1 == null) {
            return false;
         } else {
            String var2 = c1621(var1.getDisplayName());
            String[] var3 = new String[]{"SKYWARS", "战争战墙"};
            int var5 = var3.length;
            int var6 = 0;
            if (var6 < var5) {
               String var7 = var3[var6];
               if (var2.contains(var7)) {
                  return true;
               }

               ++var6;
            }

            return false;
         }
      }
   }

   public static boolean c51439() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         ScoreObjective var1 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         if (var1 == null) {
            return false;
         } else {
            String var2 = c1621(var1.getDisplayName());
            String[] var3 = new String[]{"BLITZ SG", "闪电饥饿游戏"};
            int var5 = var3.length;
            int var6 = 0;
            if (var6 < var5) {
               String var7 = var3[var6];
               if (var2.contains(var7)) {
                  return true;
               }

               ++var6;
            }

            return false;
         }
      }
   }

   public static boolean c31099() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         ScoreObjective var1 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         if (var1 == null) {
            return false;
         } else {
            String var2 = c1621(var1.getDisplayName());
            String[] var3 = new String[]{"Pit"};
            int var5 = var3.length;
            int var6 = 0;
            if (var6 < var5) {
               String var7 = var3[var6];
               if (var2.contains(var7)) {
                  return true;
               }

               ++var6;
            }

            return false;
         }
      }
   }

   public static boolean c80409() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         ScoreObjective var1 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         if (var1 == null) {
            return false;
         } else {
            String var2 = c1621(var1.getDisplayName());
            String[] var3 = new String[]{"UHC", "极限生存冠军", "极限生存"};
            int var5 = var3.length;
            int var6 = 0;
            if (var6 < var5) {
               String var7 = var3[var6];
               if (var2.contains(var7)) {
                  return true;
               }

               ++var6;
            }

            return false;
         }
      }
   }

   public static boolean c92750() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         ScoreObjective var1 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         if (var1 == null) {
            return false;
         } else {
            String var2 = c1621(var1.getDisplayName());
            String[] var3 = new String[]{"MEGA WALLS", "超级战墙"};
            int var5 = var3.length;
            int var6 = 0;
            if (var6 < var5) {
               String var7 = var3[var6];
               if (var2.contains(var7)) {
                  return true;
               }

               ++var6;
            }

            return false;
         }
      }
   }

   public static boolean c28223() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         ScoreObjective var1 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         if (var1 == null) {
            return false;
         } else {
            String var2 = c1621(var1.getDisplayName());
            String[] var3 = new String[]{"HYPIXEL UHC", "UHC", "UHC CHAMPIONS", "极限生存冠军", "极限生存"};
            int var5 = var3.length;
            int var6 = 0;
            if (var6 < var5) {
               String var7 = var3[var6];
               if (var2.contains(var7)) {
                  return true;
               }

               ++var6;
            }

            return false;
         }
      }
   }

   public static boolean c60398() {
      Module[] var0 = Value.c27574();
      if (c65213.theWorld == null) {
         return false;
      } else if (c65213.theWorld.getScoreboard() == null) {
         return false;
      } else {
         ScoreObjective var1 = c65213.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
         String var2 = c1621(var1.getDisplayName());
         String[] var3 = new String[]{"MURDER MYSTERY", "密室杀手"};
         int var5 = var3.length;
         int var6 = 0;
         if (var6 < var5) {
            String var7 = var3[var6];
            if (var2.contains(var7)) {
               return true;
            }

            ++var6;
         }

         return false;
      }
   }

   public static String c47269(String var0) {
      return Pattern.compile("[^a-z A-Z]").matcher(var0).replaceAll("");
   }

   public static String c1621(String var0) {
      return c13888.matcher(var0).replaceAll("");
   }

   public static String c27320(String var0) {
      return var0.replaceAll("(?i)\\u00A7.", "");
   }

   public static String c99570(String var0) {
      StringBuilder var2 = new StringBuilder();
      Value.c27574();
      byte var3 = 114;
      boolean var4 = false;
      char[] var5 = var0.toCharArray();
      int var6 = var5.length;
      int var7 = 0;
      if (var7 < var6) {
         char var8 = var5[var7];
         if (var8 <= '썐') {
            if (var8 == 167) {
               var4 = true;
            }

            if (var3 != var8) {
               var2.append('§');
               var2.append(var8);
            }

            var4 = false;
         }

         ++var7;
      }

      return var2.toString();
   }

   public static void c54798() {
      if (c66105 != null) {
         c65213.displayGuiScreen(new GuiConnecting(new GuiMultiplayer(new GuiMainMenu()), c65213, c66105));
      }

   }

   public static String c73904() {
      Value.c27574();
      String var1 = "Singleplayer";
      if (c65213.theWorld.isRemote) {
         ServerData var2 = c65213.getCurrentServerData();
         var1 = var2.serverIP;
      }

      return var1;
   }

   public static boolean c65131(String var0) {
      return c65213.getCurrentServerData().serverIP.contains(var0);
   }

   static {
      Minecraft var10000 = ChatUtilA.mc;
   }

   private static JSONException c36007(JSONException var0) {
      return var0;
   }
}
