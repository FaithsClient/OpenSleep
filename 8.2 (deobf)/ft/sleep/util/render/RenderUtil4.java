//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import ft.sleep.injection.interfaces.IEntityRenderer;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import ft.sleep.util.animation.Animation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderUtil4 {
   public static Minecraft explain$ = Minecraft.getMinecraft();
   public static Map comply$ = new HashMap();

   public static void _tired(float selling, float scotland, float benefits, Runnable chorus) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)selling, (float)scotland, Float.intBitsToFloat(0));
      GL11.glScalef((float)benefits, (float)benefits, 1.0F);
      GL11.glTranslatef((float)(-selling), (float)(-scotland), Float.intBitsToFloat(0));
      ((Runnable)chorus).run();
      GL11.glPopMatrix();
   }

   public static void _ceiling(float ragoyize, float osizobev, float upilayaz, float fizonusi, int nayafaza, int alarugod) {
      upilayaz = ragoyize + upilayaz;
      fizonusi = osizobev + fizonusi;
      Object oleronaf = (float)(nayafaza >> 24 & 255) / 255.0F;
      Object buzabade = (float)(nayafaza >> 16 & 255) / 255.0F;
      Object palesune = (float)(nayafaza >> 8 & 255) / 255.0F;
      Object ecumever = (float)(nayafaza & 255) / 255.0F;
      Object zipafega = (float)(alarugod >> 24 & 255) / 255.0F;
      Object epetenot = (float)(alarugod >> 16 & 255) / 255.0F;
      Object totibeya = (float)(alarugod >> 8 & 255) / 255.0F;
      Object yucunalu = (float)(alarugod & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Object odinubey = Tessellator.getInstance();
      Object oyepotat = odinubey.getWorldRenderer();
      oyepotat.begin(7, DefaultVertexFormats.POSITION_COLOR);
      oyepotat.pos((double)upilayaz, (double)osizobev, Double.longBitsToDouble(0L)).color(buzabade, palesune, ecumever, oleronaf).endVertex();
      oyepotat.pos((double)ragoyize, (double)osizobev, Double.longBitsToDouble(0L)).color(buzabade, palesune, ecumever, oleronaf).endVertex();
      oyepotat.pos((double)ragoyize, (double)fizonusi, Double.longBitsToDouble(0L)).color(epetenot, totibeya, yucunalu, zipafega).endVertex();
      oyepotat.pos((double)upilayaz, (double)fizonusi, Double.longBitsToDouble(0L)).color(epetenot, totibeya, yucunalu, zipafega).endVertex();
      odinubey.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void _expanded(double zozoceve, double egubizov, double var4, double var6) {
      _oakland((double)zozoceve, (double)egubizov, zozoceve + var4, egubizov + var6, Color.BLACK.getRGB());
      _oakland(zozoceve + 1.0D, egubizov + 1.0D, zozoceve + var4 - 1.0D, egubizov + var6 - 1.0D, (new Color(55, 55, 55)).getRGB());
      _oakland(zozoceve + 1.0D, egubizov + 1.5D, zozoceve + var4 - 2.0D, egubizov + var6 - 1.5D, (new Color(30, 30, 30)).getRGB());
      _oakland(zozoceve + 3.0D, egubizov + 3.0D, zozoceve + var4 - 3.0D, egubizov + var6 - 3.0D, (new Color(14, 14, 14)).getRGB());
   }

   public static void _optional(float naramulo, float yozufiti, float egegipug, float iyocuzuf, int yubaruse) {
      Object yepifofu = (float)(yubaruse >> 24 & 255) / 255.0F;
      Object remibezu = (float)(yubaruse >> 16 & 255) / 255.0F;
      Object duvipuna = (float)(yubaruse >> 8 & 255) / 255.0F;
      Object ayalufil = (float)(yubaruse & 255) / 255.0F;
      Object vugimiso = Tessellator.getInstance();
      Object imererop = vugimiso.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(remibezu, duvipuna, ayalufil, yepifofu);
      imererop.begin(7, DefaultVertexFormats.POSITION);
      imererop.pos((double)naramulo, (double)(yozufiti + iyocuzuf), Double.longBitsToDouble(0L)).endVertex();
      imererop.pos((double)(naramulo + egegipug), (double)(yozufiti + iyocuzuf), Double.longBitsToDouble(0L)).endVertex();
      imererop.pos((double)(naramulo + egegipug), (double)yozufiti, Double.longBitsToDouble(0L)).endVertex();
      imererop.pos((double)naramulo, (double)yozufiti, Double.longBitsToDouble(0L)).endVertex();
      vugimiso.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _knowing(float invalid, float forming, float sender, float liberal, float briefly, int miles, float infected, int michelle) {
      if (miles == 16777215) {
         miles = -65794;
      }

      if (michelle == 16777215) {
         michelle = -65794;
      }

      if (briefly < Float.intBitsToFloat(0)) {
         briefly = Float.intBitsToFloat(0);
      }

      if (briefly > sender / 2.0F) {
         briefly = sender / 2.0F;
      }

      if (briefly > liberal / 2.0F) {
         briefly = liberal / 2.0F;
      }

      _optional((float)(invalid + briefly), (float)(forming + briefly), sender - briefly * 2.0F, liberal - briefly * 2.0F, (int)miles);
      _optional((float)(invalid + briefly), (float)forming, sender - briefly * 2.0F, (float)briefly, (int)miles);
      _optional((float)(invalid + briefly), (float)(forming + liberal - briefly), sender - briefly * 2.0F, (float)briefly, (int)miles);
      _optional((float)invalid, (float)(forming + briefly), (float)briefly, liberal - briefly * 2.0F, (int)miles);
      _optional((float)(invalid + sender - briefly), (float)(forming + briefly), (float)briefly, liberal - briefly * 2.0F, (int)miles);
      _trying();
      _solely((int)miles);
      GL11.glBegin(6);
      Object churches = (float)(invalid + briefly);
      Object beats = (float)(forming + briefly);
      GL11.glVertex2d((double)churches, (double)beats);
      Object concert = (int)Math.min(Math.max((float)briefly, 10.0F), 90.0F);

      for(Object fiber = 0; fiber < concert + 1; ++fiber) {
         Object before = 6.283185307179586D * (double)(fiber + 180) / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(before) * (double)briefly, (double)beats + Math.cos(before) * (double)briefly);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      churches = (float)(invalid + sender - briefly);
      beats = (float)(forming + briefly);
      GL11.glVertex2d((double)churches, (double)beats);
      concert = (int)Math.min(Math.max((float)briefly, 10.0F), 90.0F);

      for(Object var32 = 0; var32 < concert + 1; ++var32) {
         Object var39 = 6.283185307179586D * (double)(var32 + 90) / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(var39) * (double)briefly, (double)beats + Math.cos(var39) * (double)briefly);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      churches = (float)(invalid + briefly);
      beats = (float)(forming + liberal - briefly);
      GL11.glVertex2d((double)churches, (double)beats);
      concert = (int)Math.min(Math.max((float)briefly, 10.0F), 90.0F);

      for(Object var33 = 0; var33 < concert + 1; ++var33) {
         Object var40 = 6.283185307179586D * (double)(var33 + 270) / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(var40) * (double)briefly, (double)beats + Math.cos(var40) * (double)briefly);
      }

      GL11.glEnd();
      GL11.glBegin(6);
      churches = (float)(invalid + sender - briefly);
      beats = (float)(forming + liberal - briefly);
      GL11.glVertex2d((double)churches, (double)beats);
      concert = (int)Math.min(Math.max((float)briefly, 10.0F), 90.0F);

      for(Object var34 = 0; var34 < concert + 1; ++var34) {
         Object var41 = 6.283185307179586D * (double)var34 / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(var41) * (double)briefly, (double)beats + Math.cos(var41) * (double)briefly);
      }

      GL11.glEnd();
      _solely((int)michelle);
      GL11.glLineWidth((float)infected);
      GL11.glBegin(3);
      churches = (float)(invalid + briefly);
      beats = (float)(forming + briefly);
      concert = (int)Math.min(Math.max((float)briefly, 10.0F), 90.0F);

      for(Object var35 = concert; var35 >= 0; --var35) {
         Object var42 = 6.283185307179586D * (double)(var35 + 180) / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(var42) * (double)briefly, (double)beats + Math.cos(var42) * (double)briefly);
      }

      GL11.glVertex2d((double)(invalid + briefly), (double)forming);
      GL11.glVertex2d((double)(invalid + sender - briefly), (double)forming);
      churches = (float)(invalid + sender - briefly);
      beats = (float)(forming + briefly);

      for(Object var36 = concert; var36 >= 0; --var36) {
         Object var43 = 6.283185307179586D * (double)(var36 + 90) / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(var43) * (double)briefly, (double)beats + Math.cos(var43) * (double)briefly);
      }

      GL11.glVertex2d((double)(invalid + sender), (double)(forming + briefly));
      GL11.glVertex2d((double)(invalid + sender), (double)(forming + liberal - briefly));
      churches = (float)(invalid + sender - briefly);
      beats = (float)(forming + liberal - briefly);

      for(Object var37 = concert; var37 >= 0; --var37) {
         Object var44 = 6.283185307179586D * (double)var37 / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(var44) * (double)briefly, (double)beats + Math.cos(var44) * (double)briefly);
      }

      GL11.glVertex2d((double)(invalid + sender - briefly), (double)(forming + liberal));
      GL11.glVertex2d((double)(invalid + briefly), (double)(forming + liberal));
      churches = (float)(invalid + briefly);
      beats = (float)(forming + liberal - briefly);

      for(Object var38 = concert; var38 >= 0; --var38) {
         Object var45 = 6.283185307179586D * (double)(var38 + 270) / (double)(concert * 4);
         GL11.glVertex2d((double)churches + Math.sin(var45) * (double)briefly, (double)beats + Math.cos(var45) * (double)briefly);
      }

      GL11.glVertex2d((double)invalid, (double)(forming + liberal - briefly));
      GL11.glVertex2d((double)invalid, (double)(forming + briefly));
      GL11.glEnd();
      _talking();
   }

   public static void _trying() {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
   }

   public static void _talking() {
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   public static int _tragedy(int render, float pledge) {
      Object powers = new Color((int)render);
      Object menus = 0.003921569F * (float)powers.getRed();
      Object gasoline = 0.003921569F * (float)powers.getGreen();
      Object shame = 0.003921569F * (float)powers.getBlue();
      return (new Color(menus, gasoline, shame, (float)pledge)).getRGB();
   }

   public static void _outlets(Runnable belkin) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      ((Runnable)belkin).run();
      GL11.glEnable(3553);
      GlStateManager.disableBlend();
   }

   public static void _backing(int mumasava, Runnable iyetonoy) {
      GL11.glBegin((int)mumasava);
      ((Runnable)iyetonoy).run();
      GL11.glEnd();
   }

   public static void _exhibit(float racial, float leader, float brush, Animation dairy, int strike) {
      GL11.glTranslatef((float)racial, (float)leader, Float.intBitsToFloat(0));
      _outlets(RenderUtil4::_instance);
      GL11.glTranslatef((float)(-racial), (float)(-leader), Float.intBitsToFloat(0));
   }

   public static Double _nascar(double omifofob, double ozurobum, double var4) {
      return omifofob + (ozurobum - omifofob) * var4;
   }

   public static void _casey() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static double _promised(double columns, double hosted, double santa) {
      boolean var6 = columns > hosted;
      if (santa < Double.longBitsToDouble(0L)) {
         santa = Double.longBitsToDouble(0L);
      } else if (santa > 1.0D) {
         santa = 1.0D;
      }

      double var7 = Math.max((double)columns, (double)hosted) - Math.min((double)columns, (double)hosted);
      double var9 = var7 * santa;
      return hosted + (var6 ? var9 : -var9);
   }

   public static void _polar(float jenny, float grain, double boxing, int damages, int guilty, double frontier, int policies) {
      boxing = boxing * 2.0D;
      jenny = jenny * 2.0F;
      grain = grain * 2.0F;
      Object plate = (float)(damages >> 24 & 255) / 255.0F;
      Object harley = (float)(damages >> 16 & 255) / 255.0F;
      Object gotten = (float)(damages >> 8 & 255) / 255.0F;
      float var12 = (float)(damages & 255) / 255.0F;
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glLineWidth((float)policies);
      GL11.glEnable(2848);
      GL11.glColor4f(harley, gotten, var12, plate);
      GL11.glBegin(3);

      for(int var13 = (int)guilty; (double)var13 <= frontier; ++var13) {
         GL11.glVertex2d((double)jenny + Math.sin((double)var13 * 3.141592653589793D / 180.0D) * boxing, (double)grain + Math.cos((double)var13 * 3.141592653589793D / 180.0D) * boxing);
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

   public static void _angela(Entity length, Color infinite) {
      Object lawyer = ((Entity)length).lastTickPosX + (((Entity)length).posX - ((Entity)length).lastTickPosX) * (double)explain$.timer.renderPartialTicks - explain$.getRenderManager().renderPosX;
      Object faculty = ((Entity)length).lastTickPosY + (((Entity)length).posY - ((Entity)length).lastTickPosY) * (double)explain$.timer.renderPartialTicks - explain$.getRenderManager().renderPosY;
      double var6 = ((Entity)length).lastTickPosZ + (((Entity)length).posZ - ((Entity)length).lastTickPosZ) * (double)explain$.timer.renderPartialTicks - explain$.getRenderManager().renderPosZ;
      net.minecraft.util.Vec3 var8 = (new net.minecraft.util.Vec3(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 1.0D)).rotatePitch((float)(-Math.toRadians((double)explain$.thePlayer.rotationPitch))).rotateYaw((float)(-Math.toRadians((double)explain$.thePlayer.rotationYaw)));
      _without((Color)infinite);
      GL11.glVertex3d(var8.xCoord, (double)explain$.thePlayer.eyeHeight + var8.yCoord, var8.zCoord);
      GL11.glVertex3d(lawyer, faculty, var6);
      GL11.glVertex3d(lawyer, faculty, var6);
      GL11.glVertex3d(lawyer, faculty + (double)((Entity)length).height, var6);
   }

   public static void _occurs(float yiciyobe, float cinobose, float deferumi, int cubunosa) {
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GL11.glEnable(2881);
      GlStateManager.enableBlend();
      GL11.glBegin(9);
      ColorUtil._candles((int)cubunosa);

      for(Object oyayucad = 0; oyayucad <= 360; ++oyayucad) {
         GL11.glVertex2d((double)yiciyobe + Math.sin((double)oyayucad * 3.141592653589793D / 180.0D) * (double)deferumi, (double)cinobose + Math.cos((double)oyayucad * 3.141592653589793D / 180.0D) * (double)deferumi);
      }

      GlStateManager.resetColor();
      GL11.glEnd();
      GL11.glDisable(2881);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
      GlStateManager.popMatrix();
   }

   public static void _develops(double archived, double friends, double zimbabwe, double broad, double insulin, float mambo, float parallel, float missouri, float doctors, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)mambo, (float)parallel, (float)missouri, (float)doctors);
      _broke(new AxisAlignedBB((double)(archived - broad), (double)friends, (double)(zimbabwe - broad), (double)(archived + broad), (double)(friends + insulin), (double)(zimbabwe + broad)));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      _buffer(new AxisAlignedBB((double)(archived - broad), (double)friends, (double)(zimbabwe - broad), (double)(archived + broad), (double)(friends + insulin), (double)(zimbabwe + broad)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _broke(AxisAlignedBB uzeyanas) {
      Object ebozabup = Tessellator.getInstance();
      Object ufuvadup = ebozabup.getWorldRenderer();
      ufuvadup.begin(7, DefaultVertexFormats.POSITION);
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ebozabup.draw();
      ufuvadup.begin(7, DefaultVertexFormats.POSITION);
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ebozabup.draw();
      ufuvadup.begin(7, DefaultVertexFormats.POSITION);
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ebozabup.draw();
      ufuvadup.begin(7, DefaultVertexFormats.POSITION);
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ebozabup.draw();
      ufuvadup.begin(7, DefaultVertexFormats.POSITION);
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ebozabup.draw();
      ufuvadup.begin(7, DefaultVertexFormats.POSITION);
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).minX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).minZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).maxY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ufuvadup.pos(((AxisAlignedBB)uzeyanas).maxX, ((AxisAlignedBB)uzeyanas).minY, ((AxisAlignedBB)uzeyanas).maxZ).endVertex();
      ebozabup.draw();
   }

   public static void _stable(double receipt, double acquired, double assigned, double findlaw, double var8, int var10, int var11) {
      _oakland(receipt + var8, acquired + var8, assigned - var8, findlaw - var8, var10);
      _oakland(receipt + var8, (double)acquired, assigned - var8, acquired + var8, var11);
      _oakland((double)receipt, (double)acquired, receipt + var8, (double)findlaw, var11);
      _oakland(assigned - var8, (double)acquired, (double)assigned, (double)findlaw, var11);
      _oakland(receipt + var8, findlaw - var8, assigned - var8, (double)findlaw, var11);
   }

   public static void _clouds(int uzozunal) {
      Object gucuyoyo = (float)(uzozunal >> 24 & 255) / 255.0F;
      Object epuyovip = (float)(uzozunal >> 16 & 255) / 255.0F;
      Object tomenoda = (float)(uzozunal >> 8 & 255) / 255.0F;
      Object gucopeyu = (float)(uzozunal & 255) / 255.0F;
      GL11.glColor4f(epuyovip, tomenoda, gucopeyu, gucuyoyo == Float.intBitsToFloat(0) ? 1.0F : gucuyoyo);
   }

   public static void _without(Color esayayom) {
      Object tupuyifu = (float)(((Color)esayayom).getRGB() >> 24 & 255) / 255.0F;
      Object riviyuzo = (float)(((Color)esayayom).getRGB() >> 16 & 255) / 255.0F;
      Object yizobuso = (float)(((Color)esayayom).getRGB() >> 8 & 255) / 255.0F;
      Object ebafarub = (float)(((Color)esayayom).getRGB() & 255) / 255.0F;
      GL11.glColor4f(riviyuzo, yizobuso, ebafarub, tupuyifu == Float.intBitsToFloat(0) ? 1.0F : tupuyifu);
   }

   public static void _forms(int glucose, boolean cultural) {
      comply$.put(Integer.valueOf((int)glucose), Boolean.valueOf(GL11.glGetBoolean((int)glucose)));
      if (cultural) {
         GL11.glEnable((int)glucose);
      } else {
         GL11.glDisable((int)glucose);
      }

   }

   public static void _fewer(int etomopez) {
      Object norocuza = (Boolean)comply$.get(Integer.valueOf((int)etomopez));
      if (norocuza != null) {
         if (norocuza.booleanValue()) {
            GL11.glEnable((int)etomopez);
         } else {
            GL11.glDisable((int)etomopez);
         }
      }

   }

   public static void _little() {
      for(Object zutenema : comply$.keySet()) {
         _fewer(zutenema.intValue());
      }

   }

   public static void _candle(float catholic) {
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
      GL11.glLineWidth((float)catholic);
   }

   public static void _cemetery() {
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

   public static void _avatar(float firmware, float priest, float illegal, float membrane, float disclose, int token, int articles) {
      _oakland((double)firmware, (double)priest, (double)illegal, (double)membrane, (int)articles);
      Object shuttle = (float)(token >> 24 & 255) / 255.0F;
      Object measure = (float)(token >> 16 & 255) / 255.0F;
      Object civilian = (float)(token >> 8 & 255) / 255.0F;
      Object beginner = (float)(token & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(measure, civilian, beginner, shuttle);
      GL11.glLineWidth((float)disclose);
      GL11.glBegin(1);
      GL11.glVertex2d((double)firmware, (double)priest);
      GL11.glVertex2d((double)firmware, (double)membrane);
      GL11.glVertex2d((double)illegal, (double)membrane);
      GL11.glVertex2d((double)illegal, (double)priest);
      GL11.glVertex2d((double)firmware, (double)priest);
      GL11.glVertex2d((double)illegal, (double)priest);
      GL11.glVertex2d((double)firmware, (double)membrane);
      GL11.glVertex2d((double)illegal, (double)membrane);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static int _speaks(int deluxe) {
      Object normal = deluxe >> 16 & 255;
      Object payments = deluxe >> 8 & 255;
      Object dreams = deluxe & 255;
      Object changed = 255;
      return (normal & 255) << 16 | (payments & 255) << 8 | dreams & 255 | (changed & 255) << 24;
   }

   public static int _advice(int frequent, float acrobat) {
      Object stuck = (int)((float)(frequent >> 16 & 255) * acrobat);
      Object readings = (int)((float)(frequent >> 8 & 255) * acrobat);
      Object hayes = (int)((float)(frequent & 255) * acrobat);
      Object india = frequent >> 24 & 255;
      return (stuck & 255) << 16 | (readings & 255) << 8 | hayes & 255 | (india & 255) << 24;
   }

   public static void _admit(double pugofebo, double ucocilin, double olobapos, double var6) {
      int var8;
      for(var8 = (new ScaledResolution(Minecraft.getMinecraft())).getScaleFactor(); var8 < 2 && Minecraft.getMinecraft().displayWidth / (var8 + 1) >= 320 && Minecraft.getMinecraft().displayHeight / (var8 + 1) >= 240; ++var8) {
         ;
      }

      GL11.glScissor((int)(pugofebo * (double)var8), (int)((double)Minecraft.getMinecraft().displayHeight - (ucocilin + var6) * (double)var8), (int)(olobapos * (double)var8), (int)(var6 * (double)var8));
   }

   public static void _helped(String edofegez, float lupaduro, float inomanuc, int asopalep) {
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      explain$.fontRendererObj.drawString((String)edofegez, (int)(lupaduro * 2.0F - 1.0F), (int)(inomanuc * 2.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)edofegez, (int)(lupaduro * 2.0F + 1.0F), (int)(inomanuc * 2.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)edofegez, (int)(lupaduro * 2.0F), (int)(inomanuc * 2.0F - 1.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)edofegez, (int)(lupaduro * 2.0F), (int)(inomanuc * 2.0F + 1.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)edofegez, (int)(lupaduro * 2.0F), (int)(inomanuc * 2.0F), (int)asopalep);
      GL11.glPopMatrix();
   }

   public static void _endless(String uvepavuv, float unosefir, float aganipim, int yiyupise) {
      GL11.glPushMatrix();
      explain$.fontRendererObj.drawString((String)uvepavuv, (int)(unosefir * 2.0F - 1.0F), (int)(aganipim * 2.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)uvepavuv, (int)(unosefir * 2.0F + 1.0F), (int)(aganipim * 2.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)uvepavuv, (int)(unosefir * 2.0F), (int)(aganipim * 2.0F - 1.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)uvepavuv, (int)(unosefir * 2.0F), (int)(aganipim * 2.0F + 1.0F), Color.BLACK.getRGB());
      explain$.fontRendererObj.drawString((String)uvepavuv, (int)(unosefir * 2.0F), (int)(aganipim * 2.0F), (int)yiyupise);
      GL11.glPopMatrix();
   }

   public static void _bureau(double suboyisi, double fibegimu, int var4, int var5) {
      _surface();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)var4);
      _stadium(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d((double)suboyisi, (double)fibegimu);
      GL11.glVertex2d(suboyisi + 2.0D, fibegimu + 2.0D);
      GL11.glVertex2d(suboyisi + 5.0D, fibegimu - 2.0D);
      GL11.glEnd();
      GL11.glPopMatrix();
      _picked();
   }

   public static boolean _jersey(float adidudib, float ayoyuvev, float utucofor, float ogafotuv, int onibatib, int uziletan) {
      return (float)onibatib >= adidudib && (float)uziletan >= ayoyuvev && (float)onibatib < adidudib + utucofor && (float)uziletan < ayoyuvev + ogafotuv;
   }

   public static void _bracelet(double ozebotib, double eyutemag, int cocufiru, int var5, double var6) {
      _surface();
      GL11.glPushMatrix();
      GL11.glLineWidth((float)cocufiru);
      _stadium(new Color(var5));
      GL11.glBegin(3);
      GL11.glVertex2d((double)ozebotib, (double)eyutemag);
      GL11.glVertex2d(ozebotib + 3.0D, eyutemag + var6);
      GL11.glVertex2d(ozebotib + 6.0D, (double)eyutemag);
      GL11.glEnd();
      GL11.glPopMatrix();
      _picked();
   }

   public static void _stadium(Color ilasemuy) {
      Object unepopod = (float)(((Color)ilasemuy).getRGB() >> 24 & 255) / 255.0F;
      Object yerorola = (float)(((Color)ilasemuy).getRGB() >> 16 & 255) / 255.0F;
      Object asutefes = (float)(((Color)ilasemuy).getRGB() >> 8 & 255) / 255.0F;
      Object feribeyu = (float)(((Color)ilasemuy).getRGB() & 255) / 255.0F;
      GL11.glColor4f(yerorola, asutefes, feribeyu, unepopod);
   }

   public static void _surface() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void _picked() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _ultimate(BlockPos miyonati, int ericacut) {
      Object tifinazo = (double)((BlockPos)miyonati).getX() - explain$.getRenderManager().renderPosX;
      Object ozuyocan = (double)((BlockPos)miyonati).getY() - explain$.getRenderManager().renderPosY;
      Object ibicasid = (double)((BlockPos)miyonati).getZ() - explain$.getRenderManager().renderPosZ;
      Object ubinaval = explain$.theWorld.getBlockState((BlockPos)miyonati).getBlock().getBlockBoundsMaxY() - explain$.theWorld.getBlockState((BlockPos)miyonati).getBlock().getBlockBoundsMinY();
      float var10 = (float)(ericacut >> 16 & 255) / 255.0F;
      float var11 = (float)(ericacut >> 8 & 255) / 255.0F;
      float var12 = (float)(ericacut & 255) / 255.0F;
      float var13 = (float)(ericacut >> 24 & 255) / 255.0F;
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
      _buffer(new AxisAlignedBB(tifinazo, ozuyocan, ibicasid, tifinazo + 1.0D, ozuyocan + ubinaval, ibicasid + 1.0D));
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

   public static void _element(BlockPos gnome, int senators) {
      Object belongs = Minecraft.getMinecraft();
      Object delete = (double)((BlockPos)gnome).getX() - belongs.getRenderManager().renderPosX + 0.5D;
      Object football = (double)((BlockPos)gnome).getY() - belongs.getRenderManager().renderPosY + 0.5D;
      Object denmark = (double)((BlockPos)gnome).getZ() - belongs.getRenderManager().renderPosZ + 0.5D;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
      Object accurate = (float)(senators >> 16 & 255) / 255.0F;
      Object linking = (float)(senators >> 8 & 255) / 255.0F;
      float var11 = (float)(senators & 255) / 255.0F;
      float var12 = (float)(senators >> 24 & 255) / 255.0F;
      GL11.glColor4f(accurate, linking, var11, var12);
      GL11.glLoadIdentity();
      boolean var13 = belongs.gameSettings.viewBobbing;
      belongs.gameSettings.viewBobbing = false;
      ((IEntityRenderer)belongs.entityRenderer).runorientCamera(belongs.timer.renderPartialTicks);
      GL11.glBegin(3);
      GL11.glVertex3d(Double.longBitsToDouble(0L), (double)belongs.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L));
      GL11.glVertex3d(delete, football, denmark);
      GL11.glVertex3d(delete, football, denmark);
      GL11.glEnd();
      belongs.gameSettings.viewBobbing = var13;
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _buffer(AxisAlignedBB wizard) {
      Object marked = Tessellator.getInstance();
      Object injured = marked.getWorldRenderer();
      injured.begin(3, DefaultVertexFormats.POSITION);
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).minZ).endVertex();
      marked.draw();
      injured.begin(3, DefaultVertexFormats.POSITION);
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).minZ).endVertex();
      marked.draw();
      injured.begin(1, DefaultVertexFormats.POSITION);
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).minZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).maxX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).minY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      injured.pos(((AxisAlignedBB)wizard).minX, ((AxisAlignedBB)wizard).maxY, ((AxisAlignedBB)wizard).maxZ).endVertex();
      marked.draw();
   }

   public static void _fraud(int esoyonar, float egedafol) {
      Object efenefum = (float)(esoyonar >> 16 & 255) / 255.0F;
      Object iyavolup = (float)(esoyonar >> 8 & 255) / 255.0F;
      Object pusecila = (float)(esoyonar & 255) / 255.0F;
      GlStateManager.color(efenefum, iyavolup, pusecila, (float)egedafol);
   }

   public static void _solely(int netepute) {
      _fraud((int)netepute, (float)(netepute >> 24 & 255) / 255.0F);
   }

   public static void _casio(float starting, float robust, float energy, float carlos, int tubes, int joseph) {
      Object engines = (float)(tubes >> 24 & 255) / 255.0F;
      Object swimming = (float)(tubes >> 16 & 255) / 255.0F;
      Object thought = (float)(tubes >> 8 & 255) / 255.0F;
      Object anchor = (float)(tubes & 255) / 255.0F;
      Object corners = (float)(joseph >> 24 & 255) / 255.0F;
      Object standing = (float)(joseph >> 16 & 255) / 255.0F;
      Object manage = (float)(joseph >> 8 & 255) / 255.0F;
      Object favorite = (float)(joseph & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Object journals = Tessellator.getInstance();
      Object point = journals.getWorldRenderer();
      point.begin(7, DefaultVertexFormats.POSITION_COLOR);
      point.pos((double)energy, (double)robust, Double.longBitsToDouble(0L)).color(swimming, thought, anchor, engines).endVertex();
      point.pos((double)starting, (double)robust, Double.longBitsToDouble(0L)).color(swimming, thought, anchor, engines).endVertex();
      point.pos((double)starting, (double)carlos, Double.longBitsToDouble(0L)).color(standing, manage, favorite, corners).endVertex();
      point.pos((double)energy, (double)carlos, Double.longBitsToDouble(0L)).color(standing, manage, favorite, corners).endVertex();
      journals.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void _lingerie(double sonuzivo, double bicezafa, double sapazago, double ocozupor, boolean var8, int var9, int var10) {
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      GL11.glBegin(7);
      _solely(var9);
      if (var8) {
         GL11.glVertex2d((double)sonuzivo, (double)bicezafa);
         GL11.glVertex2d((double)sonuzivo, (double)ocozupor);
         _solely(var10);
         GL11.glVertex2d((double)sapazago, (double)ocozupor);
         GL11.glVertex2d((double)sapazago, (double)bicezafa);
      } else {
         GL11.glVertex2d((double)sonuzivo, (double)bicezafa);
         _solely(var10);
         GL11.glVertex2d((double)sonuzivo, (double)ocozupor);
         GL11.glVertex2d((double)sapazago, (double)ocozupor);
         _solely(var9);
         GL11.glVertex2d((double)sapazago, (double)bicezafa);
      }

      GL11.glEnd();
      GL11.glDisable(3042);
      GL11.glShadeModel(7424);
      GL11.glEnable(3553);
   }

   public static void _indie(float opabisus, float odiyanup, float coyusogu, float yipuroso) {
      _oakland((double)opabisus, (double)odiyanup, (double)coyusogu, (double)yipuroso, ColorUtil._contract(16777215));

      while(odiyanup < yipuroso) {
         for(Object vacagisi = opabisus + Float.intBitsToFloat(0); vacagisi < coyusogu; vacagisi += 2.0F) {
            if (vacagisi <= coyusogu - 1.0F) {
               _oakland((double)vacagisi, (double)odiyanup, (double)(vacagisi + 1.0F), (double)(odiyanup + 1.0F), ColorUtil._contract(8421504));
            }
         }

         ++odiyanup;
      }

   }

   public static void _coast(int knight, int select, float funds, float necklace, int parts, int hilton, int virtue, int rather, float robot, float going) {
      Object hence = 1.0F / robot;
      Object constant = 1.0F / going;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Object chair = Tessellator.getInstance();
      Object reserve = chair.getWorldRenderer();
      reserve.begin(7, DefaultVertexFormats.POSITION_TEX);
      reserve.pos((double)knight, (double)(select + rather), Double.longBitsToDouble(0L)).tex((double)(funds * hence), (double)((necklace + (float)hilton) * constant)).endVertex();
      reserve.pos((double)(knight + virtue), (double)(select + rather), Double.longBitsToDouble(0L)).tex((double)((funds + (float)parts) * hence), (double)((necklace + (float)hilton) * constant)).endVertex();
      reserve.pos((double)(knight + virtue), (double)select, Double.longBitsToDouble(0L)).tex((double)((funds + (float)parts) * hence), (double)(necklace * constant)).endVertex();
      reserve.pos((double)knight, (double)select, Double.longBitsToDouble(0L)).tex((double)(funds * hence), (double)(necklace * constant)).endVertex();
      chair.draw();
   }

   public static void _respond(ResourceLocation closure, int royal, int detroit, int finished, int howto) {
      explain$.getTextureManager().bindTexture((ResourceLocation)closure);
      _coast((int)royal, (int)detroit, 8.0F, 8.0F, 8, 8, (int)finished, (int)howto, 64.0F, 64.0F);
      _coast((int)royal, (int)detroit, 40.0F, 8.0F, 8, 8, (int)finished, (int)howto, 64.0F, 64.0F);
   }

   public static void _oakland(double ofezolec, double ulataveg, double fisocora, double rafuvobo, int ecuvinib) {
      if (ofezolec < fisocora) {
         Object efasipey = (double)ofezolec;
         ofezolec = fisocora;
         fisocora = efasipey;
      }

      if (ulataveg < rafuvobo) {
         Object var15 = (double)ulataveg;
         ulataveg = rafuvobo;
         rafuvobo = var15;
      }

      Object var16 = (float)(ecuvinib >> 24 & 255) / 255.0F;
      Object copitezo = (float)(ecuvinib >> 16 & 255) / 255.0F;
      float var11 = (float)(ecuvinib >> 8 & 255) / 255.0F;
      float var12 = (float)(ecuvinib & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(copitezo, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)ofezolec, (double)rafuvobo, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)fisocora, (double)rafuvobo, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)fisocora, (double)ulataveg, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)ofezolec, (double)ulataveg, Double.longBitsToDouble(0L)).endVertex();
      var13.draw();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _block(double ended, double include, double feelings, double dream, Color harder) {
      if (ended < feelings) {
         Object deutsche = (double)ended;
         ended = feelings;
         feelings = deutsche;
      }

      if (include < dream) {
         Object var15 = (double)include;
         include = dream;
         dream = var15;
      }

      Object var16 = (float)(((Color)harder).getRGB() >> 24 & 255) / 255.0F;
      Object prison = (float)(((Color)harder).getRGB() >> 16 & 255) / 255.0F;
      float var11 = (float)(((Color)harder).getRGB() >> 8 & 255) / 255.0F;
      float var12 = (float)(((Color)harder).getRGB() & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(prison, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)ended, (double)dream, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)feelings, (double)dream, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)feelings, (double)include, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)ended, (double)include, Double.longBitsToDouble(0L)).endVertex();
      var13.draw();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _royalty(float muvufesu, float mudoneve, float adelicit, float yociyuna, float danusena, float riradufi, float gubiyupu, ResourceLocation igitosil) {
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)igitosil);
      Object rorosuru = 1.0F / adelicit;
      Object zozomasu = 1.0F / yociyuna;
      GL11.glColor4f((float)danusena, (float)riradufi, (float)gubiyupu, 1.0F);
      Object sirezepo = Tessellator.getInstance();
      Object lafinuco = sirezepo.getWorldRenderer();
      lafinuco.begin(7, DefaultVertexFormats.POSITION_TEX);
      lafinuco.pos((double)muvufesu, (double)(mudoneve + yociyuna), Double.longBitsToDouble(0L)).tex(Double.longBitsToDouble(0L), (double)(yociyuna * zozomasu)).endVertex();
      lafinuco.pos((double)(muvufesu + adelicit), (double)(mudoneve + yociyuna), Double.longBitsToDouble(0L)).tex((double)(adelicit * rorosuru), (double)(yociyuna * zozomasu)).endVertex();
      lafinuco.pos((double)(muvufesu + adelicit), (double)mudoneve, Double.longBitsToDouble(0L)).tex((double)(adelicit * rorosuru), Double.longBitsToDouble(0L)).endVertex();
      lafinuco.pos((double)muvufesu, (double)mudoneve, Double.longBitsToDouble(0L)).tex(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)).endVertex();
      sirezepo.draw();
   }

   public static void _cited(ResourceLocation colapipu, float nacaruyo, float alatenil, int ficagoco, int samudina) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)colapipu);
      Object izulolef = 1.0F / (float)ficagoco;
      Object avicocaz = 1.0F / (float)samudina;
      Object inacecuc = Tessellator.getInstance();
      Object tonofene = inacecuc.getWorldRenderer();
      tonofene.begin(7, DefaultVertexFormats.POSITION_TEX);
      tonofene.pos((double)nacaruyo, (double)(alatenil + (float)samudina), Double.longBitsToDouble(0L)).tex((double)(Float.intBitsToFloat(0) * izulolef), (double)((float)samudina * avicocaz)).endVertex();
      tonofene.pos((double)(nacaruyo + (float)ficagoco), (double)(alatenil + (float)samudina), Double.longBitsToDouble(0L)).tex((double)((float)ficagoco * izulolef), (double)((float)samudina * avicocaz)).endVertex();
      tonofene.pos((double)(nacaruyo + (float)ficagoco), (double)alatenil, Double.longBitsToDouble(0L)).tex((double)((float)ficagoco * izulolef), (double)(Float.intBitsToFloat(0) * avicocaz)).endVertex();
      tonofene.pos((double)nacaruyo, (double)alatenil, Double.longBitsToDouble(0L)).tex((double)(Float.intBitsToFloat(0) * izulolef), (double)(Float.intBitsToFloat(0) * avicocaz)).endVertex();
      inacecuc.draw();
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _instance(int faces, float promotes, Animation jelsoft) {
      _backing(5, RenderUtil4::_advocacy);
   }

   public static void _advocacy(int amodedul, float vololosi, Animation umemoyad) {
      _solely((int)amodedul);
      Object zocesofu = _nascar(Double.longBitsToDouble(0L), (double)vololosi / 2.0D, ((Animation)umemoyad)._bloggers()).doubleValue();
      if (((Animation)umemoyad)._bloggers() >= 0.48D) {
         GL11.glVertex2d((double)(vololosi / 2.0F), _nascar((double)vololosi / 2.0D, Double.longBitsToDouble(0L), ((Animation)umemoyad)._bloggers()).doubleValue());
      }

      GL11.glVertex2d(Double.longBitsToDouble(0L), zocesofu);
      if (((Animation)umemoyad)._bloggers() < 0.48D) {
         GL11.glVertex2d((double)(vololosi / 2.0F), _nascar((double)vololosi / 2.0D, Double.longBitsToDouble(0L), ((Animation)umemoyad)._bloggers()).doubleValue());
      }

      GL11.glVertex2d((double)vololosi, zocesofu);
   }
}
