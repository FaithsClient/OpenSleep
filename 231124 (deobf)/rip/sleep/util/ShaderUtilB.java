package rip.sleep.util;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.util.shader.ShaderB;
import rip.sleep.value.Value;

public class ShaderUtilB {
   Minecraft c74743 = Minecraft.getMinecraft();
   public static ShaderB c19483 = new ShaderB("roundedRect");
   public static ShaderB c93372 = new ShaderB("sleep/Shaders/roundRectOutline.frag");
   private static final ShaderB c45270 = new ShaderB("sleep/Shaders/roundRectTextured.frag");
   private static final ShaderB c15805 = new ShaderB("roundedRectGradient");

   public static void c25830(float var0, float var1, float var2, float var3, float var4, Color var5) {
      c7101(var0, var1, var2, var3, var4, false, var5);
   }

   public static void c17810(float var0, float var1, float var2, float var3, float var4, Color var5) {
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      c25830(var0, var1, var2, var3, var4, var5);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
   }

   public static void c33168(float var0, float var1, float var2, float var3, float var4, Color var5, float var6) {
      c7101(var0 + var2 - var2 * var6, var1 + var3 / 2.0F - var3 / 2.0F * var6, var2 * var6, var3 * var6, var4, false, var5);
   }

   public static void c41545(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6) {
      c48991(var0, var1, var2, var3, var4, var5, var5, var6, var6);
   }

   public static void c36828(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6) {
      c48991(var0, var1, var2, var3, var4, var6, var5, var6, var5);
   }

   public static void c48991(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6, Color var7, Color var8) {
      c59759();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      c15805.c99400();
      c48736(var0, var1, var2, var3, var4, c15805);
      c15805.c60072("color1", (float)var5.getRed() / 255.0F, (float)var5.getGreen() / 255.0F, (float)var5.getBlue() / 255.0F, (float)var5.getAlpha() / 255.0F);
      c15805.c60072("color2", (float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      c15805.c60072("color3", (float)var7.getRed() / 255.0F, (float)var7.getGreen() / 255.0F, (float)var7.getBlue() / 255.0F, (float)var7.getAlpha() / 255.0F);
      c15805.c60072("color4", (float)var8.getRed() / 255.0F, (float)var8.getGreen() / 255.0F, (float)var8.getBlue() / 255.0F, (float)var8.getAlpha() / 255.0F);
      ShaderB.c85005(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var3 + 2.0F);
      c15805.c26920();
      GlStateManager.disableBlend();
   }

   public static void c59759() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c7101(float var0, float var1, float var2, float var3, float var4, boolean var5, Color var6) {
      c59759();
      GlStateManager.enableBlend();
      Value.c27574();
      GlStateManager.blendFunc(770, 771);
      c19483.c99400();
      c48736(var0, var1, var2, var3, var4, c19483);
      c19483.c29268("blur", var5 ? 1 : 0);
      c19483.c60072("color", (float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      ShaderB.c85005(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var3 + 2.0F);
      c19483.c26920();
      GlStateManager.disableBlend();
   }

   public static void c77238(float var0, float var1, float var2, Color var3) {
      c59759();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      c19483.c99400();
      c48736(var0, var1, var2, var2, var2 / 2.0F - 0.25F, c19483);
      c19483.c60072("color", (float)var3.getRed() / 255.0F, (float)var3.getGreen() / 255.0F, (float)var3.getBlue() / 255.0F, (float)var3.getAlpha() / 255.0F);
      ShaderB.c85005(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var2 + 2.0F);
      c19483.c26920();
      GlStateManager.disableBlend();
   }

   public static void c35610(float var0, float var1, float var2, float var3, float var4, float var5, Color var6, Color var7) {
      c59759();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      c93372.c99400();
      ScaledResolution var8 = new ScaledResolution(Minecraft.getMinecraft());
      c48736(var0, var1, var2, var3, var4, c93372);
      c93372.c60072("outlineThickness", var5 * (float)var8.getScaleFactor());
      c93372.c60072("color", (float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      c93372.c60072("outlineColor", (float)var7.getRed() / 255.0F, (float)var7.getGreen() / 255.0F, (float)var7.getBlue() / 255.0F, (float)var7.getAlpha() / 255.0F);
      ShaderB.c85005(var0 - (2.0F + var5), var1 - (2.0F + var5), var2 + 4.0F + var5 * 2.0F, var3 + 4.0F + var5 * 2.0F);
      c93372.c26920();
      GlStateManager.disableBlend();
   }

   public static void c66564(float var0, float var1, float var2, float var3, float var4, float var5) {
      c59759();
      c45270.c99400();
      c45270.c29268("textureIn", 0);
      c48736(var0, var1, var2, var3, var4, c45270);
      c45270.c60072("alpha", var5);
      ShaderB.c85005(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var3 + 2.0F);
      c45270.c26920();
      GlStateManager.disableBlend();
   }

   private static void c48736(float var0, float var1, float var2, float var3, float var4, ShaderB var5) {
      ScaledResolution var6 = new ScaledResolution(Minecraft.getMinecraft());
      var5.c60072("location", var0 * (float)var6.getScaleFactor(), (float)Minecraft.getMinecraft().displayHeight - var3 * (float)var6.getScaleFactor() - var1 * (float)var6.getScaleFactor());
      var5.c60072("rectSize", var2 * (float)var6.getScaleFactor(), var3 * (float)var6.getScaleFactor());
      var5.c60072("radius", var4 * (float)var6.getScaleFactor());
   }

   public static void c51646(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6) {
      Color var7 = RenderUtilG.c88833(var5, var6, 0.5F);
      c48991(var0, var1, var2, var3, var4, var7, var5, var6, var7);
   }

   public static void c36486(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6) {
      Color var7 = RenderUtilG.c88833(var6, var5, 0.5F);
      c48991(var0, var1, var2, var3, var4, var5, var7, var7, var6);
   }

   private static JSONException c91590(JSONException var0) {
      return var0;
   }
}
