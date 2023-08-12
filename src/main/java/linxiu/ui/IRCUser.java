package linxiu.ui;

import java.util.concurrent.ConcurrentHashMap;

import linxiu.module.modules.player.IRC;
import linxiu.utils.PlayerUtils;
import linxiu.utils.timer.TimeHelper;

public class IRCUser {
	public static IRCUser local;
	public static ConcurrentHashMap<String, IRCUser> users = new ConcurrentHashMap<>();

	public static void update(String username, String ign) {
		if (users.containsKey(username)) {
			IRCUser user = users.get(username);
			if (!user.ign.equals(ign)) {
				PlayerUtils.irc("Update " + username + "'s Name: " + user.ign + " =>" + ign);
				user.ign = ign;
			}
			user.timer.reset();
		} else {
			IRCUser user = new IRCUser(username, ign);
			if (IRC.logincheck & user.username.equals(IRC.playerNameString))
				local = user;
			PlayerUtils.irc("Add IRC User: " + username + " => " + ign);
			users.put(username, user);
		}

		for (String s : users.keySet()) {
			IRCUser ircUser = users.get(s);
			if (ircUser.timer.isDelayComplete(30000)) {
				PlayerUtils.irc("Remove IRC User: " + ircUser.username);
				users.remove(s);
			}
		}
	}

	public static void remove(String username, String ign) {
		for (String s : users.keySet()) {
			IRCUser ircUser = users.get(s);
			IRCUser user = new IRCUser(username, ign);
			if (IRC.quticheck & user.username.equals(IRC.playerNameString2))
				local = user;
			PlayerUtils.irc("Remove IRC User: " + ircUser.username);
			users.remove(s);
		}
	}

	public static IRCUser getIRCUserByIGN(String ign) {
		for (String s : users.keySet()) {
			IRCUser ircUser = users.get(s);
			if (ircUser.ign.equals(ign)) {
				return ircUser;
			}
		}
		return null;
	}

	public String username, ign;
	public TimeHelper timer = new TimeHelper();

	public IRCUser(String username, String ign) {
		this.username = username;
		this.ign = ign;
		this.timer.reset();
	}
}
