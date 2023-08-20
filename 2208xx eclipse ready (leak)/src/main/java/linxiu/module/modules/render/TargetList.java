package linxiu.module.modules.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.opengl.GL11;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.management.PlayerManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.math.MathUtil;
import net.minecraft.entity.Entity;


public class TargetList extends Module {
    private static int listX = 118, listY = 34;

	public TargetList() {
		super("TargetList", new String[] { "TargetList" }, ModuleType.Render);
	}
	
    public static int getListX() {
        return listX;
    }

    public static void setListX(int listX) {
    	TargetList.listX = listX;
    }

    public static int getListY() {
        return listY;
    }

    public static void setListY(int listY) {
        TargetList.listY = listY;
    }

    public static boolean isHover(int mouseX, int mouseY) {
        return MathUtil.inRange(mouseX, mouseY, listX + 110, listY + 35, listX + 10, listY + 15 ) && Client.INSTANCE.getModuleManager().getModule("TargetList").isEnabled();
    }
    private List<Entity> getLoadedTargets() {
        return mc.theWorld.getLoadedEntityList().stream().filter(e -> PlayerManager.isTarget(e))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    @EventHandler
    void onRender(EventRender2D event){
        int yHeight = 13;
        int x = 10;
        int y = 8;
        final List<Entity> targets = getLoadedTargets();
        int width = 0;

        for (Entity target : targets) {
            yHeight += FontLoaders.Tahoma13.getHeight() + 1;
            int stringWidth = FontLoaders.Tahoma13.getStringWidth(target.getDisplayName().getFormattedText());

            if (stringWidth > width) {
                width = stringWidth;
            }
        }

        GL11.glPushMatrix();

        GL11.glTranslatef(listX, listY, 0);

        width = Math.max(100, width + 25);
        width += width == 100 ? 0 : 30;
        yHeight -= FontLoaders.Tahoma13.getHeight() + 1;

        if (targets.isEmpty()) {
            yHeight -= 2;
        }

       
       // RenderUtil.drawRect(x, y + 10, x + width - 8, y + yHeight, Color.BLACK.getRGB());
       // RenderUtil.drawRect(x + 1, y + 1 + 10, x + width - 8 - 1, y + yHeight - 1, new Color(55, 55, 55).getRGB());
      //  RenderUtil.drawRect(x + 1, y + 1.5 + 10, x + width - 8 - 2, y + yHeight - 1.5, new Color(30, 30, 30).getRGB());
        //RenderUtil.drawRect(x + 3, y + 3 + 10, x + width - 8 - 3, y + yHeight - 3, new Color(14, 14, 14).getRGB());
        
        RenderUtil.drawExhRect(x , y  + 10, x + width - 8, y + yHeight);

        FontLoaders.TahomaBold13.drawString("Targets", x + 5, y +16, Color.WHITE.getRGB(), false);

        int yOffset = y + 20;

        for (Entity target : targets) {
        	FontLoaders.TahomaBold11.drawString(target.getDisplayName().getFormattedText(), x + 5.5f, yOffset + 4, new Color(200, 200, 200, 255).getRGB());
            yOffset += FontLoaders.TahomaBold11.getHeight() + 2;
        }
        GL11.glPopMatrix();

    }

}
