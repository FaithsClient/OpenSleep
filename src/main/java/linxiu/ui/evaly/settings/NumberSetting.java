package linxiu.ui.evaly.settings;


import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import oh.yalan.NativeClass;

import java.awt.*;

import linxiu.Client;
import linxiu.api.value.Numbers;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ModuleRender;
import linxiu.ui.evaly.SettingRender;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.math.MathUtil;

@NativeClass
public class NumberSetting extends SettingRender<Numbers<Number>> {


    //主界面xy
    public int mainX, mainY, y;
    public float percent = 0;
    //anti-bug
    private boolean check;

    public NumberSetting(Numbers<Number> s, float x, float y, int width, int height, ModuleRender moduleRender) {
        super(s, x, y, width, height, moduleRender);
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        mainX = Client.INSTANCE.evalyGui.mainX;
        mainY = Client.INSTANCE.evalyGui.mainY;

        y = (int) (pos.y + getScrollY());
        FontLoaders.Tahoma11.drawString(setting.getName(), mainX + 17 + pos.x, mainY + 38 + y, new Color(244, 243, 245).getRGB());
        RoundedUtil.drawRound(mainX + 17.5f + pos.x, mainY + 40 + y + 4.5f, 149, 2.5f, 0, new Color(0, 0, 0));
        RenderUtil.drawGradientRect2(mainX + 17 + pos.x, mainY + 40 + y + 4, 150, 3.5f, new Color(71, 71, 71).getRGB(), new Color(71, 71, 71).darker().getRGB());


        double clamp = MathHelper.clamp_float(Minecraft.getDebugFPS() / 30f, 1, 9999);
        final double percentBar = (setting.getValue().doubleValue() - setting.getMinimum().doubleValue()) / (setting.getMaximum().doubleValue() - setting.getMinimum().doubleValue());

        percent = Math.max(0, Math.min(1, (float) (percent + (Math.max(0, Math.min(percentBar, 1)) - percent) * (0.2 / clamp))));

        RenderUtil.drawGradientRect2(mainX + 17 + pos.x, mainY + 40 + y + 4, 150 * percent, 3.5f, new Color(HUD.colorValue.getValue()).getRGB(), new Color(HUD.colorValue.getValue()).darker().getRGB());

        //设置Value
        if (check) {

            float min = Math.min(1, Math.max(0, ((mouseX - (mainX + 17 + pos.x)) / 99) * 0.65f));
            double newValue = (min * (setting.getMaximum().doubleValue() - setting.getMinimum().doubleValue())) + setting.getMinimum().doubleValue();

            double set = MathUtil.incValue(newValue, setting.getIncrement().doubleValue());

            setting.setValue(set);
        }

        float x1 = mainX + 17 + pos.x + 150 * percent -  FontLoaders.Tahoma11.getStringWidth("\247l" + setting.getValue()) / 2f;
        float y1 = mainY + 41.5f + y + 6;
        if (setting.getValue().doubleValue() != setting.getMinimum().doubleValue()) {
             FontLoaders.Tahoma9.drawString("\247l" + setting.getValue(), x1 - 0.5f, y1, 0);
             FontLoaders.Tahoma9.drawString("\247l" + setting.getValue(), x1, y1 - 0.5f, 0);
             FontLoaders.Tahoma9.drawString("\247l" + setting.getValue(), x1 + 0.5f, y1, 0);
             FontLoaders.Tahoma9.drawString("\247l" + setting.getValue(), x1, y1 + 0.5f, 0);
             FontLoaders.Tahoma9.drawString("\247l" + setting.getValue(), x1, y1, -1);
        }

    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {

        if (RenderUtil.isHovering(mainX + 17 + pos.x, mainY + 38 + y + 6, 150, 3.5f, mouseX, mouseY)) {

            if (mouseButton == 0) {
                check = true;
            }
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        if (state == 0) check = false;
    }
}
