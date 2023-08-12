package linxiu.utils;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventTick;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.Collection;

public class ServerUtil {
    public static ServerUtil INSTANCE;
    Minecraft mc = Minecraft.getMinecraft();
    public boolean isHypixelScoreboard = false;
    private final TimerUtil timer = new TimerUtil();

    public ServerUtil() {
        INSTANCE = this;
    }

    @EventHandler
    public void onTick(EventTick e) {
        if (timer.delay(1000)) {
            processScoreboard();
            timer.reset();
        }
    }

    public boolean isOnHypixel() {
        return isHypixelScoreboard && !Minecraft.getMinecraft().isSingleplayer();
    }

    public void processScoreboard() {
        Scoreboard scoreboard = this.mc.theWorld.getScoreboard();
        ScoreObjective scoreobjective = null;
        ScorePlayerTeam scoreplayerteam = scoreboard.getPlayersTeam(this.mc.thePlayer.getName());

        if (scoreplayerteam != null) {
            int i1 = scoreplayerteam.getChatFormat().getColorIndex();

            if (i1 >= 0) {
                scoreobjective = scoreboard.getObjectiveInDisplaySlot(3 + i1);
            }
        }

        ScoreObjective scoreobjective1 = scoreobjective != null ? scoreobjective
                : scoreboard.getObjectiveInDisplaySlot(1);

        if (scoreobjective1 != null) {
            fakeRenderScoreboard(scoreobjective1);
        }
    }


    private void fakeRenderScoreboard(ScoreObjective objective) {
        Scoreboard scoreboard = objective.getScoreboard();
        Collection collection = scoreboard.getSortedScores(objective);
        ArrayList arraylist = Lists.newArrayList(Iterables.filter(collection, new Predicate() {

            public boolean apply(Score p_apply_1_) {
                return p_apply_1_.getPlayerName() != null && !p_apply_1_.getPlayerName().startsWith("#");
            }

            public boolean apply(Object p_apply_1_) {
                return this.apply((Score) p_apply_1_);
            }
        }));

        ArrayList arraylist1;

        if (arraylist.size() > 15) {
            arraylist1 = Lists.newArrayList(Iterables.skip(arraylist, collection.size() - 15));
        } else {
            arraylist1 = arraylist;
        }

        for (Object b : arraylist1) {
            Score score1 = (Score) b;
            ScorePlayerTeam scoreplayerteam1 = scoreboard.getPlayersTeam(score1.getPlayerName());
            String s1 = ScorePlayerTeam.formatPlayerName(scoreplayerteam1, score1.getPlayerName());
            int chars = 0;
            String str = "www.hypixel.net";

            for (char c : str.toCharArray()) {
                if (s1.contains(String.valueOf(c))) chars++;
            }

            if (chars == str.length()) {
                ServerUtil.INSTANCE.isHypixelScoreboard = true;
            }
        }
    }
}
