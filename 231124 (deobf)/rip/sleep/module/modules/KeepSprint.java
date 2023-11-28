package rip.sleep.module.modules;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import org.json.JSONException;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class KeepSprint extends Module {
   public static BooleanValue c90956 = new BooleanValue("Stop Sprint", false);
   public static BooleanValue c29862 = new BooleanValue("Only Ground", false);
   public static NumberValue<Number> c79866 = new NumberValue<Number>("Slow Ticks", () -> {
      return c90956.c1473();
   }, 1.0D, 1.0D, 9.0D, 1.0D);
   public static NumberValue<Number> c41818 = new NumberValue<Number>("Slow %", 100.0D, 0.0D, 100.0D, 1.0D);

   public KeepSprint() {
      super("Keep Sprint", new String[]{"KeepSprint"}, ModuleType.c62580, ModuleType.c21190.c37885);
      this.c36162((new Color(208, 30, 142)).getRGB());
   }

   public static void c18686(Entity var0) {
      Value.c27574();
      Reach var4 = (Reach) ModuleManager.c25475(Reach.class);
      if (c29862.c1473().booleanValue() && var4 != null && var4.c24622() && !Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode) {
         double var2 = Minecraft.getMinecraft().objectMouseOver.hitVec.distanceTo(Minecraft.getMinecraft().getRenderViewEntity().getPositionEyes(1.0F));
         if (var2 > 3.0D) {
            double var5 = (100.0D - c41818.c53968().doubleValue()) / 100.0D;
         }

         double var8 = 0.6D;
         EntityPlayerSP var10000 = Minecraft.getMinecraft().thePlayer;
         var10000.motionX *= var8;
         var10000 = Minecraft.getMinecraft().thePlayer;
         var10000.motionZ *= var8;
      }

      double var7 = (100.0D - c41818.c53968().doubleValue()) / 100.0D;
      EntityPlayerSP var10 = Minecraft.getMinecraft().thePlayer;
      var10.motionX *= var7;
      var10 = Minecraft.getMinecraft().thePlayer;
      var10.motionZ *= var7;
      if (c90956.c1473().booleanValue() && Minecraft.getMinecraft().thePlayer.ticksExisted % c79866.c53968().intValue() == 0) {
         Minecraft.getMinecraft().thePlayer.setSprinting(false);
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
