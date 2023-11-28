package rip.sleep.module.modules;

import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtilC;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class AimAssist extends Module {
   public static NumberValue<Number> c76810 = new NumberValue<Number>("Speed 1 (yaw)", 45.0D, 5.0D, 100.0D, 1.0D);
   public static NumberValue<Number> c13972 = new NumberValue<Number>("Speed 2 (yaw)", 15.0D, 2.0D, 97.0D, 1.0D);
   public NumberValue<Number> c114 = new NumberValue<Number>("Speed 1 (pitch)", () -> {
      return c26975.c1473();
   }, 45.0D, 5.0D, 100.0D, 1.0D);
   public NumberValue<Number> c76065 = new NumberValue<Number>("Speed 2 (pitch)", () -> {
      return c26975.c1473();
   }, 15.0D, 2.0D, 97.0D, 1.0D);
   public NumberValue<Number> c57336 = new NumberValue<Number>("pitchOffSet (blocks)", () -> {
      return c26975.c1473();
   }, 4.0D, Integer.valueOf(-2), Integer.valueOf(2), 0.05D);
   public static NumberValue<Number> c81870 = new NumberValue<Number>("Fov", 90.0D, 15.0D, 360.0D, 1.0D);
   public static NumberValue<Number> c85901 = new NumberValue<Number>("Distance", 4.5D, 1.0D, 10.0D, 0.1D);
   private static BooleanValue c69604 = new BooleanValue("Players", false);
   private static BooleanValue c3186 = new BooleanValue("Monster", false);
   private static BooleanValue c30927 = new BooleanValue("Animals", false);
   private static BooleanValue c14530 = new BooleanValue("Invisible", false);
   private static BooleanValue c2794 = new BooleanValue("Click Aim", false);
   private static BooleanValue c69147 = new BooleanValue("Weapon only", false);
   private static BooleanValue c97769 = new BooleanValue("Break Blocks", false);
   private static BooleanValue c29152 = new BooleanValue("Blatant mode", false);
   private static BooleanValue c26975 = new BooleanValue("Aim Pitch", false);
   private static BooleanValue c33389 = new BooleanValue("Ignore Friends", false);

   public AimAssist() {
      super("Aim Assist", new String[]{"AimAssist"}, ModuleType.c13050, ModuleType.c21190.c28329);
   }

   @EventTarget
   private void c79015(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (PlayerUtilC.c21898()) {
         if (PlayerUtilC.c57761()) {
            if ((!c69147.c1473().booleanValue() || PlayerUtilC.c96154()) && (!c2794.c1473().booleanValue() || Mouse.isButtonDown(0) && (!c97769.c1473().booleanValue() || mc.playerController.curBlockDamageMP == 0.0F))) {
               Entity var3 = this.c10292();
               if (c29152.c1473().booleanValue()) {
                  PlayerUtilC.c5677(var3, this.c57336.c53968().floatValue(), false);
               }

               double var4 = PlayerUtilC.c70315(var3);
               if (var4 > 1.0D || var4 < -1.0D) {
                  double var6 = var4 * (ThreadLocalRandom.current().nextDouble(c13972.c53968().doubleValue() - 1.47328D, c13972.c53968().doubleValue() + 2.48293D) / 100.0D);
                  double var10000 = var6 + ThreadLocalRandom.current().nextDouble(c76810.c53968().doubleValue() - 4.723847D, c76810.c53968().doubleValue());
                  float var10 = (float)(-(var6 + var4 / (101.0D - (double)((float)ThreadLocalRandom.current().nextDouble(c76810.c53968().doubleValue() - 4.723847D, c76810.c53968().doubleValue())))));
                  mc.thePlayer.rotationYaw += var10;
               }

               if (c26975.c1473().booleanValue()) {
                  double var11 = PlayerUtilC.c11965(var3, this.c57336.c53968().floatValue()) * (ThreadLocalRandom.current().nextDouble(this.c76065.c53968().doubleValue() - 1.47328D, this.c76065.c53968().doubleValue() + 2.48293D) / 100.0D);
                  float var8 = (float)(-(var11 + var4 / (101.0D - (double)((float)ThreadLocalRandom.current().nextDouble(this.c114.c53968().doubleValue() - 4.723847D, this.c114.c53968().doubleValue())))));
                  mc.thePlayer.rotationPitch += var8;
               }
            }

         }
      }
   }

   public Entity c10292() {
      Value.c27574();
      float var2 = c81870.c53968().floatValue();

      for(Entity var4 : mc.theWorld.loadedEntityList) {
         if ((!c33389.c1473().booleanValue() || !Teams.c30985(var4)) && var4 != mc.thePlayer && !var4.isDead && (c14530.c1473().booleanValue() || !var4.isInvisible()) && (double) mc.thePlayer.getDistanceToEntity(var4) <= c85901.c53968().doubleValue() && (c29152.c1473().booleanValue() || PlayerUtilC.c86101(var4, var2))) {
            if (var4 instanceof EntityPlayer && c69604.c1473().booleanValue()) {
               return var4;
            } else if (var4 instanceof EntityAnimal && c30927.c1473().booleanValue()) {
               return var4;
            } else {
               return var4 instanceof EntityMob && c3186.c1473().booleanValue() ? var4 : null;
            }
         }
      }

      return null;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
