//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

public class RenderUtil3 {
   public static void _analog() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void _flexible() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void _harmony(float zuyosozu, float pemibeda, float esotovoc, float adogupip, int utuvilif, int emalanig) {
      _analog();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      float var6;
      float var7;
      float var9;
      _advance(var6 = zuyosozu * 2.0F, (var7 = pemibeda * 2.0F) + 1.0F, (var9 = adogupip * 2.0F) - 2.0F, (int)utuvilif);
      float var8;
      _advance((var8 = esotovoc * 2.0F) - 1.0F, var7 + 1.0F, var9 - 2.0F, (int)utuvilif);
      _seeds(var6 + 2.0F, var8 - 3.0F, var7, (int)utuvilif);
      _seeds(var6 + 2.0F, var8 - 3.0F, var9 - 1.0F, (int)utuvilif);
      _seeds(var6 + 1.0F, var6 + 1.0F, var7 + 1.0F, (int)utuvilif);
      _seeds(var8 - 2.0F, var8 - 2.0F, var7 + 1.0F, (int)utuvilif);
      _seeds(var8 - 2.0F, var8 - 2.0F, var9 - 2.0F, (int)utuvilif);
      _seeds(var6 + 1.0F, var6 + 1.0F, var9 - 2.0F, (int)utuvilif);
      _magnetic(var6 + 1.0F, var7 + 1.0F, var8 - 1.0F, var9 - 1.0F, (int)emalanig);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      _flexible();
      Gui.drawRect(0, 0, 0, 0, 0);
   }

   public static void _kinds(double usage, double nasdaq, double springer, double var6, int var8) {
      _analog();
      _welfare(var8);
      _olive((double)usage, (double)nasdaq, (double)springer, var6);
      _flexible();
   }

   public static void _olive(double celoseza, double feparova, double var4, double var6) {
      GL11.glBegin(7);
      GL11.glVertex2d((double)celoseza, var6);
      GL11.glVertex2d(var4, var6);
      GL11.glVertex2d(var4, (double)feparova);
      GL11.glVertex2d((double)celoseza, (double)feparova);
      GL11.glEnd();
   }

   public static void _welfare(int typical) {
      Object farms = (float)(typical >> 24 & 255) / 255.0F;
      Object brick = (float)(typical >> 16 & 255) / 255.0F;
      Object laura = (float)(typical >> 8 & 255) / 255.0F;
      Object modems = (float)(typical & 255) / 255.0F;
      GL11.glColor4f(brick, laura, modems, farms);
   }

   public static void _magnetic(float arranged, float levitra, float excluded, float closer, int nearby) {
      _analog();
      _welfare((int)nearby);
      _campus((float)arranged, (float)levitra, (float)excluded, (float)closer);
      _flexible();
   }

   public static void _style(float nivuyeze, float vepetupe, float elezacic, float yasudego, float yamomomi, int rivurina) {
      _analog();
      _welfare((int)rivurina);
      _campus((float)(nivuyeze + yamomomi), (float)vepetupe, (float)(elezacic - yamomomi), (float)(vepetupe + yamomomi));
      _campus((float)nivuyeze, (float)vepetupe, (float)(nivuyeze + yamomomi), (float)yasudego);
      _campus((float)(elezacic - yamomomi), (float)vepetupe, (float)elezacic, (float)yasudego);
      _campus((float)(nivuyeze + yamomomi), (float)(yasudego - yamomomi), (float)(elezacic - yamomomi), (float)yasudego);
      _flexible();
   }

   public static void _eternal(float project, float dynamics, float printer, float woman, int reset, int hunting) {
      _analog();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      float var6;
      float var7;
      float var9;
      _advance(var6 = project * 2.0F, var7 = dynamics * 2.0F, var9 = woman * 2.0F, (int)hunting);
      float var8;
      _advance((var8 = printer * 2.0F) - 1.0F, var7, var9, (int)hunting);
      _seeds(var6, var8 - 1.0F, var7, (int)hunting);
      _seeds(var6, var8 - 2.0F, var9 - 1.0F, (int)hunting);
      _magnetic(var6 + 1.0F, var7 + 1.0F, var8 - 1.0F, var9 - 1.0F, (int)reset);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      _flexible();
   }

   public static void _steam(float afolebey, float lipelodi, float raregezo, float soyunoge, int pusonito, int zemuboyu) {
      _analog();
      GL11.glShadeModel(7425);
      GL11.glBegin(7);
      _welfare((int)pusonito);
      GL11.glVertex2f((float)afolebey, (float)soyunoge);
      GL11.glVertex2f((float)raregezo, (float)soyunoge);
      _welfare((int)zemuboyu);
      GL11.glVertex2f((float)raregezo, (float)lipelodi);
      GL11.glVertex2f((float)afolebey, (float)lipelodi);
      GL11.glEnd();
      GL11.glShadeModel(7424);
      _flexible();
   }

   public static void _seeds(float piyigifa, float obibinev, float epevepam, int amaluped) {
      if (obibinev < piyigifa) {
         Object cuyidofe = (float)piyigifa;
         piyigifa = obibinev;
         obibinev = cuyidofe;
      }

      _magnetic((float)piyigifa, (float)epevepam, obibinev + 1.0F, epevepam + 1.0F, (int)amaluped);
   }

   public static void _advance(float browsers, float larry, float scale, int mixture) {
      if (scale < larry) {
         Object issued = (float)larry;
         larry = scale;
         scale = issued;
      }

      _magnetic((float)browsers, larry + 1.0F, browsers + 1.0F, (float)scale, (int)mixture);
   }

   public static void _diary(float neyovayo, float izaruguy, float urumiyun, int iyitunuy, int namodovi) {
      if (izaruguy < neyovayo) {
         Object ucepesot = (float)neyovayo;
         neyovayo = izaruguy;
         izaruguy = ucepesot;
      }

      _steam((float)neyovayo, (float)urumiyun, izaruguy + 1.0F, urumiyun + 1.0F, (int)iyitunuy, (int)namodovi);
   }

   public static void _campus(float rasimozu, float onifasud, float ezegesic, float ilonumes) {
      GL11.glBegin(7);
      GL11.glVertex2f((float)rasimozu, (float)ilonumes);
      GL11.glVertex2f((float)ezegesic, (float)ilonumes);
      GL11.glVertex2f((float)ezegesic, (float)onifasud);
      GL11.glVertex2f((float)rasimozu, (float)onifasud);
      GL11.glEnd();
   }
}
