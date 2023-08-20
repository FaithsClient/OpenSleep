package ft.sleep.util.interfaces;

import com.sun.jna.Callback;
import ft.sleep.util.discord.DiscordUser;

public interface ReadyCallback extends Callback {
   void _shame(DiscordUser var1);
}
