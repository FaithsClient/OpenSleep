package linxiu.api.events.world;

import linxiu.api.Event;
import linxiu.api.Position;
import linxiu.api.events.Rotation;
import linxiu.utils.PacketUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S08PacketPlayerPosLook.EnumFlags;

import java.util.Set;

public class PlayerTeleportEvent extends Event {

	public PlayerTeleportEvent(C06PacketPlayerPosLook c06PacketPlayerPosLook, double d0, double d1, double d2, float f, float f1) {
		response = c06PacketPlayerPosLook;
		posX = d0;
		posY = d1;
		posZ = d2;
		yaw = f;
		pitch = f1;
	}
	
	private C03PacketPlayer.C06PacketPlayerPosLook response;
    private double posX;
    private double posY;
    private double posZ;
    private float yaw;
    private float pitch;
    
	public double getPosX() {
		return posX;
	}
	
	public double getPosY() {
		return posY;
	}
    
	public double getPosZ() {
		return posZ;
	}

	public float getYaw() {
		return yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public Packet getResponse() {
		return response;
	}

	public void setPosX(double d) {
		this.posX = d;
	}

	public void setPosZ(double d) {
		this.posZ = d;
	}
}