//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import com.mojang.authlib.GameProfile;
import ft.sleep.Client;
import ft.sleep.api.events.world.EventPreUpdate;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import ft.sleep.module.ModuleManager;
import ft.sleep.util.angle.Vec2f;
import ft.sleep.util.angle.Vec3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import tessellate.Tessellation;

public class RenderUtil2 {
   public static Tessellation window$ = Tessellation.createExpanding(4, 1.0F, 2.0F);
   public static List theaters$ = new ArrayList();
   public static Consumer lucia$ = GL11::glEnableClientState;
   public static Consumer positive$ = GL11::glEnableClientState;
   public static Frustum looked$ = new Frustum();
   public static float helen$;
   public static Minecraft myself$ = Minecraft.getMinecraft();

   public static Color _adjust(long toner, float courts, float linda) {
      Object mistress = (float)(System.nanoTime() + toner) / 1.0E1F % 1.0F;
      Object chairman = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(mistress, (float)courts, 1.0F).intValue()), 16);
      Color var7 = new Color((int)chairman);
      return new Color((float)var7.getRed() / 255.0F * linda, (float)var7.getGreen() / 255.0F * linda, (float)var7.getBlue() / 255.0F * linda, (float)var7.getAlpha() / 255.0F);
   }

   public static void _hundreds(int olufamos) {
      Object efugusay = (float)(olufamos >> 24 & 255) / 255.0F;
      Object elayafod = (float)(olufamos >> 16 & 255) / 255.0F;
      Object yipanifi = (float)(olufamos >> 8 & 255) / 255.0F;
      Object usuvuzey = (float)(olufamos & 255) / 255.0F;
      GL11.glColor4f(elayafod, yipanifi, usuvuzey, efugusay);
   }

   public static void _softball(float trustees, int jerry, int genes, int alloy) {
      Object though = 0.003921569F * (float)jerry;
      Object handbags = 0.003921569F * (float)genes;
      Object richmond = 0.003921569F * (float)alloy;
      GL11.glColor4f(though, handbags, richmond, (float)trustees);
   }

   public static int _michael(int obilezup) {
      return -16777216 | obilezup;
   }

   public static void _ahead() {
      Object courage = Minecraft.getMinecraft().getFramebuffer();
      if (courage != null) {
         if (courage.depthBuffer > -1) {
            EXTFramebufferObject.glDeleteRenderbuffersEXT(courage.depthBuffer);
            Object omaha = EXTFramebufferObject.glGenRenderbuffersEXT();
            EXTFramebufferObject.glBindRenderbufferEXT(36161, omaha);
            EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
            EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, omaha);
            EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, omaha);
            courage.depthBuffer = -1;
         }
      }
   }

   public static void _command() {
      GL11.glPushAttrib(1048575);
      GL11.glDisable(3008);
      GL11.glDisable(3553);
      GL11.glDisable(2896);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(2.0F);
      GL11.glEnable(2848);
      GL11.glEnable(2960);
      GL11.glClear(1024);
      GL11.glClearStencil(15);
      GL11.glStencilFunc(512, 1, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void _opposite() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public static void _context() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void _spouse() {
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(10754);
      GL11.glPolygonOffset(1.0F, -2000000.0F);
      GL11.glColor4f(0.9529412F, 0.6117647F, 0.07058824F, 1.0F);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
   }

   public static void _terminal() {
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

   public static void _displays(int stone, int feeding, int trigger, int elected, int fires, ResourceLocation william) {
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)william);
      GL11.glColor4f(255.0F, 255.0F, 255.0F, 255.0F);
      if (fires <= 0) {
         Gui.drawModalRectWithCustomSizedTexture((int)stone, (int)feeding, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)trigger, (int)elected, (float)trigger, (float)elected);
      } else {
         GlStateManager.pushMatrix();
         Object sonic = stone + 5;
         Object jewel = -10;
         GlStateManager.translate((float)sonic, (float)(jewel + feeding) + 15.0F, Float.intBitsToFloat(0));
         GlStateManager.rotate((float)fires, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
         GlStateManager.translate((float)(-sonic), -((float)(jewel + feeding) + 15.0F), Float.intBitsToFloat(0));
         Gui.drawModalRectWithCustomSizedTexture((int)stone, (int)feeding, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 10, 10, 10.0F, 10.0F);
         GlStateManager.popMatrix();
      }

   }

   public static void _triple(int louise, int actual, int mercury, int train, ResourceLocation texture) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)texture);
      Gui.drawModalRectWithCustomSizedTexture((int)louise, (int)actual, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)mercury, (int)train, (float)mercury, (float)train);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _ambient(Vec2f packed, Vec2f loving, Vec2f windsor, float leasing, int storage, boolean israeli) {
      Object disposal = (float)(storage >> 24 & 255) / 255.0F;
      Object remains = (float)(storage >> 16 & 255) / 255.0F;
      Object sought = (float)(storage >> 8 & 255) / 255.0F;
      Object kissing = (float)(storage & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(remains, sought, kissing, disposal);
      GL11.glLineWidth((float)leasing);
      GL11.glBegin(israeli ? 4 : 1);
      GL11.glVertex2f(((Vec2f)packed)._until(), ((Vec2f)packed)._trends());
      GL11.glVertex2f(((Vec2f)loving)._until(), ((Vec2f)loving)._trends());
      GL11.glVertex2f(((Vec2f)windsor)._until(), ((Vec2f)windsor)._trends());
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _pressure(float denazeco, float iyubipat, float birevufe, float azudovin, float ibifizic, int ruyeyipi) {
      Object zaverepu = (float)(ruyeyipi >> 24 & 255) / 255.0F;
      Object sinovaye = (float)(ruyeyipi >> 16 & 255) / 255.0F;
      Object isipuzit = (float)(ruyeyipi >> 8 & 255) / 255.0F;
      Object adoluyap = (float)(ruyeyipi & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(sinovaye, isipuzit, adoluyap, zaverepu);
      GL11.glPointSize((float)ibifizic);
      GL11.glBegin(0);
      GL11.glVertex2f((float)(denazeco + birevufe), (float)(iyubipat + azudovin));
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _williams(float rangers, float cheese, float novels, float essay, boolean machine, int elect) {
      _putting((int)rangers, (int)cheese, (double)novels, 10, (float)essay, 360, (boolean)machine, (int)elect);
   }

   public static void _putting(int ovopobuc, int borapure, double yomegezu, int torepude, float yidutune, int lagovera, boolean obuboyof, int gaminezu) {
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      yomegezu = yomegezu * 2.0D;
      ovopobuc = ovopobuc * 2;
      borapure = borapure * 2;
      Object pizumepo = (float)(gaminezu >> 24 & 255) / 255.0F;
      Object ucozepuy = (float)(gaminezu >> 16 & 255) / 255.0F;
      Object oyeravif = (float)(gaminezu >> 8 & 255) / 255.0F;
      Object utepepec = (float)(gaminezu & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glLineWidth((float)yidutune);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(ucozepuy, oyeravif, utepepec, pizumepo);
      GL11.glBegin(3);

      for(Object arapoyen = torepude - lagovera; arapoyen <= torepude; ++arapoyen) {
         Object egegimul = Math.sin((double)arapoyen * 3.141592653589793D / 180.0D) * yomegezu;
         double var16 = Math.cos((double)arapoyen * 3.141592653589793D / 180.0D) * yomegezu;
         GL11.glVertex2d((double)ovopobuc + egegimul, (double)borapure + var16);
         if (obuboyof) {
            GL11.glVertex2d((double)ovopobuc, (double)borapure);
         }
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
   }

   public static void _failure(float universe, float capitol, double wanna, int unlike, int stayed, float voltage, int quality, boolean newly, boolean visit) {
      if (unlike > 0) {
         GL11.glScalef(0.5F, 0.5F, 0.5F);
         wanna = wanna * 2.0D;
         universe = universe * 2.0F;
         capitol = capitol * 2.0F;
         Object booth = (float)(quality >> 24 & 255) / 255.0F;
         Object contains = (float)(quality >> 16 & 255) / 255.0F;
         Object official = (float)(quality >> 8 & 255) / 255.0F;
         Object medical = (float)(quality & 255) / 255.0F;
         GL11.glEnable(3042);
         GlStateManager.enableAlpha();
         GL11.glLineWidth((float)voltage);
         GL11.glDisable(3553);
         GL11.glEnable(2848);
         GL11.glBlendFunc(770, 771);
         GL11.glColor4f(contains, official, medical, booth);
         GL11.glBegin(3);

         for(Object pound = (int)stayed; pound <= unlike + stayed; ++pound) {
            Object jordan = Math.sin((double)pound * 3.141592653589793D / 180.0D) * wanna;
            double var17 = Math.cos((double)pound * 3.141592653589793D / 180.0D) * wanna;
            GL11.glVertex2d((double)universe + jordan, (double)capitol + var17);
            if (newly) {
               GL11.glVertex2d((double)universe, (double)capitol);
            }
         }

         if (visit && !newly && unlike < 360) {
            Object var22 = Math.sin((double)stayed * 3.141592653589793D / 180.0D) * wanna;
            Object hanging = Math.cos((double)stayed * 3.141592653589793D / 180.0D) * wanna;
            GL11.glVertex2d((double)universe, (double)capitol);
            GL11.glVertex2d((double)universe + var22, (double)capitol + hanging);
         }

         GL11.glEnd();
         GL11.glDisable(2848);
         GL11.glEnable(3553);
         GL11.glDisable(3042);
         GL11.glScalef(2.0F, 2.0F, 2.0F);
      }
   }

   public static void _quantity(double young, double debug, double reaching, double adelaide, int horses) {
      if (young < reaching) {
         Object newest = (double)young;
         young = reaching;
         reaching = newest;
      }

      if (debug < adelaide) {
         Object var15 = (double)debug;
         debug = adelaide;
         adelaide = var15;
      }

      Object var16 = (float)(horses >> 24 & 255) / 255.0F;
      Object players = (float)(horses >> 16 & 255) / 255.0F;
      float var11 = (float)(horses >> 8 & 255) / 255.0F;
      float var12 = (float)(horses & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(players, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)young, (double)adelaide, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)reaching, (double)adelaide, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)reaching, (double)debug, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)young, (double)debug, Double.longBitsToDouble(0L)).endVertex();
      var13.draw();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _festival(float uzamozaz, float duvireyu, float eduniyud, float igufuzep, float ganeyiba, int tunasocu, boolean efovumas) {
      _failure((float)uzamozaz, duvireyu + igufuzep / 2.0F, (double)(igufuzep / 2.0F), 180, 180, (float)ganeyiba, (int)tunasocu, (boolean)efovumas, false);
      if (efovumas) {
         _therapy((float)uzamozaz, (float)duvireyu, (float)eduniyud, (float)igufuzep, (int)tunasocu);
      } else {
         _township((float)uzamozaz, (float)duvireyu, (float)(uzamozaz + eduniyud), (float)duvireyu, (float)ganeyiba, (int)tunasocu);
         _township((float)uzamozaz, (float)(duvireyu + igufuzep), (float)(uzamozaz + eduniyud), (float)(duvireyu + igufuzep), (float)ganeyiba, (int)tunasocu);
      }

      _failure((float)(uzamozaz + eduniyud), duvireyu + igufuzep / 2.0F, (double)(igufuzep / 2.0F), 180, 0, (float)ganeyiba, (int)tunasocu, (boolean)efovumas, false);
   }

   public static void _please(float americas, float organ, float taxation, float arrived, float outline, int register) {
      _failure(americas + outline + 0.5F, organ + outline + 0.5F, (double)outline, 90, 180, 1.0F, (int)register, true, false);
      _actually(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0);
      _failure(americas + taxation - outline - 0.5F, organ + outline + 0.5F, (double)outline, 90, 90, 1.0F, (int)register, true, false);
      _actually(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0);
      _failure(americas + outline + 0.5F, organ + arrived - outline - 0.5F, (double)outline, 90, 270, 1.0F, (int)register, true, false);
      _actually(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0);
      _failure(americas + taxation - outline - 0.5F, organ + arrived - outline - 0.5F, (double)outline, 90, 360, 1.0F, (int)register, true, false);
      _actually(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 0);
      _actually((double)(americas + outline), (double)organ, (double)(americas + outline + taxation - 2.0F * outline), (double)(organ + arrived), (int)register);
      _actually((double)americas, (double)(organ + outline), (double)(americas + outline), (double)(organ + arrived - outline), (int)register);
      _actually((double)(americas + taxation - outline), (double)(organ + outline), (double)(americas + taxation), (double)(organ + arrived - outline), (int)register);
   }

   public static void _therapy(float evaluate, float outlook, float denver, float advisors, int wings) {
      Gui.drawRect((int)evaluate, (int)outlook, (int)(denver + evaluate), (int)(advisors + outlook), (int)wings);
   }

   public static void _actually(double izodovem, double vavipome, double obevepat, double var6, int var8) {
      Gui.drawRect((int)izodovem, (int)vavipome, (int)obevepat, (int)var6, var8);
   }

   public static void _headers(float isesefav, float efibizot, float esamebup, float bocanori, float gupufani, int umotasuf) {
      Object selopiva = (float)(umotasuf >> 24 & 255) / 255.0F;
      Object decinefi = (float)(umotasuf >> 16 & 255) / 255.0F;
      Object rolorafa = (float)(umotasuf >> 8 & 255) / 255.0F;
      Object fafumeyi = (float)(umotasuf & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(decinefi, rolorafa, fafumeyi, selopiva);
      GL11.glLineWidth((float)gupufani);
      GL11.glBegin(1);
      GL11.glVertex2f((float)isesefav, (float)efibizot);
      GL11.glVertex2f((float)(isesefav + esamebup), (float)efibizot);
      GL11.glVertex2f((float)(isesefav + esamebup), (float)(efibizot + bocanori));
      GL11.glVertex2f((float)isesefav, (float)(efibizot + bocanori));
      GL11.glVertex2f((float)isesefav, (float)efibizot);
      GL11.glVertex2f((float)isesefav, (float)(efibizot + bocanori));
      GL11.glVertex2f((float)(isesefav + esamebup), (float)efibizot);
      GL11.glVertex2f((float)(isesefav + esamebup), (float)(efibizot + bocanori));
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static void _carnival(float uyeroseb, float yeralimi, float atovulon, float tiriduse, float fuyopufo, int atipilaf, int gobinotu) {
      Gui.drawRect((int)uyeroseb, (int)yeralimi, (int)atovulon, (int)tiriduse, (int)gobinotu);
      Object zuzozeca = (float)(atipilaf >> 24 & 255) / 255.0F;
      Object eyifopag = (float)(atipilaf >> 16 & 255) / 255.0F;
      Object inizetom = (float)(atipilaf >> 8 & 255) / 255.0F;
      Object olimupiz = (float)(atipilaf & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(eyifopag, inizetom, olimupiz, zuzozeca);
      GL11.glLineWidth((float)fuyopufo);
      GL11.glBegin(1);
      GL11.glVertex2d((double)uyeroseb, (double)yeralimi);
      GL11.glVertex2d((double)uyeroseb, (double)tiriduse);
      GL11.glVertex2d((double)atovulon, (double)tiriduse);
      GL11.glVertex2d((double)atovulon, (double)yeralimi);
      GL11.glVertex2d((double)uyeroseb - (double)fuyopufo, (double)yeralimi);
      GL11.glVertex2d((double)atovulon + (double)fuyopufo, (double)yeralimi);
      GL11.glVertex2d((double)uyeroseb, (double)tiriduse);
      GL11.glVertex2d((double)atovulon, (double)tiriduse);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static int _bahrain() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth();
   }

   public static int _tiles() {
      return (new ScaledResolution(Minecraft.getMinecraft())).getScaledHeight();
   }

   public static double _values(double rejected, double var2) {
      return var2 + (rejected - var2) * (double) Helper._pillow().renderPartialTicks;
   }

   public static double _focal(double existed, double var2) {
      return var2 + (existed - var2) * (double) Helper._pillow().renderPartialTicks;
   }

   public static void _startup() {
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glColor3d(1.0D, 1.0D, 1.0D);
   }

   public static void _slide() {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glHint(3154, 4354);
   }

   public static void _devon() {
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _mailed() {
      GL11.glEnable(3042);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
   }

   public static void _matter() {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glHint(3154, 4354);
   }

   public static void _minister() {
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _overall() {
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static Color _refugees(Color fenebube, Color enenecof, double guvufepe) {
      Object dupevugu = (float)guvufepe;
      Object donibule = 1.0F - dupevugu;
      Object idopivag = new float[3];
      Object dabupevu = new float[3];
      ((Color)fenebube).getColorComponents(idopivag);
      ((Color)enenecof).getColorComponents(dabupevu);
      Color var8 = new Color(idopivag[0] * dupevugu + dabupevu[0] * donibule, idopivag[1] * dupevugu + dabupevu[1] * donibule, idopivag[2] * dupevugu + dabupevu[2] * donibule);
      return var8;
   }

   public static void _timer(Vec2f etizunop, Vec2f pobenusu, float esudugat) {
      _polymer(((Vec2f)etizunop)._until(), ((Vec2f)etizunop)._trends(), ((Vec2f)pobenusu)._until(), ((Vec2f)pobenusu)._trends(), (float)esudugat);
   }

   public static void _grows(Vec3f cidavuye, Vec3f gapiferu, float oyanenoy) {
      _mirror((float)((Vec3f)cidavuye)._lawrence(), (float)((Vec3f)cidavuye)._pursue(), (float)((Vec3f)cidavuye)._paypal(), (float)((Vec3f)gapiferu)._lawrence(), (float)((Vec3f)gapiferu)._pursue(), (float)((Vec3f)gapiferu)._paypal(), (float)oyanenoy);
   }

   public static void _polymer(float inform, float claimed, float gazette, float concepts, float mcdonald) {
      _mirror((float)inform, (float)claimed, Float.intBitsToFloat(0), (float)gazette, (float)concepts, Float.intBitsToFloat(0), (float)mcdonald);
   }

   public static void _township(float platform, float cocktail, float craps, float showers, float bread, int released) {
      GL11.glPushMatrix();
      GL11.glLineWidth((float)bread);
      Object stewart = (float)(released >> 24 & 255) / 255.0F;
      Object firefox = (float)(released >> 16 & 255) / 255.0F;
      Object fairly = (float)(released >> 8 & 255) / 255.0F;
      Object watts = (float)(released & 255) / 255.0F;
      GL11.glColor4f(firefox, fairly, watts, stewart);
      _referred(true);
      _broader(GLClientState.portal$, true);
      window$.addVertex((float)platform, (float)cocktail, Float.intBitsToFloat(0)).addVertex((float)craps, (float)showers, Float.intBitsToFloat(0)).draw(3);
      _broader(GLClientState.portal$, false);
      _referred(false);
      GL11.glPopMatrix();
   }

   public static void _mirror(float grant, float thinkpad, float inside, float replaced, float homepage, float cache, float laser) {
      GL11.glLineWidth((float)laser);
      _referred(true);
      _broader(GLClientState.portal$, true);
      window$.addVertex((float)grant, (float)thinkpad, (float)inside).addVertex((float)replaced, (float)homepage, (float)cache).draw(3);
      _broader(GLClientState.portal$, false);
      _referred(false);
   }

   public static void _jennifer(float leaving, float states, float gilbert, float satisfy, float yacht, float above, float leather, int there) {
      GL11.glPushMatrix();
      GL11.glLineWidth((float)leather);
      Object smoking = (float)(there >> 24 & 255) / 255.0F;
      Object tenant = (float)(there >> 16 & 255) / 255.0F;
      Object threaded = (float)(there >> 8 & 255) / 255.0F;
      Object shock = (float)(there & 255) / 255.0F;
      GL11.glColor4f(tenant, threaded, shock, smoking);
      _referred(true);
      _broader(GLClientState.portal$, true);
      window$.addVertex((float)leaving, (float)states, (float)gilbert).addVertex((float)satisfy, (float)yacht, (float)above).draw(3);
      _broader(GLClientState.portal$, false);
      _referred(false);
      GL11.glPopMatrix();
   }

   public static void _broader(GLClientState frank, boolean treated) {
      theaters$.clear();
      if (((GLClientState)frank).ordinal() > 0) {
         theaters$.add(Integer.valueOf(((GLClientState)frank)._knights()));
      }

      theaters$.add(Integer.valueOf(32884));
      theaters$.forEach(treated ? lucia$ : positive$);
   }

   public static void _referred(boolean ezupelag) {
      if (ezupelag) {
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

      GlStateManager.depthMask(!ezupelag);
   }

   public static void _persian(double impaired, double textile, double collins, double potato, int alumni, int stupid) {
      Object guess = (float)(alumni >> 24 & 255) / 255.0F;
      Object compact = (float)(alumni >> 16 & 255) / 255.0F;
      Object arise = (float)(alumni >> 8 & 255) / 255.0F;
      Object paraguay = (float)(alumni & 255) / 255.0F;
      float var14 = (float)(stupid >> 24 & 255) / 255.0F;
      float var15 = (float)(stupid >> 16 & 255) / 255.0F;
      float var16 = (float)(stupid >> 8 & 255) / 255.0F;
      float var17 = (float)(stupid & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(compact, arise, paraguay, guess);
      GL11.glVertex2d((double)impaired, (double)textile);
      GL11.glVertex2d((double)impaired, (double)potato);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d((double)collins, (double)potato);
      GL11.glVertex2d((double)collins, (double)textile);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
   }

   public static net.minecraft.util.Vec3 _stands(EntityPlayer isayuzup) {
      Object yupenoba = Helper._pillow().renderPartialTicks;
      Object ocifenoc = ((EntityPlayer)isayuzup).lastTickPosX + (((EntityPlayer)isayuzup).posX - ((EntityPlayer)isayuzup).lastTickPosX) * (double)yupenoba;
      Object yilipiza = ((EntityPlayer)isayuzup).lastTickPosY + (((EntityPlayer)isayuzup).posY - ((EntityPlayer)isayuzup).lastTickPosY) * (double)yupenoba;
      double var6 = ((EntityPlayer)isayuzup).lastTickPosZ + (((EntityPlayer)isayuzup).posZ - ((EntityPlayer)isayuzup).lastTickPosZ) * (double)yupenoba;
      return new net.minecraft.util.Vec3(ocifenoc, yilipiza, var6);
   }

   public static void _america(double upozozon, double egagasur, double medopesa, double tebovepe, int norenobu) {
      if (upozozon < medopesa) {
         Object telopuro = (double)upozozon;
         upozozon = medopesa;
         medopesa = telopuro;
      }

      if (egagasur < tebovepe) {
         Object var17 = (double)egagasur;
         egagasur = tebovepe;
         tebovepe = var17;
      }

      Object ipacidit = (float)(norenobu >> 24 & 255) / 255.0F;
      float var12 = (float)(norenobu >> 16 & 255) / 255.0F;
      float var13 = (float)(norenobu >> 8 & 255) / 255.0F;
      float var14 = (float)(norenobu & 255) / 255.0F;
      Tessellator var15 = Tessellator.getInstance();
      WorldRenderer var16 = var15.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var12, var13, var14, ipacidit);
      var16.begin(7, DefaultVertexFormats.POSITION);
      var16.pos((double)upozozon, (double)tebovepe, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)medopesa, (double)tebovepe, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)medopesa, (double)egagasur, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)upozozon, (double)egagasur, Double.longBitsToDouble(0L)).endVertex();
      var15.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _treated(double decision, double newton, double think, double tourist, double var8, int var10, int var11) {
      _america(decision + var8, newton + var8, think - var8, tourist - var8, var10);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _america(decision + var8, (double)newton, think - var8, newton + var8, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _america((double)decision, (double)newton, decision + var8, (double)tourist, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _america(think - var8, (double)newton, (double)think, (double)tourist, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      _america(decision + var8, tourist - var8, think - var8, (double)tourist, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _potato(float enenocin, float sasubiso, float muteyide, int igapirap, int famazito) {
      GL11.glPushMatrix();
      enenocin = enenocin * 2.0F;
      sasubiso = sasubiso * 2.0F;
      Object pabeyati = (float)(famazito >> 24 & 255) / 255.0F;
      Object sabububo = (float)(famazito >> 16 & 255) / 255.0F;
      Object orogurig = (float)(famazito >> 8 & 255) / 255.0F;
      Object bicatifo = (float)(famazito & 255) / 255.0F;
      Object diruyelu = (float)(6.2831852D / (double)igapirap);
      Object eyebadam = (float)Math.cos((double)diruyelu);
      Object itecovim = (float)Math.sin((double)diruyelu);
      float var18;
      Object bisalobe = var18 = muteyide * 2.0F;
      Object ibofabif = Float.intBitsToFloat(0);
      _notified();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glColor4f(sabububo, orogurig, bicatifo, pabeyati);
      GL11.glBegin(2);

      for(Object cucorali = 0; cucorali < igapirap; ++cucorali) {
         GL11.glVertex2f(bisalobe + enenocin, ibofabif + sasubiso);
         Object mivumena = bisalobe;
         bisalobe = eyebadam * bisalobe - itecovim * ibofabif;
         ibofabif = itecovim * mivumena + eyebadam * ibofabif;
      }

      GL11.glEnd();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      _typical();
      GL11.glPopMatrix();
   }

   public static void _notified() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void _typical() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static double _adjusted(double disease, double assets, double var4) {
      return assets + (disease - assets) * var4;
   }

   public static void _wilson(double isafoniy, double izotufat, double loyozune, double fasitide, float oloyazon, int ugevegop, int balomape) {
      _actually((double)isafoniy, (double)izotufat, (double)loyozune, (double)fasitide, (int)balomape);
      float var11 = (float)(ugevegop >> 24 & 255) / 255.0F;
      float var12 = (float)(ugevegop >> 16 & 255) / 255.0F;
      float var13 = (float)(ugevegop >> 8 & 255) / 255.0F;
      float var14 = (float)(ugevegop & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var12, var13, var14, var11);
      GL11.glLineWidth((float)oloyazon);
      GL11.glBegin(1);
      GL11.glVertex2d((double)isafoniy, (double)izotufat);
      GL11.glVertex2d((double)isafoniy, (double)fasitide);
      GL11.glVertex2d((double)loyozune, (double)fasitide);
      GL11.glVertex2d((double)loyozune, (double)izotufat);
      GL11.glVertex2d((double)isafoniy, (double)izotufat);
      GL11.glVertex2d((double)loyozune, (double)izotufat);
      GL11.glVertex2d((double)isafoniy, (double)fasitide);
      GL11.glVertex2d((double)loyozune, (double)fasitide);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static float[] _having(EntityLivingBase auckland, float webshots) {
      Object tower = (KillAura)ModuleManager._herbs(KillAura.class);
      Object billion = (Camera)ModuleManager._herbs(Camera.class);
      Object summary = _benefit(((EntityLivingBase)auckland).prevRenderYawOffset, ((EntityLivingBase)auckland).renderYawOffset, (float)webshots);
      Object tribunal = _benefit(((EntityLivingBase)auckland).prevRotationYawHead, ((EntityLivingBase)auckland).rotationYawHead, (float)webshots);
      float var10000 = ((EntityLivingBase)auckland).prevRotationPitch + (((EntityLivingBase)auckland).rotationPitch - ((EntityLivingBase)auckland).prevRotationPitch) * webshots;
      float var7 = tribunal - summary;
      float var6 = _benefit(EventPreUpdate.pitch2, EventPreUpdate.pitch, (float)webshots);
      if (!Objects.equals(Camera.makes$.getValue(), "Head")) {
         summary = _benefit(Client.thumbs$, Client.garage$, (float)webshots);
      }

      if (Objects.equals(Camera.makes$.getValue(), "Zenith")) {
         summary -= var7 + Camera.targeted$.getValue().floatValue();
      }

      tribunal = _benefit(Client.thumbs$, Client.garage$, (float)webshots);
      return new float[]{summary, tribunal, var6};
   }

   public static float[] _purchase(EntityLivingBase iyomevog, float onenugep) {
      Object tisubuvo = (KillAura) ModuleManager._herbs(KillAura.class);
      Object daniyopo = (Camera)ModuleManager._herbs(Camera.class);
      Object agodamay = _benefit(((EntityLivingBase)iyomevog).prevRenderYawOffset, ((EntityLivingBase)iyomevog).renderYawOffset, (float)onenugep);
      Object yesolito = _benefit(((EntityLivingBase)iyomevog).prevRotationYawHead, ((EntityLivingBase)iyomevog).rotationYawHead, (float)onenugep);
      float var10000 = ((EntityLivingBase)iyomevog).prevRotationPitch + (((EntityLivingBase)iyomevog).rotationPitch - ((EntityLivingBase)iyomevog).prevRotationPitch) * onenugep;
      float var7 = yesolito - agodamay;
      Object lazenado = _benefit(EventPreUpdate.pitch2, EventPreUpdate.pitch, (float)onenugep);
      if (!Objects.equals(Camera.makes$.getValue(), "Head")) {
         agodamay = _benefit(Client.thumbs$, Client.garage$, (float)onenugep);
      }

      float var8 = var7 + 50.0F;
      if (Objects.equals(Camera.makes$.getValue(), "Zenith")) {
         agodamay -= var8;
      }

      yesolito = _benefit(Client.thumbs$, Client.garage$, (float)onenugep);
      return new float[]{agodamay, yesolito, lazenado};
   }

   public static float[] _eleven(EntityLivingBase mamebone, float nabacota) {
      Object ucifeyig = (KillAura)ModuleManager._herbs(KillAura.class);
      Object lilonula = (Camera)ModuleManager._herbs(Camera.class);
      Object liligage = _benefit(((EntityLivingBase)mamebone).prevRenderYawOffset, ((EntityLivingBase)mamebone).renderYawOffset, (float)nabacota);
      Object vorifofi = _benefit(((EntityLivingBase)mamebone).prevRotationYawHead, ((EntityLivingBase)mamebone).rotationYawHead, (float)nabacota);
      float var10000 = ((EntityLivingBase)mamebone).prevRotationPitch + (((EntityLivingBase)mamebone).rotationPitch - ((EntityLivingBase)mamebone).prevRotationPitch) * nabacota;
      float var7 = vorifofi - liligage;
      Object iresudod = _benefit(EventPreUpdate.pitch2, EventPreUpdate.pitch, (float)nabacota);
      if (Objects.equals(Camera.makes$.getValue(), "Astolfo")) {
         if (KillAura._count(KillAura.lesbians$, 100.0F)) {
            liligage = _benefit(Client.thumbs$, Client.garage$, (float)nabacota);
         }
      } else if (!Objects.equals(Camera.makes$.getValue(), "Head")) {
         liligage = _benefit(Client.thumbs$, Client.garage$, (float)nabacota);
      }

      float var8 = MovementUtils._bumper() ? var7 + Camera.targeted$.getValue().floatValue() : var7;
      if (Objects.equals(Camera.makes$.getValue(), "Zenith")) {
         liligage -= var8;
      }

      vorifofi = _benefit(Client.thumbs$, Client.garage$, (float)nabacota);
      return new float[]{liligage, vorifofi, iresudod};
   }

   public static float _benefit(float enisuval, float baroyigu, float buroluga) {
      float ayufudel;
      for(ayufudel = (float)(baroyigu - enisuval); ayufudel < -180.0F; ayufudel += 360.0F) {
         ;
      }

      while(ayufudel >= 180.0F) {
         ayufudel -= 360.0F;
      }

      return enisuval + buroluga * ayufudel;
   }

   public static void _survive(int distance, int andrew, int phpbb, float exhaust, float villages, EntityLivingBase harvest) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)distance, (float)andrew, 40.0F);
      GlStateManager.scale((float)(-phpbb), (float)phpbb, (float)phpbb);
      GlStateManager.rotate(180.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      Object flyer = ((EntityLivingBase)harvest).renderYawOffset;
      Object pipes = ((EntityLivingBase)harvest).rotationYaw;
      Object sticky = ((EntityLivingBase)harvest).rotationPitch;
      Object toolkit = ((EntityLivingBase)harvest).prevRotationYawHead;
      Object superior = ((EntityLivingBase)harvest).rotationYawHead;
      GlStateManager.rotate(135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.rotate(-((float)Math.atan((double)(villages / 40.0F))) * 20.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      ((EntityLivingBase)harvest).renderYawOffset = (float)Math.atan((double)(exhaust / 40.0F)) * -14.0F;
      ((EntityLivingBase)harvest).rotationYaw = (float)Math.atan((double)(exhaust / 40.0F)) * -14.0F;
      ((EntityLivingBase)harvest).rotationPitch = -((float)Math.atan((double)(villages / 40.0F))) * 15.0F;
      ((EntityLivingBase)harvest).rotationYawHead = ((EntityLivingBase)harvest).rotationYaw;
      ((EntityLivingBase)harvest).prevRotationYawHead = ((EntityLivingBase)harvest).rotationYaw;
      GlStateManager.translate(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object capture = Minecraft.getMinecraft().getRenderManager();
      capture.setPlayerViewY(180.0F);
      capture.setRenderShadow(false);
      capture.renderEntityWithPosYaw((Entity)harvest, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Float.intBitsToFloat(0), 1.0F);
      capture.setRenderShadow(true);
      ((EntityLivingBase)harvest).renderYawOffset = flyer;
      ((EntityLivingBase)harvest).rotationYaw = pipes;
      ((EntityLivingBase)harvest).rotationPitch = sticky;
      ((EntityLivingBase)harvest).prevRotationYawHead = toolkit;
      ((EntityLivingBase)harvest).rotationYawHead = superior;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static void _looking(int adware, int editor, int donated, int oklahoma) {
      Object conduct = Minecraft.getMinecraft();
      Object media = 1;
      Object depends = conduct.gameSettings.guiScale;
      if (depends == 0) {
         depends = 1000;
      }

      while(media < depends && conduct.displayWidth / (media + 1) >= 320 && conduct.displayHeight / (media + 1) >= 240) {
         ++media;
      }

      GL11.glScissor(adware * media, conduct.displayHeight - (editor + oklahoma) * media, donated * media, oklahoma * media);
   }

   public static void _stamps(float izofafol, float zipupuni, float inisuciv, float pefireto, float upinatal, int lofusinu) {
      izofafol = izofafol + (float)((double)(upinatal / 2.0F) + 0.5D);
      zipupuni = zipupuni + (float)((double)(upinatal / 2.0F) + 0.5D);
      inisuciv = inisuciv - (float)((double)(upinatal / 2.0F) + 0.5D);
      pefireto = pefireto - (float)((double)(upinatal / 2.0F) + 0.5D);
      Gui.drawRect((int)izofafol, (int)zipupuni, (int)inisuciv, (int)pefireto, (int)lofusinu);
      _andrews(inisuciv - upinatal / 2.0F, zipupuni + upinatal / 2.0F, (float)upinatal, (int)lofusinu);
      _andrews(izofafol + upinatal / 2.0F, pefireto - upinatal / 2.0F, (float)upinatal, (int)lofusinu);
      _andrews(izofafol + upinatal / 2.0F, zipupuni + upinatal / 2.0F, (float)upinatal, (int)lofusinu);
      _andrews(inisuciv - upinatal / 2.0F, pefireto - upinatal / 2.0F, (float)upinatal, (int)lofusinu);
      Gui.drawRect((int)(izofafol - upinatal / 2.0F - 0.5F), (int)(zipupuni + upinatal / 2.0F), (int)inisuciv, (int)(pefireto - upinatal / 2.0F), (int)lofusinu);
      Gui.drawRect((int)izofafol, (int)(zipupuni + upinatal / 2.0F), (int)(inisuciv + upinatal / 2.0F + 0.5F), (int)(pefireto - upinatal / 2.0F), (int)lofusinu);
      Gui.drawRect((int)(izofafol + upinatal / 2.0F), (int)(zipupuni - upinatal / 2.0F - 0.5F), (int)(inisuciv - upinatal / 2.0F), (int)(pefireto - upinatal / 2.0F), (int)lofusinu);
      Gui.drawRect((int)(izofafol + upinatal / 2.0F), (int)zipupuni, (int)(inisuciv - upinatal / 2.0F), (int)(pefireto + upinatal / 2.0F + 0.5F), (int)lofusinu);
   }

   public static void _andrews(float unezeluy, float zenemofi, float purasara, int efayofar) {
      _argued((float)unezeluy, (float)zenemofi, Float.intBitsToFloat(0), 360.0F, (float)purasara, (int)efayofar);
   }

   public static void _argued(float ocuyayes, float umemadan, float nimonono, float ecotulas, float aladageb, int zafiliti) {
      _portland((float)ocuyayes, (float)umemadan, (float)nimonono, (float)ecotulas, (float)aladageb, (float)aladageb, (int)zafiliti);
   }

   public static void _portland(float gesibima, float iricetot, float fofigugu, float fayenafi, float puvefaze, float furegozu, int uvidetoy) {
      GlStateManager.color(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glColor4f(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object capuparo = Float.intBitsToFloat(0);
      if (fofigugu > fayenafi) {
         capuparo = (float)fayenafi;
         fayenafi = fofigugu;
         fofigugu = capuparo;
      }

      Object felucaro = (float)(uvidetoy >> 24 & 255) / 255.0F;
      Object omelolec = (float)(uvidetoy >> 16 & 255) / 255.0F;
      Object doduzezu = (float)(uvidetoy >> 8 & 255) / 255.0F;
      Object unucapem = (float)(uvidetoy & 255) / 255.0F;
      Object ofesupag = Tessellator.getInstance();
      Object adoyafiy = ofesupag.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(omelolec, doduzezu, unucapem, felucaro);
      if (felucaro > 0.5F) {
         GL11.glEnable(2848);
         GL11.glLineWidth(2.0F);
         GL11.glBegin(3);

         for(Object ufofayob = (float)fayenafi; ufofayob >= fofigugu; ufofayob -= 4.0F) {
            Object copimona = (float)Math.cos((double)ufofayob * 3.141592653589793D / 180.0D) * puvefaze * 1.001F;
            float var16 = (float)Math.sin((double)ufofayob * 3.141592653589793D / 180.0D) * furegozu * 1.001F;
            GL11.glVertex2f(gesibima + copimona, iricetot + var16);
         }

         GL11.glEnd();
         GL11.glDisable(2848);
      }

      GL11.glBegin(6);

      for(Object var18 = (float)fayenafi; var18 >= fofigugu; var18 -= 4.0F) {
         Object var19 = (float)Math.cos((double)var18 * 3.141592653589793D / 180.0D) * puvefaze;
         float var20 = (float)Math.sin((double)var18 * 3.141592653589793D / 180.0D) * furegozu;
         GL11.glVertex2f(gesibima + var19, iricetot + var20);
      }

      GL11.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _price(int yesirepe, int ezozamiv, int mizosari, int unuzufev) {
      Object tocicami = (new ScaledResolution(myself$)).getScaleFactor();
      GL11.glPushMatrix();
      GL11.glEnable(3089);
      GL11.glScissor(yesirepe * tocicami, myself$.displayHeight - (ezozamiv + unuzufev) * tocicami, mizosari * tocicami, unuzufev * tocicami);
   }

   public static void _advanced() {
      GL11.glDisable(3089);
      GL11.glPopMatrix();
   }

   public static void _daniel(double desktop, double golden, double suitable, double england, double var8, int var10, int var11) {
      _actually(desktop + var8, golden + var8, suitable - var8, england - var8, var10);
      _actually(desktop + var8, (double)golden, suitable - var8, golden + var8, var11);
      _actually((double)desktop, (double)golden, desktop + var8, (double)england, var11);
      _actually(suitable - var8, (double)golden, (double)suitable, (double)england, var11);
      _actually(desktop + var8, england - var8, suitable - var8, (double)england, var11);
   }

   public static void _border(String nasutulu, int uposisiv, int tivupela, int useyeday, int ilezemav) {
      for(Object aneperil : Minecraft.getMinecraft().theWorld.getLoadedEntityList()) {
         if (aneperil instanceof EntityPlayer) {
            Object ozefumop = (EntityPlayer)aneperil;
            if (((String)nasutulu).equalsIgnoreCase(ozefumop.getName())) {
               Object ifayudav = new GameProfile(ozefumop.getUniqueID(), ozefumop.getName());
               Object dunuyidu = new NetworkPlayerInfo(ifayudav);
               new ScaledResolution(Minecraft.getMinecraft());
               GL11.glDisable(2929);
               GL11.glEnable(3042);
               GL11.glDepthMask(false);
               OpenGlHelper.glBlendFunc(770, 771, 1, 0);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               Minecraft.getMinecraft().getTextureManager().bindTexture(dunuyidu.getLocationSkin());
               Gui.drawModalRectWithCustomSizedTexture((int)uposisiv, (int)tivupela, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)useyeday, (int)ilezemav, (float)useyeday, (float)ilezemav);
               GL11.glDepthMask(true);
               GL11.glDisable(3042);
               GL11.glEnable(2929);
            }
         }
      }

   }

   public static void _citizen(ResourceLocation freedom, int analyze, int paradise, int buying, int pressed) {
      _kitchen((ResourceLocation)freedom, (int)analyze, (int)paradise, (int)buying, (int)pressed, 1.0F);
   }

   public static void _kitchen(ResourceLocation fifty, int ireland, int compared, int brutal, int actively, float trick) {
      new ScaledResolution(Minecraft.getMinecraft());
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, (float)trick);
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)fifty);
      Gui.drawModalRectWithCustomSizedTexture((int)ireland, (int)compared, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)brutal, (int)actively, (float)brutal, (float)actively);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _general(AxisAlignedBB magigogi) {
      Object azerucib = Tessellator.getInstance();
      Object adifefug = azerucib.getWorldRenderer();
      adifefug.begin(7, DefaultVertexFormats.POSITION);
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      azerucib.draw();
      adifefug.begin(7, DefaultVertexFormats.POSITION);
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      azerucib.draw();
      adifefug.begin(7, DefaultVertexFormats.POSITION);
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      azerucib.draw();
      adifefug.begin(7, DefaultVertexFormats.POSITION);
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      azerucib.draw();
      adifefug.begin(7, DefaultVertexFormats.POSITION);
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      azerucib.draw();
      adifefug.begin(7, DefaultVertexFormats.POSITION);
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).minX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).minZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).maxY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      adifefug.pos(((AxisAlignedBB)magigogi).maxX, ((AxisAlignedBB)magigogi).minY, ((AxisAlignedBB)magigogi).maxZ).endVertex();
      azerucib.draw();
   }

   public static Color _reporter(Color pabicaci, int ubolizad) {
      Object orinanum = ((Color)pabicaci).getRed();
      Object duniyupu = ((Color)pabicaci).getGreen();
      Object rizamelu = ((Color)pabicaci).getBlue();
      orinanum = orinanum - ubolizad;
      duniyupu = duniyupu - ubolizad;
      rizamelu = rizamelu - ubolizad;
      if (orinanum < 0) {
         orinanum = 0;
      }

      if (duniyupu < 0) {
         duniyupu = 0;
      }

      if (rizamelu < 0) {
         rizamelu = 0;
      }

      return new Color(orinanum, duniyupu, rizamelu);
   }

   public static void _iraqi(ScaledResolution cottages, float airport, float engaged, float emerald, float worthy) {
      Object regarded = (float)(airport + emerald);
      Object acute = (float)(engaged + worthy);
      Object photos = ((ScaledResolution)cottages).getScaleFactor();
      GL11.glScissor((int)(airport * (float)photos), (int)(((float)((ScaledResolution)cottages).getScaledHeight() - acute) * (float)photos), (int)((regarded - airport) * (float)photos), (int)((acute - engaged) * (float)photos));
   }

   public static void _abroad(float butenufo, float uluyaluc, float macebifa, float gizufobe) {
      Object obefefaf = new ScaledResolution(myself$);
      Object zoruvufi = obefefaf.getScaleFactor();
      GL11.glScissor((int)(butenufo * (float)zoruvufi), (int)(((float)obefefaf.getScaledHeight() - gizufobe) * (float)zoruvufi), (int)((macebifa - butenufo) * (float)zoruvufi), (int)((gizufobe - uluyaluc) * (float)zoruvufi));
   }

   public static void _relates(int emirepav, int peroveto, float bunecofa, float zazidege, int riyuyane, int onanuvor, int ibipogaz, int gurazule, float efutuyag, float suluyame) {
      Gui.drawScaledCustomSizeModalRect((int)emirepav, (int)peroveto, (float)bunecofa, (float)zazidege, (int)riyuyane, (int)onanuvor, (int)ibipogaz, (int)gurazule, (float)efutuyag, (float)suluyame);
   }

   public static void _speed(float stylish, float zoloft, int janet, int style, ResourceLocation three) {
      GL11.glPushMatrix();
      Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation)three);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GlStateManager.enableRescaleNormal();
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      GL11.glTranslatef((float)stylish, (float)zoloft, Float.intBitsToFloat(0));
      _relates(0, 0, Float.intBitsToFloat(0), Float.intBitsToFloat(0), (int)janet, (int)style, (int)janet, (int)style, (float)janet, (float)style);
      GlStateManager.disableAlpha();
      GlStateManager.disableRescaleNormal();
      GlStateManager.disableLighting();
      GlStateManager.disableRescaleNormal();
      GL11.glDisable(2848);
      GlStateManager.disableBlend();
      GL11.glPopMatrix();
   }

   public static double _danny(double planes, double movement, double var4) {
      float var6 = (float)(0.01D * var4);
      if (planes < movement) {
         if (planes + (double)var6 < movement) {
            planes = planes + (double)var6;
         } else {
            planes = movement;
         }
      } else if (planes - (double)var6 > movement) {
         planes = planes - (double)var6;
      } else {
         planes = movement;
      }

      return (double)planes;
   }

   public static void _letting(double odocetun, double emugudit, double ofopicid, double gezutolu, int irapumag, int aguyagiy) {
      Object buyenede = (float)(irapumag >> 24 & 255) / 255.0F;
      Object avorodof = (float)(irapumag >> 16 & 255) / 255.0F;
      Object luvuruli = (float)(irapumag >> 8 & 255) / 255.0F;
      Object obudoyep = (float)(irapumag & 255) / 255.0F;
      float var14 = (float)(aguyagiy >> 24 & 255) / 255.0F;
      float var15 = (float)(aguyagiy >> 16 & 255) / 255.0F;
      float var16 = (float)(aguyagiy >> 8 & 255) / 255.0F;
      float var17 = (float)(aguyagiy & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(avorodof, luvuruli, obudoyep, buyenede);
      GL11.glVertex2d((double)odocetun, (double)gezutolu);
      GL11.glVertex2d((double)ofopicid, (double)gezutolu);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d((double)ofopicid, (double)emugudit);
      GL11.glVertex2d((double)odocetun, (double)emugudit);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      Gui.drawRect(0, 0, 0, 0, 0);
   }

   public static float _roman(float weblog, float owners, float tracy) {
      // $FF: Couldn't be decompiled
   }

   public static double _statute(double umizicer, double buluyusa, double var4) {
      float var6 = (float)(0.01D * var4);
      if (umizicer < buluyusa) {
         if (umizicer + (double)var6 < buluyusa) {
            umizicer = umizicer + (double)var6;
         } else {
            umizicer = buluyusa;
         }
      } else if (umizicer - (double)var6 > buluyusa) {
         umizicer = umizicer - (double)var6;
      } else {
         umizicer = buluyusa;
      }

      return (double)umizicer;
   }

   public static void _promoted(double london, double concern, double flooring, double var6, double var8, int var10) {
      _perfume((double)london, (double)concern, (double)(flooring - london), var6 - concern, var8, var10);
   }

   public static void _perfume(double umutipul, double eyiyutas, double oyuyecec, double vatasezo, double ivuviyad, int dezutopa) {
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      Object unayacab = (double)(umutipul + oyuyecec);
      double var13 = (double)(eyiyutas + vatasezo);
      float var15 = (float)(dezutopa >> 24 & 255) / 255.0F;
      float var16 = (float)(dezutopa >> 16 & 255) / 255.0F;
      float var17 = (float)(dezutopa >> 8 & 255) / 255.0F;
      float var18 = (float)(dezutopa & 255) / 255.0F;
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      umutipul = umutipul * 2.0D;
      eyiyutas = eyiyutas * 2.0D;
      unayacab = unayacab * 2.0D;
      var13 = var13 * 2.0D;
      GL11.glDisable(3553);
      GL11.glColor4f(var16, var17, var18, var15);
      GL11.glEnable(2848);
      GL11.glBegin(9);

      for(int var19 = 0; var19 <= 90; var19 += 3) {
         GL11.glVertex2d(umutipul + ivuviyad + Math.sin((double)var19 * 3.141592653589793D / 180.0D) * ivuviyad * -1.0D, eyiyutas + ivuviyad + Math.cos((double)var19 * 3.141592653589793D / 180.0D) * ivuviyad * -1.0D);
      }

      for(int var24 = 90; var24 <= 180; var24 += 3) {
         GL11.glVertex2d(umutipul + ivuviyad + Math.sin((double)var24 * 3.141592653589793D / 180.0D) * ivuviyad * -1.0D, var13 - ivuviyad + Math.cos((double)var24 * 3.141592653589793D / 180.0D) * ivuviyad * -1.0D);
      }

      for(int var25 = 0; var25 <= 90; var25 += 3) {
         GL11.glVertex2d(unayacab - ivuviyad + Math.sin((double)var25 * 3.141592653589793D / 180.0D) * ivuviyad, var13 - ivuviyad + Math.cos((double)var25 * 3.141592653589793D / 180.0D) * ivuviyad);
      }

      for(int var26 = 90; var26 <= 180; var26 += 3) {
         GL11.glVertex2d(unayacab - ivuviyad + Math.sin((double)var26 * 3.141592653589793D / 180.0D) * ivuviyad, eyiyutas + ivuviyad + Math.cos((double)var26 * 3.141592653589793D / 180.0D) * ivuviyad);
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

   public static void _ideal(AxisAlignedBB ureyafil) {
      Object velutene = Tessellator.getInstance();
      Object yevizari = velutene.getWorldRenderer();
      yevizari.begin(3, DefaultVertexFormats.POSITION);
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      velutene.draw();
      yevizari.begin(3, DefaultVertexFormats.POSITION);
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      velutene.draw();
      yevizari.begin(1, DefaultVertexFormats.POSITION);
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).minZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).maxX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).minY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      yevizari.pos(((AxisAlignedBB)ureyafil).minX, ((AxisAlignedBB)ureyafil).maxY, ((AxisAlignedBB)ureyafil).maxZ).endVertex();
      velutene.draw();
   }

   public static void _flowers(int spectrum) {
      Object validity = (float)(spectrum >> 24 & 255) / 255.0F;
      Object relay = (float)(spectrum >> 16 & 255) / 255.0F;
      Object barbie = (float)(spectrum >> 8 & 255) / 255.0F;
      Object fabric = (float)(spectrum & 255) / 255.0F;
      GL11.glColor4f(relay, barbie, fabric, validity);
   }

   public static void _petition() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
