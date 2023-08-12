package linxiu.ui.evaly;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import linxiu.Client;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ClickUtils.Animation;
import linxiu.ui.evaly.ClickUtils.Direction;
import linxiu.ui.evaly.ClickUtils.Position;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.evaly.ClickUtils.SmoothStepAnimation;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.math.MathUtil;
import oh.yalan.NativeClass;

import java.awt.*;
import java.util.ArrayList;

@NativeClass
public class CategoryRender {

	private final ModuleType type;
	public int x, y;
	// 主界面xy
	public int mainX, mainY;
	public int leftAdd, rightAdd;
	public ArrayList<ModuleRender> moduleRect;
	// 选择大类
	private boolean selected;
	// 滚轮
	private float maxScroll = Float.MAX_VALUE;
	private float rawScroll;
	private float scroll;
	private Animation scrollAnimation = new SmoothStepAnimation(0, 0, Direction.BACKWARDS);
	//

	public CategoryRender(ModuleType category, int x) {
		this.x = x;
		this.type = category;

		Position pos1 = new Position(0, 0, 0, 0);

		int count = 0;
		moduleRect = new ArrayList<>();
		for (Module holder : Client.INSTANCE.getModuleManager().getModules()) {
			if (holder.getType().equals(category)) {
				float posWidth = 0;

				float posX = pos1.x + ((count % 2 == 0) ? 0 : 170);
				float posY = pos1.y + ((count % 2 == 0) ? leftAdd : rightAdd);

				Position pos = new Position(posX, posY, posWidth, 20);
				ModuleRender otlM = new ModuleRender(holder, pos.x, pos.y, pos.width);

				pos.height = otlM.height;
				if (count % 2 == 0) {
					leftAdd += pos.height + 10;
				} else {
					rightAdd += pos.height + 10;
				}
				moduleRect.add(otlM);
				count++;
			}
		}

	}

	public void draw(int mx, int my) {
		mainX = Client.INSTANCE.evalyGui.mainX;
		mainY = Client.INSTANCE.evalyGui.mainY;

		if (selected) {
			if (type.name().equals("Combat")) {

				RenderUtil.drawRect(mainX + 3, mainY + 13, mainX + 50 - 1, mainY + 57 - 3, new Color(0, 0, 0).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 14.5, mainX + 50, mainY + 56 - 3.5, new Color(50, 50, 50).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 15, mainX + 50, mainY + 55 - 3,
						new Color(16, 16, 16).getRGB());
			}
		}
		
		if (selected) {
			if (type.name().equals("Render")) {
				RenderUtil.drawRect(mainX + 3, mainY + 69, mainX + 50 - 1, mainY + 115 - 3, new Color(0, 0, 0).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 70.5, mainX + 50, mainY + 114 - 3.5, new Color(50, 50, 50).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 71, mainX + 50, mainY + 113 - 3,
						new Color(16, 16, 16).getRGB());
			}
		}

		if (selected) {
			if (type.name().equals("Movement")) {
				RenderUtil.drawRect(mainX + 3, mainY + 127, mainX + 50 - 1, mainY + 173 - 3, new Color(0, 0, 0).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 128.5, mainX + 50, mainY + 172 - 3.5, new Color(50, 50, 50).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 129, mainX + 50, mainY + 171 - 3,
						new Color(16, 16, 16).getRGB());
			}
		}
		
		if (selected) {
			if (type.name().equals("Player")) {
				RenderUtil.drawRect(mainX + 3, mainY + 183, mainX + 50 - 1, mainY + 230 - 3, new Color(0, 0, 0).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 184.5, mainX + 50, mainY + 229 - 3.5, new Color(50, 50, 50).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 185, mainX + 50, mainY + 228 - 3,
						new Color(16, 16, 16).getRGB());
			}
		}
		
		if (selected) {
			if (type.name().equals("Legit")) {
				RenderUtil.drawRect(mainX + 3, mainY + 243, mainX + 50 - 1, mainY + 289 - 3, new Color(0, 0, 0).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 244.5, mainX + 50, mainY + 288 - 3.5, new Color(50, 50, 50).getRGB());
				RenderUtil.drawRect(mainX + 3, mainY + 245, mainX + 50, mainY + 287 - 3,
						new Color(16, 16, 16).getRGB());
			}
		}
		
		FontLoaders.icon35.drawString(icon(), mainX + 17, mainY - 13 + x,
				selected ? HUD.colorValue.getValue() : new Color(133, 135, 139).getRGB());

		if (selected) {
			GL11.glPushMatrix();
			RenderUtil.scissor(mainX, mainY + 15, 500, 275);
			GL11.glEnable(GL11.GL_SCISSOR_TEST);
			moduleRect.forEach(e -> e.draw(mx, my));
			GL11.glDisable(GL11.GL_SCISSOR_TEST);
			GL11.glPopMatrix();

			double scroll = getScroll();
			for (ModuleRender module : moduleRect) {
				module.scrollY = (int) MathUtil.roundToHalf(scroll);
			}
			onScroll(30, mx, my);
			// 判断
			maxScroll = Math.max(0, moduleRect.size() == 0 ? 0 : moduleRect.get(moduleRect.size() - 1).getMaxScrollY());
			//
		}
	}

	private String icon() {
		String l = "";
		if (type.name().equals("Combat")) {
			l = "B";
		} else if (type.name().equals("Player")) {
			l = "J";
		} else if (type.name().equals("Movement")) {
			l = "G";
		} else if (type.name().equals("Render")) {
			l = "D";
		} else if (type.name().equals("Legit")) {
			l = "E";
		}
		return l;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean s) {
		this.selected = s;
	}

	// 滚轮
	public void onScroll(int ms, int mx, int my) {
		scroll = (float) (rawScroll - scrollAnimation.getOutput());
		if (RenderUtil.isHovering(mainX, mainY + 35, 350, 300 - 35, mx, my)) {
			rawScroll += Mouse.getDWheel() / 4f;
		}
		float minScroll = -20;
		float maxaScroll = 0;
		if (type.name().equals("Combat")) {
			maxaScroll = 100;
		} else if (type.name().equals("Player")) {
			maxaScroll = -100;
		} else if (type.name().equals("Movement")) {
			maxaScroll = -200;
		} else if (type.name().equals("Render")) {
			maxaScroll = 70;
		} else if (type.name().equals("Legit")) {
			maxaScroll = -100;
		}
		rawScroll = Math.max(Math.min(minScroll, rawScroll), -maxScroll - maxaScroll);
		scrollAnimation = new SmoothStepAnimation(ms, rawScroll - scroll, Direction.BACKWARDS);
	}

	public float getScroll() {
		scroll = (float) (rawScroll - scrollAnimation.getOutput());
		return scroll;
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {

		moduleRect.forEach(s -> s.mouseClicked(mouseX, mouseY, mouseButton));

	}

	public void mouseReleased(int mouseX, int mouseY, int state) {
		moduleRect.forEach(e -> e.mouseReleased(mouseX, mouseY, state));
	}

	public void keyTyped(char typedChar, int keyCode) {
		moduleRect.forEach(e -> e.keyTyped(typedChar, keyCode));
	}

	public boolean isHovered(int mouseX, int mouseY) {
		return RenderUtil.isHovering(mainX + 17, mainY - 13 + x, FontLoaders.icon35.getStringWidth(icon()),
				FontLoaders.icon35.getHeight() + 2, mouseX, mouseY);
	}
}
