package ft.sleep.util.render;

import org.lwjgl.opengl.GL11;

public class GLColor {
   public static void _gamespot(int rizafumo) {
      Object yeyomate = (float)(rizafumo >> 24 & 255) / 255.0F;
      Object diyoyita = (float)(rizafumo >> 16 & 255) / 255.0F;
      Object icuzevop = (float)(rizafumo >> 8 & 255) / 255.0F;
      Object pofisebo = (float)(rizafumo & 255) / 255.0F;
      GL11.glColor4f(diyoyita, icuzevop, pofisebo, yeyomate);
   }
}
