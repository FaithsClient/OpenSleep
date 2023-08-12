package linxiu.ui.evaly;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import oh.yalan.NativeClass;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Mouse;

import linxiu.module.ModuleType;
import linxiu.module.modules.movement.InvMove;
import linxiu.module.modules.render.HUD;
import linxiu.ui.evaly.ClickUtils.RenderUtil;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.render.ColorUtils;

@NativeClass
public class EvalyGui extends GuiScreen {

	private final List<CategoryRender> types = new ArrayList<>();
	public static int mainX = 240, mainY = 90;
	private int x2;
	private int y2;
	private boolean dragging;

	public EvalyGui() {
		int x = 0;
		for (ModuleType category : ModuleType.values()) {
			types.add(new CategoryRender(category, x + 40));
			x += FontLoaders.icon35.getStringWidth(icon(category)) + 40;
		}
	}

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	private String icon(ModuleType type) {
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

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		InvMove.checkKeys();
		if (getSelectedTab() == null) {
			if (!types.isEmpty()) {
				types.get(0).setSelected(true);
			}
		}

		// 移动面板
		if (dragging) {
			this.mainX = x2 + mouseX;
			this.mainY = y2 + mouseY;
		}
		
		RenderUtil.drawRect(mainX + 0.3, mainY + 0.3,  mainX + 400 - 0.3, mainY + 300 - 0.3, Color.BLACK.getRGB());
		RenderUtil.drawRect(mainX + 1, mainY + 1, mainX + 400 - 1, mainY + 300 - 1, new Color(55, 55, 55).getRGB());
		RenderUtil.drawRect(mainX + 1.5f, mainY + 1.5, mainX + 400 - 1.5f, mainY + 300 - 1.5, new Color(34,32,35).getRGB());
		RenderUtil.drawRect(mainX + 2.5, mainY + 2, mainX + 400 - 2.5, mainY + 300 - 2.5, new Color(50,50,50).getRGB());
		RenderUtil.drawRect(mainX + 3, mainY + 3, mainX + 400 - 3, mainY + 300 - 3, new Color(12,12,12).getRGB());
		
		RenderUtil.drawRect(mainX + 48, mainY + 3, mainX + 400 - 3, mainY + 300 - 3, new Color(0, 0, 0).getRGB());
		RenderUtil.drawRect(mainX + 49.5, mainY + 3, mainX + 400 - 3, mainY + 300 - 3, new Color(50, 50, 50).getRGB());
		RenderUtil.drawRect(mainX + 50, mainY + 3, mainX + 400 - 3, mainY + 300 - 3, new Color(16,16,16).getRGB());
		linxiu.utils.render.RenderUtil.drawGradientSideways(mainX + 3.5f, mainY + 2.5f, mainX + 400 - 2.5f, mainY + 7 - 3,
				ColorUtils.getFadeRainbow(new Color(HUD.colorValue.getValue()), (int) (mainX * 1),
						5).getRGB(), ColorUtils.getFadeRainbow(new Color(HUD.color2Value.getValue()), (int) (mainX * 1),
								5).getRGB());
		
		//RenderUtil.drawRect(mainX + 3.5f, mainY + 3, mainX + 400 - 2.5f, mainY + 7 - 3,
		//		ColorUtils.getFadeRainbow(new Color(100,255,255), (int) (mainX * 1),
		//				5).getRGB());
		types.forEach(e -> e.draw(mouseX, mouseY));
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (mouseButton == 0) {
			for (CategoryRender categoryRender : types) {
				if (categoryRender.isHovered(mouseX, mouseY)) {
					for (CategoryRender other : types) {
						other.setSelected(false);
					}
					categoryRender.setSelected(true);
				}
			}
		}
		CategoryRender selectedTab = getSelectedTab();
		if (selectedTab != null)
			selectedTab.mouseClicked(mouseX, mouseY, mouseButton);

		if (RenderUtil.isHovering(mainX, mainY, 400, 18, mouseX, mouseY)) {
			this.x2 = mainX - mouseX;
			this.y2 = mainY - mouseY;
			this.dragging = true;
		}
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		types.forEach(e -> e.mouseReleased(mouseX, mouseY, state));
		if (state == 0) {
			this.dragging = false;
		}

		super.mouseReleased(mouseX, mouseY, state);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		types.forEach(e -> e.keyTyped(typedChar, keyCode));
		super.keyTyped(typedChar, keyCode);
	}

	public CategoryRender getSelectedTab() {
		return types.stream().filter(CategoryRender::isSelected).findAny().orElse(null);
	}

}
