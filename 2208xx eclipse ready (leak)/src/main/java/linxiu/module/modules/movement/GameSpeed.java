package linxiu.module.modules.movement;

import java.awt.Color;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventTick;
import linxiu.api.value.Numbers;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.Helper;
import net.minecraft.potion.Potion;

public class GameSpeed extends Module {
	public final static Numbers<Number> hypixelTimer = new Numbers("Timer", 1.0, 1.0, 3.0, 0.1);

	public GameSpeed() {
		super("GameSpeed", new String[] { "GameSpeed" }, ModuleType.Movement);
		this.setColor(new Color(99, 248, 91).getRGB());
	}

	public static void a(net.minecraft.util.Timer timer, float f) {
		timer.timerSpeed = f;
	}

	@EventHandler
	public void onTick(EventTick event) {
		a(Helper.getTimer(), (float) (hypixelTimer.getValue().floatValue() - Math.random() / 50));
	}

	@Override
	public void onDisable() {
		a(Helper.getTimer(), 1.0f);
	}
}
