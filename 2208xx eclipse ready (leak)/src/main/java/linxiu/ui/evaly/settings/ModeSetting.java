package linxiu.ui.evaly.settings;

import net.minecraft.client.renderer.GlStateManager;
import oh.yalan.NativeClass;

import org.lwjgl.opengl.GL11;

import linxiu.Client;
import linxiu.api.value.Mode;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ModuleRender;
import linxiu.ui.evaly.SettingRender;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.font.FontLoaders;

import java.awt.*;

import static net.minecraft.client.Minecraft.getDebugFPS;
@NativeClass
public class ModeSetting extends SettingRender<Mode> {

	// 主界面xy
	public int mainX, mainY, y;
	private double length = 3, anim = 5;

	public ModeSetting(Mode s, float x, float y, int width, int height, ModuleRender moduleRender) {
		super(s, x, y, width, height, moduleRender);
	}

	@Override
	public void draw(int mouseX, int mouseY) {

		mainX = Client.INSTANCE.evalyGui.mainX;
		mainY = Client.INSTANCE.evalyGui.mainY;

		y = (int) (pos.y + getScrollY());

		FontLoaders.Tahoma11.drawString(setting.getName(), mainX + 17 + pos.x, mainY + 38 + y,
				new Color(244, 243, 245).getRGB());

	    RoundedUtil.drawRound(mainX + 17.5f + pos.x, mainY + 35 + y + 10.5f, 149, 7, 0, new Color(0, 0, 0));
		RenderUtil.drawGradientRect2(mainX + 17 + pos.x, mainY + 35 + y + 10, 150, 8, new Color(32, 32, 32).getRGB(),
				new Color(30, 30, 30).getRGB());

		FontLoaders.Tahoma11.drawString(setting.getValue(), mainX + 17 + 2 + pos.x, mainY + 38 + 10 + 1 + y,
				new Color(200, 200, 200).getRGB());

		double val = getDebugFPS() / 8.3;
		if (setting.openList && length > -3) {
			length -= 3 / val;
		} else if (!setting.openList && length < 3) {
			length += 2 / val;
		}
		if (setting.openList && anim < 8) {
			anim += 3 / val;
		} else if (!setting.openList && anim > 5) {
			anim -= 3 / val;
		}
		// 绘制箭头
		float anime = setting.openList ? 2 : 0;
		GlStateManager.pushMatrix();
		GlStateManager.scale(0.5, 0.5, 0.5);
		RenderUtil.drawArrow((mainX + 17 + 140 + pos.x + 3) * 2, (mainY + 34.5f + y + 9f + anim - anime) * 2, 2,
				new Color(200, 200, 200).getRGB(), length);
		GlStateManager.popMatrix();
		if (setting.openList) {
			// 循环添加Strings

			// 覆盖下面的Value
			GL11.glTranslatef(0.0f, 0.0f, 2.0f);
			RoundedUtil.drawRound(mainX + 17.5f + pos.x, mainY + 35 + 12 + y + 7.5f, 149, setting.getModes().length * 9f - 1f, 0,
					new Color(0, 0, 0));
			RenderUtil.drawGradientRect2(mainX + 17 + pos.x, mainY + 35 + 12 + y + 7, 150,
					setting.getModes().length * 9f, new Color(32, 32, 32).getRGB(), new Color(30, 30, 30).getRGB());

			for (String option : setting.getModes()) {

				FontLoaders.Tahoma11.drawString(option, mainX + 17 + pos.x + 2,
						mainY + 36 + 12 + y + 10 + setting.getModeListinde(option) * 9,
						option.equals(setting.getValue()) ? new Color(HUD.colorValue.getValue()).getRGB()
								: new Color(200, 200, 200).getRGB());
				GlStateManager.color(1, 1, 1);

			}
			GL11.glTranslatef(0.0f, 0.0f, -2.0f);
		}
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (mouseButton == 1
				&& RenderUtil.isHovering(mainX + 17 + pos.x, mainY + 35 + y + 10, 150, 10, mouseX, mouseY)) {
			setting.openList = !setting.openList;
		}

		// 设置mode
		if (mouseButton == 0) {
			if (this.setting.openList // 在这个x里面
					&& mouseX >= mainX + 17 + pos.x // 最小x
					&& mouseX <= mainX + 17 + pos.x + 150 // 最大x
			) {
				// 循环判断点击
				for (int i = 0; i < setting.getModes().length; i++) {
					// 判断Y
					final int v = (mainY + 38 + 8 + y + 10 + i * 9);

					if (mouseY >= v && mouseY <= v + 5) {
						this.setting.setMode(this.setting.getModeGet(i));
					}

				}
			}
		}
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {

	}
}
