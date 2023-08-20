package ft.sleep.api.events.world;

import ft.sleep.api.Event;

public class EventPreUpdate extends Event {
   public static float yaw;
   public static float yaw2;
   public static float pitch;
   public static float pitch2;
   public double x;
   public static double y;
   public double z;
   public static boolean ground;
   public static float prevYaw;
   public static float prevPitch;

   public EventPreUpdate(float prevYaw, float prevPitch, float yaw2, float pitch2, double x, double y, double z, boolean ground) {
      yaw2 = yaw;
      pitch2 = pitch;
      yaw = yaw2;
      pitch = pitch2;
      this.x = x;
      y = y;
      this.z = z;
      ground = ground;
      prevPitch = prevPitch;
      prevYaw = prevYaw;
   }

   public static float getYaw() {
      return yaw;
   }

   public void setYaw(float yaw) {
      yaw = yaw;
   }

   public float getPitch() {
      return pitch;
   }

   public void setPitch(float pitch) {
      pitch = pitch;
   }

   public static float getPrevYaw() {
      return prevYaw;
   }

   public static float getPrevPitch() {
      return prevPitch;
   }

   public double getZ() {
      return this.z;
   }

   public void setZ(double z) {
      this.z = z;
   }

   public double getX() {
      return this.x;
   }

   public void setX(double x) {
      this.x = x;
   }

   public double getY() {
      return y;
   }

   public static void setY(double y2) {
      y = y2;
   }

   public boolean isOnground() {
      return ground;
   }

   public static void setOnground(boolean ground2) {
      ground = ground2;
   }
}
