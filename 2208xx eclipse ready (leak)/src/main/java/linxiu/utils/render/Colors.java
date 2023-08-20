package linxiu.utils.render;

import net.minecraft.util.MathHelper;

import java.awt.*;

public class Colors {
   public static int getColor(Color color) {
      return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
   }

   public static int getColor(int brightness) {
      return getColor(brightness, brightness, brightness, 255);
   }

   public static int getColor(int brightness, int alpha) {
      return getColor(brightness, brightness, brightness, alpha);
   }

   public static int getColor(int red, int green, int blue) {
      return getColor(red, green, blue, 255);
   }

   public static int getColor(int red, int green, int blue, int alpha) {
      int color = MathHelper.clamp_int(alpha, 0, 255) << 24;
      color |= MathHelper.clamp_int(red, 0, 255) << 16;
      color |= MathHelper.clamp_int(green, 0, 255) << 8;
      color |= MathHelper.clamp_int(blue, 0, 255);
      return color;
   }

    public static int getHealthColor(float health, float maxHealth) {
		float percentage = health / maxHealth;
		if (percentage >= 0.75F) {
			return new Color(50, 255, 100, 125).getRGB();
		} else if (percentage < 0.75 && percentage >= 0.35) {
			return new Color(255, 255, 120, 125).getRGB();
		} else {
			return new Color(255, 20, 20, 125).getRGB();
		}
	}
}
