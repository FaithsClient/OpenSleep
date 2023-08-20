/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.movement;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPostUpdate;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.KillAura;
import linxiu.ui.notification.Notification;
import linxiu.utils.MovementUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSnow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

import org.lwjgl.input.Mouse;

public class NoSlow extends Module {
	public final static Numbers<Number> Reduceslow = new Numbers("Reduceslow", 100.0, 0.0, 100.0, 1.0);
	public static Option C09Value = new Option("C09", false);
	public static Option PacketValue = new Option("Packet", true);
	public static Option deathValue = new Option("DeathCheck", false);

	public NoSlow() {
		super("No SlowDown", new String[] { "noslowdown", "noslow" }, ModuleType.Movement);
		this.setColor(new Color(216, 253, 100).getRGB());
	}

	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onPre(EventPreUpdate event) {
		if (C09Value.getValue()) {
			if (mc.thePlayer.isUsingItem() && MovementUtils.isMoving()) {
				mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(mc.thePlayer.inventory.currentItem));
			}
		}
		if (PacketValue.getValue()) {
			if (!MovementUtils.isMoving())
				return;
			if (!mc.thePlayer.isBlocking() && !KillAura.blocking)
				return;
			mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(
					C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-1, -1, -1), EnumFacing.DOWN));
		}
	}

	@EventHandler
	public void onPost(EventPostUpdate event) {
		if (PacketValue.getValue()) {
			if (!MovementUtils.isMoving())
				return;
			if (!mc.thePlayer.isBlocking() && !KillAura.blocking)
				return;
			mc.thePlayer.sendQueue.addToSendQueue(
					new C08PacketPlayerBlockPlacement(new BlockPos(-1, -1, -1), 255, null, 0.0f, 0.0f, 0.0f));
		}
	}

	@EventHandler
	public void onWorldReload(EventPreUpdate event) {
		if (mc.thePlayer.ticksExisted <= 1 && deathValue.getValue()) {
			Client.getINSTANCE().getNotificationManager().getNotifications()
					.add(new Notification("Disabled NoSlow due to death", 3000L));
			this.setEnabled(false);
		}
	}

	private boolean hasSword(EntityPlayer playerIn) {
		return playerIn.inventory.getCurrentItem() != null
				&& playerIn.inventory.getCurrentItem().getItem() instanceof ItemSword;
	}

}
