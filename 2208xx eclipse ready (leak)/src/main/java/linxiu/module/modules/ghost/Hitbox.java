package linxiu.module.modules.ghost;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.KillAura;
import net.minecraft.entity.Entity;

public class Hitbox extends Module {

	public static Numbers<Number> size = new Numbers<Number>("Extra Blocks", 0.25D, 0.1D, 1.0D, 0.05D);
	public static Option vertical = new Option("Vertical", false);
	public Hitbox() {
		super("Hitboxes", new String[] { "Hitbox" }, ModuleType.Legit);
	}

	@EventHandler
	public void onRender3D(EventPreUpdate event) {
		this.setSuffix(size.getValue());
	}

	public static double exp(Entity en) {
		Hitbox hitBox = (Hitbox) ModuleManager.getModuleByClass(Hitbox.class);
		KillAura aura = (KillAura) ModuleManager.getModuleByClass(KillAura.class);
		return (hitBox.isEnabled() && aura.hitBox(en)) ? size.getValue().floatValue() : 0D;
	}
}
