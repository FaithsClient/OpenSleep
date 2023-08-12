package linxiu.ui.evaly.settings;

import java.awt.*;

import linxiu.Client;
import linxiu.api.value.Option;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ModuleRender;
import linxiu.ui.evaly.SettingRender;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.font.FontLoaders;
import oh.yalan.NativeClass;
@NativeClass
public class OptionSetting extends SettingRender<Option> {

	public OptionSetting(Option s, float x, float y, int width, int height, ModuleRender moduleRender) {
		super(s, x, y, width, height, moduleRender);
	}

	// 主界面xy
	public int mainX, mainY, y;

	@Override
	public void draw(int mouseX, int mouseY) {
		mainX = Client.INSTANCE.evalyGui.mainX;
		mainY = Client.INSTANCE.evalyGui.mainY;

		y = (int) (pos.y + getScrollY());

		FontLoaders.TahomaBold11.drawString(setting.getName(), mainX + 17 + pos.x + 7, mainY + 38.5f + y,
				new Color(244, 243, 245).getRGB());
		float tx = mainX + 17 + pos.x;
		float ty = mainY + 37 + y;
		RoundedUtil.drawRound(tx + 0.5f, ty + 0.5f, 3, 3, 0, new Color(0,0,0, 255));
		RenderUtil.drawGradientRect2(tx, ty, 4, 4,
				(boolean) setting.getValue() ? new Color(HUD.colorValue.getValue()).getRGB()
						: new Color(58, 58, 58).getRGB(),
				(boolean) setting.getValue() ? new Color(HUD.colorValue.getValue()).darker().getRGB()
						: new Color(58, 58, 58).darker().getRGB());

	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (RenderUtil.isHovering(mainX + 17 + pos.x, mainY + 37 + y, 4, 4, mouseX, mouseY) && mouseButton == 0) {
	        setting.toggle();
			return;
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {

	}

}
