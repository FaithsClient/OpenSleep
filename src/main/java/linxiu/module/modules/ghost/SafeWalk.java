/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.ghost;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventUpdate;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

import java.awt.*;

public class SafeWalk extends Module {
	public SafeWalk() {
		super("SafeWalk", new String[] { "eagle", "parkour" }, ModuleType.Legit);
		this.setColor(new Color(198, 253, 191).getRGB());
	}

	public Block getBlock(BlockPos pos) {
		return mc.theWorld.getBlockState(pos).getBlock();
	}

	public Block getBlockUnderPlayer(EntityPlayer player) {
		return getBlock(new BlockPos(player.posX, player.posY - 1.0d, player.posZ));
	}

	@EventHandler
	public void onUpdate(EventUpdate event) {
		if (getBlockUnderPlayer(mc.thePlayer) instanceof BlockAir) {
			if (mc.thePlayer.onGround) {
				KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
			}
		} else {
			if (mc.thePlayer.onGround) {
				KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
			}
		}
	}

	@Override
	public void onEnable() {
		mc.thePlayer.setSneaking(false);
		super.onEnable();
	}

	@Override
	public void onDisable() {
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
		super.onDisable();
	}
}
