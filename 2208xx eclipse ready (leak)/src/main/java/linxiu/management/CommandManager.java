/*
 * Decompiled with CFR 0_132.
 */
package linxiu.management;

import linxiu.api.EventBus;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventChat;
import linxiu.command.Command;
import linxiu.command.commands.*;
import linxiu.utils.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandManager implements Manager {
	private List<Command> commands;

	@Override
	public void init() {
		this.commands = new ArrayList<Command>();
		this.commands.add(new Command("test", new String[] { "test" }, "", "testing") {

			@Override
			public String execute(String[] args) {
				for (Command command : CommandManager.this.commands) {
				}
				return null;
			}
		});
		this.commands.add(new Help());
		this.commands.add(new Teleport());
		this.commands.add(new Title());
		this.commands.add(new ComamndQQ());
		this.commands.add(new ClientNameCommand());
		this.commands.add(new CommandReconnect());
		this.commands.add(new Toggle());
		this.commands.add(new Bind());
		this.commands.add(new Target());
		this.commands.add(new VClip());
		this.commands.add(new SkinChangeCommand());
		this.commands.add(new IRCcommand());
		this.commands.add(new CommandFriend());
		this.commands.add(new Cheats());
		this.commands.add(new Hidden());
		this.commands.add(new setName());
		this.commands.add(new Denick());
		this.commands.add(new Findnick());
		this.commands.add(new ConfigManagerCommand());
		EventBus.getInstance().register(this);
	}

	public List<Command> getCommands() {
		return this.commands;
	}

	public Optional<Command> getCommandByName(String name) {
		return this.commands.stream().filter(c2 -> {
			boolean isAlias = false;
			String[] arrstring = c2.getAlias();
			int n = arrstring.length;
			int n2 = 0;
			while (n2 < n) {
				String str = arrstring[n2];
				if (str.equalsIgnoreCase(name)) {
					isAlias = true;
					break;
				}
				++n2;
			}
			return c2.getName().equalsIgnoreCase(name) || isAlias;
		}).findFirst();
	}

	public void add(Command command) {
		this.commands.add(command);
	}

	@EventHandler
	private void onChat(EventChat e) {
		if (e.getMessage().length() > 1 && e.getMessage().startsWith("")) {
			e.setCancelled(true);
			String[] args = e.getMessage().trim().substring(1).split(" ");
			Optional<Command> possibleCmd = this.getCommandByName(args[0]);
			if (possibleCmd.isPresent()) {
				String result = possibleCmd.get().execute(Arrays.copyOfRange(args, 1, args.length));
				if (result != null && !result.isEmpty()) {
					Helper.sendMessage(result);
				}
			} else {
				Helper.sendMessage(String.format("Command not found Try '%shelp'", ""));
			}
		}
	}

}
