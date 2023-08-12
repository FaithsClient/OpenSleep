package linxiu.module.modules.player;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventPacket;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPostUpdate;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.events.world.PlayerTeleportEvent;
import linxiu.api.events.world.WorldReloadEvent;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IKeyBinding;
import linxiu.injection.interfaces.INetHandlerPlayClient;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.KillAura;
import linxiu.module.modules.combat.TargetStrafe;
import linxiu.module.modules.megawalls.Nuker;
import linxiu.module.modules.movement.GameSpeed;
import linxiu.module.modules.movement.Scaffold;
import linxiu.module.modules.movement.Speed;
import linxiu.ui.MoveUtil;
import linxiu.utils.ChatUtils;
import linxiu.utils.MathUtils;
import linxiu.utils.MoveUtils;
import linxiu.utils.MovementUtils;
import linxiu.utils.PacketUtils;
import linxiu.utils.PlayerUtil;
import linxiu.utils.PlayerUtils;
import linxiu.utils.RotationUtils;
import linxiu.utils.RotationUtils.Rotation;
import linxiu.utils.ServerUtils;
import linxiu.utils.math.MathUtil;
import linxiu.utils.timer.MSTimer;
import linxiu.utils.timer.TimeHelper;
import linxiu.utils.timer.Timer;
import linxiu.utils.timer.TimerUtil;
import linxiu.utils.tojatta.api.utilities.angle.Angle;
import linxiu.utils.tojatta.api.utilities.angle.AngleUtility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.play.client.*;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.server.S00PacketKeepAlive;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import oh.yalan.NativeClass;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomUtils;

@NativeClass
public class Disabler extends Module {
	public Option noC03 = new Option("NoC03", true);
	public Option timerA = new Option("Timer", true);
	public Option timerB = new Option("Reset", false);
	public Option testBlink = new Option("Test", true);
	private LinkedBlockingQueue<Packet<INetHandlerPlayServer>> packets = new LinkedBlockingQueue<>();
	private MSTimer timerCancelDelay = new MSTimer();
	private MSTimer timerCancelTimer = new MSTimer();
	private boolean timerShouldCancel = true;
	private boolean canBlink = true;

	public Disabler() {
		super("Disabler", new String[] { "disabler" }, ModuleType.Player);
	}

	@Override
	public void onEnable() {
		super.onEnable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

	@EventHandler
	private void onPreMotion(EventUpdate event) {
		if (timerB.getValue()) {
			if (timerCancelDelay.hasTimePassed(10000)) {
				timerShouldCancel = true;
				timerCancelTimer.reset();
				timerCancelDelay.reset();
			}
		}
	}

	@EventHandler
	public void onPacket(EventPacketSend event) {
		this.setSuffix("Watchdog");

		Packet<?> packet = event.getPacket();

		canBlink = true;

		if (timerA.getValue()) {
			if (packet instanceof C03PacketPlayer) {
				C03PacketPlayer c03 = (C03PacketPlayer) event.getPacket();
				if (!Client.getModuleManager().getModuleByClass(Nuker.class).isEnabled()) {
					if (!c03.isMoving() && !mc.thePlayer.isUsingItem()) {
						event.cancel();
					}
					if (timerShouldCancel) {
						if (!timerCancelTimer.hasTimePassed(400)) {
							if (!Client.getModuleManager().getModuleByClass(Scaffold.class).isEnabled()) {
								event.cancel();
								packets.add((Packet<INetHandlerPlayServer>) packet);
								canBlink = false;
							}
						} else {
							while (!packets.isEmpty()) {
								PacketUtils.sendPacketNoEvent(packets.poll());
							}
							timerShouldCancel = false;
						}
					}
				}
			}
		}

		if (packet instanceof C03PacketPlayer && !(packet instanceof C03PacketPlayer.C05PacketPlayerLook
				|| packet instanceof C03PacketPlayer.C06PacketPlayerPosLook
				|| packet instanceof C03PacketPlayer.C04PacketPlayerPosition) && noC03.getValue()) {
			event.cancel();
			canBlink = false;
		}

		if (testBlink.getValue()) {
			if (isOnHypixel()) {
				if (packet instanceof C02PacketUseEntity || packet instanceof C03PacketPlayer
						|| packet instanceof C07PacketPlayerDigging || packet instanceof C08PacketPlayerBlockPlacement
						|| packet instanceof C0APacketAnimation || packet instanceof C0BPacketEntityAction) {
					while (!packets.isEmpty()) {
						PacketUtils.sendPacketNoEvent(packets.poll());
					}
				} else {
					if (canBlink) {
						packets.add((Packet<INetHandlerPlayServer>) packet);
						event.cancel();
					}
				}
			}
		}
	}

	public boolean isPlayerInGame() {
		return (Minecraft.getMinecraft().thePlayer != null) && (Minecraft.getMinecraft().theWorld != null);
	}

	public boolean isOnHypixel() {
		if (!isPlayerInGame())
			return false;
		try {
			return !mc.isSingleplayer() && (mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.net")
					|| mc.getCurrentServerData().serverIP.toLowerCase().contains("localhost"));
		} catch (Exception welpBruh) {
			welpBruh.printStackTrace();
			return false;
		}
	}
}
