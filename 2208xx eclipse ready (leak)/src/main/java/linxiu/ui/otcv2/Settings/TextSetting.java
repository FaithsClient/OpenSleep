package linxiu.ui.otcv2.Settings;

import org.lwjgl.input.Keyboard;

import linxiu.Client;
import linxiu.api.value.TextValue;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.font.FontLoaders;
import linxiu.ui.otcv2.Downward;
import linxiu.ui.otcv2.ModuleRender;

import java.awt.*;

public class TextSetting extends Downward<TextValue> {
	public TextValue textValue;

	public TextSetting(TextValue s, float x, float y, int width, int height, ModuleRender moduleRender) {
		super(s, x, y, width, height, moduleRender);
		this.textValue = s;
	}

	// 获取主界面xy跟随移动
	private float modulex, moduley, texty;

	@Override
	public void draw(int mouseX, int mouseY) {
		modulex = Client.INSTANCE.otc.getMainx();
		moduley = Client.INSTANCE.otc.getMainy();

		// 修复滚轮
		texty = pos.y + getScrollY();

		// 框
		RenderUtil.drawRoundedRect(modulex + 5 + pos.x + 55, moduley + 17 + texty + 8, 75, 11f, 1,
				new Color(59, 63, 72).getRGB(), 1,
				textValue.getTextHovered() ? new Color(HUD.colorValue.getValue()).getRGB()
						: new Color(85, 90, 96).getRGB());

		// 显示描边
		if (isHovered(mouseX, mouseY) && !textValue.getTextHovered()) {
			RenderUtil.drawRoundedRect(modulex + 5 + pos.x + 55, moduley + 17 + texty + 8, 75, 11f, 1,
					new Color(0, 0, 0, 0).getRGB(), 1, new Color(HUD.colorValue.getValue()).getRGB());
		}
		// 文字
		FontLoaders.TahomaBold11.drawString(textValue.getName(), modulex + 5 + pos.x + 4, moduley + 17 + texty + 13,
				new Color(200, 200, 200).getRGB());

		// 显示框内文字 判断长度
		if (FontLoaders.TahomaBold12
				.getStringWidth(textValue.getTextHovered() ? textValue.getValue() + "_" : textValue.getValue()) > 70) {
			// 修剪字符串长度
			FontLoaders.TahomaBold12.drawString(
					FontLoaders.Tahoma16.trimStringToWidth(
							textValue.getTextHovered() ? textValue.getValue() + "_" : textValue.getValue(), 78, true),
					modulex + 5 + pos.x + 57, moduley + 17 + texty + 13, new Color(200, 200, 200).getRGB());
		} else {
			if (textValue.getValue().isEmpty() && !textValue.getTextHovered()) {
				FontLoaders.TahomaBold12.drawString("Type Here...", modulex + 5 + pos.x + 57, moduley + 17 + texty + 13,
						new Color(200, 200, 200).getRGB());
			} else {
				FontLoaders.TahomaBold12.drawString(
						textValue.getTextHovered() ? textValue.getValue() + "_" : textValue.getValue(),
						modulex + 5 + pos.x + 57, moduley + 17 + texty + 13, new Color(200, 200, 200).getRGB());
			}
		}
	}

	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= modulex + 5 + pos.x + 55 && mouseX <= modulex + 5 + pos.x + 55 + 75
				&& mouseY >= moduley + 17 + texty + 8 && mouseY <= moduley + 17 + texty + 8 + 11f;
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		// 设置是否输入
		if (isHovered(mouseX, mouseY)) {
			textValue.setTextHovered(!textValue.getTextHovered());
		} else if (textValue.getTextHovered()) {
			textValue.setTextHovered(false);
		}
	}

	@Override
	public void keyTyped(char typedChar, int keyCode) {
		// 输入
		if (textValue.getTextHovered()) {
			if (keyCode == Keyboard.KEY_ESCAPE) {
				textValue.setTextHovered(false);
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
				textValue.append(typedChar);
			}

			// 删除
			if (setting.getTextHovered() && Keyboard.isKeyDown(Keyboard.KEY_BACK)
					&& textValue.getValue().length() >= 1) {
				textValue.setValue(textValue.getValue().substring(0, textValue.getValue().length() - 1));
			}
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {
	}

}
