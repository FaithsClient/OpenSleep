package linxiu.command.commands;

import linxiu.Client;
import linxiu.command.Command;
import linxiu.module.Module;
import linxiu.utils.Helper;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class setName extends Command {
	public static List<String> list = new ArrayList();

	public setName() {
		super("setName", new String[] { "sv", "setcustomname" }, "", "set custom name for a module.");
	}

	@Override
	public String execute(String[] args) {
		if (args.length == 0) {
			Helper.sendMessage("Correct usage .sv <module> [name]");
			return null;
		}

		boolean found = false;
		Module m = Client.getModuleManager().getAlias(args[0]);
		if (m != null) {
			found = true;
			if (args.length >= 2) {
			    StringBuilder string = new StringBuilder();
		        for (int i = 1; i < args.length; ++i) {
		              String tempString = args[i];
		              tempString = tempString.replace('&', '\u00a7');
		              string.append(tempString).append(" ");
		        }
				m.setCustomName(string.toString().trim());
				Helper.sendMessage(( EnumChatFormatting.BLUE)+m.getName() +  ( EnumChatFormatting.GRAY) + " was"
						+  ( EnumChatFormatting.GREEN) + " set"+( EnumChatFormatting.GRAY)+" to " +( EnumChatFormatting.YELLOW)+ string.toString().trim());
			} else {
				m.setCustomName(null);
				Helper.sendMessage(( EnumChatFormatting.BLUE)+m.getName() +  ( EnumChatFormatting.GRAY) + " was"
						+  ( EnumChatFormatting.RED) + " reset");
			}
		}
		if (!found) {
			Helper.sendMessage("Module name " +  ( EnumChatFormatting.RED) + args[0]
					+  ( EnumChatFormatting.GRAY) + " is invalid");
		}

		return null;
	}
}
