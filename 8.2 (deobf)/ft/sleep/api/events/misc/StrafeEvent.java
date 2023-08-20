//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.api.events.misc;

import ft.sleep.api.Event;
import net.minecraft.client.Minecraft;

public class StrafeEvent extends Event {
   private static final Minecraft mc = Minecraft.getMinecraft();
   private float strafe;
   private float forward;
   private float friction;
   private final float yaw;

   public StrafeEvent(float strafe, float forward, float friction, float yaw) {
      this.strafe = strafe;
      this.forward = forward;
      this.friction = friction;
      this.yaw = yaw;
   }

   public float getStrafe() {
      return this.strafe;
   }

   public void setStrafe(float strafe) {
      this.strafe = strafe;
   }

   public float getForward() {
      return this.forward;
   }

   public void setForward(float forward) {
      this.forward = forward;
   }

   public float getFriction() {
      return this.friction;
   }

   public void setFriction(float friction) {
      this.friction = friction;
   }

   public void setMotionPartialStrafe(float friction, float strafeComponent) {
      float remainder = 1.0F - strafeComponent;
      if (this.forward != 0.0F && this.strafe != 0.0F) {
         friction = (float)((double)friction * 0.91D);
      }

      if (mc.thePlayer.onGround) {
         this.setMotion((double)friction);
      } else {
         mc.thePlayer.motionX *= (double)strafeComponent;
         mc.thePlayer.motionZ *= (double)strafeComponent;
         this.setFriction(friction * remainder);
      }

   }

   public void setMotion(double speed) {
      mc.thePlayer.motionX = 0.0D;
      mc.thePlayer.motionZ = 0.0D;
      speed = speed * (this.strafe != 0.0F && this.forward != 0.0F ? 0.91D : 1.0D);
      this.setFriction((float)speed);
   }

   public float getYaw() {
      return this.yaw;
   }
}
