package rip.sleep.module.modules;

import net.minecraft.block.material.Material;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class FluidMove extends Module {
   public static BooleanValue c73261 = new BooleanValue("Cancel Water", false);
   public static BooleanValue c4346 = new BooleanValue("Cancel Lava", false);
   public static NumberValue<Number> c37693 = new NumberValue<Number>("Custom Speed", 0.15D, 0.0D, 0.3D, 0.01D);
   public boolean c44947 = false;

   public FluidMove() {
      super("Fluid Move", new String[]{"FluidMove"}, ModuleType.c62580, ModuleType.c21190.c37885);
   }

   public boolean c44638() {
      Module[] var1 = Value.c27574();
      return !mc.gameSettings.keyBindJump.isKeyDown();
   }

   @EventTarget
   public void c11027(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer.onGround && mc.thePlayer.worldObj.handleMaterialAcceleration(mc.thePlayer.getEntityBoundingBox().expand(0.0D, -0.4000000059604645D, 0.0D).contract(0.001D, 0.001D, 0.001D), Material.water, mc.thePlayer) && this.c44638()) {
         PlayerUtil.c16498(c37693.c53968().floatValue());
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
