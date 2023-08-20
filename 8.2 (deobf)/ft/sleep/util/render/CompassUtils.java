//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

public class CompassUtils {
   public Minecraft counts$;
   public FontRenderer amount$;
   public int canadian$ = 2;
   public int seminar$ = 0;
   public int meals$ = 150;
   public int diamond$ = 20;
   public int indexes$ = 500;
   public int carriers$ = 0;
   public int wheels$ = 0;
   public int yahoo$;
   public int hansen$;
   public int pensions$;

   public CompassUtils(Minecraft dumurudo) {
      runonovu.counts$ = (Minecraft)dumurudo;
      runonovu.amount$ = ((Minecraft)dumurudo).fontRendererObj;
   }

   public void _beaches(int opelagas) {
      Object lizunufu = minetozo._analysis((int)minetozo.counts$.thePlayer.rotationYaw);
      minetozo.yahoo$ = minetozo.indexes$ * lizunufu / 360;
      minetozo.hansen$ = opelagas / 2;
      Gui.drawRect(minetozo.hansen$ - minetozo.meals$ / 2, minetozo.seminar$, minetozo.hansen$ + minetozo.meals$ / 2, minetozo.seminar$ + minetozo.diamond$, (new Color(0, 0, 0, 70)).getRGB());
      new ScaledResolution(minetozo.counts$);
      if (minetozo.wheels$ != 0) {
         minetozo.pensions$ = Color.HSBtoRGB((float)minetozo.wheels$ / 100.0F, 1.0F, 1.0F);
      } else {
         minetozo.pensions$ = -1;
      }

      if (minetozo.canadian$ >= 0) {
         minetozo._pierce("S", 0, 1.5D);
         minetozo._pierce("W", 90, 1.5D);
         minetozo._pierce("N", 180, 1.5D);
         minetozo._pierce("E", 270, 1.5D);
      }

      if (minetozo.canadian$ >= 1) {
         minetozo._pierce("SW", 45, 1.0D);
         minetozo._pierce("NW", 135, 1.0D);
         minetozo._pierce("NE", 225, 1.0D);
         minetozo._pierce("SE", 315, 1.0D);
      }

      if (minetozo.canadian$ >= 2) {
         minetozo._pierce("15", 15, 0.75D);
         minetozo._pierce("30", 30, 0.75D);
         minetozo._pierce("60", 60, 0.75D);
         minetozo._pierce("75", 75, 0.75D);
         minetozo._pierce("105", 105, 0.75D);
         minetozo._pierce("120", 120, 0.75D);
         minetozo._pierce("150", 150, 0.75D);
         minetozo._pierce("165", 165, 0.75D);
         minetozo._pierce("195", 195, 0.75D);
         minetozo._pierce("210", 210, 0.75D);
         minetozo._pierce("240", 240, 0.75D);
         minetozo._pierce("255", 255, 0.75D);
         minetozo._pierce("285", 285, 0.75D);
         minetozo._pierce("300", 300, 0.75D);
         minetozo._pierce("330", 330, 0.75D);
         minetozo._pierce("345", 345, 0.75D);
      }

   }

   public void _pierce(String cacududi, int ediragop, double ayubaruc) {
      Object zibufero = gocifima.indexes$ * ediragop / 360 - gocifima.yahoo$;
      if (zibufero > gocifima.indexes$ / 2) {
         zibufero -= gocifima.indexes$;
      }

      if (zibufero < -gocifima.indexes$ / 2) {
         zibufero += gocifima.indexes$;
      }

      Object pibitisa = 1.0D - (double)Math.abs(zibufero) / ((double)gocifima.meals$ / 2.0D);
      if (pibitisa > 0.1D) {
         Object garepade = gocifima.pensions$ & 16777215;
         Object osabafip = garepade | (int)(pibitisa * 255.0D) << 24;
         int var10 = gocifima.hansen$ + zibufero - (int)((double)gocifima.amount$.getStringWidth((String)cacududi) * ayubaruc / 2.0D);
         int var11 = gocifima.seminar$ + gocifima.diamond$ / 2 - (int)((double)gocifima.amount$.FONT_HEIGHT * ayubaruc / 2.0D);
         GL11.glEnable(3042);
         GL11.glPushMatrix();
         GL11.glTranslated((double)(-var10) * (ayubaruc - 1.0D), (double)(-var11) * (ayubaruc - 1.0D), Double.longBitsToDouble(0L));
         GL11.glScaled((double)ayubaruc, (double)ayubaruc, 1.0D);
         gocifima.amount$.drawStringWithShadow((String)cacududi, (float)var10, (float)var11, osabafip);
         GL11.glPopMatrix();
         GL11.glDisable(3042);
      }

   }

   public int _analysis(int pazuseci) {
      if (pazuseci > 360) {
         pazuseci %= 360;
      }

      while(pazuseci < 0) {
         pazuseci += 360;
      }

      return (int)pazuseci;
   }
}
