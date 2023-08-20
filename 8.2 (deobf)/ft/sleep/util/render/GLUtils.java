//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import ft.sleep.util.angle.Vec3f;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

public class GLUtils {
   public static FloatBuffer leaving$ = BufferUtils.createFloatBuffer(16);
   public static FloatBuffer version$ = BufferUtils.createFloatBuffer(16);
   public static IntBuffer bride$ = BufferUtils.createIntBuffer(16);
   public static FloatBuffer impose$ = BufferUtils.createFloatBuffer(3);
   public static FloatBuffer postage$ = BufferUtils.createFloatBuffer(3);

   public static void _shake() {
   }

   public static float[] _suggest(int omevefus) {
      return new float[]{(float)(omevefus >> 16 & 255) / 255.0F, (float)(omevefus >> 8 & 255) / 255.0F, (float)(omevefus & 255) / 255.0F, (float)(omevefus >> 24 & 255) / 255.0F};
   }

   public static void _agenda(int gloves) {
      Object defined = _suggest((int)gloves);
      GlStateManager.color(defined[0], defined[1], defined[2], defined[3]);
   }

   public static void _these(float azasopan, double uzuzopud, double denigoro, double var5) {
      GlStateManager.translate((double)uzuzopud, (double)denigoro, var5);
      GlStateManager.rotate((float)azasopan, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GlStateManager.translate((double)(-uzuzopud), (double)(-denigoro), -var5);
   }

   public static void _bufing(float driver, double miami, double belong, double var5) {
      GlStateManager.translate((double)miami, (double)belong, var5);
      GlStateManager.rotate((float)driver, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.translate((double)(-miami), (double)(-belong), -var5);
   }

   public static void _anybody(float ezapuvof, double avavefal, double uzosobav, double var5) {
      GlStateManager.translate((double)avavefal, (double)uzosobav, var5);
      GlStateManager.rotate((float)ezapuvof, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      GlStateManager.translate((double)(-avavefal), (double)(-uzosobav), -var5);
   }

   public static Vec3f _friendly(Vec3f elumituz) {
      return _roster(((Vec3f)elumituz)._lawrence(), ((Vec3f)elumituz)._pursue(), ((Vec3f)elumituz)._paypal());
   }

   public static Vec3f _roster(double odirigez, double ozipafav, double var4) {
      boolean var6 = GLU.gluProject((float)odirigez, (float)ozipafav, (float)var4, leaving$, version$, bride$, (FloatBuffer)impose$.clear());
      return var6 ? new Vec3f((double)impose$.get(0), (double)((float)Display.getHeight() - impose$.get(1)), (double)impose$.get(2)) : null;
   }

   public static Vec3f _virtue(Vec3f ipafuguv) {
      return _streams(((Vec3f)ipafuguv)._lawrence(), ((Vec3f)ipafuguv)._pursue(), ((Vec3f)ipafuguv)._paypal());
   }

   public static Vec3f _streams(double ulosufit, double aveyosal, double var4) {
      boolean var6 = GLU.gluUnProject((float)ulosufit, (float)aveyosal, (float)var4, leaving$, version$, bride$, (FloatBuffer)postage$.clear());
      return var6 ? new Vec3f((double)postage$.get(0), (double)postage$.get(1), (double)postage$.get(2)) : null;
   }

   public static FloatBuffer _means() {
      return leaving$;
   }

   public static FloatBuffer _longer() {
      return version$;
   }

   public static IntBuffer _logos() {
      return bride$;
   }
}
