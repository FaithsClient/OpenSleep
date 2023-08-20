package linxiu.ui.astolfo;

import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.font.FontLoaders;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class KeyBindButton extends ValueButton {
	public Module cheat;
	public double opacity = 0.0;
	public boolean bind;
	public ModuleType category;
	
	public KeyBindButton(ModuleType category, Module cheat, int x, int y) {
		super(category, null, x, y);
		this.category = category;
		this.custom = true;
		this.bind = false;
		this.cheat = cheat;
	}

	@Override
	public void render(int mouseX, int mouseY, Limitation limitation) {
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        limitation.cut();
		Gui.drawRect(0, 0, 0, 0, 0);
		Gui.drawRect(this.x - 9, this.y - 2, this.x + 90, this.y + 13, new Color(5, 5, 5, 110).getRGB());
		FontLoaders.TahomaBold14.drawStringWithShadow("KeyBind:", this.x - 6, this.y + 4, new Color(180,180,180).getRGB());
		FontLoaders.TahomaBold14.drawStringWithShadow("" + Keyboard.getKeyName(this.cheat.getKey()),
				this.x + 62 - FontLoaders.TahomaBold14.getStringWidth("KeyBind:"), this.y + 4.5f,
				new Color(255,255,255).getRGB());
	   GL11.glDisable(GL11.GL_SCISSOR_TEST);
	}

	@Override
	public void key(char typedChar, int keyCode) {
		if (this.bind) {
			this.cheat.setKey(keyCode);
			if (keyCode == 1) {
				this.cheat.setKey(0);
			}
			ClickUi.binding = false;
			this.bind = false;
		}
		super.key(typedChar, keyCode);
	}

	@Override
	public void click(int mouseX, int mouseY, int button) {
		if (mouseX > this.x - 7 && mouseX < this.x + 85 && mouseY > this.y + 2
				&& mouseY < this.y + FontLoaders.kiona17.getStringHeight(this.cheat.getName()) + 6
				&& button == 0) {
			ClickUi.binding = this.bind = !this.bind;
		}
		super.click(mouseX, mouseY, button);
	}
}
