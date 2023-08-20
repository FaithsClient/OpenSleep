//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.elements;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import ft.sleep.util.block.BlockUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class LiuqidRender {
   public static Map santa$ = new HashMap();
   public static int ability$;

   public static void _tyler(BlockPos vafimeca, Color yilopero, boolean uzuladod) {
      Object gatisobo = Minecraft.getMinecraft().getRenderManager();
      Object zebozera = Minecraft.getMinecraft().timer;
      Object posivigi = (double)((BlockPos)vafimeca).getX() - gatisobo.renderPosX;
      Object receyici = (double)((BlockPos)vafimeca).getY() - gatisobo.renderPosY;
      Object uyirezov = (double)((BlockPos)vafimeca).getZ() - gatisobo.renderPosZ;
      Object yetamanu = new AxisAlignedBB(posivigi, receyici, uyirezov, posivigi + 1.0D, receyici + 1.0D, uyirezov + 1.0D);
      Object epofabes = BlockUtils._sounds((BlockPos)vafimeca);
      if (epofabes != null) {
         Object sofayomo = Minecraft.getMinecraft().thePlayer;
         double var14 = sofayomo.lastTickPosX + (sofayomo.posX - sofayomo.lastTickPosX) * (double)zebozera.renderPartialTicks;
         double var16 = sofayomo.lastTickPosY + (sofayomo.posY - sofayomo.lastTickPosY) * (double)zebozera.renderPartialTicks;
         double var18 = sofayomo.lastTickPosZ + (sofayomo.posZ - sofayomo.lastTickPosZ) * (double)zebozera.renderPartialTicks;
         yetamanu = epofabes.getSelectedBoundingBox(Minecraft.getMinecraft().theWorld, (BlockPos)vafimeca).expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).offset(-var14, -var16, -var18);
      }

      GL11.glBlendFunc(770, 771);
      _unions(3042);
      _event(3553, 2929);
      GL11.glDepthMask(false);
      _shore(new Color(((Color)yilopero).getRed(), ((Color)yilopero).getGreen(), ((Color)yilopero).getBlue(), ((Color)yilopero).getAlpha() == 255 ? (uzuladod ? 130 : 50) : ((Color)yilopero).getAlpha()));
      _bizrate(yetamanu);
      if (uzuladod) {
         GL11.glLineWidth(1.0F);
         _unions(2848);
         _shore((Color)yilopero);
      }

      GlStateManager.resetColor();
      GL11.glDepthMask(true);
      _scroll();
   }

   public static void _relay(Entity sponsors, AxisAlignedBB politics, Color naval, boolean module) {
      Object getting = Minecraft.getMinecraft().getRenderManager();
      Object logic = Minecraft.getMinecraft().timer.renderPartialTicks;
      GL11.glBlendFunc(770, 771);
      _unions(3042);
      _event(3553, 2929);
      GL11.glDepthMask(false);
      Object boxed = ((Entity)sponsors).lastTickPosX + (((Entity)sponsors).posX - ((Entity)sponsors).lastTickPosX) * (double)logic - getting.viewerPosX;
      Object marriage = ((Entity)sponsors).lastTickPosY + (((Entity)sponsors).posY - ((Entity)sponsors).lastTickPosY) * (double)logic - getting.viewerPosY;
      double var10 = ((Entity)sponsors).lastTickPosZ + (((Entity)sponsors).posZ - ((Entity)sponsors).lastTickPosZ) * (double)logic - getting.viewerPosZ;
      AxisAlignedBB var12 = new AxisAlignedBB(((AxisAlignedBB)politics).minX - ((Entity)sponsors).posX + boxed - 0.15D, ((AxisAlignedBB)politics).minY - ((Entity)sponsors).posY + marriage, ((AxisAlignedBB)politics).minZ - ((Entity)sponsors).posZ + var10 - 0.15D, ((AxisAlignedBB)politics).maxX - ((Entity)sponsors).posX + boxed + 0.15D, ((AxisAlignedBB)politics).maxY - ((Entity)sponsors).posY + marriage + 0.25D, ((AxisAlignedBB)politics).maxZ - ((Entity)sponsors).posZ + var10 + 0.15D);
      if (module) {
         GL11.glLineWidth(1.0F);
         _unions(2848);
         _kenny(((Color)naval).getRed(), ((Color)naval).getGreen(), ((Color)naval).getBlue(), 95);
         RenderGlobal.drawSelectionBoundingBox(var12);
      }

      _kenny(((Color)naval).getRed(), ((Color)naval).getGreen(), ((Color)naval).getBlue(), module ? 75 : 35);
      _bizrate(var12);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDepthMask(true);
      _scroll();
   }

   public static void _kenny(int utuyirup, int mamageyu, int nidaroci, int amofefoz) {
      GL11.glColor4f((float)utuyirup / 255.0F, (float)mamageyu / 255.0F, (float)nidaroci / 255.0F, (float)amofefoz / 255.0F);
   }

   public static void _marsh(AxisAlignedBB zoyanoco, Color doroyata) {
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      if (doroyata != null) {
         _shore((Color)doroyata);
      }

      _bizrate((AxisAlignedBB)zoyanoco);
      GlStateManager.resetColor();
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
   }

   public static void _builder(double titten, Color awarded, double cellular) {
      RenderManager var5 = Minecraft.getMinecraft().getRenderManager();
      double var6 = titten - var5.renderPosY;
      _marsh(new AxisAlignedBB((double)cellular, var6 + 0.02D, (double)cellular, (double)(-cellular), var6, (double)(-cellular)), (Color)awarded);
   }

   public static void _aquatic(Entity yefuluyu, Color egenazav) {
      Object rifurogu = Minecraft.getMinecraft().getRenderManager();
      Object ripupede = Minecraft.getMinecraft().timer;
      Object atufobed = ((Entity)yefuluyu).lastTickPosX + (((Entity)yefuluyu).posX - ((Entity)yefuluyu).lastTickPosX) * (double)ripupede.renderPartialTicks - rifurogu.renderPosX;
      Object enunalot = ((Entity)yefuluyu).lastTickPosY + (((Entity)yefuluyu).posY - ((Entity)yefuluyu).lastTickPosY) * (double)ripupede.renderPartialTicks - rifurogu.renderPosY;
      double var8 = ((Entity)yefuluyu).lastTickPosZ + (((Entity)yefuluyu).posZ - ((Entity)yefuluyu).lastTickPosZ) * (double)ripupede.renderPartialTicks - rifurogu.renderPosZ;
      AxisAlignedBB var10 = ((Entity)yefuluyu).getEntityBoundingBox().offset(-((Entity)yefuluyu).posX, -((Entity)yefuluyu).posY, -((Entity)yefuluyu).posZ).offset(atufobed, enunalot, var8);
      _marsh(new AxisAlignedBB(var10.minX, var10.maxY + 0.2D, var10.minZ, var10.maxX, var10.maxY + 0.26D, var10.maxZ), (Color)egenazav);
   }

   public static void _bizrate(AxisAlignedBB nodotaze) {
      Object aliyotef = Tessellator.getInstance();
      Object buzifeco = aliyotef.getWorldRenderer();
      buzifeco.begin(7, DefaultVertexFormats.POSITION);
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      aliyotef.draw();
      buzifeco.begin(7, DefaultVertexFormats.POSITION);
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      aliyotef.draw();
      buzifeco.begin(7, DefaultVertexFormats.POSITION);
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      aliyotef.draw();
      buzifeco.begin(7, DefaultVertexFormats.POSITION);
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      aliyotef.draw();
      buzifeco.begin(7, DefaultVertexFormats.POSITION);
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      aliyotef.draw();
      buzifeco.begin(7, DefaultVertexFormats.POSITION);
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).minX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).minZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).maxY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      buzifeco.pos(((AxisAlignedBB)nodotaze).maxX, ((AxisAlignedBB)nodotaze).minY, ((AxisAlignedBB)nodotaze).maxZ).endVertex();
      aliyotef.draw();
   }

   public static void _related(float visoyoru, float subanuto, float tudeneme, float zebebara, int ufezacet) {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      _mysql((int)ufezacet);
      GL11.glBegin(7);
      GL11.glVertex2d((double)tudeneme, (double)subanuto);
      GL11.glVertex2d((double)visoyoru, (double)subanuto);
      GL11.glVertex2d((double)visoyoru, (double)zebebara);
      GL11.glVertex2d((double)tudeneme, (double)zebebara);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _naval(float iconutav, float sofisira, float milozeca, float ecazepuz, Color eforociy) {
      _related((float)iconutav, (float)sofisira, (float)milozeca, (float)ecazepuz, ((Color)eforociy).getRGB());
   }

   public static void _reveals(float ibudurag, float izizucos, float ladenico, float fobisacu, float getaligo, int icilorib, int opemutim) {
      _related((float)ibudurag, (float)izizucos, (float)ladenico, (float)fobisacu, (int)opemutim);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      _mysql((int)icilorib);
      GL11.glLineWidth((float)getaligo);
      GL11.glBegin(1);
      GL11.glVertex2d((double)ibudurag, (double)izizucos);
      GL11.glVertex2d((double)ibudurag, (double)fobisacu);
      GL11.glVertex2d((double)ladenico, (double)fobisacu);
      GL11.glVertex2d((double)ladenico, (double)izizucos);
      GL11.glVertex2d((double)ibudurag, (double)izizucos);
      GL11.glVertex2d((double)ladenico, (double)izizucos);
      GL11.glVertex2d((double)ibudurag, (double)fobisacu);
      GL11.glVertex2d((double)ladenico, (double)fobisacu);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _fifteen(float youth, float moment) {
      for(Object maiden = 0; maiden < 4; ++maiden) {
         Object decades = (int)(System.nanoTime() / ((long)1308609865 ^ 1303610889L) * (long)maiden % ((long)-1669783351 ^ -1669783135L));
         _staying((float)youth, (float)moment, (float)(maiden * 10), decades - 180, decades);
      }

   }

   public static void _staying(float optical, float atlas, float rental, int routine, int learning) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      _shore(Color.WHITE);
      GL11.glEnable(2848);
      GL11.glLineWidth(2.0F);
      GL11.glBegin(3);

      for(Object breast = (float)learning; breast >= (float)routine; breast -= 4.0F) {
         GL11.glVertex2f((float)((double)optical + Math.cos((double)breast * 3.141592653589793D / 180.0D) * (double)(rental * 1.001F)), (float)((double)atlas + Math.sin((double)breast * 3.141592653589793D / 180.0D) * (double)(rental * 1.001F)));
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _attached(int adisenip, int ugovicoc, float risazesa, Color cinodapo) {
      Object abageliv = 50;
      Object emedufup = 6.283185307179586D / (double)abageliv;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glBegin(6);

      for(int var9 = 0; var9 < abageliv; ++var9) {
         Object fugiseva = (float)((double)risazesa * Math.sin((double)var9 * emedufup));
         Object adomonon = (float)((double)risazesa * Math.cos((double)var9 * emedufup));
         GL11.glColor4f((float)((Color)cinodapo).getRed() / 255.0F, (float)((Color)cinodapo).getGreen() / 255.0F, (float)((Color)cinodapo).getBlue() / 255.0F, (float)((Color)cinodapo).getAlpha() / 255.0F);
         GL11.glVertex2f((float)adisenip + fugiseva, (float)ugovicoc + adomonon);
      }

      GlStateManager.color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glPopMatrix();
   }

   public static void _judge(ResourceLocation electro, int versions, int november, int highest, int metals) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)electro);
      Gui.drawModalRectWithCustomSizedTexture((int)versions, (int)november, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)highest, (int)metals, (float)highest, (float)metals);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _shore(Color profit) {
      GL11.glColor4f((float)((Color)profit).getRed() / 255.0F, (float)((Color)profit).getGreen() / 255.0F, (float)((Color)profit).getBlue() / 255.0F, (float)((Color)profit).getAlpha() / 255.0F);
   }

   public static void _mysql(int great) {
      Object touring = (float)(great >> 24 & 255) / 255.0F;
      Object truly = (float)(great >> 16 & 255) / 255.0F;
      Object until = (float)(great >> 8 & 255) / 255.0F;
      Object grace = (float)(great & 255) / 255.0F;
      GL11.glColor4f(truly, until, grace, touring);
   }

   public static Color _repeated(int porter) {
      Object tennis = (float)(porter >> 24 & 255) / 255.0F;
      Object daisy = (float)(porter >> 16 & 255) / 255.0F;
      Object punch = (float)(porter >> 8 & 255) / 255.0F;
      Object spice = (float)(porter & 255) / 255.0F;
      return new Color(daisy, punch, spice, tennis);
   }

   public static void _exports(EntityLivingBase vipuputa, double aseremut, double neditaza, double zoziyefo, int var7, int var8) {
      GlStateManager.pushMatrix();
      GlStateManager.translate((double)aseremut, (double)neditaza, (double)zoziyefo);
      GL11.glNormal3f(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.scale(-0.1D, -0.1D, 0.1D);
      GL11.glDisable(2929);
      GL11.glBlendFunc(770, 771);
      GlStateManager.enableTexture2D();
      GlStateManager.depthMask(true);
      _related(-7.0F, 2.0F, -4.0F, 3.0F, var7);
      _related(4.0F, 2.0F, 7.0F, 3.0F, var7);
      _related(-7.0F, 0.5F, -6.0F, 3.0F, var7);
      _related(6.0F, 0.5F, 7.0F, 3.0F, var7);
      _related(-7.0F, 3.0F, -4.0F, 3.3F, var8);
      _related(4.0F, 3.0F, 7.0F, 3.3F, var8);
      _related(-7.3F, 0.5F, -7.0F, 3.3F, var8);
      _related(7.0F, 0.5F, 7.3F, 3.3F, var8);
      GlStateManager.translate(Double.longBitsToDouble(0L), 21.0D + -(((EntityLivingBase)vipuputa).getEntityBoundingBox().maxY - ((EntityLivingBase)vipuputa).getEntityBoundingBox().minY) * 12.0D, Double.longBitsToDouble(0L));
      _related(4.0F, -20.0F, 7.0F, -19.0F, var7);
      _related(-7.0F, -20.0F, -4.0F, -19.0F, var7);
      _related(6.0F, -20.0F, 7.0F, -17.5F, var7);
      _related(-7.0F, -20.0F, -6.0F, -17.5F, var7);
      _related(7.0F, -20.0F, 7.3F, -17.5F, var8);
      _related(-7.3F, -20.0F, -7.0F, -17.5F, var8);
      _related(4.0F, -20.3F, 7.3F, -20.0F, var8);
      _related(-7.3F, -20.3F, -4.0F, -20.0F, var8);
      GL11.glEnable(2929);
      GlStateManager.popMatrix();
   }

   public static void _forum(BlockPos rupoyima, int epanapun, int didodovo) {
      Object aporafes = Minecraft.getMinecraft().getRenderManager();
      Object desubofe = (double)((BlockPos)rupoyima).getX() + 0.5D - aporafes.renderPosX;
      Object temodumo = (double)((BlockPos)rupoyima).getY() - aporafes.renderPosY;
      double var8 = (double)((BlockPos)rupoyima).getZ() + 0.5D - aporafes.renderPosZ;
      GlStateManager.pushMatrix();
      GlStateManager.translate(desubofe, temodumo, var8);
      GL11.glNormal3f(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.scale(-0.1D, -0.1D, 0.1D);
      _primary(2929, false);
      GL11.glBlendFunc(770, 771);
      GlStateManager.enableTexture2D();
      GlStateManager.depthMask(true);
      _related(-7.0F, 2.0F, -4.0F, 3.0F, (int)epanapun);
      _related(4.0F, 2.0F, 7.0F, 3.0F, (int)epanapun);
      _related(-7.0F, 0.5F, -6.0F, 3.0F, (int)epanapun);
      _related(6.0F, 0.5F, 7.0F, 3.0F, (int)epanapun);
      _related(-7.0F, 3.0F, -4.0F, 3.3F, (int)didodovo);
      _related(4.0F, 3.0F, 7.0F, 3.3F, (int)didodovo);
      _related(-7.3F, 0.5F, -7.0F, 3.3F, (int)didodovo);
      _related(7.0F, 0.5F, 7.3F, 3.3F, (int)didodovo);
      GlStateManager.translate(Float.intBitsToFloat(0), 9.0F, Float.intBitsToFloat(0));
      _related(4.0F, -20.0F, 7.0F, -19.0F, (int)epanapun);
      _related(-7.0F, -20.0F, -4.0F, -19.0F, (int)epanapun);
      _related(6.0F, -20.0F, 7.0F, -17.5F, (int)epanapun);
      _related(-7.0F, -20.0F, -6.0F, -17.5F, (int)epanapun);
      _related(7.0F, -20.0F, 7.3F, -17.5F, (int)didodovo);
      _related(-7.3F, -20.0F, -7.0F, -17.5F, (int)didodovo);
      _related(4.0F, -20.3F, 7.3F, -20.0F, (int)didodovo);
      _related(-7.3F, -20.3F, -4.0F, -20.0F, (int)didodovo);
      _scroll();
      GlStateManager.popMatrix();
   }

   public static void _brake(double paferofu, double guvacesu, double tirilizo, double var6, float var8) {
      GL11.glDisable(3553);
      GL11.glLineWidth(var8);
      GL11.glBegin(1);
      GL11.glVertex2d((double)paferofu, (double)guvacesu);
      GL11.glVertex2d((double)tirilizo, var6);
      GL11.glEnd();
      GL11.glEnable(3553);
   }

   public static void _clients(float chelsea, float begun, float viewers, float registry) {
      Object horse = new ScaledResolution(Minecraft.getMinecraft());
      Object earliest = horse.getScaleFactor();
      GL11.glScissor((int)(chelsea * (float)earliest), (int)(((float)horse.getScaledHeight() - registry) * (float)earliest), (int)((viewers - chelsea) * (float)earliest), (int)((registry - begun) * (float)earliest));
   }

   public static void _scroll() {
      santa$.forEach(LiuqidRender::_evans);
   }

   public static void _unions(int wiring) {
      _primary((int)wiring, true);
   }

   public static void _drivers(int... uforupat) {
      for(Object ibemenip : uforupat) {
         _primary(ibemenip, true);
      }

   }

   public static void _front(int sapezero) {
      _primary((int)sapezero, true);
   }

   public static void _event(int... igutelod) {
      for(Object sonepizo : igutelod) {
         _primary(sonepizo, false);
      }

   }

   public static void _primary(int gusacofa, boolean efizoyut) {
      santa$.put(Integer.valueOf((int)gusacofa), Boolean.valueOf(GL11.glGetBoolean((int)gusacofa)));
      _evans((int)gusacofa, (boolean)efizoyut);
   }

   public static void _evans(int donation, boolean deaths) {
      if (deaths) {
         GL11.glEnable((int)donation);
      } else {
         GL11.glDisable((int)donation);
      }

   }
}
