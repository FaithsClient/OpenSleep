package linxiu.command.commands;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

import linxiu.Client;
import linxiu.command.Command;
import linxiu.module.modules.player.IRC;
import linxiu.utils.Helper;
import linxiu.utils.PlayerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

public class IRCcommand extends Command {
	public IRCcommand() {
		super("IRC", new String[] { "c" }, "", "IRC");
	}

	@Override
	public String execute(String[] args) {
		if (args.length == 0) {
			Helper.sendMessageWithoutPrefix(EnumChatFormatting.GRAY + "[" + EnumChatFormatting.GREEN + "[IRC]"
					+ EnumChatFormatting.GRAY + "]" + EnumChatFormatting.WHITE + ".irc <text>");
			return null;
		} else {
			if (args.length == 1) {
				String clientname = "@" + Client.username;
				String playername = "@" + Minecraft.getMinecraft().thePlayer.getName();
				String textString2 = "MSG" + clientname + playername + "@";
				StringBuilder string = new StringBuilder();
				int i = 0;
				while (i < args.length) {
					String tempString = textString2 + args[i];
					tempString = tempString.replace('&', '\u00a7');
					string.append(tempString).append(" ");
					++i;
				}
				IRC.sendMessage(string.toString().trim());
			} 
		}
		return null;
	}

	public static String toCompleteString(final String[] args, final int start) {
		if (args.length <= start)
			return "";

		return String.join(" ", Arrays.copyOfRange(args, start, args.length));
	}
}
