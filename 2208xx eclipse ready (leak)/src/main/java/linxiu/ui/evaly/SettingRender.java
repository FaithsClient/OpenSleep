package linxiu.ui.evaly;


import linxiu.api.value.Value;
import linxiu.ui.evaly.ClickUtils.Position;
import net.minecraft.client.gui.Gui;
import oh.yalan.NativeClass;
@NativeClass
public abstract class SettingRender<V extends Value<?>> extends Gui{

    public V setting;

    private float x, y;
    private final int width;
    private final int height;

    public Position pos;

    public ModuleRender moduleRender;

    public SettingRender(V s, float x, float y, int width, int height, ModuleRender moduleRender) {
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

