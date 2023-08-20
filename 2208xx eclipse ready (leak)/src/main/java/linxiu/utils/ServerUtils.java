/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package linxiu.utils;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ServerUtils extends MinecraftInstance {

	public static ServerData serverData;

	public static void connectToLastServer() {
		if (serverData == null)
			return;

		mc.displayGuiScreen(new GuiConnecting(new GuiMultiplayer(new GuiMainMenu()), mc, serverData));
	}

	public static String getRemoteIp() {
		String serverIp = "Singleplayer";

		if (mc.theWorld.isRemote) {
			final ServerData serverData = mc.getCurrentServerData();
			if (serverData != null)
				serverIp = serverData.serverIP;
		}

		return serverIp;
	}

	public static boolean can_run() {
		if (mc.thePlayer.ticksExisted > 5) {
            return !isHypixelLobby();
		}
		return false;
	}

	public static boolean isHypixelLobby() {
		String target = "CLICK TO PLAY";
		for (Entity entity : mc.theWorld.loadedEntityList) {
			if (entity.getName().startsWith("§e§l")) {
				if (entity.getName().equals("§e§l" + target)) {
					return true;
				}
			}
		}
		return false;
	}
}