package linxiu.ui;

import java.awt.Color;

import linxiu.Client;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.RenderUtil;
import linxiu.utils.render.Colors;
import linxiu.utils.render.RenderingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiMenuButton extends GuiButton {
   float scale = 1.0F;
   float targ;

   public GuiMenuButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
      super(buttonId, x, y, widthIn, heightIn, buttonText);
   }

   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
      if (this.visible) {
         this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition - 2 && mouseX < this.xPosition + 120 && mouseY < this.yPosition + 100;
         this.targ = this.hovered ? 1.8F : 1.0F;
         float diff = (this.targ - this.scale) * 0.00F;
         this.scale = 1.0F + diff;
         GlStateManager.pushMatrix();
         GlStateManager.scale(this.scale, this.scale, this.scale);
         this.mouseDragged(mc, mouseX, mouseY);
         int text = this.hovered ? Colors.getColor(160,160,160, 255) : -1;
         GlStateManager.pushMatrix();
         RenderUtil.drawBorderedRect(this.xPosition,this.yPosition,this.xPosition+120,this.yPosition+100,(float) .3,this.hovered ?new Color(160,160,160).getRGB():new Color(80,80,80).getRGB(),new Color(18,18,18).getRGB());
         FontLoaders.Tahoma18.drawString(this.displayString.toLowerCase(), (this.xPosition+60)-FontLoaders.Tahoma18.getStringWidth(displayString)/2-2, this.yPosition+12, text);
 
         Gui.drawRect(0, 0, 0, 0, 0);
         
         GlStateManager.popMatrix();
         GlStateManager.popMatrix();
      }

   }
}
