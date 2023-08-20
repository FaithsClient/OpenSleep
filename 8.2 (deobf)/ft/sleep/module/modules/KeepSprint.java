//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;

public class KeepSprint extends Module {
   public static Numbers result$ = new Numbers("Ticks", 1.0D, 1.0D, 9.0D, 1.0D);
   public static Numbers arizona$ = new Numbers("Slow %", 100.0D, Double.longBitsToDouble(0L), 100.0D, 1.0D);
   public static Option surgeons$ = new Option("Stop ft.sleep.module.modules.Sprint", false);
   public static Option insects$ = new Option("Only reduce reach hits", false);

   public KeepSprint() {
      super("ft.sleep.module.modules.KeepSprint", new String[]{"ft.sleep.module.modules.KeepSprint"}, ModuleType.Combat);
      oluzavod._piece((new Color(208, 30, 142)).getRGB());
   }

   public static void _concerns(Entity iyotifad) {
      Reach var3 = (Reach) ModuleManager._herbs(Reach.class);
      if (insects$.getValue().booleanValue() && var3 != null && var3._central() && !Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode) {
         Object var6 = Minecraft.getMinecraft().objectMouseOver.hitVec.distanceTo(Minecraft.getMinecraft().getRenderViewEntity().getPositionEyes(1.0F));
         double var4;
         if (var6 > 3.0D) {
            var4 = (100.0D - arizona$.getValue().doubleValue()) / 100.0D;
         } else {
            var4 = 0.6D;
         }

         EntityPlayerSP var8 = Minecraft.getMinecraft().thePlayer;
         var8.motionX *= var4;
         var8 = Minecraft.getMinecraft().thePlayer;
         var8.motionZ *= var4;
      } else {
         Object ziyupoge = (100.0D - arizona$.getValue().doubleValue()) / 100.0D;
         EntityPlayerSP var10000 = Minecraft.getMinecraft().thePlayer;
         var10000.motionX *= ziyupoge;
         var10000 = Minecraft.getMinecraft().thePlayer;
         var10000.motionZ *= ziyupoge;
      }

      if (surgeons$.getValue().booleanValue() && Minecraft.getMinecraft().thePlayer.ticksExisted % result$.getValue().intValue() == 0) {
         Minecraft.getMinecraft().thePlayer.setSprinting(false);
      }

   }
}
