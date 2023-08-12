package linxiu.ui.astolfoold;

import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.api.value.Value;
import linxiu.module.ModuleType;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.PlayerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class ValueButton {
	public Value value;
	public String name;
	public boolean custom;
	public boolean change;
	public int x;
	public int y;
	public double opacity;
	public ModuleType category;

	public ValueButton(ModuleType category, final Value value, final int x, final int y) {
		this.category = category;
		this.custom = false;
		this.opacity = 0.0;
		this.value = value;
		this.x = x;
		this.y = y;
		this.name = "";
		if (this.value instanceof Option) {
			this.change = (boolean) this.value.getValue();
		} else if (this.value instanceof Mode) {
			this.name = String.valueOf(this.value.getValue());
		} else if (value instanceof Numbers) {
			final Numbers v = (Numbers) value;
			this.name = this.name
					+ (v.isInteger() ? ((Number) v.getValue()).intValue() : ((Number) v.getValue()).doubleValue());
		}
		this.opacity = 0.0;
	}

	public void render(final int mouseX, final int mouseY, Limitation limitation) {

		if (!this.custom) {
			if (mouseX > this.x - 7 && mouseX < this.x + 85 && mouseY > this.y - 6
					&& mouseY < this.y + FontLoaders.clickgui18.getStringHeight(this.value.getDisplayName()) + 6) {
				if (this.opacity + 10.0 < 200.0) {
					this.opacity += 10.0;
				} else {
					this.opacity = 200.0;
				}
			} else if (this.opacity - 6.0 > 0.0) {
				this.opacity -= 6.0;
			} else {
				this.opacity = 0.0;
			}
			if (this.value instanceof Option) {
				this.change = (boolean) this.value.getValue();
			} else if (this.value instanceof Mode) {
				this.name = String.valueOf(this.value.getValue());
			} else if (this.value instanceof Numbers) {
				final Numbers v = (Numbers) this.value;
				this.name = String.valueOf(
						v.isInteger() ? ((Number) v.getValue()).intValue() : ((Number) v.getValue()).doubleValue());
				if (mouseX > this.x - 7 && mouseX < this.x + 85
						&& mouseY > this.y + FontLoaders.clickgui14.getStringHeight(this.value.getDisplayName()) - 10
						&& mouseY < this.y + FontLoaders.clickgui14.getStringHeight(this.value.getDisplayName()) + 2
						&& Mouse.isButtonDown(0)) {
					final double min = v.getMinimum().doubleValue();
					final double max = v.getMaximum().doubleValue();
					final double inc = v.getIncrement().doubleValue();
					final double valAbs = mouseX - (this.x + 1.0);
					double perc = valAbs / 68.0;
					perc = Math.min(Math.max(0.0, perc), 1.0);
					final double valRel = (max - min) * perc;
					double val = min + valRel;
					val = Math.round(val * (1.0 / inc)) / (1.0 / inc);
					v.setValue(val);
				}
			}
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
			GL11.glEnable(GL11.GL_SCISSOR_TEST);
			limitation.cut();
			Gui.drawRect(this.x - 10, this.y - 4, this.x + 80, this.y + 11, new Color(39, 39, 39).getRGB());
			if (this.value instanceof Option) {
				FontLoaders.TahomaBold13.drawStringWithShadow(this.value.getName(), this.x - 7, this.y + 2,
						(boolean) this.value.getValue() ? new Color(staticColor).getRGB()
								: new Color(180, 180, 180).getRGB());
			}
			ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
			if (this.value instanceof Mode) {
				// RenderUtil.rectangleBordered(this.x - 8, this.y , this.x + 78, this.y +
				// 11,0.5f,new Color(80, 80, 80, 255).getRGB(),new Color(0, 0, 0,
				// 255).getRGB());
				// FontLoaders.font16.drawString(this.value.getName(), this.x - 3, this.y +
				// 2,new Color(195, 195, 195).getRGB());

				FontLoaders.TahomaBold13.drawStringWithShadow(this.value.getName(), this.x - 7, this.y + 3,
						new Color(255, 255, 255).getRGB());
				FontLoaders.TahomaBold13.drawStringWithShadow(this.name, x + 77 - FontLoaders.TahomaBold13.getStringWidth(this.name),
						this.y + 3, new Color(staticColor).getRGB());
				final Mode m = (Mode) this.value;

			}
			if (this.value instanceof Numbers) {
				final Numbers v = (Numbers) this.value;
				final double render = 82.0f * (((Number) v.getValue()).floatValue() - v.getMinimum().floatValue())
						/ (v.getMaximum().floatValue() - v.getMinimum().floatValue());
				Gui.drawRect(this.x - 8,
						this.y + FontLoaders.TahomaBold13.getStringHeight(this.value.getName()) + 2, this.x + 78,
						this.y + FontLoaders.TahomaBold13.getStringHeight(this.value.getName()) - 8,
						new Color(50, 50, 50, 180).getRGB());
				Gui.drawRect(this.x - 8,
						this.y + FontLoaders.TahomaBold13.getStringHeight(this.value.getName()) + 2,
						(int) (this.x - 4 + render),
						this.y + FontLoaders.TahomaBold13.getStringHeight(this.value.getName()) - 8, staticColor);
			}
			if (this.value instanceof Numbers) {
				FontLoaders.TahomaBold13.drawStringWithShadow(this.value.getName(), this.x - 7, this.y,
						new Color(255, 255, 255).getRGB());
				FontLoaders.TahomaBold13.drawStringWithShadow(this.name,
						this.x + FontLoaders.TahomaBold13.getStringWidth(this.value.getName()), this.y, -1);
			}
			GL11.glDisable(GL11.GL_SCISSOR_TEST);
		}
	}

	public void key(final char typedChar, final int keyCode) {
	}

	private boolean isHovering(int n, int n2) {
		boolean b;
		b = n >= this.x && n <= this.x - 7 && n2 >= this.y
				&& n2 <= this.y + FontLoaders.clickgui18.getStringHeight(this.value.getDisplayName());
		return b;
	}

	public void click(final int mouseX, final int mouseY, final int button) {
		if (!this.custom && mouseX > this.x - 7 && mouseX < this.x + 85 && mouseY > this.y - 6
				&& mouseY < this.y + FontLoaders.clickgui18.getStringHeight(this.value.getDisplayName())) {
			if (this.value instanceof Option) {
				final Option v = (Option) this.value;
				v.setValue(!(boolean) v.getValue());
				return;
			}
			if (this.value instanceof Mode) {
				final Mode m = (Mode) this.value;
				String current = m.getValue();
				value.setValue(m.getModes()[m.getModeListinde(current) + 1 >= m.getModes().length ? 0
						: m.getModeListinde(current) + 1]);
			}
		}
	}
}
