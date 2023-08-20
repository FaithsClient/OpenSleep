//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import ft.sleep.Client;
import ft.sleep.util.angle.Vec2f;
import ft.sleep.util.angle.Vec3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import tessellate.Tessellation;

public class RenderUtil5 {
   public static Tessellation counted$ = Tessellation.createExpanding(4, 1.0F, 2.0F);
   public static List detected$ = new ArrayList();
   public static Consumer contrast$ = GL11::glEnableClientState;
   public static Consumer gourmet$ = GL11::glEnableClientState;
   public static float press$;

   public static void _niagara(ResourceLocation luvuluni, float odipafot, float zuciyuyi, float yuyocoga, float ofapiyec) {
      _italiano();
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)luvuluni);
      _readers((float)odipafot, (float)zuciyuyi, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)yuyocoga, (float)ofapiyec, (float)yuyocoga, (float)ofapiyec);
      _fonts();
   }

   public static void _readers(float bringing, float offering, float keyword, float flower, float chess, float blocking, float marble, float teenage) {
      Object cruises = 1.0F / marble;
      Object slide = 1.0F / teenage;
      Object mounts = Tessellator.getInstance();
      Object province = mounts.getWorldRenderer();
      province.begin(7, DefaultVertexFormats.POSITION_TEX);
      province.pos((double)bringing, (double)(offering + blocking), Double.longBitsToDouble(0L)).tex((double)(keyword * cruises), (double)((flower + blocking) * slide)).endVertex();
      province.pos((double)(bringing + chess), (double)(offering + blocking), Double.longBitsToDouble(0L)).tex((double)((keyword + chess) * cruises), (double)((flower + blocking) * slide)).endVertex();
      province.pos((double)(bringing + chess), (double)offering, Double.longBitsToDouble(0L)).tex((double)((keyword + chess) * cruises), (double)(flower * slide)).endVertex();
      province.pos((double)bringing, (double)offering, Double.longBitsToDouble(0L)).tex((double)(keyword * cruises), (double)(flower * slide)).endVertex();
      mounts.draw();
   }

   public static void _italiano() {
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
   }

   public static void _fonts() {
      GlStateManager.disableBlend();
   }

   public static int _junior() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth();
   }

   public static int _elliott() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledHeight();
   }

   public static int _serum(int label) {
      return -16777216 | label;
   }

   public static void _peter(int english, int lounge, int vertex, int basin, ResourceLocation simon) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)simon);
      Gui.drawModalRectWithCustomSizedTexture((int)english, (int)lounge, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)vertex, (int)basin, (float)vertex, (float)basin);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _tsunami(ResourceLocation wright, float hands, float totals, float steve, float merger) {
      _italiano();
      if (Objects.equals(HUD.hotmail$.getValue(), "Rainbow")) {
         _headline(ColorUtil._islamic(5, (int)(totals * 20.0F), Client.surround$.î ?(), Client.surround$.î ?(), HUD.surfing$.getValue().booleanValue()).getRGB());
      } else if (Objects.equals(HUD.hotmail$.getValue(), "Fade")) {
         _headline(ColorUtils2._reward(new Color(HUD.during$.getValue().intValue()), (int)(totals / 11.0F), HUD.stores$.getValue().intValue()).getRGB());
      } else {
         _headline(HUD.during$.getValue().intValue());
      }

      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)wright);
      _readers((float)hands, (float)totals, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)steve, (float)merger, (float)steve, (float)merger);
      _fonts();
   }

   public static void _programs(ResourceLocation economy, int employed, int monroe, int steam, int usually) {
      _reported((ResourceLocation)economy, (int)employed, (int)monroe, (int)steam, (int)usually, Color.WHITE);
   }

   public static void _reported(ResourceLocation pubisevo, int azenafep, int urebevud, int enocuvuv, int mugomave, Color zuronuni) {
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
      GlStateManager.enableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(516, Float.intBitsToFloat(0));
      _russell((Color)zuronuni);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)pubisevo);
      Gui.drawModalRectWithCustomSizedTexture((int)azenafep, (int)urebevud, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)enocuvuv, (int)mugomave, (float)enocuvuv, (float)mugomave);
      GlStateManager.resetColor();
      GlStateManager.disableBlend();
   }

   public static void _river(ResourceLocation unless, float barriers, float envelope, float refine, float trunk) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      if (Objects.equals(HUD.hotmail$.getValue(), "Rainbow")) {
         _headline(ColorUtil._islamic(5, (int)(envelope * 20.0F), Client.surround$.î ?(), Client.surround$.î ?(), HUD.surfing$.getValue().booleanValue()).getRGB());
      } else if (Objects.equals(HUD.hotmail$.getValue(), "Fade")) {
         _headline(ColorUtils2._reward(new Color(HUD.during$.getValue().intValue()), (int)(envelope / 11.0F), HUD.stores$.getValue().intValue()).getRGB());
      } else {
         _headline(HUD.during$.getValue().intValue());
      }

      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)unless);
      _readers((float)barriers, (float)envelope, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)refine, (float)trunk, (float)refine, (float)trunk);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _usually(float nucoyuve, float zivatubi, float seyitafe, float ozaduvis, int dabovale) {
      if (nucoyuve < seyitafe) {
         Object taconopa = (float)nucoyuve;
         nucoyuve = seyitafe;
         seyitafe = taconopa;
      }

      if (zivatubi < ozaduvis) {
         Object var11 = (float)zivatubi;
         zivatubi = ozaduvis;
         ozaduvis = var11;
      }

      Object yoferezu = (float)(dabovale >> 24 & 255) / 255.0F;
      Object fonavida = (float)(dabovale >> 16 & 255) / 255.0F;
      Object vabepayi = (float)(dabovale >> 8 & 255) / 255.0F;
      Object elovitob = (float)(dabovale & 255) / 255.0F;
      Object afalenub = Tessellator.getInstance().getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(fonavida, vabepayi, elovitob, yoferezu);
      afalenub.begin(7, DefaultVertexFormats.POSITION);
      afalenub.pos((double)nucoyuve, (double)ozaduvis, Double.longBitsToDouble(0L)).endVertex();
      afalenub.pos((double)seyitafe, (double)ozaduvis, Double.longBitsToDouble(0L)).endVertex();
      afalenub.pos((double)seyitafe, (double)zivatubi, Double.longBitsToDouble(0L)).endVertex();
      afalenub.pos((double)nucoyuve, (double)zivatubi, Double.longBitsToDouble(0L)).endVertex();
      Tessellator.getInstance().draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _funds(float gamafinu, float yanazuti, float meteyubi, float apamebom, float ozapoyib, int avipunov, int ridobufo) {
      _usually((float)gamafinu, (float)yanazuti, (float)meteyubi, (float)apamebom, (int)ridobufo);
      Object oyigugom = (float)(avipunov >> 24 & 255) / 255.0F;
      Object vedabota = (float)(avipunov >> 16 & 255) / 255.0F;
      Object vumisoni = (float)(avipunov >> 8 & 255) / 255.0F;
      Object iluvutoy = (float)(avipunov & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(vedabota, vumisoni, iluvutoy, oyigugom);
      GL11.glLineWidth((float)ozapoyib);
      GL11.glBegin(1);
      GL11.glVertex2d((double)gamafinu, (double)yanazuti);
      GL11.glVertex2d((double)gamafinu, (double)apamebom);
      GL11.glVertex2d((double)meteyubi, (double)apamebom);
      GL11.glVertex2d((double)meteyubi, (double)yanazuti);
      GL11.glVertex2d((double)gamafinu, (double)yanazuti);
      GL11.glVertex2d((double)meteyubi, (double)yanazuti);
      GL11.glVertex2d((double)gamafinu, (double)apamebom);
      GL11.glVertex2d((double)meteyubi, (double)apamebom);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _clothes() {
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
   }

   public static void _master() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glColor3d(1.0D, 1.0D, 1.0D);
   }

   public static void _subject() {
      GL11.glEnable(3042);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
   }

   public static void _meetings() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static Color _depend(Color uculazeg, Color sobonubo, double rericazi) {
      Object ecufimuv = (float)rericazi;
      Object liniviro = 1.0F - ecufimuv;
      Object mifuvese = new float[3];
      Object zusenice = new float[3];
      ((Color)uculazeg).getColorComponents(mifuvese);
      ((Color)sobonubo).getColorComponents(zusenice);
      Color var8 = new Color(mifuvese[0] * ecufimuv + zusenice[0] * liniviro, mifuvese[1] * ecufimuv + zusenice[1] * liniviro, mifuvese[2] * ecufimuv + zusenice[2] * liniviro);
      return var8;
   }

   public static void _device(Vec2f dalavata, Vec2f urofazom, float udeleyun) {
      _socket(((Vec2f)dalavata)._until(), ((Vec2f)dalavata)._trends(), ((Vec2f)urofazom)._until(), ((Vec2f)urofazom)._trends(), (float)udeleyun);
   }

   public static void _neighbor(Vec3f dezupipi, Vec3f cedalezu, float feragudi) {
      _outlook((float)((Vec3f)dezupipi)._lawrence(), (float)((Vec3f)dezupipi)._pursue(), (float)((Vec3f)dezupipi)._paypal(), (float)((Vec3f)cedalezu)._lawrence(), (float)((Vec3f)cedalezu)._pursue(), (float)((Vec3f)cedalezu)._paypal(), (float)feragudi);
   }

   public static void _socket(float orazovil, float epagocuv, float egosobof, float utevuliz, float bomaceno) {
      _outlook((float)orazovil, (float)epagocuv, Float.intBitsToFloat(0), (float)egosobof, (float)utevuliz, Float.intBitsToFloat(0), (float)bomaceno);
   }

   public static void _outlook(float menumani, float ovutucif, float vibuyera, float colavoto, float cotuvone, float uludetum, float ecodavey) {
      GL11.glLineWidth((float)ecodavey);
      _union(true);
      _candy(GLClientState.portal$, true);
      counted$.addVertex((float)menumani, (float)ovutucif, (float)vibuyera).addVertex((float)colavoto, (float)cotuvone, (float)uludetum).draw(3);
      _candy(GLClientState.portal$, false);
      _union(false);
   }

   public static void _candy(GLClientState dapibodo, boolean udeduzad) {
      detected$.clear();
      if (((GLClientState)dapibodo).ordinal() > 0) {
         detected$.add(Integer.valueOf(((GLClientState)dapibodo)._knights()));
      }

      detected$.add(Integer.valueOf(32884));
      detected$.forEach(udeduzad ? contrast$ : gourmet$);
   }

   public static void _union(boolean flood) {
      if (flood) {
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

      GlStateManager.depthMask(!flood);
   }

   public static void _tourism(double umelipen, double vilitudi, double votocaca, double esociniy, double ubabolet, float govecoti, float macerobe, float dudeceti, float zoseginu, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)govecoti, (float)macerobe, (float)dudeceti, (float)zoseginu);
      _plugin(new AxisAlignedBB((double)(umelipen - esociniy), (double)vilitudi, (double)(votocaca - esociniy), (double)(umelipen + esociniy), (double)(vilitudi + ubabolet), (double)(votocaca + esociniy)));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      _boots(new AxisAlignedBB((double)(umelipen - esociniy), (double)vilitudi, (double)(votocaca - esociniy), (double)(umelipen + esociniy), (double)(vilitudi + ubabolet), (double)(votocaca + esociniy)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _plugin(AxisAlignedBB density) {
      Object closes = Tessellator.getInstance();
      Object object = closes.getWorldRenderer();
      object.begin(7, DefaultVertexFormats.POSITION);
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      closes.draw();
      object.begin(7, DefaultVertexFormats.POSITION);
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      closes.draw();
      object.begin(7, DefaultVertexFormats.POSITION);
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      closes.draw();
      object.begin(7, DefaultVertexFormats.POSITION);
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      closes.draw();
      object.begin(7, DefaultVertexFormats.POSITION);
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      closes.draw();
      object.begin(7, DefaultVertexFormats.POSITION);
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).minX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).minZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).maxY, ((AxisAlignedBB)density).maxZ).endVertex();
      object.pos(((AxisAlignedBB)density).maxX, ((AxisAlignedBB)density).minY, ((AxisAlignedBB)density).maxZ).endVertex();
      closes.draw();
   }

   public static void _boots(AxisAlignedBB izezezim) {
      Object agametol = Tessellator.getInstance();
      Object nebutimi = agametol.getWorldRenderer();
      nebutimi.begin(3, DefaultVertexFormats.POSITION);
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      agametol.draw();
      nebutimi.begin(3, DefaultVertexFormats.POSITION);
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      agametol.draw();
      nebutimi.begin(1, DefaultVertexFormats.POSITION);
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).minZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).maxX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).minY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      nebutimi.pos(((AxisAlignedBB)izezezim).minX, ((AxisAlignedBB)izezezim).maxY, ((AxisAlignedBB)izezezim).maxZ).endVertex();
      agametol.draw();
   }

   public static void _hunting(double isareyop, double odabudod, double feledeme, double igezibav, int calegane) {
      if (isareyop < feledeme) {
         Object nobogedi = (double)isareyop;
         isareyop = feledeme;
         feledeme = nobogedi;
      }

      if (odabudod < igezibav) {
         Object var17 = (double)odabudod;
         odabudod = igezibav;
         igezibav = var17;
      }

      Object uroyolod = (float)(calegane >> 24 & 255) / 255.0F;
      float var12 = (float)(calegane >> 16 & 255) / 255.0F;
      float var13 = (float)(calegane >> 8 & 255) / 255.0F;
      float var14 = (float)(calegane & 255) / 255.0F;
      Tessellator var15 = Tessellator.getInstance();
      WorldRenderer var16 = var15.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var12, var13, var14, uroyolod);
      var16.begin(7, DefaultVertexFormats.POSITION);
      var16.pos((double)isareyop, (double)igezibav, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)feledeme, (double)igezibav, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)feledeme, (double)odabudod, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)isareyop, (double)odabudod, Double.longBitsToDouble(0L)).endVertex();
      var15.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _botswana(double nickel, double seekers, double nextel, double charges, double var8, int var10, int var11) {
      _hunting(nickel + var8, seekers + var8, nextel - var8, charges - var8, var10);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _hunting(nickel + var8, (double)seekers, nextel - var8, seekers + var8, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _hunting((double)nickel, (double)seekers, nickel + var8, (double)charges, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _hunting(nextel - var8, (double)seekers, (double)nextel, (double)charges, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _hunting(nickel + var8, charges - var8, nextel - var8, (double)charges, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _wooden(double ugisinay, double cufisuni, double movacale, double nafozima, int orobibuz, int itevubam) {
      Object ozodiyob = (float)(orobibuz >> 24 & 255) / 255.0F;
      Object bipegasu = (float)(orobibuz >> 16 & 255) / 255.0F;
      Object dusutuco = (float)(orobibuz >> 8 & 255) / 255.0F;
      Object etupuyir = (float)(orobibuz & 255) / 255.0F;
      Object eziviron = (float)(itevubam >> 24 & 255) / 255.0F;
      Object ufomaret = (float)(itevubam >> 16 & 255) / 255.0F;
      float var16 = (float)(itevubam >> 8 & 255) / 255.0F;
      float var17 = (float)(itevubam & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var18 = Tessellator.getInstance();
      WorldRenderer var19 = var18.getWorldRenderer();
      var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var19.pos((double)movacale, (double)cufisuni, Double.longBitsToDouble(0L)).color(bipegasu, dusutuco, etupuyir, ozodiyob).endVertex();
      var19.pos((double)ugisinay, (double)cufisuni, Double.longBitsToDouble(0L)).color(bipegasu, dusutuco, etupuyir, ozodiyob).endVertex();
      var19.pos((double)ugisinay, (double)nafozima, Double.longBitsToDouble(0L)).color(ufomaret, var16, var17, eziviron).endVertex();
      var19.pos((double)movacale, (double)nafozima, Double.longBitsToDouble(0L)).color(ufomaret, var16, var17, eziviron).endVertex();
      var18.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void _franklin(float eligible, float catalyst, float applying, float nothing, int disputes, int conclude) {
      RenderUtil3._analog();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      float var6;
      float var7;
      float var9;
      RenderUtil3._advance(var6 = eligible * 2.0F, (var7 = catalyst * 2.0F) + 1.0F, (var9 = nothing * 2.0F) - 2.0F, (int)disputes);
      float var8;
      RenderUtil3._advance((var8 = applying * 2.0F) - 1.0F, var7 + 1.0F, var9 - 2.0F, (int)disputes);
      RenderUtil3._seeds(var6 + Float.intBitsToFloat(0), var8 - 1.0F, var7, (int)disputes);
      RenderUtil3._seeds(var6 + Float.intBitsToFloat(0), var8 - 1.0F, var9 - 1.0F, (int)disputes);
      RenderUtil3._seeds(var6 + 2.0F, var6 + 1.0F, var7 + 1.0F, (int)disputes);
      RenderUtil3._seeds(var8 - 2.0F, var8 - 2.0F, var7 + 1.0F, (int)disputes);
      RenderUtil3._seeds(var8 - 2.0F, var8 - 2.0F, var9 - 2.0F, (int)disputes);
      RenderUtil3._seeds(var6 + 1.0F, var6 + 1.0F, var9 - 2.0F, (int)disputes);
      RenderUtil3._magnetic(var6 + 1.0F, var7 + 1.0F, var8 - 1.0F, var9 - 1.0F, (int)conclude);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      RenderUtil3._flexible();
      Gui.drawRect(0, 0, 0, 0, 0);
   }

   public static void _marks(double obifamim, double ugesesov, double edapomit, double gepabivo, double ucocatov, int alalefut) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      Object necurace = (double)(obifamim + edapomit);
      double var13 = (double)(ugesesov + gepabivo);
      float var15 = (float)(alalefut >> 24 & 255) / 255.0F;
      float var16 = (float)(alalefut >> 16 & 255) / 255.0F;
      float var17 = (float)(alalefut >> 8 & 255) / 255.0F;
      float var18 = (float)(alalefut & 255) / 255.0F;
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      obifamim = obifamim * 2.0D;
      ugesesov = ugesesov * 2.0D;
      necurace = necurace * 2.0D;
      var13 = var13 * 2.0D;
      GL11.glDisable(3553);
      GL11.glColor4f(var16, var17, var18, var15);
      GL11.glEnable(2848);
      GL11.glBegin(9);

      for(int var19 = 0; var19 <= 90; var19 += 3) {
         GL11.glVertex2d(obifamim + ucocatov + Math.sin((double)var19 * 3.141592653589793D / 180.0D) * ucocatov * -1.0D, ugesesov + ucocatov + Math.cos((double)var19 * 3.141592653589793D / 180.0D) * ucocatov * -1.0D);
      }

      for(int var24 = 90; var24 <= 180; var24 += 3) {
         GL11.glVertex2d(obifamim + ucocatov + Math.sin((double)var24 * 3.141592653589793D / 180.0D) * ucocatov * -1.0D, var13 - ucocatov + Math.cos((double)var24 * 3.141592653589793D / 180.0D) * ucocatov * -1.0D);
      }

      for(int var25 = 0; var25 <= 90; var25 += 3) {
         GL11.glVertex2d(necurace - ucocatov + Math.sin((double)var25 * 3.141592653589793D / 180.0D) * ucocatov, var13 - ucocatov + Math.cos((double)var25 * 3.141592653589793D / 180.0D) * ucocatov);
      }

      for(int var26 = 90; var26 <= 180; var26 += 3) {
         GL11.glVertex2d(necurace - ucocatov + Math.sin((double)var26 * 3.141592653589793D / 180.0D) * ucocatov, ugesesov + ucocatov + Math.cos((double)var26 * 3.141592653589793D / 180.0D) * ucocatov);
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

   public static void _norman(double lonereci, double basaliri, double mogaluyu, double var6, double var8, int var10) {
      _marks((double)lonereci, (double)basaliri, (double)(mogaluyu - lonereci), var6 - basaliri, var8, var10);
   }

   public static void _horse(float upedamen, float medivusa, float zeroyibo, float unofafap, float iziparan, int ivudayuf, int nolupibu) {
      Gui.drawRect((int)upedamen, (int)medivusa, (int)zeroyibo, (int)unofafap, (int)nolupibu);
      Object igumozav = (float)(ivudayuf >> 24 & 255) / 255.0F;
      Object geferimi = (float)(ivudayuf >> 16 & 255) / 255.0F;
      Object utegacad = (float)(ivudayuf >> 8 & 255) / 255.0F;
      Object dodopote = (float)(ivudayuf & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(geferimi, utegacad, dodopote, igumozav);
      GL11.glLineWidth((float)iziparan);
      GL11.glBegin(1);
      Object asupavat = 2.0F;
      GL11.glVertex2d((double)upedamen + 2.2D, (double)medivusa);
      GL11.glVertex2d((double)zeroyibo - 2.2D, (double)medivusa);
      GL11.glVertex2d((double)upedamen + 2.2D, (double)unofafap);
      GL11.glVertex2d((double)zeroyibo - 2.2D, (double)unofafap);

      for(Object omezuzun = 0; omezuzun <= 90; omezuzun += 3) {
         GL11.glVertex2d((double)(upedamen + asupavat) + Math.sin((double)omezuzun * 3.141592653589793D / 180.0D) * (double)(asupavat * -1.0F), (double)(medivusa + asupavat) + Math.cos((double)omezuzun * 3.141592653589793D / 180.0D) * (double)(asupavat * -1.0F));
      }

      for(Object var13 = 90; var13 <= 180; var13 += 3) {
         GL11.glVertex2d((double)(upedamen + asupavat) + Math.sin((double)var13 * 3.141592653589793D / 180.0D) * (double)(asupavat * -1.0F), (double)(unofafap - asupavat) + Math.cos((double)var13 * 3.141592653589793D / 180.0D) * (double)(asupavat * -1.0F));
      }

      for(Object var14 = 0; var14 <= 90; var14 += 3) {
         GL11.glVertex2d((double)(zeroyibo - asupavat) + Math.sin((double)var14 * 3.141592653589793D / 180.0D) * (double)asupavat, (double)(unofafap - asupavat) + Math.cos((double)var14 * 3.141592653589793D / 180.0D) * (double)asupavat);
      }

      for(Object var15 = 90; var15 <= 180; var15 += 3) {
         GL11.glVertex2d((double)(zeroyibo - asupavat) + Math.sin((double)var15 * 3.141592653589793D / 180.0D) * (double)asupavat, (double)(medivusa + asupavat) + Math.cos((double)var15 * 3.141592653589793D / 180.0D) * (double)asupavat);
      }

      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _toolbar(double esozirad, double izovitos, double var4, double var6) {
      GL11.glColor4d((double)esozirad, (double)izovitos, var4, var6);
   }

   public void _media(double aminiboc, double sibuyosi, double var5) {
      _toolbar((double)aminiboc, (double)sibuyosi, var5, 1.0D);
   }

   public static void _russell(Color boulder) {
      if (boulder == null) {
         boulder = Color.white;
      }

      _toolbar((double)((float)((Color)boulder).getRed() / 255.0F), (double)((float)((Color)boulder).getGreen() / 255.0F), (double)((float)((Color)boulder).getBlue() / 255.0F), (double)((float)((Color)boulder).getAlpha() / 255.0F));
   }

   public void _chapel(Color igigegen, int var2) {
      if (igigegen == null) {
         igigegen = Color.white;
      }

      _toolbar((double)((float)((Color)igigegen).getRed() / 255.0F), (double)((float)((Color)igigegen).getGreen() / 255.0F), (double)((float)((Color)igigegen).getBlue() / 255.0F), 0.5D);
   }

   public static void _integer(double franklin, double worth, double admitted, double var6, int var8) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      _woman(var8);
      GL11.glBegin(7);
      GL11.glVertex2d((double)franklin, var6);
      GL11.glVertex2d((double)admitted, var6);
      GL11.glVertex2d((double)admitted, (double)worth);
      GL11.glVertex2d((double)franklin, (double)worth);
      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static Color _woman(int ducasido) {
      Object raputuri = (float)(ducasido >> 24 & 255) / 256.0F;
      Object vavatode = (float)(ducasido >> 16 & 255) / 255.0F;
      Object biteyado = (float)(ducasido >> 8 & 255) / 255.0F;
      Object cofigeci = (float)(ducasido & 255) / 255.0F;
      GL11.glColor4f(vavatode, biteyado, cofigeci, raputuri);
      return new Color(vavatode, biteyado, cofigeci, raputuri);
   }

   public static double _entrance(double pudeyune, double icufateg, float var4) {
      return pudeyune + (icufateg - pudeyune) * (double)var4;
   }

   public static int _shoppers(float heights, float butter, float warner, long portrait) {
      float var5 = (float)((System.currentTimeMillis() + portrait) % (long)((int)(heights * 1000.0F))) / (heights * 1000.0F);
      return Color.HSBtoRGB(var5, (float)butter, (float)warner);
   }

   public static int _virgin(int egesoyuv, float feragumo) {
      Object nalepipo = new Color((int)egesoyuv);
      Object tofivapo = 0.003921569F * (float)nalepipo.getRed();
      Object bozegesa = 0.003921569F * (float)nalepipo.getGreen();
      Object dotodele = 0.003921569F * (float)nalepipo.getBlue();
      return (new Color(tofivapo, bozegesa, dotodele, (float)feragumo)).getRGB();
   }

   public static void _polish(String zerobudi, float ozucuzug, float amigigic, int ruzecuda) {
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow((String)zerobudi, ozucuzug * 2.0F, amigigic * 2.0F, (int)ruzecuda);
      GL11.glPopMatrix();
   }

   public static void _debian(int makes) {
      Object latitude = (float)(makes >> 24 & 255) / 255.0F;
      Object sheep = (float)(makes >> 16 & 255) / 255.0F;
      Object groove = (float)(makes >> 8 & 255) / 255.0F;
      Object changes = (float)(makes & 255) / 255.0F;
      GL11.glColor4f(sheep, groove, changes, latitude == Float.intBitsToFloat(0) ? 1.0F : latitude);
   }

   public static void _peterson(float omududuz) {
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
      GL11.glLineWidth((float)omududuz);
   }

   public static void _sponsor() {
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

   public static void _preserve(EntityLivingBase smooth, int thriller, double sleeps, double lonely, double var6) {
      AxisAlignedBB var8 = new AxisAlignedBB(sleeps - 0.4D, (double)lonely, var6 - 0.4D, sleeps + 0.4D, lonely + 2.0D, var6 + 0.4D);
      GlStateManager.pushMatrix();
      GlStateManager.translate((double)sleeps, (double)lonely, var6);
      GlStateManager.translate((double)(-sleeps), (double)(-lonely), -var6);
      _peterson(1.0F);
      _debian((int)thriller);
      _boots(var8);
      _sponsor();
      GlStateManager.popMatrix();
   }

   public static void _vernon(EntityLivingBase edeyucec, int dolutunu, double buropuzu, double logucufi, double var6) {
      GL11.glPushMatrix();
      GL11.glTranslated((double)buropuzu, (double)logucufi, var6);
      GL11.glRotatef(-((EntityLivingBase)edeyucec).rotationYaw, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      _debian((int)dolutunu);
      _peterson(1.0F);
      Cylinder var8 = new Cylinder();
      GL11.glRotatef(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      var8.setDrawStyle(100011);
      var8.draw(0.5F, 0.5F, ((EntityLivingBase)edeyucec).height + 0.1F, 18, 1);
      _sponsor();
      GL11.glPopMatrix();
   }

   public static void _believes(float flame, float comfort, float focuses, float reseller) {
      Object elephant = new ScaledResolution(Minecraft.getMinecraft());
      Object vista = elephant.getScaleFactor();
      GL11.glScissor((int)(flame * (float)vista), (int)(((float)elephant.getScaledHeight() - reseller) * (float)vista), (int)((focuses - flame) * (float)vista), (int)((reseller - comfort) * (float)vista));
   }

   public static void _tramadol(double sutidoti, double vuponeru, double gigipumi, double ebiveput, int oruvemub, int guzemalo) {
      Object safesudu = (float)(oruvemub >> 24 & 255) / 255.0F;
      Object ayebadop = (float)(oruvemub >> 16 & 255) / 255.0F;
      Object obopunes = (float)(oruvemub >> 8 & 255) / 255.0F;
      Object nafisoni = (float)(oruvemub & 255) / 255.0F;
      float var14 = (float)(guzemalo >> 24 & 255) / 255.0F;
      float var15 = (float)(guzemalo >> 16 & 255) / 255.0F;
      float var16 = (float)(guzemalo >> 8 & 255) / 255.0F;
      float var17 = (float)(guzemalo & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(ayebadop, obopunes, nafisoni, safesudu);
      GL11.glVertex2d((double)sutidoti, (double)vuponeru);
      GL11.glVertex2d((double)sutidoti, (double)ebiveput);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d((double)gigipumi, (double)ebiveput);
      GL11.glVertex2d((double)gigipumi, (double)vuponeru);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      GL11.glColor4d(255.0D, 255.0D, 255.0D, 255.0D);
   }

   public static double _genes(double wheat, double probe, double boats) {
      boolean var6 = wheat > probe;
      if (boats < Double.longBitsToDouble(0L)) {
         boats = Double.longBitsToDouble(0L);
      } else if (boats > 1.0D) {
         boats = 1.0D;
      }

      if (wheat == probe) {
         return (double)wheat;
      } else {
         double var7 = Math.max((double)wheat, (double)probe) - Math.min((double)wheat, (double)probe);
         double var9 = var7 * boats;
         if (var9 < 0.1D) {
            var9 = 0.1D;
         }

         if (var6) {
            if (probe + var9 > wheat) {
               probe = wheat;
            } else {
               probe = probe + var9;
            }
         } else if (probe - var9 < wheat) {
            probe = wheat;
         } else {
            probe = probe - var9;
         }

         return (double)probe;
      }
   }

   public static void _stopped(String crack, float sierra, float canadian, int matches) {
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      Minecraft.getMinecraft().fontRendererObj.drawString((String)crack, (int)(sierra * 2.0F - 1.0F), (int)(canadian * 2.0F), Color.BLACK.getRGB());
      Minecraft.getMinecraft().fontRendererObj.drawString((String)crack, (int)(sierra * 2.0F + 1.0F), (int)(canadian * 2.0F), Color.BLACK.getRGB());
      Minecraft.getMinecraft().fontRendererObj.drawString((String)crack, (int)(sierra * 2.0F), (int)(canadian * 2.0F - 1.0F), Color.BLACK.getRGB());
      Minecraft.getMinecraft().fontRendererObj.drawString((String)crack, (int)(sierra * 2.0F), (int)(canadian * 2.0F + 1.0F), Color.BLACK.getRGB());
      Minecraft.getMinecraft().fontRendererObj.drawString((String)crack, (int)(sierra * 2.0F), (int)(canadian * 2.0F), (int)matches);
      GL11.glPopMatrix();
   }

   public static void _dividend(Color fogicuse) {
      Object yesotese = (float)(((Color)fogicuse).getRGB() >> 24 & 255) / 255.0F;
      Object umodacoc = (float)(((Color)fogicuse).getRGB() >> 16 & 255) / 255.0F;
      Object amubesom = (float)(((Color)fogicuse).getRGB() >> 8 & 255) / 255.0F;
      Object peyatemi = (float)(((Color)fogicuse).getRGB() & 255) / 255.0F;
      GL11.glColor4f(umodacoc, amubesom, peyatemi, yesotese == Float.intBitsToFloat(0) ? 1.0F : yesotese);
   }

   public static void _glenn(Entity modem, Color describe) {
      Object holding = ((Entity)modem).lastTickPosX + (((Entity)modem).posX - ((Entity)modem).lastTickPosX) * (double) Helper._pillow().renderPartialTicks - Minecraft.getMinecraft().getRenderManager().renderPosX;
      Object monday = ((Entity)modem).lastTickPosY + (((Entity)modem).posY - ((Entity)modem).lastTickPosY) * (double) Helper._pillow().renderPartialTicks - Minecraft.getMinecraft().getRenderManager().renderPosY;
      double var6 = ((Entity)modem).lastTickPosZ + (((Entity)modem).posZ - ((Entity)modem).lastTickPosZ) * (double) Helper._pillow().renderPartialTicks - Minecraft.getMinecraft().getRenderManager().renderPosZ;
      net.minecraft.util.Vec3 var8 = (new net.minecraft.util.Vec3(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 1.0D)).rotatePitch((float)(-Math.toRadians((double)Minecraft.getMinecraft().thePlayer.rotationPitch))).rotateYaw((float)(-Math.toRadians((double)Minecraft.getMinecraft().thePlayer.rotationYaw)));
      _dividend((Color)describe);
      GL11.glVertex3d(var8.xCoord, (double)Minecraft.getMinecraft().thePlayer.eyeHeight + var8.yCoord, var8.zCoord);
      GL11.glVertex3d(holding, monday, var6);
      GL11.glVertex3d(holding, monday, var6);
      GL11.glVertex3d(holding, monday + (double)((Entity)modem).height, var6);
   }

   public static void _parties(float tibizema) {
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
      GL11.glLineWidth((float)tibizema);
   }

   public static void _impact() {
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

   public static boolean _toxic(float adevafef, float miniduzu, float emabemas, float yubosufe, float yecazaya, float potuyupa) {
      return adevafef > emabemas && adevafef < yecazaya && miniduzu > yubosufe && miniduzu < potuyupa;
   }

   public static void _poland(double cifayiza, double ipavitil, double uvelovet, double erumupoz, double var8, int var10, int var11) {
      _integer(cifayiza + var8, ipavitil + var8, uvelovet - var8, erumupoz - var8, var10);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _integer(cifayiza + var8, (double)ipavitil, uvelovet - var8, ipavitil + var8, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _integer((double)cifayiza, (double)ipavitil, cifayiza + var8, (double)erumupoz, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _integer(uvelovet - var8, (double)ipavitil, (double)uvelovet, (double)erumupoz, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _integer(cifayiza + var8, erumupoz - var8, uvelovet - var8, (double)erumupoz, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _suspect(double upulomot, double nabomivi, double satetama, double gogovime, double var8, int var10, int var11) {
      _integer((double)upulomot, (double)nabomivi, (double)(upulomot + satetama), (double)(nabomivi + gogovime), var11);
      _integer((double)upulomot, (double)nabomivi, (double)(upulomot + satetama), nabomivi + var8, var10);
      _integer((double)upulomot, (double)nabomivi, upulomot + var8, (double)(nabomivi + gogovime), var10);
      _integer((double)(upulomot + satetama), (double)nabomivi, upulomot + satetama - var8, (double)(nabomivi + gogovime), var10);
      _integer((double)upulomot, (double)(nabomivi + gogovime), (double)(upulomot + satetama), nabomivi + gogovime - var8, var10);
   }

   public static float _kelly(double udodirob, double cuzevevi, double sigacare) {
      boolean var6 = udodirob > cuzevevi;
      if (sigacare < Double.longBitsToDouble(0L)) {
         sigacare = Double.longBitsToDouble(0L);
      } else if (sigacare > 1.0D) {
         sigacare = 1.0D;
      }

      double var7 = Math.abs((double)(cuzevevi - udodirob));
      double var9 = var7 * sigacare;
      if (var6) {
         cuzevevi = cuzevevi + var9;
      } else {
         cuzevevi = cuzevevi - var9;
      }

      return (float)cuzevevi;
   }

   public static float _plaza(float canada, float outer, float heated) {
      Object boost = canada > outer;
      if (heated < Float.intBitsToFloat(0)) {
         heated = Float.intBitsToFloat(0);
      } else if (heated > 1.0F) {
         heated = 1.0F;
      }

      Object abuse = Math.abs((float)(outer - canada));
      Object retail = abuse * heated;
      if (boost) {
         outer = outer + retail;
      } else {
         outer = outer - retail;
      }

      return (float)outer;
   }

   public static void _archived(double unatapir, double aniputoc, double tevarifi, double afobotiv, double foravome, int var10, int var11, float var12) {
      double var13 = (double)(unatapir + tevarifi);
      double var15 = (double)(aniputoc + afobotiv);
      GL11.glPushAttrib(0);
      if (foravome < 1.0D) {
         foravome = 1.0D;
      }

      if (foravome > afobotiv / 2.0D) {
         foravome = afobotiv / 2.0D;
      }

      if (foravome > tevarifi / 2.0D) {
         foravome = tevarifi / 2.0D;
      }

      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      if (var10 != 0) {
         _woman(var10);
         GL11.glBegin(9);
         _tickets((double)unatapir, (double)aniputoc, var13, var15, (double)foravome);
         GL11.glEnd();
      }

      if (var12 > Float.intBitsToFloat(0) && var11 != 0) {
         _woman(var11);
         GL11.glLineWidth(var12);
         GL11.glBegin(2);
         _tickets((double)unatapir, (double)aniputoc, var13, var15, (double)foravome);
         GL11.glEnd();
      }

      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glPopAttrib();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _stocks(AbstractClientPlayer forty, int naked, int catalogs, int mainland, int month) {
      Object print = ((AbstractClientPlayer)forty).getLocationSkin();
      Minecraft.getMinecraft().getTextureManager().bindTexture(print);
      Gui.drawScaledCustomSizeModalRect((int)naked, (int)catalogs, 8.0F, 8.0F, 8, 8, (int)mainland, (int)month, 64.0F, 64.0F);
   }

   public static void _intended(double ebucozep, double esirubuf, float usiyovep, float upibupuz, double asesivuf, double tebocapi, float vufezeta, float odonulun) {
      float var12 = 1.0F / vufezeta;
      float var13 = 1.0F / odonulun;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(7, DefaultVertexFormats.POSITION_TEX);
      var15.pos((double)ebucozep, (double)(esirubuf + tebocapi), Double.longBitsToDouble(0L)).tex((double)(usiyovep * var12), (double)((upibupuz + (float)tebocapi) * var13)).endVertex();
      var15.pos((double)(ebucozep + asesivuf), (double)(esirubuf + tebocapi), Double.longBitsToDouble(0L)).tex((double)((usiyovep + (float)asesivuf) * var12), (double)((upibupuz + (float)tebocapi) * var13)).endVertex();
      var15.pos((double)(ebucozep + asesivuf), (double)esirubuf, Double.longBitsToDouble(0L)).tex((double)((usiyovep + (float)asesivuf) * var12), (double)(upibupuz * var13)).endVertex();
      var15.pos((double)ebucozep, (double)esirubuf, Double.longBitsToDouble(0L)).tex((double)(usiyovep * var12), (double)(upibupuz * var13)).endVertex();
      var14.draw();
   }

   public static void _vault(double usotuyev, double geseragi, double tufubira, double liyedozu, int rinobagi, int ogugelap) {
      Object guyoyife = (float)(rinobagi >> 24 & 255) / 255.0F;
      Object anevicoz = (float)(rinobagi >> 16 & 255) / 255.0F;
      Object efumubol = (float)(rinobagi >> 8 & 255) / 255.0F;
      Object disarare = (float)(rinobagi & 255) / 255.0F;
      float var14 = (float)(ogugelap >> 24 & 255) / 255.0F;
      float var15 = (float)(ogugelap >> 16 & 255) / 255.0F;
      float var16 = (float)(ogugelap >> 8 & 255) / 255.0F;
      float var17 = (float)(ogugelap & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(anevicoz, efumubol, disarare, guyoyife);
      GL11.glVertex2d((double)usotuyev, (double)geseragi);
      GL11.glVertex2d((double)usotuyev, (double)liyedozu);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d((double)tufubira, (double)liyedozu);
      GL11.glVertex2d((double)tufubira, (double)geseragi);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
   }

   public static void _partial(double forgot, double fighters, double poultry, double var6, ResourceLocation var8) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var8);
      _intended((double)forgot, (double)fighters, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (double)poultry, var6, (float)poultry, (float)var6);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _tickets(double onibicug, double pibuvibi, double ovamubef, double var6, double var8) {
      double var10 = 0.017453292519943295D;

      for(int var12 = 0; var12 <= 90; var12 += 3) {
         GL11.glVertex2d(onibicug + var8 + Math.sin((double)var12 * 0.017453292519943295D) * var8 * -1.0D, pibuvibi + var8 + Math.cos((double)var12 * 0.017453292519943295D) * var8 * -1.0D);
      }

      for(int var13 = 90; var13 <= 180; var13 += 3) {
         GL11.glVertex2d(onibicug + var8 + Math.sin((double)var13 * 0.017453292519943295D) * var8 * -1.0D, var6 - var8 + Math.cos((double)var13 * 0.017453292519943295D) * var8 * -1.0D);
      }

      for(int var14 = 0; var14 <= 90; var14 += 3) {
         GL11.glVertex2d(ovamubef - var8 + Math.sin((double)var14 * 0.017453292519943295D) * var8, var6 - var8 + Math.cos((double)var14 * 0.017453292519943295D) * var8);
      }

      for(int var15 = 90; var15 <= 180; var15 += 3) {
         GL11.glVertex2d(ovamubef - var8 + Math.sin((double)var15 * 0.017453292519943295D) * var8, pibuvibi + var8 + Math.cos((double)var15 * 0.017453292519943295D) * var8);
      }

   }

   public static double _weapon() {
      return Minecraft.getDebugFPS() > 0 ? 1.0D / (double)Minecraft.getDebugFPS() : 1.0D;
   }

   public static void _exhaust(float emiciviy) {
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(516, (float)((double)emiciviy * 0.01D));
   }

   public static void _linux() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _warrior(int tipomeyi, float ofubemib) {
      Object uludaciz = (float)(tipomeyi >> 16 & 255) / 255.0F;
      Object ayofarab = (float)(tipomeyi >> 8 & 255) / 255.0F;
      Object gisevani = (float)(tipomeyi & 255) / 255.0F;
      GlStateManager.color(uludaciz, ayofarab, gisevani, (float)ofubemib);
   }

   public static void _headline(int warriors) {
      _warrior((int)warriors, (float)(warriors >> 24 & 255) / 255.0F);
   }

   public static void _relative(int monaco, int operated, int occasion, int store, AbstractClientPlayer deutsch) {
      _italiano();
      Minecraft.getMinecraft().getTextureManager().bindTexture(((AbstractClientPlayer)deutsch).getLocationSkin());
      Gui.drawScaledCustomSizeModalRect((int)monaco, (int)operated, 8.0F, 8.0F, 8, 8, (int)occasion, (int)store, 64.0F, 64.0F);
      _fonts();
   }

   public static void _joined(double intend, double babies, double focusing, int var6) {
      focusing = focusing / 2.0D;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glDisable(2884);
      _headline(var6);
      GL11.glBegin(6);

      for(double var7 = Double.longBitsToDouble(0L); var7 <= 120.0D; ++var7) {
         double var9 = var7 * 6.283185307179586D / 360.0D;
         GL11.glVertex2d(intend + focusing * Math.cos(var9) + focusing, babies + focusing * Math.sin(var9) + focusing);
      }

      GL11.glEnd();
      GL11.glEnable(2884);
      GL11.glEnable(3553);
   }
}
