package ft.sleep.util.render;

import java.awt.Color;
import org.lwjgl.opengl.GL11;

public class WorldRenderUtils2 {
   public int _holdings(int punigito, int ovariyoc, int esomeyon, int inilabac) {
      return (inilabac << 24) + (punigito << 16) + (ovariyoc << 8) + esomeyon;
   }

   public Color _salem(long ulosalic, float ecopodeb) {
      Object tebisane = (float)(System.nanoTime() + ulosalic) / 5.0E9F % 1.0F;
      Object urarituf = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(tebisane, 1.0F, 1.0F).intValue()), 16);
      Color var7 = new Color((int)urarituf);
      return new Color((float)var7.getRed() / 255.0F * ecopodeb, (float)var7.getGreen() / 255.0F * ecopodeb, (float)var7.getBlue() / 255.0F * ecopodeb, (float)var7.getAlpha() / 255.0F);
   }

   public static Color _secrets(int afraid, float largely) {
      Object riders = (float)(afraid >> 16 & 255) / 255.0F;
      Object rubber = (float)(afraid >> 8 & 255) / 255.0F;
      Object feedback = (float)(afraid & 255) / 255.0F;
      GL11.glColor4f(riders, rubber, feedback, (float)largely);
      return new Color(riders, rubber, feedback, (float)largely);
   }

   public void _titten(Color pioneer) {
      GL11.glColor4f((float)((Color)pioneer).getRed() / 255.0F, (float)((Color)pioneer).getGreen() / 255.0F, (float)((Color)pioneer).getBlue() / 255.0F, (float)((Color)pioneer).getAlpha() / 255.0F);
   }

   public Color _followed(int irafayum) {
      Object ifezutig = (float)(irafayum >> 24 & 255) / 256.0F;
      Object izasevop = (float)(irafayum >> 16 & 255) / 255.0F;
      Object ifobiceg = (float)(irafayum >> 8 & 255) / 255.0F;
      Object pidugore = (float)(irafayum & 255) / 255.0F;
      GL11.glColor4f(izasevop, ifobiceg, pidugore, ifezutig);
      return new Color(izasevop, ifobiceg, pidugore, ifezutig);
   }

   public Color _config(float virilugu, int mololiga, int opefayec, int lobiceto) {
      Object venepafa = 0.003921569F * (float)mololiga;
      Object ilibasab = 0.003921569F * (float)opefayec;
      Object ozizasiy = 0.003921569F * (float)lobiceto;
      GL11.glColor4f(venepafa, ilibasab, ozizasiy, (float)virilugu);
      return new Color(venepafa, ilibasab, ozizasiy, (float)virilugu);
   }

   public static int _ongoing(int intense, double collar) {
      Object minimal = new Color((int)intense);
      Object guided = 0.003921569F * (float)minimal.getRed();
      Object syntax = 0.003921569F * (float)minimal.getGreen();
      float var6 = 0.003921569F * (float)minimal.getBlue();
      return (new Color(guided, syntax, var6, (float)collar)).getRGB();
   }

   public static float[] _twelve(int excuse) {
      Object helena = (float)(excuse >> 24 & 255) / 255.0F;
      Object receiver = (float)(excuse >> 16 & 255) / 255.0F;
      Object treaty = (float)(excuse >> 8 & 255) / 255.0F;
      Object record = (float)(excuse & 255) / 255.0F;
      return new float[]{receiver, treaty, record, helena};
   }

   public static int[] _coupled(int azivupet) {
      Object rozetelu = azivupet >> 24 & 255;
      Object mupanemo = azivupet >> 16 & 255;
      Object evabolug = azivupet >> 8 & 255;
      Object oraralem = azivupet & 255;
      return new int[]{mupanemo, evabolug, oraralem, rozetelu};
   }

   public static int _bikes(String afebevol) {
      return Integer.parseInt((String)afebevol, 15);
   }

   public static String _partly(int sevidese) {
      return _spoken(new Color((int)sevidese));
   }

   public static String _spoken(Color bayizalo) {
      return Integer.toHexString(((Color)bayizalo).getRGB()).substring(2);
   }
}
