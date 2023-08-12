package linxiu.module.modules.ghost;

import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

import java.awt.*;

public class KeepSprint extends Module {
	public static Numbers<Number> b = new Numbers<Number>("Slow %", 100.0D, 0.0D, 100.0D, 1.0D);
	public static Option sprint = new Option("Stop Sprint", false);
	public static Option c = new Option("Only reduce reach hits", false);

	public KeepSprint() {
		super("KeepSprint", new String[] { "KeepSprint" }, ModuleType.Legit);
		this.setColor(new Color(208, 30, 142).getRGB());
	}

	public static void sl(Entity en) {
		double dist;
		Reach reach = (Reach) ModuleManager.getModuleByClass(Reach.class);
		if (c.getValue() && reach != null && reach.isEnabled()
				&& !Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode) {
			dist = Minecraft.getMinecraft().objectMouseOver.hitVec
					.distanceTo(Minecraft.getMinecraft().getRenderViewEntity().getPositionEyes(1.0F));
			double val;
			if (dist > 3.0D) {
				val = (100.0D - b.getValue().doubleValue()) / 100.0D;
			} else {
				val = 0.6D;
			}

			Minecraft.getMinecraft().thePlayer.motionX *= val;
			Minecraft.getMinecraft().thePlayer.motionZ *= val;
		} else {
			dist = (100.0D - b.getValue().doubleValue()) / 100.0D;
			Minecraft.getMinecraft().thePlayer.motionX *= dist;
			Minecraft.getMinecraft().thePlayer.motionZ *= dist;
		}
		if (sprint.getValue()) {
			Minecraft.getMinecraft().thePlayer.setSprinting(false);
		}
	}
}
