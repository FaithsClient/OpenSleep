package linxiu.module.modules.megawalls;

import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class BlockHitbox extends Module {
	private static final Minecraft mc = Minecraft.getMinecraft();
	private static final Option ghostHandTools = new Option("Tools", true);
	private static final Option ghostHandBow = new Option("Bow", true);

	public BlockHitbox() {
		super("GhostHead", new String[] { "BlockHitbox" }, ModuleType.Player);
	}

	public static boolean shouldHitThrough(Entity e) {
		if (mc.thePlayer.getHeldItem() != null && ((ghostHandTools.getValue()
				&& (mc.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("pickaxe")
						|| mc.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("hatchet") // who tf made
																											// axe
																											// called
																											// hatchet
						|| mc.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("shovel")
						|| mc.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("hoe"))
				&& !mc.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("shovelDiamond"))
				|| (ghostHandBow.getValue()
						&& mc.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("bow"))))
			return true;
		if (e.getDisplayName().getUnformattedText().length() < 4)
			return false;

		char color1 = ' ', color2 = ' ';
		String title, name1 = e.getDisplayName().getFormattedText(),
				name2 = mc.thePlayer.getDisplayName().getFormattedText();

		if (name1.startsWith("§r§6[§2S§6] "))
			name1 = name1.replace("§r§6[§2S§6] ", "");
		if (name2.startsWith("§r§6[§2S§6] "))
			name2 = name2.replace("§r§6[§2S§6] ", "");

		if (mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null)
			title = " ";
		else
			title = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();

		if (name1.charAt(2) == '§')
			color1 = name1.charAt(3);
		else if (name1.charAt(0) == '§' && name1.charAt(1) != 'r')
			color1 = name1.charAt(1);

		if (name2.charAt(2) == '§')
			color2 = name2.charAt(3);
		else if (name2.charAt(0) == '§' && name2.charAt(2) != '§' && name2.charAt(1) == 'r' && title.charAt(0) == '§')
			color2 = title.charAt(1);

		return color1 != ' ' && color2 != ' ' && color1 == color2;
	}
}
