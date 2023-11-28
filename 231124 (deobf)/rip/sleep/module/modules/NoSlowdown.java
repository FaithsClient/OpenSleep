package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.SlowdownEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;
import rip.sleep.module.ModuleType;

public class NoSlowdown extends Module {
   public ModeValue c12796 = new ModeValue("Mode", new String[]{"Vanilla", "Watchdog"}, "Watchdog");
   public NumberValue<Number> c77472 = new NumberValue<Number>("BlockForward", 1.0D, 0.2D, 1.0D, 0.01D);
   public NumberValue<Number> c84094 = new NumberValue<Number>("BlockStrafe", 1.0D, 0.2D, 1.0D, 0.01D);
   public NumberValue<Number> c14589 = new NumberValue<Number>("ConsumeForward", 1.0D, 0.2D, 1.0D, 0.01D);
   public NumberValue<Number> c9804 = new NumberValue<Number>("ConsumeStrafe", 1.0D, 0.2D, 1.0D, 0.01D);
   public NumberValue<Number> c56959 = new NumberValue<Number>("BowForward", 0.2F, 0.2D, 1.0D, 0.01D);
   public NumberValue<Number> c97664 = new NumberValue<Number>("BowStrafe", 0.2F, 0.2D, 1.0D, 0.01D);

   public NoSlowdown() {
      super("No SlowDown", new String[]{"noslowdown", "noslow"}, ModuleType.c62580, ModuleType.c21190.c88511);
      this.c36162((new Color(216, 253, 100)).getRGB());
   }

   public void c83205() {
   }

   public void c71897() {
   }

   private boolean c64403(ItemStack var1) {
      Module[] var2 = Value.c27574();
      if (var1 == null) {
         return false;
      } else if (var1.getItem() instanceof ItemSword) {
         return false;
      } else if (var1.getItem() instanceof ItemBow) {
         return true;
      } else if (ItemPotion.isSplash(var1.getMetadata())) {
         return false;
      } else {
         return var1.getItem() instanceof ItemFood || var1.getItem() instanceof ItemPotion || var1.getItem() instanceof ItemBucketMilk;
      }
   }

   public boolean c57725() {
      Module[] var1 = Value.c27574();
      return (Mouse.isButtonDown(1) || KillAura.c62171) && mc.thePlayer.getHeldItem() != null && mc.thePlayer.getHeldItem().getItem() instanceof ItemSword;
   }

   @EventTarget
   private void c76750(SlowdownEvent var1) {
      Item var2 = mc.thePlayer.getHeldItem().getItem();
      var1.c10752 = this.c40133(var2, true);
      var1.c63184 = this.c40133(var2, false);
   }

   private float c40133(Item var1, boolean var2) {
      Value.c27574();
      float var4 = 0.2F;
      if (var1 instanceof ItemFood || var1 instanceof ItemPotion || var1 instanceof ItemBucketMilk) {
         if (var2) {
            var4 = this.c14589.c53968().floatValue();
         }

         var4 = this.c9804.c53968().floatValue();
      }

      if (var1 instanceof ItemSword) {
         var4 = this.c77472.c53968().floatValue();
         var4 = this.c84094.c53968().floatValue();
      }

      if (var1 instanceof ItemBow) {
         if (var2) {
            var4 = this.c56959.c53968().floatValue();
         }

         var4 = this.c97664.c53968().floatValue();
      }

      return var4;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
