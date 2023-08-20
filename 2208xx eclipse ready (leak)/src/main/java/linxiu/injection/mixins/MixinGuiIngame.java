/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.misc.EventTitle;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.rendering.EventRenderGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(Side.CLIENT)
@Mixin(GuiIngame.class)
public class MixinGuiIngame extends Gui {
	
	public Minecraft mc;
	
	@Shadow
	public String displayedTitle = "";
	
	@Shadow
	public String displayedSubTitle = "";
	
	@Shadow
	public int titlesTimer;

	@Shadow
	public int titleFadeIn;
	
	@Shadow
	public int titleDisplayTime;
	
	@Shadow
	public int titleFadeOut;


	@Inject(method = "showCrosshair", at = @At("HEAD"), cancellable = true)
	private void injectCrosshair(CallbackInfoReturnable<Boolean> cir) {
		if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 1
				|| Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
			cir.setReturnValue(false);
		}
	}

	/**
	 * @author empty
	 * @reason can't inject
	 */
	@Overwrite
	public void displayTitle(String title, String subTitle, int timeFadeIn, int displayTime, int timeFadeOut) {
		if (title == null && subTitle == null && timeFadeIn < 0 && displayTime < 0 && timeFadeOut < 0) {
			this.displayedTitle = "";
			this.displayedSubTitle = "";
			this.titlesTimer = 0;
		} else if (title != null) {
			EventBus.getInstance().call(new EventTitle(title));
			this.displayedTitle = title;
			this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
		} else if (subTitle != null) {
			this.displayedSubTitle = subTitle;
		} else {
			if (timeFadeIn >= 0) {
				this.titleFadeIn = timeFadeIn;
			}

			if (displayTime >= 0) {
				this.titleDisplayTime = displayTime;
			}

			if (timeFadeOut >= 0) {
				this.titleFadeOut = timeFadeOut;
			}

			if (this.titlesTimer > 0) {
				this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
			}
		}
	}
	
	@Inject(method = "renderGameOverlay", at = @At("RETURN"), cancellable = true)
	private void renderGameOverlay(float partialTicks, CallbackInfo ci) {
		ScaledResolution scaledresolution = new ScaledResolution(this.mc);
		EventBus.getInstance().call(new EventRenderGui(scaledresolution));
		EventBus.getInstance().call(new EventRender2D(scaledresolution, partialTicks));
		GlStateManager.color(1, 1, 1);
	}
	
	
	@Inject(method = "renderTooltip", at = @At("HEAD"), cancellable = true)
	private void renderTooltip(ScaledResolution sr, float partialTicks, CallbackInfo ci) {
		EventBus.getInstance().call(new EventRender2D(sr, partialTicks));
		GlStateManager.color(1, 1, 1);
	}
}
