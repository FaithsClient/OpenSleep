/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  rip.autumn.annotations.Label
 *  rip.autumn.module.Module
 *  rip.autumn.module.ModuleCategory
 *  rip.autumn.module.annotations.Aliases
 *  rip.autumn.module.annotations.Category
 *  rip.autumn.module.impl.player.MwFly
 */
package linxiu.module.modules.megawalls;

import linxiu.module.Module;
import linxiu.module.ModuleType;

public class AutoKill extends Module {
	private boolean down;

	public AutoKill() {
		super("AutoKill", new String[] { "AutoKill", "AutoKill" }, ModuleType.Player);

	}

	@Override
	public void onEnable() {
		this.setEnabled(false);
		if (mc.thePlayer == null) {
			return;
		}
		mc.thePlayer.sendChatMessage("/kill");
	}
}
