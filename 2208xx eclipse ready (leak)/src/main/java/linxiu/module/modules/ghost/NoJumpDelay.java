package linxiu.module.modules.ghost;


import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.module.Module;
import linxiu.module.ModuleType;

public class NoJumpDelay extends Module {
	private boolean down;
	public static final Numbers<Number> delay = new Numbers<Number>("Delay", 0.0, 0.0, 10.0, 1.0);
	public NoJumpDelay() {
		super("NoJumpDelay", new String[] { "NoJumpDelay", "NoJumpDelay" }, ModuleType.Legit);
	}

	public void onEnable() {

	}
	
	@EventHandler
	void onUpdate(EventPreUpdate event) {
		this.setSuffix("" + delay.getValue().intValue());
	}
}

