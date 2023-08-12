package linxiu.injection.mixins;

import com.google.common.collect.Ordering;

import linxiu.Client;
import linxiu.injection.interfaces.IGuiPlayerTabOverlay;

import linxiu.module.modules.player.IRC;
import linxiu.ui.IRCUser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiPlayerTabOverlay.class)
public abstract class MixinGuiPlayerTabOverlay implements IGuiPlayerTabOverlay {
	@Shadow
	@Final
	private static Ordering<NetworkPlayerInfo> field_175252_a;

	@Override
	public Ordering<NetworkPlayerInfo> getField() {
		return field_175252_a;
	}

	/**
	 * @reason can't inject
	 * @author
	 */
	@Overwrite
	public String getPlayerName(NetworkPlayerInfo networkInfo) {
		String displayName = networkInfo.getDisplayName() != null ? networkInfo.getDisplayName().getFormattedText()
				: ScorePlayerTeam.formatPlayerName(networkInfo.getPlayerTeam(), networkInfo.getGameProfile().getName());

		if (networkInfo.getDisplayName() == null) {
			IRCUser user = IRCUser.getIRCUserByIGN(networkInfo.getGameProfile().getName());

			if (!networkInfo.getGameProfile().getName().isEmpty() && user != null) {
				displayName += " \u00A77(\u00A7b" + user.username+ "\u00A77)\u00A7r";
			}
		}
		return displayName;
	}
}
