//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.player;

import ft.sleep.Client;
import ft.sleep.util.color.ColorUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerManager {
   public static boolean _deviant(Entity azofecuf) {
      return azofecuf instanceof EntityPlayer && ((Entity)azofecuf).getName() != null && Client.î ?().î ?().friendsConfig.isFriend(ColorUtil._attacked(((Entity)azofecuf).getName()));
   }

   public static boolean _pension(Entity gitenulu) {
      return gitenulu instanceof EntityPlayer && ((Entity)gitenulu).getName() != null && Client.î ?().î ?().targetConfig.isTarget(ColorUtil._attacked(((Entity)gitenulu).getName()));
   }
}
