package rip.sleep.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.*;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class InvMove extends Module {
   public static boolean c54228;
   public static BooleanValue c10726 = new BooleanValue("Slow", Boolean.TRUE);
   public static BooleanValue c91704 = new BooleanValue("inventory", Boolean.TRUE);
   public NumberValue<Number> c39122 = new NumberValue<Number>("Slow Speed", () -> {
      return c10726.c1473();
   }, 0.03D, 0.0D, 0.1D, 0.01D);

   public InvMove() {
      super("Inventory Move", new String[]{"InventoryMove"}, ModuleType.c62580, ModuleType.c21190.c88511);
   }

   public static void c49780() {
      Value.c27574();
      KeyBinding[] var1 = new KeyBinding[]{Minecraft.getMinecraft().gameSettings.keyBindForward, Minecraft.getMinecraft().gameSettings.keyBindRight, Minecraft.getMinecraft().gameSettings.keyBindBack, Minecraft.getMinecraft().gameSettings.keyBindLeft, Minecraft.getMinecraft().gameSettings.keyBindJump};
      int var3 = var1.length;
      int var4 = 0;
      if (var4 < var3) {
         KeyBinding var5 = var1[var4];
         KeyBinding.setKeyBindState(var5.getKeyCode(), Keyboard.isKeyDown(var5.getKeyCode()));
         ++var4;
      }

   }

   @EventTarget
   public void c32087(LivingUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (!(mc.currentScreen instanceof GuiChat) && (mc.currentScreen instanceof GuiInventory || !c91704.c1473().booleanValue())) {
         if (mc.currentScreen != null) {
            c49780();
         }

      }
   }

   @EventTarget
   public void c42901(DisplayScreenEvent var1) {
      Module[] var2 = Value.c27574();
      if (!(mc.currentScreen instanceof GuiChat) && (mc.currentScreen instanceof GuiInventory || !c91704.c1473().booleanValue())) {
         c49780();
      }
   }

   @EventTarget
   public void c87158(JumpEvent var1) {
      Module[] var2 = Value.c27574();
      if (c10726.c1473().booleanValue() && mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat) && c54228) {
         var1.cancel();
      }

   }

   @EventTarget
   public void c75916(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c10726.c1473().booleanValue() && mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat) && c54228) {
         PlayerUtil.c12666(this.c39122.c53968().doubleValue());
      }

   }

   @EventTarget
   public void c44140(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (c10726.c1473().booleanValue()) {
         if (mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat)) {
            if (!(PacketSendEvent.c81894() instanceof C0EPacketClickWindow)) {
               return;
            }

            c54228 = true;
         }

         c54228 = false;
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
