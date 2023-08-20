
package linxiu.module.modules.render;

import java.util.Objects;

import linxiu.Client;
import linxiu.api.value.Mode;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.astolfo.ClickUi;

public class ClickGui extends Module {
	public Option disp = new Option("DisplayValue", false);
	private final Mode modeValue = new Mode("Mode", new String[] { "Exh", "Otc", "Bingus", "Astolfo" }, "Exh");

	public ClickGui() {
		super("ClickGui", new String[] { "clickui" }, ModuleType.Render);
		super.setRemoved(true);
	}

	@Override
	public void onEnable() {
		if (Objects.equals(modeValue.getValue(), "Bingus")) {
			mc.displayGuiScreen(new ClickUi());
		}
		if (Objects.equals(modeValue.getValue(), "Astolfo")) {
			mc.displayGuiScreen(new linxiu.ui.astolfoold.ClickUi());
		}
		if (Objects.equals(modeValue.getValue(), "Exh")) {
			mc.displayGuiScreen(Client.getINSTANCE().evalyGui);
		}
		if (Objects.equals(modeValue.getValue(), "Otc")) {
			mc.displayGuiScreen(Client.getINSTANCE().otc);
		}
		this.setEnabled(false);
	}
}
