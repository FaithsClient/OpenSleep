package rip.sleep.module.modules;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.JumpEvent;
import rip.sleep.event.events.LivingUpdateEvent;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public final class Sprint extends Module {
   public static BooleanValue c92168 = new BooleanValue("MultiDir", false);
   public static BooleanValue c69846 = new BooleanValue("MultiDirJump", false);
   private boolean c60587 = false;
   private boolean c84519 = false;
   public static boolean c37211 = false;

   public Sprint() {
      super("Sprint", new String[]{"Sprint"}, ModuleType.c62580, ModuleType.c21190.c88511);
   }

   public void c71897() {
      mc.thePlayer.setSprinting(false);
      super.c71897();
   }

   @EventTarget
   public void c5134(JumpEvent var1) {
      if (this.c84519) {
         var1.cancel();
      }

   }

   @EventTarget
   public void c19703(LivingUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (PlayerUtil.c71257() && !mc.thePlayer.isSneaking() && (mc.thePlayer.moveForward >= 0.8F || c92168.c1473().booleanValue())) {
         if (c92168.c1473().booleanValue() || mc.thePlayer.movementInput.moveForward >= 0.8F) {
            mc.thePlayer.setSprinting(true);
         }

         Sleep.c33759();
         if (!ModuleManager.c25475(Speed.class).c24622() && mc.thePlayer.onGround && mc.gameSettings.keyBindJump.isKeyDown() && c69846.c1473().booleanValue() && (mc.thePlayer.movementInput.moveForward != 0.0F || mc.thePlayer.movementInput.moveStrafe != 0.0F) && !mc.thePlayer.isInWater() && !mc.thePlayer.isInLava() && !mc.thePlayer.isOnLadder() && !mc.thePlayer.isInWeb) {
            if (mc.gameSettings.keyBindJump.isKeyDown()) {
               mc.gameSettings.keyBindJump.pressed = false;
               this.c60587 = true;
            }

            float var3 = mc.thePlayer.rotationYaw;
            mc.thePlayer.rotationYaw = this.c66304();
            mc.thePlayer.jump();
            mc.thePlayer.rotationYaw = var3;
            this.c84519 = true;
            if (this.c60587) {
               mc.gameSettings.keyBindJump.pressed = true;
               this.c60587 = false;
            }
         }

         this.c84519 = false;
      } else {
         mc.thePlayer.setSprinting(false);
      }
   }

   @EventTarget
   public void c25180(MotionUpdateEvent var1) {
      Value.c27574();
      c37211 = false;
      if (PlayerUtil.c71257() && !mc.thePlayer.isSneaking() && (mc.thePlayer.moveForward >= 0.8F || c92168.c1473().booleanValue())) {
         if ((c92168.c1473().booleanValue() || mc.thePlayer.movementInput.moveForward >= 0.8F) && !mc.thePlayer.isSneaking() && mc.gameSettings.keyBindBack.isKeyDown()) {
            if (this.c48596(mc.thePlayer) && mc.gameSettings.keyBindRight.isKeyDown()) {
               return;
            }

            c37211 = true;
         }

      } else {
         mc.thePlayer.setSprinting(false);
      }
   }

   private boolean c48596(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      return var1.inventory.getCurrentItem() != null && var1.inventory.getCurrentItem().getItem() instanceof ItemBlock;
   }

   private float c66304() {
      Value.c27574();
      float var2 = mc.thePlayer.rotationYaw;
      if (mc.thePlayer.moveForward != 0.0F && mc.thePlayer.moveStrafing == 0.0F) {
         var2 += mc.thePlayer.moveForward > 0.0F ? 0.0F : 180.0F;
      }

      if (mc.thePlayer.moveForward != 0.0F && mc.thePlayer.moveStrafing != 0.0F) {
         if (mc.thePlayer.moveForward > 0.0F) {
            var2 += mc.thePlayer.moveStrafing > 0.0F ? -45.0F : 45.0F;
         }

         var2 = var2 - (mc.thePlayer.moveStrafing > 0.0F ? -45.0F : 45.0F);
         var2 = var2 + (mc.thePlayer.moveForward > 0.0F ? 0.0F : 180.0F);
      }

      if (mc.thePlayer.moveStrafing != 0.0F && mc.thePlayer.moveForward == 0.0F) {
         var2 += mc.thePlayer.moveStrafing > 0.0F ? -90.0F : 90.0F;
      }

      return var2;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
