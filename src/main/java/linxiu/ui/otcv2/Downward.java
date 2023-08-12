package linxiu.ui.otcv2;

import linxiu.api.value.Value;
import linxiu.ui.otcv2.Utils.Position;
import net.minecraft.client.gui.Gui;

public abstract class Downward<V extends Value> extends Gui{

    public V setting;

    private float x, y;
    private int width, height;

    public Position pos;

    public ModuleRender moduleRender;

    public Downward(V s, float x, float y, int width, int height,ModuleRender moduleRender) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setting = s;
        this.pos = new Position(getX(), getY(), getWidth(), getHeight());
        this.moduleRender = moduleRender;
    }

    public abstract void draw(int mouseX, int mouseY);

    public abstract void mouseClicked(int mouseX, int mouseY, int mouseButton);

    public void keyTyped(char typedChar,int keyCode){

    }

    public abstract void mouseReleased(int mouseX, int mouseY, int state);


    public void update() {
        pos = new Position(getX(), getY(), getWidth(), getHeight());
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //滚轮
    public int getScrollY() {
        return moduleRender.getScrollY();
    }
}

