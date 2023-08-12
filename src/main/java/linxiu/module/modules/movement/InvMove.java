package linxiu.module.modules.movement;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.GuiCloseEvent;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.LivingUpdateEvent;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.MovementUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import org.lwjgl.input.Keyboard;

public class InvMove extends Module {
	boolean nomove;
	public static Option Cancel = new Option("Cancel", "Cancel", Boolean.TRUE);
	public static Option inventory = new Option("inventory", "inventory", Boolean.TRUE);

	public InvMove() {
		super("InvMove", new String[] {}, ModuleType.Movement);
	}

	public static void checkKeys() {
		final KeyBinding[] keys = { Minecraft.getMinecraft().gameSettings.keyBindForward, Minecraft.getMinecraft().gameSettings.keyBindRight,
				Minecraft.getMinecraft().gameSettings.keyBindBack, Minecraft.getMinecraft().gameSettings.keyBindLeft, Minecraft.getMinecraft().gameSettings.keyBindJump };
		for (final KeyBinding key : keys) {
			KeyBinding.setKeyBindState(key.getKeyCode(), Keyboard.isKeyDown(key.getKeyCode()));
		}
	}

	@EventHandler
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (mc.currentScreen instanceof GuiChat
				|| (!(mc.currentScreen instanceof GuiInventory) && inventory.getValue()))
			return;
		if (mc.currentScreen != null) {
			checkKeys();
		}
	}

	@EventHandler
	public void onGuiClose(GuiCloseEvent event) {
		if (mc.currentScreen instanceof GuiChat
				|| (!(mc.currentScreen instanceof GuiInventory) && inventory.getValue()))
			return;

		checkKeys();
	}

	@EventHandler
	public void move(EventMove e) {
		if (Cancel.getValue().booleanValue()) {
			if (nomove) {
				MovementUtils.setSpeed(e, 0.0);
			}
		}
	}

	@EventHandler
	public void onmove(EventPacketSend ep) {
		if (Cancel.getValue().booleanValue()) {
			if (mc.currentScreen instanceof GuiInventory || mc.currentScreen instanceof GuiChat
					|| mc.currentScreen instanceof GuiChest) {
				if (EventPacketSend.getPacket() instanceof C0EPacketClickWindow) {
					nomove = true;
				}
			} else {
				nomove = false;
			}
		}
	}

}
