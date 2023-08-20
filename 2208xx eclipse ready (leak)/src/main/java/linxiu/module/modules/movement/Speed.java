/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.movement;

import java.util.List;
import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventJump;
import linxiu.api.events.misc.StrafeEvent;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IKeyBinding;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.KillAura;
import linxiu.module.modules.combat.TargetStrafe;
import linxiu.ui.notification.Notification;
import linxiu.utils.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockWeb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.apache.commons.lang3.RandomUtils;

public class Speed extends Module {
	public final static Numbers<Number> hypixelTimer = new Numbers("Timer", 1.0, 1.0, 2.0, 0.1);
	public final static Numbers<Number> customSpeedValue = new Numbers("Custom", 0.48, 0.0, 0.5, 0.01);
	public final static Numbers<Number> strengthValue = new Numbers("Strength", 0.67, 0.0, 1.0, 0.01);
	public Option strafeDisabler = new Option("Strafe", true);
	public static Option fastFall = new Option("FastFall", true);
	public static Option onGroundValue = new Option("OnGround", true);
	public static Option noMoveStopValue = new Option("NoMoveStop", false);
	public static Option lag_back = new Option("Lagbackcheck", false);

	public Speed() {
		super("Bhop", new String[] { "Bhop" }, ModuleType.Movement);
		this.setColor(new Color(99, 248, 91).getRGB());
	}

	@Override
	public void onEnable() {
		final Module[] clashes = { ModuleManager.getModuleByClass(Scaffold.class), };
		int count = 0;

		for (Module m : clashes) {
			if (!m.isEnabled())
				continue;
			m.toggle();
			count++;
		}
		if (count > 0)
			Client.INSTANCE.getNotificationManager().getNotifications()
					.add(new Notification("Disabled " + count + " clash modules"));

		Helper.getTimer().timerSpeed = 1.0f;
	}

	@Override
	public void onDisable() {
		Helper.getTimer().timerSpeed = 1.0f;
	}

	@EventHandler
	public void onLagback(EventPacketReceive e) {
		if (lag_back.getValue() && EventPacketReceive.getPacket() instanceof S08PacketPlayerPosLook) {
			Client.INSTANCE.getNotificationManager().getNotifications()
					.add(new Notification("Speed was disabled to prevent flags/errors", 3000L));
			this.setEnabled(false);
		}
	}

	@EventHandler
	public void onStrafe(StrafeEvent event) {
		if (!mc.gameSettings.keyBindJump.isKeyDown()) {
			double shotSpeed = Math.sqrt(
					(mc.thePlayer.motionX * mc.thePlayer.motionX) + (mc.thePlayer.motionZ * mc.thePlayer.motionZ));
			double speed = (shotSpeed * strengthValue.getValue().doubleValue());
			double motionX = (mc.thePlayer.motionX * (1 - strengthValue.getValue().doubleValue()));
			double motionZ = (mc.thePlayer.motionZ * (1 - strengthValue.getValue().doubleValue()));

			if (!(mc.thePlayer.movementInput.moveForward != 0F || mc.thePlayer.movementInput.moveStrafe != 0F)) {
				if (noMoveStopValue.getValue()) {
					mc.thePlayer.motionX = 0.0;
					mc.thePlayer.motionZ = 0.0;
				}
				return;
			}

			if (!mc.thePlayer.onGround || onGroundValue.getValue()) {
				float yaw = (float) getDirectiond();
				mc.thePlayer.motionX = (-Math.sin(yaw) * speed) + motionX;
				mc.thePlayer.motionZ = (Math.cos(yaw) * speed) + motionZ;
			}
		}
	}

	@EventHandler
	public void handleStrafe(EventPreUpdate event) {
		this.setSuffix("Hypixel");
		final TargetStrafe targetStrafe = (TargetStrafe) Client.INSTANCE.getModuleManager().getModuleByClass(TargetStrafe.class);
		if (strafeDisabler.getValue()) {
			if (mc.thePlayer.onGround)
				event.setY(event.getY() + (4.4682E-4D + RandomUtils.nextInt(0, 100) / 10000));
		}

		if (KillAura.target == null
				&& (strafeDisabler.getValue() || (targetStrafe.isEnabled() && targetStrafe.canStrafe()))) {
			event.setYaw((float) Math.toDegrees(MovementUtils.getDirection2()));
		}
		if (MovementUtils.isMoving()) {
			if (mc.thePlayer.onGround && mc.thePlayer.isCollidedVertically) {
				a(Helper.getTimer(), (float) (hypixelTimer.getValue().floatValue() - Math.random() / 50));
				MoveUtils.strafe(
						(Math.max(customSpeedValue.getValue().doubleValue() + MovementUtils.getSpeedEffect() * 0.1,
								getBaseSpeed())));
				mc.thePlayer.motionY = MovementUtils.getJumpBoostModifier(0.419999986886978D, true);
			}
			if (MovementUtils.isMoving() && fastFall.getValue()) {
				if (mc.thePlayer.motionY < 0.1 && mc.thePlayer.motionY > -0.25 && mc.thePlayer.fallDistance < 0.1) {
					mc.thePlayer.motionY -= 0.15;
				}
			}
		} else {
			mc.thePlayer.motionX *= 0.0;
			mc.thePlayer.motionZ *= 0.0;
		}
	}

	public boolean isPlayerInGame() {
		return (Minecraft.getMinecraft().thePlayer != null) && (Minecraft.getMinecraft().theWorld != null);
	}

	public boolean isOnHypixel() {
		if (!isPlayerInGame())
			return false;
		try {
			return !mc.isSingleplayer() && (mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.net")
					|| mc.getCurrentServerData().serverIP.toLowerCase().contains("localhost"));
		} catch (Exception welpBruh) {
			welpBruh.printStackTrace();
			return false;
		}
	}

	@EventHandler
	public void onmove(EventJump event) {
		if (MovementUtils.isMoving() && !MovementUtils.isInLiquid()) {
			event.setCancelled(true);
		}
	}

	public void strafe(final double speed) {
		if (!MovementUtils.isMoving())
			return;

		final double yaw = getDirection();
		mc.thePlayer.motionX = -MathHelper.sin((float) yaw) * speed;
		mc.thePlayer.motionZ = MathHelper.cos((float) yaw) * speed;
	}

	public double getDirection() {
		float rotationYaw = mc.thePlayer.rotationYaw;

		if (mc.thePlayer.moveForward < 0F)
			rotationYaw += 180F;

		float forward = 1F;

		if (mc.thePlayer.moveForward < 0F)
			forward = -0.5F;
		else if (mc.thePlayer.moveForward > 0F)
			forward = 0.5F;

		if (mc.thePlayer.moveStrafing > 0F)
			rotationYaw -= 90F * forward;
		if (mc.thePlayer.moveStrafing < 0F)
			rotationYaw += 90F * forward;

		return Math.toRadians(rotationYaw);
	}

	public double getAllowedHorizontalDistance() {
		double horizontalDistance;
		boolean useBaseModifiers = false;

		if (PlayerUtil.getBlockRelativeToPlayer(0, 0, 0) instanceof BlockWeb) {
			horizontalDistance = 0.105;
		} else if (PlayerUtil.isInLiquid()) {
			horizontalDistance = 0.115F;
		} else if (mc.thePlayer.isSneaking()) {
			horizontalDistance = 0.3F * 0.221;
		} else {
			horizontalDistance = 0.221;
			useBaseModifiers = true;
		}

		if (useBaseModifiers) {
			if (Math.abs(mc.thePlayer.moveForward) >= 0.8F || Math.abs(mc.thePlayer.moveStrafing) >= 0.8F) {
				horizontalDistance *= 1.3F;
			}

			if (mc.thePlayer.isPotionActive(Potion.moveSpeed)
					&& mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getDuration() > 0) {
				horizontalDistance *= 1
						+ (0.2 * (mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1));
			}

			if (mc.thePlayer.isPotionActive(Potion.moveSlowdown)) {
				horizontalDistance = 0.29;
			}
		}

		final Block below = PlayerUtil.getBlockRelativeToPlayer(0, -1, 0);
		if (below == Blocks.ice || below == Blocks.packed_ice) {
			horizontalDistance *= 2.5F;
		}

		return horizontalDistance;
	}

	public boolean isHoldingMovingKeys() {
		return ((IKeyBinding) mc.gameSettings.keyBindForward).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindBack).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindRight).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindLeft).getPress();
	}

	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	private double getBaseSpeed() {
		final EntityPlayerSP player = mc.thePlayer;
		double base = 0.2895;
		final PotionEffect moveSpeed = player.getActivePotionEffect(Potion.moveSpeed);
		final PotionEffect moveSlowness = player.getActivePotionEffect(Potion.moveSlowdown);
		if (moveSpeed != null)
			base *= 1.0 + 0.19 * (moveSpeed.getAmplifier() + 1);

		if (moveSlowness != null)
			base *= 1.0 - 0.13 * (moveSlowness.getAmplifier() + 1);

		if (player.isInWater()) {
			base *= 0.5203619984250619;
			final int depthStriderLevel = EnchantmentHelper.getDepthStriderModifier(mc.thePlayer);
			if (depthStriderLevel > 0) {
				double[] DEPTH_STRIDER_VALUES = new double[] { 1.0, 1.4304347400741908, 1.7347825295420374,
						1.9217391028296074 };
				base *= DEPTH_STRIDER_VALUES[depthStriderLevel];
			}
		} else if (player.isInLava()) {
			base *= 0.5203619984250619;
		}
		return base;
	}

	public float getDirectiond() {
		double yaw = mc.thePlayer.rotationYaw;

		if (mc.thePlayer.moveForward < 0.0F)
			yaw += 180.0;

		float forward = 1F;

		if (mc.thePlayer.moveForward < 0F) {
			forward = -0.5F;
		} else if (mc.thePlayer.moveForward > 0F) {
			forward = 0.5F;
		}

		if (mc.thePlayer.moveStrafing > 0F)
			yaw -= 90F * forward;

		if (mc.thePlayer.moveStrafing < 0F)
			yaw += 90F * forward;

		return (float) Math.toRadians(yaw);
	}

	public static void a(net.minecraft.util.Timer timer, float f) {
		timer.timerSpeed = f;
	}

	enum SpeedMode {
		Hypixel,
	}
}
