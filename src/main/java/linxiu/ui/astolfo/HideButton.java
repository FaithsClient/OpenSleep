package linxiu.ui.astolfo;

import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.render.HUD;
import linxiu.ui.RenderUtil;
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
		Gui.drawRect(this.x - 9, this.y - 2, this.x + 90, this.y + 13, new Color(5, 5, 5, 110).getRGB());
		RenderUtil.drawRect(this.x + 4, this.y + 2.5, this.x + 3.5, this.y + 10.5,
				new Color(180, 180, 180).getRGB());
		RenderUtil.drawRect(this.x - 6, this.y + 2.5, this.x - 5.5, this.y + 10.5,
				new Color(180, 180, 180).getRGB());
		RenderUtil.drawRect(this.x - 6, this.y + 2.5, this.x + 4, this.y + 2,
				new Color(180, 180, 180).getRGB());
		RenderUtil.drawRect(this.x - 6, this.y + 11, this.x + 4, this.y + 10.5,
				new Color(180, 180, 180).getRGB());
		if (cheat.wasRemoved()) {
			FontLoaders.logo18.drawStringWithShadow("v", x + 3.5 - FontLoaders.logo18.getStringWidth("v"),
					this.y + 4.5, new Color(255,255,255).getRGB());
		}
		FontLoaders.TahomaBold14.drawStringWithShadow("Hidden", this.x + 5, this.y + 5f,
				new Color(180, 180, 180).getRGB());
	//	FontLoaders.kiona17.drawStringWithShadow(
	//			String.valueOf(this.hide ? "" : "") + this.cheat.wasRemoved(),
	//			this.x + 39 - FontLoaders.kiona17.getStringWidth("Hide:"), this.y + 2,
	//			new Color(255,255,255)
	//					.getRGB());

		 GL11.glDisable(GL11.GL_SCISSOR_TEST);
	}

	@Override
	public void click(int mouseX, int mouseY, int button) {
		if (mouseX > this.x - 7 && mouseX < this.x + 1 && mouseY > this.y + 2
				&& mouseY < this.y + FontLoaders.kiona17.getStringHeight(this.cheat.getName()) + 6
				&& button == 0) {
            this.cheat.setRemoved(!cheat.wasRemoved());
		}
		super.click(mouseX, mouseY, button);
	}
}
