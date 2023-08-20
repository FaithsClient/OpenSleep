//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import java.awt.Color;

import ft.sleep.util.color.ColorUtils;
import ft.sleep.util.render.RenderUtil2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GuiRenderUtils {
   public static Minecraft clinical$ = Minecraft.getMinecraft();
   public static float totally$;
   public static float watson$;
   public static float sleeve$;
   public static float scott$;
   public static float kernel$;
   public static boolean exists$;

   public static float[] _instant() {
      return exists$ ? new float[]{totally$, watson$, sleeve$, scott$, kernel$} : new float[]{-1.0F};
   }

   public static void _flour(float wendy, float delayed, float declare, float warrant) {
      Object diabetes = _offshore();
      GL11.glEnable(3089);
      GL11.glScissor((int)(wendy * diabetes), (int)((float)Display.getHeight() - delayed * diabetes), (int)(declare * diabetes), (int)(warrant * diabetes));
      exists$ = true;
      totally$ = (float)wendy;
      watson$ = (float)delayed;
      sleeve$ = (float)declare;
      scott$ = (float)warrant;
      kernel$ = diabetes;
   }

   public static void _paying(float uvotogac, float azopivus, float iyamagod, float sazofetu) {
      Object lapibage = _offshore();
      GL11.glEnable(3089);
      GL11.glScissor((int)(uvotogac * lapibage), (int)((float)Display.getHeight() - azopivus * lapibage), (int)(iyamagod * lapibage), (int)(sazofetu * lapibage));
      exists$ = true;
      totally$ = (float)uvotogac;
      watson$ = (float)azopivus;
      sleeve$ = (float)iyamagod;
      scott$ = (float)sazofetu;
      kernel$ = lapibage;
   }

   public static void _launches(float units, float handed, float estimate, float reality, float adoption) {
      GL11.glEnable(3089);
      GL11.glScissor((int)(units * adoption), (int)((float)Display.getHeight() - handed * adoption), (int)(estimate * adoption), (int)(reality * adoption));
      exists$ = true;
      totally$ = (float)units;
      watson$ = (float)handed;
      sleeve$ = (float)estimate;
      scott$ = (float)reality;
      kernel$ = (float)adoption;
   }

   public static void _profile() {
      GL11.glDisable(3089);
      exists$ = false;
   }

   public static void _shades(int supreme, int nowhere, float pushing, float topic, float involve) {
      int footage;
      for(footage = 1; (float)footage < involve && clinical$.displayWidth / (footage + 1) >= 320 && clinical$.displayHeight / (footage + 1) >= 240; ++footage) {
         ;
      }

      GL11.glScissor(supreme * footage, (int)((float)clinical$.displayHeight - ((float)nowhere + topic) * (float)footage), (int)(pushing * (float)footage), (int)(topic * (float)footage));
   }

   public static void _morgan(double penosete, double vulelemo, double uzerogud, double efosunab, double var8, double var10, int var12) {
      _fastest((double)penosete, (double)vulelemo, (double)uzerogud, (double)efosunab, var8, var10, var12, true);
   }

   public static void _fastest(double library, double develops, double earth, double shape, double var8, double var10, int var12, boolean var13) {
      _humor(var13);
      _zealand(var12);
      GL11.glBegin(1);
      GL11.glVertex3d((double)library, (double)develops, (double)earth);
      GL11.glVertex3d((double)shape, var8, var10);
      GL11.glEnd();
      _consumer(var13);
   }

   public static void _latitude(double handmade, double rebecca, double pitch, double var6, float var8, int var9) {
      _musician();
      _zealand(var9);
      GL11.glLineWidth(var8);
      GL11.glBegin(1);
      GL11.glVertex2d((double)handmade, (double)rebecca);
      GL11.glVertex2d((double)pitch, var6);
      GL11.glEnd();
      _clause();
   }

   public static void _carried(int viruses, int moses, float measures, int marvel) {
      _musician();
      _zealand((int)marvel);
      GL11.glPointSize((float)measures);
      GL11.glEnable(2832);
      GL11.glBegin(0);
      GL11.glVertex2d((double)viruses, (double)moses);
      GL11.glEnd();
      GL11.glDisable(2832);
      _clause();
   }

   public static float _offshore() {
      Object vanedili = new ScaledResolution(clinical$);
      return (float)vanedili.getScaleFactor();
   }

   public static void _stayed(AxisAlignedBB uroyoyul, int sezuyosu) {
      _yourself((AxisAlignedBB)uroyoyul, (int)sezuyosu, true);
   }

   public static void _yourself(AxisAlignedBB station, int dealt, boolean lovers) {
      if (station != null) {
         _humor((boolean)lovers);
         _zealand((int)dealt);
         GL11.glBegin(3);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).minZ);
         GL11.glEnd();
         GL11.glBegin(3);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).minZ);
         GL11.glEnd();
         GL11.glBegin(1);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).minZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)station).maxX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).minY, ((AxisAlignedBB)station).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)station).minX, ((AxisAlignedBB)station).maxY, ((AxisAlignedBB)station).maxZ);
         GL11.glEnd();
         _consumer((boolean)lovers);
      }

   }

   public static void _nearby(AxisAlignedBB dibedazo, int sefipoli) {
      _modeling((AxisAlignedBB)dibedazo, (int)sefipoli, true);
   }

   public static void _modeling(AxisAlignedBB mimiralo, int adibison, boolean fudalanu) {
      if (mimiralo != null) {
         _humor((boolean)fudalanu);
         _zealand((int)adibison);
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).maxY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).minZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).minX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)mimiralo).maxX, ((AxisAlignedBB)mimiralo).minY, ((AxisAlignedBB)mimiralo).maxZ);
         GL11.glEnd();
         _consumer((boolean)fudalanu);
      }

   }

   public static void _humor(boolean costume) {
      if (costume) {
         GL11.glDepthMask(false);
         GL11.glDisable(2929);
      }

      GL11.glDisable(3008);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glLineWidth(1.0F);
   }

   public static void _consumer(boolean zoyugogo) {
      if (zoyugogo) {
         GL11.glDepthMask(true);
         GL11.glEnable(2929);
      }

      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(3008);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _musician() {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
   }

   public static void _clause() {
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static void _zealand(int iyicebiv) {
      Object aricasav = (float)(iyicebiv >> 24 & 255) / 255.0F;
      Object erurizor = (float)(iyicebiv >> 16 & 255) / 255.0F;
      Object oriyodef = (float)(iyicebiv >> 8 & 255) / 255.0F;
      Object isarulud = (float)(iyicebiv & 255) / 255.0F;
      GL11.glColor4f(erurizor, oriyodef, isarulud, aricasav);
   }

   public static void _feelings(float balumasi, float upulazov, float ceyeyase, float orafezos, float olovilet, Color ubedomoc, Color bedodute) {
      _frequent((float)balumasi, (float)upulazov, (float)ceyeyase, (float)orafezos, (float)olovilet, ((Color)ubedomoc).getRGB(), ((Color)bedodute).getRGB());
   }

   public static void _frequent(float praise, float hansen, float imposed, float reasons, float ports, int ethics, int puzzle) {
      _pamela((float)(praise + ports), (float)(hansen + ports), imposed - ports * 2.0F, reasons - ports * 2.0F, (int)ethics);
      _pamela((float)praise, (float)hansen, (float)imposed, (float)ports, (int)puzzle);
      _pamela((float)praise, (float)(hansen + ports), (float)ports, (float)(reasons - ports), (int)puzzle);
      _pamela((float)(praise + imposed - ports), (float)(hansen + ports), (float)ports, (float)(reasons - ports), (int)puzzle);
      _pamela((float)(praise + ports), (float)(hansen + reasons - ports), imposed - ports * 2.0F, (float)ports, (int)puzzle);
   }

   public static void _scary(float icotegul, float tumeforo, float forafiya, float buboluzi, float riromepo, int ibetisel) {
      _pamela((float)(icotegul + riromepo), (float)(tumeforo + riromepo), forafiya - riromepo * 2.0F, (float)riromepo, (int)ibetisel);
      _pamela((float)icotegul, (float)(tumeforo + riromepo), (float)riromepo, (float)(buboluzi - riromepo), (int)ibetisel);
      _pamela((float)(icotegul + forafiya - riromepo), (float)(tumeforo + riromepo), (float)riromepo, (float)(buboluzi - riromepo), (int)ibetisel);
      _pamela((float)(icotegul + riromepo), (float)(tumeforo + buboluzi - riromepo), forafiya - riromepo * 2.0F, (float)riromepo, (int)ibetisel);
   }

   public static void _assured(float ulepayuz, float duzivuna, float yepiripi, float afatodug, Color sefesuvu) {
      _pamela((float)ulepayuz, (float)duzivuna, (float)yepiripi, (float)afatodug, ((Color)sefesuvu).getRGB());
   }

   public static void _pamela(float atinanaz, float duserize, float oyobadav, float eyurotub, int etepiyip) {
      _musician();
      _zealand((int)etepiyip);
      GL11.glBegin(7);
      GL11.glVertex2d((double)atinanaz, (double)duserize);
      GL11.glVertex2d((double)(atinanaz + oyobadav), (double)duserize);
      GL11.glVertex2d((double)(atinanaz + oyobadav), (double)(duserize + eyurotub));
      GL11.glVertex2d((double)atinanaz, (double)(duserize + eyurotub));
      GL11.glEnd();
      _clause();
   }

   public static int _truth() {
      Object vavoneco = new ScaledResolution(clinical$);
      Object omugugif = vavoneco.getScaledWidth();
      return omugugif;
   }

   public static int _studied() {
      Object chester = new ScaledResolution(clinical$);
      Object murray = chester.getScaledHeight();
      return murray;
   }

   public static void _laura(float properly, float lexus, float permits, float cooper, int behind) {
      _musician();
      _zealand((int)behind);
      GL11.glLineWidth((float)cooper);
      Object carriers = (int)Math.min(Math.max((float)permits, 45.0F), 360.0F);
      GL11.glBegin(2);

      for(Object eminem = 0; eminem < carriers; ++eminem) {
         Object author = 6.283185307179586D * (double)eminem / (double)carriers;
         GL11.glVertex2d((double)properly + Math.sin(author) * (double)permits, (double)lexus + Math.cos(author) * (double)permits);
      }

      GL11.glEnd();
      _clause();
   }

   public static void _terms(float jeans, float origin, float equipped, int accessed) {
      _musician();
      _zealand((int)accessed);
      Object replace = (int)Math.min(Math.max((float)equipped, 45.0F), 360.0F);
      GL11.glBegin(9);

      for(Object science = 0; science < replace; ++science) {
         Object monsters = 6.283185307179586D * (double)science / (double)replace;
         GL11.glVertex2d((double)jeans + Math.sin(monsters) * (double)equipped, (double)origin + Math.cos(monsters) * (double)equipped);
      }

      GL11.glEnd();
      _clause();
      _laura((float)jeans, (float)origin, (float)equipped, 1.5F, 16777215);
   }

   public static void _colin(float yubazoce, float vulobugu, float radefabo, int fopotosa) {
      _musician();
      _zealand((int)fopotosa);
      Object uvalolup = (int)Math.min(Math.max((float)radefabo, 45.0F), 360.0F);
      GL11.glBegin(9);

      for(Object osebipef = 0; osebipef < uvalolup; ++osebipef) {
         Object enepomab = 6.283185307179586D * (double)osebipef / (double)uvalolup;
         GL11.glVertex2d((double)yubazoce + Math.sin(enepomab) * (double)radefabo, (double)vulobugu + Math.cos(enepomab) * (double)radefabo);
      }

      GL11.glEnd();
      _clause();
   }

   public static int _statutes(int lizorocu, int eriyamip) {
      Object tepucuce = (float)(lizorocu >> 24 & 255);
      Object ucurezay = Math.max((float)(lizorocu >> 16 & 255) - (float)(lizorocu >> 16 & 255) / (100.0F / (float)eriyamip), Float.intBitsToFloat(0));
      Object anelelos = Math.max((float)(lizorocu >> 8 & 255) - (float)(lizorocu >> 8 & 255) / (100.0F / (float)eriyamip), Float.intBitsToFloat(0));
      Object asarelor = Math.max((float)(lizorocu & 255) - (float)(lizorocu & 255) / (100.0F / (float)eriyamip), Float.intBitsToFloat(0));
      return (int)((float)(((int)tepucuce << 24) + ((int)ucurezay << 16) + ((int)anelelos << 8)) + asarelor);
   }

   public static int _writer(int affected, int lasting) {
      Object springs = Math.max((float)(affected >> 24 & 255) - (float)(affected >> 24 & 255) / (100.0F / (float)lasting), Float.intBitsToFloat(0));
      Object parking = (float)(affected >> 16 & 255);
      Object tagged = (float)(affected >> 8 & 255);
      Object proud = (float)(affected & 255);
      return (int)((float)(((int)springs << 24) + ((int)parking << 16) + ((int)tagged << 8)) + proud);
   }

   public static void _victoria(float premier, float nervous, float filed, float ensures, float assumes, int ending, float instead, int romantic) {
      if (ending == 16777215) {
         ending = ColorUtils.liquid$.hygiene$;
      }

      if (romantic == 16777215) {
         romantic = ColorUtils.liquid$.hygiene$;
      }

      if (assumes < Float.intBitsToFloat(0)) {
         assumes = Float.intBitsToFloat(0);
      }

      if (assumes > filed / 2.0F) {
         assumes = filed / 2.0F;
      }

      if (assumes > ensures / 2.0F) {
         assumes = ensures / 2.0F;
      }

      _pamela((float)(premier + assumes), (float)(nervous + assumes), filed - assumes * 2.0F, ensures - assumes * 2.0F, (int)ending);
      _pamela((float)(premier + assumes), (float)nervous, filed - assumes * 2.0F, (float)assumes, (int)ending);
      _pamela((float)(premier + assumes), (float)(nervous + ensures - assumes), filed - assumes * 2.0F, (float)assumes, (int)ending);
      _pamela((float)premier, (float)(nervous + assumes), (float)assumes, ensures - assumes * 2.0F, (int)ending);
      _pamela((float)(premier + filed - assumes), (float)(nervous + assumes), (float)assumes, ensures - assumes * 2.0F, (int)ending);
      _musician();
      RenderUtil2._flowers((int)ending);
      GL11.glBegin(6);
      Object calcium = (float)(premier + assumes);
      Object films = (float)(nervous + assumes);
      GL11.glVertex2d((double)calcium, (double)films);
      Object fountain = (int)Math.min(Math.max((float)assumes, 10.0F), 90.0F);

      for(Object picture = 0; picture < fountain + 1; ++picture) {
         Object awesome = 6.283185307179586D * (double)(picture + 180) / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(awesome) * (double)assumes, (double)films + Math.cos(awesome) * (double)assumes);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      calcium = (float)(premier + filed - assumes);
      films = (float)(nervous + assumes);
      GL11.glVertex2d((double)calcium, (double)films);
      fountain = (int)Math.min(Math.max((float)assumes, 10.0F), 90.0F);

      for(Object var32 = 0; var32 < fountain + 1; ++var32) {
         Object var39 = 6.283185307179586D * (double)(var32 + 90) / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(var39) * (double)assumes, (double)films + Math.cos(var39) * (double)assumes);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      calcium = (float)(premier + assumes);
      films = (float)(nervous + ensures - assumes);
      GL11.glVertex2d((double)calcium, (double)films);
      fountain = (int)Math.min(Math.max((float)assumes, 10.0F), 90.0F);

      for(Object var33 = 0; var33 < fountain + 1; ++var33) {
         Object var40 = 6.283185307179586D * (double)(var33 + 270) / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(var40) * (double)assumes, (double)films + Math.cos(var40) * (double)assumes);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      calcium = (float)(premier + filed - assumes);
      films = (float)(nervous + ensures - assumes);
      GL11.glVertex2d((double)calcium, (double)films);
      fountain = (int)Math.min(Math.max((float)assumes, 10.0F), 90.0F);

      for(Object var34 = 0; var34 < fountain + 1; ++var34) {
         Object var41 = 6.283185307179586D * (double)var34 / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(var41) * (double)assumes, (double)films + Math.cos(var41) * (double)assumes);
      }

      GL11.glEnd();
      RenderUtil2._flowers((int)romantic);
      GL11.glLineWidth((float)instead);
      GL11.glBegin(3);
      calcium = (float)(premier + assumes);
      films = (float)(nervous + assumes);
      fountain = (int)Math.min(Math.max((float)assumes, 10.0F), 90.0F);

      for(Object var35 = fountain; var35 >= 0; --var35) {
         Object var42 = 6.283185307179586D * (double)(var35 + 180) / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(var42) * (double)assumes, (double)films + Math.cos(var42) * (double)assumes);
      }

      GL11.glVertex2d((double)(premier + assumes), (double)nervous);
      GL11.glVertex2d((double)(premier + filed - assumes), (double)nervous);
      calcium = (float)(premier + filed - assumes);
      films = (float)(nervous + assumes);

      for(Object var36 = fountain; var36 >= 0; --var36) {
         Object var43 = 6.283185307179586D * (double)(var36 + 90) / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(var43) * (double)assumes, (double)films + Math.cos(var43) * (double)assumes);
      }

      GL11.glVertex2d((double)(premier + filed), (double)(nervous + assumes));
      GL11.glVertex2d((double)(premier + filed), (double)(nervous + ensures - assumes));
      calcium = (float)(premier + filed - assumes);
      films = (float)(nervous + ensures - assumes);

      for(Object var37 = fountain; var37 >= 0; --var37) {
         Object var44 = 6.283185307179586D * (double)var37 / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(var44) * (double)assumes, (double)films + Math.cos(var44) * (double)assumes);
      }

      GL11.glVertex2d((double)(premier + filed - assumes), (double)(nervous + ensures));
      GL11.glVertex2d((double)(premier + assumes), (double)(nervous + ensures));
      calcium = (float)(premier + assumes);
      films = (float)(nervous + ensures - assumes);

      for(Object var38 = fountain; var38 >= 0; --var38) {
         Object var45 = 6.283185307179586D * (double)(var38 + 270) / (double)(fountain * 4);
         GL11.glVertex2d((double)calcium + Math.sin(var45) * (double)assumes, (double)films + Math.cos(var45) * (double)assumes);
      }

      GL11.glVertex2d((double)premier, (double)(nervous + ensures - assumes));
      GL11.glVertex2d((double)premier, (double)(nervous + assumes));
      GL11.glEnd();
      _clause();
   }
}
