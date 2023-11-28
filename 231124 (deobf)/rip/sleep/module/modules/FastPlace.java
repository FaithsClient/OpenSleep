package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.potion.Potion;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class FastPlace extends Module {
   public NumberValue<Number> c70442 = new NumberValue<Number>("Place Ticks", 1.0D, 0.0D, 4.0D, 1.0D);
   private final BooleanValue c64322 = new BooleanValue("Blocks", true);
   private final BooleanValue c92057 = new BooleanValue("Projectiles", true);
   private final BooleanValue c46419 = new BooleanValue("Healing Potions", true);

   public FastPlace() {
      super("Fast Place", new String[]{"fPlace", "fc", "FastPlace"}, ModuleType.c31770, ModuleType.c21190.c76367);
      this.c36162((new Color(226, 197, 78)).getRGB());
   }

   private boolean c98306() {
      Module[] var1 = Value.c27574();
      if (mc.thePlayer != null && mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItem() != null) {
         Item var2 = mc.thePlayer.getCurrentEquippedItem().getItem();
         return this.c64322.c1473().booleanValue() && var2 instanceof ItemBlock || this.c92057.c1473().booleanValue() && (var2 instanceof ItemSnowball || var2 instanceof ItemEgg || var2 instanceof ItemExpBottle) || this.c46419.c1473().booleanValue() && this.c43596(var2);
      } else {
         return false;
      }
   }

   private boolean c43596(Item var1) {
      Module[] var2 = Value.c27574();
      return var1 != null && var1 instanceof ItemPotion && mc.thePlayer.getCurrentEquippedItem().getDisplayName().contains("Healing");
   }

   @EventTarget
   public void c86165(EndTickEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c98306()) {
         if (!mc.thePlayer.isPotionActive(Potion.jump) && mc.thePlayer.rotationPitch >= 70.0F && mc.gameSettings.keyBindJump.isKeyDown() && !PlayerUtil.c71257()) {
            return;
         }

         mc.rightClickDelayTimer = Math.min(mc.rightClickDelayTimer, this.c70442.c53968().intValue());
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
