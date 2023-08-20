package linxiu.command.commands;

import linxiu.command.Command;
import linxiu.utils.Helper;
import org.lwjgl.opengl.Display;

import javax.swing.*;

public class Title extends Command {
	public Title() {
		super("title", new String[] { "settile", "st", "sett", "stitle" }, "", "Set Client Title");
	}

	@Override
	public String execute(String[] args) {
		String input = JOptionPane.showInputDialog(null, "set title", null);
		if (input != null) {
			if (input.contains("lnt")) {
				Display.setTitle("lynx");
			} else {
				Display.setTitle(input);
				Helper.sendMessage("> " + "Client Title was set to " + input);
			}
		} else {
			Display.setTitle(Display.getTitle());
			Helper.sendMessage("> " + "Client Title was set to " + Display.getTitle());
		}

		return null;
	}
}
