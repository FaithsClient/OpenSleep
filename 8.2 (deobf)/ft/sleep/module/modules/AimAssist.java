//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.util.concurrent.ThreadLocalRandom;

import ft.sleep.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Mouse;

public class AimAssist extends Module {
   public static Numbers revealed$ = new Numbers("ft.sleep.module.modules.Speed 1 (yaw)", 45.0D, 5.0D, 100.0D, 1.0D);
   public static Numbers surge$ = new Numbers("ft.sleep.module.modules.Speed 2 (yaw)", 15.0D, 2.0D, 97.0D, 1.0D);
   public static Numbers lexmark$ = new Numbers("ft.sleep.module.modules.Speed 1 (pitch)", 45.0D, 5.0D, 100.0D, 1.0D);
   public static Numbers proudly$ = new Numbers("ft.sleep.module.modules.Speed 2 (pitch)", 15.0D, 2.0D, 97.0D, 1.0D);
   public static Numbers elder$ = new Numbers("pitchOffSet (blocks)", 4.0D, Integer.valueOf(-2), Integer.valueOf(2), 0.05D);
   public static Numbers acrobat$ = new Numbers("Fov", 90.0D, 15.0D, 360.0D, 1.0D);
   public static Numbers enhanced$ = new Numbers("Distance", 4.5D, 1.0D, 10.0D, 0.1D);
   public static Option ozone$ = new Option("Players", false);
   public static Option express$ = new Option("Monster", false);
   public static Option click$ = new Option("Animals", false);
   public static Option label$ = new Option("Invisible", false);
   public static Option costa$ = new Option("Click Aim", false);
   public static Option knock$ = new Option("Weapon only", false);
   public static Option contains$ = new Option("Break Blocks", false);
   public static Option roses$ = new Option("Blatant mode", false);
   public static Option copying$ = new Option("Aim Pitch", false);
   public static Option relying$ = new Option("Ignore Friends", false);

   public AimAssist() {
      super("ft.sleep.module.modules.AimAssist", new String[]{"ft.sleep.module.modules.AimAssist"}, ModuleType.rolls$);
   }

   @EventHandler
   public void _dried(EventPreUpdate tapes) {
      if (RavenUtils._chester()) {
         if (RavenUtils._cable()) {
            if ((!knock$.getValue().booleanValue() || RavenUtils._daily()) && (!costa$.getValue().booleanValue() || Mouse.isButtonDown(0) && (!contains$.getValue().booleanValue() || process.mc.playerController.curBlockDamageMP == Float.intBitsToFloat(0)))) {
               Object finding = process._woods();
               if (finding != null) {
                  if (roses$.getValue().booleanValue()) {
                     RavenUtils._remained(finding, elder$.getValue().floatValue(), false);
                  } else {
                     Object readily = RavenUtils._legends(finding);
                     if (readily > 1.0D || readily < -1.0D) {
                        Object fails = readily * (ThreadLocalRandom.current().nextDouble(surge$.getValue().doubleValue() - 1.47328D, surge$.getValue().doubleValue() + 2.48293D) / 100.0D);
                        double var10000 = fails + ThreadLocalRandom.current().nextDouble(revealed$.getValue().doubleValue() - 4.723847D, revealed$.getValue().doubleValue());
                        float var9 = (float)(-(fails + readily / (101.0D - (double)((float)ThreadLocalRandom.current().nextDouble(revealed$.getValue().doubleValue() - 4.723847D, revealed$.getValue().doubleValue())))));
                        process.mc.thePlayer.rotationYaw += var9;
                     }

                     if (copying$.getValue().booleanValue()) {
                        Object var10 = RavenUtils._marine(finding, elder$.getValue().floatValue()) * (ThreadLocalRandom.current().nextDouble(proudly$.getValue().doubleValue() - 1.47328D, proudly$.getValue().doubleValue() + 2.48293D) / 100.0D);
                        float var7 = (float)(-(var10 + readily / (101.0D - (double)((float)ThreadLocalRandom.current().nextDouble(lexmark$.getValue().doubleValue() - 4.723847D, lexmark$.getValue().doubleValue())))));
                        process.mc.thePlayer.rotationPitch += var7;
                     }
                  }
               }
            }

         }
      }
   }

   public Entity _woods() {
      Object feluvuzu = acrobat$.getValue().floatValue();

      for(Object unesinev : anacorom.mc.theWorld.loadedEntityList) {
         if ((!relying$.getValue().booleanValue() || !Teams._exposure(unesinev)) && unesinev != anacorom.mc.thePlayer && !unesinev.isDead && (label$.getValue().booleanValue() || !unesinev.isInvisible()) && (double)anacorom.mc.thePlayer.getDistanceToEntity(unesinev) <= enhanced$.getValue().doubleValue() && (roses$.getValue().booleanValue() || RavenUtils._markets(unesinev, feluvuzu))) {
            if (unesinev instanceof EntityPlayer && ozone$.getValue().booleanValue()) {
               return unesinev;
            } else if (unesinev instanceof EntityAnimal && click$.getValue().booleanValue()) {
               return unesinev;
            } else {
               return unesinev instanceof EntityMob && express$.getValue().booleanValue() ? unesinev : null;
            }
         }
      }

      return null;
   }
}
