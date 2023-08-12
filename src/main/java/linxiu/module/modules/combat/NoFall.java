/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.combat;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventTick;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IEntityPlayerSP;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.MovementUtils;
import linxiu.utils.PacketUtils;
import linxiu.utils.math.MathUtil;
import net.minecraft.block.BlockAir;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;

import java.awt.*;

public class NoFall extends Module {
	private static final Option Suffix = new Option("Set Suffix", "Set Suffix", true);
	private float fallDist, lastTickFallDist;
	public Option no_void = new Option("Void Check", "Void Check", true);
	public NoFall() {
		super("NoFall", new String[] { "Nofalldamage" }, ModuleType.Combat);
		this.setColor(new Color(242, 137, 73).getRGB());
	}

	@EventHandler
	public final void onPacket(EventPacketSend e) {
		if (Suffix.getValue()) {
			this.setSuffix("Hypixel");
		} else {
			this.setSuffix("");
		}
	}

	@EventHandler
	public void update(EventPreUpdate e) {
		if (mc.thePlayer == null || mc.theWorld == null || mc.thePlayer.capabilities.isFlying
				|| mc.thePlayer.capabilities.disableDamage || mc.thePlayer.motionY >= 0.0d || mc.thePlayer.posY <= 0)
			return;

		if (mc.thePlayer.fallDistance == 0)
			fallDist = 0;

		fallDist += mc.thePlayer.fallDistance - lastTickFallDist;
		lastTickFallDist = mc.thePlayer.fallDistance;
		
        if (fallDist > 2F && (no_void.getValue() || isBlockUnder())) {
			double lastReportedY = ((IEntityPlayerSP) mc.thePlayer).getlastReportedPosY();
			if (lastReportedY - Math.floor(lastReportedY) < 0.8F) {
				e.setY(Math.floor(lastReportedY));
				e.setOnground(true);
				fallDist = 0F;
				mc.thePlayer.motionY = -0.0784000015258789;
			}
		}
	}

	public boolean isBlockUnder() {
		for (int i = (int) (mc.thePlayer.posY - 1.0); i > 0; --i) {
			BlockPos pos = new BlockPos(mc.thePlayer.posX, i, mc.thePlayer.posZ);
			if (mc.theWorld.getBlockState(pos).getBlock() instanceof BlockAir)
				continue;
			return true;
		}
		return false;
	}
}
