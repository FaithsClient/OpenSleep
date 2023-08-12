package linxiu.module;

import org.lwjgl.input.Keyboard;
import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.events.misc.EventKey;
import linxiu.api.events.misc.EventLoop;
import linxiu.api.events.world.EventTick;
import linxiu.api.events.world.WorldReloadEvent;
import linxiu.management.ModuleManager;
import linxiu.module.modules.player.IRC;
import linxiu.module.modules.uhc.Xray;
import linxiu.ui.menu.GuiLogin;
import linxiu.ui.menu.GuiRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import oh.yalan.NativeClass;

@NativeClass
public class MixinHelper {
	boolean NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL;

	public static void Mixin4() {
		EventBus.getInstance().call(new EventLoop());
	}

	public static void Mixin6() {
		if (Xray.isEnabled) {
			ModuleManager.getModuleByClass(Xray.class).toggle();
		}
		Client.getINSTANCE().shutDown();
	}

	public static void Mixin7(WorldClient p_loadWorld_1_) {
		WorldReloadEvent reloadEvent = new WorldReloadEvent(p_loadWorld_1_);
		EventBus.getInstance().call(reloadEvent);
	}

	public static void Mixin231() {
		if (Keyboard.getEventKeyState() && Minecraft.getMinecraft().currentScreen == null)
			EventBus.getInstance().call(new EventKey(
					Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey()));
	}

	public static void Mixin1() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiLogin());
		Client.getINSTANCE().initiate();
	}

	public static void Mixin3() {
		EventBus.getInstance().call(new EventTick());
	}

	public static void Mixin2() {
		if (Client.INSTANCE != null && GuiLogin.isLogin()) {
			if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu
					|| Minecraft.getMinecraft().currentScreen instanceof GuiLogin) {
				Minecraft.getMinecraft().displayGuiScreen(new GuiMainMenu());
			}
		} else if (!(Minecraft.getMinecraft().currentScreen instanceof GuiLogin)
				&& !(Minecraft.getMinecraft().currentScreen instanceof GuiRegister)) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiLogin());
		}
	}

	public static void doKeyMixin() {
		if (Keyboard.getEventKeyState() && Minecraft.getMinecraft().currentScreen == null)
			EventBus.getInstance().call(new EventKey(
					Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey()));
	}
}
