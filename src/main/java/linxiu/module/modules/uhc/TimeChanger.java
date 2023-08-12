package linxiu.module.modules.uhc;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventTick;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S03PacketTimeUpdate;

import java.awt.*;

public class TimeChanger extends Module {
	static float gamma = 0f;
	public static Numbers<Number> gaoliang = new Numbers<>("Brightness", "Brightness", 0.8, 0.0, 1.0, 0.1);

	public TimeChanger() {
		super("FullBright", new String[] { "FullBright" }, ModuleType.Legit);
		this.setColor(new Color(208, 30, 142).getRGB());
	}

	@Override
	public void onEnable() {
		gamma = mc.gameSettings.gammaSetting;
	}

	@Override
	public void onDisable() {
		mc.gameSettings.gammaSetting = gamma;
	}

	@EventHandler
	void onUpdate(EventTick event) {
		mc.gameSettings.gammaSetting = 300;
	}
}
