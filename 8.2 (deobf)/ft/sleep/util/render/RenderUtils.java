//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.injection.interfaces.IEntityRenderer;
import ft.sleep.injection.interfaces.IRenderManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.vecmath.Vector3d;

import ft.sleep.util.timer.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.GLU;

public class RenderUtils {
   public static Minecraft criminal$ = Minecraft.getMinecraft();
   public static Frustum informal$ = new Frustum();
   public static double necklace$;
   public static double carrying$ = Double.longBitsToDouble(0L);
   public static double reduce$ = Double.longBitsToDouble(0L);
   public static Map acquire$ = new HashMap();
   public static int chain$;
   public static TimeHelper asked$ = new TimeHelper();
   public static HashMap actors$ = new HashMap();
   public static IntBuffer jumping$ = GLAllocation.createDirectIntBuffer(16);
   public static FloatBuffer belarus$ = GLAllocation.createDirectFloatBuffer(16);
   public static FloatBuffer angry$ = GLAllocation.createDirectFloatBuffer(16);
   public static boolean sunday$ = false;
   public static float attract$ = Float.intBitsToFloat(0);
   public static boolean takes$ = false;
   public static float doubt$ = Float.intBitsToFloat(0);

   public static double _features(double turned, double myself, double var4) {
      return myself + (turned - myself) * var4;
   }

   public static boolean _multi(Entity lugalela) {
      return _brand(((Entity)lugalela).getEntityBoundingBox()) || ((Entity)lugalela).ignoreFrustumCheck;
   }

   public static boolean _brand(AxisAlignedBB category) {
      Object banned = criminal$.getRenderViewEntity();
      informal$.setPosition(banned.posX, banned.posY, banned.posZ);
      return informal$.isBoundingBoxInFrustum((AxisAlignedBB)category);
   }

   public static void _syria(ResourceLocation utuzucat, double iciyutam, double ulezutac, double egugegec, double ipivucaf) {
      criminal$.getTextureManager().bindTexture((ResourceLocation)utuzucat);
      float var9 = 1.0F / (float)egugegec;
      float var10 = 1.0F / (float)ipivucaf;
      Tessellator var11 = Tessellator.getInstance();
      WorldRenderer var12 = var11.getWorldRenderer();
      var12.begin(7, DefaultVertexFormats.POSITION_TEX);
      var12.pos((double)iciyutam, (double)(ulezutac + ipivucaf), Double.longBitsToDouble(0L)).tex((double)(Float.intBitsToFloat(0) * var9), (double)((Float.intBitsToFloat(0) + (float)ipivucaf) * var10)).endVertex();
      var12.pos((double)(iciyutam + egugegec), (double)(ulezutac + ipivucaf), Double.longBitsToDouble(0L)).tex((double)((Float.intBitsToFloat(0) + (float)egugegec) * var9), (double)((Float.intBitsToFloat(0) + (float)ipivucaf) * var10)).endVertex();
      var12.pos((double)(iciyutam + egugegec), (double)ulezutac, Double.longBitsToDouble(0L)).tex((double)((Float.intBitsToFloat(0) + (float)egugegec) * var9), (double)(Float.intBitsToFloat(0) * var10)).endVertex();
      var12.pos((double)iciyutam, (double)ulezutac, Double.longBitsToDouble(0L)).tex((double)(Float.intBitsToFloat(0) * var9), (double)(Float.intBitsToFloat(0) * var10)).endVertex();
      var11.draw();
   }

   public static void _storage(float yesicovo, float oronacur, float unudical, float salibaga, int ibevemey) {
      Object zavucoda = (float)(ibevemey >> 24 & 255) / 255.0F;
      Object digodita = (float)(ibevemey >> 16 & 255) / 255.0F;
      Object utivedog = (float)(ibevemey >> 8 & 255) / 255.0F;
      Object uliliful = (float)(ibevemey & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(digodita, utivedog, uliliful, zavucoda);
      GL11.glBegin(7);
      GL11.glVertex2d((double)unudical, (double)oronacur);
      GL11.glVertex2d((double)yesicovo, (double)oronacur);
      GL11.glVertex2d((double)yesicovo, (double)salibaga);
      GL11.glVertex2d((double)unudical, (double)salibaga);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _stars(double itself, double opens, double concerts, double davis, int pools, int board) {
      Object arcade = (float)(pools >> 24 & 255) / 255.0F;
      Object child = (float)(pools >> 16 & 255) / 255.0F;
      Object kidney = (float)(pools >> 8 & 255) / 255.0F;
      Object johnson = (float)(pools & 255) / 255.0F;
      Object model = (float)(board >> 24 & 255) / 255.0F;
      Object relative = (float)(board >> 16 & 255) / 255.0F;
      float var16 = (float)(board >> 8 & 255) / 255.0F;
      float var17 = (float)(board & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var18 = Tessellator.getInstance();
      WorldRenderer var19 = var18.getWorldRenderer();
      var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var19.pos((double)concerts, (double)opens, Double.longBitsToDouble(0L)).color(child, kidney, johnson, arcade).endVertex();
      var19.pos((double)itself, (double)opens, Double.longBitsToDouble(0L)).color(child, kidney, johnson, arcade).endVertex();
      var19.pos((double)itself, (double)davis, Double.longBitsToDouble(0L)).color(relative, var16, var17, model).endVertex();
      var19.pos((double)concerts, (double)davis, Double.longBitsToDouble(0L)).color(relative, var16, var17, model).endVertex();
      var18.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void _branch(float oyoyelip, float odigiyif, float igecabez, float udezibum) {
      Object ibupigun = new ScaledResolution(criminal$);
      Object irenifir = ibupigun.getScaleFactor();
      GL11.glScissor((int)(oyoyelip * (float)irenifir), (int)(((float)ibupigun.getScaledHeight() - udezibum) * (float)irenifir), (int)((igecabez - oyoyelip) * (float)irenifir), (int)((udezibum - odigiyif) * (float)irenifir));
   }

   public static void _similar(float closely, float analyzed, float apple, float enabling, float monitor, int proposal, int fluid) {
      _storage((float)closely, (float)analyzed, (float)apple, (float)enabling, (int)fluid);
      Object turtle = (float)(proposal >> 24 & 255) / 255.0F;
      Object lawsuit = (float)(proposal >> 16 & 255) / 255.0F;
      Object italic = (float)(proposal >> 8 & 255) / 255.0F;
      Object missing = (float)(proposal & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(lawsuit, italic, missing, turtle);
      GL11.glLineWidth((float)monitor);
      GL11.glBegin(1);
      GL11.glVertex2d((double)closely, (double)analyzed);
      GL11.glVertex2d((double)closely, (double)enabling);
      GL11.glVertex2d((double)apple, (double)enabling);
      GL11.glVertex2d((double)apple, (double)analyzed);
      GL11.glVertex2d((double)closely, (double)analyzed);
      GL11.glVertex2d((double)apple, (double)analyzed);
      GL11.glVertex2d((double)closely, (double)enabling);
      GL11.glVertex2d((double)apple, (double)enabling);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _motel() {
      GL11.glEnable(2848);
      GL11.glEnable(2881);
      GL11.glEnable(2832);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glHint(3153, 4354);
   }

   public static void _reads() {
      GL11.glDisable(2848);
      GL11.glDisable(2881);
      GL11.glEnable(2832);
   }

   public static void _saudi(ScaledResolution zebegelu) {
      _storage(Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)((ScaledResolution)zebegelu).getScaledWidth(), (float)((ScaledResolution)zebegelu).getScaledHeight(), (new Color(34, 34, 34)).getRGB());
      _syria(new ResourceLocation("client/images/background.png"), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)((ScaledResolution)zebegelu).getScaledWidth(), (double)((ScaledResolution)zebegelu).getScaledHeight());
   }

   public static void _juvenile(double ifufeneg, double lagoledo, double zocepuro, double yicipapa, double var8, int var10, int var11, boolean var12) {
      _illness(ifufeneg - (!var12 ? var8 : Double.longBitsToDouble(0L)), lagoledo - (!var12 ? var8 : Double.longBitsToDouble(0L)), zocepuro + (!var12 ? var8 : Double.longBitsToDouble(0L)), yicipapa + (!var12 ? var8 : Double.longBitsToDouble(0L)), var11);
      _illness(ifufeneg + (var12 ? var8 : Double.longBitsToDouble(0L)), lagoledo + (var12 ? var8 : Double.longBitsToDouble(0L)), zocepuro - (var12 ? var8 : Double.longBitsToDouble(0L)), yicipapa - (var12 ? var8 : Double.longBitsToDouble(0L)), var10);
   }

   public static void _hammer(double criteria, double kitty, double acting, double var6, double var8, int var10) {
      _illness((double)criteria, (double)kitty, (double)(criteria + acting), kitty + var8, var10);
      _illness((double)criteria, (double)kitty, criteria + var8, kitty + var6, var10);
      _illness((double)criteria, kitty + var6 - var8, (double)(criteria + acting), kitty + var6, var10);
      _illness(criteria + acting - var8, (double)kitty, (double)(criteria + acting), kitty + var6, var10);
   }

   public static void _compared(double without, double exhibits, double amateur, double stripes, int kills, int species) {
      Object purpose = (float)(kills >> 24 & 255) / 255.0F;
      Object relying = (float)(kills >> 16 & 255) / 255.0F;
      Object legend = (float)(kills >> 8 & 255) / 255.0F;
      Object exposed = (float)(kills & 255) / 255.0F;
      float var14 = (float)(species >> 24 & 255) / 255.0F;
      float var15 = (float)(species >> 16 & 255) / 255.0F;
      float var16 = (float)(species >> 8 & 255) / 255.0F;
      float var17 = (float)(species & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(relying, legend, exposed, purpose);
      GL11.glVertex2d((double)without, (double)exhibits);
      GL11.glVertex2d((double)without, (double)stripes);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d((double)amateur, (double)stripes);
      GL11.glVertex2d((double)amateur, (double)exhibits);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void _illness(double leyetimu, double zodimura, double uroyerud, double cinuyedi, int tefusude) {
      if (leyetimu < uroyerud) {
         Object lidomuci = (double)leyetimu;
         leyetimu = uroyerud;
         uroyerud = lidomuci;
      }

      if (zodimura < cinuyedi) {
         Object var15 = (double)zodimura;
         zodimura = cinuyedi;
         cinuyedi = var15;
      }

      Object var16 = (float)(tefusude >> 24 & 255) / 255.0F;
      Object agedotep = (float)(tefusude >> 16 & 255) / 255.0F;
      float var11 = (float)(tefusude >> 8 & 255) / 255.0F;
      float var12 = (float)(tefusude & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(agedotep, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)leyetimu, (double)cinuyedi, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)uroyerud, (double)cinuyedi, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)uroyerud, (double)zodimura, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)leyetimu, (double)zodimura, Double.longBitsToDouble(0L)).endVertex();
      var13.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _mozilla(double apache, double looks, double question, double uncle, float var8) {
      if (apache < question) {
         double var9 = (double)apache;
         apache = question;
         question = var9;
      }

      if (looks < uncle) {
         double var11 = (double)looks;
         looks = uncle;
         uncle = var11;
      }

      Tessellator var12 = Tessellator.getInstance();
      WorldRenderer var10 = var12.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(0.1F, 0.1F, 0.1F, var8);
      var10.begin(7, DefaultVertexFormats.POSITION);
      var10.pos((double)apache, (double)uncle, Double.longBitsToDouble(0L)).endVertex();
      var10.pos((double)question, (double)uncle, Double.longBitsToDouble(0L)).endVertex();
      var10.pos((double)question, (double)looks, Double.longBitsToDouble(0L)).endVertex();
      var10.pos((double)apache, (double)looks, Double.longBitsToDouble(0L)).endVertex();
      var12.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _stuck(AxisAlignedBB directed) {
      Object captain = Tessellator.getInstance();
      Object gateway = captain.getWorldRenderer();
      gateway.begin(7, DefaultVertexFormats.POSITION);
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      captain.draw();
      gateway.begin(7, DefaultVertexFormats.POSITION);
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      captain.draw();
      gateway.begin(7, DefaultVertexFormats.POSITION);
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      captain.draw();
      gateway.begin(7, DefaultVertexFormats.POSITION);
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      captain.draw();
      gateway.begin(7, DefaultVertexFormats.POSITION);
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      captain.draw();
      gateway.begin(7, DefaultVertexFormats.POSITION);
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).minX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).minZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).maxY, ((AxisAlignedBB)directed).maxZ).endVertex();
      gateway.pos(((AxisAlignedBB)directed).maxX, ((AxisAlignedBB)directed).minY, ((AxisAlignedBB)directed).maxZ).endVertex();
      captain.draw();
   }

   public static void _remains(double obagalin, double cenudafa, double adesozav, double oruvogun, double inagamem, float eyiceber, float ufazezab, float usirogis, float asoredes, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)eyiceber, (float)ufazezab, (float)usirogis, (float)asoredes);
      _stuck(new AxisAlignedBB((double)(obagalin - oruvogun), (double)cenudafa, (double)(adesozav - oruvogun), (double)(obagalin + oruvogun), (double)(cenudafa + inagamem), (double)(adesozav + oruvogun)));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      _electric(new AxisAlignedBB((double)(obagalin - oruvogun), (double)cenudafa, (double)(adesozav - oruvogun), (double)(obagalin + oruvogun), (double)(cenudafa + inagamem), (double)(adesozav + oruvogun)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _heritage(double upeyufob, double gituzefu, double ufudobon, int uyatusug, int ibumadib, float nifozefo) {
      Object anavurip = (float)(uyatusug >> 24 & 255) / 255.0F;
      Object iyabuyir = (float)(uyatusug >> 16 & 255) / 255.0F;
      Object ozadocel = (float)(uyatusug >> 8 & 255) / 255.0F;
      Object zovivuyo = (float)(uyatusug & 255) / 255.0F;
      Object mesodusu = (float)(ibumadib >> 24 & 255) / 255.0F;
      float var14 = (float)(ibumadib >> 16 & 255) / 255.0F;
      float var15 = (float)(ibumadib >> 8 & 255) / 255.0F;
      float var16 = (float)(ibumadib & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(iyabuyir, ozadocel, zovivuyo, anavurip);
      _electric(new AxisAlignedBB((double)upeyufob, (double)gituzefu, (double)ufudobon, upeyufob + 1.0D, gituzefu + 1.0D, ufudobon + 1.0D));
      GL11.glLineWidth((float)nifozefo);
      GL11.glColor4f(var14, var15, var16, mesodusu);
      _electric(new AxisAlignedBB((double)upeyufob, (double)gituzefu, (double)ufudobon, upeyufob + 1.0D, gituzefu + 1.0D, ufudobon + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _electric(AxisAlignedBB omemedad) {
      Object ufonumud = Tessellator.getInstance();
      Object gelotice = ufonumud.getWorldRenderer();
      gelotice.begin(3, DefaultVertexFormats.POSITION);
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      ufonumud.draw();
      gelotice.begin(3, DefaultVertexFormats.POSITION);
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      ufonumud.draw();
      gelotice.begin(1, DefaultVertexFormats.POSITION);
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).minZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).maxX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).minY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      gelotice.pos(((AxisAlignedBB)omemedad).minX, ((AxisAlignedBB)omemedad).maxY, ((AxisAlignedBB)omemedad).maxZ).endVertex();
      ufonumud.draw();
   }

   public static void _videos(double ladibuvu, double ruzurabo, double agipilos, double itopofuy, int arelulos) {
      if (ladibuvu < agipilos) {
         Object ogicoloy = (double)ladibuvu;
         ladibuvu = agipilos;
         agipilos = ogicoloy;
      }

      if (ruzurabo < itopofuy) {
         Object var17 = (double)ruzurabo;
         ruzurabo = itopofuy;
         itopofuy = var17;
      }

      Object celacadu = (float)(arelulos >> 24 & 255) / 255.0F;
      float var12 = (float)(arelulos >> 16 & 255) / 255.0F;
      float var13 = (float)(arelulos >> 8 & 255) / 255.0F;
      float var14 = (float)(arelulos & 255) / 255.0F;
      Tessellator var15 = Tessellator.getInstance();
      WorldRenderer var16 = var15.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var12, var13, var14, celacadu);
      var16.begin(7, DefaultVertexFormats.POSITION);
      var16.pos((double)ladibuvu, (double)itopofuy, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)agipilos, (double)itopofuy, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)agipilos, (double)ruzurabo, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)ladibuvu, (double)ruzurabo, Double.longBitsToDouble(0L)).endVertex();
      var15.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _vampire(double nizitada, double cileguna, double rumamufu, double udidipef, double var8, int var10, int var11) {
      _videos(nizitada + var8, cileguna + var8, rumamufu - var8, udidipef - var8, var10);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _videos(nizitada + var8, (double)cileguna, rumamufu - var8, cileguna + var8, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _videos((double)nizitada, (double)cileguna, nizitada + var8, (double)udidipef, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _videos(rumamufu - var8, (double)cileguna, (double)rumamufu, (double)udidipef, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _videos(nizitada + var8, udidipef - var8, rumamufu - var8, (double)udidipef, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _bedrooms(int omacasan) {
      Object ugevopem = (float)(omacasan >> 24 & 255) / 255.0F;
      Object azavogim = (float)(omacasan >> 16 & 255) / 255.0F;
      Object fefunuzu = (float)(omacasan >> 8 & 255) / 255.0F;
      Object uvafogey = (float)(omacasan & 255) / 255.0F;
      GL11.glColor4f(azavogim, fefunuzu, uvafogey, ugevopem);
   }

   public static void _rotary(float licenses, float airfare, float buffalo, float suddenly, float battle, float armenia, int warnings) {
      GlStateManager.color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glColor4f(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object gregory = Float.intBitsToFloat(0);
      if (buffalo > suddenly) {
         gregory = (float)suddenly;
         suddenly = buffalo;
         buffalo = gregory;
      }

      Object giant = (float)(warnings >> 24 & 255) / 255.0F;
      Object found = (float)(warnings >> 16 & 255) / 255.0F;
      Object chassis = (float)(warnings >> 8 & 255) / 255.0F;
      Object fridge = (float)(warnings & 255) / 255.0F;
      Object biblical = Tessellator.getInstance();
      Object assuming = biblical.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(found, chassis, fridge, giant);
      if (giant > 0.5F) {
         GL11.glEnable(2848);
         GL11.glLineWidth(2.0F);
         GL11.glBegin(3);

         for(Object killed = (float)suddenly; killed >= buffalo; killed -= 4.0F) {
            Object precious = (float)Math.cos((double)killed * 3.141592653589793D / 180.0D) * battle * 1.001F;
            float var16 = (float)Math.sin((double)killed * 3.141592653589793D / 180.0D) * armenia * 1.001F;
            GL11.glVertex2f(licenses + precious, airfare + var16);
         }

         GL11.glEnd();
         GL11.glDisable(2848);
      }

      GL11.glBegin(6);

      for(Object var18 = (float)suddenly; var18 >= buffalo; var18 -= 4.0F) {
         Object var19 = (float)Math.cos((double)var18 * 3.141592653589793D / 180.0D) * battle;
         float var20 = (float)Math.sin((double)var18 * 3.141592653589793D / 180.0D) * armenia;
         GL11.glVertex2f(licenses + var19, airfare + var20);
      }

      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _father(float asagazal, float sumaneyo, float ucatobaf, float zegotace, float nadocuca, int rucetimi) {
      _rotary((float)asagazal, (float)sumaneyo, (float)ucatobaf, (float)zegotace, (float)nadocuca, (float)nadocuca, (int)rucetimi);
   }

   public static void _pressing(float nuferini, float zoriyigu, float uzazubev, int udozifap) {
      _father((float)nuferini, (float)zoriyigu, Float.intBitsToFloat(0), 360.0F, (float)uzazubev, (int)udozifap);
   }

   public static void _chairs(float honey, float mostly, float yours, float planned, float relates, int cooler) {
      honey = honey + (float)((double)(relates / 2.0F) + 0.5D);
      mostly = mostly + (float)((double)(relates / 2.0F) + 0.5D);
      yours = yours - (float)((double)(relates / 2.0F) + 0.5D);
      planned = planned - (float)((double)(relates / 2.0F) + 0.5D);
      Gui.drawRect((int)honey, (int)mostly, (int)yours, (int)planned, (int)cooler);
      _pressing(yours - relates / 2.0F, mostly + relates / 2.0F, (float)relates, (int)cooler);
      _pressing(honey + relates / 2.0F, planned - relates / 2.0F, (float)relates, (int)cooler);
      _pressing(honey + relates / 2.0F, mostly + relates / 2.0F, (float)relates, (int)cooler);
      _pressing(yours - relates / 2.0F, planned - relates / 2.0F, (float)relates, (int)cooler);
      Gui.drawRect((int)(honey - relates / 2.0F - 0.5F), (int)(mostly + relates / 2.0F), (int)yours, (int)(planned - relates / 2.0F), (int)cooler);
      Gui.drawRect((int)honey, (int)(mostly + relates / 2.0F), (int)(yours + relates / 2.0F + 0.5F), (int)(planned - relates / 2.0F), (int)cooler);
      Gui.drawRect((int)(honey + relates / 2.0F), (int)(mostly - relates / 2.0F - 0.5F), (int)(yours - relates / 2.0F), (int)(planned - relates / 2.0F), (int)cooler);
      Gui.drawRect((int)(honey + relates / 2.0F), (int)mostly, (int)(yours - relates / 2.0F), (int)(planned + relates / 2.0F + 0.5F), (int)cooler);
   }

   public static void _testing(ResourceLocation knock, int belize, int extreme, int speech, int ukraine, Color extend) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f((float)((Color)extend).getRed() / 255.0F, (float)((Color)extend).getBlue() / 255.0F, (float)((Color)extend).getRed() / 255.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)knock);
      Gui.drawModalRectWithCustomSizedTexture((int)belize, (int)extreme, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)speech, (int)ukraine, (float)speech, (float)ukraine);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _sensors(float cedar) {
      attract$ = (float)cedar;
      sunday$ = true;
      criminal$.thePlayer.rotationYawHead = (float)cedar;
   }

   public static void _worldcat() {
      sunday$ = false;
   }

   public static float _anchor() {
      return attract$;
   }

   public static void _tigers(float transfer) {
      doubt$ = (float)transfer;
      takes$ = true;
   }

   public static void _edwards() {
      takes$ = false;
   }

   public static float _flight() {
      return doubt$;
   }

   public static void _program(Color zovagufa) {
      Object otozepeg = (float)((Color)zovagufa).getRed() / 255.0F;
      Object enarapig = (float)((Color)zovagufa).getGreen() / 255.0F;
      Object mosepadu = (float)((Color)zovagufa).getBlue() / 255.0F;
      Object imemaler = (float)((Color)zovagufa).getAlpha() / 255.0F;
      GlStateManager.color(otozepeg, enarapig, mosepadu, imemaler);
   }

   public static void _asbestos() {
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
   }

   public static void _adding() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glColor3d(1.0D, 1.0D, 1.0D);
   }

   public static void _patio(int tufigedu, int iyomacuv, int susecule, EntityLivingBase yamozevo) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)tufigedu, (float)iyomacuv, 50.0F);
      GlStateManager.scale((float)(-susecule), (float)susecule, (float)susecule);
      GlStateManager.rotate(180.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      Object egodopob = ((EntityLivingBase)yamozevo).renderYawOffset;
      Object onidopir = ((EntityLivingBase)yamozevo).rotationYaw;
      Object opucudir = ((EntityLivingBase)yamozevo).rotationPitch;
      Object cideritu = ((EntityLivingBase)yamozevo).prevRotationYawHead;
      Object orefupar = ((EntityLivingBase)yamozevo).rotationYawHead;
      GlStateManager.rotate(135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.rotate(Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      ((EntityLivingBase)yamozevo).renderYawOffset = (float)(10 * ((EntityLivingBase)yamozevo).ticksExisted % 360);
      ((EntityLivingBase)yamozevo).rotationYaw = (float)(10 * ((EntityLivingBase)yamozevo).ticksExisted % 360);
      ((EntityLivingBase)yamozevo).rotationPitch = Float.intBitsToFloat(0);
      ((EntityLivingBase)yamozevo).rotationYawHead = ((EntityLivingBase)yamozevo).rotationYaw;
      ((EntityLivingBase)yamozevo).prevRotationYawHead = ((EntityLivingBase)yamozevo).rotationYaw;
      GlStateManager.translate(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object botabomi = Minecraft.getMinecraft().getRenderManager();
      botabomi.setPlayerViewY(180.0F);
      botabomi.setRenderShadow(false);
      botabomi.renderEntityWithPosYaw((Entity)yamozevo, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Float.intBitsToFloat(0), 1.0F);
      botabomi.setRenderShadow(true);
      ((EntityLivingBase)yamozevo).renderYawOffset = egodopob;
      ((EntityLivingBase)yamozevo).rotationYaw = onidopir;
      ((EntityLivingBase)yamozevo).rotationPitch = opucudir;
      ((EntityLivingBase)yamozevo).prevRotationYawHead = cideritu;
      ((EntityLivingBase)yamozevo).rotationYawHead = orefupar;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static void _lamps(ItemStack zizimeyi, int ogunalog, int begeyire) {
      GlStateManager.pushMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.clear(256);
      RenderHelper.enableStandardItemLighting();
      Minecraft.getMinecraft().getRenderItem().zLevel = -150.0F;
      GlStateManager.disableDepth();
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
      GlStateManager.enableLighting();
      GlStateManager.enableDepth();
      Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI((ItemStack)zizimeyi, (int)ogunalog, (int)begeyire);
      Minecraft.getMinecraft().getRenderItem().renderItemOverlays(Minecraft.getMinecraft().fontRendererObj, (ItemStack)zizimeyi, (int)ogunalog, (int)begeyire);
      Minecraft.getMinecraft().getRenderItem().zLevel = Float.intBitsToFloat(0);
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableCull();
      GlStateManager.enableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.disableLighting();
      GlStateManager.disableDepth();
      GlStateManager.enableDepth();
      GlStateManager.popMatrix();
   }

   public static int _licence(float uzilovum, float ayuluful) {
      Object budupuyu = uzilovum / ayuluful / 3.0F;
      return Color.HSBtoRGB(budupuyu, 1.0F, 1.0F);
   }

   public static void _observe(float baptist, float leeds, float railway, float urban, int mattress) {
      _storage((float)baptist, (float)leeds, (float)(baptist + railway), (float)(leeds + urban), (int)mattress);
   }

   public static double _damages(double dennis, double brunette, double var4) {
      return (1.0D - var4) * dennis + var4 * brunette;
   }

   public static double _kijiji(double sheriff, double smaller, float var4) {
      return sheriff + (smaller - sheriff) * (double)var4;
   }

   public static float _monitors(float cadoguna, float vuforugo, float denucabi) {
      return (float)(cadoguna + (vuforugo - cadoguna) * denucabi);
   }

   public static void _disclose() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void _ensemble() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void _modem(int cakes) {
      Object donate = (float)(cakes >> 24 & 255) / 255.0F;
      Object stevens = (float)(cakes >> 16 & 255) / 255.0F;
      Object cooking = (float)(cakes >> 8 & 255) / 255.0F;
      Object mexican = (float)(cakes & 255) / 255.0F;
      GL11.glColor4f(stevens, cooking, mexican, donate);
   }

   public static void _folding(float onugales, float vomoyumo, float afevetod, float rufumude, float butimiyu, int unicaled, int acavovup) {
      _disclose();
      _storage((float)onugales, (float)vomoyumo, (float)afevetod, (float)rufumude, (int)unicaled);
      _modem((int)acavovup);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth((float)butimiyu);
      GL11.glBegin(3);
      GL11.glVertex2f((float)onugales, (float)vomoyumo);
      GL11.glVertex2f((float)onugales, (float)rufumude);
      GL11.glVertex2f((float)afevetod, (float)rufumude);
      GL11.glVertex2f((float)afevetod, (float)vomoyumo);
      GL11.glVertex2f((float)onugales, (float)vomoyumo);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      _ensemble();
   }

   public static void _coverage() {
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

   public static void _failed(float iyosumob) {
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
      GL11.glLineWidth((float)iyosumob);
   }

   public static void _graphs(Entity jesse, double owner, double assists, double parade, double var7, int var9, int var10) {
      Cylinder var11 = new Cylinder();
      GL11.glPushMatrix();
      GL11.glTranslated((double)owner, (double)assists, (double)parade);
      _modem(0);
      _failed(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      _modem(var10);
      GL11.glBegin(2);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), Float.intBitsToFloat(0), var9, 0);
      var11.setDrawStyle(100011);
      _coverage();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GlStateManager.translate((double)owner, (double)assists, (double)parade);
      _failed(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      _modem(var10);
      GL11.glBegin(2);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), Float.intBitsToFloat(0), var9, 0);
      _coverage();
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void _tablet(Entity ocupitog, double ipofovad, double opiyecen, double fotibiva, double var7, int var9, int var10) {
      Cylinder var11 = new Cylinder();
      GL11.glPushMatrix();
      GL11.glTranslated((double)ipofovad, (double)opiyecen, (double)fotibiva);
      _modem(0);
      _failed(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      _modem(var10);
      GL11.glBegin(3);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), Float.intBitsToFloat(0), var9, 0);
      var11.setDrawStyle(100011);
      _coverage();
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GlStateManager.translate((double)ipofovad, (double)opiyecen, (double)fotibiva);
      _failed(3.5F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      _modem(var10);
      GL11.glBegin(3);
      GL11.glEnd();
      var11.draw((float)(var7 + 0.25D), (float)(var7 + 0.25D), Float.intBitsToFloat(0), var9, 0);
      _coverage();
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void _manner(AxisAlignedBB uvalutot) {
      Object avoneboy = Tessellator.getInstance();
      Object zasadoca = avoneboy.getWorldRenderer();
      zasadoca.begin(3, DefaultVertexFormats.POSITION);
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      avoneboy.draw();
      zasadoca.begin(3, DefaultVertexFormats.POSITION);
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      avoneboy.draw();
      zasadoca.begin(1, DefaultVertexFormats.POSITION);
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).minZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).maxX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).minY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      zasadoca.pos(((AxisAlignedBB)uvalutot).minX, ((AxisAlignedBB)uvalutot).maxY, ((AxisAlignedBB)uvalutot).maxZ).endVertex();
      avoneboy.draw();
   }

   public static void _watch(ResourceLocation fecisusu, int idilaced, int epubugog, int mirulaba, int ecosofuy) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)fecisusu);
      Gui.drawModalRectWithCustomSizedTexture((int)idilaced, (int)epubugog, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)mirulaba, (int)ecosofuy, (float)mirulaba, (float)ecosofuy);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static int _blink(int imipogip, int razufifi, float fuyitire) {
      Object domubesi = 1.0F - fuyitire;
      Object isomeziy = (int)((float)(imipogip >> 16 & 255) * domubesi + (float)(razufifi >> 16 & 255) * fuyitire);
      Object salasimi = (int)((float)(imipogip >> 8 & 255) * domubesi + (float)(razufifi >> 8 & 255) * fuyitire);
      Object gefetose = (int)((float)(imipogip & 255) * domubesi + (float)(razufifi & 255) * fuyitire);
      Object iyobucup = (int)((float)(imipogip >> 24 & 255) * domubesi + (float)(razufifi >> 24 & 255) * fuyitire);
      return (iyobucup & 255) << 24 | (isomeziy & 255) << 16 | (salasimi & 255) << 8 | gefetose & 255;
   }

   public static void _chicken() {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
   }

   public static void _pleasure(int payavefe) {
      GL11.glColor4ub((byte)(payavefe >> 16 & 255), (byte)(payavefe >> 8 & 255), (byte)(payavefe & 255), (byte)(payavefe >> 24 & 255));
   }

   public static void _bookings(Color opiyapon) {
      Object ayataben = (float)((Color)opiyapon).getRed() / 255.0F;
      Object oyonubul = (float)((Color)opiyapon).getGreen() / 255.0F;
      Object gecobifo = (float)((Color)opiyapon).getBlue() / 255.0F;
      Object buzeruso = (float)((Color)opiyapon).getAlpha() / 255.0F;
      GlStateManager.color(ayataben, oyonubul, gecobifo, buzeruso);
   }

   public static void _wagon(AxisAlignedBB february, Color enormous) {
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)((Color)enormous).getRed() / 255.0F, (float)((Color)enormous).getGreen() / 255.0F, (float)((Color)enormous).getBlue() / 255.0F, 0.25F);
      _sells((AxisAlignedBB)february);
      GlStateManager.resetColor();
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
   }

   public static void _sells(AxisAlignedBB prepare) {
      Object searched = Tessellator.getInstance();
      Object portugal = searched.getWorldRenderer();
      portugal.begin(7, DefaultVertexFormats.POSITION);
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      searched.draw();
      portugal.begin(7, DefaultVertexFormats.POSITION);
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      searched.draw();
      portugal.begin(7, DefaultVertexFormats.POSITION);
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      searched.draw();
      portugal.begin(7, DefaultVertexFormats.POSITION);
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      searched.draw();
      portugal.begin(7, DefaultVertexFormats.POSITION);
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      searched.draw();
      portugal.begin(7, DefaultVertexFormats.POSITION);
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).minX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).minZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).maxY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      portugal.pos(((AxisAlignedBB)prepare).maxX, ((AxisAlignedBB)prepare).minY, ((AxisAlignedBB)prepare).maxZ).endVertex();
      searched.draw();
   }

   public static void _decision() {
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

   public static void _photos() {
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      if (!GL11.glIsEnabled(2896)) {
         ;
      }

   }

   public static void _hitachi(BlockPos eyurusem, int livucaba) {
      Object umazuner = (double)((BlockPos)eyurusem).getX() - criminal$.getRenderManager().renderPosX + 0.5D;
      Object vinavace = (double)((BlockPos)eyurusem).getY() - criminal$.getRenderManager().renderPosY + 0.5D;
      Object ulamemal = (double)((BlockPos)eyurusem).getZ() - criminal$.getRenderManager().renderPosZ + 0.5D;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
      float var10000 = (float)(criminal$.thePlayer.posX - (double)((BlockPos)eyurusem).getX());
      var10000 = (float)(criminal$.thePlayer.posY - (double)((BlockPos)eyurusem).getY());
      float var10 = (float)(livucaba >> 16 & 255) / 255.0F;
      float var11 = (float)(livucaba >> 8 & 255) / 255.0F;
      float var12 = (float)(livucaba & 255) / 255.0F;
      float var13 = (float)(livucaba >> 24 & 255) / 255.0F;
      GL11.glColor4f(var10, var11, var12, var13);
      GL11.glLoadIdentity();
      boolean var14 = criminal$.gameSettings.viewBobbing;
      criminal$.gameSettings.viewBobbing = false;
      ((IEntityRenderer)criminal$.entityRenderer).runorientCamera(Helper._pillow().renderPartialTicks);
      GL11.glBegin(3);
      GL11.glVertex3d(Double.longBitsToDouble(0L), (double)criminal$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L));
      GL11.glVertex3d(umazuner, vinavace, ulamemal);
      GL11.glVertex3d(umazuner, vinavace, ulamemal);
      GL11.glEnd();
      criminal$.gameSettings.viewBobbing = var14;
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _charlie(double ulurubog, double ufedenaz, double rileyaze, int larosupo) {
      Object iyurudif = ulurubog - criminal$.getRenderManager().renderPosX;
      Object dayopudi = ufedenaz - criminal$.getRenderManager().renderPosY;
      double var11 = rileyaze - criminal$.getRenderManager().renderPosZ;
      float var13 = (float)(larosupo >> 16 & 255) / 255.0F;
      float var14 = (float)(larosupo >> 8 & 255) / 255.0F;
      float var15 = (float)(larosupo & 255) / 255.0F;
      float var16 = (float)(larosupo >> 24 & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth(1.0F);
      GL11.glColor4f(var13, var14, var15, var16);
      _electric(new AxisAlignedBB(iyurudif, dayopudi, var11, iyurudif + 1.0D, dayopudi + 1.0D, var11 + 1.0D));
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _supplied(BlockPos zimalaca, int usipulad) {
      Object giyumimi = (double)((BlockPos)zimalaca).getX() - criminal$.getRenderManager().renderPosX;
      Object deyagomi = (double)((BlockPos)zimalaca).getY() - criminal$.getRenderManager().renderPosY;
      Object amovizob = (double)((BlockPos)zimalaca).getZ() - criminal$.getRenderManager().renderPosZ;
      Object ipadufur = criminal$.theWorld.getBlockState((BlockPos)zimalaca).getBlock().getBlockBoundsMaxY() - criminal$.theWorld.getBlockState((BlockPos)zimalaca).getBlock().getBlockBoundsMinY();
      float var10 = (float)(usipulad >> 16 & 255) / 255.0F;
      float var11 = (float)(usipulad >> 8 & 255) / 255.0F;
      float var12 = (float)(usipulad & 255) / 255.0F;
      float var13 = (float)(usipulad >> 24 & 255) / 255.0F;
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
      _electric(new AxisAlignedBB(giyumimi, deyagomi, amovizob, giyumimi + 1.0D, deyagomi + ipadufur, amovizob + 1.0D));
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

   public static void _enhance(double vofaludu, double mufofuvo, double feloluna, double fufamito, float geborilo, int imobacos, int titagudo) {
      _storage((float)vofaludu, (float)mufofuvo, (float)feloluna, (float)fufamito, (int)titagudo);
      float var11 = (float)(imobacos >> 24 & 255) / 255.0F;
      float var12 = (float)(imobacos >> 16 & 255) / 255.0F;
      float var13 = (float)(imobacos >> 8 & 255) / 255.0F;
      float var14 = (float)(imobacos & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var12, var13, var14, var11);
      GL11.glLineWidth((float)geborilo);
      GL11.glBegin(1);
      GL11.glVertex2d((double)vofaludu, (double)mufofuvo);
      GL11.glVertex2d((double)vofaludu, (double)fufamito);
      GL11.glVertex2d((double)feloluna, (double)fufamito);
      GL11.glVertex2d((double)feloluna, (double)mufofuvo);
      GL11.glVertex2d((double)vofaludu, (double)mufofuvo);
      GL11.glVertex2d((double)feloluna, (double)mufofuvo);
      GL11.glVertex2d((double)vofaludu, (double)fufamito);
      GL11.glVertex2d((double)feloluna, (double)fufamito);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glPopMatrix();
      GL11.glColor4f(255.0F, 1.0F, 1.0F, 255.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _james(EntityLivingBase rewards, EventRender3D kennedy) {
      Object meetings = 0.25F;
      Object hudson = 4.0F;
      GL11.glPushMatrix();
      Object display = ((EntityLivingBase)rewards).lastTickPosX + (((EntityLivingBase)rewards).posX - ((EntityLivingBase)rewards).lastTickPosX) * (double)((EventRender3D)kennedy).getPartialTicks();
      Object diploma = display - ((IRenderManager)criminal$.getRenderManager()).getVieWerPosX();
      double var8 = ((EntityLivingBase)rewards).lastTickPosY + (((EntityLivingBase)rewards).posY - ((EntityLivingBase)rewards).lastTickPosY) * (double)((EventRender3D)kennedy).getPartialTicks();
      double var10 = var8 - ((IRenderManager)criminal$.getRenderManager()).getVieWerPosY() + (double)((EntityLivingBase)rewards).height * 1.1D;
      double var12 = ((EntityLivingBase)rewards).lastTickPosZ + (((EntityLivingBase)rewards).posZ - ((EntityLivingBase)rewards).lastTickPosZ) * (double)((EventRender3D)kennedy).getPartialTicks();
      GL11.glTranslated(diploma, var10, var12 - ((IRenderManager)criminal$.getRenderManager()).getVieWerPosZ());
      GL11.glRotatef(-((EntityLivingBase)rewards).width, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      _modem(((EntityLivingBase)rewards).hurtTime <= 0 ? (new Color(80, 255, 80, 80)).getRGB() : (new Color(255, 0, 0, 80)).getRGB());
      _failed(1.5F);
      Cylinder var14 = new Cylinder();
      GL11.glRotatef(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      var14.draw(Float.intBitsToFloat(0), 0.25F, 0.3F, 4, 1);
      var14.setDrawStyle(100012);
      GL11.glTranslated(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0.3D);
      var14.draw(0.25F, Float.intBitsToFloat(0), 0.3F, 4, 1);
      GL11.glRotatef(90.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      GL11.glTranslated(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), -0.3D);
      var14.draw(Float.intBitsToFloat(0), 0.25F, 0.3F, 4, 1);
      GL11.glTranslated(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0.3D);
      var14.draw(0.25F, Float.intBitsToFloat(0), 0.3F, 4, 1);
      _coverage();
      GL11.glPopMatrix();
   }

   public static void _adelaide(Entity mededave, Color sanufope) {
      Object efuyalem = criminal$.getRenderManager();
      Object usetecid = criminal$.timer;
      GL11.glBlendFunc(770, 771);
      _motor(3042);
      _swingers(3553, 2929);
      GL11.glDepthMask(false);
      Object temofure = ((Entity)mededave).lastTickPosX + (((Entity)mededave).posX - ((Entity)mededave).lastTickPosX) * (double)usetecid.renderPartialTicks - efuyalem.renderPosX;
      Object dafagilu = ((Entity)mededave).lastTickPosY + (((Entity)mededave).posY - ((Entity)mededave).lastTickPosY) * (double)usetecid.renderPartialTicks - efuyalem.renderPosY;
      Object payinulo = ((Entity)mededave).lastTickPosZ + (((Entity)mededave).posZ - ((Entity)mededave).lastTickPosZ) * (double)usetecid.renderPartialTicks - efuyalem.renderPosZ;
      AxisAlignedBB var10 = ((Entity)mededave).getEntityBoundingBox();
      AxisAlignedBB var11 = new AxisAlignedBB(var10.minX - ((Entity)mededave).posX + temofure - 0.1D, var10.minY - ((Entity)mededave).posY + dafagilu, var10.minZ - ((Entity)mededave).posZ + payinulo - 0.1D, var10.maxX - ((Entity)mededave).posX + temofure + 0.1D, var10.maxY - ((Entity)mededave).posY + dafagilu + 0.15D, var10.maxZ - ((Entity)mededave).posZ + payinulo + 0.1D);
      GL11.glLineWidth(1.0F);
      _motor(2848);
      _quest(((Color)sanufope).getRed(), ((Color)sanufope).getGreen(), ((Color)sanufope).getBlue(), ((Color)sanufope).getAlpha() + 75);
      _manner(var11);
      _quest(((Color)sanufope).getRed(), ((Color)sanufope).getGreen(), ((Color)sanufope).getBlue(), ((Color)sanufope).getAlpha());
      _sells(var11);
      GlStateManager.resetColor();
      GL11.glDepthMask(true);
      _usage();
   }

   public static void _refuse(Entity having, Color midwest) {
      if (KillAura.lesbians$ != null) {
         Object breaks = ((Entity)having).lastTickPosX + (((Entity)having).posX - ((Entity)having).lastTickPosX) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)criminal$.getRenderManager()).getRenderPosX();
         Object playback = ((Entity)having).lastTickPosY + (((Entity)having).posY - ((Entity)having).lastTickPosY) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)criminal$.getRenderManager()).getRenderPosY();
         double var6 = ((Entity)having).lastTickPosZ + (((Entity)having).posZ - ((Entity)having).lastTickPosZ) * (double) Helper._pillow().renderPartialTicks - ((IRenderManager)criminal$.getRenderManager()).getRenderPosZ();
         AxisAlignedBB var8 = ((Entity)having).getEntityBoundingBox().offset(-((Entity)having).posX, -((Entity)having).posY, -((Entity)having).posZ).offset(breaks, playback - 0.41D, var6);
         _wagon(new AxisAlignedBB(var8.minX, var8.maxY + 0.2D, var8.minZ, var8.maxX, var8.maxY + 0.26D, var8.maxZ), (Color)midwest);
      }

   }

   public static void _hands(float twins, float carnival, float breath, float binary, float believes, float glance, int nepal, int behavior, float drivers, float commons) {
      Object depend = 1.0F / drivers;
      Object bermuda = 1.0F / commons;
      Object abroad = Tessellator.getInstance();
      Object still = abroad.getWorldRenderer();
      still.begin(7, DefaultVertexFormats.POSITION_TEX);
      still.pos((double)twins, (double)(carnival + (float)behavior), Double.longBitsToDouble(0L)).tex((double)(breath * depend), (double)((binary + glance) * bermuda)).endVertex();
      still.pos((double)(twins + (float)nepal), (double)(carnival + (float)behavior), Double.longBitsToDouble(0L)).tex((double)((breath + believes) * depend), (double)((binary + glance) * bermuda)).endVertex();
      still.pos((double)(twins + (float)nepal), (double)carnival, Double.longBitsToDouble(0L)).tex((double)((breath + believes) * depend), (double)(binary * bermuda)).endVertex();
      still.pos((double)twins, (double)carnival, Double.longBitsToDouble(0L)).tex((double)(breath * depend), (double)(binary * bermuda)).endVertex();
      abroad.draw();
   }

   public static void _michelle(float uteducaf, float cupumuvu, float uceladoy, float gifotomo, int umetiguz, int ecasibet, int viyaciti, int esugudod, float vonazuye, float orevegid) {
      _hands((float)uteducaf, (float)cupumuvu, (float)uceladoy, (float)gifotomo, (float)umetiguz, (float)ecasibet, (int)viyaciti, (int)esugudod, (float)vonazuye, (float)orevegid);
   }

   public static void _formerly(int filme, int unlikely, int thongs, NetworkPlayerInfo versus) {
      criminal$.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
      Object domain = 0;
      Object hello = 0;
      if (versus != null) {
         if (((NetworkPlayerInfo)versus).getResponseTime() < 0) {
            domain = 5;
         }

         if (((NetworkPlayerInfo)versus).getResponseTime() < 150) {
            domain = 0;
         }

         if (((NetworkPlayerInfo)versus).getResponseTime() < 300) {
            domain = 1;
         }

         if (((NetworkPlayerInfo)versus).getResponseTime() < 600) {
            domain = 2;
         }

         if (((NetworkPlayerInfo)versus).getResponseTime() < 1000) {
            domain = 3;
         } else {
            domain = 4;
         }
      } else {
         domain = 0;
      }

      _guyana(unlikely + filme - 11, (int)thongs, hello * 10, 176 + domain * 8, 10, 8);
   }

   public static void _guyana(int iverutot, int punizegu, int remobepu, int omuyavis, int guyoyigu, int licutugi) {
      Object ivivavom = 0.00390625F;
      Object azuvubun = Tessellator.getInstance();
      Object yerecina = azuvubun.getWorldRenderer();
      yerecina.begin(7, DefaultVertexFormats.POSITION_TEX);
      yerecina.pos((double)iverutot, (double)(punizegu + licutugi), Double.longBitsToDouble(0L)).tex((double)((float)remobepu * ivivavom), (double)((float)(omuyavis + licutugi) * ivivavom)).endVertex();
      yerecina.pos((double)(iverutot + guyoyigu), (double)(punizegu + licutugi), Double.longBitsToDouble(0L)).tex((double)((float)(remobepu + guyoyigu) * ivivavom), (double)((float)(omuyavis + licutugi) * ivivavom)).endVertex();
      yerecina.pos((double)(iverutot + guyoyigu), (double)punizegu, Double.longBitsToDouble(0L)).tex((double)((float)(remobepu + guyoyigu) * ivivavom), (double)((float)omuyavis * ivivavom)).endVertex();
      yerecina.pos((double)iverutot, (double)punizegu, Double.longBitsToDouble(0L)).tex((double)((float)remobepu * ivivavom), (double)((float)omuyavis * ivivavom)).endVertex();
      azuvubun.draw();
   }

   public static void _wanna(double omuzelaz, double adeliyuv, double icadulig, double var6, Color var8) {
      _manuals((double)omuzelaz, (double)adeliyuv, (double)icadulig, var6, true, var8);
   }

   public static void _manuals(double ogovecap, double ecayepoy, double epupepal, double var6, boolean var8, Color var9) {
      _reprint();
      if (var9 != null) {
         _added(var9);
      }

      _gained(var8 ? 6 : 1);
      _frost((double)ogovecap, (double)ecayepoy);
      _frost((double)(ogovecap + epupepal), (double)ecayepoy);
      _frost((double)(ogovecap + epupepal), ecayepoy + var6);
      _frost((double)ogovecap, ecayepoy + var6);
      if (!var8) {
         _frost((double)ogovecap, (double)ecayepoy);
         _frost((double)ogovecap, ecayepoy + var6);
         _frost((double)(ogovecap + epupepal), (double)ecayepoy);
         _frost((double)(ogovecap + epupepal), ecayepoy + var6);
      }

      _domain();
      _naturals();
   }

   public static void _reprint() {
      _reggae(3042);
      GL11.glBlendFunc(770, 771);
      _deadly(3553);
      _deadly(2884);
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
   }

   public static void _reggae(int delays) {
      GL11.glEnable((int)delays);
   }

   public static void _added(Color implies) {
      if (implies == null) {
         implies = Color.white;
      }

      _cached((double)((float)((Color)implies).getRed() / 255.0F), (double)((float)((Color)implies).getGreen() / 255.0F), (double)((float)((Color)implies).getBlue() / 255.0F), (double)((float)((Color)implies).getAlpha() / 255.0F));
   }

   public static void _cached(double arebazod, double uvubocil, double var4, double var6) {
      GL11.glColor4d((double)arebazod, (double)uvubocil, var4, var6);
   }

   public static void _exercise(float nemalune) {
      GL11.glLineWidth((float)nemalune);
   }

   public static void _gained(int lunefafe) {
      GL11.glBegin((int)lunefafe);
   }

   public static void _frost(double rolled, double var2) {
      GL11.glVertex2d((double)rolled, var2);
   }

   public static void _domain() {
      GL11.glEnd();
   }

   public static void _naturals() {
      GlStateManager.enableAlpha();
      GlStateManager.enableDepth();
      _reggae(2884);
      _reggae(3553);
      _deadly(3042);
      _added(Color.white);
   }

   public static void _deadly(int ayulipos) {
      GL11.glDisable((int)ayulipos);
   }

   public static void _diamonds(float seeker, float slides, int marcus, int civic, ResourceLocation techno, Color curtis) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f((float)((Color)curtis).getRed() / 255.0F, (float)((Color)curtis).getGreen() / 255.0F, (float)((Color)curtis).getBlue() / 255.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)techno);
      Gui.drawModalRectWithCustomSizedTexture((int)seeker, (int)slides, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)marcus, (int)civic, (float)marcus, (float)civic);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _porter(double usilarum, double ucopevag, double ugizodap, int migodide) {
      GL11.glEnable(32925);
      GL11.glEnable(2881);
      Object ocepidaf = (float)(migodide >> 24 & 255) / 255.0F;
      Object semirado = (float)(migodide >> 16 & 255) / 255.0F;
      Object melofugu = (float)(migodide >> 8 & 255) / 255.0F;
      Object amegarat = (float)(migodide & 255) / 255.0F;
      Object vocomami = GL11.glIsEnabled(3042);
      boolean var12 = GL11.glIsEnabled(2848);
      boolean var13 = GL11.glIsEnabled(3553);
      if (!vocomami) {
         GL11.glEnable(3042);
      }

      if (!var12) {
         GL11.glEnable(2848);
      }

      if (var13) {
         GL11.glDisable(3553);
      }

      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(semirado, melofugu, amegarat, ocepidaf);
      GL11.glBegin(9);

      for(int var14 = 0; var14 <= 360; ++var14) {
         GL11.glVertex2d(usilarum + Math.sin((double)var14 * 3.141526D / 180.0D) * ugizodap, ucopevag + Math.cos((double)var14 * 3.141526D / 180.0D) * ugizodap);
      }

      GL11.glEnd();
      if (var13) {
         GL11.glEnable(3553);
      }

      if (!var12) {
         GL11.glDisable(2848);
      }

      if (!vocomami) {
         GL11.glDisable(3042);
      }

      GL11.glDisable(2881);
      GL11.glClear(0);
   }

   public static void _leonard(float gefagepa, float evigidam, float mefacofa, float azisicut, int momibege) {
      _chairs((float)gefagepa, (float)evigidam, (float)mefacofa, (float)azisicut, (float)momibege, (int)momibege);
      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }

   public static int _landing(int ulorusap, float obubudes) {
      Object usoloref = new Color((int)ulorusap);
      Object alovuyir = 0.003921569F * (float)usoloref.getRed();
      Object ecubufaf = 0.003921569F * (float)usoloref.getGreen();
      Object umobuvuc = 0.003921569F * (float)usoloref.getBlue();
      return (new Color(alovuyir, ecubufaf, umobuvuc, (float)obubudes)).getRGB();
   }

   public static void _craig(BlockPos ocevevas, Color fabizura, int retilide, float vucubele) {
      if (retilide != 0) {
         Object anopegab = criminal$.getRenderManager();
         Object umucifev = (double)((BlockPos)ocevevas).getX() - anopegab.viewerPosX;
         Object aseyabiv = (double)((BlockPos)ocevevas).getY() - anopegab.viewerPosY;
         Object ticovuvi = (double)((BlockPos)ocevevas).getZ() - anopegab.viewerPosZ;
         Object tumiyetu = new AxisAlignedBB(umucifev, aseyabiv, ticovuvi, umucifev + 1.0D, aseyabiv + 1.0D, ticovuvi + 1.0D);
         Object ugodaroc = criminal$.theWorld.getBlockState((BlockPos)ocevevas).getBlock();
         if (ugodaroc != null) {
            Object elumamey = criminal$.thePlayer;
            double var14 = elumamey.lastTickPosX + (elumamey.posX - elumamey.lastTickPosX) * (double)vucubele;
            double var16 = elumamey.lastTickPosY + (elumamey.posY - elumamey.lastTickPosY) * (double)vucubele;
            double var18 = elumamey.lastTickPosZ + (elumamey.posZ - elumamey.lastTickPosZ) * (double)vucubele;
            ugodaroc.setBlockBoundsBasedOnState(criminal$.theWorld, (BlockPos)ocevevas);
            tumiyetu = ugodaroc.getSelectedBoundingBox(criminal$.theWorld, (BlockPos)ocevevas).expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).offset(-var14, -var16, -var18);
         }

         GL11.glBlendFunc(770, 771);
         _motor(3042);
         _swingers(3553, 2929);
         GL11.glDepthMask(false);
         _quest(((Color)fabizura).getRed(), ((Color)fabizura).getGreen(), ((Color)fabizura).getBlue(), ((Color)fabizura).getAlpha() != 255 ? ((Color)fabizura).getAlpha() : 26);
         GL11.glLineWidth((float)retilide);
         _motor(2848);
         _program((Color)fabizura);
         _manner(tumiyetu);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDepthMask(true);
         _usage();
      }
   }

   public static void _quest(int aconugay, int cotusole, int vocazabu, int zunilumu) {
      GL11.glColor4f((float)aconugay / 255.0F, (float)cotusole / 255.0F, (float)vocazabu / 255.0F, (float)zunilumu / 255.0F);
   }

   public static void _usage() {
      acquire$.forEach(RenderUtils::_thailand);
   }

   public static void _motor(int oreracuv) {
      _captured((int)oreracuv, true);
   }

   public static void _losses(int... ericsson) {
      for(Object moved : ericsson) {
         _captured(moved, true);
      }

   }

   public static void _sheriff(int observer) {
      _captured((int)observer, true);
   }

   public static void _swingers(int... agelupug) {
      for(Object lemipocu : agelupug) {
         _captured(lemipocu, false);
      }

   }

   public static void _captured(int emuletev, boolean bayuvumi) {
      acquire$.put(Integer.valueOf((int)emuletev), Boolean.valueOf(GL11.glGetBoolean((int)emuletev)));
      _thailand((int)emuletev, (boolean)bayuvumi);
   }

   public static void _thailand(int esuvator, boolean ulozalis) {
      if (ulozalis) {
         GL11.glEnable((int)esuvator);
      } else {
         GL11.glDisable((int)esuvator);
      }

   }

   public static int _salaries(int izapamed, int rineloci, int gobuzopu) {
      Object irorigis = (long)rineloci * ((long)658678422 ^ 658678142L);
      float var5 = (float)((System.currentTimeMillis() + (long)(gobuzopu * izapamed)) % irorigis) / ((float)irorigis / 2.0F);
      return Color.HSBtoRGB(var5, 0.55F, 0.9F);
   }

   public static Color _turtle(int dirotolo, int origazeg, float lizaceva, float emasomof) {
      Object efegurer = (float)((System.currentTimeMillis() + (long)dirotolo) % (long)origazeg) / (float)origazeg;
      return Color.getHSBColor(efegurer, (float)lizaceva, (float)emasomof);
   }

   public static void _genetics(float SAO46) {
   }

   public static void _encoding(EntityLivingBase glory, Color loading, boolean zambia) {
      GL11.glPushMatrix();
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glEnable(2848);
      Object velvet = Float.intBitsToFloat(0);
      Object appeal = Float.intBitsToFloat(0);
      Object theft = 0;
      if (asked$._ascii((long)886667101 ^ 886667095L)) {
         ++chain$;
         asked$._silent();
      }

      _bench((Entity)glory);
      GL11.glLineWidth(1.0F);
      GL11.glBegin(3);

      for(Object cream = chain$; cream < 100 + chain$; ++cream) {
         Object scoring = (double)(2 * cream) * 3.141592653589793D / 100.0D;
         Color var9 = (Color)(zambia ? _turtle(theft, 1000, 0.8F, 1.0F) : loading);
         GL11.glColor3d((double)((float)var9.getRed() / 255.0F), (double)((float)var9.getGreen() / 255.0F), (double)((float)var9.getBlue() / 255.0F));
         GL11.glVertex3d(Math.cos(scoring) * 0.5D, (double)velvet, Math.sin(scoring) * 0.5D);
         velvet += ((EntityLivingBase)glory).height / 100.0F;
         theft += 10;
      }

      GL11.glEnd();
      GL11.glBegin(3);

      for(Object var10 = 50 + chain$; var10 < 150 + chain$; ++var10) {
         Object var11 = (double)(2 * var10) * 3.141592653589793D / 100.0D;
         Color var12 = (Color)(zambia ? _turtle(theft, 1000, 0.8F, 1.0F) : loading);
         GL11.glColor3d((double)((float)var12.getRed() / 255.0F), (double)((float)var12.getGreen() / 255.0F), (double)((float)var12.getBlue() / 255.0F));
         GL11.glVertex3d(Math.cos(var11) * 0.5D, (double)appeal, Math.sin(var11) * 0.5D);
         appeal += ((EntityLivingBase)glory).height / 100.0F;
         theft += 10;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(2929);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
   }

   public static void _bench(Entity sutuyoco) {
      Object amayapen = criminal$.timer.renderPartialTicks;
      Object cusutofe = ((Entity)sutuyoco).lastTickPosX + (((Entity)sutuyoco).posX - ((Entity)sutuyoco).lastTickPosX) * (double)amayapen - ((IRenderManager)criminal$.getRenderManager()).getRenderPosX();
      Object nemudesu = ((Entity)sutuyoco).lastTickPosY + (((Entity)sutuyoco).posY - ((Entity)sutuyoco).lastTickPosY) * (double)amayapen - ((IRenderManager)criminal$.getRenderManager()).getRenderPosY();
      double var6 = ((Entity)sutuyoco).lastTickPosZ + (((Entity)sutuyoco).posZ - ((Entity)sutuyoco).lastTickPosZ) * (double)amayapen - ((IRenderManager)criminal$.getRenderManager()).getRenderPosZ();
      GL11.glTranslated(cusutofe, nemudesu, var6);
      GL11.glNormal3d(Double.longBitsToDouble(0L), 1.0D, Double.longBitsToDouble(0L));
      GL11.glRotated((double)(-criminal$.getRenderManager().playerViewY), Double.longBitsToDouble(0L), 1.0D, Double.longBitsToDouble(0L));
   }

   public static void _charging(int cozetupa, int tetaridi, int buguvefu, float moyisili, float beyaputo, EntityLivingBase zazupalo, float mogilate) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)cozetupa, (float)tetaridi, 50.0F);
      GlStateManager.scale((float)(-buguvefu), (float)buguvefu, (float)buguvefu);
      GlStateManager.rotate(180.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      Object etabudap = ((EntityLivingBase)zazupalo).renderYawOffset;
      Object iyofinos = ((EntityLivingBase)zazupalo).rotationYaw;
      Object iyayidam = ((EntityLivingBase)zazupalo).rotationPitch;
      Object unoziyev = ((EntityLivingBase)zazupalo).prevRotationYawHead;
      Object evumurum = ((EntityLivingBase)zazupalo).rotationYawHead;
      GlStateManager.rotate((float)mogilate, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.rotate(-((float)Math.atan((double)(beyaputo / 40.0F))) * 20.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      ((EntityLivingBase)zazupalo).renderYawOffset = (float)Math.atan((double)(moyisili / 40.0F)) * 20.0F;
      ((EntityLivingBase)zazupalo).rotationYaw = (float)Math.atan((double)(moyisili / 40.0F)) * 40.0F;
      ((EntityLivingBase)zazupalo).rotationPitch = -((float)Math.atan((double)(beyaputo / 40.0F))) * 20.0F;
      ((EntityLivingBase)zazupalo).rotationYawHead = ((EntityLivingBase)zazupalo).rotationYaw;
      ((EntityLivingBase)zazupalo).prevRotationYawHead = ((EntityLivingBase)zazupalo).rotationYaw;
      GlStateManager.translate(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object tezudali = Minecraft.getMinecraft().getRenderManager();
      tezudali.setPlayerViewY(180.0F);
      tezudali.setRenderShadow(false);
      tezudali.renderEntityWithPosYaw((Entity)zazupalo, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Float.intBitsToFloat(0), 1.0F);
      tezudali.setRenderShadow(true);
      ((EntityLivingBase)zazupalo).renderYawOffset = etabudap;
      ((EntityLivingBase)zazupalo).rotationYaw = iyofinos;
      ((EntityLivingBase)zazupalo).rotationPitch = iyayidam;
      ((EntityLivingBase)zazupalo).prevRotationYawHead = unoziyev;
      ((EntityLivingBase)zazupalo).rotationYawHead = evumurum;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static void _titanium(double choice, double heaven, double updating, double finite, double vampire, Color var10) {
      double var11 = Math.abs((double)(updating - choice));
      double var13 = Math.abs((double)(finite - heaven));
      double var15 = var11 / 4.0D;
      double var17 = var13 / 4.0D;
      _walked();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)vampire);
      _colon(var10);
      GL11.glBegin(3);
      GL11.glVertex2d(choice + var15, (double)heaven);
      GL11.glVertex2d((double)choice, (double)heaven);
      GL11.glVertex2d((double)choice, heaven + var17);
      GL11.glEnd();
      GL11.glBegin(3);
      GL11.glVertex2d((double)choice, heaven + var13 - var17);
      GL11.glVertex2d((double)choice, heaven + var13);
      GL11.glVertex2d(choice + var15, heaven + var13);
      GL11.glEnd();
      GL11.glBegin(3);
      GL11.glVertex2d(choice + var11 - var15, heaven + var13);
      GL11.glVertex2d(choice + var11, heaven + var13);
      GL11.glVertex2d(choice + var11, heaven + var13 - var17);
      GL11.glEnd();
      GL11.glBegin(3);
      GL11.glVertex2d(choice + var11, heaven + var17);
      GL11.glVertex2d(choice + var11, (double)heaven);
      GL11.glVertex2d(choice + var11 - var15, (double)heaven);
      GL11.glEnd();
      GL11.glPopMatrix();
      _ontario();
   }

   public static void _colon(Color olanafig) {
      Object iyeloded = (float)(((Color)olanafig).getRGB() >> 24 & 255) / 255.0F;
      Object ayinafeg = (float)(((Color)olanafig).getRGB() >> 16 & 255) / 255.0F;
      Object neciliri = (float)(((Color)olanafig).getRGB() >> 8 & 255) / 255.0F;
      Object bamosofi = (float)(((Color)olanafig).getRGB() & 255) / 255.0F;
      GL11.glColor4f(ayinafeg, neciliri, bamosofi, iyeloded);
   }

   public static void _walked() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void _ontario() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _stick(Entity vepususo, Color igamebam) {
      Object maveguse = criminal$.getRenderManager();
      Object irunepol = criminal$.timer;
      GlStateManager.pushMatrix();
      GL11.glBlendFunc(770, 771);
      _motor(3042);
      _swingers(3553, 2929);
      GL11.glDepthMask(false);
      Object vasegave = ((Entity)vepususo).lastTickPosX + (((Entity)vepususo).posX - ((Entity)vepususo).lastTickPosX) * (double)irunepol.renderPartialTicks - maveguse.renderPosX;
      Object esicamon = ((Entity)vepususo).lastTickPosY + (((Entity)vepususo).posY - ((Entity)vepususo).lastTickPosY) * (double)irunepol.renderPartialTicks - maveguse.renderPosY;
      Object denoravo = ((Entity)vepususo).lastTickPosZ + (((Entity)vepususo).posZ - ((Entity)vepususo).lastTickPosZ) * (double)irunepol.renderPartialTicks - maveguse.renderPosZ;
      AxisAlignedBB var10 = ((Entity)vepususo).getEntityBoundingBox();
      AxisAlignedBB var11 = new AxisAlignedBB(var10.minX - ((Entity)vepususo).posX + vasegave - 0.05D, var10.minY - ((Entity)vepususo).posY + esicamon, var10.minZ - ((Entity)vepususo).posZ + denoravo - 0.05D, var10.maxX - ((Entity)vepususo).posX + vasegave + 0.05D, var10.maxY - ((Entity)vepususo).posY + esicamon + 0.15D, var10.maxZ - ((Entity)vepususo).posZ + denoravo + 0.05D);
      GL11.glTranslated(vasegave, esicamon, denoravo);
      GL11.glRotated((double)(-((Entity)vepususo).getRotationYawHead()), Double.longBitsToDouble(0L), 1.0D, Double.longBitsToDouble(0L));
      GL11.glTranslated(-vasegave, -esicamon, -denoravo);
      GL11.glLineWidth(3.0F);
      _motor(2848);
      _quest(0, 0, 0, 255);
      _manner(var11);
      GL11.glLineWidth(1.0F);
      _motor(2848);
      _quest(((Color)igamebam).getRed(), ((Color)igamebam).getGreen(), ((Color)igamebam).getBlue(), 255);
      _manner(var11);
      GlStateManager.resetColor();
      GL11.glDepthMask(true);
      _usage();
      GlStateManager.popMatrix();
   }

   public static void _pregnant(double patrick, double fabulous, double projects, double var6) {
      _illness((double)patrick, (double)fabulous, (double)projects, var6, -16119286);
      double var8 = 0.5D;
      _illness(patrick + var8, fabulous + var8, projects - var8, var6 - var8, -12829636);
      var8 = 1.0D;
      _illness(patrick + var8, fabulous + var8, projects - var8, var6 - var8, -14540254);
      var8 = 2.5D;
      _illness(patrick + var8, fabulous + var8, projects - var8, var6 - var8, -12829636);
      var8 = 3.0D;
      _illness(patrick + var8, fabulous + var8, projects - var8, var6 - var8, -15329770);
   }

   public static void _lindsay(double nigizalo, double sulonene, double anebiraz, double muvagedo, int cecorari, Color orulazoz) {
      GL11.glPushMatrix();
      GlStateManager.alphaFunc(516, 0.01F);
      anebiraz = anebiraz + (double)(cecorari * 2);
      muvagedo = muvagedo + (double)(cecorari * 2);
      nigizalo = nigizalo - (double)cecorari;
      sulonene = sulonene - (double)cecorari;
      Object sidesofu = nigizalo - 0.25D;
      Object vinefoyu = sulonene + 0.25D;
      double var14 = (double)((int)(anebiraz * muvagedo * 13212.0D / Math.sin((double)cecorari)));
      GL11.glEnable(3553);
      GL11.glDisable(2884);
      GL11.glEnable(3008);
      GlStateManager.enableBlend();
      int var16 = -1;
      if (actors$.containsKey(Double.valueOf(var14))) {
         var16 = ((Integer)actors$.get(Double.valueOf(var14))).intValue();
         GlStateManager.bindTexture(var16);
      } else {
         BufferedImage var17 = new BufferedImage((int)anebiraz, (int)muvagedo, 2);
         Graphics var18 = var17.getGraphics();
         var18.setColor(Color.WHITE);
         var18.fillRect((int)cecorari, (int)cecorari, (int)(anebiraz - (double)(cecorari * 2)), (int)(muvagedo - (double)(cecorari * 2)));
         var18.dispose();
         GaussianFilter var19 = new GaussianFilter((float)cecorari);
         BufferedImage var20 = var19.filter(var17, (BufferedImage)null);
         var16 = TextureUtil.uploadTextureImageAllocate(TextureUtil.glGenTextures(), var20, true, false);
         actors$.put(Double.valueOf(var14), Integer.valueOf(var16));
      }

      GL11.glColor4f((float)((Color)orulazoz).getRed() / 255.0F, (float)((Color)orulazoz).getGreen() / 255.0F, (float)((Color)orulazoz).getBlue() / 255.0F, (float)((Color)orulazoz).getAlpha() / 255.0F);
      GL11.glBegin(7);
      GL11.glTexCoord2f(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glVertex2d(sidesofu, vinefoyu);
      GL11.glTexCoord2f(Float.intBitsToFloat(0), 1.0F);
      GL11.glVertex2d(sidesofu, vinefoyu + muvagedo);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2d(sidesofu + anebiraz, vinefoyu + muvagedo);
      GL11.glTexCoord2f(1.0F, Float.intBitsToFloat(0));
      GL11.glVertex2d(sidesofu + anebiraz, vinefoyu);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glEnable(2884);
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void _laptops(float ibemulad, float razedofe, float edipumil, float nivubune, int ibococim, Color puminiva) {
      GL11.glPushMatrix();
      GlStateManager.alphaFunc(516, 0.01F);
      edipumil = edipumil + (float)(ibococim * 2);
      nivubune = nivubune + (float)(ibococim * 2);
      ibemulad = ibemulad - (float)ibococim;
      razedofe = razedofe - (float)ibococim;
      Object fupegore = ibemulad - 0.25F;
      Object megasona = razedofe + 0.25F;
      Object geralamu = (double)((int)((double)(edipumil * nivubune * 13212.0F) / Math.sin((double)ibococim)));
      GL11.glEnable(3553);
      GL11.glDisable(2884);
      GL11.glEnable(3008);
      GlStateManager.enableBlend();
      Object suparuge = -1;
      if (actors$.containsKey(Double.valueOf(geralamu))) {
         suparuge = ((Integer)actors$.get(Double.valueOf(geralamu))).intValue();
         GlStateManager.bindTexture(suparuge);
      } else {
         Object yabuvefi = new BufferedImage((int)edipumil, (int)nivubune, 2);
         Object ofesuyeb = yabuvefi.getGraphics();
         ofesuyeb.setColor(Color.WHITE);
         ofesuyeb.fillRect((int)ibococim, (int)ibococim, (int)(edipumil - (float)(ibococim * 2)), (int)(nivubune - (float)(ibococim * 2)));
         ofesuyeb.dispose();
         Object filovofu = new GaussianFilter((float)ibococim);
         BufferedImage var14 = filovofu.filter(yabuvefi, (BufferedImage)null);
         suparuge = TextureUtil.uploadTextureImageAllocate(TextureUtil.glGenTextures(), var14, true, false);
         actors$.put(Double.valueOf(geralamu), Integer.valueOf(suparuge));
      }

      GL11.glColor4f((float)((Color)puminiva).getRed() / 255.0F, (float)((Color)puminiva).getGreen() / 255.0F, (float)((Color)puminiva).getBlue() / 255.0F, (float)((Color)puminiva).getAlpha() / 255.0F);
      GL11.glBegin(7);
      GL11.glTexCoord2f(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glVertex2f(fupegore, megasona);
      GL11.glTexCoord2f(Float.intBitsToFloat(0), 1.0F);
      GL11.glVertex2f(fupegore, megasona + nivubune);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f(fupegore + edipumil, megasona + nivubune);
      GL11.glTexCoord2f(1.0F, Float.intBitsToFloat(0));
      GL11.glVertex2f(fupegore + edipumil, megasona);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glEnable(2884);
      GlStateManager.resetColor();
      GL11.glPopMatrix();
   }

   public static void _shipment(float novelty, float dates, float rebate, float function, float earning, int scary, int spare) {
      GlStateManager.color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      if (rebate > function) {
         Object executed = (float)function;
         function = rebate;
         rebate = executed;
      }

      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      _failed((float)spare);
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GL11.glBegin(3);

      for(Object var10 = (float)function; var10 >= rebate; var10 -= 4.0F) {
         _cloudy((int)scary, 70);
         Object goals = (float)(Math.cos((double)var10 * 3.141592653589793D / 180.0D) * (double)earning * 1.0D);
         Object robbie = (float)(Math.sin((double)var10 * 3.141592653589793D / 180.0D) * (double)earning * 1.0D);
         GL11.glVertex2f(novelty + goals, dates + robbie);
      }

      GL11.glEnd();
      _coverage();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _closest(float staffing, float malaysia, float craig, float coach, float random, int compiled, int employ) {
      GlStateManager.color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      if (craig > coach) {
         Object playing = (float)coach;
         coach = craig;
         craig = playing;
      }

      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      _failed((float)employ);
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GL11.glBegin(3);

      for(Object var10 = (float)coach; var10 >= craig; var10 -= 4.0F) {
         _cloudy((int)compiled, 255);
         Object gamecube = (float)(Math.cos((double)var10 * 3.141592653589793D / 180.0D) * (double)random * 1.0D);
         Object cottage = (float)(Math.sin((double)var10 * 3.141592653589793D / 180.0D) * (double)random * 1.0D);
         GL11.glVertex2f(staffing + gamecube, malaysia + cottage);
      }

      GL11.glEnd();
      _coverage();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _cloudy(int jackets, int anyone) {
      Object berkeley = (float)(jackets >> 16 & 255) / 255.0F;
      Object priority = (float)(jackets >> 8 & 255) / 255.0F;
      Object rings = (float)(jackets & 255) / 255.0F;
      GlStateManager.color(berkeley, priority, rings, (float)anyone / 255.0F);
   }

   public static void _recipes(float support, float breeding, float maple, float placing, float diary, boolean carmen, Color violent) {
      _cached(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
      if (maple > placing) {
         Object breeds = (float)placing;
         placing = maple;
         maple = breeds;
      }

      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      _phones(((Color)violent).getRGB());
      GL11.glEnable(2848);
      GL11.glLineWidth(2.0F);
      GL11.glBegin(3);

      for(Object indicate = (float)placing; indicate >= maple; indicate -= 4.0F) {
         Object contact = (float)(Math.cos((double)indicate * 3.141592653589793D / 180.0D) * (double)diary * 1.0D);
         Object tommy = (float)(Math.sin((double)indicate * 3.141592653589793D / 180.0D) * (double)diary * 1.0D);
         GL11.glVertex2f(support + contact, breeding + tommy);
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(2848);
      GL11.glBegin(carmen ? 6 : 3);

      for(Object var13 = (float)placing; var13 >= maple; var13 -= 4.0F) {
         Object var12 = (float)Math.cos((double)var13 * 3.141592653589793D / 180.0D) * diary;
         Object var11 = (float)Math.sin((double)var13 * 3.141592653589793D / 180.0D) * diary;
         GL11.glVertex2f(support + var12, breeding + var11);
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _phones(int gathered) {
      GL11.glColor4ub((byte)(gathered >> 16 & 255), (byte)(gathered >> 8 & 255), (byte)(gathered & 255), (byte)(gathered >> 24 & 255));
   }

   public static void _marvel(float uyufamad) {
      _twisted();
      GL11.glPushAttrib(1048575);
      GL11.glDisable(3008);
      GL11.glDisable(3553);
      GL11.glDisable(2896);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth((float)uyufamad);
      GL11.glEnable(2848);
      GL11.glEnable(2960);
      GL11.glClear(1024);
      GL11.glClearStencil(15);
      GL11.glStencilFunc(512, 1, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void _twisted() {
      Object zebigote = Minecraft.getMinecraft().getFramebuffer();
      if (zebigote.depthBuffer > -1) {
         _locate(zebigote);
         zebigote.depthBuffer = -1;
      }

   }

   public static void _locate(Framebuffer bemivogo) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(((Framebuffer)bemivogo).depthBuffer);
      Object riyayuso = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, riyayuso);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, riyayuso);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, riyayuso);
   }

   public static void _councils() {
      GL11.glPolygonOffset(1.0F, 2000000.0F);
      GL11.glDisable(10754);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(2960);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glEnable(3042);
      GL11.glEnable(2896);
      GL11.glEnable(3553);
      GL11.glEnable(3008);
      GL11.glPopAttrib();
   }

   public static void _cities(AxisAlignedBB iyimeled) {
      Object yunocaci = Tessellator.getInstance();
      Object cufipayo = yunocaci.getWorldRenderer();
      cufipayo.begin(7, DefaultVertexFormats.POSITION);
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      yunocaci.draw();
      cufipayo.begin(7, DefaultVertexFormats.POSITION);
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      yunocaci.draw();
      cufipayo.begin(7, DefaultVertexFormats.POSITION);
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      yunocaci.draw();
      cufipayo.begin(7, DefaultVertexFormats.POSITION);
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      yunocaci.draw();
      cufipayo.begin(7, DefaultVertexFormats.POSITION);
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      yunocaci.draw();
      cufipayo.begin(7, DefaultVertexFormats.POSITION);
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).minX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).minZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).maxY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      cufipayo.pos(((AxisAlignedBB)iyimeled).maxX, ((AxisAlignedBB)iyimeled).minY, ((AxisAlignedBB)iyimeled).maxZ).endVertex();
      yunocaci.draw();
   }

   public static void _cancel(int licagaya) {
      Object ofuyacev = (float)(licagaya >> 24 & 255) / 255.0F;
      Object mirotove = (float)(licagaya >> 16 & 255) / 255.0F;
      Object ufisovev = (float)(licagaya >> 8 & 255) / 255.0F;
      Object ficirilo = (float)(licagaya & 255) / 255.0F;
      GL11.glColor4f(mirotove, ufisovev, ficirilo, ofuyacev == Float.intBitsToFloat(0) ? 1.0F : ofuyacev);
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(10754);
      GL11.glPolygonOffset(1.0F, -2000000.0F);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
   }

   public static void _plants() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void _rather() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public static void _hazard(float uguzinun, float acalugen, float paponabu, float ediyaduy, float ibateyuf) {
      if (uguzinun > paponabu) {
         Object elufonav = (float)uguzinun;
         uguzinun = paponabu;
         paponabu = elufonav;
      }

      if (acalugen > ediyaduy) {
         Object var18 = (float)acalugen;
         acalugen = ediyaduy;
         ediyaduy = var18;
      }

      Object alitiyel = (double)(uguzinun + ibateyuf);
      Object suyerube = (double)(acalugen + ibateyuf);
      Object upabipub = (double)(paponabu - ibateyuf);
      double var12 = (double)(ediyaduy - ibateyuf);
      GL11.glEnable(2848);
      GL11.glLineWidth(1.0F);
      GL11.glBegin(9);
      double var14 = 0.017453292519943295D;

      for(double var16 = Double.longBitsToDouble(0L); var16 <= 90.0D; ++var16) {
         GL11.glVertex2d(upabipub + Math.sin(var16 * var14) * (double)ibateyuf, var12 + Math.cos(var16 * var14) * (double)ibateyuf);
      }

      for(double var19 = 90.0D; var19 <= 180.0D; ++var19) {
         GL11.glVertex2d(upabipub + Math.sin(var19 * var14) * (double)ibateyuf, suyerube + Math.cos(var19 * var14) * (double)ibateyuf);
      }

      for(double var20 = 180.0D; var20 <= 270.0D; ++var20) {
         GL11.glVertex2d(alitiyel + Math.sin(var20 * var14) * (double)ibateyuf, suyerube + Math.cos(var20 * var14) * (double)ibateyuf);
      }

      for(double var21 = 270.0D; var21 <= 360.0D; ++var21) {
         GL11.glVertex2d(alitiyel + Math.sin(var21 * var14) * (double)ibateyuf, var12 + Math.cos(var21 * var14) * (double)ibateyuf);
      }

      GL11.glEnd();
      GL11.glDisable(2848);
   }

   public static ScaledResolution _parents() {
      return new ScaledResolution(Minecraft.getMinecraft());
   }

   public static Vector3d _istanbul(double catomama, double emuragoz, double var4) {
      FloatBuffer var6 = GLAllocation.createDirectFloatBuffer(4);
      GL11.glGetFloat(2982, belarus$);
      GL11.glGetFloat(2983, angry$);
      GL11.glGetInteger(2978, jumping$);
      return GLU.gluProject((float)catomama, (float)emuragoz, (float)var4, belarus$, angry$, jumping$, var6) ? new Vector3d((double)(var6.get(0) / (float)_parents().getScaleFactor()), (double)(((float)Display.getHeight() - var6.get(1)) / (float)_parents().getScaleFactor()), (double)var6.get(2)) : null;
   }

   public static void _asking(double bearing, double images, int arizona, int outcomes, double japan, int suzuki) {
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBegin(9);
      _modem((int)suzuki);

      for(int var9 = (int)arizona; var9 <= outcomes; ++var9) {
         double var10 = Math.sin((double)var9 * 3.141592653589793D / 180.0D) * japan;
         double var12 = Math.cos((double)var9 * 3.141592653589793D / 180.0D) * japan;
         GL11.glVertex2d(bearing + var10, images + var12);
      }

      GL11.glVertex2d((double)bearing, (double)images);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void _secured(double vufitimo, double idayivan, double irunasel, double fidivube, double var8, int var10) {
      float var11 = (float)Math.abs((double)(irunasel - vufitimo));
      float var12 = (float)Math.abs((double)(fidivube - idayivan));
      var8 = Math.min(var8, (double)(var11 / 2.0F));
      var8 = Math.min(var8, (double)(var12 / 2.0F));
      _illness((double)vufitimo, idayivan + var8, vufitimo + (double)var11, idayivan + (double)var12 - var8, var10);
      _illness(vufitimo + var8, (double)idayivan, vufitimo + (double)var11 - var8, idayivan + var8, var10);
      _illness(vufitimo + var8, idayivan + (double)var12 - var8, vufitimo + (double)var11 - var8, idayivan + (double)var12, var10);
      _asking((double)((float)(vufitimo + var8)), idayivan + var8, 180, 271, var8, var10);
      _asking(vufitimo + var8, idayivan + (double)var12 - var8, 270, 361, var8, var10);
      _asking(vufitimo + (double)var11 - var8, idayivan + var8, 90, 181, var8, var10);
      _asking(vufitimo + (double)var11 - var8, idayivan + (double)var12 - var8, 0, 91, var8, var10);
   }

   public static void _bacteria(double begosomu, double irozosar, int igutesom, int recuyadi, double uvopuvic, int ifirilip) {
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBegin(9);
      _modem((int)ifirilip);

      for(int var9 = (int)igutesom; var9 <= recuyadi; ++var9) {
         double var10 = Math.sin((double)var9 * 3.141592653589793D / 180.0D) * uvopuvic;
         double var12 = Math.cos((double)var9 * 3.141592653589793D / 180.0D) * uvopuvic;
         GL11.glVertex2d(begosomu + var10, irozosar + var12);
      }

      GL11.glVertex2d((double)begosomu, (double)irozosar);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void _meter(double egusodeg, double izitivob, double uvalatob, double amebigap, int var8, int var9) {
      double var10 = (double)(uvalatob - egusodeg);
      double var12 = (double)(amebigap - izitivob);
      _illness((double)egusodeg, izitivob + var12 / (double)var8, egusodeg + var12 / (double)var8, izitivob + var12 - var12 / (double)var8, var9);
      _illness(egusodeg + var10 - var12 / (double)var8, izitivob + var12 / (double)var8, egusodeg + var10, izitivob + var12 - var12 / (double)var8, var9);
      _illness(egusodeg + var12 / (double)var8, (double)izitivob, egusodeg + var10 - var12 / (double)var8, izitivob + var12, var9);
      _bacteria(egusodeg + var12 / (double)var8, izitivob + var12 / (double)var8, 180, 270, var12 / (double)var8, var9);
      _bacteria(egusodeg + var12 / (double)var8, izitivob + var12 - var12 / (double)var8, 270, 360, var12 / (double)var8, var9);
      _bacteria(egusodeg + var10 - var12 / (double)var8, izitivob + var12 / (double)var8, 90, 180, var12 / (double)var8, var9);
      _bacteria(egusodeg + var10 - var12 / (double)var8, izitivob + var12 - var12 / (double)var8, 0, 90, var12 / (double)var8, var9);
   }
}
