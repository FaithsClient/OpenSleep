package linxiu.module.modules.render;


import linxiu.api.value.Numbers;
import linxiu.module.Module;
import linxiu.module.ModuleType;

public class ViewClip extends Module {

    public static Numbers<Number> N = new Numbers<Number>("3rdPersonDistance", 4.0, 1.0, 10.0, 0.01);

	public ViewClip() {
		super("ViewClip", new String[] { "ViewClip" }, ModuleType.Render);
	}
}