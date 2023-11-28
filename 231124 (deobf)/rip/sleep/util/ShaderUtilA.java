package rip.sleep.util;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.util.shader.ShaderA;
import rip.sleep.value.Value;

public class ShaderUtilA {
   Minecraft c33592 = Minecraft.getMinecraft();
   public static ShaderA c77888 = new ShaderA("roundedRect");
   public static ShaderA c34405 = new ShaderA("sleep/Shaders/roundRectOutline.frag");
   private static final ShaderA c99477 = new ShaderA("sleep/Shaders/roundRectTextured.frag");
   private static final ShaderA c93734 = new ShaderA("roundedRectGradient");

   public static void c76901(float var0, float var1, float var2, float var3, float var4, Color var5) {
      c80483(var0, var1, var2, var3, var4, false, var5);
   }

   public static void c79602(float var0, float var1, float var2, float var3, float var4, Color var5) {
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      c76901(var0, var1, var2, var3, var4, var5);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
   }

   public static void c75291(float var0, float var1, float var2, float var3, float var4, Color var5, float var6) {
      c80483(var0 + var2 - var2 * var6, var1 + var3 / 2.0F - var3 / 2.0F * var6, var2 * var6, var3 * var6, var4, false, var5);
   }

   public static void c84202(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6) {
      c66560(var0, var1, var2, var3, var4, var5, var5, var6, var6);
   }

   public static void c48908(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6) {
      c66560(var0, var1, var2, var3, var4, var6, var5, var6, var5);
   }

   public static void c66560(float var0, float var1, float var2, float var3, float var4, Color var5, Color var6, Color var7, Color var8) {
      GlStateManager.resetColor();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      c93734.c78750();
      c63963(var0, var1, var2, var3, var4, c93734);
      c93734.c30180("color1", (float)var5.getRed() / 255.0F, (float)var5.getGreen() / 255.0F, (float)var5.getBlue() / 255.0F, (float)var5.getAlpha() / 255.0F);
      c93734.c30180("color2", (float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      c93734.c30180("color3", (float)var7.getRed() / 255.0F, (float)var7.getGreen() / 255.0F, (float)var7.getBlue() / 255.0F, (float)var7.getAlpha() / 255.0F);
      c93734.c30180("color4", (float)var8.getRed() / 255.0F, (float)var8.getGreen() / 255.0F, (float)var8.getBlue() / 255.0F, (float)var8.getAlpha() / 255.0F);
      ShaderA.c47219(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var3 + 2.0F);
      c93734.c2875();
      GlStateManager.disableBlend();
   }

   public static void c80483(float var0, float var1, float var2, float var3, float var4, boolean var5, Color var6) {
      Value.c27574();
      GlStateManager.resetColor();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      c77888.c78750();
      c63963(var0, var1, var2, var3, var4, c77888);
      c77888.c95251("blur", var5 ? 1 : 0);
      c77888.c30180("color", (float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      ShaderA.c47219(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var3 + 2.0F);
      c77888.c2875();
      GlStateManager.disableBlend();
   }

   public static void c88870(float var0, float var1, float var2, Color var3) {
      GlStateManager.resetColor();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      c77888.c78750();
      c63963(var0, var1, var2, var2, var2 / 2.0F - 0.25F, c77888);
      c77888.c30180("color", (float)var3.getRed() / 255.0F, (float)var3.getGreen() / 255.0F, (float)var3.getBlue() / 255.0F, (float)var3.getAlpha() / 255.0F);
      ShaderA.c47219(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var2 + 2.0F);
      c77888.c2875();
      GlStateManager.disableBlend();
   }

   public static void c93129(float var0, float var1, float var2, float var3, float var4, float var5, Color var6, Color var7) {
      GlStateManager.resetColor();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      c34405.c78750();
      ScaledResolution var8 = new ScaledResolution(Minecraft.getMinecraft());
      c63963(var0, var1, var2, var3, var4, c34405);
      c34405.c30180("outlineThickness", var5 * (float)var8.getScaleFactor());
      c34405.c30180("color", (float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      c34405.c30180("outlineColor", (float)var7.getRed() / 255.0F, (float)var7.getGreen() / 255.0F, (float)var7.getBlue() / 255.0F, (float)var7.getAlpha() / 255.0F);
      ShaderA.c47219(var0 - (2.0F + var5), var1 - (2.0F + var5), var2 + 4.0F + var5 * 2.0F, var3 + 4.0F + var5 * 2.0F);
      c34405.c2875();
      GlStateManager.disableBlend();
   }

   public static void c42318(float var0, float var1, float var2, float var3, float var4, float var5) {
      GlStateManager.resetColor();
      c99477.c78750();
      c99477.c95251("textureIn", 0);
      c63963(var0, var1, var2, var3, var4, c99477);
      c99477.c30180("alpha", var5);
      ShaderA.c47219(var0 - 1.0F, var1 - 1.0F, var2 + 2.0F, var3 + 2.0F);
      c99477.c2875();
      GlStateManager.disableBlend();
   }

   private static void c63963(float var0, float var1, float var2, float var3, float var4, ShaderA var5) {
      ScaledResolution var6 = new ScaledResolution(Minecraft.getMinecraft());
      var5.c30180("location", var0 * (float)var6.getScaleFactor(), (float)Minecraft.getMinecraft().displayHeight - var3 * (float)var6.getScaleFactor() - var1 * (float)var6.getScaleFactor());
      var5.c30180("rectSize", var2 * (float)var6.getScaleFactor(), var3 * (float)var6.getScaleFactor());
      var5.c30180("radius", var4 * (float)var6.getScaleFactor());
   }

   private static JSONException c91562(JSONException var0) {
      return var0;
   }
}
