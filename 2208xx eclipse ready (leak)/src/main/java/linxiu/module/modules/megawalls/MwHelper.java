/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.megawalls;

import io.netty.buffer.Unpooled;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventChat;
import linxiu.api.events.world.ChatEvent;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPostUpdate;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.MultiOptionValue;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.HttpUtils;
import linxiu.utils.PacketUtils;
import linxiu.utils.PlayerUtil;
import linxiu.utils.SpamCount;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.ItemBow;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.BlockPos;
import org.apache.commons.lang3.RandomUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.List;
import java.util.Map;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class MwHelper extends Module {
	public ArrayList<SpamCount> messages = new ArrayList();

	public static MultiOptionValue elementValue = new MultiOptionValue("Element", new Option("McLook", true),
			new Option("wwJump", true), new Option("wwJump2", true), new Option("AutoRespawn", true),
			new Option("AutoBack", true), new Option("WallSprint", true));

	public static Option antispam = new Option("AntiSpam", true);
	public static Option AutoHead = new Option("AutoHead", true);
	private final Numbers<Number> health = new Numbers("Health", 15, 0, 20, 1);
	private final Numbers<Number> minDelay = new Numbers("Min Delay", 300, 0, 1000, 25);
	private final Numbers<Number> maxDelay = new Numbers("Max Delay", 500, 0, 1000, 25);
	private boolean released;

	private final TimerUtil timer = new TimerUtil();
	private boolean switchBack;
	private long decidedTimer;
	private int head = -37;

	public MwHelper() {
		super("MwAddons", new String[] { "MwAddons" }, ModuleType.Legit);
		this.setColor(new Color(158, 205, 125).getRGB());
	}

	@Override
	public void onDisable() {
		if (AutoHead.getValue()) {
			switchBack = false;
			head = -37;
		}
	}

	@EventHandler
	public void onPreMotion(EventPreUpdate event) {
		if (AutoHead.getValue()) {
			if (switchBack) {
				PacketUtils.sendPacket(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM,
						BlockPos.ORIGIN, EnumFacing.DOWN));
				PacketUtils.sendPacket(new C09PacketHeldItemChange(mc.thePlayer.inventory.currentItem));
				switchBack = false;
				return;
			}

			if (timer.hasTimeElapsed(decidedTimer)) {
				if (mc.thePlayer.ticksExisted > 10 && mc.thePlayer.getHealth() < health.getValue().floatValue()) {
					head = PlayerUtil.findHead() - 36;

					if (head != -37) {
						PacketUtils.sendPacket(new C09PacketHeldItemChange(head));
						PacketUtils.sendPacket(
								new C08PacketPlayerBlockPlacement(mc.thePlayer.inventory.getStackInSlot(head)));
						switchBack = true;
					}

					final int delayFirst = (int) Math
							.floor(Math.min(minDelay.getValue().intValue(), maxDelay.getValue().intValue()));
					final int delaySecond = (int) Math
							.ceil(Math.max(minDelay.getValue().intValue(), maxDelay.getValue().intValue()));

					decidedTimer = RandomUtils.nextInt(delayFirst, delaySecond);
					timer.reset();
				}
			}
		}
	}
	
	@EventHandler
	public void onChatasd(ChatEvent event) {
		if (!antispam.getValue()) {
			return;
		}
		IChatComponent mes = event.getChatComponent();
		boolean existsAlready = false;
		for (SpamCount spam : messages) {
			if (!spam.isSame(mes))
				continue;
			existsAlready = true;
			Long currentTime = System.currentTimeMillis();
			if (currentTime - spam.getTime() < 30000L) {
				spam.increaseCounter();
				mes.appendText(EnumChatFormatting.GOLD + " [" + EnumChatFormatting.GRAY + "x" + EnumChatFormatting.RED
						+ spam.getCounter() + EnumChatFormatting.GOLD + "]");
			} else {
				spam.resetCounter();
			}
			spam.setTime(currentTime);
		}
		if (!existsAlready) {
			messages.add(new SpamCount(mes));
		} else {
			List<ChatLine> list = mc.ingameGUI.getChatGUI().chatLines;
			if (list != null) {
				for (int i = 0; i < list.size(); ++i) {
					String mesStr;
					ChatLine line = list.get(i);
					String counterStr = EnumChatFormatting.GOLD + " [" + EnumChatFormatting.GRAY + "x";
					String lineStr = line.getChatComponent().getUnformattedText();
					int lastIndex = lineStr.lastIndexOf(counterStr);
					if (lastIndex > 0) {
						lineStr = lineStr.substring(0, lastIndex);
					}
					if ((lastIndex = (mesStr = mes.getUnformattedText()).lastIndexOf(counterStr)) > 0) {
						mesStr = mesStr.substring(0, lastIndex);
					}
					if (!lineStr.equals(mesStr))
						continue;
					list.remove(line);
				}
			}
			mc.ingameGUI.getChatGUI().refreshChat();
		}
	}

	@EventHandler
	public void Send(EventPacketSend e) {
		if (e.getPacket() instanceof C17PacketCustomPayload) {
			final C17PacketCustomPayload packet = (C17PacketCustomPayload) e.getPacket();
			PacketBuffer data = packet.getBufferData();
			String channel = packet.getChannelName();
			data = (createPacketBuffer("FML", true));
			channel = ("REGISTER");
			data = (createPacketBuffer("Lunar-Client", false));
			data = (createPacketBuffer("LMC", true));
			data = (createPacketBuffer("PLC18", false));
			data = (createPacketBuffer("CB", true));
			data = (createPacketBuffer("Geyser", false));
		}
	}

	private PacketBuffer createPacketBuffer(final String data, final boolean string) {
		if (string)
			return new PacketBuffer(Unpooled.buffer()).writeString(data);
		else
			return new PacketBuffer(Unpooled.wrappedBuffer(data.getBytes()));
	}

	@Override
	public void onEnable() {
		super.onEnable();
	}

	@EventHandler
	public void onMotionUpdate(EventPostUpdate event) {
		if (elementValue.getSetting("McLook").getValue()) {
			if (Mouse.isButtonDown(2)) {
				mc.gameSettings.thirdPersonView = 1;
				released = false;
			} else {
				if (!released) {
					mc.gameSettings.thirdPersonView = 0;
					released = true;
				}
			}
		}
	}

	@EventHandler
	public void tick(EventPostUpdate e) {
		if (elementValue.getSetting("AutoRespawn").getValue()) {

			if (mc.thePlayer.isDead) {
				this.mc.thePlayer.respawnPlayer();
			}
		}
	}

	@EventHandler
	private void onChat(EventChat e) {
		if (elementValue.getSetting("AutoBack").getValue()) {
			if (e.getMessage().contains("Flying or related.")) {
				if (mc.thePlayer == null) {
					return;
				}
				mc.thePlayer.sendChatMessage("/lobby");
				new Thread(() -> {
					try {
						Thread.sleep(150L);
					} catch (InterruptedException e3) {
						e3.printStackTrace();
					}
					mc.thePlayer.sendChatMessage("/back");
				}).start();
			}
			if (e.getMessage().contains(
					"A kick occurred in your connection, so you were put in the MegaWalls Champions lobby!")) {
				if (mc.thePlayer == null) {
					return;
				}
				mc.thePlayer.sendChatMessage("/back");
			}
			if (e.getMessage()
					.contains("A kick occurred in your connection, so you were put in the UHC Champions lobby!")) {
				if (mc.thePlayer == null) {
					return;
				}
				mc.thePlayer.sendChatMessage("/back");
			}
			if (e.getMessage().contains("You were spawned in Limbo.")) {
				if (mc.thePlayer == null) {
					return;
				}
				mc.thePlayer.sendChatMessage("/lobby");
				new Thread(() -> {
					try {
						Thread.sleep(150L);
					} catch (InterruptedException e3) {
						e3.printStackTrace();
					}
					mc.thePlayer.sendChatMessage("/back");
				}).start();
			}
		}
	}

	public static String translate(String string) {
		String text = getURLEncoderString(string);
		Map<String, String> header = new HashMap();
		header.put("Connection", " keep-alive");
		header.put("Referer", "http://fanyi.youdao.com/translate");
		header.put("Accept-Language", " zh-CN,zh;q=0.8");
		return (org.apache.commons.lang3.StringUtils.substringAfterLast(HttpUtils.get(
				"http://fanyi.youdao.com//translate?i=" + text + "&type=AUTO&doctype=text&xmlVersion=1.1&keyfrom=360se",
				null, header), "result="));
	}

	public static String getURLEncoderString(String str) {
		String result = "";
		try {
			result = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean f() {
		return elementValue.getSetting("McLook").getValue() && Mouse.isButtonDown(Keyboard.KEY_E);
	}
}
