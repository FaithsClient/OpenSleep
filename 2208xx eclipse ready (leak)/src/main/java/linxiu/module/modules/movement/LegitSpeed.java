package linxiu.module.modules.movement;

import com.ibm.icu.math.BigDecimal;
import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventJump;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IKeyBinding;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.notification.Notification;
import linxiu.utils.MovementUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;

import java.awt.*;
import java.util.Objects;

import org.lwjgl.input.Keyboard;

public class LegitSpeed extends Module {
	private final Mode mode = new Mode("Mode", new String[] { "Bingus", "Phantom" }, "Bingus");
	public final static Numbers<Number> Speed = new Numbers("Ph", 0.08, 0.0, 0.2, 0.01);
	public final static Numbers<Number> Boost = new Numbers("Boost 1", 0.1, 0.0, 0.2, 0.01);
	public final static Numbers<Number> Boost1 = new Numbers("Boost 2", 0.15, 0.0, 0.2, 0.01);
	public final static Numbers<Number> Boost2 = new Numbers("Boost 3", 0.15, 0.0, 0.2, 0.01);
	public static Option fastFall = new Option("Fast Fall", true);
	public static Option lag_back = new Option("Lagback check", false);
	public static Option suffixOption = new Option("Speed Suffix", false);
	public boolean ph = false;

	public LegitSpeed() {
		super("Legit Speed", new String[] { "LegitSpeed" }, ModuleType.Movement);
		this.setColor(new Color(99, 248, 91).getRGB());
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
	public void onMove(EventMove event) {
		if (Objects.equals(mode.getValue(), "Phantom")) {
			if (mc.thePlayer != null || MovementUtils.isMoving()) {
				if (ph) {
					event.setX(event.getX() + event.getX() * Speed.getValue().doubleValue());
					event.setZ(event.getZ() + event.getZ() * Speed.getValue().doubleValue());
				}
			}
		}
	}

	@Override
	public void onEnable() {
		this.ph = false;
	}

	@EventHandler
	public void onJump(EventJump event) {
		if (mc.thePlayer != null || MovementUtils.isMoving()) {
			if (Objects.equals(mode.getValue(), "Phantom")) {
				ph = true;
			}
			if (Objects.equals(mode.getValue(), "Bingus")) {
				if (mc.thePlayer.isPotionActive(Potion.moveSpeed)
						&& mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() != 1) {
					float boost = Boost.getValue().floatValue();
					mc.thePlayer.motionX *= (1.0F + getBaseSpeed() * boost);
					mc.thePlayer.motionZ *= (1.0F + getBaseSpeed() * boost);
				}
				if (mc.thePlayer.isPotionActive(Potion.moveSpeed)
						&& mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() != 2) {
					float boost = Boost1.getValue().floatValue();
					mc.thePlayer.motionX *= (1.0F + getBaseSpeed() * boost);
					mc.thePlayer.motionZ *= (1.0F + getBaseSpeed() * boost);
				}
				if (mc.thePlayer.isPotionActive(Potion.moveSpeed)
						&& mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() != 3) {
					float boost = Boost2.getValue().floatValue();
					mc.thePlayer.motionX *= (1.0F + getBaseSpeed() * boost);
					mc.thePlayer.motionZ *= (1.0F + getBaseSpeed() * boost);
				}
			}
		}
	}

	@EventHandler
	private void onMove(EventPreUpdate e) {
		BigDecimal bg = new BigDecimal(getVelocity() * 10d);
		double curSpeed = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		ph = false;
		if (MovementUtils.isMoving() && fastFall.getValue()) {
			if (mc.thePlayer.motionY < 0.1 && mc.thePlayer.motionY > -0.25 && mc.thePlayer.fallDistance < 0.1) {
				mc.thePlayer.motionY -= 0.15;
			}
		}
		if (suffixOption.getValue().booleanValue()) {
			this.setSuffix(curSpeed);
		} else {
			this.setSuffix(this.mode.getValue());
		}
	}

	public boolean isHoldingMovingKeys() {
		return ((IKeyBinding) mc.gameSettings.keyBindForward).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindBack).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindRight).getPress()
				|| ((IKeyBinding) mc.gameSettings.keyBindLeft).getPress();
	}

	public double getVelocity() {
		double xDiff = (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * 2;
		double zDiff = (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * 2;
		return MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
	}

	private double getBaseSpeed() {
		final EntityPlayerSP player = mc.thePlayer;
		double base = 0.2895;
		final PotionEffect moveSpeed = player.getActivePotionEffect(Potion.moveSpeed);
		final PotionEffect moveSlowness = player.getActivePotionEffect(Potion.moveSlowdown);
		if (moveSpeed != null && moveSpeed.getDuration() > 20) {
			base *= 1.0 + 0.19 * (moveSpeed.getAmplifier() + 1);
		}

		if (moveSlowness != null && moveSlowness.getDuration() > 20) {
			base *= 1.0 - 0.13 * (moveSlowness.getAmplifier() + 1);
		}

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

	public static void a(net.minecraft.util.Timer timer, float f) {
		timer.timerSpeed = f;
	}
}
