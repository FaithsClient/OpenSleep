/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package linxiu.injection.mixins;

import linxiu.module.AutoReconnect;
import linxiu.utils.ServerUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiSlider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.text.DecimalFormat;

@Mixin(GuiDisconnected.class)
public abstract class MixinGuiDisconnected extends GuiScreen {
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0");

	@Shadow
	private int field_175353_i;

	private GuiButton reconnectButton;
	private GuiSlider autoReconnectDelaySlider;
	private GuiButton forgeBypassButton;
	private int reconnectTimer;

	@Inject(method = "initGui", at = @At("RETURN"))
	private void initGui(CallbackInfo callbackInfo) {
		reconnectTimer = 0;
		buttonList.add(reconnectButton = new GuiButton(1, this.width / 2 - 100,
				this.height / 2 + field_175353_i / 2 + this.fontRendererObj.FONT_HEIGHT + 22, 98, 20, "Reconnect"));
		this.drawReconnectDelaySlider();
		updateSliderText();
	}

	@Inject(method = "actionPerformed", at = @At("HEAD"))
	private void actionPerformed(GuiButton button, CallbackInfo callbackInfo) {
        if (button.id == 1) {
            ServerUtils.connectToLastServer();
        }
	}

	@Override
	public void updateScreen() {
		if (AutoReconnect.isEnabled()) {
			reconnectTimer++;
			if (reconnectTimer > AutoReconnect.getDelay() / 50)
			    ServerUtils.connectToLastServer();
		}
	}

	@Inject(method = "drawScreen", at = @At("RETURN"))
	private void drawScreen(CallbackInfo callbackInfo) {
		if (AutoReconnect.isEnabled()) {
			this.updateReconnectButton();
		}
	}

	private void drawReconnectDelaySlider() {
		buttonList.add(autoReconnectDelaySlider = new GuiSlider(2, this.width / 2 + 2,
				this.height / 2 + field_175353_i / 2 + this.fontRendererObj.FONT_HEIGHT + 22, 98, 20, "AutoReconnect: ",
				"ms", AutoReconnect.MIN, AutoReconnect.MAX, AutoReconnect.getDelay(), false, true, guiSlider -> {
					AutoReconnect.setDelay(guiSlider.getValueInt());

					this.reconnectTimer = 0;
					this.updateReconnectButton();
					this.updateSliderText();
				}));
	}

	private void updateSliderText() {
		if (this.autoReconnectDelaySlider == null)
			return;

		if (!AutoReconnect.isEnabled()) {
			this.autoReconnectDelaySlider.displayString = "AutoReconnect: Off";
		} else {
			this.autoReconnectDelaySlider.displayString = "AutoReconnect: "
					+ DECIMAL_FORMAT.format(AutoReconnect.getDelay() / 1000.0) + "s";
		}
	}

	private void updateReconnectButton() {
		if (reconnectButton != null)
			reconnectButton.displayString = "Reconnect"
					+ (AutoReconnect.isEnabled() ? " (" + (AutoReconnect.getDelay() / 1000 - reconnectTimer / 20) + ")"
							: "");
	}
}