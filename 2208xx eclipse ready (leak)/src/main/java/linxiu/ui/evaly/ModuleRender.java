package linxiu.ui.evaly;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import linxiu.Client;
import linxiu.api.value.ColorValue;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.api.value.TextValue;
import linxiu.api.value.Value;
import linxiu.module.Module;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ClickUtils.Position;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.evaly.settings.ColorSetting;
import linxiu.ui.evaly.settings.ModeSetting;
import linxiu.ui.evaly.settings.MultiOptionValue;
import linxiu.ui.evaly.settings.NumberSetting;
import linxiu.ui.evaly.settings.OptionSetting;
import linxiu.ui.evaly.settings.TextSetting;
import linxiu.ui.font.FontLoaders;
import net.minecraft.util.EnumChatFormatting;
import oh.yalan.NativeClass;

@NativeClass
public class ModuleRender {
	public boolean binds;
	private final Position pos;
	public Module module;
	public int height = 0;
	public float y, x;
	// 主界面xy
	public int mainX, mainY;
	public int scrollY = 0;
	public List<SettingRender<?>> settingRenders;

	public ModuleRender(Module module, float modX, float modY, float w) {
		this.module = module;
		this.settingRenders = new ArrayList<>();

		int cHeight = 20;
		// value向下递增y
		cHeight = valueCheck(cHeight, modX + 50, modY);

		pos = new Position(modX + 50, modY, w, cHeight);
	}

	public int valueCheck(int cHeight, float modX, float modY) {
		for (Value<?> setting : module.getValues()) {
			if (setting instanceof Option) {
				this.settingRenders.add(new OptionSetting((Option) setting, modX, modY + cHeight, 0, 0, this));
				cHeight += 10;
			}

			if (setting instanceof Numbers) {
				this.settingRenders.add(new NumberSetting((Numbers) setting, modX, modY + cHeight, 0, 0, this));
				cHeight += 16;
			}
			if (setting instanceof ColorValue) {
				this.settingRenders.add(new ColorSetting((ColorValue) setting, modX, modY + cHeight, 0, 0, this));
				cHeight += 10;
			}
			if (setting instanceof Mode) {
				this.settingRenders.add(new ModeSetting((Mode) setting, modX, modY + cHeight, 0, 0, this));
				cHeight += 20;
			}
			if (setting instanceof linxiu.api.value.MultiOptionValue) {
				this.settingRenders.add(new MultiOptionValue((linxiu.api.value.MultiOptionValue) setting, modX,
						modY + cHeight, 0, 0, this));
				cHeight += 20;
			}
			if (setting instanceof TextValue) {
				this.settingRenders.add(new TextSetting((TextValue) setting, modX, modY + cHeight, 0, 0, this));
				cHeight += 20;
			}

		}

		this.height = cHeight;
		return cHeight;

	}

	public void draw(int mx, int my) {
		this.mainX = Client.INSTANCE.evalyGui.mainX;
		this.mainY = Client.INSTANCE.evalyGui.mainY;

		x = pos.x;
		y = pos.y + scrollY;

		RoundedUtil.drawRound(mainX + 10f + x + 1f, mainY + 4.5f + 35 + y + 1f, 160f + 5 - 2f, pos.height - 6.5f, 0,
				new Color(0, 0, 0));
		RoundedUtil.drawRound(mainX + 10f + x + 1f, mainY + 4.5f + 35 + y + 1f, 160f + 5 - 2, pos.height - 1 - 5.5f, 0,
				new Color(150, 150, 150));
		RoundedUtil.drawRound(mainX + 10 + x + 1, mainY + 4.5f + 35 + y + 1, 160 + 5 - 2, pos.height - 2 - 4.5f, 0,
				new Color(19, 19, 19));

		FontLoaders.TahomaBold11.drawString("" + module.getName(), mainX + 17 + x, mainY + 38 + y, -1);

		float tx = mainX + 17 + x;
		float ty = mainY + 43f + y + 4;
		FontLoaders.TahomaBold11.drawString("Enabled", tx + 7, ty + 1f, new Color(224, 223, 225).getRGB());

		RoundedUtil.drawRound(tx + 0.5f, ty + 0.5f, 3, 3, 0, new Color(0, 0, 0, 255));

		RenderUtil.drawGradientRect2(tx, ty, 4, 4,
				module.isEnabled() ? new Color(HUD.colorValue.getValue()).getRGB() : new Color(58, 58, 58).getRGB(),
				module.isEnabled() ? new Color(HUD.colorValue.getValue()).darker().getRGB()
						: new Color(58, 58, 58).darker().getRGB());

		// 绘制按键绑定 28,32,40 , 49,53,61

		FontLoaders.TahomaBold11.drawString(
				binds ? "..."
						: EnumChatFormatting.GRAY + "" + EnumChatFormatting.RESET
								+ Keyboard.getKeyName(module.getKey()).toUpperCase() + EnumChatFormatting.GRAY + "",
				mainX + 156f + x
						- FontLoaders.TahomaBold11
								.getStringWidth(binds ? "..." : Keyboard.getKeyName(module.getKey()).toUpperCase())
						+ 13,
				ty, new Color(-1).darker().getRGB());

	

		settingRenders.forEach(e -> e.draw(mx, my));

	}

	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (isKeyBindHovered(mouseX, mouseY)) {
			if (mouseButton == 0) {
				binds = true;
			}
		}
		if (!isKeyBindHovered(mouseX, mouseY) && binds) {
			if (mouseButton == 0) {
				binds = false;
			}
		}
	
		if (mouseButton == 0) {
			if (RenderUtil.isHovering(mainX + 17 + x, mainY + 43f + y, 8, 8, mouseX, mouseY)) {
				module.setEnabled(!module.isEnabled());
			}
		}

		if (this.binds) {
			if (mouseButton == 1) {
				module.setKey(0);
				this.binds = false;
			}
		}
		for (SettingRender<?> settingRender : settingRenders) {
			settingRender.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}

	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= mainX + 5 + x + 4 && mouseX <= mainX + 5 + x + 4 + 15 && mouseY >= mainY + 17 + y + 8
				&& mouseY <= mainY + 17 + y + 8 + 6;
	}

	public boolean isKeyBindHovered(int mouseX, int mouseY) {
		return mouseX >= mainX + 156f + x
				- FontLoaders.TahomaBold11.getStringWidth(Keyboard.getKeyName(module.getKey()).toUpperCase()) + 13
				&& mouseX <= mainX + 156f + x
						- FontLoaders.TahomaBold11.getStringWidth(Keyboard.getKeyName(module.getKey()).toUpperCase())
						+ 13
						+ FontLoaders.TahomaBold11.getStringWidth(Keyboard.getKeyName(module.getKey()).toUpperCase())
						+ 3
				&& mouseY >= mainY + 43f + y + 4 && mouseY <= mainY + 43f + y + 4 + 7;
	}

	public void mouseReleased(int mouseX, int mouseY, int state) {
		settingRenders.forEach(e -> e.mouseReleased(mouseX, mouseY, state));
	}

	public void keyTyped(char typedChar, int keyCode) {
		int finalKeyCode = keyCode;
		settingRenders.forEach(e -> e.keyTyped(typedChar, finalKeyCode));
		if (this.binds) {
			if (keyCode == 211) {
				keyCode = 0;
			}
			module.setKey(keyCode);
			this.binds = false;
		}
	}

	public int getMaxScrollY() {
		return (int) ((int) pos.y + pos.height);
	}

	public int getPosY() {
		return (int) pos.y;
	}

	public int getScrollY() {
		return scrollY;
	}
}
