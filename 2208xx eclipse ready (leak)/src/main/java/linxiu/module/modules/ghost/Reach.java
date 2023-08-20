package linxiu.module.modules.ghost;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.KillAura;
import linxiu.utils.timer.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

import java.awt.*;
import java.util.Random;

public class Reach extends Module {
	public long lastAttack = 0L;
	public TimeHelper timer = new TimeHelper();
	public static Numbers<Number> maxreach = new Numbers<Number>("Max Reach", 3.0d, 3.0d, 6.0d, 0.1d);
	public static Numbers<Number> minreach = new Numbers<Number>("Min Reach", 3.0d, 3.0d, 6.0d, 0.1d);
	public static Option weapon_only = new Option("Weapon Only", false);
	public static Option moving_only = new Option("Moving only", false);
	public static Option sprint_only = new Option("Sprint only", false);
	public Random rand = new Random();
	public double currentRange = 3.0D;

	public Reach() {
		super("Reach", new String[] { "Reach" }, ModuleType.Legit);
		this.setColor(new Color(191, 191, 191).getRGB());
	}

	public static double random(double min, double max) {
		Random random = new Random();
		double range = max - min;
		double scaled = random.nextDouble() * range;
		double shifted = scaled + min;
		return shifted;
	}

	@EventHandler
	public void onRender3D(EventPreUpdate event) {
	//	this.setSuffix("");
	}

	public static double getReach() {
		Reach reach = (Reach) ModuleManager.getModuleByClass(Reach.class);
		KillAura aura = (KillAura) ModuleManager.getModuleByClass(KillAura.class);
		double normal = Minecraft.getMinecraft().playerController.extendedReach() ? 5 : 3;

		if (aura.isEnabled())
			return aura.rangeValue.getValue().doubleValue();

		if (!isPlayerInGame() || (weapon_only.getValue() && !isPlayerHoldingWeapon()))
			return normal;

		if (moving_only.getValue() && ((double) Minecraft.getMinecraft().thePlayer.moveForward == 0.0D)
				&& ((double) Minecraft.getMinecraft().thePlayer.moveStrafing == 0.0D))
			return normal;

		if (sprint_only.getValue() && !Minecraft.getMinecraft().thePlayer.isSprinting())
			return normal;

		return reach.isEnabled() ? random(minreach.getValue().doubleValue(), maxreach.getValue().doubleValue()) : 3.0f;
	}

	public static boolean isPlayerInGame() {
		return (Minecraft.getMinecraft().thePlayer != null) && (Minecraft.getMinecraft().theWorld != null);
	}

	public static boolean isPlayerHoldingSword() {
		return (Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem() != null)
				&& (Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword);
	}

	public static boolean isPlayerHoldingAxe() {
		return (Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem() != null)
				&& (Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe);
	}

	public static boolean isPlayerHoldingWeapon() {
		return isPlayerHoldingAxe() || isPlayerHoldingSword();
	}
}
