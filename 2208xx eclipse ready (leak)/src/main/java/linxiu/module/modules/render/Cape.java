package linxiu.module.modules.render;

import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.module.Module;
import linxiu.module.ModuleType;

public class Cape extends Module {
	public final Mode overlayProperty = new Mode("OverlayMode", new String[] { "Sleep", "Exh" },
			"Sleep");
	
	public final Mode arrayListColorModeProperty = new Mode("ColorMode", new String[] { "Rainbow", "Normal" },
			"Normal");

	
	public final Numbers<Number> red = new Numbers<>("Red", 0.5, 0.0, 1.0, 0.1),
			green = new Numbers<>("Green", 0.5, 0.0, 1.0, 0.1), blue = new Numbers<>("Blue", 0.5, 0.0, 1.0, 0.1),
			rainbowWidth = new Numbers<>("RainbowWidth", 1.0, 1.0, 300.0, 1.0),
			rainbowSpeed = new Numbers<>("RainbowSpeed", 80.0, 1.0, 1000.0, 1.0);

	public Cape() {
		super("Cape", new String[] { "Cape" }, ModuleType.Render);
	}

}
