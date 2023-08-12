package linxiu.management;


import linxiu.Client;
import linxiu.utils.render.ColorUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;



public class PlayerManager {
    public static boolean isFriend(final Entity entity) {
        return entity instanceof EntityPlayer && entity.getName() != null &&
                Client.getINSTANCE().getFileManager().friendsConfig.isFriend(ColorUtil.stripColor(entity.getName()));
    }


    public static boolean isTarget(final Entity entity) {
        return entity instanceof EntityPlayer && entity.getName() != null &&
                Client.getINSTANCE().getFileManager().targetConfig.isTarget(ColorUtil.stripColor(entity.getName()));
    }




}
