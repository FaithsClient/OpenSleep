package linxiu.command.commands;

import java.io.File;

import linxiu.Client;
import linxiu.command.Command;
import linxiu.config.FileConfig;
import linxiu.config.configs.Configs;
import linxiu.utils.Helper;
import net.minecraft.client.Minecraft;

public class ConfigManagerCommand extends Command {
    public final static File dir = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "Sleep");
    public final File configsdir = new File(dir, "configs");

	public ConfigManagerCommand() {
		super("ConfigManager", new String[] { "config" }, "", "Load or Save Local Config");
	}

	@Override
	public String execute(String[] args) {
		FileConfig configs = new Configs(new File(configsdir, (args[1] +".json") ));
		if (args.length == 2 && args[0].equalsIgnoreCase("save")) {
			Client.getINSTANCE().getFileManager().saveConfig(configs);
			Helper.sendMessageWithoutPrefix("Save");
		}
		if (args.length == 2 && args[0].equalsIgnoreCase("load")) {
			Client.getINSTANCE().getFileManager().loadConfig(configs);
			Helper.sendMessageWithoutPrefix("load");
		}
		if (args.length != 2) {
			Helper.sendMessageWithoutPrefix("\u00a77\u00a7m\u00a7l==================================");
			Helper.sendMessageWithoutPrefix("\u00a7b\u00a7lStylle ConfigManager");
			Helper.sendMessageWithoutPrefix("\u00a7b.cm save <Configuration name> :\u00a77 Save Config");
			Helper.sendMessageWithoutPrefix("\u00a7b.cm load <Configuration name> :\u00a77 Load Config");
			Helper.sendMessageWithoutPrefix("\u00a7b.cm remove <Configuration name> :\u00a77 Remove Config");
			Helper.sendMessageWithoutPrefix("\u00a77\u00a7m\u00a7l==================================");
		}
		return null;
	}
}
