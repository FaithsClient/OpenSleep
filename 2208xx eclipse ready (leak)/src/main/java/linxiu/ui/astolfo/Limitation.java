package linxiu.ui.astolfo;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

//这个Class添加到你的包里 然后引用

public class Limitation {
    public int startX, startY, endX, endY;
    public Limitation(int x1, int y1, int x2, int y2){
        this.startX = x1;
        this.startY = y1;
        this.endX = x2;
        this.endY = y2;
    }
    
    public void cut(){
        doGlScissor(startX, startY + 1, endX - startX + 20, endY - startY + 50);
    }
    
    public static void doGlScissor(int x, int y, int width, int height) {
        Minecraft mc = Minecraft.getMinecraft();
        int scaleFactor = 1;
        int k = mc.gameSettings.guiScale;
        if (k == 0) {
            k = 1000;
        }
        while (scaleFactor < k && mc.displayWidth / (scaleFactor + 1) >= 320 && mc.displayHeight / (scaleFactor + 1) >= 240) {
            ++scaleFactor;
        }
        GL11.glScissor(x * scaleFactor, mc.displayHeight - (y + height) * scaleFactor, width * scaleFactor, height * scaleFactor);
    }
}
