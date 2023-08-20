//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.vecmath.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class RenderUtil {
   public static Minecraft graphics$ = Minecraft.getMinecraft();
   public static Map annie$ = new HashMap();
   public static Frustum lance$ = new Frustum();
   public static IntBuffer allowing$ = GLAllocation.createDirectIntBuffer(16);
   public static FloatBuffer puppy$ = GLAllocation.createDirectFloatBuffer(16);
   public static FloatBuffer medicaid$ = GLAllocation.createDirectFloatBuffer(16);

   public static ScaledResolution _newbie() {
      return new ScaledResolution(graphics$);
   }

   public static Matrix4f _onion(int ninoreze) {
      Object mayimaso = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat((int)ninoreze, mayimaso);
      return (Matrix4f)(new Matrix4f()).load(mayimaso);
   }

   public static boolean _issue(int edeyonis, int izoderaf, int ufinubiz, int yacutepu, int rimamice, int usidatud) {
      return rimamice >= edeyonis && rimamice <= edeyonis + ufinubiz && usidatud >= izoderaf && usidatud <= izoderaf + yacutepu;
   }

   public static void _severe(float inner, float minimize, float medium, int artistic, int hoped, int lessons) {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glBegin(6);
      _phase((int)lessons);
      GL11.glVertex2f((float)inner, (float)minimize);

      for(Object highway = (float)artistic; highway <= (float)hoped; ++highway) {
         _phase((int)lessons);
         GL11.glVertex2f((float)((double)medium * Math.cos(3.141592653589793D * (double)highway / 180.0D) + (double)inner), (float)((double)medium * Math.sin(3.141592653589793D * (double)highway / 180.0D) + (double)minimize));
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glEnable(2884);
      GL11.glDisable(3042);
   }

   public static void _purposes(int auctions, int forces, int large, int maximum, int terrace, String average) {
      if (terrace == 0) {
         GlStateManager.color(1.0F, 1.0F, 1.0F);
      } else {
         _phase((int)terrace);
      }

      Object corps = new ResourceLocation("sleep/" + average);
      graphics$.getTextureManager().bindTexture(corps);
      GlStateManager.enableBlend();
      GL11.glTexParameteri(3553, 10240, 9729);
      Gui.drawModalRectWithCustomSizedTexture((int)auctions, (int)forces, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)large, (int)maximum, (float)large, (float)maximum);
      GlStateManager.disableBlend();
   }

   public static void _orbit(int epetefar, int edagifen, int ilesetez, int onamafis, int yezepupi, int ulibenem, int obapizel) {
      if (obapizel == -1) {
         Gui.drawRect((int)epetefar, (int)edagifen, ilesetez + epetefar, edagifen + onamafis, (int)ulibenem);
      } else if (obapizel == 0) {
         Gui.drawRect(epetefar + yezepupi, edagifen + yezepupi, epetefar + ilesetez - yezepupi, edagifen + onamafis - yezepupi, (int)ulibenem);
         Gui.drawRect(epetefar + yezepupi, (int)edagifen, epetefar + ilesetez - yezepupi, edagifen + yezepupi, (int)ulibenem);
         Gui.drawRect(epetefar + ilesetez - yezepupi, edagifen + yezepupi, epetefar + ilesetez, edagifen + onamafis - yezepupi, (int)ulibenem);
         Gui.drawRect(epetefar + yezepupi, edagifen + onamafis - yezepupi, epetefar + ilesetez - yezepupi, edagifen + onamafis, (int)ulibenem);
         Gui.drawRect((int)epetefar, edagifen + yezepupi, epetefar + yezepupi, edagifen + onamafis - yezepupi, (int)ulibenem);
         _severe((float)(epetefar + yezepupi), (float)(edagifen + yezepupi), (float)yezepupi, 180, 270, (int)ulibenem);
         _severe((float)(epetefar + ilesetez - yezepupi), (float)(edagifen + yezepupi), (float)yezepupi, 270, 360, (int)ulibenem);
         _severe((float)(epetefar + yezepupi), (float)(edagifen + onamafis - yezepupi), (float)yezepupi, 90, 180, (int)ulibenem);
         _severe((float)(epetefar + ilesetez - yezepupi), (float)(edagifen + onamafis - yezepupi), (float)yezepupi, 0, 90, (int)ulibenem);
      } else if (obapizel == 1) {
         Gui.drawRect(0, 0, 0, 0, -1);
         Gui.drawRect(epetefar + yezepupi, edagifen + yezepupi, epetefar + ilesetez - yezepupi, edagifen + onamafis - yezepupi, (int)ulibenem);
         Gui.drawRect(epetefar + yezepupi, (int)edagifen, epetefar + ilesetez - yezepupi, edagifen + yezepupi, (int)ulibenem);
         Gui.drawRect(epetefar + ilesetez - yezepupi, edagifen + yezepupi, epetefar + ilesetez, edagifen + onamafis - yezepupi, (int)ulibenem);
         Gui.drawRect((int)epetefar, edagifen + onamafis - yezepupi, epetefar + ilesetez, edagifen + onamafis, (int)ulibenem);
         Gui.drawRect((int)epetefar, edagifen + yezepupi, epetefar + yezepupi, edagifen + onamafis - yezepupi, (int)ulibenem);
         _severe((float)(epetefar + yezepupi), (float)(edagifen + yezepupi), (float)yezepupi, 180, 270, (int)ulibenem);
         _severe((float)(epetefar + ilesetez - yezepupi), (float)(edagifen + yezepupi), (float)yezepupi, 270, 360, (int)ulibenem);
      } else if (obapizel == 2) {
         Gui.drawRect(0, 0, 0, 0, -1);
         Gui.drawRect(epetefar + yezepupi, edagifen + yezepupi, epetefar + ilesetez - yezepupi, edagifen + onamafis - yezepupi, (int)ulibenem);
         Gui.drawRect((int)epetefar, (int)edagifen, epetefar + ilesetez, edagifen + yezepupi, (int)ulibenem);
         Gui.drawRect(epetefar + ilesetez - yezepupi, edagifen + yezepupi, epetefar + ilesetez, edagifen + onamafis - yezepupi, (int)ulibenem);
         Gui.drawRect(epetefar + yezepupi, edagifen + onamafis - yezepupi, epetefar + ilesetez - yezepupi, edagifen + onamafis, (int)ulibenem);
         Gui.drawRect((int)epetefar, edagifen + yezepupi, epetefar + yezepupi, edagifen + onamafis - yezepupi, (int)ulibenem);
         _severe((float)(epetefar + yezepupi), (float)(edagifen + onamafis - yezepupi), (float)yezepupi, 90, 180, (int)ulibenem);
         _severe((float)(epetefar + ilesetez - yezepupi), (float)(edagifen + onamafis - yezepupi), (float)yezepupi, 0, 90, (int)ulibenem);
      }

   }

   public static void _talks(AxisAlignedBB smoke) {
      GL11.glBegin(7);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).maxX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).minZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).minY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).maxZ);
      GL11.glVertex3d(((AxisAlignedBB)smoke).minX, ((AxisAlignedBB)smoke).maxY, ((AxisAlignedBB)smoke).minZ);
      GL11.glEnd();
   }

   public static void _canada(double jackson, double thing, double locate, double coding, double races, float var10, float var11, float var12, float var13) {
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.disableDepth();
      GlStateManager.color(var10, var11, var12, var13);
      _talks(new AxisAlignedBB((double)(jackson - coding), (double)thing, (double)(locate - coding), (double)(jackson + coding), (double)(thing + races), (double)(locate + coding)));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableDepth();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static Vector3d _bible(double obudabid, double ulogocir, double var4) {
      FloatBuffer var6 = GLAllocation.createDirectFloatBuffer(4);
      GL11.glGetFloat(2982, puppy$);
      GL11.glGetFloat(2983, medicaid$);
      GL11.glGetInteger(2978, allowing$);
      return GLU.gluProject((float)obudabid, (float)ulogocir, (float)var4, puppy$, medicaid$, allowing$, var6) ? new Vector3d((double)(var6.get(0) / (float)_newbie().getScaleFactor()), (double)(((float)Display.getHeight() - var6.get(1)) / (float)_newbie().getScaleFactor()), (double)var6.get(2)) : null;
   }

   public static org.lwjgl.util.vector.Vector _fellow(Vector3f system, int prompt, int gently) {
      return _foreign((Vector3f)system, _onion(2982), _onion(2983), (int)prompt, (int)gently);
   }

   public static void _spelling(float irezasug, float etosenol, float alilusut, float lozapopu, float eyacinoz, float gevuyase, int boyituse) {
      Object rugapadi = (float)(boyituse >> 24 & 255) / 255.0F;
      Object isezizis = (float)(boyituse >> 16 & 255) / 255.0F;
      Object sugabeye = (float)(boyituse >> 8 & 255) / 255.0F;
      Object vilebiga = (float)(boyituse & 255) / 255.0F;
      Object yumegebo = (float)(lozapopu / eyacinoz);
      GL11.glColor4f(isezizis, sugabeye, vilebiga, rugapadi);
      _stylish((float)irezasug, (float)etosenol, (float)alilusut, (float)lozapopu, 0.5F, -16777216, 0);
      Object osorated = etosenol + lozapopu - yumegebo;

      for(Object udarumor = 0; (float)udarumor < gevuyase; ++udarumor) {
         _stylish(irezasug + 0.25F, osorated, alilusut - 0.5F, yumegebo, 0.25F, -16777216, (int)boyituse);
         osorated -= yumegebo;
      }

   }

   public static double _burns(double brothers, double jason, double var4) {
      return jason + (brothers - jason) * var4;
   }

   public static boolean _gauge(Entity daughter) {
      return _health(((Entity)daughter).getEntityBoundingBox()) || ((Entity)daughter).ignoreFrustumCheck;
   }

   public static boolean _health(AxisAlignedBB travesti) {
      Object casino = Minecraft.getMinecraft().getRenderViewEntity();
      lance$.setPosition(casino.posX, casino.posY, casino.posZ);
      return lance$.isBoundingBoxInFrustum((AxisAlignedBB)travesti);
   }

   public static Vector2f _foreign(Vector3f lovafaco, Matrix4f uyalizen, Matrix4f ipudesad, int ebemonaz, int ezinirom) {
      Object fazeziza = _answered(_answered(new Vector4f(((Vector3f)lovafaco).x, ((Vector3f)lovafaco).y, ((Vector3f)lovafaco).z, 1.0F), (Matrix4f)uyalizen), (Matrix4f)ipudesad);
      Object zitagipe = new Vector3f(fazeziza.x / fazeziza.w, fazeziza.y / fazeziza.w, fazeziza.z / fazeziza.w);
      Object erirazez = (zitagipe.x + 1.0F) / 2.0F * (float)ebemonaz;
      Object bedocize = (1.0F - zitagipe.y) / 2.0F * (float)ezinirom;
      return (double)zitagipe.z >= -1.0D && (double)zitagipe.z <= 1.0D ? new Vector2f(erirazez, bedocize) : null;
   }

   public static void _beings(int sapuzudu, int olagaliz, int ponozave, int limevota, int agoracac, int orufuvup, float nezusure) {
      Object avazubap = 0.00390625F;
      Object ticonati = 0.00390625F;
      Object ocavudep = Tessellator.getInstance();
      Object ipelizom = ocavudep.getWorldRenderer();
      ipelizom.begin(7, DefaultVertexFormats.POSITION_TEX);
      ipelizom.pos((double)(sapuzudu + 0), (double)(olagaliz + orufuvup), (double)nezusure).tex((double)((float)(ponozave + 0) * avazubap), (double)((float)(limevota + orufuvup) * ticonati)).endVertex();
      ipelizom.pos((double)(sapuzudu + agoracac), (double)(olagaliz + orufuvup), (double)nezusure).tex((double)((float)(ponozave + agoracac) * avazubap), (double)((float)(limevota + orufuvup) * ticonati)).endVertex();
      ipelizom.pos((double)(sapuzudu + agoracac), (double)(olagaliz + 0), (double)nezusure).tex((double)((float)(ponozave + agoracac) * avazubap), (double)((float)(limevota + 0) * ticonati)).endVertex();
      ipelizom.pos((double)(sapuzudu + 0), (double)(olagaliz + 0), (double)nezusure).tex((double)((float)(ponozave + 0) * avazubap), (double)((float)(limevota + 0) * ticonati)).endVertex();
      ocavudep.draw();
   }

   public static void _matched(Color freight) {
      if (freight == null) {
         freight = Color.white;
      }

      GL11.glColor4d((double)((float)((Color)freight).getRed() / 255.0F), (double)((float)((Color)freight).getGreen() / 255.0F), (double)((float)((Color)freight).getBlue() / 255.0F), (double)((float)((Color)freight).getAlpha() / 255.0F));
   }

   public static void _rights(double isagolof, double loyazeca, double var4, Color var6) {
      _gross((double)isagolof, (double)loyazeca, var4, 360.0D, var6);
   }

   public static void _gross(double chain, double holds, double blast, double cotton, Color var8) {
      blast = blast / 2.0D;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2884);
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
      if (var8 != null) {
         _matched(var8);
      }

      GL11.glEnable(2848);
      GL11.glBegin(6);

      for(double var9 = Double.longBitsToDouble(0L); var9 <= cotton / 4.0D; ++var9) {
         double var11 = var9 * 4.0D * 6.283185307179586D / 360.0D;
         GL11.glVertex2d(chain + blast * Math.cos(var11) + blast, holds + blast * Math.sin(var11) + blast);
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GlStateManager.enableAlpha();
      GlStateManager.enableDepth();
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      _matched(Color.white);
   }

   public static Vector4f _answered(Vector4f citizens, Matrix4f orders) {
      return new Vector4f(((Vector4f)citizens).x * ((Matrix4f)orders).m00 + ((Vector4f)citizens).y * ((Matrix4f)orders).m10 + ((Vector4f)citizens).z * ((Matrix4f)orders).m20 + ((Vector4f)citizens).w * ((Matrix4f)orders).m30, ((Vector4f)citizens).x * ((Matrix4f)orders).m01 + ((Vector4f)citizens).y * ((Matrix4f)orders).m11 + ((Vector4f)citizens).z * ((Matrix4f)orders).m21 + ((Vector4f)citizens).w * ((Matrix4f)orders).m31, ((Vector4f)citizens).x * ((Matrix4f)orders).m02 + ((Vector4f)citizens).y * ((Matrix4f)orders).m12 + ((Vector4f)citizens).z * ((Matrix4f)orders).m22 + ((Vector4f)citizens).w * ((Matrix4f)orders).m32, ((Vector4f)citizens).x * ((Matrix4f)orders).m03 + ((Vector4f)citizens).y * ((Matrix4f)orders).m13 + ((Vector4f)citizens).z * ((Matrix4f)orders).m23 + ((Vector4f)citizens).w * ((Matrix4f)orders).m33);
   }

   public static void _clearing(float irogamas, float egobepov, float odibutap, float iyinumun) {
      Object naronimu = new ScaledResolution(graphics$);
      _emerald(irogamas - 9.0F, egobepov - 9.0F, 9.0F, 9.0F, "paneltopleft", naronimu);
      _emerald(irogamas - 9.0F, (float)(egobepov + iyinumun), 9.0F, 9.0F, "panelbottomleft", naronimu);
      _emerald((float)(irogamas + odibutap), (float)(egobepov + iyinumun), 9.0F, 9.0F, "panelbottomright", naronimu);
      _emerald((float)(irogamas + odibutap), egobepov - 9.0F, 9.0F, 9.0F, "paneltopright", naronimu);
      _emerald(irogamas - 9.0F, (float)egobepov, 9.0F, (float)iyinumun, "panelleft", naronimu);
      _emerald((float)(irogamas + odibutap), (float)egobepov, 9.0F, (float)iyinumun, "panelright", naronimu);
      _emerald((float)irogamas, egobepov - 9.0F, (float)odibutap, 9.0F, "paneltop", naronimu);
      _emerald((float)irogamas, (float)(egobepov + iyinumun), (float)odibutap, 9.0F, "panelbottom", naronimu);
   }

   public static double _biggest(double yapidutu, double dufayoma, double uzerudip) {
      boolean var6 = yapidutu > dufayoma;
      if (uzerudip < Double.longBitsToDouble(0L)) {
         uzerudip = Double.longBitsToDouble(0L);
      } else if (uzerudip > 1.0D) {
         uzerudip = 1.0D;
      }

      double var7 = Math.max((double)yapidutu, (double)dufayoma) - Math.min((double)yapidutu, (double)dufayoma);
      double var9 = var7 * uzerudip;
      if (var9 < 0.1D) {
         var9 = 0.1D;
      }

      if (var6) {
         dufayoma = dufayoma + var9;
      } else {
         dufayoma = dufayoma - var9;
      }

      return (double)dufayoma;
   }

   public static void _grade(double onerugot, double picuyusi, double olozagoc, double edicedan, double fivotusa, int paniyigo) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      Object imatoluz = (double)(onerugot + olozagoc);
      double var13 = (double)(picuyusi + edicedan);
      float var15 = (float)(paniyigo >> 24 & 255) / 255.0F;
      float var16 = (float)(paniyigo >> 16 & 255) / 255.0F;
      float var17 = (float)(paniyigo >> 8 & 255) / 255.0F;
      float var18 = (float)(paniyigo & 255) / 255.0F;
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      onerugot = onerugot * 2.0D;
      picuyusi = picuyusi * 2.0D;
      imatoluz = imatoluz * 2.0D;
      var13 = var13 * 2.0D;
      GL11.glDisable(3553);
      GL11.glColor4f(var16, var17, var18, var15);
      GL11.glEnable(2848);
      GL11.glBegin(9);

      for(int var19 = 0; var19 <= 90; var19 += 3) {
         GL11.glVertex2d(onerugot + fivotusa + Math.sin((double)var19 * 3.141592653589793D / 180.0D) * fivotusa * -1.0D, picuyusi + fivotusa + Math.cos((double)var19 * 3.141592653589793D / 180.0D) * fivotusa * -1.0D);
      }

      for(int var24 = 90; var24 <= 180; var24 += 3) {
         GL11.glVertex2d(onerugot + fivotusa + Math.sin((double)var24 * 3.141592653589793D / 180.0D) * fivotusa * -1.0D, var13 - fivotusa + Math.cos((double)var24 * 3.141592653589793D / 180.0D) * fivotusa * -1.0D);
      }

      for(int var25 = 0; var25 <= 90; var25 += 3) {
         GL11.glVertex2d(imatoluz - fivotusa + Math.sin((double)var25 * 3.141592653589793D / 180.0D) * fivotusa, var13 - fivotusa + Math.cos((double)var25 * 3.141592653589793D / 180.0D) * fivotusa);
      }

      for(int var26 = 90; var26 <= 180; var26 += 3) {
         GL11.glVertex2d(imatoluz - fivotusa + Math.sin((double)var26 * 3.141592653589793D / 180.0D) * fivotusa, picuyusi + fivotusa + Math.cos((double)var26 * 3.141592653589793D / 180.0D) * fivotusa);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _quiet(double sinevura, double zelafego, double vizatiya, double beputayi, double vasumiya, float megepibo, int ifegonel) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      Object usebudop = (double)(sinevura + vizatiya);
      double var14 = (double)(zelafego + beputayi);
      float var16 = (float)(ifegonel >> 24 & 255) / 255.0F;
      float var17 = (float)(ifegonel >> 16 & 255) / 255.0F;
      float var18 = (float)(ifegonel >> 8 & 255) / 255.0F;
      float var19 = (float)(ifegonel & 255) / 255.0F;
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      sinevura = sinevura * 2.0D;
      zelafego = zelafego * 2.0D;
      usebudop = usebudop * 2.0D;
      var14 = var14 * 2.0D;
      GL11.glLineWidth((float)megepibo);
      GL11.glDisable(3553);
      GL11.glColor4f(var17, var18, var19, var16);
      GL11.glEnable(2848);
      GL11.glBegin(2);

      for(int var20 = 0; var20 <= 90; var20 += 3) {
         GL11.glVertex2d(sinevura + vasumiya + Math.sin((double)var20 * 3.141592653589793D / 180.0D) * vasumiya * -1.0D, zelafego + vasumiya + Math.cos((double)var20 * 3.141592653589793D / 180.0D) * vasumiya * -1.0D);
      }

      for(int var25 = 90; var25 <= 180; var25 += 3) {
         GL11.glVertex2d(sinevura + vasumiya + Math.sin((double)var25 * 3.141592653589793D / 180.0D) * vasumiya * -1.0D, var14 - vasumiya + Math.cos((double)var25 * 3.141592653589793D / 180.0D) * vasumiya * -1.0D);
      }

      for(int var26 = 0; var26 <= 90; var26 += 3) {
         GL11.glVertex2d(usebudop - vasumiya + Math.sin((double)var26 * 3.141592653589793D / 180.0D) * vasumiya, var14 - vasumiya + Math.cos((double)var26 * 3.141592653589793D / 180.0D) * vasumiya);
      }

      for(int var27 = 90; var27 <= 180; var27 += 3) {
         GL11.glVertex2d(usebudop - vasumiya + Math.sin((double)var27 * 3.141592653589793D / 180.0D) * vasumiya, zelafego + vasumiya + Math.cos((double)var27 * 3.141592653589793D / 180.0D) * vasumiya);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _yacht(double unadicup, double odetogez, double orenupoc, double var6) {
      ScaledResolution var8 = new ScaledResolution(Minecraft.getMinecraft());
      int var9 = var8.getScaleFactor();
      GL11.glScissor((int)(unadicup * (double)((float)var9)), (int)(((double)((float)var8.getScaledHeight()) - var6) * (double)((float)var9)), (int)((orenupoc - unadicup) * (double)((float)var9)), (int)((var6 - odetogez) * (double)((float)var9)));
   }

   public static void _bizarre(int bimefula, int tosalifo, int evizufod, int ecesaper, float otidavit) {
      bimefula = bimefula - 5;
      evizufod = evizufod + 5;
      tosalifo = tosalifo - 5;
      ecesaper = ecesaper + 5;
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      graphics$.getTextureManager().bindTexture(new ResourceLocation("sleep/shader/shadow.png"));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      Gui.drawModalRectWithCustomSizedTexture((int)bimefula, (int)tosalifo, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)evizufod, (int)ecesaper, (float)evizufod, (float)ecesaper);
      GlStateManager.color(1.0F, 1.0F, 1.0F, (float)otidavit);
      Gui.drawModalRectWithCustomSizedTexture((int)bimefula, (int)tosalifo, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)evizufod, (int)ecesaper, (float)evizufod, (float)ecesaper);
      GlStateManager.bindTexture(0);
      GlStateManager.resetColor();
      GlStateManager.enableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static void _emerald(float ocayediv, float bivezopi, float ropezape, float lesefuzi, String asidosib, ScaledResolution var5) {
      GL11.glPushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      graphics$.getTextureManager().bindTexture(new ResourceLocation("sleep/shader/" + asidosib + ".png"));
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      Gui.drawModalRectWithCustomSizedTexture((int)ocayediv, (int)bivezopi, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)ropezape, (int)lesefuzi, (float)((int)ropezape), (float)((int)lesefuzi));
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GL11.glPopMatrix();
   }

   public static double[] _defense(double mupogevi, double bedapofu, double nagesafa) {
      Object utucegus = BufferUtils.createFloatBuffer(3);
      Object imisuvev = BufferUtils.createIntBuffer(16);
      FloatBuffer var8 = BufferUtils.createFloatBuffer(16);
      FloatBuffer var9 = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat(2982, var8);
      GL11.glGetFloat(2983, var9);
      GL11.glGetInteger(2978, imisuvev);
      boolean var10 = GLU.gluProject((float)mupogevi, (float)bedapofu, (float)nagesafa, var8, var9, imisuvev, utucegus);
      return var10 ? new double[]{(double)utucegus.get(0), (double)((float)Display.getHeight() - utucegus.get(1)), (double)utucegus.get(2)} : null;
   }

   public static void _stomach(float yacufosa, float enucupoc, float avapediy, float opuzaney, int bipivuyi, int cogiyeru) {
      avapediy = yacufosa + avapediy;
      opuzaney = enucupoc + opuzaney;
      Object poyevupu = (float)(bipivuyi >> 24 & 255) / 255.0F;
      Object efucemac = (float)(bipivuyi >> 16 & 255) / 255.0F;
      Object inunolor = (float)(bipivuyi >> 8 & 255) / 255.0F;
      Object linesibi = (float)(bipivuyi & 255) / 255.0F;
      Object imosatef = (float)(cogiyeru >> 24 & 255) / 255.0F;
      Object ipaladub = (float)(cogiyeru >> 16 & 255) / 255.0F;
      Object vaficotu = (float)(cogiyeru >> 8 & 255) / 255.0F;
      Object lozidaso = (float)(cogiyeru & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Object uciguref = Tessellator.getInstance();
      Object ocamagoy = uciguref.getWorldRenderer();
      ocamagoy.begin(7, DefaultVertexFormats.POSITION_COLOR);
      ocamagoy.pos((double)avapediy, (double)enucupoc, Double.longBitsToDouble(0L)).color(efucemac, inunolor, linesibi, poyevupu).endVertex();
      ocamagoy.pos((double)yacufosa, (double)enucupoc, Double.longBitsToDouble(0L)).color(efucemac, inunolor, linesibi, poyevupu).endVertex();
      ocamagoy.pos((double)yacufosa, (double)opuzaney, Double.longBitsToDouble(0L)).color(ipaladub, vaficotu, lozidaso, imosatef).endVertex();
      ocamagoy.pos((double)avapediy, (double)opuzaney, Double.longBitsToDouble(0L)).color(ipaladub, vaficotu, lozidaso, imosatef).endVertex();
      uciguref.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void _street(double format, double bargains, double var4, double var6) {
      _newman((double)format, (double)bargains, format + var4, bargains + var6, Color.BLACK.getRGB());
      _newman(format + 1.0D, bargains + 1.0D, format + var4 - 1.0D, bargains + var6 - 1.0D, (new Color(55, 55, 55)).getRGB());
      _newman(format + 1.0D, bargains + 1.5D, format + var4 - 2.0D, bargains + var6 - 1.5D, (new Color(30, 30, 30)).getRGB());
      _newman(format + 3.0D, bargains + 3.0D, format + var4 - 3.0D, bargains + var6 - 3.0D, (new Color(14, 14, 14)).getRGB());
   }

   public static void _passage(int ugusilug, int esanasos, int igolanil, int afonilet) {
      GlStateManager.resetColor();
      _newman((double)ugusilug, (double)esanasos, (double)(ugusilug + igolanil), (double)(esanasos + afonilet), Color.BLACK.getRGB());
      _newman((double)ugusilug, (double)esanasos, (double)(ugusilug + igolanil), (double)(esanasos + afonilet), (new Color(55, 55, 55)).getRGB());
      _newman((double)(ugusilug + 1), (double)(esanasos + 1), (double)(ugusilug + igolanil - 1), (double)(esanasos + afonilet - 1), (new Color(14, 14, 14)).getRGB());
      GlStateManager.resetColor();
   }

   public static void _jackson(double crisis, double locking, double factor, double var6, double var8) {
      _greece((double)crisis, locking + -4.0D, crisis + factor + var8, locking + var6 + var8, 0.5D, (new Color(60, 60, 60)).getRGB(), (new Color(10, 10, 10)).getRGB());
      _greece(crisis + 1.0D, locking + -3.0D, crisis + factor + var8 - 1.0D, locking + var6 + var8 - 1.0D, 1.0D, (new Color(40, 40, 40)).getRGB(), (new Color(40, 40, 40)).getRGB());
      _greece(crisis + 2.5D, locking + -1.5D, crisis + factor + var8 - 2.5D, locking + var6 + var8 - 2.5D, 0.5D, (new Color(40, 40, 40)).getRGB(), (new Color(60, 60, 60)).getRGB());
      _greece(crisis + 2.5D, locking + -1.5D, crisis + factor + var8 - 2.5D, locking + var6 + var8 - 2.5D, 0.5D, (new Color(22, 22, 22)).getRGB(), (new Color(255, 255, 255, 0)).getRGB());
   }

   public static void _firms(double elvis, double paying, double verbal, double var6, double var8) {
      _greece(elvis + 4.35D, paying + 0.5D, elvis + verbal + var8 - 84.5D, paying + var6 + var8 - 4.35D, 0.5D, (new Color(48, 48, 48)).getRGB(), (new Color(10, 10, 10)).getRGB());
      _greece(elvis + 5.0D, paying + 1.0D, elvis + verbal + var8 - 85.0D, paying + var6 + var8 - 5.0D, 0.5D, (new Color(17, 17, 17)).getRGB(), (new Color(255, 255, 255, 0)).getRGB());
   }

   public static void _bands(double zebicime, double vabogifu, double var4, double var6) {
      _greece(zebicime + 4.35D, vabogifu + 0.5D, zebicime + var4 - 84.5D, vabogifu + var6 - 4.35D, 0.5D, (new Color(48, 48, 48)).getRGB(), (new Color(10, 10, 10)).getRGB());
      _greece(zebicime + 5.0D, vabogifu + 1.0D, zebicime + var4 - 85.0D, vabogifu + var6 - 5.0D, 0.5D, (new Color(17, 17, 17)).getRGB(), (new Color(255, 255, 255, 0)).getRGB());
   }

   public static void _ensure(float merchant, float oregon, float refused, float carries, int webster) {
      Object rapids = (float)(webster >> 24 & 255) / 255.0F;
      Object alliance = (float)(webster >> 16 & 255) / 255.0F;
      Object marilyn = (float)(webster >> 8 & 255) / 255.0F;
      Object avenue = (float)(webster & 255) / 255.0F;
      Object herself = Tessellator.getInstance();
      Object problem = herself.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(alliance, marilyn, avenue, rapids);
      problem.begin(7, DefaultVertexFormats.POSITION);
      problem.pos((double)merchant, (double)(oregon + carries), Double.longBitsToDouble(0L)).endVertex();
      problem.pos((double)(merchant + refused), (double)(oregon + carries), Double.longBitsToDouble(0L)).endVertex();
      problem.pos((double)(merchant + refused), (double)oregon, Double.longBitsToDouble(0L)).endVertex();
      problem.pos((double)merchant, (double)oregon, Double.longBitsToDouble(0L)).endVertex();
      herself.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _payday(float matters, float victory, float backing, float myspace, float beauty, int again, float publicly, int bargain) {
      if (again == 16777215) {
         again = -65794;
      }

      if (bargain == 16777215) {
         bargain = -65794;
      }

      if (beauty < Float.intBitsToFloat(0)) {
         beauty = Float.intBitsToFloat(0);
      }

      if (beauty > backing / 2.0F) {
         beauty = backing / 2.0F;
      }

      if (beauty > myspace / 2.0F) {
         beauty = myspace / 2.0F;
      }

      _ensure((float)(matters + beauty), (float)(victory + beauty), backing - beauty * 2.0F, myspace - beauty * 2.0F, (int)again);
      _ensure((float)(matters + beauty), (float)victory, backing - beauty * 2.0F, (float)beauty, (int)again);
      _ensure((float)(matters + beauty), (float)(victory + myspace - beauty), backing - beauty * 2.0F, (float)beauty, (int)again);
      _ensure((float)matters, (float)(victory + beauty), (float)beauty, myspace - beauty * 2.0F, (int)again);
      _ensure((float)(matters + backing - beauty), (float)(victory + beauty), (float)beauty, myspace - beauty * 2.0F, (int)again);
      _plymouth();
      _phase((int)again);
      GL11.glBegin(6);
      Object aquatic = (float)(matters + beauty);
      Object cross = (float)(victory + beauty);
      GL11.glVertex2d((double)aquatic, (double)cross);
      Object national = (int)Math.min(Math.max((float)beauty, 10.0F), 90.0F);

      for(Object stopped = 0; stopped < national + 1; ++stopped) {
         Object desire = 6.283185307179586D * (double)(stopped + 180) / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(desire) * (double)beauty, (double)cross + Math.cos(desire) * (double)beauty);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      aquatic = (float)(matters + backing - beauty);
      cross = (float)(victory + beauty);
      GL11.glVertex2d((double)aquatic, (double)cross);
      national = (int)Math.min(Math.max((float)beauty, 10.0F), 90.0F);

      for(Object var32 = 0; var32 < national + 1; ++var32) {
         Object var39 = 6.283185307179586D * (double)(var32 + 90) / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(var39) * (double)beauty, (double)cross + Math.cos(var39) * (double)beauty);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      aquatic = (float)(matters + beauty);
      cross = (float)(victory + myspace - beauty);
      GL11.glVertex2d((double)aquatic, (double)cross);
      national = (int)Math.min(Math.max((float)beauty, 10.0F), 90.0F);

      for(Object var33 = 0; var33 < national + 1; ++var33) {
         Object var40 = 6.283185307179586D * (double)(var33 + 270) / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(var40) * (double)beauty, (double)cross + Math.cos(var40) * (double)beauty);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      aquatic = (float)(matters + backing - beauty);
      cross = (float)(victory + myspace - beauty);
      GL11.glVertex2d((double)aquatic, (double)cross);
      national = (int)Math.min(Math.max((float)beauty, 10.0F), 90.0F);

      for(Object var34 = 0; var34 < national + 1; ++var34) {
         Object var41 = 6.283185307179586D * (double)var34 / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(var41) * (double)beauty, (double)cross + Math.cos(var41) * (double)beauty);
      }

      GL11.glEnd();
      _phase((int)bargain);
      GL11.glLineWidth((float)publicly);
      GL11.glBegin(3);
      aquatic = (float)(matters + beauty);
      cross = (float)(victory + beauty);
      national = (int)Math.min(Math.max((float)beauty, 10.0F), 90.0F);

      for(Object var35 = national; var35 >= 0; --var35) {
         Object var42 = 6.283185307179586D * (double)(var35 + 180) / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(var42) * (double)beauty, (double)cross + Math.cos(var42) * (double)beauty);
      }

      GL11.glVertex2d((double)(matters + beauty), (double)victory);
      GL11.glVertex2d((double)(matters + backing - beauty), (double)victory);
      aquatic = (float)(matters + backing - beauty);
      cross = (float)(victory + beauty);

      for(Object var36 = national; var36 >= 0; --var36) {
         Object var43 = 6.283185307179586D * (double)(var36 + 90) / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(var43) * (double)beauty, (double)cross + Math.cos(var43) * (double)beauty);
      }

      GL11.glVertex2d((double)(matters + backing), (double)(victory + beauty));
      GL11.glVertex2d((double)(matters + backing), (double)(victory + myspace - beauty));
      aquatic = (float)(matters + backing - beauty);
      cross = (float)(victory + myspace - beauty);

      for(Object var37 = national; var37 >= 0; --var37) {
         Object var44 = 6.283185307179586D * (double)var37 / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(var44) * (double)beauty, (double)cross + Math.cos(var44) * (double)beauty);
      }

      GL11.glVertex2d((double)(matters + backing - beauty), (double)(victory + myspace));
      GL11.glVertex2d((double)(matters + beauty), (double)(victory + myspace));
      aquatic = (float)(matters + beauty);
      cross = (float)(victory + myspace - beauty);

      for(Object var38 = national; var38 >= 0; --var38) {
         Object var45 = 6.283185307179586D * (double)(var38 + 270) / (double)(national * 4);
         GL11.glVertex2d((double)aquatic + Math.sin(var45) * (double)beauty, (double)cross + Math.cos(var45) * (double)beauty);
      }

      GL11.glVertex2d((double)matters, (double)(victory + myspace - beauty));
      GL11.glVertex2d((double)matters, (double)(victory + beauty));
      GL11.glEnd();
      _buying();
   }

   public static void _plymouth() {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
   }

   public static void _buying() {
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static int _offers(int deboguya, float oyubocan) {
      Object sarezuse = new Color((int)deboguya);
      Object ifinodon = 0.003921569F * (float)sarezuse.getRed();
      Object miveloru = 0.003921569F * (float)sarezuse.getGreen();
      Object ofagubir = 0.003921569F * (float)sarezuse.getBlue();
      return (new Color(ifinodon, miveloru, ofagubir, (float)oyubocan)).getRGB();
   }

   public static Color _offering(Color terror, float builds) {
      Object remarks = 0.003921569F * (float)((Color)terror).getRed();
      Object geometry = 0.003921569F * (float)((Color)terror).getGreen();
      Object earned = 0.003921569F * (float)((Color)terror).getBlue();
      return new Color(remarks, geometry, earned, (float)builds);
   }

   public static void _simply(Runnable geneva) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      ((Runnable)geneva).run();
      GL11.glEnable(3553);
      GlStateManager.disableBlend();
   }

   public static void _prize(int focused, Runnable tutorial) {
      GL11.glBegin((int)focused);
      ((Runnable)tutorial).run();
      GL11.glEnd();
   }

   public static void _chicks() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _generic(float yazeyeye, float dumiboso, double zidayopo, int uralezoy, int erevisus, double sacofeda, int epuloyic) {
      zidayopo = zidayopo * 2.0D;
      yazeyeye = yazeyeye * 2.0F;
      dumiboso = dumiboso * 2.0F;
      Object emacavim = (float)(uralezoy >> 24 & 255) / 255.0F;
      Object uzoreyuf = (float)(uralezoy >> 16 & 255) / 255.0F;
      Object tobovuza = (float)(uralezoy >> 8 & 255) / 255.0F;
      float var12 = (float)(uralezoy & 255) / 255.0F;
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glLineWidth((float)epuloyic);
      GL11.glEnable(2848);
      GL11.glColor4f(uzoreyuf, tobovuza, var12, emacavim);
      GL11.glBegin(3);

      for(int var13 = (int)erevisus; (double)var13 <= sacofeda; ++var13) {
         GL11.glVertex2d((double)yazeyeye + Math.sin((double)var13 * 3.141592653589793D / 180.0D) * zidayopo, (double)dumiboso + Math.cos((double)var13 * 3.141592653589793D / 180.0D) * zidayopo);
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void _colleges(float muloguba, float ozetidig, float ososoyun, int semadifa, int unedeval) {
      GL11.glPushMatrix();
      muloguba = muloguba * 2.0F;
      ozetidig = ozetidig * 2.0F;
      Object uliluzic = (float)(unedeval >> 24 & 255) / 255.0F;
      Object mirorumi = (float)(unedeval >> 16 & 255) / 255.0F;
      Object odafuvoc = (float)(unedeval >> 8 & 255) / 255.0F;
      Object uvidisat = (float)(unedeval & 255) / 255.0F;
      Object azezevey = (float)(6.2831852D / (double)semadifa);
      Object ecayuder = (float)Math.cos((double)azezevey);
      Object amabozup = (float)Math.sin((double)azezevey);
      float var18;
      Object yobayifo = var18 = ososoyun * 2.0F;
      Object abavinab = Float.intBitsToFloat(0);
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glColor4f(mirorumi, odafuvoc, uvidisat, uliluzic);
      GL11.glBegin(2);

      for(Object alabevus = 0; alabevus < semadifa; ++alabevus) {
         GL11.glVertex2f(yobayifo + muloguba, abavinab + ozetidig);
         Object rosativi = yobayifo;
         yobayifo = ecayuder * yobayifo - amabozup * abavinab;
         abavinab = amabozup * rosativi + ecayuder * abavinab;
      }

      GL11.glEnd();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
      GL11.glPopMatrix();
   }

   public static void _founded(float spell, float likes, float thinks, int ellis) {
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GL11.glEnable(2881);
      GlStateManager.enableBlend();
      GL11.glBegin(9);
      ColorUtil._candles((int)ellis);

      for(Object drink = 0; drink <= 360; ++drink) {
         GL11.glVertex2d((double)spell + Math.sin((double)drink * 3.141592653589793D / 180.0D) * (double)thinks, (double)likes + Math.cos((double)drink * 3.141592653589793D / 180.0D) * (double)thinks);
      }

      GlStateManager.resetColor();
      GL11.glEnd();
      GL11.glDisable(2881);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
      GlStateManager.popMatrix();
   }

   public static void _discuss(double ruredayu, double vazobife, double udulerov, double utepiver, double babeloze, float ibefoyuy, float fogigoni, float umiyibir, float opagozis, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)ibefoyuy, (float)fogigoni, (float)umiyibir, (float)opagozis);
      _talks(new AxisAlignedBB((double)(ruredayu - utepiver), (double)vazobife, (double)(udulerov - utepiver), (double)(ruredayu + utepiver), (double)(vazobife + babeloze), (double)(udulerov + utepiver)));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      _abuse(new AxisAlignedBB((double)(ruredayu - utepiver), (double)vazobife, (double)(udulerov - utepiver), (double)(ruredayu + utepiver), (double)(vazobife + babeloze), (double)(udulerov + utepiver)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _presence(Entity enacugan, double zuvecafo, boolean pizigana) {
      GL11.glPushMatrix();
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glEnable(2832);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glHint(3153, 4354);
      GL11.glDepthMask(false);
      GlStateManager.alphaFunc(516, Float.intBitsToFloat(0));
      if (pizigana) {
         GL11.glShadeModel(7425);
      }

      GlStateManager.disableCull();
      GL11.glBegin(5);
      Object yumilape = ((Entity)enacugan).lastTickPosX + (((Entity)enacugan).posX - ((Entity)enacugan).lastTickPosX) * (double)graphics$.timer.renderPartialTicks - graphics$.getRenderManager().renderPosX;
      Object eriradab = ((Entity)enacugan).lastTickPosY + (((Entity)enacugan).posY - ((Entity)enacugan).lastTickPosY) * (double)graphics$.timer.renderPartialTicks - graphics$.getRenderManager().renderPosY + Math.sin((double)System.currentTimeMillis() / 200.0D) + 1.0D;
      Object atumivag = ((Entity)enacugan).lastTickPosZ + (((Entity)enacugan).posZ - ((Entity)enacugan).lastTickPosZ) * (double)graphics$.timer.renderPartialTicks - graphics$.getRenderManager().renderPosZ;

      for(float var11 = Float.intBitsToFloat(0); (double)var11 < 6.283185307179586D; var11 = (float)((double)var11 + 0.09817477042468103D)) {
         double var12 = yumilape + zuvecafo * Math.cos((double)var11);
         double var14 = atumivag + zuvecafo * Math.sin((double)var11);
         Color var10 = new Color(HUD.during$.getValue().intValue());
         if (pizigana) {
            GL11.glColor4f((float)var10.getRed() / 255.0F, (float)var10.getGreen() / 255.0F, (float)var10.getBlue() / 255.0F, Float.intBitsToFloat(0));
            GL11.glVertex3d(var12, eriradab - Math.cos((double)System.currentTimeMillis() / 200.0D) / 2.0D, var14);
            GL11.glColor4f((float)var10.getRed() / 255.0F, (float)var10.getGreen() / 255.0F, (float)var10.getBlue() / 255.0F, 0.85F);
         }

         GL11.glVertex3d(var12, eriradab, var14);
      }

      GL11.glEnd();
      if (pizigana) {
         GL11.glShadeModel(7424);
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.enableCull();
      GL11.glDisable(2848);
      GL11.glDisable(2848);
      GL11.glEnable(2832);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
      GL11.glColor3f(255.0F, 255.0F, 255.0F);
   }

   public static void _greece(double lapitela, double acigasus, double anofenad, double tefavute, double var8, int var10, int var11) {
      _newman(lapitela + var8, acigasus + var8, anofenad - var8, tefavute - var8, var10);
      _newman(lapitela + var8, (double)acigasus, anofenad - var8, acigasus + var8, var11);
      _newman((double)lapitela, (double)acigasus, lapitela + var8, (double)tefavute, var11);
      _newman(anofenad - var8, (double)acigasus, (double)anofenad, (double)tefavute, var11);
      _newman(lapitela + var8, tefavute - var8, anofenad - var8, (double)tefavute, var11);
   }

   public static void _balance(double nilomobi, double cozutolu, double iveriped, double ipitaben, double var8, int var10, int var11) {
      _newman(nilomobi + var8, cozutolu + var8, nilomobi + iveriped - var8, cozutolu + ipitaben - var8, var10);
      _newman(nilomobi + var8, (double)cozutolu, nilomobi + iveriped - var8, cozutolu + cozutolu + var8, var11);
      _newman((double)nilomobi, (double)cozutolu, nilomobi + nilomobi + var8, (double)(cozutolu + ipitaben), var11);
      _newman(iveriped - var8, (double)cozutolu, (double)(nilomobi + iveriped), (double)(cozutolu + ipitaben), var11);
      _newman(nilomobi + var8, ipitaben - var8, nilomobi + iveriped - var8, (double)(cozutolu + ipitaben), var11);
   }

   public static void _shooting(int flying) {
      Object suggest = (float)(flying >> 24 & 255) / 255.0F;
      Object roulette = (float)(flying >> 16 & 255) / 255.0F;
      Object homeland = (float)(flying >> 8 & 255) / 255.0F;
      Object results = (float)(flying & 255) / 255.0F;
      GL11.glColor4f(roulette, homeland, results, suggest == Float.intBitsToFloat(0) ? 1.0F : suggest);
   }

   public static void _honors(Color blame) {
      Object success = (float)(((Color)blame).getRGB() >> 24 & 255) / 255.0F;
      Object gather = (float)(((Color)blame).getRGB() >> 16 & 255) / 255.0F;
      Object sperm = (float)(((Color)blame).getRGB() >> 8 & 255) / 255.0F;
      Object momentum = (float)(((Color)blame).getRGB() & 255) / 255.0F;
      GL11.glColor4f(gather, sperm, momentum, success == Float.intBitsToFloat(0) ? 1.0F : success);
   }

   public static void _lecture(int login, boolean picnic) {
      annie$.put(Integer.valueOf((int)login), Boolean.valueOf(GL11.glGetBoolean((int)login)));
      if (picnic) {
         GL11.glEnable((int)login);
      } else {
         GL11.glDisable((int)login);
      }

   }

   public static void _drops(int aspect) {
      Object violin = (Boolean)annie$.get(Integer.valueOf((int)aspect));
      if (violin != null) {
         if (violin.booleanValue()) {
            GL11.glEnable((int)aspect);
         } else {
            GL11.glDisable((int)aspect);
         }
      }

   }

   public static void _toward() {
      for(Object votefogo : annie$.keySet()) {
         _drops(votefogo.intValue());
      }

   }

   public static void _frames(float vemomome) {
      GL11.glDisable(3008);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glEnable(2884);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glLineWidth((float)vemomome);
   }

   public static void _hockey() {
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(3042);
      GL11.glEnable(3008);
      GL11.glDepthMask(true);
      GL11.glCullFace(1029);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void _stylish(float ontario, float touched, float awful, float arrested, float thoughts, int texas, int pastor) {
      _newman((double)ontario, (double)touched, (double)awful, (double)arrested, (int)pastor);
      Object leading = (float)(texas >> 24 & 255) / 255.0F;
      Object micro = (float)(texas >> 16 & 255) / 255.0F;
      Object albany = (float)(texas >> 8 & 255) / 255.0F;
      Object partners = (float)(texas & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(micro, albany, partners, leading);
      GL11.glLineWidth((float)thoughts);
      GL11.glBegin(1);
      GL11.glVertex2d((double)ontario, (double)touched);
      GL11.glVertex2d((double)ontario, (double)arrested);
      GL11.glVertex2d((double)awful, (double)arrested);
      GL11.glVertex2d((double)awful, (double)touched);
      GL11.glVertex2d((double)ontario, (double)touched);
      GL11.glVertex2d((double)awful, (double)touched);
      GL11.glVertex2d((double)ontario, (double)arrested);
      GL11.glVertex2d((double)awful, (double)arrested);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _token(double gutoboru, double vilelida, double uretelug, double carimape, float terinega, int icerovov, int inuyiviv) {
      _newman((double)gutoboru, (double)vilelida, (double)uretelug, (double)carimape, (int)inuyiviv);
      float var11 = (float)(icerovov >> 24 & 255) / 255.0F;
      float var12 = (float)(icerovov >> 16 & 255) / 255.0F;
      float var13 = (float)(icerovov >> 8 & 255) / 255.0F;
      float var14 = (float)(icerovov & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var12, var13, var14, var11);
      GL11.glLineWidth((float)terinega);
      GL11.glBegin(1);
      GL11.glVertex2d((double)gutoboru, (double)vilelida);
      GL11.glVertex2d((double)gutoboru, (double)carimape);
      GL11.glVertex2d((double)uretelug, (double)carimape);
      GL11.glVertex2d((double)uretelug, (double)vilelida);
      GL11.glVertex2d((double)gutoboru, (double)vilelida);
      GL11.glVertex2d((double)uretelug, (double)vilelida);
      GL11.glVertex2d((double)gutoboru, (double)carimape);
      GL11.glVertex2d((double)uretelug, (double)carimape);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static int _proposal(int yalutusi) {
      Object upasamas = yalutusi >> 16 & 255;
      Object anuvoviz = yalutusi >> 8 & 255;
      Object ebobemos = yalutusi & 255;
      Object rebapiro = 255;
      return (upasamas & 255) << 16 | (anuvoviz & 255) << 8 | ebobemos & 255 | (rebapiro & 255) << 24;
   }

   public static int _stream(Color ufedoyeb) {
      Object utidamuc = ((Color)ufedoyeb).getRGB() >> 16 & 255;
      Object busizudu = ((Color)ufedoyeb).getRGB() >> 8 & 255;
      Object afapenic = ((Color)ufedoyeb).getRGB() & 255;
      Object ozecezul = 255;
      return (utidamuc & 255) << 16 | (busizudu & 255) << 8 | afapenic & 255 | (ozecezul & 255) << 24;
   }

   public static int _argument(int aviganem, float cozetozo) {
      Object ifigabal = (int)((float)(aviganem >> 16 & 255) * cozetozo);
      Object acupubon = (int)((float)(aviganem >> 8 & 255) * cozetozo);
      Object eyocerar = (int)((float)(aviganem & 255) * cozetozo);
      Object atomugiy = aviganem >> 24 & 255;
      return (ifigabal & 255) << 16 | (acupubon & 255) << 8 | eyocerar & 255 | (atomugiy & 255) << 24;
   }

   public static void _clone(double sewing, double junction, double losses, double var6) {
      int var8;
      for(var8 = (new ScaledResolution(Minecraft.getMinecraft())).getScaleFactor(); var8 < 2 && Minecraft.getMinecraft().displayWidth / (var8 + 1) >= 320 && Minecraft.getMinecraft().displayHeight / (var8 + 1) >= 240; ++var8) {
         ;
      }

      GL11.glScissor((int)(sewing * (double)var8), (int)((double)Minecraft.getMinecraft().displayHeight - (junction + var6) * (double)var8), (int)(losses * (double)var8), (int)(var6 * (double)var8));
   }

   public static void _insights(String input, float skill, float ethnic, int tomato) {
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      graphics$.fontRendererObj.drawString((String)input, (int)(skill * 2.0F - 1.0F), (int)(ethnic * 2.0F), Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)input, (int)(skill * 2.0F + 1.0F), (int)(ethnic * 2.0F), Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)input, (int)(skill * 2.0F), (int)(ethnic * 2.0F - 1.0F), Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)input, (int)(skill * 2.0F), (int)(ethnic * 2.0F + 1.0F), Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)input, (int)(skill * 2.0F), (int)(ethnic * 2.0F), (int)tomato);
      GL11.glPopMatrix();
   }

   public static void _enters(String mavuduci, float eloyozey, float afopayit, int gegurumo) {
      GL11.glPushMatrix();
      graphics$.fontRendererObj.drawString((String)mavuduci, (int)(eloyozey - 1.0F), (int)afopayit, Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)mavuduci, (int)(eloyozey + 1.0F), (int)afopayit, Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)mavuduci, (int)eloyozey, (int)(afopayit - 1.0F), Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)mavuduci, (int)eloyozey, (int)(afopayit + 1.0F), Color.BLACK.getRGB());
      graphics$.fontRendererObj.drawString((String)mavuduci, (int)eloyozey, (int)afopayit, (int)gegurumo);
      GL11.glPopMatrix();
   }

   public static void _glasses(double bouquet, double morris, int var4, int var5) {
      _rolled();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      _ebook(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d((double)bouquet, (double)morris);
      GL11.glVertex2d(bouquet + 2.0D, morris + 2.0D);
      GL11.glVertex2d(bouquet + 5.0D, morris - 2.0D);
      GL11.glEnd();
      GL11.glPopMatrix();
      _alpha();
   }

   public static boolean _become(float apolobim, float fezilezu, float yopopopa, float difesici, int atibifab, int ayisodim) {
      return (float)atibifab >= apolobim && (float)ayisodim >= fezilezu && (float)atibifab < apolobim + yopopopa && (float)ayisodim < fezilezu + difesici;
   }

   public static boolean _wines(int trend, int platinum, double idaho, double classes, double var6, double var8) {
      return (double)trend > idaho && (double)trend < var6 && (double)platinum > classes && (double)platinum < var8;
   }

   public static void _feels(double ricigoce, double zunitile, int obenalez, int var5, double var6) {
      _rolled();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)obenalez);
      _ebook(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d((double)ricigoce, (double)zunitile);
      GL11.glVertex2d(ricigoce + 3.0D, zunitile + var6);
      GL11.glVertex2d(ricigoce + 6.0D, (double)zunitile);
      GL11.glEnd();
      GL11.glPopMatrix();
      _alpha();
   }

   public static void _ebook(Color pugivofu) {
      Object obezuzid = (float)(((Color)pugivofu).getRGB() >> 24 & 255) / 255.0F;
      Object fozaronu = (float)(((Color)pugivofu).getRGB() >> 16 & 255) / 255.0F;
      Object eguzuyur = (float)(((Color)pugivofu).getRGB() >> 8 & 255) / 255.0F;
      Object paladuve = (float)(((Color)pugivofu).getRGB() & 255) / 255.0F;
      GL11.glColor4f(fozaronu, eguzuyur, paladuve, obezuzid);
   }

   public static void _rolled() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void _alpha() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _mainland(BlockPos sorry, int bryan) {
      Object charger = (double)((BlockPos)sorry).getX() - graphics$.getRenderManager().renderPosX;
      Object valuable = (double)((BlockPos)sorry).getY() - graphics$.getRenderManager().renderPosY;
      Object dating = (double)((BlockPos)sorry).getZ() - graphics$.getRenderManager().renderPosZ;
      Object route = graphics$.theWorld.getBlockState((BlockPos)sorry).getBlock().getBlockBoundsMaxY() - graphics$.theWorld.getBlockState((BlockPos)sorry).getBlock().getBlockBoundsMinY();
      float var10 = (float)(bryan >> 16 & 255) / 255.0F;
      float var11 = (float)(bryan >> 8 & 255) / 255.0F;
      float var12 = (float)(bryan & 255) / 255.0F;
      float var13 = (float)(bryan >> 24 & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth(1.0F);
      GL11.glColor4f(var10, var11, var12, var13);
      _abuse(new AxisAlignedBB(charger, valuable, dating, charger + 1.0D, valuable + route, dating + 1.0D));
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GlStateManager.disableBlend();
      GL11.glPopMatrix();
   }

   public static void _abuse(AxisAlignedBB oreficum) {
      Object otetegaz = Tessellator.getInstance();
      Object esidozim = otetegaz.getWorldRenderer();
      esidozim.begin(3, DefaultVertexFormats.POSITION);
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      otetegaz.draw();
      esidozim.begin(3, DefaultVertexFormats.POSITION);
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      otetegaz.draw();
      esidozim.begin(1, DefaultVertexFormats.POSITION);
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).minZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).maxX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).minY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      esidozim.pos(((AxisAlignedBB)oreficum).minX, ((AxisAlignedBB)oreficum).maxY, ((AxisAlignedBB)oreficum).maxZ).endVertex();
      otetegaz.draw();
   }

   public static void _highest(int refer, float unique) {
      Object jungle = (float)(refer >> 16 & 255) / 255.0F;
      Object handling = (float)(refer >> 8 & 255) / 255.0F;
      Object cornwall = (float)(refer & 255) / 255.0F;
      GlStateManager.color(jungle, handling, cornwall, (float)unique);
   }

   public static void _phase(int enusenid) {
      _highest((int)enusenid, (float)(enusenid >> 24 & 255) / 255.0F);
   }

   public static void _hired(float ovemusif, float tasodeyi, float badupace, float iyoyutom, int marofati, int cefolapo) {
      Object usazisuc = (float)(marofati >> 24 & 255) / 255.0F;
      Object uyubinin = (float)(marofati >> 16 & 255) / 255.0F;
      Object zubayoya = (float)(marofati >> 8 & 255) / 255.0F;
      Object cibutato = (float)(marofati & 255) / 255.0F;
      Object zinecolo = (float)(cefolapo >> 24 & 255) / 255.0F;
      Object vunicaco = (float)(cefolapo >> 16 & 255) / 255.0F;
      Object ulecivun = (float)(cefolapo >> 8 & 255) / 255.0F;
      Object usucodin = (float)(cefolapo & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Object negozobi = Tessellator.getInstance();
      Object rovavipu = negozobi.getWorldRenderer();
      rovavipu.begin(7, DefaultVertexFormats.POSITION_COLOR);
      rovavipu.pos((double)badupace, (double)tasodeyi, Double.longBitsToDouble(0L)).color(uyubinin, zubayoya, cibutato, usazisuc).endVertex();
      rovavipu.pos((double)ovemusif, (double)tasodeyi, Double.longBitsToDouble(0L)).color(uyubinin, zubayoya, cibutato, usazisuc).endVertex();
      rovavipu.pos((double)ovemusif, (double)iyoyutom, Double.longBitsToDouble(0L)).color(vunicaco, ulecivun, usucodin, zinecolo).endVertex();
      rovavipu.pos((double)badupace, (double)iyoyutom, Double.longBitsToDouble(0L)).color(vunicaco, ulecivun, usucodin, zinecolo).endVertex();
      negozobi.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void _ukraine(double iyaloduv, double enolavuz, double afuvarum, double ibimanuv, boolean var8, int var9, int var10) {
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glBegin(7);
      _phase(var9);
      if (var8) {
         GL11.glVertex2d((double)iyaloduv, (double)enolavuz);
         GL11.glVertex2d((double)iyaloduv, (double)ibimanuv);
         _phase(var10);
         GL11.glVertex2d((double)afuvarum, (double)ibimanuv);
         GL11.glVertex2d((double)afuvarum, (double)enolavuz);
      } else {
         GL11.glVertex2d((double)iyaloduv, (double)enolavuz);
         _phase(var10);
         GL11.glVertex2d((double)iyaloduv, (double)ibimanuv);
         GL11.glVertex2d((double)afuvarum, (double)ibimanuv);
         _phase(var9);
         GL11.glVertex2d((double)afuvarum, (double)enolavuz);
      }

      GL11.glEnd();
      GL11.glDisable(3042);
      GL11.glShadeModel(7424);
      GL11.glEnable(3553);
   }

   public static void _raising(float roads, float postal, float failed, float reforms) {
      _newman((double)roads, (double)postal, (double)failed, (double)reforms, ColorUtil._contract(16777215));

      while(postal < reforms) {
         for(Object visited = roads + Float.intBitsToFloat(0); visited < failed; visited += 2.0F) {
            if (visited <= failed - 1.0F) {
               _newman((double)visited, (double)postal, (double)(visited + 1.0F), (double)(postal + 1.0F), ColorUtil._contract(8421504));
            }
         }

         ++postal;
      }

   }

   public static void _wound(int volume, int initial, float volvo, float central, int matched, int their, int civil, int accepted, float savannah, float creator) {
      Object salad = 1.0F / savannah;
      Object fingers = 1.0F / creator;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Object sparc = Tessellator.getInstance();
      Object grateful = sparc.getWorldRenderer();
      grateful.begin(7, DefaultVertexFormats.POSITION_TEX);
      grateful.pos((double)volume, (double)(initial + accepted), Double.longBitsToDouble(0L)).tex((double)(volvo * salad), (double)((central + (float)their) * fingers)).endVertex();
      grateful.pos((double)(volume + civil), (double)(initial + accepted), Double.longBitsToDouble(0L)).tex((double)((volvo + (float)matched) * salad), (double)((central + (float)their) * fingers)).endVertex();
      grateful.pos((double)(volume + civil), (double)initial, Double.longBitsToDouble(0L)).tex((double)((volvo + (float)matched) * salad), (double)(central * fingers)).endVertex();
      grateful.pos((double)volume, (double)initial, Double.longBitsToDouble(0L)).tex((double)(volvo * salad), (double)(central * fingers)).endVertex();
      sparc.draw();
   }

   public static void _hazards(ResourceLocation fulosuzi, int doticele, int noneyovo, int didazufo, int ivabivaz) {
      graphics$.getTextureManager().bindTexture((ResourceLocation)fulosuzi);
      _wound((int)doticele, (int)noneyovo, 8.0F, 8.0F, 8, 8, (int)didazufo, (int)ivabivaz, 64.0F, 64.0F);
      _wound((int)doticele, (int)noneyovo, 40.0F, 8.0F, 8, 8, (int)didazufo, (int)ivabivaz, 64.0F, 64.0F);
   }

   public static void _newman(double zopotune, double lepavega, double afacefoy, double utetayiv, int yipiruye) {
      if (zopotune < afacefoy) {
         Object mivenaru = (double)zopotune;
         zopotune = afacefoy;
         afacefoy = mivenaru;
      }

      if (lepavega < utetayiv) {
         Object var15 = (double)lepavega;
         lepavega = utetayiv;
         utetayiv = var15;
      }

      Object var16 = (float)(yipiruye >> 24 & 255) / 255.0F;
      Object gidobupo = (float)(yipiruye >> 16 & 255) / 255.0F;
      float var11 = (float)(yipiruye >> 8 & 255) / 255.0F;
      float var12 = (float)(yipiruye & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(gidobupo, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)zopotune, (double)utetayiv, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)afacefoy, (double)utetayiv, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)afacefoy, (double)lepavega, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)zopotune, (double)lepavega, Double.longBitsToDouble(0L)).endVertex();
      var13.draw();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _dublin(double monacugi, double yogeceso, double ofolacey, double zafubopo, Color odatitef) {
      if (monacugi < ofolacey) {
         Object ipupucac = (double)monacugi;
         monacugi = ofolacey;
         ofolacey = ipupucac;
      }

      if (yogeceso < zafubopo) {
         Object var15 = (double)yogeceso;
         yogeceso = zafubopo;
         zafubopo = var15;
      }

      Object var16 = (float)(((Color)odatitef).getRGB() >> 24 & 255) / 255.0F;
      Object munogeco = (float)(((Color)odatitef).getRGB() >> 16 & 255) / 255.0F;
      float var11 = (float)(((Color)odatitef).getRGB() >> 8 & 255) / 255.0F;
      float var12 = (float)(((Color)odatitef).getRGB() & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(munogeco, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)monacugi, (double)zafubopo, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)ofolacey, (double)zafubopo, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)ofolacey, (double)yogeceso, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)monacugi, (double)yogeceso, Double.longBitsToDouble(0L)).endVertex();
      var13.draw();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _always(float thesis, float company, float arbor, float hindu, float wherever, float harbor, float diamond, ResourceLocation increase) {
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)increase);
      Object later = 1.0F / arbor;
      Object adults = 1.0F / hindu;
      GL11.glColor4f((float)wherever, (float)harbor, (float)diamond, 1.0F);
      Object distinct = Tessellator.getInstance();
      Object signup = distinct.getWorldRenderer();
      signup.begin(7, DefaultVertexFormats.POSITION_TEX);
      signup.pos((double)thesis, (double)(company + hindu), Double.longBitsToDouble(0L)).tex(Double.longBitsToDouble(0L), (double)(hindu * adults)).endVertex();
      signup.pos((double)(thesis + arbor), (double)(company + hindu), Double.longBitsToDouble(0L)).tex((double)(arbor * later), (double)(hindu * adults)).endVertex();
      signup.pos((double)(thesis + arbor), (double)company, Double.longBitsToDouble(0L)).tex((double)(arbor * later), Double.longBitsToDouble(0L)).endVertex();
      signup.pos((double)thesis, (double)company, Double.longBitsToDouble(0L)).tex(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)).endVertex();
      distinct.draw();
   }

   public static void _marked(ResourceLocation telemote, float pobuzuli, float obugobit, int vinimuva, int evenemap) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)telemote);
      Object udoralav = 1.0F / (float)vinimuva;
      Object opabuvob = 1.0F / (float)evenemap;
      Object zilomiya = Tessellator.getInstance();
      Object itagociz = zilomiya.getWorldRenderer();
      itagociz.begin(7, DefaultVertexFormats.POSITION_TEX);
      itagociz.pos((double)pobuzuli, (double)(obugobit + (float)evenemap), Double.longBitsToDouble(0L)).tex((double)(Float.intBitsToFloat(0) * udoralav), (double)((float)evenemap * opabuvob)).endVertex();
      itagociz.pos((double)(pobuzuli + (float)vinimuva), (double)(obugobit + (float)evenemap), Double.longBitsToDouble(0L)).tex((double)((float)vinimuva * udoralav), (double)((float)evenemap * opabuvob)).endVertex();
      itagociz.pos((double)(pobuzuli + (float)vinimuva), (double)obugobit, Double.longBitsToDouble(0L)).tex((double)((float)vinimuva * udoralav), (double)(Float.intBitsToFloat(0) * opabuvob)).endVertex();
      itagociz.pos((double)pobuzuli, (double)obugobit, Double.longBitsToDouble(0L)).tex((double)(Float.intBitsToFloat(0) * udoralav), (double)(Float.intBitsToFloat(0) * opabuvob)).endVertex();
      zilomiya.draw();
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }
}
