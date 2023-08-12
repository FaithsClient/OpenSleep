package linxiu.ui.evaly.ClickUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import linxiu.utils.ShaderUtil;

import java.awt.*;

public class RoundedUtil {
	public static ShaderUtil roundedShader = new ShaderUtil("roundedrect");
	private static final ShaderUtil roundedGradientShader = new ShaderUtil("roundedrectgradient");

	public static void drawRound(float x, float y, float width, float height, float radius, Color color) {
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		roundedShader.init();

		setupRoundedRectUniforms(x, y, width, height, radius, roundedShader);
		roundedShader.setUniformf("color", color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f,
				color.getAlpha() / 255f);
		ShaderUtil.drawQuads(x - 1, y - 1, width + 2, height + 2);
		roundedShader.unload();
		GlStateManager.disableBlend();
	}

	private static void setupRoundedRectUniforms(float x, float y, float width, float height, float radius,
			ShaderUtil roundedTexturedShader) {
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		roundedTexturedShader.setUniformf("location", x * sr.getScaleFactor(),
				(Minecraft.getMinecraft().displayHeight - (height * sr.getScaleFactor())) - (y * sr.getScaleFactor()));
		roundedTexturedShader.setUniformf("rectSize", width * sr.getScaleFactor(), height * sr.getScaleFactor());
		roundedTexturedShader.setUniformf("radius", radius * sr.getScaleFactor());
	}

	public static void resetColor() {
		GlStateManager.color(1, 1, 1, 1);
	}

	public static void drawGradientRound(float x, float y, float width, float height, float radius, Color bottomLeft,
			Color topLeft, Color bottomRight, Color topRight) {
		resetColor();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		roundedGradientShader.init();
		setupRoundedRectUniforms(x, y, width, height, radius, roundedGradientShader);
		// Bottom Left
		roundedGradientShader.setUniformf("color1", bottomLeft.getRed() / 255f, bottomLeft.getGreen() / 255f,
				bottomLeft.getBlue() / 255f, bottomLeft.getAlpha() / 255f);
		// Top left
		roundedGradientShader.setUniformf("color2", topLeft.getRed() / 255f, topLeft.getGreen() / 255f,
				topLeft.getBlue() / 255f, topLeft.getAlpha() / 255f);
		// Bottom Right
		roundedGradientShader.setUniformf("color3", bottomRight.getRed() / 255f, bottomRight.getGreen() / 255f,
				bottomRight.getBlue() / 255f, bottomRight.getAlpha() / 255f);
		// Top Right
		roundedGradientShader.setUniformf("color4", topRight.getRed() / 255f, topRight.getGreen() / 255f,
				topRight.getBlue() / 255f, topRight.getAlpha() / 255f);
		ShaderUtil.drawQuads(x - 1, y - 1, width + 2, height + 2);
		roundedGradientShader.unload();
		GlStateManager.disableBlend();
	}

	public static void drawGradientHorizontal(float x, float y, float width, float height, float radius, Color left,
			Color right) {
		drawGradientRound(x, y, width, height, radius, left, left, right, right);
	}

}
