//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import java.nio.FloatBuffer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class RenderingUtil {
   public static double[] _divine(double festival, double email, double navigate) {
      Object terms = BufferUtils.createFloatBuffer(3);
      Object simple = BufferUtils.createIntBuffer(16);
      FloatBuffer var8 = BufferUtils.createFloatBuffer(16);
      FloatBuffer var9 = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat(2982, var8);
      GL11.glGetFloat(2983, var9);
      GL11.glGetInteger(2978, simple);
      boolean var10 = GLU.gluProject((float)festival, (float)email, (float)navigate, var8, var9, simple, terms);
      return var10 ? new double[]{(double)terms.get(0), (double)((float)Display.getHeight() - terms.get(1)), (double)terms.get(2)} : null;
   }

   public static double[] _maria(double inelepen, double ubuzipod, double cabeduca, AxisAlignedBB vosonoli) {
      Object vegedaba = _divine(((AxisAlignedBB)vosonoli).minX - inelepen, ((AxisAlignedBB)vosonoli).minY - ubuzipod, ((AxisAlignedBB)vosonoli).minZ - cabeduca);
      Object fefumutu = _divine(((AxisAlignedBB)vosonoli).maxX - inelepen, ((AxisAlignedBB)vosonoli).minY - ubuzipod, ((AxisAlignedBB)vosonoli).minZ - cabeduca);
      Object cavegiyi = _divine(((AxisAlignedBB)vosonoli).maxX - inelepen, ((AxisAlignedBB)vosonoli).minY - ubuzipod, ((AxisAlignedBB)vosonoli).maxZ - cabeduca);
      Object ticupeli = _divine(((AxisAlignedBB)vosonoli).minX - inelepen, ((AxisAlignedBB)vosonoli).minY - ubuzipod, ((AxisAlignedBB)vosonoli).maxZ - cabeduca);
      Object evuvusom = _divine(((AxisAlignedBB)vosonoli).minX - inelepen, ((AxisAlignedBB)vosonoli).maxY - ubuzipod, ((AxisAlignedBB)vosonoli).minZ - cabeduca);
      Object edacibug = _divine(((AxisAlignedBB)vosonoli).maxX - inelepen, ((AxisAlignedBB)vosonoli).maxY - ubuzipod, ((AxisAlignedBB)vosonoli).minZ - cabeduca);
      Object vucituyi = _divine(((AxisAlignedBB)vosonoli).maxX - inelepen, ((AxisAlignedBB)vosonoli).maxY - ubuzipod, ((AxisAlignedBB)vosonoli).maxZ - cabeduca);
      Object yapebute = _divine(((AxisAlignedBB)vosonoli).minX - inelepen, ((AxisAlignedBB)vosonoli).maxY - ubuzipod, ((AxisAlignedBB)vosonoli).maxZ - cabeduca);
      Object latugepo = vegedaba[2] > Double.longBitsToDouble(0L) && vegedaba[2] <= 1.0D && fefumutu[2] > Double.longBitsToDouble(0L) && fefumutu[2] <= 1.0D && cavegiyi[2] > Double.longBitsToDouble(0L) && cavegiyi[2] <= 1.0D && ticupeli[2] > Double.longBitsToDouble(0L) && ticupeli[2] <= 1.0D && evuvusom[2] > Double.longBitsToDouble(0L) && evuvusom[2] <= 1.0D && edacibug[2] > Double.longBitsToDouble(0L) && edacibug[2] <= 1.0D && vucituyi[2] > Double.longBitsToDouble(0L) && vucituyi[2] <= 1.0D && yapebute[2] > Double.longBitsToDouble(0L) && yapebute[2] <= 1.0D;
      if (latugepo) {
         return new double[]{-1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D, -1337.0D};
      } else {
         Object uveyegic = vegedaba[0];
         Object rotizuvu = vegedaba[1];
         Object disacena = yapebute[0];
         Object gacupaca = yapebute[1];
         double[] var24 = new double[]{vegedaba[0], fefumutu[0], cavegiyi[0], ticupeli[0], evuvusom[0], edacibug[0], vucituyi[0], yapebute[0]};
         double[] var25 = new double[]{vegedaba[1], fefumutu[1], cavegiyi[1], ticupeli[1], evuvusom[1], edacibug[1], vucituyi[1], yapebute[1]};
         double[] var26 = var24;
         int var27 = var24.length;

         for(int var28 = 0; var28 < var27; ++var28) {
            Double var29 = var26[var28];
            if (var29.doubleValue() < uveyegic) {
               uveyegic = var29.doubleValue();
            }
         }

         var26 = var24;
         var27 = var24.length;

         for(int var36 = 0; var36 < var27; ++var36) {
            Double var39 = var26[var36];
            if (var39.doubleValue() > disacena) {
               disacena = var39.doubleValue();
            }
         }

         var26 = var25;
         var27 = var25.length;

         for(int var37 = 0; var37 < var27; ++var37) {
            Double var40 = var26[var37];
            if (var40.doubleValue() < rotizuvu) {
               rotizuvu = var40.doubleValue();
            }
         }

         var26 = var25;
         var27 = var25.length;

         for(int var38 = 0; var38 < var27; ++var38) {
            Double var41 = var26[var38];
            if (var41.doubleValue() > gacupaca) {
               gacupaca = var41.doubleValue();
            }
         }

         return new double[]{vegedaba[0], vegedaba[1], fefumutu[0], fefumutu[1], cavegiyi[0], cavegiyi[1], ticupeli[0], ticupeli[1], evuvusom[0], evuvusom[1], edacibug[0], edacibug[1], vucituyi[0], vucituyi[1], yapebute[0], yapebute[1], uveyegic, rotizuvu, disacena, gacupaca};
      }
   }

   public static void _products(boolean ludigopu) {
      if (ludigopu) {
         GlStateManager.enableBlend();
         GL11.glEnable(2848);
         GlStateManager.disableDepth();
         GlStateManager.disableTexture2D();
         GlStateManager.blendFunc(770, 771);
         GL11.glHint(3154, 4354);
      } else {
         GlStateManager.disableBlend();
         GlStateManager.enableTexture2D();
         GL11.glDisable(2848);
         GlStateManager.enableDepth();
      }

      GlStateManager.depthMask(!ludigopu);
   }

   public static void _framed(double yovayizu, double lidazomi, double inamasey, double punibega, int isinezup) {
      float var9 = (float)(isinezup >> 24 & 255) / 255.0F;
      float var10 = (float)(isinezup >> 16 & 255) / 255.0F;
      float var11 = (float)(isinezup >> 8 & 255) / 255.0F;
      float var12 = (float)(isinezup & 255) / 255.0F;
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GL11.glPushMatrix();
      GL11.glEnable(2848);
      GL11.glEnable(2881);
      GL11.glEnable(2832);
      GL11.glEnable(3042);
      GL11.glColor4f(var10, var11, var12, var9);
      GL11.glBegin(7);
      GL11.glVertex2d(inamasey + 1.300000011920929D, (double)lidazomi);
      GL11.glVertex2d(yovayizu + 1.0D, (double)lidazomi);
      GL11.glVertex2d(yovayizu - 1.300000011920929D, (double)punibega);
      GL11.glVertex2d(inamasey - 1.0D, (double)punibega);
      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glDisable(2881);
      GL11.glDisable(2832);
      GL11.glDisable(3042);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glPopMatrix();
   }

   public static void _executed(double player, double buyers, double comments, double ranked, int troops, int printed) {
      Object nation = (float)(troops >> 24 & 255) / 255.0F;
      Object lawyers = (float)(troops >> 16 & 255) / 255.0F;
      Object prepared = (float)(troops >> 8 & 255) / 255.0F;
      Object pillow = (float)(troops & 255) / 255.0F;
      float var14 = (float)(printed >> 24 & 255) / 255.0F;
      float var15 = (float)(printed >> 16 & 255) / 255.0F;
      float var16 = (float)(printed >> 8 & 255) / 255.0F;
      float var17 = (float)(printed & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(lawyers, prepared, pillow, nation);
      GL11.glVertex2d((double)comments, (double)buyers);
      GL11.glVertex2d((double)player, (double)buyers);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d((double)player, (double)ranked);
      GL11.glVertex2d((double)comments, (double)ranked);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
   }

   public static void _fruit(double adegediy, double elurebal, double oladumes, double cicabuvo, int avanizin, int samezezi) {
      Object ipiyuyet = (float)(avanizin >> 24 & 255) / 255.0F;
      Object tigudogu = (float)(avanizin >> 16 & 255) / 255.0F;
      Object fubituri = (float)(avanizin >> 8 & 255) / 255.0F;
      Object retereri = (float)(avanizin & 255) / 255.0F;
      float var14 = (float)(samezezi >> 24 & 255) / 255.0F;
      float var15 = (float)(samezezi >> 16 & 255) / 255.0F;
      float var16 = (float)(samezezi >> 8 & 255) / 255.0F;
      float var17 = (float)(samezezi & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(tigudogu, fubituri, retereri, ipiyuyet);
      GL11.glVertex2d((double)adegediy, (double)elurebal);
      GL11.glVertex2d((double)adegediy, (double)cicabuvo);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d((double)oladumes, (double)cicabuvo);
      GL11.glVertex2d((double)oladumes, (double)elurebal);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
   }

   public static void _washer(double hearings, double cadillac, double enjoy, double arrow, int radical) {
      float var9 = (float)(radical >> 24 & 255) / 255.0F;
      float var10 = (float)(radical >> 16 & 255) / 255.0F;
      float var11 = (float)(radical >> 8 & 255) / 255.0F;
      float var12 = (float)(radical & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(var10, var11, var12, var9);
      GL11.glVertex2d((double)hearings, (double)cadillac);
      GL11.glColor4f(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      GL11.glVertex2d((double)hearings, (double)arrow);
      GL11.glColor4f(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      GL11.glVertex2d((double)enjoy, (double)arrow);
      GL11.glColor4f(var10, var11, var12, var9);
      GL11.glVertex2d((double)enjoy, (double)cadillac);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
   }

   public static void _melissa(double alonugob, double ipizemiv, double fugulami, double ororiris, int vezupala) {
      if (alonugob < fugulami) {
         ;
      }

      if (ipizemiv < ororiris) {
         ;
      }

      float var11 = (float)(vezupala >> 24 & 255) / 255.0F;
      float var12 = (float)(vezupala >> 16 & 255) / 255.0F;
      float var13 = (float)(vezupala >> 8 & 255) / 255.0F;
      float var14 = (float)(vezupala & 255) / 255.0F;
      WorldRenderer var15 = Tessellator.getInstance().getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var12, var13, var14, var11);
      Tessellator.getInstance().draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _teachers(double rocopoca, double obuzacuf, double ubefuyib, double omemerac, double var8, int var10, int var11) {
      _melissa(rocopoca + var8, obuzacuf + var8, ubefuyib - var8, omemerac - var8, var10);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _melissa(rocopoca + var8, (double)obuzacuf, ubefuyib - var8, obuzacuf + var8, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _melissa((double)rocopoca, (double)obuzacuf, rocopoca + var8, (double)omemerac, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _melissa(ubefuyib - var8, (double)obuzacuf, (double)ubefuyib, (double)omemerac, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _melissa(rocopoca + var8, omemerac - var8, ubefuyib - var8, (double)omemerac, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _amended(AxisAlignedBB wider) {
      GL11.glPushMatrix();
      GL11.glBegin(2);
      GL11.glVertex3d(((AxisAlignedBB)wider).minX, ((AxisAlignedBB)wider).minY, ((AxisAlignedBB)wider).minZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).minX, ((AxisAlignedBB)wider).maxY, ((AxisAlignedBB)wider).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).maxX, ((AxisAlignedBB)wider).minY, ((AxisAlignedBB)wider).minZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).maxX, ((AxisAlignedBB)wider).maxY, ((AxisAlignedBB)wider).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).maxX, ((AxisAlignedBB)wider).minY, ((AxisAlignedBB)wider).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).minX, ((AxisAlignedBB)wider).maxY, ((AxisAlignedBB)wider).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).maxX, ((AxisAlignedBB)wider).minY, ((AxisAlignedBB)wider).minZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).minX, ((AxisAlignedBB)wider).maxY, ((AxisAlignedBB)wider).minZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).maxX, ((AxisAlignedBB)wider).minY, ((AxisAlignedBB)wider).minZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).minX, ((AxisAlignedBB)wider).minY, ((AxisAlignedBB)wider).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).maxX, ((AxisAlignedBB)wider).maxY, ((AxisAlignedBB)wider).minZ);
      GL11.glVertex3d(((AxisAlignedBB)wider).minX, ((AxisAlignedBB)wider).maxY, ((AxisAlignedBB)wider).maxZ);
      GL11.glEnd();
      GL11.glPopMatrix();
   }

   public static void _johnston() {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDisable(2896);
      GL11.glDepthMask(false);
      GL11.glHint(3154, 4354);
   }

   public static void _villas() {
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      if (!GL11.glIsEnabled(2896)) {
         GL11.glEnable(2896);
      }

   }

   public static void _papers(float tribal, int involved, int strand, int approach) {
      Object portland = 0.003921569F * (float)involved;
      Object backup = 0.003921569F * (float)strand;
      Object heart = 0.003921569F * (float)approach;
      GL11.glColor4f(portland, backup, heart, (float)tribal);
   }

   public static void _opinion(float ubezosad, float uyipecim, float malidoro, float emiyetuf) {
      GL11.glBegin(7);
      GL11.glVertex2f((float)ubezosad, (float)emiyetuf);
      GL11.glVertex2f((float)malidoro, (float)emiyetuf);
      GL11.glVertex2f((float)malidoro, (float)uyipecim);
      GL11.glVertex2f((float)ubezosad, (float)uyipecim);
      GL11.glEnd();
   }

   public static void _loving(int gamespot) {
      Object vehicle = (float)(gamespot >> 24 & 255) / 255.0F;
      Object roland = (float)(gamespot >> 16 & 255) / 255.0F;
      Object garcia = (float)(gamespot >> 8 & 255) / 255.0F;
      Object campaign = (float)(gamespot & 255) / 255.0F;
      GL11.glColor4f(roland, garcia, campaign, vehicle);
   }

   public static void _special(float lingerie, float value, float offer, float digest, int boots) {
      _author();
      _loving((int)boots);
      _opinion((float)lingerie, (float)value, (float)offer, (float)digest);
      _coaches();
   }

   public static void _hidden(float studies, float balance, float harmony, float village, int action, int var5) {
      _special(studies + 0.5F, (float)balance, harmony - 0.5F, balance + 0.5F, var5);
      _special(studies + 0.5F, village - 0.5F, harmony - 0.5F, (float)village, var5);
      _special((float)studies, balance + 0.5F, (float)harmony, village - 0.5F, var5);
   }

   public static void _precise(float colusobi, float gugucusa, float maguyenu, int uliyilam) {
      if (gugucusa < colusobi) {
         Object yebanugo = (float)colusobi;
         colusobi = gugucusa;
         gugucusa = yebanugo;
      }

      _special((float)colusobi, (float)maguyenu, gugucusa + 1.0F, maguyenu + 1.0F, (int)uliyilam);
   }

   public static void _rotation(float mimopavu, float pisulapu, float igovimil, int nodarunu) {
      Object burefobe = (float)(nodarunu >> 24 & 255) / 255.0F;
      float var5 = (float)(nodarunu >> 16 & 255) / 255.0F;
      float var6 = (float)(nodarunu >> 8 & 255) / 255.0F;
      float var7 = (float)(nodarunu & 255) / 255.0F;
      _johnston();
      Tessellator var8 = Tessellator.getInstance();
      GlStateManager.enableAlpha();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      RenderHelper.disableStandardItemLighting();
      GL11.glBegin(6);
      GL11.glVertex2f((float)mimopavu, (float)pisulapu);
      GL11.glVertex2f((float)igovimil, (float)pisulapu);
      GL11.glVertex2f(mimopavu + (igovimil - mimopavu) / 2.0F, pisulapu + 3.0F);
      GL11.glEnd();
      var8.draw();
      RenderHelper.enableStandardItemLighting();
      _villas();
   }

   public static void _author() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void _coaches() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void _laugh(float points, float flows, float tariff, int vienna, int rescue) {
      GL11.glPushMatrix();
      points = points * 2.0F;
      flows = flows * 2.0F;
      Object suspect = (float)(rescue >> 24 & 255) / 255.0F;
      Object twist = (float)(rescue >> 16 & 255) / 255.0F;
      Object commit = (float)(rescue >> 8 & 255) / 255.0F;
      Object blank = (float)(rescue & 255) / 255.0F;
      Object combines = (float)(6.2831852D / (double)vienna);
      Object scholar = (float)Math.cos((double)combines);
      Object petite = (float)Math.sin((double)combines);
      float var18;
      Object cisco = var18 = tariff * 2.0F;
      Object judge = Float.intBitsToFloat(0);
      _author();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glColor4f(twist, commit, blank, suspect);
      GL11.glBegin(2);

      for(Object lemon = 0; lemon < vienna; ++lemon) {
         GL11.glVertex2f(cisco + points, judge + flows);
         Object concerns = cisco;
         cisco = scholar * cisco - petite * judge;
         judge = petite * concerns + scholar * judge;
      }

      GL11.glEnd();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      _coaches();
      GL11.glPopMatrix();
   }

   public static void _emails(int supplies, int replies, double michael, double moving, int var6, int var7) {
      _author();
      _laugh((float)supplies, (float)replies, (float)(michael - 0.5D + moving), 72, var6);
      _heater((int)supplies, (int)replies, (double)michael, var7);
      _coaches();
   }

   public static void _dutch(float gicapote, float var1, float var2, int var3) {
      float var4 = Float.intBitsToFloat(0);
      int var5 = var3 + 2;
      float var6 = 6.2831855F;
   }

   public static void _heater(int anidadun, int tegosutu, double gulitato, int ugotelir) {
      gulitato = gulitato * 2.0D;
      anidadun = anidadun * 2;
      tegosutu = tegosutu * 2;
      Object ocavifef = (float)(ugotelir >> 24 & 255) / 255.0F;
      Object utirecun = (float)(ugotelir >> 16 & 255) / 255.0F;
      Object liberoba = (float)(ugotelir >> 8 & 255) / 255.0F;
      Object yulugizo = (float)(ugotelir & 255) / 255.0F;
      _author();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glColor4f(utirecun, liberoba, yulugizo, ocavifef);
      GL11.glBegin(6);

      for(Object usogutil = 0; usogutil <= 2160; ++usogutil) {
         Object zegoporo = Math.sin((double)usogutil * 3.141592653589793D / 360.0D) * gulitato;
         double var12 = Math.cos((double)usogutil * 3.141592653589793D / 360.0D) * gulitato;
         GL11.glVertex2d((double)anidadun + zegoporo, (double)tegosutu + var12);
      }

      GL11.glEnd();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      _coaches();
   }

   public static net.minecraft.util.Vec3 _timeline(EntityPlayer monecila) {
      Object ayocogiv = Helper._pillow().renderPartialTicks;
      Object ilicalic = ((EntityPlayer)monecila).lastTickPosX + (((EntityPlayer)monecila).posX - ((EntityPlayer)monecila).lastTickPosX) * (double)ayocogiv;
      Object onamopid = ((EntityPlayer)monecila).lastTickPosY + (((EntityPlayer)monecila).posY - ((EntityPlayer)monecila).lastTickPosY) * (double)ayocogiv;
      double var6 = ((EntityPlayer)monecila).lastTickPosZ + (((EntityPlayer)monecila).posZ - ((EntityPlayer)monecila).lastTickPosZ) * (double)ayocogiv;
      return new net.minecraft.util.Vec3(ilicalic, onamopid, var6);
   }

   public static double _include(double edabadat, double odarapem, float var4) {
      return edabadat + (odarapem - edabadat) * (double)var4;
   }

   public static float _thoughts(float osanoluy, float gusetupa, float afedasay) {
      return (float)(osanoluy + (gusetupa - osanoluy) * afedasay);
   }
}
