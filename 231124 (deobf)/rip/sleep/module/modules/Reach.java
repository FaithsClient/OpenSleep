package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class Reach extends Module {
   public static NumberValue<Number> c40409 = new NumberValue<Number>("Reach (Max Combo)", 3.0D, 3.0D, 6.0D, 0.1D);
   public static NumberValue<Number> c6788 = new NumberValue<Number>("Reach (Min Combo)", 3.0D, 3.0D, 6.0D, 0.1D);
   public static BooleanValue c23463 = new BooleanValue("Weapon Only", false);
   public static BooleanValue c3455 = new BooleanValue("Moving only", false);
   public static BooleanValue c12112 = new BooleanValue("Sprint only", false);
   public static BooleanValue c21189 = new BooleanValue("Hit through blocks", false);
   private static final Random c71296 = new Random();

   public Reach() {
      super("Reach", new String[]{"Reach"}, ModuleType.c13050, ModuleType.c21190.c28329);
      this.c36162((new Color(191, 191, 191)).getRGB());
   }

   public static double c61278(double var0, double var2) {
      Random var4 = new Random();
      double var5 = var2 - var0;
      double var7 = var4.nextDouble() * var5;
      double var9 = var7 + var0;
      return var9;
   }

   @EventTarget
   public void c26448(MotionUpdateEvent var1) {
   }

   public static double c98619() {
      Value.c27574();
      Reach var1 = (Reach) ModuleManager.c25475(Reach.class);
      KillAura var2 = (KillAura) ModuleManager.c25475(KillAura.class);
      if (var2.c24622()) {
         return KillAura.c17384.c53968().doubleValue();
      } else {
         double var3 = Minecraft.getMinecraft().playerController.extendedReach() ? 5.0D : 3.0D;
         if (!c85401()) {
            return var3;
         } else if (c23463.c1473().booleanValue() && !c94209()) {
            return var3;
         } else if (c3455.c1473().booleanValue() && (double)Minecraft.getMinecraft().thePlayer.moveForward == 0.0D && (double)Minecraft.getMinecraft().thePlayer.moveStrafing == 0.0D) {
            return var3;
         } else if (c12112.c1473().booleanValue() && !Minecraft.getMinecraft().thePlayer.isSprinting()) {
            return var3;
         } else {
            if (!c21189.c1473().booleanValue() && Minecraft.getMinecraft().objectMouseOver != null) {
               BlockPos var5 = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
               if (Minecraft.getMinecraft().theWorld.getBlockState(var5).getBlock() != Blocks.air) {
                  return var3;
               }
            }

            return !var1.c24622() ? var3 : c58449(c71124()) + (double)(Minecraft.getMinecraft().playerController.extendedReach() ? 2 : 0);
         }
      }
   }

   public static double c58449(Random var0) {
      Module[] var1 = Value.c27574();
      return c6788.c53968().doubleValue() == c40409.c53968().doubleValue() ? c6788.c53968().doubleValue() : c6788.c53968().doubleValue() + var0.nextDouble() * (c40409.c53968().doubleValue() - c6788.c53968().doubleValue());
   }

   public static Random c71124() {
      return c71296;
   }

   public static boolean c85401() {
      Module[] var0 = Value.c27574();
      return Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().theWorld != null;
   }

   public static boolean c94209() {
      Value.c27574();
      ItemStack var1 = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();
      return var1 != null && (var1.getItem() instanceof ItemSword || var1.getItem() instanceof ItemAxe);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
