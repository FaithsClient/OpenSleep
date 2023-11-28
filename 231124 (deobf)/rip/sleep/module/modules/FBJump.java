package rip.sleep.module.modules;

import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PacketUtilA;
import rip.sleep.util.PlayerUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public final class FBJump extends Module {
   private NumberValue<Number> c69780 = new NumberValue<Number>("Speed", 1.91D, 0.5D, 3.01D, 0.01D);
   boolean c98342 = false;
   boolean c68794 = false;
   boolean c31626 = false;
   boolean c20966 = false;
   int c14451 = 0;

   public FBJump() {
      super("FB Jump", new String[]{"fbjump"}, ModuleType.c62580, ModuleType.c21190.c88511);
   }

   public void c83205() {
   }

   public void c71897() {
      this.c98342 = false;
      this.c31626 = false;
      this.c20966 = false;
      this.c14451 = 0;
   }

   public boolean c80206() {
      Value.c27574();
      ItemStack var2 = mc.thePlayer.getHeldItem();
      return var2 != null && (var2.getDisplayName().contains("Fireball") || var2.getDisplayName().contains("Fire Charge"));
   }

   public boolean c21847() {
      Value.c27574();
      MovingObjectPosition var2 = mc.objectMouseOver;
      return var2 != null && var2.typeOfHit == MovingObjectType.BLOCK;
   }

   @EventTarget
   public void c74713(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      Packet var3 = PacketSendEvent.c81894();
      if (var3 instanceof C08PacketPlayerBlockPlacement && this.c80206() && this.c21847() && c23171(Velocity.class).c24622() || c23171(AntiKB.class).c24622()) {
         this.c98342 = true;
         this.c68794 = true;
         Sleep var10000 = Sleep.INSTANCE;
         Sleep.c33759();
         if (ModuleManager.c25475(Velocity.class).c24622()) {
            c23171(Velocity.class).c23631(false);
            this.c31626 = true;
         }

         var10000 = Sleep.INSTANCE;
         Sleep.c33759();
         if (ModuleManager.c25475(AntiKB.class).c24622()) {
            c23171(AntiKB.class).c23631(false);
            this.c20966 = true;
         }

         var1.cancel();
      }

   }

   @EventTarget
   public void c25180(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c98342) {
         ++this.c14451;
         if (this.c68794) {
            MotionUpdateEvent.c49492 = 79.0F;
            MotionUpdateEvent.c20086 -= 180.0F;
         }

         if (this.c14451 >= 2) {
            PacketUtilA.sendPacketNoEvent(new C08PacketPlayerBlockPlacement(mc.thePlayer.inventory.getCurrentItem()));
            this.c68794 = false;
         }

         if (mc.thePlayer.hurtTime > 0) {
            this.c14451 = 0;
            this.c98342 = false;
            this.c68794 = false;
            PlayerUtil.c86285(this.c69780.c53968().doubleValue());
         }
      }

      if (this.c14451 >= 12) {
         this.c14451 = 0;
         this.c98342 = false;
         this.c68794 = false;
         if (this.c31626) {
            Sleep var10000 = Sleep.INSTANCE;
            Sleep.c33759();
            if (!ModuleManager.c25475(Velocity.class).c24622()) {
               c23171(Velocity.class).c23631(true);
            }

            this.c31626 = false;
         }

         if (this.c20966) {
            Sleep var3 = Sleep.INSTANCE;
            Sleep.c33759();
            if (!ModuleManager.c25475(AntiKB.class).c24622()) {
               c23171(AntiKB.class).c23631(true);
            }

            this.c20966 = false;
         }
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
