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

public class AutoRejoin extends Module {
	private boolean down;

	public AutoRejoin() {
		super("Logout", new String[] { "Logout", "Logout" }, ModuleType.Player);

	}

	@Override
	public void onEnable() {
		this.setEnabled(false);
		if (mc.thePlayer == null) {
			return;
		}
		mc.thePlayer.sendChatMessage("/lobby");
		new Thread(() -> {
			try {
				Thread.sleep(150L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mc.thePlayer.sendChatMessage("/back");
		}).start();
	}
}
