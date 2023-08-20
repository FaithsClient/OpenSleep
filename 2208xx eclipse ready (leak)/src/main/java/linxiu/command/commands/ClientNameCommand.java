/*
 * Decompiled with CFR 0.150.
 */
package linxiu.command.commands;

import linxiu.command.Command;
import linxiu.module.modules.render.HUD;
import linxiu.utils.PlayerUtils;

import java.util.Arrays;
import java.util.List;

public final class ClientNameCommand extends Command {
	private final List<Character> chars = Arrays.asList(Character.valueOf('0'), Character.valueOf('1'),
			Character.valueOf('2'), Character.valueOf('3'), Character.valueOf('4'), Character.valueOf('5'),
			Character.valueOf('6'), Character.valueOf('7'), Character.valueOf('8'), Character.valueOf('9'),
			Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c'), Character.valueOf('d'),
			Character.valueOf('e'), Character.valueOf('k'), Character.valueOf('m'), Character.valueOf('o'),
			Character.valueOf('l'), Character.valueOf('n'), Character.valueOf('r'));

	public ClientNameCommand() {
		super("clientname", new String[] { "list" }, "", "sketit");
	}

	@Override
	public String execute(String... arguments) {
		if (arguments.length == 0) {
			PlayerUtils.tellPlayer("Correct usage .clientname <name>");
			return null;
		}
		if (arguments.length >= 2) {
			StringBuilder string = new StringBuilder();
			for (int i = 1; i < arguments.length; ++i) {
				String tempString = arguments[i];
				tempString = tempString.replace('&', '\u00a7');
				string.append(tempString).append(" ");
			}
			PlayerUtils.tellPlayer(String.format("Changed client name to '%s\u00a77' was '%s\u00a77'.", string.toString().trim(), HUD.clientName));
			HUD.clientName = string.toString().trim();
		} else {

		}

		return null;
	}
}
