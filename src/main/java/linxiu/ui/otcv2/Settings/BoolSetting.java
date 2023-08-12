package linxiu.ui.otcv2.Settings;

import java.awt.*;

import linxiu.Client;
import linxiu.api.value.Option;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.font.FontLoaders;
import linxiu.ui.otcv2.Downward;
import linxiu.ui.otcv2.ModuleRender;

public class BoolSetting extends Downward<Option> {

	public BoolSetting(Option s, float x, float y, int width, int height, ModuleRender moduleRender) {
		super(s, x, y, width, height, moduleRender);

	}

	// 获取主界面xy跟随移动
	private float modulex, moduley, booly;

	@Override
	public void draw(int mouseX, int mouseY) {
		modulex = Client.INSTANCE.otc.getMainx();
		moduley = Client.INSTANCE.otc.getMainy();

		// 修复滚轮
		booly = pos.y + getScrollY();

		RenderUtil.drawRoundedRect(modulex + 5 + pos.x + 4, moduley + 17 + booly + 8, 135 - 128, 7, 1,
				setting.getValue() ? new Color(86, 94, 115).getRGB() : new Color(50, 54, 65).getRGB(), 1,
				setting.getValue() ? new Color(86, 94, 115).getRGB() : new Color(85, 90, 96).getRGB());
		if (isHovered(mouseX, mouseY)) {
			RenderUtil.drawRoundedRect(modulex + 5 + pos.x + 4, moduley + 17 + booly + 8, 135 - 128, 7, 1,
					new Color(0, 0, 0, 0).getRGB(), 1, new Color(HUD.colorValue.getValue()).getRGB());
		}
		FontLoaders.TahomaBold11.drawString(setting.getName(), modulex + 5 + pos.x + 4 + 10,
				moduley + 17 + booly + 8 + 3, new Color(200, 200, 200).getRGB());

	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (isHovered(mouseX, mouseY)) {
			setting.toggle();
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {

	}

	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= modulex + 5 + pos.x + 4 && mouseX <= modulex + 5 + pos.x + 4 + 135 - 128
				&& mouseY >= moduley + 17 + booly + 8 && mouseY <= moduley + 17 + booly + 8 + 7;
	}
}
