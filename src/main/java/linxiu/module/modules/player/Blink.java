/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.player;

import com.mojang.authlib.GameProfile;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketSend;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Blink extends Module {
	private static EntityOtherPlayerMP blinkEntity;
	private final List<Packet> packetList = new ArrayList<Packet>();

	public Blink() {
		super("Blink", new String[] { "blonk" }, ModuleType.Player);
	}

	@Override
	public void onEnable() {
		this.setColor(new Color(200, 100, 200).getRGB());
		if (this.mc.thePlayer == null) {
			return;
		}
		blinkEntity = new EntityOtherPlayerMP(this.mc.theWorld, new GameProfile(new UUID(69L, 96L), "Blink"));
		blinkEntity.inventory = this.mc.thePlayer.inventory;
		blinkEntity.inventoryContainer = this.mc.thePlayer.inventoryContainer;
		blinkEntity.setPositionAndRotation(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ,
				this.mc.thePlayer.rotationYaw, this.mc.thePlayer.rotationPitch);
		blinkEntity.rotationYawHead = this.mc.thePlayer.rotationYawHead;
		this.mc.theWorld.addEntityToWorld(blinkEntity.getEntityId(), blinkEntity);
	}

	@EventHandler
	private void onPacketSend(EventPacketSend event) {
		if (EventPacketSend.getPacket() instanceof C0BPacketEntityAction || EventPacketSend.getPacket() instanceof C03PacketPlayer
				|| EventPacketSend.getPacket() instanceof C02PacketUseEntity || EventPacketSend.getPacket() instanceof C0APacketAnimation
				|| EventPacketSend.getPacket() instanceof C08PacketPlayerBlockPlacement) {
			this.packetList.add(EventPacketSend.getPacket());
			event.setCancelled(true);
		}
	}

	public static EntityOtherPlayerMP getBlinkEntity() {
		return blinkEntity;
	}

	@Override
	public void onDisable() {
		for (Packet packet : this.packetList) {
			this.mc.getNetHandler().addToSendQueue(packet);
		}
		this.packetList.clear();
		this.mc.theWorld.removeEntityFromWorld(blinkEntity.getEntityId());
	}
}
