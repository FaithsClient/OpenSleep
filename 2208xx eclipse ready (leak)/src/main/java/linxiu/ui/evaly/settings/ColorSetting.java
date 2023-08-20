package linxiu.ui.evaly.settings;


import org.lwjgl.opengl.GL11;

import linxiu.Client;
import linxiu.api.value.ColorValue;
import linxiu.ui.evaly.ModuleRender;
import linxiu.ui.evaly.SettingRender;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.font.FontLoaders;
import oh.yalan.NativeClass;

import java.awt.*;
@NativeClass
public class ColorSetting extends SettingRender<ColorValue> {

    public ColorValue colorValue;

    private float hue;
    private float saturation;
    private float brightness;
    private float alpha;
    private boolean colorSelectorDragging;
    private boolean hueSelectorDragging;
    private boolean alphaSelectorDragging;

    //获取主界面xy跟随移动
    private float moduleX, moduleY, colorY;

    public ColorSetting(ColorValue s, float x, float y, int width, int height, ModuleRender moduleRender) {
        super(s, x, y, width, height, moduleRender);
        this.colorValue = s;
        updateValue(s.getValue());
    }


    @Override
    public void draw(int mouseX, int mouseY) {
        moduleX = Client.INSTANCE.evalyGui.mainX;
        moduleY = Client.INSTANCE.evalyGui.mainY;

        //修复滚轮
        colorY = pos.y + getScrollY();

        float x2 = pos.x + moduleX + 153;
        float y2 = colorY + moduleY + 38;

        float width = 11;
        float height = 5;

        FontLoaders.Tahoma11.drawString(setting.getName(), moduleX + 17 + pos.x, moduleY + 38 + colorY, new Color(244, 243, 245).getRGB());

        //绘制调色板SKID
        int black = RenderUtil.getColor(0);
        RenderUtil.drawRect(x2 - 0.2f, y2 - 0.2f, (x2 + width) + 0.2f, (y2 + height) + 0.2f, black);
        int guiAlpha = 255;
        int color = colorValue.getValue();
        int colorAlpha = color >> 24 & 0xFF;

        if (colorAlpha < 255) {
            RenderUtil.drawCheckeredBackground(x2, y2, x2 + width, y2 + height);
        }

        int newColor = new Color(color >> 16 & 0xFF, color >> 8 & 0xFF, color & 0xFF, colorAlpha).getRGB();
        RenderUtil.drawGradientRect(x2, y2, x2 + width, y2 + height, newColor, RenderUtil.darker(newColor, 0.6f));
        if (colorValue.isExpanded()) {
            float hueSelectorY;
            float hueSliderYDif;
            float alphaSliderBottom;
            float hueSliderRight;
            GL11.glTranslated(0.0, 0.0, 3.0);
            float expandedX = this.getExpandedX();
            float expandedY = this.getExpandedY();
            float expandedWidth = this.getExpandedWidth();
            float expandedHeight = this.getExpandedHeight();
            RenderUtil.drawBorderedRect(expandedX, expandedY, expandedX + expandedWidth, expandedY + expandedHeight + 70, 1, new Color(0, 0, 0, 0).getRGB(), new Color(15, 15, 25, 120).getRGB());
            float colorPickerSize = expandedWidth - 9.0f - 8.0f;
            float colorPickerLeft = expandedX + 3.0f;
            float colorPickerTop = expandedY + 3.0f;
            float colorPickerRight = colorPickerLeft + colorPickerSize;
            float colorPickerBottom = colorPickerTop + colorPickerSize;
            int selectorWhiteOverlayColor = new Color(255, 255, 255, 180).getRGB();
            if ((float) mouseX <= colorPickerLeft || (float) mouseY <= colorPickerTop || (float) mouseX >= colorPickerRight || (float) mouseY >= colorPickerBottom) {
                this.colorSelectorDragging = false;
            }
            RenderUtil.drawRect(colorPickerLeft - 0.5f, colorPickerTop - 0.5f, colorPickerRight + 0.5f, colorPickerBottom + 0.5f, RenderUtil.getColor(0));
            this.drawColorPickerRect(colorPickerLeft, colorPickerTop, colorPickerRight, colorPickerBottom);
            float hueSliderLeft = this.saturation * (colorPickerRight - colorPickerLeft);
            float alphaSliderTop = (1.0f - this.brightness) * (colorPickerBottom - colorPickerTop);
            if (this.colorSelectorDragging) {
                hueSliderRight = colorPickerRight - colorPickerLeft;
                alphaSliderBottom = (float) mouseX - colorPickerLeft;
                this.saturation = alphaSliderBottom / hueSliderRight;
                hueSliderLeft = alphaSliderBottom;
                hueSliderYDif = colorPickerBottom - colorPickerTop;
                hueSelectorY = (float) mouseY - colorPickerTop;
                this.brightness = 1.0f - hueSelectorY / hueSliderYDif;
                alphaSliderTop = hueSelectorY;
                this.updateColor(Color.HSBtoRGB(this.hue, this.saturation, this.brightness), false);
            }
            hueSliderRight = colorPickerLeft + hueSliderLeft - 0.5f;
            alphaSliderBottom = colorPickerTop + alphaSliderTop - 0.5f;
            hueSliderYDif = colorPickerLeft + hueSliderLeft + 0.5f;
            hueSelectorY = colorPickerTop + alphaSliderTop + 0.5f;
            RenderUtil.drawRect(hueSliderRight - 0.5f, alphaSliderBottom - 0.5f, hueSliderRight, hueSelectorY + 0.5f, black);
            RenderUtil.drawRect(hueSliderYDif, alphaSliderBottom - 0.5f, hueSliderYDif + 0.5f, hueSelectorY + 0.5f, black);
            RenderUtil.drawRect(hueSliderRight, alphaSliderBottom - 0.5f, hueSliderYDif, alphaSliderBottom, black);
            RenderUtil.drawRect(hueSliderRight, hueSelectorY, hueSliderYDif, hueSelectorY + 0.5f, black);
            RenderUtil.drawRect(hueSliderRight, alphaSliderBottom, hueSliderYDif, hueSelectorY, selectorWhiteOverlayColor);
            hueSliderLeft = colorPickerRight + 3.0f;
            hueSliderRight = hueSliderLeft + 8.0f;
            if ((float) mouseX <= hueSliderLeft || (float) mouseY <= colorPickerTop || (float) mouseX >= hueSliderRight || (float) mouseY >= colorPickerBottom) {
                this.hueSelectorDragging = false;
            }
            hueSliderYDif = colorPickerBottom - colorPickerTop;
            hueSelectorY = (1.0f - this.hue) * hueSliderYDif;
            if (this.hueSelectorDragging) {
                float inc = (float) mouseY - colorPickerTop;
                this.hue = 1.0f - inc / hueSliderYDif;
                hueSelectorY = inc;
                this.updateColor(Color.HSBtoRGB(this.hue, this.saturation, this.brightness), false);
            }
            RenderUtil.drawRect(hueSliderLeft - 0.5f, colorPickerTop - 0.5f, hueSliderRight + 0.5f, colorPickerBottom + 0.5f, black);
            float hsHeight = colorPickerBottom - colorPickerTop;
            float alphaSelectorX = hsHeight / 5.0f;
            float asLeft = colorPickerTop;
            int i2 = 0;
            while ((float) i2 < 5.0f) {
                boolean last = (float) i2 == 4.0f;
                RenderUtil.drawGradientRect(hueSliderLeft, asLeft, hueSliderRight, asLeft + alphaSelectorX, RenderUtil.getColor(Color.HSBtoRGB(1.0f - 0.2f * (float) i2, 1.0f, 1.0f)), RenderUtil.getColor(Color.HSBtoRGB(1.0f - 0.2f * (float) (i2 + 1), 1.0f, 1.0f)));
                if (!last) {
                    asLeft += alphaSelectorX;
                }
                ++i2;
            }
            float hsTop = colorPickerTop + hueSelectorY - 0.5f;
            float asRight = colorPickerTop + hueSelectorY + 0.5f;
            RenderUtil.drawRect(hueSliderLeft - 0.5f, hsTop - 0.5f, hueSliderLeft, asRight + 0.5f, black);
            RenderUtil.drawRect(hueSliderRight, hsTop - 0.5f, hueSliderRight + 0.5f, asRight + 0.5f, black);
            RenderUtil.drawRect(hueSliderLeft, hsTop - 0.5f, hueSliderRight, hsTop, black);
            RenderUtil.drawRect(hueSliderLeft, asRight, hueSliderRight, asRight + 0.5f, black);
            RenderUtil.drawRect(hueSliderLeft, hsTop, hueSliderRight, asRight, selectorWhiteOverlayColor);
            alphaSliderTop = colorPickerBottom + 3.0f;
            alphaSliderBottom = alphaSliderTop + 8.0f;
            if ((float) mouseX <= colorPickerLeft || (float) mouseY <= alphaSliderTop || (float) mouseX >= colorPickerRight || (float) mouseY >= alphaSliderBottom) {
                this.alphaSelectorDragging = false;
            }
            int z2 = Color.HSBtoRGB(this.hue, this.saturation, this.brightness);
            int r2 = z2 >> 16 & 0xFF;
            int g2 = z2 >> 8 & 0xFF;
            int b2 = z2 & 0xFF;
            hsHeight = colorPickerRight - colorPickerLeft;
            alphaSelectorX = this.alpha * hsHeight;
            if (this.alphaSelectorDragging) {
                asLeft = (float) mouseX - colorPickerLeft;
                this.alpha = asLeft / hsHeight;
                alphaSelectorX = asLeft;
                this.updateColor(new Color(r2, g2, b2, (int) (this.alpha * 255.0f)).getRGB(), true);
            }
            RenderUtil.drawRect(colorPickerLeft - 0.5f, alphaSliderTop - 0.5f, colorPickerRight + 0.5f, alphaSliderBottom + 0.5f, black);
            RenderUtil.drawCheckeredBackground(colorPickerLeft, alphaSliderTop, colorPickerRight, alphaSliderBottom);
            RenderUtil.drawGradientRect(colorPickerLeft, alphaSliderTop, colorPickerRight, alphaSliderBottom, true, new Color(r2, g2, b2, 0).getRGB(), new Color(r2, g2, b2, Math.min(guiAlpha, 255)).getRGB());
            asLeft = colorPickerLeft + alphaSelectorX - 0.5f;
            asRight = colorPickerLeft + alphaSelectorX + 0.5f;
            RenderUtil.drawRect(asLeft - 0.5f, alphaSliderTop, asRight + 0.5f, alphaSliderBottom, black);
            RenderUtil.drawRect(asLeft, alphaSliderTop, asRight, alphaSliderBottom, selectorWhiteOverlayColor);
            GL11.glTranslated(0.0, 0.0, -3.0);
        }
    }


    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX >= pos.x + moduleX + 153 && mouseX <= pos.x + moduleX + 153 + 13 && mouseY >= colorY + moduleY + 35 + 2 && mouseY <= (colorY + moduleY + 38 - 0.5 + 8);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 1) {
            if (isHovered(mouseX, mouseY)) {
                colorValue.setExpanded(!colorValue.isExpanded());
            }
        }
        if (colorValue.isExpanded() && mouseButton == 0) {
            float expandedX = this.getExpandedX();
            float expandedY = this.getExpandedY();
            float expandedWidth = this.getExpandedWidth();
            float colorPickerSize = expandedWidth - 9.0f - 8.0f;
            float colorPickerLeft = expandedX + 3.0f;
            float colorPickerTop = expandedY + 3.0f;
            float colorPickerRight = colorPickerLeft + colorPickerSize;
            float colorPickerBottom = colorPickerTop + colorPickerSize;
            float alphaSliderTop = colorPickerBottom + 3.0f;
            float alphaSliderBottom = alphaSliderTop + 8.0f;
            float hueSliderLeft = colorPickerRight + 3.0f;
            float hueSliderRight = hueSliderLeft + 8.0f;
            this.colorSelectorDragging = !this.colorSelectorDragging && (float) mouseX > colorPickerLeft && (float) mouseY > colorPickerTop && (float) mouseX < colorPickerRight && (float) mouseY < colorPickerBottom;
            this.alphaSelectorDragging = !this.alphaSelectorDragging && (float) mouseX > colorPickerLeft && (float) mouseY > alphaSliderTop && (float) mouseX < colorPickerRight && (float) mouseY < alphaSliderBottom;
            this.hueSelectorDragging = !this.hueSelectorDragging && (float) mouseX > hueSliderLeft && (float) mouseY > colorPickerTop && (float) mouseX < hueSliderRight && (float) mouseY < colorPickerBottom;
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        if (this.hueSelectorDragging) {
            this.hueSelectorDragging = false;
        } else if (this.colorSelectorDragging) {
            this.colorSelectorDragging = false;
        } else if (this.alphaSelectorDragging) {
            this.alphaSelectorDragging = false;
        }
    }

    public void updateColor(int hex, boolean hasAlpha) {
        if (hasAlpha) {
            colorValue.setValue(hex);
        } else {
            colorValue.setValue(new Color(hex >> 16 & 0xFF, hex >> 8 & 0xFF, hex & 0xFF, (int) (this.alpha * 255.0f)).getRGB());
        }
    }

    private void drawColorPickerRect(float left, float top, float right, float bottom) {
        int hueBasedColor = RenderUtil.getColor(Color.HSBtoRGB(this.hue, 1.0F, 1.0F));
        RenderUtil.drawGradientRect(left, top, right, bottom, true, RenderUtil.getColor(16777215), hueBasedColor);
        RenderUtil.drawGradientRect(left, top, right, bottom, 0, RenderUtil.getColor(0));
    }

    public void updateValue(int value) {
        float[] hsb = this.getHSBFromColor(value);
        this.hue = hsb[0];
        this.saturation = hsb[1];
        this.brightness = hsb[2];
        this.alpha = (float) (value >> 24 & 255) / 255.0f;
    }

    private float[] getHSBFromColor(int hex) {
        int r2 = hex >> 16 & 0xFF;
        int g2 = hex >> 8 & 0xFF;
        int b2 = hex & 0xFF;
        return Color.RGBtoHSB(r2, g2, b2, null);
    }

    public float getExpandedX() {
        return pos.x + moduleX + 153 + 11 - 80.333336f;
    }

    public float getExpandedY() {
        return colorY + moduleY + 38 + 5;
    }

    public float getExpandedWidth() {
        float right = pos.x + moduleX + 153 + 11;
        return right - this.getExpandedX();
    }

    public float getExpandedHeight() {
        return 11;
    }
}
