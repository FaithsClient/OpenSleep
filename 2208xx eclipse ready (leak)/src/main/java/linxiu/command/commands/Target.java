package linxiu.command.commands;

import linxiu.Client;
import linxiu.command.Command;
import linxiu.config.configs.TargetConfig;
import linxiu.ui.notification.Notification;
import linxiu.utils.PlayerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public class Target extends Command {

	public Target() {
		super("Target", new String[] { "Target", "target" }, "target", "Target Player");
	}

	public Type type;

	@Override
	public String execute(String[] args) {
		if (args.length >= 2) {
			switch (args[0]) {
			case "add":
				type = Type.Add;
				break;
			case "remove":
				type = Type.Remove;
				break;
			case "clear":
				type = Type.Clear;
				break;
			case "list":
				type = Type.List;
				break;
			}

			if (type == Type.Add && !args[1].isEmpty()) {
				Client.INSTANCE.getFileManager().targetConfig.addTarget(args[1]);
				Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().targetConfig);

				PlayerUtils.tellPlayer("Add Target : " + args[1]);
				Client.INSTANCE.getNotificationManager().getNotifications()
						.add(new Notification("Add target " + args[1]));

			} else if (type == Type.Remove && !args[1].isEmpty()) {
				Client.INSTANCE.getFileManager().targetConfig.removeTarget(args[1]);
				Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().targetConfig);

				PlayerUtils.tellPlayer("Remove Target : " + args[1]);
				Client.INSTANCE.getNotificationManager().getNotifications()
						.add(new Notification("Remove target " + args[1]));

			}

		} else if (type == Type.Clear) {
			Client.INSTANCE.getFileManager().targetConfig.clearTarget();
			Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().targetConfig);

			PlayerUtils.tellPlayer("Clear Target");
			Client.INSTANCE.getNotificationManager().getNotifications().add(new Notification("Clear targets"));

		} else if (type == Type.List) {
			PlayerUtils.tellPlayer("---" + " You have "
					+ Client.INSTANCE.getFileManager().targetConfig.getTargets().size() + " Targets ---");
			for (TargetConfig.Target target : Client.INSTANCE.getFileManager().targetConfig.getTargets()) {
				PlayerUtils.tellPlayer(target.getPlayerName());
			}
			PlayerUtils.tellPlayer("------");
		} else {
			PlayerUtils.tellPlayer("invalid syntax Valid .target");
		}

		return null;
	}

	enum Type {
		Add, Remove, Clear, List
	}
}
