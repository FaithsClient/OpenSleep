package linxiu.module.modules.player;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import oh.yalan.NativeClass;
import scala.reflect.internal.Trees.This;

import org.lwjgl.Sys;
import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventChat;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.AntiBot;
import linxiu.ui.IRCThread;
import linxiu.ui.IRCUser;
import linxiu.ui.menu.EncodeUtil;
import linxiu.ui.menu.GuiLogin;
import linxiu.utils.PlayerUtils;
import linxiu.utils.timer.TimeHelper;

import javax.swing.*;

@NativeClass
public class IRC extends Module {
	public static boolean check;
	public static Socket socket;
	public static PrintWriter pw;
	static InputStream in;
	public static boolean logincheck;
	public static boolean quticheck;

	public IRC() {
		super("IRC", new String[] { "IRC" }, ModuleType.Player);
	}

	@Override
	public void onDisable() {
		try {
			if (new IRCThread() != null) {
				new IRCThread().stop();
				PlayerUtils.irc("thread stop");
			}
			
			if (pw != null) {
				pw.println("CLOSE");
				pw.flush();
				in.close();
				pw.close();
				socket.close();
				check = false;
				PlayerUtils.irc("释放资源");
			}

			if (socket != null) {
				socket.close();// 关闭服务器端连接
				PlayerUtils.irc("socket quit");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		PlayerUtils.irc("关闭IRC");
	}

	@Override
	public void onEnable() {
		new IRCThread().start();
	}

	public static String playerNameString;
	public static String playerNameString2;

	@EventHandler
	private void onChat(EventChat e) {
		if (e.getMessage().contains("Name:")) {
			playerNameString = e.getMessage().substring(7, e.getMessage().length());
			logincheck = true;
		}
		if (e.getMessage().contains("KName:")) {
			playerNameString2 = e.getMessage().substring(6, e.getMessage().length());
			quticheck = true;
		}
		if (e.getMessage().contains("退出了IRC")) {
			IRCUser.remove(e.getMessage().substring(0, e.getMessage().length() - 6), playerNameString2);
		}

		if (e.getMessage().contains("进入IRC")) {
			IRCUser.update(e.getMessage().substring(3, e.getMessage().length() - 5), playerNameString);

		}
	}

	public static void handleInput() {
		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				String ircmessage;
				while ((ircmessage = br.readLine()) != null) {
					if (ircmessage.equals("CLOSE")) {
						PlayerUtils.irc("服务器关闭");
						try {
							if (new IRCThread() != null) {
								new IRCThread().stop();
								PlayerUtils.irc("thread stop");
							}
							
							if (pw != null) {
								pw.println("CLOSE");
								pw.flush();
								in.close();
								pw.close();
								socket.close();
								check = false;
								PlayerUtils.irc("释放资源");
							}

							if (socket != null) {
								socket.close();// 关闭服务器端连接
								PlayerUtils.irc("socket quit");
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						Client.getINSTANCE().getModuleManager().getModuleByClass(IRC.class).setEnabled(false);
						return;
					} else if (ircmessage.equals("你被踢出了IRC")) {
						try {
							if (new IRCThread() != null) {
								new IRCThread().stop();
								PlayerUtils.irc("thread stop");
							}
							
							if (pw != null) {
								pw.println("CLOSE");
								pw.flush();
								in.close();
								pw.close();
								socket.close();
								check = false;
								PlayerUtils.irc("释放资源");
							}

							if (socket != null) {
								socket.close();// 关闭服务器端连接
								PlayerUtils.irc("socket quit");
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.exit(99);
					}

					if (Minecraft.getMinecraft().thePlayer != null) {
						Minecraft.getMinecraft().ingameGUI.getChatGUI()
								.printChatMessage(new ChatComponentText(ircmessage));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void connect() {
		PlayerUtils.irc("尝试连接服务器");
		try {
			socket = new Socket("irc.sleepsense.cc", 1892);
			in = socket.getInputStream();
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println(Client.username + "@" + " " + "@SLeep@" + Minecraft.getMinecraft().thePlayer.getName());
			check = true;
		} catch (IOException e) {
			PlayerUtils.irc("连接失败");
			Client.getINSTANCE().getModuleManager().getModuleByClass(IRC.class).setEnabled(false);
			e.printStackTrace();
		}
		return;
	}

	public static void sendMessage(String msg) {
		pw.println(msg);
	}
}