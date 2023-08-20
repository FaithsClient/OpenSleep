/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.ghost;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.PlayerUtils;
import linxiu.utils.timer.TimeHelper;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class AntiKB extends Module {
	public Numbers<Number> Vertical = new Numbers<Number>("V-Motion", 0.0, 0.0, 100.0, 5.0);
	public Numbers<Number> Horizontal = new Numbers<Number>("H-Motion", 0.0, 0.0, 100.0, 5.0);
	public Numbers<Number> changce = new Numbers<Number>("C-Hangce", 100.0, 0.0, 100.0, 5.0);
	private static final Option Bot = new Option("Bot Check", true);
	private static final Option OnlyTarget = new Option("Only Target", true);
	private static final Option BackDisable = new Option("Back Disable", true);
	private final TimeHelper knockBackTimer = new TimeHelper();
	boolean wtfBoolean = true;

	public AntiKB() {
		super("AntiKB", new String[] { "LegitVelocity" }, ModuleType.Legit);
		this.setColor(new Color(191, 191, 191).getRGB());
	}

	@EventHandler
	private void onPacket(EventPacketReceive e) {
		this.setSuffix(Vertical.getValue() + "% " + Horizontal.getValue() + "%");
		if (Bot.getValue()) {
			if (EventPacketReceive.getPacket() instanceof S12PacketEntityVelocity) {
				S12PacketEntityVelocity packet = (S12PacketEntityVelocity) EventPacketReceive.getPacket();
				if (packet.getEntityID() != mc.thePlayer.getEntityId())
					return;
				if (knockBackTimer.isDelayComplete(250) && mc.thePlayer.ticksExisted > 60) {
					if (wtfBoolean && mc.thePlayer.hurtResistantTime == 0 && mc.thePlayer.velocityChanged) {
						PlayerUtils.tellPlayer("You may have been KB checked!");
						wtfBoolean = false;
						mc.thePlayer.addVelocity(packet.getMotionX(), packet.getMotionY(), packet.getMotionZ());
					} else {
						wtfBoolean = false;
					}
				} else if (wtfBoolean && mc.thePlayer.hurtResistantTime > 0) {
					wtfBoolean = false;
				}
			}
		}
	}

	@EventHandler
	public void onUpdate(EventUpdate event) {
		if (mc.thePlayer.maxHurtResistantTime != mc.thePlayer.hurtResistantTime
				|| mc.thePlayer.maxHurtResistantTime == 0) {
			return;
		}
		if (OnlyTarget.getValue() && (mc.objectMouseOver == null || mc.objectMouseOver.entityHit == null)) {
			return;
		}
		if (BackDisable.getValue() && Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode())) {
			return;
		}
		Double random = Math.random();
		random *= 100.0;

		if (random < this.changce.getValue().intValue()) {
			float hori = this.Horizontal.getValue().floatValue();
			hori /= 100.0f;
			float verti = this.Vertical.getValue().floatValue();
			verti /= 100.0f;
			mc.thePlayer.motionX *= hori;
			mc.thePlayer.motionZ *= hori;
			mc.thePlayer.motionY *= verti;
		} else {
			mc.thePlayer.motionX *= 1.0f;
			mc.thePlayer.motionY *= 1.0f;
			mc.thePlayer.motionZ *= 1.0f;
		}
	}
}