package linxiu.module.modules.player;

import linxiu.module.Module;
import linxiu.module.ModuleType;

import java.awt.*;

public class Deobfuscator extends Module {
	public Deobfuscator() {
		super("Deobfuscator", new String[] { "Deobfuscator", }, ModuleType.Player);
		this.setColor(new Color(218, 97, 127).getRGB());
	}
}
