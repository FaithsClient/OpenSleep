package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.client.Minecraft;
import org.json.JSONException;
import rip.sleep.value.Value;

public class StrafeEvent extends Event {
   private static final Minecraft c99562 = Minecraft.getMinecraft();
   private float c56983;
   private float c95831;
   private float c61885;
   private final float c52520;

   public StrafeEvent(float var1, float var2, float var3, float var4) {
      this.c56983 = var1;
      this.c95831 = var2;
      this.c61885 = var3;
      this.c52520 = var4;
   }

   public float c3185() {
      return this.c56983;
   }

   public void c45778(float var1) {
      this.c56983 = var1;
   }

   public float c60583() {
      return this.c95831;
   }

   public void c66661(float var1) {
      this.c95831 = var1;
   }

   public float c69436() {
      return this.c61885;
   }

   public void c11051(float var1) {
      this.c61885 = var1;
   }

   public void c81722(float var1, float var2) {
      Value.c27574();
      float var4 = 1.0F - var2;
      if (this.c95831 != 0.0F && this.c56983 != 0.0F) {
         var1 = (float)((double)var1 * 0.91D);
      }

      if (c99562.thePlayer.onGround) {
         this.c77253((double)var1);
      }

      c99562.thePlayer.motionX *= (double)var2;
      c99562.thePlayer.motionZ *= (double)var2;
      this.c11051(var1 * var4);
   }

   public void c77253(double var1) {
      Value.c27574();
      c99562.thePlayer.motionX = 0.0D;
      c99562.thePlayer.motionZ = 0.0D;
      var1 = var1 * (this.c56983 != 0.0F && this.c95831 != 0.0F ? 0.91D : 1.0D);
      this.c11051((float)var1);
   }

   public float c74012() {
      return this.c52520;
   }

   private static JSONException c83349(JSONException var0) {
      return var0;
   }
}
