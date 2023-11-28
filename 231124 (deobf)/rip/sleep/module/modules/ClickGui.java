package rip.sleep.module.modules;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.bingus.GuiBingusClickGui;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;

public class ClickGui extends Module {
   public BooleanValue c51289 = new BooleanValue("DisplayValue", false);
   private final ModeValue c77902 = new ModeValue("Mode", new String[]{"Bingus", "Neverlose"}, "Exh");

   public ClickGui() {
      super("ClickGui", new String[]{"clickui"}, ModuleType.c12482, ModuleType.c21190.c94221);
      super.c68609(true);
   }

   public void c83205() {
      Module[] var1 = Value.c27574();
      if (Objects.equals(this.c77902.c54460(), "Bingus")) {
         mc.displayGuiScreen(new GuiBingusClickGui());
      }

      if (Objects.equals(this.c77902.c54460(), "Neverlose")) {
         Minecraft var10000 = mc;
         Sleep.getInstance();
         var10000.displayGuiScreen(Sleep.c43802);
      }

      this.c23631(false);
   }

   @EventTarget
   public void c73835(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat)) {
         KeyBinding[] var3 = new KeyBinding[]{mc.gameSettings.keyBindForward, mc.gameSettings.keyBindBack, mc.gameSettings.keyBindLeft, mc.gameSettings.keyBindRight, mc.gameSettings.keyBindSprint, mc.gameSettings.keyBindJump};
         int var5 = var3.length;
         int var6 = 0;
         if (var6 < var5) {
            KeyBinding var7 = var3[var6];
            KeyBinding.setKeyBindState(var7.getKeyCode(), Keyboard.isKeyDown(var7.getKeyCode()));
            ++var6;
         }
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
