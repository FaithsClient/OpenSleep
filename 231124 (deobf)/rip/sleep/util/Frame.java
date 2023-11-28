package rip.sleep.util;

import net.minecraft.client.Minecraft;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.value.Value;

public class Frame {
   public int c21693;
   public int c8013;
   public int c11862;
   public int c18861;

   public Frame(int var1, int var2, int var3, int var4) {
      this.c21693 = var1;
      this.c8013 = var2;
      this.c11862 = var3;
      this.c18861 = var4;
   }

   public void c94845() {
      c1550(this.c21693, this.c8013 + 1, this.c11862 - this.c21693 + 20, this.c18861 - this.c8013 + 50);
   }

   public static void c1550(int var0, int var1, int var2, int var3) {
      Value.c27574();
      Minecraft var5 = Minecraft.getMinecraft();
      int var6 = 1;
      int var7 = var5.gameSettings.guiScale;
      if (var7 == 0) {
         var7 = 1000;
      }

      if (var6 < var7 && var5.displayWidth / (var6 + 1) >= 320 && var5.displayHeight / (var6 + 1) >= 240) {
         ++var6;
      }

      GL11.glScissor(var0 * var6, var5.displayHeight - (var1 + var3) * var6, var2 * var6, var3 * var6);
   }

   private static JSONException c71722(JSONException var0) {
      return var0;
   }
}
