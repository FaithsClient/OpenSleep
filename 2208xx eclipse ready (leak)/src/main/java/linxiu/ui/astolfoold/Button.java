package linxiu.ui.astolfoold;

import com.google.common.collect.Lists;
import linxiu.api.value.Value;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.render.HUD;
import linxiu.ui.font.FontLoaders;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

public class Button {
	public Module cheat;
	public Window parent;
	public int x;
	public int y;
	public int enable;
	public int arrow;
	public int index;
	public int remander;
	private final int valueY;
	public double opacity = 0.0;
	public ArrayList<ValueButton> buttons = Lists.newArrayList();
	public boolean expand;
	int staticColor;
	public ModuleType category;

	public Button(ModuleType category, Module cheat, int x, int y) {
		this.category = category;
		this.cheat = cheat;
		this.x = x;
		this.y = y;
		int y2 = y + 15;
		valueY = 0;
		for (Value v : cheat.getValues()) {
			this.buttons.add(new ValueButton(category, v, x + 5, y2));
			y2 += 18;
		}
		if (cheat == ModuleManager.getModuleByClass(HUD.class)) {
			this.buttons.add(new ColorValueButton(category, x + 15, y2));
		}
		this.buttons.add(new KeyBindButton(category, cheat, x + 5, y2));
		this.buttons.add(new HideButton(category, cheat, x + 5, y2));
	}

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

	public void render(int mouseX, int mouseY, Limitation limitation) {

		if (this.index != 0) {
			Button b2 = this.parent.buttons.get(this.index - 1);
			this.y = b2.y + 15 + (b2.expand ? 15 * b2.buttons.size() : 0);
		}
		int i = 0;
		while (i < this.buttons.size()) {
			this.buttons.get(i).y = this.y + 14 + 15 * i;
			this.buttons.get(i).x = this.x + 5;
			++i;
		}

		if (this.parent.category.name().equals("Combat")) {
			staticColor = new Color(225,25,25).getRGB();
		} else if (this.parent.category.name().equals("Render")) {
			staticColor = new Color(38, 160, 255).getRGB();
		} else if (this.parent.category.name().equals("Movement")) {
			staticColor = new Color(0, 150, 120).getRGB();
		} else if (this.parent.category.name().equals("Player")) {
			staticColor = new Color(128, 0, 128).getRGB();
		} else if (this.parent.category.name().equals("Legit")) {
			staticColor = new Color(255, 140, 205).getRGB();
		}

		GL11.glPushMatrix();
		GL11.glEnable(3089);
		doGlScissor(this.x - 5, this.y - 5, 90,
				FontLoaders.TahomaBold14.getStringHeight(this.cheat.getName().toLowerCase()) + 5);
		limitation.cut();
		Gui.drawRect(this.x - 5, this.y - 5, this.x + 85,
				this.y + 5 + FontLoaders.TahomaBold14.getStringHeight(this.cheat.getName().toLowerCase()),
				new Color(39, 39, 39).getRGB());

		// RenderUtil.drawCircle(this.x - 100, (int)this.y-100,(float)this.enable, -1);
		if (this.cheat.isEnabled()) {
			limitation.cut();
			Gui.drawRect(this.x - 4, this.y - 6, this.x + 84, y + 9, staticColor);
		}
		if (this.cheat.isEnabled()) {
			if (enable < 180) {
				enable += 10;
			}
			limitation.cut();
			FontLoaders.TahomaBold14.drawStringWithShadow(this.cheat.getName().toLowerCase(),
					x + 81 - FontLoaders.TahomaBold14.getStringWidth(this.cheat.getName().toLowerCase()),
					this.y, new Color(220, 220, 220).getRGB());
		} else {
			if (enable > 0) {
				enable -= 10;
			}
			limitation.cut();
			FontLoaders.TahomaBold14.drawStringWithShadow(this.cheat.getName().toLowerCase(),
					x + 81 - FontLoaders.TahomaBold14.getStringWidth(this.cheat.getName().toLowerCase()),
					this.y, new Color(220, 220, 220).getRGB());
		}
		if (this.cheat.getValues().size() > 0) {
			GlStateManager.pushMatrix();
			GlStateManager.translate((this.x + 78), (this.y + 2), 0);
			GlStateManager.rotate(arrow, 0.0f, 0.0f, 1.0f);
			if (this.expand && arrow < 180) {
				arrow += 10;
			} else if (!this.expand && arrow > 0) {
				arrow -= 10;
			}
			GlStateManager.translate(-(this.x + 78), -(this.y + 2), 0);
			// Client.instance.getFontManager().logo18.drawString("h", this.x + 74, this.y,
			// new Color(255,255,255).getRGB());
			// RenderUtil.drawImage(new
			// ResourceLocation("ZenithAssets/arrow.png"),this.x+75,this.y ,6,6);
			GlStateManager.popMatrix();
		}
		GL11.glDisable(3089);
		GL11.glPopMatrix();
		if (this.expand) {
			buttons.forEach(component -> component.render(mouseX, mouseY, limitation));
		}
	}

	public void key(char typedChar, int keyCode) {
		this.buttons.forEach(b -> b.key(typedChar, keyCode));
	}

	private boolean isHovering(int n, int n2) {
		boolean b;
		b = n >= this.x && n <= this.x - 7 && n2 >= this.y
				&& n2 <= this.y + FontLoaders.clickgui16.getStringHeight(this.cheat.getName());
		return b;
	}

	public void click(int mouseX, int mouseY, int button) {
		if (mouseX > this.x - 7 && mouseX < this.x + 85 && mouseY > this.y - 6
				&& mouseY < this.y + FontLoaders.clickgui16.getStringHeight(this.cheat.getName())) {
			if (button == 0) {
				this.cheat.setEnabled(!this.cheat.isEnabled());
			}
			if (button == 1 && !this.buttons.isEmpty()) {
				boolean bl = this.expand = !this.expand;
			}
			if (button == 2) {
				this.cheat.setRemoved(!this.cheat.wasRemoved());
			}
		}
		if (this.expand) {
			this.buttons.forEach(b -> b.click(mouseX, mouseY, button));
		}
	}

	public void setParent(Window parent) {
		this.parent = parent;
		int i = 0;
		while (i < this.parent.buttons.size()) {
			if (this.parent.buttons.get(i) == this) {
				this.index = i;
				this.remander = this.parent.buttons.size() - i;
				break;
			}
			++i;
		}
	}
}
