package linxiu.ui.astolfoold;

import linxiu.module.ModuleType;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class ColorValueButton extends ValueButton {
	public ModuleType category;
	private final float[] hue = new float[] { 0.0f };
	private int position;
	private int color = new Color(125, 125, 125).getRGB();

	public ColorValueButton(ModuleType category, int x, int y) {
		super(category, null, x, y);
		this.category = category;
		this.custom = true;
		this.position = -1111;
	}

	@Override
	public void render(int mouseX, int mouseY, Limitation limitation) {
		float[] huee = new float[] { this.hue[0] };
		int i = this.x - 7;
		// ADD
		GL11.glEnable(GL11.GL_SCISSOR_TEST);
//ADD
		limitation.cut();
		Gui.drawRect(this.x - 10, this.y - 4, this.x + 80, this.y + 11, new Color(39, 39, 39).getRGB());
		while (i < this.x + 79) {
			Color color = Color.getHSBColor(huee[0] / 255.0f, 0.7f, 1.0f);
			if (mouseX > i - 1 && mouseX < i + 1 && mouseY > this.y - 6 && mouseY < this.y + 12
					&& Mouse.isButtonDown(0)) {
				this.color = color.getRGB();
				this.position = i;
				// Client.setColor(color);
			}
			if (this.color == color.getRGB()) {
				this.position = i;
			}

			Gui.drawRect(i - 1, this.y, i, this.y + 8, color.getRGB());
			float[] arrf = huee;
			arrf[0] = arrf[0] + 4.0f;
			if (huee[0] > 255.0f) {
				huee[0] = huee[0] - 255.0f;
			}
			++i;
		}
		Gui.drawRect(this.position, this.y, this.position + 1, this.y + 8, -1);
		if (this.hue[0] > 255.0f) {
			this.hue[0] = this.hue[0] - 255.0f;
		}
		GL11.glDisable(GL11.GL_SCISSOR_TEST);
	}

	@Override
	public void key(char typedChar, int keyCode) {
	}

	@Override
	public void click(int mouseX, int mouseY, int button) {
	}
}
