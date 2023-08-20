package linxiu;

import linxiu.config.FileManager;
import linxiu.management.CommandManager;
import linxiu.management.ModuleManager;

import linxiu.module.Module;
import linxiu.module.modules.player.IRC;
import linxiu.module.modules.render.HUD;
import linxiu.ui.Yarukon;
import linxiu.ui.evaly.EvalyGui;
import linxiu.ui.login.AltManager;
import linxiu.ui.notification.NotificationManager;
import linxiu.ui.otcv2.OtcClickGUi;
import linxiu.utils.SystemUtils;
import linxiu.utils.VMCheck;
import linxiu.utils.WebUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import oh.yalan.NativeClass;

import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import LemonObfAnnotation.Setup;

@NativeClass
public class Client {
	public static Client INSTANCE = new Client();
	public static boolean isStarting;
	public final static String name = "Sleep";
	private ModuleManager moduleManager;
	private CommandManager commandManager;
	private AltManager altManager;
	private NotificationManager notificationManager;
	public static String username;
	public static String User;
	public static String Pass;
	public EvalyGui evalyGui;
	private FileManager fileManager;
	public OtcClickGUi otc;

	public void startDetection() {
		new Thread(() -> {
			try {
				while (true) {
					if (VMCheck.getInstance().runChecks()) {
					}
					Thread.sleep(5000L);
				}
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}).start();
	}

	@Setup
	public void initiate() {
		try {
			if (WebUtils.get("https://gitee.com/forest-repair/acid/raw/master/HWID").contains(getHWID())) {
				isStarting = true;
				AntiPatcher.check();
				this.commandManager = new CommandManager();
				this.commandManager.init();
				this.moduleManager = new ModuleManager();
				this.moduleManager.init();

				fileManager = new FileManager();
				this.notificationManager = new NotificationManager();
				this.altManager = new AltManager();
				AltManager.init();
				AltManager.setupAlts();
				new Yarukon();
				if (Client.INSTANCE.getFileManager() != null)
					Client.INSTANCE.getFileManager().loadAllConfigs();
				this.evalyGui = new EvalyGui();
				otc = new OtcClickGUi();
				startDetection();
				isStarting = false;
				try {
					SystemUtils.addNotification("Client Injecting", "NMSL XIESHEN", TrayIcon.MessageType.INFO, 10000L);
				} catch (AWTException exception) {
					exception.printStackTrace();
				}
			} else {
				JOptionPane.showInputDialog((Component) null, "这是你的HWID", getHWID());
				System.exit(0);
			}
		} catch (NoSuchAlgorithmException | IOException |

				HeadlessException var6) {
			JOptionPane.showMessageDialog((Component) null, "拜拜");
			System.exit(0);
		}
	}

	public static String getHWID() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuilder s = new StringBuilder();
		String main = System.getenv("PROCESS_IDENTIFIER") + System.getenv("COMPUTERNAME");
		byte[] bytes = main.getBytes("UTF-8");
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] md5 = messageDigest.digest(bytes);
		int i = 0;
		for (byte b : md5) {
			s.append(Integer.toHexString((b & 0xFF) | 0x300), 0, 3);
			if (i != md5.length - 1) {
				s.append("-");
			}
			i++;
		}
		return s.toString();
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public static ModuleManager getModuleManager() {
		return INSTANCE.moduleManager;
	}

	public static Client getINSTANCE() {
		return INSTANCE;
	}

	public static CommandManager getCommandManager() {
		return INSTANCE.commandManager;
	}

	public static AltManager getAltManager() {
		return INSTANCE.altManager;
	}

	public NotificationManager getNotificationManager() {
		return notificationManager;
	}

	public void shutDown() {
		Client.INSTANCE.getFileManager().saveAllConfigs();
		Client.INSTANCE.getModuleManager().getModuleByClass(IRC.class).setEnabled(false);
	}

	public static String getModuleName(Module mod) {
		String module = mod.getName();
		String custom = mod.getCustomName();
		if (custom != null) {
			return custom;
		}
		return module;
	}

	public final Color getClientColor() {
		return new Color(HUD.colorValue.getValue());
	}

	public final Color getAlternateClientColor() {
		return new Color(HUD.color2Value.getValue());
	}
}
