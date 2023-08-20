//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.scaffold;

import com.google.common.base.Predicate;
import net.minecraft.scoreboard.Score;

public class ServerUtil implements Predicate {
   public ServerUtil2 unless$;

   public ServerUtil(ServerUtil2 produced) {
      freeware.unless$ = (ServerUtil2)produced;
      super();
   }

   public boolean _/* $FF was: î ?*/(Score sugilone) {
      return ((Score)sugilone).getPlayerName() != null && !((Score)sugilone).getPlayerName().startsWith("#");
   }

   public boolean apply(Object zatopazi) {
      return vagefive.î ?((Score)zatopazi);
   }
}
