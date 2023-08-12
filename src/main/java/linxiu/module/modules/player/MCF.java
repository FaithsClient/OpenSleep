/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package linxiu.module.modules.player;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.ChatUtils;
import linxiu.utils.PlayerUtils;
import linxiu.utils.render.ColorUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Mouse;

import java.awt.*;

public class MCF extends Module {
	private boolean down;

	public MCF() {
		super("MCF", new String[] { "middleclickfriends", "middleclick" }, ModuleType.Player);
		this.setColor(new Color(241, 175, 67).getRGB());
	}

	@EventHandler
	private void onClick(EventPreUpdate e) {
		if (mc.currentScreen != null)
			return;

		if (!down && Mouse.isButtonDown(2)) {
			Entity entity = mc.objectMouseOver.entityHit;
			EntityPlayer player = (EntityPlayer) this.mc.objectMouseOver.entityHit;
			String playerName = ColorUtil.stripColor(player.getName());
			if (Client.INSTANCE.getFileManager().friendsConfig.isFriend(playerName)) {
				Client.INSTANCE.getFileManager().friendsConfig.removeFriend(playerName);
				PlayerUtils.tellPlayer("remove " + playerName);
				Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().friendsConfig);
			} else {
				Client.INSTANCE.getFileManager().friendsConfig.addFriend(playerName);
				PlayerUtils.tellPlayer("add " + playerName);
				Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().friendsConfig);
			}
		} else {
			//PlayerUtils.tellPlayer("You need to select a player.");
		}
		down = Mouse.isButtonDown(2);
	}
}
