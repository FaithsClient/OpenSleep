package linxiu.command.commands;

import java.util.Objects;

import linxiu.command.Command;
import linxiu.utils.AntisniperWrapper;
import linxiu.utils.PlayerUtils;

public final class Denick extends Command {
	private long lastDenick = 0;

	public Denick() {
		super("Denick", new String[] { "denick" }, "", "Find's a nicks real IGN on Hypixel using a database");
	}

	@Override
	public String execute(String[] args) {
		if (System.currentTimeMillis() - lastDenick < 2500) {
			PlayerUtils.tellPlayer("Please wait before using this again!");
			return null;
		}
		lastDenick = System.currentTimeMillis();

		if (Objects.equals(args[0], "")) {
			PlayerUtils.tellPlayer("Enter a nick to denick");
			return null;
		}

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				String realIgn = AntisniperWrapper.denick(args[0]);
				if (realIgn != null) {
					if (realIgn.equals(args[0])) {
						PlayerUtils.tellPlayer(args[0] + " isn't a nick");
						return;
					}
					PlayerUtils.tellPlayer(args[0] + "'s real IGN is " + realIgn);
				} else {
					PlayerUtils.tellPlayer(args[0] + " couldn't be denicked! Double check their name is correct");
				}
			}
		});
		thread.start();
		return null;
	}
}
