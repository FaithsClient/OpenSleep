//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.color;

import java.awt.Color;
import net.minecraft.util.MathHelper;

public class Colors {
   public static int _vitamins(Color branch) {
      return _nickname(((Color)branch).getRed(), ((Color)branch).getGreen(), ((Color)branch).getBlue(), ((Color)branch).getAlpha());
   }

   public static int _coleman(int minor) {
      return _nickname((int)minor, (int)minor, (int)minor, 255);
   }

   public static int _jeffrey(int ufesiliz, int otabidab) {
      return _nickname((int)ufesiliz, (int)ufesiliz, (int)ufesiliz, (int)otabidab);
   }

   public static int _smilies(int deadline, int ranch, int promises) {
      return _nickname((int)deadline, (int)ranch, (int)promises, 255);
   }

   public static int _nickname(int durifeni, int igesufaz, int gapiraru, int doyozuti) {
      Object yidupaci = MathHelper.clamp_int((int)doyozuti, 0, 255) << 24;
      yidupaci = yidupaci | MathHelper.clamp_int((int)durifeni, 0, 255) << 16;
      yidupaci = yidupaci | MathHelper.clamp_int((int)igesufaz, 0, 255) << 8;
      yidupaci = yidupaci | MathHelper.clamp_int((int)gapiraru, 0, 255);
      return yidupaci;
   }

   public static int _venture(float wrong, float nissan) {
      Object penguin = (float)(wrong / nissan);
      if (penguin >= 0.75F) {
         return (new Color(0, 225, 0, 180)).getRGB();
      } else {
         return (double)penguin < 0.75D && (double)penguin >= 0.35D ? (new Color(255, 255, 120, 125)).getRGB() : (new Color(255, 20, 20, 125)).getRGB();
      }
   }
}
