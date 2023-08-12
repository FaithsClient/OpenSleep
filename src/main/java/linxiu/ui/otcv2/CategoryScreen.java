package linxiu.ui.otcv2;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import linxiu.Client;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.evaly.ClickUtils.Animation;
import linxiu.ui.evaly.ClickUtils.Direction;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.evaly.ClickUtils.RoundedUtil;
import linxiu.ui.evaly.ClickUtils.SmoothStepAnimation;
import linxiu.ui.font.FontLoaders;
import linxiu.ui.otcv2.Utils.Position;
import linxiu.utils.math.MathUtil;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CategoryScreen {

	private float maxScroll = Float.MAX_VALUE, minScroll = 0, rawScroll;

	private float scroll;

	public Position pos;

	private final ModuleType category;
	private float x;

	private float categoryX;
	private float categoryY;

	// 选择大类
	private boolean selected;

	private final List<ModuleRender> moduleList = new CopyOnWriteArrayList<>();

	private Animation scrollAnimation = new SmoothStepAnimation(0, 0, Direction.BACKWARDS);

	public CategoryScreen(ModuleType category, float x) {
		this.category = category;
		this.x = x;

		this.pos = new Position(0, 0, 0, 0);

		int count = 0;

		// new ly ry
		int leftAdd = 0;
		int rightAdd = 0;

		for (Module holder : ModuleManager.getModules()) {
			Module module = holder;
			if (module.getType().equals(this.category)) {

				// 奇偶判断
				float posWidth = 0;

				// 判断左右分别添加
				float posX = pos.x + ((count % 2 == 0) ? 0 : 145);
				float posY = pos.y + ((count % 2 == 0) ? leftAdd : rightAdd);

				Position pos = new Position(posX, posY, posWidth, 30);
				// 只需要x y height
				ModuleRender otlM = new ModuleRender(module, pos.x, pos.y, pos.width, pos.height);
				pos.height = otlM.height;
				if (count % 2 == 0) {
					leftAdd += pos.height + 20;
				} else {
					rightAdd += pos.height + 20;
				}
				moduleList.add(otlM);
				count++;
			}

		}
	}

	public String newcatename(ModuleType moduleCategory) {
		if (moduleCategory.name().equals("Combat")) {
			return "combat";
		} else if (moduleCategory.name().equals("Player")) {
			return "player";
		} else if (moduleCategory.name().equals("Movement")) {
			return "move";
		} else if (moduleCategory.name().equals("Render")) {
			return "visuals";
		} else if (moduleCategory.name().equals("Legit")) {
			return "legit";
		}
		return "";
	}

	public void drawScreen(int mouseX, int mouseY) {
		categoryX = Client.INSTANCE.otc.getMainx();
		categoryY = Client.INSTANCE.otc.getMainy();

		if (selected) {

			double scrolll = getScroll();
			for (ModuleRender module : moduleList) {
				module.scrollY = (int) MathUtil.roundToHalf(scrolll);
			}

			onScroll(30);
			// 判断
			maxScroll = Math.max(0, moduleList.get(moduleList.size() - 1).getY()
					+ moduleList.get(moduleList.size() - 1).height * 2 + 15);
			//

		}

		FontLoaders.TahomaBold13.drawString(newcatename(category), x + categoryX + 77, categoryY - 17, 0xFFFFFFFF);
		if (selected) {
			RoundedUtil.drawRound(x + categoryX + 76, categoryY - 17 - 3,
					FontLoaders.TahomaBold12.getStringWidth(newcatename(category)) + 3, 5 + 4, 1,
					new Color(255, 255, 255, 44));
			// RenderUtils.drawRect();
			// 隐藏不可见的
			GL11.glPushMatrix();
			RenderUtil.scissor(0, Client.INSTANCE.otc.getMainy(), 1920, 300);
			// GL11.glScissor(0, (int) (LiquidBounce.otc.sHeight() -
			// LiquidBounce.otc.getMainy() * 2 + 375 - LiquidBounce.otc.getHeight() * 2) +
			// 40, 1920, LiquidBounce.otc.getHeight() * 2 - 42 -375 );
			GL11.glEnable(GL11.GL_SCISSOR_TEST);
			moduleList.stream() ////
					.sorted((o1, o2) -> Boolean.compare(o1.isSelected(), o2.isSelected())) //
					.forEach(module -> module.drawScreen(mouseX, mouseY));

			GL11.glDisable(GL11.GL_SCISSOR_TEST);
			GL11.glPopMatrix();
		}

		if (isHovered(mouseX, mouseY)) {
			RoundedUtil.drawRound(x + categoryX + 76, categoryY - 17 - 3,
					FontLoaders.TahomaBold13.getStringWidth(newcatename(category)) + 2, 5 + 4, 1,
					new Color(255, 255, 255, 44));
		}

	}

	public void onScroll(int ms) {
		scroll = (float) (rawScroll - scrollAnimation.getOutput());
		
		
		float maxaScroll = 0;
		if (category.name().equals("Combat")) {
			maxaScroll = 600;
		} else if (category.name().equals("Player")) {
			maxaScroll = 70;
		} else if (category.name().equals("Movement")) {
			maxaScroll = -100;
		} else if (category.name().equals("Render")) {
			maxaScroll = 680;
		} else if (category.name().equals("Legit")) {
			maxaScroll = 50;
		}
		rawScroll += Mouse.getDWheel() / 4f;
		rawScroll = Math.max(Math.min(minScroll, rawScroll), -maxScroll - maxaScroll);
		scrollAnimation = new SmoothStepAnimation(ms, rawScroll - scroll, Direction.BACKWARDS);
	}

	public float getScroll() {
		scroll = (float) (rawScroll - scrollAnimation.getOutput());
		return scroll;
	}

	public boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x + categoryX + 76
				&& mouseX <= x + categoryX + 76 + FontLoaders.TahomaBold13.getStringWidth(newcatename(category)) + 2
				&& mouseY >= categoryY - 17 - 2 && mouseY <= categoryY - 17 - 3 + 9;
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {

		moduleList.forEach(s -> s.mouseClicked(mouseX, mouseY, mouseButton));

	}

	public void mouseReleased(int mouseX, int mouseY, int state) {
		moduleList.forEach(e -> e.mouseReleased(mouseX, mouseY, state));
	}

	public void keyTyped(char typedChar, int keyCode) {
		moduleList.forEach(e -> e.keyTyped(typedChar, keyCode));
	}

	public void setSelected(boolean s) {
		this.selected = s;
	}

	public boolean isSelected() {
		return this.selected;
	}
}
