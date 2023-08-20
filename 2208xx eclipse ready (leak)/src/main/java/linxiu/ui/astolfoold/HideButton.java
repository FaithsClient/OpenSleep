package linxiu.ui.astolfoold;

import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.font.FontLoaders;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class HideButton extends ValueButton {
	public Module cheat;
	public double opacity = 0.0;
	public boolean hide;
	public ModuleType category;

	public HideButton(ModuleType category, Module cheat, int x, int y) {
		super(category, null, x, y);
		this.category = category;
		this.custom = true;
		this.hide = false;
		this.cheat = cheat;
	}

	@Override
	public void render(int mouseX, int mouseY, Limitation limitation) {
		GL11.glEnable(GL11.GL_SCISSOR_TEST);
		limitation.cut();
		Gui.drawRect(0, 0, 0, 0, 0);
		int staticColor;
		if (this.category.name().equals("Combat")) {
			staticColor = new Color(225,25,25).getRGB();
		} else if (this.category.name().equals("Render")) {
			staticColor = new Color(38, 160, 255).getRGB();
		} else if (this.category.name().equals("Movement")) {
			staticColor = new Color(0, 150, 120).getRGB();
		} else if (this.category.name().equals("Player")) {
			staticColor = new Color(128, 0, 128).getRGB();
		} else if (this.category.name().equals("Legit")) {
			staticColor = new Color(255, 140, 205).getRGB();
		} else {
			staticColor = new Color(38, 154, 255).getRGB();
		}
		Gui.drawRect(this.x - 9, this.y - 5, this.x + 90, this.y + 13, new Color(39,39,39).getRGB());
		if (cheat.wasRemoved()) {
			FontLoaders.logo18.drawStringWithShadow("j", x + 77.5 - FontLoaders.logo18.getStringWidth("j"),
					this.y + 1.5, new Color(staticColor).getRGB());
		}
		FontLoaders.TahomaBold13.drawStringWithShadow("Hidden", this.x - 7, this.y  + 0.5f,
				new Color(255, 255, 255).getRGB());
		//	FontLoaders.kiona17.drawStringWithShadow(
		//			String.valueOf(this.hide ? "" : "") + this.cheat.wasRemoved(),
		//			this.x + 39 - FontLoaders.kiona17.getStringWidth("Hide:"), this.y + 2,
		//			new Color(HUD.r.getValue().intValue(), HUD.g.getValue().intValue(), HUD.b.getValue().intValue())
		//					.getRGB());

		GL11.glDisable(GL11.GL_SCISSOR_TEST);
	}

	@Override
	public void click(int mouseX, int mouseY, int button) {
		if (mouseX > this.x - 7 && mouseX < this.x + 85 && mouseY > this.y - 6
				&& mouseY < this.y + FontLoaders.clickgui17.getStringHeight(this.cheat.getName()) + 5
				&& button == 0) {
			this.cheat.setRemoved(!cheat.wasRemoved());
		}
		super.click(mouseX, mouseY, button);
	}
}
