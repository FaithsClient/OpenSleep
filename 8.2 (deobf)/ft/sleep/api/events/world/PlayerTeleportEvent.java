package ft.sleep.api.events.world;

import ft.sleep.api.Event;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;

public class PlayerTeleportEvent extends Event {
   private C06PacketPlayerPosLook response;
   private double posX;
   private double posY;
   private double posZ;
   private float yaw;
   private float pitch;

   public PlayerTeleportEvent(C06PacketPlayerPosLook c06PacketPlayerPosLook, double d0, double d1, double d2, float f, float f1) {
      this.response = c06PacketPlayerPosLook;
      this.posX = d0;
      this.posY = d1;
      this.posZ = d2;
      this.yaw = f;
      this.pitch = f1;
   }

   public double getPosX() {
      return this.posX;
   }

   public double getPosY() {
      return this.posY;
   }

   public double getPosZ() {
      return this.posZ;
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getPitch() {
      return this.pitch;
   }

   public Packet getResponse() {
      return this.response;
   }

   public void setPosX(double d) {
      this.posX = d;
   }

   public void setPosZ(double d) {
      this.posZ = d;
   }

   public void setYaw(float rotationYaw) {
      this.yaw = rotationYaw;
   }

   public void setPitch(float rotationPitch) {
      this.pitch = rotationPitch;
   }
}
