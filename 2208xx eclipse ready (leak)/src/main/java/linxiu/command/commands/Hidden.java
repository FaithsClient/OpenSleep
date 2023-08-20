package linxiu.command.commands;

import linxiu.Client;
import linxiu.command.Command;
import linxiu.module.Module;
import linxiu.utils.Helper;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class Hidden extends Command {
	public static List<String> list = new ArrayList();

	public Hidden() {
		super("hidden", new String[] { "h", "hide" }, "", "Hide a module.");
	}

	@Override
	public String execute(String[] args) {
		if (args.length == 0) {
			Helper.sendMessage("Correct usage .h <module>");
			return null;
		}
		for (String s : args) {
			boolean found = false;
			Module m = Client.getModuleManager().getAlias(s);
			if (m != null) {
				found = true;
				if (!m.wasRemoved()) {
					m.setRemoved(true);
					Helper.sendMessage(m.getName() + EnumChatFormatting.GRAY + " was"
							+ EnumChatFormatting.RED + " hidden");
				} else {
					m.setRemoved(false);
					Helper.sendMessage(m.getName() + EnumChatFormatting.GRAY + " was"
							+ EnumChatFormatting.GREEN + " shown");
				}
				 if (Client.getINSTANCE().getFileManager() != null)         Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().configs);
			}
			if (found)
				continue;
			Helper.sendMessage("Module name " + EnumChatFormatting.RED + s
					+ EnumChatFormatting.GRAY + " is invalid");
		}
		return null;
	}
}
