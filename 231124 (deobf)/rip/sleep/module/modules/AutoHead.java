package rip.sleep.module.modules;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.ServerUtilA;
import rip.sleep.util.TimerUtilF;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public class AutoHead extends Module {
   private final NumberValue<Number> c98816 = new NumberValue<Number>("Delay", Integer.valueOf(750), Integer.valueOf(0), Integer.valueOf(3000), Integer.valueOf(50));
   private final NumberValue<Number> c6245 = new NumberValue<Number>("Health %", Integer.valueOf(50), Integer.valueOf(1), Integer.valueOf(99), Integer.valueOf(1));
   private final TimerUtilF c91057 = new TimerUtilF();
   boolean c79240 = false;

   public AutoHead() {
      super("Auto Head", new String[]{"AutoHead"}, ModuleType.c13050, ModuleType.c21190.c47958);
   }

   @EventTarget
   public void c42000(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (!ServerUtilA.c92750()) {
         if (mc.thePlayer != null && mc.theWorld != null && (!mc.thePlayer.isPotionActive(Potion.moveSpeed) || !mc.thePlayer.isPotionActive(Potion.regeneration)) && mc.thePlayer.getHealth() / mc.thePlayer.getMaxHealth() * 100.0F <= this.c6245.c53968().floatValue() && this.c91057.c75125(this.c98816.c53968().longValue())) {
            int var3 = 0;
            if (var3 < 45) {
               ItemStack var4 = mc.thePlayer.inventoryContainer.getSlot(var3).getStack();
               if (var4.getItem() instanceof ItemSkull && var4.getDisplayName().contains("Head")) {
                  int var5 = mc.thePlayer.inventory.currentItem;
                  if (var3 - 36 < 0) {
                     mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, var3, 8, 2, mc.thePlayer);
                     mc.thePlayer.inventory.currentItem = 8;
                  }

                  mc.thePlayer.inventory.currentItem = var3 - 36;
                  KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                  this.c79240 = true;
                  mc.thePlayer.inventory.currentItem = var5;
                  this.c91057.c99119();
               }

               ++var3;
            }
         }

         if (this.c79240) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
            this.c79240 = false;
         }
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
