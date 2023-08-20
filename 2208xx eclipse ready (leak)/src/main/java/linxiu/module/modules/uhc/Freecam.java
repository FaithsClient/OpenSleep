/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.uhc;

import java.awt.Color;

import org.lwjgl.input.Keyboard;
import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.mojang.realmsclient.gui.ChatFormatting;
import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventCollideWithBlock;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.MovementUtils;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class Freecam extends Module {
	private EntityOtherPlayerMP copy;
	private double x;
	private double y;
	private double z;

	public Freecam() {
		super("Freecam", new String[] { "Freecam" }, ModuleType.Player);
		this.setColor(new Color(221, 214, 51).getRGB());
	}

	@Override
	public void onEnable() {
		this.copy = new EntityOtherPlayerMP(this.mc.theWorld, this.mc.thePlayer.getGameProfile());
		this.copy.clonePlayer(this.mc.thePlayer, true);
		this.copy.setLocationAndAngles(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ,
				this.mc.thePlayer.rotationYaw, this.mc.thePlayer.rotationPitch);
		this.copy.rotationYawHead = this.mc.thePlayer.rotationYawHead;
		this.copy.setEntityId(-1337);
		this.copy.setSneaking(this.mc.thePlayer.isSneaking());
		this.mc.theWorld.addEntityToWorld(this.copy.getEntityId(), this.copy);
		this.x = this.mc.thePlayer.posX;
		this.y = this.mc.thePlayer.posY;
		this.z = this.mc.thePlayer.posZ;
	}

	@EventHandler
	private void onPreMotion(EventPreUpdate e) {
		this.mc.thePlayer.capabilities.isFlying = true;
		this.mc.thePlayer.noClip = true;
		this.mc.thePlayer.capabilities.setFlySpeed(0.1f);
		e.setCancelled(true);
	}

	@EventHandler
	private void onPacketSend(EventPacketSend e) {
		if (e.getPacket() instanceof C03PacketPlayer) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	private void onBB(EventCollideWithBlock e) {
		e.setBoundingBox(null);
	}

	@Override
	public void onDisable() {
		MovementUtils.setMotion(0.0);
		this.mc.thePlayer.setLocationAndAngles(this.copy.posX, this.copy.posY, this.copy.posZ, this.copy.rotationYaw,
				this.copy.rotationPitch);
		this.mc.thePlayer.rotationYawHead = this.copy.rotationYawHead;
		this.mc.theWorld.removeEntityFromWorld(this.copy.getEntityId());
		this.mc.thePlayer.setSneaking(this.copy.isSneaking());
		this.copy = null;
		this.mc.renderGlobal.loadRenderers();
		this.mc.thePlayer.setPosition(this.x, this.y, this.z);
		this.mc.getNetHandler().addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX,
				this.mc.thePlayer.posY + 0.01, this.mc.thePlayer.posZ, this.mc.thePlayer.onGround));
		this.mc.thePlayer.capabilities.isFlying = false;
		this.mc.thePlayer.noClip = false;
		this.mc.theWorld.removeEntityFromWorld(-1);
	}
}