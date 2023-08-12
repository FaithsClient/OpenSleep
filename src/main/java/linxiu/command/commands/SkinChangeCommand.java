package linxiu.command.commands;

import linxiu.command.Command;
import linxiu.ui.Yarukon;
import linxiu.utils.ChatUtils;

public class SkinChangeCommand extends Command {

	public static boolean slim = false;
	public static String targetSkin = "";
	
	public SkinChangeCommand() {
		super("changeskin", new String[] { "skin", "cskin" }, "", "Change Skin");
	}

	@Override
	public String execute(String[] args) {
		if (args.length == 1) {
			targetSkin = args[0];
			Yarukon.INSTANCE.loadSkinFromLocal(targetSkin);
			slim = !slim;
			ChatUtils.info("Current skin-type: " + (slim ? "Slim" : "Steve"));
		} else {
			targetSkin = "";
		}
		return null;
	}
}
