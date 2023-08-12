package linxiu.module.modules.ghost;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventTick;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.math.MathUtil;
import linxiu.utils.timer.Timer;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AutoClicker extends Module {
	private final TimerUtil attacker = new TimerUtil();
	
	public Numbers<Number> maxCps = new Numbers<Number>("MaxCPS", 10d, 1d, 20d, 0.1d);
	public Numbers<Number> minCps = new Numbers<Number>("MinCPS", 8d, 1d, 20d, 0.1d);
	public Option onlySwordsTools = new Option("Only Swords/Tools", false);

	public AutoClicker() {
		super("AutoClicker", new String[] { "AutoClicker", "AutoClicker" }, ModuleType.Legit);
	}
	public double ranModuleVal(Random r) {
		return minCps.getValue().doubleValue() == maxCps.getValue().doubleValue()
				? minCps.getValue().doubleValue()
				: minCps.getValue().doubleValue() + (r.nextDouble()
						* (maxCps.getValue().doubleValue() - minCps.getValue().doubleValue()));
	}
	
	@EventHandler
	public void onTick(EventTick event) {
		this.setSuffix(minCps.getValue() + "-" + maxCps.getValue());
		double cps;
		cps = ranModuleVal(MathUtil.rand()) + (0.4 * MathUtil.rand().nextDouble());
		if (mc.gameSettings.keyBindAttack.isKeyDown()) {
			if (!onlySwordsTools.getValue()
					|| mc.thePlayer.getHeldItem() != null && (mc.thePlayer.getHeldItem().getItem() instanceof ItemTool
							|| mc.thePlayer.getHeldItem().getItem() instanceof ItemSword)) {
				if (attacker.hasTimeElapsed(1000 / cps, true)) {
					mc.thePlayer.swingItem();

					if (mc.objectMouseOver.entityHit != null) {
						mc.playerController.attackEntity(mc.thePlayer, mc.objectMouseOver.entityHit);
					}

					attacker.reset();
				}
			}
		}
	}
}
