package linxiu.ui.astolfoold;

import com.google.common.collect.Lists;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.render.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

public class Window {
	public ModuleType category;
	public ArrayList<Button> buttons = Lists.newArrayList();
	public boolean drag;
	public boolean extended;
	public int x;
	public int y;
	public int expand;
	public int dragX;
	public int dragY;
	public int max;
	public int scroll;
	public int scrollTo;
	public double angel;
	int staticColor;

	public int totalY;

	public Window(ModuleType category, int x, int y) {
		this.category = category;
		this.x = x;
		this.y = y;
		this.max = 120;
		int y2 = y + 25;
		for (Module c : ModuleManager.getModules()) {
			if (c.getType() != category)
				continue;
			this.buttons.add(new Button(category, c, x + 5, y2));
			y2 += 15;
		}
		for (Button b2 : this.buttons) {
			b2.setParent(this);
		}
	}

	public void render(int mouseX, int mouseY) {
		int current = 0;

		int iY = this.y + 20;
		totalY = 15;

		for (Button b3 : this.buttons) {
			b3.y = iY - offset;
			iY += 15;
			totalY += 15;
			if (b3.expand) {
				for (ValueButton v : b3.buttons) {
					current += 15;
					totalY += 15;
				}
			}
			current += 15;
		}
		int height = 15 + current;
		// 限制添加高度
		if (height > 16 + 15 * 20) {
			height = 16 + 15 * 20;
		}

		if (this.extended) {
			this.expand = height;
			this.angel = 180.0;
		} else {
			this.expand = 0;
			this.angel = 0.0;
		}

		boolean isOnPanel = mouseX > this.x - 2 && mouseX < this.x + 92 && mouseY > this.y - 2
				&& mouseY < this.y + expand;
		if (isOnPanel)
			runWheel(height);
		
		if (this.category.name().equals("Combat")) {
			staticColor = new Color(225,25,25).getRGB();
		} else if (this.category.name().equals("Render")) {
			staticColor = new Color(38, 160, 255).getRGB();
		} else if (this.category.name().equals("Movement")) {
			staticColor = new Color(0, 150, 120).getRGB();
		} else if (this.category.name().equals("Player")) {
			staticColor = new Color(128, 0, 128).getRGB();
		} else if (this.category.name().equals("Legit")) {
			staticColor = new Color(255, 140, 205).getRGB();
		}

		// GlStateManager.pushMatrix();
		if (expand > 0) {
			RenderUtil.rectangleBordered(this.x - 0.5, this.y - 0.5, this.x + 90.5, this.y + 1.5 + expand, 1.0f,
					staticColor, staticColor);// category
			RenderUtil.rectangleBordered(this.x, this.y, this.x + 90, this.y + 1.0 + expand, 1.0f,
					new Color(39,39,39).getRGB(), new Color(39,39,39).getRGB());// category
		}

		RenderUtil.drawGradientRect(this.x, this.y, this.x + 90, this.y + 17, new Color(25, 25, 25).getRGB(),
				new Color(25, 25, 25).getRGB());// category
		// Client.instance.getFontManager().arial17.drawStringWithShadow(this.category.name(),
		// x + 81 -
		// Client.instance.getFontManager().arial17.getStringWidth(this.category.name()),
		// this.y, new Color(200,200,200 ).getRGB());
		// FontLoaders.clickgui16.drawStringWithShadow(this.category.name().toLowerCase(),
		// this.x + 3, this.y + 6, new Color(220, 220, 220).getRGB());
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		if (this.category.name().equals("Combat")) {
			FontLoaders.TahomaBold14.drawStringWithShadow("combat", this.x + 3, this.y + 6, new Color(220, 220, 220).getRGB());
			FontLoaders.logog18.drawString("D", this.x + 80 , this.y + 7, -1);
		}
		if (this.category.name().equals("Render")) {
			FontLoaders.TahomaBold14.drawStringWithShadow("visual", this.x + 3, this.y + 6, new Color(220, 220, 220).getRGB());
			FontLoaders.logog18.drawString("C", this.x  + 79, this.y + 7, -1);
		}
		if (this.category.name().equals("Movement")) {
			FontLoaders.TahomaBold14.drawStringWithShadow("movement", this.x + 3, this.y + 6, new Color(220, 220, 220).getRGB());
			FontLoaders.logog18.drawString("A", this.x + 80, this.y + 7, -1);
		}
		if (this.category.name().equals("Player")) {
			FontLoaders.TahomaBold14.drawStringWithShadow("player", this.x + 3, this.y + 6, new Color(220, 220, 220).getRGB());
			FontLoaders.logog18.drawString("B", this.x + 80, this.y + 7,-1);
		}
		if (this.category.name().equals("Legit")) {
			FontLoaders.TahomaBold14.drawStringWithShadow("ghost", this.x + 3, this.y + 6, new Color(220, 220, 220).getRGB());
			FontLoaders.logog18.drawString("K", this.x + 80, this.y + 7,-1);
		}
		/*
		 * GlStateManager.pushMatrix(); GlStateManager.translate(this.x + 90 - 10,
		 * this.y + 5, 0.0f); GlStateManager.rotate((float) this.angel, 0.0f, 0.0f,
		 * -1.0f); GlStateManager.translate(-this.x + 90 - 10, -this.y + 5, 0.0f);
		 * GlStateManager.popMatrix();
		 */
		if (this.expand > 0) {
			for (Button b2 : buttons) {
				b2.render(mouseX, mouseY, new Limitation(this.x, this.y + 16, this.x + 90, this.y + expand));
			}
		}

		if (this.drag) {
			if (!Mouse.isButtonDown(0)) {
				this.drag = false;
			}
			this.x = mouseX - this.dragX;
			this.y = mouseY - this.dragY;
			this.buttons.get(0).y = this.y + 22 - this.offset;
			for (Button b4 : this.buttons) {
				b4.x = this.x + 5;
			}
		}
	}

	int offset;

	// ADD
	public static void doGlScissor(int x, int y, int width, int height) {
		Minecraft mc = Minecraft.getMinecraft();
		int scaleFactor = 1;
		int k = mc.gameSettings.guiScale;
		if (k == 0) {
			k = 1000;
		}
		while (scaleFactor < k && mc.displayWidth / (scaleFactor + 1) >= 320
				&& mc.displayHeight / (scaleFactor + 1) >= 240) {
			++scaleFactor;
		}
		GL11.glScissor(x * scaleFactor, mc.displayHeight - (y + height) * scaleFactor,
				width * scaleFactor, height * scaleFactor);
	}

	// ADD
	protected void runWheel(int height) {
		if (Mouse.hasWheel()) {
			int wheel = Mouse.getDWheel();
			if (totalY - height <= 0)
				return;
			if (wheel < 0) {
				if (offset < totalY - height) {
					offset += 20;
					if (offset < 0) {
						offset = 0;
					}
				}
			} else if (wheel > 0) {
				offset -= 20;
				if (offset < 0) {
					offset = 0;
				}
			}
		}
	}

	public void key(char typedChar, int keyCode) {
		this.buttons.forEach(b2 -> b2.key(typedChar, keyCode));
	}

	public void mouseScroll(int mouseX, int mouseY, int amount) {
		if (mouseX > this.x - 2 && mouseX < this.x + 92 && mouseY > this.y - 2 && mouseY < this.y + 17 + this.expand) {
			this.scrollTo = (int) ((float) this.scrollTo - (float) (amount / 120 * 28));
		}
	}

	public void click(int mouseX, int mouseY, int button) {
		if (mouseX > this.x - 2 && mouseX < this.x + 92 && mouseY > this.y - 2 && mouseY < this.y + 17) {
			if (button == 1) {
				boolean bl = this.extended = !this.extended;
			}
			if (button == 0) {
				this.drag = true;
				this.dragX = mouseX - this.x;
				this.dragY = mouseY - this.y;
			}
		}
		if (this.extended) {
			this.buttons.stream().filter(b2 -> b2.y < this.y + this.expand)
					.forEach(b2 -> b2.click(mouseX, mouseY, button));
		}
	}
}
