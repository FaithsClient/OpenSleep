package linxiu.injection.mixins;

import linxiu.Client;
import linxiu.module.modules.render.HUD;
import linxiu.module.modules.render.TargetHUD;
import linxiu.module.modules.render.TargetList;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(GuiChat.class)
@SideOnly(Side.CLIENT)
public abstract class MixinGuiChat extends GuiScreen {
	@Shadow
	protected GuiTextField inputField;

	private int x;
	private int y;
	private int dragX;
	private int dragY;
	private int x2;
	private int y2;
	private boolean dragging;

	private int dragX2, dragY2;
	private boolean dragging2;

	@Inject(method = "initGui", at = @At("RETURN"))
	private void init(CallbackInfo callbackInfo) {
		dragging = false;
	}

	@Override
	public void mouseReleased(int mouseX, int mouseY, int state) {
		if (HUD.isHover(mouseX, mouseY)) {
			if (state == 0) {
				dragX = mouseX - HUD.getHudX();
				dragY = mouseY - HUD.getHudY();
				dragging = false;
			}
		}
		if (TargetHUD.isHover(mouseX, mouseY)) {
			if (state == 0) {
				dragX = mouseX - TargetHUD.getHudX();
				dragY = mouseY - TargetHUD.getHudY();
				dragging = false;
				if (Client.INSTANCE.getFileManager() != null)
					Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().configs);
			}
		}
		if (TargetList.isHover(mouseX, mouseY)) {
			if (state == 0) {
				dragX2 = mouseX - TargetList.getListX();
				dragY2 = mouseY - TargetList.getListY();
				dragging2 = false;
				if (Client.INSTANCE.getFileManager() != null)
					Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().configs);
			}
		}
	}

	/**
	 * @reason can't inject
	 * @author
	 */
	@Overwrite
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		IChatComponent ichatcomponent = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
		if (HUD.isHover(mouseX, mouseY)
				|| (ichatcomponent != null && ichatcomponent.getClass().getName().startsWith("net.labymod")
						&& ichatcomponent.getClass().getSimpleName().equals("ModGuiChat"))) {
			if (mouseButton == 0) {
				dragX = mouseX - HUD.getHudX();
				dragY = mouseY - HUD.getHudY();
				dragging = true;
				return;
			}
		}
		if (TargetHUD.isHover(mouseX, mouseY)
				|| (ichatcomponent != null && ichatcomponent.getClass().getName().startsWith("net.labymod")
						&& ichatcomponent.getClass().getSimpleName().equals("ModGuiChat"))) {
			if (mouseButton == 0) {
				dragX = mouseX - TargetHUD.getHudX();
				dragY = mouseY - TargetHUD.getHudY();
				dragging = true;
				return;
			}
		}

		if (TargetList.isHover(mouseX, mouseY)) {
			if (mouseButton == 0) {
				dragX2 = mouseX - TargetList.getListX();
				dragY2 = mouseY - TargetList.getListY();
				dragging2 = true;
				return;
			}
		}

		if (mouseButton == 0) {
			if (this.handleComponentClick(ichatcomponent)) {
				return;
			}
		}
		this.inputField.mouseClicked(mouseX, mouseY, mouseButton);
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Inject(method = "drawScreen", at = @At("HEAD"))
	public void mouse(int mouseX, int mouseY, float partialTicks, CallbackInfo info) {
		if (HUD.isHover(mouseX, mouseY)) {
			if (!Mouse.isButtonDown(0) && dragging) {
				dragging = false;
			}
			if (dragging) {
				HUD.setHudX(mouseX - dragX);
				HUD.setHudY(mouseY - dragY);
			}
		}
		if (TargetList.isHover(mouseX, mouseY)) {
			if (!Mouse.isButtonDown(0) && dragging2) {
				dragging2 = false;
				if (Client.INSTANCE.getFileManager() != null)
					Client.INSTANCE.getFileManager().saveConfig(Client.INSTANCE.getFileManager().configs);
			}

			if (dragging2) {
				TargetList.setListX(mouseX - dragX2);
				TargetList.setListY(mouseY - dragY2);
			}
		}
		if (TargetHUD.isHover(mouseX, mouseY)) {
			if (!Mouse.isButtonDown(0) && dragging) {
				dragging = false;
			}
			if (dragging) {
				TargetHUD.setHudX(mouseX - dragX);
				TargetHUD.setHudY(mouseY - dragY);
			}
		}
	}
}
