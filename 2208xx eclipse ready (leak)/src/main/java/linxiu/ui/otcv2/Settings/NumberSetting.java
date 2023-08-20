package linxiu.ui.otcv2.Settings;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

import java.awt.*;

import linxiu.Client;
import linxiu.api.value.Numbers;
import linxiu.module.modules.render.ClickGui;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.font.FontLoaders;
import linxiu.ui.otcv2.Downward;
import linxiu.ui.otcv2.ModuleRender;
import linxiu.utils.math.MathUtil;

public class NumberSetting extends Downward<Numbers> {

	public NumberSetting(Numbers s, float x, float y, int width, int height, ModuleRender moduleRender) {
		super(s, x, y, width, height, moduleRender);
	}

	// 获取主界面xy跟随移动
	private float modulex, moduley, numbery;

	public float percent = 0;

	// anti-bug
	private boolean iloveyou;

	@Override
	public void draw(int mouseX, int mouseY) {
		modulex = Client.INSTANCE.otc.getMainx();
		moduley = Client.INSTANCE.otc.getMainy();

		// 修复滚轮
		numbery = pos.y + getScrollY();

		double clamp = MathHelper.clamp_double(Minecraft.getMinecraft().getDebugFPS() / 30, 1, 9999);
		final double percentBar = (setting.getValue().doubleValue() - setting.getMinimum().doubleValue())
				/ (setting.getMaximum().doubleValue() - setting.getMinimum().doubleValue());

		percent = Math.max(0,
				Math.min(1, (float) (percent + (Math.max(0, Math.min(percentBar, 1)) - percent) * (0.2 / clamp))));
		// V2 Style
		// 背景
		RoundedUtil.drawRound(modulex + 5 + pos.x + 55, moduley + 17 + numbery + 8, 75, 2.5f, 1, new Color(34, 38, 48));
		// value大小线条
		RoundedUtil.drawRound(modulex + 5 + pos.x + 55, moduley + 17 + numbery + 8, 75 * percent, 2.5f, 1,
				new Color(HUD.colorValue.getValue()));
		// Value名字显示
		FontLoaders.TahomaBold11.drawString(setting.getName(), modulex + 5 + pos.x + 4, moduley + 17 + numbery + 8,
				new Color(200, 200, 200).getRGB());

		// 设置Value
		if (iloveyou) {

			float percentt = Math.min(1, Math.max(0, ((mouseX - (modulex + 5 + pos.x + 55)) / 99) * 1.3f));
			double newValue = (percentt * (setting.getMaximum().doubleValue() - setting.getMinimum().doubleValue()))
					+ setting.getMinimum().doubleValue();

			double set = MathUtil.incValue(newValue, setting.getIncrement().doubleValue());

			setting.setValue(set);
		}

		// 绘制文字框
		final ClickGui cg = (ClickGui) Client.INSTANCE.getModuleManager().getModuleByClass(ClickGui.class);
		if (iloveyou || isHovered(mouseX, mouseY) || cg.disp.getValue()) {
			RoundedUtil.drawRound(modulex + 5 + pos.x + 55 + 61 * percent, moduley + 17 + numbery + 8 + 6,
					FontLoaders.TahomaBold11.getStringWidth(setting.getValue() + "") + 1, 6, 1,
					new Color(32, 34, 39, 180));
			FontLoaders.TahomaBold11.drawString(setting.getValue() + "", modulex + 5.5f + pos.x + 55 + 62 * percent,
					moduley + 17 + numbery + 8 + 8, new Color(250, 250, 250).getRGB());
		}
		// 所选
		if (isHovered(mouseX, mouseY)) {
			RenderUtil.drawRoundedRect(modulex + 5 + pos.x + 55, moduley + 17 + numbery + 8, 75, 2.5f, 1,
					new Color(0, 0, 0, 0).getRGB(), 1, new Color(HUD.colorValue.getValue()).getRGB());
		}
		// V3 Style
		// RoundedUtil.drawRound(modulex+ 5+ pos.x + 55 ,moduley+ 17 +numbery +
		// 8,75,2.5f,1, new Color(HUD.Hudcolor.getVaule()));
		// Fonts.SFBOLD.SFBOLD_11.SFBOLD_11.drawString(setting.getName(),modulex+ 5+
		// pos.x + 4 ,moduley+ 17 +numbery + 8,new Color(200,200,200).getRGB());
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (isHovered(mouseX, mouseY)) {
			if (mouseButton == 0) {
				iloveyou = true;
			}
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {
		if (state == 0)
			iloveyou = false;
	}

	// 如果指针在线条上
	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= modulex + 5 + pos.x + 55 && mouseX <= modulex + 5 + pos.x + 55 + 75
				&& mouseY >= moduley + 17 + numbery + 8 && mouseY <= moduley + 17 + numbery + 8 + 2.5f;
	}
}
