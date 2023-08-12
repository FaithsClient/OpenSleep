package linxiu.command.commands;

import java.util.Objects;

import linxiu.command.Command;
import linxiu.utils.AntisniperWrapper;
import linxiu.utils.PlayerUtils;

public final class Findnick extends Command {
	private long lastFindnick = 0;

	public Findnick() {
		super("Findnick", new String[] { "findnick" }, "", "Find's a players' nick on Hypixel using a database");
	}

	@Override
	public String execute(String[] args) {
		if (System.currentTimeMillis() - lastFindnick < 2500) {
			PlayerUtils.tellPlayer("Please wait before using this again!");
			return null;
		}
		lastFindnick = System.currentTimeMillis();

		if (Objects.equals(args[0], "")) {
			PlayerUtils.tellPlayer("Enter a name to find the nick of");
		}

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				String nick = AntisniperWrapper.findnick(args[0]);
				if (nick != null) {
					if (nick.equals(args[0])) {

						PlayerUtils.tellPlayer(args[0] + " isn't a real player! Did you mean to denick them instead?");
						return;
					}
					PlayerUtils.tellPlayer(args[0] + "'s nick is " + nick);
				} else {
					PlayerUtils.tellPlayer(
							"Couldn't find the nick for " + args[0] + "! They might not be in the database");
				}
			}
		});
		thread.start();
		return null;
	}
}
