package linxiu.ui;

import java.io.IOException;
import java.net.UnknownHostException;

import linxiu.Client;
import linxiu.module.modules.player.IRC;
import linxiu.utils.PlayerUtils;
import net.minecraft.client.Minecraft;

public class IRCThread extends Thread {
	@Override
	public void run() {
		IRC.connect();
		while (true) {
			IRC.handleInput();
			if (!Client.getINSTANCE().getModuleManager().getModuleByClass(IRC.class).isEnabled()) {
				PlayerUtils.tellPlayer("IRC");
				break;
			}
		}
	}
}
