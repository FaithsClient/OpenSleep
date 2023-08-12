package linxiu.ui.evaly.settings;

import org.lwjgl.input.Keyboard;

import linxiu.Client;
import linxiu.api.value.TextValue;
import linxiu.ui.evaly.ModuleRender;
import linxiu.ui.evaly.SettingRender;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.font.FontLoaders;
import net.minecraft.client.Minecraft;
import oh.yalan.NativeClass;

import java.awt.*;
@NativeClass
public class TextSetting extends SettingRender<TextValue> {
	public TextSetting(TextValue s, float x, float y, int width, int height, ModuleRender moduleRender) {
		super(s, x, y, width, height, moduleRender);
	}

	// 主界面xy
	public int mainX, mainY, y;

	@Override
	public void draw(int mouseX, int mouseY) {
		mainX = Client.INSTANCE.evalyGui.mainX;
		mainY = Client.INSTANCE.evalyGui.mainY;

		y = (int) (pos.y + getScrollY());

		FontLoaders.Tahoma11.drawString(setting.getName(), mainX + 17 + pos.x, mainY + 38 + y,
				new Color(200, 200, 200).getRGB());

		RoundedUtil.drawRound(mainX + 17.5f + pos.x, mainY + 35 + y + 10.5f, 149, 7, 0, new Color(0, 0, 0));
		RenderUtil.drawGradientRect2(mainX + 17 + pos.x, mainY + 35 + y + 10, 150, 8, new Color(32, 32, 32).getRGB(),
				new Color(30, 30, 30).getRGB());

		// 显示框内文字 判断长度
		if (FontLoaders.Tahoma11
				.getStringWidth(setting.getTextHovered() ? setting.getValue() + "_" : setting.getValue()) > 65) {
			// 修剪字符串长度
			FontLoaders.Tahoma11.drawString(
					FontLoaders.Tahoma11.trimStringToWidth(
							setting.getTextHovered() ? setting.getValue() + "_" : setting.getValue(), 59, true),
					mainX + 19 + pos.x, mainY + 38 + y + 10, new Color(200, 200, 200).getRGB());
		} else {
			if (setting.getValue().isEmpty() && !setting.getTextHovered()) {
				FontLoaders.Tahoma11.drawString("Type Here...", (int) (mainX + 19 + pos.x), mainY + 38 + y + 10,
						new Color(200, 200, 200).getRGB());
			} else {
				FontLoaders.Tahoma11.drawString(setting.getTextHovered() ? setting.getValue() + "_" : setting.getValue(),
						(int) (mainX + 19 + pos.x), mainY + 38 + y + 10, new Color(200, 200, 200).getRGB());
			}
		}
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (RenderUtil.isHovering(mainX + 17 + pos.x, mainY + 35 + y + 10, 150, 12, mouseX, mouseY)) {
			setting.setTextHovered(!setting.getTextHovered());
		} else if (setting.getTextHovered()) {
			setting.setTextHovered(false);
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {

	}

	@Override
	public void keyTyped(char typedChar, int keyCode) {
		// 输入
		if (setting.getTextHovered()) {
			if (keyCode == Keyboard.KEY_ESCAPE) {
				setting.setTextHovered(false);
			} else if (!(keyCode == Keyboard.KEY_BACK) && keyCode != Keyboard.KEY_RCONTROL
					&& keyCode != Keyboard.KEY_LCONTROL && keyCode != Keyboard.KEY_RSHIFT
					&& keyCode != Keyboard.KEY_LSHIFT && keyCode != Keyboard.KEY_TAB && keyCode != Keyboard.KEY_CAPITAL
					&& keyCode != Keyboard.KEY_DELETE && keyCode != Keyboard.KEY_HOME && keyCode != Keyboard.KEY_INSERT
					&& keyCode != Keyboard.KEY_UP && keyCode != Keyboard.KEY_DOWN && keyCode != Keyboard.KEY_RIGHT
					&& keyCode != Keyboard.KEY_LEFT && keyCode != Keyboard.KEY_LMENU && keyCode != Keyboard.KEY_RMENU
					&& keyCode != Keyboard.KEY_PAUSE && keyCode != Keyboard.KEY_SCROLL && keyCode != Keyboard.KEY_END
					&& keyCode != Keyboard.KEY_PRIOR && keyCode != Keyboard.KEY_NEXT && keyCode != Keyboard.KEY_APPS
					&& keyCode != Keyboard.KEY_F1 && keyCode != Keyboard.KEY_F2 && keyCode != Keyboard.KEY_F3
					&& keyCode != Keyboard.KEY_F4 && keyCode != Keyboard.KEY_F5 && keyCode != Keyboard.KEY_F6
					&& keyCode != Keyboard.KEY_F7 && keyCode != Keyboard.KEY_F8 && keyCode != Keyboard.KEY_F9
					&& keyCode != Keyboard.KEY_F10 && keyCode != Keyboard.KEY_F11 && keyCode != Keyboard.KEY_F12) {
				setting.append(typedChar);
			}

			// 删除
			if (setting.getTextHovered() && Keyboard.isKeyDown(Keyboard.KEY_BACK) && setting.getValue().length() >= 1) {
				setting.setValue(setting.getValue().substring(0, setting.getValue().length() - 1));
			}
		}
		super.keyTyped(typedChar, keyCode);
	}
}
