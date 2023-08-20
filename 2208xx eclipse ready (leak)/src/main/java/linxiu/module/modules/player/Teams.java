package linxiu.module.modules.player;

import linxiu.Client;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teams extends Module {
	private static final Option ColorValue = new Option("Color Mode", false);
	private static final Option BLUE = new Option("BLUE", false);
	private static final Option GREEN = new Option("GREEN", false);
	private static final Option RED = new Option("RED", false);
	private static final Option YELLOW = new Option("YELLOW", false);
	private static final Option transperentValue = new Option("Transperent", false);

	public Teams() {
		super("Teams", new String[] {}, ModuleType.Player);
	}

	public static boolean isOnSameTeam(EntityLivingBase entity) {
		if (!ModuleManager.getModuleByClass(Teams.class).isEnabled() || entity == Minecraft.getMinecraft().thePlayer)
			return false;
		if (ColorValue.getValue()) {
			if (entity.getDisplayName().getUnformattedText().startsWith("\247")) {

				if (BLUE.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\2479")) {
						return true;
					}
				if (GREEN.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\247a")) {
						return true;
					}

				if (RED.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\247c")) {
						return true;
					}

				if (YELLOW.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\247e")) {
						return true;
					}

			}
		} else {
			String self = Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText();
			String target = entity.getDisplayName().getUnformattedText();
			if (self.startsWith("\247")) {
				if (!target.contains("\247"))
					return true;
				if (self.length() <= 2 || target.length() <= 2)
					return false;
				return self.substring(0, 2).equals(target.substring(0, 2));
			}
		}
		return false;
	}

	public static int getTeamColor(Entity player) {
		int var2 = 16777215;

		if (player instanceof EntityPlayer) {
			ScorePlayerTeam var6 = (ScorePlayerTeam) ((EntityPlayer) player).getTeam();

			if (var6 != null) {
				String var7 = FontRenderer.getFormatFromString(var6.getColorPrefix());

				if (var7.length() >= 2) {
					if (!"0123456789abcdef".contains(String.valueOf(var7.charAt(1))))
						return var2;

					var2 = Minecraft.getMinecraft().fontRendererObj.getColorCode(var7.charAt(1));

				}
			}
		}
		return var2;
	}

	public static boolean isOnSameTeam(Entity entity) {
		if (!ModuleManager.getModuleByClass(Teams.class).isEnabled() || entity == Minecraft.getMinecraft().thePlayer)
			return false;
		if (ColorValue.getValue()) {
			if (entity.getDisplayName().getUnformattedText().startsWith("\247")) {

				if (BLUE.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\2479")) {
						return true;
					}
				if (GREEN.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\247a")) {
						return true;
					}

				if (RED.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\247c")) {
						return true;
					}

				if (YELLOW.getValue().booleanValue())
					if (entity.getDisplayName().getUnformattedText().startsWith("\247e")) {
						return true;
					}

			}
		} else {
			String self = Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText();
			String target = entity.getDisplayName().getUnformattedText();
			if (self.startsWith("\247")) {
				if (!target.contains("\247"))
					return true;
				if (self.length() <= 2 || target.length() <= 2)
					return false;
				return self.substring(0, 2).equals(target.substring(0, 2));
			}
		}
		return false;
	}

	public static boolean inTeam(ICommandSender entity0, ICommandSender entity1) {
		String s = "\u00a7" + teamColor(entity0);

		return entity0.getDisplayName().getFormattedText().contains(s)
				&& entity1.getDisplayName().getFormattedText().contains(s);
	}

	public static boolean inTeamWithMinecraftPlayer(ICommandSender entity) {
		return inTeam(Minecraft.getMinecraft().thePlayer, entity);
	}

	public static String teamColor(ICommandSender player) {
		Matcher matcher = Pattern.compile("\u00a7(.).*\u00a7r").matcher(player.getDisplayName().getFormattedText());
		return matcher.find() ? matcher.group(1) : "f";
	}

	public boolean transperentBool(EntityLivingBase entityPlayer) {
		if (!isEnabled() || !transperentValue.getValue()) {
			return false;
		}
		if (!(entityPlayer == mc.thePlayer)
				&& Client.getINSTANCE().getFileManager().friendsConfig.isFriend(entityPlayer.getName())) {
			if (mc.thePlayer.getDistanceToEntity(entityPlayer) < 5) {
				return true;
			}
		}
		if (!(entityPlayer == mc.thePlayer) && isOnSameTeam(entityPlayer)) {
			if (mc.thePlayer.getDistanceToEntity(entityPlayer) < 5) {
				return true;
			}
		}
		return false;
	}
}
