package linxiu.ui.astolfo;

import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.api.value.Value;
import linxiu.module.ModuleType;
import linxiu.module.modules.render.HUD;
import linxiu.ui.RenderUtil;
import linxiu.ui.font.FontLoaders;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
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
					&& mouseY < this.y + FontLoaders.kiona17.getStringHeight(this.value.getDisplayName()) + 6) {
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
						&& mouseY > this.y + FontLoaders.clickgui14.getStringHeight(this.value.getDisplayName()) - 6
						&& mouseY < this.y + FontLoaders.clickgui14.getStringHeight(this.value.getDisplayName()) + 6
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
			GL11.glEnable(GL11.GL_SCISSOR_TEST);
			limitation.cut();
			Gui.drawRect(this.x - 9, this.y - 2, this.x + 90, this.y + 13, new Color(5, 5, 5, 110).getRGB());
			// Gui.drawRect(this.x - 8, this.y - 2, this.x + 89, this.y + 13, new Color(0,
			// 0, 0, 100).getRGB());
			if (this.value instanceof Option) {
				RenderUtil.drawRect(this.x + 4, this.y + 2.5, this.x + 3.5, this.y + 10.5,
						new Color(180, 180, 180).getRGB());
				RenderUtil.drawRect(this.x - 6, this.y + 2.5, this.x - 5.5, this.y + 10.5,
						new Color(180, 180, 180).getRGB());
				RenderUtil.drawRect(this.x - 6, this.y + 2.5, this.x + 4, this.y + 2,
						new Color(180, 180, 180).getRGB());
				RenderUtil.drawRect(this.x - 6, this.y + 11, this.x + 4, this.y + 10.5,
						new Color(180, 180, 180).getRGB());
				if ((boolean) this.value.getValue()) {
					FontLoaders.logo18.drawStringWithShadow("v", x + 3.5 - FontLoaders.logo18.getStringWidth("v"),
							this.y + 4.5, new Color(255, 255, 255).getRGB());
				}
				FontLoaders.TahomaBold14.drawStringWithShadow(this.value.getName(), this.x + 5.5f, this.y + 5f,
						new Color(255, 255, 255).getRGB());

			}
			ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
			if (this.value instanceof Mode) {
				// RenderUtil.rectangleBordered(this.x - 8, this.y , this.x +
				// 78, this.y + 11,0.5f,new Color(80, 80, 80, 255).getRGB(),new
				// Color(0, 0, 0, 255).getRGB());
				// FontLoaders.font16.drawString(this.value.getName(), this.x -
				// 3, this.y + 2,new Color(195, 195, 195).getRGB());
				FontLoaders.TahomaBold14.drawStringWithShadow(this.value.getName(), this.x - 6, this.y + 3,
						new Color(182, 182, 182).getRGB());
				FontLoaders.TahomaBold14.drawStringWithShadow(this.name,
						x + 85 - FontLoaders.kiona17.getStringWidth(this.name), this.y + 3,
						new Color(255, 255, 255).getRGB());
			}
			if (this.value instanceof Numbers) {
				final Numbers v = (Numbers) this.value;
				final double render = 97.0f * (((Number) v.getValue()).floatValue() - v.getMinimum().floatValue())
						/ (v.getMaximum().floatValue() - v.getMinimum().floatValue());

				linxiu.utils.render.RenderUtil.drawRoundedRect2(this.x - 9, this.y + 10, this.x + 90, this.y + 12, 2.0,
						new Color(5, 5, 5, 70).getRGB());

				linxiu.utils.render.RenderUtil.drawRoundedRect2(this.x - 9, this.y + 10, (int) (this.x - 7 + render),
						this.y + 12, 2.0, new Color(255, 255, 255).getRGB());
			}
			if (this.value instanceof Numbers) {
				FontLoaders.TahomaBold14.drawStringWithShadow(this.value.getName(), this.x - 6, this.y + 3,
						new Color(180, 180, 180).getRGB());
				FontLoaders.TahomaBold14.drawStringWithShadow(this.name,
						this.x + FontLoaders.kiona17.getStringWidth(this.value.getName()) - 6, this.y + 3.5f,
						new Color(255, 255, 255).getRGB());
			}
			GL11.glDisable(GL11.GL_SCISSOR_TEST);
		}
	}

	public void key(final char typedChar, final int keyCode) {
	}

	private boolean isHovering(int n, int n2) {
		boolean b;
		b = n >= this.x && n <= this.x - 7 && n2 >= this.y
				&& n2 <= this.y + FontLoaders.kiona17.getStringHeight(this.value.getDisplayName());
		return b;
	}

	public void click(final int mouseX, final int mouseY, final int button) {
		if (!this.custom && mouseX > this.x - 7 && mouseX < this.x + 85 && mouseY > this.y + 2
				&& mouseY < this.y + 3 + FontLoaders.kiona17.getStringHeight(this.value.getDisplayName())) {
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

	public void key(char typedChar, boolean keyCode) {

	}
}
