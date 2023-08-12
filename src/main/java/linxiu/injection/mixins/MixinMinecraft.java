
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

import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.events.misc.EventKey;
import linxiu.api.events.misc.EventLoop;
import linxiu.api.events.world.EventTick;
import linxiu.api.events.world.WorldReloadEvent;
import linxiu.injection.interfaces.IMixinMinecraft;
import linxiu.management.ModuleManager;
import linxiu.module.MixinHelper;
import linxiu.module.modules.ghost.NoJumpDelay;
import linxiu.module.modules.player.IRC;
import linxiu.module.modules.uhc.FastPlace;
import linxiu.module.modules.uhc.Xray;
import linxiu.utils.RenderUtil;
import linxiu.utils.render.IconUtils;
import linxiu.utils.render.OSUtils;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.crash.CrashReport;
import net.minecraft.init.Bootstrap;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mixin(Minecraft.class)
@SideOnly(Side.CLIENT)
public abstract class MixinMinecraft implements IMixinMinecraft {
	@Shadow
	public GuiScreen currentScreen;

	@Shadow
	private static final Logger logger = LogManager.getLogger();

	@Shadow
	public boolean skipRenderWorld;

	@Shadow
	public PlayerControllerMP playerController;

	@Shadow
	private boolean fullscreen;

	@Shadow
	private MovingObjectPosition objectMouseOver;

	@Shadow
	private String serverName;

	@Shadow
	private int serverPort;

	@Shadow
	public int rightClickDelayTimer;

	@Shadow
	@Mutable
	@Final
	private Session session;

	@Shadow
	private int leftClickCounter;

	public void setClickCounter(int a) {
		this.leftClickCounter = a;
	}

	@Shadow
	protected abstract void rightClickMouse();
	
	@Override
	public void runRightMouse() {
		this.rightClickMouse();
	}

	@Inject(method = "startGame", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;", shift = At.Shift.AFTER))
	private void startGame(CallbackInfo ci) {
		MixinHelper.Mixin1();
	}

	@Inject(method = "runTick", at = @At("RETURN"))
	private void runTick2(CallbackInfo ci) {
		MixinHelper.Mixin2();
	}
	
	@Inject(method = "runTick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;joinPlayerCounter:I", shift = At.Shift.BEFORE))
	private void runTick3(CallbackInfo ci) {
		MixinHelper.Mixin3();
	}

	@Inject(method = "runGameLoop", at = @At("HEAD"))
	private void onLoop(CallbackInfo ci) {
		MixinHelper.Mixin4();
	}

	@Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift = At.Shift.AFTER))
	private void onKey(CallbackInfo ci) {
		MixinHelper.Mixin231();
	}

	@Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
	public void shutdownMinecraftApplet(CallbackInfo ci) {
		MixinHelper.Mixin6();
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void clickMouse() {
		if (this.leftClickCounter <= 0) {
			Minecraft.getMinecraft().thePlayer.swingItem();
			if (this.objectMouseOver == null) {
				logger.error("Null returned as 'hitResult', this shouldn't happen!");
				if (this.playerController.isNotCreative()) {
					this.leftClickCounter = 10;
				}
			} else {
				switch (this.objectMouseOver.typeOfHit) {
				case ENTITY:
					this.playerController.attackEntity(Minecraft.getMinecraft().thePlayer,
							this.objectMouseOver.entityHit);
					break;
				case BLOCK:
					BlockPos blockpos = this.objectMouseOver.getBlockPos();

					if (Minecraft.getMinecraft().theWorld.getBlockState(blockpos).getBlock()
							.getMaterial() != Material.air) {
						this.playerController.clickBlock(blockpos, this.objectMouseOver.sideHit);
						break;
					}

				case MISS:
				default:
					if (this.playerController.isNotCreative()) {
						this.leftClickCounter = ModuleManager.getModuleByClass(NoJumpDelay.class).isEnabled() ? 0 : 10;
					}
				}
			}
		}
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	private void sendClickBlockToController(boolean leftClick) {
		if (!leftClick) {
			this.leftClickCounter = 0;
		}

		if (this.leftClickCounter <= 0) {
			if (leftClick && Minecraft.getMinecraft().objectMouseOver != null && Minecraft
					.getMinecraft().objectMouseOver.typeOfHit == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK) {
				BlockPos blockpos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();

				if (Minecraft.getMinecraft().theWorld.getBlockState(blockpos).getBlock().getMaterial() != Material.air
						&& Minecraft.getMinecraft().playerController.onPlayerDamageBlock(blockpos,
								Minecraft.getMinecraft().objectMouseOver.sideHit)) {
					Minecraft.getMinecraft().effectRenderer.addBlockHitEffects(blockpos,
							Minecraft.getMinecraft().objectMouseOver.sideHit);
					Minecraft.getMinecraft().thePlayer.swingItem();
				}
			} else {
				Minecraft.getMinecraft().playerController.resetBlockRemoving();
			}
		}
	}

	@Inject(method = "loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V", at = @At("HEAD"))
	private void loadWorld(WorldClient p_loadWorld_1_, String p_loadWorld_2_, final CallbackInfo callbackInfo) {
		MixinHelper.Mixin7(p_loadWorld_1_);
	}

	@Inject(method = "createDisplay", at = @At("RETURN"))
	private void createDisplay(CallbackInfo callbackInfo) {
		Display.setTitle("Sleep #120722");
	}

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	private long lastFrame = getTime();

	@Inject(method = "runGameLoop", at = @At("HEAD"))
	private void runGameLoop(final CallbackInfo callbackInfo) {
		final long currentTime = getTime();
		final int deltaTime = (int) (currentTime - lastFrame);
		lastFrame = currentTime;
		RenderUtil.deltaTime = deltaTime;
	}

	/**
	 * @author
	 */
	@Overwrite
	public void displayCrashReport(CrashReport crashReportIn) {
		File file1 = new File(Minecraft.getMinecraft().getMinecraft().mcDataDir, "crash-reports");
		File file2 = new File(file1,
				"crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt");
		Bootstrap.printToSYSOUT(crashReportIn.getCompleteReport());

		if (Xray.isEnabled) {
			Client.getModuleManager().getModuleByClass(Xray.class).toggle();
		}

		Client.getINSTANCE().shutDown();

		int retVal;
		if (crashReportIn.getFile() != null) {
			Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + crashReportIn.getFile());
			retVal = -1;
		} else if (crashReportIn.saveToFile(file2)) {
			Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
			retVal = -1;
		} else {
			Bootstrap.printToSYSOUT("#@?@# Game crashed! Crash report could not be saved. #@?@#");
			retVal = -2;
		}
		net.minecraftforge.fml.common.FMLCommonHandler.instance().handleExit(retVal);
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public int getRightClickDelayTimer() {
		return rightClickDelayTimer;
	}

	@Override
	public void setRightClickDelayTimer(int i) {
		rightClickDelayTimer = i;
	}
}
