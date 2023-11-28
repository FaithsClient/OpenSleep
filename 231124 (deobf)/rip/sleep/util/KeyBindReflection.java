package rip.sleep.util;

import net.minecraft.client.settings.KeyBinding;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.module.Module;
import rip.sleep.interfaces.IInstanceAccess;
import rip.sleep.value.Value;

public class KeyBindReflection implements IInstanceAccess {
   public static boolean c69502(KeyBinding var0) {
      return Keyboard.isKeyDown(var0.getKeyCode());
   }

   public static void c78817(KeyBinding var0) {
      Module[] var1 = Value.c27574();
      if (c56767.currentScreen != null) {
         var0.pressed = false;
      }

      var0.pressed = c69502(var0);
   }

   public static void c18932(KeyBinding... var0) {
      Value.c27574();
      int var3 = var0.length;
      int var4 = 0;
      if (var4 < var3) {
         KeyBinding var5 = var0[var4];
         c78817(var5);
         ++var4;
      }

   }

   private static JSONException c14498(JSONException var0) {
      return var0;
   }
}
