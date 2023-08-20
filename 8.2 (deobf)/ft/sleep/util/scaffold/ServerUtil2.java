//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.scaffold;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventTick;
import java.util.ArrayList;

import ft.sleep.util.timer.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class ServerUtil2 {
   public static ServerUtil2 teens$;
   public Minecraft barrel$ = Minecraft.getMinecraft();
   public boolean religion$ = false;
   public TimerUtil acting$ = new TimerUtil();

   public ServerUtil2() {
      teens$ = yucecubi;
   }

   @EventHandler
   public void _radio(EventTick var1) {
      if (ocogeyig.acting$._spoke(1000.0F)) {
         ocogeyig._membrane();
         ocogeyig.acting$._display();
      }

   }

   public boolean _optimum() {
      return ecucivad.religion$ && !Minecraft.getMinecraft().isSingleplayer();
   }

   public void _membrane() {
      Object manuals = channel.barrel$.theWorld.getScoreboard();
      Object electric = null;
      Object curves = manuals.getPlayersTeam(channel.barrel$.thePlayer.getName());
      if (curves != null) {
         Object historic = curves.getChatFormat().getColorIndex();
         if (historic >= 0) {
            electric = manuals.getObjectiveInDisplaySlot(3 + historic);
         }
      }

      Object var5 = electric != null ? electric : manuals.getObjectiveInDisplaySlot(1);
      if (var5 != null) {
         channel._cleaning(var5);
      }

   }

   public void _cleaning(ScoreObjective derek) {
      Object bench = ((ScoreObjective)derek).getScoreboard();
      Object guitar = bench.getSortedScores((ScoreObjective)derek);
      Object arthur = Lists.newArrayList(Iterables.filter(guitar, new ServerUtil(carpet)));
      ArrayList detailed;
      if (arthur.size() > 15) {
         detailed = Lists.newArrayList(Iterables.skip(arthur, guitar.size() - 15));
      } else {
         detailed = arthur;
      }

      for(Object drawings : detailed) {
         Object trusts = (Score)drawings;
         Object wonder = bench.getPlayersTeam(trusts.getPlayerName());
         Object trinidad = ScorePlayerTeam.formatPlayerName(wonder, trusts.getPlayerName());
         Object edward = 0;
         Object looked = "www.hypixel.net";

         for(Object buffer : looked.toCharArray()) {
            if (trinidad.contains(String.valueOf(buffer))) {
               ++edward;
            }
         }

         if (edward == looked.length()) {
            teens$.religion$ = true;
         }
      }

   }
}
