/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package linxiu.injection.mixins;

import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.Position;
import linxiu.api.events.Rotation;
import linxiu.api.events.misc.EventPacket;
import linxiu.api.events.world.PlayerTeleportEvent;
import linxiu.injection.interfaces.INetHandlerPlayClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(NetHandlerPlayClient.class)
public abstract class MixinNetHandlerPlayClient implements INetHandlerPlayClient {
	@Shadow
	private boolean doneLoadingTerrain;

	@Shadow
	private NetworkManager netManager;

	@Shadow
	private Minecraft gameController;

	@Override
	public boolean getDoneLoadingTerrain() {
		return doneLoadingTerrain;
	}

	@Override
	public void addToSendQueueSilent(Packet p_147297_1_) {
		try {
			this.netManager.sendPacket(p_147297_1_);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void handlePlayerPosLook(S08PacketPlayerPosLook packetIn) {
		PacketThreadUtil.checkThreadAndEnqueue(packetIn, (NetHandlerPlayClient) ((Object) this), gameController);
		final EntityPlayer entityplayer = this.gameController.thePlayer;
		double d0 = packetIn.getX();
		double d1 = packetIn.getY();
		double d2 = packetIn.getZ();
		float f = packetIn.getYaw();
		float f1 = packetIn.getPitch();

		final PlayerTeleportEvent event = new PlayerTeleportEvent(
				new C03PacketPlayer.C06PacketPlayerPosLook(entityplayer.posX, entityplayer.posY, entityplayer.posZ,
						entityplayer.rotationYaw, entityplayer.rotationPitch, false),
				d0, d1, d2, f, f1);

		EventBus.getInstance().call(event);

		if (event.isCancelled())
			return;
		if (packetIn.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.X)) {
			d0 += entityplayer.posX;
		} else {
			entityplayer.motionX = 0.0D;
		}

		if (packetIn.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.Y)) {
			d1 += entityplayer.posY;
		} else {
			entityplayer.motionY = 0.0D;
		}

		if (packetIn.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.Z)) {
			d2 += entityplayer.posZ;
		} else {
			entityplayer.motionZ = 0.0D;
		}

		if (packetIn.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.X_ROT)) {
			f1 += entityplayer.rotationPitch;
		}

		if (packetIn.func_179834_f().contains(S08PacketPlayerPosLook.EnumFlags.Y_ROT)) {
			f += entityplayer.rotationYaw;
		}

		entityplayer.setPositionAndRotation(d0, d1, d2, f, f1);
		this.netManager.sendPacket(
				new C03PacketPlayer.C06PacketPlayerPosLook(entityplayer.posX, entityplayer.getEntityBoundingBox().minY,
						entityplayer.posZ, entityplayer.rotationYaw, entityplayer.rotationPitch, false));

		if (!this.doneLoadingTerrain) {
			this.gameController.thePlayer.prevPosX = this.gameController.thePlayer.posX;
			this.gameController.thePlayer.prevPosY = this.gameController.thePlayer.posY;
			this.gameController.thePlayer.prevPosZ = this.gameController.thePlayer.posZ;
			this.doneLoadingTerrain = true;
			this.gameController.displayGuiScreen(null);
		}
	}
}
