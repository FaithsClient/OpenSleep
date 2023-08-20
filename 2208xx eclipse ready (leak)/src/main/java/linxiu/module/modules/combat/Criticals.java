/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.combat;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.timer.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.awt.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomUtils;

public class Criticals extends Module {
	private final Mode mode = new Mode("Mode", new String[] { "Visual", "Edit" }, "Visual");
	private final TimeHelper timer = new TimeHelper();
	private final Numbers<Number> delay = new Numbers<Number>("Delay", 500, 0, 1000, 25);
	private boolean readyCrits = false;

	public Criticals() {
		super("Criticals", new String[] { "crits", "crit" }, ModuleType.Combat);
		this.setColor(new Color(235, 194, 138).getRGB());
	}

	@Override
	public void onEnable() {
		timer.reset();
		super.onEnable();
	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	private void onUpdate(EventPreUpdate event) {
		if (Objects.equals(mode.getValue(), "Edit")) {
			if (!mc.thePlayer.onGround || mc.thePlayer.isOnLadder() || mc.thePlayer.isInWeb || mc.thePlayer.isInWater()
					|| mc.thePlayer.isInLava() || mc.thePlayer.ridingEntity != null
					|| !timer.isDelayComplete(delay.getValue().longValue()))
				return;
			if (Client.getModuleManager().getModuleByClass(KillAura.class).isEnabled()
					&& KillAura.getTarget() != null) {
				readyCrits = true;
			}
		}
	}

	@EventHandler
	private void onUpdate(EventPacketSend event) {
		this.setSuffix(mode.getValue());
		if (Objects.equals(mode.getValue(), "Edit")) {
			if (readyCrits) {
				if (event.getPacket() instanceof C03PacketPlayer) {
					C03PacketPlayer c03 = (C03PacketPlayer) event.getPacket();
					c03.onGround = false;
				}
				readyCrits = false;
			}
		}
	}
}
