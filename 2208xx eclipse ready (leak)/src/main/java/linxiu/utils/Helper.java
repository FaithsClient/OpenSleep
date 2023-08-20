/*
 * Decompiled with CFR 0_132.
 */
package linxiu.utils;

import linxiu.Client;
import linxiu.injection.interfaces.INetworkManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Timer;

public class Helper {
	public static final Minecraft mc = Minecraft.getMinecraft();
	public static boolean canSendMotionPacket = true;

	public static void sendMessageOLD(String msg) {
		Object[] arrobject = new Object[2];
		Client.INSTANCE.getClass();
		arrobject[0] = EnumChatFormatting.BLUE + "Sleep" + EnumChatFormatting.GRAY
				+ ": ";
		arrobject[1] = msg;
		Helper.mc.thePlayer.addChatMessage(new ChatComponentText(String.format("%s%s", arrobject)));
	}

	public static void sendMessage(String message) {
		new ChatUtils.ChatMessageBuilder(true, true).appendText(message).setColor(EnumChatFormatting.GRAY).build()
				.displayClientSided();
	}

	public static void sendMessageWithoutPrefix(String message) {
		new ChatUtils.ChatMessageBuilder(false, true).appendText(message).setColor(EnumChatFormatting.GRAY).build()
				.displayClientSided();
	}

	public static boolean onServer(String server) {
        return !mc.isSingleplayer() && Helper.mc.getCurrentServerData().serverIP.toLowerCase().contains(server);
    }

	public static Timer getTimer() {
		return mc.timer;
	}

	public static void sendPacketNoEvent(Packet packet) {
		((INetworkManager) mc.thePlayer.sendQueue.getNetworkManager()).sendPacketNoEvent(packet);
	}
}
