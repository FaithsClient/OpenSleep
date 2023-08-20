package linxiu.command.commands;

import linxiu.Client;
import linxiu.command.Command;
import linxiu.config.configs.FriendsConfig;
import linxiu.ui.notification.Notification;
import linxiu.utils.PlayerUtils;

public class CommandFriend extends Command {

	public CommandFriend() {
		super("friend", new String[] { "f", "friend" }, "", "Friend Command");
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
				Client.getINSTANCE().getFileManager().friendsConfig.addFriend(args[1]);
				Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().friendsConfig);
				PlayerUtils.tellPlayer("Add Friend : " + args[1]);
				Client.getINSTANCE().getNotificationManager().getNotifications()
						.add(new Notification("Add friend " + args[1]));
			} else if (type == Type.Remove && !args[1].isEmpty()) {
				Client.getINSTANCE().getFileManager().friendsConfig.removeFriend(args[1]);
				Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().friendsConfig);
				PlayerUtils.tellPlayer("Remove Friend : " + args[1]);
				Client.getINSTANCE().getNotificationManager().getNotifications()
						.add(new Notification("Remove friend " + args[1]));
			}
		} else if (type == Type.Clear&& !args[1].isEmpty()) {
			Client.getINSTANCE().getFileManager().friendsConfig.clearFriends();
			Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().friendsConfig);

			PlayerUtils.tellPlayer("Clear Friend");
			Client.getINSTANCE().getNotificationManager().getNotifications().add(new Notification("Clear all friends"));

		} else if (type == Type.List) {
			PlayerUtils.tellPlayer("---" + " You have "
					+ Client.getINSTANCE().getFileManager().friendsConfig.getFriends().size() + " friends ---");
			for (FriendsConfig.Friend friend : Client.getINSTANCE().getFileManager().friendsConfig.getFriends()) {
				PlayerUtils.tellPlayer(friend.getPlayerName());
			}
			PlayerUtils.tellPlayer("------");
		} else {
			PlayerUtils.tellPlayer("invalid syntax Valid .friend");
		}
		return null;
	}

	enum Type {
		Add, Remove, Clear, List
	}
}
