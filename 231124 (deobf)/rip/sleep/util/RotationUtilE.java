package rip.sleep.util;

import net.minecraft.entity.player.EntityPlayer;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RotationUtilE {
   public float c41918;
   public float c28064;

   public RotationUtilE(float var1, float var2) {
      this.c41918 = var1;
      this.c28064 = var2;
      this.c93924(Float.valueOf(ChatUtilA.mc.gameSettings.mouseSensitivity));
   }

   public void c56722(float var1) {
      this.c41918 = var1;
   }

   public void c60795(float var1) {
      this.c28064 = var1;
   }

   public float c28107() {
      return this.c41918;
   }

   public float c79255() {
      return this.c28064;
   }

   public void c14909(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      if (!Float.isNaN(this.c41918) && !Float.isNaN(this.c28064)) {
         this.c93924(Float.valueOf(ChatUtilA.mc.gameSettings.mouseSensitivity));
         var1.rotationYaw = this.c41918;
         var1.rotationPitch = this.c28064;
      }
   }

   public void c93924(Float var1) {
      float var2 = var1.floatValue() * 0.6F + 0.2F;
      float var3 = var2 * var2 * var2 * 1.2F;
      this.c41918 -= this.c41918 % var3;
      this.c28064 -= this.c28064 % var3;
   }

   private static JSONException c68727(JSONException var0) {
      return var0;
   }
}
